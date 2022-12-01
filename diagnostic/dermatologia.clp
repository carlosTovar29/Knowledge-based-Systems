(defrule r-acne
   (sintoma barros) (sintoma espinillas) (paciente ?paciente)
   =>
   (assert (sintoma acne))
   (printout t "Dermatologo -> " ?paciente ": Sufres de acne" crlf)
)

(defrule r-psoriasis
   (sintoma piel-escamosa) (sintoma manchas-rojas) (paciente ?paciente)
   =>
   (assert (sintoma psoriasis))
   (printout t "Dermatologo -> " ?paciente ": Sufres de psoriasis" crlf)
)

(defrule r-eccema
   (sintoma piel-enrojecida) (sintoma comezon) (paciente ?paciente)
   =>
   (assert (sintoma eccema))
   (printout t "Dermatologo -> " ?paciente ": Sufres de eccema" crlf)
)

(defrule r-urticaria
   (sintoma ronchas) (sintoma comezon) (paciente ?paciente)
   =>
   (assert (sintoma urticaria))
   (printout t "Dermatologo -> " ?paciente ": Sufres de urticaria" crlf)
)

(defrule r-cancel-piel
   (sintoma ulceras-piel) (sintoma lunares-sangrantes) (sintoma lesiones-marrones) (paciente ?paciente)
   =>
   (assert (sintoma cancel-piel))
   (printout t "Dermatologo -> " ?paciente ": Sufres de cancer de piel" crlf)
)
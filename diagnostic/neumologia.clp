(defrule r-resfriado
   (sintoma congestion-nasal) (sintoma estornudos) (sintoma tos) (paciente ?paciente)
   =>
   (assert (sintoma resfriado))
   (printout t "Neumologo -> " ?paciente ": Te diagnostico resfriado comun" crlf)
)

(defrule r-gripe
   (sintoma congestion-nasal) (sintoma fiebre) (sintoma fatiga) (paciente ?paciente)
   =>
   (assert (sintoma gripe))
   (printout t "Neumologo -> " ?paciente ": Te diagnostico gripe" crlf)
)

(defrule r-asma
   (sintoma falta-aire) (sintoma tos) (sintoma dolor-pecho) (paciente ?paciente)
   =>
   (assert (sintoma asma))
   (printout t "Neumologo -> " ?paciente ": Te diagnostico asma" crlf)
)

(defrule r-rinitis
   (sintoma congestion-nasal) (sintoma estornudos) (sintoma comezon-nasal) (paciente ?paciente)
   =>
   (assert (sintoma rinitis))
   (printout t "Neumologo -> " ?paciente ": Te diagnostico rinitis" crlf)
)

(defrule r-sinusitis
   (sintoma rinitis) (sintoma perdida-olfato) (sintoma fatiga) (paciente ?paciente)
   =>
   (assert (sintoma sinusitis))
   (printout t "Neumologo -> " ?paciente ": Te diagnostico sinusitis" crlf)
)
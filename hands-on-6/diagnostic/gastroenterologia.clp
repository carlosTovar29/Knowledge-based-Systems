(defrule r-gastroenteritis
   (sintoma nausea) (sintoma vomito) (sintoma diarrea) (paciente ?paciente)
   =>
   (assert (sintoma gastroenteritis))
   (printout t "Gastrointerologo -> " ?paciente ": Padeces de gastroenteritis" crlf)
)

(defrule r-reflujo
   (sintoma ardor-garganta) (sintoma dolor-pecho) (sintoma dificultad-tragar) (paciente ?paciente)
   =>
   (assert (sintoma reflujo))
   (printout t "Gastrointerologo -> " ?paciente ": Padeces de reflujo" crlf)
)

(defrule r-ulceras
   (sintoma dolor-estomacal) (sintoma nauseas) (sintoma reflujo) (paciente ?paciente)
   =>
   (assert (sintoma ulceras))
   (printout t "Gastrointerologo -> " ?paciente ": Padeces de ulceras" crlf)
)

(defrule r-colitis
   (sintoma dolor-estomacal) (sintoma fatiga) (sintoma diarrea) (paciente ?paciente)
   =>
   (assert (sintoma colitis))
   (printout t "Gastrointerologo -> " ?paciente ": Padeces de colitis" crlf)
)

(defrule r-infeccion-helicobacter-pylori
   (sintoma ulceras) (sintoma perdida-apetito) (paciente ?paciente)
   =>
   (assert (sintoma infeccion-helicobacter-pylori))
   (printout t "Gastrointerologo -> " ?paciente ": Padeces de una infección por Helicobacter Pylori" crlf)
)
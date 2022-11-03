(defrule gripe
   (sintoma tos) (sintoma fiebre) (sintoma moco)
   =>
   (assert (sintoma gripe))
   (printout t "Te diagnostico tiene gripe" crlf))

(defrule caries
(sintoma dolor-dientes) (sintoma puntos-negros-dentales)
=>
(printout t "Te diagnostico tiene caries" crlf))

(defrule gastritis
(sintoma dolor-estomago) (sintoma reflujo) (sintoma nauseas)
=>
(printout t "Te diagnostico tiene gastritis" crlf))

(defrule gripe-bacteria
(sintoma gripe) (sintoma moco-amarillo)
=>
(printout t "La gripe es producto de una bacteria" crlf))

(defrule gripe-hongo
   (sintoma gripe) (sintoma moco-verde)
   =>
  (printout t "La gripe es producto de un hongo" crlf))

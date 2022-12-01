
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import jade.core.*;
import jade.lang.acl.ACLMessage;

public class Paciente extends Agent {
    protected void setup() {
        List<String> todos_sintomas = new ArrayList<>(Arrays.asList("congestion-nasal", "estornudos", "tos", "fiebre", "fatiga", "falta-aire", "dolor-pecho", "comezon-nasal", "perdida-olfato", "nausea", "vomito", "diarrea", "ardor-garganta", "dificultad-tragar", "dolor-estomacal", "perdida-apetito", "barros", "espinillas", "piel-escamosa", "manchas-rojas", "piel-enrojecida", "comezon", "ronchas", "ulceras-piel", "lunares-sangrantes", "lesiones-marrones"));
        int size = todos_sintomas.size();

        String sintomas = "";
        Random rnd = new Random();
        for (int i = 0; i < size / 2; i++) {
            int it = rnd.nextInt(todos_sintomas.size());
            String sintoma = todos_sintomas.get(it);
            todos_sintomas.remove(it);
            sintomas += sintoma + " ";
        }

        System.out.println(getLocalName() + ": Me siento mal doctor, tengo " + sintomas);

        try {
            Thread.sleep(1000);
            addBehaviour(new ConsultarDoctor("Neumologo", sintomas));
            Thread.sleep(2000);
            addBehaviour(new ConsultarDoctor("Gastrointerologo", sintomas));
            Thread.sleep(2000);
            addBehaviour(new ConsultarDoctor("Dermatologo", sintomas));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    private class ConsultarDoctor extends OneShotBehaviour {
        String doctor_nombre;
        String sintomas;

        ConsultarDoctor(String doc_nombre, String sintomas) {
            this.doctor_nombre = doc_nombre;
            this.sintomas = sintomas;
        }

        public void action() {
            AID id = new AID();
            id.setLocalName(doctor_nombre);
            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);

            // Rellenar los campos necesarios del mensaje
            mensaje.setSender(getAID());
            mensaje.setLanguage("English");
            mensaje.addReceiver(id);
            
            // Envia el mensaje a los destinatarios
            mensaje.setContent(sintomas);
            send(mensaje);
        }
    }
}

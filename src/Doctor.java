
import jade.core.Agent;
import net.sf.clipsrules.jni.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;
import java.util.Arrays;
import java.util.List;

public class Doctor extends Agent {
    protected Environment clips;
    protected String clip_rules_file;
    protected String saludo;
    protected String mensaje_recibido;
    protected String despedida;

    @Override
    protected void setup() {
        clips = new Environment();

        addBehaviour(new Diagnosticar());

        System.out.println(getLocalName() + saludo);
    }

    private class Diagnosticar extends CyclicBehaviour {
        public void action() {
            try {
                // Obtiene el primer mensaje de la cola de mensajes
                ACLMessage mensaje = receive();

                if (mensaje != null) {
                    clips.clear();
                    clips.eval("(load \"" + clip_rules_file + "\")");
                    clips.reset();

                    String paciente_nombre = mensaje.getSender().getLocalName().toString();

                    System.out.println("\n" + getLocalName() + " -> " + paciente_nombre + mensaje_recibido);
                    clips.eval("(assert (paciente " + paciente_nombre + "))");

                    List<String> sintomas = Arrays.asList(mensaje.getContent().split("\\s+"));
                    for (String sintoma : sintomas) {
                        clips.eval("(assert (sintoma " + sintoma + "))");
                    }
                    clips.run();

                    System.out.println("\n" + getLocalName() + " -> " + paciente_nombre + despedida);

                    /*
                    List<FactInstance> facts = clips.getFactList();
                    facts.removeIf(fact -> (sintomas.contains("sintoma " + fact.getName())));

                    for (FactInstance fact : facts) {
                        System.out.println("\n" + getLocalName() + " -> " + mensaje.getSender().getLocalName().toString() + fact.getSlotValues().toArray().toString());
                    }
                    */
                }
            } catch (CLIPSException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
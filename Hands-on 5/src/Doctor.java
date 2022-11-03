import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import net.sf.clipsrules.jni.*;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder.Redirect;


public class Doctor extends Agent {

  private Environment clips;

  protected void setup() {
    clips = new Environment(); 
    addBehaviour(new ReceptorComportaminento());

    System.out.println(" ¿Qué síntomas tienes?");
}

private class ReceptorComportaminento extends CyclicBehaviour {
        private boolean fin = false;
   
        public void action() {
          try {
            

            clips.eval("(clear)");

            clips.eval("(load \"diagnostic/rules.clp\")");

            clips.eval("(reset)");

        //Obtiene el primer mensaje de la cola de mensajes
            ACLMessage mensaje = receive();

            if (mensaje!= null) {
                System.out.println(getLocalName() + ": veo que tienes: ");
                System.out.println(mensaje.getContent());

                for (String sintoma : mensaje.getContent().split("\\s+")) {
                  clips.eval("(assert (sintoma " + sintoma + "))");
                }

                //clips.eval("(reset)");

                clips.run();
                

                clips.eval("(facts)");


                fin = true;
            }
          } catch (CLIPSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          
            
        }
  }
}

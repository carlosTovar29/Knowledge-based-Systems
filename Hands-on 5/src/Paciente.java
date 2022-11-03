import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import net.sf.clipsrules.jni.*;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder.Redirect;
import jade.lang.acl.ACLMessage;

public class Paciente extends Agent {
  protected void setup() {
    addBehaviour(new EmisorComportaminento());
}

private class EmisorComportaminento extends SimpleBehaviour {
    boolean fin = false;
  
    public void action() {
        System.out.println(getLocalName() +": Preparandose para enviar un mensaje al doctor");
        AID id = new AID();
        id.setLocalName("Doctor");

    // Creación del objeto ACLMessage
        ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);

    //Rellenar los campos necesarios del mensaje
        mensaje.setSender(getAID());
        mensaje.setLanguage("English");
        mensaje.addReceiver(id);
        mensaje.setContent("tos fiebre moco moco-amarillo nausas");

    //Envia el mensaje a los destinatarios
        send(mensaje);

        System.out.println(getLocalName() +": Voy a morir, verdad?");
        System.out.println(mensaje.toString());
        fin = true;
    }

    public boolean done()
    {
        return fin;
    }
}
}

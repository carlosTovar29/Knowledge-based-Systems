import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import net.sf.clipsrules.jni.*;
import jade.core.behaviours.OneShotBehaviour;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder.Redirect;


public class Persons extends Agent {
  private Environment clips;
  
  protected void setup() {	
    clips = new Environment(); 
    addBehaviour(new TellBehaviour());
    addBehaviour(new AskBehaviour());
  } 

  private class TellBehaviour extends Behaviour  {
    boolean tellDone = false;

    public void action() {
    
      System.out.println("Invoking Tell"); 
      try {
        clips.eval("(clear)");

        clips.eval("(load \"persons/load-persons.clp\")\n");
        clips.eval("(load \"persons/load-persons-rules.clp\")\n");
        
        //clips.build("(defrule r1 (sintoma ?s) => (printout t ?s crlf))");
        clips.eval("(reset)");

        //clips.eval("(assert (sintoma a))");

        tellDone = true;
      } catch (CLIPSException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } 
    
    public boolean done() {
      if (tellDone)
        return true;
      else
	return false;
    }
  }    // END of inner class ...Behaviour

 private class AskBehaviour extends Behaviour {
    boolean askDone = false;

    public void action() {
      System.out.println("Invoking Ask"); 

      try {
        System.out.println("\n\n############### RUNNING ############### \n#######################################");
        clips.run();
        System.out.println();

        System.out.println("\n\n################ FACTS ################ \n#######################################");
        clips.eval("(facts)");

        System.out.println("\n\n################ RULES ################ \n#######################################");
        clips.eval("(rules)\n");
        
        
        clips.clear();
        
          
        askDone = true;
      } catch (CLIPSException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    } 
    
    public boolean done() {
      if (askDone)
        return true;
      else
	return false;
    }
   
    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    } 
  }  
}

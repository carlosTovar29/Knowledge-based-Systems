import net.sf.clipsrules.jni.Environment;

public class Neumologo extends Doctor {
    @Override
    protected void setup() {
        clip_rules_file = "diagnostic/neumologia.clp";
        saludo = ": Buen día ¿En qué puedo ayudarle?";
        mensaje_recibido = ": veo que usted presenta varios síntomas ";
        despedida = ": Eso es todo en lo que te puedo ayudar";

        super.setup();
    }
}
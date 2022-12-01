import net.sf.clipsrules.jni.Environment;

public class Dermatologo extends Doctor {
    @Override
    protected void setup() {
        clip_rules_file = "diagnostic/dermatologia.clp";
        saludo = ": Qué tal, ¿Gusta tomar aciento?";
        mensaje_recibido = ": Puedo ver que no se encuentra del todo bien ";
        despedida = ": Ese es todo mi diagnóstico.";

        super.setup();
    }
}
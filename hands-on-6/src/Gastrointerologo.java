import net.sf.clipsrules.jni.Environment;

public class Gastrointerologo extends Doctor {
    @Override
    protected void setup() {
        clip_rules_file = "diagnostic/gastroenterologia.clp";
        saludo = ": Hola, mucho gusto ¿Viene a consulta?";
        mensaje_recibido = ": Así que usted tiene todo eso...";
        despedida = ": ¿Listo para comenzar tu tratamiento?";

        super.setup();
    }
}

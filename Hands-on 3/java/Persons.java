package clipsOnJava;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder.Redirect;

public class Persons {
    public static void main (String args[]) throws IOException, InterruptedException
	{
        ProcessBuilder pb = new ProcessBuilder("CLIPS\\CLIPSDOS.exe");

        pb.redirectOutput(Redirect.INHERIT).redirectError(Redirect.INHERIT);

        Process p = pb.start();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));

        bw.write("(load \"hands-on 3/persons/load-persons.clp\")\n");
        bw.write("(load \"hands-on 3/persons/load-persons-rules.clp\")\n");


        bw.write("(reset)\n");
        bw.write("(facts)\n");
        bw.write("(rules)\n");
        bw.write("(run)\n");
        bw.write("(exit)\n");

        bw.flush();

        p.waitFor();
    }
}

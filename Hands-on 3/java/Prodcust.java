package clipsOnJava;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder.Redirect;

public class Prodcust {
    public static void main (String args[]) throws IOException, InterruptedException
	{
        ProcessBuilder pb = new ProcessBuilder("CLIPS\\CLIPSDOS.exe");

        pb.redirectOutput(Redirect.INHERIT).redirectError(Redirect.INHERIT);

        Process p = pb.start();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream())); // writer
        // BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream())); // reader

        bw.write("(load \"hands-on 3/prodcust/load-prod-cust.clp\")\n");
        bw.write("(load \"hands-on 3/prodcust/load-prodcust-rules.clp\")\n");


        bw.write("(reset)\n");
        bw.write("(facts)\n");
        bw.write("(rules)\n");
        bw.write("(run)\n");
        bw.write("(exit)\n");

        bw.flush();

        p.waitFor();
    }
}

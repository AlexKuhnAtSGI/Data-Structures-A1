package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Part2 {
  
  /**
   * Your code goes here - see Part0 for an example
   * @param r the reader to read from
   * @param w the writer to write to
   * @throws IOException
   */
  public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
    ArrayList<String> sEvens = new ArrayList<String>();
    ArrayList<String> sOdds = new ArrayList<String>();
    int x = 0;
    
    for (String line = r.readLine(); line != null; line = r.readLine()) {
      if (x % 2 == 0){
        sEvens.add(line);
      }
      else {
        sOdds.add(line);
      }
      x += 1;
    }
    for (int i = 0; i < sEvens.size(); i++) {
      w.println(sEvens.get(i));
    }
    for (int i = 0; i < sOdds.size(); i++) {
      w.println(sOdds.get(i));
    }
  }
  
  /**
   * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
   * and System.out or from filenames specified on the command line, then call doIt.
   * @param args
   */
  public static void main(String[] args) {
    try {
      BufferedReader r;
      PrintWriter w;
      if (args.length == 0) {
        r = new BufferedReader(new InputStreamReader(System.in));
        w = new PrintWriter(System.out);
      } else if (args.length == 1) {
        r = new BufferedReader(new FileReader(args[0]));
        w = new PrintWriter(System.out);    
      } else {
        r = new BufferedReader(new FileReader(args[0]));
        w = new PrintWriter(new FileWriter(args[1]));
      }
      long start = System.nanoTime();
      doIt(r, w);
      w.flush();
      long stop = System.nanoTime();
      System.out.println("Execution time: " + 10e-9 * (stop-start));
      r.close();
      w.close();
    } catch (IOException e) {
      System.err.println(e);
      System.exit(-1);
    }
  }
}

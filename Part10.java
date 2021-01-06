package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Part10 {
  
  /**
   * Your code goes here - see Part0 for an example
   * @param r the reader to read from
   * @param w the writer to write to
   * @throws IOException
   */
  public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
    ArrayList<String> i = new ArrayList<String>();
    for (String line = r.readLine(); line != null; line = r.readLine()) {
      i.add(line);
    }
    Iterator<String> itr = i.iterator();
    ArrayList<String> iIncreasing = new ArrayList<String>();
    ArrayList<String> iDecreasing = new ArrayList<String>();
    int maxSize = (int)Math.ceil(Math.sqrt(i.size()));
    
    iIncreasing.add(i.get(0));
    iDecreasing.add(i.get(0));
    for (int x = 0; x < i.size(); x++){
      if (i.get(x).toLowerCase().compareTo(iIncreasing.get(iIncreasing.size() - 1).toLowerCase()) > 0){
        iIncreasing.add(i.get(x));
      }
      if (i.get(x).toLowerCase().compareTo(iDecreasing.get(iDecreasing.size() - 1).toLowerCase()) < 0){
        iDecreasing.add(i.get(x));
      }
      
      if (iIncreasing.size() >= maxSize || iDecreasing.size() >= maxSize){
        break;
      }
    }
  
  if (iIncreasing.size() >= maxSize){
    itr = iIncreasing.iterator();
  }
  else{
    itr = iDecreasing.iterator();
  }
  while(itr.hasNext()) {
    w.println(itr.next());
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
  } catch (IOException e) {
    System.err.println(e);
    System.exit(-1);
  }
}
}

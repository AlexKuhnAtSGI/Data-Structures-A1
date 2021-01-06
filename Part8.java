package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Part8{
  
//  public int compare(String s1, String s2) {
//    return s1.compareTo(s2);
//  }
//  
//  public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
//    Integer v1 = e1.getValue();
//    Integer v2 = e2.getValue();
//    
//    String k1 = e1.getKey();
//    String k2 = e2.getKey();
//    
//    if (v1.compareTo(v2) != 0)
//      return v1.compareTo(v2);
//    else
//      return k1.compareTo(k2);
//  }
//  
  
  
  public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
    Map<String, Integer> s = new HashMap<String, Integer>();
    for (String line = r.readLine(); line != null; line = r.readLine()) {
      if (!s.containsKey(line)){
        s.put(line, 1);
      }
      else{
        s.put(line, s.get(line) + 1);
      }
    }
    
    Comparator<Entry<String, Integer>> sSorter = new Comparator<Entry<String, Integer>>() {
      
      @Override
      public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
        Integer v1 = e1.getValue();
        Integer v2 = e2.getValue();
        
        String k1 = e1.getKey();
        String k2 = e2.getKey();
        
        if (v1.compareTo(v2) != 0)
          return -1*(v1.compareTo(v2));
        else
          return k1.compareTo(k2);
      }
    };
    
    Set<Map.Entry<String, Integer>> sEntries = s.entrySet();
    List<Entry<String, Integer>> sList = new ArrayList<Entry<String, Integer>>(sEntries);
    Collections.sort(sList, sSorter);
    LinkedHashMap<String, Integer> sSorted = new LinkedHashMap<String, Integer>(sList.size());
    
    for(Entry<String, Integer> e : sList){
      sSorted.put(e.getKey(), e.getValue());
    }
    
    Set<Entry<String, Integer>> sFinal = sSorted.entrySet();
    
    for(Entry<String, Integer> e : sFinal){
      w.println(e.getKey());
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

/** Hannah Dougherty
 * Formal Languages final project
 * https://www.homeandlearn.co.uk/java/read_a_textfile_in_java.html
 */
import java.io.*;

public class grep{
        
    public static class writeFile{
        // creating NFA and DFA files
        static StringBuilder NFAfile = new StringBuilder();
        static StringBuilder DFAfile = new StringBuilder();
        int NFA = 0;
        int DFA = 1;

        public NFA processNFA(String[] regexer, int x){
            // processing NFA file
            RegEx parse = new RegEx(regexer[x]);
            NFA nfaa = parse.regex();;
            return nfaa;
        }

        public void processDFA(NFA nfa){
            DFA dfaa = new DFA();
            dfaa.nfaDfa(nfa);
        }
    }

    public static void main(String[] args){
        try{
            // accepting file to work with 
            BufferedReader read =  new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter a regex file and path:");
            String s = read.readLine();
            String[] line = s.split(" ");
    
            //getting the regex, NFA file, and DFA file
            String regexer = line[0];
            String NFAfiler = line[1];
            String DFAfiler = line[2];
    
            // read regex file
            FileReader filer = new FileReader(regexer); 
            BufferedReader in = new BufferedReader(filer);
            // finding the length of the file
            int length = 0;
            String lines = in.readLine();
            while(line != null){
                if(lines.isEmpty()){
                    break;
                }
                length += lines.length();
            }
            // making a string array the length of the # of lines in the file
            String[] data = new String[length];
            // setting all data to the data array
            for (int i = 0; i < length; i++) {
                data[i] = in.readLine();
            }
            in.close();
    
            // open regex file
            FileWriter outputNFA = new FileWriter(NFAfiler); // create NFA file
            FileWriter outputDFA = new FileWriter(DFAfiler); // create DFA file
            // closing the file 
            outputNFA.close();
            outputDFA.close();
        }catch(IOException e){
            // catching errors 
            System.out.println("An error occurred.");
        }
    }
}
/** Hannah Dougherty
 * Formal Languages final project
 * https://www.homeandlearn.co.uk/java/read_a_textfile_in_java.html
 */
import java.io.*;
import java.io.File;

public class grep{
        
    public static class writeFile{
        static StringBuilder NFAfile = new StringBuilder();
        static StringBuilder DFAfile = new StringBuilder();
        int NFA = 0;
        int DFA = 1;

        public NFA processNFA(String[] regexer, int x){
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
            BufferedReader read =  new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter a regex file and path:");
            String s = read.readLine();
            String[] line = s.split(" ");
    
            //getting the regex, NFA file, and DFA file
            String regexer = line[0];
            String NFAfiler = line[1];
            String DFAfiler = line[2];
    
            FileReader filer = new FileReader(regexer); // read regex file
            BufferedReader in = new BufferedReader(filer);
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
    
            //String[] lines = file.openFile(); // open regex file
            FileWriter outputNFA = new FileWriter(NFAfiler); // create NFA file
            FileWriter outputDFA = new FileWriter(DFAfiler); // create DFA file
            outputNFA.close();
            outputDFA.close();
        }catch(IOException e){
            System.out.println("An error occurred.");
        }
    }
}
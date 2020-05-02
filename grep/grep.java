/** Hannah Dougherty
 * Formal Languages final project
 * https://www.homeandlearn.co.uk/java/read_a_textfile_in_java.html
 */
import java.io.*;

public class grep{
        
    public static class writeFile(){
        private final String outter;
        static StringBuilder NFAfile = new StringBuilder();
        static StringBuilder DFAfile = new StringBuilder();
        private final int NFA = 0;
        private final int DFA = 1;

        public writeFile(String file){
            outter = file;
        }

        public NFA processNFA(String[] regex, int x){
            // need DFA and NFA classes //
            RegexParser parse = new RegexParser(regex[i]);
            NFA nfaa = parse.regex();
            String i = nfaa.NFAtoDOT();
            NFAfile.append(i);
            return nfaa;
        }

        public void processDFA(NFA nfa){
            //  need DFA and NFA classes //
            DFA dfaa = new DFA();
            dfaa.nfaToDfa(nfa);
            String i = dfaa.DFAtoDOT();
            DFAfile.append(i);
        }

        public void output(int nfadfa){
            File file = new File(outter);
            FileWriter fileWriter = new FileWriter(file);
            if(nfadfa == NFA) {
                // if nfadfa is an nfa
                fileWriter.write(NFAfile.toString());
            }else {
                // else if nfadfa is a dfa
                fileWriter.write(DFAfile.toString());
            }
        }
    }

    public static class readFile(){
        private String file;

        public readFiles(String filer) {
            file = filer;
        }    
        
        public String[] openFile() throws IOException{
            FileReader filer = new FileReader(file);
            BufferedReader in = new BufferedReader(filer);
            // # of lines in file
            int num = readLines();
            // making a string array the length of the # of lines in the file
            String[] data = new String[num];
            // setting all data to the data array
            for (int i = 0; i < num; i++) {
                data[i] = in.readLine();
            }
            in.close();
            return data;
        }

        int readLine() throws IOException{
            FileReader filer = new FileReader(file);
            BufferReader in = new BufferReader(filer);
            int num = 0;
            while(in.readLine() != null){
                num++;
            }
            in.close;
            return num;
        }
    }

    public static void main(String[] args){
        try{
            BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
            System.out.printl("Please enter a regex file and path!");
            String s = in.readLine();
            String[] line = s.split(" ");
    
            //getting the regex, NFA file, and DFA file
            String regexer = line[0];
            String NFAfiler = line[1];
            String DFAfiler = line[2];
    
            ReadFile file = new ReadFile(regexer); // read regex file
            String[] lines = file.OpenFile(); // open regex file
            WriteFile outputNFA = new WriteFile(NFAfiler); // create NFA file
            WriteFile outputDFA = new WriteFile(DFAfiler); // create DFA file
        }catch(IOException e){
            System.out.println("error");
        }

    }
}
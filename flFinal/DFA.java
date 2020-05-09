/** Hannah Dougherty
 * DFA.java
 */
import java.util.LinkedHashSet;
import java.util.Set;

public class DFA extends NFA{

    public DFA(){
        super();
    }

    public void nfaDfa(NFA nfa){
        this.start = nfa.start;
        this.stop = nfa.stop;
    }

    public dotConvert(){
        // create DOT file
    }

    public toDOT(){

    }
}
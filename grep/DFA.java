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

    public toDOT(DFA.state x, StringBuilder dotter, Set<Integer> visit){
        String z;
        if(visit.contains(x.stateNumber)){
            return;
        }
        visit.add(x.stateNumber);
        for(DFA.Edge e: x.edges){
            if(e.label == DFA.FAIL){
                break;
            }else{
                label = String.valueOf(e.label);
            }
            // create dot file here 
        }
    }
}
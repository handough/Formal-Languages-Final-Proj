/** Hannah Dougherty
 * DFA.java
 */

public class DFA extends NFA{

    public DFA(){
        // constructor 
        super();
    }

    public void nfaDfa(NFA nfa){
        this.start = nfa.start;
        this.stop = nfa.stop;
    }
    // create dot file
}
/** Hannah Dougherty
 * NFA.java
 */
import java.util.ArrayList;
import java.util.List;

public class NFA{
    // invalid value for accept in stop state 
    public static final int FAIL = 0;
    // epsilon variable
    public static final char EPSILON = 0;
    // global state counting variable
    public static int globals = 0;

    public static class State{
        // state number
        public int stateNumber;
        // array list used to keep track of the edges 
        public final List<Edge> edges = new ArrayList<>();
        protected int accept = FAIL;

        public State(){
            // keeps track of states 
            stateNumber = globals++;
        }

        public void edge(char z, State target){
            // edges 
            Edge e = new Edge(z, target);
            edges.add(e);
        }

        public void epsilon(State target){
            // epsilon 
            edge(EPSILON, target);
        }

        public void accept(int x){
            // accepting states 
            accept = x;
        }

        public String toString(){
            // returns state number as a string
            return "state" + stateNumber;
        }
    }

    public static class Edge{
        final State target;
        char z;

        public Edge(char z, State target){
            this.z = z;
            this.target = target;
        }
    }

    protected State start;
    protected State stop;
    
    public NFA(){
        start = new State();
        stop = new State();
    }

    public NFA(State start, State stop){
        this.stop = stop;
        this.start = start;
    }

    public static NFA atom(char z){
        State a = new State();
        State b = new State();
        a.edge(z, b);
        return new NFA(a,b);
    }
}
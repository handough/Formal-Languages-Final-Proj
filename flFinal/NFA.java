/** Hannah Dougherty
 * NFA.java
 */

import java.util.ArrayList;
import java.util.LinkedHashSet;
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
            stateNumber = globals++;
        }

        public void edge(char z, State target){
            Edge e = new Edge(z, target);
            edges.add(e);
        }

        public void epsilon(State target){
            edge(EPSILON, target);
        }

        public void accept(int x){
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

    // build string file

    public void tooDOT(){
        // build string to save
    }

    public LinkedHashSet<State> getState(){
        LinkedHashSet<State> visited = new LinkedHashSet<>();
        getStater(start, visited);
        return visited;
    }

    public void getStater(State x, LinkedHashSet<State> visited){
        if(visited.contains(x)){
            return;
        }
        visited.add(x);
        for(Edge e: x.edges){
            getStater(e.target, visited);
        }
    }

    public static NFA atom(char z){
        State a = new State();
        State b = new State();
        a.edge(z, b);
        return new NFA(a,b);
    }
}
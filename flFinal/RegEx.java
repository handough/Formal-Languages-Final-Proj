
/** Hannah Dougherty
 * RegEx.java
 */
public class RegEx {
    char z[]; // the regex pattern characters
    int x = 0;
    int num = 0;

    

    public RegEx(String z){
        this.z = z.toCharArray();
        num = this.z.length;
    }

    public NFA regex(){
        NFA q;
        q = pattern();
        if(q==null){
            q = NFA.atom(NFA.EPSILON);
        }

        if (search() == '|'){
            NFA l = new NFA();
            l.start.epsilon(q.start);
            q.stop.epsilon(l.stop);
            q = l;
        }
        return q;
    }

    public NFA pattern(){
        NFA q;
        if(validNum() || search() == '('){
            q = end();
            NFA w = pattern();
            if(w != null){
                q.stop.epsilon(w.start);
                return new NFA(q.start, w.stop);
            }else{
                return q;
            }
        }else{
            return null;
        }
    }

    public NFA end(){
        NFA q;
        q = letters();
        while(search() == '*'){
            matchCheck('*');
            NFA n = new NFA();
            n.start.epsilon(q.start);
            q.stop.epsilon(n.start);
            q.stop.epsilon(n.stop);
            n.start.epsilon(n.stop);
            q = n;
        }
        return q;
    }

    public NFA letters(){
        NFA a;
        char q;
        if(validChar()){
            q = z[x];
            matchCheck(q);
            a = NFA.atom(q);
            return a;
        }if(search() == '('){
            matchCheck('(');
            a = regex();
            matchCheck(')');
            return a;
        }else{
            return null;
        }
    }

    public boolean validChar(){
        return search() <= 'z' && search() >= 'a';
    }

    public boolean validNum(){
        return search() >= 97 && search() <= 122;
    }

    public void matchCheck(char a){
        if(search() == a){
            x++;
        }
    }

    public char search(){
        if(x >= z.length){
            return (char)-1;
        }
        return z[x];
    }
}
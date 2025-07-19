import java.util.*;
/** ADT
 * 
 * 
 */
public class integerSet {
    ArrayList<Integer> Number ; //rep

    public integerSet(){
        Number = new ArrayList<>();
        checkRep();
    }

    private void checkRep(){
        if(Number.size() != 0){
            for (int i = 0; i < Number.size() - 1; i++) {
                if (Number.get(i) >= Number.get(i+1 ) || Number.get(i) == null ) {
                    throw new RuntimeException("Rep invariant violated!");
                }
            }
        }
    }

    public void add(Integer x ){
        if (!this.contains(x)) {
            Number.add(x);
            Number.sort(null);
        }
        checkRep();
    }

    public boolean contains(int n) {
        return Number.indexOf(n) != -1;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < Number.size(); i++) {
            sb.append(Number.get(i));
            if (i < Number.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
}

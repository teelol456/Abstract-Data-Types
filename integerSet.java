import java.util.*;
/** 
 * ADT ที่เก็บเลขจำนวนเต็มใดๆ เรียงจากน้อยไปมาก และห้ามมี null หรือตัวเลขซ้ำ
 */
public class integerSet {
    ArrayList<Integer> Number ; //rep

    // AF(Number) 
    // - เซตของตัวเลขทั้งหมดที่อยู่ในArrayList Number
    //RI 
    // - Integer in Number เรียงจากน้อยไปมาก ห้ามมี null และ ห้ามมี ตัวเลขซ้ำ 
    
    /**
     * Constructor เริ่มต้น สร้าง ArrayList ว่าง
     */
    public integerSet(){
        Number = new ArrayList<>();
        checkRep();
    }

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    private void checkRep(){
        if(Number.size() != 0){
            for (int i = 0; i < Number.size() - 1; i++) {
                if (Number.get(i) >= Number.get(i+1 ) || Number.get(i) == null ) {
                    throw new RuntimeException("Rep invariant violated!");
                }
            }
        }
    }
    /**
     * เพิ่มตัวเลข และ เรียงจากน้อยไปมาก
     * @param c เลขที่ต้องการเพิ่ม
     */
    public void add(Integer x ){
        if (!this.contains(x)) {
            Number.add(x);
            Number.sort(null);
        }
        checkRep();
    }

    /**
     * ตรวจสอบว่ามีตัวเลขนี้อยู่ในArrayListหรือไม่
     * @param x ตัวเลขที่ต้องการตรวจสอบ
     * @return true หากมี x อยู่ในArrayList, false หากไม่มี
     */
    public boolean contains(int n) {
        return Number.indexOf(n) != -1;
    }

    /**
     * คืนค่าขนาดของArrayList
     * @return จำนวนสมาชิกในArrayList
     */
    public int size() {
        return Number.size();
    }

    /**
     * แปลงจากตัวเลขทั้งหมดในArrayListเป็นข้อความ
     * @return Stringตัวเลขที่แปลงมา
     */
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


public class AddBinary {

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        
        if (b == null || b.length() == 0) {
            return a;
        }
        
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        
        StringBuilder builder = new StringBuilder();
        int flag = 0;
        while (pa >= 0 || pb >= 0) {
            int va = 0;
            int vb = 0;
            
            if (pa >= 0) {
                va = a.charAt(pa) == '0' ? 0 : 1;
                pa--;
            }
            
            if (pb >= 0) {
                vb = b.charAt(pb) == '0' ? 0 : 1;
                pb--;
            }
            
            int result = va + vb + flag;
            if (result >= 2) {
                builder.append((result - 2));
                flag = 1;
            } else {
                builder.append(result);
                flag = 0;
            }
        }
        
        if (flag == 1) {
            builder.append(1);
        }
        
        return builder.reverse().toString();
    }
}


public class MaxProductWordLength {

    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) {
            return 0;
        }
        
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                char[] chars = words[i].toCharArray();
                
                boolean found = false;
                for (int k = 0; k < chars.length; k++) {
                    if (k < chars.length - 1) {
                        if (chars[k] == chars[k+1]) {
                            continue;
                        }
                    }
                    
                    if (words[j].contains(chars[k] + "")) {
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    int temp = words[j].length() * words[i].length();
                    
                    max = Math.max(max, temp);
                }
            }
        }
        
        return max;
    }
}

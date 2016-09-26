
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
      	if (s == null) {
      	    return true;
      	}
      	
      	s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        
        int start = 0;
        int end = s.length()-1;
        while(start < end) {
            int startChar = Character.toLowerCase(s.charAt(start));
            int endChar = Character.toLowerCase(s.charAt(end));
            
            if (startChar != endChar) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
   }
}

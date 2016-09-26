import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = new char[26];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }
            
            String temp = new String(chars);
            if (map.containsKey(temp)) {
                map.get(temp).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(temp, list);
            }
        }
        
        result.addAll(map.values());
        
        return result;
    }

}

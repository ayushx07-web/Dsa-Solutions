import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<String> electronics = new ArrayList<>();
        List<String> grocery = new ArrayList<>();
        List<String> pharmacy = new ArrayList<>();
        List<String> restaurant = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            
            if (!isActive[i]) continue;

            
            if (code[i] == null || code[i].isEmpty()) continue;

            
            if (!isValidCode(code[i])) continue;

            String b = businessLine[i];

            if (b.equals("electronics")) electronics.add(code[i]);
            else if (b.equals("grocery")) grocery.add(code[i]);
            else if (b.equals("pharmacy")) pharmacy.add(code[i]);
            else if (b.equals("restaurant")) restaurant.add(code[i]);
        }

        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);

        List<String> res = new ArrayList<>();
        res.addAll(electronics);
        res.addAll(grocery);
        res.addAll(pharmacy);
        res.addAll(restaurant);

        return res;
    }

    
    private boolean isValidCode(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(
                    (c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z') ||
                    (c >= '0' && c <= '9') ||
                    c == '_'
            )) {
                return false;
            }
        }
        return true;
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] code = {"SAVE20", "", "PHARMA5", "SAVE@20"};
        String[] businessLine = {"restaurant","grocery","pharmacy","restaurant"};
        boolean[] isActive = {true,true,true,true};

        List<String> result = sol.validateCoupons(code, businessLine, isActive);
        System.out.println(result);
    }
}

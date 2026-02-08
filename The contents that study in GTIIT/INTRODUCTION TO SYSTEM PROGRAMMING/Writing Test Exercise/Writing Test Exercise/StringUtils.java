// StringUtils.java
public class StringUtils {
    /**
     * 练习2.1: 反转字符串
     * 输入: "hello" -> 返回: "olleh"
     * 输入: null -> 返回: null
     * 输入: "" -> 返回: ""
     */
    public String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }
    
    /**
     * 练习2.2: 判断是否为回文字符串
     * 回文：正读反读都一样，如"racecar"
     */
    public boolean isPalindrome(String str) {
        if (str == null) return false;
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(reverse(cleaned));
    }
    
    /**
     * 练习2.3: 统计元音字母数量
     * 元音字母: a, e, i, o, u (不区分大小写)
     */
    public int countVowels(String str) {
        if (str == null || str.isEmpty()) return 0;
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) != -1) count++;
        }
        return count;
    }
}
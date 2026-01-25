// StringProcessor.java
public class StringProcessor {
    public String reverse(String text) {
        // 反转字符串
        String result = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            result += text.charAt(i);
        }
        return result;
    }
    
    public int countWords(String sentence) {
        // 简单统计单词数（用空格分割）
        String[] words = sentence.split(" ");
        return words.length;
    }
}
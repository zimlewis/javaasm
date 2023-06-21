package qu_method;

public class string_handler {
    public static String reverse_string_by_word(String input) {
        String[] words = input.split(" ");
        StringBuilder reversedString = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]);
            if (i != 0) {
                reversedString.append(" ");
            }
        }
        return reversedString.toString();
    }
}

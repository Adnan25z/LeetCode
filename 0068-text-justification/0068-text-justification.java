import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;

            // Find out how many words can fit into the current line
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int wordCount = last - index;
            // If this is the last line or there's only one word in this line, left-justify
            if (last == words.length || wordCount == 1) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) sb.append(" ");
                }
                // Fill in the remaining space
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                // Fully justify the line
                int spaces = (maxWidth - totalChars) / (wordCount - 1);
                int extraSpaces = (maxWidth - totalChars) % (wordCount - 1);

                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                    for (int j = 0; j < spaces; j++) {
                        sb.append(" ");
                    }
                    if (i - index < extraSpaces) {
                        sb.append(" ");
                    }
                }
                sb.append(words[last - 1]);  // Add the last word without extra spaces
            }

            result.add(sb.toString());
            index = last;  // Move to the next group of words
        }
        
        return result;
    }
}

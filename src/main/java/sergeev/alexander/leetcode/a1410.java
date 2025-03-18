package sergeev.alexander.leetcode;

import java.util.HashMap;
import java.util.Map;

// 1410. HTML Entity Parser
public class a1410 {

    /*
    HTML entity parser is the parser that takes HTML code as input
    and replace all the entities of the special characters by the characters itself.
    The special characters and their entities for HTML are:
    Quotation Mark: the entity is &quot; and symbol character is ".
    Single Quote Mark: the entity is &apos; and symbol character is '.
    Ampersand: the entity is &amp; and symbol character is &.
    Greater Than Sign: the entity is &gt; and symbol character is >.
    Less Than Sign: the entity is &lt; and symbol character is <.
    Slash: the entity is &frasl; and symbol character is /.
    Given the input text string to the HTML parser, you have to implement the entity parser.
    Return the text after replacing the entities by the special characters.
     */

    public static void main(String[] args) {
        String s = "and I quote: &quot;...&quot;";
        System.out.println(entityParser(s));
    }

    // BEATS 73%
    public static String entityParser(String text) {
        char a = '"';
        String b = "'";
        text = text.replace("&quot;", Character.toString(a));
        text = text.replace("&apos;", b);
        text = text.replace("&amp;", "-1");
        text = text.replace("&gt;", ">");
        text = text.replace("&lt;", "<");
        text = text.replace("&frasl;", "/");
        text = text.replace("-1", "&");
        return text;
    }

    // BEATS 8%
    public static String entityParser1(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        StringBuilder sb = new StringBuilder();
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '&') {
                String str = text.substring(i);
                boolean was = false;
                for (String s : map.keySet()) {
                    if (str.startsWith(s)) {
                        was = true;
                        String replacement = map.get(s);
                        int size = s.length();
                        sb.append(replacement);
                        i += size - 1;
                        break;
                    }
                }
                if (!was) {
                    sb.append(arr[i]);
                }
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
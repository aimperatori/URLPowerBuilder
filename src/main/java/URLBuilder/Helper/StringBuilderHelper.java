package URLBuilder.Helper;

public class StringBuilderHelper {

    public static StringBuilder TrimEnd(StringBuilder _sb, char _trimChar) {
        while (_sb.charAt(_sb.length()-1) == _trimChar)
            _sb.deleteCharAt(_sb.length()-1);

        return _sb;
    }
}

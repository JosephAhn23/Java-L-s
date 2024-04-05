/**
 *
 * @author Marcel Turcotte, Université d'Ottawa/University of Ottawa
 */

 public class Balanced {

    public static boolean algo1( String s ) {

        int curly = 0;
        int square = 0;
        int round = 0;

        for ( int i=0; i<s.length(); i++ ) {

            char c = s.charAt( i );

            switch ( c ) {
            case '{':
                curly++;
                break;
            case '}':
                curly--;
                break;
            case '[':
                square++;
                break;
            case ']':
                square--;
                break;
            case '(':
                round++;
                break;
            case ')':
                round--;
            }
        }
        return curly == 0 && square == 0 && round == 0;
    }
    public static boolean algo2(String expression) {
        ArrayStack<Character> stack = new ArrayStack<>(expression.length());

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;  
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty(); 
    }


    public static void main( String[] args ) {
        for ( int i=0; i<args.length; i++ ) {
            System.out.println( "algo1( \"" + args[ i ] + "\" ) -> " + algo1( args[ i ] ) );
        }
    }
}
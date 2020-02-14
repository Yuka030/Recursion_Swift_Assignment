public class Recursion {
    public static void main(String[] args) {
        String str1 = "((3 + 5) * ((1 * 2) + 5))";
        String str2 = "((2 + 1) * 2)";

        System.out.println(evaluate(str1)); // 56
        System.out.println(evaluate(str2)); // 6
    }

    public static int evaluate(String string){
        string = string. replaceAll("\\s","");

        // base case
        if(string.length() < 2){
            return perseInt(string.charAt(0));
        }

        // recursive case
        string = string.substring(1, string.length() - 1);
        System.out.println("(recursive case) string is:" + string);

        int stack = 0;
        int i = 0;


        while(i < string.length()){
            switch (string.charAt(i)){
                case '(':
                    stack++;
                    break;
                case ')':
                    stack--;
                    break;
            }

            if(stack == 0){
                if(string.charAt(i) == '+' || string.charAt(i) == '*'){
                    int left = evaluate(string.substring(0, i));
                    char operator = string.charAt(i);
                    int right = evaluate(string.substring(i + 1, string.length()));

                    switch(operator) {
                        case '+':
                            return left + right;
                        case '*':
                            return left * right;
                    }
                }
            }
            i++;
        }

        return -1;
    }

    public static int perseInt(char number){
        return Integer.parseInt(Character.toString(number));
    }
}
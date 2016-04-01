import java.util.*;

public class Braces {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter Your String: ");
        String inputString = in.nextLine();
        System.out.println(checkBraces(inputString));
        in.close();
    }

    static String checkBraces(String value) {
        ArrayList<String> asd = new ArrayList<String>();
        Stack<Character> specialCharStack = new Stack<Character>();
        String response = "Fail";
        char tempChar;
        Character[] openingBraces = {'[', '{', '('};
        Character[] closingBraces = {']', '}', ')'};
        List<Character> openingBracesList = Arrays.asList(openingBraces);
        List<Character> closingBracesList = Arrays.asList(closingBraces);

        if (value == null) {
            return response;
        } else if (value.length() == 0) {
            response = "Pass";
        } else {
            for (int i = 0; i < value.length(); i++) {
                tempChar = value.charAt(i);

                if (openingBracesList.contains(tempChar)) {
                    specialCharStack.push(tempChar);
                } else if (closingBracesList.contains(tempChar)) {
                    if (!specialCharStack.isEmpty()) {
                        if (tempChar == ')' && '(' != specialCharStack.pop()) {
                            return response;
                        } else if (tempChar == '}' && '{' != specialCharStack.pop()) {
                            return response;
                        } else if (tempChar == ']' && '[' != specialCharStack.pop()) {
                            return response;
                        }
                    } else {
                        return response;
                    }
                } else {
                    return response;
                }
            }
        }
        if (specialCharStack.isEmpty()) {
            response = "Pass";
            return response;
        } else {
            return response;
        }

    }

/*
 * Complete the function below.
 */

    private static ArrayList<String> finalResponse = new ArrayList<String>();

    static String[] braces(String[] values) {
        for (int i = 0; i < values.length; i++) {
            finalResponse.add(solve(values[i]));
        }
        String[] answer = new String[finalResponse.size()];
        answer = finalResponse.toArray(answer);
        return answer;
    }

    static String solve(String values) {
        Stack<Character> charStack = new Stack<Character>(); //creating stack for popping chars in and out
        String output = "NO"; //response
        Character[] openingBraces = {'{', '[', '('}; //values to compare against
        Character[] closingBraces = {'}', ']', ')'};
        List<Character> openingBraceList = Arrays.asList(openingBraces); //to see if char is contained in list
        List<Character> closingBraceList = Arrays.asList(closingBraces);

        if (values == null) {
            return output;
        } else if (values.length() == 0) {
            output = "YES";
        } else {
            char temp;
            for (int i = 0; i < values.length(); i++) {
                temp = values.charAt(i);

                if (closingBraceList.contains(temp)) {
                    charStack.push(temp);
                } else if (openingBraceList.contains(temp) && !charStack.isEmpty()) {
                    if (temp == '(' && ')' != charStack.pop()) {
                        return output;
                    } else if (temp == '{' && '}' != charStack.pop()) {
                        return output;
                    } else if (temp == '[' && ']' != charStack.pop()) {
                        return output;
                    }
                } else {
                    return output;
                }
            }
        }
        if (charStack.isEmpty()) {
            output = "YES";
            return output;
        }
        else {
            return output;
        }

    }
}

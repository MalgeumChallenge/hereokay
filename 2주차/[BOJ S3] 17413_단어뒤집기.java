import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Character> stack = new Stack<>();
    static Stack<Character> tagChecker = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        char[] inputArr = input.toCharArray();

        for (int i = 0; i < inputArr.length; i++) {

            
            if(isTag()){
                
                bw.write(inputArr[i]);

                
                if (inputArr[i] == '>' && isTag()) {
                    tagChecker.pop();
                }

            
            } else if (!isTag()) {

                
                if (inputArr[i] == '<') {
                    tagChecker.push('<');
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write('<');
                    continue;
                }
                
                if (inputArr[i] == ' ') {
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(inputArr[i]);
                }
                
                if (inputArr[i] != ' ') {
                    stack.push(inputArr[i]);
                }
            }
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
        bw.flush();
        bw.close();
    }
        public static boolean isTag() {
            return !tagChecker.isEmpty(); 
        }
}

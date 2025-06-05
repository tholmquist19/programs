import java.util.Scanner;


public class Main{
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter expression: ");
        String exp = kb.nextLine();
        LinkedStack list = new LinkedStack();
        String ev = list.toPostfix(exp);

        System.out.println("The final postfix expression for the infix is: " + ev);
        System.out.println("The final result after evaluating the postfix is: " +list.evaluate(ev));
    }


}
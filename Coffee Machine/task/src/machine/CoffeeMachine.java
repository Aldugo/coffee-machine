package machine;
import java.util.Scanner;

public class CoffeeMachine {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String action = "";
        Machine myMachine = new Machine(400,540,120,9,550);

        while (!action.equals("exit")) {

            if (myMachine.getState() == Machine.State.CHOOSE_ACTION) {
                System.out.println();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
            }
            action = scanner.nextLine();

            switch (action) {
                case "exit":
                    //do nothing and exit loop
                    break;
                default:
                    myMachine.processInput(action);
            }
        }

    }
}

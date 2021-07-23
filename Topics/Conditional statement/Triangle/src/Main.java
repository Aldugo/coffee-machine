import java.util.Scanner;

class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int A;
        int B;
        int C;

        //System.out.println("Enter size of side A: ");
        A = scanner.nextInt();
        //System.out.println("Enter size of side B: ");
        B = scanner.nextInt();
        //System.out.println("Enter size of side C: ");
        C = scanner.nextInt();

        if((A+B>C)&&(A+C>B)&&(B+C>A)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
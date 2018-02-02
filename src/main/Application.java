import java.util.Scanner;

/**
 ** Java Program to implement Pollard Rho Algorithm
 **/
public class Application {

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pollard Rho Algorithm\n");
        System.out.println("Enter a number");
        long N = scan.nextLong();
        System.out.println("\nFactors are : ");
        PollardRho pr = new PollardRho();
        pr.factor (N);
    }
}
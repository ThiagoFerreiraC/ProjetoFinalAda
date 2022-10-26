import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidade;
        String operation;
        double media;

        quantidade = getQuantidade(sc);

        while (quantidade <= 0) {
            System.out.println("Entrada inválida! Digite um número maior do que zero.\n");
            quantidade = getQuantidade(sc);
        }

        double[] numberArray = new double[quantidade];

        numberArray = getNumbers(quantidade, sc, numberArray);

        operation = getOperation(sc);

        operation = operation.toLowerCase(Locale.ROOT);

        while (!operation.equals("aritmetica") && !operation.equals("harmonica")) {
            System.out.println("\nOperação Inválida. Insira ARITMETICA ou HARMONICA");
            operation = getOperation(sc);
            operation = operation.toLowerCase(Locale.ROOT);
        }

        media = getMedia(operation, numberArray);

        System.out.println("------------------------------------------------------");
        System.out.println("\nOs números digitados foram: ");

        for (int i = 0; i < numberArray.length; i++) {
            System.out.printf("%s\n", numberArray[i]);
        }

        System.out.printf("\nO tipo de média escolhida foi: %s.", operation);

        System.out.printf("\n\nMédia %s = %.2f", operation, media);

    }

    public static int getQuantidade (Scanner entrada) {
        try {
            System.out.println("Digite a quantidade de números: ");
            return entrada.nextInt();
        } catch (InputMismatchException e) {
            entrada.nextLine();
            System.out.println("Entrada Inválida. Digite um número inteiro\n");
            return getQuantidade(entrada);
        }
    }

    public static double[] getNumbers(int quantidade, Scanner entrada, double[] numberArray) {
        try {
            for (int i = 0; i < quantidade; i++) {
                System.out.println("Digite um número:");
                numberArray[i] = entrada.nextDouble();
            }
            return numberArray;
        } catch (InputMismatchException e) {
            entrada.nextLine();
            System.out.println("Entrada inválida. Digite novamente!\n");
            return getNumbers(quantidade, entrada, numberArray);
        }
    }

    public static String getOperation(Scanner entrada) {
        System.out.println("Digite qual o tipo de média desejada: ARITMETICA ou HARMONICA");
        return entrada.next();
    }

    public static double calculateMediaSimples (double[] numberArray) {
        double total = 0;
        for (int i = 0; i < numberArray.length; i++) {
            total += numberArray[i];
        }
        return total/numberArray.length;
    }

    public static double calculateMediaHarmonica (double[] numberArray) {
        double inverso = 0;
        double total = 0;
        for (int i = 0; i < numberArray.length; i++) {
            inverso = 1/numberArray[i];
            total += inverso;
        }
        return numberArray.length/total;
    }

    public static double getMedia(String operation, double[] numberArray) {
        if (operation.equals("aritmetica")) {
            return calculateMediaSimples(numberArray);
        } else  {
            return calculateMediaHarmonica(numberArray);
        }
    }
}

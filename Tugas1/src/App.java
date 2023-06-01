import java.util.stream.*;
public class App {


    private static void numberOne() {
        System.out.println("\nNo. 1 =========================>");
        System.out.println("Saya Pasti Bisa \nPemrograman itu menyenangkan \nAku Bahagia Kuliah di Informatika");
        System.out.println("===============================>");
    }

    private static void numberTwo() {
        System.out.println("\nNo. 2 =========================>");
        int limit = 5;
        for(int i = 1; i <= limit; i++) {
            System.out.println("Belajar JAVA itu menyenangkan");
        }
        System.out.println("===============================>");
    }

    private static void numberThree() {
        System.out.println("\nNo. 3 =========================>");
        System.out.println("   J     A     V     V     A");
        System.out.println("   J    A A     V   V     A A");
        System.out.println("J  J   AAAAA     V V     AAAAA");
        System.out.println(" JJ   A     A     V     A     A");
        System.out.println("===============================>");
    }

    private static void numberFourHelper(int number) {
        int secNum = (int) Math.pow(number, 2);
        int thirdNum = (int) Math.pow(number, 3);
        System.out.println(number + "     " + secNum + "       " + thirdNum);

    }
    private static void numberFour() {
        System.out.println("\nNo. 4 =========================>");
        System.out.println("a     a^2     a^3");
        numberFourHelper(1);
        numberFourHelper(2);
        numberFourHelper(3);
        numberFourHelper(4);
        System.out.println("===============================>");
    }

    private static int numberFiveHelper(String arithmetic) {
        String[] stringNumbers = arithmetic.split("\\+");
        int size = stringNumbers.length;
        int[] numbers = new int [size];
        for(int i=0; i<size; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        int sum = IntStream.of(numbers).sum();
        return sum;
    }

    private static void numberFive() {
        String arithmetic = "1+2+3+4+5+6+7+8+9";
        int sum = numberFiveHelper(arithmetic);
        System.out.println("\nNo. 5 =========================>");
        System.out.println(arithmetic + " = " + sum);
        System.out.println("===============================>");
    }

    public static void main(String[] args) throws Exception {
        numberOne();
        numberTwo();
        numberThree();
        numberFour();
        numberFive();

    }

}

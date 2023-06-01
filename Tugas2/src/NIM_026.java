import java.util.Scanner;

public class NIM_026 {

    private static void degree() {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan Suhu Fahrenheit: ");
        int fahrenheit = in.nextInt();
        int cDegree = 5 * (fahrenheit - 32) / 9;
        System.out.println("Dalam Celcius: " + cDegree);
        in.close();
    }

    private static void tubes() {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan Radius: ");
        int radius = in.nextInt();
        System.out.print("Masukkan Panjang: ");
        int length = in.nextInt();
        double area = radius * radius * 3.14;
        double volume = area * length;
        in.close();
        System.out.println("Luas: " + area);
        System.out.println("Volume: " + volume);
    }

    private static void feetToMeter() {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan Meter: ");
        int meter = in.nextInt();
        double feet = meter * 0.305;
        in.close();
        System.out.println("Dalam Kaki: " + feet);
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Tugas 2 (Bayu Setiawan, 026)\nPilih nomor tugas:");
        System.out.println("1. No.1\n2. No.2\n3. No.3");
        System.out.print("Masukkan Pilihan: ");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                degree();
                break;
            case 2:
                tubes();
                break;
            case 3:
                feetToMeter();
                break;
            default:
                System.out.println("Pilihan Tidak ada");
                break;
        }
        in.close();
    }
}

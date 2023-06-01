import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Bayu_Setiawan_026 {

    private static void guessingBirthday() {
        String set1 = "1 3 5 7\n9 11 13 15\n17 19 21 23\n25 27 29 31";
        String set2 = "2 3 6 7\n10 11 14 15\n18 19 22 23\n26 27 30 31";
        String set3 = "4 5 6 7\n12 13 14 15\n20 21 22 23\n28 29 30 31";
        String set4 = "8 9 10 11\n12 13 14 15\n24 25 26 27\n28 29 30 31";
        String set5 = "16 17 18 19\n20 21 22 23\n24 25 26 27\n28 29 30 31";

        List<String> sets = new ArrayList<String>(Arrays.asList(set1, set2, set3, set4, set5));
        Scanner scanner = new Scanner(System.in);
        int day = 0;

        System.out.println("\nTEBAK TGL ULTAH");
        for (int i = 0; i < sets.size(); i++) {
            System.out.println("=====================================");
            System.out.println("Apakah tgl ultahmu ada di set ini?");
            System.out.println(sets.get(i));
            System.out.print("Tidak = 0, Ya = 1: ");
            int answer = scanner.nextInt();
            if (answer == 1) {
                String[] tokens = sets.get(i).split(" ");  
                int val = Integer.parseInt(tokens[0]);
                day += val;
            }
        }
        scanner.close();
        System.out.println("Tgl ultahmu adalah: " + day);
    }

    private static void imb() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nINDEKS BERAT BADAN");
        System.out.println("=====================================");
        System.out.print("Berat badan (pound): ");
        double weight = Float.parseFloat(scanner.nextLine()) * 0.45359237;
        System.out.print("Tinggi badan (inci): ");
        double height = Float.parseFloat(scanner.nextLine()) * 0.0254;
        System.out.println("=====================================");
        System.out.println("Berat badan (kg): " + weight);
        System.out.println("Berat badan (meter): " + height);

        int indeks = (int) (weight / Math.pow(height, 2));
        String res = "";
        if(indeks < 16) {
            res = "Sangat Kurus";
        } else if (indeks >= 16 && indeks < 18) {
            res = "Kurus";
        } else if (indeks >= 18 && indeks < 24) {
            res = "Normal";
        } else if (indeks >= 24 && indeks < 29) {
            res = "Gemuk";
        } else if (indeks >= 29 && indeks < 35) {
            res = "Sangat Gemuk";
        } else {
            res = "Terlalu Gemuk";
        }
        System.out.println("Indeks Berat Badan: " + indeks + " kg/m2 (" + res + ")");
        scanner.close();
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Tugas 2 (Bayu Setiawan, 026)\nPilih nomor tugas:");
        System.out.println("1. No.1\n2. No.2");
        System.out.print("Masukkan Pilihan: ");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
            guessingBirthday();
                break;
            case 2:
                imb();
                break;
            default:
                System.out.println("Pilihan Tidak ada");
                break;
        }
        in.close();
    }
}

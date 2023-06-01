import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("Penugasan Pertemuan Akhir - Bayu Setiawan - 2109106026:");
            System.out.println("1. Soal 1");
            System.out.println("2. Soal 2");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    firstQuestion();
                    break;
                case 2:
                    secondQuestion();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
    
    public static void firstQuestion() {
        String str = "JavaScript adalah bahasa pemrograman tingkat tinggi dan dinamis";

        System.out.println("\n");
        System.out.println("String awal: " + str);
        System.out.println("1. " + str.substring(0, 37));
        System.out.println("2. " + str.toLowerCase().substring(0, 37));
        System.out.println("3. " + str.toUpperCase().substring(0, 37));
        System.out.println("4. " + str.substring(25, 36));
        System.out.println("5. " + str.substring(37));
    }


    public static double getPresentScore(int kehadiran) {
        if (kehadiran < 3) {
            return 0;
        } else if (kehadiran >= 3 && kehadiran <= 4) {
            return 60;
        } else if (kehadiran >= 5 && kehadiran <= 6) {
            return 80;
        } else {
            return 100;
        }
    }

    public static String getGrade(double skorAkhir) {
        if (skorAkhir >= 85 && skorAkhir <= 100) {
            return "A";
        } else if (skorAkhir >= 70 && skorAkhir <= 84) {
            return "B";
        } else if (skorAkhir >= 60 && skorAkhir <= 69) {
            return "C";
        } else if (skorAkhir >= 50 && skorAkhir <= 59) {
            return "D";
        } else {
            return "E";
        }
    }

    public static void secondQuestion() {

        System.out.println("=== Program Kebijakan Akademik ===");
        System.out.print("Masukkan jumlah kehadiran: ");
        int presents = scanner.nextInt();

        System.out.print("Masukkan nilai UTS: ");
        double midExam = scanner.nextDouble();

        System.out.print("Masukkan nilai UAS: ");
        double finalExam = scanner.nextDouble();

        double presentScore = getPresentScore(presents);
        double finalScore = (presentScore * 0.2) + (midExam * 0.3) + (finalExam * 0.5);
        String grade = getGrade(finalScore);
        
        System.out.println("Skor Akhir: " + finalScore);
        System.out.println("Grade: " + grade);

        System.out.println("Tekan enter untuk melanjutkan...");
        scanner.nextLine(); 
        scanner.nextLine();
    }
}

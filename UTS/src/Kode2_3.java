import java.util.Scanner;

public class Kode2_3 {
    public static void main(String[] args) throws Exception {
        // Menciptakan suatu objek Scanner
        Scanner masukan = new Scanner(System.in);

        // Meminta pengguna untuk mengentri nama
        System.out.print("Siapa nama anda? ");
        String nama = masukan.nextLine();

        // Tampilkan hasil
        System.out.println("Salam kenal, " + nama + ". Ayo belajar Java bareng!");
        // Menutup scanner
        masukan.close();
    }
}

package driver;

import java.util.ArrayList;
import java.util.Scanner;

import model.Model2;

public class Driver2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        // Menggunakan ArrayList untuk menyimpan deretan objek Model2
        ArrayList<Model2> daftarStokBarang = new ArrayList<>();

        System.out.println("========================================");
        System.out.println("          SISTEM PENDATAAN STOK         ");
        System.out.println("========================================");

        try {
            // 1. Input Jumlah Data (N)
            System.out.print("1. Jumlah total data (N): ");
            int n = scanner.nextInt();
            
            if (n <= 0) {
                System.out.println("Jumlah data harus lebih dari 0.");
                return;
            }

            // Inisialisasi array sementara untuk menampung input sebaris
            int[] deretStok = new int[n];
            String[] deretKode = new String[n];

            // 2. Input Deret Stok
            System.out.print("2. Deret stok (" + n + " data, pisahkan dengan spasi): ");
            for (int i = 0; i < n; i++) {
                deretStok[i] = scanner.nextInt();
            }

            // 3. Input Kode Kategori Barang
            System.out.println("\n   (Petunjuk Kode: DS=Dasi SD, GL=Gula, RP=Rok Pramuka, MY=Minyak)");
            System.out.print("3. Kode kategori barang (" + n + " data, pisahkan dengan spasi): ");
            for (int i = 0; i < n; i++) {
                deretKode[i] = scanner.next();
            }

            // Menerapkan OOP: Membuat instance dari setiap data dan memasukkannya ke ArrayList
            for (int i = 0; i < n; i++) {
                Model2 barang = new Model2(deretKode[i], deretStok[i]);
                daftarStokBarang.add(barang);
            }

            // Menampilkan Output sesuai input
            System.out.println("\n========================================");
            System.out.println("            HASIL TOTAL STOK            ");
            System.out.println("========================================");
            
            int totalKeseluruhan = 0;
            for (Model2 item : daftarStokBarang) {
                item.cetakInfo(); // Memanggil method dari Model2
                totalKeseluruhan += item.getStok();
            }
            
            System.out.println("----------------------------------------");
            System.out.println("Total keseluruhan item: " + totalKeseluruhan + " pcs");
            System.out.println("========================================");

        } catch (Exception e) {
            System.out.println("\nTerjadi kesalahan input. Pastikan deret stok berupa angka.");
        } finally {
            scanner.close(); // Mencegah memory leak
        }
	}
}
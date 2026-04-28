package driver;

import java.util.Scanner;

import model.Model3;

public class Driver3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        Model3 kafetaria = new Model3();

        // Mengisi stok awal Kafetaria IT Del
        kafetaria.tambahMenu("Nasi Goreng", true);
        kafetaria.tambahMenu("Mie Gomak", true);
        kafetaria.tambahMenu("Ayam Geprek", false); // Contoh menu yang sedang kosong

        System.out.println("=== Selamat Datang di Sistem Pemesanan Kafetaria IT Del ===");
        
        // Meminta input dari pengguna
        System.out.print("Nama Pelanggan  : ");
        String nama = input.nextLine();

        System.out.print("Tanggal (DD/MM) : ");
        String tanggal = input.nextLine();

        System.out.print("Jumlah Pesanan  : ");
        int jumlah = input.nextInt();
        input.nextLine(); // Consume newline character

        System.out.print("Pesanan         : ");
        String pesanan = input.nextLine();

        System.out.println("\n--- Memproses Permintaan ---");

        // Alur logika sesuai permintaan
        if (kafetaria.cekKetersediaan(pesanan)) {
            System.out.println("Status: Makanan '" + pesanan + "' tersedia.");
            // 1. Makanan ada -> Catat pesanan
            kafetaria.catatPesanan(nama, tanggal, jumlah, pesanan);
            
            // Simulasi proses memasak...
            System.out.println("... Sedang menyiapkan makanan ...");
            
            // 2. Jika pesanan sudah siap -> Beri notifikasi
            kafetaria.notifikasiSiap(nama);
        } else {
            // 3. Makanan tidak ada -> Batal membeli
            System.out.println("Status: Maaf, '" + pesanan + "' sedang tidak tersedia. Pemesanan dibatalkan.");
        }

        System.out.println("===========================================================");
        input.close();
	}
}

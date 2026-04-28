package driver;

import model.Model1;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver1 {
// Menggunakan Class biasa untuk entitas Kota sesuai konsep OOP
    static class Kota {
        String kode;
        String nama;
        double ongkos;
        String keterangan;

        public Kota(String kode, String nama, double ongkos, String keterangan) {
            this.kode = kode;
            this.nama = nama;
            this.ongkos = ongkos;
            this.keterangan = keterangan;
        }
    }

    public static void main(String[] args) {
        // Menyimpan data kota ke dalam ArrayList
        ArrayList<Kota> databaseKota = new ArrayList<>();
        databaseKota.add(new Kota("MDN", "Medan", 8000, "Dalam Pulau"));
        databaseKota.add(new Kota("BLG", "Balige", 5000, "Dalam Pulau"));
        databaseKota.add(new Kota("JKT", "Jakarta", 12000, "Luar Pulau"));
        databaseKota.add(new Kota("SBY", "Surabaya", 13000, "Luar Pulau"));

        Scanner scanner = new Scanner(System.in);
        // Menggunakan huruf kapital 'M' untuk Model1
        ArrayList<Model1> daftarTransaksi = new ArrayList<>();

        System.out.println("=== Sistem Otomatis Del-Express ===");
    
        while (true) {
            System.out.print("Kode Kota Tujuan: ");
            String inputKode = scanner.nextLine().trim();

            if (inputKode.equals("---") || inputKode.equalsIgnoreCase("END")) {
                break;
            }

            // Mencari kota di dalam ArrayList (Case Insensitive)
            Kota kotaTujuan = null;
            for (Kota k : databaseKota) {
                if (k.kode.equalsIgnoreCase(inputKode)) {
                    kotaTujuan = k;
                    break;
                }
            }

            if (kotaTujuan == null) {
                System.out.println("[!] Error: Kode kota tidak ditemukan! Silakan masukkan kode yang valid.\n");
                continue;
            }

            System.out.print("Berat Paket (kg): ");
            String inputBerat = scanner.nextLine().trim();
            double beratButet = 0;

            try {
                beratButet = Double.parseDouble(inputBerat);
                if (beratButet <= 0) {
                    System.out.println("[!] Error: Berat paket harus lebih besar dari 0!\n");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("[!] Error: Input berat harus berupa angka!\n");
                continue;
            }

            // Memanggil Model1 (Pastikan Model1.java menggunakan nama class dan konstruktor Model1)
            Model1 transaksiBaru = new Model1(
                kotaTujuan.kode, 
                kotaTujuan.nama, 
                kotaTujuan.ongkos, 
                kotaTujuan.keterangan, 
                beratButet
            );
            
            daftarTransaksi.add(transaksiBaru);
            System.out.println("> Data berhasil ditambahkan ke keranjang.\n");
        }

        System.out.println("\nMemproses semua struk pembayaran...\n");
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Tidak ada transaksi yang diproses.");
        } else {
            // Looping untuk cetak struk
            for (Model1 trx : daftarTransaksi) {
                trx.cetakStruk();
            }
        }
        
        scanner.close();
    }
}
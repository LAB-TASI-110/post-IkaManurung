package model;

import java.util.ArrayList;

    class Makanan {
    private String nama;
    private boolean tersedia;

    public Makanan(String nama, boolean tersedia) {
        this.nama = nama;
        this.tersedia = tersedia;
    }

    public String getNama() {
        return nama;
    }

    public boolean isTersedia() {
        return tersedia;
    }
}

// Class untuk merepresentasikan data Pesanan
class Pesanan {
    private String namaPelanggan;
    private String tanggal;
    private int jumlah;
    private String namaPesanan;

    public Pesanan(String namaPelanggan, String tanggal, int jumlah, String namaPesanan) {
        this.namaPelanggan = namaPelanggan;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.namaPesanan = namaPesanan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }
}


public class Model3 {
	private ArrayList<Makanan> daftarMenu;
    private ArrayList<Pesanan> daftarPesanan;

    public Model3() {
        daftarMenu = new ArrayList<>();
        daftarPesanan = new ArrayList<>();
    }

    // Method untuk menambahkan menu ke sistem
    public void tambahMenu(String nama, boolean tersedia) {
        daftarMenu.add(new Makanan(nama, tersedia));
    }

    // Method untuk mengecek apakah makanan tersedia
    public boolean cekKetersediaan(String namaMakanan) {
        for (Makanan m : daftarMenu) {
            if (m.getNama().equalsIgnoreCase(namaMakanan) && m.isTersedia()) {
                return true;
            }
        }
        return false;
    }

    // Method untuk mencatat pesanan pelanggan
    public void catatPesanan(String namaPelanggan, String tanggal, int jumlah, String namaPesanan) {
        Pesanan pesananBaru = new Pesanan(namaPelanggan, tanggal, jumlah, namaPesanan);
        daftarPesanan.add(pesananBaru);
        System.out.println("Sistem: Pesanan atas nama " + namaPelanggan + " berhasil dicatat oleh penjual.");
    }

    // Method untuk memberitahu pesanan siap
    public void notifikasiSiap(String namaPelanggan) {
        System.out.println("Sistem: Makanan untuk " + namaPelanggan + " telah siap, silahkan diambil.");
    }
}

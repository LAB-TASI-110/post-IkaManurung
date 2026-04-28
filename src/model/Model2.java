package model;

public class Model2 {
	private String kodeKategori;
    private int stok;
    private String namaBarang;

    // Constructor untuk inisialisasi objek
    public Model2(String kodeKategori, int stok) {
        this.kodeKategori = kodeKategori;
        this.stok = stok;
        // Penentuan nama barang otomatis berdasarkan kode saat objek dibuat
        this.namaBarang = tentukanNamaBarang(kodeKategori);
    }

    // Getter dan Setter (Encapsulation)
    public String getKodeKategori() {
        return kodeKategori;
    }

    public void setKodeKategori(String kodeKategori) {
        this.kodeKategori = kodeKategori;
        this.namaBarang = tentukanNamaBarang(kodeKategori); // Update nama jika kode diubah
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    // Method private menggunakan Switch Expression (Fitur Java JDK 14+)
    private String tentukanNamaBarang(String kode) {
        return switch (kode.toUpperCase()) {
            case "DS" -> "dasi sd";
            case "GL" -> "gula";
            case "RP" -> "rok pramuka";
            case "MY" -> "minyak";
            default -> "barang tidak diketahui (" + kode + ")";
        };
    }

    // Method untuk menampilkan informasi stok barang
    public void cetakInfo() {
        System.out.println("- " + namaBarang + " sebanyak " + stok + "pcs");
    }
}

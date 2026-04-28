package model;

public class Model1 {
	private String kodeKota;
    private String namaKota;
    private double tarifPerKg;
    private String keteranganPulau;
    
    private double beratButet;
    private double beratUcok;
    private double totalBerat;
    private double totalOngkir;
    private String infoPromo;

    // Constructor untuk inisialisasi objek transaksi
    public Model1 (String kodeKota, String namaKota, double tarifPerKg, String keteranganPulau, double beratButet) {
        this.kodeKota = kodeKota;
        this.namaKota = namaKota;
        this.tarifPerKg = tarifPerKg;
        this.keteranganPulau = keteranganPulau;
        
        this.beratButet = beratButet;
        // Berat paket Ucok adalah 3/2 (1.5) dari berat paket Butet
        this.beratUcok = 1.5 * beratButet; 
        this.totalBerat = this.beratButet + this.beratUcok;
        
        kalkulasiOngkirDanPromo();
    }
    
    // Method private (OOP: Encapsulation) untuk menghitung biaya
    private void kalkulasiOngkirDanPromo() {
        double hargaDasar = this.totalBerat * this.tarifPerKg;
        StringBuilder promoBuilder = new StringBuilder();
        
        // Cek Promo Lebaran: Berat > 10kg dapat diskon 10%
        if (this.totalBerat > 10.0) {
            hargaDasar = hargaDasar - (hargaDasar * 0.10);
            promoBuilder.append("- Diskon Ongkir 10%\n");
        }
        
        // Cek Promo Luar Pulau: Asuransi Gratis
        if (this.keteranganPulau.equalsIgnoreCase("Luar Pulau")) {
            promoBuilder.append("- Asuransi Gratis\n");
        }
        
        if (promoBuilder.isEmpty()) {
            promoBuilder.append("- Tidak ada promo\n");
        }
        
        this.infoPromo = promoBuilder.toString();
        this.totalOngkir = hargaDasar;
    }

    // Method untuk mencetak struk
    public void cetakStruk() {
        System.out.println("-------------------------------------------------");
        System.out.println("STRUK PEMBAYARAN DEL-EXPRESS");
        System.out.println("-------------------------------------------------");
        System.out.println("Kota Tujuan        : " + this.namaKota + " (" + this.keteranganPulau + ")");
        System.out.println("Berat Paket Butet  : " + this.beratButet + " kg");
        System.out.println("Berat Paket Ucok   : " + this.beratUcok + " kg");
        System.out.println("Total Berat        : " + this.totalBerat + " kg");
        System.out.println("Total Ongkos Kirim : Rp " + String.format("%.2f", this.totalOngkir));
        System.out.print("Promo Diperoleh    :\n" + this.infoPromo);
        System.out.println("-------------------------------------------------\n");
    }
}

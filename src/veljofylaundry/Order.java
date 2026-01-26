/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veljofylaundry;

/**
 *
 * @author FINAFAIZA
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private String kodePesanan;
    private String namaCustomer;
    private String jenisLayanan;       // kiloan / satuan
    private String jenisPengerjaan;    // cuci / cuci + setrika
    private String estimasiWaktu;      // 1 jam / 5 jam / besok
    private String metodePengambilan;  // diantar / ambil sendiri
    private String metodePembayaran;   // tunai / transfer
    private double beratAtauJumlah;    // kiloan = kg, satuan = 1
    private double totalHarga;
    private String status;
    private LocalDateTime tanggalTransaksi;

    public Order(String kodePesanan, String namaCustomer, String jenisLayanan, String jenisPengerjaan,
                String estimasiWaktu, String metodePengambilan, String metodePembayaran,
                double beratAtauJumlah, double totalHarga) {
        this.kodePesanan = kodePesanan;
        this.namaCustomer = namaCustomer;
        this.jenisLayanan = jenisLayanan;
        this.jenisPengerjaan = jenisPengerjaan;
        this.estimasiWaktu = estimasiWaktu;
        this.metodePengambilan = metodePengambilan;
        this.metodePembayaran = metodePembayaran;
        this.beratAtauJumlah = beratAtauJumlah;
        this.totalHarga = totalHarga;
        this.status = "Dalam Proses";
        this.tanggalTransaksi = LocalDateTime.now();
    }

    public String getKodePesanan() {
        return kodePesanan;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void cetakStruk() {
        System.out.println("\n======= STRUK PESANAN =====================");
        System.out.println("Kode Pesanan        : " + kodePesanan);
        System.out.println("Nama Customer       : " + namaCustomer);
        System.out.println("Jenis Layanan       : " + jenisLayanan);
        System.out.println("Jenis Pengerjaan    : " + jenisPengerjaan);
        System.out.println("Estimasi Waktu      : " + estimasiWaktu);
        System.out.println("Metode Pengambilan  : " + metodePengambilan);
        System.out.println("Metode Pembayaran   : " + metodePembayaran);
        System.out.println("Jumlah/Kg           : " + beratAtauJumlah);
        System.out.println("Total Harga         : Rp " + totalHarga);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
        System.out.println("Tanggal Transaksi   : " + tanggalTransaksi.format(formatter));
        System.out.println("Status              : " + status);
        System.out.println("==========================================\n");
    }

    public String getNamaCustomer() {
        return namaCustomer;        
    }

    public String getJenisLayanan() {
        return jenisLayanan;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

}

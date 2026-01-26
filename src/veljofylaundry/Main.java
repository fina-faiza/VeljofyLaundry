/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veljofylaundry;

/**
 *
 * @author FINAFAIZA
 */
public class Main {
    static OrderManager manager = new OrderManager();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("====== Selamat Datang di Veljofy Laundry ======");
            System.out.println("1. Buat Pesanan Baru");
            System.out.println("2. Cek Status Pesanan");
            System.out.println("3. Tampilkan Semua Pesanan (Admin)");
            System.out.println("4. Ubah Status Pesanan (Admin)");
            System.out.println("5. Tampilkan Ringkasan Transaksi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            String pilihan = Utils.scanner.nextLine();

            switch (pilihan) {
                case "1" -> buatPesanan();
                case "2" -> cekStatus();
                case "3" -> manager.tampilkanSemuaPesanan();
                case "4" -> ubahStatusPesanan();
                case "5" -> manager.tampilkanRingkasan();
                case "6" -> running = false;
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
        System.out.println("Program selesai. Terima kasih!");
    }

    public static void buatPesanan() {
        System.out.println("\n--- Daftar Harga ---");
        System.out.println("KILOAN:");
        System.out.println(" - Cuci saja       : Rp 5.000 / kg");
        System.out.println(" - Cuci + Setrika  : Rp 7.000 / kg");
        System.out.println("SATUAN:");
        System.out.println(" - Cuci saja       : Rp 8.000 / pcs");
        System.out.println(" - Cuci + Setrika  : Rp 10.000 / pcs\n");

        System.out.println("\n--- Buat Pesanan Baru ---");
        System.out.print("Masukkan nama customer: ");
        String nama = Utils.scanner.nextLine();

        String layanan = Utils.inputPilihan("Pilih layanan (kiloan/satuan): ", new String[]{"kiloan", "satuan"});
        String pengerjaan = Utils.inputPilihan("Jenis pengerjaan (cuci / cuci+setrika): ", new String[]{"cuci", "cuci+setrika"});
        String estimasi = Utils.inputPilihan("Estimasi selesai (1jam / 5jam / besok): ", new String[]{"1jam", "5jam", "besok"});
        String pengambilan = Utils.inputPilihan("Pengambilan (ambil / antar): ", new String[]{"ambil", "antar"});
        String pembayaran = Utils.inputPilihan("Pembayaran (tunai / transfer): ", new String[]{"tunai", "transfer"});

        double jumlah = layanan.equals("kiloan") ?
                Utils.inputDouble("Masukkan berat (kg): ") :
                1.0; // satuan: 1 item = 1 pesanan

        double hargaPerUnit = 0;
        if (layanan.equals("kiloan")) {
            hargaPerUnit = pengerjaan.equals("cuci+setrika") ? 7000 : 5000;
        } else {
            hargaPerUnit = pengerjaan.equals("cuci+setrika") ? 10000 : 8000;
        }

        double total = jumlah * hargaPerUnit;
        String kode = Utils.generateKodePesanan();

        Order order = new Order(kode, nama, layanan, pengerjaan, estimasi, pengambilan, pembayaran, jumlah, total);
        manager.tambahPesanan(order);
        order.cetakStruk();
    }

    public static void cekStatus() {
        System.out.print("Masukkan kode pesanan: ");
        String kode = Utils.scanner.nextLine();
        Order o = manager.cariPesananByKode(kode);
        if (o != null) {
            o.cetakStruk();
        } else {
            System.out.println("Pesanan tidak ditemukan.");
        }
    }

    public static void ubahStatusPesanan() {
        System.out.print("Masukkan kode pesanan: ");
        String kode = Utils.scanner.nextLine();
        Order o = manager.cariPesananByKode(kode);
        if (o != null) {
            System.out.print("Masukkan status baru (Dalam Proses / Selesai / Diambil): ");
            String status = Utils.scanner.nextLine();
            o.setStatus(status);
            System.out.println("Status berhasil diubah.");
        } else {
            System.out.println("Pesanan tidak ditemukan.");
        }
    }
}


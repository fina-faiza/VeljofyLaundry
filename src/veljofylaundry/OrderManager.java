/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veljofylaundry;

/**
 *
 * @author FINAFAIZA
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderManager {
    private List<Order> pesananList = new ArrayList<>();

    public void tambahPesanan(Order order) {
        pesananList.add(order);
    }

    public void tampilkanSemuaPesanan() {
        if (pesananList.isEmpty()) {
            System.out.println("Belum ada pesanan.");
            return;
        }
        for (Order order : pesananList) {
            order.cetakStruk();
        }
    }

    public Order cariPesananByKode(String kode) {
        for (Order o : pesananList) {
            if (o.getKodePesanan().equalsIgnoreCase(kode)) {
                return o;
            }
        }
        return null;
    }

    public void tampilkanRingkasan() {
    int totalPesanan = pesananList.size();
    double totalPemasukan = 0;
    int kiloan = 0;
    int satuan = 0;
    int selesai = 0;
    int belumSelesai = 0;

    Set<String> pelangganUnik = new HashSet<>();

    for (Order o : pesananList) {
        totalPemasukan += o.getTotalHarga();
        if (o.getJenisLayanan().equalsIgnoreCase("kiloan")) kiloan++;
        else if (o.getJenisLayanan().equalsIgnoreCase("satuan")) satuan++;

        if (o.getStatus().equalsIgnoreCase("selesai")) selesai++;
        else belumSelesai++;

        pelangganUnik.add(o.getNamaCustomer());
    }

    System.out.println("\n===== RINGKASAN TRANSAKSI =====");
    System.out.println("Total transaksi     : " + totalPesanan + " pesanan");
    System.out.println("Total pemasukan     : Rp " + (int) totalPemasukan);
    System.out.println("Pelanggan unik      : " + pelangganUnik.size() + " orang");
    System.out.println("Jumlah kiloan       : " + kiloan + " pesanan");
    System.out.println("Jumlah satuan       : " + satuan + " pesanan");
    System.out.println("Transaksi selesai   : " + selesai + " pesanan");
    System.out.println("Transaksi belum     : " + belumSelesai + " pesanan\n");
}

}


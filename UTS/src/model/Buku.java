// model/Buku.java
package model;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Buku extends ItemPerpustakaan {
    private double harga;
    private JenisBuku jenisBuku;
    private int stok;
    private static final DecimalFormat df = new DecimalFormat("#,###");

    // Konstruktor utama
    public Buku(String judul, String penulis, int tahunTerbit, double harga, JenisBuku jenisBuku, int stok) {
        super(judul, penulis, tahunTerbit);
        this.harga = harga;
        this.jenisBuku = jenisBuku;
        this.stok = stok;
    }

    // Konstruktor overload (judul dan penulis saja)
    public Buku(String judul, String penulis) {
        this(judul, penulis, LocalDate.now().getYear(), 0.0, JenisBuku.LAINNYA, 0);
    }

    public double getHarga() {
        return harga;
    }

    public JenisBuku getJenisBuku() {
        return jenisBuku;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok() {
        if (stok > 0)
            stok--;
    }

    public void tambahStok() {
        stok++;
    }

    // Polimorfisme (override dari abstract class)
    @Override
    public void tampilkanInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        System.out.println("Harga: Rp" + df.format(harga));
        System.out.println("Jenis: " + jenisBuku);
        System.out.println("Stok: " + stok);
        System.out.println("------------------------------------");
    }

    // Method dengan Math + type casting
    public int hitungHargaDiskon(int jumlah) {
        double total = harga * jumlah;
        if (jumlah >= 3) {
            total *= 0.9; // Diskon 10% untuk pembelian ≥ 3
        }
        return (int) Math.round(total); // dibulatkan dan dikonversi ke int
    }
}

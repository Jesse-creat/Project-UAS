// controller/Perpustakaan.java
package controller;

import model.Buku;
import model.ItemPerpustakaan;
import model.JenisBuku;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class Perpustakaan {
    private final List<ItemPerpustakaan> katalog;
    private final List<ItemPerpustakaan> historiPembelian;

    public Perpustakaan() {
        katalog = new ArrayList<>();
        historiPembelian = new ArrayList<>();
    }

    public void tambahItem(ItemPerpustakaan item) {
        katalog.add(item);
    }

    public void tampilkanKatalog() {
        for (ItemPerpustakaan item : katalog) {
            item.tampilkanInfo();
        }
    }

    public void beliBuku(String judul, int jumlah) {
        for (ItemPerpustakaan item : katalog) {
            if (item instanceof Buku && item.getJudul().equalsIgnoreCase(judul)) {
                Buku buku = (Buku) item;
                if (buku.getStok() >= jumlah) {
                    for (int i = 0; i < jumlah; i++) {
                        buku.kurangiStok();
                    }
                    historiPembelian.add(buku);
                    int total = buku.hitungHargaDiskon(jumlah);
                    System.out.println("Total harga setelah diskon: Rp" + total);
                } else {
                    System.out.println("Stok tidak mencukupi!");
                }
                break;
            }
        }
    }

    public void pinjamBuku(String judul) {
        for (ItemPerpustakaan item : katalog) {
            if (item instanceof Buku buku && buku.getJudul().equalsIgnoreCase(judul)) {
                if (buku.getStok() > 0) {
                    buku.kurangiStok();
                    System.out.println("📖 Buku dipinjam: " + judul);
                    return;
                } else {
                    System.out.println("❌ Buku sedang tidak tersedia.");
                    return;
                }
            }
        }
        System.out.println("❌ Buku tidak ditemukan.");
    }

    public void kembalikanBuku(String judul) {
        for (ItemPerpustakaan item : katalog) {
            if (item.getJudul().equalsIgnoreCase(judul) && item instanceof Buku buku) {
                buku.tambahStok();
                System.out.println("Buku dikembalikan: " + buku.getJudul());
                break;
            }
        }
    }

    public void hapusBuku(String judul) {
        katalog.removeIf(item -> item instanceof Buku buku && buku.getJudul().equalsIgnoreCase(judul));
        System.out.println("✅ Buku dihapus (jika ditemukan).");
    }

    public void tampilkanHistoriPembelian() {
        System.out.println("📚 Histori Pembelian:");
        for (ItemPerpustakaan item : historiPembelian) {
            item.tampilkanInfo();
        }
    }

    public void sortByHarga() {
        katalog.sort(Comparator.comparingDouble(item -> ((Buku) item).getHarga()));
        System.out.println("📊 Katalog diurutkan berdasarkan harga.");
    }

    public void sortByTahunTerbit() {
        katalog.sort(Comparator.comparingInt(ItemPerpustakaan::getTahunTerbit));
        System.out.println("📊 Katalog diurutkan berdasarkan tahun terbit.");
    }

    public void sortByJenis() {
        katalog.sort(Comparator.comparing(item -> ((Buku) item).getJenisBuku().toString()));
        System.out.println("📊 Katalog diurutkan berdasarkan jenis.");
    }

    // Statistik jumlah buku berdasarkan jenis (menggunakan array)
    public void tampilkanStatistikJenisBuku() {
        int[] jumlahPerJenis = new int[JenisBuku.values().length];
        for (ItemPerpustakaan item : katalog) {
            if (item instanceof Buku buku) {
                jumlahPerJenis[buku.getJenisBuku().ordinal()]++;
            }
        }
        for (JenisBuku jenis : JenisBuku.values()) {
            System.out.println(jenis + ": " + jumlahPerJenis[jenis.ordinal()] + " buku");
        }
    }

    // Pencarian judul secara rekursif
    public ItemPerpustakaan cariJudulRecursif(String judul, int index) {
        if (index >= katalog.size())
            return null;
        if (katalog.get(index).getJudul().equalsIgnoreCase(judul))
            return katalog.get(index);
        return cariJudulRecursif(judul, index + 1);
    }

    public List<ItemPerpustakaan> getKatalog() {
        return katalog;
    }

}
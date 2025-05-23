// view/SistemPerpustakaan.java
package view;

import controller.Perpustakaan;
import model.Buku;
import model.ItemPerpustakaan;
import model.JenisBuku;

import java.util.Scanner;

public class SistemPerpustakaan {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Perpustakaan perpustakaan = new Perpustakaan();

            // Data awal
            perpustakaan.tambahItem(
                    new Buku("The Subtle Art of Not Giving a F*ck", "Mark Manson", 2016, 110000.0, JenisBuku.EBOOK, 5));
            perpustakaan
                    .tambahItem(new Buku("Algoritma dan Pemrograman dalam Bahasa Pascal dan C", "Rinaldi Munir", 2002,
                            105000.0, JenisBuku.PELAJARAN_INFORMATIKA, 5));

            perpustakaan.tambahItem(new Buku("Naruto", "Masashi Kishimoto", 2000, 50000.0, JenisBuku.KOMIK, 10));
            perpustakaan.tambahItem(new Buku("Bobo", "Redaksi Bobo", 2024, 20000.0, JenisBuku.MAJALAH, 5));

            perpustakaan
                    .tambahItem(new Buku("Dongeng Nusantara", "Faisal Rahman", 2015, 80000.0, JenisBuku.DONGENG, 4));
            perpustakaan.tambahItem(new Buku("Atomic Habits", "James Clear", 2018, 89000.0, JenisBuku.NONFIKSI, 5));

            perpustakaan.tambahItem(
                    new Buku("Soekarno: Biografi Sang Putra Fajar", "Cindy Adams", 1965, 75000.0, JenisBuku.BIOGRAFI,
                            5));
            perpustakaan
                    .tambahItem(new Buku("Indonesia Menggugat", "Ir. Soekarno", 1930, 65000.0, JenisBuku.SEJARAH, 5));

            perpustakaan
                    .tambahItem(new Buku("Bumi Manusia", "Pramoedya Ananta Toer", 1980, 98000.0, JenisBuku.NOVEL, 5));
            perpustakaan.tambahItem(
                    new Buku("Digital Photography Masterclass", "Tom Ang", 2008, 98000.0, JenisBuku.FOTOGRAFI, 5));

            perpustakaan.tambahItem(new Buku("Nusantara Bertutur: Asal Usul Danau Toba", "Tim Nusantara Bertutur", 2015,
                    47000.0, JenisBuku.CERGAM, 5));
            perpustakaan.tambahItem(new Buku("Kancil dan Buaya", "R.M. Ardisoma", 1980, 37000.0, JenisBuku.FABEL, 5));

            perpustakaan.tambahItem(new Buku("Malam Terakhir", "Leila S. Chudori", 1989, 69000.0, JenisBuku.CERPEN, 5));
            perpustakaan.tambahItem(
                    new Buku("Si Juki: Kisah Kusut Dunia Kartun", "Faza Meonk", 2013, 42000.0, JenisBuku.KOMIK, 5));

            perpustakaan.tambahItem(new Buku("Majalah Teknologi", "Redaksi IT", 2022, 45000.0, JenisBuku.MAJALAH, 6));
            perpustakaan.tambahItem(
                    new Buku("Sejarah Nasional Indonesia", "Dr. Sartono Kartodirdjo", 1975, 90000.0, JenisBuku.SEJARAH,
                            5));

            perpustakaan.tambahItem(new Buku("Habibie & Ainun", "B.J. Habibie", 2010, 88000.0, JenisBuku.BIOGRAFI, 5));
            perpustakaan.tambahItem(
                    new Buku("Cerpen Pilihan Kompas 2019", "Berbagai Penulis", 2019, 95000.0, JenisBuku.CERPEN, 5));

            perpustakaan
                    .tambahItem(new Buku("Supernova: Kesatria, Puteri, dan Bintang Jatuh", "Dewi Lestari (Dee)", 2001,
                            72000.0, JenisBuku.NOVEL, 5));
            perpustakaan.tambahItem(
                    new Buku("Understanding Exposure", "Bryan Peterson", 1990, 67000.0, JenisBuku.FOTOGRAFI, 5));

            perpustakaan
                    .tambahItem(
                            new Buku("Kumpulan Dongeng Nusantara", "Evi Shelvia", 2010, 55000.0, JenisBuku.DONGENG, 5));
            perpustakaan.tambahItem(
                    new Buku("Dongeng Binatang Terpopuler", "Grimm Brothers", 2012, 62000.0, JenisBuku.FABEL, 5));

            perpustakaan.tambahItem(new Buku("The Art of War", "Sun Tzu", -500, 33000.0, JenisBuku.EBOOK, 5));
            perpustakaan
                    .tambahItem(new Buku("Sejarah Indonesia", "Anis Baswedan", 2010, 150000.0, JenisBuku.SEJARAH, 5));

            perpustakaan
                    .tambahItem(
                            new Buku("Gundala: Takdir", "Harya Suraminata (Hasmi)", 1969, 33000.0, JenisBuku.KOMIK, 5));
            perpustakaan.tambahItem(new Buku("Pengantar Teknologi Informasi", "Jogiyanto Hartono", 2005, 82000.0,
                    JenisBuku.PELAJARAN_INFORMATIKA, 5));

            perpustakaan.tambahItem(new Buku("National Geographic Indonesia", "Redaksi NatGeo Indonesia", 2024, 35000.0,
                    JenisBuku.MAJALAH, 5));
            perpustakaan.tambahItem(new Buku("Cerita Rakyat dari Sabang sampai Merauke", "Yudhistira Ikranegara", 2008,
                    48000.0, JenisBuku.DONGENG, 5));

            perpustakaan
                    .tambahItem(new Buku("Biografi Einstein", "Walter Isaacson", 2008, 17000.0, JenisBuku.BIOGRAFI, 3));
            perpustakaan
                    .tambahItem(new Buku("Si Kancil dan Buaya", "R.M. Ardisoma", 1980, 39000.0, JenisBuku.CERGAM, 5));

            perpustakaan
                    .tambahItem(new Buku("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 2011, 99000.0,
                            JenisBuku.NONFIKSI, 5));

            int pilihan;
            do {
                System.out.println("\n===== LIBRARY & BOOK STORE (Console) =====");
                System.out.println("1. Tampilkan Katalog");
                System.out.println("2. Tambah Buku");
                System.out.println("3. Beli Buku");
                System.out.println("4. Pinjam Buku");
                System.out.println("5. Kembalikan Buku");
                System.out.println("6. Hapus Buku");
                System.out.println("7. Lihat Histori Pembelian");
                System.out.println("8. Urutkan Buku Berdasarkan Harga");
                System.out.println("9. Urutkan Buku Berdasarkan Tahun Terbit");
                System.out.println("10. Urutkan Buku Berdasarkan Jenis");
                System.out.println("11. Statistik Buku per Jenis");
                System.out.println("12. Cari Judul (Rekursif)");
                System.out.println("0. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> perpustakaan.tampilkanKatalog();
                    case 2 -> {
                        System.out.print("Judul: ");
                        String judul = scanner.nextLine();
                        System.out.print("Penulis: ");
                        String penulis = scanner.nextLine();
                        System.out.print("Tahun: ");
                        int tahun = scanner.nextInt();
                        System.out.print("Harga: ");
                        double harga = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Jenis (NOVEL/KOMIK/DLL): ");
                        String jenis = scanner.nextLine();
                        System.out.print("Stok: ");
                        int stok = scanner.nextInt();

                        try {
                            JenisBuku jenisBuku = JenisBuku.valueOf(jenis.toUpperCase());
                            perpustakaan.tambahItem(new Buku(judul, penulis, tahun, harga, jenisBuku, stok));
                        } catch (IllegalArgumentException e) {
                            System.out.println("❌ Jenis buku tidak valid.");
                        }
                    }
                    case 3 -> {
                        System.out.print("Judul Buku: ");
                        String judul = scanner.nextLine();
                        System.out.print("Jumlah: ");
                        int jumlah = scanner.nextInt();
                        perpustakaan.beliBuku(judul, jumlah);
                    }
                    case 4 -> {
                        System.out.print("Judul buku yang ingin dipinjam: ");
                        String judul = scanner.nextLine();
                        perpustakaan.pinjamBuku(judul);
                    }
                    case 5 -> {
                        System.out.print("Judul buku yang ingin dikembalikan: ");
                        String judul = scanner.nextLine();
                        perpustakaan.kembalikanBuku(judul);
                    }
                    case 6 -> {
                        System.out.print("Judul buku yang ingin dihapus: ");
                        String judul = scanner.nextLine();
                        perpustakaan.hapusBuku(judul);
                    }
                    case 7 -> perpustakaan.tampilkanHistoriPembelian();
                    case 8 -> perpustakaan.sortByHarga();
                    case 9 -> perpustakaan.sortByTahunTerbit();
                    case 10 -> perpustakaan.sortByJenis();
                    case 11 -> perpustakaan.tampilkanStatistikJenisBuku();
                    case 12 -> {
                        System.out.print("Masukkan judul yang dicari: ");
                        String target = scanner.nextLine();
                        ItemPerpustakaan hasil = perpustakaan.cariJudulRecursif(target, 0);
                        if (hasil != null)
                            hasil.tampilkanInfo();
                        else
                            System.out.println("⚠️ Buku tidak ditemukan.");
                    }
                    case 0 -> System.out.println("👋 Terima kasih telah menggunakan sistem ini.");
                    default -> System.out.println("❗ Pilihan tidak valid!");
                }
            } while (pilihan != 0);
        }
    }
}

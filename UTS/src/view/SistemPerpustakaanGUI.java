// view/SistemPerpustakaanGUI.java //
package view;

import controller.Perpustakaan;
import model.BeliTransaksi;
import model.Buku;
import model.ItemPerpustakaan;
import model.JenisBuku;
import model.Transaksi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SistemPerpustakaanGUI extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private Perpustakaan perpustakaan;

    @SuppressWarnings("unused")
    public SistemPerpustakaanGUI() {
        setTitle("Library & Book Store");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        perpustakaan = new Perpustakaan();

        String[] columnNames = { "Judul", "Penulis", "Tahun", "Harga", "Jenis", "Stok" };
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton btnTambah = new JButton("Tambah Buku");
        JButton btnBeli = new JButton("Beli Buku");
        JButton btnPinjam = new JButton("Pinjam Buku");
        JButton btnKembalikan = new JButton("Kembalikan Buku");
        JButton btnLHB = new JButton("Lihat Histori Pembelian");
        JButton btnUBBH = new JButton("Urutkan Buku Berdasarkan Harga");
        JButton btnUBBTT = new JButton("Urutkan Buku Berdasarkan Tahun Terbit");
        JButton btnUBBJ = new JButton("Urutkan Buku Berdasarkan Jenis");
        JButton btnStatistik = new JButton("Statistik Jenis");
        JButton btnCJ = new JButton("Cari Judul (Rekursif)");
        JButton btnKeluar = new JButton("Keluar");
        panel.add(btnTambah);
        panel.add(btnBeli);
        panel.add(btnPinjam);
        panel.add(btnKembalikan);
        panel.add(btnLHB);
        panel.add(btnUBBH);
        panel.add(btnUBBTT);
        panel.add(btnUBBJ);
        panel.add(btnStatistik);
        panel.add(btnCJ);
        panel.add(btnKeluar);
        add(panel, BorderLayout.SOUTH);

        btnTambah.addActionListener(this::tambahBuku);
        btnBeli.addActionListener(this::beliBuku);
        btnPinjam.addActionListener(this::pinjamBuku);
        btnKembalikan.addActionListener(this::kembalikanBuku);
        btnLHB.addActionListener(e -> perpustakaan.tampilkanHistoriPembelian());
        btnUBBH.addActionListener(e -> {
            perpustakaan.sortByHarga();
            updateTable();
        });
        btnUBBTT.addActionListener(e -> {
            perpustakaan.sortByTahunTerbit();
            updateTable();
        });
        btnUBBJ.addActionListener(e -> {
            perpustakaan.sortByJenis();
            updateTable();
        });
        btnStatistik.addActionListener(e -> perpustakaan.tampilkanStatistikJenisBuku());
        btnCJ.addActionListener(this::cariJudul);
        btnKeluar.addActionListener(e -> {
            int konfirmasi = JOptionPane.showConfirmDialog(
                    this,
                    "Apakah Anda yakin ingin keluar?",
                    "Konfirmasi Keluar",
                    JOptionPane.YES_NO_OPTION);
            if (konfirmasi == JOptionPane.YES_OPTION) {
                System.exit(0); // keluar dari program
            }
        });

        // Data awal
        perpustakaan.tambahItem(
                new Buku("The Subtle Art of Not Giving a F*ck", "Mark Manson", 2016, 110000.0, JenisBuku.EBOOK, 5));
        perpustakaan.tambahItem(new Buku("Algoritma dan Pemrograman dalam Bahasa Pascal dan C", "Rinaldi Munir", 2002,
                105000.0, JenisBuku.PELAJARAN_INFORMATIKA, 5));

        perpustakaan.tambahItem(new Buku("Naruto", "Masashi Kishimoto", 2000, 50000.0, JenisBuku.KOMIK, 10));
        perpustakaan.tambahItem(new Buku("Bobo", "Redaksi Bobo", 2024, 20000.0, JenisBuku.MAJALAH, 5));

        perpustakaan.tambahItem(new Buku("Dongeng Nusantara", "Faisal Rahman", 2015, 80000.0, JenisBuku.DONGENG, 4));
        perpustakaan.tambahItem(new Buku("Atomic Habits", "James Clear", 2018, 89000.0, JenisBuku.NONFIKSI, 5));

        perpustakaan.tambahItem(
                new Buku("Soekarno: Biografi Sang Putra Fajar", "Cindy Adams", 1965, 75000.0, JenisBuku.BIOGRAFI, 5));
        perpustakaan.tambahItem(new Buku("Indonesia Menggugat", "Ir. Soekarno", 1930, 65000.0, JenisBuku.SEJARAH, 5));

        perpustakaan.tambahItem(new Buku("Bumi Manusia", "Pramoedya Ananta Toer", 1980, 98000.0, JenisBuku.NOVEL, 5));
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
                new Buku("Sejarah Nasional Indonesia", "Dr. Sartono Kartodirdjo", 1975, 90000.0, JenisBuku.SEJARAH, 5));

        perpustakaan.tambahItem(new Buku("Habibie & Ainun", "B.J. Habibie", 2010, 88000.0, JenisBuku.BIOGRAFI, 5));
        perpustakaan.tambahItem(
                new Buku("Cerpen Pilihan Kompas 2019", "Berbagai Penulis", 2019, 95000.0, JenisBuku.CERPEN, 5));

        perpustakaan.tambahItem(new Buku("Supernova: Kesatria, Puteri, dan Bintang Jatuh", "Dewi Lestari (Dee)", 2001,
                72000.0, JenisBuku.NOVEL, 5));
        perpustakaan.tambahItem(
                new Buku("Understanding Exposure", "Bryan Peterson", 1990, 67000.0, JenisBuku.FOTOGRAFI, 5));

        perpustakaan
                .tambahItem(new Buku("Kumpulan Dongeng Nusantara", "Evi Shelvia", 2010, 55000.0, JenisBuku.DONGENG, 5));
        perpustakaan.tambahItem(
                new Buku("Dongeng Binatang Terpopuler", "Grimm Brothers", 2012, 62000.0, JenisBuku.FABEL, 5));

        perpustakaan.tambahItem(new Buku("The Art of War", "Sun Tzu", -500, 33000.0, JenisBuku.EBOOK, 5));
        perpustakaan.tambahItem(new Buku("Sejarah Indonesia", "Anis Baswedan", 2010, 150000.0, JenisBuku.SEJARAH, 5));

        perpustakaan
                .tambahItem(new Buku("Gundala: Takdir", "Harya Suraminata (Hasmi)", 1969, 33000.0, JenisBuku.KOMIK, 5));
        perpustakaan.tambahItem(new Buku("Pengantar Teknologi Informasi", "Jogiyanto Hartono", 2005, 82000.0,
                JenisBuku.PELAJARAN_INFORMATIKA, 5));

        perpustakaan.tambahItem(new Buku("National Geographic Indonesia", "Redaksi NatGeo Indonesia", 2024, 35000.0,
                JenisBuku.MAJALAH, 5));
        perpustakaan.tambahItem(new Buku("Cerita Rakyat dari Sabang sampai Merauke", "Yudhistira Ikranegara", 2008,
                48000.0, JenisBuku.DONGENG, 5));

        perpustakaan.tambahItem(new Buku("Biografi Einstein", "Walter Isaacson", 2008, 17000.0, JenisBuku.BIOGRAFI, 3));
        perpustakaan.tambahItem(new Buku("Si Kancil dan Buaya", "R.M. Ardisoma", 1980, 39000.0, JenisBuku.CERGAM, 5));

        perpustakaan.tambahItem(new Buku("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 2011, 99000.0,
                JenisBuku.NONFIKSI, 5));

        updateTable();
    }

    private void updateTable() {
        model.setRowCount(0);
        for (ItemPerpustakaan item : perpustakaan.getKatalog()) {
            if (item instanceof Buku buku) {
                model.addRow(new Object[] {
                        buku.getJudul(),
                        buku.getPenulis(),
                        buku.getTahunTerbit(),
                        buku.getHarga(),
                        buku.getJenisBuku(),
                        buku.getStok()
                });
            }
        }
    }

    private void tambahBuku(ActionEvent e) {
        try {
            String judul = JOptionPane.showInputDialog("Judul:");
            String penulis = JOptionPane.showInputDialog("Penulis:");
            int tahun = Integer.parseInt(JOptionPane.showInputDialog("Tahun Terbit:"));
            double harga = Double.parseDouble(JOptionPane.showInputDialog("Harga:"));
            String jenis = JOptionPane.showInputDialog("Jenis Buku (cth: NOVEL, KOMIK, EBOOK):");
            int stok = Integer.parseInt(JOptionPane.showInputDialog("Stok:"));

            JenisBuku jenisBuku = JenisBuku.valueOf(jenis.toUpperCase());
            perpustakaan.tambahItem(new Buku(judul, penulis, tahun, harga, jenisBuku, stok));
            updateTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "❌ Input tidak valid.");
        }
    }

    private void beliBuku(ActionEvent e) {
        try {
            String judul = JOptionPane.showInputDialog("Judul Buku:");
            int jumlah = Integer.parseInt(JOptionPane.showInputDialog("Jumlah Buku:"));
            Transaksi transaksi = new BeliTransaksi(perpustakaan, judul, jumlah);
            transaksi.proses();
            updateTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "❌ Gagal membeli buku.");
        }
    }

    private void pinjamBuku(ActionEvent e) {
        try {
            String judul = JOptionPane.showInputDialog("Judul Buku yang Ingin Dipinjam:");
            if (judul == null || judul.isBlank())
                return;
            perpustakaan.pinjamBuku(judul);
            updateTable();
            JOptionPane.showMessageDialog(this, "📚 Buku berhasil dipinjam!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "❌ Gagal meminjam buku.");
        }
    }

    private void kembalikanBuku(ActionEvent e) {
        String judul = JOptionPane.showInputDialog("Judul Buku yang Dikembalikan:");
        if (judul == null || judul.isBlank())
            return;
        perpustakaan.kembalikanBuku(judul);
        updateTable();
        JOptionPane.showMessageDialog(this, "✅ Buku berhasil dikembalikan!");
    }

    // Inner class untuk histori
    class HistoriTransaksi {
        private String judul;
        private int jumlah;

        public HistoriTransaksi(String judul, int jumlah) {
            this.judul = judul;
            this.jumlah = jumlah;
        }

        public String getJudul() {
            return judul;
        }

        public int getJumlah() {
            return jumlah;
        }
    }

    private void cariJudul(ActionEvent e) {
        String target = JOptionPane.showInputDialog("Judul Buku yang Dicari:");
        if (target == null || target.isBlank())
            return;

        ItemPerpustakaan hasil = perpustakaan.cariJudulRecursif(target, 0);
        if (hasil != null) {
            JOptionPane.showMessageDialog(this, "✅ Buku ditemukan:\n" + hasil);
        } else {
            JOptionPane.showMessageDialog(this, "❌ Buku tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SistemPerpustakaanGUI().setVisible(true));
    }
}

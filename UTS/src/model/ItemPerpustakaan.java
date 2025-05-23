// model/ItemPerpustakaan.java
package model;

public abstract class ItemPerpustakaan {
    protected String judul;
    protected String penulis;
    protected int tahunTerbit;

    public ItemPerpustakaan(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    // Method abstrak yang harus diimplementasikan oleh subclass
    public abstract void tampilkanInfo();
}

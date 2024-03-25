public class ThriftItem {
    protected String jenis;
    protected String ukuran;
    protected String kategori;

    public ThriftItem(String jenis, String ukuran, String kategori) {
        this.jenis = jenis;
        this.ukuran = ukuran;
        this.kategori = kategori;
    }

    public String getJenis() {
        return jenis;
    }

    public String getUkuran() {
        return ukuran;
    }

    public String getKategori() {
        return kategori;
    }
}

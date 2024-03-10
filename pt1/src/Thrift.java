public class Thrift {
    private String jenis;
    private String ukuran;
    private String kategori;

    Thrift(String jenis, String ukuran, String kategori) {
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

    public void display() {
        System.out.printf("Jenis: %s, Ukuran: %s, Kategori: %s%n", jenis, ukuran, kategori);
    }
}
    

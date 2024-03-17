class Thrift {
    private String jenis;
    private String ukuran;
    private String kategori;

    public Thrift(String jenis, String ukuran, String kategori) {
        this.jenis = jenis;
        this.ukuran = ukuran;
        this.kategori = kategori;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}

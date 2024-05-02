class Clothing extends ThriftItem implements OperasiThrift {
    private String material;

    public Clothing(String jenis, String ukuran, String kategori, String material) {
        super(jenis, ukuran, kategori);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.println("Material: " + material);
    }

    @Override
    public String getDeskripsiDetail() {
        return "Pakaian: Materialnya adalah " + material;
    }

    @Override
    public void perbaruiDetail(String... details) {
        if (details.length > 0) this.material = details[0];
    }
}

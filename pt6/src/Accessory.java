class Accessory extends ThriftItem implements OperasiThrift {
    private String color;

    public Accessory(String jenis, String ukuran, String kategori, String color) {
        super(jenis, ukuran, kategori);
        this.color = color;
    }

    @Override
    public void displayDetails() {
        System.out.println("Warna: " + color);
    }

    @Override
    public String getDeskripsiDetail() {
        return "Aksesoris: Warnanya adalah " + color;
    }

    @Override
    public void perbaruiDetail(String... details) {
        if (details.length > 0) this.color = details[0];
    }
}
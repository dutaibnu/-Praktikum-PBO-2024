class Accessory extends ThriftItem {
    private String color;

    public Accessory(String jenis, String ukuran, String kategori, String color) {
        super(jenis, ukuran, kategori);
        this.color = color;
    }

    @Override
    public void displayDetails() {
        System.out.println("Warna: " + color);
    }
}
public class Accessory extends ThriftItem {
    private String color;

    public Accessory(String jenis, String ukuran, String kategori, String color) {
        super(jenis, ukuran, kategori);
        this.color = color;
    }

    @Override
    public void displayDetails() {
        System.out.printf("%-20s | %-15s | %-20s | Warna: %s%n", jenis, ukuran, kategori, color);
    }
}

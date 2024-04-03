public class Clothing extends ThriftItem {
    private String material;

    public Clothing(String jenis, String ukuran, String kategori, String material) {
        super(jenis, ukuran, kategori);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.printf("%-20s | %-15s | %-20s | Material: %s%n", jenis, ukuran, kategori, material);
    }
}

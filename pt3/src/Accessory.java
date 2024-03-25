public class Accessory extends ThriftItem {
    private String color;

    public Accessory(String jenis, String ukuran, String kategori, String color) {
        super(jenis, ukuran, kategori);
        this.color = color;
    }

    // Getter untuk color
    public String getColor() {
        return color;
    }
}

class Clothing extends ThriftItem {
    private String material;

    public Clothing(String jenis, String ukuran, String kategori, String material) {
        super(jenis, ukuran, kategori);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.println("Material: " + material);
    }
}
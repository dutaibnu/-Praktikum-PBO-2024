import java.io.*;
import java.util.ArrayList;

abstract class ThriftItem {
    private String jenis;
    private String ukuran;
    private String kategori;

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

    public abstract void displayDetails();
}

public class Main {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<ThriftItem> DataThrift = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\nMenu Utama");
                System.out.println("1. Tambah Data");
                System.out.println("2. Tampilkan Data");
                System.out.println("3. Perbarui Data");
                System.out.println("4. Hapus Data");
                System.out.println("5. Keluar");
                System.out.print("Masukkan pilihan >>> ");
                int pilihan = Integer.parseInt(input.readLine());

                switch (pilihan) {
                    case 1:
                        tambahData();
                        break;
                    case 2:
                        displayData();
                        break;
                    case 3:
                        updateData();
                        break;
                    case 4:
                        deleteData();
                        break;
                    case 5:
                        System.out.println("Keluar dari program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak ada. Silakan coba lagi.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            } catch (IOException e) {
                System.out.println("Terjadi kesalahan dalam input/output: " + e.getMessage());
            }
        }
    }
    static void tambahData() throws IOException {
        String lanjut;
        do {
            System.out.println("\nTambah Data");
            System.out.println("Pilih jenis item:");
            System.out.println("1. Pakaian");
            System.out.println("2. Aksesoris");
            System.out.print("Pilihan Anda >>> ");
            int jenisItem = Integer.parseInt(input.readLine());
    
            String jenis = "", ukuran = "", kategori = "", material = "", color = "";
    
            while (jenis.trim().isEmpty()) {
                System.out.print("Masukkan jenis >>> ");
                jenis = input.readLine();
                if (jenis.trim().isEmpty()) {
                    System.out.println("Jenis tidak boleh kosong.");
                }
            }
    
            while (ukuran.trim().isEmpty()) {
                System.out.print("Masukkan ukuran >>> ");
                ukuran = input.readLine();
                if (ukuran.trim().isEmpty()) {
                    System.out.println("Ukuran tidak boleh kosong.");
                }
            }
    
            while (kategori.trim().isEmpty()) {
                System.out.print("Masukkan kategori >>> ");
                kategori = input.readLine();
                if (kategori.trim().isEmpty()) {
                    System.out.println("Kategori tidak boleh kosong.");
                }
            }
    
            ThriftItem item = null;
            switch (jenisItem) {
                case 1:
                    System.out.print("Masukkan material >>> ");
                    material = input.readLine();
                    item = new Clothing(jenis, ukuran, kategori, material);
                    break;
                case 2:
                    System.out.print("Masukkan warna >>> ");
                    color = input.readLine();
                    item = new Accessory(jenis, ukuran, kategori, color);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
    
            if (item != null) {
                DataThrift.add(item);
                System.out.println("Data telah ditambahkan!");
            }
    
            System.out.print("Tambah data lagi? (y/n) >>> ");
            lanjut = input.readLine();
        } while (lanjut.equalsIgnoreCase("y"));
    }

    static void displayData() {
        if (DataThrift.isEmpty()) {
            System.out.println("Tidak ada data untuk ditampilkan.");
            return;
        }
        
        System.out.printf("%-3s | %-20s | %-15s | %-20s%n", "No", "Jenis", "Ukuran", "Kategori");
        System.out.println("-----------------------------------------------------------------");
        
        int nomor = 1;
        for (ThriftItem trf : DataThrift) {
            System.out.printf("%-3d | %-20s | %-15s | %-20s%n", nomor++, trf.getJenis(), trf.getUkuran(), trf.getKategori());
            trf.displayDetails();
        }
    }

    static void updateData() throws IOException {
        if (DataThrift.isEmpty()) {
            System.out.println("Tidak ada data untuk diperbarui.");
            return;
        }
        displayData();
        System.out.print("Masukkan nomor data yang ingin diperbarui: ");
        int index = Integer.parseInt(input.readLine()) - 1;
        
        if (index >= 0 && index < DataThrift.size()) {
            ThriftItem trf = DataThrift.get(index);
            if (trf instanceof OperasiThrift) {
                OperasiThrift operasi = (OperasiThrift) trf;
                System.out.print("Masukkan detail baru >>> ");
                String detail = input.readLine();
                operasi.perbaruiDetail(detail);
                System.out.println("Data berhasil diperbarui: " + operasi.getDeskripsiDetail());
            } else {
                System.out.println("Item ini tidak mendukung operasi perbaruan.");
            }
        } else {
            System.out.println("Nomor data tidak valid.");
        }
    }
    

    static void deleteData() throws IOException {
        if (DataThrift.isEmpty()) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }
        displayData();
        System.out.print("Masukkan nomor data yang ingin dihapus: ");
        int index = Integer.parseInt(input.readLine()) - 1;
        
        if (index >= 0 && index < DataThrift.size()) {
            DataThrift.remove(index);
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Nomor data tidak valid.");
        }
    }
}

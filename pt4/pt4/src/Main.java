import java.io.*;
import java.util.*;

public class Main {
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private static ArrayList<ThriftItem> DataThrift = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("\nMenu Utama");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Update Data");
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
                    System.out.println("Keluar program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak ada. Silakan coba lagi.");
                    break;
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
    }
    
    static void displayData(String kategori) {
        if (DataThrift.isEmpty()) {
            System.out.println("Tidak ada data untuk ditampilkan.");
            return;
        }
        
        System.out.printf("%-3s | %-20s | %-15s | %-20s%n", "No", "Jenis", "Ukuran", "Kategori");
        System.out.println("-----------------------------------------------------------------");
        
        int nomor = 1;
        for (ThriftItem trf : DataThrift) {
            if (trf.getKategori().equalsIgnoreCase(kategori)) {
                System.out.printf("%-3d | %-20s | %-15s | %-20s%n", nomor++, trf.getJenis(), trf.getUkuran(), trf.getKategori());
                trf.displayDetails();
            }
        }
    }
    
    static void updateData() throws IOException {
        if (DataThrift.isEmpty()) {
            System.out.println("Tidak ada data untuk diperbarui.");
            return;
        }
        displayData(); 
        System.out.print("Masukkan nomor data yang ingin diupdate: ");
        int index = Integer.parseInt(input.readLine()) - 1;
        
        if (index >= 0 && index < DataThrift.size()) {
            ThriftItem trf = DataThrift.get(index);
            
            System.out.print("Masukkan jenis baru >>> ");
            String jenis = input.readLine();
            System.out.print("Masukkan ukuran baru >>> ");
            String ukuran = input.readLine();
            System.out.print("Masukkan kategori baru >>> ");
            String kategori = input.readLine();
            
            if (trf instanceof Clothing) {
                System.out.print("Masukkan material baru >>> ");
                String material = input.readLine();
                Clothing updatedItem = new Clothing(jenis, ukuran, kategori, material);
                DataThrift.set(index, updatedItem);
            } else if (trf instanceof Accessory) {
                System.out.print("Masukkan warna baru >>> ");
                String color = input.readLine();
                Accessory updatedItem = new Accessory(jenis, ukuran, kategori, color);
                DataThrift.set(index, updatedItem);
            }
            System.out.println("Data berhasil diupdate.");
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

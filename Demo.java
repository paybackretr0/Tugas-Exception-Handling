import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nomor faktur: ");
        String nomorFaktur = scanner.nextLine();

        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = scanner.nextLine();
        Pelanggan pelanggan = new Pelanggan(namaPelanggan);

        System.out.print("Masukkan jumlah barang yang ingin dibeli: ");
        int jumlahBarang = scanner.nextInt();
        Barang[] barang = new Barang[jumlahBarang];

        for (int i = 0; i < jumlahBarang; i++) {
            scanner.nextLine();

            System.out.println("\nBarang ke-" + (i + 1));
            System.out.print("Nama barang: ");
            String namaBarang = scanner.nextLine();
            System.out.print("Harga barang: ");
            double hargaBarang = scanner.nextDouble();
            System.out.print("Jumlah barang: ");
            int jumlah = scanner.nextInt();
            System.out.print("Diskon barang (%): ");
            double diskonBarang = scanner.nextDouble();

            barang[i] = new BarangDiskon(namaBarang, hargaBarang, jumlah, diskonBarang);
        }

        Transaksi transaksi = new Transaksi(barang, pelanggan, nomorFaktur);

        System.out.println("\nDetail Transaksi:");
        System.out.println("Nomor Faktur: " + transaksi.getNomorFaktur());
        System.out.println("Nama Pelanggan: " + transaksi.getPelanggan().getNama());
        for (int i = 0; i < jumlahBarang; i++) {
            Barang item = (Barang) transaksi.barang[i];
            System.out.println("Barang ke-" + (i + 1) + ": " + item.getNama() + " (Total Harga: " + item.getHarga()
                    + ", Jumlah: " + item.getJumlah() + ")");
        }
        System.out.println("Total Bayar: " + transaksi.getTotalBayar());

        scanner.close();
    }
}
class BarangDiskon extends Barang {
    private double diskon;

    public BarangDiskon(String nama, double harga, int jumlah, double diskon) {
        super(nama, harga, jumlah); // Memanggil konstruktor kelas induk Barang
        this.diskon = diskon;
    }

    public double getTotalSetelahDiskon() {
        double totalSebelumDiskon = super.getHarga(); // Mengambil harga dari kelas induk
        double potongan = totalSebelumDiskon * (diskon / 100);
        return totalSebelumDiskon - potongan;
    }
}

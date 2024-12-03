import entities.Mahasiswi;  // Mengimpor class Mahasiswi
import entities.Slip;       // Mengimpor class Slip
import views.MahasiswiSlipTerminalViewImpl; // Mengimpor kelas view yang sudah diimplementasikan

import java.util.ArrayList; // Untuk ArrayList yang menyimpan Mahasiswi dan Slip

public class Main {
    public static void main(String[] args) {
        // Membuat daftar Mahasiswi dan Slip kosong
        ArrayList<Mahasiswi> daftarMahasiswi = new ArrayList<>();
        ArrayList<Slip> daftarSlip = new ArrayList<>();

        // Membuat objek MahasiswiSlipTerminalViewImpl
        MahasiswiSlipTerminalViewImpl view = new MahasiswiSlipTerminalViewImpl(daftarMahasiswi, daftarSlip);

        // Menjalankan menu utama
        view.jalankanMenuUtama();
    }
}

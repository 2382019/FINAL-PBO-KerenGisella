import config.Database;
import entities.Mahasiswi;  // Mengimpor class Mahasiswi
import entities.Slip;       // Mengimpor class Slip
import views.MahasiswiSlipTerminalViewImpl; // Mengimpor kelas view yang sudah diimplementasikan

import java.util.ArrayList; // Untuk ArrayList yang menyimpan Mahasiswi dan Slip

public class Main {
    public static void main(String[] args) {
        Database database = new Database("databaseslip", "root", "", "localhost", "3306");
        database.setup();

        ArrayList<Mahasiswi> daftarMahasiswi = new ArrayList<>();
        ArrayList<Slip> daftarSlip = new ArrayList<>();

        MahasiswiSlipTerminalViewImpl view = new MahasiswiSlipTerminalViewImpl(daftarMahasiswi, daftarSlip);
        view.jalankanMenuUtama();
    }
}

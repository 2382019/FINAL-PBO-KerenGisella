import config.Database;
import entities.Mahasiswi;
import entities.Slip;
import repositories.MahasiswiSlipRepository;
import repositories.MahasiswiSlipRepositoryDbImpl;
import repositories.MahasiswiSlipRepositoryImpl;
import services.MahasiswiSlipServiceImpl;
import services.MahasiswiSlipService;
import views.MahasiswiSlipView;
import views.MahasiswiSlipTerminalViewImpl;

import java.util.ArrayList;

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

package mahasiswislipapp;

import mahasiswislipapp.config.Database;
import mahasiswislipapp.entities.Mahasiswi;
import mahasiswislipapp.entities.Slip;
import mahasiswislipapp.views.MahasiswiSlipTerminalViewImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Bean;

import java.util.ArrayList;

@Component
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

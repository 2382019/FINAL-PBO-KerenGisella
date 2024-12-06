package mahasiswislipapp;

import mahasiswislipapp.config.Database;
import mahasiswislipapp.entities.Mahasiswi;
import mahasiswislipapp.entities.Slip;
import mahasiswislipapp.views.MahasiswiSlipTerminalViewImpl;
import mahasiswislipapp.views.MahasiswiSlipView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.ArrayList;

@ComponentScan(basePackages="mahasiswislipapp")
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        MahasiswiSlipView mahasiswiSlipView = applicationContext.getBean(MahasiswiSlipView.class);


        ArrayList<Mahasiswi> daftarMahasiswi = new ArrayList<>();
        ArrayList<Slip> daftarSlip = new ArrayList<>();

        MahasiswiSlipTerminalViewImpl view = new MahasiswiSlipTerminalViewImpl(daftarMahasiswi, daftarSlip);

        view.jalankanMenuUtama();
    }

    @Bean
    Database database() {
        Database database = new Database("databaseslip", "root", "", "localhost", "3306");
        database.setup();
        return database;
    }
}

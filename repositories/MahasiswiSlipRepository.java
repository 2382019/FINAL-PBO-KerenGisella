package repositories;

import entities.Mahasiswi;
import entities.Slip;

import java.util.ArrayList;

public interface MahasiswiSlipRepository {
    ArrayList<Mahasiswi> getDaftarMahasiswi();
    ArrayList<Slip> getDaftarSlip();
}

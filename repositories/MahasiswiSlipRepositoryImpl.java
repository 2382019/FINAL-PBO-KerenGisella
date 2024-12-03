package repositories;

import entities.Mahasiswi;
import entities.Slip;

import java.util.ArrayList;

public class MahasiswiSlipRepositoryImpl implements MahasiswiSlipRepository {
    private final ArrayList<Mahasiswi> daftarMahasiswi = new ArrayList<>();
    private final ArrayList<Slip> daftarSlip = new ArrayList<>();

    @Override
    public ArrayList<Mahasiswi> getDaftarMahasiswi() {
        return daftarMahasiswi;
    }

    @Override
    public ArrayList<Slip> getDaftarSlip() {
        return daftarSlip;
    }
}

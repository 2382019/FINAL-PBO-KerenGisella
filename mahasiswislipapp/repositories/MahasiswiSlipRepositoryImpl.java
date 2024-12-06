package mahasiswislipapp.repositories;

import mahasiswislipapp.entities.Mahasiswi;
import mahasiswislipapp.entities.Slip;

import java.util.ArrayList;

public class MahasiswiSlipRepositoryImpl implements MahasiswiSlipRepository {
    private final ArrayList<Mahasiswi> daftarMahasiswi = new ArrayList<>();
    private final ArrayList<Slip> daftarSlip = new ArrayList<>();

    @Override
    public Slip[] getAll() {
        return new Slip[0];
    }

    @Override
    public void add(Mahasiswi mahasiswi) {

    }

    @Override
    public void add(Slip slip) {

    }

    @Override
    public Boolean remove(Integer id) {
        return null;
    }

    @Override
    public Boolean remove(Slip slip) {
        return null;
    }

    @Override
    public Boolean edit(Slip slip) {
        return null;
    }

    @Override
    public ArrayList<Mahasiswi> getDaftarMahasiswi() {
        return daftarMahasiswi;
    }

    @Override
    public ArrayList<Slip> getDaftarSlip() {
        return daftarSlip;
    }
}
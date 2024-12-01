package services;

import entities.MahasiswiSlip;
import repositories.MahasiswiSlipRepository;
import java.util.List;

public class MahasiswiSlipServiceImpl implements MahasiswiSlipService{
    private MahasiswiSlipRepository repository;

    public MahasiswiSlipServiceImpl(MahasiswiSlipRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addMahasiswiSlip(MahasiswiSlip mahasiswiSlip) {
        repository.addMahasiswiSlip(mahasiswiSlip);
    }

    @Override
    public List<MahasiswiSlip> lihatSemuaMahasiswiSlip() {
        return repository.getAllMahasiswiSlip();
    }

    @Override
    public MahasiswiSlip cariMahasiswiSlipBerdasarkanNama(String nama) {
        return repository.getMahasiswiSlipByName(nama);
    }

    @Override
    public boolean updateMahasiswiSlip(String nama, MahasiswiSlip mahasiswiSlipBaru) {
        return repository.updateMahasiswiSlip(nama, mahasiswiSlipBaru);
    }

    @Override
    public boolean deleteMahasiswiSlip(String nama) {
        return repository.deleteMahasiswiSlip(nama);
    }
}

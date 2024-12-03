package services;

import entities.Mahasiswi;
import entities.Slip;
import repositories.MahasiswiSlipRepository;

public class MahasiswiSlipServiceImpl implements MahasiswiSlipService {
    private final MahasiswiSlipRepository repository;

    public MahasiswiSlipServiceImpl(MahasiswiSlipRepository repository) {
        this.repository = repository;
    }

    @Override
    public void tambahMahasiswi(Mahasiswi mahasiswi) {
        repository.getDaftarMahasiswi().add(mahasiswi);
    }

    @Override
    public void tambahSlip(Slip slip) {
        repository.getDaftarSlip().add(slip);
    }
}

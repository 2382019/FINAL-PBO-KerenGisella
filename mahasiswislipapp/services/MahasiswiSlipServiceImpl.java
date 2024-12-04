package mahasiswislipapp.services;

import mahasiswislipapp.entities.Mahasiswi;
import mahasiswislipapp.entities.Slip;
import mahasiswislipapp.repositories.MahasiswiSlipRepository;
import org.springframework.stereotype.Component;

@Component
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

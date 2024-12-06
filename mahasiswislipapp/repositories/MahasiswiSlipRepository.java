package mahasiswislipapp.repositories;

import mahasiswislipapp.entities.Mahasiswi;
import mahasiswislipapp.entities.Slip;

import java.util.ArrayList;

public interface MahasiswiSlipRepository {
    Slip[] getAll();

    void add(Mahasiswi mahasiswi);

    void add(Slip slip);

    Boolean remove(Integer id);

    Boolean remove(Slip slip);

    Boolean edit(Slip slip);

    ArrayList<Mahasiswi> getDaftarMahasiswi();
    ArrayList<Slip> getDaftarSlip();
}

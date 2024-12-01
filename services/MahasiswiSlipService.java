package services;

import entities.MahasiswiSlip;
import repositories.MahasiswiSlipRepository;

import java.util.List;

public interface MahasiswiSlipService {
    void addMahasiswiSlip(MahasiswiSlip mahasiswiSlip);

    List<MahasiswiSlip> lihatSemuaMahasiswiSlip();

    MahasiswiSlip cariMahasiswiSlipBerdasarkanNama(String nama);

    boolean updateMahasiswiSlip(String nama, MahasiswiSlip mahasiswiSlipBaru);

    boolean deleteMahasiswiSlip(String nama);
}

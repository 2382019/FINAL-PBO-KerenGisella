package repositories;

import entities.MahasiswiSlip;
import java.util.List;

public interface MahasiswiSlipRepository {
    // Menambahkan data MahasiswiSlip baru
    void addMahasiswiSlip(MahasiswiSlip mahasiswiSlip);

    // Mendapatkan semua MahasiswiSlip
    List<MahasiswiSlip> getAllMahasiswiSlip();

    // Mendapatkan MahasiswiSlip berdasarkan nama
    MahasiswiSlip getMahasiswiSlipByName(String nama);

    // Menghapus MahasiswiSlip berdasarkan nama
    boolean deleteMahasiswiSlip(String nama);

    // Mengupdate data MahasiswiSlip
    boolean updateMahasiswiSlip(String nama, MahasiswiSlip mahasiswiSlip);
}

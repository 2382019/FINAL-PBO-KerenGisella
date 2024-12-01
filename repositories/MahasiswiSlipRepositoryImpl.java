package repositories;

import entities.MahasiswiSlip;
import java.util.ArrayList;
import java.util.List;

public class MahasiswiSlipRepositoryImpl implements MahasiswiSlipRepository {
    private List<MahasiswiSlip> dataMahasiswiSlip = new ArrayList<>();


    @Override
    public void addMahasiswiSlip(MahasiswiSlip mahasiswiSlip) {
        dataMahasiswiSlip.add(mahasiswiSlip);
    }

    @Override
    public List<MahasiswiSlip> getAllMahasiswiSlip() {
        return dataMahasiswiSlip;
    }

    @Override
    public MahasiswiSlip getMahasiswiSlipByName(String nama) {
        for (MahasiswiSlip mahasiswiSlip : dataMahasiswiSlip) {
            if (mahasiswiSlip.getNama().equalsIgnoreCase(nama)) {
                return mahasiswiSlip;
            }
        }
        return null;
    }

    @Override
    public boolean deleteMahasiswiSlip(String nama) {
        MahasiswiSlip mahasiswiSlip = getMahasiswiSlipByName(nama);
        if (mahasiswiSlip != null) {
            dataMahasiswiSlip.remove(mahasiswiSlip);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMahasiswiSlip(String nama, MahasiswiSlip updateMahasiswiSlip) {
        for (int i = 0; i < dataMahasiswiSlip.size(); i++) {
            if (dataMahasiswiSlip.get(i).getNama().equalsIgnoreCase(nama)) {
                dataMahasiswiSlip.set(i, updateMahasiswiSlip);
                return true;
            }
        }
        return false;
    }
}

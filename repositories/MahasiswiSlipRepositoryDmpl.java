package repositories;

import config.Database;
import entities.Mahasiswi;
import entities.Slip;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MahasiswiSlipRepositoryDmpl implements MahasiswiSlipRepository {
    private final Database database;

    public MahasiswiSlipRepositoryDmpl(final Database database) {
        this.database = database;
    }

    @Override
    public ArrayList<Mahasiswi> getDaftarMahasiswi() {
        return null;
    }

    @Override
    public ArrayList<Slip> getDaftarSlip() {
        return null;
    }
}
package repositories;

import config.Database;
import entities.Slip;
import entities.Mahasiswi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MahasiswiSlipRepositoryDbImpl implements MahasiswiSlipRepository {
    private final Database database;

    public MahasiswiSlipRepositoryDbImpl(final Database database) {
        this.database = database;
    }

    @Override
    public Slip[] getAll() {
        Connection connection = database.getConnection();
        String sqlStatement = "SELECT * FROM slip";
        List<Slip> slips = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Slip slip = new Slip();
                Mahasiswi mahasiswi = new Mahasiswi();

                mahasiswi.setNama(resultSet.getString("mahasiswi_nama"));
                mahasiswi.setAsrama(resultSet.getString("mahasiswi_asrama"));
                mahasiswi.setNomorKamar(resultSet.getString("mahasiswi_nomor_kamar"));
                slip.setMahasiswi(mahasiswi);

                // Set data Slip
                slip.setJenisSlip(resultSet.getString("jenis_slip"));
                slip.setAlasan(resultSet.getString("alasan"));
                slip.setTanggalKeluar(resultSet.getString("tanggal_keluar"));
                slip.setWaktuKembali(resultSet.getString("waktu_kembali"));

                slips.add(slip);
            }
        } catch (Exception e) {
            System.out.println("Error while fetching slips: " + e.getMessage());
        }
        return slips.toArray(Slip[]::new);
    }

    @Override
    public void add(final Slip slip) {
        String sqlStatement = """
            INSERT INTO slip (
                mahasiswi_nama, mahasiswi_asrama, mahasiswi_nomor_kamar,
                jenis_slip, alasan, tanggal_keluar, waktu_kembali
            ) VALUES (?, ?, ?, ?, ?, ?, ?)
        """;
        Connection conn = database.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setString(1, slip.getMahasiswi().getNama());
            preparedStatement.setString(2, slip.getMahasiswi().getAsrama());
            preparedStatement.setString(3, slip.getMahasiswi().getNomorKamar());
            preparedStatement.setString(4, slip.getJenisSlip());
            preparedStatement.setString(5, slip.getAlasan());
            preparedStatement.setString(6, slip.getTanggalKeluar());
            preparedStatement.setString(7, slip.getWaktuKembali());

            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println("Insert successful!");
            }
        } catch (Exception e) {
            System.out.println("Error while adding slip: " + e.getMessage());
        }
    }

    @Override
    public Boolean remove(Integer id) {
        return null;
    }

    @Override
    public Boolean remove(final Slip slip) {
        String sqlStatement = """
            DELETE FROM slip WHERE 
                mahasiswi_nama = ? AND mahasiswi_asrama = ? AND 
                mahasiswi_nomor_kamar = ? AND jenis_slip = ? AND alasan = ?
        """;
        Connection conn = database.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setString(1, slip.getMahasiswi().getNama());
            preparedStatement.setString(2, slip.getMahasiswi().getAsrama());
            preparedStatement.setString(3, slip.getMahasiswi().getNomorKamar());
            preparedStatement.setString(4, slip.getJenisSlip());
            preparedStatement.setString(5, slip.getAlasan());

            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println("Delete successful!");
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error while removing slip: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean edit(final Slip slip) {
        String sqlStatement = """
            UPDATE slip SET 
                jenis_slip = ?, alasan = ?, tanggal_keluar = ?, waktu_kembali = ?
            WHERE 
                mahasiswi_nama = ? AND mahasiswi_asrama = ? AND mahasiswi_nomor_kamar = ?
        """;
        Connection conn = database.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setString(1, slip.getJenisSlip());
            preparedStatement.setString(2, slip.getAlasan());
            preparedStatement.setString(3, slip.getTanggalKeluar());
            preparedStatement.setString(4, slip.getWaktuKembali());
            preparedStatement.setString(5, slip.getMahasiswi().getNama());
            preparedStatement.setString(6, slip.getMahasiswi().getAsrama());
            preparedStatement.setString(7, slip.getMahasiswi().getNomorKamar());

            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println("Update successful!");
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error while updating slip: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Mahasiswi> getDaftarMahasiswi() {
        Connection connection = database.getConnection();
        String sqlStatement = """
            SELECT DISTINCT mahasiswi_nama, mahasiswi_asrama, mahasiswi_nomor_kamar FROM slip
        """;
        ArrayList<Mahasiswi> daftarMahasiswi = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Mahasiswi mahasiswi = new Mahasiswi();
                mahasiswi.setNama(resultSet.getString("mahasiswi_nama"));
                mahasiswi.setAsrama(resultSet.getString("mahasiswi_asrama"));
                mahasiswi.setNomorKamar(resultSet.getString("mahasiswi_nomor_kamar"));

                daftarMahasiswi.add(mahasiswi);
            }
        } catch (Exception e) {
            System.out.println("Error while fetching daftar mahasiswi: " + e.getMessage());
        }

        return daftarMahasiswi;
    }

    @Override
    public ArrayList<Slip> getDaftarSlip() {
        return new ArrayList<>(List.of(getAll()));
    }
}

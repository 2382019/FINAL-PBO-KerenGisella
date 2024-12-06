package mahasiswislipapp.repositories;

import mahasiswislipapp.config.Database;
import mahasiswislipapp.entities.Slip;
import mahasiswislipapp.entities.Mahasiswi;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class MahasiswiSlipRepositoryDbImpl implements MahasiswiSlipRepository {
    private final Database database;

    public MahasiswiSlipRepositoryDbImpl(final Database database) {
        this.database = database;
    }

    @Override
    public Slip[] getAll() {
        String sqlStatement = "SELECT * FROM mahasiswislips";
        List<Slip> slips = new ArrayList<>();

        try (Connection conn = database.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Slip slip = new Slip();
                Mahasiswi mahasiswi = new Mahasiswi();

                mahasiswi.setNama(resultSet.getString("nama"));
                mahasiswi.setAsrama(resultSet.getString("asrama"));
                mahasiswi.setNomorKamar(resultSet.getString("noKamar"));
                slip.setMahasiswi(mahasiswi);

                // Set Slip fields
                slip.setJenisSlip(resultSet.getString("jenisSlip"));
                slip.setAlasan(resultSet.getString("alasan"));
                slip.setTanggalKeluar(resultSet.getString("tanggalKeluar"));
                slip.setWaktuKembali(resultSet.getString("waktuKembali"));

                slips.add(slip);
            }
        } catch (Exception e) {
            System.out.println("Error while fetching slips: " + e.getMessage());
        }
        return slips.toArray(Slip[]::new);
    }

    @Override
    public void add(Mahasiswi mahasiswi) {
        String sqlStatement = "INSERT INTO mahasiswislips (nama, asrama, noKamar) VALUES (?, ?, ?)";

        try (Connection conn = database.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement)) {

            preparedStatement.setString(1, mahasiswi.getNama());
            preparedStatement.setString(2, mahasiswi.getAsrama());
            preparedStatement.setInt(3, Integer.parseInt(mahasiswi.getNomorKamar()));

            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println("Mahasiswi successfully added!");
            }
        } catch (Exception e) {
            System.out.println("Error while adding mahasiswi: " + e.getMessage());
        }
    }

    @Override
    public void add(Slip slip) {
        String sqlStatement = "INSERT INTO mahasiswislips (nama, asrama, noKamar, jenisSlip, alasan, tanggalKeluar, waktuKembali) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = database.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement)) {

            preparedStatement.setString(1, slip.getMahasiswi().getNama());
            preparedStatement.setString(2, slip.getMahasiswi().getAsrama());
            preparedStatement.setInt(3, Integer.parseInt(slip.getMahasiswi().getNomorKamar()));
            preparedStatement.setString(4, slip.getJenisSlip());
            preparedStatement.setString(5, slip.getAlasan());
            preparedStatement.setDate(6, java.sql.Date.valueOf(slip.getTanggalKeluar()));
            preparedStatement.setTime(7, java.sql.Time.valueOf(slip.getWaktuKembali()));

            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println("Slip successfully added!");
            }
        } catch (Exception e) {
            System.out.println("Error while adding slip: " + e.getMessage());
        }
    }

    @Override
    public Boolean remove(Integer id) {
        String sqlStatement = "DELETE FROM mahasiswislips WHERE id = ?";

        try (Connection conn = database.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement)) {

            preparedStatement.setInt(1, id);

            int rowsEffected = preparedStatement.executeUpdate();
            return rowsEffected > 0;
        } catch (Exception e) {
            System.out.println("Error while removing slip by ID: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean remove(Slip slip) {
        String sqlStatement = "DELETE FROM mahasiswislips WHERE nama = ? AND asrama = ? AND noKamar = ? AND jenisSlip = ? AND alasan = ? AND tanggalKeluar = ? AND waktuKembali = ? ";

        try (Connection conn = database.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement)) {

            preparedStatement.setString(1, slip.getMahasiswi().getNama());
            preparedStatement.setString(2, slip.getMahasiswi().getAsrama());
            preparedStatement.setInt(3, Integer.parseInt(slip.getMahasiswi().getNomorKamar()));
            preparedStatement.setString(4, slip.getJenisSlip());
            preparedStatement.setString(5, slip.getAlasan());
            preparedStatement.setDate(6, java.sql.Date.valueOf(slip.getTanggalKeluar()));
            preparedStatement.setTime(7, java.sql.Time.valueOf(slip.getWaktuKembali()));

            int rowsEffected = preparedStatement.executeUpdate();
            return rowsEffected > 0;
        } catch (Exception e) {
            System.out.println("Error while removing slip: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean edit(Slip slip) {
        String sqlStatement = "UPDATE mahasiswislips SET jenisSlip = ?, alasan = ?, tanggalKeluar = ?, waktuKembali = ? WHERE id = ?";

        try (Connection conn = database.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement)) {

            preparedStatement.setString(1, slip.getJenisSlip());
            preparedStatement.setString(2, slip.getAlasan());
            preparedStatement.setDate(3, java.sql.Date.valueOf(slip.getTanggalKeluar()));
            preparedStatement.setTime(4, java.sql.Time.valueOf(slip.getWaktuKembali()));
            preparedStatement.setInt(5, slip.getId());

            int rowsEffected = preparedStatement.executeUpdate();
            return rowsEffected > 0;
        } catch (Exception e) {
            System.out.println("Error while updating slip: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Mahasiswi> getDaftarMahasiswi() {
        String sqlStatement = "SELECT DISTINCT nama, asrama, noKamar FROM mahasiswislips";
        ArrayList<Mahasiswi> daftarMahasiswi = new ArrayList<>();

        try (Connection conn = database.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Mahasiswi mahasiswi = new Mahasiswi();
                mahasiswi.setNama(resultSet.getString("nama"));
                mahasiswi.setAsrama(resultSet.getString("asrama"));
                mahasiswi.setNomorKamar(resultSet.getString("noKamar"));

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

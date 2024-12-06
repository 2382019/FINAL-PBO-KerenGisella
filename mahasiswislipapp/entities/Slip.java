package mahasiswislipapp.entities;

public class Slip {
    public Mahasiswi mahasiswi;
    public String jenisSlip;
    public String alasan;
    public String tanggalKeluar;
    public String waktuKembali;

    public Slip(Mahasiswi mahasiswi, String jenisSlip, String alasan, String tanggalKeluar) {
        this.mahasiswi = mahasiswi;
        this.jenisSlip = jenisSlip;
        this.alasan = alasan;
        this.tanggalKeluar = tanggalKeluar;
        this.waktuKembali = null;
    }

    public Slip() {

    }

    public Mahasiswi getMahasiswi() {
        return mahasiswi;
    }

    public void setMahasiswi(Mahasiswi mahasiswi) {
        this.mahasiswi = mahasiswi;
    }

    public String getJenisSlip() {
        return jenisSlip;
    }

    public void setJenisSlip(String jenisSlip) {
        this.jenisSlip = jenisSlip;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public String getTanggalKeluar() {
        return tanggalKeluar;
    }

    public void setTanggalKeluar(String tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }

    public String getWaktuKembali() {
        return waktuKembali;
    }

    public void setWaktuKembali(String waktuKembali) {
        this.waktuKembali = waktuKembali;
    }
}

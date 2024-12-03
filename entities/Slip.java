package entities;

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
}

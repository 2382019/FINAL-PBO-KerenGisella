package entities;

public class Mahasiswi {
    public String nama;
    public String asrama;
    public String nomorKamar;

    public Mahasiswi(String nama, String asrama, String nomorKamar) {
        this.nama = nama;
        this.asrama = asrama;
        this.nomorKamar = nomorKamar;
    }

    public Mahasiswi() {

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsrama() {
        return asrama;
    }

    public void setAsrama(String asrama) {
        this.asrama = asrama;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public void setNomorKamar(String nomorKamar) {
        this.nomorKamar = nomorKamar;
    }
}

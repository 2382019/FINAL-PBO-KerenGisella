package entities;

import java.util.ArrayList;
import java.util.List;

public class MahasiswiSlip {
    private String nama;
    private String asrama;
    private String nomorKamar;
    private List<Slip> slips;

    public MahasiswiSlip() {
        this.slips = new ArrayList<>();
    }

    public MahasiswiSlip(String nama, String asrama, String nomorKamar) {
        this.nama = nama;
        this.asrama = asrama;
        this.nomorKamar = nomorKamar;
        this.slips = new ArrayList<>();
    }

    // Getter dan Setter untuk atribut Mahasiswi
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

    // Metode untuk mengelola slip
    public List<Slip> getSlips() {
        return slips;
    }

    public void tambahSlip(String jenisSlip, String alasan, String tanggalKeluar) {
        this.slips.add(new Slip(jenisSlip, alasan, tanggalKeluar));
    }

    public void hapusSlip(int index) {
        if (index >= 0 && index < slips.size()) {
            this.slips.remove(index);
        }
    }

    // Kelas dalam untuk Slip
    public static class Slip {
        private String jenisSlip;
        private String alasan;
        private String tanggalKeluar;
        private String waktuKembali;
        private boolean statusPersetujuan;

        public Slip(String jenisSlip, String alasan, String tanggalKeluar) {
            this.jenisSlip = jenisSlip;
            this.alasan = alasan;
            this.tanggalKeluar = tanggalKeluar;
            this.statusPersetujuan = false;
        }

        // Getter dan Setter untuk atribut Slip
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

        public boolean isStatusPersetujuan() {
            return statusPersetujuan;
        }

        public void setStatusPersetujuan(boolean statusPersetujuan) {
            this.statusPersetujuan = statusPersetujuan;
        }
    }
}

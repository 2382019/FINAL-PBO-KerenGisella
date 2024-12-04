package mahasiswislipapp.views;

import mahasiswislipapp.entities.Mahasiswi;  // Mengimpor class Mahasiswi
import mahasiswislipapp.entities.Slip;      // Mengimpor class Slip
import org.springframework.stereotype.Component;

import java.util.ArrayList; // Untuk daftar Mahasiswi dan Slip
import java.util.Scanner;   // Untuk input terminal

@Component
public class MahasiswiSlipTerminalViewImpl implements MahasiswiSlipView {
    private Scanner scanner;
    private ArrayList<Mahasiswi> daftarMahasiswi;
    private ArrayList<Slip> daftarSlip;

    public MahasiswiSlipTerminalViewImpl(ArrayList<Mahasiswi> daftarMahasiswi, ArrayList<Slip> daftarSlip) {
        this.scanner = new Scanner(System.in);
        this.daftarMahasiswi = daftarMahasiswi;
        this.daftarSlip = daftarSlip;
    }

    @Override
    public void jalankanMenuUtama() {
        boolean isRunning = true;

        while (isRunning) {
            tampilkanMenuUtama();

            String pilihan = input("Pilih menu");
            switch (pilihan) {
                case "1":
                    pendaftaranAkunMahasiswi();
                    break;
                case "2":
                    pengajuanSlip();
                    break;
                case "3":
                    editSlip();
                    break;
                case "4":
                    lihatMahasiswiDanSlip();
                    break;
                case "5":
                    pencatatanWaktuKembali();
                    break;
                case "6":
                    hapusSlip();
                    break;
                case "7":
                    pencarianDanFilterSlip();
                    break;
                case "8":
                    isRunning = false;
                    tampilkanPesan("Terima kasih telah menggunakan sistem. Sampai jumpa!");
                    break;
                default:
                    tampilkanPesan("Pilihan tidak valid");
            }
        }
    }

    private void tampilkanMenuUtama() {
        System.out.println("\nSISTEM PENDATAAN SLIP ASRAMA PUTRI");
        System.out.println("1. Pendaftaran Akun");
        System.out.println("2. Pengajuan Slip");
        System.out.println("3. Edit Slip");
        System.out.println("4. Lihat Mahasiswi dan Slip");
        System.out.println("5. Pencatatan Waktu Keluar-Masuk");
        System.out.println("6. Hapus Slip");
        System.out.println("7. Pencarian dan Filter Slip");
        System.out.println("8. Keluar");
    }

    private void pendaftaranAkunMahasiswi() {
        tampilkanPesan("\nPENDAFTARAN AKUN");
        String nama = input("Nama lengkap");
        String asrama = input("Asrama");
        String nomorKamar = input("Nomor kamar");

        Mahasiswi mahasiswi = new Mahasiswi(nama, asrama, nomorKamar);
        daftarMahasiswi.add(mahasiswi);
        tampilkanPesan("Akun mahasiswi berhasil didaftarkan!");
    }

    private void pengajuanSlip() {
        if (daftarMahasiswi.isEmpty()) {
            tampilkanPesan("Belum ada mahasiswi yang terdaftar. Silakan daftar terlebih dahulu.");
            return;
        }

        tampilkanPesan("Daftar Mahasiswi:");
        for (int i = 0; i < daftarMahasiswi.size(); i++) {
            System.out.println((i + 1) + ". " + daftarMahasiswi.get(i).nama);
        }

        int pilihan = Integer.parseInt(input("Pilih nomor mahasiswi")) - 1;
        if (pilihan < 0 || pilihan >= daftarMahasiswi.size()) {
            tampilkanPesan("Pilihan tidak valid.");
            return;
        }

        Mahasiswi mahasiswi = daftarMahasiswi.get(pilihan);
        String jenisSlip = input("Jenis slip (Keluar/Weekend)");
        String alasan = input("Alasan");
        String tanggalKeluar = input("Tanggal keluar (dd-MM-yyyy)");
        String waktuKeluar = input("Waktu keluar (HH:mm)");

        Slip slip = new Slip(mahasiswi, jenisSlip, alasan, tanggalKeluar + " " + waktuKeluar);
        daftarSlip.add(slip);
        tampilkanPesan("Slip berhasil diajukan.");
    }

    private void editSlip() {
        tampilkanPesan("\nEDIT SLIP");
        if (daftarSlip.isEmpty()) {
            tampilkanPesan("Tidak ada slip yang dapat diedit.");
            return;
        }

        tampilkanDaftarSlip();
        int pilihan = Integer.parseInt(input("Pilih nomor slip yang ingin diedit")) - 1;
        if (pilihan < 0 || pilihan >= daftarSlip.size()) {
            tampilkanPesan("Pilihan tidak valid.");
            return;
        }

        Slip slip = daftarSlip.get(pilihan);
        slip.jenisSlip = input("Jenis slip baru (Keluar/Weekend) (" + slip.jenisSlip + ")");
        slip.alasan = input("Alasan baru (" + slip.alasan + ")");
        slip.tanggalKeluar = input("Tanggal keluar baru (" + slip.tanggalKeluar + ")");
        tampilkanPesan("Slip berhasil diperbarui.");
    }

    private void lihatMahasiswiDanSlip() {
        tampilkanPesan("\nLIHAT MAHASISWI DAN SLIP");
        if (daftarMahasiswi.isEmpty()) {
            tampilkanPesan("Tidak ada mahasiswi yang terdaftar.");
            return;
        }

        for (Mahasiswi mahasiswi : daftarMahasiswi) {
            tampilkanMahasiswi(mahasiswi);
            for (Slip slip : daftarSlip) {
                if (slip.mahasiswi == mahasiswi) {
                    tampilkanSlip(slip);
                }
            }
        }
    }

    private void pencatatanWaktuKembali() {
        tampilkanPesan("\nPENCATATAN WAKTU KEMBALI");
        tampilkanDaftarSlip();
        int pilihan = Integer.parseInt(input("Pilih nomor slip")) - 1;
        if (pilihan < 0 || pilihan >= daftarSlip.size()) {
            tampilkanPesan("Pilihan tidak valid.");
            return;
        }

        Slip slip = daftarSlip.get(pilihan);
        String tanggalKembali = input("Tanggal kembali (dd-MM-yyyy)");
        String waktuKembali = input("Waktu kembali (HH:mm)");
        slip.waktuKembali = tanggalKembali + " " + waktuKembali;
        tampilkanPesan("Waktu kembali berhasil dicatat.");
    }

    private void hapusSlip() {
        tampilkanPesan("\nHAPUS SLIP");
        if (daftarSlip.isEmpty()) {
            tampilkanPesan("Tidak ada slip yang dapat dihapus.");
            return;
        }

        tampilkanDaftarSlip();
        int pilihan = Integer.parseInt(input("Pilih nomor slip")) - 1;
        if (pilihan < 0 || pilihan >= daftarSlip.size()) {
            tampilkanPesan("Pilihan tidak valid.");
            return;
        }

        daftarSlip.remove(pilihan);
        tampilkanPesan("Slip berhasil dihapus.");
    }

    private void pencarianDanFilterSlip() {
        tampilkanPesan("\nFILTER SLIP BERDASARKAN JENIS");
        String jenisSlip = input("Masukkan jenis slip (Keluar/Weekend)");
        boolean ditemukan = false;

        for (Slip slip : daftarSlip) {
            if (slip.jenisSlip.equalsIgnoreCase(jenisSlip)) {
                tampilkanSlip(slip);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            tampilkanPesan("Tidak ada slip dengan jenis tersebut.");
        }
    }

    private String input(String prompt) {
        System.out.print(prompt + " : ");
        return scanner.nextLine();
    }

    private void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }

    private void tampilkanMahasiswi(Mahasiswi mahasiswi) {
        System.out.println("Nama: " + mahasiswi.nama);
        System.out.println("Asrama: " + mahasiswi.asrama);
        System.out.println("Nomor Kamar: " + mahasiswi.nomorKamar);
        System.out.println("--------------------");
    }

    private void tampilkanSlip(Slip slip) {
        System.out.println("Nama: " + slip.mahasiswi.nama);
        System.out.println("Jenis Slip: " + slip.jenisSlip);
        System.out.println("Alasan: " + slip.alasan);
        System.out.println("Tanggal Keluar: " + slip.tanggalKeluar);
        if (slip.waktuKembali != null) {
            System.out.println("Tanggal Kembali: " + slip.waktuKembali);
        }
        System.out.println("--------------------");
    }

    private void tampilkanDaftarSlip() {
        tampilkanPesan("DAFTAR SLIP");
        for (int i = 0; i < daftarSlip.size(); i++) {
            System.out.println((i + 1) + ". " + daftarSlip.get(i).mahasiswi.nama + " - " + daftarSlip.get(i).jenisSlip);
        }
    }
}

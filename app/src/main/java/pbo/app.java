package pbo;
import java.util.ArrayList;
import java.util.Scanner;

public class app {

    static ArrayList<Mahasiswa> daftarMhs = new ArrayList<>();
    static ArrayList<mataKuliah> daftarMK = new ArrayList<>();
    static ArrayList<krs> daftarKRS = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        daftarMhs.add(new Mahasiswa("112401", "Bob", true));
        daftarMhs.add(new Mahasiswa("112402", "Bobby", true));

        daftarMK.add(new mataKuliah("MK001", "Algoritma", true));
        daftarMK.add(new mataKuliah("MK002", "Struktur Data", true));

        daftarKRS.add(new krs(daftarMhs.get(0), daftarMK.get(0), 85.0));
        daftarKRS.add(new krs(daftarMhs.get(1), daftarMK.get(1), 90.0));

        int pilihan;

        do {
            System.out.println("Menu:");
            System.out.println("1. Menu Mahasiswa");
            System.out.println("2. Menu Mata Kuliah");
            System.out.println("3. Menu KRS");
            System.out.println("4. List berdasarkan Mata Kuliah");
            System.out.println("5. List berdasarkan Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("===== MENU MAHASISWA =====");
                    System.out.println("1. Tambah");
                    System.out.println("2. Edit");
                    System.out.print("Pilih : ");
                    int pilihMhs = scanner.nextInt();
                    
                    switch (pilihMhs) {
                        case 1:
                            System.out.print("NIM: ");
                            String nim = scanner.next();
                            System.out.print("Nama: ");
                            String nama = scanner.next();
                            System.out.print("Status (true/false): ");
                            boolean status = scanner.nextBoolean();
                            daftarMhs.add(new Mahasiswa(nim, nama, status));
                            break;
                        case 2:
                            System.out.print("Masukkan NIM yang ingin diedit: ");
                            String nimEdit = scanner.next();
                            for (int i = 0; i < daftarMhs.size(); i++) {
                                Mahasiswa mhs = daftarMhs.get(i);
                                if (mhs.nim.equals(nimEdit)) {
                                    System.out.print("Nama baru: ");
                                    mhs.nama = scanner.next();
                                    System.out.print("Status baru (true/false): ");
                                    mhs.status = scanner.nextBoolean();
                                    break;
                                }
                            }
                            break;
                        default:
                            System.out.println("Pilihan tidak valid.");
                    }
                    break;

                case 2:
                    System.out.println("===== MENU MATA KULIAH =====");
                    System.out.println("1. Tambah");
                    System.out.println("2. Edit");
                    System.out.print("Pilih : ");
                    int pilihMK = scanner.nextInt();
                    
                    switch (pilihMK) {
                        case 1:
                            System.out.print("Kode: ");
                            String kode = scanner.next();
                            System.out.print("Nama: ");
                            String namaMK = scanner.next();
                            System.out.print("Status (true/false): ");
                            boolean statusMK = scanner.nextBoolean();
                            daftarMK.add(new mataKuliah(kode, namaMK, statusMK));
                            break;
                        case 2:
                            System.out.print("Masukkan Kode yang ingin diedit: ");
                            String kodeEdit = scanner.next();
                            for (int i = 0; i < daftarMK.size(); i++) {
                                mataKuliah mk = daftarMK.get(i);
                                if (mk.kode.equals(kodeEdit)) {
                                    System.out.print("Nama baru: ");
                                    mk.nama = scanner.next();
                                    System.out.print("Status baru (true/false): ");
                                    mk.status = scanner.nextBoolean();
                                    break;
                                }
                            }
                            break;
                        default:
                            System.out.println("Pilihan tidak valid.");
                    }
                    break;

                case 3:
                    System.out.println("===== MENU KRS =====");
                    System.out.println("1. Tambah");
                    System.out.println("2. Edit");
                    System.out.print("Pilih : ");
                    int pilihKRS = scanner.nextInt();
                    
                    switch (pilihKRS) {
                        case 1:
                            System.out.print("NIM Mahasiswa: ");
                            String nimKRS = scanner.next();
                            System.out.print("Kode Mata Kuliah: ");
                            String kodeKRS = scanner.next();
                            System.out.print("Nilai: ");
                            double nilaiKRS = scanner.nextDouble();

                            Mahasiswa mhsKRS = null;
                            mataKuliah mkKRS = null;

                            for (int i = 0; i < daftarMhs.size(); i++) {
                                Mahasiswa m = daftarMhs.get(i);
                                if (m.nim.equals(nimKRS)) {
                                    mhsKRS = m;
                                    break;
                                }
                            }

                            for (int i = 0; i < daftarMK.size(); i++) {
                                mataKuliah mk = daftarMK.get(i);
                                if (mk.kode.equals(kodeKRS)) {
                                    mkKRS = mk;
                                    break;
                                }
                            }

                            if (mhsKRS == null || mkKRS == null) {
                                System.out.println("Mahasiswa atau Mata Kuliah tidak ditemukan.");
                            } else if (!mhsKRS.status) {
                                System.out.println("Mahasiswa tidak aktif.");
                            } else if (!mkKRS.status) {
                                System.out.println("Mata Kuliah tidak aktif.");
                            } else {
                                daftarKRS.add(new krs(mhsKRS, mkKRS, nilaiKRS));
                            }
                            break;
                        case 2:
                            System.out.print("Masukkan NIM Mahasiswa yang ingin diedit: ");
                            String nimEditKRS = scanner.next();
                            System.out.print("Masukkan Kode Mata Kuliah yang ingin diedit: ");
                            String kodeEditKRS = scanner.next();

                            for (int i = 0; i < daftarKRS.size(); i++) {
                                krs k = daftarKRS.get(i);
                                if (k.mhs.nim.equals(nimEditKRS) && k.mk.kode.equals(kodeEditKRS)) {
                                    System.out.print("Nilai baru: ");
                                    k.nilai = scanner.nextDouble();
                                    break;
                                }
                            }
                            break;
                        default:
                            System.out.println("Pilihan tidak valid.");
                    }
                    break;

                case 4:
                    System.out.println("Daftar Mata Kuliah:");
                    for (int i = 0; i < daftarMK.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarMK.get(i).nama);
                    }

                    System.out.print("Pilih Mata Kuliah: ");
                    int pilihMKList = scanner.nextInt();

                    if (pilihMKList > 0 && pilihMKList <= daftarMK.size()) {
                        mataKuliah mkDipilih = daftarMK.get(pilihMKList - 1);
                        System.out.println("Mahasiswa yang mengambil " + mkDipilih.nama + ":");

                        for (int i = 0; i < daftarKRS.size(); i++) {
                            krs k = daftarKRS.get(i);
                            if (k.mk == mkDipilih) {
                                System.out.println(k.mhs.nim + " - " + k.mhs.nama + " Nilai: " + k.nilai);
                            }
                        }
                    } else {
                        System.out.println("Pilihan nomor mata kuliah tidak valid.");
                    }
                    break;

                case 5:
                    System.out.println("Daftar Mahasiswa:");
                    for (int i = 0; i < daftarMhs.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarMhs.get(i).nama);
                    }

                    System.out.print("Pilih Mahasiswa: ");
                    int pilihMhsList = scanner.nextInt();
                    if (pilihMhsList > 0 && pilihMhsList <= daftarMhs.size()) {
                        Mahasiswa mhsDipilih = daftarMhs.get(pilihMhsList - 1);
                        System.out.println("Mata Kuliah yang diambil " + mhsDipilih.nama + ":");

                        for (int i = 0; i < daftarKRS.size(); i++) {
                            krs k = daftarKRS.get(i);
                            if (k.mhs == mhsDipilih) {
                                System.out.println(k.mk.kode + " - " + k.mk.nama + " Nilai: " + k.nilai);
                            }
                        }
                    } else {
                        System.out.println("Pilihan nomor mahasiswa tidak valid.");
                    }
                    break;

                case 0:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan menu utama tidak valid.");
            }

        } while (pilihan != 0);
    }
}
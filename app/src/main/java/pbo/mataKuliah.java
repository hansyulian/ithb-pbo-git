package pbo;
public class mataKuliah {
    public String kode;
    public String nama;
    public boolean status;

    public mataKuliah(String kode, String nama, boolean status) {
        this.kode = kode;
        this.nama = nama;
        this.status = status;
    }

    public void print() {
        System.out.println("Kode: " + kode);
        System.out.println("Nama: " + nama);
        System.out.println("Status: " + (status ? "Aktif" : "Tidak Aktif"));
    }
}

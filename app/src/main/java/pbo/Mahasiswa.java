package pbo;
class Mahasiswa {
    public String nim;
    public String nama;
    public boolean status;

    public Mahasiswa(String nim, String nama, boolean status) {
        this.nim = nim;
        this.nama = nama;
        this.status = status;
    }

    public void print() {
        System.out.println("NIM: " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("Status: " + (status ? "Aktif" : "Tidak Aktif"));
    }
}

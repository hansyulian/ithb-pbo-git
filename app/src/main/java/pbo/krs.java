package pbo;
public class krs {
    Mahasiswa mhs;
    mataKuliah mk;
    double nilai;

    public krs(Mahasiswa mhs, mataKuliah mk, double nilai) {
        this.mhs = mhs;
        this.mk = mk;
        this.nilai = nilai;
    }

    public void print() {
    System.out.println(mhs.nama + " " + mk.nama + " Nilai: " + nilai);
}
}

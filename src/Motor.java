public class Motor {
    private String nama;
    private String nopol;
    private String password;
    private int waktuMasuk;

    public Motor(String nama, String nopol, String password, int waktuMasuk) {
        this.nama = nama;
        this.nopol = nopol;
        this.password = password;
        this.waktuMasuk = waktuMasuk;
    }

    public String getNama () {
        return nama;
    }

    public String getNopol () {
        return nopol;
    }

    public String getPassword() {
        return password;
    }

    public int getWaktuMasuk() {
        return waktuMasuk;
    }
}
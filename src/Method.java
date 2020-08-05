import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Method {

    // this code from Filda Fikri Faizal Muttaqin
    public static String password() { // generate random password
        String chara = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        while (stringBuilder.length() < 5) {
            int index = (int) (rnd.nextFloat() * chara.length());
            stringBuilder.append(chara.charAt(index));
        }
        String randStr = stringBuilder.toString().toLowerCase();
        return randStr;
    }

    public int waktuMasuk() { // waktu masuk
        int tes = (int)new Date().getTime();
        return tes;
    }

    public int jam(int waktuMasuk) { // convert waktu masuk ke jam
        int waktuKeluar = (int)new Date().getTime();
        int hasil = waktuKeluar-waktuMasuk;
        int lama = hasil/1000;
        int lama2 = 0;
        if (lama > 60) {
            lama2 = lama / 60;
        }
        return lama2;
    }

    public int menit(int waktuMasuk) { // convert waktu masuk ke menit
        int waktuKeluar = (int)new Date().getTime();
        int lama = (waktuKeluar - waktuMasuk) / 1000;
        if (lama>60) {
            lama = lama%60;
        }
        return lama;
    }

    public int harga(int jam) { // generate harga
        int bayar = 0;
        bayar += 5000;
        if (jam >= 2) {
            bayar += 2000*(jam-1);
        }
        return bayar;
    }

    private static String mataUang(int uang) { // menambahkan simbol mata uang (Rp)
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(localeID);
        return formatter.format(uang);
    }

    void keluar(String nama, String nopol, String password, int waktuMasuk) { // keluar
        int jam = jam(waktuMasuk);
        int menit = menit(waktuMasuk);

        System.out.print("-------------------------\nNama     : "+ nama+ "\nNopol    : " + nopol+ "\nPassword : " + password+ "\nDurasi   : " + jam + " jam " + menit + " menit\nBiaya    : " + mataUang(harga(jam))+ "\n-------------------------\n");
    }
}
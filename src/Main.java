import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Motor> arr = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Method method = new Method();

        boolean end = false;
        while (end == false) {
            System.out.print("========================================\n===SELAMAT DATANG DI PARKIRAN SIAPGAN===\n========================================\n*biaya parkir Rp5.000,00 dua jam pertama\n*setelahnya, ditambah Rp2.000,00 perjam\n|1| Masukkan motor\n|2| Keluarkan motor\n|3| Lihat daftar pengguna\n|4| Sorting pengguna\n|5| Cari pengguna\n|6| Keluar dari program\n");
            String pilih = "", validasi;
            do { // cek kalau inputan sudah benar atau tidak
                validasi = "TRUE";
                System.out.print("Pilih apa: ");
                try {
                    pilih = scan.next();
                    if(!(Integer.parseInt(pilih)>=1 && Integer.parseInt(pilih)<=6)){
                        validasi="FALSE";
                    }
                } catch (Exception e) {
                    validasi = "FALSE";
                } if (validasi == "FALSE") {
                    System.out.println("Salah input !");
                }
            } while(validasi == "FALSE");

            if (Integer.parseInt(pilih) == 1) { // memasukkan motor
                System.out.print("Masukkan nama  : ");
                String tambahNama = scan.next()+ scan.nextLine();
                System.out.print("Masukkan nopol : ");
                String tambahNopol = scan.next();

                boolean isExist2 = false;
                for (Motor motor2 : arr) {
                    isExist2 = motor2.getNopol().equals(tambahNopol);
                }
                if (isExist2 == false) {
                    String password = method.password();
                    System.out.println("Passwordmu adalah: " + password);
                    arr.add(new Motor(tambahNama, tambahNopol, password, method.waktuMasuk()));
                } else {
                    System.out.println("Maaf, motor sudah ada !");
                }

            } else if (Integer.parseInt(pilih) == 2) { // mengeluarkan motor
                System.out.print("Masukkan nopol: ");
                String nopol = scan.next();
                boolean isExist = false;

                for (Motor motor : arr) {
                    isExist = motor.getNopol().equals(nopol);
                    if (isExist == true) {
                        System.out.println("Nama: "+ motor.getNama());
                        System.out.print("Masukkan password: ");
                        String password = scan.next();
                        if (motor.getPassword().contains(password)) {
                            System.out.println("Password benar");
                            method.keluar(motor.getNama(), motor.getNopol(), motor.getPassword(), motor.getWaktuMasuk());
                            arr.remove(motor);
                        } else {
                            System.out.println("Password salah");
                        }
                        break;
                    }
                }
                if (isExist == false) {
                    System.out.println("Motor tidak ditemukan");
                }

            } else if (Integer.parseInt(pilih) == 3) { // lihat daftar pengguna
                int index = 0;
                for (Motor motor : arr) {
                    System.out.println(motor.getNama());
                    index++;
                }
                if (index == 0) {
                    System.out.println("Maaf tidak ada data !");
                }

            } else if (Integer.parseInt(pilih) == 4) { // sorting daftar pengguna
                String[] data = new String[arr.size()];
                int index = 0;

                for (Motor motor : arr) {
                    data[index] = motor.getNama();
                    index++;
                }

                int compare;
                String tempt;
                for (int b = 0; b < data.length; b++) {
                    System.out.println(data[b]);
                }

                if (data.length == 0) {
                    System.out.println("Maaf tidak ada data !");
                } else {
                    System.out.println("---setelah sorting---");
                    for (int c = 0; c < data.length; c++) { // menggunakan bubble sort
                        for (int v = 1; v < data.length; v++) {
                            compare = data[v - 1].toLowerCase().compareTo(data[v].toLowerCase());
                            if (compare > 0) {
                                tempt = data[v - 1];
                                data[v - 1] = data[v];
                                data[v] = tempt;
                            }
                        }
                    }
                    for (int n = 0; n < data.length; n++) {
                        System.out.println(data[n]);
                    }
                }

            } else if (Integer.parseInt(pilih) == 5) { // cari pengguna
                System.out.println("Masukkan nama pengguna: ");
                String cariNama = scan.next()+ scan.nextLine();
                int ada = 0;
                for (Motor motor : arr) {
                    if(motor.getNama().toLowerCase().contains(cariNama.toLowerCase())) {
                        System.out.print("Nama  : "+ motor.getNama()+ "\nNopol : "+ motor.getNopol());
                        System.out.println();
                        ada++;
                    }
                }
                if (ada == 0) {
                    System.out.println("Maaf pengguna tidak ditemukan !");
                }

            } else if (Integer.parseInt(pilih) == 6) { // keluar dari program
                System.out.println("Terimakasih telah menggunakan aplikasi !");
                end = true;

            } else { // apabila inputan salah
                System.out.println("Salah inputan !");
            }
            System.out.println();
        }
    }
}
import java.util.Scanner;

public class MainAntrianKlinik {

    public static void menu() {
        System.out.println("Antrian Pembayaran Obat");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Hapus Pasien");
        System.out.println("3. Total Antrian");
        System.out.println("4. Cek waktu Antrian Pasien");
        System.out.println("5. Cek data pasien");
        System.out.println("6. Statistik Keluhan");
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        try (Scanner Nazario = new Scanner(System.in)) {
            try (Scanner Safariesqi = new Scanner(System.in)) {
                int wpk[] = {7, 5, 8, 4, 3, 11, 13, 6, 5};
                String daftarKeluhan[] = {"Demam", "Flu", "Sakit Kepala", "Asma", "Diare", "Sakit Gigi", "Sakit Mata", "Keseleo", "Susah Tidur"};
                int pilih, no;

                AntrianKlinik antrian = new AntrianKlinik();
                System.out.println("==========================================");
                System.out.println("Nazario Safariesqi Tyo Widjaya \t1941720233");
                System.out.println("==========================================\n\n");

                do {
                    menu();
                    System.out.print("Pilihan |>");
                    pilih = Nazario.nextInt();

                    AntrianKlinik data = new AntrianKlinik();
                    switch (pilih) {
                        case 1:
                            System.out.println("\n----------------\nPendataan Pasien");
                            System.out.print("Masukkan nama pasien: ");
                            data.nama = Safariesqi.nextLine();
                            System.out.println("\nDaftar keluhan\n-----------------");
                            for (int i = 0; i < 9; i++) {
                                System.out.println((i + 1) + ". " + daftarKeluhan[i]);
                            }
                            System.out.print("Pilih Keluhan: ");
                            int keluhan = Nazario.nextInt();
                            for (int i = 0; i < wpk.length; i++) {
                                if (i == (keluhan - 1)) {
                                    data.keluhan = daftarKeluhan[i];
                                    data.waktu = wpk[i];
                                    data.no = antrian.no += 1;
                                    break;
                                }
                            }
                            antrian.Enqueue(data);
                            break;
                        case 2:
                            antrian.Dequeue();
                            break;
                        case 3:
                            antrian.cekAntrian();
                            break;
                        case 4:
                            System.out.println("\nCek Antrian Pasien");
                            System.out.print("Masukkan nomor pasien: ");
                            no = Nazario.nextInt();
                            antrian.cekAntrianByNo(no);
                            break;
                        case 5:
                            Node tmp = antrian.Head;
                            System.out.println("Cek Data Pasien");
                            System.out.print("Daftar Antrian: ");
                            if (tmp != null) {
                                while (tmp != null) {
                                    System.out.print(tmp.data.no + " ");
                                    tmp = tmp.next;
                                }
                                System.out.println("");
                                System.out.print("Masukkan nomor pasien: ");
                                no = Nazario.nextInt();
                                antrian.cekPasienByNo(no);
                            } else {
                                System.out.println("Antrian masih kosong");
                            }
                            break;
                        case 6:
                            System.out.println("Statistik Keluhan");
                            antrian.statistikKeluhan();
                            break;
                        default:
                            System.out.println("Inputan salah!! Aplikasi keluar");
                    }
                } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || pilih == 6);
            }
        }
    }
}

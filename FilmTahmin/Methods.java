package practice.FilmTahmin;

public class Methods extends Depo {
    static int choice;
    static String secilenFilm;
    static StringBuilder filmBul;
    static int tahminSayisi;
    static int filmsecim;

    static void startMethod() {
        System.out.println(Green+"Film Tahmin oyununa hosgeldiniz");
        System.out.println(Red+"1- oyunu baslat\n2- oyunu kapat");
        oyunsecim = scan.nextInt();
        switch (filmsecim) {
            case 1:
                filmChoice();
                break;
            case 2:
                System.out.println("iyi gunler dileriz");
                break;
            default:
                System.out.println("yanlis secim yaptiniz");
                startMethod();
        }
    }

    private static void tahmin() {
        int counter = 1;
        int counter1 = 0;
        char tahminHarf;
        do {
            counter1 = 0;
            System.out.println("kalan tahmin sayisi = "+ tahminSayisi);
            System.out.println(counter + ". harfi giriniz");
            tahminHarf = scan.next().toUpperCase().charAt(0);
            for (int i = 0; i < secilenFilm.length(); i++) {
                if (secilenFilm.charAt(i) == tahminHarf) {
                    filmBul.setCharAt(i, tahminHarf);
                } else {
                    counter1++;
                }
            }


            if (counter1 == filmBul.length()) {
                System.out.println(Red+"Yanlis tahmin");
            }
            System.out.println(filmBul);
            counter++;
            tahminSayisi--;

            if (filmBul.toString().equals(film.get(secim - 1))) {
                System.out.println("Tebrikler Bildiniz");
                break;
            }

        } while (counter <= film.get(secim - 1).length() * 2);

        if (counter > film.get(secim - 1).length() * 2){
            System.out.println(Red+"Bilemediniz Tekrar deneyiniz");
        }


        startMethod();
    }

    private static void filmChoice() {
        System.out.println("1 - 10 arasinda bir sayi giriniz");
        secim = scan.nextInt();
        secimKontrol();
    }

    private static void secimKontrol() {
        if (secim < 1 || secim > 10) {
            System.out.println("Lutfen 1-10 arasinda bir rakam giriniz");
            filmChoice();
        }
        secilenFilm = film.get(secim - 1);
        filmBul = new StringBuilder(film.get(secim - 1));
        filmBul = new StringBuilder(filmBul.toString().replaceAll("\\w", "_"));
        System.out.println(filmBul);
        tahminSayisi = film.get(secim - 1).length() * 2;
        tahmin();
    }
}

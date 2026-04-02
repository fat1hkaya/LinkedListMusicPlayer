import java.util.Random;

public class Main {
    public static void main(String[] args){
        MuzikCalar app = new MuzikCalar();
        Random rand = new Random();
        String[] turler = {"Pop", "Rock", "Klasik"};

        int toplamSarki = 17;
        for (int i = 1; i <= toplamSarki; i++){
            app.sarkiEkle("Sarki"+i,
                    turler[rand.nextInt(3)],
                    120 + rand.nextInt(181),
                    rand.nextInt(1001));
        }
        app.listeYazdir("ORİJİNAL ANA LİSTE (17 DÜĞÜM)", app.head, false);

        app.turlerineAyir();
        app.listeYazdir("POP MÜZİK LİSTESİ", app.popHead, false);
        app.listeYazdir("ROCK MÜZİK LİSTESİ", app.rockHead, false);
        app.listeYazdir("KLASİK MÜZİK LİSTESİ", app.klasikHead, false);

        app.sureyeGoreSirala();
        app.listeYazdir("SÜREYE GÖRE SIRALANMIŞ YENİ LİSTE", app.siraliHead, false);

        app.enIyiAltiliDairesel();
        app.listeYazdir("EN YÜKSEK BEĞENİLİ 6 ŞARKI (DAİRESEL BAĞLANTI)", app.daireselHead, true);
    }
}
import java.util.ArrayList;
import java.util.List;

public class MuzikCalar {
    Sarki head = null;
    Sarki popHead = null, rockHead = null, klasikHead = null;
    Sarki siraliHead = null;
    Sarki daireselHead = null;

    public void sarkiEkle(String ad, String tur, int sure, int begeni) {
        Sarki yeniSarki = new Sarki(ad, tur, sure, begeni);
        if (head == null) {
            head = yeniSarki;
        } else {
            Sarki temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = yeniSarki;
        }
    }

    public void turlerineAyir(){
        Sarki temp = head;
        while (temp != null){
            Sarki yeni = new Sarki(temp.ad,temp.tur,temp.sure,temp.begeniSayisi);
            if (temp.tur.equalsIgnoreCase("Pop")) popHead = sonaEkle(popHead, yeni);
            else if (temp.tur.equalsIgnoreCase("Rock")) rockHead = sonaEkle(rockHead, yeni);
            else if (temp.tur.equalsIgnoreCase("Klasik")) klasikHead = sonaEkle(klasikHead, yeni);
            temp = temp.next;
        }
    }
    private Sarki sonaEkle(Sarki listeBasi, Sarki yeni) {
        if (listeBasi == null) return yeni;
        Sarki temp = listeBasi;
        while (temp.next != null) temp = temp.next;
        temp.next = yeni;
        return listeBasi;
    }

    public void sureyeGoreSirala(){
        Sarki temp = head;
        while (temp != null){
            Sarki yeni = new Sarki(temp.ad,temp.tur,temp.sure,temp.begeniSayisi);
            if (siraliHead == null || yeni.sure < siraliHead.sure){
                yeni.next = siraliHead;
                siraliHead = yeni;
            }else{
                Sarki curr = siraliHead;
                while (curr.next != null && curr.next.sure < yeni.sure) curr = curr.next;
                yeni.next = curr.next;
                curr.next = yeni;
            }
            temp = temp.next;
        }
    }

    public void enIyiAltiliDairesel(){
        List<Sarki> tumSarkilar = new ArrayList<>();
        Sarki temp = head;
        while (temp != null){
            tumSarkilar.add(temp);
            temp = temp.next;
        }
        tumSarkilar.sort((s1, s2) -> s2.begeniSayisi - s1.begeniSayisi);
        Sarki tail = null;
        for (int i = 0; i < 6 && i < tumSarkilar.size(); i++){
            Sarki s = tumSarkilar.get(i);
            Sarki yeni = new Sarki(s.ad, s.tur, s.sure, s.begeniSayisi);
            if (daireselHead == null){
                daireselHead = yeni;
                tail = yeni;
            } else{
                tail.next = yeni;
                tail = yeni;
            }
        }
        if (tail != null) tail.next = daireselHead;
    }

    public void listeYazdir(String baslik, Sarki baslangic, boolean dairesel){
        System.out.println("\n========== " + baslik + " ==========");
        if (baslangic == null){
            System.out.println("Liste boş.");
            return;
        }
        Sarki temp = baslangic;
        int count = 0;
        do {
            System.out.printf("Ad: %-8s  Tür: %-7s  Süre: %3d sn  Beğeni: %4d\n",
                    temp.ad, temp.tur, temp.sure, temp.begeniSayisi);
            temp = temp.next;
            count++;
            if(dairesel && count == 6) break;
        } while (temp != null && temp != baslangic);
    }
}

/**
 * Banka Hesap Yönetim Sistemi
 * Statik ve nesne tabanlı değişkenlerin kullanımını içeren uygulama.
 */
class Test2 {
    public static void main(String[] args) {
        BankaHesap murat = new BankaHesap(123, 1000, "Murat", "Çolakoğlu");
        BankaHesap emre = new BankaHesap(321, 1500, "Emre", "Özümağı");

        // İşlemler
        murat.paraYatir(500);
        emre.paraCek(200);

        // Kıyaslama ve Transfer testleri
        murat.kiyasla(emre);
        emre.paraGonder(murat, 100);    // Başarılı transfer
        emre.paraGonder(murat, 10000);  // Yetersiz bakiye testi

        // Bankanın genel durum özeti
        BankaHesap.bankaOzetGoster();
    }
}

public class BankaHesap {
    private int hesapNo;
    private int mevcutPara;
    private String isim;
    private String soyİsim;

    // Bankanın genelini tutan statik değişkenler
    private static int bankaBakiye = 0;
    private static int bankaUserSayisi = 0;
    private static int toplamIslemSayisi = 0;

    public BankaHesap(int hesapNo, int mevcutPara, String isim, String soyİsim) {
        this.hesapNo = hesapNo;
        this.mevcutPara = mevcutPara;
        this.isim = isim;
        this.soyİsim = soyİsim;

        // Yeni hesap açılınca banka geneline ekleme yapıyoruz
        bankaBakiye += mevcutPara;
        bankaUserSayisi++;
    }

    // Para yatırma işlemi
    public void paraYatir(int yatirilacakMiktar) {
        this.mevcutPara += yatirilacakMiktar;
        bankaBakiye += yatirilacakMiktar; // Banka kasası da artar
        toplamIslemSayisi++;
        System.out.println(this.isim + " hesabına " + yatirilacakMiktar + " TL yatırıldı.");
    }

    // Para çekme işlemi
    public void paraCek(int cekilecekMiktar) {
        if (this.mevcutPara >= cekilecekMiktar) {
            this.mevcutPara -= cekilecekMiktar;
            bankaBakiye -= cekilecekMiktar; // Banka kasasından düşer
            toplamIslemSayisi++;
            System.out.println(this.isim + " hesabından " + cekilecekMiktar + " TL çekildi.");
        } else {
            System.out.println("Hata: " + this.isim + " için bakiye yetersiz!");
        }
    }

    // İki hesabı para miktarına göre karşılaştırır
    public void kiyasla(BankaHesap digerHesap) {
        if (this.mevcutPara > digerHesap.mevcutPara) {
            System.out.println(this.isim + " hesabındaki para " + digerHesap.isim + " hesabından daha fazladır.");
        } else if (this.mevcutPara == digerHesap.mevcutPara) {
            System.out.println("İki hesabın bakiyesi eşittir: " + this.mevcutPara);
        } else {
            System.out.println(digerHesap.isim + " hesabındaki para " + this.isim + " hesabından daha fazladır.");
        }
    }

    // EFT/Havale işlemi
    public void paraGonder(BankaHesap gonderilecekHesap, int miktar) {
        if (this.mevcutPara >= miktar) {
            this.mevcutPara -= miktar;
            gonderilecekHesap.mevcutPara += miktar;
            toplamIslemSayisi++;
            // Banka bakiyesi değişmez çünkü para banka içinde el değiştiriyor
            System.out.println(this.isim + " -> " + gonderilecekHesap.isim + " hesabına " + miktar + " TL gönderdi.");
        } else {
            System.out.println("Transfer başarısız: " + this.isim + " bakiyesi yetersiz!");
        }
    }

    // Banka genel bilgilerini gösteren statik metot
    public static void bankaOzetGoster() {
        System.out.println("\n---- BANKA GENEL ÖZETİ ----");
        System.out.println("Toplam Mevduat: " + bankaBakiye + " TL");
        System.out.println("Kayıtlı Müşteri: " + bankaUserSayisi);
        System.out.println("Yapılan Toplam İşlem: " + toplamIslemSayisi);

    }

    // Getter ve Setter metotları
    public int getHesapNo() { return hesapNo; }
    public void setHesapNo(int hesapNo) { this.hesapNo = hesapNo; }

    public int getMevcutPara() { return mevcutPara; }
    public void setMevcutPara(int mevcutPara) { this.mevcutPara = mevcutPara; }

    public String getIsim() { return isim; }
    public void setIsim(String isim) { this.isim = isim; }

    public String getSoyİsim() { return soyİsim; }
    public void setSoyİsim(String soyİsim) { this.soyİsim = soyİsim; }

    public static int getBankaBakiye() { return bankaBakiye; }
    public static int getBankaUserSayisi() { return bankaUserSayisi; }
}
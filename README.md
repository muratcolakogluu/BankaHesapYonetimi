# Banka Hesap Yönetim Sistemi (Java OOP Çalışması) 

Bu proje, Java'da Nesne Yönelimli Programlama (OOP) mantığını anlamak, **static** değişkenlerin ve metotların kullanımını pekiştirmek amacıyla geliştirilmiştir. Bir banka simülasyonu üzerinden hesaplar arası para transferi, bakiye yönetimi ve banka genel durum takibi yapılmaktadır.

##  Özellikler

* **Hesap Yönetimi:** Her müşteri için benzersiz hesap numarası ve bakiye tanımlama.
* **Para İşlemleri:** Para yatırma, çekme ve hesaplar arası transfer (EFT/Havale) desteği.
* **Banka Genel Takibi:** `static` anahtar kelimesi kullanılarak tüm hesaplardan bağımsız olarak;
    * Bankadaki toplam mevduat miktarı,
    * Sistemdeki toplam kullanıcı sayısı,
    * Yapılan başarılı işlem sayısı anlık olarak takip edilir.
* **Kıyaslama:** İki farklı hesabın bakiyesini birbiriyle karşılaştıran mantıksal kontrol.

## Teknik Detaylar

Projeyi geliştirirken şu Java kavramlarına odaklanılmıştır:
- **Encapsulation (Kapsülleme):** Değişkenlerin `private` tutulması ve `getter/setter` metotları ile yönetilmesi.
- **Static Context:** Sınıfa özgü değişkenler (`static variable`) ile nesneye özgü değişkenlerin ayrımı.
- **Method Overriding:** Nesne tabanlı mantık kurgusu.



##  Nasıl Çalıştırılır?

1. Projeyi bilgisayarınıza klonlayın:
   ```bash
   git clone [https://github.com/kullaniciadi/proje-adiniz.git](https://github.com/kullaniciadi/proje-adiniz.git)

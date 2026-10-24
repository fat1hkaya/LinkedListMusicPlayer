# Linked List Music Player

Bağlı liste (linked list) yapılarıyla çalma listelerini yöneten, Java ile yazılmış bir müzik çalar simülasyonu. Program rastgele başlık, tür, süre ve puanla 17 şarkı üretir ve oluşan listeleri konsola yazdırır.

## Özellikler

- Türe (genre) göre şarkı gruplama
- Şarkıları süreye göre **Insertion Sort** ile sıralama
- En yüksek puanlı şarkılar için **dairesel bağlı liste** (circular linked list)

## Dosyalar

| Dosya | Görev |
|---|---|
| `src/Main.java` | Giriş noktası: örnek şarkıları üretir ve listeleri yazdırır |
| `src/MuzikCalar.java` | Bağlı liste işlemleri |
| `src/Sarki.java` | Şarkı düğümü (node) |

## Çalıştırma

**Gereksinim:** JDK

```bash
cd src
javac *.java
java Main
```


# Character Manager – Sprint #2
## TP5 / AP6 – Java Visual (SIH-6406)

**Nama:** Mutiara Fitri Salbilla Harahap  
**NIM:** 253303621258
**Universitas:** Universitas Prima Indonesia  
**Program Studi:** Sistem Informasi  
**Mata Kuliah:** Java Visual  
**Dosen:** Dr. Evta Indra  

---

## 1. Deskripsi Project

Character Manager Sprint #2 merupakan pengembangan
project Java yang berfokus pada pengelolaan objek
Character menggunakan konsep Object-Oriented Programming.

Project ini mengimplementasikan Encapsulation,
Object Reference, Method, ArrayList, Static,
dan Defensive Copy.

## 2. Fitur TP5

### Bagian A – Core Implementation

- equals() membandingkan nama karakter.
- addCharacter() menambahkan karakter.
- findByName() mencari karakter berdasarkan nama.
- removeCharacter() menghapus karakter.
- getTotalCharacters() menghitung jumlah karakter.
- getAllCharacters() mengembalikan salinan ArrayList.
- Nama duplikat ditolak.

### Bagian B – Mini Challenge

- getAverageLevel() menghitung rata-rata level.
- Mengembalikan 0.0 jika daftar kosong.
- findByType() mencari karakter berdasarkan tipe.
- Hasil pencarian dikembalikan dalam ArrayList baru.

### Bagian C – Fitur Analitik Mandiri

**findStrongest()**

Method ini digunakan untuk mencari karakter
dengan level tertinggi di dalam CharacterManager.

Fitur ini membantu pengguna mengetahui karakter
yang mempunyai level paling tinggi tanpa harus
memeriksa data satu per satu secara manual.

Method menggunakan perulangan untuk membandingkan
level setiap karakter. Jika daftar kosong,
method mengembalikan null.

Method tidak mengekspos ArrayList asli sehingga
Encapsulation tetap terjaga.

## 3. Konsep Object Reference

Variabel objek Java menyimpan reference yang
menunjuk ke objek di memory.

Ketika dua variabel menunjuk objek yang sama,
perubahan melalui salah satu variabel dapat
terlihat melalui variabel lainnya.

Defensive copy digunakan untuk mencegah
perubahan struktur ArrayList asli dari luar.

## 4. Pengujian Program

Pengujian yang dilakukan:

1. Menambahkan enam karakter.
2. Mencoba menambahkan nama duplikat.
3. Mencari karakter berdasarkan nama.
4. Menghapus karakter.
5. Menghitung rata-rata level.
6. Menguji rata-rata pada list kosong.
7. Mencari karakter berdasarkan tipe.
8. Mencari karakter dengan level tertinggi.
9. Menguji defensive copy menggunakan clear().
10. Menguji object reference menggunakan a dan b.
11. Menguji equals() berdasarkan nama.
12. Menguji static counter.

## 5. Screenshot Output

### Screenshot 1 – CRUD dan Duplikat
[Masukkan screenshot hasil program bagian CRUD]

### Screenshot 2 – Analytics
[Masukkan screenshot average level, findByType,
dan findStrongest]

### Screenshot 3 – Defensive Copy dan Reference
[Masukkan screenshot eksperimen copy.clear(),
a == b, dan perubahan level]

## 6. Google Docs – Analisis TP5

Link Google Docs:
[MASUKKAN LINK GOOGLE DOCS]

## 7. Kesimpulan

Melalui tugas ini, saya mempelajari pengelolaan
objek menggunakan ArrayList, penggunaan equals(),
perbedaan reference dan primitive value,
serta pentingnya Encapsulation dan Defensive Copy
dalam pengembangan program Java.

Project ini merupakan kelanjutan dari Sprint #1
dan dikembangkan dengan commit bertahap pada
repository GitHub yang sama.
https://docs.google.com/document/d/13Brw-Rnh_gnmQr_Pa52cmvyvZVHvio8fgmXFPbB8YJo/edit?usp=sharing
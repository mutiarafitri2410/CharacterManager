# Character Manager

## TP12 — Character Manager Sprint #5
**Layout, UI Responsif & Analisis MVC**

### 1. Tujuan
Pada Sprint #5 ini, aplikasi Character Manager dikembangkan dengan menggunakan Layout Manager pada Java Swing. Tujuannya adalah membuat tampilan aplikasi lebih terstruktur, rapi, dan responsif ketika ukuran jendela diubah.

### 2. Wireframe Aplikasi

```text
+---------------------------------------------------------------+
|                    CHARACTER MANAGER                          |
|             Kelola karakter, role, dan level                  |
|---------------------------------------------------------------|
| Total karakter | Rata-rata level | Level tertinggi | Terendah |
+-----------------------------------------------+---------------+
|                                               | LEGENDA ROLE  |
|  +----------------+  +----------------+       |               |
|  | Arjuna         |  | Merlin         |       | WARRIOR       |
|  | WARRIOR        |  | MAGE           |       | MAGE          |
|  | Level: 15      |  | Level: 25      |       | ARCHER        |
|  +----------------+  +----------------+       | HEALER        |
|                                               |               |
|  +----------------+  +----------------+       |               |
|  | Athena         |  | Luna           |       |               |
|  | ARCHER         |  | HEALER         |       |               |
|  | Level: 20      |  | Level: 18      |       |               |
|  +----------------+  +----------------+       |               |
|                                               |               |
+-----------------------------------------------+---------------+
| Character Manager | Siap digunakan                  v0.5      |
+---------------------------------------------------------------+
```

### 3. Implementasi Layout

Aplikasi menggunakan `BorderLayout` sebagai layout utama dengan empat wilayah, yaitu NORTH untuk header dan statistik, CENTER untuk daftar karakter, EAST untuk legenda role, dan SOUTH untuk status bar. Daftar karakter ditempatkan di dalam `JScrollPane` agar pengguna tetap dapat melihat seluruh kartu ketika jendela diperkecil.

Legenda menggunakan `BoxLayout` dengan arah Y_AXIS. Data legenda dibuat berdasarkan `CharacterType.values()` sehingga setiap role yang tersedia pada enum dapat ditampilkan tanpa menulis satu per satu secara manual.

### 4. Panel Tambahan

Panel statistik menggunakan `GridLayout(2, 2)` untuk menampilkan empat informasi, yaitu jumlah karakter, rata-rata level, level tertinggi, dan level terendah. `GridLayout` dipilih karena setiap informasi memiliki ruang yang sama dan tersusun rapi dalam dua baris dan dua kolom.

Saya tidak memilih `FlowLayout` untuk panel statistik karena susunan komponen dapat berpindah baris mengikuti ruang yang tersedia. Untuk informasi statistik, susunan yang konsisten lebih mudah dibaca.

### 5. Screenshot Pengujian

Simpan screenshot hasil aplikasi ke folder `screenshots/`, lalu masukkan gambar berikut ke repository.

**A. Ukuran awal**

![Screenshot ukuran awal](screenshots/tp12-awal.png)

**B. Jendela dilebarkan**

![Screenshot jendela dilebarkan](screenshots/tp12-lebar.png)

**C. Jendela dikecilkan sampai scrollbar terlihat**

![Screenshot jendela dikecilkan](screenshots/tp12-kecil.png)

### 6. Tabel Pengamatan Resize

| Kondisi | Prediksi | Hasil Pengamatan |
|---|---|---|
| Ukuran awal | Header, daftar, legenda, dan status bar terlihat | Isi sesuai hasil pengujian |
| Jendela dilebarkan | Area CENTER memperoleh ruang lebih besar | Isi sesuai hasil pengujian |
| Jendela dikecilkan | Daftar tetap dapat diakses melalui scrollbar | Isi sesuai hasil pengujian |

**Catatan:** Kolom hasil pengamatan harus diperbarui berdasarkan hasil pengujian aplikasi yang sebenarnya.

### 7. Struktur Panel Bersarang

Struktur tampilan menggunakan panel utama dengan `BorderLayout`. Panel NORTH berisi panel judul dan panel statistik yang menggunakan `GridLayout`. Panel CENTER berisi `JScrollPane`, yang menampung panel pembungkus dan panel kartu karakter. Panel EAST berisi legenda dengan `BoxLayout`, sedangkan panel SOUTH menampilkan status dan versi aplikasi.

### 8. Pengujian

Pengujian dilakukan dengan menjalankan aplikasi, mengamati susunan komponen pada ukuran awal, memperlebar jendela, kemudian memperkecil jendela sampai scrollbar terlihat. Pengujian juga memastikan delapan karakter ditampilkan dengan role dan level yang berbeda.

### 9. Analisis Layout dan MVC

Dokumen analisis Google Docs:

**[Masukkan link Google Docs TP12 di sini]**

### 10. Kesimpulan

Melalui Sprint #5, aplikasi Character Manager menggunakan Layout Manager untuk mengatur komponen secara lebih terstruktur. Penggunaan `BorderLayout`, `GridLayout`, `BoxLayout`, dan `JScrollPane` membantu menjaga tampilan tetap rapi ketika ukuran jendela berubah. Pemisahan package model dan view juga membuat pengelolaan data karakter tidak bergantung pada komponen antarmuka.

https://docs.google.com/document/d/13Brw-Rnh_gnmQr_Pa52cmvyvZVHvio8fgmXFPbB8YJo/edit?usp=sharing
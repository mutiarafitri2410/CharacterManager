## TP14 – Character Manager Sprint #6

### Form Input, Validasi & Analisis MVC

**Mata Kuliah:** Java Visual (SIH-6406)  
**Universitas:** Universitas Prima Indonesia  
**Program Studi:** Sistem Informasi  
**Tugas:** TP14 – AP19 Belajar Praktik

### A. Implementasi CharacterFormPanel

Pada TP14, aplikasi Character Manager dikembangkan dengan menambahkan form input karakter menggunakan Java Swing.

Form terdiri dari tiga komponen utama:
- `JTextField` untuk memasukkan nama karakter.
- `JComboBox<CharacterType>` untuk memilih role karakter.
- `JSpinner` untuk menentukan level karakter dari 1 sampai 99.

Form juga dilengkapi dengan tombol tambah karakter dan pesan validasi yang ditampilkan langsung pada aplikasi.

### B. Validasi Input

Validasi nama dilakukan melalui method `validateName()` dengan empat tahap:

1. Kelengkapan: nama tidak boleh kosong.
2. Panjang: nama maksimal 30 karakter.
3. Format: nama tidak boleh memiliki spasi ganda.
4. Keunikan: nama tidak boleh sama dengan karakter yang sudah tersimpan.

Input nama dibersihkan menggunakan `trim()`. Jika terjadi kesalahan, aplikasi menampilkan pesan di dekat form, memberikan border merah pada kolom nama, dan mengembalikan fokus ke kolom tersebut.

### C. Validasi Model dan Mini-Challenge

Validasi pada Model memastikan bahwa data tetap benar meskipun berasal dari luar form.

Aturan tambahan yang diterapkan:

- Karakter MAGE tidak boleh memiliki level di atas 60.
- Jumlah karakter dalam CharacterManager maksimal 20.

Kedua aturan tersebut diletakkan pada Model agar tetap berlaku meskipun data dimasukkan melalui sumber lain, seperti file JSON.

### D. Aturan Validasi Tambahan

**1. View – Larangan spasi ganda**

Nama karakter tidak boleh memiliki dua atau lebih spasi berturut-turut. Aturan ini ditempatkan di View karena berkaitan dengan format input yang dimasukkan pengguna.

**2. Model – Maksimal 20 karakter**

Jumlah karakter yang dapat disimpan dibatasi maksimal 20. Aturan ini ditempatkan di Model karena merupakan aturan pengelolaan data yang harus berlaku untuk semua sumber input.

### E. Tabel Pengujian

| No. | Input | Hasil Diharapkan | Hasil Nyata | Lapisan |
|---|---|---|---|---|
| 1 | Nama kosong | Ditolak | Isi setelah pengujian | View |
| 2 | Nama duplikat | Ditolak | Isi setelah pengujian | View/Model |
| 3 | Nama dengan spasi di awal/akhir | Diterima setelah trim | Isi setelah pengujian | View |
| 4 | Nama dengan spasi ganda | Ditolak | Isi setelah pengujian | View |
| 5 | Nama lebih dari 30 karakter | Ditolak | Isi setelah pengujian | View/Model |
| 6 | MAGE level 61 | Ditolak | Isi setelah pengujian | Model |
| 7 | MAGE level 60 | Diterima | Isi setelah pengujian | Model |
| 8 | Level 100 | Ditolak | Isi setelah pengujian | View |
| 9 | Nama karakter baru yang valid | Berhasil ditambahkan | Isi setelah pengujian | View dan Model |
| 10 | Menambahkan karakter ke-21 | Ditolak | Isi setelah pengujian | Model |

**Catatan pengujian:** Kolom hasil nyata harus diisi berdasarkan hasil pengujian langsung pada aplikasi. Jika hasil berbeda dari harapan, lakukan pemeriksaan pada validasi terkait dan perbaiki penyebabnya.

### F. Screenshot Pengujian

**1. Error nama kosong**

Masukkan screenshot ketika tombol tambah ditekan tanpa mengisi nama.

`![Error nama kosong](screenshots/TP14-kosong.png)`

**2. Error nama duplikat**

Masukkan screenshot ketika pengguna memasukkan nama karakter yang sudah terdaftar.

`![Error nama duplikat](screenshots/TP14-duplikat.png)`

**3. Sukses menambahkan karakter**

Masukkan screenshot setelah karakter baru berhasil ditambahkan dan muncul pada daftar.

`![Sukses tambah karakter](screenshots/TP14-sukses.png)`

### G. Kompromi Sementara pada Sprint Ini

Pada Sprint #6, aplikasi masih menggunakan `ActionListener` sederhana untuk menangani tombol tambah karakter. Selain itu, `CharacterFormPanel` masih memanggil `CharacterManager` secara langsung untuk menyimpan data. Pendekatan ini digunakan agar proses pembelajaran form dan validasi lebih mudah dipahami. Pada pengembangan berikutnya, tanggung jawab tersebut diharapkan dipindahkan ke Controller agar View dan Model memiliki pemisahan yang lebih baik.

### H. Google Docs – Analisis Input dan Validasi

**Link Google Docs:** [Masukkan link Google Docs TP14 di sini]

Dokumen tersebut berisi analisis tentang pemilihan komponen input, validasi format dan makna, validasi dua lapis, umpan balik kesalahan, serta hubungan View, Model, dan Controller.

---
https://docs.google.com/document/d/13Brw-Rnh_gnmQr_Pa52cmvyvZVHvio8fgmXFPbB8YJo/edit?usp=sharing
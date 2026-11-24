## TP8 – Character Manager Sprint #3

### MainWindow, Data Dinamis & Analisis MVC

**Mata Kuliah:** Java Visual (SIH-6406)  
**Universitas:** Universitas Prima Indonesia  
**Program Studi:** Sistem Informasi  
**Tugas:** TP8 – AP10 Belajar Praktik

### A. Implementasi MainWindow

Pada tugas TP8 ini, aplikasi Character Manager dikembangkan dari program berbasis console menjadi aplikasi berbasis GUI (Graphical User Interface) menggunakan Java Swing.

Aplikasi menggunakan class `MainWindow` yang mewarisi (`extends`) `JFrame`. Data karakter diterima dari `Main.java` melalui `CharacterManager`, kemudian ditampilkan secara dinamis menggunakan perulangan (`for-each loop`).

GUI dijalankan menggunakan `SwingUtilities.invokeLater()` agar proses pembuatan dan pengelolaan komponen Swing berjalan pada Event Dispatch Thread (EDT).

### B. Data Karakter

Aplikasi memiliki lima karakter:

| No. | Nama | Tipe | Level |
|---|---|---|---|
| 1 | Arjuna | WARRIOR | 5 |
| 2 | Merlin | MAGE | 3 |
| 3 | Athena | ARCHER | 4 |
| 4 | Hercules | WARRIOR | 8 |
| 5 | Luna | HEALER | 6 |

**Alasan pemilihan karakter tambahan:**

- Hercules dipilih sebagai WARRIOR karena menggambarkan karakter petarung dengan kemampuan fisik yang kuat. Level 8 menunjukkan kemampuan yang lebih tinggi.
- Luna dipilih sebagai HEALER karena menggambarkan karakter pendukung yang membantu memulihkan karakter lain. Level 6 menunjukkan kemampuan penyembuhan yang cukup baik.

### C. Mini-Challenge: Rata-rata Level

Aplikasi dilengkapi dengan JLabel statistik yang menampilkan rata-rata level seluruh karakter.

Perhitungan dilakukan dengan menjumlahkan level setiap karakter, kemudian membaginya dengan jumlah karakter.

Rumus:

Rata-rata Level = Total Level / Jumlah Karakter

Dengan lima karakter di atas:

(5 + 3 + 4 + 8 + 6) / 5 = 5,20

Hasil rata-rata level ditampilkan secara otomatis berdasarkan data karakter yang diterima oleh MainWindow.

### D. Screenshot Hasil Program

**1. Screenshot sebelum perubahan data**

Masukkan screenshot pertama di sini.

`![Screenshot sebelum perubahan](screenshots/sebelum.png)`

**2. Screenshot sesudah perubahan data**

Masukkan screenshot kedua di sini.

`![Screenshot sesudah perubahan](screenshots/sesudah.png)`

### E. Analisis Aliran Data dan MVC

Aliran data pada aplikasi dimulai dari `Main.java` yang membuat objek `CharacterManager` dan menambahkan data karakter. Selanjutnya, `CharacterManager` menyimpan serta mengelola kumpulan objek karakter menggunakan ArrayList. Data tersebut kemudian diberikan kepada `MainWindow` untuk ditampilkan melalui komponen GUI seperti JPanel dan JLabel.

Dalam konsep MVC (Model-View-Controller), bagian Model bertanggung jawab mengelola data karakter, sedangkan View bertanggung jawab menampilkan data kepada pengguna. Pada implementasi tugas ini, Main.java mengatur proses pembuatan data dan menghubungkan Model dengan View. Pemisahan tersebut membuat kode lebih terstruktur dan lebih mudah dikembangkan.

### F. Google Docs – Analisis GUI dan MVC

**Link Google Docs:** [Masukkan link Google Docs di sini]

Dokumen tersebut berisi analisis mengenai program sekuensial, event-driven programming, Event Dispatch Thread, JFrame, serta penerapan konsep MVC pada aplikasi Character Manager.

---
https://docs.google.com/document/d/13Brw-Rnh_gnmQr_Pa52cmvyvZVHvio8fgmXFPbB8YJo/edit?usp=sharing
# PROJEK AKHIR PBO

```
............................................  
Anggota:  
<a> 2109106037  Agustina Dwi Maharani
<a> 2109106039  Ibnu Yafi Arya Wardana
<k> 2109106040  Natalie Fuad
<a> 2109106042  Hadie Pratama Tulili

	<a> Anggota
	<b> Ketua
............................................  
```
    
 Program ini adalah sebuah program sistem manajemen pasar (KOREAN MARKET) yang terdiri dari **tiga jenis** user yaitu **Admin, Seller, dan Customer**.
    
Alur Menu:
    
```mermaid
graph 
A[Customer] -- 1 --> B(Toko-Toko)
B --99 --> BA(Kembali)
B -- <> --> BB(Pilih Toko)
BB -- 99 --> BBA(Kembali)
BB -- <> --> BBB(Pesan Produk)

A -- 2 --> C(Tas Belanja)
C -- 99 --> CA(Kembali)
C -- 0 --> CB(Lakukan Pembelian)
C -- <> --> CC(Keluarkan Barang dari Tas)

A -- 3 --> D(Riwayat Pembelian)
A -- 4 --> E(Ubah Profil)
E -- 0 --> EA(Kembali)
E -- 1 --> EB(Ubah Data Akun)
E -- 1 --> EC(Hapus Akun)

A -- 5 --> F(Log Out)
```
```mermaid
graph

A[Admin] -- 1 --> B(Manajemen Toko-Toko)
B --99 --> BA(Kembali)
B -- <> --> BB(Pilih Toko)
	BB -- 99 --> BBA(Kembali)
	BB -- 0 --> BBB(Manajemen Toko)
	BB -- <> --> BBC(Manajemen Produk Terpilih)
		BBC -- 99 --> BBCA(Kembali)
		BBC -- 1 --> BBCB(Ubah Produk)
		BBC -- 2 --> BBCC(Hapus Produk)

BBB -- 99 --> BBBA(Kembali)
BBB -- 1 --> BBBB(Ubah Informasi Toko)
BBB -- 2 --> BBBC(Manajemen Seller Toko)
	BBBC -- 99 --> BBBCA(Kembali)
	BBBC -- 1 --> BBBCB(Tambah Seller Toko)
	BBBC -- <> --> BBBCC(Hapus Seller Toko)
BBB -- 3 --> BBBE(Tambah Produk)
BBB -- 4 --> BBBF(Lihat Pesanan)
BBB -- 5 --> BBBG(Hapus Toko)

A -- 2 --> C(Manajemen Seller)
C -- 99 --> CA(Kembali)
C -- 0 --> CB(Tambah Akun Seller)
C -- <> --> CC(Hapus Akun Seller)

A -- 3 --> D(Riwayat Pembelian)
D -- 99 --> DA(Kembali)
D -- <> --> DB(Lihat Riwayat)
	DB -- 99 --> DBA(Kembali)
	DB -- 0 --> DBB(Hapus Riwayat)

A -- 4 --> E(Ubah Profil)

E -- 99 --> EA(Kembali)
E -- 1 --> EB(Ubah Data Akun)

A -- 5 --> F(Log Out)
```

```mermaid
graph

A[Seller] -- 1 --> B(Toko)
	B -- 99 --> BA(Kembali)
	B -- 0 --> BB(Manajemen Toko)
	B -- <> --> BC(Manajemen Produk Terpilih)
		BC -- 99 --> BCA(Kembali)
		BC -- 1 --> BCB(Ubah Produk)
		BC -- 2 --> BCC(Hapus Produk)

BB -- 99 --> BBA(Kembali)
BB -- 1 --> BBB(Ubah Informasi Toko)
BB -- 2 --> BBE(Tambah Produk)
BB -- 3 --> BBF(Lihat Pesanan)

A -- 2 --> C(Ubah Profil)
C -- 0 --> CA(Kembali)
C -- 1 --> CB(Ubah Data Akun)

A -- 3 --> D(Log Out)
```

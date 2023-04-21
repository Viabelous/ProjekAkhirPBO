# PROJEK AKHIR PBO
**Manajemen Korean Market**
```
............................................  
Contributors:

<Anggota> 	2109106037  Agustina Dwi Maharani 		{Seller, Produk}
<Anggota> 	2109106039  Ibnu Yafi Arya Wardana 		{Customer, Design UX}
 <Ketua>	2109106040  Natalie Fuad 			{Admin}
<Anggota>	2109106042  Hadie Pratama Tulili 		{Autentikasi, UI}
............................................  
```
**Program Manajemen Korean Market** adalah sebuah program multi-user tentang pasar terkait produk-produk Korea (Selatan) berisikan banyak toko yang masing-masingnya dapat diakses oleh Costumer untuk memilih dan membeli produk diinginkan.
    
Program ini terdiri dari **tiga jenis** user yaitu **Admin, Seller, dan Customer**:
- Akun **Admin** dibuat secara ***default*** sementara akun **Seller dibuat** atau diregistrasikan oleh **Admin** yang nantinya akan dimasukkan ke dalam Toko, satu toko dapat memiliki lebih dari satu Seller yang memanajemen toko tersebut.
Akun **Customer** diregistrasikan melalui menu landing.

- **Admin** satu-satunya yang dapat menambah Toko dan menambahkan seller ke dalam Toko agar Seller dapat memanajemen Toko. Admin juga dapat mengeluarkan Seller dari Toko ataupun menghapus Toko.

- **Admin dan Seller** dapat melakukan CRUD terhadap produk-produk yang dijual di Toko.
- **Customer** dapat memilih toko lalu melihat produk-produk yang dijual di toko tersebut dan memasukkan produk ke Tas Belanja.

       
## Alur Menu
Berikut ini dijabarkan alur menu utama setelah melakukan login sebagai Admin, Seller, atau Customer
> Tanda "<>" berarti merupakan opsi 1, 2, 3, ..., n sebanyak data yang ada, misal toko
> memiliki 5 buah produk, maka opsi <> adalah respon untuk opsi 1, 2, 3, 4, 5
    
 ### Menu Customer
```mermaid
graph 
A[Customer] -- 1 --> B(Toko-Toko)
B --99 --> BA(Kembali)
B -- <> --> BB(Pilih Toko)
	BB -- 99 --> BBA(Kembali)
	BB -- <> --> BBB(Pesan Produk)

A -- 2 --> C(Tas Belanja)
C -- 99 --> CA(Kembali)
C -- 0 --> CB(Hapus Invalid)
C -- <> --> CC(Proses Barang)
	CC -- 99 --> CCA(Kembali)
	CC -- 1 --> CCB(Ubah Jumlah)
	CC -- 2 --> CCC(Proses Pesan)

A -- 3 --> D(Riwayat Pembelian)
A -- 4 --> E(Ubah Profil)
E -- 99 --> EA(Kembali)
E -- 1 --> EB(Ubah Data Akun)
E -- 2 --> EC(Hapus Akun)

A -- 5 --> F(Log Out)
```
  
### Menu Admin
```mermaid
graph

A[Admin] -- 1 --> B(Manajemen Toko-Toko)
B --99 --> BA(Kembali)
B -- 0 --> BB(Tambah Toko)
B -- <> --> BC(Pilih Toko)
	BC -- 99 --> BCA(Kembali)
	BC -- 0 --> BCB(Manajemen Toko)
	BC -- <> --> BCC(Manajemen Produk Terpilih)
		BCC -- 99 --> BCCA(Kembali)
		BCC -- 1 --> BCCB(Ubah Produk)
		BCC -- 2 --> BCCC(Hapus Produk)

BCB -- 99 --> BCBA(Kembali)
BCB -- 1 --> BCBB(Ubah Informasi Toko)
BCB -- 2 --> BCBC(Manajemen Seller Toko)
	BCBC -- 99 --> BCBCA(Kembali)
	BCBC -- 0 --> BCBCB(Tambah Seller Toko)
	BCBC -- <> --> BCBCC(Hapus Seller Toko)
BCB -- 3 --> BCBE(Tambah Produk)
BCB -- 4 --> BCBF(Lihat Pesanan)
BCB -- 5 --> BCBG(Hapus Toko)

A -- 2 --> C(Manajemen Seller)
C -- 99 --> CA(Kembali)
C -- 0 --> CB(Tambah Akun Seller)
C -- <> --> CC(Hapus Akun Seller)

A -- 3 --> D(Riwayat Pembelian)
D -- 99 --> DA(Kembali)
D -- <> --> DB(Lihat Riwayat)
	DB -- 99 --> DBA(Kembali)
	DB -- 1 --> DBB(Hapus Riwayat)

A -- 4 --> E(Ubah Profil)

E -- 99 --> EA(Kembali)
E -- 1 --> EB(Ubah Data Akun)

A -- 5 --> F(Log Out)
```
  
  ### Menu Seller
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
C -- 99 --> CA(Kembali)
C -- 1 --> CB(Ubah Data Akun)

A -- 3 --> D(Log Out)
```

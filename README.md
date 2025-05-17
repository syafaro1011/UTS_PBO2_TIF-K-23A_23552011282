# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: Syaiful Fathur Rozaq</li>
  <li>NIM: 23552011282</li>
  <li>Studi Kasus: Sistem Todo List Fullstack (Spring Boot + Thymeleaf)</li>
</ul>

## Judul Studi Kasus
<p>Sistem Todo List Fullstack (Spring Boot + Thymeleaf)</p>

## Penjelasan Studi Kasus
<p>Universitas Teknologi Bandung (UTB) ingin membangun sebuah sistem manajemen tugas (Todo List) berbasis web. Sistem ini akan digunakan oleh mahasiswa dan dosen untuk mencatat dan mengelola daftar tugas pribadi mereka secara online. Sistem akan dibangun menggunakan teknologi Java Spring Boot untuk backend dan Thymeleaf untuk frontend, dengan pendekatan fullstack berbasis MVC (Model-View-Controller).</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>Mewarisi properti dan perilaku dari class lain serta memungkinkan penggunaan kembali kode. Dalam studi kasus di class UserDetailsServiceImpl mewarisi interface dari Spring Security, dan harus mengimplementasikan method loadUserByUsername.</p>

### 2. Encapsulation
<p>Menyembunyikan detail sebuah objek dan hanya mengekspos antarmuka publik yang diperlukan. Biasanya dilakukan dengan menjadikan atribut private dan menyediakan getter / setter. Dalam studi kasus semua field di class ToDo dan User bersifat private dan hanya bisa diakses melalui method publik (getTask(), setTask(), dll). Ini melindungi data dari akses langsung yang tidak sah dan memungkinkan kontrol penuh atas data.</p>

### 3. Polymorphism
<p>Kemampuan objek untuk mengambil banyak bentuk, biasanya lewat pewarisan. </p>
<p>UserDetails userDetails = userDetailsService.loadUserByUsername(username);</p>
<p>Pada sistem todo list variabel userDetails bertipe UserDetails, tapi objek nyatanya adalah hasil implementasi dari UserDetailsServiceImpl. </p>

### 4. Abstract
<p>Menyembunyikan kompleksitas dan hanya menampilkan fungsionalitas penting. Biasanya diwujudkan dalam bentuk interface atau class abstract.</p>
<p>public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}</p>
<p>Pada sistem todo list UserRepository tidak mengimplementasikan method apapun secara langsung, tetapi Spring Data JPA akan menghasilkan implementasi secara otomatis di balik layar.</p>


## Demo Proyek
<ul>
  <li>Github: <a href="">Github</a></li>
  <li>Youtube: <a href="">Youtube</a></li>
</ul>

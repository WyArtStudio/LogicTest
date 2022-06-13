class Main {

    companion object {

        /**
         * Fungsi Valid String
         *
         * Sebuah String dikatakan valid jika memenuhi kriteria berikut :
         * 1. Semua karakter dalam string muncul dalam jumlah yang sama, atau.
         * 2. Jika dengan menghapus satu karakter, dapat memenuhi kriteria nomor 1,
        makan string masih bisa dikatakan valid.
         */
        private fun isValidString(string1: String): Boolean {
            // Inisialisasi map
            val map: MutableMap<Char, Int> = HashMap()

            // Memasukkan data string ke dalam map menggunakan perulangan
            for (i in string1.indices) {
                // Huruf pada string bertindak sebagai key, dan banyaknya perulangan huruf bertindak sebagai value
                // Nilai dari perulangan huruf tersebut diambil dari nilai map dengan key huruf sebelumnya,
                // kemudian ditambah 1 karena telah mengalami loop
                map[string1[i]] = map.getOrDefault(string1[i], 0).plus(1)
            }

            // Inisialisasi iterator
            val itr: Iterator<Int> = map.values.iterator()

            // Deklarasi variabel

            // Variabel yang mengecek frekuensi pertama
            var firstCheck = true

            // Variabel yang mengecek frekuensi kedua
            var secondCheck = true

            // Nilai dari frekuensi pertama
            var firstFrequency = 0

            // Nilai dari frekuensi pertama
            var secondFrequency = 0

            // Jumlah huruf yang memiliki frekuensi sebanyak frekuensi pertama
            var countOfFirstFreq = 0

            // Jumlah huruf yang memiliki frekuensi sebanyak frekuensi kedua
            var countOfSecondFreq = 0

            // Perulangan jika iterator masih memiliki elemen selanjutnya
            while (itr.hasNext()) {

                // Nilai i adalah nilai dari elemen selanjutnya tersebut
                val i = itr.next()

                // jika kondisi firstCheck true, maka nilai dari firstFrequency sama dengan elemen i,
                // atau bisa dibilang nilai dari frekuensi pertama
                if (firstCheck) {
                    firstFrequency = i

                    // firstCheck false sehingga perulangan berikutnya nilai firstCheck tidak akan berubah
                    firstCheck = false

                    // Menambah jumlah huruf yang memiliki frekuensi sama dengan firstFrequency
                    countOfFirstFreq++
                    continue
                }

                // Jika nilai elemen i sama dengan firstFrequency, maka jumlah huruf yang berfrekuensi
                // firstFrequency ditambah 1 lalu lanjut loop berikutnya jika memungkinkan
                if (i == firstFrequency) {
                    countOfFirstFreq++
                    continue
                }

                // jika kondisi secondCheck true, maka nilai dari secondFrequency sama dengan elemen i,
                // atau bisa dibilang nilai dari frekuensi kedua
                if (secondCheck) {
                    secondFrequency = i

                    // secondCheck false sehingga perulangan berikutnya nilai firstCheck tidak akan berubah
                    secondCheck = false

                    // Menambah jumlah huruf yang memiliki frekuensi sama dengan secondFrequency
                    countOfSecondFreq++
                    continue
                }

                // Jika nilai elemen i sama dengan secondFrequency, maka jumlah huruf yang berfrekuensi
                // secondFrequency ditambah 1 lalu lanjut loop berikutnya jika memungkinkan
                if (i == secondFrequency) {
                    countOfSecondFreq++
                    continue
                }
            }

            // True jika hanya terdapat 1 karakter yang 'anomali' (jika dihapus 1 menjadi frekuensi sejenis)
            return countOfFirstFreq <= 1 || countOfSecondFreq <= 1
        }

        /**
         * Fungsi Rotasi Kiri
         *
         * Rotasi Kiri adalah sebuah operasi yang di lakukan didalam sebuah array yang
         * mana kita akan menggeser element dari array tersebut sejumlah x baris ke
         * sebelah kiri.
         * misal : original array : 1,2,3,4,5,6 .
         * lakukan rotasi kiri sebanyak 3x.
         * maka rotated array : 4,5,6,1,2,3
         */
        private fun rotateLeft(arrayInt: IntArray, numOfRotation: Int) {

            // Menampilkan array asli sebelum dirotasi
            print("Original array: ")
            for (i in arrayInt.indices) {
                print(arrayInt[i].toString() + " ")
            }

            // Merotasi array ke kiri sebanyak numOfRotation
            for (i in 0 until numOfRotation) {
                // Mengambil nilai paling kiri dari array
                val first: Int = arrayInt[0]

                var j = 0
                // Menginput array sebanyak panjang array
                while (j < arrayInt.size - 1) {
                    // Memasukan nilai baru pada array dengan mengambil nilai dari index selanjutnya satu per satu
                    arrayInt[j] = arrayInt[j + 1]
                    j++
                }

                // Elemen pertama array sebelumnya akan ditempatkan di akhir array (paling kanan)
                arrayInt[j] = first

            }

            // Menampilkan hasil array yang telah dirotasi ke kiri
            print("\nRotated array: ")
            for (i in arrayInt.indices) {
                print(arrayInt[i].toString() + " ")
            }
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println("Question 1: ")
            println(isValidString("aabbccddeefghi"))
            println(isValidString("abcdefghhgfedecba"))
            println(isValidString("abcbdcd"))

            println("\nQuestion 2:")
            rotateLeft(intArrayOf(2,3,5,1,2,3,9,8), 5)
        }
    }
}
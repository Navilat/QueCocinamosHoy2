package id.creatorb.resep;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_Resep extends SQLiteOpenHelper {
	final static String DB_NAME = "db_resep";

	public DB_Resep(Context context) {
		super(context, DB_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE IF NOT EXISTS resep(_id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, bahan TEXT, cara TEXT, img BLOB)";
		db.execSQL(sql);

		ContentValues values = new ContentValues();
		values.put("_id", "1");
		values.put("nama", "ALBÓNDIGAS DE CERDO Y QUINOA");
		values.put("bahan", "1/2 taza de quinoa\n" +
				"500 gramos de cerdo molido\n" +
				"6 cebollines picados finos parte blanca y 3cm. de la verde\n" +
				"2 huevos\n" +
				"1 cucharadita de sal gruesa\n" +
				"1/2 cucharadita de orégano seco\n" +
				"1/2 cucharadita de comino");
		values.put("cara","Precalienta tu horno a 425F o 210C. Cubre la lata del horno con papel aluminio o pergamino.\n" +
				"Lava la quinoa en un colador bajo agua corriendo hasta que deje de salir espuma. Coloca en una olla pequeña con 1 taza de agua, pizca de sal, revuelve y cocina a fuego medio-alto. Apenas suelte el hervor, baja el fuego al mínimo y cocina por 15 minutos. Destapa, revuelve con un tenedor y separa.\n" +
				"En un bol coloca los huevos, la sal, orégano y comino, bate 20 segundos con un tenedor agrega el cerdo molido y la quinoa. Mezcla muy bien.\n" +
				"Con una cuchara saca porciones de la mezcla y forma las albóndigas de un tamaño similar a una bola de golf. Coloca ordenadas en la lata de horno y hornea por 15 minutos. La temperatura interna debe ser superior a 165F o 73C.\n" +
				"Sirve caliente o tibias.");
		values.put("img", R.drawable.buburcandil);
		db.insert("resep", "_id", values);

		values.put("_id", "2");
		values.put("nama", "Donat Mini");
		values.put("bahan", "Tepung terigu 140 gram, Tepung maizena 1 sdm, Gula pasir 1 sdm,  Air 120 ml, Ragi instan 1 sdt, Baking powder 1 sdt");
		values.put("cara","Siapkan bahan. Masukkan tepung terigu,maizena dan gula,BP ke dalam wadah, aduk secara meratarata. Kemudian Larutkan ragi ke dalam air dan campur dengan tepung. Tambahkan sedikit air demi sedikit dan uleni sampai kalis. Air tidak harus dipakai semua bergantung pada adonan nya. Diamkan 30 menit lalu bentuk bulat dan biarkan lagi 15 menit. Goreng dgn api kecil sedang sambil siram minyak ke bagian atas donat s/d kecoklatan. Tim DCC hingga leleh, celup donat dan taburi meises/ kacang sesuai selera. Kini donat mini siap dinikmati");
		values.put("img", R.drawable.donatmini);
		db.insert("resep", "_id", values);
		
		values.put("_id", "3");
		values.put("nama", "Tumis Buncis Telor");
		values.put("bahan", "Buncis	1 bungkus, Telur 1 butir, Bawang putih 2 siung, Minyak untuk menumis 2 sendok makan, Merica	secukupnya, Garam secukupnya, Kecap asin secukupnya");
		values.put("cara", "Bersihkan buncis dan potong kedua ujung lalu dibagi 3. Geprek bawang putih dan cincang halus. Siapkan wajan dan diberi minyak lalu tumis bawang putih hingga harum. Setelah itu masukan buncis dan aduk rata selama kurleb 2 menit. Masukan telur yang sudah dikocok dan apinya jangan terlalu besar. Beri merica, garam dan kecap asin lalu aduk rata selama kurleb 2 menit. Angkat dan sajikan.");
		values.put("img", R.drawable.tumisbuncistelor);
		db.insert("resep", "_id", values);
		
		values.put("_id", "4");
		values.put("nama", "Terong Balado");
		values.put("bahan", "Terong ungu 3 buah. Cabe merah keriting 100 gram. Bawang merah 10 butir. Tomat	0,5 buah. Jeruk nipis 0,5 buah. Gula secukupnya. Garam secukupnya");
		values.put("cara", "Potong-potong terong menjadi 4 bagian. Jangan potong terong terlalu tipis, karena akan sangat berminyak. Goreng terong hingga bagian putih berubah kecoklatan. Haluskan dengan blender hingga benar-benar halus: Cabai merah keriting, bawang merah dan garam. Tomat dipotong dadu kecil. Tiriskan minyak bekas menggoreng terong dan sisakan secukupnya untuk menumis. Iris bawang merah lalu tumis dengan minyak bekas menggoreng terong tadi hingga setengah matang. Masukkan gilingan cabai dan bawang merah lalu masak hingga tidak lagi berbau langu. Lalu tambahkan air perasan jeruk nipis. Kecilkan api, lalu masukkan terong. Aduk hingga semua terong tertutup dengan sambal lado. Angkat dan sajikan. Sangat cocok dimakan dengan nasi putih hangat.");
		values.put("img", R.drawable.terongbalado);
		db.insert("resep", "_id", values);
		
		values.put("_id", "4");
		values.put("nama", "Cumi Tumis Kecap");
		values.put("bahan", "Cumi-cumi besar, bersihkan dan potong 2 ekor. Kecap Manis 5 sendok makan. Garam secukupnya. Daun Jeruk 4 lembar. Daun salam 2 lembar. Bawang Bombay, iris sabit 1/2 siung Bawang Putih, iris tipis	2 siung. Olive oil secukupnya");
		values.put("cara", "Tumis bawang bombay, bawang putih, daun jeruk, dan daun salam dengan olive oil hingga harum. Masukkan cumi, lalu tutup dan masak dengan api kecil hingga cumi berair, buka dan aduk aduk, masak terus hingga airnya berkurang. Masukkan garam dan kecap manis, aduk hingga rata. Masak terus sambil diaduk hingga kecap mendidih dan mengental seperti karamel. Angkat dan sajikan.");
		values.put("img", R.drawable.cumitumiskecap);
		db.insert("resep", "_id", values);
		
		values.put("_id", "5");
		values.put("nama", "Nasi Uduk Rempah");
		values.put("bahan", "Beras putih 300 gram. Santan dari 1/4 butir kelapa 500 ml. Garam 1 sendok teh. Serai 1 batang. Cengkeh 2 biji. Daun salam 2 lembar. Kayu manis	1,5 cm. Daun pandan 1 lembar. Makanan Pendamping. Ayam goreng 1 potong. Serundeng 1 sendok makan. Telur dadar secukupnya. Sambal kemiri 1 sendok teh.");
		values.put("cara", "Campur beras dengan semua bahan kecuali daun pandan. Masak sambil sesekali diaduk hingga santan susut. Angkat. Masukkan pandan kedalam air untuk mengukus, pasang sekat kemudian masukkan nasi aron. Kukus +/- 20 menit hingga matang. Sajikan bersama makanan pendamping dan kini siap dinikmati.");
		values.put("img", R.drawable.nasiudukrempah);
		db.insert("resep", "_id", values);
		
		values.put("_id", "6");
		values.put("nama", "Perkedel Jagung");
		values.put("bahan", "Jagung	4 buah. Bawang merah 3 butir. Bawang putih 2 siung. Cabai rawit	5 biji. Daun bawang	2 batang. Daun seledri 1 batang. Garam 1 sendok teh. Gula 1 secukupnya. Penyedap secukupnya. Telur kocok 1 butir. Tepung terigu	3 sendok makan. Merica bubuk 1 sendok teh.");
		values.put("cara", "Pipil jagung lalu haluskan. Haluskan bawang merah,bawang putih,cabai,lalu masukan dalam adonan jagung,Tambahkan daun bawang,daun seledri yg telah diiris halus. Kocok telur kemudian masukan dalam adonan jagung,tambah terigu,garam,gula dan merica. tambahkan penyedap,lalu goreng hingga kuning kecoklatan. Selamat mencoba");
		values.put("img", R.drawable.perkedeljagung);
		db.insert("resep", "_id", values);
		
		values.put("_id", "7");
		values.put("nama", "Udang Mentega");
		values.put("bahan", "Udang jerbung 250 gram. Jeruk nipis 1 buah. Garam 1 sendok teh. Bubuk bawang putih	secukupnya. Mentega	1.5 sendok makan. Minyak goreng	1 sendok makan. Basil kering secukupnya. Oregano kering	secukupnya. Thyme kering secukupnya. Rosemary kering secukupnya");
		values.put("cara", "buang kepala udang jerbung, jangan kupas kulitnya karena memasak udang dengan kulitnya akan mempertahankan rasa manis dari udang itu sendiri. Campur udang dengan air perasan jeruk nipis, garam, bawang putih bubuk dan semua rempah kering. Marinate paling sebentar 5 menit. Panaskan minyak dan mentega hingga mentega meleleh. Masukkan udah dan masak hingga udang berubah warna menjadi merah. Jangan masak udang terlalu lama karena nanti jadi keras. Sajikan dengan saus sambal botolan.");
		values.put("img", R.drawable.udangrempahmentega);
		db.insert("resep", "_id", values);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS resep");
		onCreate(db);

	}

}
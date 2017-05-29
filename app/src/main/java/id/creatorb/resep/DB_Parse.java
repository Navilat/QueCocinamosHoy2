package id.creatorb.resep;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

public class DB_Parse extends Activity {
	ImageView Im;
	TextView tv_nama, tv_bahan, tv_cara, id;
	Gallery gallery;
	ImageSwitcher imageSwitcher;
	Integer[] imageIDs = new Integer[3];
	int msg_im;
    SQLiteDatabase db;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resep);
        db = (new DB_Resep(this)).getWritableDatabase();

		Intent iIdentifikasi = getIntent();
		msg_im = iIdentifikasi.getIntExtra("dataIM", 0);
		String msg_nama = iIdentifikasi.getStringExtra("dataNama");
		String msg_bahan = iIdentifikasi.getStringExtra("dataBahan");
		String msg_cara = iIdentifikasi.getStringExtra("dataCara");
		String msg_id = iIdentifikasi.getStringExtra("dataId");

		Im = (ImageView) findViewById(R.id.iv_detail);
		tv_nama = (TextView) findViewById(R.id.tvNama);
		tv_bahan = (TextView) findViewById(R.id.tvBahan);
		tv_cara = (TextView) findViewById(R.id.tvCara);
		id = (TextView) findViewById(R.id.id_temp);

		Im.setImageResource(msg_im);
		tv_nama.setText(msg_nama);
		tv_bahan.setText(msg_bahan);
		tv_cara.setText(msg_cara);
		id.setText(msg_id);


	}

    /*
    Método para eliminar la receta
     */
    public void del_receta(View v) {

		//Se lee el campo ID
        String del_db = id.getText().toString();

		Log.d(getLocalClassName(), "Intentando borrar receta con id: " + del_db);

		//Se guarda ID en un Intent y se cierra el activity (i.e., se envía ID al main activity)
		Intent intent = new Intent();
		intent.putExtra("id_del", del_db);
		setResult(RESULT_OK, intent);
		finish();
    }
}
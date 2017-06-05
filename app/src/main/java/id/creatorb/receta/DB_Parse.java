package id.creatorb.receta;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

public class DB_Parse extends Activity {
	ImageView Im;
	TextView tv_nombre, tv_ingredientes, tv_pasos, id;
	ImageSwitcher imageSwitcher;
	Integer[] imageIDs = new Integer[3];
	int msg_im;
    SQLiteDatabase db;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.receta);
        db = (new DB_Receta(this)).getWritableDatabase();

		Intent iIntent = getIntent();
		msg_im = iIntent.getIntExtra("dataIM", 0);
		String msg_nombre = iIntent.getStringExtra("dataNombre");
		String msg_ingredientes = iIntent.getStringExtra("dataIngredientes");
		String msg_pasos = iIntent.getStringExtra("dataPasos");
		String msg_id = iIntent.getStringExtra("dataId");

		Im = (ImageView) findViewById(R.id.iv_detail);
		tv_nombre = (TextView) findViewById(R.id.tvNombre);
		tv_ingredientes = (TextView) findViewById(R.id.tvIngredientes);
		tv_pasos = (TextView) findViewById(R.id.tvPasos);
		id = (TextView) findViewById(R.id.id_temp);

		Im.setImageResource(msg_im);
		tv_nombre.setText(msg_nombre);
		tv_ingredientes.setText(msg_ingredientes);
		tv_pasos.setText(msg_pasos);
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
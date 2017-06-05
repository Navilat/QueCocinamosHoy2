package id.creatorb.receta;

import android.content.ContentValues;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	protected ListView lv;
	protected ListAdapter adapter;
	SQLiteDatabase db;
	Cursor cursor;
	EditText et_db;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		db = (new DB_Receta(this)).getWritableDatabase();
		lv = (ListView) findViewById(R.id.lv);
		et_db = (EditText) findViewById(R.id.et);

		try {
			cursor = db.rawQuery("SELECT * FROM receta ORDER BY nombre ASC", null);
			adapter = new SimpleCursorAdapter(this, R.layout.isi_lv, cursor,
					new String[] { "nombre", "ingredientes", "pasos" }, new int[] {
							R.id.tv_nombre, R.id.tvIngredientes, R.id.imV });
			lv.setAdapter(adapter);
			lv.setTextFilterEnabled(true);
			lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View v,
						int position, long id) {
					detail(position);

				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	public void search_db(View v) {
		String edit_db = et_db.getText().toString();
		if (!edit_db.equals("")) {
			try {
				cursor = db.rawQuery("SELECT * FROM receta WHERE nombre LIKE ?",
						new String[] { "%" + edit_db + "%" });
				adapter = new SimpleCursorAdapter(
						this,
						R.layout.isi_lv,
						cursor,
						new String[] { "nombre", "ingredientes", "img" },
						new int[] { R.id.tv_nombre, R.id.tvIngredientes, R.id.imV });
				if (adapter.getCount() == 0) {
					Toast.makeText(
							this,
							"No se encontró ninguna receta con el nombre " + edit_db
									+ "", Toast.LENGTH_SHORT).show();
				} else {
					lv.setAdapter(adapter);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				cursor = db.rawQuery("SELECT * FROM receta ORDER BY nombre ASC",
						null);
				adapter = new SimpleCursorAdapter(
						this,
						R.layout.isi_lv,
						cursor,
						new String[] { "nombre", "ingredientes", "img" },
						new int[] { R.id.tv_nombre, R.id.tvIngredientes, R.id.imV });
				lv.setAdapter(adapter);
				lv.setTextFilterEnabled(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	Método llamado al seleccionar "Nueva Receta"
	 */
	@SuppressWarnings("deprecation")
	public void nueva_receta(View v) {
		Log.d(getLocalClassName(), "Creando nueva receta - Click");
		ContentValues values = new ContentValues();
		values.put("nombre", "Calzones Rotos");
		values.put("ingredientes", "Ingredientes CR");
		values.put("pasos","Pasos a seguir CR");
		values.put("img", R.drawable.albondigas_de_cerdo_y_quinoa); //Cambiar luego
		db.insert("receta", "_id", values);
	}

	public void detail(int position) {
		int im = 0;
		String _id = "";
		String nombre = "";
		String ingredientes = "";
		String pasos = "";
		if (cursor.moveToFirst()) {
			cursor.moveToPosition(position);
			im = cursor.getInt(cursor.getColumnIndex("img"));
			nombre = cursor.getString(cursor.getColumnIndex("nombre"));
			ingredientes = cursor.getString(cursor.getColumnIndex("ingredientes"));
			pasos = cursor.getString(cursor.getColumnIndex("pasos"));
			_id = cursor.getString(cursor.getColumnIndex("_id"));
		}

		Intent iIntent = new Intent(this, DB_Parse.class);
		iIntent.putExtra("dataIM", im);
		iIntent.putExtra("dataNombre", nombre);
		iIntent.putExtra("dataIngredientes", ingredientes);
		iIntent.putExtra("dataPasos", pasos);
		iIntent.putExtra("dataId", _id);
		setResult(RESULT_OK, iIntent);
		startActivityForResult(iIntent, 99); //RESULT_CODE de detalle: 99
	}

	// Llamado cuando se cierra el activity de Detalle
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		//Se verifica que es el activity de Detalle con RESULT_OK
		if (requestCode == 99) {
			if (resultCode == RESULT_OK) {

				int res;

				String id_del = data.getStringExtra("id_del").trim();

				Log.d(getLocalClassName(), "Intentando borrar receta con id: " + id_del + "en el Main Activity");

				//Borrar receta
				try{
					res = db.delete("receta", "_id = ?",
							new String[] { id_del });
					//res = db.delete("receta", "_id='" + 9 + "'", null);
					Log.d(getLocalClassName(), "Resultado operacion Delete: " + res);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
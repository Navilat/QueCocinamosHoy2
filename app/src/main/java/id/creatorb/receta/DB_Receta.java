package id.creatorb.receta;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_Receta extends SQLiteOpenHelper {
	final static String DB_NAME = "db_receta";

	public DB_Receta(Context context) {
		super(context, DB_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE IF NOT EXISTS receta(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, ingredientes TEXT, pasos TEXT, img BLOB)";
		db.execSQL(sql);

		ContentValues values = new ContentValues();
		values.put("_id", "1");
		values.put("nombre", "Albóndigas de cerdo y quinoa");
		values.put("ingredientes", "1/2 taza de quinoa\n" +
				"500 gramos de cerdo molido\n" +
				"6 cebollines picados finos parte blanca y 3cm. de la verde\n" +
				"2 huevos\n" +
				"1 cucharadita de sal gruesa\n" +
				"1/2 cucharadita de orégano seco\n" +
				"1/2 cucharadita de comino");
		values.put("pasos","Precalienta tu horno a 425F o 210C. Cubre la lata del horno con papel aluminio o pergamino.\n" +
				"Lava la quinoa en un colador bajo agua corriendo hasta que deje de salir espuma. Coloca en una olla pequeña con 1 taza de agua, pizca de sal, revuelve y cocina a fuego medio-alto. Apenas suelte el hervor, baja el fuego al mínimo y cocina por 15 minutos. Destapa, revuelve con un tenedor y separa.\n" +
				"En un bol coloca los huevos, la sal, orégano y comino, bate 20 segundos con un tenedor agrega el cerdo molido y la quinoa. Mezcla muy bien.\n" +
				"Con una cuchara saca porciones de la mezcla y forma las albóndigas de un tamaño similar a una bola de golf. Coloca ordenadas en la lata de horno y hornea por 15 minutos. La temperatura interna debe ser superior a 165F o 73C.\n" +
				"Sirve caliente o tibias.");
		values.put("img", R.drawable.albondigas_de_cerdo_y_quinoa);
		db.insert("receta", "_id", values);

		values.put("_id", "2");
		values.put("nombre", "Alfajores con chancaca atoradores, receta chilena");
		values.put("ingredientes", "2 tazas de harina cernida\n" +
				"3 yemas\n" +
				"5 cucharadas de leche\n" +
				"1 cucharadita de vinagre\n" +
				"1 cucharada de mantequilla derretida\n" +
				"225 gramos de chancaca\n" +
				"1/3 taza de agua\n" +
				"1/2  taza de harina tostada\n" +
				"1/3 taza de nueces picadas\n" +
				"ralladura de 1/2 naranja opcional");
		values.put("pasos","Precalentar el horno a 350F o 180C.\n" +
				"Poner la harina en un bol amplio.\n" +
				"Agregar las yemas y trabajando con un tenedor o las manos formar migas.\n" +
				"Agregar la leche, el vinagre y  la mantequilla derretida.\n" +
				"Formar una masa, agregar agua a cucharaditas de ser necesario.\n" +
				"Amasar hasta formar una masa lisa y que suene, unos 10 minutos.\n" +
				"Envolver en plástico de cocina y reposar en el refrigerador mínimo 2 horas y hasta 2 días.\n" +
				"Uslerear delgada y cortar los alfajores, antes de meter al horno clavar con un tenedor, hornear por 10-12 minutos o hasta que estén dorados.\n" +
				"Pegar con chancaca una vez que estén fríos.\n" +
				"Puedes guardar las masas sin rellenar en lata hermética por hasta 1 semana, congelar por hasta 2 meses. Una vez rellenos es mejor consumirlos el mismo día.\n" +
				"Colocar la chancaca picada o rallada en una olla, agregar el agua y cocinar a fuego medio, revolviendo ocasionalmente hasta que toda la chancaca se derrita, agregar la ralladura de naranja. Agregar el harina de a poco revolviendo todo el tiempo con un batidor de alambre. Dejar que hierva suavemente por 3 minutos, siempre revolviendo. Sacar del fuego y agregar las nueces picadas. Revolver.\n" +
				"Dejar enfriar y rellenar los alfajores.");
		values.put("img", R.drawable.alfajores_con_chancaca_atoradores_rc);
		db.insert("receta", "_id", values);
		
		values.put("_id", "3");
		values.put("nombre", "Alfajores de chocolate, estilo sausalito");
		values.put("ingredientes", "170 gramos de mantequilla a temperatura ambiente\n" +
				"130 gramos de azúcar rubia\n" +
				"2 huevos a temperatura ambiente\n" +
				"20 gramos de miel líquida\n" +
				"340 gramos de harina sin polvos de hornear\n" +
				"2 cucharaditas de extracto de vainilla\n" +
				"4 cucharadas de cacao en polvo, sin azúcar\n" +
				"2 cucharaditas de polvos de hornear\n" +
				"1 cucharadita de bicarbonato de sodio\n" +
				"1/8 cucharadita de sal fina\n" +
				"1 1/2 tarro de manjar (si lo hacen en casa con leche condensada, hervir por 2 horas y media desde que suelta el hervor para que les quede espeso)\n" +
				"200 gramos de chocolate semi-amargo, yo use uno con 60% de cacao\n" +
				"1 cucharada de aceite vegetal");
		values.put("pasos", "Para hacer la masa. En un bol amplio con batidora, batir la mantequilla hasta que este cremosa y pálida, unos 5 minutos, agregar el azúcar y batir hasta que este cremoso (3 minutos), agregar los huevos uno a uno, batiendo hasta incorporar, luego batir todo por 2 minutos para que este bien liviano. Agregar la miel y la vainilla, batir hasta incorporar. Cernir la harina, cacao, bicarbonato y sal, agregar al batido anterior y mezclar con cuchara de palo (no usen la batidora) hasta obtener una masa blanda y húmeda. Envolver en plástico de cocina y refrigerar por 1-2 horas.\n" +
				"Precalentar el horno a 350F o 180C.\n" +
				"Dividir la masa en 4 y sacar un cuarto y hacer una bolita, enharinar uno de los papeles siliconados y uslerear la masa con un uslero enharinado. Cortar los alfajores con un cortador en círculos de 3 cm de diámetro, colocar en una bandeja de horno cubierta con papel pergamino. Una vez horneados y fríos los puedes poner en una bolsa plástica y  congelar. Esto lo hice 2 semanas antes de la fiesta. Repetir con los 3 trozos de masa restantes.\n" +
				"Hornear por 5 minutos cada bandeja de horno (sin retirar el papel), solo 5 minutos en el horno precalentado, la masa va a crecer un poquito en el horno hacia arriba. Sacar y dejar enfriar en una rejilla en el mismo papel.\n" +
				"Una vez fríos, yo los hice en la mañana y rellene en la noche, armar los alfajores. Envolver en plástico de cocina y refrigerar toda la noche.\n" +
				"Al día siguiente picar el chocolate en trozos pequeños 1cm mas o menos y agregar el aceite vegetal, derretir en el microonda, partir con 30 segundos, sacar, revolver por 1 minuto, seguir derritiendo en el microonda de 15 segundos en 15 segundos, revolviendo entre medio hasta que todo el chocolate se disuelva. Bañar los alfajores ayudándose de una cuchara y espátula. Refrigerar, sacar 2 horas antes de servir.");
		values.put("img", R.drawable.alfajores_de_chocolate_estilo_sausalito);
		db.insert("receta", "_id", values);
		
		values.put("_id", "4");
		values.put("nombre", "Arroz con leche y manjar");
		values.put("ingredientes", "1 taza de agua\n" +
				"1 palito de canela\n" +
				"1 taza de arroz blanco Minute® Rice\n" +
				"4 tazas de leche semi-descremada (use 2%)\n" +
				"1 tarro (380 gramos o 13.4 oz.) de manjar\n" +
				"1 cucharada de mantequilla\n" +
				"sal");
		values.put("pasos", "Cocinar 1 taza de arroz integral. Usar el palito de canela en el agua de la cocción y una pizca de sal.\n" +
				"En una olla colocar la leche y el manjar y calentar a fuego medio alto, revolviendo para disolver el manjar.\n" +
				"Agregar el arroz cocido y cocinar a fuego medio bajo por 20-30 minutos revolviendo frecuentemente.\n" +
				"Tener cuidado que al hervir la leche suelta mucha espuma y se puede subir. La idea es que hierva despacio para que se reduzca lentamente el líquido.\n" +
				"Una vez que hayan llegado a la textura deseada, en mi caso fue 24 minutos. Agregar la mantequilla y apagar el fuego.\n" +
				"Tengan en cuenta que al enfriarse se va a espesar más.\n" +
				"Servir frío con chispas de chocolate.");
		values.put("img", R.drawable.arroz_con_leche_y_manjar);
		db.insert("receta", "_id", values);

		values.put("_id", "5");
		values.put("nombre", "Betarragas rellenas");
		values.put("ingredientes", "4 betarragas\n" +
				"1 taza de choclo cocido\n" +
				"2-3 cebollines picados finos\n" +
				"2 ramitas de eneldo picado fino\n" +
				"1 palta mediana picada en cubos\n" +
				"1 cucharada de mayonesa o yogurt natural");
		values.put("pasos", "Cocinar las betarragas, a mi me gusta envolverlas en papel aluminio y hornearlas a 200C o 400F por 30-40 minutos. Están listas cuando se pueden atravesar fácilmente con un cuchillo. Dejar enfriar un poco.\n" +
				"En un bowl mezclar el choclo, cebollines, eneldo, mayonesa y sal.\n" +
				"Pelar las betarragas, si son pequeñas cortar por la mitad. Si son grandes cortar en rodajas de 1 cm. mas o menos.\n" +
				"Agregar la palta a la mezcla de choclo justo antes de servir. Revolver.\n" +
				"Rellenar las betarragas y servir.");
		values.put("img", R.drawable.betarragas_rellenas);
		db.insert("receta", "_id", values);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS receta");
		onCreate(db);

	}

}
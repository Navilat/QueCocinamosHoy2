package id.creatorb.receta;

import id.creatorb.receta.Task.TaskFinishedListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashInit extends Activity implements TaskFinishedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Muestra la pantalla de splash
        setContentView(R.layout.splashinit);
        //Busca la barra de carga o progress bar
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.activity_splash_progress_bar);
        //Comienza la carga
        new Task(progressBar, this).execute("www.google.co.uk"); // Pass in whatever you need a url is just an example we don't use it in this tutorial
    }

    // This is the callback for when your async task has finished
    @Override
	public void onTaskFinished() {
		completeSplash();
	}

    private void completeSplash(){
		startApp();
		finish(); //Fin de la activity de splash (para no poder volver a ella)
    }

    private void startApp() {
		Intent intent = new Intent(SplashInit.this, MainActivity.class);
		startActivity(intent);
	}
}
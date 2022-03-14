package course.examples.QuoteViewerActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import course.examples.QuoteViewerActivity.R;

public class QuoteViewerActivity extends Activity implements TitlesFragment.ListSelectionListener {

	public static String[] mTitleArray; //Array de títulos
	public static String[] mQuoteArray; //Array de citas.
	private QuotesFragment mQuotesFragment;  //Declaramos el Fragment para mostrar las citas.

	private static final String TAG = "QuoteViewerActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, getClass().getSimpleName() + ":Begin of onCreate();");

		//Cargamos los arrays de títulos y citas.
		//Fijarse que son objetos de la activity, no de los fragments.
		mTitleArray = getResources().getStringArray(R.array.Titles);
		mQuoteArray = getResources().getStringArray(R.array.Quotes);

		//Establecemos el layout principal
		setContentView(R.layout.main);

		//Instanciamos el Fragment para mostrar las citas. Usamos el getFragmentManager()
		//El TitlesFragment no necesitamos instanciarlo porque no vamos a actuar sobre el desde la activity.
		mQuotesFragment = (QuotesFragment) getFragmentManager().findFragmentById(R.id.details);
		Log.d(TAG, getClass().getSimpleName() + ":end of onCreate()");
	}

	//Implementamos los métodos de la interfaz ------------------------------
		public void onListSelection(int index) {
			//Este es el método que tenemos que codificar de la interfaz que hemos implementado
			//Lo llamaremos cuando recibamos el callback onListItemClick en la lista del TilesFragmente
			//Entonces lo que tenemos que hacer es pedire al QuotesFragment que muestre la cita
			//para el indice que llega, sólo si no se está mostrando ya, claro.
			Log.d(TAG, getClass().getSimpleName() + ":onListSelection() interface method");
			if (mQuotesFragment.getShownIndex() != index) {
				//Si no coincide con el que ya esta mostrando, indicamos que lo muestre
				//y le pasamos la cita a mostrar.
				mQuotesFragment.showQuote(index,mQuoteArray[index]);
			}
		}

		public String[] getTitles(){
			//Este método es llamado por el fragment para obtener la lista de titulos a añadir en
			//el ListView de titulos
			Log.d(TAG, getClass().getSimpleName() + ":Getting Titles() interface method");
			return mTitleArray;
		}
	//----------------------------------------------------------------------


	@Override
	protected void onDestroy() {
		Log.d(TAG, getClass().getSimpleName() + ":entered onDestroy()");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		Log.d(TAG, getClass().getSimpleName() + ":entered onPause()");
		super.onPause();
	}

	@Override
	protected void onRestart() {
		Log.d(TAG, getClass().getSimpleName() + ":entered onRestart()");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.d(TAG, getClass().getSimpleName() + ":entered onResume()");
		super.onResume();
	}

	@Override
	protected void onStart() {
		Log.d(TAG, getClass().getSimpleName() + ":entered onStart()");
		super.onStart();
	}

	@Override
	protected void onStop() {
		Log.d(TAG, getClass().getSimpleName() + ":entered onStop()");
		super.onStop();
	}

}
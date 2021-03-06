package edu.dartmouth.cs.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

	private static final String TAG = "MyFirstApp";
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	/** Called when the user clicks the Send button */

	public void sendMessage(final View view) {

		// Send the input string to the DisplayMessageActivity using an intent

		Log.d(TAG, "sendMessage");

		class WorkerThread extends Thread {
			public void run(){
				final TextView tv = (TextView) view.findViewById(R.id.textView);

				tv.setText("hi");
			}
		}

		new WorkerThread().start();

//		Intent intent = new Intent(this, DisplayMessageActivity.class);
//		EditText editText = (EditText) findViewById(R.id.edit_message);
//		String message = editText.getText().toString();
//		intent.putExtra(EXTRA_MESSAGE, message);
//		startActivity(intent);
	}
}

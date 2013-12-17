package cordova.plugins.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;

import java.io.File;

public class DemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
		Intent intent = new Intent().putExtra("result", path.toString());
		setResult(Activity.RESULT_OK, intent);
		finish();
	}

}

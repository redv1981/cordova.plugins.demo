package cordova.plugins.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;

public class DemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		File file = Environment.getDataDirectory();
		Intent intent = new Intent().putExtra("result", file.toString());
		setResult(Activity.RESULT_OK, intent);
		finish();
	}

}

package cordova.plugins.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class DemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = new Intent().putExtra("result", "Heiheihei!");
		setResult(Activity.RESULT_OK, intent);
		finish();
	}

}

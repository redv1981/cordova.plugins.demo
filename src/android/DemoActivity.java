package cordova.plugins.demo;

import android.app.Activity;
import android.content.Intent;

public class DemoActivity extends Activity {

	@Override
	protected void onStop() {
		Intent intent = new Intent().putExtra("result", "Heiheihei!");
		setResult(Activity.RESULT_OK, intent);
		finish();
		
		super.onStop();
	}

}

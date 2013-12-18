package cordova.plugins.demo;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.File;

public class DemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final SurfaceView view = new SurfaceView(this);

		final Button btn = new Button(this);
		btn.setText("按钮");
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
				Intent intent = new Intent().putExtra("result", path.toString());
				setResult(Activity.RESULT_OK, intent);
				finish();
			}
		});

		final LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(view);
		layout.addView(btn);

		setContentView(layout);
	}

}

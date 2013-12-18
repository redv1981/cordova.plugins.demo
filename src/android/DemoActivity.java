package cordova.plugins.demo;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.File;
import java.io.IOException;

public class DemoActivity extends Activity implements SurfaceHolder.Callback {

	private Camera camera = null;
	private boolean cameraPreviewing = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

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
		layout.addView(btn);

		final SurfaceView view = new SurfaceView(this);
		layout.addView(view);

		final SurfaceHolder holder = view.getHolder();
		holder.addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		camera = Camera.open();

		if (null == camera) {
			finish();
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		if (cameraPreviewing) {
			camera.stopPreview();
		}

		// Camera.Parameters params = camera.getParameters();
		// params.setPreviewFormat(format);
		// params.setPreviewSize(width, height);
		// camera.setParameters(params);

		// Intent intent = new Intent().putExtra("result", String.format("Format: %d; Width: %d; Height: %d", format, width, height));
		// setResult(Activity.RESULT_OK, intent);
		// finish();

		try {
			camera.setDisplayOrientation(90);
			camera.setPreviewDisplay(holder);
			camera.startPreview();
			cameraPreviewing = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		if (null != camera) {
			camera.stopPreview();
			camera.release();
		}
	}

}

package cordova.plugins.demo;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

public class Demo extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("callActivity")) {
			return callActivity(args.getString(0), callbackContext);
		} else if (action.equals("keyClick")) {
			return keyClick(callbackContext);
		}
		
		return false;
	}

	protected boolean callActivity(String className, CallbackContext callbackContext) {
		Intent intent = new Intent().setClassName(cordova.getActivity(), className);
		cordova.startActivityForResult(this, intent, 1);
		//callbackContext.success();

		return true;
	}

	protected boolean keyClick(CallbackContext callbackContext) {
		AudioManager audioManager = (AudioManager)cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
		audioManager.playSoundEffect(AudioManager.FX_KEY_CLICK);
		callbackContext.success();

		return true;
	}

}

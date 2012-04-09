package br.livro.android.cap18.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * BroadcastReceiver que exibe um alerta Toast quando uma ligação é recebida
 * 
 * <uses-permission android:name="android.permission.READ_PHONE_STATE" />
 * 
 *      <receiver android:name="ReceberLigacao">
            <intent-filter>
                <action android:name="android.intent.action.PHONE_STATE" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </receiver>
 */
public class ReceberLigacao extends BroadcastReceiver {
	private static final String CATEGORIA = "livro";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(CATEGORIA, "receiver > " + intent.getAction());

        if(intent.getExtras() != null){
          
          String state = intent.getStringExtra("state");
          String numero = intent.getStringExtra("incoming_number");
          
          Log.i(CATEGORIA, "receiver state > " + state);
          if("RINGING".equalsIgnoreCase(state)){
            Log.i(CATEGORIA, "receiver Chamando numero :-) > " + numero);
          }
        }

	}
}

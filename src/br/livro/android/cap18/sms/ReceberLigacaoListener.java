package br.livro.android.cap18.sms;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Listener para receber ligação
 * 
 * TelephonyManager t = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
 * t.listen(new ReceberLigacaoListener(), PhoneStateListener.LISTEN_CALL_STATE);
 * 
 */
public class ReceberLigacaoListener extends PhoneStateListener {
  private static final String CATEGORIA = "livro";

  @Override
  public void onCallStateChanged(int state, String incomingNumber) {
    Log.v(CATEGORIA, "listener >>  Incoming Number: " + incomingNumber);

    super.onCallStateChanged(state, incomingNumber);

    switch (state) {
      case TelephonyManager.CALL_STATE_IDLE:
        Log.i(CATEGORIA, "CALL_STATE_IDLE");
        break;
      case TelephonyManager.CALL_STATE_OFFHOOK:
        Log.i(CATEGORIA, "CALL_STATE_OFFHOOK");
        break;
      case TelephonyManager.CALL_STATE_RINGING:
        //Está tocacdo
        Log.i(CATEGORIA, "Recebeu ligação: " + incomingNumber);
        break;
      default:
        Log.w(CATEGORIA, "unknown call state: " + state);
    }
  }
}

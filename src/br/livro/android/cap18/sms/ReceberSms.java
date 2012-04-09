package br.livro.android.cap18.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * BroadcastReceiver que exibe um alerta Toast quando um SMS e recebido
 * 
 */
public class ReceberSms extends BroadcastReceiver {
	private static final String CATEGORIA = "livro";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(CATEGORIA, ">" + intent.getAction());

		Sms sms = new Sms();
		//Lê a mensagem
		SmsMessage msg = sms.receberMensagem(intent);
		String celular = msg.getDisplayOriginatingAddress();
		String mensagem = msg.getDisplayMessageBody();

		String texto = "ReceberSms: recebeu sms[" + celular + "] -> " + mensagem;

		Log.i(CATEGORIA, texto);

		Toast.makeText(context, texto, Toast.LENGTH_SHORT).show();
	}
}

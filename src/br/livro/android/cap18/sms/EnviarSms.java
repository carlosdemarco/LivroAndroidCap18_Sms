package br.livro.android.cap18.sms;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Activity que exibe o formulário e envia um SMS para o número fornecido
 * 
 * O número é o do emulador
 * 
 * @author ricardo
 *
 */
public class EnviarSms extends Activity {
	private static final String CATEGORIA = "livro";
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.form_enviar_sms);
		Button btEnviar = (Button) findViewById(R.id.btEnviar);
		btEnviar.setOnClickListener(new OnClickListener(){
			public void onClick(View view) {
				EditText numeroText   = (EditText) findViewById(R.id.numero);
				EditText mensagemText = (EditText) findViewById(R.id.mensagem);

				String numero   = numeroText.getText().toString();
				String mensagem = mensagemText.getText().toString();

				Log.i(CATEGORIA, "Enviando SMS para ["+numero+"]: " + mensagem);

				Sms sms = new Sms();
				sms.enviarSms(EnviarSms.this, numero, mensagem);
			}});
	}
}

package id.or.redroid.tugasdncc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtkey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtkey =(EditText) findViewById(R.id.edt_key);
    }
    public void cekKey(View view) {
        SharedPreferences SharedPreferences = getSharedPreferences("authentication",MODE_PRIVATE);
        if (edtkey.getText().toString().isEmpty()){
            Toast.makeText(this,"ISI DONG SAYANG!",Toast.LENGTH_LONG).show();
            return;
        }
        String key_sp = SharedPreferences.getString("key","dms");
        String pin = edtkey.getText().toString().trim();
        if (pin.equals(key_sp)){
            Intent intent = new Intent(this, SelamatDatangActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "KEY YANG ANDA MASUKKAN SALAH!", Toast.LENGTH_LONG).show();
        }

    }
}
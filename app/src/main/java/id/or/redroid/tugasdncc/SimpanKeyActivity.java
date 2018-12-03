package id.or.redroid.tugasdncc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SimpanKeyActivity extends AppCompatActivity {

    EditText edtsimpankey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpankey);

        edtsimpankey=(EditText) findViewById(R.id.edit_simpan_key);
    }
    public void simpanKey (View view){
        SharedPreferences sharedPreferences = getSharedPreferences("authentication",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        if (edtsimpankey.getText().toString().isEmpty()){
            editor.remove("key");
            editor.commit();
            Toast.makeText(this, "GAADA ISI, KEK HATI BEB :((",Toast.LENGTH_SHORT).show();
            return;
        }
        String simpankey = edtsimpankey.getText().toString().trim();
        editor.putString("key", simpankey);
        editor.commit();
        Toast.makeText(this, "KEY DISIMPAN SAYANG :)",Toast.LENGTH_LONG).show();
    }
    public void pressback(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
package com.example.checkboxradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private EditText etInputNama;
    private EditText etInputNim;
    private EditText etInputHp;
    private EditText etInputEmail;
    private TextView TvNim,TvNama,TvHp,TvEmail,TvJurusan;
    private Spinner jurusan;
    private String[] data = {"S1TI","D3TI","D3MI"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInputNim = findViewById(R.id.etInputNim);
        etInputNama = findViewById(R.id.etInputNama);
        etInputHp = findViewById(R.id.etInputHp);
        etInputEmail = findViewById(R.id.etInputEmail);
        TvNim= findViewById(R.id.hasil_Nim);
        TvNama = findViewById(R.id.hasil_Nama);
        TvHp = findViewById(R.id.hasil_Hp);
        TvEmail = findViewById(R.id.hasil_Email);
        TvJurusan = (TextView) findViewById(R.id.hasil_jurusan);
        jurusan = (Spinner) findViewById(R.id.jurusan);

        ArrayAdapter<String> adapters = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, data)
;
        jurusan.setAdapter(adapters);
    }
    public void btnTampil(View v) {
        TvNim.setText("NIM: "+etInputNim.getText());
        TvNama.setText("NAMA: "+etInputNama.getText());
        TvHp.setText("NO HP: "+etInputHp.getText());
        TvEmail.setText("EMAIL"+etInputEmail.getText());
        RadioGroup rg = findViewById(R.id.rg);
        int id = rg.getCheckedRadioButtonId();
        if (id != -1) {
            RadioButton jenis_kelamin = findViewById(id);
            TextView hasil_Jenis_kelamin = findViewById(R.id.hasil_jenis_kelamin);
            hasil_Jenis_kelamin.setText("Jenis Kelamin : " + jenis_kelamin.getText());
        } else {
            Toast.makeText(this, "Jenis kelamin belum dipilih", Toast.LENGTH_SHORT).show();
        }
        CheckBox game = findViewById(R.id.game);
        CheckBox programer = findViewById(R.id.programer);
        ArrayList list = new ArrayList();
        if (game.isChecked()) {
            list.add(game.getText().toString());
        }
        if (programer.isChecked()) {list.add(programer.getText().toString());          }
        if (list.size() != 0) {
            TextView hasil_hoby = findViewById(R.id.hasil_hobi);
            hasil_hoby.setText("Hobi : " + list);
        } else {
            Toast.makeText(this, "Hobi belum dipilih", Toast.LENGTH_SHORT).show();
        }
        TvJurusan.setText("Jurusan : "+jurusan.getSelectedItem().toString());
    }
}


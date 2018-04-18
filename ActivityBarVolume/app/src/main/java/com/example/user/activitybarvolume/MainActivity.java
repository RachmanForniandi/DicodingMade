package com.example.user.activitybarvolume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etPanjang,etLebar, etTinggi;
    private Button btnHitung;
    private TextView txtViewHasil;
    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPanjang = (EditText) findViewById(R.id.et_panjang);
        etLebar = (EditText)findViewById(R.id.et_lebar);
        etTinggi = (EditText)findViewById(R.id.et_tinggi);
        btnHitung = (Button)findViewById(R.id.btn_hitung);
        txtViewHasil = (TextView) findViewById(R.id.txtView_hasil);
        btnHitung.setOnClickListener(this);

        if (savedInstanceState !=null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            txtViewHasil.setText(hasil);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putString(STATE_HASIL, txtViewHasil.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_hitung){
            String panjang = etPanjang.getText().toString().trim();
            String lebar = etLebar.getText().toString().trim();
            String tinggi = etTinggi.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(panjang)){
                isEmptyFields = true;
                etPanjang.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(lebar)){
                isEmptyFields = true;
                etLebar.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(tinggi)){
                isEmptyFields = true;
                etTinggi.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields){
                double p = Double.parseDouble(panjang);
                double l = Double.parseDouble(lebar);
                double t = Double.parseDouble(tinggi);
                double volume = p * l * t;
                txtViewHasil.setText(String.valueOf(volume));
            }
        }
    }
}

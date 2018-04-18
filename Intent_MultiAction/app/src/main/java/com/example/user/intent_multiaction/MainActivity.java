package com.example.user.intent_multiaction;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnPindahActivity,btnPindahwDataActivity,btnPindahwObject,btnNoPanggilan,
    btnPindahUtkHasil;
    private TextView txtViewHasil;
    private int REQUEST_CODE =120;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindahActivity = findViewById(R.id.btn_pindah_activity);
        btnPindahActivity.setOnClickListener(this);

        btnPindahwDataActivity = findViewById(R.id.btn_pindah_w_data_activity);
        btnPindahwDataActivity.setOnClickListener(this);

        btnPindahwObject = findViewById(R.id.btn_pindah_object_activity);
        btnPindahwObject.setOnClickListener(this);

        btnNoPanggilan = findViewById(R.id.btn_no_panggilan);
        btnNoPanggilan.setOnClickListener(this);

        btnPindahUtkHasil = findViewById(R.id.btn_pindah_ke_hasil);
        btnPindahUtkHasil.setOnClickListener(this);

        txtViewHasil = findViewById(R.id.txtView_hasil);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_pindah_activity:
                Intent pindahIntent = new Intent(MainActivity.this,MoveActivity.class);
                startActivity(pindahIntent);
                break;
            case R.id.btn_pindah_w_data_activity:
                Intent pindahBawaDataIntent = new Intent(MainActivity.this,MoveWithDataActivity.class);
                pindahBawaDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Rachman Forniandi");
                pindahBawaDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 26);
                startActivity(pindahBawaDataIntent);
                break;
            case R.id.btn_pindah_object_activity:
                Mahasiswa mMahasiswa = new Mahasiswa();
                mMahasiswa.setNama("Rachman Forniandi");
                mMahasiswa.setAsal("Tangerang Selatan Banten");
                mMahasiswa.setJurusan("Teknik Fisika");
                mMahasiswa.setEmail("rachmanforniandi@gmail.com");

                Intent pindahObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                pindahObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mMahasiswa);
                startActivity(pindahObjectIntent);
                break;
            case R.id.btn_no_panggilan:
                String noHp = "085732737500";
                Intent telponNoIni = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+noHp));
                startActivity(telponNoIni);
                break;
            case R.id.btn_pindah_ke_hasil:
                Intent pindahKeHasil = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(pindahKeHasil,REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if (requestCode == REQUEST_CODE ){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_NOMINAL,0);
                txtViewHasil.setText("Pulsa Terkirim: Rp "+selectedValue);
            }
        }
    }
}

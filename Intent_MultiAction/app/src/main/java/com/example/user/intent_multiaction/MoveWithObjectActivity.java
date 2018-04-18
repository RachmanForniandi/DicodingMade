package com.example.user.intent_multiaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static String EXTRA_PERSON = "extra_person";
    private TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject = findViewById(R.id.txtView_object_diterima);
        Mahasiswa mMahasiswa = getIntent().getParcelableExtra(EXTRA_PERSON);
        String profile = "Name: "+mMahasiswa.getNama()+", Asal : "+mMahasiswa.getAsal()+
                ", Jurusan : "+ mMahasiswa.getJurusan()+", Email :"+mMahasiswa.getEmail();
        tvObject.setText(profile);
    }
}

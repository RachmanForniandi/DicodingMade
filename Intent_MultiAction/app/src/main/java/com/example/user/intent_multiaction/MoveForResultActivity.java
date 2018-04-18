package com.example.user.intent_multiaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MoveForResultActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnPesan;
    private RadioGroup rgNominalPulsa;
    public static String EXTRA_SELECTED_NOMINAL = "extra_selected_nominal";
    public static int RESULT_CODE = 120;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result);
        btnPesan = findViewById(R.id.btn_pesan);
        btnPesan.setOnClickListener(this);

        rgNominalPulsa = findViewById(R.id.rg_options);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_pesan){
            if (rgNominalPulsa.getCheckedRadioButtonId() !=0){
                int nominal = 0;
                switch (rgNominalPulsa.getCheckedRadioButtonId()){
                    case R.id.rb_25K:
                        nominal = 25000;
                        break;
                    case R.id.rb_50K:
                        nominal = 50000;
                        break;
                    case R.id.rb_100K:
                        nominal = 100000;
                        break;
                    case R.id.rb_150K:
                        nominal = 150000;
                        break;
                    case R.id.rb_250K:
                        nominal = 250000;
                        break;
                    case R.id.rb_500K:
                        nominal = 500000;
                        break;
                    case R.id.rb_1000K:
                        nominal = 1000000;
                        break;
                }
                Intent hasilIntent = new Intent();
                hasilIntent.putExtra(EXTRA_SELECTED_NOMINAL,nominal);
                setResult(RESULT_CODE, hasilIntent);
                finish();
            }
        }
    }
}

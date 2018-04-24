package com.example.user.fragmentflexible;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button btnChoose, btnClose;
    private RadioGroup radioGroupOptions;
    private RadioButton rbJm,rbAc,rbPg,rbJk,rbAw;
    private OnOptionDialogListener onOptionDialogListener;
    public OptionDialogFragment() {
        // Required empty public constructor
    }
    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
    }
    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
        this.onOptionDialogListener = onOptionDialogListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);
        btnChoose = (Button)view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
        btnClose = (Button)view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        radioGroupOptions = (RadioGroup)view.findViewById(R.id.rg_options);
        rbJm = (RadioButton) view.findViewById(R.id.rb_jm);
        rbAc = (RadioButton)view.findViewById(R.id.rb_ac);
        rbJk = (RadioButton)view.findViewById(R.id.rb_jk);
        rbPg = (RadioButton)view.findViewById(R.id.rb_pg);
        rbAw = (RadioButton)view.findViewById(R.id.rb_aw);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case R.id.btn_choose:
                int checkedRadioButtonId = radioGroupOptions.getCheckedRadioButtonId();

                if (checkedRadioButtonId != -1){
                    String decide = null;
                    switch (checkedRadioButtonId){
                        case R.id.rb_jm:
                            decide = rbJm.getText().toString().trim();
                            break;
                        case R.id.rb_pg:
                            decide = rbPg.getText().toString().trim();
                            break;
                        case R.id.rb_ac:
                            decide = rbAc.getText().toString().trim();
                            break;
                        case R.id.rb_jk:
                            decide = rbJk.getText().toString().trim();
                            break;
                        case R.id.rb_aw:
                            decide = rbAw.getText().toString().trim();
                            break;
                    }
                    getOnOptionDialogListener().onOptionChoosen(decide);
                    getDialog().cancel();
                }
                break;
        }
    }

    public interface OnOptionDialogListener {

        void onOptionChoosen(String text);
    }
}

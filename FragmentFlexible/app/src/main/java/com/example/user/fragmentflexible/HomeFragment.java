package com.example.user.fragmentflexible;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // tumpuk layout di activity ini
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        Button btnCategory = (Button)v.findViewById(R.id.btn_category);
        btnCategory.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_category){
            //CategoryFragment nya ngapain ?
            CategoryFragment mCategoryFragment = new CategoryFragment();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, mCategoryFragment,
                    CategoryFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
    }
}

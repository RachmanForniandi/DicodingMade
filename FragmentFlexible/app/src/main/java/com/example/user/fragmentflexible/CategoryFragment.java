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
public class CategoryFragment extends Fragment implements View.OnClickListener{

private Button btnDetailCategory;
    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_category, container, false);
        btnDetailCategory = (Button)v.findViewById(R.id.btn_detail_category);
        btnDetailCategory.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.btn_detail_category){
            DetailCategoryFragment mDetailCategoryFragment = new DetailCategoryFragment();
            Bundle mBundle = new Bundle();
            mBundle.putString(mDetailCategoryFragment.EXTRA_NAME,"Lifestyle");
            String description = "Kategori ini berisi produk-produk lifestyle";

            mDetailCategoryFragment.setArguments(mBundle);
            mDetailCategoryFragment.setDescription(description);

            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container,mDetailCategoryFragment,
                    DetailCategoryFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
    }
}

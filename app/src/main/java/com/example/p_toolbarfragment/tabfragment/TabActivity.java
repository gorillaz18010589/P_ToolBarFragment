package com.example.p_toolbarfragment.tabfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.p_toolbarfragment.R;

public class TabActivity extends AppCompatActivity {
    private FragmentTransaction fragmentTransaction;
    private TableTestFragment tableFragment = new TableTestFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        initFragment();
    }

    private void initFragment() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameContiner,tableFragment);
        fragmentTransaction.commit();
    }
}

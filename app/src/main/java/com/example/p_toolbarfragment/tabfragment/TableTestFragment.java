package com.example.p_toolbarfragment.tabfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p_toolbarfragment.R;
import com.example.p_toolbarfragment.databinding.FragmentTableTestBinding;


public class TableTestFragment extends Fragment {
    private FragmentTableTestBinding fragmentTableTestBinding;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentTableTestBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()),R.layout.fragment_table_test,container,false);
        return fragmentTableTestBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setView();
    }

    private void setView() {
        fragmentTableTestBinding.tvContent1.setText("測試版本1");
        fragmentTableTestBinding.tvContent2.setText("測試版本2");



        fragmentTableTestBinding.tvTitle1.setText(getResources().getString(R.string.help_real_lottery_beijing_title1));
        fragmentTableTestBinding.tvTitle2.setText(getResources().getString(R.string.help_real_lottery_beijing_title2));



    }

}

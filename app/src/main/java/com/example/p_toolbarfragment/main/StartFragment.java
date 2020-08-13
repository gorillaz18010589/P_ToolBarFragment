package com.example.p_toolbarfragment.main;
//start的Fragment才開始fragmentTransaction.addToBackStack("");這頁叫0,之後每addToBackStack的頁面會加1以此類推
//要顯示改變tittle在各自頁面的OnViewCreate
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.p_toolbarfragment.Message;
import com.example.p_toolbarfragment.R;
import com.example.p_toolbarfragment.databinding.FragmentStartBinding;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;


public class StartFragment extends Fragment {
    private FragmentStartBinding fragmentStartBinding;
    private FragmentTransaction fragmentTransaction;
    private OneFragment oneFragment = new OneFragment();
    private SecondFragment secondFragment = new SecondFragment();
    private ImageView imgTop;
    private TextView tvTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imgTop = getActivity().findViewById(R.id.imgTop);
        imgTop.setOnClickListener(onClickListener);
        tvTitle =  getActivity().findViewById(R.id.tvTitle);

    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        EventBus.getDefault().postSticky(new Message("首頁"));
        fragmentStartBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()),R.layout.fragment_start,container,false);
        return fragmentStartBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTitle.setText("start");
        fragmentStartBinding.btn1.setOnClickListener(onClickListener);
        fragmentStartBinding.btn2.setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn1:
                    setFragment(oneFragment);
                    break;
                case R.id.btn2:
                    setFragment(secondFragment);
                    break;
                case R.id.imgTop:
                  int  backStackEntryCount = getFragmentManager().getBackStackEntryCount();
                  if(backStackEntryCount == 0){
                      getActivity().finish();
                      Log.v("hank","Start ->getBackStackEntryCount:" + backStackEntryCount);
                  }else{
                      Log.v("hank","Start ->getBackStackEntryCount:" + backStackEntryCount);
                      getFragmentManager().popBackStack();
                  };
                    break;
            }
        }
    };

    private void setFragment(Fragment fragment) {
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameContiner,fragment);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
    }

    @Subscribe(threadMode = ThreadMode.MainThread, sticky = true)
    public void getMessage(Message message){
        Log.v("hank","getMessage:" + message.getType());
        if(message.equals("首頁")){
            tvTitle.setText(message.getType());
        }
    }




}

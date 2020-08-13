package com.example.p_toolbarfragment.main;

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
import android.widget.TextView;

import com.example.p_toolbarfragment.Message;
import com.example.p_toolbarfragment.R;
import com.example.p_toolbarfragment.databinding.FragmentStartBinding;
import com.example.p_toolbarfragment.main.next.ThirdFragment;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;


public class OneFragment extends Fragment {
    private TextView tvTitle;
    private FragmentTransaction fragmentTransaction;
    private FragmentStartBinding fragmentStartBinding;
    private ThirdFragment thirdFragment = new ThirdFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        tvTitle = getActivity().findViewById(R.id.tvTitle);
        tvTitle.setText("one");
        fragmentStartBinding.btn1.setOnClickListener(onClickListener);
        fragmentStartBinding.btn2.setOnClickListener(onClickListener);

        setView();
    }

    private void setView() {
        fragmentStartBinding.btn1.setText("One1");
        fragmentStartBinding.btn2.setText("One2");
        fragmentStartBinding.btn3.setText("One3");
        fragmentStartBinding.btn4.setText("One4");
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn1:
                    setFragment(thirdFragment);
                    break;
                case R.id.btn2:

                    break;
                case R.id.imgTop:
                    int  backStackEntryCount = getFragmentManager().getBackStackEntryCount();
                    if(backStackEntryCount == 0){

                        getActivity().finish();
                        Log.v("hank","One ->getBackStackEntryCount:" + backStackEntryCount);
                    }else{
                        Log.v("hank","One ->getBackStackEntryCount:" + backStackEntryCount);
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

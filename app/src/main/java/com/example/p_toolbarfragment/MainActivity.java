package com.example.p_toolbarfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.p_toolbarfragment.main.StartFragment;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction fragmentTransaction;
    private StartFragment startFragment = new StartFragment();
    private ImageView imgTop;
    private TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
        initFragment();
    }

    private void init() {
        imgTop = findViewById(R.id.imgTop);
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("ＭainActivitty");

        imgTop.setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imgTop:
                    break;
            }
        }
    };
    private void initFragment() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameContiner,startFragment);
        fragmentTransaction.commit();
    }
}

package com.example.p_toolbarfragment.tabfragment;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.p_toolbarfragment.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.M)
public class TableFragment extends Fragment {
    private TabLayout tlTitle;
    private ViewPager vpContent;
    private FragmentStatePagerAdapter adapter;
    private List<Fragment> listFragment;
    private String[] title = {"快乐彩", "时时彩", "北京PK拾", "六合彩"};
    private Fragment mHappyLotteryFragment;
    private Fragment mTimeLotteryFragment;
    private Fragment mBejjingLotteryFragment;
    private Fragment mMarkSixFragment;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table, container, false);
    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        tlTitle = view.findViewById(R.id.tl_title);
//        vpContent = view.findViewById(R.id.vp_content);
//        listFragment = new ArrayList<>();
//
//
//
//        listFragment.add(mHappyLotteryFragment);
//        listFragment.add(mTimeLotteryFragment);
//        listFragment.add(mBejjingLotteryFragment);
//        listFragment.add(mMarkSixFragment);
//        adapter = new FragmentAdapter(getChildFragmentManager(),listFragment);
//        vpContent.setAdapter(adapter);
//        tlTitle.setupWithViewPager(vpContent);
//        for (int i = 0; i < title.length; i++) {
//            TabLayout.Tab tab = tlTitle.getTabAt(i);
//            tab.setCustomView(R.layout.activity_tab);
//            TextView tvTab = tab.getCustomView().findViewById(R.id.tv_tab);
//            tvTab.setText(tab.getText());
//            if (i == 0) {
//                tvTab.setTextColor(getResources().getColor(R.color.offer_tab_select_color));
//                tvTab.setSelected(true);
//                tvTab.setTypeface(Typeface.DEFAULT_BOLD);
//            }
//        }
//        tlTitle.addOnTabSelectedListener(onTabSelectedListener);
//
//
//    }
//
//
//
//
//
//
//    TabLayout.OnTabSelectedListener onTabSelectedListener = new TabLayout.OnTabSelectedListener() {
//        @Override
//        public void onTabSelected(TabLayout.Tab tab) {
//            TextView tv = tab.getCustomView().findViewById(R.id.tv_tab);
//            tv.setTextColor(getResources().getColor(R.color.offer_tab_select_color));
//            tv.setSelected(true);
//            tv.setTypeface(Typeface.DEFAULT_BOLD);
//            vpContent.setCurrentItem(tab.getPosition());
//            tabChecked(tab.getPosition());
//        }
//
//        @Override
//        public void onTabUnselected(TabLayout.Tab tab) {
//            TextView tv = tab.getCustomView().findViewById(R.id.tv_tab);
//            tv.setTextColor(getResources().getColor(R.color.offer_tab_unselect_color));
//            tv.setSelected(false);
//            tv.setTypeface(Typeface.DEFAULT);
//        }
//
//        @Override
//        public void onTabReselected(TabLayout.Tab tab) {
//
//        }
//    };
//
//    class FragmentAdapter extends FragmentStatePagerAdapter {
//
//        private List<Fragment> fragmentList;
//
//        public FragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
//            super(fm);
//            this.fragmentList = fragmentList;
//        }
//
//        @NonNull
//        @Override
//        public Fragment getItem(int position) {
//
//            return fragmentList.get(position);
//        }
//
//        @Override
//        public int getCount() {
//
//            return fragmentList.size();
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return title[position];
//        }
//
//        @Override
//        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//
//        }
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
}

package com.example.doanrapphim.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.doanrapphim.Activity_ChiTiet.TabBinhLuan;
import com.example.doanrapphim.Activity_ChiTiet.TabLich;
import com.example.doanrapphim.Activity_ChiTiet.TabThongTin;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int tabcout;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcout = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new TabLich();
            case 1 : return new TabThongTin();
            case 2 : return new TabBinhLuan();
            default: return new TabLich();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0 : title = "Lịch Chiếu";break;
            case 1 :  title = "Thông Tin";break;
            case 2 : title = "Bình Luận";break;
        }
        return title;
    }
}

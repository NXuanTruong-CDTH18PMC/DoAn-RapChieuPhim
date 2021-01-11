package com.example.doanrapphim.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.doanrapphim.TrangCaNhan.TabGiaoDich;
import com.example.doanrapphim.TrangCaNhan.TabThongTinCaNhan;

public class AdapterTrangCaNhan extends FragmentStatePagerAdapter {
    public AdapterTrangCaNhan(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String Title = "";
        switch (position){
            case 0:
                Title = "Thông Tin";
                break;
            case 1:
                Title = "Giao Dịch";
                break;
        }
        return Title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TabThongTinCaNhan();
            case 1:
                return new TabGiaoDich();
            default:
                return new TabThongTinCaNhan();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}


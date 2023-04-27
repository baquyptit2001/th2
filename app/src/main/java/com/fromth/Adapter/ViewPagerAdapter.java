package com.fromth.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.fromth.Fragment.FragmentDanhsach;
import com.fromth.Fragment.FragmentSearch;
import com.fromth.Fragment.FragmentThongtin;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm,behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentDanhsach();
            case 1: return new FragmentThongtin();
            case 2: return new FragmentSearch();
            default: return new FragmentDanhsach();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

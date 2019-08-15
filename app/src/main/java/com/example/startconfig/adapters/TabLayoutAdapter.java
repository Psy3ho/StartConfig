package com.example.startconfig.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.startconfig.fragments.FirstFragment;
import com.example.startconfig.fragments.SecondFragment;
import com.example.startconfig.fragments.ThirdFragment;

public class TabLayoutAdapter extends FragmentStatePagerAdapter {

    private int counttab;
    public TabLayoutAdapter(FragmentManager fm, int counttab) {
        super(fm);
        this.counttab = counttab;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return counttab;
    }
}

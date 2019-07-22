package com.nandaadisaputra.submission2made.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nandaadisaputra.submission2made.fragment.MovieFragment;
import com.nandaadisaputra.submission2made.fragment.TvFragment;

public class PageAdapter extends FragmentStatePagerAdapter {

    private int mNoOfTabs;

    public PageAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                //MovieFragment fragment activity
                return new MovieFragment();
            case 1:
                //TvFragment fragment activity
                return new TvFragment();
            default:
                return null;
        }
    }

    @Override
    // get item count
    public int getCount() {
        return mNoOfTabs;
    }
}

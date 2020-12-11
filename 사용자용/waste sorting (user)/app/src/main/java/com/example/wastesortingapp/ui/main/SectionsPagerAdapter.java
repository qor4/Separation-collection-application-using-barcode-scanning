package com.example.wastesortingapp.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.wastesortingapp.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new baricecream();
        else if(position==1)
            return new box();
        else if(position==2)
            return new can();
        else if(position==3)
            return new cupnoodle();
        else if(position==4)
            return new glassbottle();
        else if(position==5)
            return new iron();
        else if(position==6)
            return new note();
        else if(position==7)
            return new paper();
        else if(position==8)
            return new paperpack();
        else if(position==9)
            return new pet();
        else
            return new plasticbag();



    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 11;
    }
}
package com.pariwisatjogja.suhin_22.pariwisatjogja;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by SUHIN_22 on 09-05-2016.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    //Open
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String f = null;
        switch (position) {
            case 0:
                f = "Wisata Pantai";
                break;
            case 1:
                f = "Wisata Museum";
                break;
        }
        return f;
    }
    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch (position) {
            case 0:
                 f = new PantaiFragment();
                 break;
            case 1:
                f = new MuseumFragment();
                break;
         }
        return f;
    }
}

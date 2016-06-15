package com.vmr.vmrdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.vmr.vmrdemo.LoginFragments.FragmentCorporate;
import com.vmr.vmrdemo.LoginFragments.FragmentFamily;
import com.vmr.vmrdemo.LoginFragments.FragmentIndividual;
import com.vmr.vmrdemo.LoginFragments.FragmentProfessional;

/**
 * Created by abhijit on 6/10/16.
 */
public class PagerAdapterLogin extends FragmentPagerAdapter {
    int mNumOfTabs;
    String[] tabs = { "Individual", "Family", "Professional", "Corporate" };
    public PagerAdapterLogin(FragmentManager fm) {
        super(fm);
        this.mNumOfTabs = tabs.length;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentIndividual fragmentIndividual = new FragmentIndividual();
                return fragmentIndividual;
            case 1:
                FragmentFamily fragmentFamily = new FragmentFamily();
                return fragmentFamily;
            case 2:
                FragmentProfessional fragmentProfessional = new FragmentProfessional();
                return fragmentProfessional;
            case 3:
                FragmentCorporate fragmentCorporate = new FragmentCorporate();
                return fragmentCorporate;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return tabs[0];
            case 1:
                return tabs[1];
            case 2:
                return tabs[2];
            case 3:
                return tabs[3];
            default:
                return null;
        }
    }
}

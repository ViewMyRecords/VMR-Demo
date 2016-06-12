package com.vmr.vmrdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.vmr.vmrdemo.Fragments.FragmentCorporate;
import com.vmr.vmrdemo.Fragments.FragmentFamily;
import com.vmr.vmrdemo.Fragments.FragmentIndividual;
import com.vmr.vmrdemo.Fragments.FragmentProfessional;

/**
 * Created by abhijit on 6/10/16.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
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
}

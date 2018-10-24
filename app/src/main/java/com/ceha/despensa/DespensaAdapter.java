package com.ceha.despensa;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by carloseduardohernandezaguilar on 23/10/18.
 */

public class DespensaAdapter extends FragmentStatePagerAdapter {
    private DespensaActivity activity;

    public DespensaAdapter(FragmentManager fragmentManager, DespensaActivity activity) {
        super(fragmentManager);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ProductoFragment.newInstance(0);
            case 1:
                return GastoFragment.newInstance(1);
            case 2:
                return TareaFragment.newInstance(2);

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}

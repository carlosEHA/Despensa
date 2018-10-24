package com.ceha.despensa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by carloseduardohernandezaguilar on 23/10/18.
 */

public class ProductoFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public ProductoFragment() {}


    public static ProductoFragment newInstance(int param1) {
        ProductoFragment fragment = new ProductoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_producto, container, false);
    }
}


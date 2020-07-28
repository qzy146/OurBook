package com.our_book.BookCityFragment;



import android.os.Bundle;

import com.our_book.R;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;



public class BookCityFragment extends Fragment {
    private Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bookcityfragment,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        toolbar=view.findViewById(R.id.toolbar_bookcityfragment);
        toolbar.setTitle("书城");
    }
}
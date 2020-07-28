package com.our_book.CommunityFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.our_book.R;

public class CommunityFragment extends Fragment {
    private Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.communityfragment,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        toolbar=view.findViewById(R.id.toolbar_communityfragment);
        toolbar.setTitle("社区");
    }

}

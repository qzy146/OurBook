package com.our_book.MineFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.our_book.R;
import com.our_book.main_Activity.LogActivity;

public class MineFragment extends Fragment {
    private Toolbar toolbar;
    private Button login_button;
    private Button read_button;
    private Button post_button;
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.minefragment,container,false);
        login_button = (Button) view.findViewById(R.id.log_button);
        read_button = (Button) view.findViewById(R.id.reading_notes);
        post_button = (Button) view.findViewById(R.id.posting_note);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), LogActivity.class);
                startActivity(intent);
            }

        });

        initView(view);
        return view;
    }

    private void initView(View view) {
        toolbar=view.findViewById(R.id.toolbar_minefragment);
        toolbar.setTitle("我的");
    }
}

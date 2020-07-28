package com.our_book.BookRackFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import com.our_book.BookRackFragment.test.test_book;
import com.our_book.BookRackFragment.test.testbookAdapter;
import com.our_book.R;


import java.util.ArrayList;
import java.util.List;


public class BookRackFragment extends Fragment {
    private Toolbar toolbar;
    private List<test_book> rack_book = new ArrayList<>();




        private void startthebookrack() {
            rack_book.clear();
            for (int i = 0; i < 1; i++) {
                test_book apple = new test_book("为美好的世界\n献上祝福", R.drawable.bookcover1);
                //Toast.makeText(OurBookApplication.getContext(),"触发书架添加程序",Toast.LENGTH_SHORT).show();
                rack_book.add(apple);
            }
        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bookrackfragment,container,false);
        initView(view);
        startthebookrack();
        return view;
    }

    private void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        testbookAdapter adapter = new testbookAdapter(rack_book);
        recyclerView.setAdapter(adapter);
        toolbar=view.findViewById(R.id.toolbar_bookrackfragment);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        toolbar.setTitle("书架");
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.bookrack_menu, menu);
        inflater.inflate(R.menu.search,menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bookrack_menu_button1:
                Toast.makeText(getContext(),"书架管理",Toast.LENGTH_LONG).show();
                break;
            case R.id.bookrack_menu_button2:
                Toast.makeText(getContext(),"下载管理",Toast.LENGTH_LONG).show();
                break;
            case R.id.bookrack_search:
                Toast.makeText(getContext(),"搜索",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
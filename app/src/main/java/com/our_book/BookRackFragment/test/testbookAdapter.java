package com.our_book.BookRackFragment.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.our_book.ActivityReadingBook;
import com.our_book.R;
import com.our_book.base.OurBookApplication;

import java.util.List;

public class testbookAdapter extends RecyclerView.Adapter<testbookAdapter.ViewHolder>  {

    private Context context;
    private List<test_book> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View test_bookview;
        ImageView book_rack_Image;
        TextView  book_rack_Name;

        public ViewHolder(View view) {
            super(view);
            test_bookview=view;
            book_rack_Image = (ImageView) view.findViewById(R.id.test_book_image);
            book_rack_Name = (TextView) view.findViewById(R.id.test_book_name);
        }

    }

    public testbookAdapter(List<test_book> fruitList)
    {
        mFruitList = fruitList;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.testbook, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.test_bookview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position =holder.getAdapterPosition();
                test_book testbook=mFruitList.get(position);
                Intent intent=new Intent(view.getContext(), ActivityReadingBook.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                OurBookApplication.getContext().startActivity(intent);
            }
        });
        holder.book_rack_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                test_book fruit = mFruitList.get(position);
                Intent intent=new Intent(view.getContext(), ActivityReadingBook.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                OurBookApplication.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        test_book fruit = mFruitList.get(position);
        holder.book_rack_Image.setImageResource(fruit.getImageId());
        holder.book_rack_Name.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

}
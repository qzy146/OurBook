package com.our_book.util;


import android.content.Context;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.our_book.R;
import com.our_book.base.OurBookApplication;


public class NoticeUtil {
    public enum Notice{NOTICE_WARNING,NOTICE_INFO,NOTICE_CUSTOM}
    private static  ImageView imageView;
    private static LinearLayout linearLayout;
    private static Integer imgResId;
    private static Integer linearResId;
    /**
     * 展示time==LENGTH_SHORT
     *
     * @param msg
     */
    public static void show(Notice level,String msg) {
        show(level,msg, Toast.LENGTH_SHORT);
    }
    /**
     * 展示time==LENGTH_LONG
     *
     * @param msg
     */
    public static void showLong(Notice level,String msg) {
        show(level,msg, Toast.LENGTH_LONG);
    }
    private static void show(Notice level,String massage, int show_length) {
        Context context = OurBookApplication.getContext();
        //使用布局加载器，将编写的toast_layout布局加载进来
        View view = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
        //获取ImageView
        imageView= view.findViewById(R.id.image_toast);
        //获取TextView
        TextView title = view.findViewById(R.id.text_toast);
        //获取背景
        linearLayout=view.findViewById(R.id.linear_toast);
        //警告级别
        if (level==Notice.NOTICE_WARNING)
        { //设置图片
            imgResId=R.drawable.warning;
            linearResId=R.drawable.toast_background_warning;
            setImageView();
            setBackground();
            // linearLayout.setBackground(context.getResources().getDrawable(R.drawable.toast_background_warning));
        }
        else if (level==Notice.NOTICE_INFO)
        {
            linearResId=R.drawable.toast_background_info;
            setBackground();
            //linearLayout.setBackground(context.getResources().getDrawable(R.drawable.toast_background_info));
        }
        else {
            setImageView();
            setBackground();
        }
        //设置显示的内容
        title.setText(massage);
        Toast toast = new Toast(context);
        //设置Toast要显示的位置，水平居中并在底部，X轴偏移0个单位，Y轴偏移70个单位，
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 70);
        //设置显示时间
        toast.setDuration(show_length);
        toast.setView(view);
        toast.show();
        imgResId=null;
        linearResId=null;
    }
    private static void setImageView()
    {
        if (imgResId!=null)
            imageView.setImageResource(imgResId);
    }
    private static void setBackground()
    {
        if (linearResId!=null)
            linearLayout.setBackground(OurBookApplication.getContext().getResources().getDrawable(linearResId));
    }
}
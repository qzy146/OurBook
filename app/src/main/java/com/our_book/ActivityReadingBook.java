package com.our_book;


import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.our_book.base.BaseActivity;
import com.our_book.base.OurBookApplication;


public class ActivityReadingBook extends BaseActivity {
    private DrawerLayout drawerLayout;
    private View open_top_menu;
    private View open_bottom_menu;
    private View reading_bottom_menu_setting;
    private View open_top_menu_below_toolbar;
    private int flag=0;
    private int second_flag=0;
    @Override
    protected BaseActivityMode initData() {
        return BaseActivityMode.TWICE_ON_KEY_DOWN;
    }

    @Override
    protected void initView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 隐藏应用程序的标题栏，即当前activity的label
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // 隐藏android系统的状态栏
        setContentView(R.layout.activity_reading_book);
        View reading_openmenu=findViewById(R.id.readingbook_open_menu);
        View reading_last=findViewById(R.id.readingbook_last);
        View reading_next=findViewById(R.id.readingbook_next);
        View open_bottom_menu_setting=findViewById(R.id.reading_open_bottom_menu_setting);
        drawerLayout=findViewById(R.id.read_dl_slide);

        reading_bottom_menu_setting=findViewById(R.id.reading_bottom_menu_setting);
        open_top_menu=findViewById(R.id.read_abl_top_menu);
        open_bottom_menu=findViewById(R.id.read_ll_bottom_menu);
        View opentest=findViewById(R.id.read_tv_category);


        open_bottom_menu_setting.setOnClickListener(this);
        opentest.setOnClickListener(this);
        reading_openmenu.setOnClickListener(this);
        reading_last.setOnClickListener(this);
        reading_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.readingbook_open_menu:
                reading_bottom_menu_setting.setVisibility(View.INVISIBLE);
                if(flag==1&&second_flag==0)
                {
                    open_top_menu.setVisibility(View.INVISIBLE);
                    open_bottom_menu.setVisibility(View.INVISIBLE);
                    flag=0;
                }
                else if(second_flag==0)
                {
                    open_top_menu.setVisibility(View.VISIBLE);
                    open_bottom_menu.setVisibility(View.VISIBLE);
                    flag=1;
                }
                else second_flag=0;
                break;
            case R.id.readingbook_last:
                Toast.makeText(OurBookApplication.getContext(),"上一章",Toast.LENGTH_SHORT).show();
                reading_bottom_menu_setting.setVisibility(View.INVISIBLE);
                second_flag=0;
                break;

            case R.id.readingbook_next:
                Toast.makeText(OurBookApplication.getContext(),"下一章",Toast.LENGTH_SHORT).show();
                wuyy();
                reading_bottom_menu_setting.setVisibility(View.INVISIBLE);
                second_flag=0;
                break;
            case R.id.read_tv_category:
                open_top_menu.setVisibility(View.INVISIBLE);
                open_bottom_menu.setVisibility(View.INVISIBLE);
                flag=0;
//                Toast.makeText(OurBookApplication.getContext(),"打开目录",Toast.LENGTH_SHORT).show();
                openmenu();
                break;
            case R.id.reading_open_bottom_menu_setting:
            {
                open_top_menu.setVisibility(View.INVISIBLE);
                open_bottom_menu.setVisibility(View.INVISIBLE);
                flag=0;
                second_flag=1;
                reading_bottom_menu_setting.setVisibility(View.VISIBLE);
//                Toast.makeText(OurBookApplication.getContext(),"测试设置",Toast.LENGTH_SHORT).show();
                break;
            }

            default:
                //Toast.makeText(OurBookApplication.getContext(),"触发事件3",Toast.LENGTH_SHORT).show();

                if(second_flag==0)
                    reading_bottom_menu_setting.setVisibility(View.INVISIBLE);
                break;

            }
        }
private void wuyy(){

}
    public void openmenu(){
        drawerLayout.openDrawer(GravityCompat.START);
    }
}

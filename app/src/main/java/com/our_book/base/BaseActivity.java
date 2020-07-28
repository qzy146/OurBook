package com.our_book.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.our_book.util.NoticeUtil;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


///////@@@注释：这是我抄的组长的代码，写的Base类基类，里面可以加了一些接口，如果想要继承，那么必须要实现3个定义好函数
abstract public class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    public enum BaseActivityMode{ON_KEY_DOWN,TWICE_ON_KEY_DOWN}
    private long exitTime = 0;
    private BaseActivityMode mode;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        BaseActivityMode mode=initData();
        setMode(mode);
        initView();
    }
    //设置活动返回键类型
    private void setMode(BaseActivityMode mode){
        this.mode=mode;
    }
    //返回活动返回键类型：一次退出或按两次退出

    protected abstract BaseActivityMode initData();//加载数据
    protected abstract void initView();//加载布局


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN&&mode==BaseActivityMode.TWICE_ON_KEY_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                NoticeUtil.show(NoticeUtil.Notice.NOTICE_INFO,"再按一次退出应用");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

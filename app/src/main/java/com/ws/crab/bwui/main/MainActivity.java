package com.ws.crab.bwui.main;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ws.crab.R;
import com.ws.crab.base.BaseActivity;
import com.ws.crab.bwui.mine.MineFragment;
import com.ws.crab.bwui.msg.MsgFragment;
import com.ws.crab.bwui.wscircle.CircleFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.footer_rb_circle)
    TextView footer_circle;
    @InjectView(R.id.footer_rb_mine)
    TextView footer_mine;
    @InjectView(R.id.footer_rb_msg)
    TextView footer_msg;
    private CircleFragment circleFragment;
    private MsgFragment msgFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initFragment1();
    }

    private void initFragment1() {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        if (circleFragment == null) {
            circleFragment = new CircleFragment();
            transaction.add(R.id.content, circleFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(circleFragment);
        //提交事务
        transaction.commit();
    }
    private void initFragment2() {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if (msgFragment == null) {
            msgFragment = new MsgFragment();
            transaction.add(R.id.content, msgFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(msgFragment);
        //提交事务
        transaction.commit();
    }
    private void initFragment3() {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if (mineFragment == null) {
            mineFragment = new MineFragment();
            transaction.add(R.id.content, mineFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(mineFragment);
        //提交事务
        transaction.commit();
    }
    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction){
        if(circleFragment != null){
            transaction.hide(circleFragment);
        }
        if(msgFragment != null){
            transaction.hide(msgFragment);
        }
        if(mineFragment !=null){
            transaction.hide(mineFragment);
        }
    }
    @OnClick({R.id.footer_rb_circle, R.id.footer_rb_msg, R.id.footer_rb_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.footer_rb_circle:
                footer_circle.setSelected(true);
                footer_msg.setSelected(false);
                footer_mine.setSelected(false);
                initFragment1();
                break;
            case R.id.footer_rb_msg:
                footer_circle.setSelected(false);
                footer_msg.setSelected(true);
                footer_mine.setSelected(false);
                initFragment2();
                break;
            case R.id.footer_rb_mine:
                footer_circle.setSelected(false);
                footer_msg.setSelected(false);
                footer_mine.setSelected(true);
                initFragment3();
                break;
        }
    }
}

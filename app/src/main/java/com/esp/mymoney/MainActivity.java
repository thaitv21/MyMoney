package com.esp.mymoney;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView selectWallet;
    private TextView walletName;
    private TextView walletMoney;
    private ImageView notificationView;
    private ImageView moreView;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private Dictionary<String, MainFragment> fragments = new Dictionary<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        tabLayout = findViewById(R.id.home_tab_layout);
        viewPager = findViewById(R.id.home_view_pager);
        String[] title = new String[] {"03/2018", "Tháng trước", "Tháng này", "Tương lai"};
        for (int i = 0; i < title.length; i++) {
            MainFragment fragment = new MainFragment();
            fragments.add(title[i], fragment);
        }
        pagerAdapter = new PagerAdapter(this, getSupportFragmentManager(), fragments);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setPageMargin(20);
    }
}

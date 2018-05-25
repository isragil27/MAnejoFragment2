package com.example.isgil27.manejofragment;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.isgil27.manejofragment.Fragments.Fragment1;
import com.example.isgil27.manejofragment.Fragments.Fragment2;
import com.example.isgil27.manejofragment.Fragments.PageAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= findViewById(R.id.mitoolbar);
        tabLayout=findViewById(R.id.miTabLayout);
       viewPager=findViewById(R.id.miviewpager);


        setUpViewPager();

        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
        }




    }

    private ArrayList<Fragment> AgregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());

        return fragments;

    }
    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),AgregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
    }
}

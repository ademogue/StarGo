package com.example.antho.stargo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangJ on 2017/12/10.
 */

public class Introduction extends Activity {
    private ViewPager viewPager;
    private PagerTitleStrip pagerTitleStrip;
    private List<View> list;
    private List<String> titleList;
    private Button skip;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction1);

        skip = (Button) findViewById(R.id.btn);
        skip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent activityMainActivity = new Intent(Introduction.this, MainActivity.class);
                startActivity(activityMainActivity);
            }
        });
        viewPager = (ViewPager) this.findViewById(R.id.viewpager);
        pagerTitleStrip = (PagerTitleStrip) this.findViewById(R.id.pagertitle);
        //
        View view1 = LayoutInflater.from(Introduction.this).inflate(
                R.layout.tab1,null);
        View view2 = LayoutInflater.from(Introduction.this).inflate(
                R.layout.tab2,null);
        View view3 = LayoutInflater.from(Introduction.this).inflate(
                R.layout.tab3,null);
        list =new ArrayList<View>();
        list.add(view1);
        list.add(view2);
        list.add(view3);
        titleList = new ArrayList<String>();
        titleList.add("title1");
        titleList.add("title2");
        titleList.add("title2");

        viewPager.setAdapter(new MyAdapter());
    }
    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount(){
            return list.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container,position,object);
            ((ViewPager) container).removeView(list.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager) container).addView(list.get(position));
            return list.get(position);
        }


        @Override
        public boolean isViewFromObject(View arg0, Object arg1){
            return arg0==arg1;
        }

    }
}

package com.example.leliao;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends Fragment {
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        ViewPager homeViewPage = view.findViewById(R.id.homeViewpager);

        final List<View> viewList = new ArrayList<View>();
        viewList.add(new QiangLiao(getContext(), null));
        viewList.add(new DongTai(getContext(), null));

//        Fragment fragment01 = new HomeFragment01();
//        Fragment fragment02 = new HomeFragment02();
//        listfragment.add(fragment01);
//        listfragment.add(fragment02);

//        HomeFragmentPagerAdapter mfpa=new HomeFragmentPagerAdapter(getFragmentManager(), listfragment); //new myFragmentPagerAdater记得带上两个参数
//
//        homeViewPage.setAdapter(mfpa);
//        homeViewPage.setCurrentItem(0); //设置当前页是第一页

        final ArrayList titles = new ArrayList<String>();
        titles.add("财富榜");
        titles.add("礼物榜");

        tabLayout = view.findViewById(R.id.tabLayout);
//        tabStrip.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
//        tabStrip.setTabIndicatorColor(getResources().getColor(android.R.color.holo_purple));
//        tabStrip.setTextColor(Color.BLACK);

        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View view, Object object) {
                //return view == object;
                //根据传来的key，找到view,判断与传来的参数View view是不是同一个视图
                return view == viewList.get((int)Integer.parseInt(object.toString()));
            }

            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                //return viewList.get(position);
                return position;
            }
            @Override
            public CharSequence getPageTitle(int positon){
                return titles.get(positon).toString();
            }

        };

        homeViewPage.setAdapter(pagerAdapter);

        return view;

    }
}

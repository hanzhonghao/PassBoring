package com.exercise.passboring.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 项目名称：PassBoring
 * 类描述： ViewPager适配器
 * 创建人：小豪
 * 创建时间：2017/3/22 9:25
 * 修改人：小豪
 * 修改时间：2017/3/22 9:25
 * 修改备注：
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    List<String> mTitles;
    List<Fragment> fragments;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mTitles = new ArrayList<>();
        fragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    public void setItems(List<Fragment> fragments,List<String> mTitles){
        this.fragments = fragments;
        this.mTitles = mTitles;
        notifyDataSetChanged();
    }

    public void setItems(List<Fragment> fragments, String[] mTitles) {
        this.fragments = fragments;
        this.mTitles = Arrays.asList(mTitles);
        notifyDataSetChanged();
    }
    /**       以下增删改是用于频道管理        */
    public void addItem(Fragment fragment,String title){
        fragments.add(fragment);
        mTitles.add(title);
        notifyDataSetChanged();
    }

    public void delItem(int position) {
        mTitles.remove(position);
        fragments.remove(position);
        notifyDataSetChanged();
    }

    public int delItem(String title) {
        int index = mTitles.indexOf(title);
        if (index != -1) {
            delItem(index);
        }
        return index;
    }

    public void swapItems(int fromPos, int toPos) {
        Collections.swap(mTitles, fromPos, toPos);
        Collections.swap(fragments, fromPos, toPos);
        notifyDataSetChanged();
    }
}

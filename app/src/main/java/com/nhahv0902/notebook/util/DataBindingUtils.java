package com.nhahv0902.notebook.util;

import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatTextView;
import android.view.MenuItem;
import com.nhahv0902.notebook.R;
import com.nhahv0902.notebook.screen.main.MainViewModel;

/**
 * Created by nhahv0902 on 7/5/2017.
 * <></>
 */

public class DataBindingUtils {
    @BindingAdapter("type_fonts")
    public static void fonts(AppCompatTextView view, String fonts) {
        view.setTypeface(Typeface.createFromAsset(view.getContext().getAssets(), fonts));
    }

    /*
    * bind bottom navigation view in MainActivity
    * */
    @BindingAdapter({ "bottom_navigation", "bottom_view_pager" })
    public static void bottomNavigation(final BottomNavigationView view,
            final MainViewModel viewModel, ViewPager viewPager) {
        view.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_notebook:
                                viewModel.setCurrentViewPager(0);
                                return true;
                            case R.id.navigation_new_notebook:
                                viewModel.setCurrentViewPager(1);
                                return true;
                            case R.id.navigation_setting:
                                viewModel.setCurrentViewPager(2);
                                return true;
                            default:
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                    int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                view.setSelectedItemId(
                        position == 0 ? R.id.navigation_notebook : R.id.navigation_setting);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /*
      * bind view pager current of viewPager view in MainActivity
      * */
    @BindingAdapter("current_item")
    public static void currentItemViewPager(ViewPager view, int currentItem) {
        view.setCurrentItem(currentItem);
    }
}

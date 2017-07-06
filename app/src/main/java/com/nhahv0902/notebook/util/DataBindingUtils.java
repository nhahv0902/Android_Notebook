package com.nhahv0902.notebook.util;

import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatTextView;
import android.view.MenuItem;
import android.widget.TextView;
import com.nhahv0902.notebook.R;
import com.nhahv0902.notebook.screen.main.MainViewModel;
import com.nhahv0902.notebook.screen.main.notebook.NotebookContract;
import java.util.Calendar;
import java.util.Locale;

import static com.nhahv0902.notebook.screen.main.notebook.NotebookContract.NotebookDate
        .DAY_OF_MONTH;
import static com.nhahv0902.notebook.screen.main.notebook.NotebookContract.NotebookDate.DAY_OF_WEAK;
import static com.nhahv0902.notebook.screen.main.notebook.NotebookContract.NotebookDate.MONTH;
import static com.nhahv0902.notebook.screen.main.notebook.NotebookContract.NotebookDate.YEAR;

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

    /*
    * bind date time for item notebook
    * in ItemFragmentNotebook
    * */
    @BindingAdapter(value = { "date_notebook", "date_type", "time_notebook" }, requireAll = false)
    public static void dateTime(TextView view, long date,
            @NotebookContract.NotebookDate int dateType, String time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        switch (dateType) {
            case DAY_OF_MONTH:
                view.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
                break;
            case DAY_OF_WEAK:
                String timeDay =
                        time + ", " + calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG,
                                Locale.getDefault());
                view.setText(timeDay);
                break;
            case MONTH:
                view.setText(String.valueOf(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG,
                        Locale.getDefault())));
                break;
            case YEAR:
                view.setText(String.valueOf(calendar.get(Calendar.YEAR)));
                break;
            default:
                view.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
                break;
        }
    }
}

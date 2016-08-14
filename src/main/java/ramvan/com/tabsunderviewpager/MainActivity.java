package ramvan.com.tabsunderviewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ramvan.com.tabsunderviewpager.fragments.FirstTabFragment;
import ramvan.com.tabsunderviewpager.fragments.SecTabFragment;

public class MainActivity extends AppCompatActivity {

    private static final int FIRST_TAB  = 0;
    private static final int SECOND_TAB  = 1;
    private ViewPager mPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this is used to remove the action bar shadow.
        getSupportActionBar().setElevation(0);

        mPager = (ViewPager)findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        initViewPager(mPager);

        tabLayout.setupWithViewPager(mPager);

        // setting the default action bar title of the first tab.
        setActionBarTitle(getString(R.string.first_tab));

        /**
         * callback function when the user tap on the tabs text
         */
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // setting the action bar title with the selected tab
                setActionBarTitle(tab.getText().toString().trim());
                setSelectedTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * set the action bar title
     * @param mTitle
     */
    private void setActionBarTitle(String mTitle){
        getSupportActionBar().setTitle(mTitle);
    }

    /**
     * redirecting the Viewpage to specific position when click on tab text
     * @param position
     */
    protected void setSelectedTab(int position) {
        switch (position) {
            case FIRST_TAB:
                mPager.setCurrentItem(FIRST_TAB);
                break;
            case SECOND_TAB:
                mPager.setCurrentItem(SECOND_TAB);
                break;
            default:
                break;
        }
    }

    /**
     * initializing the view pager
     * @param mPager
     */
    private void initViewPager(ViewPager mPager) {
        FragmentManager fm = getSupportFragmentManager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(fm);
        adapter.addFragment(new FirstTabFragment(),getString(R.string.first_tab));
        adapter.addFragment(new SecTabFragment(), getString(R.string.second_tab));
        mPager.setAdapter(adapter);
    }

    /**
     * view pager adapter
     */
    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

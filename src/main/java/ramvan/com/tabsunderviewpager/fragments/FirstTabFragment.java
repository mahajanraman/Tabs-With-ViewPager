package ramvan.com.tabsunderviewpager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ramvan.com.tabsunderviewpager.R;

/**
 * Created by Mahajan on 09-Aug-16.
 */
public class FirstTabFragment extends Fragment{

    private View mFirstTabView;

    public FirstTabFragment(){
        // empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFirstTabView = inflater.inflate(R.layout.first_tab_layout, container , false);
        return mFirstTabView;
    }
}

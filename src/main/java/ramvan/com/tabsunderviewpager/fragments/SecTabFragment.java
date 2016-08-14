package ramvan.com.tabsunderviewpager.fragments;

/**
 * Created by Mahajan on 09-Aug-16.
 */
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
public class SecTabFragment extends Fragment{

    private View mSecTabView;

    public SecTabFragment(){
        // empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mSecTabView = inflater.inflate(R.layout.sec_tab_layout, container , false);
        return mSecTabView;
    }
}
package ua.ck.geekhub.ivanov.rssreader.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import ua.ck.geekhub.ivanov.rssreader.R;
import ua.ck.geekhub.ivanov.rssreader.fragments.ListFragment;

public class ListActivity extends ActionBarActivity {

    private ListFragment mFeedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.ab_solid_toolbarstyle_list));
        actionBar.setIcon(getResources().getDrawable(R.drawable.ic_launcher));

        if (mFeedFragment == null) {
            mFeedFragment = new ListFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.list_main_container, mFeedFragment).commit();
        }
    }
}
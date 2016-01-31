package com.ronstruempf.fragmenttest;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Fragment for displaying selected item details
 *
 * Created by Ron on 1/31/2016.
 */
public class DetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("APP_DEBUG", "DetailFragment.onCreateView called");
        View view = inflater.inflate(R.layout.fragment_rssitem_detail,
                container, false);
        return view;
    }
    public void setText(String url) {
        TextView view = (TextView) getView().findViewById(R.id.detailsText);
        view.setText(url);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("APP_DEBUG", "DetailFragment.onAttach(Context) called");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("APP_DEBUG", "DetailFragment.onAttach(Activity) called");
    }


}

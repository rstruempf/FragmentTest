package com.ronstruempf.fragmenttest;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Fragment to display item list
 *
 * Created by Ron on 1/31/2016.
 */
public class MyListFragment extends Fragment {

    private MyListFragment.OnItemSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("APP_DEBUG", "MyListFragment.onCreateView called");
        View view = inflater.inflate(R.layout.fragment_rsslist_overview,
                container, false);
        Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("fake");
            }
        });
        return view;
    }

    public interface OnItemSelectedListener {
        public void onRssItemSelected(String link);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("APP_DEBUG", "MyListFragment.onAttach(Context) called");
        assignListener(context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("APP_DEBUG", "MyListFragment.onAttach(Activity) called");
        assignListener(activity);
    }

    private void assignListener(Context context) {
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }


    // triggers update of the details fragment
    public void updateDetail(String uri) {
        // create fake data
        String newTime = String.valueOf(System.currentTimeMillis());
        // send data to activity
        if (listener != null) {
            listener.onRssItemSelected(newTime);
        }
        else {
            Log.d("APP_DEBUG", "updateDetail: listener is null");
        }
    }
}

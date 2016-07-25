package net.hitechgroupindia.hitechgroup.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.GridView;

import net.hitechgroupindia.hitechgroup.Activity.FullScreenImage;
import net.hitechgroupindia.hitechgroup.Activity.HitechFarmActivity;
import net.hitechgroupindia.hitechgroup.Adapter.CustomGridAdapterProjectFragment;
import net.hitechgroupindia.hitechgroup.R;


public class ProjectFragment extends android.support.v4.app.Fragment {

    public ProjectFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_project, container, false);
        GridView gridView = (GridView)view. findViewById(R.id.grid_view);
        hideKeyboard(getActivity());
        // Instance of ImageAdapter Class
        int image[] = new int[]{R.drawable.gallery8,R.drawable.six};

        final String text[] ={"HITECH FARM","HITECH GHARAUNDA"};

        gridView.setAdapter(new CustomGridAdapterProjectFragment(getActivity(),text,image));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                if (position == 0) {
                    Intent i = new Intent(getActivity(), HitechFarmActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(getActivity(), FullScreenImage.class);
                    // passing array index
                    i.putExtra("id", position);
                    startActivity(i);
                }

            }
        });

        return view;
    }

    public static void hideKeyboard(Context ctx) {
        InputMethodManager inputManager = (InputMethodManager) ctx
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View v = ((Activity) ctx).getCurrentFocus();
        if (v == null)
            return;

        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

}

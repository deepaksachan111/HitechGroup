package net.hitechgroupindia.hitechgroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import net.hitechgroupindia.hitechgroup.Adapter.ProjectImageAdapter;


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

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ProjectImageAdapter(getActivity()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                if (position == 1) {
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



}
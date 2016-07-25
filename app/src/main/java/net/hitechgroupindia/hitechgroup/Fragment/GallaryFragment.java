package net.hitechgroupindia.hitechgroup.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import net.hitechgroupindia.hitechgroup.Activity.FullScreenViewPager;
import net.hitechgroupindia.hitechgroup.Adapter.ImageAdapterGallary;
import net.hitechgroupindia.hitechgroup.R;


public class GallaryFragment extends android.support.v4.app.Fragment {

    public GallaryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        GridView gridView = (GridView)view. findViewById(R.id.gridview_gallery);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapterGallary(getActivity()));

        // Listening to GridView item click
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // Launch ImageViewPager.java on selecting GridView Item
                Intent i = new Intent(getActivity(), FullScreenViewPager.class);

                // Show a simple toast message for the item position
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();

                // Send the click position to ImageViewPager.java using intent
                i.putExtra("id", position);

                // Start ImageViewPager
                startActivity(i);
            }
        });

return view;
    }
}

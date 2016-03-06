package net.hitechgroupindia.hitechgroup;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import net.hitechgroupindia.hitechgroup.Adapter.CustomGridAdapterHomeFragment;


public class HomeFragment extends android.support.v4.app.Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView imageView = (ImageView)view.findViewById(R.id.iv_homeimg);

        AnimationDrawable animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.iv1),2000);
        animation.addFrame(getResources().getDrawable(R.drawable.iv2), 3000);
        animation.addFrame(getResources().getDrawable(R.drawable.iv4), 2000);

        animation.setOneShot(false);
        imageView.setBackgroundDrawable(animation);

        // start the animation!
        animation.start();
        final Button button_contactus =(Button)view.findViewById(R.id.btn_contactus);
        button_contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ContactUsActivity.class));
            }
        });


      // gridview
        GridView gridView =(GridView)view.findViewById(R.id.gridview_home_fragment);

        int image[] = new int[]{R.drawable.user_icon,R.drawable.gallery_icon,R.drawable.project_icon,R.drawable.location_icon,R.drawable.mail_icon,R.drawable.setting_icon};

        final String text[] ={"About Us","Gallery","Project","Contact Us","Mail","Setting"};

        CustomGridAdapterHomeFragment gridAdapter = new CustomGridAdapterHomeFragment(getActivity(),text,image);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " + text[+position], Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), AboutUsActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(),GalleryActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(),ProjectActivity.class));
                        break;
                }

            }
        });


        return view;
    }




}

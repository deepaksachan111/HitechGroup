package net.hitechgroupindia.hitechgroup;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import net.hitechgroupindia.hitechgroup.Adapter.CustomGridAdapterHomeFragment;
import net.hitechgroupindia.hitechgroup.Fragment.*;


public class Extrafragment extends Fragment {

    LinearLayout linear_dashbord;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_extrafragment, container, false);

        linear_dashbord = (LinearLayout)view.findViewById(R.id.linear_dashboard);
       // final GridView gridView =(GridView)view.findViewById(R.id.gridview_extra_fragment);
       /* final    String text[] ={"Dashboard","Profile","Team","Business","Income","ePins","Rewards"};
        int image[] = new int[]{R.mipmap.dashboard,R.mipmap.picture,R.mipmap.team,R.mipmap.menu,R.mipmap.dollor,R.mipmap.gift,R.id.rewards};

        final CustomGridAdapterHomeFragment gridAdapter = new CustomGridAdapterHomeFragment(getActivity(),text,image);
        //gridView.setAdapter(gridAdapter);*/

       linear_dashbord.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getFragmentManager().beginTransaction().replace(R.id.viewpager, new net.hitechgroupindia.hitechgroup.Fragment.ProjectFragment()).commit();
           }
       });
        //getSupportFragmentManager().beginTransaction().replace(R.id.viewpager, new ProjectFragment()).commit();


        return view;
    }


}

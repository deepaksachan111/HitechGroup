package net.hitechgroupindia.hitechgroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;


public class AboutFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    ImageView imageView_up, imageView_down;
    ScrollView scrollView;
    LinearLayout linearLayout;
    public AboutFragment() {
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
        View view = inflater.inflate(R.layout.fragment_about, container, false);


        Button  btnpopup = (Button) view.findViewById(R.id.btn_vision_mission);

        btnpopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(),VisionMissionActivity.class));
              /*  LayoutInflater layoutInflater = (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View popupView = layoutInflater.inflate(R.layout.popup_about, null);
                final PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                Button btnabout = (Button) popupView.findViewById(R.id.about);
                */

            }
        });

        scrollView = (ScrollView) view.findViewById(R.id.iv_scroll_aboutus);
        imageView_up = (ImageView) view.findViewById(R.id.iv_upscroll);
        imageView_down = (ImageView) view.findViewById(R.id.iv_downscroll);



        scrollView.setOnClickListener(this);
        imageView_down.setOnClickListener(this);
        imageView_up.setOnClickListener(this);
       // btnpopup.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View v) {
       if(v == imageView_up){
            scrollView.fullScroll(View.FOCUS_DOWN);
           // scrollView.scrollTo(0,50);
            imageView_up.setVisibility(View.GONE);
            imageView_down.setVisibility(View.VISIBLE);
        }else if(v == imageView_down) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);
            //scrollView.scrollBy(0, -50);
            imageView_down.setVisibility(View.GONE);
            imageView_up.setVisibility(View.VISIBLE);
        }
    }
}

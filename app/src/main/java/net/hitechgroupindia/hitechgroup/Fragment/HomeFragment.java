package net.hitechgroupindia.hitechgroup.Fragment;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.hitechgroupindia.hitechgroup.Activity.AboutUsActivity;
import net.hitechgroupindia.hitechgroup.Activity.ContactUsActivity;
import net.hitechgroupindia.hitechgroup.Activity.GalleryActivity;
import net.hitechgroupindia.hitechgroup.Activity.ProjectActivity;
import net.hitechgroupindia.hitechgroup.Adapter.CustomGridAdapterHomeFragment;
import net.hitechgroupindia.hitechgroup.LoginActivity;
import net.hitechgroupindia.hitechgroup.R;
import net.hitechgroupindia.hitechgroup.SessionManager;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeFragment extends android.support.v4.app.Fragment {
    int tipPosition = 0;
    ImageView imageView;
    TextView textView;

    String text[] ={"About Us","Gallery","Project","Contact Us","Mail","Login"};

    String text2[] ={"About Us","Gallery","Project","Contact Us","Mail","Dashboard"};
 int colours[] = new int[]{R.color.light_color,R.color.colorAccent,R.color.colorPrimary,R.color.light_color,R.color.yellow,R.color.orange};

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
        imageView = (ImageView)view.findViewById(R.id.iv_homeimg);
        textView = (TextView)view.findViewById(R.id.tv_animation);
      showAnimationImage();

        final Animation a = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_out_right);
        a.reset();


        final Handler tipsHanlder = new Handler();

        tipsHanlder.post(new Runnable() {
            @Override
            public void run() {
                //set number of tip(randon/another way)

                    textView.setText(text[tipPosition]);
                textView.startAnimation(a);
                    textView.setBackgroundColor(getResources().getColor(colours[tipPosition]));
                    tipPosition++;
                    if(tipPosition==6){
                        tipPosition = 0;
                    }


              tipsHanlder.postDelayed(this,3000);

            }
        });

    /*  final   WebView view2 = new WebView(getActivity());

        view2.setVerticalScrollBarEnabled(false);
        ((LinearLayout)view.findViewById(R.id.tv_home_1111)).addView(view2);
        view2.loadData(getString(R.string.text_aboutus_homefragment_linear), "text/html", "utf-8");*/

        final   WebView view3 = new WebView(getActivity());


        view3.setVerticalScrollBarEnabled(false);
        ((LinearLayout)view.findViewById(R.id.linear_fffffffffffffff)).addView(view3);
        view3.loadData(getString(R.string.text_aboutus_homefragment2_linear), "text/html", "utf-8");




        final Button button_contactus =(Button)view.findViewById(R.id.btn_contactus);
        button_contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ContactUsActivity.class));
            }
        });



      // gridview
        final GridView gridView =(GridView)view.findViewById(R.id.gridview_home_fragment);

        int image[] = new int[]{R.drawable.user_icon_new,R.drawable.gallery_icon_new,R.drawable.project_icon_new,R.drawable.location_icon_new,R.drawable.mail_icon_new,R.drawable.login_new};

        SessionManager sessionManager = new SessionManager(getActivity());

        HashMap<String, String> map = sessionManager.getUserDetails();
         String login_name = map.get(SessionManager.KEY_EMAIL);



      if(login_name == null){

          final CustomGridAdapterHomeFragment gridAdapter = new CustomGridAdapterHomeFragment(getActivity(),text,image);
          gridView.setAdapter(gridAdapter);
      }else{
          final CustomGridAdapterHomeFragment gridAdapter2 = new CustomGridAdapterHomeFragment(getActivity(),text2,image);
          gridView.setAdapter(gridAdapter2);
      }



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            View savedView;

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " + text[+position], Toast.LENGTH_SHORT).show();


                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), AboutUsActivity.class));


                        // view.setBackgroundResource(R.drawable.default_background);
                        break;
                    case 1:

                        startActivity(new Intent(getActivity(), GalleryActivity.class));
                        break;
                    case 2:

                        startActivity(new Intent(getActivity(), ProjectActivity.class));
                        break;
                    case 3:

                        startActivity(new Intent(getActivity(), ContactUsActivity.class));
                        break;
                    case 4:

                        sendMail();
                        break;

                    case 5:

                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        break;
                }



                }




        });


        return view;
    }




    private void sendMail() {


        ArrayList<String>Email = new ArrayList<String>();
        Email.add("info@hitechgroupindia.com");
      /*  Email.add("info@hitechgroupindia.com");

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, Email.toArray(new String[Email.size()]));
       // emailIntent.setType("plain/text");
        emailIntent.setType("message/rfc822");
        try {
            startActivityForResult(Intent.createChooser(emailIntent, "Choose App to send email:"), 1);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "No email clients installed.", Toast.LENGTH_SHORT).show();
        }*/

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + "info@hitechgroupindia.com"));
       /* emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Enter Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Enter Body ");*/


        try {
            startActivityForResult(Intent.createChooser(emailIntent, "Choose App to send email:"), 1);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "No email clients installed.", Toast.LENGTH_SHORT).show();
        }


    }


   // final String[] tipsArray = getResources().getStringArray(R.array.tips);


public void showAnimationImage(){


    AnimationDrawable animation = new AnimationDrawable();
    animation.addFrame(getResources().getDrawable(R.drawable.iv1),2000);
    animation.addFrame(getResources().getDrawable(R.drawable.iv2), 3000);
    animation.addFrame(getResources().getDrawable(R.drawable.iv4), 2000);

    animation.setOneShot(false);
    imageView.setBackgroundDrawable(animation);

    // start the animation!
    animation.start();
}


}

package net.hitechgroupindia.hitechgroup;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class HitechFarmActivity extends Activity implements View.OnClickListener{

    private ImageView btn_scrollup,btn_scrolldown;
    private LinearLayout linearLayout_back;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitech_farm);
             idsviewBy();
            linearLayout_back.setOnClickListener(this);
             btn_scrollup.setOnClickListener(this);
             btn_scrolldown.setOnClickListener(this);
        scrollView.setOnClickListener(this);

    }

    public void idsviewBy(){
 linearLayout_back =(LinearLayout)findViewById(R.id.iv_back_linear_hitechfarm);
        scrollView=(ScrollView)findViewById(R.id.scrollView_hitech_farm);
        btn_scrollup =(ImageView)findViewById(R.id.iv_upscroll_hi_farm);
        btn_scrolldown=(ImageView)findViewById(R.id.iv_downscrollhi_farm);

    }

    @Override
    public void onClick(View v) {
        if(v == linearLayout_back){
            finish();
        }else if(v == btn_scrollup){
            scrollView.fullScroll(View.FOCUS_UP);
            btn_scrollup.setVisibility(View.GONE);
            btn_scrolldown.setVisibility(View.VISIBLE);
        }else if(v == btn_scrolldown){
            scrollView.fullScroll(View.FOCUS_DOWN);
            btn_scrolldown.setVisibility(View.GONE);
            btn_scrollup.setVisibility(View.VISIBLE);
        }
    }
}

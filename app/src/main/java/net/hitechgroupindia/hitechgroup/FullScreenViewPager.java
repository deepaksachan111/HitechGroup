package net.hitechgroupindia.hitechgroup;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class FullScreenViewPager extends Activity {
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_view_pager);

        // Set title for the ViewPager
        setTitle("ViewPager");

        // Retrieve data from MainActivity on item click event
        Intent p = getIntent();
        position = p.getExtras().getInt("id");

        ImageAdapterGallary imageAdapter = new ImageAdapterGallary(this);
        List<ImageView> images = new ArrayList<ImageView>();

        // Retrieve all the images
        for (int i = 0; i < imageAdapter.getCount(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imageAdapter.mThumbIds[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            images.add(imageView);
        }

        // Set the images into ViewPager
        ImagePagerAdapter pageradapter = new ImagePagerAdapter(images);
        ViewPager viewpager = (ViewPager) findViewById(R.id.pager);
        viewpager.setAdapter(pageradapter);
        // Show images following the position
        viewpager.setCurrentItem(position);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_full_screen_view_pager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package net.hitechgroupindia.hitechgroup;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import net.hitechgroupindia.hitechgroup.Fragment.GallaryFragment;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.MainColor)));
       // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_gallary, new GallaryFragment()).commit();
            getSupportActionBar().setTitle("Gallery");
        }
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gallery, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

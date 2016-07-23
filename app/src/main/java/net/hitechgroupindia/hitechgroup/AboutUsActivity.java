package net.hitechgroupindia.hitechgroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.MainColor)));

      //  getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new AboutFragment()).commit();
            getSupportActionBar().setTitle("About Us");
        }

      //  View view =getLayoutInflater().inflate(R.layout.activity_contact_us,null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_, menu);
        return true;
    }

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

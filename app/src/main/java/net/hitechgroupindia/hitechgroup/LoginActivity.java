package net.hitechgroupindia.hitechgroup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import net.hitechgroupindia.hitechgroup.Fragment.LoginFragment;
import net.hitechgroupindia.hitechgroup.Fragment.LoginWebView;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    EditText editTextTo,editTextSubject,editTextMessage;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SessionManager sessionManager = new SessionManager(this);
        HashMap<String, String> map = sessionManager.getUserDetails();
        String loginname = map.get(SessionManager.KEY_EMAIL);
        if(loginname == null){

            getSupportFragmentManager().beginTransaction().add(R.id.container_login,new LoginFragment()).commit();
        }else{

            getSupportFragmentManager().beginTransaction().replace(R.id.container_login, new LoginWebView()).commit();
           // startActivity(new Intent(this,NavigationDrawerActivity.class));
        }
    }



 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_email, menu);
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

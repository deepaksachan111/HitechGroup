package net.hitechgroupindia.hitechgroup;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class NavigationDrawerActivity extends AppCompatActivity {

    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer_activity);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
     if(savedInstanceState == null){
     getSupportActionBar().setTitle("Dashboard");
     Toast.makeText(getApplicationContext(), "Inbox Selected", Toast.LENGTH_SHORT).show();
     DashboardFragment fragment = new DashboardFragment();
     android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
     fragmentTransaction.add(R.id.frame, fragment);
     fragmentTransaction.commit();
 }
        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

     /*   Menu menu = navigationView.getMenu();
        Menu topChannelMenu = menu.addSubMenu("Top Channels");

        topChannelMenu.add("Foo");
        topChannelMenu.add("Bar");
        topChannelMenu.add("Baz");*/

        navigationView.invalidate(); // Trying to force a redraw, doesn't help.
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);
                Menu menu = navigationView.getMenu();
                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.frag_dashboard:
                        getSupportActionBar().setTitle("Dashboard");
                        Toast.makeText(getApplicationContext(), "Inbox Selected", Toast.LENGTH_SHORT).show();
                        DashboardFragment fragment = new DashboardFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,fragment);
                        fragmentTransaction.commit();
                        return true;

                    // For rest of the options we just show a toast on click

                    case R.id.profile:
                   /*     navigationView.getMenu().clear(); //clear old inflated items.
                        navigationView.inflateMenu(R.menu.drawer);*/
                        Toast.makeText(getApplicationContext(), "Stared Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.team:

                        Toast.makeText(getApplicationContext(), "Send Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.business:
                        Toast.makeText(getApplicationContext(), "Drafts Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.income:
                       // menu .setGroupVisible(R.id.spam, false);
                        Toast.makeText(getApplicationContext(), "All Mail Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.epins:
                        Toast.makeText(getApplicationContext(), "Trash Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.rewards:

                        Toast.makeText(getApplicationContext(), "Spam Selected", Toast.LENGTH_SHORT).show();
                        return true;

                    default:
                        if(menuItem.getTitle().equals("Foo")) {
                            Toast.makeText(getApplicationContext(), "Foo", Toast.LENGTH_SHORT).show();
                        }else {

                            Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        }
                        return true;

                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();






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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

package wbollock.com.javainterface;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Layout
        RelativeLayout buckysLayout = new RelativeLayout(this);
        buckysLayout.setBackgroundColor(Color.GREEN);

        //Button
        Button redButton = new Button(this); // not yet displayed on screen
        redButton.setText("Log In");
        redButton.setBackgroundColor(Color.MAGENTA);

        //Username input
        EditText username = new EditText(this);

        redButton.setId(1);
        username.setId(2);

        //Rules of Button
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        ); // needed to set position of button

        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        ); // this is a container, too

        // Give rules to position widgets
        usernameDetails.addRule(RelativeLayout.ABOVE, redButton.getId()); // saying position it Above the RedButton
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0,0,0,50); // set bottom spacing between redButton

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        Resources r =  getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,
                r.getDisplayMetrics()
                ); // this is meant to get the value of 200 DIP and convert it to pixels
        username.setWidth(px); // now that we have pixel value we put it in right here

        // add widget to layout
        buckysLayout.addView(redButton, buttonDetails); // red Button says what to add, Button Details says how to add it
        buckysLayout.addView(username, usernameDetails);
        // set this activities content/display to view
        setContentView(buckysLayout);


            }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

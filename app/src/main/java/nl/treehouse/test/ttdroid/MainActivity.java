package nl.treehouse.test.ttdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    private int mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeText("We started!");

        Button button = (Button) this.findViewById(R.id.action_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText("We rock!");
            }
        });

        Button nextButton = (Button) this.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToNextActivity();
            }
        });
    }

    protected void moveToNextActivity() {
        Intent intent = new Intent(this, NextActivity.class);
        startActivity(intent);
    }

    protected void changeText(String input) {
        TextView textView = (TextView) this.findViewById(R.id.welcome_text);
        textView.setText(input);
    }

    protected String getText() {
        TextView textView = (TextView) this.findViewById(R.id.welcome_text);

        return (String) textView.getText();
    }

    protected void addToCounter(int update) {
        mCounter += update;
    }

    protected int getCounter() {
        return mCounter;
    }



}

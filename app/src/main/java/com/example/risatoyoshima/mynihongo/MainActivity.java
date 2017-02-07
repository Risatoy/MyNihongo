package com.example.risatoyoshima.mynihongo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent emailIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = (Button) findViewById(R.id.btn_mail);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });

        emailIntent = new Intent(Intent.ACTION_SEND);

        String[] TO = { "lisa0107ty@gmail.com" };

        //2. Set other properties on the emailIntent object such as TO, SUBJECT, BODY
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        // emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                "Email client launched from an Android app");
        emailIntent.putExtra(Intent.EXTRA_TEXT,
                "We used an Intent object to launch the Email client.");

    }

    private void sendEmail() {

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "There is no email client installed..", Toast.LENGTH_SHORT)
                    .show();
        }
    }



    public void onClickStart(View view){
        Intent i = new Intent(MainActivity.this, ListCardsets.class);
        startActivity(i);
    }


}

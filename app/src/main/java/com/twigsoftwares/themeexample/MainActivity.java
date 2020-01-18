package com.twigsoftwares.themeexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        if (InitApplication.getInstance().isNightModeEnabled()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        setContentView(R.layout.activity_main);
        SwitchCompat switchCompat = findViewById(R.id.switchCompat);


        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            switchCompat.setChecked(true);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    InitApplication.getInstance().setIsNightModeEnabled(true);
                    Intent intent = getIntent();
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    finish();
                    startActivity(intent);

                } else {
                    InitApplication.getInstance().setIsNightModeEnabled(false);
                    Intent intent = getIntent();
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    finish();
                    startActivity(intent);
                }


            }
        });

        Button btn = (Button) findViewById(R.id.button);
        Fooo fooo = new Fooo(MainActivity.this);
        btn.setOnClickListener(fooo);
       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"I am Clicked",Toast.LENGTH_LONG).show();
            }
        });*/
    }

}

class Fooo implements View.OnClickListener {
    Context context;
    Fooo(Context context)
    {
        this.context = context;
    }
    @Override
    public void onClick(View v) {

        Intent move = new Intent(context,SecondActivity.class);
        move.putExtra("EXTRA_INFO", "Tushar Kshirsagar");
        context.startActivity(move);


        /*Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);

        i.setData(Uri.parse("https://www.tutorialspoint.com"));
        context.startActivity(i);*/
        //Toast.makeText(context,"I am Clicked",Toast.LENGTH_LONG).show();
    }
}
package com.example.mismapas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivImage1,ivImage2,ivImage3,ivImage4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ivImage1 = findViewById(R.id.ivImagen1);
        ivImage2 = findViewById(R.id.ivImagen2);
        ivImage3 = findViewById(R.id.ivImagen3);
        ivImage4 = findViewById(R.id.ivImagen4);

        ivImage1.setOnClickListener(this);
        ivImage2.setOnClickListener(this);
        ivImage3.setOnClickListener(this);
        ivImage4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,MapsActivity.class);
        switch (view.getId())
        {
            case R.id.ivImagen1:
                intent.putExtra("lugar","catedral");
                break;
            case R.id.ivImagen2:
                intent.putExtra("lugar","fundadores");
                break;
            case R.id.ivImagen3:
                intent.putExtra("lugar","cable");
                break;
            case R.id.ivImagen4:
                intent.putExtra("lugar","torre");
                break;
        }
        startActivity(intent);

    }
}
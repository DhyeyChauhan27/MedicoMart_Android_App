package com.example.medicomart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN_TIME_OUT = 2000;

    Button button;
    FirebaseAuth auth;

    CardView MustHaves;
    CardView HealthCondition;
    CardView HealthcareDevices;
    CardView SkinCare;
    CardView HealthFoodandDrink;
    CardView AccessoriesWearables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        MustHaves = findViewById(R.id.MustHaves);
        MustHaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MustHavesActivity.class);
                startActivity(intent);
            }
        });

        HealthCondition = findViewById(R.id.HealthCondition);
        HealthCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, HealthConditionActivity.class);
                startActivity(intent);
            }
        });

        HealthcareDevices = findViewById(R.id.HealthcareDevices);
        HealthcareDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, HealthcareDevicesActivity.class);
                startActivity(intent);
            }
        });

        SkinCare = findViewById(R.id.SkinCare);
        SkinCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SkinCareActivity.class);
                startActivity(intent);
            }
        });

        HealthFoodandDrink = findViewById(R.id.HealthFoodandDrink);
        HealthFoodandDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HealthFoodandDrinkActivity.class);
                startActivity(intent);
            }
        });

        AccessoriesWearables = findViewById(R.id.AccessoriesWearables);
        AccessoriesWearables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AccessoriesWearablesActivity.class);
                startActivity(intent);
            }
        });

        button=findViewById(R.id.button);
        auth=FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
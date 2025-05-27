package com.example.medicomart;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HealthFoodandDrinkActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdepter mainAdepter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_health_foodand_drink);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize and show the ProgressDialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        // FirebaseRecyclerOptions
        FirebaseRecyclerOptions<MainModel> options = new FirebaseRecyclerOptions.Builder<MainModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("healthfoodanddrink"), MainModel.class)
                .build();

        mainAdepter = new MainAdepter(options);
        recyclerView.setAdapter(mainAdepter);

        FirebaseDatabase.getInstance().getReference().child("healthfoodanddrink")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            // Data is available
                            if (progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                        } else {
                            // No data found
                            if (progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Handle error
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    }
                });

        // Handle item clicks
        mainAdepter.setOnItemClickListener(model -> {
            Intent intent = new Intent(HealthFoodandDrinkActivity.this, DetailsViewActivity.class);
            intent.putExtra("mname", model.getMname());
            intent.putExtra("mprice", model.getMprice());
            intent.putExtra("image", model.getImage());
            intent.putExtra("mdeliver",model.getMdeliver());
            startActivity(intent);
            finish();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mainAdepter != null) {
            mainAdepter.startListening();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mainAdepter != null) {
            // Detach the adapter from RecyclerView to avoid inconsistencies
            recyclerView.setAdapter(null);
            mainAdepter.stopListening();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mainAdepter != null) {
            mainAdepter = null;
        }
    }
}
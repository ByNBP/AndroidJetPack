package com.example.androidjetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.*;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView mText = findViewById(R.id.number_content);
//        DataGeneratorViewModel myData = new DataGeneratorViewModel();
        DataGeneratorViewModel model = ViewModelProviders.of(this).get(DataGeneratorViewModel.class);

        mText.setText(model.getNumber());

        Log.d("TAG",   "Random Number Set");




        Log.i("LifeCycle", "Owner : ON_CREATE");
        getLifecycle().addObserver(new MainActivityObserver());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeCycle", "Owner : on_start");
        getLifecycle().addObserver(new MainActivityObserver());

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LifeCycle", "Owner : on-pause");
        getLifecycle().addObserver(new MainActivityObserver());

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeCycle", "Owner : ON_RESUME");
        getLifecycle().addObserver(new MainActivityObserver());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "Owner : ON_DESTROY");
        getLifecycle().addObserver(new MainActivityObserver());

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeCycle", "Owner : ON_STOP");
        getLifecycle().addObserver(new MainActivityObserver());

    }
}

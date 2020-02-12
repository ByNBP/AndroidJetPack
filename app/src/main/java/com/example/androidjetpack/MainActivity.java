package com.example.androidjetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button;
        final TextView mText = findViewById(R.id.number_content);
//      DataGeneratorViewModel myData = new DataGeneratorViewModel();// content her değiştiğinde sayıda değişir..!!


        //content yenılense bıle değer kaybolmaz aynı datayı tutar. !!
//        DataGeneratorViewModel model = ViewModelProviders.of(this).get(DataGeneratorViewModel.class);
//        mText.setText(model.getNumber());

        button = findViewById(R.id.buttonChange);
        final MutableLiveDataTest model = ViewModelProviders.of(this).get(MutableLiveDataTest.class);
        final LiveData<String> randomNumber = model.getNumber();
        randomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mText.setText(s);
                Log.d("TAG", "Data Changed in UI !");

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.createNumber();
            }
        });

        Log.d("TAG", "Random Number Set");
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

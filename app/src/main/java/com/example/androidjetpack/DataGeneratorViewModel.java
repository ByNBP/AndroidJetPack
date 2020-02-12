package com.example.androidjetpack;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class DataGeneratorViewModel extends ViewModel {

    private String myRandomNumber;

    public String getNumber() {
        Log.i("TAG", "GET NUMBER");
        if (myRandomNumber == null)
            createNumber();
        return myRandomNumber;

    }

    public void createNumber() {
        Log.i("TAG", "Create Number");
        Random random = new Random();
        myRandomNumber = "Number : " + (random.nextInt(10 - 1) + 1);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("TAG", "Cleared !! ");
    }
}

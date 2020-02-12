package com.example.androidjetpack;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MutableLiveDataTest extends ViewModel {
    private MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String> getNumber() {
        Log.i("TAG", "GET NUMBER");
        if (myRandomNumber == null) {
            myRandomNumber = new MutableLiveData<String>();
            createNumber();
        }

        return myRandomNumber;

    }

    public void createNumber() {
        Log.i("TAG", "Create Number");
        Random random = new Random();
        myRandomNumber.setValue("Number : " + (random.nextInt(10 - 1) + 1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("TAG", "Cleared !! ");
    }
}

package com.example.a02databinding;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number ;


    public MutableLiveData<Integer> getNumber() {
        if(number == null){
            number = new MutableLiveData<>();
            number.setValue(0);
        }


        return number;
    }

    public void addNumber(View v) {
        Integer value = number.getValue();
        value+=1;
        number.setValue(value);


    }
}

package com.example.a02databinding;

import android.view.View;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends ViewModel {



    private MutableLiveData<Integer> number ;
    private MutableLiveData<String> searchContent ;
//    private LiveData<Boolean> isChecked = new MutableLiveData<Boolean>(false);
    private MutableLiveData<Boolean> isChecked = new MutableLiveData<Boolean>(false);



    public MutableLiveData<Boolean> getIsChecked() {
        return isChecked;
    }


    public MutableLiveData<String> getSearchContent() {
        if(searchContent == null){
            searchContent = new MutableLiveData<>();
            searchContent.setValue("defulat content");
        }
        return searchContent;
    }

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

package com.example.a02databinding;

import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;

import java.util.Observable;

public class User  extends BaseObservable {
    String name ;
    public int age ;
    long phone;
    public final ObservableField<String> loginName = new ObservableField<>();
//    String avatar;

    public  void onClickLogin(View view){

        setAge(33) ;
        setName("wsl333");
        loginName.set("admin33333");
        Log.d("ssssssssssssssssss"," loginname ="+loginName.get()+"age= "+age);
    }







    public User(String name, int age, long phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getAge() {
        return age+"";
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    public String getPhone() {
        return phone+"";
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}

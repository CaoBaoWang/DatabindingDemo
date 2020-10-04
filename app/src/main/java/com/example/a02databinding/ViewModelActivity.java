package com.example.a02databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.a02databinding.databinding.ActivityViewModelBinding;

public class ViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        https://developer.android.com/topic/libraries/architecture/viewmodel
        setContentView(R.layout.activity_view_model);
        ActivityViewModelBinding binding = ActivityViewModelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setLifecycleOwner(this);
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        binding.setViewModel(viewModel);





    }
}
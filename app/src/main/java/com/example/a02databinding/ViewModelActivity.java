package com.example.a02databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

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


        String[] stringArray = getResources().getStringArray(R.array.planets_array);

        ArrayAdapter<CharSequence> personArrayAdapter = new ArrayAdapter<CharSequence>(this,R.layout.spinner_item,R.id.spinnerText,stringArray);
//        binding.spinner.setAdapter(personArrayAdapter);
        binding.spinnerRes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object selectedItem = parent.getSelectedItem();
                Toast.makeText(ViewModelActivity.this,stringArray[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });




    }
}
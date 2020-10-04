package com.example.a02databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.a02databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private User user;


//    https://developer.android.com/topic/libraries/data-binding/expressions

//    犹豫要不要用DataBinding？这篇文章帮你解惑
//    https://www.jianshu.com/p/ebbc224eab53


//    注意：Android Studio 3.1 及更高版本允许用 LiveData 对象替换可观察字段，从而为您的应用提供额外的好处。如需了解详情，请参阅使用 LiveData 将数据变化通知给界面(https://developer.android.com/topic/libraries/data-binding/architecture#livedata)。



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout_fragment_blank_item.activity_main); 对databinding 无用




        //第一种方式
//        setContentView(R.layout_fragment_blank_item.activity_main);
//        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout_fragment_blank_item.activity_main);


        //第二种方式 需要加上   setContentView(activityMainBinding.getRoot()); 有更好的扩展性   可以alt + 鼠标左键 点ActivityMainBinding  ->跳转对应 xml文件 代码可读性影响不大
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BlankFragment fragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,fragment,"blank").commit();


        user = new User("wsl",18,15711111111L);
        binding.setUser(user);
        user.age = 22;
        user.loginName.set("admin");

        final Intent intent = new Intent(this,ViewModelActivity.class);
        binding.viewModelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }
        });


    }
    public void login(View view){
        user.setAge(4444) ;
        user.setName("wsl4444");
        user.loginName.set("admin444444");
    }
}
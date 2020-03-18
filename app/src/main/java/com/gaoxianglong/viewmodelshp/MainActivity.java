package com.gaoxianglong.viewmodelshp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.gaoxianglong.viewmodelshp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    MyViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 将布局文件和activity绑定起来
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // 获取ViewModel实例
        mViewModel = ViewModelProviders.of(this,
                new SavedStateViewModelFactory(getApplication(),this))
                .get(MyViewModel.class);
        // 给布局文件的data绑定数据
        mBinding.setData(mViewModel);
        // 观察者
        mBinding.setLifecycleOwner(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 这个生命周期函数 用来保存数据最好
        mViewModel.save();
    }
}

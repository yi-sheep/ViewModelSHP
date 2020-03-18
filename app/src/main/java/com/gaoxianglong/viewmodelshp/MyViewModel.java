package com.gaoxianglong.viewmodelshp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

@SuppressWarnings("ConstantConditions")
public class MyViewModel extends AndroidViewModel {
    private SavedStateHandle mHandle; // 用于暂时保存数据
    private String key = getApplication().getResources().getString(R.string.data_key);
    private String shpName = getApplication().getResources().getString(R.string.shp_name);

    public MyViewModel(@NonNull Application application,SavedStateHandle handle) {
        super(application);
        mHandle = handle;
        if (!handle.contains(key)) { // 判断handle中是否有数据
            // 没有
            load(); // 读取
        }
    }

    /**
     * 获取数字
     * @return 实时数据
     */
    public LiveData<Integer> getNumber() {
        return mHandle.getLiveData(key);
    }

    /**
     * 读取出共享的数据
     */
    private void load() {
        // 创建SharedPreferences对象 在键值对中存储私有原始数据。
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        // 读取数据
        int x = shp.getInt(key, 0);
        mHandle.set(key, x); // 将数据设置到 Handle
    }

    /**
     * 保存要共享的数据
     */
    void save() {
        // 创建SharedPreferences对象
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        // 获取SharedPreferences编辑对象
        SharedPreferences.Editor editor = shp.edit();
        // 将数据写入编辑对象中
        editor.putInt(key, getNumber().getValue());
        // 启用编辑对象
        editor.apply();
    }

    /**
     * 对数据进行改变
     * @param x
     */
    public void add(int x) {
        // 对数据进行加减操作
        mHandle.set(key,getNumber().getValue() + x);
        // 在这里进行数据的共享 会在每次数据发送改变的时候
        // 这样的话要说数据频繁改变就会产生很大的内存压力
        // 所以需要把数据共享的这个操作放到activity的生命周期函数里去
//        save();
    }
}

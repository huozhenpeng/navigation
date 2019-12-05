package com.example.jetpacklifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;

public class MainActivity extends AppCompatActivity {

    String TAG="abc";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLifecycle().addObserver(new MyObserver());

        //LiveData
//        MutableLiveData<String> mutableLiveData=new MutableLiveData<>();
//        mutableLiveData.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                Log.e("abc","onChanged:"+s);
//            }
//        });
//        LiveData<String> stringLiveData= Transformations.map(mutableLiveData, new Function<String, String>() {
//            @Override
//            public String apply(String input) {
//                return input+":"+"已转换";
//            }
//        });
//        stringLiveData.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                Log.e("abc","转换后:"+s);
//            }
//        });
//        mutableLiveData.postValue("Android");

        MutableLiveData<String> mutableLiveData1  = new MutableLiveData<>();
        MutableLiveData<String> mutableLiveData2  = new MutableLiveData<>();
        final MediatorLiveData liveDataMerger = new MediatorLiveData<String>();
        liveDataMerger.addSource(mutableLiveData1, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                Log.d(TAG, "onChanged1:"+o.toString());
                liveDataMerger.setValue(o);
            }
        });

        liveDataMerger.addSource(mutableLiveData2, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                Log.d(TAG, "onChanged2:"+o.toString());
                liveDataMerger.setValue(o);
            }
        });
        liveDataMerger.observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                Log.d(TAG, "onChanged:"+o.toString());
            }
        });
        mutableLiveData1.postValue("Android进阶之光");



    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("abc","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("abc","onPause");
    }
}

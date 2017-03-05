package com.example.dominic.scrollviewandlistviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ListView listView = (ListView) findViewById(R.id.list_view);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            stringList.add("" + i);
        }

        MyAdapter adapter = new MyAdapter(getApplicationContext(), stringList);
        listView.setAdapter(adapter);
        //当用户按下的时候，我们告诉父组件，
        // 不要拦截我的事件（这个时候子组件是可以正常响应事件的），拿起之后就会告诉父组件可以阻止。
        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:    //在listView按下后不拦截
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:   //移动和取消的时候拦截
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                
                return false;
                
            }
        });
    }






}

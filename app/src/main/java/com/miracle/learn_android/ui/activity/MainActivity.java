package com.miracle.learn_android.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.miracle.learn_android.R;
import com.miracle.learn_android.util.Tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private ListView mLvTestFunction;
    private List<String> mListActivity = new ArrayList<>();
    private Map<String,String> mMapActivity = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        mMapActivity.clear();
        mMapActivity.put("TweenAnimation", "com.miracle.learn_android.ui.activity.Animation.TweenAnimation");
        mMapActivity.put("TweenAnimationLoadFile", "com.miracle.learn_android.ui.activity.Animation.TweenAnimationLoadFile");

        mMapActivity.put("TestDialog1", "com.miracle.learn_android.ui.activity.Dialog.TestDialog1");

        Iterator it = mMapActivity.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            mListActivity.add(key);
        }
    }

    private void initView() {
        final String strPkgName = Tool.getPkgName(this);
        mLvTestFunction = (ListView)findViewById(R.id.lv_test_function);
        mLvTestFunction.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mListActivity));
        mLvTestFunction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0 && position < mListActivity.size()) {
                    String strKey = mListActivity.get(position);
                    String strComponentName = mMapActivity.get(strKey);
                    if(Tool.isEmptyString(strComponentName)) {
                        throw new RuntimeException("need add "+ strKey + "corresponding activity to map !");
                    }

                    Intent intent = Tool.activityIntent(strPkgName, strComponentName);
                    startActivity(intent);
                }
            }
        });

    }



}

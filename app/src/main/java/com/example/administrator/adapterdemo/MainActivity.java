package com.example.administrator.adapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.administrator.adapterdemo.commonadcpter.ThreeItemAdapter;
import com.example.administrator.adapterdemo.commonadcpter.ThreeItemInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview_id ;
    private List<ThreeItemInfo> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview_id = (RecyclerView) findViewById(R.id.recyclerview_id);
        mList = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            ThreeItemInfo threeItemInfo = new ThreeItemInfo();
            threeItemInfo.setStatus("1");
            if (i % 2 == 0) {
                List<ThreeItemInfo> itemInfos = new ArrayList<>();
                for (int j = 0; j <= 5; j++) {
                    ThreeItemInfo threeItemInfo_2 = new ThreeItemInfo();
                    threeItemInfo_2.setStatus("2");
                    itemInfos.add(threeItemInfo_2);
                    if (j % 2 == 0) {
                        List<ThreeItemInfo> itemInfos_list = new ArrayList<>();
                        for (int z = 0; z <= 5; z++) {
                            ThreeItemInfo threeItemInfo_3 = new ThreeItemInfo();
                            threeItemInfo_3.setStatus("3");
                            itemInfos_list.add(threeItemInfo_3);
                        }
                        // 二级目录的添加
                        threeItemInfo_2.setResults(itemInfos_list);
                    }
                }
                // 二级目录的添加
                threeItemInfo.setResults(itemInfos);
            }
            // 添加一级目录
            mList.add(threeItemInfo);
        }
        ThreeItemAdapter threeItemAdapter = new ThreeItemAdapter(this, mList);

        threeItemAdapter.setOnItemThreeClickListener(new ThreeItemAdapter.OnItemThreeClickListener() {
            @Override
            public void ThreeOnclickListener(int position) {
                Toast.makeText(MainActivity.this,"我是三级条目" + position,Toast.LENGTH_SHORT);
            }
        });
        recyclerview_id.setLayoutManager(new LinearLayoutManager(this));
        recyclerview_id.setAdapter(threeItemAdapter);
    }
}

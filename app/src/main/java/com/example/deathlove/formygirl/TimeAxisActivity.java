package com.example.deathlove.formygirl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import BeanModel.WholeDayModel;
import CreateModel.ToApril30th;
import CustomAdapter.ExpandableListViewAdapter;

/**
 * Created by Death丶Love on 2016/5/12.
 */
public class TimeAxisActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private ExpandableListViewAdapter adapter;
    private List<WholeDayModel> list;
    private ImageView Axis_return;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeaxis);
        getSupportActionBar().hide();
        InitViews();
        expandableListView.setAdapter(adapter);
        expandableListView.setGroupIndicator(null);
        for (int i = 0; i < list.size(); i++) {
            expandableListView.expandGroup(i);
        }

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //Toast.makeText(getApplicationContext(), "111", Toast.LENGTH_SHORT).show();
                if (list.get(groupPosition).getList().size() == 0 && list.get(groupPosition).isGoodnight()) {
                    Bundle bundle = new Bundle();
                    bundle.putIntArray("PicArray", new int[]{list.get(groupPosition).getGoodnightPic()});
                    Intent intent = new Intent(TimeAxisActivity.this, TimeAxisPicActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putIntArray("PicArray", list.get(groupPosition).getList().get(childPosition).getPicList());
                    Intent intent = new Intent(TimeAxisActivity.this, TimeAxisPicActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    private void InitViews() {
        expandableListView = ((ExpandableListView) findViewById(R.id.Axis_ExpandableListView));
        list = new ArrayList<>();
        list.addAll(ToApril30th.toApril30th());
        adapter = new ExpandableListViewAdapter(getApplicationContext(), list);
        Axis_return = ((ImageView) findViewById(R.id.Axis_return));

        Axis_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

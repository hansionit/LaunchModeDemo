package com.hansion.launchmodetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hansion.launchmodetest.HLogUtil.i;

/**
 * Description：
 * Author: Hansion
 * Time: 2017/4/25 16:26
 */
public class BaseActivity extends AppCompatActivity {

    private String className;
    private int taskId;
    private int hashCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置Layout
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        className = getClass().getSimpleName();
        taskId = getTaskId();
        hashCode = hashCode();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(className + " " + taskId + " " + hashCode);

        HLogUtil.i(className + " ----------> oncreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        i(className + " ----------> onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        i(className + " ----------> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        i(className + " ----------> onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        i(className + " ----------> onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        i(className + " ----------> onDestroy");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        i(className + " ----------> onNewIntent");
    }

    @OnClick({R.id.mGoStandardActivity, R.id.mGoSingleTopActivity, R.id.mGoSingleTaskActivity, R.id.mGoSingleInstanceActivity})
    public void onClick(View view) {
        HLogUtil.e(className + "---------------------------------------->");
        switch (view.getId()) {
            case R.id.mGoStandardActivity:
                startActivity(new Intent(this, StandardActivity.class));
                break;
            case R.id.mGoSingleTopActivity:
                startActivity(new Intent(this, SingleTopActivity.class));
                break;
            case R.id.mGoSingleTaskActivity:
                startActivity(new Intent(this, SingleTaskActivity.class));
                break;
            case R.id.mGoSingleInstanceActivity:
                startActivity(new Intent(this, SingleInstanceActivity.class));
                break;
        }
    }
}

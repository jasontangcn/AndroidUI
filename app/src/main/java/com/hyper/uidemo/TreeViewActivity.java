package com.hyper.uidemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class TreeViewActivity extends AppCompatActivity {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tree_view_activity);

    getSupportFragmentManager()
        .beginTransaction()
        .add(R.id.fragment_container,new TreeViewFragment())
        .commit();
  }
}

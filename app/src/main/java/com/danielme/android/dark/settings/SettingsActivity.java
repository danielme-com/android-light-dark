package com.danielme.android.dark.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.danielme.android.dark.R;

public class SettingsActivity extends AppCompatActivity {

  public static void start(Context context) {
    Intent intent = new Intent(context, SettingsActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings);
    setSupportActionBar(findViewById(R.id.toolbar));
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

}

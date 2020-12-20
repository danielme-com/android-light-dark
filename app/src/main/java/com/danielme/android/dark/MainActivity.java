package com.danielme.android.dark;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.danielme.android.dark.settings.SettingsActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

  private TextInputEditText editTextEmail;
  private TextInputLayout textInputEmail;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    editTextEmail = findViewById(R.id.editTextEmail);
    textInputEmail = findViewById(R.id.text_input_layout_email);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.toolbar_menu, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    SettingsActivity.start(this);
    return true;
  }

  public void validate(View view) {
    if (TextUtils.isEmpty(editTextEmail.getText())) {
      textInputEmail.setError(getString(R.string.field_mandatory));
      textInputEmail.setErrorEnabled(true);
    } else {
      textInputEmail.setError(null);
      textInputEmail.setErrorEnabled(false);
    }

    clearFocus();
  }


  private void clearFocus() {
    View view = this.getCurrentFocus();
    if (view instanceof EditText) {
      InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context
              .INPUT_METHOD_SERVICE);
      inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
      view.clearFocus();
    }
  }

}

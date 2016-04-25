package com.example.guest.weatherforcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.locationEditText) EditText mLocation;
    @Bind(R.id.submitButton) Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSubmitButton.setOnClickListener(this);
    }

        @Override
        public void onClick(View v){
            switch (v.getId()) {
                case R.id.submitButton:
                    String location = mLocation.getText().toString();
                    Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                    intent.putExtra("location", location);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
}

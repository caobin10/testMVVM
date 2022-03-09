package com.mvvm.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.mvvm.model.mvvm.view.MVVMActivity;

/*
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMVVM;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMVVM = findViewById(R.id.btnMVVM);
        btnMVVM.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMVVM:
                Intent intentMVVM = new Intent(this, MVVMActivity.class);
                startActivity(intentMVVM);
                break;
            default:
                break;
        }
    }
}

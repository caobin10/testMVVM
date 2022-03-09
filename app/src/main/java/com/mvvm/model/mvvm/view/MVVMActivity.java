package com.mvvm.model.mvvm.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mvvm.model.R;

import com.mvvm.model.databinding.ActivityMvvmpatternBinding;
import com.mvvm.model.mvvm.viewmodel.MVVMDataViewModel;

/**
 * View层
 */
public class MVVMActivity extends AppCompatActivity {
    private MVVMDataViewModel userViewModel;
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmpatternBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmpattern);
        userViewModel = new MVVMDataViewModel();
        binding.setUserViewModel(userViewModel);
        binding.setHandlers(this);

        tvData = binding.tvData;

    }

    public void onClickShowToastName(View view) {
        Toast.makeText(this, tvData.getText().toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickLoadData(View view) {
        userViewModel.loadUserData();
    }
}

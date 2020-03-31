package edu.itc.gic.m1.s2.databinding;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import edu.itc.gic.m1.s2.databinding.databinding.ActivityMainDatabindingBinding;

import static edu.itc.gic.m1.s2.databinding.R.layout.activity_main_databinding;

public class MainDataBinding extends AppCompatActivity {

    private static final String TAG = "MainDatabindingActivity";

    ActivityMainDatabindingBinding mBinding;
    BindingViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, activity_main_databinding);

        mBinding.setLifecycleOwner(this);

        mViewModel = new ViewModelProvider(this).get(BindingViewModel.class);

        mBinding.setVariable(BR.viewModel, mViewModel);

        String myPhone = "This is my phone number: %s";
        String message = String.format(myPhone, "0987654321");
        Log.i(TAG, "onCreate: " + message);

        String msgDetail = String.format(getString(R.string.confirm_profile_detail_fmt),
                mViewModel.getUser().getName(),
                mViewModel.getUser().getEmail());
    }
}

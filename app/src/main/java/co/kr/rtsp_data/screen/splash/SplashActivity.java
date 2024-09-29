package co.kr.rtsp_data.screen.splash;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import co.kr.rtsp_data.R;
import co.kr.rtsp_data.databinding.ActivitySplashBinding;
import co.kr.rtsp_data.screen.main.MainActivity;


public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;
    private boolean permission = false;
    private static final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.e(TAG, "onCreate step");

        onCheckContactsPermission();
        if (permission) {
            onCheckContactsPermission();
            initViews();
        } else {
            initViews();
        }
    }

    private void initViews() {
        Log.e(TAG, "Splash Step Error");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(splash);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        }, 3000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        onCheckContactsPermission();
    }

    private void onCheckContactsPermission() {
        boolean permissionDenied =
                checkSelfPermission(Manifest.permission.INTERNET) == PackageManager.PERMISSION_DENIED
                        || checkSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_DENIED;

        if (permissionDenied) {
            Toast.makeText(this, getString(R.string.permissionReject), Toast.LENGTH_SHORT).show();
        } else {
            permission = true;
        }
    }
}

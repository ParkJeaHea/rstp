package co.kr.rtsp_data.screen.main;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import co.kr.rtsp_data.R;
import co.kr.rtsp_data.databinding.ActivityMainBinding;
import co.kr.rtsp_data.screen.menu.CameraFragment;
import co.kr.rtsp_data.screen.menu.ProductFragment;
import co.kr.rtsp_data.screen.menu.SettingFragment;
import co.kr.rtsp_data.screen.menu.UserFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;

    private static final String Tag = MainActivity.class.getSimpleName();

//    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();
    }

    private void initViews() {
        binding.bottomNav.setOnItemSelectedListener(this);
        showFragment(ProductFragment.newInstance(), ProductFragment.TAG);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        final String menu = item.toString();
        Log.e(Tag,"Value : " + menu);
        switch (menu) {

            case "Product":
                Log.e(Tag,"Value product : " + menu);
                showFragment(ProductFragment.newInstance(), ProductFragment.TAG);
                return true;

            case "Camera":
                Log.e(Tag,"Value camera : " + menu);
                showFragment(CameraFragment.newInstance(), CameraFragment.TAG);
                return true;

            case "Setting":
                Log.e(Tag,"Value setting : " + menu);
                showFragment(SettingFragment.newInstance(), SettingFragment.TAG);
                return true;

            case "User":
                Log.e(Tag,"Value user : " + menu);
                showFragment(UserFragment.newInstance(), UserFragment.TAG);
                return true;

            default:
                return false;
        }
    }

    private void showFragment(Fragment fragment, String tag) {
        Fragment findFragment = getSupportFragmentManager().findFragmentByTag(tag);
        for (Fragment fm : getSupportFragmentManager().getFragments()) {
            getSupportFragmentManager().beginTransaction().hide(fm).commitAllowingStateLoss();
        }
        if (findFragment != null) {
            getSupportFragmentManager().beginTransaction().show(findFragment).commitAllowingStateLoss();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, fragment, tag)
                    .commitAllowingStateLoss();
        }
    }
}

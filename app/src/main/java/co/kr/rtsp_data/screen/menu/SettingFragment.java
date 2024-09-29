package co.kr.rtsp_data.screen.menu;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import co.kr.rtsp_data.base.BaseFragment;
import co.kr.rtsp_data.databinding.FragmentProductBinding;
import co.kr.rtsp_data.databinding.FragmentSettingBinding;

public class SettingFragment extends Fragment {

    private FragmentSettingBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSettingBinding.inflate(inflater,container,false);
        initViews();
        return binding.getRoot();
    }

    public void initViews(){

    }
    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    public static final String TAG = "SettingFragment";
}

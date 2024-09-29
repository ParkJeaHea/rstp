package co.kr.rtsp_data.screen.menu;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import co.kr.rtsp_data.base.BaseFragment;
import co.kr.rtsp_data.databinding.FragmentSettingBinding;
import co.kr.rtsp_data.databinding.FragmentUserBinding;

public class UserFragment extends Fragment {

    private FragmentUserBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentUserBinding.inflate(inflater,container,false);
        initViews();
        return binding.getRoot();
    }

    public void initViews(){

    }

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    public static final String TAG = "UserFragment";
}
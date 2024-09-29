package co.kr.rtsp_data.screen.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.kr.rtsp_data.databinding.FragmentProductBinding;
import co.kr.rtsp_data.model.ProductEntity;
import co.kr.rtsp_data.screen.adapter.ProductAdapter;


public class ProductFragment extends Fragment {

    private FragmentProductBinding binding;
    private ProductAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProductBinding.inflate(inflater,container,false);
        initViews();
        return binding.getRoot();
    }

    public void initViews(){
        List<ProductEntity> productList = new ArrayList<>();// 샘플 데이터
        ProductEntity data1 = new ProductEntity();
        data1.title = "염산";
        data1.quantity = 44;
        productList.add(data1);
        ProductEntity data2 = new ProductEntity();
        data2.title = "질산";
        data2.quantity = 666;
        productList.add(data2);

        adapter = new ProductAdapter(productList);
        binding.pRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.pRecyclerView.setAdapter(adapter);
    }

    public static ProductFragment newInstance() {
        return new ProductFragment();
    }

    public static final String TAG = "ProductFragment";

    private static final int REQUEST_READ_EXTERNAL_STORAGE_PERMISSION = 1;
    private static final boolean USE_TEXTURE_VIEW = false;
    private static final boolean ENABLE_SUBTITLES = true;
}

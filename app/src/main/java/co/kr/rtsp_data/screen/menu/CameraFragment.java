package co.kr.rtsp_data.screen.menu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;
import org.videolan.libvlc.util.VLCVideoLayout;
import java.util.ArrayList;
import java.util.List;
import co.kr.rtsp_data.Data;
import co.kr.rtsp_data.databinding.FragmentCameraBinding;

public class CameraFragment extends Fragment {

    private VLCVideoLayout mVideoLayout;
    private LibVLC mLibVLC;
    private MediaPlayer mMediaPlayer;
    private List<String> arg = new ArrayList<>();
    private FragmentCameraBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCameraBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        initViews();
        playMedia();
    }

    private void initViews() {
        Context context = requireContext();
        arg.add("-vv");
        mLibVLC = new LibVLC(context, arg);
        mMediaPlayer = new MediaPlayer(mLibVLC);
        mVideoLayout = binding.videoLayout;  // Ensure binding is not null

        // Ensure mVideoLayout is initialized before attaching
        if (mVideoLayout != null) {
            mMediaPlayer.attachViews(mVideoLayout, null, ENABLE_SUBTITLES, USE_TEXTURE_VIEW);
        }
    }

    private void playMedia() {
        Uri uri = Uri.parse(Data.uri);
        final Media media = new Media(mLibVLC, uri);
        mMediaPlayer.setMedia(media);
        media.release();
        mMediaPlayer.play();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.detachViews();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
        }
        if (mLibVLC != null) {
            mLibVLC.release();
        }
    }

    public static CameraFragment newInstance() {
        return new CameraFragment();
    }

    public static final String TAG = "CameraFragment";
    private static final boolean ENABLE_SUBTITLES = true;
    private static final boolean USE_TEXTURE_VIEW = false;
}

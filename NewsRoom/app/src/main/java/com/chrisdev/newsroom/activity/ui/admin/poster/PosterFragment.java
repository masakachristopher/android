package com.chrisdev.newsroom.activity.ui.admin.poster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.chrisdev.newsroom.R;
import com.chrisdev.newsroom.activity.ui.admin.student.RegisterStudentFragment;

public class PosterFragment extends Fragment{

//    public PosterFragment(){
//
//    }

    private PosterViewModel posterViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        posterViewModel =
                ViewModelProviders.of(this).get(PosterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_post, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        posterViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}

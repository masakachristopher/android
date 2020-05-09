package com.chrisdev.newsroom.activity.ui.admin.staff;

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

public class RegisterStaffFragment extends Fragment{

    private RegisterStaffViewModel registerStaffViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registerStaffViewModel =
                ViewModelProviders.of(this).get(RegisterStaffViewModel.class);
        View root = inflater.inflate(R.layout.fragment_staff, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        registerStaffViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}

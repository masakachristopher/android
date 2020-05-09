package com.chrisdev.newsroom.activity.ui.admin.student;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.chrisdev.newsroom.R;
import com.chrisdev.newsroom.activity.ui.admin.staff.RegisterStaffFragment;
import com.chrisdev.newsroom.database.DatabaseAdapter;
import com.chrisdev.newsroom.users.*;
//import com.chrisdev.newsroom.activity.R;

public class RegisterStudentFragment extends Fragment {
    EditText editTextFirstname,editTextMiddlename,editTextLastname,editTextUsername;
    Button register;

    private RegisterStudentViewModel registerStudentViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registerStudentViewModel=
                ViewModelProviders.of(this).get(RegisterStudentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_student, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        editTextFirstname = root.findViewById(R.id.editText_firstname);
        editTextMiddlename = root.findViewById(R.id.editText_middlename);
        editTextLastname = root.findViewById(R.id.editText_lastname);
        editTextUsername = root.findViewById(R.id.editText_username);
        register = root.findViewById(R.id.buttonInserData);

        registerStudentViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
//                editTextFirstname.getText().;
//                editTextLastname.getText();
//                editTextLastname.getText();
//                editTextUsername.getText();

                register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    String first_name = editTextFirstname.getText().toString();
                    String middle_name = editTextMiddlename.getText().toString();
                    String last_name= editTextLastname.getText().toString();
                    String username = editTextUsername.getText().toString();
                    String password = editTextLastname.getText().toString();
                        if (TextUtils.isEmpty(first_name)) {
                        editTextFirstname.setError("invalid");
                        }

                        else if (TextUtils.isEmpty(middle_name)) {
                            editTextMiddlename.setError("invalid");
                        }
                        else if (TextUtils.isEmpty(last_name)) {
                            editTextLastname.setError("invalid");
                        }
                        else if (TextUtils.isEmpty(username)) {
                            editTextUsername.setError("invalid");
                        }
                        else {

                            Student student= new Student();

                            student.setStudenFirstname(first_name);
                            student.setStudentMiddlename(middle_name);
                            student.setStudentLastname(last_name);
                            student.setStudentUsername(username);
                            student.setStudentPassword(password);

                            DatabaseAdapter newsroomDB= new DatabaseAdapter(getActivity());
                            newsroomDB.addAStudent(student);
                            if(student != null) {
//                                Intent intent = new Intent();
//                                startActivity(intent);
                                Toast.makeText(getActivity(), "student added successfully", Toast.LENGTH_LONG).show();
                                getParentFragment();
                            }
                            else
                                Toast.makeText(getActivity(), "student not added ", Toast.LENGTH_LONG).show();
                        }



                    }
                });



            }
        });
        return root;
    }
}

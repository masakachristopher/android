package com.chrisdev.newsroom.activity.ui.admin.student;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegisterStudentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RegisterStudentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is register student fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
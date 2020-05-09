package com.chrisdev.newsroom.activity.ui.admin.staff;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegisterStaffViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RegisterStaffViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is register staff fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
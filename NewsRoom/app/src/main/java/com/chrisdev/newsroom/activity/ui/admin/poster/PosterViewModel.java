package com.chrisdev.newsroom.activity.ui.admin.poster;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PosterViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PosterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is register poster fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

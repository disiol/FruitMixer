package com.fruitmixer.ui.base;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseBindingFragment<P extends BasePresenter, T extends ViewDataBinding> extends Fragment implements BaseView {

    @Inject
    protected P presenter;
    protected T binding;


    @LayoutRes
    public abstract int getLayoutResId();

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    @SuppressWarnings("All")
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);
        presenter.onCreateView(this);
        return binding.getRoot();
    }

    @Override
    public void showProgress(ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress(ProgressBar progressBar) {
        progressBar.setVisibility(View.GONE);
    }

}

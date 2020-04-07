package com.fruitmixer.routers.base;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BaseRouter<A extends AppCompatActivity> {

    protected A activity;

    public BaseRouter(A activity) {
        this.activity = activity;
    }

    protected boolean isCurrentFragment(@IdRes int containerId, Class clazz) {
        Fragment fragment = activity.getSupportFragmentManager().findFragmentById(containerId);
        return clazz.isInstance(fragment);
    }

    protected void replaceFragment(@IdRes int containerId, Fragment fragment) {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commitAllowingStateLoss();
    }
}

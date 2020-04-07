package com.fruitmixer.ui.fragments.start.view;


import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.fruitmixer.R;
import com.fruitmixer.databinding.StartBinding;
import com.fruitmixer.manedger.PreferencesManager;
import com.fruitmixer.routers.main.MainActivityRouter;
import com.fruitmixer.ui.base.BaseBindingFragment;
import com.fruitmixer.ui.fragments.start.presenter.StartPresenter;

import javax.inject.Inject;

public class StartFragment extends BaseBindingFragment<StartPresenter, StartBinding> implements StartView {

    public static final String SHOW_WEB_FRAGMENT = "showWebFragment";
    public static final String SHOW_GAME = "showGame";
    final String PREFS_NAME = "MyPrefsFile";
    final String PREFS = "forRanWeb";
    final String PREFS2 = "forRanGAme";
    private SharedPreferences forRanWeb;
    private SharedPreferences forRanGame;
    private boolean settingsBoolean;

    @Inject
    PreferencesManager preferencesManager;

    @Override
    public int getLayoutResId() {
        return R.layout.start;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] strings = {getActivity().getString(R.string.eeg), getActivity().getString(R.string.rerehrh), getActivity().getString(R.string.etht5y)};
        String[] strings1 = {null};
        String[] strings2 = {getActivity().getString(R.string.ksksksf), getActivity().getString(R.string.aaaacsc), getActivity().getString(R.string.adwff), getActivity().getString(R.string.ccsascasv)};
        String[] strings3 = {getActivity().getString(R.string.scsacac)};
        String[] strings4 = {getActivity().getString(R.string.vsavasw)};
        String[] strings5 = {getActivity().getString(R.string.sCCCC)};
        String[] strings6 = {getActivity().getString(R.string.VDVSDBSDB), getActivity().getString(R.string.cccccc), getActivity().getString(R.string.sssscv), getActivity().getString(R.string.jjhu), getActivity().getString(R.string.hgtrrds), getActivity().getString(R.string.kjjhbh)};
        String[] strings7 = {getActivity().getString(R.string.sssvsvsv), getActivity().getString(R.string.sssvsvsssdwdwdf), getActivity().getString(R.string.ssscsac)};
        String[] strings8 = {getActivity().getString(R.string.ssfgrbdbbsaf), getActivity().getString(R.string.sssssSDVVXVd), getActivity().getString(R.string.sssssfbdb), getActivity().getString(R.string.sssssswv), getActivity().getString(R.string.sssvdav), getActivity().getString(R.string.sssssssvsvavasv),
                getActivity().getString(R.string.ssssssssssvvs),
                getActivity().getString(R.string.sssvsacv),
                getActivity().getString(R.string.ssssvsvvsavsav)};


        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
        forRanWeb = getActivity().getSharedPreferences(PREFS, 0);
        forRanGame = getActivity().getSharedPreferences(PREFS2, 0);

        settingsBoolean = preferencesManager.getMyFirstTime();
        if (settingsBoolean) {

            //the app is being launched for first time, do something
            Log.d("Comments", "First time");
            presenter.eadParamsForCheck(strings, strings1, strings2, strings3, strings4, strings5, strings6, strings7, strings8);
            // first time task
            showProgress(binding.progressBar);
            presenter.check(getActivity());
            showProgress(binding.progressBar);

            // record the fact that the app has been started at least once
            forRanWeb.edit().putBoolean(SHOW_WEB_FRAGMENT, false).apply();
            forRanGame.edit().putBoolean(SHOW_GAME, false).apply();


           preferencesManager.setMyFirstTime(false);
                Log.d("Comments", "First time");



        } else {
            if (forRanWeb.getBoolean(SHOW_WEB_FRAGMENT, true)) {
                presenter.showWeb();
            } else if (forRanGame.getBoolean(SHOW_GAME, true)) {
                presenter.showGame();

            }

        }


    }


    @SuppressLint("CommitPrefEdits")
    @Override
    public void showWeb(MainActivityRouter mainActivityRouter) {
        forRanWeb.edit().putBoolean(SHOW_WEB_FRAGMENT, true).apply();
        mainActivityRouter.showWebFragment();

    }

    private void restartApp() {
        Intent mStartActivity = new Intent(getContext(), getActivity().getClass());
        int mPendingIntentId = 123456;
        PendingIntent mPendingIntent = PendingIntent.getActivity(getContext(), mPendingIntentId, mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager mgr = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
        getActivity().finish();
    }

    @Override
    public void showGame(MainActivityRouter mainActivityRouter) {
        forRanGame.edit().putBoolean(SHOW_GAME, true).apply();
        showGameFragment();

    }

    private void showGameFragment() {
//     TODO   Intent intent = new Intent(getActivity(), AndroidLauncher.class);
//        getActivity().startActivity(intent);
//        getActivity().finish();

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showError(Throwable throwable, MainActivityRouter mainActivityRouter) {
        forRanGame.edit().putBoolean(SHOW_GAME, true).apply();

       showGameFragment();
    }
}
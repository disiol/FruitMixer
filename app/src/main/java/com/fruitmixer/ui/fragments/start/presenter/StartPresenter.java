package com.fruitmixer.ui.fragments.start.presenter;


import android.text.TextUtils;

import androidx.databinding.library.baseAdapters.BuildConfig;
import androidx.fragment.app.FragmentActivity;

import com.fruitmixer.R;
import com.fruitmixer.interactor.DataStore;
import com.fruitmixer.routers.main.MainActivityRouter;
import com.fruitmixer.ui.base.BasePresenter;
import com.fruitmixer.ui.fragments.start.view.StartView;
import com.fruitmixer.util.Keys;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public class StartPresenter extends BasePresenter<StartView> {

    private MainActivityRouter mainActivityRouter;
    private DataStore dataStore;
    private EnumMap<Keys, String[]> enumMap;

    @Inject
    StartPresenter(MainActivityRouter mainActivityRouter, DataStore dataStore) {
        this.mainActivityRouter = mainActivityRouter;
        this.dataStore = dataStore;
    }

    public void check(FragmentActivity activity) {

        dataStore.sendRequest().subscribe(sendRequest -> {
            if(!check(sendRequest,activity)){
                showWeb();
            }else{
                showGame();

            }

        }, throwable -> getView().showError(throwable, mainActivityRouter));
    }

    public void showGame() {
        getView().showGame(mainActivityRouter);
    }

    public void showWeb() {
        getView().showWeb(mainActivityRouter);
    }

    private boolean check(Response<ResponseBody> sendRequest1, FragmentActivity activity) {



        EnumMap<Keys, String> checkedParams = new EnumMap<>(Keys.class);
        List<Keys> checkedKeys = new ArrayList<>();

        getParamsForCheck(sendRequest1, checkedParams, checkedKeys,activity);
        return checkMatch(checkedParams, checkedKeys);
    }

    private void getParamsForCheck(@NotNull Response<ResponseBody> sendRequest1, EnumMap<Keys, String> checkedParams, List<Keys> checkedKeys, FragmentActivity activity) {
        String msg = sendRequest1.raw().toString();

        String[] q = msg.split(activity.getString(R.string.ktuktkllly));
        String str = TextUtils.join(",", q);
        String[] list = str.split("&");

        if (BuildConfig.DEBUG) {
        }

        int size = list.length;

        for (int i = 0; i < size; i++) {
            boolean endsWith = list[i].endsWith("=");

            if (!endsWith) {
                checkedParams.put(Keys.values()[i], list[i]);
                checkedKeys.add(Keys.values()[i]);
            }
        }


    }

    private boolean checkMatch(EnumMap<Keys, String> checkedParams, List<Keys> checkedKeys) {
        for (Keys key : checkedKeys) {
            for (String keyWord : enumMap.get(key)) {

                if (BuildConfig.DEBUG) {
                }

                if (containsIgnoreCase(checkedParams.get(key), keyWord)) {

                    if (BuildConfig.DEBUG) {
                    }
                    return true;
                }
            }


        }
        return false;
    }

    public void eadParamsForCheck(String[] yyyyy, String[] jhtjtj, String[] rrdhrdhr, String[] regrg, String[] hdhtht, String[] hhrh, String[] hdfhdfhdfh, String[] hdhdhh, String[] hdhdh) {
        enumMap = new EnumMap<>(Keys.class);
        enumMap.put(Keys.PUT, yyyyy);
        enumMap.put(Keys.STRINGS, jhtjtj);
        enumMap.put(Keys.KEYS, rrdhrdhr);
        enumMap.put(Keys.PUT1, regrg);
        enumMap.put(Keys.KEYS1, hdhtht);
        enumMap.put(Keys.PUT2, hhrh);
        enumMap.put(Keys.PUT3, hdfhdfhdfh);
        enumMap.put(Keys.PUT4, hdhdhh);
        enumMap.put(Keys.STRINGS1, hdhdh);


    }

   


}

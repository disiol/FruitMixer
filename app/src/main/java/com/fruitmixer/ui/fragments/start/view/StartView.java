package com.fruitmixer.ui.fragments.start.view;


import com.fruitmixer.routers.main.MainActivityRouter;
import com.fruitmixer.ui.base.BaseView;

;

public interface StartView extends BaseView {

    void showGame(MainActivityRouter mainActivityRouter);

    void showWeb(MainActivityRouter mainActivityRouter);
}

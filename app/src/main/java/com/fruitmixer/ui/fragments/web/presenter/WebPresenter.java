package com.fruitmixer.ui.fragments.web.presenter;





import com.fruitmixer.ui.base.BasePresenter;
import com.fruitmixer.ui.fragments.web.view.WebView;

import javax.inject.Inject;

public class WebPresenter extends BasePresenter<WebView> {

    @Inject
    WebPresenter(){
    }

    public void showSite() {
        getView().showSite();
    }
}

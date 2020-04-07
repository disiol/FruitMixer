package com.fruitmixer.di.modules;

import com.fruitmixer.di.scopes.ActivityScope;
import com.fruitmixer.di.scopes.FragmentScope;
import com.fruitmixer.routers.main.MainActivityRouter;
import com.fruitmixer.routers.main.MainActivityRouterImpl;
import com.fruitmixer.ui.fragments.start.view.StartFragment;
import com.fruitmixer.ui.fragments.web.view.WebFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {
    @ActivityScope
    @Binds
    MainActivityRouter mainActivityRouter(MainActivityRouterImpl mainRouter);

    @FragmentScope
    @ContributesAndroidInjector
    WebFragment webFragment();

    @FragmentScope
    @ContributesAndroidInjector
    StartFragment logoFragment();


}

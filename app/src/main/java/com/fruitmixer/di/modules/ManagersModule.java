package com.fruitmixer.di.modules;

import android.content.Context;

import com.fruitmixer.manedger.PreferencesManager;
import com.fruitmixer.manedger.PreferencesManagerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagersModule {

    @Provides
    @Singleton
    PreferencesManager providePreferencesManager(Context context){
        return new PreferencesManagerImpl(context);
    }


}

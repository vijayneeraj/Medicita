package com.medicitadocter.base;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by linux on 26/6/17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);

        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this));

        initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(getApplicationContext()));

        Stetho.Initializer initializer = initializerBuilder.build();

        Stetho.initialize(initializer);

    }
}

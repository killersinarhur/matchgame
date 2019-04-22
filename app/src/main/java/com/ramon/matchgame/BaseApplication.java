package com.ramon.matchgame;

import android.app.Application;

import com.ramon.matchgame.di.DaggerMatchComponent;
import com.ramon.matchgame.di.MatchComponent;
import com.ramon.matchgame.di.MatchModule;

public class BaseApplication extends Application {

    private static MatchComponent daggerComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        buildDaggerComponent();
    }

    public void buildDaggerComponent() {
        daggerComponent= DaggerMatchComponent.builder()
                .matchModule(new MatchModule(this))
                .build();
    }
    public static MatchComponent getDaggerComponent() {
        return daggerComponent;
    }
}

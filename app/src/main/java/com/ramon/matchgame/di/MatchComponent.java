package com.ramon.matchgame.di;



import com.ramon.matchgame.actualgame.MatchingPresenter;
import com.ramon.matchgame.startgame.StartGamePresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MatchModule.class})
public interface MatchComponent {

    void inject(StartGamePresenter startGameActivity);

    void inject(MatchingPresenter matchingPresenter);
}

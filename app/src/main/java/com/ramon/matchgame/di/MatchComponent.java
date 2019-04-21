package com.ramon.matchgame.di;



import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MatchModule.class})
public interface MatchComponent {

}

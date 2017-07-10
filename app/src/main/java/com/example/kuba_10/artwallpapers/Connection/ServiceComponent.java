package com.example.kuba_10.artwallpapers.Connection;

/**
 * Created by Kuba-10 on 10.07.2017.
 */


import com.example.kuba_10.artwallpapers.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ServiceModule.class})
public interface ServiceComponent {
    void inject(MainActivity activity);


}
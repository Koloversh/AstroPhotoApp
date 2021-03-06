package com.example.astrophoto;

import android.app.Application;

import com.example.astrophoto.api.NasaService;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class App extends Application {

    private NasaService nasaService;
    //private RoscosmosService roscosmosService;

    @Override
    public void onCreate() {
        super.onCreate();

        nasaService = new NasaService();

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new LruMemoryCache(20 * 1024 * 1024))
                .memoryCacheSize(20 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
    }

    public NasaService getNasaService() {
        return nasaService;
    }

}
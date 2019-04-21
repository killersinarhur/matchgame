package com.ramon.matchgame.di;

import android.app.Application;

import com.google.gson.Gson;
import com.ramon.matchgame.webservice.configuration.InterceptorConfig;
import com.ramon.matchgame.webservice.configuration.OkHttpManagerConfig;
import com.ramon.matchgame.webservice.configuration.UnsafeHostnameVerifierConfig;
import com.ramon.matchgame.webservice.configuration.UnsafeTrustManagerConfig;
import com.ramon.matchgame.webservice.flicker.FlickerApi;
import com.ramon.matchgame.webservice.flicker.FlickerClient;
import com.ramon.matchgame.webservice.flicker.FlickerEndpoint;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.CertificatePinner;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MatchModule {

    private final Application app;

    public MatchModule(Application app) {
        this.app = app;
    }

    @Provides
    public Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    public FlickerClient provideFlickerClient(Application app, FlickerApi client) {
        return new FlickerClient(app, client);
    }

    @Provides
    @Singleton
    public FlickerApi provideFlickerApi(OkHttpManagerConfig okHttpManager, GsonConverterFactory factory, FlickerEndpoint endpoint) {
        return new Retrofit.Builder()
                .client(okHttpManager.getOkHttpClient())
                .addConverterFactory(factory)
                .baseUrl(endpoint.getEndpoint())
                .build()
                .create(FlickerApi.class);
    }

    @Provides
    @Singleton
    public FlickerEndpoint providesFlickerEndpoint() {
        return new FlickerEndpoint();
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideConverterFactory() {
        return GsonConverterFactory.create();
    }


    @Provides
    @Singleton
    public OkHttpManagerConfig provideSolidOkHttpManager(UnsafeTrustManagerConfig unsafeTrustManager, CertificatePinner certificatePinner,
                                                         InterceptorConfig interceptor, UnsafeHostnameVerifierConfig unsafeHostnameVerifier) {
        return new OkHttpManagerConfig(unsafeTrustManager, certificatePinner, interceptor, unsafeHostnameVerifier);
    }

    @Provides
    @Singleton
    public CertificatePinner providesCertificatePinner() {
        return new CertificatePinner.Builder()

                .build();
    }

    @Provides
    @Singleton
    public UnsafeTrustManagerConfig provideUnsafeCertificateValidator() {
        return new UnsafeTrustManagerConfig();
    }


    @Provides
    @Singleton
    public Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    public UnsafeHostnameVerifierConfig providesUnsafeHostnameVerifier() {
        return new UnsafeHostnameVerifierConfig();
    }

    @Provides
    @Singleton
    public InterceptorConfig provideInterceptor() {
        return new InterceptorConfig();
    }



}

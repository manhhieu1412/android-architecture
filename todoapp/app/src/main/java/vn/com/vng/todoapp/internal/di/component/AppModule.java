package vn.com.vng.todoapp.internal.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import vn.com.vng.todoapp.AndroidApplication;
import dagger.android.AndroidInjectionModule;

/**
 * Provides application-wide dependencies.
 */
@Module(includes = AndroidInjectionModule.class)
abstract class AppModule {

    @Binds
    @Singleton
    /*
     * Singleton annotation isn't necessary since Application instance is unique but is here for
     * convention. In general, providing Activity, Fragment, BroadcastReceiver, etc does not require
     * them to be scoped since they are the components being injected and their instance is unique.
     *
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */
    abstract Application application(AndroidApplication app);

    /**
     * Provides the injector for the {@link MainActivity}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
   /* @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivityInjector();

    *//**
     * Provides the injector for the {@link Example1Activity}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     *//*
    @PerActivity
    @ContributesAndroidInjector(modules = Example1ActivityModule.class)
    abstract Example1Activity example1ActivityInjector();

    *//**
     * Provides the injector for the {@link Example2Activity}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     *//*
    @PerActivity
    @ContributesAndroidInjector(modules = Example2ActivityModule.class)
    abstract Example2Activity example2ActivityInjector();

    *//**
     * Provides the injector for the {@link Example3Activity}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     *//*
    @PerActivity
    @ContributesAndroidInjector(modules = Example3ActivityModule.class)
    abstract Example3Activity example3ActivityInjector();*/
}
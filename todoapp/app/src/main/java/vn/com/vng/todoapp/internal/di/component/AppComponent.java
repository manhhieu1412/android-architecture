package vn.com.vng.todoapp.internal.di.component;

import javax.inject.Singleton;

import dagger.Component;
import vn.com.vng.todoapp.AndroidApplication;
import dagger.android.AndroidInjector;

/**
 * Injects application dependencies.
 */
@Singleton
@Component(modules = AppModule.class)
interface AppComponent extends AndroidInjector<AndroidApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<AndroidApplication> {
    }
}
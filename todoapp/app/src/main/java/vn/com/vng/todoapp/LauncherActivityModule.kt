package vn.com.vng.todoapp

import android.app.Activity
import android.content.Context
import dagger.Binds
import dagger.Module
import vn.com.vng.todoapp.internal.di.scope.PerActivity

/**
 * Created by hieuvm on 9/22/17.
 * *
 */

@Module
abstract class LauncherActivityModule {

    /*
     * PerActivity annotation isn't necessary since Activity instance is unique but is here for
     * convention. In general, providing Application, Activity, Fragment, BroadcastReceiver,
     * etc does not require scoped annotations since they are the components being injected and
     * their instance is unique.
     *
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */
    
    @Binds
    @PerActivity
    internal abstract fun activityContext(activity: Activity): Context

    @Binds
    @PerActivity
    internal abstract fun activity(launcherActivity: LauncherActivity): Activity

}

package vn.com.vng.todoapp.provider

import io.reactivex.Scheduler

/**
 * Created by hieuvm on 9/17/17.
 * *
 */
interface SchedulerProvider {
    fun ui(): Scheduler

    fun io(): Scheduler

    fun computation(): Scheduler
}
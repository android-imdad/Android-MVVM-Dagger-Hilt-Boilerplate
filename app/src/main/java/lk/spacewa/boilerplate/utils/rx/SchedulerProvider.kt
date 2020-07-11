package lk.spacewa.boilerplate.utils.rx

import io.reactivex.rxjava3.core.Scheduler

/**
 * Created by Imdad on 05/11/20.
 */
interface SchedulerProvider {
    fun computation(): Scheduler
    fun io(): Scheduler
    fun ui(): Scheduler?
}
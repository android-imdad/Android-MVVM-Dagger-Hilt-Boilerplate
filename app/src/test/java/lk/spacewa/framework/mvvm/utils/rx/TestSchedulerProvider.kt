package lk.spacewa.framework.mvvm.utils.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler
import lk.spacewa.boilerplate.utils.rx.SchedulerProvider

/**
 * Created by Imdad on 05/11/20.
 */
class TestSchedulerProvider(private val mTestScheduler: TestScheduler) : SchedulerProvider {
    override fun computation(): Scheduler {
        return mTestScheduler
    }

    override fun io(): Scheduler {
        return mTestScheduler
    }

    override fun ui(): Scheduler? {
        return mTestScheduler
    }

}
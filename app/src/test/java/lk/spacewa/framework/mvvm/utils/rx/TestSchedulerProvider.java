

package lk.spacewa.framework.mvvm.utils.rx;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;
import lk.spacewa.boilerplate.utils.rx.SchedulerProvider;

/**
 * Created by Imdad on 05/11/20.
 */

public class TestSchedulerProvider implements SchedulerProvider {

    private final TestScheduler mTestScheduler;

    public TestSchedulerProvider(TestScheduler testScheduler) {
        this.mTestScheduler = testScheduler;
    }

    @Override
    public Scheduler computation() {
        return mTestScheduler;
    }

    @Override
    public Scheduler io() {
        return mTestScheduler;
    }

    @Override
    public Scheduler ui() {
        return mTestScheduler;
    }
}

package com.alipay.mobile.nebulacore.dev.sampler;

import com.alibaba.a.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractSampler {
    private static final int DEFAULT_SAMPLE_INTERVAL = 300;
    protected final List<SampleCallback> callbacks = new ArrayList();
    /* access modifiers changed from: private */
    public Runnable mRunnable = new Runnable() {
        public void run() {
            e doSample = AbstractSampler.this.doSample();
            for (SampleCallback onSample : AbstractSampler.this.callbacks) {
                if (!onSample.onSample(doSample)) {
                    AbstractSampler.this.mShouldSample.set(false);
                }
            }
            if (AbstractSampler.this.mShouldSample.get()) {
                HandlerThreadFactory.getTimerThreadHandler().postDelayed(AbstractSampler.this.mRunnable, AbstractSampler.this.mSampleInterval);
            }
        }
    };
    protected long mSampleInterval;
    protected AtomicBoolean mShouldSample = new AtomicBoolean(false);

    public interface SampleCallback {
        boolean onSample(e eVar);
    }

    /* access modifiers changed from: package-private */
    public abstract e doSample();

    public AbstractSampler(long j) {
        this.mSampleInterval = 0 == j ? 300 : j;
    }

    public void start() {
        if (!this.mShouldSample.get()) {
            this.mShouldSample.set(true);
            HandlerThreadFactory.getTimerThreadHandler().removeCallbacks(this.mRunnable);
            HandlerThreadFactory.getTimerThreadHandler().postDelayed(this.mRunnable, (long) ReportConfig.getInstance().getSampleDelay());
        }
    }

    public void stop() {
        if (this.mShouldSample.get()) {
            this.mShouldSample.set(false);
            HandlerThreadFactory.getTimerThreadHandler().removeCallbacks(this.mRunnable);
        }
    }

    public void registerCallback(SampleCallback sampleCallback) {
        synchronized (this.callbacks) {
            this.callbacks.add(sampleCallback);
        }
    }

    public void unRegisterCallback(SampleCallback sampleCallback) {
        synchronized (this.callbacks) {
            this.callbacks.remove(sampleCallback);
        }
    }
}

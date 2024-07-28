package com.paytmmall.clpartifact.utils;

import android.app.Activity;
import com.paytmmall.clpartifact.listeners.ITimerListener;
import java.lang.ref.WeakReference;
import java.util.TimerTask;
import kotlin.g.b.k;

public final class SFTimerTask extends TimerTask {
    private final WeakReference<ITimerListener> timerListener;

    public SFTimerTask(ITimerListener iTimerListener) {
        k.c(iTimerListener, "listener");
        this.timerListener = new WeakReference<>(iTimerListener);
    }

    public final WeakReference<ITimerListener> getTimerListener() {
        return this.timerListener;
    }

    public final void run() {
        ITimerListener iTimerListener = (ITimerListener) this.timerListener.get();
        Activity view = iTimerListener != null ? iTimerListener.getView() : null;
        if (!(view != null ? view.isFinishing() : true)) {
            ITimerListener iTimerListener2 = (ITimerListener) this.timerListener.get();
            if (iTimerListener2 != null) {
                iTimerListener2.onTick();
                return;
            }
            return;
        }
        this.timerListener.clear();
    }
}

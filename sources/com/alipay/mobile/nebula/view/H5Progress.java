package com.alipay.mobile.nebula.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.alipay.mobile.nebula.util.H5Log;

public class H5Progress extends ProgressBar {
    public static final int DEFAULT_DURATION = 400;
    public static final int MIN_DURATION = 300;
    public static final String TAG = "H5Progress";
    /* access modifiers changed from: private */
    public long curDuration;
    /* access modifiers changed from: private */
    public boolean isRunnableWorking = false;
    /* access modifiers changed from: private */
    public int lastProgress;
    /* access modifiers changed from: private */
    public int lastTarget;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    private UpdateRunnable mUpdateRunnable = new UpdateRunnable();
    private long minDuration;
    /* access modifiers changed from: private */
    public int nextVisibility;
    /* access modifiers changed from: private */
    public ProgressNotifier notifier;
    private long originTime;
    /* access modifiers changed from: private */
    public long startTime;
    /* access modifiers changed from: private */
    public int targetProgress;

    public interface ProgressNotifier {
        void onProgressBegin();

        void onProgressEnd();
    }

    public H5Progress(Context context) {
        super(context);
        init();
    }

    public H5Progress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public H5Progress(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }

    public void setNotifier(ProgressNotifier progressNotifier) {
        this.notifier = progressNotifier;
    }

    private void init() {
        this.minDuration = 400;
        setMax(100);
        this.nextVisibility = -1;
        reset();
    }

    /* access modifiers changed from: private */
    public void reset() {
        this.originTime = 0;
        this.targetProgress = 0;
        this.lastTarget = 0;
        this.lastProgress = 0;
    }

    public void setMinDuration(long j) {
        this.minDuration = j;
    }

    public void updateProgress(int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.originTime == 0) {
            this.originTime = currentTimeMillis;
        }
        int max = getMax();
        int i3 = (int) ((((double) i2) * 0.25d) + (((double) max) * 0.75d));
        int i4 = this.lastProgress;
        if (i3 >= i4 && i3 <= max) {
            this.lastTarget = i4;
            this.startTime = currentTimeMillis;
            this.targetProgress = i3;
            linearProgress();
        }
    }

    private void linearProgress() {
        if (isIndeterminate()) {
            H5Log.d(TAG, "isIndeterminate");
            return;
        }
        this.curDuration = this.minDuration;
        if (this.targetProgress == getMax() && this.lastTarget > getMax() / 2) {
            this.curDuration = 300;
        }
        int i2 = this.targetProgress - this.lastTarget;
        if (i2 > 0) {
            long j = this.curDuration;
            if (j > 0) {
                int i3 = (int) (j / ((long) i2));
                this.mHandler.removeCallbacks(this.mUpdateRunnable);
                this.mUpdateRunnable.setPeriodValue(i3);
                this.mUpdateRunnable.setdeltaProgressValue(i2);
                this.mHandler.postDelayed(this.mUpdateRunnable, (long) i3);
            }
        }
    }

    public void setVisibility(int i2) {
        H5Log.d(TAG, "setVisibility:".concat(String.valueOf(i2)));
        if (!this.isRunnableWorking || i2 == 0) {
            super.setVisibility(i2);
        } else {
            this.nextVisibility = i2;
        }
    }

    public void hideProgress() {
        H5Log.d(TAG, "hideProgress");
        super.setVisibility(8);
    }

    class UpdateRunnable implements Runnable {
        private int deltaProgress;
        private int period;

        UpdateRunnable() {
        }

        public void setPeriodValue(int i2) {
            this.period = i2;
        }

        public void setdeltaProgressValue(int i2) {
            this.deltaProgress = i2;
        }

        public void run() {
            boolean unused = H5Progress.this.isRunnableWorking = true;
            int max = H5Progress.this.getMax();
            if (max == 0) {
                H5Progress.this.mHandler.removeCallbacks(this);
                boolean unused2 = H5Progress.this.isRunnableWorking = false;
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - H5Progress.this.startTime;
            if ((H5Progress.this.curDuration * ((long) this.deltaProgress)) / ((long) max) == 0) {
                H5Progress.this.mHandler.removeCallbacks(this);
                boolean unused3 = H5Progress.this.isRunnableWorking = false;
                return;
            }
            int access$400 = H5Progress.this.lastTarget + ((int) ((currentTimeMillis * ((long) this.deltaProgress)) / H5Progress.this.curDuration));
            if (access$400 > H5Progress.this.targetProgress) {
                if (access$400 > H5Progress.this.getMax() && H5Progress.this.notifier != null) {
                    H5Progress.this.notifier.onProgressEnd();
                }
                if (H5Progress.this.nextVisibility != -1) {
                    H5Progress h5Progress = H5Progress.this;
                    H5Progress.super.setVisibility(h5Progress.nextVisibility);
                    int unused4 = H5Progress.this.nextVisibility = -1;
                }
            } else {
                if (H5Progress.this.lastProgress == 0 && H5Progress.this.notifier != null) {
                    H5Progress.this.notifier.onProgressBegin();
                }
                H5Progress.this.setProgress(access$400);
                int unused5 = H5Progress.this.lastProgress = access$400;
            }
            if (access$400 > H5Progress.this.targetProgress) {
                if (access$400 > H5Progress.this.getMax()) {
                    H5Progress.this.reset();
                }
                H5Progress.this.mHandler.removeCallbacks(this);
                boolean unused6 = H5Progress.this.isRunnableWorking = false;
                return;
            }
            H5Progress.this.mHandler.postDelayed(this, (long) this.period);
        }
    }
}

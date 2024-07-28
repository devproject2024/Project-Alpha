package com.paytmmall.clpartifact.common;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.paytmmall.clpartifact.utils.LogUtils;
import java.util.concurrent.TimeUnit;

public class FlashSaleView extends AppCompatTextView {
    /* access modifiers changed from: private */
    public static final String TAG = FlashSaleView.class.getSimpleName();
    /* access modifiers changed from: private */
    public OnTimerStateChangedListener mListener;
    private CountDownTimer mTimer;
    /* access modifiers changed from: private */
    public long remainingMillisec;

    public interface OnTimerStateChangedListener {
        void onEnded();

        void onUpdateRequired();
    }

    public FlashSaleView(Context context) {
        super(context);
    }

    public FlashSaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlashSaleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setTimerStateChangedListener(OnTimerStateChangedListener onTimerStateChangedListener) {
        this.mListener = onTimerStateChangedListener;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtils.d(TAG, "onDetachedFromWindow: ");
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtils.d(TAG, "onAttachedToWindow: ");
        OnTimerStateChangedListener onTimerStateChangedListener = this.mListener;
        if (onTimerStateChangedListener != null) {
            onTimerStateChangedListener.onUpdateRequired();
        }
    }

    public void setRemainingTime(long j) {
        if (j <= 0) {
            setText("");
            return;
        }
        this.remainingMillisec = j;
        refreshText();
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mTimer = new ViewTimer(j);
        this.mTimer.start();
    }

    public void setStaticText(String str) {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        setText(str);
    }

    /* access modifiers changed from: private */
    public void refreshText() {
        setText(String.format("%02d : %02d : %02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toHours(this.remainingMillisec)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(this.remainingMillisec) % 60), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.remainingMillisec) % 60)}));
    }

    class ViewTimer extends CountDownTimer {
        ViewTimer(long j) {
            super(j, 1000);
        }

        public ViewTimer(long j, long j2) {
            super(j, j2);
        }

        public void onTick(long j) {
            long unused = FlashSaleView.this.remainingMillisec = j;
            LogUtils.d(FlashSaleView.TAG, "onTick: ".concat(String.valueOf(j)));
            FlashSaleView.this.refreshText();
        }

        public void onFinish() {
            LogUtils.d(FlashSaleView.TAG, "onFinish: ");
            FlashSaleView.this.setText("00:00:00");
            if (FlashSaleView.this.mListener != null) {
                FlashSaleView.this.mListener.onEnded();
            }
        }
    }
}

package com.paytm.android.chat.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;
import com.paytm.utility.q;

public class SoundPoolPlayer extends SoundPool {
    private static SoundPoolPlayer player;
    Context context;
    long duration;
    long endTime;
    Handler handler;
    boolean isPlaying = false;
    MediaPlayer.OnCompletionListener listener;
    boolean loaded = false;
    int resId;
    Runnable runnable = new Runnable() {
        public final void run() {
            if (SoundPoolPlayer.this.isPlaying) {
                SoundPoolPlayer.this.isPlaying = false;
                q.d("ending..");
                if (SoundPoolPlayer.this.listener != null) {
                    SoundPoolPlayer.this.listener.onCompletion((MediaPlayer) null);
                }
            }
        }
    };
    int soundId;
    long startTime;
    int streamId;
    long timeSinceStart = 0;

    public void pause() {
        if (this.streamId > 0) {
            this.endTime = System.currentTimeMillis();
            this.timeSinceStart += this.endTime - this.startTime;
            super.pause(this.streamId);
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.removeCallbacks(this.runnable);
            }
            this.isPlaying = false;
        }
    }

    public void stop() {
        int i2 = this.streamId;
        if (i2 > 0) {
            this.timeSinceStart = 0;
            super.stop(i2);
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.removeCallbacks(this.runnable);
            }
            this.isPlaying = false;
        }
    }

    public void play() {
        if (!this.loaded) {
            loadAndPlay();
        } else {
            playIt();
        }
    }

    public static SoundPoolPlayer create(Context context2, int i2) {
        SoundPoolPlayer soundPoolPlayer = new SoundPoolPlayer(1, 3, 0);
        player = soundPoolPlayer;
        soundPoolPlayer.context = context2;
        SoundPoolPlayer soundPoolPlayer2 = player;
        soundPoolPlayer2.resId = i2;
        return soundPoolPlayer2;
    }

    public void destory() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacks(this.runnable);
        }
        this.context = null;
        player = null;
    }

    public SoundPoolPlayer(int i2, int i3, int i4) {
        super(1, i3, i4);
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.listener = onCompletionListener;
    }

    private void loadAndPlay() {
        this.duration = getSoundDuration(this.resId);
        try {
            this.soundId = super.load(this.context, this.resId, 1);
            setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                public final void onLoadComplete(SoundPool soundPool, int i2, int i3) {
                    SoundPoolPlayer soundPoolPlayer = SoundPoolPlayer.this;
                    soundPoolPlayer.loaded = true;
                    soundPoolPlayer.playIt();
                }
            });
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void playIt() {
        if (this.loaded && !this.isPlaying) {
            q.d("start playing..");
            long j = 0;
            if (this.timeSinceStart == 0) {
                this.streamId = super.play(this.soundId, 1.0f, 1.0f, 1, 0, 1.0f);
            } else {
                super.resume(this.streamId);
            }
            this.startTime = System.currentTimeMillis();
            this.handler = new Handler();
            Handler handler2 = this.handler;
            Runnable runnable2 = this.runnable;
            long j2 = this.duration;
            long j3 = this.timeSinceStart;
            if (j2 - j3 > 0) {
                j = j2 - j3;
            }
            handler2.postDelayed(runnable2, j);
            this.isPlaying = true;
        }
    }

    private long getSoundDuration(int i2) {
        int i3;
        try {
            i3 = MediaPlayer.create(this.context, i2).getDuration();
        } catch (Exception | NullPointerException unused) {
            i3 = 0;
        }
        return (long) i3;
    }
}

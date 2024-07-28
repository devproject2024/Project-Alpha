package com.paytm.android.chat.services;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.ToastUtil;

public class MediaPlayerService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f42305a = null;

    /* renamed from: b  reason: collision with root package name */
    a f42306b;

    /* renamed from: c  reason: collision with root package name */
    public final IBinder f42307c = new b();

    /* renamed from: d  reason: collision with root package name */
    private AudioManager f42308d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public AudioManager.OnAudioFocusChangeListener f42309e;

    public interface a {
        void a(MediaPlayer mediaPlayer);
    }

    public final void a(a aVar) {
        this.f42306b = aVar;
    }

    /* access modifiers changed from: private */
    public int g() {
        if (Build.VERSION.SDK_INT < 8) {
            return 0;
        }
        if (this.f42308d == null) {
            this.f42308d = (AudioManager) getSystemService(H5ResourceHandlerUtil.AUDIO);
        }
        if (this.f42309e == null && Build.VERSION.SDK_INT >= 8) {
            this.f42309e = new AudioManager.OnAudioFocusChangeListener() {
                public final void onAudioFocusChange(int i2) {
                }
            };
        }
        return this.f42308d.requestAudioFocus(this.f42309e, 3, 2);
    }

    /* access modifiers changed from: private */
    public void a(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        if (this.f42308d != null && onAudioFocusChangeListener != null && Build.VERSION.SDK_INT >= 8) {
            this.f42308d.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    public void onCreate() {
        super.onCreate();
        if (this.f42305a == null) {
            this.f42305a = new MediaPlayer();
        }
        MediaPlayer mediaPlayer = this.f42305a;
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    int unused = MediaPlayerService.this.g();
                    mediaPlayer.start();
                }
            });
            this.f42305a.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                    if (i2 == -38) {
                        return false;
                    }
                    ToastUtil.showMsg(R.string.chat_module_file_corruption);
                    return false;
                }
            });
            this.f42305a.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    MediaPlayerService mediaPlayerService = MediaPlayerService.this;
                    mediaPlayerService.a(mediaPlayerService.f42309e);
                    if (MediaPlayerService.this.f42306b != null) {
                        MediaPlayerService.this.f42306b.a(mediaPlayer);
                    }
                }
            });
        }
    }

    public IBinder onBind(Intent intent) {
        String string;
        Bundle extras = intent.getExtras();
        if (!(extras == null || (string = extras.getString("url")) == null || string.equals(""))) {
            a(string);
        }
        return this.f42307c;
    }

    public class b extends Binder {
        public b() {
        }

        public final MediaPlayerService a() {
            return MediaPlayerService.this;
        }
    }

    public boolean onUnbind(Intent intent) {
        f();
        return super.onUnbind(intent);
    }

    public final void a() {
        MediaPlayer mediaPlayer = this.f42305a;
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            g();
            this.f42305a.start();
        }
    }

    public final void b() {
        MediaPlayer mediaPlayer = this.f42305a;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            a(this.f42309e);
            this.f42305a.pause();
        }
    }

    public final void a(int i2) {
        MediaPlayer mediaPlayer = this.f42305a;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i2);
        }
    }

    public final int c() {
        MediaPlayer mediaPlayer = this.f42305a;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public final int d() {
        MediaPlayer mediaPlayer = this.f42305a;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    public final boolean e() {
        MediaPlayer mediaPlayer = this.f42305a;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    public final void f() {
        a(this.f42309e);
        MediaPlayer mediaPlayer = this.f42305a;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f42305a.stop();
            }
            this.f42305a.release();
            this.f42305a = null;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        f();
    }

    public final void a(String str) {
        this.f42305a.reset();
        try {
            this.f42305a.setDataSource(str);
            this.f42305a.prepareAsync();
        } catch (Exception unused) {
        }
    }
}

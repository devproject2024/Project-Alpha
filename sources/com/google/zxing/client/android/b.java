package com.google.zxing.client.android;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import java.io.Closeable;
import java.io.IOException;

public final class b implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, Closeable {

    /* renamed from: b  reason: collision with root package name */
    private static final String f40135b = b.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    int f40136a = R.raw.qr_scansound;

    /* renamed from: c  reason: collision with root package name */
    private final Activity f40137c;

    /* renamed from: d  reason: collision with root package name */
    private MediaPlayer f40138d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f40139e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f40140f;

    public b(Activity activity) {
        this.f40137c = activity;
        this.f40138d = null;
        a();
    }

    public b(Activity activity, int i2) {
        this.f40137c = activity;
        this.f40138d = null;
        this.f40136a = i2;
        a();
    }

    public final synchronized void a() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f40137c);
        Activity activity = this.f40137c;
        boolean z = defaultSharedPreferences.getBoolean("preferences_play_beep", true);
        if (z && ((AudioManager) activity.getSystemService(H5ResourceHandlerUtil.AUDIO)).getRingerMode() != 2) {
            z = false;
        }
        this.f40139e = z;
        this.f40140f = defaultSharedPreferences.getBoolean("preferences_vibrate", false);
        if (this.f40139e && this.f40138d == null) {
            this.f40137c.setVolumeControlStream(3);
            this.f40138d = a(this.f40137c);
        }
    }

    public final synchronized void b() {
        if (this.f40139e && this.f40138d != null) {
            this.f40138d.start();
        }
        if (this.f40140f) {
            ((Vibrator) this.f40137c.getSystemService("vibrator")).vibrate(200);
        }
    }

    private MediaPlayer a(Context context) {
        AssetFileDescriptor openRawResourceFd;
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        try {
            openRawResourceFd = context.getResources().openRawResourceFd(this.f40136a);
            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            openRawResourceFd.close();
            mediaPlayer.setVolume(1.0f, 1.0f);
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (IOException unused) {
            mediaPlayer.release();
            return null;
        } catch (Throwable th) {
            openRawResourceFd.close();
            throw th;
        }
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.seekTo(0);
    }

    public final synchronized boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        if (i2 == 100) {
            this.f40137c.finish();
        } else {
            mediaPlayer.release();
            this.f40138d = null;
            a();
        }
        return true;
    }

    public final synchronized void close() {
        if (this.f40138d != null) {
            this.f40138d.release();
            this.f40138d = null;
        }
    }
}

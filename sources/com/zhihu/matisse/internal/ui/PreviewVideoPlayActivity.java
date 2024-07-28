package com.zhihu.matisse.internal.ui;

import android.content.Context;
import android.content.ContextWrapper;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.paytm.android.chat.R;
import com.paytm.android.chat.base.BaseActivity;

public class PreviewVideoPlayActivity extends BaseActivity implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f45798a = "";

    /* renamed from: b  reason: collision with root package name */
    private ImageView f45799b;

    /* renamed from: c  reason: collision with root package name */
    private MediaController f45800c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public VideoView f45801d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f45802e;

    /* renamed from: f  reason: collision with root package name */
    private int f45803f = -1;

    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_video_play);
        this.f45798a = getIntent().getStringExtra("video_path");
        this.f45799b = (ImageView) findViewById(R.id.picture_left_back);
        this.f45801d = (VideoView) findViewById(R.id.video_view);
        this.f45801d.setBackgroundColor(-16777216);
        this.f45802e = (ImageView) findViewById(R.id.iv_play);
        this.f45800c = new MediaController(this);
        this.f45801d.setOnCompletionListener(this);
        this.f45801d.setOnPreparedListener(this);
        this.f45801d.setMediaController(this.f45800c);
        this.f45799b.setOnClickListener(this);
        this.f45802e.setOnClickListener(this);
    }

    public void onStart() {
        this.f45801d.setVideoPath(this.f45798a);
        this.f45801d.start();
        super.onStart();
    }

    public void onPause() {
        this.f45803f = this.f45801d.getCurrentPosition();
        this.f45801d.stopPlayback();
        super.onPause();
    }

    public void onDestroy() {
        this.f45800c = null;
        this.f45801d = null;
        this.f45802e = null;
        super.onDestroy();
    }

    public void onResume() {
        int i2 = this.f45803f;
        if (i2 >= 0) {
            this.f45801d.seekTo(i2);
            this.f45803f = -1;
        }
        super.onResume();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        ImageView imageView = this.f45802e;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.picture_left_back) {
            finish();
        } else if (id == R.id.iv_play) {
            this.f45801d.start();
            this.f45802e.setVisibility(4);
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(new ContextWrapper(context) {
            public final Object getSystemService(String str) {
                if (H5ResourceHandlerUtil.AUDIO.equals(str)) {
                    return getApplicationContext().getSystemService(str);
                }
                return super.getSystemService(str);
            }
        });
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                if (i2 != 3) {
                    return false;
                }
                PreviewVideoPlayActivity.this.f45801d.setBackgroundColor(0);
                return true;
            }
        });
    }
}

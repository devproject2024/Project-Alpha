package exfilepicker.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.paytm.android.chat.R;
import com.paytm.android.chat.c;
import exfilepicker.ui.adapter.AudioListAdapter;
import java.util.Timer;
import java.util.TimerTask;

public class CircleProgressPlayButton extends View {

    /* renamed from: a  reason: collision with root package name */
    public a f46231a;

    /* renamed from: b  reason: collision with root package name */
    protected Paint f46232b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    protected Path f46233c = new Path();

    /* renamed from: d  reason: collision with root package name */
    protected Bitmap f46234d = BitmapFactory.decodeResource(getResources(), R.drawable.chat_ic_local_audio_stop);

    /* renamed from: e  reason: collision with root package name */
    protected Bitmap f46235e = BitmapFactory.decodeResource(getResources(), R.drawable.chat_ic_local_audio_play);

    /* renamed from: f  reason: collision with root package name */
    protected Bitmap f46236f = BitmapFactory.decodeResource(getResources(), R.drawable.chat_ic_local_audio_replay);

    /* renamed from: g  reason: collision with root package name */
    protected Rect f46237g = new Rect(0, 0, this.f46234d.getWidth(), this.f46234d.getHeight());

    /* renamed from: h  reason: collision with root package name */
    protected Rect f46238h = new Rect(0, 0, this.f46235e.getWidth(), this.f46235e.getHeight());

    /* renamed from: i  reason: collision with root package name */
    protected Rect f46239i = new Rect(0, 0, this.f46236f.getWidth(), this.f46236f.getHeight());
    protected RectF j;
    protected Rect k;
    protected int l = ((int) (getResources().getDisplayMetrics().density * 1.0f));
    protected String m = "#00B9F5";
    protected Timer n = null;
    public String o;
    private int p = 0;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static String f46243a = "PAUSE";

        /* renamed from: b  reason: collision with root package name */
        public static String f46244b = "PLAYING";

        /* renamed from: c  reason: collision with root package name */
        public static String f46245c = "IDLE";

        /* renamed from: d  reason: collision with root package name */
        public static String f46246d = "STOP";

        /* renamed from: e  reason: collision with root package name */
        public String f46247e = null;

        /* renamed from: f  reason: collision with root package name */
        public String f46248f = f46245c;

        /* renamed from: g  reason: collision with root package name */
        public MediaPlayer f46249g = null;

        /* renamed from: h  reason: collision with root package name */
        public AudioListAdapter.a f46250h;

        /* renamed from: i  reason: collision with root package name */
        public Context f46251i = null;
        private AudioManager j;
        private AudioManager.OnAudioFocusChangeListener k = null;

        private int f() {
            if (Build.VERSION.SDK_INT < 8) {
                return 0;
            }
            if (this.j == null) {
                this.j = (AudioManager) c.a().getSystemService(H5ResourceHandlerUtil.AUDIO);
            }
            if (this.k == null && Build.VERSION.SDK_INT >= 8) {
                this.k = new AudioManager.OnAudioFocusChangeListener() {
                    public final void onAudioFocusChange(int i2) {
                    }
                };
            }
            return this.j.requestAudioFocus(this.k, 3, 2);
        }

        private void a(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
            if (this.j != null && onAudioFocusChangeListener != null && Build.VERSION.SDK_INT >= 8) {
                this.j.abandonAudioFocus(onAudioFocusChangeListener);
            }
        }

        public final void a() {
            f();
            this.f46248f = f46244b;
            this.f46249g.start();
            this.f46250h.f46198f.setTimer(this);
        }

        public final void b() {
            a(this.k);
            this.f46248f = f46246d;
            AudioListAdapter.a aVar = this.f46250h;
            if (aVar != null) {
                aVar.f46198f.a();
                this.f46250h.f46198f.invalidate();
            }
            MediaPlayer mediaPlayer = this.f46249g;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                this.f46249g.release();
                this.f46249g = null;
            }
            this.f46247e = null;
        }

        public final void c() {
            MediaPlayer mediaPlayer = this.f46249g;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                a(this.k);
                this.f46248f = f46243a;
                this.f46250h.f46198f.a();
                this.f46249g.pause();
                this.f46250h.f46198f.invalidate();
            }
        }

        public final int d() {
            MediaPlayer mediaPlayer = this.f46249g;
            if (mediaPlayer == null) {
                return 0;
            }
            return (mediaPlayer.getCurrentPosition() * 360) / this.f46249g.getDuration();
        }

        public final boolean e() {
            MediaPlayer mediaPlayer = this.f46249g;
            if (mediaPlayer == null) {
                return false;
            }
            return mediaPlayer.isPlaying();
        }
    }

    public CircleProgressPlayButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.p = i2;
        this.k = new Rect(0, 0, i2, i2);
        int i6 = this.l;
        this.j = new RectF((float) ((i6 / 2) + 1), (float) ((i6 / 2) + 1), (float) ((i2 - (i6 / 2)) - 1), (float) ((i2 - (i6 / 2)) - 1));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f46232b.setFilterBitmap(true);
        if (!this.o.equals(this.f46231a.f46247e)) {
            canvas.drawBitmap(this.f46235e, this.f46238h, this.k, this.f46232b);
        } else if (this.f46231a.e()) {
            canvas.drawBitmap(this.f46234d, this.f46237g, this.k, this.f46232b);
            a(canvas);
        } else if (this.f46231a.f46248f.equals(a.f46243a)) {
            canvas.drawBitmap(this.f46236f, this.f46239i, this.k, this.f46232b);
            a(canvas);
        } else {
            canvas.drawBitmap(this.f46235e, this.f46238h, this.k, this.f46232b);
        }
    }

    public void setTimer(final a aVar) {
        this.n = new Timer();
        this.n.schedule(new TimerTask() {

            /* renamed from: c  reason: collision with root package name */
            private int f46242c = 0;

            public final void run() {
                if (this.f46242c != aVar.f46249g.getCurrentPosition() || this.f46242c == 0) {
                    this.f46242c = aVar.f46249g.getCurrentPosition();
                    CircleProgressPlayButton.this.postInvalidate();
                    return;
                }
                a aVar = aVar;
                Boolean bool = Boolean.TRUE;
                aVar.f46248f = a.f46245c;
                aVar.f46249g.seekTo(0);
                if (bool.booleanValue()) {
                    aVar.f46250h.f46198f.postInvalidate();
                } else {
                    aVar.f46250h.f46198f.invalidate();
                }
                CircleProgressPlayButton.this.a();
            }
        }, 0, 100);
    }

    public final void a() {
        Timer timer = this.n;
        if (timer != null) {
            timer.cancel();
            this.n = null;
        }
    }

    private void a(Canvas canvas) {
        this.f46232b.setStyle(Paint.Style.STROKE);
        this.f46232b.setColor(Color.parseColor(this.m));
        this.f46232b.setStrokeWidth((float) this.l);
        this.f46232b.setAntiAlias(true);
        canvas.drawArc(this.j, -90.0f, (float) this.f46231a.d(), false, this.f46232b);
    }
}

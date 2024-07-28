package net.one97.paytm.h5paytmsdk.videoplayer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.h5paytmsdk.R;

public final class PaytmH5VideoPlayerImpl extends RelativeLayout implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    /* renamed from: d  reason: collision with root package name */
    public static final b f17125d = new b((byte) 0);
    private Uri A;
    private Map<String, String> B;
    private a C;
    /* access modifiers changed from: private */
    public c D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private String H;
    private boolean I;
    private boolean J;
    /* access modifiers changed from: private */
    public boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private int O;
    private final h P;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Handler f17126a;

    /* renamed from: b  reason: collision with root package name */
    boolean f17127b;

    /* renamed from: c  reason: collision with root package name */
    Runnable f17128c;

    /* renamed from: e  reason: collision with root package name */
    private int f17129e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public MediaPlayer f17130f;

    /* renamed from: g  reason: collision with root package name */
    private AudioManager f17131g;

    /* renamed from: h  reason: collision with root package name */
    private Surface f17132h;

    /* renamed from: i  reason: collision with root package name */
    private View f17133i;
    private View j;
    private View k;
    private View l;
    private Toolbar m;
    private ProgressBar n;
    private TextView o;
    private TextureView p;
    private SeekBar q;
    private ProgressBar r;
    private TextView s;
    private TextView t;
    private ImageButton u;
    private boolean v;
    /* access modifiers changed from: private */
    public boolean w;
    private boolean x;
    private int y;
    private int z;

    public enum a {
        PlayButton,
        PauseButton,
        RestartButton
    }

    public PaytmH5VideoPlayerImpl(Context context) {
        this(context, (AttributeSet) null, 0, 6, (kotlin.g.b.g) null);
    }

    public PaytmH5VideoPlayerImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (kotlin.g.b.g) null);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        k.c(surfaceTexture, "surfaceTexture");
    }

    public static final /* synthetic */ View a(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
        View view = paytmH5VideoPlayerImpl.f17133i;
        if (view == null) {
            k.a("mControlsFrame");
        }
        return view;
    }

    public static final /* synthetic */ View b(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
        View view = paytmH5VideoPlayerImpl.l;
        if (view == null) {
            k.a("mToolbarFrame");
        }
        return view;
    }

    public static final /* synthetic */ TextView e(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
        TextView textView = paytmH5VideoPlayerImpl.s;
        if (textView == null) {
            k.a("mLabelPosition");
        }
        return textView;
    }

    public static final /* synthetic */ TextView g(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
        TextView textView = paytmH5VideoPlayerImpl.t;
        if (textView == null) {
            k.a("mLabelDuration");
        }
        return textView;
    }

    public static final /* synthetic */ SeekBar h(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
        SeekBar seekBar = paytmH5VideoPlayerImpl.q;
        if (seekBar == null) {
            k.a("mSeeker");
        }
        return seekBar;
    }

    public static final /* synthetic */ ProgressBar i(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
        ProgressBar progressBar = paytmH5VideoPlayerImpl.r;
        if (progressBar == null) {
            k.a("mBottomProgressBar");
        }
        return progressBar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaytmH5VideoPlayerImpl(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.g.b.g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaytmH5VideoPlayerImpl(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        this.f17129e = H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY;
        this.B = new HashMap();
        boolean z2 = true;
        this.K = true;
        this.M = true;
        this.O = -1;
        this.f17128c = new f(this);
        this.P = new h(this);
        setBackgroundColor(-16777216);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PaytmH5VideoPlayer, 0, 0);
            try {
                String string = obtainStyledAttributes.getString(R.styleable.PaytmH5VideoPlayer_phvp_source);
                if (string != null) {
                    if (string != null) {
                        if (p.b(string).toString().length() > 0) {
                            this.A = Uri.parse(string);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
                String string2 = obtainStyledAttributes.getString(R.styleable.PaytmH5VideoPlayer_phvp_title);
                if (string2 != null) {
                    if (string2 != null) {
                        if (p.b(string2).toString().length() <= 0) {
                            z2 = false;
                        }
                        if (z2) {
                            this.H = string2;
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
                this.E = obtainStyledAttributes.getDrawable(R.styleable.PaytmH5VideoPlayer_phvp_playDrawable);
                this.F = obtainStyledAttributes.getDrawable(R.styleable.PaytmH5VideoPlayer_phvp_pauseDrawable);
                this.G = obtainStyledAttributes.getDrawable(R.styleable.PaytmH5VideoPlayer_phvp_restartDrawable);
                setHideControlsDuration(obtainStyledAttributes.getInteger(R.styleable.PaytmH5VideoPlayer_phvp_hideControlsDuration, getHideControlsDuration()));
                this.J = obtainStyledAttributes.getBoolean(R.styleable.PaytmH5VideoPlayer_phvp_hideControlsOnPlay, false);
                this.N = obtainStyledAttributes.getBoolean(R.styleable.PaytmH5VideoPlayer_phvp_autoPlay, false);
                this.I = obtainStyledAttributes.getBoolean(R.styleable.PaytmH5VideoPlayer_phvp_loop, false);
                this.K = obtainStyledAttributes.getBoolean(R.styleable.PaytmH5VideoPlayer_phvp_showTotalDuration, false);
                this.L = obtainStyledAttributes.getBoolean(R.styleable.PaytmH5VideoPlayer_phvp_showBottomProgressBar, false);
                this.f17127b = obtainStyledAttributes.getBoolean(R.styleable.PaytmH5VideoPlayer_phvp_disableControls, false);
            } catch (Exception e2) {
                b.a("Exception " + e2.getMessage(), new Object[0]);
                e2.printStackTrace();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
            obtainStyledAttributes.recycle();
        }
        if (this.E == null) {
            this.E = androidx.core.content.b.a(context, R.drawable.ph5_action_play);
        }
        if (this.F == null) {
            this.F = androidx.core.content.b.a(context, R.drawable.ph5_action_pause);
        }
        if (this.G == null) {
            this.G = androidx.core.content.b.a(context, R.drawable.ph5_action_restart);
        }
    }

    public final int getHideControlsDuration() {
        return this.f17129e;
    }

    public final void setHideControlsDuration(int i2) {
        this.f17129e = i2;
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmH5VideoPlayerImpl f17137a;

        f(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
            this.f17137a = paytmH5VideoPlayerImpl;
        }

        public final void run() {
            this.f17137a.b();
        }
    }

    public static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmH5VideoPlayerImpl f17139a;

        h(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
            this.f17139a = paytmH5VideoPlayerImpl;
        }

        public final void run() {
            MediaPlayer d2;
            if (this.f17139a.w && (d2 = this.f17139a.f17130f) != null) {
                long currentPosition = (long) d2.getCurrentPosition();
                long duration = (long) d2.getDuration();
                if (currentPosition > duration) {
                    currentPosition = duration;
                }
                TextView e2 = PaytmH5VideoPlayerImpl.e(this.f17139a);
                net.one97.paytm.h5paytmsdk.d.g gVar = net.one97.paytm.h5paytmsdk.d.g.f17102a;
                e2.setText(net.one97.paytm.h5paytmsdk.d.g.a(currentPosition, false));
                if (this.f17139a.K) {
                    TextView g2 = PaytmH5VideoPlayerImpl.g(this.f17139a);
                    net.one97.paytm.h5paytmsdk.d.g gVar2 = net.one97.paytm.h5paytmsdk.d.g.f17102a;
                    g2.setText(net.one97.paytm.h5paytmsdk.d.g.a(duration, false));
                } else {
                    TextView g3 = PaytmH5VideoPlayerImpl.g(this.f17139a);
                    net.one97.paytm.h5paytmsdk.d.g gVar3 = net.one97.paytm.h5paytmsdk.d.g.f17102a;
                    g3.setText(net.one97.paytm.h5paytmsdk.d.g.a(duration - currentPosition, true));
                }
                int i2 = (int) currentPosition;
                int i3 = (int) duration;
                PaytmH5VideoPlayerImpl.h(this.f17139a).setProgress(i2);
                PaytmH5VideoPlayerImpl.h(this.f17139a).setMax(i3);
                PaytmH5VideoPlayerImpl.i(this.f17139a).setProgress(i2);
                PaytmH5VideoPlayerImpl.i(this.f17139a).setMax(i3);
                c unused = this.f17139a.D;
                Handler k = this.f17139a.f17126a;
                if (k != null) {
                    k.postDelayed(this, 100);
                }
            }
        }
    }

    public final void setSource(Uri uri) {
        k.c(uri, "source");
        this.A = uri;
        if (this.f17130f != null) {
            d();
        }
    }

    public final void setSource(Uri uri, Map<String, String> map) {
        k.c(uri, "source");
        k.c(map, "headers");
        this.B = map;
        setSource(uri);
    }

    public final void setCallback(a aVar) {
        k.c(aVar, H5Event.TYPE_CALL_BACK);
        this.C = aVar;
    }

    public final void setProgressCallback(c cVar) {
        k.c(cVar, H5Event.TYPE_CALL_BACK);
        this.D = cVar;
    }

    public final void setButtonDrawable(a aVar, Drawable drawable) {
        k.c(aVar, "type");
        k.c(drawable, "drawable");
        int i2 = b.f17140a[aVar.ordinal()];
        if (i2 == 1) {
            this.E = drawable;
            if (!f()) {
                ImageButton imageButton = this.u;
                if (imageButton == null) {
                    k.a("mBtnPlayPause");
                }
                imageButton.setImageDrawable(drawable);
            }
        } else if (i2 == 2) {
            this.F = drawable;
            if (f()) {
                ImageButton imageButton2 = this.u;
                if (imageButton2 == null) {
                    k.a("mBtnPlayPause");
                }
                imageButton2.setImageDrawable(drawable);
            }
        } else if (i2 == 3) {
            this.F = drawable;
            MediaPlayer mediaPlayer = this.f17130f;
            if (mediaPlayer != null && mediaPlayer.getCurrentPosition() >= mediaPlayer.getDuration()) {
                ImageButton imageButton3 = this.u;
                if (imageButton3 == null) {
                    k.a("mBtnPlayPause");
                }
                imageButton3.setImageDrawable(drawable);
            }
        }
    }

    public final void setHideControlsOnPlay(boolean z2) {
        this.J = z2;
    }

    public final void setAutoPlay(boolean z2) {
        this.N = z2;
    }

    public final void setInitialPosition(int i2) {
        this.O = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078 A[Catch:{ IOException -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void d() {
        /*
            r4 = this;
            boolean r0 = r4.v
            if (r0 == 0) goto L_0x0086
            boolean r0 = r4.w
            if (r0 == 0) goto L_0x000a
            goto L_0x0086
        L_0x000a:
            android.net.Uri r0 = r4.A
            if (r0 == 0) goto L_0x0086
            r4.b()     // Catch:{ IOException -> 0x007e }
            net.one97.paytm.h5paytmsdk.videoplayer.a r1 = r4.C     // Catch:{ IOException -> 0x007e }
            if (r1 == 0) goto L_0x0018
            r1.c(r4)     // Catch:{ IOException -> 0x007e }
        L_0x0018:
            android.media.MediaPlayer r1 = r4.f17130f     // Catch:{ IOException -> 0x007e }
            if (r1 == 0) goto L_0x0021
            android.view.Surface r2 = r4.f17132h     // Catch:{ IOException -> 0x007e }
            r1.setSurface(r2)     // Catch:{ IOException -> 0x007e }
        L_0x0021:
            java.lang.String r1 = r0.getScheme()     // Catch:{ IOException -> 0x007e }
            java.lang.String r2 = "http"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ IOException -> 0x007e }
            r2 = 0
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = r0.getScheme()     // Catch:{ IOException -> 0x007e }
            java.lang.String r3 = "https"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)     // Catch:{ IOException -> 0x007e }
            if (r1 == 0) goto L_0x003b
            goto L_0x0058
        L_0x003b:
            java.lang.String r1 = "Loading local URI: "
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x007e }
            java.lang.String r1 = r1.concat(r3)     // Catch:{ IOException -> 0x007e }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x007e }
            net.one97.paytm.h5paytmsdk.videoplayer.PaytmH5VideoPlayerImpl.b.a(r1, r2)     // Catch:{ IOException -> 0x007e }
            android.media.MediaPlayer r1 = r4.f17130f     // Catch:{ IOException -> 0x007e }
            if (r1 == 0) goto L_0x0074
            android.content.Context r2 = r4.getContext()     // Catch:{ IOException -> 0x007e }
            java.util.Map<java.lang.String, java.lang.String> r3 = r4.B     // Catch:{ IOException -> 0x007e }
            r1.setDataSource(r2, r0, r3)     // Catch:{ IOException -> 0x007e }
            goto L_0x0074
        L_0x0058:
            java.lang.String r1 = "Loading web URI: "
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x007e }
            java.lang.String r1 = r1.concat(r3)     // Catch:{ IOException -> 0x007e }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x007e }
            net.one97.paytm.h5paytmsdk.videoplayer.PaytmH5VideoPlayerImpl.b.a(r1, r2)     // Catch:{ IOException -> 0x007e }
            android.media.MediaPlayer r1 = r4.f17130f     // Catch:{ IOException -> 0x007e }
            if (r1 == 0) goto L_0x0074
            android.content.Context r2 = r4.getContext()     // Catch:{ IOException -> 0x007e }
            java.util.Map<java.lang.String, java.lang.String> r3 = r4.B     // Catch:{ IOException -> 0x007e }
            r1.setDataSource(r2, r0, r3)     // Catch:{ IOException -> 0x007e }
        L_0x0074:
            android.media.MediaPlayer r0 = r4.f17130f     // Catch:{ IOException -> 0x007e }
            if (r0 == 0) goto L_0x007d
            r0.prepareAsync()     // Catch:{ IOException -> 0x007e }
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ IOException -> 0x007e }
        L_0x007d:
            return
        L_0x007e:
            r0 = move-exception
            java.lang.Exception r0 = (java.lang.Exception) r0
            r4.a((java.lang.Exception) r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.videoplayer.PaytmH5VideoPlayerImpl.d():void");
    }

    private final void setControlsEnabled(boolean z2) {
        SeekBar seekBar = this.q;
        if (seekBar == null) {
            k.a("mSeeker");
        }
        seekBar.setEnabled(z2);
        ImageButton imageButton = this.u;
        if (imageButton == null) {
            k.a("mBtnPlayPause");
        }
        imageButton.setEnabled(z2);
        ImageButton imageButton2 = this.u;
        if (imageButton2 == null) {
            k.a("mBtnPlayPause");
        }
        imageButton2.setAlpha(z2 ? 1.0f : 0.4f);
        View view = this.k;
        if (view == null) {
            k.a("mClickFrame");
        }
        view.setEnabled(z2);
    }

    public final void a() {
        a aVar = this.C;
        if (aVar != null) {
            aVar.f(this);
        }
        if (!this.f17127b && !c()) {
            View view = this.f17133i;
            if (view == null) {
                k.a("mControlsFrame");
            }
            view.animate().cancel();
            View view2 = this.f17133i;
            if (view2 == null) {
                k.a("mControlsFrame");
            }
            view2.setAlpha(0.0f);
            View view3 = this.f17133i;
            if (view3 == null) {
                k.a("mControlsFrame");
            }
            view3.setVisibility(0);
            View view4 = this.f17133i;
            if (view4 == null) {
                k.a("mControlsFrame");
            }
            view4.animate().alpha(1.0f).translationY(0.0f).setListener((Animator.AnimatorListener) null).setInterpolator(new DecelerateInterpolator()).start();
            if (this.L) {
                ProgressBar progressBar = this.r;
                if (progressBar == null) {
                    k.a("mBottomProgressBar");
                }
                progressBar.animate().cancel();
                ProgressBar progressBar2 = this.r;
                if (progressBar2 == null) {
                    k.a("mBottomProgressBar");
                }
                progressBar2.setAlpha(1.0f);
                ProgressBar progressBar3 = this.r;
                if (progressBar3 == null) {
                    k.a("mBottomProgressBar");
                }
                progressBar3.animate().alpha(0.0f).start();
            }
            if (this.M) {
                View view5 = this.l;
                if (view5 == null) {
                    k.a("mToolbarFrame");
                }
                view5.animate().cancel();
                View view6 = this.l;
                if (view6 == null) {
                    k.a("mToolbarFrame");
                }
                view6.setAlpha(0.0f);
                View view7 = this.l;
                if (view7 == null) {
                    k.a("mToolbarFrame");
                }
                view7.setVisibility(0);
                View view8 = this.l;
                if (view8 == null) {
                    k.a("mToolbarFrame");
                }
                view8.animate().alpha(1.0f).setListener((Animator.AnimatorListener) null).setInterpolator(new DecelerateInterpolator()).start();
            }
        }
    }

    public final void b() {
        a aVar = this.C;
        if (aVar != null) {
            aVar.f(this);
        }
        if (!this.f17127b && c()) {
            View view = this.f17133i;
            if (view == null) {
                k.a("mControlsFrame");
            }
            view.animate().cancel();
            view.setAlpha(1.0f);
            view.setTranslationY(0.0f);
            view.setVisibility(0);
            view.animate().alpha(0.0f).translationY((float) view.getHeight()).setInterpolator(new DecelerateInterpolator()).setListener(new e(this)).start();
            if (this.L) {
                ProgressBar progressBar = this.r;
                if (progressBar == null) {
                    k.a("mBottomProgressBar");
                }
                progressBar.animate().cancel();
                progressBar.setAlpha(0.0f);
                progressBar.animate().alpha(1.0f).start();
            }
            e();
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmH5VideoPlayerImpl f17136a;

        e(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
            this.f17136a = paytmH5VideoPlayerImpl;
        }

        public final void onAnimationEnd(Animator animator) {
            k.c(animator, "animation");
            PaytmH5VideoPlayerImpl.a(this.f17136a).setVisibility(8);
        }
    }

    private final void e() {
        View view = this.l;
        if (view == null) {
            k.a("mToolbarFrame");
        }
        if (view.getVisibility() == 0) {
            View view2 = this.l;
            if (view2 == null) {
                k.a("mToolbarFrame");
            }
            view2.animate().cancel();
            View view3 = this.l;
            if (view3 == null) {
                k.a("mToolbarFrame");
            }
            view3.setAlpha(1.0f);
            View view4 = this.l;
            if (view4 == null) {
                k.a("mToolbarFrame");
            }
            view4.setVisibility(0);
            View view5 = this.l;
            if (view5 == null) {
                k.a("mToolbarFrame");
            }
            view5.animate().alpha(0.0f).setInterpolator(new DecelerateInterpolator()).setListener(new g(this)).start();
        }
    }

    public static final class g extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmH5VideoPlayerImpl f17138a;

        g(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
            this.f17138a = paytmH5VideoPlayerImpl;
        }

        public final void onAnimationEnd(Animator animator) {
            k.c(animator, "animation");
            PaytmH5VideoPlayerImpl.b(this.f17138a).setVisibility(8);
        }
    }

    public final boolean c() {
        if (this.f17127b) {
            return false;
        }
        View view = this.f17133i;
        if (view == null) {
            k.a("mControlsFrame");
        }
        return view.getAlpha() > 0.5f;
    }

    public final void setBottomProgressBarVisibility(boolean z2) {
        this.L = z2;
        if (z2) {
            ProgressBar progressBar = this.r;
            if (progressBar == null) {
                k.a("mBottomProgressBar");
            }
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = this.r;
        if (progressBar2 == null) {
            k.a("mBottomProgressBar");
        }
        progressBar2.setVisibility(8);
    }

    public static final class d extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmH5VideoPlayerImpl f17135a;

        d(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
            this.f17135a = paytmH5VideoPlayerImpl;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl = this.f17135a;
            if (paytmH5VideoPlayerImpl.f17127b) {
                return true;
            }
            if (paytmH5VideoPlayerImpl.c()) {
                paytmH5VideoPlayerImpl.b();
                return true;
            }
            if (paytmH5VideoPlayerImpl.getHideControlsDuration() >= 0) {
                Handler handler = paytmH5VideoPlayerImpl.f17126a;
                if (handler != null) {
                    handler.removeCallbacks(paytmH5VideoPlayerImpl.f17128c);
                }
                Handler handler2 = paytmH5VideoPlayerImpl.f17126a;
                if (handler2 != null) {
                    handler2.postDelayed(paytmH5VideoPlayerImpl.f17128c, (long) paytmH5VideoPlayerImpl.getHideControlsDuration());
                }
            }
            paytmH5VideoPlayerImpl.a();
            return true;
        }
    }

    static final class c implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GestureDetector f17134a;

        c(GestureDetector gestureDetector) {
            this.f17134a = gestureDetector;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f17134a.onTouchEvent(motionEvent);
        }
    }

    private boolean f() {
        MediaPlayer mediaPlayer = this.f17130f;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    public final int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f17130f;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return -1;
    }

    public final int getDuration() {
        MediaPlayer mediaPlayer = this.f17130f;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return -1;
    }

    private void g() {
        MediaPlayer mediaPlayer = this.f17130f;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        a aVar = this.C;
        if (aVar != null) {
            aVar.a(this);
        }
        if (this.f17126a == null) {
            this.f17126a = new Handler();
        }
        Handler handler = this.f17126a;
        if (handler != null) {
            handler.post(this.P);
        }
        ImageButton imageButton = this.u;
        if (imageButton == null) {
            k.a("mBtnPlayPause");
        }
        imageButton.setImageDrawable(this.F);
    }

    private void a(int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            MediaPlayer mediaPlayer = this.f17130f;
            if (mediaPlayer != null) {
                mediaPlayer.seekTo((long) i2, 3);
                return;
            }
            return;
        }
        MediaPlayer mediaPlayer2 = this.f17130f;
        if (mediaPlayer2 != null) {
            mediaPlayer2.seekTo(i2);
        }
    }

    public final void setVolume(float f2, float f3) {
        MediaPlayer mediaPlayer = this.f17130f;
        if (mediaPlayer == null || !this.w) {
            throw new IllegalStateException("You cannot use setVolume(float, float) until the player is prepared.");
        } else if (mediaPlayer != null) {
            mediaPlayer.setVolume(f2, f3);
        }
    }

    public final Toolbar getToolbar() {
        Toolbar toolbar = this.m;
        if (toolbar == null) {
            k.a("mToolbar");
        }
        return toolbar;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        k.c(surfaceTexture, "surfaceTexture");
        b.a("Surface texture available: %dx%d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.y = i2;
        this.z = i3;
        this.v = true;
        this.f17132h = new Surface(surfaceTexture);
        if (this.w) {
            b.a("Surface texture available and media player is prepared", new Object[0]);
            MediaPlayer mediaPlayer = this.f17130f;
            if (mediaPlayer != null) {
                mediaPlayer.setSurface(this.f17132h);
                return;
            }
            return;
        }
        d();
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        k.c(surfaceTexture, "surfaceTexture");
        b.a("Surface texture changed: %dx%d", Integer.valueOf(i2), Integer.valueOf(i3));
        MediaPlayer mediaPlayer = this.f17130f;
        if (mediaPlayer != null) {
            a(i2, i3, mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        k.c(mediaPlayer, "mediaPlayer");
        b.a("Buffering: %d%%", Integer.valueOf(i2));
        a aVar = this.C;
        if (aVar != null) {
            aVar.a(i2);
        }
        if (i2 == 100) {
            SeekBar seekBar = this.q;
            if (seekBar == null) {
                k.a("mSeeker");
            }
            seekBar.setSecondaryProgress(0);
            ProgressBar progressBar = this.r;
            if (progressBar == null) {
                k.a("mBottomProgressBar");
            }
            progressBar.setSecondaryProgress(0);
            return;
        }
        float f2 = ((float) i2) / 100.0f;
        SeekBar seekBar2 = this.q;
        if (seekBar2 == null) {
            k.a("mSeeker");
        }
        int max = (int) (((float) seekBar2.getMax()) * f2);
        SeekBar seekBar3 = this.q;
        if (seekBar3 == null) {
            k.a("mSeeker");
        }
        seekBar3.setSecondaryProgress(max);
        ProgressBar progressBar2 = this.r;
        if (progressBar2 == null) {
            k.a("mBottomProgressBar");
        }
        progressBar2.setSecondaryProgress(max);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        k.c(mediaPlayer, "mediaPlayer");
        b.a("Video size changed: %dx%d", Integer.valueOf(i2), Integer.valueOf(i3));
        a(this.y, this.z, i2, i3);
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        k.c(mediaPlayer, "mediaPlayer");
        if (i2 == -38) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Preparation/playback error (" + i2 + "): ");
        sb.append(i2 != -1010 ? i2 != -1007 ? i2 != -1004 ? i2 != -110 ? i2 != 100 ? i2 != 200 ? "Unknown error" : "Not valid for progressive playback" : "Server died" : "Timed out" : "I/O error" : "Malformed" : "Unsupported");
        a(new Exception(sb.toString()));
        return false;
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        super.onFinishInflate();
        setKeepScreenOn(true);
        this.f17126a = new Handler();
        this.f17130f = new MediaPlayer();
        MediaPlayer mediaPlayer = this.f17130f;
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(this);
        }
        MediaPlayer mediaPlayer2 = this.f17130f;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setOnBufferingUpdateListener(this);
        }
        MediaPlayer mediaPlayer3 = this.f17130f;
        if (mediaPlayer3 != null) {
            mediaPlayer3.setOnCompletionListener(this);
        }
        MediaPlayer mediaPlayer4 = this.f17130f;
        if (mediaPlayer4 != null) {
            mediaPlayer4.setOnVideoSizeChangedListener(this);
        }
        MediaPlayer mediaPlayer5 = this.f17130f;
        if (mediaPlayer5 != null) {
            mediaPlayer5.setOnErrorListener(this);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            MediaPlayer mediaPlayer6 = this.f17130f;
            if (mediaPlayer6 != null) {
                mediaPlayer6.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).setLegacyStreamType(3).build());
            }
        } else {
            MediaPlayer mediaPlayer7 = this.f17130f;
            if (mediaPlayer7 != null) {
                mediaPlayer7.setAudioStreamType(3);
            }
        }
        Object systemService = getContext().getSystemService(H5ResourceHandlerUtil.AUDIO);
        if (systemService != null) {
            this.f17131g = (AudioManager) systemService;
            LayoutInflater from = LayoutInflater.from(getContext());
            ViewGroup viewGroup = this;
            View inflate = from.inflate(R.layout.ph5_include_surface, viewGroup, false);
            addView(inflate);
            View findViewById = inflate.findViewById(R.id.textureview);
            k.a((Object) findViewById, "mTextureFrame.findViewById(R.id.textureview)");
            this.p = (TextureView) findViewById;
            TextureView textureView = this.p;
            if (textureView == null) {
                k.a("mTextureView");
            }
            textureView.setSurfaceTextureListener(this);
            View inflate2 = from.inflate(R.layout.ph5_include_progress, viewGroup, false);
            k.a((Object) inflate2, "li.inflate(R.layout.ph5_…de_progress, this, false)");
            this.j = inflate2;
            View view = this.j;
            if (view == null) {
                k.a("mProgressFrame");
            }
            View findViewById2 = view.findViewById(R.id.material_progress_bar);
            k.a((Object) findViewById2, "mProgressFrame.findViewB…id.material_progress_bar)");
            this.n = (ProgressBar) findViewById2;
            View view2 = this.j;
            if (view2 == null) {
                k.a("mProgressFrame");
            }
            View findViewById3 = view2.findViewById(R.id.progressBarBottom);
            k.a((Object) findViewById3, "mProgressFrame.findViewB…d(R.id.progressBarBottom)");
            this.r = (ProgressBar) findViewById3;
            View view3 = this.j;
            if (view3 == null) {
                k.a("mProgressFrame");
            }
            View findViewById4 = view3.findViewById(R.id.position_textview);
            k.a((Object) findViewById4, "mProgressFrame.findViewB…d(R.id.position_textview)");
            this.o = (TextView) findViewById4;
            TextView textView = this.o;
            if (textView == null) {
                k.a("mPositionTextView");
            }
            textView.setShadowLayer(3.0f, 3.0f, 3.0f, -16777216);
            View view4 = this.j;
            if (view4 == null) {
                k.a("mProgressFrame");
            }
            addView(view4);
            this.k = new FrameLayout(getContext());
            try {
                View view5 = this.k;
                if (view5 == null) {
                    k.a("mClickFrame");
                }
                if (view5 != null) {
                    net.one97.paytm.h5paytmsdk.d.g gVar = net.one97.paytm.h5paytmsdk.d.g.f17102a;
                    Context context = getContext();
                    k.a((Object) context, "context");
                    int i2 = R.attr.selectableItemBackground;
                    k.c(context, "context");
                    ((FrameLayout) view5).setForeground(net.one97.paytm.h5paytmsdk.d.g.a(context, i2));
                    View view6 = this.k;
                    if (view6 == null) {
                        k.a("mClickFrame");
                    }
                    addView(view6, new ViewGroup.LayoutParams(-1, -1));
                    View inflate3 = from.inflate(R.layout.ph5_include_controls, viewGroup, false);
                    k.a((Object) inflate3, "li.inflate(R.layout.ph5_…de_controls, this, false)");
                    this.f17133i = inflate3;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    View view7 = this.f17133i;
                    if (view7 == null) {
                        k.a("mControlsFrame");
                    }
                    addView(view7, layoutParams);
                    View inflate4 = from.inflate(R.layout.ph5_include_topbar, viewGroup, false);
                    k.a((Object) inflate4, "li.inflate(R.layout.ph5_…lude_topbar, this, false)");
                    this.l = inflate4;
                    View view8 = this.l;
                    if (view8 == null) {
                        k.a("mToolbarFrame");
                    }
                    View findViewById5 = view8.findViewById(R.id.toolbar);
                    k.a((Object) findViewById5, "mToolbarFrame.findViewById(R.id.toolbar)");
                    this.m = (Toolbar) findViewById5;
                    Toolbar toolbar = this.m;
                    if (toolbar == null) {
                        k.a("mToolbar");
                    }
                    toolbar.setTitle((CharSequence) this.H);
                    View view9 = this.l;
                    if (view9 == null) {
                        k.a("mToolbarFrame");
                    }
                    view9.setVisibility(this.M ? 0 : 8);
                    View view10 = this.l;
                    if (view10 == null) {
                        k.a("mToolbarFrame");
                    }
                    addView(view10);
                    View view11 = this.f17133i;
                    if (view11 == null) {
                        k.a("mControlsFrame");
                    }
                    View findViewById6 = view11.findViewById(R.id.seeker);
                    k.a((Object) findViewById6, "mControlsFrame.findViewById(R.id.seeker)");
                    this.q = (SeekBar) findViewById6;
                    SeekBar seekBar = this.q;
                    if (seekBar == null) {
                        k.a("mSeeker");
                    }
                    seekBar.setOnSeekBarChangeListener(this);
                    View view12 = this.f17133i;
                    if (view12 == null) {
                        k.a("mControlsFrame");
                    }
                    View findViewById7 = view12.findViewById(R.id.position);
                    k.a((Object) findViewById7, "mControlsFrame.findViewById(R.id.position)");
                    this.s = (TextView) findViewById7;
                    TextView textView2 = this.s;
                    if (textView2 == null) {
                        k.a("mLabelPosition");
                    }
                    net.one97.paytm.h5paytmsdk.d.g gVar2 = net.one97.paytm.h5paytmsdk.d.g.f17102a;
                    textView2.setText(net.one97.paytm.h5paytmsdk.d.g.a(0, false));
                    View view13 = this.f17133i;
                    if (view13 == null) {
                        k.a("mControlsFrame");
                    }
                    View findViewById8 = view13.findViewById(R.id.duration);
                    k.a((Object) findViewById8, "mControlsFrame.findViewById(R.id.duration)");
                    this.t = (TextView) findViewById8;
                    TextView textView3 = this.t;
                    if (textView3 == null) {
                        k.a("mLabelDuration");
                    }
                    net.one97.paytm.h5paytmsdk.d.g gVar3 = net.one97.paytm.h5paytmsdk.d.g.f17102a;
                    textView3.setText(net.one97.paytm.h5paytmsdk.d.g.a(0, true));
                    TextView textView4 = this.t;
                    if (textView4 == null) {
                        k.a("mLabelDuration");
                    }
                    View.OnClickListener onClickListener = this;
                    textView4.setOnClickListener(onClickListener);
                    View view14 = this.f17133i;
                    if (view14 == null) {
                        k.a("mControlsFrame");
                    }
                    View findViewById9 = view14.findViewById(R.id.btnPlayPause);
                    k.a((Object) findViewById9, "mControlsFrame.findViewById(R.id.btnPlayPause)");
                    this.u = (ImageButton) findViewById9;
                    ImageButton imageButton = this.u;
                    if (imageButton == null) {
                        k.a("mBtnPlayPause");
                    }
                    imageButton.setOnClickListener(onClickListener);
                    ImageButton imageButton2 = this.u;
                    if (imageButton2 == null) {
                        k.a("mBtnPlayPause");
                    }
                    imageButton2.setImageDrawable(this.E);
                    if (this.f17127b) {
                        this.f17127b = true;
                        View view15 = this.f17133i;
                        if (view15 == null) {
                            k.a("mControlsFrame");
                        }
                        view15.setVisibility(8);
                        View view16 = this.l;
                        if (view16 == null) {
                            k.a("mToolbarFrame");
                        }
                        view16.setVisibility(8);
                        View view17 = this.k;
                        if (view17 == null) {
                            k.a("mClickFrame");
                        }
                        view17.setOnTouchListener((View.OnTouchListener) null);
                        View view18 = this.k;
                        if (view18 == null) {
                            k.a("mClickFrame");
                        }
                        view18.setClickable(false);
                    } else {
                        this.f17127b = false;
                        View view19 = this.k;
                        if (view19 == null) {
                            k.a("mClickFrame");
                        }
                        view19.setClickable(true);
                        GestureDetector gestureDetector = new GestureDetector(getContext(), new d(this));
                        View view20 = this.k;
                        if (view20 == null) {
                            k.a("mClickFrame");
                        }
                        view20.setOnTouchListener(new c(gestureDetector));
                    }
                    setBottomProgressBarVisibility(this.L);
                    setControlsEnabled(false);
                    d();
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            throw new u("null cannot be cast to non-null type android.media.AudioManager");
        }
    }

    public final void onClick(View view) {
        Handler handler;
        k.c(view, "view");
        if (view.getId() == R.id.btnPlayPause) {
            MediaPlayer mediaPlayer = this.f17130f;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                if (this.J && !this.f17127b && (handler = this.f17126a) != null) {
                    handler.postDelayed(this.f17128c, 500);
                }
                g();
                return;
            }
            MediaPlayer mediaPlayer2 = this.f17130f;
            if (mediaPlayer2 != null && f()) {
                mediaPlayer2.pause();
                a aVar = this.C;
                if (aVar != null) {
                    aVar.b(this);
                }
                Handler handler2 = this.f17126a;
                if (handler2 != null) {
                    handler2.removeCallbacks(this.f17128c);
                }
                Handler handler3 = this.f17126a;
                if (handler3 != null) {
                    handler3.removeCallbacks(this.P);
                }
                ImageButton imageButton = this.u;
                if (imageButton == null) {
                    k.a("mBtnPlayPause");
                }
                imageButton.setImageDrawable(this.E);
            }
        } else if (view.getId() == R.id.duration) {
            this.K = !this.K;
        }
    }

    public final void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        k.c(seekBar, "seekBar");
        if (z2) {
            a(i2);
            TextView textView = this.o;
            if (textView == null) {
                k.a("mPositionTextView");
            }
            net.one97.paytm.h5paytmsdk.d.g gVar = net.one97.paytm.h5paytmsdk.d.g.f17102a;
            textView.setText(net.one97.paytm.h5paytmsdk.d.g.a((long) i2, false));
        }
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
        MediaPlayer mediaPlayer;
        k.c(seekBar, "seekBar");
        this.x = f();
        if (this.x && (mediaPlayer = this.f17130f) != null) {
            mediaPlayer.pause();
        }
        TextView textView = this.o;
        if (textView == null) {
            k.a("mPositionTextView");
        }
        textView.setVisibility(0);
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        MediaPlayer mediaPlayer;
        k.c(seekBar, "seekBar");
        if (this.x && (mediaPlayer = this.f17130f) != null) {
            mediaPlayer.start();
        }
        TextView textView = this.o;
        if (textView == null) {
            k.a("mPositionTextView");
        }
        textView.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.a("Attached to window", new Object[0]);
        if (this.f17130f != null) {
            b.a("mPlayer not null on attach", new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b.a("Detached from window", new Object[0]);
        this.w = false;
        try {
            MediaPlayer mediaPlayer = this.f17130f;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Throwable unused) {
        }
        this.f17130f = null;
        Handler handler = this.f17126a;
        if (handler != null) {
            handler.removeCallbacks(this.P);
        }
        this.f17126a = null;
        b.a("Released player and Handler", new Object[0]);
        Handler handler2 = this.f17126a;
        if (handler2 != null) {
            handler2.removeCallbacks(this.P);
        }
        this.f17126a = null;
    }

    private final void a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        double d2 = ((double) i5) / ((double) i4);
        int i8 = (int) (((double) i2) * d2);
        if (i3 > i8) {
            i6 = i8;
            i7 = i2;
        } else {
            i7 = (int) (((double) i3) / d2);
            i6 = i3;
        }
        int i9 = (i2 - i7) / 2;
        int i10 = (i3 - i6) / 2;
        Matrix matrix = new Matrix();
        TextureView textureView = this.p;
        if (textureView == null) {
            k.a("mTextureView");
        }
        textureView.getTransform(matrix);
        matrix.setScale(((float) i7) / ((float) i2), ((float) i6) / ((float) i3));
        matrix.postTranslate((float) i9, (float) i10);
        TextureView textureView2 = this.p;
        if (textureView2 == null) {
            k.a("mTextureView");
        }
        textureView2.setTransform(matrix);
    }

    private final void a(Exception exc) {
        a aVar = this.C;
        if (aVar == null) {
            throw new RuntimeException(exc);
        } else if (aVar != null) {
            aVar.a(this, exc);
        }
    }

    public final void setLoop(boolean z2) {
        this.I = z2;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        static void a(String str, Object... objArr) {
            aa aaVar = aa.f47921a;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            k.a((Object) String.format(str, Arrays.copyOf(copyOf, copyOf.length)), "java.lang.String.format(format, *args)");
            com.alipay.iap.android.common.b.c.e();
        }
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        k.c(surfaceTexture, "surfaceTexture");
        b.a("Surface texture destroyed", new Object[0]);
        this.v = false;
        this.f17132h = null;
        return false;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler;
        k.c(mediaPlayer, "mediaPlayer");
        b.a("onPrepared()", new Object[0]);
        ProgressBar progressBar = this.n;
        if (progressBar == null) {
            k.a("mProgressBar");
        }
        progressBar.setVisibility(4);
        a();
        this.w = true;
        a aVar = this.C;
        if (!(aVar == null || aVar == null)) {
            aVar.d(this);
        }
        TextView textView = this.s;
        if (textView == null) {
            k.a("mLabelPosition");
        }
        net.one97.paytm.h5paytmsdk.d.g gVar = net.one97.paytm.h5paytmsdk.d.g.f17102a;
        textView.setText(net.one97.paytm.h5paytmsdk.d.g.a(0, false));
        TextView textView2 = this.t;
        if (textView2 == null) {
            k.a("mLabelDuration");
        }
        net.one97.paytm.h5paytmsdk.d.g gVar2 = net.one97.paytm.h5paytmsdk.d.g.f17102a;
        textView2.setText(net.one97.paytm.h5paytmsdk.d.g.a((long) mediaPlayer.getDuration(), false));
        SeekBar seekBar = this.q;
        if (seekBar == null) {
            k.a("mSeeker");
        }
        seekBar.setProgress(0);
        SeekBar seekBar2 = this.q;
        if (seekBar2 == null) {
            k.a("mSeeker");
        }
        seekBar2.setMax(mediaPlayer.getDuration());
        setControlsEnabled(true);
        if (this.N) {
            if (!this.f17127b && this.J && (handler = this.f17126a) != null) {
                handler.postDelayed(this.f17128c, 500);
            }
            g();
            int i2 = this.O;
            if (i2 > 0) {
                a(i2);
                this.O = -1;
                return;
            }
            return;
        }
        MediaPlayer mediaPlayer2 = this.f17130f;
        if (mediaPlayer2 != null) {
            mediaPlayer2.start();
        }
        MediaPlayer mediaPlayer3 = this.f17130f;
        if (mediaPlayer3 != null) {
            mediaPlayer3.pause();
        }
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        k.c(mediaPlayer, "mediaPlayer");
        b.a("onCompletion()", new Object[0]);
        ImageButton imageButton = this.u;
        if (imageButton == null) {
            k.a("mBtnPlayPause");
        }
        imageButton.setImageDrawable(this.G);
        Handler handler = this.f17126a;
        if (handler != null) {
            handler.removeCallbacks(this.P);
        }
        SeekBar seekBar = this.q;
        if (seekBar == null) {
            k.a("mSeeker");
        }
        int max = seekBar.getMax();
        SeekBar seekBar2 = this.q;
        if (seekBar2 == null) {
            k.a("mSeeker");
        }
        seekBar2.setProgress(max);
        ProgressBar progressBar = this.r;
        if (progressBar == null) {
            k.a("mBottomProgressBar");
        }
        progressBar.setProgress(max);
        if (!this.I) {
            a();
        } else {
            g();
        }
        a aVar = this.C;
        if (aVar != null) {
            aVar.e(this);
        }
    }
}

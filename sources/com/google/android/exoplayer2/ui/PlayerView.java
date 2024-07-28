package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.e.k;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.trackselection.f;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.spherical.SphericalSurfaceView;
import com.google.android.exoplayer2.ui.spherical.e;
import com.google.android.exoplayer2.video.g;
import com.google.android.exoplayer2.y;
import com.google.android.exoplayer2.z;
import java.util.ArrayList;
import java.util.List;

public class PlayerView extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final AspectRatioFrameLayout f33551a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final View f33552b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final View f33553c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f33554d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final SubtitleView f33555e;

    /* renamed from: f  reason: collision with root package name */
    private final View f33556f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f33557g;

    /* renamed from: h  reason: collision with root package name */
    private final PlayerControlView f33558h;

    /* renamed from: i  reason: collision with root package name */
    private final a f33559i;
    private final FrameLayout j;
    private final FrameLayout k;
    private z l;
    private boolean m;
    private boolean n;
    private Drawable o;
    private int p;
    private boolean q;
    private g<? super i> r;
    private CharSequence s;
    private int t;
    private boolean u;
    /* access modifiers changed from: private */
    public boolean v;
    private boolean w;
    /* access modifiers changed from: private */
    public int x;
    private boolean y;

    public PlayerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        boolean z;
        int i3;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        boolean z5;
        int i7;
        int i8;
        boolean z6;
        boolean z7;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        if (isInEditMode()) {
            this.f33551a = null;
            this.f33552b = null;
            this.f33553c = null;
            this.f33554d = null;
            this.f33555e = null;
            this.f33556f = null;
            this.f33557g = null;
            this.f33558h = null;
            this.f33559i = null;
            this.j = null;
            this.k = null;
            ImageView imageView = new ImageView(context2);
            if (ae.f32499a >= 23) {
                Resources resources = getResources();
                imageView.setImageDrawable(resources.getDrawable(R.drawable.exo_edit_mode_logo, (Resources.Theme) null));
                imageView.setBackgroundColor(resources.getColor(R.color.exo_edit_mode_background_color, (Resources.Theme) null));
            } else {
                Resources resources2 = getResources();
                imageView.setImageDrawable(resources2.getDrawable(R.drawable.exo_edit_mode_logo));
                imageView.setBackgroundColor(resources2.getColor(R.color.exo_edit_mode_background_color));
            }
            addView(imageView);
            return;
        }
        int i9 = R.layout.exo_player_view;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.PlayerView, 0, 0);
            try {
                z4 = obtainStyledAttributes.hasValue(R.styleable.PlayerView_shutter_background_color);
                i6 = obtainStyledAttributes.getColor(R.styleable.PlayerView_shutter_background_color, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.PlayerView_player_layout_id, i9);
                z3 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_use_artwork, true);
                i5 = obtainStyledAttributes.getResourceId(R.styleable.PlayerView_default_artwork, 0);
                boolean z8 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_use_controller, true);
                i4 = obtainStyledAttributes.getInt(R.styleable.PlayerView_surface_type, 1);
                i3 = obtainStyledAttributes.getInt(R.styleable.PlayerView_resize_mode, 0);
                int i10 = obtainStyledAttributes.getInt(R.styleable.PlayerView_show_timeout, 5000);
                boolean z9 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_hide_on_touch, true);
                boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_auto_show, true);
                int i11 = resourceId;
                i8 = obtainStyledAttributes.getInteger(R.styleable.PlayerView_show_buffering, 0);
                boolean z11 = z9;
                this.q = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_keep_content_on_player_reset, this.q);
                boolean z12 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_hide_during_ads, true);
                obtainStyledAttributes.recycle();
                z5 = z10;
                z = z8;
                z2 = z12;
                i7 = i10;
                i9 = i11;
                z6 = z11;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z6 = true;
            i8 = 0;
            i7 = 5000;
            z5 = true;
            z4 = false;
            i6 = 0;
            z3 = true;
            i5 = 0;
            z2 = true;
            i4 = 1;
            i3 = 0;
            z = true;
        }
        LayoutInflater.from(context).inflate(i9, this);
        this.f33559i = new a(this, (byte) 0);
        setDescendantFocusability(262144);
        this.f33551a = (AspectRatioFrameLayout) findViewById(R.id.exo_content_frame);
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f33551a;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i3);
        }
        this.f33552b = findViewById(R.id.exo_shutter);
        View view = this.f33552b;
        if (view != null && z4) {
            view.setBackgroundColor(i6);
        }
        if (this.f33551a == null || i4 == 0) {
            this.f33553c = null;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i4 == 2) {
                this.f33553c = new TextureView(context2);
            } else if (i4 != 3) {
                this.f33553c = new SurfaceView(context2);
            } else {
                SphericalSurfaceView sphericalSurfaceView = new SphericalSurfaceView(context2);
                sphericalSurfaceView.setSingleTapListener(this.f33559i);
                this.f33553c = sphericalSurfaceView;
            }
            this.f33553c.setLayoutParams(layoutParams);
            this.f33551a.addView(this.f33553c, 0);
        }
        this.j = (FrameLayout) findViewById(R.id.exo_ad_overlay);
        this.k = (FrameLayout) findViewById(R.id.exo_overlay);
        this.f33554d = (ImageView) findViewById(R.id.exo_artwork);
        this.n = z3 && this.f33554d != null;
        if (i5 != 0) {
            this.o = b.a(getContext(), i5);
        }
        this.f33555e = (SubtitleView) findViewById(R.id.exo_subtitles);
        SubtitleView subtitleView = this.f33555e;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            this.f33555e.setUserDefaultTextSize();
        }
        this.f33556f = findViewById(R.id.exo_buffering);
        View view2 = this.f33556f;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        this.p = i8;
        this.f33557g = (TextView) findViewById(R.id.exo_error_message);
        TextView textView = this.f33557g;
        if (textView != null) {
            textView.setVisibility(8);
        }
        PlayerControlView playerControlView = (PlayerControlView) findViewById(R.id.exo_controller);
        View findViewById = findViewById(R.id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.f33558h = playerControlView;
            z7 = false;
        } else if (findViewById != null) {
            z7 = false;
            this.f33558h = new PlayerControlView(context2, (AttributeSet) null, 0, attributeSet2);
            this.f33558h.setId(R.id.exo_controller);
            this.f33558h.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(this.f33558h, indexOfChild);
        } else {
            z7 = false;
            this.f33558h = null;
        }
        this.t = this.f33558h == null ? 0 : i7;
        this.w = z6;
        this.u = z5;
        this.v = z2;
        if (z && this.f33558h != null) {
            z7 = true;
        }
        this.m = z7;
        a();
    }

    public z getPlayer() {
        return this.l;
    }

    public void setPlayer(z zVar) {
        com.google.android.exoplayer2.g.a.b(Looper.myLooper() == Looper.getMainLooper());
        com.google.android.exoplayer2.g.a.a(zVar == null || zVar.j() == Looper.getMainLooper());
        z zVar2 = this.l;
        if (zVar2 != zVar) {
            if (zVar2 != null) {
                zVar2.b((z.a) this.f33559i);
                z.c h2 = this.l.h();
                if (h2 != null) {
                    h2.b((com.google.android.exoplayer2.video.g) this.f33559i);
                    View view = this.f33553c;
                    if (view instanceof TextureView) {
                        h2.b((TextureView) view);
                    } else if (view instanceof SphericalSurfaceView) {
                        ((SphericalSurfaceView) view).setVideoComponent((z.c) null);
                    } else if (view instanceof SurfaceView) {
                        h2.b((SurfaceView) view);
                    }
                }
                z.b i2 = this.l.i();
                if (i2 != null) {
                    i2.b(this.f33559i);
                }
            }
            this.l = zVar;
            if (this.m) {
                this.f33558h.setPlayer(zVar);
            }
            SubtitleView subtitleView = this.f33555e;
            if (subtitleView != null) {
                subtitleView.setCues((List<com.google.android.exoplayer2.e.b>) null);
            }
            g();
            h();
            c(true);
            if (zVar != null) {
                z.c h3 = zVar.h();
                if (h3 != null) {
                    View view2 = this.f33553c;
                    if (view2 instanceof TextureView) {
                        h3.a((TextureView) view2);
                    } else if (view2 instanceof SphericalSurfaceView) {
                        ((SphericalSurfaceView) view2).setVideoComponent(h3);
                    } else if (view2 instanceof SurfaceView) {
                        h3.a((SurfaceView) view2);
                    }
                    h3.a((com.google.android.exoplayer2.video.g) this.f33559i);
                }
                z.b i3 = zVar.i();
                if (i3 != null) {
                    i3.a(this.f33559i);
                }
                zVar.a((z.a) this.f33559i);
                a(false);
                return;
            }
            a();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        View view = this.f33553c;
        if (view instanceof SurfaceView) {
            view.setVisibility(i2);
        }
    }

    public void setResizeMode(int i2) {
        com.google.android.exoplayer2.g.a.b(this.f33551a != null);
        this.f33551a.setResizeMode(i2);
    }

    public int getResizeMode() {
        com.google.android.exoplayer2.g.a.b(this.f33551a != null);
        return this.f33551a.getResizeMode();
    }

    public boolean getUseArtwork() {
        return this.n;
    }

    public void setUseArtwork(boolean z) {
        com.google.android.exoplayer2.g.a.b(!z || this.f33554d != null);
        if (this.n != z) {
            this.n = z;
            c(false);
        }
    }

    public Drawable getDefaultArtwork() {
        return this.o;
    }

    @Deprecated
    public void setDefaultArtwork(Bitmap bitmap) {
        BitmapDrawable bitmapDrawable;
        if (bitmap == null) {
            bitmapDrawable = null;
        } else {
            bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        }
        setDefaultArtwork((Drawable) bitmapDrawable);
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.o != drawable) {
            this.o = drawable;
            c(false);
        }
    }

    public boolean getUseController() {
        return this.m;
    }

    public void setUseController(boolean z) {
        com.google.android.exoplayer2.g.a.b(!z || this.f33558h != null);
        if (this.m != z) {
            this.m = z;
            if (z) {
                this.f33558h.setPlayer(this.l);
                return;
            }
            PlayerControlView playerControlView = this.f33558h;
            if (playerControlView != null) {
                playerControlView.b();
                this.f33558h.setPlayer((z) null);
            }
        }
    }

    public void setShutterBackgroundColor(int i2) {
        View view = this.f33552b;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.q != z) {
            this.q = z;
            c(false);
        }
    }

    @Deprecated
    public void setShowBuffering(boolean z) {
        setShowBuffering(z ? 1 : 0);
    }

    public void setShowBuffering(int i2) {
        if (this.p != i2) {
            this.p = i2;
            g();
        }
    }

    public void setErrorMessageProvider(g<? super i> gVar) {
        if (this.r != gVar) {
            this.r = gVar;
            h();
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        com.google.android.exoplayer2.g.a.b(this.f33557g != null);
        this.s = charSequence;
        h();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        z zVar = this.l;
        if (zVar != null && zVar.w()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        boolean z = (keyCode == 19 || keyCode == 270 || keyCode == 22 || keyCode == 271 || keyCode == 20 || keyCode == 269 || keyCode == 21 || keyCode == 268 || keyCode == 23) && this.m;
        if (!z || this.f33558h.c()) {
            if ((this.m && this.f33558h.a(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
                a(true);
                return true;
            }
            if (z) {
                a(true);
            }
            return false;
        }
        a(true);
        return true;
    }

    public final void a() {
        PlayerControlView playerControlView = this.f33558h;
        if (playerControlView != null) {
            playerControlView.b();
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.t;
    }

    public void setControllerShowTimeoutMs(int i2) {
        com.google.android.exoplayer2.g.a.b(this.f33558h != null);
        this.t = i2;
        if (this.f33558h.c()) {
            b(c());
        }
    }

    public boolean getControllerHideOnTouch() {
        return this.w;
    }

    public void setControllerHideOnTouch(boolean z) {
        com.google.android.exoplayer2.g.a.b(this.f33558h != null);
        this.w = z;
    }

    public boolean getControllerAutoShow() {
        return this.u;
    }

    public void setControllerAutoShow(boolean z) {
        this.u = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.v = z;
    }

    public void setControllerVisibilityListener(PlayerControlView.c cVar) {
        com.google.android.exoplayer2.g.a.b(this.f33558h != null);
        this.f33558h.setVisibilityListener(cVar);
    }

    public void setPlaybackPreparer(y yVar) {
        com.google.android.exoplayer2.g.a.b(this.f33558h != null);
        this.f33558h.setPlaybackPreparer(yVar);
    }

    public void setControlDispatcher(d dVar) {
        com.google.android.exoplayer2.g.a.b(this.f33558h != null);
        this.f33558h.setControlDispatcher(dVar);
    }

    public void setRewindIncrementMs(int i2) {
        com.google.android.exoplayer2.g.a.b(this.f33558h != null);
        this.f33558h.setRewindIncrementMs(i2);
    }

    public void setFastForwardIncrementMs(int i2) {
        com.google.android.exoplayer2.g.a.b(this.f33558h != null);
        this.f33558h.setFastForwardIncrementMs(i2);
    }

    public void setRepeatToggleModes(int i2) {
        com.google.android.exoplayer2.g.a.b(this.f33558h != null);
        this.f33558h.setRepeatToggleModes(i2);
    }

    public void setShowShuffleButton(boolean z) {
        com.google.android.exoplayer2.g.a.b(this.f33558h != null);
        this.f33558h.setShowShuffleButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        com.google.android.exoplayer2.g.a.b(this.f33558h != null);
        this.f33558h.setShowMultiWindowTimeBar(z);
    }

    public void setExtraAdGroupMarkers(long[] jArr, boolean[] zArr) {
        com.google.android.exoplayer2.g.a.b(this.f33558h != null);
        this.f33558h.setExtraAdGroupMarkers(jArr, zArr);
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.a aVar) {
        com.google.android.exoplayer2.g.a.b(this.f33551a != null);
        this.f33551a.setAspectRatioListener(aVar);
    }

    public View getVideoSurfaceView() {
        return this.f33553c;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.k;
    }

    public SubtitleView getSubtitleView() {
        return this.f33555e;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.m || this.l == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.y = true;
            return true;
        } else if (action != 1 || !this.y) {
            return false;
        } else {
            this.y = false;
            performClick();
            return true;
        }
    }

    public boolean performClick() {
        super.performClick();
        return b();
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.m || this.l == null) {
            return false;
        }
        a(true);
        return true;
    }

    protected static void a(float f2, AspectRatioFrameLayout aspectRatioFrameLayout, View view) {
        if (aspectRatioFrameLayout != null) {
            if (view instanceof SphericalSurfaceView) {
                f2 = 0.0f;
            }
            aspectRatioFrameLayout.setAspectRatio(f2);
        }
    }

    public ViewGroup getAdViewGroup() {
        FrameLayout frameLayout = this.j;
        if (frameLayout != null) {
            return frameLayout;
        }
        throw new NullPointerException("exo_ad_overlay must be present for ad playback");
    }

    public View[] getAdOverlayViews() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            arrayList.add(frameLayout);
        }
        PlayerControlView playerControlView = this.f33558h;
        if (playerControlView != null) {
            arrayList.add(playerControlView);
        }
        return (View[]) arrayList.toArray(new View[0]);
    }

    /* access modifiers changed from: private */
    public boolean b() {
        if (!this.m || this.l == null) {
            return false;
        }
        if (!this.f33558h.c()) {
            a(true);
        } else if (this.w) {
            this.f33558h.b();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if ((!d() || !this.v) && this.m) {
            boolean z2 = this.f33558h.c() && this.f33558h.getShowTimeoutMs() <= 0;
            boolean c2 = c();
            if (z || z2 || c2) {
                b(c2);
            }
        }
    }

    private boolean c() {
        z zVar = this.l;
        if (zVar == null) {
            return true;
        }
        int k2 = zVar.k();
        if (!this.u) {
            return false;
        }
        if (k2 == 1 || k2 == 4 || !this.l.n()) {
            return true;
        }
        return false;
    }

    private void b(boolean z) {
        if (this.m) {
            this.f33558h.setShowTimeoutMs(z ? 0 : this.t);
            this.f33558h.a();
        }
    }

    /* access modifiers changed from: private */
    public boolean d() {
        z zVar = this.l;
        return zVar != null && zVar.w() && this.l.n();
    }

    /* access modifiers changed from: private */
    public void c(boolean z) {
        z zVar = this.l;
        if (zVar != null && !zVar.B().a()) {
            if (z && !this.q) {
                f();
            }
            com.google.android.exoplayer2.trackselection.g C = this.l.C();
            int i2 = 0;
            while (i2 < C.f33504a) {
                if (this.l.b(i2) != 2 || C.f33505b[i2] == null) {
                    i2++;
                } else {
                    e();
                    return;
                }
            }
            f();
            if (this.n) {
                for (int i3 = 0; i3 < C.f33504a; i3++) {
                    f fVar = C.f33505b[i3];
                    if (fVar != null) {
                        int i4 = 0;
                        while (i4 < fVar.f()) {
                            Metadata metadata = fVar.a(i4).f31067g;
                            if (metadata == null || !a(metadata)) {
                                i4++;
                            } else {
                                return;
                            }
                        }
                        continue;
                    }
                }
                if (a(this.o)) {
                    return;
                }
            }
            e();
        } else if (!this.q) {
            e();
            f();
        }
    }

    private boolean a(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                a(((float) intrinsicWidth) / ((float) intrinsicHeight), this.f33551a, this.f33554d);
                this.f33554d.setImageDrawable(drawable);
                this.f33554d.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private void e() {
        ImageView imageView = this.f33554d;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.f33554d.setVisibility(4);
        }
    }

    private void f() {
        View view = this.f33552b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        int i2;
        if (this.f33556f != null) {
            z zVar = this.l;
            boolean z = true;
            int i3 = 0;
            if (zVar == null || zVar.k() != 2 || ((i2 = this.p) != 2 && (i2 != 1 || !this.l.n()))) {
                z = false;
            }
            View view = this.f33556f;
            if (!z) {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        TextView textView = this.f33557g;
        if (textView != null) {
            CharSequence charSequence = this.s;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f33557g.setVisibility(0);
                return;
            }
            i iVar = null;
            z zVar = this.l;
            if (!(zVar == null || zVar.k() != 1 || this.r == null)) {
                iVar = this.l.m();
            }
            if (iVar != null) {
                this.f33557g.setText((CharSequence) this.r.a().second);
                this.f33557g.setVisibility(0);
                return;
            }
            this.f33557g.setVisibility(8);
        }
    }

    final class a implements View.OnLayoutChangeListener, k, e, com.google.android.exoplayer2.video.g, z.a {
        public /* synthetic */ void a(ah ahVar) {
            z.a.CC.$default$a((z.a) this, ahVar);
        }

        public /* synthetic */ void a(i iVar) {
            z.a.CC.$default$a((z.a) this, iVar);
        }

        public /* synthetic */ void a(boolean z) {
            z.a.CC.$default$a((z.a) this, z);
        }

        public /* synthetic */ void b() {
            z.a.CC.$default$b(this);
        }

        public /* synthetic */ void b(boolean z) {
            z.a.CC.$default$b(this, z);
        }

        public /* synthetic */ void c() {
            z.a.CC.$default$c(this);
        }

        public /* synthetic */ void e() {
            z.a.CC.$default$e(this);
        }

        public /* synthetic */ void f() {
            z.a.CC.$default$f(this);
        }

        public /* synthetic */ void j() {
            g.CC.$default$j(this);
        }

        private a() {
        }

        /* synthetic */ a(PlayerView playerView, byte b2) {
            this();
        }

        public final void a(List<com.google.android.exoplayer2.e.b> list) {
            if (PlayerView.this.f33555e != null) {
                PlayerView.this.f33555e.setCues(list);
            }
        }

        public final void a(int i2, int i3, int i4, float f2) {
            float f3 = (i3 == 0 || i2 == 0) ? 1.0f : (((float) i2) * f2) / ((float) i3);
            if (PlayerView.this.f33553c instanceof TextureView) {
                if (i4 == 90 || i4 == 270) {
                    f3 = 1.0f / f3;
                }
                if (PlayerView.this.x != 0) {
                    PlayerView.this.f33553c.removeOnLayoutChangeListener(this);
                }
                int unused = PlayerView.this.x = i4;
                if (PlayerView.this.x != 0) {
                    PlayerView.this.f33553c.addOnLayoutChangeListener(this);
                }
                PlayerView.a((TextureView) PlayerView.this.f33553c, PlayerView.this.x);
            }
            PlayerView.a(f3, PlayerView.this.f33551a, PlayerView.this.f33553c);
        }

        public final void i() {
            if (PlayerView.this.f33552b != null) {
                PlayerView.this.f33552b.setVisibility(4);
            }
        }

        public final void a() {
            PlayerView.this.c(false);
        }

        public final void a(int i2) {
            PlayerView.this.g();
            PlayerView.this.h();
            if (!PlayerView.this.d() || !PlayerView.this.v) {
                PlayerView.this.a(false);
            } else {
                PlayerView.this.a();
            }
        }

        public final void d() {
            if (PlayerView.this.d() && PlayerView.this.v) {
                PlayerView.this.a();
            }
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            PlayerView.a((TextureView) view, PlayerView.this.x);
        }

        public final boolean g() {
            return PlayerView.this.b();
        }
    }

    private boolean a(Metadata metadata) {
        byte[] bArr;
        int i2;
        int i3 = 0;
        int i4 = -1;
        boolean z = false;
        while (i3 < metadata.f32644a.length) {
            Metadata.Entry entry = metadata.f32644a[i3];
            if (entry instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) entry;
                bArr = apicFrame.f32682d;
                i2 = apicFrame.f32681c;
            } else if (entry instanceof PictureFrame) {
                PictureFrame pictureFrame = (PictureFrame) entry;
                bArr = pictureFrame.f32667h;
                i2 = pictureFrame.f32660a;
            } else {
                continue;
                i3++;
            }
            if (i4 == -1 || i2 == 3) {
                z = a((Drawable) new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
                if (i2 == 3) {
                    break;
                }
                i4 = i2;
                i3++;
            } else {
                i3++;
            }
        }
        return z;
    }

    static /* synthetic */ void a(TextureView textureView, int i2) {
        float width = (float) textureView.getWidth();
        float height = (float) textureView.getHeight();
        if (width == 0.0f || height == 0.0f || i2 == 0) {
            textureView.setTransform((Matrix) null);
            return;
        }
        Matrix matrix = new Matrix();
        float f2 = width / 2.0f;
        float f3 = height / 2.0f;
        matrix.postRotate((float) i2, f2, f3);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        matrix.postScale(width / rectF2.width(), height / rectF2.height(), f2, f3);
        textureView.setTransform(matrix);
    }
}

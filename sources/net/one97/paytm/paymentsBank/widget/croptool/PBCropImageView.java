package net.one97.paytm.paymentsBank.widget.croptool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;
import java.util.UUID;
import net.one97.paytm.paymentsBank.widget.croptool.c;

public class PBCropImageView extends FrameLayout {
    private int A;
    private f B;
    private e C;
    private g D;
    private int E;
    private float F;
    private float G;
    private float H;
    private RectF I;
    private int J;
    private boolean K;
    private Uri L;

    /* renamed from: a  reason: collision with root package name */
    Bitmap f19673a;

    /* renamed from: b  reason: collision with root package name */
    int f19674b;

    /* renamed from: c  reason: collision with root package name */
    boolean f19675c;

    /* renamed from: d  reason: collision with root package name */
    boolean f19676d;

    /* renamed from: e  reason: collision with root package name */
    h f19677e;

    /* renamed from: f  reason: collision with root package name */
    d f19678f;

    /* renamed from: g  reason: collision with root package name */
    Uri f19679g;

    /* renamed from: h  reason: collision with root package name */
    WeakReference<b> f19680h;

    /* renamed from: i  reason: collision with root package name */
    WeakReference<a> f19681i;
    private final ImageView j;
    private final CropOverlayView k;
    private final Matrix l;
    private final Matrix m;
    private final ProgressBar n;
    private final float[] o;
    private final float[] p;
    private d q;
    private int r;
    private int s;
    private int t;
    private int u;
    private j v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public enum b {
        RECTANGLE,
        OVAL
    }

    public enum c {
        OFF,
        ON_TOUCH,
        ON
    }

    public interface d {
        void a(a aVar);
    }

    public interface e {
    }

    public interface f {
    }

    public interface g {
    }

    public interface h {
        void a(Exception exc);
    }

    public enum i {
        NONE,
        SAMPLING,
        RESIZE_INSIDE,
        RESIZE_FIT,
        RESIZE_EXACT
    }

    public enum j {
        FIT_CENTER,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    public PBCropImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: type inference failed for: r2v47, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PBCropImageView(android.content.Context r6, android.util.AttributeSet r7) {
        /*
            r5 = this;
            r5.<init>(r6, r7)
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            r5.l = r0
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            r5.m = r0
            r0 = 8
            float[] r1 = new float[r0]
            r5.o = r1
            float[] r0 = new float[r0]
            r5.p = r0
            r0 = 0
            r5.w = r0
            r1 = 1
            r5.x = r1
            r5.y = r1
            r5.z = r1
            r5.E = r1
            r2 = 1065353216(0x3f800000, float:1.0)
            r5.F = r2
            boolean r2 = r6 instanceof android.app.Activity
            r3 = 0
            if (r2 == 0) goto L_0x0038
            r2 = r6
            android.app.Activity r2 = (android.app.Activity) r2
            android.content.Intent r2 = r2.getIntent()
            goto L_0x0039
        L_0x0038:
            r2 = r3
        L_0x0039:
            if (r2 == 0) goto L_0x004c
            java.lang.String r4 = "CROP_IMAGE_EXTRA_BUNDLE"
            android.os.Bundle r2 = r2.getBundleExtra(r4)
            if (r2 == 0) goto L_0x004c
            java.lang.String r3 = "CROP_IMAGE_EXTRA_OPTIONS"
            android.os.Parcelable r2 = r2.getParcelable(r3)
            r3 = r2
            net.one97.paytm.paymentsBank.widget.croptool.CropImageOptions r3 = (net.one97.paytm.paymentsBank.widget.croptool.CropImageOptions) r3
        L_0x004c:
            if (r3 != 0) goto L_0x01f2
            net.one97.paytm.paymentsBank.widget.croptool.CropImageOptions r3 = new net.one97.paytm.paymentsBank.widget.croptool.CropImageOptions
            r3.<init>()
            if (r7 == 0) goto L_0x01f2
            int[] r2 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView
            android.content.res.TypedArray r7 = r6.obtainStyledAttributes(r7, r2, r0, r0)
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropFixAspectRatio     // Catch:{ all -> 0x01ed }
            boolean r2 = r3.l     // Catch:{ all -> 0x01ed }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.l = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropAspectRatioX     // Catch:{ all -> 0x01ed }
            int r2 = r3.m     // Catch:{ all -> 0x01ed }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.m = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropAspectRatioY     // Catch:{ all -> 0x01ed }
            int r2 = r3.n     // Catch:{ all -> 0x01ed }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.n = r0     // Catch:{ all -> 0x01ed }
            net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView$j[] r0 = net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView.j.values()     // Catch:{ all -> 0x01ed }
            int r2 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropScaleType     // Catch:{ all -> 0x01ed }
            net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView$j r4 = r3.f19658e     // Catch:{ all -> 0x01ed }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x01ed }
            int r2 = r7.getInt(r2, r4)     // Catch:{ all -> 0x01ed }
            r0 = r0[r2]     // Catch:{ all -> 0x01ed }
            r3.f19658e = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropAutoZoomEnabled     // Catch:{ all -> 0x01ed }
            boolean r2 = r3.f19661h     // Catch:{ all -> 0x01ed }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.f19661h = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropMultiTouchEnabled     // Catch:{ all -> 0x01ed }
            boolean r2 = r3.f19662i     // Catch:{ all -> 0x01ed }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.f19662i = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropMaxZoom     // Catch:{ all -> 0x01ed }
            int r2 = r3.j     // Catch:{ all -> 0x01ed }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.j = r0     // Catch:{ all -> 0x01ed }
            net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView$b[] r0 = net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView.b.values()     // Catch:{ all -> 0x01ed }
            int r2 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropShape     // Catch:{ all -> 0x01ed }
            net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView$b r4 = r3.f19654a     // Catch:{ all -> 0x01ed }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x01ed }
            int r2 = r7.getInt(r2, r4)     // Catch:{ all -> 0x01ed }
            r0 = r0[r2]     // Catch:{ all -> 0x01ed }
            r3.f19654a = r0     // Catch:{ all -> 0x01ed }
            net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView$c[] r0 = net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView.c.values()     // Catch:{ all -> 0x01ed }
            int r2 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropGuidelines     // Catch:{ all -> 0x01ed }
            net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView$c r4 = r3.f19657d     // Catch:{ all -> 0x01ed }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x01ed }
            int r2 = r7.getInt(r2, r4)     // Catch:{ all -> 0x01ed }
            r0 = r0[r2]     // Catch:{ all -> 0x01ed }
            r3.f19657d = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropSnapRadius     // Catch:{ all -> 0x01ed }
            float r2 = r3.f19655b     // Catch:{ all -> 0x01ed }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.f19655b = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropTouchRadius     // Catch:{ all -> 0x01ed }
            float r2 = r3.f19656c     // Catch:{ all -> 0x01ed }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.f19656c = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropInitialCropWindowPaddingRatio     // Catch:{ all -> 0x01ed }
            float r2 = r3.k     // Catch:{ all -> 0x01ed }
            float r0 = r7.getFloat(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.k = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropBorderLineThickness     // Catch:{ all -> 0x01ed }
            float r2 = r3.o     // Catch:{ all -> 0x01ed }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.o = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropBorderLineColor     // Catch:{ all -> 0x01ed }
            int r2 = r3.p     // Catch:{ all -> 0x01ed }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.p = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropBorderCornerThickness     // Catch:{ all -> 0x01ed }
            float r2 = r3.q     // Catch:{ all -> 0x01ed }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.q = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropBorderCornerOffset     // Catch:{ all -> 0x01ed }
            float r2 = r3.r     // Catch:{ all -> 0x01ed }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.r = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropBorderCornerLength     // Catch:{ all -> 0x01ed }
            float r2 = r3.s     // Catch:{ all -> 0x01ed }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.s = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropBorderCornerColor     // Catch:{ all -> 0x01ed }
            int r2 = r3.t     // Catch:{ all -> 0x01ed }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.t = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropGuidelinesThickness     // Catch:{ all -> 0x01ed }
            float r2 = r3.u     // Catch:{ all -> 0x01ed }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.u = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropGuidelinesColor     // Catch:{ all -> 0x01ed }
            int r2 = r3.v     // Catch:{ all -> 0x01ed }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.v = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropBackgroundColor     // Catch:{ all -> 0x01ed }
            int r2 = r3.w     // Catch:{ all -> 0x01ed }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.w = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropShowCropOverlay     // Catch:{ all -> 0x01ed }
            boolean r2 = r5.x     // Catch:{ all -> 0x01ed }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.f19659f = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropShowProgressBar     // Catch:{ all -> 0x01ed }
            boolean r2 = r5.y     // Catch:{ all -> 0x01ed }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.f19660g = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropBorderCornerThickness     // Catch:{ all -> 0x01ed }
            float r2 = r3.q     // Catch:{ all -> 0x01ed }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.q = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropMinCropWindowWidth     // Catch:{ all -> 0x01ed }
            int r2 = r3.x     // Catch:{ all -> 0x01ed }
            float r2 = (float) r2     // Catch:{ all -> 0x01ed }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01ed }
            int r0 = (int) r0     // Catch:{ all -> 0x01ed }
            r3.x = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropMinCropWindowHeight     // Catch:{ all -> 0x01ed }
            int r2 = r3.y     // Catch:{ all -> 0x01ed }
            float r2 = (float) r2     // Catch:{ all -> 0x01ed }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01ed }
            int r0 = (int) r0     // Catch:{ all -> 0x01ed }
            r3.y = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropMinCropResultWidthPX     // Catch:{ all -> 0x01ed }
            int r2 = r3.z     // Catch:{ all -> 0x01ed }
            float r2 = (float) r2     // Catch:{ all -> 0x01ed }
            float r0 = r7.getFloat(r0, r2)     // Catch:{ all -> 0x01ed }
            int r0 = (int) r0     // Catch:{ all -> 0x01ed }
            r3.z = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropMinCropResultHeightPX     // Catch:{ all -> 0x01ed }
            int r2 = r3.A     // Catch:{ all -> 0x01ed }
            float r2 = (float) r2     // Catch:{ all -> 0x01ed }
            float r0 = r7.getFloat(r0, r2)     // Catch:{ all -> 0x01ed }
            int r0 = (int) r0     // Catch:{ all -> 0x01ed }
            r3.A = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropMaxCropResultWidthPX     // Catch:{ all -> 0x01ed }
            int r2 = r3.B     // Catch:{ all -> 0x01ed }
            float r2 = (float) r2     // Catch:{ all -> 0x01ed }
            float r0 = r7.getFloat(r0, r2)     // Catch:{ all -> 0x01ed }
            int r0 = (int) r0     // Catch:{ all -> 0x01ed }
            r3.B = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropMaxCropResultHeightPX     // Catch:{ all -> 0x01ed }
            int r2 = r3.C     // Catch:{ all -> 0x01ed }
            float r2 = (float) r2     // Catch:{ all -> 0x01ed }
            float r0 = r7.getFloat(r0, r2)     // Catch:{ all -> 0x01ed }
            int r0 = (int) r0     // Catch:{ all -> 0x01ed }
            r3.C = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropFlipHorizontally     // Catch:{ all -> 0x01ed }
            boolean r2 = r3.S     // Catch:{ all -> 0x01ed }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.S = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropFlipHorizontally     // Catch:{ all -> 0x01ed }
            boolean r2 = r3.T     // Catch:{ all -> 0x01ed }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01ed }
            r3.T = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropSaveBitmapToInstanceState     // Catch:{ all -> 0x01ed }
            boolean r2 = r5.w     // Catch:{ all -> 0x01ed }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01ed }
            r5.w = r0     // Catch:{ all -> 0x01ed }
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropAspectRatioX     // Catch:{ all -> 0x01ed }
            boolean r0 = r7.hasValue(r0)     // Catch:{ all -> 0x01ed }
            if (r0 == 0) goto L_0x01e9
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropAspectRatioX     // Catch:{ all -> 0x01ed }
            boolean r0 = r7.hasValue(r0)     // Catch:{ all -> 0x01ed }
            if (r0 == 0) goto L_0x01e9
            int r0 = net.one97.paytm.paymentsBank.R.styleable.PBCropImageView_pbcropFixAspectRatio     // Catch:{ all -> 0x01ed }
            boolean r0 = r7.hasValue(r0)     // Catch:{ all -> 0x01ed }
            if (r0 != 0) goto L_0x01e9
            r3.l = r1     // Catch:{ all -> 0x01ed }
        L_0x01e9:
            r7.recycle()
            goto L_0x01f2
        L_0x01ed:
            r6 = move-exception
            r7.recycle()
            throw r6
        L_0x01f2:
            r3.a()
            net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView$j r7 = r3.f19658e
            r5.v = r7
            boolean r7 = r3.f19661h
            r5.z = r7
            int r7 = r3.j
            r5.A = r7
            boolean r7 = r3.f19659f
            r5.x = r7
            boolean r7 = r3.f19660g
            r5.y = r7
            boolean r7 = r3.S
            r5.f19675c = r7
            boolean r7 = r3.T
            r5.f19676d = r7
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            int r7 = net.one97.paytm.paymentsBank.R.layout.pb_crop_image_view
            android.view.View r6 = r6.inflate(r7, r5, r1)
            int r7 = net.one97.paytm.paymentsBank.R.id.ImageView_image
            android.view.View r7 = r6.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r5.j = r7
            android.widget.ImageView r7 = r5.j
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.MATRIX
            r7.setScaleType(r0)
            int r7 = net.one97.paytm.paymentsBank.R.id.CropOverlayView
            android.view.View r7 = r6.findViewById(r7)
            net.one97.paytm.paymentsBank.widget.croptool.CropOverlayView r7 = (net.one97.paytm.paymentsBank.widget.croptool.CropOverlayView) r7
            r5.k = r7
            net.one97.paytm.paymentsBank.widget.croptool.CropOverlayView r7 = r5.k
            net.one97.paytm.paymentsBank.widget.croptool.-$$Lambda$PBCropImageView$rfu9JhrG8L5XK5WGDwGzRX3ct80 r0 = new net.one97.paytm.paymentsBank.widget.croptool.-$$Lambda$PBCropImageView$rfu9JhrG8L5XK5WGDwGzRX3ct80
            r0.<init>()
            r7.setCropWindowChangeListener(r0)
            net.one97.paytm.paymentsBank.widget.croptool.CropOverlayView r7 = r5.k
            r7.setInitialAttributeValues(r3)
            int r7 = net.one97.paytm.paymentsBank.R.id.CropProgressBar
            android.view.View r6 = r6.findViewById(r7)
            android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
            r5.n = r6
            r5.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(boolean z2) {
        a(z2, true);
        if (this.B != null && !z2) {
            getCropRect();
        }
        if (this.C != null && z2) {
            getCropRect();
        }
    }

    private static int a(int i2, int i3, int i4) {
        if (i2 == 1073741824) {
            return i3;
        }
        return i2 == Integer.MIN_VALUE ? Math.min(i4, i3) : i4;
    }

    public j getScaleType() {
        return this.v;
    }

    public void setScaleType(j jVar) {
        if (jVar != this.v) {
            this.v = jVar;
            this.F = 1.0f;
            this.H = 0.0f;
            this.G = 0.0f;
            this.k.b();
            requestLayout();
        }
    }

    public b getCropShape() {
        return this.k.getCropShape();
    }

    public void setCropShape(b bVar) {
        this.k.setCropShape(bVar);
    }

    public void setAutoZoomEnabled(boolean z2) {
        if (this.z != z2) {
            this.z = z2;
            a(false, false);
            this.k.invalidate();
        }
    }

    public void setMultiTouchEnabled(boolean z2) {
        if (this.k.a(z2)) {
            a(false, false);
            this.k.invalidate();
        }
    }

    public int getMaxZoom() {
        return this.A;
    }

    public void setMaxZoom(int i2) {
        if (this.A != i2 && i2 > 0) {
            this.A = i2;
            a(false, false);
            this.k.invalidate();
        }
    }

    public void setMinCropResultSize(int i2, int i3) {
        this.k.setMinCropResultSize(i2, i3);
    }

    public void setMaxCropResultSize(int i2, int i3) {
        this.k.setMaxCropResultSize(i2, i3);
    }

    public int getRotatedDegrees() {
        return this.r;
    }

    public void setRotatedDegrees(int i2) {
        int i3 = this.r;
        if (i3 != i2) {
            a(i2 - i3);
        }
    }

    public void setFixedAspectRatio(boolean z2) {
        this.k.setFixedAspectRatio(z2);
    }

    public void setFlippedHorizontally(boolean z2) {
        if (this.f19675c != z2) {
            this.f19675c = z2;
            a((float) getWidth(), (float) getHeight(), true, false);
        }
    }

    public void setFlippedVertically(boolean z2) {
        if (this.f19676d != z2) {
            this.f19676d = z2;
            a((float) getWidth(), (float) getHeight(), true, false);
        }
    }

    public c getGuidelines() {
        return this.k.getGuidelines();
    }

    public void setGuidelines(c cVar) {
        this.k.setGuidelines(cVar);
    }

    public Pair<Integer, Integer> getAspectRatio() {
        return new Pair<>(Integer.valueOf(this.k.getAspectRatioX()), Integer.valueOf(this.k.getAspectRatioY()));
    }

    public void setAspectRatio(int i2, int i3) {
        this.k.setAspectRatioX(i2);
        this.k.setAspectRatioY(i3);
        setFixedAspectRatio(true);
    }

    public void setSnapRadius(float f2) {
        if (f2 >= 0.0f) {
            this.k.setSnapRadius(f2);
        }
    }

    public void setShowProgressBar(boolean z2) {
        if (this.y != z2) {
            this.y = z2;
            a();
        }
    }

    public void setShowCropOverlay(boolean z2) {
        if (this.x != z2) {
            this.x = z2;
            d();
        }
    }

    public void setSaveBitmapToInstanceState(boolean z2) {
        this.w = z2;
    }

    public int getImageResource() {
        return this.u;
    }

    public void setImageResource(int i2) {
        if (i2 != 0) {
            this.k.setInitialCropWindowRect((Rect) null);
            a(BitmapFactory.decodeResource(getResources(), i2), i2, (Uri) null, 1, 0);
        }
    }

    public Uri getImageUri() {
        return this.f19679g;
    }

    public Rect getWholeImageRect() {
        int i2 = this.E;
        Bitmap bitmap = this.f19673a;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i2, bitmap.getHeight() * i2);
    }

    public Rect getCropRect() {
        int i2 = this.E;
        Bitmap bitmap = this.f19673a;
        if (bitmap == null) {
            return null;
        }
        return c.a(getCropPoints(), bitmap.getWidth() * i2, i2 * bitmap.getHeight(), this.k.f19663a, this.k.getAspectRatioX(), this.k.getAspectRatioY());
    }

    public void setCropRect(Rect rect) {
        this.k.setInitialCropWindowRect(rect);
    }

    public RectF getCropWindowRect() {
        CropOverlayView cropOverlayView = this.k;
        if (cropOverlayView == null) {
            return null;
        }
        return cropOverlayView.getCropWindowRect();
    }

    public float[] getCropPoints() {
        RectF cropWindowRect = this.k.getCropWindowRect();
        float[] fArr = {cropWindowRect.left, cropWindowRect.top, cropWindowRect.right, cropWindowRect.top, cropWindowRect.right, cropWindowRect.bottom, cropWindowRect.left, cropWindowRect.bottom};
        this.l.invert(this.m);
        this.m.mapPoints(fArr);
        for (int i2 = 0; i2 < 8; i2++) {
            fArr[i2] = fArr[i2] * ((float) this.E);
        }
        return fArr;
    }

    public Bitmap getCroppedImage() {
        Bitmap bitmap;
        i iVar = i.NONE;
        if (this.f19673a == null) {
            return null;
        }
        this.j.clearAnimation();
        i iVar2 = i.NONE;
        i iVar3 = i.NONE;
        if (this.f19679g == null || (this.E <= 1 && iVar != i.SAMPLING)) {
            bitmap = c.a(this.f19673a, getCropPoints(), this.r, this.k.f19663a, this.k.getAspectRatioX(), this.k.getAspectRatioY(), this.f19675c, this.f19676d).f19722a;
        } else {
            bitmap = c.a(getContext(), this.f19679g, getCropPoints(), this.r, this.f19673a.getWidth() * this.E, this.f19673a.getHeight() * this.E, this.k.f19663a, this.k.getAspectRatioX(), this.k.getAspectRatioY(), 0, 0, this.f19675c, this.f19676d).f19722a;
        }
        return c.a(bitmap, 0, 0, iVar);
    }

    public void getCroppedImageAsync() {
        i iVar = i.NONE;
        if (this.f19678f != null) {
            a(0, 0, iVar, (Uri) null, (Bitmap.CompressFormat) null, 0);
            return;
        }
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    public final void a(Uri uri, Bitmap.CompressFormat compressFormat, int i2, int i3, int i4, i iVar) {
        if (this.f19678f != null) {
            a(i3, i4, iVar, uri, compressFormat, i2);
            return;
        }
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    public void setOnSetCropOverlayReleasedListener(f fVar) {
        this.B = fVar;
    }

    public void setOnSetCropOverlayMovedListener(e eVar) {
        this.C = eVar;
    }

    public void setOnCropWindowChangedListener(g gVar) {
        this.D = gVar;
    }

    public void setOnSetImageUriCompleteListener(h hVar) {
        this.f19677e = hVar;
    }

    public void setOnCropImageCompleteListener(d dVar) {
        this.f19678f = dVar;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.k.setInitialCropWindowRect((Rect) null);
        a(bitmap, 0, (Uri) null, 1, 0);
    }

    public void setImageBitmap(Bitmap bitmap, ExifInterface exifInterface) {
        int i2;
        Bitmap bitmap2;
        if (bitmap == null || exifInterface == null) {
            bitmap2 = bitmap;
            i2 = 0;
        } else {
            c.b a2 = c.a(bitmap, exifInterface);
            Bitmap bitmap3 = a2.f19724a;
            int i3 = a2.f19725b;
            this.f19674b = a2.f19725b;
            bitmap2 = bitmap3;
            i2 = i3;
        }
        this.k.setInitialCropWindowRect((Rect) null);
        a(bitmap2, 0, (Uri) null, 1, i2);
    }

    public void setImageUriAsync(Uri uri) {
        if (uri != null) {
            WeakReference<b> weakReference = this.f19680h;
            b bVar = weakReference != null ? (b) weakReference.get() : null;
            if (bVar != null) {
                bVar.cancel(true);
            }
            b();
            this.I = null;
            this.J = 0;
            this.k.setInitialCropWindowRect((Rect) null);
            this.f19680h = new WeakReference<>(new b(this, uri));
            ((b) this.f19680h.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            a();
        }
    }

    public final void a(int i2) {
        int i3;
        int i4 = i2;
        if (this.f19673a != null) {
            if (i4 < 0) {
                i3 = (i4 % 360) + 360;
            } else {
                i3 = i4 % 360;
            }
            boolean z2 = !this.k.f19663a && ((i3 > 45 && i3 < 135) || (i3 > 215 && i3 < 305));
            c.f19717c.set(this.k.getCropWindowRect());
            RectF rectF = c.f19717c;
            float height = (z2 ? rectF.height() : rectF.width()) / 2.0f;
            RectF rectF2 = c.f19717c;
            float width = (z2 ? rectF2.width() : rectF2.height()) / 2.0f;
            if (z2) {
                boolean z3 = this.f19675c;
                this.f19675c = this.f19676d;
                this.f19676d = z3;
            }
            this.l.invert(this.m);
            c.f19718d[0] = c.f19717c.centerX();
            c.f19718d[1] = c.f19717c.centerY();
            c.f19718d[2] = 0.0f;
            c.f19718d[3] = 0.0f;
            c.f19718d[4] = 1.0f;
            c.f19718d[5] = 0.0f;
            this.m.mapPoints(c.f19718d);
            this.r = (this.r + i3) % 360;
            a((float) getWidth(), (float) getHeight(), true, false);
            this.l.mapPoints(c.f19719e, c.f19718d);
            this.F = (float) (((double) this.F) / Math.sqrt(Math.pow((double) (c.f19719e[4] - c.f19719e[2]), 2.0d) + Math.pow((double) (c.f19719e[5] - c.f19719e[3]), 2.0d)));
            this.F = Math.max(this.F, 1.0f);
            a((float) getWidth(), (float) getHeight(), true, false);
            this.l.mapPoints(c.f19719e, c.f19718d);
            double sqrt = Math.sqrt(Math.pow((double) (c.f19719e[4] - c.f19719e[2]), 2.0d) + Math.pow((double) (c.f19719e[5] - c.f19719e[3]), 2.0d));
            float f2 = (float) (((double) height) * sqrt);
            float f3 = (float) (((double) width) * sqrt);
            c.f19717c.set(c.f19719e[0] - f2, c.f19719e[1] - f3, c.f19719e[0] + f2, c.f19719e[1] + f3);
            this.k.b();
            this.k.setCropWindowRect(c.f19717c);
            a((float) getWidth(), (float) getHeight(), true, false);
            a(false, false);
            this.k.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Bitmap bitmap, int i2, Uri uri, int i3, int i4) {
        Bitmap bitmap2 = this.f19673a;
        if (bitmap2 == null || !bitmap2.equals(bitmap)) {
            this.j.clearAnimation();
            b();
            this.f19673a = bitmap;
            this.j.setImageBitmap(this.f19673a);
            this.f19679g = uri;
            this.u = i2;
            this.E = i3;
            this.r = i4;
            a((float) getWidth(), (float) getHeight(), true, false);
            CropOverlayView cropOverlayView = this.k;
            if (cropOverlayView != null) {
                cropOverlayView.b();
                d();
            }
        }
    }

    private void b() {
        if (this.f19673a != null && (this.u > 0 || this.f19679g != null)) {
            this.f19673a.recycle();
        }
        this.f19673a = null;
        this.u = 0;
        this.f19679g = null;
        this.E = 1;
        this.r = 0;
        this.F = 1.0f;
        this.G = 0.0f;
        this.H = 0.0f;
        this.l.reset();
        this.L = null;
        this.j.setImageBitmap((Bitmap) null);
        d();
    }

    private void a(int i2, int i3, i iVar, Uri uri, Bitmap.CompressFormat compressFormat, int i4) {
        PBCropImageView pBCropImageView;
        i iVar2 = iVar;
        Bitmap bitmap = this.f19673a;
        if (bitmap != null) {
            this.j.clearAnimation();
            WeakReference<a> weakReference = this.f19681i;
            a aVar = weakReference != null ? (a) weakReference.get() : null;
            if (aVar != null) {
                aVar.cancel(true);
            }
            int i5 = iVar2 != i.NONE ? i2 : 0;
            int i6 = iVar2 != i.NONE ? i3 : 0;
            int width = bitmap.getWidth() * this.E;
            int height = bitmap.getHeight();
            int i7 = this.E;
            int i8 = height * i7;
            if (this.f19679g == null || (i7 <= 1 && iVar2 != i.SAMPLING)) {
                a aVar2 = r0;
                a aVar3 = new a(this, bitmap, getCropPoints(), this.r, this.k.f19663a, this.k.getAspectRatioX(), this.k.getAspectRatioY(), i5, i6, this.f19675c, this.f19676d, iVar, uri, compressFormat, i4);
                pBCropImageView = this;
                pBCropImageView.f19681i = new WeakReference<>(aVar2);
            } else {
                a aVar4 = r0;
                a aVar5 = new a(this, this.f19679g, getCropPoints(), this.r, width, i8, this.k.f19663a, this.k.getAspectRatioX(), this.k.getAspectRatioY(), i5, i6, this.f19675c, this.f19676d, iVar, uri, compressFormat, i4);
                this.f19681i = new WeakReference<>(aVar4);
                pBCropImageView = this;
            }
            ((a) pBCropImageView.f19681i.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            a();
            return;
        }
    }

    public Parcelable onSaveInstanceState() {
        b bVar;
        if (this.f19679g == null && this.f19673a == null && this.u <= 0) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        Uri uri = this.f19679g;
        if (this.w && uri == null && this.u <= 0) {
            uri = c.a(getContext(), this.f19673a, this.L);
            this.L = uri;
        }
        if (!(uri == null || this.f19673a == null)) {
            String uuid = UUID.randomUUID().toString();
            c.f19720f = new Pair<>(uuid, new WeakReference(this.f19673a));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", uuid);
        }
        WeakReference<b> weakReference = this.f19680h;
        if (!(weakReference == null || (bVar = (b) weakReference.get()) == null)) {
            bundle.putParcelable("LOADING_IMAGE_URI", bVar.f19705a);
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uri);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.u);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.E);
        bundle.putInt("DEGREES_ROTATED", this.r);
        bundle.putParcelable("INITIAL_CROP_RECT", this.k.getInitialCropWindowRect());
        c.f19717c.set(this.k.getCropWindowRect());
        this.l.invert(this.m);
        this.m.mapRect(c.f19717c);
        bundle.putParcelable("CROP_WINDOW_RECT", c.f19717c);
        bundle.putString("CROP_SHAPE", this.k.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.z);
        bundle.putInt("CROP_MAX_ZOOM", this.A);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.f19675c);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.f19676d);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (this.f19680h == null && this.f19679g == null && this.f19673a == null && this.u == 0) {
                Uri uri = (Uri) bundle.getParcelable("LOADED_IMAGE_URI");
                if (uri != null) {
                    String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                    if (string != null) {
                        Bitmap bitmap = (c.f19720f == null || !((String) c.f19720f.first).equals(string)) ? null : (Bitmap) ((WeakReference) c.f19720f.second).get();
                        c.f19720f = null;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            a(bitmap, 0, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
                        }
                    }
                    if (this.f19679g == null) {
                        setImageUriAsync(uri);
                    }
                } else {
                    int i2 = bundle.getInt("LOADED_IMAGE_RESOURCE");
                    if (i2 > 0) {
                        setImageResource(i2);
                    } else {
                        Uri uri2 = (Uri) bundle.getParcelable("LOADING_IMAGE_URI");
                        if (uri2 != null) {
                            setImageUriAsync(uri2);
                        }
                    }
                }
                int i3 = bundle.getInt("DEGREES_ROTATED");
                this.J = i3;
                this.r = i3;
                Rect rect = (Rect) bundle.getParcelable("INITIAL_CROP_RECT");
                if (rect != null && (rect.width() > 0 || rect.height() > 0)) {
                    this.k.setInitialCropWindowRect(rect);
                }
                RectF rectF = (RectF) bundle.getParcelable("CROP_WINDOW_RECT");
                if (rectF != null && (rectF.width() > 0.0f || rectF.height() > 0.0f)) {
                    this.I = rectF;
                }
                this.k.setCropShape(b.valueOf(bundle.getString("CROP_SHAPE")));
                this.z = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
                this.A = bundle.getInt("CROP_MAX_ZOOM");
                this.f19675c = bundle.getBoolean("CROP_FLIP_HORIZONTALLY");
                this.f19676d = bundle.getBoolean("CROP_FLIP_VERTICALLY");
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        Bitmap bitmap = this.f19673a;
        if (bitmap != null) {
            if (size2 == 0) {
                size2 = bitmap.getHeight();
            }
            double width = size < this.f19673a.getWidth() ? ((double) size) / ((double) this.f19673a.getWidth()) : Double.POSITIVE_INFINITY;
            double height = size2 < this.f19673a.getHeight() ? ((double) size2) / ((double) this.f19673a.getHeight()) : Double.POSITIVE_INFINITY;
            if (width == Double.POSITIVE_INFINITY && height == Double.POSITIVE_INFINITY) {
                i5 = this.f19673a.getWidth();
                i4 = this.f19673a.getHeight();
            } else if (width <= height) {
                i4 = (int) (((double) this.f19673a.getHeight()) * width);
                i5 = size;
            } else {
                i5 = (int) (((double) this.f19673a.getWidth()) * height);
                i4 = size2;
            }
            int a2 = a(mode, size, i5);
            int a3 = a(mode2, size2, i4);
            this.s = a2;
            this.t = a3;
            setMeasuredDimension(this.s, this.t);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (this.s <= 0 || this.t <= 0) {
            a(true);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.s;
        layoutParams.height = this.t;
        setLayoutParams(layoutParams);
        if (this.f19673a != null) {
            float f2 = (float) (i4 - i2);
            float f3 = (float) (i5 - i3);
            a(f2, f3, true, false);
            if (this.I != null) {
                int i6 = this.J;
                if (i6 != this.f19674b) {
                    this.r = i6;
                    a(f2, f3, true, false);
                }
                this.l.mapRect(this.I);
                this.k.setCropWindowRect(this.I);
                a(false, false);
                this.k.a();
                this.I = null;
            } else if (this.K) {
                this.K = false;
                a(false, false);
            }
        } else {
            a(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.K = i4 > 0 && i5 > 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r11, boolean r12) {
        /*
            r10 = this;
            int r0 = r10.getWidth()
            int r1 = r10.getHeight()
            android.graphics.Bitmap r2 = r10.f19673a
            if (r2 == 0) goto L_0x00f8
            if (r0 <= 0) goto L_0x00f8
            if (r1 <= 0) goto L_0x00f8
            net.one97.paytm.paymentsBank.widget.croptool.CropOverlayView r2 = r10.k
            android.graphics.RectF r2 = r2.getCropWindowRect()
            r3 = 0
            if (r11 == 0) goto L_0x003a
            float r11 = r2.left
            int r11 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r11 < 0) goto L_0x0033
            float r11 = r2.top
            int r11 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r11 < 0) goto L_0x0033
            float r11 = r2.right
            float r12 = (float) r0
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r11 > 0) goto L_0x0033
            float r11 = r2.bottom
            float r12 = (float) r1
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r11 <= 0) goto L_0x00f8
        L_0x0033:
            float r11 = (float) r0
            float r12 = (float) r1
            r0 = 0
            r10.a(r11, r12, r0, r0)
            return
        L_0x003a:
            boolean r11 = r10.z
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r11 != 0) goto L_0x0046
            float r11 = r10.F
            int r11 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r11 <= 0) goto L_0x00f8
        L_0x0046:
            float r11 = r10.F
            int r5 = r10.A
            float r5 = (float) r5
            int r11 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r11 >= 0) goto L_0x0088
            float r11 = r2.width()
            float r5 = (float) r0
            r6 = 1056964608(0x3f000000, float:0.5)
            float r7 = r5 * r6
            int r11 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r11 >= 0) goto L_0x0088
            float r11 = r2.height()
            float r7 = (float) r1
            float r6 = r6 * r7
            int r11 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r11 >= 0) goto L_0x0088
            int r11 = r10.A
            float r11 = (float) r11
            float r6 = r2.width()
            float r8 = r10.F
            float r6 = r6 / r8
            r8 = 1059313418(0x3f23d70a, float:0.64)
            float r6 = r6 / r8
            float r5 = r5 / r6
            float r6 = r2.height()
            float r9 = r10.F
            float r6 = r6 / r9
            float r6 = r6 / r8
            float r7 = r7 / r6
            float r5 = java.lang.Math.min(r5, r7)
            float r11 = java.lang.Math.min(r11, r5)
            goto L_0x0089
        L_0x0088:
            r11 = 0
        L_0x0089:
            float r5 = r10.F
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x00c6
            float r5 = r2.width()
            float r6 = (float) r0
            r7 = 1059481190(0x3f266666, float:0.65)
            float r8 = r6 * r7
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 > 0) goto L_0x00a8
            float r5 = r2.height()
            float r8 = (float) r1
            float r8 = r8 * r7
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x00c6
        L_0x00a8:
            float r11 = r2.width()
            float r5 = r10.F
            float r11 = r11 / r5
            r5 = 1057132380(0x3f028f5c, float:0.51)
            float r11 = r11 / r5
            float r6 = r6 / r11
            float r11 = (float) r1
            float r2 = r2.height()
            float r7 = r10.F
            float r2 = r2 / r7
            float r2 = r2 / r5
            float r11 = r11 / r2
            float r11 = java.lang.Math.min(r6, r11)
            float r11 = java.lang.Math.max(r4, r11)
        L_0x00c6:
            boolean r2 = r10.z
            if (r2 != 0) goto L_0x00cc
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x00cc:
            int r2 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x00f8
            float r2 = r10.F
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00f8
            if (r12 == 0) goto L_0x00f0
            net.one97.paytm.paymentsBank.widget.croptool.d r2 = r10.q
            if (r2 != 0) goto L_0x00e7
            net.one97.paytm.paymentsBank.widget.croptool.d r2 = new net.one97.paytm.paymentsBank.widget.croptool.d
            android.widget.ImageView r3 = r10.j
            net.one97.paytm.paymentsBank.widget.croptool.CropOverlayView r4 = r10.k
            r2.<init>(r3, r4)
            r10.q = r2
        L_0x00e7:
            net.one97.paytm.paymentsBank.widget.croptool.d r2 = r10.q
            float[] r3 = r10.o
            android.graphics.Matrix r4 = r10.l
            r2.a(r3, r4)
        L_0x00f0:
            r10.F = r11
            float r11 = (float) r0
            float r0 = (float) r1
            r1 = 1
            r10.a(r11, r0, r1, r12)
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView.a(boolean, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, float f3, boolean z2, boolean z3) {
        float f4;
        if (this.f19673a != null) {
            float f5 = 0.0f;
            if (f2 > 0.0f && f3 > 0.0f) {
                this.l.invert(this.m);
                RectF cropWindowRect = this.k.getCropWindowRect();
                this.m.mapRect(cropWindowRect);
                this.l.reset();
                this.l.postTranslate((f2 - ((float) this.f19673a.getWidth())) / 2.0f, (f3 - ((float) this.f19673a.getHeight())) / 2.0f);
                c();
                int i2 = this.r;
                if (i2 > 0) {
                    this.l.postRotate((float) i2, c.g(this.o), c.h(this.o));
                    c();
                }
                float min = Math.min(f2 / c.e(this.o), f3 / c.f(this.o));
                if (this.v == j.FIT_CENTER || ((this.v == j.CENTER_INSIDE && min < 1.0f) || (min > 1.0f && this.z))) {
                    this.l.postScale(min, min, c.g(this.o), c.h(this.o));
                    c();
                }
                float f6 = this.f19675c ? -this.F : this.F;
                float f7 = this.f19676d ? -this.F : this.F;
                this.l.postScale(f6, f7, c.g(this.o), c.h(this.o));
                c();
                this.l.mapRect(cropWindowRect);
                if (z2) {
                    if (f2 > c.e(this.o)) {
                        f4 = 0.0f;
                    } else {
                        f4 = Math.max(Math.min((f2 / 2.0f) - cropWindowRect.centerX(), -c.a(this.o)), ((float) getWidth()) - c.c(this.o)) / f6;
                    }
                    this.G = f4;
                    if (f3 <= c.f(this.o)) {
                        f5 = Math.max(Math.min((f3 / 2.0f) - cropWindowRect.centerY(), -c.b(this.o)), ((float) getHeight()) - c.d(this.o)) / f7;
                    }
                    this.H = f5;
                } else {
                    this.G = Math.min(Math.max(this.G * f6, -cropWindowRect.left), (-cropWindowRect.right) + f2) / f6;
                    this.H = Math.min(Math.max(this.H * f7, -cropWindowRect.top), (-cropWindowRect.bottom) + f3) / f7;
                }
                this.l.postTranslate(this.G * f6, this.H * f7);
                cropWindowRect.offset(this.G * f6, this.H * f7);
                this.k.setCropWindowRect(cropWindowRect);
                c();
                this.k.invalidate();
                if (z3) {
                    this.q.b(this.o, this.l);
                    this.j.startAnimation(this.q);
                } else {
                    this.j.setImageMatrix(this.l);
                }
                a(false);
            }
        }
    }

    private void c() {
        float[] fArr = this.o;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = (float) this.f19673a.getWidth();
        float[] fArr2 = this.o;
        fArr2[3] = 0.0f;
        fArr2[4] = (float) this.f19673a.getWidth();
        this.o[5] = (float) this.f19673a.getHeight();
        float[] fArr3 = this.o;
        fArr3[6] = 0.0f;
        fArr3[7] = (float) this.f19673a.getHeight();
        this.l.mapPoints(this.o);
        float[] fArr4 = this.p;
        fArr4[0] = 0.0f;
        fArr4[1] = 0.0f;
        fArr4[2] = 100.0f;
        fArr4[3] = 0.0f;
        fArr4[4] = 100.0f;
        fArr4[5] = 100.0f;
        fArr4[6] = 0.0f;
        fArr4[7] = 100.0f;
        this.l.mapPoints(fArr4);
    }

    private void d() {
        CropOverlayView cropOverlayView = this.k;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.x || this.f19673a == null) ? 4 : 0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        int i2 = 0;
        boolean z2 = this.y && ((this.f19673a == null && this.f19680h != null) || this.f19681i != null);
        ProgressBar progressBar = this.n;
        if (!z2) {
            i2 = 4;
        }
        progressBar.setVisibility(i2);
    }

    private void a(boolean z2) {
        if (this.f19673a != null && !z2) {
            this.k.setCropWindowLimits((float) getWidth(), (float) getHeight(), (((float) this.E) * 100.0f) / c.e(this.p), (((float) this.E) * 100.0f) / c.f(this.p));
        }
        this.k.setBounds(z2 ? null : this.o, getWidth(), getHeight());
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Uri f19682a;

        /* renamed from: b  reason: collision with root package name */
        final Uri f19683b;

        /* renamed from: c  reason: collision with root package name */
        final Exception f19684c;

        /* renamed from: d  reason: collision with root package name */
        final float[] f19685d;

        /* renamed from: e  reason: collision with root package name */
        final Rect f19686e;

        /* renamed from: f  reason: collision with root package name */
        final Rect f19687f;

        /* renamed from: g  reason: collision with root package name */
        final int f19688g;

        /* renamed from: h  reason: collision with root package name */
        final int f19689h;

        /* renamed from: i  reason: collision with root package name */
        private final Bitmap f19690i;
        private final Bitmap j;

        a(Bitmap bitmap, Uri uri, Bitmap bitmap2, Uri uri2, Exception exc, float[] fArr, Rect rect, Rect rect2, int i2, int i3) {
            this.f19690i = bitmap;
            this.f19682a = uri;
            this.j = bitmap2;
            this.f19683b = uri2;
            this.f19684c = exc;
            this.f19685d = fArr;
            this.f19686e = rect;
            this.f19687f = rect2;
            this.f19688g = i2;
            this.f19689h = i3;
        }
    }
}

package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.h.u;
import com.airbnb.lottie.b.b;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f.d;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.g.c;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottieAnimationView extends AppCompatImageView {
    /* access modifiers changed from: private */
    public static final h<Throwable> DEFAULT_FAILURE_LISTENER = new h<Throwable>() {
        public final /* synthetic */ void onResult(Object obj) {
            Throwable th = (Throwable) obj;
            if (h.a(th)) {
                d.b("Unable to load composition.");
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    };
    private static final String TAG = LottieAnimationView.class.getSimpleName();
    private String animationName;
    private int animationResId;
    private boolean autoPlay = false;
    private int buildDrawingCacheDepth = 0;
    private boolean cacheComposition = true;
    private d composition;
    private m<d> compositionTask;
    /* access modifiers changed from: private */
    public h<Throwable> failureListener;
    /* access modifiers changed from: private */
    public int fallbackResource = 0;
    private boolean isInitialized;
    private final h<d> loadedListener = new h<d>() {
        public final /* synthetic */ void onResult(Object obj) {
            LottieAnimationView.this.setComposition((d) obj);
        }
    };
    private final f lottieDrawable = new f();
    private Set<j> lottieOnCompositionLoadedListeners = new HashSet();
    private boolean playAnimationWhenShown = false;
    private o renderMode = o.AUTOMATIC;
    private boolean wasAnimatingWhenDetached = false;
    private boolean wasAnimatingWhenNotShown = false;
    private final h<Throwable> wrappedFailureListener = new h<Throwable>() {
        public final /* synthetic */ void onResult(Object obj) {
            Throwable th = (Throwable) obj;
            if (LottieAnimationView.this.fallbackResource != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
            }
            (LottieAnimationView.this.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : LottieAnimationView.this.failureListener).onResult(th);
        }
    };

    public LottieAnimationView(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView);
        boolean z = false;
        if (!isInEditMode()) {
            this.cacheComposition = obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
            boolean hasValue3 = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_url);
            if (!hasValue || !hasValue2) {
                if (hasValue) {
                    int resourceId = obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
                    if (resourceId != 0) {
                        setAnimation(resourceId);
                    }
                } else if (hasValue2) {
                    String string2 = obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
                    if (string2 != null) {
                        setAnimation(string2);
                    }
                } else if (hasValue3 && (string = obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
                    setAnimationFromUrl(string);
                }
                setFallbackResource(obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
            } else {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.wasAnimatingWhenDetached = true;
            this.autoPlay = true;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.lottieDrawable.d(-1);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            p pVar = new p(obtainStyledAttributes.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0));
            addValueCallback(new e("**"), k.C, new c(pVar));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.lottieDrawable.d(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_renderMode)) {
            int i2 = obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_renderMode, o.AUTOMATIC.ordinal());
            if (i2 >= o.values().length) {
                i2 = o.AUTOMATIC.ordinal();
            }
            setRenderMode(o.values()[i2]);
        }
        if (getScaleType() != null) {
            this.lottieDrawable.f6070h = getScaleType();
        }
        obtainStyledAttributes.recycle();
        f fVar = this.lottieDrawable;
        if (h.a(getContext()) != 0.0f) {
            z = true;
        }
        fVar.f6066d = z;
        enableOrDisableHardwareLayer();
        this.isInitialized = true;
    }

    public void setImageResource(int i2) {
        cancelLoaderTask();
        super.setImageResource(i2);
    }

    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        f fVar = this.lottieDrawable;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5634a = this.animationName;
        savedState.f5635b = this.animationResId;
        savedState.f5636c = this.lottieDrawable.f6064b.b();
        savedState.f5637d = this.lottieDrawable.e() || (!u.M(this) && this.wasAnimatingWhenDetached);
        savedState.f5638e = this.lottieDrawable.j;
        savedState.f5639f = this.lottieDrawable.f6064b.getRepeatMode();
        savedState.f5640g = this.lottieDrawable.f6064b.getRepeatCount();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.animationName = savedState.f5634a;
        if (!TextUtils.isEmpty(this.animationName)) {
            setAnimation(this.animationName);
        }
        this.animationResId = savedState.f5635b;
        int i2 = this.animationResId;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(savedState.f5636c);
        if (savedState.f5637d) {
            playAnimation();
        }
        this.lottieDrawable.j = savedState.f5638e;
        setRepeatMode(savedState.f5639f);
        setRepeatCount(savedState.f5640g);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        if (this.isInitialized) {
            if (isShown()) {
                if (this.wasAnimatingWhenNotShown) {
                    resumeAnimation();
                } else if (this.playAnimationWhenShown) {
                    playAnimation();
                }
                this.wasAnimatingWhenNotShown = false;
                this.playAnimationWhenShown = false;
            } else if (isAnimating()) {
                pauseAnimation();
                this.wasAnimatingWhenNotShown = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay || this.wasAnimatingWhenDetached) {
            playAnimation();
            this.autoPlay = false;
            this.wasAnimatingWhenDetached = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        super.onDetachedFromWindow();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        f fVar = this.lottieDrawable;
        if (fVar.o == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            d.a("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        fVar.o = z;
        if (fVar.f6063a != null) {
            fVar.a();
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.o;
    }

    public void setCacheComposition(boolean z) {
        this.cacheComposition = z;
    }

    public void setAnimation(int i2) {
        this.animationResId = i2;
        this.animationName = null;
        setCompositionTask(this.cacheComposition ? e.a(getContext(), i2) : e.a(getContext(), i2, (String) null));
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(this.cacheComposition ? e.b(getContext(), str) : e.b(getContext(), str, (String) null));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, (String) null);
    }

    public void setAnimationFromJson(String str, String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setAnimation(InputStream inputStream, String str) {
        setCompositionTask(e.a(inputStream, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.cacheComposition ? e.a(getContext(), str) : e.a(getContext(), str, (String) null));
    }

    public void setAnimationFromUrl(String str, String str2) {
        setCompositionTask(e.a(getContext(), str, str2));
    }

    public void setFailureListener(h<Throwable> hVar) {
        this.failureListener = hVar;
    }

    public void setFallbackResource(int i2) {
        this.fallbackResource = i2;
    }

    private void setCompositionTask(m<d> mVar) {
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = mVar.a(this.loadedListener).c(this.wrappedFailureListener);
    }

    private void cancelLoaderTask() {
        m<d> mVar = this.compositionTask;
        if (mVar != null) {
            mVar.b(this.loadedListener);
            this.compositionTask.d(this.wrappedFailureListener);
        }
    }

    public void setComposition(d dVar) {
        if (c.f5801a) {
            new StringBuilder("Set Composition \n").append(dVar);
        }
        this.lottieDrawable.setCallback(this);
        this.composition = dVar;
        boolean a2 = this.lottieDrawable.a(dVar);
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable || a2) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (j aB_ : this.lottieOnCompositionLoadedListeners) {
                aB_.aB_();
            }
        }
    }

    public d getComposition() {
        return this.composition;
    }

    public boolean hasMasks() {
        f fVar = this.lottieDrawable;
        return fVar.p != null && fVar.p.e();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasMatte() {
        /*
            r4 = this;
            com.airbnb.lottie.f r0 = r4.lottieDrawable
            com.airbnb.lottie.c.c.b r1 = r0.p
            if (r1 == 0) goto L_0x0045
            com.airbnb.lottie.c.c.b r0 = r0.p
            java.lang.Boolean r1 = r0.f5937i
            r2 = 1
            if (r1 != 0) goto L_0x003c
            boolean r1 = r0.c()
            if (r1 == 0) goto L_0x0019
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.f5937i = r1
        L_0x0017:
            r0 = 1
            goto L_0x0042
        L_0x0019:
            java.util.List<com.airbnb.lottie.c.c.a> r1 = r0.f5936h
            int r1 = r1.size()
            int r1 = r1 - r2
        L_0x0020:
            if (r1 < 0) goto L_0x0038
            java.util.List<com.airbnb.lottie.c.c.a> r3 = r0.f5936h
            java.lang.Object r3 = r3.get(r1)
            com.airbnb.lottie.c.c.a r3 = (com.airbnb.lottie.c.c.a) r3
            boolean r3 = r3.c()
            if (r3 == 0) goto L_0x0035
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.f5937i = r1
            goto L_0x0017
        L_0x0035:
            int r1 = r1 + -1
            goto L_0x0020
        L_0x0038:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.f5937i = r1
        L_0x003c:
            java.lang.Boolean r0 = r0.f5937i
            boolean r0 = r0.booleanValue()
        L_0x0042:
            if (r0 == 0) goto L_0x0045
            return r2
        L_0x0045:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.hasMatte():boolean");
    }

    public void playAnimation() {
        if (isShown()) {
            this.lottieDrawable.c();
            enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = true;
    }

    public void resumeAnimation() {
        if (isShown()) {
            this.lottieDrawable.d();
            enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = true;
    }

    public void setMinFrame(int i2) {
        this.lottieDrawable.a(i2);
    }

    public float getMinFrame() {
        return this.lottieDrawable.f6064b.h();
    }

    public void setMinProgress(float f2) {
        this.lottieDrawable.a(f2);
    }

    public void setMaxFrame(int i2) {
        this.lottieDrawable.b(i2);
    }

    public float getMaxFrame() {
        return this.lottieDrawable.f6064b.i();
    }

    public void setMaxProgress(float f2) {
        this.lottieDrawable.b(f2);
    }

    public void setMinFrame(String str) {
        this.lottieDrawable.a(str);
    }

    public void setMaxFrame(String str) {
        this.lottieDrawable.b(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.lottieDrawable.c(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.lottieDrawable.a(str, str2, z);
    }

    public void setMinAndMaxFrame(int i2, int i3) {
        this.lottieDrawable.a(i2, i3);
    }

    public void setMinAndMaxProgress(float f2, float f3) {
        this.lottieDrawable.a(f2, f3);
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.f6064b.d();
    }

    public void setSpeed(float f2) {
        this.lottieDrawable.f6064b.f6111b = f2;
    }

    public float getSpeed() {
        return this.lottieDrawable.f6064b.f6111b;
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.f6064b.addUpdateListener(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.f6064b.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        f fVar = this.lottieDrawable;
        fVar.f6064b.removeAllUpdateListeners();
        fVar.f6064b.addUpdateListener(fVar.f6069g);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.f6064b.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.f6064b.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.f6064b.removeAllListeners();
    }

    @Deprecated
    public void loop(boolean z) {
        this.lottieDrawable.d(z ? -1 : 0);
    }

    public void setRepeatMode(int i2) {
        this.lottieDrawable.f6064b.setRepeatMode(i2);
    }

    public int getRepeatMode() {
        return this.lottieDrawable.f6064b.getRepeatMode();
    }

    public void setRepeatCount(int i2) {
        this.lottieDrawable.d(i2);
    }

    public int getRepeatCount() {
        return this.lottieDrawable.f6064b.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.lottieDrawable.e();
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.j = str;
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.j;
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        f fVar = this.lottieDrawable;
        b g2 = fVar.g();
        if (g2 == null) {
            d.a("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        if (bitmap == null) {
            g gVar = g2.f5798b.get(str);
            bitmap2 = gVar.f6132e;
            gVar.f6132e = null;
        } else {
            Bitmap bitmap3 = g2.f5798b.get(str).f6132e;
            g2.a(str, bitmap);
            bitmap2 = bitmap3;
        }
        fVar.invalidateSelf();
        return bitmap2;
    }

    public void setImageAssetDelegate(b bVar) {
        f fVar = this.lottieDrawable;
        fVar.k = bVar;
        if (fVar.f6071i != null) {
            fVar.f6071i.f5797a = bVar;
        }
    }

    public void setFontAssetDelegate(a aVar) {
        f fVar = this.lottieDrawable;
        fVar.m = aVar;
        if (fVar.l != null) {
            fVar.l.f5794e = aVar;
        }
    }

    public void setTextDelegate(q qVar) {
        this.lottieDrawable.n = qVar;
    }

    public List<e> resolveKeyPath(e eVar) {
        return this.lottieDrawable.a(eVar);
    }

    public <T> void addValueCallback(e eVar, T t, c<T> cVar) {
        this.lottieDrawable.a(eVar, t, cVar);
    }

    public <T> void addValueCallback(e eVar, T t, final com.airbnb.lottie.g.e<T> eVar2) {
        this.lottieDrawable.a(eVar, t, new c<T>() {
            public final T a() {
                return eVar2.a();
            }
        });
    }

    public void setScale(float f2) {
        this.lottieDrawable.d(f2);
        if (getDrawable() == this.lottieDrawable) {
            setImageDrawable((Drawable) null);
            setImageDrawable(this.lottieDrawable);
        }
    }

    public float getScale() {
        return this.lottieDrawable.f6065c;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        f fVar = this.lottieDrawable;
        if (fVar != null) {
            fVar.f6070h = scaleType;
        }
    }

    public void cancelAnimation() {
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        f fVar = this.lottieDrawable;
        fVar.f6068f.clear();
        fVar.f6064b.cancel();
        enableOrDisableHardwareLayer();
    }

    public void pauseAnimation() {
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        f fVar = this.lottieDrawable;
        fVar.f6068f.clear();
        fVar.f6064b.b(true);
        enableOrDisableHardwareLayer();
    }

    public void setFrame(int i2) {
        this.lottieDrawable.c(i2);
    }

    public int getFrame() {
        return (int) this.lottieDrawable.f6064b.f6112c;
    }

    public void setProgress(float f2) {
        this.lottieDrawable.c(f2);
    }

    public float getProgress() {
        return this.lottieDrawable.f6064b.b();
    }

    public long getDuration() {
        d dVar = this.composition;
        if (dVar != null) {
            return (long) dVar.a();
        }
        return 0;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        f fVar = this.lottieDrawable;
        fVar.q = z;
        if (fVar.f6063a != null) {
            fVar.f6063a.a(z);
        }
    }

    public n getPerformanceTracker() {
        f fVar = this.lottieDrawable;
        if (fVar.f6063a != null) {
            return fVar.f6063a.f5974a;
        }
        return null;
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.b();
    }

    public void setSafeMode(boolean z) {
        this.lottieDrawable.f6067e = z;
    }

    public void buildDrawingCache(boolean z) {
        c.a("buildDrawingCache");
        this.buildDrawingCacheDepth++;
        super.buildDrawingCache(z);
        if (this.buildDrawingCacheDepth == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(o.HARDWARE);
        }
        this.buildDrawingCacheDepth--;
        c.b("buildDrawingCache");
    }

    public void setRenderMode(o oVar) {
        this.renderMode = oVar;
        enableOrDisableHardwareLayer();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.lottieDrawable.r = z;
    }

    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.s = false;
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5633a = new int[o.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.airbnb.lottie.o[] r0 = com.airbnb.lottie.o.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5633a = r0
                int[] r0 = f5633a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.o r1 = com.airbnb.lottie.o.HARDWARE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f5633a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.o r1 = com.airbnb.lottie.o.SOFTWARE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f5633a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airbnb.lottie.o r1 = com.airbnb.lottie.o.AUTOMATIC     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.AnonymousClass5.<clinit>():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        if (r3 != false) goto L_0x0038;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void enableOrDisableHardwareLayer() {
        /*
            r5 = this;
            int[] r0 = com.airbnb.lottie.LottieAnimationView.AnonymousClass5.f5633a
            com.airbnb.lottie.o r1 = r5.renderMode
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L_0x0038
            if (r0 == r1) goto L_0x0039
            r3 = 3
            if (r0 == r3) goto L_0x0014
            goto L_0x0039
        L_0x0014:
            com.airbnb.lottie.d r0 = r5.composition
            r3 = 0
            if (r0 == 0) goto L_0x0024
            boolean r0 = r0.m
            if (r0 == 0) goto L_0x0024
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L_0x0024
            goto L_0x0036
        L_0x0024:
            com.airbnb.lottie.d r0 = r5.composition
            if (r0 == 0) goto L_0x002e
            int r0 = r0.n
            r4 = 4
            if (r0 <= r4) goto L_0x002e
            goto L_0x0036
        L_0x002e:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r0 >= r4) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r3 = 1
        L_0x0036:
            if (r3 == 0) goto L_0x0039
        L_0x0038:
            r2 = 2
        L_0x0039:
            int r0 = r5.getLayerType()
            if (r2 == r0) goto L_0x0043
            r0 = 0
            r5.setLayerType(r2, r0)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.enableOrDisableHardwareLayer():void");
    }

    public boolean addLottieOnCompositionLoadedListener(j jVar) {
        if (this.composition != null) {
            jVar.aB_();
        }
        return this.lottieOnCompositionLoadedListeners.add(jVar);
    }

    public boolean removeLottieOnCompositionLoadedListener(j jVar) {
        return this.lottieOnCompositionLoadedListeners.remove(jVar);
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        String f5634a;

        /* renamed from: b  reason: collision with root package name */
        int f5635b;

        /* renamed from: c  reason: collision with root package name */
        float f5636c;

        /* renamed from: d  reason: collision with root package name */
        boolean f5637d;

        /* renamed from: e  reason: collision with root package name */
        String f5638e;

        /* renamed from: f  reason: collision with root package name */
        int f5639f;

        /* renamed from: g  reason: collision with root package name */
        int f5640g;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f5634a = parcel.readString();
            this.f5636c = parcel.readFloat();
            this.f5637d = parcel.readInt() != 1 ? false : true;
            this.f5638e = parcel.readString();
            this.f5639f = parcel.readInt();
            this.f5640g = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f5634a);
            parcel.writeFloat(this.f5636c);
            parcel.writeInt(this.f5637d ? 1 : 0);
            parcel.writeString(this.f5638e);
            parcel.writeInt(this.f5639f);
            parcel.writeInt(this.f5640g);
        }
    }
}

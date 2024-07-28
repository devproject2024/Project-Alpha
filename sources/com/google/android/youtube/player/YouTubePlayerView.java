package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.google.android.youtube.player.c;
import com.google.android.youtube.player.internal.e;
import com.google.android.youtube.player.internal.n;
import com.google.android.youtube.player.internal.s;
import com.google.android.youtube.player.internal.u;
import com.google.android.youtube.player.internal.v;
import com.google.android.youtube.player.internal.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class YouTubePlayerView extends ViewGroup implements c.e {

    /* renamed from: a  reason: collision with root package name */
    private final a f37531a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Set<View> f37532b;

    /* renamed from: c  reason: collision with root package name */
    private final b f37533c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public e f37534d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public u f37535e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public View f37536f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public n f37537g;

    /* renamed from: h  reason: collision with root package name */
    private c.e f37538h;

    /* renamed from: i  reason: collision with root package name */
    private Bundle f37539i;
    private c.C0610c j;
    private boolean k;
    /* access modifiers changed from: private */
    public boolean l;

    interface b {
        void a(YouTubePlayerView youTubePlayerView);

        void a(YouTubePlayerView youTubePlayerView, String str, c.C0610c cVar);
    }

    public YouTubePlayerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    YouTubePlayerView(Context context, AttributeSet attributeSet, int i2, b bVar) {
        super((Context) com.google.android.youtube.player.internal.c.a(context, (Object) "context cannot be null"), attributeSet, i2);
        this.f37533c = (b) com.google.android.youtube.player.internal.c.a(bVar, (Object) "listener cannot be null");
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        setClipToPadding(false);
        this.f37537g = new n(context);
        requestTransparentRegion(this.f37537g);
        addView(this.f37537g);
        this.f37532b = new HashSet();
        this.f37531a = new a(this, (byte) 0);
    }

    private void a(View view) {
        if (!(view == this.f37537g || (this.f37535e != null && view == this.f37536f))) {
            throw new UnsupportedOperationException("No views can be added on top of the player");
        }
    }

    static /* synthetic */ void a(YouTubePlayerView youTubePlayerView, Activity activity) {
        try {
            youTubePlayerView.f37535e = new u(youTubePlayerView.f37534d, com.google.android.youtube.player.internal.b.a().a(activity, youTubePlayerView.f37534d, youTubePlayerView.k));
            youTubePlayerView.f37536f = youTubePlayerView.f37535e.b();
            youTubePlayerView.addView(youTubePlayerView.f37536f);
            youTubePlayerView.removeView(youTubePlayerView.f37537g);
            youTubePlayerView.f37533c.a(youTubePlayerView);
            if (youTubePlayerView.j != null) {
                boolean z = false;
                Bundle bundle = youTubePlayerView.f37539i;
                if (bundle != null) {
                    z = youTubePlayerView.f37535e.a(bundle);
                    youTubePlayerView.f37539i = null;
                }
                youTubePlayerView.j.a(youTubePlayerView.f37535e, z);
                youTubePlayerView.j = null;
            }
        } catch (y.a unused) {
            b bVar = b.INTERNAL_ERROR;
            youTubePlayerView.f();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        u uVar = this.f37535e;
        if (uVar != null) {
            uVar.c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(final Activity activity, c.e eVar, String str, c.C0610c cVar, Bundle bundle) {
        if (this.f37535e == null && this.j == null) {
            com.google.android.youtube.player.internal.c.a(activity, (Object) "activity cannot be null");
            this.f37538h = (c.e) com.google.android.youtube.player.internal.c.a(eVar, (Object) "provider cannot be null");
            this.j = (c.C0610c) com.google.android.youtube.player.internal.c.a(cVar, (Object) "listener cannot be null");
            this.f37539i = bundle;
            this.f37537g.a();
            this.f37534d = com.google.android.youtube.player.internal.b.a().a(getContext(), str, new v.a() {
                public final void a() {
                    if (YouTubePlayerView.this.f37534d != null) {
                        YouTubePlayerView.a(YouTubePlayerView.this, activity);
                    }
                    e unused = YouTubePlayerView.this.f37534d = null;
                }

                public final void b() {
                    if (!YouTubePlayerView.this.l && YouTubePlayerView.this.f37535e != null) {
                        try {
                            YouTubePlayerView.this.f37535e.f37607a.q();
                        } catch (RemoteException e2) {
                            throw new s(e2);
                        }
                    }
                    n e3 = YouTubePlayerView.this.f37537g;
                    e3.f37572a.setVisibility(8);
                    e3.f37573b.setVisibility(8);
                    YouTubePlayerView youTubePlayerView = YouTubePlayerView.this;
                    if (youTubePlayerView.indexOfChild(youTubePlayerView.f37537g) < 0) {
                        YouTubePlayerView youTubePlayerView2 = YouTubePlayerView.this;
                        youTubePlayerView2.addView(youTubePlayerView2.f37537g);
                        YouTubePlayerView youTubePlayerView3 = YouTubePlayerView.this;
                        youTubePlayerView3.removeView(youTubePlayerView3.f37536f);
                    }
                    View unused = YouTubePlayerView.this.f37536f = null;
                    u unused2 = YouTubePlayerView.this.f37535e = null;
                    e unused3 = YouTubePlayerView.this.f37534d = null;
                }
            }, new v.b() {
                public final void a() {
                    YouTubePlayerView.this.f();
                    e unused = YouTubePlayerView.this.f37534d = null;
                }
            });
            this.f37534d.e();
        }
    }

    public final void a(String str, c.C0610c cVar) {
        com.google.android.youtube.player.internal.c.a(str, (Object) "Developer key cannot be null or empty");
        this.f37533c.a(this, str, cVar);
    }

    public final void addFocusables(ArrayList<View> arrayList, int i2) {
        ArrayList arrayList2 = new ArrayList();
        super.addFocusables(arrayList2, i2);
        arrayList.addAll(arrayList2);
        this.f37532b.clear();
        this.f37532b.addAll(arrayList2);
    }

    public final void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        ArrayList arrayList2 = new ArrayList();
        super.addFocusables(arrayList2, i2, i3);
        arrayList.addAll(arrayList2);
        this.f37532b.clear();
        this.f37532b.addAll(arrayList2);
    }

    public final void addView(View view) {
        a(view);
        super.addView(view);
    }

    public final void addView(View view, int i2) {
        a(view);
        super.addView(view, i2);
    }

    public final void addView(View view, int i2, int i3) {
        a(view);
        super.addView(view, i2, i3);
    }

    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        a(view);
        super.addView(view, i2, layoutParams);
    }

    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
        super.addView(view, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        u uVar = this.f37535e;
        if (uVar != null) {
            uVar.d();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(boolean z) {
        u uVar = this.f37535e;
        if (uVar != null) {
            uVar.d(z);
            c(z);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        u uVar = this.f37535e;
        if (uVar != null) {
            uVar.e();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(boolean z) {
        this.l = true;
        u uVar = this.f37535e;
        if (uVar != null) {
            uVar.c(z);
        }
    }

    public final void clearChildFocus(View view) {
        if (hasFocusable()) {
            requestFocus();
        } else {
            super.clearChildFocus(view);
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        u uVar = this.f37535e;
        if (uVar != null) {
            uVar.f();
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.f37535e != null) {
            if (keyEvent.getAction() == 0) {
                return this.f37535e.a(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 1) {
                return this.f37535e.b(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: package-private */
    public final Bundle e() {
        u uVar = this.f37535e;
        return uVar == null ? this.f37539i : uVar.g();
    }

    public final void focusableViewAvailable(View view) {
        super.focusableViewAvailable(view);
        this.f37532b.add(view);
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalFocusChangeListener(this.f37531a);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalFocusChangeListener(this.f37531a);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (getChildCount() > 0) {
            getChildAt(0).layout(0, 0, i4 - i2, i5 - i3);
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            childAt.measure(i2, i3);
            setMeasuredDimension(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.f37532b.add(view2);
    }

    public final void setClipToPadding(boolean z) {
    }

    public final void setPadding(int i2, int i3, int i4, int i5) {
    }

    final class a implements ViewTreeObserver.OnGlobalFocusChangeListener {
        private a() {
        }

        /* synthetic */ a(YouTubePlayerView youTubePlayerView, byte b2) {
            this();
        }

        public final void onGlobalFocusChanged(View view, View view2) {
            if (YouTubePlayerView.this.f37535e != null && YouTubePlayerView.this.f37532b.contains(view2) && !YouTubePlayerView.this.f37532b.contains(view)) {
                try {
                    YouTubePlayerView.this.f37535e.f37607a.l();
                } catch (RemoteException e2) {
                    throw new s(e2);
                }
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, ((YouTubeBaseActivity) context).f37526a);
        if (context instanceof YouTubeBaseActivity) {
            return;
        }
        throw new IllegalStateException("A YouTubePlayerView can only be created with an Activity  which extends YouTubeBaseActivity as its context.");
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        if (!z || Build.VERSION.SDK_INT >= 14) {
            this.k = z;
            return;
        }
        String.format("Could not enable TextureView because API level is lower than 14", new Object[0]);
        this.k = false;
    }

    /* access modifiers changed from: private */
    public void f() {
        this.f37535e = null;
        n nVar = this.f37537g;
        nVar.f37572a.setVisibility(8);
        nVar.f37573b.setVisibility(0);
        if (this.j != null) {
            this.j = null;
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        u uVar = this.f37535e;
        if (uVar != null) {
            try {
                uVar.f37607a.a(configuration);
            } catch (RemoteException e2) {
                throw new s(e2);
            }
        }
    }
}

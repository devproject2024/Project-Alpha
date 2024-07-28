package com.travel.train.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.travel.train.R;

public final class f implements View.OnClickListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    public b f28390a;

    /* renamed from: b  reason: collision with root package name */
    private final View f28391b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28392c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final PopupWindow f28393d;

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout f28394e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f28395f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageView f28396g;

    /* renamed from: h  reason: collision with root package name */
    private float f28397h;

    /* renamed from: i  reason: collision with root package name */
    private float f28398i;
    private final com.travel.train.e.a j;

    public interface b {
        void a();
    }

    public /* synthetic */ f(Context context, View view, int i2, com.travel.train.e.a aVar, char c2) {
        this(context, view, i2, aVar);
    }

    public /* synthetic */ f(Context context, View view, int i2, com.travel.train.e.a aVar, short s) {
        this(context, view, i2, aVar, (byte) 0);
    }

    private f(Context context, View view, int i2, com.travel.train.e.a aVar) {
        this.f28391b = view;
        this.f28392c = i2;
        this.j = aVar;
        this.f28394e = new LinearLayout(context);
        this.f28394e.setOnClickListener(this);
        this.f28395f = new TextView(context);
        this.f28395f.setPadding(aVar.j, aVar.l, aVar.k, aVar.m);
        this.f28395f.setGravity(aVar.f26640c);
        this.f28395f.setTextColor(aVar.f26641d);
        this.f28395f.setTextSize(0, aVar.f26642e);
        this.f28395f.setTypeface(aVar.f26643f, aVar.f26644g);
        int i3 = aVar.f26645h;
        if (i3 > 0) {
            this.f28395f.setLines(i3);
            this.f28395f.setEllipsize(TextUtils.TruncateAt.END);
        }
        CharSequence charSequence = aVar.f26639b;
        this.f28395f.setText(TextUtils.isEmpty(charSequence) ? context.getString(aVar.f26638a) : charSequence);
        int i4 = aVar.f26646i;
        float f2 = aVar.n;
        if (f2 > 0.0f) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i4);
            gradientDrawable.setGradientType(0);
            gradientDrawable.setCornerRadius(f2);
            this.f28395f.setBackgroundDrawable(gradientDrawable);
        } else {
            this.f28395f.setBackgroundColor(i4);
        }
        this.f28396g = new ImageView(context);
        this.f28396g.setVisibility(8);
        this.f28396g.setColorFilter(new PorterDuffColorFilter(i4, PorterDuff.Mode.MULTIPLY));
        if (i2 == 3) {
            this.f28394e.setOrientation(0);
            this.f28394e.addView(this.f28395f, new LinearLayout.LayoutParams(-2, -2));
            this.f28396g.setImageResource(R.drawable.pre_t_ic_arrow_down_tooltip);
            this.f28396g.setRotation(90.0f);
            this.f28394e.addView(this.f28396g, new LinearLayout.LayoutParams(-2, -2));
        } else if (i2 == 5) {
            this.f28394e.setOrientation(0);
            this.f28396g.setImageResource(R.drawable.pre_t_ic_arrow_down_tooltip);
            this.f28396g.setRotation(2700.0f);
            this.f28394e.addView(this.f28396g, new LinearLayout.LayoutParams(-2, -2));
            this.f28394e.addView(this.f28395f, new LinearLayout.LayoutParams(-2, -2));
        } else if (i2 == 48) {
            this.f28394e.setOrientation(1);
            this.f28394e.addView(this.f28395f, new LinearLayout.LayoutParams(-2, -2));
            this.f28396g.setImageResource(R.drawable.pre_t_ic_arrow_down_tooltip);
            this.f28394e.addView(this.f28396g, new LinearLayout.LayoutParams(-2, -2));
        } else if (i2 == 80) {
            this.f28394e.addView(this.f28396g, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f28393d = new PopupWindow(this.f28394e, -1, -1);
    }

    private f(Context context, View view, int i2, com.travel.train.e.a aVar, byte b2) {
        this.f28391b = view;
        this.f28392c = i2;
        this.j = aVar;
        this.f28394e = new LinearLayout(context);
        this.f28394e.setOnClickListener(this);
        this.f28395f = new TextView(context);
        int i3 = aVar.f26646i;
        this.f28396g = new ImageView(context);
        this.f28396g.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.MULTIPLY));
        if (i2 == 3) {
            this.f28394e.setOrientation(0);
            this.f28394e.addView(aVar.p, new LinearLayout.LayoutParams(-2, -2));
            this.f28396g.setImageResource(R.drawable.pre_t_ic_arrow_down_tooltip);
            this.f28396g.setRotation(90.0f);
            this.f28394e.addView(this.f28396g, new LinearLayout.LayoutParams(-2, -2));
        } else if (i2 == 5) {
            this.f28394e.setOrientation(0);
            this.f28396g.setImageResource(R.drawable.pre_t_ic_arrow_down_tooltip);
            this.f28396g.setRotation(270.0f);
            this.f28394e.addView(this.f28396g, new LinearLayout.LayoutParams(-2, -2));
            this.f28394e.addView(aVar.p, new LinearLayout.LayoutParams(-2, -2));
        } else if (i2 == 48) {
            this.f28394e.setOrientation(1);
            this.f28394e.addView(aVar.p, new LinearLayout.LayoutParams(-2, -2));
            this.f28396g.setImageResource(R.drawable.pre_t_ic_arrow_down_tooltip);
            this.f28394e.addView(this.f28396g, new LinearLayout.LayoutParams(-2, -2));
        } else if (i2 == 80) {
            this.f28394e.addView(aVar.p, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f28393d = new PopupWindow(this.f28394e, -1, -1);
    }

    public final void a() {
        this.f28393d.showAsDropDown(this.f28391b);
        this.f28394e.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public final void b() {
        if (Build.VERSION.SDK_INT >= 12) {
            this.f28394e.setPivotX(this.f28397h);
            this.f28394e.setPivotY(this.f28398i);
            this.f28394e.animate().setDuration(300).alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    f.this.f28393d.dismiss();
                }
            });
            return;
        }
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(300);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, this.f28397h, this.f28398i));
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                f.this.f28393d.dismiss();
            }
        });
        this.f28394e.startAnimation(animationSet);
    }

    public final boolean onPreDraw() {
        int i2;
        int i3;
        int i4;
        this.f28394e.getViewTreeObserver().removeOnPreDrawListener(this);
        Context context = this.f28394e.getContext();
        if (!(context instanceof Activity)) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i5 = displayMetrics.widthPixels;
        int i6 = displayMetrics.heightPixels;
        Rect rect = new Rect();
        this.f28391b.getWindowVisibleDisplayFrame(rect);
        int i7 = rect.top;
        int[] iArr = new int[2];
        this.f28391b.getLocationInWindow(iArr);
        Rect rect2 = new Rect();
        this.f28391b.getLocalVisibleRect(rect2);
        int i8 = iArr[1] - i7;
        int i9 = iArr[0];
        int width = this.f28391b.getWidth();
        int height = this.f28391b.getHeight();
        int width2 = this.f28395f.getWidth();
        int height2 = this.f28395f.getHeight();
        int width3 = this.f28396g.getWidth();
        int height3 = this.f28396g.getHeight();
        int i10 = this.f28392c;
        if (i10 == 48 || i10 == 80) {
            int max = Math.max(width2, width3);
            int i11 = height2 + height3;
            if (this.f28392c == 48) {
                i2 = i8 - i11;
            } else {
                i2 = rect2.bottom;
            }
            int i12 = i9 + (width / 2);
            int i13 = i12 - (max / 2);
            if (i13 + max > i5) {
                i13 = i5 - max;
            }
            Math.max(0, i13);
            this.f28394e.setPadding(i5 - (this.j.p.getMeasuredWidth() + 5), 0, 0, i6 - ((this.j.p.getMeasuredHeight() + rect2.bottom) + 100));
            this.f28397h = (float) i12;
            this.f28398i = this.f28392c == 48 ? (float) i8 : (float) i2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, rect2.bottom - 22, 2, 0);
            this.f28394e.setLayoutParams(layoutParams);
        } else {
            int i14 = width2 + width3;
            int max2 = Math.max(height2, height3);
            if (this.f28392c == 3) {
                i4 = Math.max(0, i9 - i14);
                i3 = i5 - i9;
                this.f28395f.setMaxWidth(((i5 - i3) - i4) - width3);
            } else {
                i4 = width + i9;
                i3 = 0;
            }
            int i15 = i8 + (height / 2);
            int i16 = i15 - (max2 / 2);
            if (i16 + max2 > i6) {
                i16 = i6 - max2;
            }
            int max3 = Math.max(0, i16);
            this.f28394e.setPadding(i4, max3, i3, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f28396g.getLayoutParams();
            marginLayoutParams.topMargin = (i15 - max3) - (height3 / 2);
            this.f28396g.setLayoutParams(marginLayoutParams);
            this.f28397h = this.f28392c == 3 ? (float) i9 : (float) i4;
            this.f28398i = (float) i15;
        }
        return false;
    }

    public final void onClick(View view) {
        b bVar = this.f28390a;
        if (bVar != null) {
            bVar.a();
        }
        b();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Context f28402a;

        /* renamed from: b  reason: collision with root package name */
        public View f28403b;

        /* renamed from: c  reason: collision with root package name */
        public com.travel.train.e.a f28404c;

        /* renamed from: d  reason: collision with root package name */
        public int f28405d = 80;

        public a(Context context) {
            this.f28402a = context;
        }
    }
}

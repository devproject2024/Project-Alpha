package net.one97.paytm;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
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
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.wallet.dialog.a.c;

public final class ad implements View.OnClickListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    b f52281a;

    /* renamed from: b  reason: collision with root package name */
    private final View f52282b;

    /* renamed from: c  reason: collision with root package name */
    private final int f52283c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final PopupWindow f52284d;

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout f52285e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f52286f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageView f52287g;

    /* renamed from: h  reason: collision with root package name */
    private float f52288h;

    /* renamed from: i  reason: collision with root package name */
    private float f52289i;
    private final c j;

    public interface b {
        void a();
    }

    /* synthetic */ ad(Context context, View view, int i2, c cVar, char c2) {
        this(context, view, i2, cVar);
    }

    /* synthetic */ ad(Context context, View view, int i2, c cVar, short s) {
        this(context, view, i2, cVar, (byte) 0);
    }

    private ad(Context context, View view, int i2, c cVar) {
        this.f52282b = view;
        this.f52283c = i2;
        this.j = cVar;
        this.f52285e = new LinearLayout(context);
        this.f52285e.setOnClickListener(this);
        this.f52286f = new TextView(context);
        this.f52286f.setPadding(cVar.j, cVar.l, cVar.k, cVar.m);
        this.f52286f.setGravity(cVar.f70276c);
        this.f52286f.setTextColor(cVar.f70277d);
        this.f52286f.setTextSize(0, cVar.f70278e);
        this.f52286f.setTypeface(cVar.f70279f, cVar.f70280g);
        int i3 = cVar.f70281h;
        if (i3 > 0) {
            this.f52286f.setLines(i3);
            this.f52286f.setEllipsize(TextUtils.TruncateAt.END);
        }
        CharSequence charSequence = cVar.f70275b;
        this.f52286f.setText(TextUtils.isEmpty(charSequence) ? context.getString(cVar.f70274a) : charSequence);
        int i4 = cVar.f70282i;
        float f2 = cVar.n;
        if (f2 > 0.0f) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i4);
            gradientDrawable.setGradientType(0);
            gradientDrawable.setCornerRadius(f2);
            this.f52286f.setBackgroundDrawable(gradientDrawable);
        } else {
            this.f52286f.setBackgroundColor(i4);
        }
        this.f52287g = new ImageView(context);
        this.f52287g.setVisibility(8);
        this.f52287g.setColorFilter(new PorterDuffColorFilter(i4, PorterDuff.Mode.MULTIPLY));
        if (i2 == 3) {
            this.f52285e.setOrientation(0);
            this.f52285e.addView(this.f52286f, new LinearLayout.LayoutParams(-2, -2));
            this.f52287g.setImageResource(R.drawable.ic_arrow_right_tooltip);
            this.f52285e.addView(this.f52287g, new LinearLayout.LayoutParams(-2, -2));
        } else if (i2 == 5) {
            this.f52285e.setOrientation(0);
            this.f52287g.setImageResource(R.drawable.ic_arrow_left_tooltip);
            this.f52285e.addView(this.f52287g, new LinearLayout.LayoutParams(-2, -2));
            this.f52285e.addView(this.f52286f, new LinearLayout.LayoutParams(-2, -2));
        } else if (i2 == 48) {
            this.f52285e.setOrientation(1);
            this.f52285e.addView(this.f52286f, new LinearLayout.LayoutParams(-2, -2));
            this.f52287g.setImageResource(R.drawable.ic_arrow_down_tooltip);
            this.f52285e.addView(this.f52287g, new LinearLayout.LayoutParams(-2, -2));
        } else if (i2 == 80) {
            this.f52285e.addView(this.f52287g, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f52284d = new PopupWindow(this.f52285e, -1, -1);
    }

    private ad(Context context, View view, int i2, c cVar, byte b2) {
        this.f52282b = view;
        this.f52283c = i2;
        this.j = cVar;
        this.f52285e = new LinearLayout(context);
        this.f52285e.setOnClickListener(this);
        this.f52286f = new TextView(context);
        int i3 = cVar.f70282i;
        this.f52287g = new ImageView(context);
        this.f52287g.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.MULTIPLY));
        if (i2 == 3) {
            this.f52285e.setOrientation(0);
            this.f52285e.addView(cVar.p, new LinearLayout.LayoutParams(-2, -2));
            this.f52287g.setImageResource(R.drawable.ic_arrow_right_tooltip);
            this.f52285e.addView(this.f52287g, new LinearLayout.LayoutParams(-2, -2));
        } else if (i2 == 5) {
            this.f52285e.setOrientation(0);
            this.f52287g.setImageResource(R.drawable.ic_arrow_left_tooltip);
            this.f52285e.addView(this.f52287g, new LinearLayout.LayoutParams(-2, -2));
            this.f52285e.addView(cVar.p, new LinearLayout.LayoutParams(-2, -2));
        } else if (i2 == 48) {
            this.f52285e.setOrientation(1);
            this.f52285e.addView(cVar.p, new LinearLayout.LayoutParams(-2, -2));
            this.f52287g.setImageResource(R.drawable.ic_arrow_down_tooltip);
            this.f52285e.addView(this.f52287g, new LinearLayout.LayoutParams(-2, -2));
        } else if (i2 == 80) {
            this.f52285e.addView(cVar.p, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f52284d = new PopupWindow(this.f52285e, -1, -1);
    }

    public final void a() {
        this.f52284d.showAsDropDown(this.f52282b);
        this.f52285e.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public final void a(long j2) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public final void run() {
                ad.this.a();
            }
        }, j2);
    }

    public final void b() {
        if (Build.VERSION.SDK_INT >= 12) {
            this.f52285e.setPivotX(this.f52288h);
            this.f52285e.setPivotY(this.f52289i);
            this.f52285e.animate().setDuration(300).alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    ad.this.f52284d.dismiss();
                }
            });
            return;
        }
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(300);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, this.f52288h, this.f52289i));
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                ad.this.f52284d.dismiss();
            }
        });
        this.f52285e.startAnimation(animationSet);
    }

    public final boolean onPreDraw() {
        int i2;
        int i3;
        int i4;
        this.f52285e.getViewTreeObserver().removeOnPreDrawListener(this);
        Context context = this.f52285e.getContext();
        if (!(context instanceof Activity)) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i5 = displayMetrics.widthPixels;
        int i6 = displayMetrics.heightPixels;
        Rect rect = new Rect();
        this.f52282b.getWindowVisibleDisplayFrame(rect);
        int i7 = rect.top;
        int[] iArr = new int[2];
        this.f52282b.getLocationInWindow(iArr);
        Rect rect2 = new Rect();
        this.f52282b.getLocalVisibleRect(rect2);
        int i8 = iArr[1] - i7;
        int i9 = iArr[0];
        int width = this.f52282b.getWidth();
        int height = this.f52282b.getHeight();
        int width2 = this.f52286f.getWidth();
        int height2 = this.f52286f.getHeight();
        int width3 = this.f52287g.getWidth();
        int height3 = this.f52287g.getHeight();
        int i10 = this.f52283c;
        if (i10 == 48 || i10 == 80) {
            int max = Math.max(width2, width3);
            int i11 = height2 + height3;
            if (this.f52283c == 48) {
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
            this.f52285e.setPadding(i5 - (this.j.p.getMeasuredWidth() + 5), 0, 0, i6 - ((this.j.p.getMeasuredHeight() + rect2.bottom) + 100));
            this.f52288h = (float) i12;
            this.f52289i = this.f52283c == 48 ? (float) i8 : (float) i2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, rect2.bottom - 22, 2, 0);
            this.f52285e.setLayoutParams(layoutParams);
        } else {
            int i14 = width2 + width3;
            int max2 = Math.max(height2, height3);
            if (this.f52283c == 3) {
                i4 = Math.max(0, i9 - i14);
                i3 = i5 - i9;
                this.f52286f.setMaxWidth(((i5 - i3) - i4) - width3);
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
            this.f52285e.setPadding(i4, max3, i3, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f52287g.getLayoutParams();
            marginLayoutParams.topMargin = (i15 - max3) - (height3 / 2);
            this.f52287g.setLayoutParams(marginLayoutParams);
            this.f52288h = this.f52283c == 3 ? (float) i9 : (float) i4;
            this.f52289i = (float) i15;
        }
        return false;
    }

    public final void onClick(View view) {
        b bVar = this.f52281a;
        if (bVar != null) {
            bVar.a();
        }
        b();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        View f52293a;

        /* renamed from: b  reason: collision with root package name */
        c f52294b;

        /* renamed from: c  reason: collision with root package name */
        int f52295c = 80;

        /* renamed from: d  reason: collision with root package name */
        private final Context f52296d;

        public a(Context context) {
            this.f52296d = context;
        }

        public final ad a() {
            int i2 = this.f52295c;
            if (i2 == 8388611 || i2 == 8388613) {
                if (Build.VERSION.SDK_INT < 17 || this.f52293a.getLayoutDirection() != 1) {
                    this.f52295c &= 7;
                } else {
                    this.f52295c = this.f52295c == 8388611 ? 5 : 3;
                }
            }
            int i3 = this.f52295c;
            if (i3 != 48 && i3 != 80 && i3 != 3 && i3 != 5) {
                throw new IllegalArgumentException("Unsupported gravity - " + this.f52295c);
            } else if (!this.f52294b.o) {
                return new ad(this.f52296d, this.f52293a, this.f52295c, this.f52294b, 0);
            } else {
                return new ad(this.f52296d, this.f52293a, this.f52295c, this.f52294b, 0);
            }
        }
    }
}

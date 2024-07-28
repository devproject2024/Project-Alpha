package com.travel.flight.tooltipwidget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.travel.flight.R;
import com.travel.flight.tooltipwidget.a;
import java.util.ArrayList;

public class ToolTipView extends LinearLayout implements View.OnClickListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f25499a = ((ImageView) findViewById(R.id.tooltip_pointer_up));

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f25500b = ((ViewGroup) findViewById(R.id.tooltip_contentholder));

    /* renamed from: c  reason: collision with root package name */
    private TextView f25501c = ((TextView) findViewById(R.id.tooltip_contenttv));

    /* renamed from: d  reason: collision with root package name */
    private TextView f25502d = ((TextView) findViewById(R.id.tooltip_1));

    /* renamed from: e  reason: collision with root package name */
    private TextView f25503e = ((TextView) findViewById(R.id.tooltip_2));

    /* renamed from: f  reason: collision with root package name */
    private ImageView f25504f = ((ImageView) findViewById(R.id.tooltip_pointer_down));

    /* renamed from: g  reason: collision with root package name */
    private a f25505g;

    /* renamed from: h  reason: collision with root package name */
    private View f25506h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f25507i;
    private int j;
    private int k;
    private int l;
    private c m;

    public interface c {
    }

    public ToolTipView(Context context) {
        super(context);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.pre_f_tooltip, this, true);
        setOnClickListener(this);
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        this.f25507i = true;
        this.l = this.f25500b.getWidth();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.width = this.l;
        setLayoutParams(layoutParams);
        if (this.f25505g != null) {
            b();
        }
        return true;
    }

    public void setToolTip(a aVar, View view) {
        this.f25505g = aVar;
        this.f25506h = view;
        if (this.f25505g.f25519h != null) {
            if (this.f25505g.f25519h.get(0).length() != 0) {
                this.f25501c.setVisibility(0);
                this.f25501c.setText(this.f25505g.f25519h.get(0));
            } else {
                this.f25501c.setVisibility(8);
            }
            this.f25502d.setText(this.f25505g.f25519h.get(1));
            this.f25503e.setText(this.f25505g.f25519h.get(2));
        } else if (this.f25505g.f25512a != 0) {
            this.f25501c.setText(this.f25505g.f25512a);
        }
        if (this.f25505g.f25518g != null) {
            this.f25501c.setTypeface(this.f25505g.f25518g);
        }
        if (this.f25505g.f25514c != 0) {
            this.f25501c.setTextColor(this.f25505g.f25514c);
        }
        if (this.f25505g.f25513b != 0) {
            setColor(this.f25505g.f25513b);
        }
        if (this.f25505g.f25515d != null) {
            setContentView(this.f25505g.f25515d);
        }
        if (this.f25507i) {
            b();
        }
    }

    private void b() {
        int[] iArr = new int[2];
        this.f25506h.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f25506h.getWindowVisibleDisplayFrame(rect);
        int[] iArr2 = new int[2];
        ((View) getParent()).getLocationOnScreen(iArr2);
        int width = this.f25506h.getWidth();
        int height = this.f25506h.getHeight();
        this.k = iArr[0] - iArr2[0];
        this.j = iArr[1] - iArr2[1];
        int i2 = this.k + (width / 2);
        int height2 = this.j - getHeight();
        int max = Math.max(0, this.j + height);
        int max2 = Math.max(0, i2 - (this.l / 2));
        if (this.l + max2 > rect.right) {
            max2 = rect.right - this.l;
        }
        float f2 = (float) max2;
        setX(f2);
        setPointerCenterX(i2);
        int i3 = height2 < 0 ? 1 : 0;
        if (Build.VERSION.SDK_INT < 11) {
            this.f25499a.setAlpha(i3);
            this.f25504f.setAlpha(i3 ^ 1);
        } else {
            int i4 = 8;
            this.f25499a.setVisibility(i3 != 0 ? 0 : 8);
            ImageView imageView = this.f25504f;
            if (i3 == 0) {
                i4 = 0;
            }
            imageView.setVisibility(i4);
        }
        int i5 = i3 != 0 ? max - 20 : height2 + 20;
        float f3 = (float) i5;
        setY(f3);
        if (this.f25505g.f25516e == a.C0478a.NONE) {
            setTranslationY(f3);
            setTranslationX(f2);
            return;
        }
        ArrayList arrayList = new ArrayList(5);
        if (this.f25505g.f25516e == a.C0478a.FROM_MASTER_VIEW) {
            arrayList.add(ObjectAnimator.ofInt(this, "translationY", new int[]{(this.j + (this.f25506h.getHeight() / 2)) - (getHeight() / 2), i5}));
            arrayList.add(ObjectAnimator.ofInt(this, "translationX", new int[]{(this.k + (this.f25506h.getWidth() / 2)) - (this.l / 2), max2}));
        } else if (this.f25505g.f25516e == a.C0478a.FROM_TOP) {
            arrayList.add(ObjectAnimator.ofFloat(this, "translationY", new float[]{0.0f, f3}));
        }
        arrayList.add(ObjectAnimator.ofFloat(this, "scaleX", new float[]{0.0f, 1.0f}));
        arrayList.add(ObjectAnimator.ofFloat(this, "scaleY", new float[]{0.0f, 1.0f}));
        arrayList.add(ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f}));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        if (Build.VERSION.SDK_INT < 11) {
            animatorSet.addListener(new a(f2, f3));
        }
        animatorSet.start();
    }

    public void setPointerCenterX(int i2) {
        int max = i2 - (Math.max(this.f25499a.getMeasuredWidth(), this.f25504f.getMeasuredWidth()) / 2);
        this.f25499a.setX((float) (max - ((int) getX())));
        this.f25504f.setX((float) (max - ((int) getX())));
    }

    public void setOnToolTipViewClickedListener(c cVar) {
        this.m = cVar;
    }

    public void setColor(int i2) {
        this.f25499a.setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
        this.f25504f.setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
        this.f25500b.setBackgroundColor(i2);
    }

    private void setContentView(View view) {
        this.f25500b.removeAllViews();
        this.f25500b.addView(view);
    }

    public final void a() {
        if (Build.VERSION.SDK_INT < 11) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            setX((float) layoutParams.leftMargin);
            setY((float) layoutParams.topMargin);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            setLayoutParams(layoutParams);
        }
        if (this.f25505g.f25516e != a.C0478a.NONE) {
            ArrayList arrayList = new ArrayList(5);
            if (this.f25505g.f25516e == a.C0478a.FROM_MASTER_VIEW) {
                arrayList.add(ObjectAnimator.ofInt(this, "translationY", new int[]{(int) getY(), (this.j + (this.f25506h.getHeight() / 2)) - (getHeight() / 2)}));
                arrayList.add(ObjectAnimator.ofInt(this, "translationX", new int[]{(int) getX(), (this.k + (this.f25506h.getWidth() / 2)) - (this.l / 2)}));
            } else {
                arrayList.add(ObjectAnimator.ofFloat(this, "translationY", new float[]{getY(), 0.0f}));
            }
            arrayList.add(ObjectAnimator.ofFloat(this, "scaleX", new float[]{1.0f, 0.0f}));
            arrayList.add(ObjectAnimator.ofFloat(this, "scaleY", new float[]{1.0f, 0.0f}));
            arrayList.add(ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f}));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.addListener(new b(this, (byte) 0));
            animatorSet.start();
        } else if (getParent() != null) {
            ((ViewManager) getParent()).removeView(this);
        }
    }

    public void onClick(View view) {
        a();
    }

    public float getX() {
        if (Build.VERSION.SDK_INT >= 11) {
            return super.getX();
        }
        return getX();
    }

    public void setX(float f2) {
        if (Build.VERSION.SDK_INT >= 11) {
            super.setX(f2);
        } else {
            setX(f2);
        }
    }

    public float getY() {
        if (Build.VERSION.SDK_INT >= 11) {
            return super.getY();
        }
        return getY();
    }

    public void setY(float f2) {
        if (Build.VERSION.SDK_INT >= 11) {
            super.setY(f2);
        } else {
            setY(f2);
        }
    }

    class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private final float f25509b;

        /* renamed from: c  reason: collision with root package name */
        private final float f25510c;

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        a(float f2, float f3) {
            this.f25509b = f2;
            this.f25510c = f3;
        }

        public final void onAnimationEnd(Animator animator) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ToolTipView.this.getLayoutParams();
            layoutParams.leftMargin = (int) this.f25509b;
            layoutParams.topMargin = (int) this.f25510c;
            ToolTipView.this.setX(0.0f);
            ToolTipView.this.setY(0.0f);
            ToolTipView.this.setLayoutParams(layoutParams);
        }
    }

    class b extends AnimatorListenerAdapter {
        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        private b() {
        }

        /* synthetic */ b(ToolTipView toolTipView, byte b2) {
            this();
        }

        public final void onAnimationEnd(Animator animator) {
            if (ToolTipView.this.getParent() != null) {
                ((ViewManager) ToolTipView.this.getParent()).removeView(ToolTipView.this);
            }
        }
    }
}

package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public final class Snackbar extends BaseTransientBottomBar<Snackbar> {

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f36694h = {R.attr.snackbarButtonStyle};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f36695i = {R.attr.snackbarButtonStyle, R.attr.snackbarTextViewStyle};

    /* renamed from: f  reason: collision with root package name */
    private final AccessibilityManager f36696f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f36697g;

    public static class a extends BaseTransientBottomBar.a<Snackbar> {
        public void a(Snackbar snackbar) {
        }

        public void a(Snackbar snackbar, int i2) {
        }
    }

    private Snackbar(ViewGroup viewGroup, View view, a aVar) {
        super(viewGroup, view, aVar);
        this.f36696f = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    public final void c() {
        super.c();
    }

    public final void d() {
        super.d();
    }

    public final boolean e() {
        return super.e();
    }

    public static Snackbar a(View view, int i2, int i3) {
        return a(view, view.getResources().getText(i2), i3);
    }

    public final Snackbar a(CharSequence charSequence) {
        ((SnackbarContentLayout) this.f36658c.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    public final Snackbar a(CharSequence charSequence, final View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.f36658c.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener((View.OnClickListener) null);
            this.f36697g = false;
        } else {
            this.f36697g = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    onClickListener.onClick(view);
                    Snackbar.this.a(1);
                }
            });
        }
        return this;
    }

    public final int a() {
        int a2 = super.a();
        if (a2 == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f36696f.getRecommendedTimeoutMillis(a2, (this.f36697g ? 4 : 0) | 1 | 2);
        } else if (!this.f36697g || !this.f36696f.isTouchExplorationEnabled()) {
            return a2;
        } else {
            return -2;
        }
    }

    public final Snackbar d(int i2) {
        ((SnackbarContentLayout) this.f36658c.getChildAt(0)).getActionView().setTextColor(i2);
        return this;
    }

    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public final /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        public final /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public final /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        public final /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        public final /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }

    public static Snackbar a(View view, CharSequence charSequence, int i2) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        while (true) {
            if (!(view instanceof CoordinatorLayout)) {
                if (view instanceof FrameLayout) {
                    if (view.getId() == 16908290) {
                        viewGroup = (ViewGroup) view;
                        break;
                    }
                    viewGroup2 = (ViewGroup) view;
                }
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof View) {
                        view = (View) parent;
                        continue;
                    } else {
                        view = null;
                        continue;
                    }
                }
                if (view == null) {
                    viewGroup = viewGroup2;
                    break;
                }
            } else {
                viewGroup = (ViewGroup) view;
                break;
            }
        }
        if (viewGroup != null) {
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes(f36695i);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            boolean z = true;
            int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
            obtainStyledAttributes.recycle();
            if (resourceId == -1 || resourceId2 == -1) {
                z = false;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(z ? R.layout.mtrl_layout_snackbar_include : R.layout.design_layout_snackbar_include, viewGroup, false);
            Snackbar snackbar = new Snackbar(viewGroup, snackbarContentLayout, snackbarContentLayout);
            snackbar.a(charSequence);
            snackbar.f36659d = i2;
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    public final Snackbar a(int i2, View.OnClickListener onClickListener) {
        return a(this.f36657b.getText(i2), onClickListener);
    }
}

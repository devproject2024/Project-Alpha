package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.a.a.a;
import androidx.core.h.a.c;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.h.b;
import com.google.android.material.k.h;
import com.google.android.material.k.m;
import com.google.android.material.textfield.TextInputLayout;

final class d extends e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f36814a = (Build.VERSION.SDK_INT >= 21);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final TextWatcher f36815b = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            final AutoCompleteTextView a2 = d.a(d.this.f36833c.getEditText());
            a2.post(new Runnable() {
                public final void run() {
                    boolean isPopupShowing = a2.isPopupShowing();
                    d.this.b(isPopupShowing);
                    boolean unused = d.this.j = isPopupShowing;
                }
            });
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final View.OnFocusChangeListener f36816f = new View.OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            d.this.f36833c.setEndIconActivated(z);
            if (!z) {
                d.this.b(false);
                boolean unused = d.this.j = false;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final TextInputLayout.a f36817g = new TextInputLayout.a(this.f36833c) {
        public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            if (d.this.f36833c.getEditText().getKeyListener() == null) {
                cVar.b((CharSequence) Spinner.class.getName());
            }
            boolean z = false;
            if (Build.VERSION.SDK_INT >= 26) {
                z = cVar.f3041a.isShowingHintText();
            } else {
                Bundle e2 = cVar.e();
                if (e2 != null && (e2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 4) == 4) {
                    z = true;
                }
            }
            if (z) {
                cVar.f((CharSequence) null);
            }
        }

        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView a2 = d.a(d.this.f36833c.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.o.isTouchExplorationEnabled()) {
                d.a(d.this, a2);
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final TextInputLayout.b f36818h = new TextInputLayout.b() {
        public final void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView a2 = d.a(textInputLayout.getEditText());
            d.b(d.this, a2);
            d.c(d.this, a2);
            d.d(d.this, a2);
            a2.setThreshold(0);
            a2.removeTextChangedListener(d.this.f36815b);
            a2.addTextChangedListener(d.this.f36815b);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f36817g);
            textInputLayout.setEndIconVisible(true);
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final TextInputLayout.c f36819i = new TextInputLayout.c() {
        public final void a(TextInputLayout textInputLayout, int i2) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i2 == 3) {
                autoCompleteTextView.removeTextChangedListener(d.this.f36815b);
                if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f36816f) {
                    autoCompleteTextView.setOnFocusChangeListener((View.OnFocusChangeListener) null);
                }
                autoCompleteTextView.setOnTouchListener((View.OnTouchListener) null);
                if (d.f36814a) {
                    autoCompleteTextView.setOnDismissListener((AutoCompleteTextView.OnDismissListener) null);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean j = false;
    /* access modifiers changed from: private */
    public boolean k = false;
    /* access modifiers changed from: private */
    public long l = Long.MAX_VALUE;
    private StateListDrawable m;
    private h n;
    /* access modifiers changed from: private */
    public AccessibilityManager o;
    private ValueAnimator p;
    /* access modifiers changed from: private */
    public ValueAnimator q;

    /* access modifiers changed from: package-private */
    public final boolean a(int i2) {
        return i2 != 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return true;
    }

    d(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        float dimensionPixelOffset = (float) this.f36834d.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.f36834d.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f36834d.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        h a2 = a(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        h a3 = a(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.n = a2;
        this.m = new StateListDrawable();
        this.m.addState(new int[]{16842922}, a2);
        this.m.addState(new int[0], a3);
        this.f36833c.setEndIconDrawable(a.b(this.f36834d, f36814a ? R.drawable.mtrl_dropdown_arrow : R.drawable.mtrl_ic_arrow_drop_down));
        this.f36833c.setEndIconContentDescription(this.f36833c.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.f36833c.setEndIconOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.a(d.this, (AutoCompleteTextView) d.this.f36833c.getEditText());
            }
        });
        this.f36833c.a(this.f36818h);
        this.f36833c.a(this.f36819i);
        this.q = a(67, 0.0f, 1.0f);
        this.p = a(50, 1.0f, 0.0f);
        this.p.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                d.this.f36835e.setChecked(d.this.k);
                d.this.q.start();
            }
        });
        u.c((View) this.f36835e, 2);
        this.o = (AccessibilityManager) this.f36834d.getSystemService("accessibility");
    }

    private h a(float f2, float f3, float f4, int i2) {
        m a2 = m.a().b(f2).c(f2).e(f3).d(f3).a();
        h a3 = h.a(this.f36834d, f4);
        a3.setShapeAppearanceModel(a2);
        a3.a(i2, i2);
        return a3;
    }

    /* access modifiers changed from: private */
    public boolean d() {
        long currentTimeMillis = System.currentTimeMillis() - this.l;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        if (this.k != z) {
            this.k = z;
            this.q.cancel();
            this.p.start();
        }
    }

    private ValueAnimator a(int i2, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.a.a.f35800a);
        ofFloat.setDuration((long) i2);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.f36835e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    static /* synthetic */ AutoCompleteTextView a(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    static /* synthetic */ void a(d dVar, AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView != null) {
            if (dVar.d()) {
                dVar.j = false;
            }
            if (!dVar.j) {
                if (f36814a) {
                    dVar.b(!dVar.k);
                } else {
                    dVar.k = !dVar.k;
                    dVar.f36835e.toggle();
                }
                if (dVar.k) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            dVar.j = false;
        }
    }

    static /* synthetic */ void b(d dVar, AutoCompleteTextView autoCompleteTextView) {
        if (f36814a) {
            int boxBackgroundMode = dVar.f36833c.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(dVar.n);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(dVar.m);
            }
        }
    }

    static /* synthetic */ void c(d dVar, AutoCompleteTextView autoCompleteTextView) {
        LayerDrawable layerDrawable;
        if (autoCompleteTextView.getKeyListener() == null) {
            int boxBackgroundMode = dVar.f36833c.getBoxBackgroundMode();
            h boxBackground = dVar.f36833c.getBoxBackground();
            int a2 = b.a((View) autoCompleteTextView, R.attr.colorControlHighlight);
            int[][] iArr = {new int[]{16842919}, new int[0]};
            if (boxBackgroundMode == 2) {
                int a3 = b.a((View) autoCompleteTextView, R.attr.colorSurface);
                h hVar = new h(boxBackground.G.f36536a);
                int a4 = com.google.android.material.b.a.a(a2, a3, 0.1f);
                hVar.g(new ColorStateList(iArr, new int[]{a4, 0}));
                if (f36814a) {
                    hVar.setTint(a3);
                    ColorStateList colorStateList = new ColorStateList(iArr, new int[]{a4, a3});
                    h hVar2 = new h(boxBackground.G.f36536a);
                    hVar2.setTint(-1);
                    layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, hVar, hVar2), boxBackground});
                } else {
                    layerDrawable = new LayerDrawable(new Drawable[]{hVar, boxBackground});
                }
                u.a((View) autoCompleteTextView, (Drawable) layerDrawable);
            } else if (boxBackgroundMode == 1) {
                int boxBackgroundColor = dVar.f36833c.getBoxBackgroundColor();
                int[] iArr2 = {com.google.android.material.b.a.a(a2, boxBackgroundColor, 0.1f), boxBackgroundColor};
                if (f36814a) {
                    u.a((View) autoCompleteTextView, (Drawable) new RippleDrawable(new ColorStateList(iArr, iArr2), boxBackground, boxBackground));
                    return;
                }
                h hVar3 = new h(boxBackground.G.f36536a);
                hVar3.g(new ColorStateList(iArr, iArr2));
                LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{boxBackground, hVar3});
                int m2 = u.m(autoCompleteTextView);
                int paddingTop = autoCompleteTextView.getPaddingTop();
                int n2 = u.n(autoCompleteTextView);
                int paddingBottom = autoCompleteTextView.getPaddingBottom();
                u.a((View) autoCompleteTextView, (Drawable) layerDrawable2);
                u.b(autoCompleteTextView, m2, paddingTop, n2, paddingBottom);
            }
        }
    }

    static /* synthetic */ void d(d dVar, final AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    if (d.this.d()) {
                        boolean unused = d.this.j = false;
                    }
                    d.a(d.this, autoCompleteTextView);
                }
                return false;
            }
        });
        autoCompleteTextView.setOnFocusChangeListener(dVar.f36816f);
        if (f36814a) {
            autoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() {
                public final void onDismiss() {
                    boolean unused = d.this.j = true;
                    long unused2 = d.this.l = System.currentTimeMillis();
                    d.this.b(false);
                }
            });
        }
    }
}

package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.core.h.u;
import androidx.core.h.x;

public class ActionBarContextView extends a {

    /* renamed from: g  reason: collision with root package name */
    public boolean f1401g;

    /* renamed from: h  reason: collision with root package name */
    private CharSequence f1402h;

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f1403i;
    private View j;
    private View k;
    private LinearLayout l;
    private TextView m;
    private TextView n;
    private int o;
    private int p;
    private int q;

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public final /* bridge */ /* synthetic */ x a(int i2, long j2) {
        return super.a(i2, j2);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ac a2 = ac.a(context, attributeSet, R.styleable.ActionMode, i2, 0);
        u.a((View) this, a2.a(R.styleable.ActionMode_background));
        this.o = a2.g(R.styleable.ActionMode_titleTextStyle, 0);
        this.p = a2.g(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f1657e = a2.f(R.styleable.ActionMode_height, 0);
        this.q = a2.g(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        a2.f1669a.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1656d != null) {
            this.f1656d.g();
            this.f1656d.i();
        }
    }

    public void setContentHeight(int i2) {
        this.f1657e = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.k;
        if (view2 != null) {
            removeView(view2);
        }
        this.k = view;
        if (!(view == null || (linearLayout = this.l) == null)) {
            removeView(linearLayout);
            this.l = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1402h = charSequence;
        d();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1403i = charSequence;
        d();
    }

    public CharSequence getTitle() {
        return this.f1402h;
    }

    public CharSequence getSubtitle() {
        return this.f1403i;
    }

    private void d() {
        if (this.l == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            this.l = (LinearLayout) getChildAt(getChildCount() - 1);
            this.m = (TextView) this.l.findViewById(R.id.action_bar_title);
            this.n = (TextView) this.l.findViewById(R.id.action_bar_subtitle);
            if (this.o != 0) {
                this.m.setTextAppearance(getContext(), this.o);
            }
            if (this.p != 0) {
                this.n.setTextAppearance(getContext(), this.p);
            }
        }
        this.m.setText(this.f1402h);
        this.n.setText(this.f1403i);
        boolean z = !TextUtils.isEmpty(this.f1402h);
        boolean z2 = !TextUtils.isEmpty(this.f1403i);
        int i2 = 0;
        this.n.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = this.l;
        if (!z && !z2) {
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
        if (this.l.getParent() == null) {
            addView(this.l);
        }
    }

    public final void a(final b bVar) {
        View view = this.j;
        if (view == null) {
            this.j = LayoutInflater.from(getContext()).inflate(this.q, this, false);
            addView(this.j);
        } else if (view.getParent() == null) {
            addView(this.j);
        }
        this.j.findViewById(R.id.action_mode_close_button).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                bVar.c();
            }
        });
        g gVar = (g) bVar.b();
        if (this.f1656d != null) {
            this.f1656d.h();
        }
        this.f1656d = new ActionMenuPresenter(getContext());
        this.f1656d.d();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        gVar.a((m) this.f1656d, this.f1654b);
        this.f1655c = (ActionMenuView) this.f1656d.a((ViewGroup) this);
        u.a((View) this.f1655c, (Drawable) null);
        addView(this.f1655c, layoutParams);
    }

    public final void b() {
        if (this.j == null) {
            c();
        }
    }

    public final void c() {
        removeAllViews();
        this.k = null;
        this.f1655c = null;
    }

    public final boolean a() {
        if (this.f1656d != null) {
            return this.f1656d.e();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4 = 1073741824;
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i3) != 0) {
            int size = View.MeasureSpec.getSize(i2);
            int size2 = this.f1657e > 0 ? this.f1657e : View.MeasureSpec.getSize(i3);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            View view = this.j;
            if (view != null) {
                int a2 = a(view, paddingLeft, makeMeasureSpec);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
                paddingLeft = a2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            if (this.f1655c != null && this.f1655c.getParent() == this) {
                paddingLeft = a((View) this.f1655c, paddingLeft, makeMeasureSpec);
            }
            LinearLayout linearLayout = this.l;
            if (linearLayout != null && this.k == null) {
                if (this.f1401g) {
                    this.l.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.l.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.l.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = a((View) linearLayout, paddingLeft, makeMeasureSpec);
                }
            }
            View view2 = this.k;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i6 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i4 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    i5 = Math.min(layoutParams.height, i5);
                }
                this.k.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(i5, i4));
            }
            if (this.f1657e <= 0) {
                int childCount = getChildCount();
                int i7 = 0;
                for (int i8 = 0; i8 < childCount; i8++) {
                    int measuredHeight = getChildAt(i8).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i7) {
                        i7 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i7);
                return;
            }
            setMeasuredDimension(size, size2);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean a2 = ai.a(this);
        int paddingRight = a2 ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.j;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
            int i6 = a2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = a2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a3 = a(paddingRight, i6, a2);
            paddingRight = a(a3 + a(this.j, a3, paddingTop, paddingTop2, a2), i7, a2);
        }
        LinearLayout linearLayout = this.l;
        if (!(linearLayout == null || this.k != null || linearLayout.getVisibility() == 8)) {
            paddingRight += a(this.l, paddingRight, paddingTop, paddingTop2, a2);
        }
        View view2 = this.k;
        if (view2 != null) {
            a(view2, paddingRight, paddingTop, paddingTop2, a2);
        }
        int paddingLeft = a2 ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        if (this.f1655c != null) {
            a(this.f1655c, paddingLeft, paddingTop, paddingTop2, !a2);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1402h);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1401g) {
            requestLayout();
        }
        this.f1401g = z;
    }
}

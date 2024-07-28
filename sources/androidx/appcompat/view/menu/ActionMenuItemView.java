package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ae;
import androidx.appcompat.widget.r;

public class ActionMenuItemView extends AppCompatTextView implements View.OnClickListener, n.a, ActionMenuView.a {

    /* renamed from: a  reason: collision with root package name */
    i f1258a;

    /* renamed from: b  reason: collision with root package name */
    g.b f1259b;

    /* renamed from: c  reason: collision with root package name */
    b f1260c;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f1261e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f1262f;

    /* renamed from: g  reason: collision with root package name */
    private r f1263g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1264h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1265i;
    private int j;
    private int k;
    private int l;

    public static abstract class b {
        public abstract p a();
    }

    public final boolean a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setShortcut(boolean z, char c2) {
    }

    public ActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.f1264h = e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i2, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.k = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1264h = e();
        f();
    }

    private boolean e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (i2 < 480) {
            return (i2 >= 640 && i3 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.k = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public i getItemData() {
        return this.f1258a;
    }

    public final void a(i iVar) {
        this.f1258a = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.a((n.a) this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f1263g == null) {
            this.f1263g = new a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        r rVar;
        if (!this.f1258a.hasSubMenu() || (rVar = this.f1263g) == null || !rVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void onClick(View view) {
        g.b bVar = this.f1259b;
        if (bVar != null) {
            bVar.a(this.f1258a);
        }
    }

    public void setItemInvoker(g.b bVar) {
        this.f1259b = bVar;
    }

    public void setPopupCallback(b bVar) {
        this.f1260c = bVar;
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1265i != z) {
            this.f1265i = z;
            i iVar = this.f1258a;
            if (iVar != null) {
                iVar.f1351d.h();
            }
        }
    }

    private void f() {
        CharSequence charSequence;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f1261e);
        if (this.f1262f != null && (!this.f1258a.i() || (!this.f1264h && !this.f1265i))) {
            z = false;
        }
        boolean z3 = z2 & z;
        CharSequence charSequence2 = null;
        setText(z3 ? this.f1261e : null);
        CharSequence contentDescription = this.f1258a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z3) {
                charSequence = null;
            } else {
                charSequence = this.f1258a.getTitle();
            }
            setContentDescription(charSequence);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f1258a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z3) {
                charSequence2 = this.f1258a.getTitle();
            }
            ae.a(this, charSequence2);
            return;
        }
        ae.a(this, tooltipText);
    }

    public void setIcon(Drawable drawable) {
        this.f1262f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.l;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i2) / ((float) intrinsicWidth)));
                intrinsicWidth = i2;
            }
            int i3 = this.l;
            if (intrinsicHeight > i3) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i3) / ((float) intrinsicHeight)));
                intrinsicHeight = i3;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        f();
    }

    public final boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f1261e = charSequence;
        f();
    }

    public final boolean c() {
        return b() && this.f1258a.getIcon() == null;
    }

    public final boolean d() {
        return b();
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        boolean b2 = b();
        if (b2 && (i5 = this.k) >= 0) {
            super.setPadding(i5, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i4 = Math.min(size, this.j);
        } else {
            i4 = this.j;
        }
        if (mode != 1073741824 && this.j > 0 && measuredWidth < i4) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
        }
        if (!b2 && this.f1262f != null) {
            super.setPadding((getMeasuredWidth() - this.f1262f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    class a extends r {
        public a() {
            super(ActionMenuItemView.this);
        }

        public final p a() {
            if (ActionMenuItemView.this.f1260c != null) {
                return ActionMenuItemView.this.f1260c.a();
            }
            return null;
        }

        public final boolean b() {
            p a2;
            if (ActionMenuItemView.this.f1259b == null || !ActionMenuItemView.this.f1259b.a(ActionMenuItemView.this.f1258a) || (a2 = a()) == null || !a2.e()) {
                return false;
            }
            return true;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }
}

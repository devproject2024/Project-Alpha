package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R;

final class ag {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1697a;

    /* renamed from: b  reason: collision with root package name */
    private final View f1698b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f1699c;

    /* renamed from: d  reason: collision with root package name */
    private final WindowManager.LayoutParams f1700d = new WindowManager.LayoutParams();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f1701e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final int[] f1702f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    private final int[] f1703g = new int[2];

    ag(Context context) {
        this.f1697a = context;
        this.f1698b = LayoutInflater.from(this.f1697a).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f1699c = (TextView) this.f1698b.findViewById(R.id.message);
        this.f1700d.setTitle(getClass().getSimpleName());
        this.f1700d.packageName = this.f1697a.getPackageName();
        WindowManager.LayoutParams layoutParams = this.f1700d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        this.f1700d.flags = 24;
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, int i2, int i3, boolean z, CharSequence charSequence) {
        if (b()) {
            a();
        }
        this.f1699c.setText(charSequence);
        a(view, i2, i3, z, this.f1700d);
        ((WindowManager) this.f1697a.getSystemService("window")).addView(this.f1698b, this.f1700d);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (b()) {
            ((WindowManager) this.f1697a.getSystemService("window")).removeView(this.f1698b);
        }
    }

    private boolean b() {
        return this.f1698b.getParent() != null;
    }

    private void a(View view, int i2, int i3, boolean z, WindowManager.LayoutParams layoutParams) {
        int i4;
        int i5;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1697a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1697a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            i5 = i3 + dimensionPixelOffset2;
            i4 = i3 - dimensionPixelOffset2;
        } else {
            i5 = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1697a.getResources().getDimensionPixelOffset(z ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
        View a2 = a(view);
        if (a2 != null) {
            a2.getWindowVisibleDisplayFrame(this.f1701e);
            if (this.f1701e.left < 0 && this.f1701e.top < 0) {
                Resources resources = this.f1697a.getResources();
                int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                this.f1701e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            a2.getLocationOnScreen(this.f1703g);
            view.getLocationOnScreen(this.f1702f);
            int[] iArr = this.f1702f;
            int i6 = iArr[0];
            int[] iArr2 = this.f1703g;
            iArr[0] = i6 - iArr2[0];
            iArr[1] = iArr[1] - iArr2[1];
            layoutParams.x = (iArr[0] + i2) - (a2.getWidth() / 2);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.f1698b.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredHeight = this.f1698b.getMeasuredHeight();
            int[] iArr3 = this.f1702f;
            int i7 = ((iArr3[1] + i4) - dimensionPixelOffset3) - measuredHeight;
            int i8 = iArr3[1] + i5 + dimensionPixelOffset3;
            if (z) {
                if (i7 < 0) {
                    layoutParams.y = i8;
                    return;
                }
            } else if (measuredHeight + i8 <= this.f1701e.height()) {
                layoutParams.y = i8;
                return;
            }
            layoutParams.y = i7;
        }
    }

    private static View a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}

package net.one97.paytm.upi.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import net.one97.paytm.upi.R;

public class CustomSnackbar {
    private int background = -1;
    private View contentView;
    private LENGTH duration = LENGTH.LONG;
    private int layout = -1;
    private LayoutInflater layoutInflater;
    private Snackbar snackbar;
    /* access modifiers changed from: private */
    public Snackbar.SnackbarLayout snackbarView;
    private boolean swipe = true;

    public enum LENGTH {
        INDEFINITE,
        SHORT,
        LONG
    }

    private CustomSnackbar(Context context) {
        this.layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public static CustomSnackbar Builder(Context context) {
        return new CustomSnackbar(context);
    }

    public CustomSnackbar layout(int i2) {
        this.layout = i2;
        return this;
    }

    public CustomSnackbar background(int i2) {
        this.background = i2;
        return this;
    }

    public CustomSnackbar duration(LENGTH length) {
        this.duration = length;
        return this;
    }

    public CustomSnackbar swipe(boolean z) {
        this.swipe = z;
        return this;
    }

    /* renamed from: net.one97.paytm.upi.util.CustomSnackbar$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f69532a = new int[LENGTH.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                net.one97.paytm.upi.util.CustomSnackbar$LENGTH[] r0 = net.one97.paytm.upi.util.CustomSnackbar.LENGTH.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f69532a = r0
                int[] r0 = f69532a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.upi.util.CustomSnackbar$LENGTH r1 = net.one97.paytm.upi.util.CustomSnackbar.LENGTH.INDEFINITE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f69532a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.upi.util.CustomSnackbar$LENGTH r1 = net.one97.paytm.upi.util.CustomSnackbar.LENGTH.SHORT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f69532a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.upi.util.CustomSnackbar$LENGTH r1 = net.one97.paytm.upi.util.CustomSnackbar.LENGTH.LONG     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.util.CustomSnackbar.AnonymousClass2.<clinit>():void");
        }
    }

    public CustomSnackbar build(View view) {
        if (view == null) {
            throw new CustomSnackbarException("view can not be null");
        } else if (this.layout != -1) {
            int i2 = AnonymousClass2.f69532a[this.duration.ordinal()];
            if (i2 == 1) {
                this.snackbar = Snackbar.a(view, (CharSequence) "", -2);
            } else if (i2 == 2) {
                this.snackbar = Snackbar.a(view, (CharSequence) "", -1);
            } else if (i2 == 3) {
                this.snackbar = Snackbar.a(view, (CharSequence) "", 0);
            }
            this.snackbarView = (Snackbar.SnackbarLayout) this.snackbar.b();
            ViewGroup.LayoutParams layoutParams = this.snackbarView.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                ((CoordinatorLayout.d) layoutParams).f2605c = 48;
            } else {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 48;
            }
            this.snackbar.b().setLayoutParams(layoutParams);
            this.snackbarView.setLayoutParams(layoutParams);
            if (!this.swipe) {
                this.snackbarView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public final boolean onPreDraw() {
                        CustomSnackbar.this.snackbarView.getViewTreeObserver().removeOnPreDrawListener(this);
                        ((CoordinatorLayout.d) CustomSnackbar.this.snackbarView.getLayoutParams()).a((CoordinatorLayout.Behavior) null);
                        return true;
                    }
                });
            }
            this.snackbarView.setPadding(0, 0, 0, 0);
            int i3 = this.background;
            if (i3 != -1) {
                this.snackbarView.setBackgroundResource(i3);
            }
            ((TextView) this.snackbarView.findViewById(R.id.snackbar_text)).setVisibility(4);
            ((TextView) this.snackbarView.findViewById(R.id.snackbar_action)).setVisibility(4);
            this.contentView = this.layoutInflater.inflate(this.layout, (ViewGroup) null);
            this.snackbarView.addView(this.contentView, 0);
            return this;
        } else {
            throw new CustomSnackbarException("layout must be setted");
        }
    }

    public void show() {
        this.snackbar.c();
    }

    public boolean isShowing() {
        Snackbar snackbar2 = this.snackbar;
        return snackbar2 != null && snackbar2.e();
    }

    public void dismiss() {
        Snackbar snackbar2 = this.snackbar;
        if (snackbar2 != null) {
            snackbar2.d();
        }
    }

    public View getContentView() {
        return this.contentView;
    }

    public class CustomSnackbarException extends RuntimeException {
        public CustomSnackbarException(String str) {
            super(str);
        }
    }
}

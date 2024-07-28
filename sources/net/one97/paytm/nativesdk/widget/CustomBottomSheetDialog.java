package net.one97.paytm.nativesdk.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.f;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.a;
import androidx.core.h.a.c;
import androidx.core.h.u;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import net.one97.paytm.nativesdk.R;

public class CustomBottomSheetDialog extends f {
    public BottomSheetBehavior<FrameLayout> mBehavior;
    private BottomSheetBehavior.a mBottomSheetCallback;
    boolean mCancelable;
    private boolean mCanceledOnTouchOutside;
    private boolean mCanceledOnTouchOutsideSet;

    public CustomBottomSheetDialog(Context context) {
        this(context, 0);
    }

    public CustomBottomSheetDialog(Context context, int i2) {
        super(context, getThemeResId(context, i2));
        this.mCancelable = true;
        this.mCanceledOnTouchOutside = true;
        this.mBottomSheetCallback = new BottomSheetBehavior.a() {
            public void onSlide(View view, float f2) {
            }

            public void onStateChanged(View view, int i2) {
                if (i2 == 1) {
                    CustomBottomSheetDialog.this.mBehavior.setState(3);
                }
                if (i2 == 5) {
                    CustomBottomSheetDialog.this.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
    }

    protected CustomBottomSheetDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mCancelable = true;
        this.mCanceledOnTouchOutside = true;
        this.mBottomSheetCallback = new BottomSheetBehavior.a() {
            public void onSlide(View view, float f2) {
            }

            public void onStateChanged(View view, int i2) {
                if (i2 == 1) {
                    CustomBottomSheetDialog.this.mBehavior.setState(3);
                }
                if (i2 == 5) {
                    CustomBottomSheetDialog.this.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
        this.mCancelable = z;
    }

    public void setContentView(int i2) {
        super.setContentView(wrapInBottomSheet(i2, (View) null, (ViewGroup.LayoutParams) null));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    public void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(0, view, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams));
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.mCancelable != z) {
            this.mCancelable = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.mBehavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(3);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.mCancelable) {
            this.mCancelable = true;
        }
        this.mCanceledOnTouchOutside = z;
        this.mCanceledOnTouchOutsideSet = true;
    }

    private View wrapInBottomSheet(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_custom_bottom_sheet_dialog, (ViewGroup) null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, coordinatorLayout, false);
        }
        FrameLayout frameLayout2 = (FrameLayout) coordinatorLayout.findViewById(R.id.design_bottom_sheet);
        this.mBehavior = BottomSheetBehavior.from(frameLayout2);
        this.mBehavior.setBottomSheetCallback(this.mBottomSheetCallback);
        this.mBehavior.setHideable(this.mCancelable);
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (CustomBottomSheetDialog.this.mCancelable && CustomBottomSheetDialog.this.isShowing() && CustomBottomSheetDialog.this.shouldWindowCloseOnTouchOutside()) {
                    CustomBottomSheetDialog.this.cancel();
                }
            }
        });
        u.a((View) frameLayout2, (a) new a() {
            public void onInitializeAccessibilityNodeInfo(View view, c cVar) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                if (CustomBottomSheetDialog.this.mCancelable) {
                    cVar.a(1048576);
                    cVar.k(true);
                    return;
                }
                cVar.k(false);
            }

            public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
                if (i2 != 1048576 || !CustomBottomSheetDialog.this.mCancelable) {
                    return super.performAccessibilityAction(view, i2, bundle);
                }
                CustomBottomSheetDialog.this.cancel();
                return true;
            }
        });
        frameLayout2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return frameLayout;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldWindowCloseOnTouchOutside() {
        if (!this.mCanceledOnTouchOutsideSet) {
            if (Build.VERSION.SDK_INT < 11) {
                this.mCanceledOnTouchOutside = true;
            } else {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
                this.mCanceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
            this.mCanceledOnTouchOutsideSet = true;
        }
        return this.mCanceledOnTouchOutside;
    }

    private static int getThemeResId(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return R.style.Theme_Design_Light_BottomSheetDialog;
    }
}

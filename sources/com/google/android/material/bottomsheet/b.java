package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.g;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class b extends g {
    private boolean waitingForDismissAllowingStateLoss;

    public Dialog onCreateDialog(Bundle bundle) {
        return new a(getContext(), getTheme());
    }

    public void dismiss() {
        if (!tryDismissWithAnimation(false)) {
            super.dismiss();
        }
    }

    public void dismissAllowingStateLoss() {
        if (!tryDismissWithAnimation(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    private boolean tryDismissWithAnimation(boolean z) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof a)) {
            return false;
        }
        a aVar = (a) dialog;
        BottomSheetBehavior<FrameLayout> a2 = aVar.a();
        if (!a2.isHideable() || !aVar.f36011b) {
            return false;
        }
        dismissWithAnimation(a2, z);
        return true;
    }

    private void dismissWithAnimation(BottomSheetBehavior<?> bottomSheetBehavior, boolean z) {
        this.waitingForDismissAllowingStateLoss = z;
        if (bottomSheetBehavior.getState() == 5) {
            dismissAfterAnimation();
            return;
        }
        if (getDialog() instanceof a) {
            a aVar = (a) getDialog();
            aVar.f36010a.removeBottomSheetCallback(aVar.f36015f);
        }
        bottomSheetBehavior.addBottomSheetCallback(new a(this, (byte) 0));
        bottomSheetBehavior.setState(5);
    }

    /* access modifiers changed from: private */
    public void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    class a extends BottomSheetBehavior.a {
        public final void onSlide(View view, float f2) {
        }

        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        public final void onStateChanged(View view, int i2) {
            if (i2 == 5) {
                b.this.dismissAfterAnimation();
            }
        }
    }
}

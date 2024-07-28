package net.one97.paytm.nativesdk.common.view.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.widget.CustomBottomSheetDialog;

public class CustomBottomSheetDialogFragment extends f {
    private boolean isFullScreen = false;

    public Dialog onCreateDialog(Bundle bundle) {
        return new CustomBottomSheetDialog(getContext(), getTheme());
    }

    public void setFullScreen(boolean z) {
        this.isFullScreen = z;
    }

    public void show(j jVar, String str) {
        try {
            q a2 = jVar.a();
            a2.a((Fragment) this, str);
            a2.c();
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public void onStart() {
        super.onStart();
        if (this.isFullScreen) {
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.findViewById(R.id.design_bottom_sheet).getLayoutParams().height = -1;
            }
            final View view = getView();
            if (view != null) {
                view.post(new Runnable() {
                    public void run() {
                        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) ((CoordinatorLayout.d) ((View) view.getParent()).getLayoutParams()).f2603a;
                        if (bottomSheetBehavior != null) {
                            bottomSheetBehavior.setPeekHeight(view.getMeasuredHeight());
                        }
                    }
                });
            }
        }
    }
}

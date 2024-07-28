package net.one97.paytm.upgradeKyc.d;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.upgradeKyc.R;

public final class f extends net.one97.paytm.i.f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65680a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public BottomSheetBehavior<?> f65681b;

    /* renamed from: c  reason: collision with root package name */
    private Button f65682c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f65683d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f65684e;

    public final void onClick(View view) {
        if ((view != null && view.getId() == R.id.ok_i_understant_btn) || (view != null && view.getId() == R.id.cross_iv)) {
            dismiss();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.kyc_know_more_decl_bottom_sheet, viewGroup, false);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f65685a;

        b(f fVar) {
            this.f65685a = fVar;
        }

        public final void onClick(View view) {
            this.f65685a.dismissAllowingStateLoss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f65686a;

        c(f fVar) {
            this.f65686a = fVar;
        }

        public final void onClick(View view) {
            this.f65686a.dismissAllowingStateLoss();
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.open_acc_btn);
        if (findViewById != null) {
            this.f65682c = (Button) findViewById;
            View findViewById2 = view.findViewById(R.id.full_kyc_cross_iv);
            if (findViewById2 != null) {
                this.f65683d = (ImageView) findViewById2;
                Dialog dialog = getDialog();
                if (dialog != null) {
                    dialog.setCanceledOnTouchOutside(true);
                }
                Button button = this.f65682c;
                if (button == null) {
                    k.a("mBtnConfirmBlock");
                }
                button.setOnClickListener(new b(this));
                ImageView imageView = this.f65683d;
                if (imageView == null) {
                    k.a("mIvCross");
                }
                imageView.setOnClickListener(new c(this));
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.ImageView");
        }
        throw new u("null cannot be cast to non-null type android.widget.Button");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new d(this));
            Window window = aVar.getWindow();
            if (window == null) {
                k.a();
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class d implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f65687a;

        d(f fVar) {
            this.f65687a = fVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                ViewParent parent = frameLayout.getParent();
                if (parent != null) {
                    View view = frameLayout;
                    BottomSheetBehavior from = BottomSheetBehavior.from(view);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    from.setPeekHeight(frameLayout.getHeight());
                    ((CoordinatorLayout) parent).getParent().requestLayout();
                    frameLayout.setBackgroundDrawable(new ColorDrawable(0));
                    this.f65687a.f65681b = BottomSheetBehavior.from(view);
                    f.b(this.f65687a);
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public static final class e extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f65688a;

        public final void onSlide(View view, float f2) {
            k.c(view, "bottomSheet");
        }

        e(f fVar) {
            this.f65688a = fVar;
        }

        public final void onStateChanged(View view, int i2) {
            k.c(view, "bottomSheet");
            if (i2 == 1) {
                BottomSheetBehavior a2 = this.f65688a.f65681b;
                if (a2 == null) {
                    k.a();
                }
                a2.setState(3);
            }
        }
    }

    public static final /* synthetic */ void b(f fVar) {
        e eVar = new e(fVar);
        BottomSheetBehavior<?> bottomSheetBehavior = fVar.f65681b;
        if (bottomSheetBehavior == null) {
            k.a();
        }
        bottomSheetBehavior.setBottomSheetCallback(eVar);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65684e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final f a() {
        return new f();
    }
}

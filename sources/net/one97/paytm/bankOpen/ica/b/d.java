package net.one97.paytm.bankOpen.ica.b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;

public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.bankCommon.f.d f16478a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public BottomSheetBehavior<?> f16479b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f16480c;

    public View a(int i2) {
        if (this.f16480c == null) {
            this.f16480c = new HashMap();
        }
        View view = (View) this.f16480c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f16480c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void a() {
        HashMap hashMap = this.f16480c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new a(this));
            Window window = aVar.getWindow();
            if (window == null) {
                k.a();
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class a implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f16481a;

        a(d dVar) {
            this.f16481a = dVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                frameLayout.setBackgroundDrawable(new ColorDrawable(0));
                this.f16481a.f16479b = BottomSheetBehavior.from(frameLayout);
                d.b(this.f16481a);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public static final class b extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f16482a;

        public final void onSlide(View view, float f2) {
            k.c(view, "bottomSheet");
        }

        b(d dVar) {
            this.f16482a = dVar;
        }

        public final void onStateChanged(View view, int i2) {
            k.c(view, "bottomSheet");
            if (i2 == 1) {
                BottomSheetBehavior a2 = this.f16482a.f16479b;
                if (a2 == null) {
                    k.a();
                }
                a2.setState(3);
            }
        }
    }

    public static final /* synthetic */ void b(d dVar) {
        b bVar = new b(dVar);
        BottomSheetBehavior<?> bottomSheetBehavior = dVar.f16479b;
        if (bottomSheetBehavior == null) {
            k.a();
        }
        bottomSheetBehavior.setBottomSheetCallback(bVar);
    }
}

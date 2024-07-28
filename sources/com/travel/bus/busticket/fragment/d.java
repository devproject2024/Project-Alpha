package com.travel.bus.busticket.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import net.one97.paytm.i.f;

public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f22235a;

    /* renamed from: b  reason: collision with root package name */
    private ImageButton f22236b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public BottomSheetBehavior f22237c;

    /* renamed from: d  reason: collision with root package name */
    private String f22238d = null;

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                d.this.a(dialogInterface);
            }
        });
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet);
        frameLayout.setBackgroundDrawable(new ColorDrawable(0));
        if (frameLayout != null) {
            this.f22237c = BottomSheetBehavior.from(frameLayout);
        }
        this.f22237c.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
                if (i2 == 1) {
                    d.this.f22237c.setState(3);
                }
                if (i2 == 5 && d.this.getDialog() != null) {
                    d.this.getDialog().dismiss();
                }
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.travel.bus.R.layout.disclaimer_dialog, viewGroup, false);
        this.f22235a = (ImageView) inflate.findViewById(com.travel.bus.R.id.disc_dpdp_icon);
        this.f22236b = (ImageButton) inflate.findViewById(com.travel.bus.R.id.ibDiscClose);
        this.f22236b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a(view);
            }
        });
        if (getArguments() != null) {
            this.f22238d = getArguments().getString("bp_dp_type", "");
            if (this.f22238d.equals("BP")) {
                ResourceUtils.loadBusImagesFromCDN(this.f22235a, "ic_order_summary_boarding.png", false, false, n.a.V1);
            } else if (this.f22238d.equals("DP")) {
                ResourceUtils.loadBusImagesFromCDN(this.f22235a, "ic_order_summary_dropping.png", false, false, n.a.V1);
            }
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (getDialog() != null) {
            getDialog().dismiss();
        }
    }

    public void show(j jVar, String str) {
        try {
            q a2 = jVar.a();
            a2.a((Fragment) this, str);
            a2.c();
        } catch (IllegalStateException unused) {
        }
    }
}

package net.one97.paytm.upi.registration.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.e.q;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;

public final class h extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f68882a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final String f68883b = "paytmmp://profile";

    /* renamed from: c  reason: collision with root package name */
    private HashMap f68884c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.MoneyTransferBottomSheetDialogStyle);
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, "screen_open", "", "", "", GAConstants.SCREEN_NAME.UPI_ACC_SWITCH_LOGIN, "");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new b(this));
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f68885a;

        b(h hVar) {
            this.f68885a = hVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    Context context = this.f68885a.getContext();
                    if (context != null) {
                        frameLayout.setBackgroundColor(androidx.core.content.b.c(context, R.color.transparent));
                    }
                    from.setState(3);
                    from.setPeekHeight(200);
                    from.setHideable(true);
                    from.setSkipCollapsed(true);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_new_reg_bottomsheet, viewGroup, false);
        q a2 = q.a(inflate);
        k.a((Object) a2, "FragmentNewRegBottomsheetBinding.bind(view)");
        a2.f66869a.setOnClickListener(new c(this));
        a2.f66876h.setOnClickListener(new d(this));
        a2.f66871c.setOnClickListener(new e(this));
        return inflate;
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f68886a;

        c(h hVar) {
            this.f68886a = hVar;
        }

        public final void onClick(View view) {
            h.a(this.f68886a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f68887a;

        d(h hVar) {
            this.f68887a = hVar;
        }

        public final void onClick(View view) {
            h.b(this.f68887a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f68888a;

        e(h hVar) {
            this.f68888a = hVar;
        }

        public final void onClick(View view) {
            h.c(this.f68888a);
        }
    }

    private final void a(String str) {
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, GAConstants.ACTION.BANK_ACC_DROPUP_ACTION_CLICKED, str, "", "", GAConstants.SCREEN_NAME.UPI_ACC_SWITCH_LOGIN, "");
    }

    public static final /* synthetic */ void a(h hVar) {
        if (hVar.isAdded()) {
            hVar.dismiss();
        }
    }

    public static final /* synthetic */ void b(h hVar) {
        net.one97.paytm.upi.h c2;
        if (hVar.isAdded()) {
            i a2 = i.a();
            if (!(a2 == null || (c2 = a2.c()) == null)) {
                c2.a((Activity) hVar.getActivity(), hVar.f68883b);
            }
            hVar.dismiss();
            FragmentActivity activity = hVar.getActivity();
            if (activity != null) {
                activity.finish();
            }
            hVar.a(GAConstants.LABEL.ACCOUNT_REPLACE);
        }
    }

    public static final /* synthetic */ void c(h hVar) {
        net.one97.paytm.upi.h c2;
        if (hVar.isAdded()) {
            i a2 = i.a();
            if (!(a2 == null || (c2 = a2.c()) == null)) {
                c2.b((Activity) hVar.getActivity());
            }
            hVar.dismiss();
            FragmentActivity activity = hVar.getActivity();
            if (activity != null) {
                activity.finish();
            }
            hVar.a(GAConstants.LABEL.ACCOUNT_LOGIN);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f68884c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

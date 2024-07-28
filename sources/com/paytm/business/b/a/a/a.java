package com.paytm.business.b.a.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.business.merchant_payments.databinding.MpBottomsheetPracticesForSettleNowBinding;
import com.business.merchant_payments.widget.CustomBottomSheetDialogFragment;
import java.util.HashMap;
import kotlin.g.b.k;

public final class a extends CustomBottomSheetDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public HashMap f42661a;

    /* renamed from: com.paytm.business.b.a.a.a$a  reason: collision with other inner class name */
    public static final class C0709a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42662a;

        public C0709a(a aVar) {
            this.f42662a = aVar;
        }

        public final void onClick(View view) {
            this.f42662a.dismiss();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        MpBottomsheetPracticesForSettleNowBinding inflate = MpBottomsheetPracticesForSettleNowBinding.inflate(layoutInflater, viewGroup, false);
        k.b(inflate, "MpBottomsheetPracticesFo…flater, container, false)");
        inflate.btnGotIt.setOnClickListener(new C0709a(this));
        return inflate.getRoot();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f42661a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

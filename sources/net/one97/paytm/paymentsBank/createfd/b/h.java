package net.one97.paytm.paymentsBank.createfd.b;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDProjectionListModel;

public final class h extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18126a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static String f18127b = "projection_list_model";

    /* renamed from: c  reason: collision with root package name */
    private static FDProjectionListModel f18128c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f18129d;

    private View a(int i2) {
        if (this.f18129d == null) {
            this.f18129d = new HashMap();
        }
        View view = (View) this.f18129d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f18129d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(f18127b) : null;
        if (!(serializable instanceof FDProjectionListModel)) {
            serializable = null;
        }
        f18128c = (FDProjectionListModel) serializable;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return getLayoutInflater().inflate(R.layout.fd_interest_table_layout, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001e, code lost:
        r1 = r1.getAmount();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r4, android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r4, r0)
            super.onViewCreated(r4, r5)
            int r4 = net.one97.paytm.paymentsBank.R.id.tv_fd_table_amount
            android.view.View r4 = r3.a(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r5 = 0
            if (r4 == 0) goto L_0x003a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "₹ "
            r0.<init>(r1)
            net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDProjectionListModel r1 = f18128c
            if (r1 == 0) goto L_0x002d
            java.lang.Double r1 = r1.getAmount()
            if (r1 == 0) goto L_0x002d
            double r1 = r1.doubleValue()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto L_0x002e
        L_0x002d:
            r1 = r5
        L_0x002e:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
        L_0x003a:
            androidx.recyclerview.widget.LinearLayoutManager r4 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            r4.<init>(r0)
            r0 = 1
            r4.setOrientation(r0)
            int r0 = net.one97.paytm.paymentsBank.R.id.rv_interest_table
            android.view.View r0 = r3.a(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            java.lang.String r1 = "rv_interest_table"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r4 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r4
            r0.setLayoutManager(r4)
            net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDProjectionListModel r4 = f18128c
            if (r4 == 0) goto L_0x0064
            java.util.List r4 = r4.getFdInterestProjectionDtoList()
            goto L_0x0065
        L_0x0064:
            r4 = r5
        L_0x0065:
            r0 = 0
            if (r4 == 0) goto L_0x0087
            java.lang.Object r1 = r4.get(r0)     // Catch:{ Exception -> 0x0085 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDProjectionListModel$FdInterestProjectionDtoList r1 = (net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDProjectionListModel.FdInterestProjectionDtoList) r1     // Catch:{ Exception -> 0x0085 }
            if (r1 == 0) goto L_0x0087
            java.lang.String r1 = r1.getLabel()     // Catch:{ Exception -> 0x0085 }
            if (r1 == 0) goto L_0x0087
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0085 }
            java.lang.String r5 = "CURRENT_DATE"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x0085 }
            boolean r5 = kotlin.m.p.c((java.lang.CharSequence) r1, (java.lang.CharSequence) r5)     // Catch:{ Exception -> 0x0085 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0085 }
            goto L_0x0087
        L_0x0085:
            goto L_0x0095
        L_0x0087:
            if (r5 != 0) goto L_0x008c
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0085 }
        L_0x008c:
            boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x0085 }
            if (r5 == 0) goto L_0x0095
            r4.remove(r0)     // Catch:{ Exception -> 0x0085 }
        L_0x0095:
            net.one97.paytm.paymentsBank.createfd.a.a r5 = new net.one97.paytm.paymentsBank.createfd.a.a
            android.content.Context r0 = r3.getContext()
            r5.<init>(r0, r4)
            int r4 = net.one97.paytm.paymentsBank.R.id.rv_interest_table
            android.view.View r4 = r3.a(r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            if (r4 == 0) goto L_0x00ad
            androidx.recyclerview.widget.RecyclerView$a r5 = (androidx.recyclerview.widget.RecyclerView.a) r5
            r4.setAdapter(r5)
        L_0x00ad:
            int r4 = net.one97.paytm.paymentsBank.R.id.img_cross_view
            android.view.View r4 = r3.a(r4)
            androidx.appcompat.widget.AppCompatImageView r4 = (androidx.appcompat.widget.AppCompatImageView) r4
            if (r4 == 0) goto L_0x00c1
            net.one97.paytm.paymentsBank.createfd.b.h$b r5 = new net.one97.paytm.paymentsBank.createfd.b.h$b
            r5.<init>(r3)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r4.setOnClickListener(r5)
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.createfd.b.h.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f18130a;

        b(h hVar) {
            this.f18130a = hVar;
        }

        public final void onClick(View view) {
            this.f18130a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f18129d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

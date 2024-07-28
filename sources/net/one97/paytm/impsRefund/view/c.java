package net.one97.paytm.impsRefund.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.impsdatamodel.CJRAccountBodyResponse;
import net.one97.paytm.common.entity.impsdatamodel.CJRAddRefundAmount;
import net.one97.paytm.common.entity.impsdatamodel.CJRRefundAccountDetail;
import net.one97.paytm.impsRefund.a.c;
import net.one97.paytm.impsRefund.b.b;
import net.one97.paytm.impsRefund.view.b;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.r;

public final class c extends net.one97.paytm.i.h implements c.b {

    /* renamed from: g  reason: collision with root package name */
    public static final a f50650g = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    ArrayList<CJRRefundAccountDetail> f50651a;

    /* renamed from: b  reason: collision with root package name */
    c.a f50652b;

    /* renamed from: c  reason: collision with root package name */
    int f50653c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f50654d = -1;

    /* renamed from: e  reason: collision with root package name */
    int f50655e = -1;

    /* renamed from: f  reason: collision with root package name */
    RecyclerView f50656f;

    /* renamed from: h  reason: collision with root package name */
    private Dialog f50657h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f50658i;

    public static final /* synthetic */ c.a c(c cVar) {
        c.a aVar = cVar.f50652b;
        if (aVar == null) {
            kotlin.g.b.k.a("mPresenter");
        }
        return aVar;
    }

    public static final /* synthetic */ ArrayList d(c cVar) {
        ArrayList<CJRRefundAccountDetail> arrayList = cVar.f50651a;
        if (arrayList == null) {
            kotlin.g.b.k.a("bankList");
        }
        return arrayList;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(UpiConstants.ARG_BANK_LIST) : null;
        if (serializable != null) {
            this.f50651a = (ArrayList) serializable;
            int i2 = 0;
            ArrayList<CJRRefundAccountDetail> arrayList = this.f50651a;
            if (arrayList == null) {
                kotlin.g.b.k.a("bankList");
            }
            Iterator<CJRRefundAccountDetail> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (!TextUtils.isEmpty(it2.next().getAssetId())) {
                    this.f50653c = i2;
                    return;
                }
                i2++;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.common.entity.impsdatamodel.CJRRefundAccountDetail> /* = java.util.ArrayList<net.one97.paytm.common.entity.impsdatamodel.CJRRefundAccountDetail> */");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_refund_bank_list, viewGroup, false);
        c.b bVar = this;
        b.a aVar = net.one97.paytm.impsRefund.b.b.f50588a;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        this.f50652b = new net.one97.paytm.impsRefund.c.b(bVar, b.a.a(activity));
        View findViewById = inflate.findViewById(R.id.recycler_view);
        if (findViewById != null) {
            this.f50656f = (RecyclerView) findViewById;
            RecyclerView recyclerView = this.f50656f;
            if (recyclerView == null) {
                kotlin.g.b.k.a("listRv");
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            RecyclerView recyclerView2 = this.f50656f;
            if (recyclerView2 == null) {
                kotlin.g.b.k.a("listRv");
            }
            ArrayList<CJRRefundAccountDetail> arrayList = this.f50651a;
            if (arrayList == null) {
                kotlin.g.b.k.a("bankList");
            }
            recyclerView2.setAdapter(new d(arrayList, this));
            View findViewById2 = inflate.findViewById(R.id.change_acc_tv);
            if (findViewById2 != null) {
                ((TextView) findViewById2).setOnClickListener(new b(this));
                View findViewById3 = inflate.findViewById(R.id.delete_acc_tv);
                if (findViewById3 != null) {
                    ((TextView) findViewById3).setOnClickListener(new C0921c(this));
                    ((TextView) inflate.findViewById(R.id.tv_add_account)).setOnClickListener(new d(this));
                    ((TextView) inflate.findViewById(R.id.tv_ok_got_it)).setOnClickListener(new e(inflate));
                    return inflate;
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f50659a;

        b(c cVar) {
            this.f50659a = cVar;
        }

        public final void onClick(View view) {
            c.a(this.f50659a);
        }
    }

    /* renamed from: net.one97.paytm.impsRefund.view.c$c  reason: collision with other inner class name */
    static final class C0921c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f50660a;

        C0921c(c cVar) {
            this.f50660a = cVar;
        }

        public final void onClick(View view) {
            c.b(this.f50660a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f50661a;

        d(c cVar) {
            this.f50661a = cVar;
        }

        public final void onClick(View view) {
            if (this.f50661a.getActivity() instanceof RefundHomePageActivity) {
                FragmentActivity activity = this.f50661a.getActivity();
                if (activity != null) {
                    RefundHomePageActivity refundHomePageActivity = (RefundHomePageActivity) activity;
                    refundHomePageActivity.getSupportFragmentManager().a().a((int) R.id.fragment_container, (Fragment) net.one97.paytm.upi.awareness.view.b.a()).c();
                    refundHomePageActivity.f50605b = true;
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.impsRefund.view.RefundHomePageActivity");
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f50662a;

        e(View view) {
            this.f50662a = view;
        }

        public final void onClick(View view) {
            View findViewById = this.f50662a.findViewById(R.id.i_bottom_strip);
            kotlin.g.b.k.a((Object) findViewById, "view.findViewById<Constr…out>(R.id.i_bottom_strip)");
            ((ConstraintLayout) findViewById).setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        StringBuilder sb = new StringBuilder();
        ArrayList<CJRRefundAccountDetail> arrayList = this.f50651a;
        if (arrayList == null) {
            kotlin.g.b.k.a("bankList");
        }
        CJRRefundAccountDetail cJRRefundAccountDetail = arrayList.get(this.f50655e);
        kotlin.g.b.k.a((Object) cJRRefundAccountDetail, "bankList[mAccountToBeSet]");
        sb.append(cJRRefundAccountDetail.getHolderName().get("firstName"));
        sb.append(" ");
        ArrayList<CJRRefundAccountDetail> arrayList2 = this.f50651a;
        if (arrayList2 == null) {
            kotlin.g.b.k.a("bankList");
        }
        CJRRefundAccountDetail cJRRefundAccountDetail2 = arrayList2.get(this.f50655e);
        kotlin.g.b.k.a((Object) cJRRefundAccountDetail2, "bankList[mAccountToBeSet]");
        sb.append(cJRRefundAccountDetail2.getHolderName().get("lastName"));
        String sb2 = sb.toString();
        ArrayList<CJRRefundAccountDetail> arrayList3 = this.f50651a;
        if (arrayList3 == null) {
            kotlin.g.b.k.a("bankList");
        }
        CJRRefundAccountDetail cJRRefundAccountDetail3 = arrayList3.get(this.f50655e);
        kotlin.g.b.k.a((Object) cJRRefundAccountDetail3, "bankList[mAccountToBeSet]");
        String maskedAccountNumber = cJRRefundAccountDetail3.getMaskedAccountNumber();
        ArrayList<CJRRefundAccountDetail> arrayList4 = this.f50651a;
        if (arrayList4 == null) {
            kotlin.g.b.k.a("bankList");
        }
        CJRRefundAccountDetail cJRRefundAccountDetail4 = arrayList4.get(this.f50655e);
        kotlin.g.b.k.a((Object) cJRRefundAccountDetail4, "bankList[mAccountToBeSet]");
        String bankName = cJRRefundAccountDetail4.getBankName();
        ArrayList<CJRRefundAccountDetail> arrayList5 = this.f50651a;
        if (arrayList5 == null) {
            kotlin.g.b.k.a("bankList");
        }
        CJRRefundAccountDetail cJRRefundAccountDetail5 = arrayList5.get(this.f50655e);
        kotlin.g.b.k.a((Object) cJRRefundAccountDetail5, "bankList[mAccountToBeSet]");
        String accountId = cJRRefundAccountDetail5.getAccountId();
        c.a aVar = this.f50652b;
        if (aVar == null) {
            kotlin.g.b.k.a("mPresenter");
        }
        aVar.a(sb2, maskedAccountNumber, bankName, accountId);
    }

    private static Dialog a(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.lyt_progress_bar);
            Window window = dialog.getWindow();
            if (window == null) {
                kotlin.g.b.k.a();
            }
            window.setBackgroundDrawableResource(17170445);
            return dialog;
        } catch (Exception e2) {
            if (!com.paytm.utility.b.v) {
                return null;
            }
            q.b(e2.getMessage());
            return null;
        }
    }

    public final void a(boolean z) {
        Dialog dialog;
        Dialog dialog2;
        if (z) {
            try {
                if (this.f50657h == null) {
                    this.f50657h = a((Activity) getActivity());
                }
                if (this.f50657h != null) {
                    Dialog dialog3 = this.f50657h;
                    if (dialog3 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!dialog3.isShowing() && (dialog2 = this.f50657h) != null) {
                        dialog2.show();
                    }
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        } else if (this.f50657h != null) {
            Dialog dialog4 = this.f50657h;
            if (dialog4 == null) {
                kotlin.g.b.k.a();
            }
            if (dialog4.isShowing() && (dialog = this.f50657h) != null) {
                dialog.dismiss();
            }
        }
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "msg");
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.something_wrong_try_again);
            kotlin.g.b.k.a((Object) str, "getString(R.string.something_wrong_try_again)");
        }
        com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), str);
    }

    public final void a(NetworkCustomError networkCustomError) {
        kotlin.g.b.k.c(networkCustomError, "error");
        if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, networkCustomError.getMessage(), true)) {
            r.a((Activity) getActivity(), (Exception) networkCustomError, c.class.getName(), (Bundle) null);
        } else {
            com.paytm.utility.b.b((Context) getActivity(), "Error", networkCustomError.getAlertMessage());
        }
    }

    public final void a() {
        RecyclerView recyclerView = this.f50656f;
        if (recyclerView == null) {
            kotlin.g.b.k.a("listRv");
        }
        if (recyclerView.getAdapter() != null && this.f50654d != -1) {
            ArrayList<CJRRefundAccountDetail> arrayList = this.f50651a;
            if (arrayList == null) {
                kotlin.g.b.k.a("bankList");
            }
            CJRRefundAccountDetail cJRRefundAccountDetail = arrayList.get(this.f50654d);
            kotlin.g.b.k.a((Object) cJRRefundAccountDetail, "bankList[mAccountToBeRemoved]");
            cJRRefundAccountDetail.setAssetId((String) null);
            RecyclerView recyclerView2 = this.f50656f;
            if (recyclerView2 == null) {
                kotlin.g.b.k.a("listRv");
            }
            RecyclerView.a adapter = recyclerView2.getAdapter();
            if (adapter == null) {
                kotlin.g.b.k.a();
            }
            adapter.notifyItemChanged(this.f50654d);
            this.f50653c = -1;
            b();
        }
    }

    public final void a(CJRAddRefundAmount cJRAddRefundAmount) {
        kotlin.g.b.k.c(cJRAddRefundAmount, "dataModel");
        if (getActivity() instanceof RefundHomePageActivity) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((RefundHomePageActivity) activity).a();
                int i2 = this.f50655e;
                if (i2 != -1) {
                    this.f50653c = i2;
                    ArrayList<CJRRefundAccountDetail> arrayList = this.f50651a;
                    if (arrayList == null) {
                        kotlin.g.b.k.a("bankList");
                    }
                    CJRRefundAccountDetail cJRRefundAccountDetail = arrayList.get(this.f50653c);
                    kotlin.g.b.k.a((Object) cJRRefundAccountDetail, "bankList[mRefundAccountIndex]");
                    CJRAccountBodyResponse body = cJRAddRefundAmount.getBody();
                    kotlin.g.b.k.a((Object) body, "dataModel.body");
                    cJRRefundAccountDetail.setAssetId(body.getAssetId());
                    RecyclerView recyclerView = this.f50656f;
                    if (recyclerView == null) {
                        kotlin.g.b.k.a("listRv");
                    }
                    RecyclerView.a adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        adapter.notifyItemChanged(this.f50653c);
                    }
                    this.f50655e = -1;
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.impsRefund.view.RefundHomePageActivity");
        }
    }

    static final class f implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f50663a;

        f(BottomSheetBehavior bottomSheetBehavior) {
            this.f50663a = bottomSheetBehavior;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f50663a.setState(4);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f50664a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f50665b;

        g(c cVar, com.google.android.material.bottomsheet.a aVar) {
            this.f50664a = cVar;
            this.f50665b = aVar;
        }

        public final void onClick(View view) {
            this.f50665b.dismiss();
            c.a c2 = c.c(this.f50664a);
            Object obj = c.d(this.f50664a).get(0);
            kotlin.g.b.k.a(obj, "bankList[0]");
            String assetId = ((CJRRefundAccountDetail) obj).getAssetId();
            kotlin.g.b.k.a((Object) assetId, "bankList[0].assetId");
            c2.a(assetId);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f50666a;

        h(com.google.android.material.bottomsheet.a aVar) {
            this.f50666a = aVar;
        }

        public final void onClick(View view) {
            this.f50666a.dismiss();
        }
    }

    static final class i implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f50667a;

        i(BottomSheetBehavior bottomSheetBehavior) {
            this.f50667a = bottomSheetBehavior;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f50667a.setState(4);
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f50668a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f50669b;

        j(c cVar, com.google.android.material.bottomsheet.a aVar) {
            this.f50668a = cVar;
            this.f50669b = aVar;
        }

        public final void onClick(View view) {
            this.f50669b.dismiss();
            if (this.f50668a.getActivity() instanceof RefundHomePageActivity) {
                FragmentActivity activity = this.f50668a.getActivity();
                if (activity != null) {
                    Object obj = c.d(this.f50668a).get(0);
                    kotlin.g.b.k.a(obj, "bankList[0]");
                    String assetId = ((CJRRefundAccountDetail) obj).getAssetId();
                    androidx.fragment.app.j supportFragmentManager = ((RefundHomePageActivity) activity).getSupportFragmentManager();
                    b.a aVar = b.s;
                    b bVar = new b();
                    Bundle bundle = new Bundle();
                    bundle.putString("bank_assetId", assetId);
                    bVar.setArguments(bundle);
                    RefundHomePageActivity.a(supportFragmentManager, bVar, true);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.impsRefund.view.RefundHomePageActivity");
            }
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f50670a;

        k(com.google.android.material.bottomsheet.a aVar) {
            this.f50670a = aVar;
        }

        public final void onClick(View view) {
            this.f50670a.dismiss();
        }
    }

    public static final /* synthetic */ void a(c cVar) {
        View inflate = LayoutInflater.from(cVar.getActivity()).inflate(R.layout.change_refund_account_bottom_sheet, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.bank_name);
        TextView textView2 = (TextView) inflate.findViewById(R.id.bank_no);
        kotlin.g.b.k.a((Object) textView, "tvBankName");
        ArrayList<CJRRefundAccountDetail> arrayList = cVar.f50651a;
        if (arrayList == null) {
            kotlin.g.b.k.a("bankList");
        }
        CJRRefundAccountDetail cJRRefundAccountDetail = arrayList.get(0);
        kotlin.g.b.k.a((Object) cJRRefundAccountDetail, "bankList[0]");
        textView.setText(cJRRefundAccountDetail.getBankName());
        kotlin.g.b.k.a((Object) textView2, "tvBankNo");
        FragmentActivity activity = cVar.getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        Resources resources = activity.getResources();
        Object[] objArr = new Object[1];
        ArrayList<CJRRefundAccountDetail> arrayList2 = cVar.f50651a;
        if (arrayList2 == null) {
            kotlin.g.b.k.a("bankList");
        }
        CJRRefundAccountDetail cJRRefundAccountDetail2 = arrayList2.get(0);
        kotlin.g.b.k.a((Object) cJRRefundAccountDetail2, "bankList[0]");
        String maskedAccountNumber = cJRRefundAccountDetail2.getMaskedAccountNumber();
        if (maskedAccountNumber == null) {
            maskedAccountNumber = "";
        }
        objArr[0] = maskedAccountNumber;
        textView2.setText(resources.getString(R.string.money_transfer_acc_no_with_placeholder_without_bold, objArr));
        FragmentActivity activity2 = cVar.getActivity();
        if (activity2 == null) {
            kotlin.g.b.k.a();
        }
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(activity2);
        aVar.setContentView(inflate);
        aVar.setCancelable(false);
        aVar.setCanceledOnTouchOutside(false);
        kotlin.g.b.k.a((Object) inflate, "bottomSheetView");
        ViewParent parent = inflate.getParent();
        if (parent != null) {
            BottomSheetBehavior from = BottomSheetBehavior.from((View) parent);
            kotlin.g.b.k.a((Object) from, "BottomSheetBehavior.from…SheetView.parent as View)");
            from.setState(3);
            aVar.show();
            aVar.setOnDismissListener(new i(from));
            TextView textView3 = (TextView) inflate.findViewById(R.id.recent_delete_btn);
            if (textView3 != null) {
                textView3.setOnClickListener(new j(cVar, aVar));
                View findViewById = inflate.findViewById(R.id.recent_cancel_btn);
                if (findViewById != null) {
                    ((TextView) findViewById).setOnClickListener(new k(aVar));
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    public static final /* synthetic */ void b(c cVar) {
        View inflate = LayoutInflater.from(cVar.getActivity()).inflate(R.layout.refund_confirm_delete_bottom_sheet, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.recent_delete_btn);
        TextView textView2 = (TextView) inflate.findViewById(R.id.recent_cancel_btn);
        TextView textView3 = (TextView) inflate.findViewById(R.id.delete_message);
        FragmentActivity activity = cVar.getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(activity);
        aVar.setContentView(inflate);
        aVar.setCancelable(false);
        aVar.setCanceledOnTouchOutside(false);
        kotlin.g.b.k.a((Object) textView3, "tvDeleteMsg");
        FragmentActivity activity2 = cVar.getActivity();
        if (activity2 == null) {
            kotlin.g.b.k.a();
        }
        textView3.setText(activity2.getString(R.string.refund_confirm_delete_bank_account));
        kotlin.g.b.k.a((Object) inflate, "bottomSheetView");
        ViewParent parent = inflate.getParent();
        if (parent != null) {
            BottomSheetBehavior from = BottomSheetBehavior.from((View) parent);
            kotlin.g.b.k.a((Object) from, "BottomSheetBehavior.from…SheetView.parent as View)");
            from.setState(3);
            aVar.show();
            aVar.setOnDismissListener(new f(from));
            textView.setOnClickListener(new g(cVar, aVar));
            textView2.setOnClickListener(new h(aVar));
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f50658i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

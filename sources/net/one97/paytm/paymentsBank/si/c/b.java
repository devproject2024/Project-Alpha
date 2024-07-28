package net.one97.paytm.paymentsBank.si.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.mapping.e;
import net.one97.paytm.bankCommon.model.BeneficiaryEntity;
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.si.a.a;
import net.one97.paytm.paymentsBank.si.b.c;
import net.one97.paytm.paymentsBank.utils.ShimmerFrameLayout;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.UpiUtils;

public class b extends h implements View.OnClickListener, c.b {

    /* renamed from: a  reason: collision with root package name */
    public static int f18865a = 4;

    /* renamed from: b  reason: collision with root package name */
    public int f18866b = 0;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f18867c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f18868d;

    /* renamed from: e  reason: collision with root package name */
    private Dialog f18869e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<IJRPaytmDataModel> f18870f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<IJRPaytmDataModel> f18871g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.si.a.a f18872h;

    /* renamed from: i  reason: collision with root package name */
    private int f18873i;
    /* access modifiers changed from: private */
    public int j = -1;
    private BeneficiaryEntity k = null;
    private com.google.android.material.bottomsheet.a l;
    private TextView m;
    private c.a n;
    private a o;
    private ShimmerFrameLayout p;
    private ShimmerFrameLayout q;
    private FrameLayout r;
    private FrameLayout s;

    public interface a {
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.n = (c.a) obj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.o = (a) context;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.si_fragment_benif_list, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        net.one97.paytm.paymentsBank.si.f.a.a.a(getActivity());
        this.n = new net.one97.paytm.paymentsBank.si.e.a(this, net.one97.paytm.paymentsBank.si.f.b.a(net.one97.paytm.paymentsBank.si.f.b.a.a(getActivity())));
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.beneficiary_list);
        recyclerView.setItemAnimator((RecyclerView.f) null);
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.self_accounts_list);
        recyclerView2.setItemAnimator((RecyclerView.f) null);
        this.f18867c = (RelativeLayout) view.findViewById(R.id.saved_accounts_parent_layout);
        this.f18868d = (RelativeLayout) view.findViewById(R.id.self_accounts_parent_layout);
        view.findViewById(R.id.loader_view);
        this.m = (TextView) view.findViewById(R.id.tv_view_all);
        this.p = (ShimmerFrameLayout) view.findViewById(R.id.beneficiary_shimmer_layout);
        this.q = (ShimmerFrameLayout) view.findViewById(R.id.self_shimmer_layout);
        this.r = (FrameLayout) view.findViewById(R.id.progress_layout_beneficiary);
        this.s = (FrameLayout) view.findViewById(R.id.progress_layout_self_account);
        this.m.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView2.setNestedScrollingEnabled(false);
        this.f18872h = new net.one97.paytm.paymentsBank.si.a.a(getActivity(), this.f18870f, new a.C0322a() {
            public final void a(int i2) {
                int unused = b.this.j = i2;
                b.a(b.this);
            }
        });
        recyclerView.setAdapter(this.f18872h);
        this.n.a();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    private ArrayList<IJRPaytmDataModel> b() {
        ArrayList<IJRPaytmDataModel> arrayList = new ArrayList<>();
        int i2 = 0;
        while (i2 < f18865a && i2 < this.f18870f.size()) {
            arrayList.add(this.f18870f.get(i2));
            i2++;
        }
        return arrayList;
    }

    public void onClick(View view) {
        if (view.getId() != R.id.tv_view_all) {
            return;
        }
        if (this.m.getText().toString().equalsIgnoreCase(getString(R.string.money_transfer_view_all))) {
            this.m.setText(getString(R.string.money_transfer_view_less));
            net.one97.paytm.paymentsBank.si.a.a aVar = this.f18872h;
            aVar.f18768b = this.f18870f;
            aVar.notifyItemRangeInserted(f18865a, aVar.f18768b.size() - f18865a);
            ArrayList<IJRPaytmDataModel> arrayList = this.f18870f;
            if (arrayList != null && this.f18873i != arrayList.size()) {
                this.f18866b += 25;
                this.n.a(this.f18866b, this.f18873i - 25);
                return;
            }
            return;
        }
        this.m.setText(getString(R.string.money_transfer_view_all));
        this.f18872h.f18768b = b();
        this.f18872h.notifyDataSetChanged();
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (networkCustomError == null) {
            return;
        }
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(networkCustomError.getMessage()) || "410".equalsIgnoreCase(networkCustomError.getMessage())) {
            o.a().showSessionTimeOutAlert(getActivity(), getClass().getSimpleName(), (Bundle) null, net.one97.paytm.bankCommon.mapping.h.a(networkCustomError));
        } else {
            com.paytm.utility.b.b((Context) getActivity(), "Error", networkCustomError.getAlertMessage());
        }
    }

    public final void a(ArrayList<BeneficiaryEntity> arrayList, int i2) {
        if (this.f18866b == 0) {
            this.f18873i = i2;
            if (this.f18873i > f18865a) {
                this.m.setVisibility(0);
            }
            this.f18870f.addAll(arrayList);
            this.f18872h.f18768b = b();
            this.f18872h.notifyDataSetChanged();
            this.f18867c.setVisibility(0);
            return;
        }
        int size = this.f18870f.size();
        this.f18870f.addAll(arrayList);
        this.f18872h.notifyItemRangeInserted(size, arrayList.size());
    }

    public final void a(boolean z) {
        if (z) {
            if (this.f18869e == null) {
                this.f18869e = e.f(getActivity());
            }
            Dialog dialog = this.f18869e;
            if (dialog != null && !dialog.isShowing()) {
                this.f18869e.show();
                return;
            }
            return;
        }
        Dialog dialog2 = this.f18869e;
        if (dialog2 != null && dialog2.isShowing()) {
            this.f18869e.dismiss();
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.r.setVisibility(0);
            this.p.a();
            return;
        }
        this.r.setVisibility(8);
        this.p.b();
    }

    public final void a() {
        this.f18870f.remove(this.j);
        if (this.m.getVisibility() != 0 || !this.m.getText().toString().equalsIgnoreCase(getString(R.string.money_transfer_view_all))) {
            this.f18872h.f18768b = this.f18870f;
        } else {
            this.f18872h.f18768b = b();
        }
        this.f18872h.notifyItemRemoved(this.j);
        if (this.f18870f.size() <= f18865a) {
            this.m.setVisibility(8);
        }
        ArrayList<IJRPaytmDataModel> arrayList = this.f18870f;
        if (arrayList != null && arrayList.size() == 0) {
            this.f18867c.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void b(android.view.View r5) {
        /*
            r4 = this;
            com.google.android.material.bottomsheet.a r5 = r4.l
            r5.dismiss()
            java.util.ArrayList<com.paytm.network.model.IJRPaytmDataModel> r5 = r4.f18870f
            int r0 = r4.j
            java.lang.Object r5 = r5.get(r0)
            net.one97.paytm.bankCommon.model.BeneficiaryEntity r5 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity) r5
            java.lang.String r5 = r5.beneficiaryId
            java.util.ArrayList<com.paytm.network.model.IJRPaytmDataModel> r0 = r4.f18870f
            int r1 = r4.j
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.bankCommon.model.BeneficiaryEntity r0 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity) r0
            net.one97.paytm.bankCommon.model.BeneficiaryEntity$InstrumentPreferences r0 = r0.instrumentPreferences
            net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBank r0 = r0.otherBank
            r1 = 0
            if (r0 == 0) goto L_0x003b
            java.util.ArrayList<com.paytm.network.model.IJRPaytmDataModel> r0 = r4.f18870f
            int r2 = r4.j
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.bankCommon.model.BeneficiaryEntity r0 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity) r0
            net.one97.paytm.bankCommon.model.BeneficiaryEntity$InstrumentPreferences r0 = r0.instrumentPreferences
            net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBank r0 = r0.otherBank
            java.util.ArrayList<net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount> r0 = r0.accounts
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.bankCommon.model.BeneficiaryEntity$OtherBankAccount r0 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity.OtherBankAccount) r0
            java.lang.String r0 = r0.uuid
            goto L_0x0069
        L_0x003b:
            java.util.ArrayList<com.paytm.network.model.IJRPaytmDataModel> r0 = r4.f18870f
            int r2 = r4.j
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.bankCommon.model.BeneficiaryEntity r0 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity) r0
            net.one97.paytm.bankCommon.model.BeneficiaryEntity$InstrumentPreferences r0 = r0.instrumentPreferences
            net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPI r0 = r0.upi
            if (r0 == 0) goto L_0x0067
            r0 = 1
            java.util.ArrayList<com.paytm.network.model.IJRPaytmDataModel> r2 = r4.f18870f
            int r3 = r4.j
            java.lang.Object r2 = r2.get(r3)
            net.one97.paytm.bankCommon.model.BeneficiaryEntity r2 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity) r2
            net.one97.paytm.bankCommon.model.BeneficiaryEntity$InstrumentPreferences r2 = r2.instrumentPreferences
            net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPI r2 = r2.upi
            java.util.ArrayList<net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPIAccount> r2 = r2.accounts
            java.lang.Object r2 = r2.get(r1)
            net.one97.paytm.bankCommon.model.BeneficiaryEntity$UPIAccount r2 = (net.one97.paytm.bankCommon.model.BeneficiaryEntity.UPIAccount) r2
            java.lang.String r2 = r2.uuid
            r0 = r2
            r2 = 1
            goto L_0x006a
        L_0x0067:
            java.lang.String r0 = ""
        L_0x0069:
            r2 = 0
        L_0x006a:
            androidx.fragment.app.FragmentActivity r3 = r4.getActivity()
            boolean r3 = com.paytm.utility.b.c((android.content.Context) r3)
            if (r3 == 0) goto L_0x007a
            net.one97.paytm.paymentsBank.si.b.c$a r1 = r4.n
            r1.a(r0, r5, r2)
            return
        L_0x007a:
            r4.a((boolean) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.si.c.b.b(android.view.View):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.l.dismiss();
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            e.a((Context) getActivity(), getResources().getString(R.string.error), str);
        } else {
            e.a((Context) getActivity(), getResources().getString(R.string.error), getResources().getString(R.string.pb_something_wrong_try_again));
        }
    }

    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        com.google.android.play.core.splitcompat.a.a((Context) getActivity());
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a((Context) getActivity());
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    static /* synthetic */ void a(b bVar) {
        View inflate = LayoutInflater.from(bVar.getActivity()).inflate(R.layout.pb_confirm_delete_bottom_sheet, (ViewGroup) null);
        inflate.findViewById(R.id.delete_message);
        bVar.l = new com.google.android.material.bottomsheet.a(bVar.getActivity());
        bVar.l.setContentView(inflate);
        bVar.l.setCancelable(false);
        bVar.l.setCanceledOnTouchOutside(false);
        BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
        from.setState(3);
        bVar.l.show();
        bVar.l.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                BottomSheetBehavior.this.setState(4);
            }
        });
        ((TextView) inflate.findViewById(R.id.recent_delete_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.b(view);
            }
        });
        ((TextView) inflate.findViewById(R.id.recent_cancel_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.a(view);
            }
        });
    }
}

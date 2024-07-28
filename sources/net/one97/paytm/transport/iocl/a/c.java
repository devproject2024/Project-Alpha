package net.one97.paytm.transport.iocl.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import net.one97.paytm.common.widgets.e;
import net.one97.paytm.iocl.R;
import net.one97.paytm.iocl.a.k;
import net.one97.paytm.transport.iocl.activity.AJRIOCLHomeActivity;
import net.one97.paytm.transport.iocl.activity.IOCLBaseActivity;
import net.one97.paytm.transport.iocl.b.d;
import net.one97.paytm.transport.iocl.data.IOCLRedeemHistoryModel;
import net.one97.paytm.transport.iocl.data.a;

public class c extends Fragment implements b, d.b {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.transport.iocl.c.c f14225a;

    /* renamed from: b  reason: collision with root package name */
    e f14226b;

    /* renamed from: c  reason: collision with root package name */
    ProgressBar f14227c;

    /* renamed from: d  reason: collision with root package name */
    TextView f14228d;

    /* renamed from: e  reason: collision with root package name */
    RecyclerView f14229e;

    /* renamed from: f  reason: collision with root package name */
    k f14230f;

    /* renamed from: g  reason: collision with root package name */
    private d f14231g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f14232h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f14233i;
    /* access modifiers changed from: private */
    public LinearLayoutManager j;
    /* access modifiers changed from: private */
    public int k = 0;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public String m;
    private String n = "";
    private String o = "";
    /* access modifiers changed from: private */
    public boolean p = false;
    /* access modifiers changed from: private */
    public boolean q = false;
    private net.one97.paytm.common.widgets.a.d r = new net.one97.paytm.common.widgets.a.d() {
        public final void setSelectedDate(String str) {
            c.this.d(str);
        }
    };
    private net.one97.paytm.common.widgets.a.d s = new net.one97.paytm.common.widgets.a.d() {
        public final void setSelectedDate(String str) {
            c.this.c(str);
        }
    };

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.iocl_history_fragment, viewGroup, false);
        this.f14227c = (ProgressBar) inflate.findViewById(R.id.pb_transactions);
        this.f14228d = (TextView) inflate.findViewById(R.id.tv_no_transaction_msg);
        this.f14229e = (RecyclerView) inflate.findViewById(R.id.history_recycler_view);
        this.f14225a = new net.one97.paytm.transport.iocl.c.c();
        this.f14225a.a(true);
        this.f14225a.b(true);
        if (!com.paytm.utility.b.c((Context) getActivity())) {
            getString(R.string.iocl_no_connection);
            com.paytm.utility.b.a((Context) (IOCLBaseActivity) getActivity(), getString(R.string.iocl_no_internet), false);
        } else if (com.paytm.utility.b.r((Context) getActivity())) {
            net.one97.paytm.transport.iocl.b.b.a(getContext(), this, this.k, this.l, this.m, this.p, this.q);
            this.f14232h = true;
            this.f14227c.setVisibility(0);
            this.f14229e.setNestedScrollingEnabled(false);
            this.j = new LinearLayoutManager(getContext());
            this.f14229e.setLayoutManager(this.j);
            this.f14231g = new d(getContext(), this);
            this.f14229e.setAdapter(this.f14231g);
            this.f14229e.addOnScrollListener(new RecyclerView.l() {
                public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                    super.onScrolled(recyclerView, i2, i3);
                    int childCount = c.this.j.getChildCount();
                    int itemCount = c.this.j.getItemCount();
                    int findFirstVisibleItemPosition = c.this.j.findFirstVisibleItemPosition();
                    if (!c.this.f14232h && !c.this.f14233i && i3 > 0 && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0 && itemCount >= net.one97.paytm.transport.iocl.b.b.f14277i && com.paytm.utility.b.c((Context) c.this.getActivity())) {
                        if (com.paytm.utility.b.r((Context) c.this.getActivity())) {
                            Context context = c.this.getContext();
                            c cVar = c.this;
                            net.one97.paytm.transport.iocl.b.b.a(context, cVar, cVar.k, c.this.l, c.this.m, c.this.p, c.this.q);
                        } else {
                            NetworkCustomError networkCustomError = new NetworkCustomError();
                            networkCustomError.setStatusCode(403);
                            ((IOCLBaseActivity) c.this.getActivity()).a(net.one97.paytm.transport.iocl.b.b.f14272d, networkCustomError);
                        }
                        boolean unused = c.this.f14232h = true;
                    }
                }
            });
        } else {
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setStatusCode(403);
            ((IOCLBaseActivity) getActivity()).a(net.one97.paytm.transport.iocl.b.b.f14272d, networkCustomError);
        }
        return inflate;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == net.one97.paytm.transport.iocl.b.b.f14272d && i3 == -1) {
            net.one97.paytm.transport.iocl.b.b.a(getContext(), this, this.k, this.l, this.m, this.p, this.q);
        }
    }

    public final void a() {
        LinearLayoutManager linearLayoutManager = this.j;
        if (linearLayoutManager != null) {
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = this.j.getItemCount();
            int findFirstVisibleItemPosition = this.j.findFirstVisibleItemPosition();
            if (!this.f14232h && !this.f14233i && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0 && itemCount >= net.one97.paytm.transport.iocl.b.b.f14277i && com.paytm.utility.b.c((Context) getActivity())) {
                if (com.paytm.utility.b.r((Context) getActivity())) {
                    if ((getActivity() instanceof AJRIOCLHomeActivity) && getActivity() != null) {
                        ((AJRIOCLHomeActivity) getActivity()).a(true);
                    }
                    net.one97.paytm.transport.iocl.b.b.a(getContext(), this, this.k, this.l, this.m, this.p, this.q);
                    this.f14232h = true;
                    return;
                }
                NetworkCustomError networkCustomError = new NetworkCustomError();
                networkCustomError.setStatusCode(403);
                ((IOCLBaseActivity) getActivity()).a(net.one97.paytm.transport.iocl.b.b.f14272d, networkCustomError);
            }
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof IOCLRedeemHistoryModel) {
            IOCLRedeemHistoryModel iOCLRedeemHistoryModel = (IOCLRedeemHistoryModel) iJRPaytmDataModel;
            if (this.k == 0) {
                ArrayList<a> response = iOCLRedeemHistoryModel.getResponse();
                this.f14231g.a(response);
                if (response == null || response.size() == 0) {
                    this.f14228d.setVisibility(0);
                } else {
                    this.f14228d.setVisibility(8);
                }
            } else {
                d dVar = this.f14231g;
                ArrayList<a> response2 = iOCLRedeemHistoryModel.getResponse();
                if (!(response2 == null || response2.size() == 0)) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < response2.size(); i2++) {
                        if (!dVar.f14283c.equalsIgnoreCase(dVar.a(response2.get(i2).f14319e))) {
                            arrayList.add(new a(dVar.a(response2.get(i2).f14319e)));
                            dVar.f14283c = dVar.a(response2.get(i2).f14319e);
                        }
                        arrayList.add(response2.get(i2));
                    }
                    dVar.f14281a.addAll(arrayList);
                    dVar.notifyDataSetChanged();
                }
            }
            this.f14232h = false;
            this.f14227c.setVisibility(8);
            this.f14229e.setVisibility(0);
            if (iOCLRedeemHistoryModel.getResponse() == null || iOCLRedeemHistoryModel.getResponse().size() < 10) {
                this.f14233i = true;
            }
            if (iOCLRedeemHistoryModel.getResponse() != null) {
                this.k += iOCLRedeemHistoryModel.getResponse().size();
            }
            if ((getActivity() instanceof AJRIOCLHomeActivity) && getActivity() != null) {
                ((AJRIOCLHomeActivity) getActivity()).a(false);
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f14232h = false;
        this.f14227c.setVisibility(8);
        this.f14229e.setVisibility(0);
        if ((getActivity() instanceof AJRIOCLHomeActivity) && getActivity() != null) {
            ((AJRIOCLHomeActivity) getActivity()).a(false);
            if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403) {
                ((AJRIOCLHomeActivity) getActivity()).a(net.one97.paytm.transport.iocl.b.b.f14272d, networkCustomError);
            }
        }
    }

    public final void b() {
        this.f14230f = (k) f.a(LayoutInflater.from(getContext()), R.layout.iocl_bottom_sheet_filter, (ViewGroup) null, false);
        this.f14230f.a(this.f14225a);
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(getActivity());
        aVar.setContentView(this.f14230f.getRoot());
        BottomSheetBehavior from = BottomSheetBehavior.from((View) this.f14230f.getRoot().getParent());
        aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                BottomSheetBehavior.this.setState(4);
            }
        });
        from.setState(3);
        aVar.show();
        this.f14230f.f14129c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                com.google.android.material.bottomsheet.a.this.dismiss();
            }
        });
        if (!TextUtils.isEmpty(this.l)) {
            this.f14230f.k.setText(this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
            this.f14230f.j.setText(this.m);
        } else {
            try {
                this.m = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                this.f14230f.j.setText(this.m);
                this.f14225a.f14307d.set(Long.valueOf(b(this.m)));
            } catch (Exception unused) {
            }
        }
        this.f14230f.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.c(view);
            }
        });
        this.f14230f.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.b(view);
            }
        });
        this.f14230f.f14132f.setOnClickListener(new View.OnClickListener(aVar) {
            private final /* synthetic */ com.google.android.material.bottomsheet.a f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                c.this.a(this.f$1, view);
            }
        });
        this.f14230f.f14133g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        a("start");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a("end");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(com.google.android.material.bottomsheet.a aVar, View view) {
        aVar.dismiss();
        if (c()) {
            this.p = this.f14225a.f14304a.get().booleanValue();
            this.q = this.f14225a.f14305b.get().booleanValue();
            this.n = this.l;
            this.o = this.m;
            if (com.paytm.utility.b.c((Context) getActivity())) {
                this.k = 0;
                if (com.paytm.utility.b.r((Context) getActivity())) {
                    this.f14231g.a((ArrayList<a>) null);
                    this.f14231g.notifyDataSetChanged();
                    if (a(this.l, this.m)) {
                        net.one97.paytm.transport.iocl.b.b.a(getContext(), this, this.k, this.l, this.m, this.p, this.q);
                    } else {
                        net.one97.paytm.transport.iocl.b.b.a(getContext(), this, this.k, this.m, this.l, this.p, this.q);
                    }
                    this.f14232h = true;
                    this.f14227c.setVisibility(0);
                    this.f14229e.setVisibility(8);
                    return;
                }
                NetworkCustomError networkCustomError = new NetworkCustomError();
                networkCustomError.setStatusCode(403);
                ((IOCLBaseActivity) getActivity()).a(net.one97.paytm.transport.iocl.b.b.f14272d, networkCustomError);
                return;
            }
            getString(R.string.iocl_no_connection);
            com.paytm.utility.b.a((Context) (IOCLBaseActivity) getActivity(), getString(R.string.iocl_no_internet), false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f14225a.f14304a.set(Boolean.FALSE);
        this.f14225a.f14305b.set(Boolean.FALSE);
        this.m = "";
        this.l = "";
        this.f14230f.k.setText("Start Date");
        this.f14230f.j.setText("End Date");
    }

    private boolean c() {
        if (this.p != this.f14225a.f14304a.get().booleanValue() || this.q != this.f14225a.f14305b.get().booleanValue()) {
            return true;
        }
        try {
            if (!this.n.equalsIgnoreCase(this.l) || !this.o.equalsIgnoreCase(this.m)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("default_dob", net.one97.paytm.transport.iocl.b.a.a("dd-MM-yyyy"));
        bundle.putString("date_format", "dd-MM-yyyy");
        if (this.f14226b == null) {
            this.f14226b = new e();
            if (str.equalsIgnoreCase("start")) {
                this.f14226b.f49899a = this.r;
                if (!TextUtils.isEmpty(this.l)) {
                    bundle.putString("default_dob", this.l);
                }
            } else {
                this.f14226b.f49899a = this.s;
                if (!TextUtils.isEmpty(this.m)) {
                    bundle.putString("default_dob", this.m);
                }
            }
            this.f14226b.setArguments(bundle);
        }
        if (!this.f14226b.isVisible() && getActivity().getSupportFragmentManager().c(H5Plugin.CommonEvents.DATE_PICKER) == null) {
            if (str.equalsIgnoreCase("start")) {
                this.f14226b.f49899a = this.r;
                if (!TextUtils.isEmpty(this.l)) {
                    bundle.putString("default_dob", this.l);
                }
            } else {
                this.f14226b.f49899a = this.s;
                if (!TextUtils.isEmpty(this.m)) {
                    bundle.putString("default_dob", this.m);
                }
            }
            this.f14226b.setArguments(bundle);
            this.f14226b.show(getActivity().getSupportFragmentManager(), H5Plugin.CommonEvents.DATE_PICKER);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(String str) {
        this.l = str;
        this.f14230f.k.setText(this.l);
        this.f14225a.f14306c.set(Long.valueOf(b(str)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        this.m = str;
        this.f14230f.j.setText(this.m);
        this.f14225a.f14307d.set(Long.valueOf(b(str)));
    }

    private static boolean a(String str, String str2) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        try {
            String[] split = str.split("-");
            String[] split2 = str2.split("-");
            instance.set(Integer.parseInt(split[2]), Integer.parseInt(split[1]) - 1, Integer.parseInt(split[0]));
            instance2.set(Integer.parseInt(split2[2]), Integer.parseInt(split2[1]) - 1, Integer.parseInt(split2[0]));
            if (instance.before(instance2) || instance.equals(instance2)) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static long b(String str) {
        Calendar instance = Calendar.getInstance();
        String[] split = str.split("-");
        instance.set(Integer.parseInt(split[2]), Integer.parseInt(split[1]) - 1, Integer.parseInt(split[0]));
        return instance.getTimeInMillis();
    }
}

package net.one97.paytm.passbook.subWallet.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.h.d;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.MerchantWiseDetail;
import net.one97.paytm.passbook.beans.PreAuthTxnHistory;
import net.one97.paytm.passbook.beans.Response;
import net.one97.paytm.passbook.beans.TutorialMessage;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;
import net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.passbook.utility.l;
import net.one97.paytm.passbook.utility.m;

public class c extends h implements RecyclerView.k, g, i.a<IJRDataModel> {

    /* renamed from: a  reason: collision with root package name */
    public Fragment f58823a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f58824b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayoutManager f58825c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f58826d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.passbook.other.a f58827e;

    /* renamed from: f  reason: collision with root package name */
    private d f58828f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f58829g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f58830h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f58831i;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout j;
    private ArrayList<MerchantWiseDetail> k;
    /* access modifiers changed from: private */
    public boolean l = false;
    private boolean m;
    /* access modifiers changed from: private */
    public com.google.android.material.bottomsheet.a n;

    static /* synthetic */ void a() {
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public /* synthetic */ void onResponse(Object obj) {
        Response response;
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        if (getActivity() != null && !isDetached() && !getActivity().isFinishing()) {
            this.j.setRefreshing(false);
            if (iJRDataModel != null && !isDetached()) {
                if (iJRDataModel instanceof PreAuthTxnHistory) {
                    PreAuthTxnHistory preAuthTxnHistory = (PreAuthTxnHistory) iJRDataModel;
                    String statusCode = preAuthTxnHistory.getStatusCode();
                    if (statusCode == null) {
                        return;
                    }
                    if (statusCode.equalsIgnoreCase("SUCCESS") && (response = preAuthTxnHistory.getResponse()) != null) {
                        if (this.l) {
                            this.k.clear();
                        }
                        this.k.size();
                        this.k.addAll(response.getMerchantWiseDetails());
                        this.f58827e.notifyDataSetChanged();
                        if (this.k.size() <= 0) {
                            char c2 = 65535;
                            int hashCode = "no_data".hashCode();
                            if (!(hashCode == -2077031716 || hashCode == -617237321 || hashCode != 2109803368)) {
                                c2 = 1;
                            }
                            if (c2 != 0) {
                                if (c2 == 1) {
                                    try {
                                        if (!(this.f58829g == null || this.f58830h == null)) {
                                            this.f58829g.setVisibility(0);
                                            this.f58830h.setVisibility(0);
                                            this.f58826d.setVisibility(0);
                                            this.f58829g.setText(getResources().getString(R.string.no_transaction_result_preauth));
                                            this.f58830h.setImageResource(R.drawable.pass_no_entry_passbook);
                                            this.f58826d.setVisibility(0);
                                            this.m = true;
                                            d();
                                        }
                                    } catch (OutOfMemoryError unused) {
                                        System.gc();
                                    }
                                } else if (c2 != 2) {
                                    try {
                                        if (!isDetached()) {
                                            getResources().getString(R.string.we_are_fixing_something);
                                            getResources().getString(R.string.be_right_back);
                                        }
                                    } catch (Exception unused2) {
                                    }
                                }
                            }
                        } else {
                            this.f58826d.setVisibility(8);
                        }
                    }
                }
                if (iJRDataModel instanceof TutorialMessage) {
                    TutorialMessage tutorialMessage = (TutorialMessage) iJRDataModel;
                    if (!TextUtils.isEmpty(tutorialMessage.getStatusMessage()) && tutorialMessage.getStatusMessage().equalsIgnoreCase("SUCCESS") && !TextUtils.isEmpty(tutorialMessage.getResponse().getHelpText())) {
                        f();
                    }
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pass_fragment_new_passbook_entry, (ViewGroup) null);
        this.f58823a = d.a();
        this.k = new ArrayList<>();
        this.j = (SwipeRefreshLayout) inflate.findViewById(R.id.swipeRefreshLayout);
        this.f58824b = (RecyclerView) inflate.findViewById(R.id.passbook_entrylist_recycler);
        this.f58826d = (RelativeLayout) inflate.findViewById(R.id.passbook_entrylist_no_result_layout);
        this.f58829g = (TextView) inflate.findViewById(R.id.passbook_entrylist_no_result_layout_no_data_tv);
        this.f58830h = (ImageView) inflate.findViewById(R.id.passbook_entrylist_no_result_layout_no_data_img);
        this.f58825c = new LinearLayoutManager(getActivity());
        this.f58824b.setLayoutManager(this.f58825c);
        this.f58824b.setItemAnimator(new androidx.recyclerview.widget.g());
        this.j.setOnRefreshListener(new SwipeRefreshLayout.b() {
            public final void onRefresh() {
                c.this.j.setRefreshing(false);
                boolean unused = c.this.l = true;
                c.this.b();
            }
        });
        this.f58824b.addOnItemTouchListener(this);
        this.f58828f = new d(getActivity(), new b(this, (byte) 0));
        this.f58827e = new net.one97.paytm.passbook.other.a(this.k, getActivity());
        this.f58824b.setAdapter(this.f58827e);
        this.l = true;
        b();
        d();
        return inflate;
    }

    public void onResume() {
        super.onResume();
        if (this.m) {
            e();
        }
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        this.m = z;
        if (z) {
            d();
            e();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    /* access modifiers changed from: private */
    public void b() {
        e.a();
        String m2 = e.m();
        if (!TextUtils.isEmpty(m2)) {
            String q = com.paytm.utility.a.q(getContext());
            "----->URL :: ".concat(String.valueOf(m2));
            com.paytm.utility.b.j();
            "----->WalletSso :: ".concat(String.valueOf(q));
            com.paytm.utility.b.j();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ssotoken", q);
            if (com.paytm.utility.b.c((Context) getActivity())) {
                getContext();
                net.one97.paytm.passbook.mapping.a.c.a();
                net.one97.paytm.passbook.mapping.a.c.b(new net.one97.paytm.passbook.mapping.a.a(m2, this, this, new PreAuthTxnHistory(), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getSimpleName()));
                c();
                return;
            }
            a((net.one97.paytm.passbook.mapping.a.e) new net.one97.paytm.passbook.mapping.a.a(m2, this, this, new PreAuthTxnHistory(), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getSimpleName()));
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        d dVar = this.f58828f;
        if (dVar == null) {
            return false;
        }
        dVar.a(motionEvent);
        return false;
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (getActivity() != null && !isDetached()) {
            if (getActivity() == null || !getActivity().isFinishing()) {
                this.j.setRefreshing(false);
                FragmentActivity activity = getActivity();
                PassbookSubwalletActivity.class.getName();
                j.a((Activity) activity, (Throwable) networkCustomError);
            }
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        /* synthetic */ b(c cVar, byte b2) {
            this();
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            View findChildViewUnder = c.this.f58824b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            int childPosition = c.this.f58824b.getChildPosition(findChildViewUnder);
            if (c.this.f58831i == null) {
                c cVar = c.this;
                a unused = cVar.f58831i = new a(findChildViewUnder, childPosition);
            } else {
                c.this.f58831i.f58839a = findChildViewUnder;
                c.this.f58831i.f58840b = childPosition;
            }
            c.a();
            return super.onSingleTapConfirmed(motionEvent);
        }

        public final void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
        }
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        View f58839a;

        /* renamed from: b  reason: collision with root package name */
        int f58840b;

        public a(View view, int i2) {
            this.f58839a = view;
            this.f58840b = i2;
        }
    }

    private void c() {
        this.j.post(new Runnable() {
            public final void run() {
                c.this.j.setRefreshing(true);
            }
        });
    }

    private void d() {
        Fragment fragment;
        if (this.m && (fragment = this.f58823a) != null && !fragment.isDetached() && !this.f58823a.getActivity().isFinishing()) {
            ((l) this.f58823a).a(net.one97.paytm.passbook.mapping.c.k("yyyy-MM-dd hh:mm:SS", "MMMM dd , hh:mm a", " "));
        }
    }

    private void e() {
        Integer valueOf = Integer.valueOf(m.a(getContext().getApplicationContext()).b("isPreAuthMessageVisible", 0, false));
        if (getActivity() != null && valueOf != null && valueOf.intValue() <= 0) {
            f();
        }
    }

    private void f() {
        if (this.n == null) {
            String string = getString(R.string.msg_preauth_1);
            View inflate = getActivity().getLayoutInflater().inflate(R.layout.pass_layout_passbook_preauth_overlay, (ViewGroup) null);
            this.n = new com.google.android.material.bottomsheet.a(getActivity());
            this.n.setContentView(inflate);
            final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
            this.n.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    from.setState(4);
                    com.google.android.material.bottomsheet.a unused = c.this.n = null;
                }
            });
            from.setState(3);
            this.n.show();
            ((TextView) inflate.findViewById(R.id.added_msg)).setText(string);
            inflate.findViewById(R.id.passbooksendtobank_okgotit_tv).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    m.a(net.one97.paytm.passbook.d.b().b()).a("isPreAuthMessageVisible", 1, false);
                    c.this.n.dismiss();
                    com.google.android.material.bottomsheet.a unused = c.this.n = null;
                }
            });
        }
    }

    public final void a(final net.one97.paytm.passbook.mapping.a.e eVar) {
        if (getActivity() != null && !getActivity().isFinishing() && !isDetached()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(getResources().getString(R.string.no_connection));
            builder.setMessage(getResources().getString(R.string.no_internet));
            builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    if (com.paytm.utility.b.c(c.this.getContext())) {
                        c.this.getContext().getApplicationContext();
                        net.one97.paytm.passbook.mapping.a.c.a();
                        net.one97.paytm.passbook.mapping.a.c.b(eVar);
                        return;
                    }
                    c.this.a(eVar);
                }
            });
            builder.show();
        }
    }
}

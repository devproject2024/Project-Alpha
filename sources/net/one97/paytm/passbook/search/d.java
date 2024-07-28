package net.one97.paytm.passbook.search;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.sendbird.android.constant.StringSet;
import java.math.BigDecimal;
import java.util.ArrayList;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.search.e;
import net.one97.paytm.passbook.transactionDetail.PassbookDetailActivity;
import net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity;
import net.one97.paytm.passbook.utility.l;
import org.json.JSONObject;

public class d extends h implements View.OnClickListener, RecyclerView.k, e.c, net.one97.paytm.passbook.utility.d, net.one97.paytm.passbook.utility.h {

    /* renamed from: a  reason: collision with root package name */
    boolean f58395a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f58396b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public LinearLayoutManager f58397c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f58398d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f58399e;

    /* renamed from: f  reason: collision with root package name */
    private androidx.core.h.d f58400f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f58401g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f58402h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f58403i;
    private TextView j;
    private ImageView k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public int m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public boolean o = false;
    /* access modifiers changed from: private */
    public a p;
    /* access modifiers changed from: private */
    public FragmentActivity q;
    /* access modifiers changed from: private */
    public ArrayList<CJRTransaction> r;
    /* access modifiers changed from: private */
    public boolean s = false;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout t;

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof l)) {
            ((l) activity).a((net.one97.paytm.passbook.utility.h) this);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f58399e = getArguments().getString("entrytype", StringSet.all);
        View inflate = layoutInflater.inflate(R.layout.pass_fragment_passbook_entry, (ViewGroup) null);
        this.r = new ArrayList<>();
        this.t = (SwipeRefreshLayout) inflate.findViewById(R.id.swipeRefreshLayout);
        this.t.setEnabled(false);
        this.f58396b = (RecyclerView) inflate.findViewById(R.id.passbook_entrylist_recycler);
        this.j = (TextView) inflate.findViewById(R.id.passbook_entrylist_no_result_layout_no_data_tv);
        this.k = (ImageView) inflate.findViewById(R.id.passbook_entrylist_no_result_layout_no_data_img);
        this.f58397c = new LinearLayoutManager(getActivity());
        this.f58396b.setLayoutManager(this.f58397c);
        this.f58396b.setItemAnimator(new g());
        e eVar = new e(this, this.r, this.f58399e);
        this.f58396b.setAdapter(eVar);
        this.f58396b.setPadding(0, 0, 0, 0);
        this.q = getActivity();
        FragmentActivity fragmentActivity = this.q;
        if (!(fragmentActivity instanceof l) || fragmentActivity.isFinishing() || ((l) this.q).i()) {
            e();
        } else {
            e();
            this.f58398d = (LinearLayout) inflate.findViewById(R.id.passbook_entry_bottombar_parent_rl);
            this.f58402h = (TextView) this.f58398d.findViewById(R.id.passbook_entry_bottombar_received_value_tv);
            this.f58401g = (TextView) this.f58398d.findViewById(R.id.passbook_entry_bottombar_paid_value_tv);
            this.f58403i = (TextView) this.f58398d.findViewById(R.id.passbook_entry_bottombar_net_value_tv);
            ((ImageView) this.f58398d.findViewById(R.id.passbook_entry_bottombar_cross_iv)).setOnClickListener(this);
            this.f58398d.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            FragmentActivity fragmentActivity2 = this.q;
            if (!(fragmentActivity2 == null || ((l) fragmentActivity2).c(this.f58399e) == null)) {
                ArrayList<? extends IJRDataModel> c2 = ((l) this.q).c(this.f58399e);
                if (c2 == null) {
                    c2 = new ArrayList<>();
                }
                if (c2.size() > 0) {
                    int size = this.r.size();
                    this.r.addAll(c2);
                    if (size == 0) {
                        c();
                    }
                }
                eVar.a((ArrayList<CJRTransaction>) c2);
                eVar.f58421e = 0;
            }
        }
        this.t.setOnRefreshListener(new SwipeRefreshLayout.b() {
            public final void onRefresh() {
                boolean unused = d.this.s = true;
                d.this.t.setRefreshing(false);
                d.this.d();
            }
        });
        this.f58396b.addOnItemTouchListener(this);
        this.f58400f = new androidx.core.h.d(getActivity(), new b(this, (byte) 0));
        this.p = new a((View) null, 0);
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        SwipeRefreshLayout swipeRefreshLayout = this.t;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.removeAllViews();
            this.t.setEnabled(false);
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof l)) {
            ((l) activity).b((net.one97.paytm.passbook.utility.h) this);
        }
        this.f58396b = null;
        this.f58397c = null;
        this.f58399e = null;
        this.f58398d = null;
        this.f58400f = null;
        this.f58400f = null;
        System.gc();
    }

    public final void a() {
        if (getActivity() != null && !isDetached()) {
            if (getActivity() == null || !getActivity().isFinishing()) {
                SwipeRefreshLayout swipeRefreshLayout = this.t;
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                getActivity().runOnUiThread(new Runnable() {
                    public final void run() {
                        ArrayList<? extends IJRDataModel> c2;
                        if (d.this.f58399e != null && (c2 = ((l) d.this.getActivity()).c(d.this.f58399e)) != null && d.this.f58396b != null) {
                            int size = d.this.r.size();
                            d.this.r.addAll(c2);
                            if (size == 0) {
                                d.this.c();
                            }
                            ((e) d.this.f58396b.getAdapter()).a((ArrayList<CJRTransaction>) c2);
                        }
                    }
                });
            }
        }
    }

    private void e() {
        this.f58396b.addOnScrollListener(new RecyclerView.l() {
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
            }

            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0) {
                    if (i2 != 1 && i2 != 2) {
                    }
                } else if (d.this.f58397c != null) {
                    d.this.c();
                    d dVar = d.this;
                    int unused = dVar.l = dVar.f58397c.getChildCount();
                    d dVar2 = d.this;
                    int unused2 = dVar2.m = dVar2.f58397c.getItemCount();
                    d dVar3 = d.this;
                    int unused3 = dVar3.n = dVar3.f58397c.findFirstVisibleItemPosition();
                    FragmentActivity activity = d.this.getActivity();
                    l lVar = (l) activity;
                    if (!lVar.g() && d.this.l + d.this.n >= d.this.m && d.this.n >= 0) {
                        lVar.f();
                        if (!com.paytm.utility.b.c((Context) activity)) {
                            return;
                        }
                        if (d.this.q == null || !((l) d.this.q).i()) {
                            lVar.d();
                        } else {
                            lVar.e();
                        }
                    }
                }
            }
        });
    }

    public final void c() {
        FragmentActivity activity;
        LinearLayoutManager linearLayoutManager;
        String str;
        if (this.f58395a && (activity = getActivity()) != null && this.f58396b != null && (linearLayoutManager = this.f58397c) != null) {
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            RecyclerView.a adapter = this.f58396b.getAdapter();
            if (adapter == null || adapter.getItemCount() <= 0) {
                ((l) activity).a("");
                return;
            }
            if (findFirstVisibleItemPosition >= 0) {
                str = ((e) adapter).a(findFirstVisibleItemPosition).getTxnDate();
            } else {
                str = this.r.get(0).getTxnDate();
            }
            l lVar = (l) activity;
            lVar.a(lVar.a("yyyy-MM-dd HH:mm:ss", "MMMM yyyy", str));
            ((e) adapter).f58421e = findFirstVisibleItemPosition;
        }
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        this.f58395a = z;
        if (z) {
            try {
                c();
            } catch (Exception unused) {
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.passbook_entry_bottombar_cross_iv) {
            f();
        }
    }

    private boolean f() {
        LinearLayout linearLayout;
        if (this.f58398d == null || ((e) this.f58396b.getAdapter()) == null || (linearLayout = this.f58398d) == null || linearLayout.getVisibility() != 0 || getActivity().isFinishing()) {
            return false;
        }
        a((View) this.f58398d);
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r12, android.view.View r13) {
        /*
            r11 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r11.f58396b
            androidx.recyclerview.widget.RecyclerView$a r0 = r0.getAdapter()
            net.one97.paytm.passbook.search.e r0 = (net.one97.paytm.passbook.search.e) r0
            if (r0 == 0) goto L_0x01df
            if (r13 == 0) goto L_0x01df
            android.widget.LinearLayout r1 = r11.f58398d
            if (r1 == 0) goto L_0x01df
            android.widget.TextView r1 = r11.f58402h
            if (r1 == 0) goto L_0x01df
            android.widget.TextView r1 = r11.f58401g
            if (r1 == 0) goto L_0x01df
            android.widget.TextView r1 = r11.f58403i
            if (r1 != 0) goto L_0x001e
            goto L_0x01df
        L_0x001e:
            android.util.SparseBooleanArray r1 = r0.f58422f
            r2 = 0
            boolean r1 = r1.get(r12, r2)
            r3 = 1
            if (r1 == 0) goto L_0x0040
            android.util.SparseBooleanArray r1 = r0.f58422f
            r1.delete(r12)
            if (r13 == 0) goto L_0x0082
            int r1 = net.one97.paytm.passbook.R.color.light_grey
            r13.setBackgroundResource(r1)
            int r1 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_ledger_icon_bg_iv
            android.view.View r13 = r13.findViewById(r1)
            android.content.Context r1 = r0.f58417a
            r0.a((android.view.View) r13, (android.content.Context) r1)
            goto L_0x006f
        L_0x0040:
            android.util.SparseBooleanArray r1 = r0.f58422f
            r1.put(r12, r3)
            if (r13 == 0) goto L_0x0082
            int r1 = net.one97.paytm.passbook.R.color.white
            r13.setBackgroundResource(r1)
            int r1 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_ledger_icon_bg_iv
            android.view.View r13 = r13.findViewById(r1)
            int r1 = r0.f58423g
            r4 = 16
            if (r1 < r4) goto L_0x0064
            android.content.res.Resources r1 = r0.f58420d
            int r4 = net.one97.paytm.passbook.R.drawable.pass_circle_border
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r4)
            r13.setBackground(r1)
            goto L_0x006f
        L_0x0064:
            android.content.res.Resources r1 = r0.f58420d
            int r4 = net.one97.paytm.passbook.R.drawable.pass_circle_border
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r4)
            r13.setBackgroundDrawable(r1)
        L_0x006f:
            android.content.Context r1 = r0.f58417a
            int r4 = net.one97.paytm.passbook.R.anim.pass_flip_anim
            android.view.animation.Animation r1 = android.view.animation.AnimationUtils.loadAnimation(r1, r4)
            r13.startAnimation(r1)
            net.one97.paytm.passbook.search.e$4 r13 = new net.one97.paytm.passbook.search.e$4
            r13.<init>()
            r1.setAnimationListener(r13)
        L_0x0082:
            r0.notifyItemChanged(r12)
            android.util.SparseBooleanArray r12 = r0.f58422f
            int r12 = r12.size()
            r13 = 3
            float[] r13 = new float[r13]
            java.util.ArrayList<net.one97.paytm.passbook.beans.CJRTransaction> r1 = r0.f58419c
            r4 = 0
            if (r1 == 0) goto L_0x00ec
            java.util.ArrayList<net.one97.paytm.passbook.beans.CJRTransaction> r1 = r0.f58419c
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00ec
            java.util.ArrayList<net.one97.paytm.passbook.beans.CJRTransaction> r1 = r0.f58419c
            int r1 = r1.size()
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x00a4:
            android.util.SparseBooleanArray r8 = r0.f58422f
            int r8 = r8.size()
            if (r5 >= r8) goto L_0x00ee
            android.util.SparseBooleanArray r8 = r0.f58422f
            int r8 = r8.keyAt(r5)
            if (r8 >= r1) goto L_0x00ee
            java.util.ArrayList<net.one97.paytm.passbook.beans.CJRTransaction> r9 = r0.f58419c
            java.lang.Object r8 = r9.get(r8)
            net.one97.paytm.passbook.beans.CJRTransaction r8 = (net.one97.paytm.passbook.beans.CJRTransaction) r8
            if (r8 == 0) goto L_0x00ee
            java.lang.String r9 = r8.getTxnType()
            java.lang.String r10 = "DR"
            boolean r9 = r9.equalsIgnoreCase(r10)
            if (r9 == 0) goto L_0x00d4
            java.lang.String r8 = r8.getTxnAmount()
            float r8 = java.lang.Float.parseFloat(r8)
            float r7 = r7 + r8
            goto L_0x00e9
        L_0x00d4:
            java.lang.String r9 = r8.getTxnType()
            java.lang.String r10 = "CR"
            boolean r9 = r9.equalsIgnoreCase(r10)
            if (r9 == 0) goto L_0x00e9
            java.lang.String r8 = r8.getTxnAmount()
            float r8 = java.lang.Float.parseFloat(r8)
            float r6 = r6 + r8
        L_0x00e9:
            int r5 = r5 + 1
            goto L_0x00a4
        L_0x00ec:
            r6 = 0
            r7 = 0
        L_0x00ee:
            r13[r2] = r6
            r13[r3] = r7
            float r6 = r6 - r7
            r0 = 2
            r13[r0] = r6
            if (r12 <= 0) goto L_0x012d
            android.widget.LinearLayout r12 = r11.f58398d
            int r12 = r12.getVisibility()
            r1 = 8
            if (r12 != r1) goto L_0x012d
            android.widget.LinearLayout r12 = r11.f58398d
            r12.setVisibility(r2)
            android.widget.LinearLayout r12 = r11.f58398d
            android.view.animation.AccelerateInterpolator r1 = new android.view.animation.AccelerateInterpolator
            r1.<init>()
            android.view.ViewPropertyAnimator r12 = r12.animate()
            android.view.ViewPropertyAnimator r5 = r12.translationY(r4)
            r6 = 500(0x1f4, double:2.47E-321)
            android.view.ViewPropertyAnimator r5 = r5.setDuration(r6)
            android.view.ViewPropertyAnimator r1 = r5.setInterpolator(r1)
            net.one97.paytm.passbook.search.d$5 r5 = new net.one97.paytm.passbook.search.d$5
            r5.<init>(r12)
            android.view.ViewPropertyAnimator r12 = r1.setListener(r5)
            r12.start()
            goto L_0x0148
        L_0x012d:
            r12 = r13[r2]
            r1 = r13[r3]
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 != 0) goto L_0x0148
            r12 = r13[r3]
            r1 = r13[r0]
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 != 0) goto L_0x0148
            r12 = r13[r0]
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 != 0) goto L_0x0148
            android.widget.LinearLayout r12 = r11.f58398d
            r11.a((android.view.View) r12)
        L_0x0148:
            android.content.res.Resources r12 = r11.getResources()
            int r1 = net.one97.paytm.passbook.R.string.wallet_rs
            java.lang.String r12 = r12.getString(r1)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            r5 = r13[r2]
            float r5 = a((float) r5)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r1[r2] = r5
            java.lang.String r12 = java.lang.String.format(r12, r1)
            android.widget.TextView r1 = r11.f58402h
            r1.setText(r12)
            android.content.res.Resources r12 = r11.getResources()
            int r1 = net.one97.paytm.passbook.R.string.wallet_rs
            java.lang.String r12 = r12.getString(r1)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            r3 = r13[r3]
            float r3 = a((float) r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r1[r2] = r3
            java.lang.String r12 = java.lang.String.format(r12, r1)
            android.widget.TextView r1 = r11.f58401g
            r1.setText(r12)
            r12 = r13[r0]
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 >= 0) goto L_0x01bb
            android.widget.TextView r12 = r11.f58403i
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "-"
            r1.<init>(r2)
            android.content.res.Resources r2 = r11.getResources()
            int r3 = net.one97.paytm.passbook.R.string.wallet_rs_sign
            java.lang.String r2 = r2.getString(r3)
            r1.append(r2)
            r13 = r13[r0]
            float r13 = a((float) r13)
            float r13 = java.lang.Math.abs(r13)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            r12.setText(r13)
            return
        L_0x01bb:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            android.content.res.Resources r1 = r11.getResources()
            int r2 = net.one97.paytm.passbook.R.string.wallet_rs_sign
            java.lang.String r1 = r1.getString(r2)
            r12.append(r1)
            r13 = r13[r0]
            float r13 = a((float) r13)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            android.widget.TextView r13 = r11.f58403i
            r13.setText(r12)
        L_0x01df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.search.d.a(int, android.view.View):void");
    }

    private static float a(float f2) {
        return new BigDecimal(Float.toString(f2)).setScale(2, 4).floatValue();
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        androidx.core.h.d dVar = this.f58400f;
        if (dVar == null) {
            return false;
        }
        dVar.a(motionEvent);
        return false;
    }

    public final void d() {
        if (getActivity() instanceof l) {
            ((l) getActivity()).b();
        } else if (getActivity() instanceof g) {
            getActivity();
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        if (getActivity() instanceof l) {
            ((l) getActivity()).a(str, jSONObject);
        }
    }

    public final void a(String str) {
        if (getActivity() instanceof l) {
            ((l) getActivity()).b(str);
        }
    }

    public final void a(boolean z, String str) {
        if (z) {
            try {
                if (!(this.j == null || this.k == null)) {
                    boolean z2 = false;
                    this.j.setVisibility(0);
                    this.k.setVisibility(0);
                    FragmentActivity activity = getActivity();
                    if (!(activity instanceof l)) {
                        return;
                    }
                    if (!((l) activity).i()) {
                        ArrayList<? extends IJRDataModel> c2 = ((l) activity).c(StringSet.all);
                        if (c2 != null && c2.size() > 0) {
                            z2 = true;
                        }
                        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(StringSet.all)) {
                            this.j.setText(getResources().getString(R.string.no_transaction_result_all));
                            this.k.setImageResource(R.drawable.pass_no_entry_passbook);
                            return;
                        } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("DR")) {
                            if (z2) {
                                this.j.setText(getResources().getString(R.string.no_transaction_result_more_paid));
                            } else {
                                this.j.setText(getResources().getString(R.string.no_transaction_result_paid));
                            }
                            this.k.setImageResource(R.drawable.pass_no_recent_payment);
                            return;
                        } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("CR_added")) {
                            if (z2) {
                                this.j.setText(getResources().getString(R.string.no_transaction_result_more_added));
                            } else {
                                this.j.setText(getResources().getString(R.string.no_transaction_result_added));
                            }
                            this.k.setImageResource(R.drawable.pass_add_money_no_data);
                            return;
                        } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("CR")) {
                            if (z2) {
                                this.j.setText(getResources().getString(R.string.no_transaction_result_more_received));
                            } else {
                                this.j.setText(getResources().getString(R.string.no_transaction_result_received));
                            }
                            this.k.setImageResource(R.drawable.pass_no_requests_icon);
                            return;
                        } else {
                            return;
                        }
                    } else if (activity != null && !activity.isFinishing()) {
                        if (activity instanceof PassbookSearchActivity) {
                            this.j.setText(getResources().getString(R.string.no_search_result));
                            this.k.setImageResource(R.drawable.pass_no_entry_passbook);
                            return;
                        }
                        this.j.setText(getResources().getString(R.string.no_result_transfer_tobank));
                        this.k.setImageResource(R.drawable.pass_no_entry_passbook);
                        return;
                    } else {
                        return;
                    }
                }
            } catch (OutOfMemoryError unused) {
                System.gc();
                return;
            } catch (Exception unused2) {
                return;
            }
        }
        if (this.j != null && this.k != null) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b2) {
            this();
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.f58396b == null || d.this.p == null) {
                return false;
            }
            View findChildViewUnder = d.this.f58396b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            int childPosition = d.this.f58396b.getChildPosition(findChildViewUnder);
            if (d.this.p == null) {
                d dVar = d.this;
                a unused = dVar.p = new a(findChildViewUnder, childPosition);
            } else {
                d.this.p.f58413a = findChildViewUnder;
                d.this.p.f58414b = childPosition;
            }
            d.a(d.this, findChildViewUnder, childPosition);
            return super.onSingleTapConfirmed(motionEvent);
        }

        public final void onLongPress(MotionEvent motionEvent) {
            boolean unused = d.this.o = true;
            if (d.this.f58396b != null) {
                View findChildViewUnder = d.this.f58396b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                d.this.a(d.this.f58396b.getChildPosition(findChildViewUnder), findChildViewUnder);
                super.onLongPress(motionEvent);
            }
        }
    }

    private void a(final View view) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        final ViewPropertyAnimator animate = view.animate();
        animate.translationY((float) view.getHeight()).setDuration(500).setInterpolator(accelerateInterpolator).setListener(new Animator.AnimatorListener() {
            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                e eVar = (e) d.this.f58396b.getAdapter();
                View view = view;
                if (view != null) {
                    view.setVisibility(8);
                }
                if (eVar != null) {
                    eVar.f58422f.clear();
                    eVar.notifyDataSetChanged();
                }
                boolean unused = d.this.o = false;
            }

            public final void onAnimationCancel(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
            }
        }).start();
    }

    public final boolean b() {
        return f() && this.f58395a;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        View f58413a;

        /* renamed from: b  reason: collision with root package name */
        int f58414b;

        public a(View view, int i2) {
            this.f58413a = view;
            this.f58414b = i2;
        }
    }

    static /* synthetic */ void a(d dVar, View view, int i2) {
        if (!dVar.o || ((l) dVar.q).i()) {
            e eVar = (e) dVar.f58396b.getAdapter();
            if (view != null && eVar != null && eVar.f58419c != null && i2 < eVar.f58419c.size() && !TextUtils.isEmpty(eVar.f58419c.get(i2).getType())) {
                if (eVar.f58425i) {
                    eVar.f58425i = false;
                    return;
                }
                CJRTransaction cJRTransaction = eVar.f58419c.get(i2);
                if (PassbookTransactionDetailsActivity.a(cJRTransaction.getType(), cJRTransaction.getTxnStatus(), cJRTransaction.getTxnDesc1())) {
                    Intent intent = new Intent(eVar.f58417a, PassbookTransactionDetailsActivity.class);
                    intent.putExtra("passbook_detail_data", eVar.f58419c.get(i2));
                    intent.putExtra("EXTENDED_TXN_INFO", eVar.b());
                    eVar.f58417a.startActivity(intent);
                    return;
                }
                Intent intent2 = new Intent(eVar.f58417a, PassbookDetailActivity.class);
                intent2.putExtra("passbook_detail_data", eVar.f58419c.get(i2));
                intent2.putExtra("EXTENDED_TXN_INFO", eVar.b());
                eVar.f58417a.startActivity(intent2);
                return;
            }
            return;
        }
        dVar.a(i2, view);
    }
}

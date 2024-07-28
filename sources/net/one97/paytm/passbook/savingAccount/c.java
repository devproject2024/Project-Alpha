package net.one97.paytm.passbook.savingAccount;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.paytm.utility.v;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.SavingAccountPassbookEntriesModal;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.other.PassbookMainActivityEvent;
import net.one97.paytm.passbook.savingAccount.b;
import net.one97.paytm.passbook.utility.d;
import net.one97.paytm.passbook.utility.l;
import net.one97.paytm.upi.util.UpiConstants;

public class c extends h implements RecyclerView.k, d, net.one97.paytm.passbook.utility.h {

    /* renamed from: a  reason: collision with root package name */
    boolean f58282a = false;

    /* renamed from: b  reason: collision with root package name */
    public Fragment f58283b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> f58284c;

    /* renamed from: d  reason: collision with root package name */
    boolean f58285d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f58286e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public LinearLayoutManager f58287f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public d f58288g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f58289h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f58290i;
    private ImageView j;
    private RelativeLayout k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public int m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout o;
    private View p;
    private int q = 0;
    /* access modifiers changed from: private */
    public String r;

    public final boolean b() {
        return false;
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        return false;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.f58289h = arguments.getString("entrytype", StringSet.all);
        this.q = arguments.getInt("filterpos");
        View inflate = layoutInflater.inflate(R.layout.pass_fragment_saving_account_entries, (ViewGroup) null);
        this.k = (RelativeLayout) inflate.findViewById(R.id.passbook_entrylist_no_result_layout);
        this.o = (SwipeRefreshLayout) inflate.findViewById(R.id.swipeRefreshLayout);
        this.f58286e = (RecyclerView) inflate.findViewById(R.id.passbook_entrylist_recycler);
        this.f58290i = (TextView) inflate.findViewById(R.id.passbook_entrylist_no_result_layout_no_data_tv);
        this.j = (ImageView) inflate.findViewById(R.id.passbook_entrylist_no_result_layout_no_data_img);
        this.p = inflate;
        this.f58284c = new ArrayList<>();
        this.f58285d = getArguments().getBoolean(UpiConstants.EXTRA_INTENT_UPI_FROM_CST);
        this.f58283b = b.a();
        Fragment fragment = this.f58283b;
        if (fragment != null && (fragment instanceof l)) {
            ((l) fragment).a((net.one97.paytm.passbook.utility.h) this);
        }
        Fragment fragment2 = this.f58283b;
        if (fragment2 != null && (fragment2 instanceof l)) {
            this.r = ((l) fragment2).c();
        }
        if (this.f58283b == null) {
            this.f58283b = b.a();
        }
        if (this.f58284c == null) {
            this.f58284c = new ArrayList<>();
        }
        this.f58288g = new d(this, this.f58289h, this.f58284c, this.f58285d, this.r);
        this.f58286e.setAdapter(this.f58288g);
        this.f58287f = new LinearLayoutManager(getActivity());
        this.f58287f.setOrientation(1);
        this.f58286e.setLayoutManager(this.f58287f);
        this.f58286e.setItemAnimator(new g());
        this.f58286e.addOnItemTouchListener(this);
        Fragment fragment3 = this.f58283b;
        if (!(fragment3 instanceof l) || fragment3.getActivity() == null || this.f58283b.getActivity().isFinishing() || ((l) this.f58283b).i()) {
            d();
        } else {
            d();
            Fragment fragment4 = this.f58283b;
            if (!(fragment4 == null || ((l) fragment4).c(this.f58289h) == null)) {
                ArrayList<? extends IJRDataModel> c2 = ((l) this.f58283b).c(this.f58289h);
                if (c2 == null) {
                    c2 = new ArrayList<>();
                }
                if (c2.size() > 0) {
                    int size = this.f58284c.size();
                    this.f58284c.addAll(c2);
                    if (size == 0) {
                        e();
                    }
                    this.f58288g.b((ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail>) c2);
                }
                ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList = this.f58284c;
                if (arrayList == null || arrayList.size() <= 0) {
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
                a(this.f58288g);
            }
        }
        this.o.setOnRefreshListener(new SwipeRefreshLayout.b() {
            public final void onRefresh() {
                c.this.o.setRefreshing(false);
                c cVar = c.this;
                if (cVar.f58283b instanceof l) {
                    ((l) cVar.f58283b).b();
                }
                PassbookMainActivityEvent passbookMainActivityEvent = new PassbookMainActivityEvent();
                passbookMainActivityEvent.setActionType(0);
                passbookMainActivityEvent.setOuterTabPosition(1);
                d.a.a.c.a().d(passbookMainActivityEvent);
            }
        });
        c();
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    /* access modifiers changed from: private */
    public void c() {
        d dVar;
        if (this.f58284c != null) {
            if (this.f58283b == null) {
                this.f58283b = b.a();
            }
            int i2 = 0;
            if (this.q != 0 || (dVar = this.f58288g) == null) {
                int i3 = this.q;
                if (i3 == 1) {
                    ArrayList arrayList = new ArrayList();
                    while (i2 < this.f58284c.size()) {
                        if (b.a.DEBIT.getSavingAccountPassbookConstantName().equalsIgnoreCase(this.f58284c.get(i2).getTxnType())) {
                            arrayList.add(this.f58284c.get(i2));
                        }
                        i2++;
                    }
                    this.f58288g.a((ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail>) arrayList);
                } else if (i3 == 2) {
                    ArrayList arrayList2 = new ArrayList();
                    while (i2 < this.f58284c.size()) {
                        if (b.a.CREDIT.getSavingAccountPassbookConstantName().equalsIgnoreCase(this.f58284c.get(i2).getTxnType())) {
                            arrayList2.add(this.f58284c.get(i2));
                        }
                        i2++;
                    }
                    this.f58288g.a((ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail>) arrayList2);
                }
            } else {
                dVar.a(this.f58284c);
                int findFirstVisibleItemPosition = this.f58287f.findFirstVisibleItemPosition();
                if (findFirstVisibleItemPosition != -1) {
                    Fragment fragment = this.f58283b;
                    if ((fragment instanceof l) && fragment.getActivity() != null) {
                        ((l) this.f58283b).a(this.f58288g.a(findFirstVisibleItemPosition));
                    }
                } else if (this.f58284c.size() > 0) {
                    Fragment fragment2 = this.f58283b;
                    if ((fragment2 instanceof l) && fragment2.getActivity() != null) {
                        l lVar = (l) this.f58283b;
                        d dVar2 = this.f58288g;
                        String str = null;
                        if (dVar2.f58294a.size() > 0) {
                            str = dVar2.a(dVar2.f58294a.get(0).getTxnPostDate());
                        }
                        lVar.a(str);
                    }
                }
            }
            this.f58288g.notifyDataSetChanged();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        SwipeRefreshLayout swipeRefreshLayout = this.o;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.removeAllViews();
            this.o.setEnabled(false);
        }
        Fragment fragment = this.f58283b;
        if (fragment != null && (fragment instanceof l)) {
            ((l) fragment).b((net.one97.paytm.passbook.utility.h) this);
        }
        this.f58286e = null;
        this.f58287f = null;
        this.f58288g = null;
        this.f58289h = null;
        System.gc();
    }

    public void onDetach() {
        super.onDetach();
    }

    public final void a() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            SwipeRefreshLayout swipeRefreshLayout = this.o;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(false);
            }
            getActivity().runOnUiThread(new Runnable() {
                public final void run() {
                    if (c.this.f58289h != null && c.this.f58283b != null && (c.this.f58283b instanceof l)) {
                        c cVar = c.this;
                        cVar.f58284c = ((l) cVar.f58283b).c(c.this.f58289h);
                        if (c.this.f58284c != null && c.this.f58286e != null) {
                            if (c.this.f58288g == null) {
                                c cVar2 = c.this;
                                d unused = cVar2.f58288g = new d(cVar2, cVar2.f58289h, c.this.f58284c, c.this.f58285d, c.this.r);
                                c cVar3 = c.this;
                                cVar3.a(cVar3.f58288g);
                                SavingAccountPassbookEntriesModal.TransactionDetail b2 = c.this.f58288g.b(0);
                                if (b2 != null && !TextUtils.isEmpty(b2.getTxnPostDate())) {
                                    ((l) c.this.f58283b).a(net.one97.paytm.passbook.mapping.c.k("yyyy-MM-dd HH:mm:ss.SSS", "MMMM yyyy", b2.getTxnPostDate()));
                                    return;
                                }
                                return;
                            }
                            if (c.this.f58288g != null) {
                                c.this.f58288g.b(c.this.f58284c);
                            }
                            c.this.c();
                        }
                    }
                }
            });
        }
    }

    private void d() {
        this.f58286e.addOnScrollListener(new RecyclerView.l() {
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0) {
                    if (i2 != 1 && i2 != 2) {
                    }
                } else if (c.this.f58287f != null) {
                    c.this.e();
                    c cVar = c.this;
                    int unused = cVar.l = cVar.f58287f.getChildCount();
                    c cVar2 = c.this;
                    int unused2 = cVar2.m = cVar2.f58287f.getItemCount();
                    c cVar3 = c.this;
                    int unused3 = cVar3.n = cVar3.f58287f.findFirstVisibleItemPosition();
                    if (c.this.f58283b != null && (c.this.f58283b instanceof l) && !((l) c.this.f58283b).g() && c.this.l + c.this.n >= c.this.m && c.this.n >= 0 && com.paytm.utility.b.c((Context) c.this.getActivity()) && c.this.f58283b != null && (c.this.f58283b instanceof l)) {
                        ((l) c.this.f58283b).d();
                    }
                }
            }

            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
            }
        });
    }

    /* access modifiers changed from: private */
    public void e() {
        LinearLayoutManager linearLayoutManager;
        Fragment fragment;
        if (this.f58283b != null && this.f58286e != null && (linearLayoutManager = this.f58287f) != null) {
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            RecyclerView.a adapter = this.f58286e.getAdapter();
            if (adapter == null || adapter.getItemCount() <= 0 || findFirstVisibleItemPosition < 0) {
                Fragment fragment2 = this.f58283b;
                if (fragment2 != null && (fragment2 instanceof l)) {
                    ((l) fragment2).a("");
                    return;
                }
                return;
            }
            d dVar = (d) adapter;
            String a2 = dVar.a(findFirstVisibleItemPosition);
            dVar.b(findFirstVisibleItemPosition).getTxnPostDate();
            if (!v.a(a2) && (fragment = this.f58283b) != null && (fragment instanceof l)) {
                ((l) fragment).a(a2);
            }
            dVar.f58295b = findFirstVisibleItemPosition;
        }
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        this.f58282a = z;
        if (z) {
            try {
                e();
            } catch (Exception unused) {
            }
        }
    }

    public final void a(boolean z, String str) {
        if (z) {
            try {
                if (!(this.f58290i == null || this.j == null)) {
                    this.f58290i.setVisibility(0);
                    this.j.setVisibility(0);
                    this.k.setVisibility(0);
                    if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(StringSet.all)) {
                        this.f58290i.setText(getResources().getString(R.string.sa_no_txn));
                        this.j.setImageResource(R.drawable.pass_ic_sa_no_trans);
                        return;
                    } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_CONSTANT)) {
                        this.f58290i.setText(getResources().getString(R.string.sa_no_txn));
                        this.j.setImageResource(R.drawable.pass_ic_sa_no_trans);
                        return;
                    } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("CR_added")) {
                        this.f58290i.setText(getResources().getString(R.string.sa_no_txn));
                        this.j.setImageResource(R.drawable.pass_ic_sa_no_trans);
                        return;
                    } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(AppConstants.FEED_COMMUNITY)) {
                        this.f58290i.setText(getResources().getString(R.string.sa_no_txn));
                        this.j.setImageResource(R.drawable.pass_ic_sa_no_trans);
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
        if (!(this.f58290i == null || this.j == null)) {
            this.f58290i.setVisibility(8);
            this.j.setVisibility(8);
        }
        this.k.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void a(d dVar) {
        RecyclerView recyclerView = this.f58286e;
        if (recyclerView != null && this.f58287f != null && dVar != null) {
            recyclerView.setAdapter(dVar);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }
}

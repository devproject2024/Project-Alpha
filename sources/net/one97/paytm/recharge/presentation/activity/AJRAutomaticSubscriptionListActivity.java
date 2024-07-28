package net.one97.paytm.recharge.presentation.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.view.viewmodel.SharedHomeVM;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.automatic.b.a.h;
import net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionProductModel;
import net.one97.paytm.recharge.presentation.a.e;
import net.one97.paytm.recharge.presentation.b.a;

public final class AJRAutomaticSubscriptionListActivity extends PaytmActivity implements View.OnClickListener, a.C1275a, net.one97.paytm.recharge.presentation.d.a, net.one97.paytm.recharge.presentation.d.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CJRAutomaticSubscriptionListModel f64666a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.recharge.presentation.g.a f64667b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public View f64668c;

    /* renamed from: d  reason: collision with root package name */
    private View f64669d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f64670e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f64671f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public net.one97.paytm.recharge.widgets.widget.a f64672g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public e f64673h;

    /* renamed from: i  reason: collision with root package name */
    private String f64674i;
    /* access modifiers changed from: private */
    public boolean j;
    private HashMap k;

    public final View b(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionListModel>, x> {
        final /* synthetic */ AJRAutomaticSubscriptionListActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AJRAutomaticSubscriptionListActivity aJRAutomaticSubscriptionListActivity) {
            super(1);
            this.this$0 = aJRAutomaticSubscriptionListActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionListModel>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f64676a;

            a(b bVar) {
                this.f64676a = bVar;
            }

            public final void run() {
                ProgressBar progressBar = (ProgressBar) this.f64676a.this$0.b(R.id.progress_bar);
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                AJRAutomaticSubscriptionListActivity.j(this.f64676a.this$0);
            }
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionListModel> bVar) {
            CJRAutomaticSubscriptionListModel d2;
            ArrayList<CJRAutomaticSubscriptionItemModel> subscriptionModelArrayList;
            ProgressBar progressBar;
            ProgressBar progressBar2;
            if (bVar != null) {
                int i2 = d.f64714a[bVar.f64955c.ordinal()];
                if (i2 == 1) {
                    ProgressBar progressBar3 = (ProgressBar) this.this$0.b(R.id.progress_bar);
                    if (progressBar3 != null) {
                        progressBar3.setVisibility(0);
                    }
                } else if (i2 != 2) {
                    if (i2 == 3 && (progressBar2 = (ProgressBar) this.this$0.b(R.id.progress_bar)) != null) {
                        progressBar2.setVisibility(8);
                    }
                } else if (!this.this$0.j && (progressBar = (ProgressBar) this.this$0.b(R.id.progress_bar)) != null) {
                    progressBar.setVisibility(8);
                }
                CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel = (CJRAutomaticSubscriptionListModel) bVar.f64954b;
                if (cJRAutomaticSubscriptionListModel != null) {
                    this.this$0.f64666a = cJRAutomaticSubscriptionListModel;
                    CJRAutomaticSubscriptionListModel d3 = this.this$0.f64666a;
                    if ((d3 != null ? d3.getSubscriptionModelArrayList() : null) == null || !((d2 = this.this$0.f64666a) == null || (subscriptionModelArrayList = d2.getSubscriptionModelArrayList()) == null || !subscriptionModelArrayList.isEmpty())) {
                        ProgressBar progressBar4 = (ProgressBar) this.this$0.b(R.id.progress_bar);
                        if (progressBar4 != null) {
                            progressBar4.setVisibility(8);
                        }
                        this.this$0.j = false;
                        if (this.this$0.f64670e) {
                            this.this$0.f64670e = false;
                            TextView textView = (TextView) this.this$0.b(R.id.txt_heading);
                            if (textView != null) {
                                textView.setVisibility(0);
                            }
                            TextView textView2 = (TextView) this.this$0.b(R.id.btn_setup_new_automatic);
                            if (textView2 != null) {
                                textView2.setVisibility(0);
                            }
                            e g2 = this.this$0.f64673h;
                            if (g2 != null) {
                                g2.a((ArrayList<CJRAutomaticSubscriptionItemModel>) null);
                            }
                            TextView textView3 = (TextView) this.this$0.b(R.id.no_active_subscription);
                            if (textView3 != null) {
                                textView3.setVisibility(0);
                            }
                        } else {
                            TextView textView4 = (TextView) this.this$0.b(R.id.no_active_subscription);
                            if (textView4 != null) {
                                textView4.setVisibility(8);
                            }
                            this.this$0.a();
                            this.this$0.finish();
                        }
                    } else {
                        TextView textView5 = (TextView) this.this$0.b(R.id.no_active_subscription);
                        if (textView5 != null) {
                            textView5.setVisibility(8);
                        }
                        if (this.this$0.j) {
                            this.this$0.j = false;
                            AJRAutomaticSubscriptionListActivity.i(this.this$0);
                            TextView textView6 = (TextView) this.this$0.b(R.id.no_active_subscription);
                            if (textView6 != null) {
                                textView6.postDelayed(new a(this), 500);
                            }
                        } else {
                            AJRAutomaticSubscriptionListActivity.j(this.this$0);
                        }
                    }
                }
                NetworkCustomError networkCustomError = bVar.f64953a;
                if (networkCustomError == null) {
                    return;
                }
                if (networkCustomError.getStatusCode() == 403 || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410) {
                    net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                    net.one97.paytm.recharge.automatic.c.a.a.a((Activity) this.this$0, networkCustomError, (int) SharedHomeVM.INITKYCFORNAME);
                    return;
                }
                this.this$0.a();
                this.this$0.finish();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d8, code lost:
        r7 = r7.f64924a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            int r7 = net.one97.paytm.recharge.automatic.R.layout.activity_subscription_list
            r6.setContentView((int) r7)
            int r7 = net.one97.paytm.recharge.automatic.R.id.rv_subscription_list
            android.view.View r7 = r6.b((int) r7)
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            r0 = 1
            r7.setHasFixedSize(r0)
            int r7 = net.one97.paytm.recharge.automatic.R.id.rv_subscription_list
            android.view.View r7 = r6.b((int) r7)
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            java.lang.String r1 = "rv_subscription_list"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            r2 = r6
            android.content.Context r2 = (android.content.Context) r2
            r3 = 0
            r1.<init>(r2, r0, r3)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r1
            r7.setLayoutManager(r1)
            int r7 = net.one97.paytm.recharge.automatic.R.id.rv_subscription_list
            android.view.View r7 = r6.b((int) r7)
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x0043
            net.one97.paytm.recharge.automatic.b.a r1 = new net.one97.paytm.recharge.automatic.b.a
            r1.<init>()
            androidx.recyclerview.widget.RecyclerView$h r1 = (androidx.recyclerview.widget.RecyclerView.h) r1
            r7.addItemDecoration(r1)
        L_0x0043:
            android.content.Intent r7 = r6.getIntent()
            r1 = 0
            if (r7 == 0) goto L_0x0077
            java.lang.String r4 = "extra_home_data"
            boolean r5 = r7.hasExtra(r4)
            if (r5 == 0) goto L_0x0077
            java.io.Serializable r7 = r7.getSerializableExtra(r4)
            boolean r4 = r7 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem
            if (r4 != 0) goto L_0x005b
            r7 = r1
        L_0x005b:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r7 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r7
            if (r7 == 0) goto L_0x0077
            boolean r4 = r7.isDeepLinking()
            if (r4 == 0) goto L_0x0077
            java.lang.String r7 = r7.getPushRechargeNumber()
            r6.f64674i = r7
            java.lang.String r7 = r6.f64674i
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0077
            r6.j = r0
        L_0x0077:
            androidx.appcompat.app.ActionBar r7 = r6.getSupportActionBar()
            if (r7 == 0) goto L_0x0080
            r7.b((boolean) r0)
        L_0x0080:
            androidx.appcompat.app.ActionBar r7 = r6.getSupportActionBar()
            if (r7 == 0) goto L_0x008d
            java.lang.String r0 = ""
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7.a((java.lang.CharSequence) r0)
        L_0x008d:
            androidx.appcompat.app.ActionBar r7 = r6.getSupportActionBar()
            if (r7 == 0) goto L_0x0098
            r0 = 1092616192(0x41200000, float:10.0)
            r7.a((float) r0)
        L_0x0098:
            r7 = r6
            androidx.fragment.app.FragmentActivity r7 = (androidx.fragment.app.FragmentActivity) r7
            net.one97.paytm.recharge.presentation.e.a r0 = new net.one97.paytm.recharge.presentation.e.a
            r0.<init>()
            androidx.lifecycle.al$b r0 = (androidx.lifecycle.al.b) r0
            androidx.lifecycle.al r7 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r7, (androidx.lifecycle.al.b) r0)
            java.lang.Class<net.one97.paytm.recharge.presentation.g.a> r0 = net.one97.paytm.recharge.presentation.g.a.class
            androidx.lifecycle.ai r7 = r7.a(r0)
            net.one97.paytm.recharge.presentation.g.a r7 = (net.one97.paytm.recharge.presentation.g.a) r7
            r6.f64667b = r7
            net.one97.paytm.recharge.presentation.g.a r7 = r6.f64667b
            if (r7 == 0) goto L_0x00b7
            androidx.lifecycle.y<net.one97.paytm.recharge.presentation.g.b<net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel>> r7 = r7.f64924a
            goto L_0x00b8
        L_0x00b7:
            r7 = r1
        L_0x00b8:
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity$b r0 = new net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity$b
            r0.<init>(r6)
            kotlin.g.a.b r0 = (kotlin.g.a.b) r0
            net.one97.paytm.recharge.automatic.b.a.d.a(r6, r7, r0)
            boolean r7 = com.paytm.network.b.b.a(r2)
            if (r7 != 0) goto L_0x00ce
            r6.c()
            goto L_0x0102
        L_0x00ce:
            boolean r7 = com.paytm.utility.d.c(r2)
            if (r7 == 0) goto L_0x00ea
            net.one97.paytm.recharge.presentation.g.a r7 = r6.f64667b
            if (r7 == 0) goto L_0x00e3
            androidx.lifecycle.y<net.one97.paytm.recharge.presentation.g.b<net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel>> r7 = r7.f64924a
            if (r7 == 0) goto L_0x00e3
            java.lang.Object r7 = r7.getValue()
            net.one97.paytm.recharge.presentation.g.b r7 = (net.one97.paytm.recharge.presentation.g.b) r7
            goto L_0x00e4
        L_0x00e3:
            r7 = r1
        L_0x00e4:
            if (r7 != 0) goto L_0x00f4
            r6.b()
            goto L_0x00f4
        L_0x00ea:
            net.one97.paytm.recharge.automatic.c.a.a r7 = net.one97.paytm.recharge.automatic.c.a.a.f60256a
            r7 = r6
            android.app.Activity r7 = (android.app.Activity) r7
            r0 = 1013(0x3f5, float:1.42E-42)
            net.one97.paytm.recharge.automatic.c.a.a.a((android.app.Activity) r7, (int) r0)
        L_0x00f4:
            int r7 = net.one97.paytm.recharge.automatic.R.id.btn_setup_new_automatic
            android.view.View r7 = r6.b((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r0 = r6
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r7.setOnClickListener(r0)
        L_0x0102:
            android.view.Window r7 = r6.getWindow()
            if (r7 == 0) goto L_0x010d
            android.view.View r7 = r7.getDecorView()
            goto L_0x010e
        L_0x010d:
            r7 = r1
        L_0x010e:
            boolean r0 = r7 instanceof android.view.ViewGroup
            if (r0 != 0) goto L_0x0113
            r7 = r1
        L_0x0113:
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            android.view.View r0 = r6.f64668c
            if (r0 != 0) goto L_0x013e
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r2)
            int r4 = net.one97.paytm.recharge.automatic.R.layout.lyt_automatic_set_successful
            android.view.View r0 = r0.inflate(r4, r1, r3)
            r6.f64668c = r0
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = -1
            r4 = -2
            r0.<init>(r1, r4)
            r1 = 24
            int r1 = com.paytm.utility.b.c((int) r1)
            r0.setMargins(r3, r1, r3, r3)
            if (r7 == 0) goto L_0x013e
            android.view.View r1 = r6.f64668c
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r7.addView(r1, r0)
        L_0x013e:
            android.view.View r7 = r6.f64669d
            if (r7 != 0) goto L_0x014d
            net.one97.paytm.recharge.automatic.b.a.h$a r7 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
            r7 = r6
            android.app.Activity r7 = (android.app.Activity) r7
            android.view.View r7 = net.one97.paytm.recharge.automatic.b.a.h.a.a((android.app.Activity) r7)
            r6.f64669d = r7
        L_0x014d:
            android.content.Intent r7 = r6.getIntent()
            r6.a((android.content.Intent) r7)
            net.one97.paytm.recharge.automatic.c.a.a r7 = net.one97.paytm.recharge.automatic.c.a.a.f60256a
            net.one97.paytm.recharge.automatic.b.a.a$a r7 = net.one97.paytm.recharge.automatic.b.a.a.f60239a
            java.lang.String r7 = net.one97.paytm.recharge.automatic.b.a.a.T
            net.one97.paytm.recharge.automatic.c.a.a.a((android.content.Context) r2, (java.lang.String) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity.onCreate(android.os.Bundle):void");
    }

    private final void a(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("recharge_number");
            String stringExtra2 = intent.getStringExtra("nick_name");
            String stringExtra3 = intent.getStringExtra("operator_name");
            boolean booleanExtra = intent.getBooleanExtra("isSubscribed", false);
            boolean booleanExtra2 = intent.getBooleanExtra("isPending", false);
            if (intent.getBooleanExtra("is_event_subscription", false)) {
                a(booleanExtra, booleanExtra2, stringExtra, stringExtra2, stringExtra3, false);
            } else if (intent.hasExtra("is_from_edit_emandate") && intent.getBooleanExtra("is_from_edit_emandate", false)) {
                a(booleanExtra, booleanExtra2, stringExtra, stringExtra2, stringExtra3, true);
            }
        }
    }

    public final void onNewIntent(Intent intent) {
        a(intent);
    }

    /* access modifiers changed from: private */
    public final void a(boolean z, boolean z2, String str, String str2, String str3, boolean z3) {
        if (TextUtils.isEmpty(str2)) {
            str2 = str3;
        }
        if (TextUtils.isEmpty(str2)) {
            TextView textView = (TextView) b(R.id.txt_contact_name_operator_number);
            if (textView != null) {
                textView.setText(getString(R.string.set_subscription_number_details, new Object[]{str}));
            }
        } else {
            TextView textView2 = (TextView) b(R.id.txt_contact_name_operator_number);
            if (textView2 != null) {
                textView2.setText(getString(R.string.set_subscription_details, new Object[]{str2, str}));
            }
        }
        if (z) {
            View view = this.f64668c;
            if (view != null) {
                view.setVisibility(0);
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) b(R.id.lyt_success);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            b();
            TextView textView3 = (TextView) b(R.id.btn_okay);
            if (textView3 != null) {
                textView3.setOnClickListener(this);
            }
            View view2 = this.f64668c;
            if (view2 != null) {
                view2.postDelayed(new c(this), 3000);
            }
        } else if (z2) {
            if (z3) {
                View view3 = this.f64668c;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                ConstraintLayout constraintLayout2 = (ConstraintLayout) b(R.id.lyt_success);
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(0);
                }
                View view4 = this.f64668c;
                if (view4 != null) {
                    view4.postDelayed(new d(this), 3000);
                }
            }
            b();
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticSubscriptionListActivity f64677a;

        c(AJRAutomaticSubscriptionListActivity aJRAutomaticSubscriptionListActivity) {
            this.f64677a = aJRAutomaticSubscriptionListActivity;
        }

        public final void run() {
            View a2 = this.f64677a.f64668c;
            if (a2 != null) {
                a2.setVisibility(8);
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) this.f64677a.b(R.id.lyt_success);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticSubscriptionListActivity f64678a;

        d(AJRAutomaticSubscriptionListActivity aJRAutomaticSubscriptionListActivity) {
            this.f64678a = aJRAutomaticSubscriptionListActivity;
        }

        public final void run() {
            View a2 = this.f64678a.f64668c;
            if (a2 != null) {
                a2.setVisibility(8);
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) this.f64678a.b(R.id.lyt_success);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btn_okay;
        if (valueOf != null && valueOf.intValue() == i2) {
            ConstraintLayout constraintLayout = (ConstraintLayout) b(R.id.lyt_success);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            View view2 = this.f64668c;
            if (view2 != null) {
                view2.setVisibility(8);
                return;
            }
            return;
        }
        int i3 = R.id.btn_setup_new_automatic;
        if (valueOf != null && valueOf.intValue() == i3) {
            try {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String h2 = net.one97.paytm.recharge.automatic.b.a.a.f60247i;
                a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                net.one97.paytm.recharge.automatic.c.a.a.a(this, a2, h2, "", net.one97.paytm.recharge.automatic.b.a.a.Q, (Object) null, (Object) null, 96);
            } catch (Throwable unused) {
            }
            a();
            return;
        }
        int i4 = R.id.retry_button;
        if (valueOf != null && valueOf.intValue() == i4 && SystemClock.elapsedRealtime() - this.f64671f >= 2000) {
            this.f64671f = SystemClock.elapsedRealtime();
            if (com.paytm.utility.b.c((Context) this)) {
                q a3 = getSupportFragmentManager().a();
                net.one97.paytm.recharge.widgets.widget.a aVar5 = this.f64672g;
                if (aVar5 == null) {
                    k.a();
                }
                a3.a((Fragment) aVar5).b();
                FrameLayout frameLayout = (FrameLayout) b(R.id.offline_lyt_container);
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                b();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        Intent intent = new Intent(this, AJRAutomaticUnSubscribedList.class);
        intent.putExtra("automatic_subscription_list", this.f64666a);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void b() {
        Context context = this;
        if (com.paytm.utility.b.c(context)) {
            net.one97.paytm.recharge.presentation.g.a aVar = this.f64667b;
            if (aVar != null) {
                aVar.a(context);
                return;
            }
            return;
        }
        c();
    }

    public final void a(int i2) {
        CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel = this.f64666a;
        if (cJRAutomaticSubscriptionListModel == null) {
            k.a();
        }
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList().get(i2);
        k.a((Object) cJRAutomaticSubscriptionItemModel, "mSubscriptionListModel!!…nModelArrayList[position]");
        a(cJRAutomaticSubscriptionItemModel);
    }

    private final void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
        try {
            CJRAutomaticSubscriptionProductModel product = cJRAutomaticSubscriptionItemModel.getProduct();
            StringBuilder sb = new StringBuilder();
            String service = product.getService();
            if (service != null) {
                String lowerCase = service.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                sb.append(lowerCase);
                sb.append("_");
                String paytype = product.getPaytype();
                if (paytype != null) {
                    String lowerCase2 = paytype.toLowerCase();
                    k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                    sb.append(lowerCase2);
                    String sb2 = sb.toString();
                    net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                    a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                    String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                    a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                    net.one97.paytm.recharge.automatic.c.a.a.a(this, a2, net.one97.paytm.recharge.automatic.b.a.a.z, "", sb2, (Object) null, (Object) null, 96);
                    Intent intent = new Intent(this, AJRAutomaticSubscriptionManageActivity.class);
                    intent.putExtra("selected_automatic_subscribed_item", cJRAutomaticSubscriptionItemModel);
                    startActivityForResult(intent, CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE);
                    return;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable unused) {
        }
    }

    public final void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, int i2) {
        String str;
        k.c(cJRAutomaticSubscriptionItemModel, "subscriptionModel");
        CJRAutomaticSubscriptionProductModel product = cJRAutomaticSubscriptionItemModel.getProduct();
        if (product != null) {
            StringBuilder sb = new StringBuilder();
            String service = product.getService();
            if (service != null) {
                String lowerCase = service.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                sb.append(lowerCase);
                sb.append("_");
                String paytype = product.getPaytype();
                if (paytype != null) {
                    String lowerCase2 = paytype.toLowerCase();
                    k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                    sb.append(lowerCase2);
                    str = sb.toString();
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        } else {
            str = "";
        }
        String str2 = str;
        try {
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
            a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a(this, a2, net.one97.paytm.recharge.automatic.b.a.a.x, "", str2, (Object) null, (Object) null, 96);
        } catch (Exception unused) {
        }
        int i3 = cJRAutomaticSubscriptionItemModel.getStatus() == 0 ? 1 : 0;
        a.b bVar = net.one97.paytm.recharge.presentation.b.a.f64720a;
        a.b.a(cJRAutomaticSubscriptionItemModel, i3, (AutomaticSubscriptionSavedCard) null, i2, "", this).show(getSupportFragmentManager(), net.one97.paytm.recharge.presentation.b.a.class.getSimpleName());
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 204) {
            if (i3 == -1 && intent != null && intent.hasExtra("is_refresh_needed") && intent.getBooleanExtra("is_refresh_needed", false)) {
                if (intent.hasExtra("key_is_delete_automatic") && intent.getBooleanExtra("key_is_delete_automatic", false)) {
                    h.a aVar = h.f60252a;
                    h.a.a(this.f64669d);
                    this.f64670e = true;
                }
                b();
            }
        } else if (1013 != i2) {
        } else {
            if (i3 != 0) {
                b();
            } else {
                finish();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r0 = r0.getSubscriptionModelArrayList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r4, int r5) {
        /*
            r3 = this;
            r0 = -1
            if (r5 == r0) goto L_0x0052
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel r0 = r3.f64666a
            if (r0 == 0) goto L_0x0014
            java.util.ArrayList r0 = r0.getSubscriptionModelArrayList()
            if (r0 == 0) goto L_0x0014
            java.lang.Object r0 = r0.get(r5)
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = (net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel) r0
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            r0.setStatus(r4)
        L_0x001a:
            int r4 = net.one97.paytm.recharge.automatic.R.id.rv_subscription_list
            android.view.View r4 = r3.b((int) r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            java.lang.String r1 = "rv_subscription_list"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            androidx.recyclerview.widget.RecyclerView$a r4 = r4.getAdapter()
            if (r4 == 0) goto L_0x004a
            net.one97.paytm.recharge.presentation.a.e r4 = (net.one97.paytm.recharge.presentation.a.e) r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            if (r0 == 0) goto L_0x0049
            if (r5 != 0) goto L_0x0038
            goto L_0x0049
        L_0x0038:
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel> r1 = r4.f64599a
            int r2 = r5.intValue()
            r1.set(r2, r0)
            int r5 = r5.intValue()
            r4.notifyItemChanged(r5)
            goto L_0x0052
        L_0x0049:
            return
        L_0x004a:
            kotlin.u r4 = new kotlin.u
            java.lang.String r5 = "null cannot be cast to non-null type net.one97.paytm.recharge.presentation.adapter.CJRAutomaticSubscriptionListAdapter"
            r4.<init>(r5)
            throw r4
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity.a(int, int):void");
    }

    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private final void c() {
        this.f64672g = new net.one97.paytm.recharge.widgets.widget.a();
        net.one97.paytm.recharge.widgets.widget.a aVar = this.f64672g;
        if (aVar != null) {
            aVar.a(new a(this));
        }
        j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            q a2 = supportFragmentManager.a();
            int i2 = R.id.offline_lyt_container;
            net.one97.paytm.recharge.widgets.widget.a aVar2 = this.f64672g;
            if (aVar2 == null) {
                k.a();
            }
            a2.a(i2, aVar2, "").e();
        }
        FrameLayout frameLayout = (FrameLayout) b(R.id.offline_lyt_container);
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticSubscriptionListActivity f64675a;

        a(AJRAutomaticSubscriptionListActivity aJRAutomaticSubscriptionListActivity) {
            this.f64675a = aJRAutomaticSubscriptionListActivity;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.f64675a.f64671f >= 2000) {
                this.f64675a.f64671f = SystemClock.elapsedRealtime();
                if (this.f64675a.f64672g != null && com.paytm.utility.b.c((Context) this.f64675a)) {
                    j supportFragmentManager = this.f64675a.getSupportFragmentManager();
                    if (supportFragmentManager != null) {
                        q a2 = supportFragmentManager.a();
                        net.one97.paytm.recharge.widgets.widget.a l = this.f64675a.f64672g;
                        if (l == null) {
                            k.a();
                        }
                        q a3 = a2.a((Fragment) l);
                        if (a3 != null) {
                            a3.c();
                        }
                    }
                    FrameLayout frameLayout = (FrameLayout) this.f64675a.b(R.id.offline_lyt_container);
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    this.f64675a.b();
                }
            }
        }
    }

    public static final /* synthetic */ void i(AJRAutomaticSubscriptionListActivity aJRAutomaticSubscriptionListActivity) {
        CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel = aJRAutomaticSubscriptionListActivity.f64666a;
        ArrayList<CJRAutomaticSubscriptionItemModel> subscriptionModelArrayList = cJRAutomaticSubscriptionListModel != null ? cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList() : null;
        if (subscriptionModelArrayList == null) {
            k.a();
        }
        Iterator<CJRAutomaticSubscriptionItemModel> it2 = subscriptionModelArrayList.iterator();
        while (it2.hasNext()) {
            CJRAutomaticSubscriptionItemModel next = it2.next();
            if (!TextUtils.isEmpty(next.getRechargeNumber()) && !TextUtils.isEmpty(aJRAutomaticSubscriptionListActivity.f64674i) && p.a(aJRAutomaticSubscriptionListActivity.f64674i, next.getRechargeNumber(), true)) {
                k.a((Object) next, "subscriptionItem");
                aJRAutomaticSubscriptionListActivity.a(next);
                return;
            }
        }
    }

    public static final /* synthetic */ void j(AJRAutomaticSubscriptionListActivity aJRAutomaticSubscriptionListActivity) {
        TextView textView = (TextView) aJRAutomaticSubscriptionListActivity.b(R.id.txt_heading);
        boolean z = false;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = (TextView) aJRAutomaticSubscriptionListActivity.b(R.id.btn_setup_new_automatic);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel = aJRAutomaticSubscriptionListActivity.f64666a;
        Collection subscriptionModelArrayList = cJRAutomaticSubscriptionListModel != null ? cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList() : null;
        if (subscriptionModelArrayList == null || subscriptionModelArrayList.isEmpty()) {
            z = true;
        }
        if (!z) {
            e eVar = aJRAutomaticSubscriptionListActivity.f64673h;
            if (eVar == null) {
                CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel2 = aJRAutomaticSubscriptionListActivity.f64666a;
                if (cJRAutomaticSubscriptionListModel2 == null) {
                    k.a();
                }
                aJRAutomaticSubscriptionListActivity.f64673h = new e(cJRAutomaticSubscriptionListModel2.getSubscriptionModelArrayList(), aJRAutomaticSubscriptionListActivity, aJRAutomaticSubscriptionListActivity);
                RecyclerView recyclerView = (RecyclerView) aJRAutomaticSubscriptionListActivity.b(R.id.rv_subscription_list);
                k.a((Object) recyclerView, "rv_subscription_list");
                recyclerView.setAdapter(aJRAutomaticSubscriptionListActivity.f64673h);
            } else if (eVar != null) {
                CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel3 = aJRAutomaticSubscriptionListActivity.f64666a;
                if (cJRAutomaticSubscriptionListModel3 == null) {
                    k.a();
                }
                eVar.a(cJRAutomaticSubscriptionListModel3.getSubscriptionModelArrayList());
            }
        } else {
            e eVar2 = aJRAutomaticSubscriptionListActivity.f64673h;
            if (eVar2 != null) {
                eVar2.a((ArrayList<CJRAutomaticSubscriptionItemModel>) null);
            }
        }
    }
}

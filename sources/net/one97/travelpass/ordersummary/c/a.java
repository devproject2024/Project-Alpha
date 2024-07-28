package net.one97.travelpass.ordersummary.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.TPOrderSummaryContactUs;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.travelpass.R;
import net.one97.travelpass.b.i;
import net.one97.travelpass.e.j;
import net.one97.travelpass.ordersummary.model.OrderSummary;
import net.one97.travelpass.ordersummary.model.OrderSummaryBody;
import net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem;
import net.one97.travelpass.ui.fragment.g;

public final class a extends g implements com.one97.travelpass.a.b {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.travelpass.ordersummary.a.b f30498a;

    /* renamed from: b  reason: collision with root package name */
    OrderSummary f30499b;

    /* renamed from: c  reason: collision with root package name */
    private i f30500c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.travelpass.ordersummary.h.a f30501d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.travelpass.ordersummary.d.b f30502e = new net.one97.travelpass.ordersummary.d.b();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<net.one97.travelpass.ordersummary.g.a> f30503f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private String f30504g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f30505h = Boolean.FALSE;

    /* renamed from: i  reason: collision with root package name */
    private CJRParcelTrackingInfo f30506i;
    private ArrayList<TPOrderSummaryContactUs> j = new ArrayList<>();
    private net.one97.travelpass.ordersummary.d.a k;
    private HashMap l;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    static final class b<T> implements z<OrderSummary> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30508a;

        b(a aVar) {
            this.f30508a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String status;
            OrderSummary orderSummary = (OrderSummary) obj;
            if (orderSummary != null) {
                OrderSummaryBody body = orderSummary.getBody();
                Boolean bool = null;
                if ((body != null ? body.getStatus() : null) != null) {
                    OrderSummaryBody body2 = orderSummary.getBody();
                    if (!(body2 == null || (status = body2.getStatus()) == null)) {
                        bool = Boolean.valueOf(p.a(status, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, true));
                    }
                    if (bool == null) {
                        k.a();
                    }
                    if (bool.booleanValue()) {
                        this.f30508a.a();
                        g.handleErrorCode$default(this.f30508a, (Integer) null, orderSummary, (NetworkCustomError) null, 5, (Object) null);
                        return;
                    }
                }
                a aVar = this.f30508a;
                aVar.f30499b = orderSummary;
                a.a(aVar);
                this.f30508a.a();
                a.b(this.f30508a);
            }
        }
    }

    static final class c<T> implements z<net.one97.travelpass.e.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30509a;

        c(a aVar) {
            this.f30509a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num;
            net.one97.travelpass.e.a aVar = (net.one97.travelpass.e.a) obj;
            this.f30509a.a();
            a aVar2 = this.f30509a;
            NetworkCustomError networkCustomError = null;
            if (aVar != null) {
                num = Integer.valueOf(aVar.f30319a);
            } else {
                num = null;
            }
            IJRPaytmDataModel iJRPaytmDataModel = aVar != null ? aVar.f30320b : null;
            if (aVar != null) {
                networkCustomError = aVar.f30321c;
            }
            aVar2.handleErrorCode(num, iJRPaytmDataModel, networkCustomError);
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
        e();
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        this.f30500c = (i) f.a(layoutInflater, R.layout.fragment_travel_pass_order_summary, viewGroup, false);
        i iVar = this.f30500c;
        if (iVar == null) {
            k.a();
        }
        return iVar.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        LiveData liveData;
        LiveData liveData2;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RoboTextView roboTextView;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f30501d = (net.one97.travelpass.ordersummary.h.a) am.a((Fragment) this).a(net.one97.travelpass.ordersummary.h.a.class);
        e();
        i iVar = this.f30500c;
        if (!(iVar == null || (roboTextView = iVar.f30248d) == null)) {
            roboTextView.setText("Order Id - " + this.f30504g);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
        i iVar2 = this.f30500c;
        if (!(iVar2 == null || (recyclerView2 = iVar2.f30250f) == null)) {
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        if (this.f30503f != null) {
            this.f30498a = new net.one97.travelpass.ordersummary.a.b(getActivity(), this.f30503f, this);
            i iVar3 = this.f30500c;
            if (!(iVar3 == null || (recyclerView = iVar3.f30250f) == null)) {
                net.one97.travelpass.ordersummary.a.b bVar = this.f30498a;
                if (bVar == null) {
                    k.a("recyclerAdapter");
                }
                recyclerView.setAdapter(bVar);
            }
        }
        net.one97.travelpass.ordersummary.h.a aVar = this.f30501d;
        if (!(aVar == null || (liveData2 = aVar.f30525a) == null)) {
            liveData2.observe(this, new b(this));
        }
        net.one97.travelpass.ordersummary.h.a aVar2 = this.f30501d;
        if (!(aVar2 == null || (liveData = aVar2.f30526b) == null)) {
            liveData.observe(this, new c(this));
        }
        c();
    }

    /* renamed from: net.one97.travelpass.ordersummary.c.a$a  reason: collision with other inner class name */
    static final class C0516a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30507a;

        C0516a(a aVar) {
            this.f30507a = aVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f30507a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    private final void a(int i2) {
        FragmentActivity activity = getActivity();
        Window window = activity != null ? activity.getWindow() : null;
        if (window != null) {
            window.clearFlags(67108864);
        }
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
        }
        if (getContext() != null && Build.VERSION.SDK_INT >= 21 && window != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            window.setStatusBarColor(androidx.core.content.b.c(context, i2));
        }
    }

    private final void b() {
        OrderSummary orderSummary = this.f30499b;
        boolean z = false;
        String str = "";
        if (orderSummary != null) {
            OrderSummaryBody body = orderSummary.getBody();
            if ((body != null ? body.getBody() : null) != null) {
                OrderSummaryBody body2 = orderSummary.getBody();
                List<OrderSummaryBodyItem> body3 = body2 != null ? body2.getBody() : null;
                if (body3 == null) {
                    k.a();
                }
                Iterator<OrderSummaryBodyItem> it2 = body3.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    OrderSummaryBodyItem next = it2.next();
                    k.a((Object) next, "summaryCard");
                    if (p.a(next.getType(), "statusCard", true)) {
                        CharSequence statusImage = next.getStatusImage();
                        if (!(statusImage == null || statusImage.length() == 0)) {
                            str = next.getStatusImage();
                        }
                    }
                }
            }
        }
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (!z && getContext() != null) {
            b.a aVar = com.paytm.utility.b.b.f43744a;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            b.a.C0750a a2 = b.a.a(context);
            a2.f43753a = str;
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            Drawable a3 = androidx.core.content.b.a(context2, R.drawable.travelpass_placeholder_default);
            if (a3 == null) {
                k.a();
            }
            k.a((Object) a3, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
            b.a.C0750a b2 = a2.b(a3);
            Context context3 = getContext();
            if (context3 == null) {
                k.a();
            }
            Drawable a4 = androidx.core.content.b.a(context3, R.drawable.travelpass_placeholder_default);
            if (a4 == null) {
                k.a();
            }
            k.a((Object) a4, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
            b.a.C0750a a5 = b2.a((Object) a4);
            i iVar = this.f30500c;
            b.a.C0750a.a(a5, iVar != null ? iVar.f30251g : null, (com.paytm.utility.b.b.b) null, 2);
        }
    }

    private void c() {
        if (getContext() == null || com.paytm.utility.b.c(getContext())) {
            d();
            return;
        }
        j.a aVar = j.f30335a;
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        j.a.a(context);
    }

    private void d() {
        CharSequence charSequence = this.f30504g;
        if (!(charSequence == null || charSequence.length() == 0)) {
            f();
            net.one97.travelpass.ordersummary.h.a aVar = this.f30501d;
            if (aVar != null) {
                Context context = getContext();
                String str = this.f30504g;
                if (str == null) {
                    k.a();
                }
                aVar.a(context, str);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void e() {
        /*
            r4 = this;
            android.os.Bundle r0 = r4.getArguments()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.String r2 = "order_id"
            java.lang.String r2 = r0.getString(r2)
            goto L_0x000f
        L_0x000e:
            r2 = r1
        L_0x000f:
            r4.f30504g = r2
            if (r0 == 0) goto L_0x001f
            r2 = 0
            java.lang.String r3 = "is_cancel"
            boolean r2 = r0.getBoolean(r3, r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x0020
        L_0x001f:
            r2 = r1
        L_0x0020:
            r4.f30505h = r2
            if (r0 == 0) goto L_0x002d
            java.lang.String r1 = "tracking_info"
            android.os.Parcelable r0 = r0.getParcelable(r1)
            r1 = r0
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r1 = (net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo) r1
        L_0x002d:
            r4.f30506i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ordersummary.c.a.e():void");
    }

    private void f() {
        ProgressBar progressBar;
        i iVar = this.f30500c;
        if (iVar != null && (progressBar = iVar.f30249e) != null) {
            progressBar.setVisibility(0);
        }
    }

    public final void a() {
        ProgressBar progressBar;
        i iVar = this.f30500c;
        if (iVar != null && (progressBar = iVar.f30249e) != null) {
            progressBar.setVisibility(8);
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [net.one97.travelpass.ordersummary.b.a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.travelpass.ordersummary.g.a r8, java.lang.Integer r9) {
        /*
            r7 = this;
            net.one97.travelpass.ui.a r0 = net.one97.travelpass.ui.a.f30575a
            int r0 = net.one97.travelpass.ui.a.e()
            r1 = 0
            if (r9 != 0) goto L_0x000a
            goto L_0x0035
        L_0x000a:
            int r2 = r9.intValue()
            if (r2 != r0) goto L_0x0035
            if (r8 == 0) goto L_0x0034
            com.paytm.network.model.IJRPaytmDataModel r9 = r8.a()
            if (r9 == 0) goto L_0x0034
            com.paytm.network.model.IJRPaytmDataModel r8 = r8.a()
            boolean r9 = r8 instanceof net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem
            if (r9 != 0) goto L_0x0021
            r8 = r1
        L_0x0021:
            net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem r8 = (net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem) r8
            net.one97.travelpass.e.f$a r9 = net.one97.travelpass.e.f.f30332a
            androidx.fragment.app.FragmentActivity r9 = r7.getActivity()
            android.content.Context r9 = (android.content.Context) r9
            if (r8 == 0) goto L_0x0031
            java.lang.String r1 = r8.getCategoryDeeplink()
        L_0x0031:
            net.one97.travelpass.e.f.a.a(r9, r1)
        L_0x0034:
            return
        L_0x0035:
            net.one97.travelpass.ui.a r0 = net.one97.travelpass.ui.a.f30575a
            int r0 = net.one97.travelpass.ui.a.f()
            if (r9 != 0) goto L_0x003e
            goto L_0x0069
        L_0x003e:
            int r2 = r9.intValue()
            if (r2 != r0) goto L_0x0069
            if (r8 == 0) goto L_0x0068
            com.paytm.network.model.IJRPaytmDataModel r9 = r8.a()
            if (r9 == 0) goto L_0x0068
            com.paytm.network.model.IJRPaytmDataModel r8 = r8.a()
            boolean r9 = r8 instanceof net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem
            if (r9 != 0) goto L_0x0055
            r8 = r1
        L_0x0055:
            net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem r8 = (net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem) r8
            net.one97.travelpass.e.f$a r9 = net.one97.travelpass.e.f.f30332a
            androidx.fragment.app.FragmentActivity r9 = r7.getActivity()
            android.content.Context r9 = (android.content.Context) r9
            if (r8 == 0) goto L_0x0065
            java.lang.String r1 = r8.getMypassDeeplink()
        L_0x0065:
            net.one97.travelpass.e.f.a.a(r9, r1)
        L_0x0068:
            return
        L_0x0069:
            if (r8 == 0) goto L_0x0070
            net.one97.travelpass.ordersummary.b.a r0 = r8.b()
            goto L_0x0071
        L_0x0070:
            r0 = r1
        L_0x0071:
            net.one97.travelpass.ordersummary.b.a r2 = net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_TERMS_AND_CONDITIONS
            r3 = 0
            r4 = 1
            if (r0 != r2) goto L_0x00d7
            if (r8 == 0) goto L_0x007e
            com.paytm.network.model.IJRPaytmDataModel r8 = r8.a()
            goto L_0x007f
        L_0x007e:
            r8 = r1
        L_0x007f:
            boolean r9 = r8 instanceof net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem
            if (r9 != 0) goto L_0x0084
            r8 = r1
        L_0x0084:
            net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem r8 = (net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem) r8
            if (r8 == 0) goto L_0x008d
            java.util.List r8 = r8.getTermsConditions()
            goto L_0x008e
        L_0x008d:
            r8 = r1
        L_0x008e:
            boolean r9 = r8 instanceof java.util.ArrayList
            if (r9 != 0) goto L_0x0093
            r8 = r1
        L_0x0093:
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            r9 = r8
            java.util.Collection r9 = (java.util.Collection) r9
            if (r9 == 0) goto L_0x00a0
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x00a1
        L_0x00a0:
            r3 = 1
        L_0x00a1:
            if (r3 != 0) goto L_0x00d6
            net.one97.travelpass.ui.fragment.c r9 = new net.one97.travelpass.ui.fragment.c
            r9.<init>()
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.io.Serializable r8 = (java.io.Serializable) r8
            java.lang.String r1 = "dataList"
            r0.putSerializable(r1, r8)
            r9.setArguments(r0)
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 == 0) goto L_0x00d6
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 != 0) goto L_0x00c6
            kotlin.g.b.k.a()
        L_0x00c6:
            java.lang.String r0 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            androidx.fragment.app.j r8 = r8.getSupportFragmentManager()
            java.lang.String r0 = r9.getTag()
            r9.show((androidx.fragment.app.j) r8, (java.lang.String) r0)
        L_0x00d6:
            return
        L_0x00d7:
            if (r8 == 0) goto L_0x00de
            net.one97.travelpass.ordersummary.b.a r0 = r8.b()
            goto L_0x00df
        L_0x00de:
            r0 = r1
        L_0x00df:
            net.one97.travelpass.ordersummary.b.a r2 = net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_WALLET_REFUND_ITEM
            if (r0 != r2) goto L_0x00f5
            if (r8 == 0) goto L_0x00f4
            com.paytm.network.model.IJRPaytmDataModel r8 = r8.a()
            if (r8 == 0) goto L_0x00ec
            goto L_0x00f4
        L_0x00ec:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type net.one97.travelpass.ordersummary.model.OrderSummaryFiled"
            r8.<init>(r9)
            throw r8
        L_0x00f4:
            return
        L_0x00f5:
            if (r8 == 0) goto L_0x00fc
            net.one97.travelpass.ordersummary.b.a r0 = r8.b()
            goto L_0x00fd
        L_0x00fc:
            r0 = r1
        L_0x00fd:
            net.one97.travelpass.ordersummary.b.a r2 = net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_CONTACT_US
            if (r0 != r2) goto L_0x0253
            if (r8 == 0) goto L_0x0108
            com.paytm.network.model.IJRPaytmDataModel r9 = r8.a()
            goto L_0x0109
        L_0x0108:
            r9 = r1
        L_0x0109:
            boolean r0 = r9 instanceof net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem
            if (r0 != 0) goto L_0x010e
            r9 = r1
        L_0x010e:
            net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem r9 = (net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem) r9
            if (r9 == 0) goto L_0x0117
            java.util.List r9 = r9.getTPOrderSummaryCSTData()
            goto L_0x0118
        L_0x0117:
            r9 = r1
        L_0x0118:
            boolean r0 = r9 instanceof java.util.ArrayList
            if (r0 != 0) goto L_0x011d
            r9 = r1
        L_0x011d:
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            r7.j = r9
            if (r8 == 0) goto L_0x0252
            com.paytm.network.model.IJRPaytmDataModel r9 = r8.a()
            boolean r0 = r9 instanceof net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem
            if (r0 != 0) goto L_0x012c
            r9 = r1
        L_0x012c:
            net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem r9 = (net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem) r9
            if (r9 == 0) goto L_0x0252
            java.util.List r0 = r9.getTPOrderSummaryCSTData()
            if (r0 == 0) goto L_0x0252
            java.util.List r9 = r9.getTPOrderSummaryCSTData()
            java.lang.String r0 = "contactUsData?.tpOrderSummaryCSTData"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            r9 = r9 ^ r4
            if (r9 == 0) goto L_0x0252
            net.one97.travelpass.ordersummary.d.a r9 = new net.one97.travelpass.ordersummary.d.a
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x0153
            kotlin.g.b.k.a()
        L_0x0153:
            com.paytm.network.model.IJRPaytmDataModel r8 = r8.a()
            boolean r2 = r8 instanceof net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem
            if (r2 != 0) goto L_0x015c
            r8 = r1
        L_0x015c:
            net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem r8 = (net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem) r8
            java.lang.String r1 = r7.f30504g
            r9.<init>(r0, r8, r1)
            r7.k = r9
            net.one97.travelpass.ordersummary.d.a r8 = r7.k
            if (r8 == 0) goto L_0x0252
            java.util.ArrayList<java.lang.String> r9 = r8.f30511b
            java.util.Collection r9 = (java.util.Collection) r9
            if (r9 == 0) goto L_0x0178
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x0176
            goto L_0x0178
        L_0x0176:
            r9 = 0
            goto L_0x0179
        L_0x0178:
            r9 = 1
        L_0x0179:
            if (r9 != 0) goto L_0x0221
            java.util.ArrayList<java.lang.String> r9 = r8.f30511b
            if (r9 != 0) goto L_0x0182
            kotlin.g.b.k.a()
        L_0x0182:
            int r9 = r9.size()
            if (r9 <= r4) goto L_0x0221
            android.app.AlertDialog$Builder r9 = new android.app.AlertDialog$Builder
            android.content.Context r0 = r8.f30510a
            r9.<init>(r0)
            android.widget.TextView r0 = new android.widget.TextView
            android.content.Context r1 = r8.f30510a
            r0.<init>(r1)
            android.content.Context r1 = r8.f30510a
            if (r1 != 0) goto L_0x019d
            kotlin.g.b.k.a()
        L_0x019d:
            int r2 = net.one97.travelpass.R.string.contact_us_header
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            r1 = 10
            r0.setPadding(r1, r1, r1, r1)
            r1 = 17
            r0.setGravity(r1)
            r1 = 1101004800(0x41a00000, float:20.0)
            r0.setTextSize(r1)
            android.content.Context r1 = r8.f30510a
            if (r1 != 0) goto L_0x01be
            kotlin.g.b.k.a()
        L_0x01be:
            int r2 = net.one97.travelpass.R.color.color_33b5e5
            int r1 = androidx.core.content.b.c(r1, r2)
            r0.setTextColor(r1)
            android.widget.ListView r1 = new android.widget.ListView
            android.content.Context r2 = r8.f30510a
            r1.<init>(r2)
            r1.setChoiceMode(r4)
            net.one97.travelpass.ordersummary.a.a r2 = new net.one97.travelpass.ordersummary.a.a
            android.content.Context r5 = r8.f30510a
            if (r5 != 0) goto L_0x01da
            kotlin.g.b.k.a()
        L_0x01da:
            java.util.ArrayList<java.lang.String> r6 = r8.f30511b
            if (r6 != 0) goto L_0x01e1
            kotlin.g.b.k.a()
        L_0x01e1:
            r2.<init>(r5, r6)
            android.widget.ListAdapter r2 = (android.widget.ListAdapter) r2
            r1.setAdapter(r2)
            net.one97.travelpass.ordersummary.d.a$a r2 = new net.one97.travelpass.ordersummary.d.a$a
            r2.<init>(r8)
            android.widget.AdapterView$OnItemClickListener r2 = (android.widget.AdapterView.OnItemClickListener) r2
            r1.setOnItemClickListener(r2)
            android.view.View r0 = (android.view.View) r0
            r9.setCustomTitle(r0)
            r9.setInverseBackgroundForced(r4)
            int r0 = net.one97.travelpass.R.string.ok
            net.one97.travelpass.ordersummary.d.a$b r2 = new net.one97.travelpass.ordersummary.d.a$b
            r2.<init>(r8)
            android.content.DialogInterface$OnClickListener r2 = (android.content.DialogInterface.OnClickListener) r2
            r9.setPositiveButton(r0, r2)
            android.view.View r1 = (android.view.View) r1
            r9.setView(r1)
            android.app.AlertDialog r9 = r9.create()
            android.app.Dialog r9 = (android.app.Dialog) r9
            r8.f30513d = r9
            r8.f30512c = r3
            android.app.Dialog r8 = r8.f30513d
            if (r8 != 0) goto L_0x021d
            kotlin.g.b.k.a()
        L_0x021d:
            r8.show()
            return
        L_0x0221:
            java.util.ArrayList<java.lang.String> r9 = r8.f30511b
            if (r9 != 0) goto L_0x0228
            kotlin.g.b.k.a()
        L_0x0228:
            int r9 = r9.size()
            if (r9 != r4) goto L_0x0232
            r8.a((int) r4)
            return
        L_0x0232:
            java.util.ArrayList<net.one97.paytm.common.TPOrderSummaryContactUs> r9 = r8.f30514e
            java.util.Collection r9 = (java.util.Collection) r9
            if (r9 == 0) goto L_0x0240
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x023f
            goto L_0x0240
        L_0x023f:
            r4 = 0
        L_0x0240:
            if (r4 != 0) goto L_0x0252
            java.util.ArrayList<net.one97.paytm.common.TPOrderSummaryContactUs> r9 = r8.f30514e
            if (r9 != 0) goto L_0x0249
            kotlin.g.b.k.a()
        L_0x0249:
            int r9 = r9.size()
            if (r9 <= 0) goto L_0x0252
            r8.a((int) r3)
        L_0x0252:
            return
        L_0x0253:
            if (r8 == 0) goto L_0x0259
            net.one97.travelpass.ordersummary.b.a r1 = r8.b()
        L_0x0259:
            net.one97.travelpass.ordersummary.b.a r8 = net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_HEADER
            if (r1 != r8) goto L_0x0277
            net.one97.travelpass.ui.a r8 = net.one97.travelpass.ui.a.f30575a
            int r8 = net.one97.travelpass.ui.a.g()
            if (r9 != 0) goto L_0x0266
            return
        L_0x0266:
            int r9 = r9.intValue()
            if (r9 != r8) goto L_0x0277
            net.one97.travelpass.e.f$a r8 = net.one97.travelpass.e.f.f30332a
            android.content.Context r8 = r7.getContext()
            java.lang.String r9 = "paytmmp://travelpass?scrn=passDet"
            net.one97.travelpass.e.f.a.a(r8, r9)
        L_0x0277:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ordersummary.c.a.a(net.one97.travelpass.ordersummary.g.a, java.lang.Integer):void");
    }

    public final void onDestroy() {
        super.onDestroy();
        net.one97.travelpass.ordersummary.d.a aVar = this.k;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 3) {
            c();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
        r5 = r0.getBody();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0024, code lost:
        r5 = r0.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.travelpass.ordersummary.c.a r8) {
        /*
            net.one97.travelpass.ordersummary.model.OrderSummary r0 = r8.f30499b
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            net.one97.travelpass.ordersummary.g.a r2 = new net.one97.travelpass.ordersummary.g.a
            r2.<init>()
            net.one97.travelpass.ordersummary.b.a r3 = net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_HEADER
            r2.a((net.one97.travelpass.ordersummary.b.a) r3)
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0022
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r5 = r0.getBody()
            if (r5 == 0) goto L_0x0022
            int r5 = r5.getPaytmStatusCode()
            r6 = 4
            if (r5 == r6) goto L_0x0031
        L_0x0022:
            if (r0 == 0) goto L_0x0033
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r5 = r0.getBody()
            if (r5 == 0) goto L_0x0033
            int r5 = r5.getPaytmStatusCode()
            r6 = 6
            if (r5 != r6) goto L_0x0033
        L_0x0031:
            r5 = 1
            goto L_0x0034
        L_0x0033:
            r5 = 0
        L_0x0034:
            r2.a((boolean) r5)
            java.lang.String r5 = "statusCard"
            com.paytm.network.model.IJRPaytmDataModel r5 = net.one97.travelpass.ordersummary.d.b.a(r5, r0)
            r2.a((com.paytm.network.model.IJRPaytmDataModel) r5)
            com.paytm.network.model.IJRPaytmDataModel r5 = r2.a()
            if (r5 == 0) goto L_0x0049
            r1.add(r2)
        L_0x0049:
            net.one97.travelpass.ordersummary.g.a r2 = new net.one97.travelpass.ordersummary.g.a
            r2.<init>()
            net.one97.travelpass.ordersummary.b.a r5 = net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_ACTION
            r2.a((net.one97.travelpass.ordersummary.b.a) r5)
            java.lang.String r5 = "actionCard"
            com.paytm.network.model.IJRPaytmDataModel r5 = net.one97.travelpass.ordersummary.d.b.a(r5, r0)
            r2.a((com.paytm.network.model.IJRPaytmDataModel) r5)
            com.paytm.network.model.IJRPaytmDataModel r5 = r2.a()
            if (r5 == 0) goto L_0x0065
            r1.add(r2)
        L_0x0065:
            net.one97.travelpass.ordersummary.g.a r2 = new net.one97.travelpass.ordersummary.g.a
            r2.<init>()
            net.one97.travelpass.ordersummary.b.a r5 = net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_BANNER
            r2.a((net.one97.travelpass.ordersummary.b.a) r5)
            java.lang.String r5 = "paytmBanner"
            com.paytm.network.model.IJRPaytmDataModel r5 = net.one97.travelpass.ordersummary.d.b.a(r5, r0)
            r2.a((com.paytm.network.model.IJRPaytmDataModel) r5)
            com.paytm.network.model.IJRPaytmDataModel r5 = r2.a()
            if (r5 == 0) goto L_0x0081
            r1.add(r2)
        L_0x0081:
            net.one97.travelpass.ordersummary.g.a r2 = new net.one97.travelpass.ordersummary.g.a
            r2.<init>()
            net.one97.travelpass.ordersummary.b.a r5 = net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_DETAIL
            r2.a((net.one97.travelpass.ordersummary.b.a) r5)
            java.lang.String r5 = "travelPassDetails"
            com.paytm.network.model.IJRPaytmDataModel r5 = net.one97.travelpass.ordersummary.d.b.a(r5, r0)
            boolean r6 = r5 instanceof net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem
            if (r6 != 0) goto L_0x0096
            r5 = 0
        L_0x0096:
            net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem r5 = (net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem) r5
            r6 = r5
            com.paytm.network.model.IJRPaytmDataModel r6 = (com.paytm.network.model.IJRPaytmDataModel) r6
            r2.a((com.paytm.network.model.IJRPaytmDataModel) r6)
            java.util.ArrayList r5 = net.one97.travelpass.ordersummary.d.b.a((net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem) r5)
            r2.a((java.util.ArrayList<net.one97.travelpass.ordersummary.g.a>) r5)
            com.paytm.network.model.IJRPaytmDataModel r5 = r2.a()
            if (r5 == 0) goto L_0x00c2
            java.util.ArrayList r5 = r2.c()
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x00bc
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x00ba
            goto L_0x00bc
        L_0x00ba:
            r5 = 0
            goto L_0x00bd
        L_0x00bc:
            r5 = 1
        L_0x00bd:
            if (r5 != 0) goto L_0x00c2
            r1.add(r2)
        L_0x00c2:
            net.one97.travelpass.ordersummary.g.a r2 = new net.one97.travelpass.ordersummary.g.a
            r2.<init>()
            net.one97.travelpass.ordersummary.b.a r5 = net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_CASHBACK
            r2.a((net.one97.travelpass.ordersummary.b.a) r5)
            java.lang.String r5 = "cashback"
            com.paytm.network.model.IJRPaytmDataModel r5 = net.one97.travelpass.ordersummary.d.b.a(r5, r0)
            r2.a((com.paytm.network.model.IJRPaytmDataModel) r5)
            com.paytm.network.model.IJRPaytmDataModel r5 = r2.a()
            if (r5 == 0) goto L_0x00de
            r1.add(r2)
        L_0x00de:
            net.one97.travelpass.ordersummary.g.a r2 = new net.one97.travelpass.ordersummary.g.a
            r2.<init>()
            net.one97.travelpass.ordersummary.b.a r5 = net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_PAYMENT_DETAIL
            r2.a((net.one97.travelpass.ordersummary.b.a) r5)
            java.lang.String r5 = "paymentDetails"
            com.paytm.network.model.IJRPaytmDataModel r5 = net.one97.travelpass.ordersummary.d.b.a(r5, r0)
            r2.a((com.paytm.network.model.IJRPaytmDataModel) r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            if (r0 == 0) goto L_0x0116
            java.util.ArrayList r6 = net.one97.travelpass.ordersummary.d.b.a((net.one97.travelpass.ordersummary.model.OrderSummary) r0)
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x0107
            r5.addAll(r6)
        L_0x0107:
            java.util.ArrayList r6 = net.one97.travelpass.ordersummary.d.b.b(r0)
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x0116
            r5.addAll(r6)
        L_0x0116:
            r2.a((java.util.ArrayList<net.one97.travelpass.ordersummary.g.a>) r5)
            java.util.ArrayList r5 = r2.c()
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x012a
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0128
            goto L_0x012a
        L_0x0128:
            r5 = 0
            goto L_0x012b
        L_0x012a:
            r5 = 1
        L_0x012b:
            if (r5 != 0) goto L_0x0130
            r1.add(r2)
        L_0x0130:
            net.one97.travelpass.ordersummary.g.a r2 = new net.one97.travelpass.ordersummary.g.a
            r2.<init>()
            net.one97.travelpass.ordersummary.b.a r5 = net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_REFUND_DETAIL
            r2.a((net.one97.travelpass.ordersummary.b.a) r5)
            java.lang.String r5 = "refundCard1"
            com.paytm.network.model.IJRPaytmDataModel r5 = net.one97.travelpass.ordersummary.d.b.a(r5, r0)
            r2.a((com.paytm.network.model.IJRPaytmDataModel) r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            if (r0 == 0) goto L_0x0177
            java.util.ArrayList r6 = net.one97.travelpass.ordersummary.d.b.c(r0)
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x0159
            r5.addAll(r6)
        L_0x0159:
            java.util.ArrayList r6 = net.one97.travelpass.ordersummary.d.b.d(r0)
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x0168
            r5.addAll(r6)
        L_0x0168:
            java.util.ArrayList r7 = net.one97.travelpass.ordersummary.d.b.e(r0)
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0177
            java.util.Collection r7 = (java.util.Collection) r7
            r5.addAll(r7)
        L_0x0177:
            r2.a((java.util.ArrayList<net.one97.travelpass.ordersummary.g.a>) r5)
            com.paytm.network.model.IJRPaytmDataModel r5 = r2.a()
            if (r5 == 0) goto L_0x0194
            java.util.ArrayList r5 = r2.c()
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x018e
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x018f
        L_0x018e:
            r3 = 1
        L_0x018f:
            if (r3 != 0) goto L_0x0194
            r1.add(r2)
        L_0x0194:
            net.one97.travelpass.ordersummary.g.a r2 = new net.one97.travelpass.ordersummary.g.a
            r2.<init>()
            net.one97.travelpass.ordersummary.b.a r3 = net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_TERMS_AND_CONDITIONS
            r2.a((net.one97.travelpass.ordersummary.b.a) r3)
            java.lang.String r3 = "tnc"
            com.paytm.network.model.IJRPaytmDataModel r3 = net.one97.travelpass.ordersummary.d.b.a(r3, r0)
            r2.a((com.paytm.network.model.IJRPaytmDataModel) r3)
            com.paytm.network.model.IJRPaytmDataModel r3 = r2.a()
            if (r3 == 0) goto L_0x01b0
            r1.add(r2)
        L_0x01b0:
            net.one97.travelpass.ordersummary.g.a r2 = new net.one97.travelpass.ordersummary.g.a
            r2.<init>()
            net.one97.travelpass.ordersummary.b.a r3 = net.one97.travelpass.ordersummary.b.a.TP_ORDER_SUMMARY_CONTACT_US
            r2.a((net.one97.travelpass.ordersummary.b.a) r3)
            java.lang.String r3 = "footer"
            com.paytm.network.model.IJRPaytmDataModel r0 = net.one97.travelpass.ordersummary.d.b.a(r3, r0)
            r2.a((com.paytm.network.model.IJRPaytmDataModel) r0)
            com.paytm.network.model.IJRPaytmDataModel r0 = r2.a()
            if (r0 == 0) goto L_0x01cc
            r1.add(r2)
        L_0x01cc:
            r8.f30503f = r1
            java.util.ArrayList<net.one97.travelpass.ordersummary.g.a> r0 = r8.f30503f
            r8.f30503f = r0
            java.util.ArrayList<net.one97.travelpass.ordersummary.g.a> r0 = r8.f30503f
            net.one97.travelpass.ordersummary.a.b r1 = r8.f30498a
            java.lang.String r2 = "recyclerAdapter"
            if (r1 != 0) goto L_0x01dd
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01dd:
            if (r1 == 0) goto L_0x0206
            if (r0 == 0) goto L_0x0206
            net.one97.travelpass.b.i r0 = r8.f30500c
            if (r0 == 0) goto L_0x01ec
            androidx.recyclerview.widget.RecyclerView r0 = r0.f30250f
            if (r0 == 0) goto L_0x01ec
            r0.removeAllViewsInLayout()
        L_0x01ec:
            net.one97.travelpass.ordersummary.a.b r0 = r8.f30498a
            if (r0 != 0) goto L_0x01f3
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01f3:
            java.util.ArrayList<net.one97.travelpass.ordersummary.g.a> r1 = r8.f30503f
            java.lang.String r3 = "<set-?>"
            kotlin.g.b.k.c(r1, r3)
            r0.f30491a = r1
            net.one97.travelpass.ordersummary.a.b r8 = r8.f30498a
            if (r8 != 0) goto L_0x0203
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0203:
            r8.notifyDataSetChanged()
        L_0x0206:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ordersummary.c.a.a(net.one97.travelpass.ordersummary.c.a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(net.one97.travelpass.ordersummary.c.a r5) {
        /*
            net.one97.travelpass.ordersummary.model.OrderSummary r0 = r5.f30499b
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0015
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r0 = r0.getBody()
            if (r0 == 0) goto L_0x0015
            int r0 = r0.getPaytmStatusCode()
            r3 = 7
            if (r0 != r3) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 == 0) goto L_0x002e
            net.one97.travelpass.b.i r0 = r5.f30500c
            if (r0 == 0) goto L_0x0025
            com.google.android.material.appbar.CollapsingToolbarLayout r0 = r0.f30247c
            if (r0 == 0) goto L_0x0025
            int r1 = net.one97.travelpass.R.color.success_toolbar_color
            r0.setContentScrimResource(r1)
        L_0x0025:
            r5.b()
            int r0 = net.one97.travelpass.R.color.success_statusbar_color
            r5.a((int) r0)
            goto L_0x008a
        L_0x002e:
            net.one97.travelpass.ordersummary.model.OrderSummary r0 = r5.f30499b
            if (r0 == 0) goto L_0x003e
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r3 = r0.getBody()
            if (r3 == 0) goto L_0x003e
            int r3 = r3.getPaytmStatusCode()
            if (r3 == r2) goto L_0x005c
        L_0x003e:
            if (r0 == 0) goto L_0x004d
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r3 = r0.getBody()
            if (r3 == 0) goto L_0x004d
            int r3 = r3.getPaytmStatusCode()
            r4 = 2
            if (r3 == r4) goto L_0x005c
        L_0x004d:
            if (r0 == 0) goto L_0x005d
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r0 = r0.getBody()
            if (r0 == 0) goto L_0x005d
            int r0 = r0.getPaytmStatusCode()
            r3 = 5
            if (r0 != r3) goto L_0x005d
        L_0x005c:
            r1 = 1
        L_0x005d:
            if (r1 == 0) goto L_0x0075
            net.one97.travelpass.b.i r0 = r5.f30500c
            if (r0 == 0) goto L_0x006c
            com.google.android.material.appbar.CollapsingToolbarLayout r0 = r0.f30247c
            if (r0 == 0) goto L_0x006c
            int r1 = net.one97.travelpass.R.color.pending_toolbar_color
            r0.setContentScrimResource(r1)
        L_0x006c:
            r5.b()
            int r0 = net.one97.travelpass.R.color.pending_statusbar_color
            r5.a((int) r0)
            goto L_0x008a
        L_0x0075:
            net.one97.travelpass.b.i r0 = r5.f30500c
            if (r0 == 0) goto L_0x0082
            com.google.android.material.appbar.CollapsingToolbarLayout r0 = r0.f30247c
            if (r0 == 0) goto L_0x0082
            int r1 = net.one97.travelpass.R.color.failed_toolbar_color
            r0.setContentScrimResource(r1)
        L_0x0082:
            r5.b()
            int r0 = net.one97.travelpass.R.color.failed_statusbar_color
            r5.a((int) r0)
        L_0x008a:
            net.one97.travelpass.b.i r0 = r5.f30500c
            if (r0 == 0) goto L_0x009c
            android.widget.ImageView r0 = r0.f30246b
            if (r0 == 0) goto L_0x009c
            net.one97.travelpass.ordersummary.c.a$a r1 = new net.one97.travelpass.ordersummary.c.a$a
            r1.<init>(r5)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ordersummary.c.a.b(net.one97.travelpass.ordersummary.c.a):void");
    }
}

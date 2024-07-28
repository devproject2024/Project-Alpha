package net.one97.travelpass.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.lifecycle.z;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.b.y;
import net.one97.travelpass.e.b;
import net.one97.travelpass.e.f;
import net.one97.travelpass.e.j;
import net.one97.travelpass.model.BookingDetailsResponse;
import net.one97.travelpass.model.MyPassesResponse;
import net.one97.travelpass.model.PassData;
import net.one97.travelpass.ui.c.j;

public final class a extends g implements com.one97.travelpass.a.c {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.travelpass.a.c f30673a;

    /* renamed from: b  reason: collision with root package name */
    MyPassesResponse f30674b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.travelpass.b.a f30675c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.travelpass.g.a f30676d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<j> f30677e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private net.one97.travelpass.e.c f30678f = new net.one97.travelpass.e.c();

    /* renamed from: g  reason: collision with root package name */
    private Integer f30679g = 0;

    /* renamed from: h  reason: collision with root package name */
    private j f30680h;

    /* renamed from: i  reason: collision with root package name */
    private Button f30681i;
    private long j = -1;
    private boolean k;
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

    static final class c<T> implements z<MyPassesResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30684a;

        c(a aVar) {
            this.f30684a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
            if (r0.booleanValue() == false) goto L_0x0037;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ae, code lost:
            if (r1.size() == 0) goto L_0x00b0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r9) {
            /*
                r8 = this;
                net.one97.travelpass.model.MyPassesResponse r9 = (net.one97.travelpass.model.MyPassesResponse) r9
                if (r9 == 0) goto L_0x00bc
                net.one97.travelpass.model.MyPasses r0 = r9.getBody()
                r1 = 0
                if (r0 == 0) goto L_0x0010
                java.lang.String r0 = r0.getStatus()
                goto L_0x0011
            L_0x0010:
                r0 = r1
            L_0x0011:
                if (r0 == 0) goto L_0x0037
                net.one97.travelpass.model.MyPasses r0 = r9.getBody()
                if (r0 == 0) goto L_0x002b
                java.lang.String r0 = r0.getStatus()
                if (r0 == 0) goto L_0x002b
                r2 = 1
                java.lang.String r3 = "failure"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                goto L_0x002c
            L_0x002b:
                r0 = r1
            L_0x002c:
                if (r0 != 0) goto L_0x0031
                kotlin.g.b.k.a()
            L_0x0031:
                boolean r0 = r0.booleanValue()
                if (r0 != 0) goto L_0x0074
            L_0x0037:
                net.one97.travelpass.model.MyPasses r0 = r9.getBody()
                if (r0 == 0) goto L_0x0042
                java.util.List r0 = r0.getVerticalPassesData()
                goto L_0x0043
            L_0x0042:
                r0 = r1
            L_0x0043:
                if (r0 == 0) goto L_0x0074
                net.one97.travelpass.model.MyPasses r0 = r9.getBody()
                if (r0 == 0) goto L_0x0050
                java.util.List r0 = r0.getVerticalPassesData()
                goto L_0x0051
            L_0x0050:
                r0 = r1
            L_0x0051:
                if (r0 != 0) goto L_0x0056
                kotlin.g.b.k.a()
            L_0x0056:
                int r0 = r0.size()
                if (r0 != 0) goto L_0x005d
                goto L_0x0074
            L_0x005d:
                net.one97.travelpass.ui.fragment.a r0 = r8.f30684a
                r0.f30674b = r9
                r0.a(0)
                net.one97.travelpass.ui.fragment.a r9 = r8.f30684a
                r9.a((java.util.List<java.lang.Integer>) null)
                net.one97.travelpass.ui.fragment.a r9 = r8.f30684a
                r9.e()
                net.one97.travelpass.ui.fragment.a r9 = r8.f30684a
                r9.c()
                goto L_0x00bc
            L_0x0074:
                net.one97.travelpass.ui.fragment.a r2 = r8.f30684a
                r3 = 0
                r4 = r9
                com.paytm.network.model.IJRPaytmDataModel r4 = (com.paytm.network.model.IJRPaytmDataModel) r4
                r5 = 0
                r6 = 5
                r7 = 0
                kotlin.o r0 = net.one97.travelpass.ui.fragment.g.processErrorState$default(r2, r3, r4, r5, r6, r7)
                java.lang.Object r2 = r0.getFirst()
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r0 = r0.getSecond()
                java.lang.String r0 = (java.lang.String) r0
                net.one97.travelpass.model.MyPasses r3 = r9.getBody()
                if (r3 == 0) goto L_0x0098
                java.util.List r3 = r3.getVerticalPassesData()
                goto L_0x0099
            L_0x0098:
                r3 = r1
            L_0x0099:
                if (r3 == 0) goto L_0x00b0
                net.one97.travelpass.model.MyPasses r9 = r9.getBody()
                if (r9 == 0) goto L_0x00a5
                java.util.List r1 = r9.getVerticalPassesData()
            L_0x00a5:
                if (r1 != 0) goto L_0x00aa
                kotlin.g.b.k.a()
            L_0x00aa:
                int r9 = r1.size()
                if (r9 != 0) goto L_0x00b2
            L_0x00b0:
                java.lang.String r0 = "No Passes Available"
            L_0x00b2:
                net.one97.travelpass.ui.fragment.a r9 = r8.f30684a
                kotlin.o r1 = new kotlin.o
                r1.<init>(r2, r0)
                r9.a((kotlin.o<java.lang.String, java.lang.String>) r1)
            L_0x00bc:
                net.one97.travelpass.ui.fragment.a r9 = r8.f30684a
                r9.b()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.a.c.onChanged(java.lang.Object):void");
        }
    }

    static final class d<T> implements z<net.one97.travelpass.e.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30685a;

        d(a aVar) {
            this.f30685a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num;
            net.one97.travelpass.e.a aVar = (net.one97.travelpass.e.a) obj;
            this.f30685a.b();
            a aVar2 = this.f30685a;
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
            this.f30685a.a(aVar2.processErrorState(num, iJRPaytmDataModel, networkCustomError));
        }
    }

    static final class e<T> implements z<BookingDetailsResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30686a;

        e(a aVar) {
            this.f30686a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
            r1 = r8.getBody();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r8) {
            /*
                r7 = this;
                net.one97.travelpass.model.BookingDetailsResponse r8 = (net.one97.travelpass.model.BookingDetailsResponse) r8
                r0 = 0
                if (r8 == 0) goto L_0x0010
                net.one97.travelpass.model.BookingDetailsResponse$BookingDetails r1 = r8.getBody()
                if (r1 == 0) goto L_0x0010
                java.lang.String r1 = r1.getStatus()
                goto L_0x0011
            L_0x0010:
                r1 = r0
            L_0x0011:
                if (r1 == 0) goto L_0x004a
                if (r8 == 0) goto L_0x002c
                net.one97.travelpass.model.BookingDetailsResponse$BookingDetails r1 = r8.getBody()
                if (r1 == 0) goto L_0x002c
                java.lang.String r1 = r1.getStatus()
                if (r1 == 0) goto L_0x002c
                r0 = 1
                java.lang.String r2 = "failure"
                boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r0)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            L_0x002c:
                if (r0 != 0) goto L_0x0031
                kotlin.g.b.k.a()
            L_0x0031:
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x004a
                net.one97.travelpass.ui.fragment.a r1 = r7.f30686a
                r2 = 0
                r3 = r8
                com.paytm.network.model.IJRPaytmDataModel r3 = (com.paytm.network.model.IJRPaytmDataModel) r3
                r4 = 0
                r5 = 5
                r6 = 0
                kotlin.o r8 = net.one97.travelpass.ui.fragment.g.processErrorState$default(r1, r2, r3, r4, r5, r6)
                net.one97.travelpass.ui.fragment.a r0 = r7.f30686a
                r0.a((kotlin.o<java.lang.String, java.lang.String>) r8)
                goto L_0x0081
            L_0x004a:
                net.one97.travelpass.ui.fragment.a r0 = r7.f30686a
                if (r8 == 0) goto L_0x0081
                net.one97.travelpass.ui.fragment.e r1 = new net.one97.travelpass.ui.fragment.e
                r1.<init>()
                android.os.Bundle r2 = new android.os.Bundle
                r2.<init>()
                java.io.Serializable r8 = (java.io.Serializable) r8
                java.lang.String r3 = "body"
                r2.putSerializable(r3, r8)
                r1.setArguments(r2)
                androidx.fragment.app.FragmentActivity r8 = r0.getActivity()
                if (r8 == 0) goto L_0x0081
                androidx.fragment.app.FragmentActivity r8 = r0.getActivity()
                if (r8 != 0) goto L_0x0071
                kotlin.g.b.k.a()
            L_0x0071:
                java.lang.String r0 = "activity!!"
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
                androidx.fragment.app.j r8 = r8.getSupportFragmentManager()
                java.lang.String r0 = r1.getTag()
                r1.show((androidx.fragment.app.j) r8, (java.lang.String) r0)
            L_0x0081:
                net.one97.travelpass.ui.fragment.a r8 = r7.f30686a
                r8.b()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.a.e.onChanged(java.lang.Object):void");
        }
    }

    static final class f<T> implements z<net.one97.travelpass.e.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30687a;

        f(a aVar) {
            this.f30687a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num;
            net.one97.travelpass.e.a aVar = (net.one97.travelpass.e.a) obj;
            this.f30687a.b();
            a aVar2 = this.f30687a;
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
        d();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        this.f30675c = (net.one97.travelpass.b.a) androidx.databinding.f.a(layoutInflater, R.layout.fragment_my_pass, viewGroup, false);
        net.one97.travelpass.b.a aVar = this.f30675c;
        if (aVar == null) {
            k.a();
        }
        return aVar.getRoot();
    }

    private final void d() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getSerializable("deeplinkParams") != null) {
            this.k = true;
            Serializable serializable = arguments.getSerializable("deeplinkParams");
            if (serializable != null) {
                HashMap hashMap = (HashMap) serializable;
                if (hashMap.containsKey("itemid")) {
                    Object obj = hashMap.get("itemid");
                    if (obj != null) {
                        String str = (String) obj;
                        this.j = (str != null ? Long.valueOf(Long.parseLong(str)) : null).longValue();
                        return;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.Any> /* = java.util.HashMap<kotlin.String, kotlin.Any> */");
        }
    }

    /* renamed from: net.one97.travelpass.ui.fragment.a$a  reason: collision with other inner class name */
    static final class C0522a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30682a;

        C0522a(a aVar) {
            this.f30682a = aVar;
        }

        public final void onClick(View view) {
            this.f30682a.a("");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r5v11, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0112, code lost:
        r9 = r9.getSupportFragmentManager();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onItemClickedItem(net.one97.travelpass.ui.c.j r8, java.lang.Integer r9, java.lang.Integer r10) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x02ff
            net.one97.travelpass.ui.b.b r0 = r8.c()
            net.one97.travelpass.ui.b.b r1 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_TAB_ITEM
            if (r0 == r1) goto L_0x02ff
            net.one97.travelpass.ui.b.b r0 = r8.c()
            net.one97.travelpass.ui.b.b r1 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_CAROUSEL_ITEM
            r2 = -1
            r3 = 0
            r4 = 1
            r5 = 0
            if (r0 != r1) goto L_0x008f
            if (r9 != 0) goto L_0x0019
            goto L_0x001f
        L_0x0019:
            int r0 = r9.intValue()
            if (r0 == r2) goto L_0x02ff
        L_0x001f:
            net.one97.travelpass.ui.a r0 = net.one97.travelpass.ui.a.f30575a
            int r0 = net.one97.travelpass.ui.a.c()
            if (r10 != 0) goto L_0x0028
            return
        L_0x0028:
            int r10 = r10.intValue()
            if (r10 != r0) goto L_0x02ff
            r7.f30680h = r8
            if (r9 != 0) goto L_0x0035
            kotlin.g.b.k.a()
        L_0x0035:
            int r8 = r9.intValue()
            r7.a((int) r8)
            net.one97.travelpass.e.c r8 = r7.f30678f
            if (r8 == 0) goto L_0x0088
            java.util.ArrayList<net.one97.travelpass.ui.c.j> r8 = r7.f30677e
            r9 = r8
            java.util.Collection r9 = (java.util.Collection) r9
            if (r9 == 0) goto L_0x004f
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r4 = 0
        L_0x004f:
            if (r4 != 0) goto L_0x0088
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r10 = r8
            java.util.List r10 = (java.util.List) r10
            int r10 = kotlin.a.k.a(r10)
            if (r10 < 0) goto L_0x0085
        L_0x005f:
            java.lang.Object r0 = r8.get(r3)
            net.one97.travelpass.ui.c.j r0 = (net.one97.travelpass.ui.c.j) r0
            net.one97.travelpass.ui.b.b r0 = r0.c()
            net.one97.travelpass.ui.b.b r1 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_CAROUSEL
            if (r0 == r1) goto L_0x0080
            net.one97.travelpass.ui.b.b r1 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_CAROUSEL_ITEM
            if (r0 == r1) goto L_0x0080
            net.one97.travelpass.ui.b.b r1 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_TABS
            if (r0 == r1) goto L_0x0080
            net.one97.travelpass.ui.b.b r1 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_TAB_ITEM
            if (r0 == r1) goto L_0x0080
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            r9.add(r0)
        L_0x0080:
            if (r3 == r10) goto L_0x0085
            int r3 = r3 + 1
            goto L_0x005f
        L_0x0085:
            r5 = r9
            java.util.List r5 = (java.util.List) r5
        L_0x0088:
            r7.a((java.util.List<java.lang.Integer>) r5)
            r7.c()
            return
        L_0x008f:
            net.one97.travelpass.ui.b.b r9 = r8.c()
            net.one97.travelpass.ui.b.b r0 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_TEAMS_CONDITIONS
            java.lang.String r1 = "activity!!"
            java.lang.String r6 = "dataList"
            if (r9 != r0) goto L_0x00f5
            if (r8 == 0) goto L_0x00f4
            com.paytm.network.model.IJRPaytmDataModel r9 = r8.b()
            if (r9 == 0) goto L_0x00f4
            com.paytm.network.model.IJRPaytmDataModel r8 = r8.b()
            boolean r9 = r8 instanceof net.one97.travelpass.model.TravelPassMetaData.TncData
            if (r9 != 0) goto L_0x00ac
            r8 = r5
        L_0x00ac:
            net.one97.travelpass.model.TravelPassMetaData$TncData r8 = (net.one97.travelpass.model.TravelPassMetaData.TncData) r8
            if (r8 == 0) goto L_0x00f4
            java.util.ArrayList r9 = r8.getTncContent()
            java.util.Collection r9 = (java.util.Collection) r9
            if (r9 == 0) goto L_0x00be
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x00bf
        L_0x00be:
            r3 = 1
        L_0x00bf:
            if (r3 != 0) goto L_0x00f4
            net.one97.travelpass.ui.fragment.c r9 = new net.one97.travelpass.ui.fragment.c
            r9.<init>()
            android.os.Bundle r10 = new android.os.Bundle
            r10.<init>()
            java.util.ArrayList r8 = r8.getTncContent()
            java.io.Serializable r8 = (java.io.Serializable) r8
            r10.putSerializable(r6, r8)
            r9.setArguments(r10)
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 == 0) goto L_0x00f4
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 != 0) goto L_0x00e6
            kotlin.g.b.k.a()
        L_0x00e6:
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            androidx.fragment.app.j r8 = r8.getSupportFragmentManager()
            java.lang.String r10 = r9.getTag()
            r9.show((androidx.fragment.app.j) r8, (java.lang.String) r10)
        L_0x00f4:
            return
        L_0x00f5:
            net.one97.travelpass.ui.b.b r9 = r8.c()
            net.one97.travelpass.ui.b.b r0 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_PARTNER_OFFERS_ITEM
            if (r9 != r0) goto L_0x01dc
            net.one97.travelpass.ui.a r9 = net.one97.travelpass.ui.a.f30575a
            int r9 = net.one97.travelpass.ui.a.h()
            if (r10 != 0) goto L_0x0106
            goto L_0x016d
        L_0x0106:
            int r10 = r10.intValue()
            if (r10 != r9) goto L_0x016d
            androidx.fragment.app.FragmentActivity r9 = r7.getActivity()
            if (r9 == 0) goto L_0x011d
            androidx.fragment.app.j r9 = r9.getSupportFragmentManager()
            if (r9 == 0) goto L_0x011d
            androidx.fragment.app.q r9 = r9.a()
            goto L_0x011e
        L_0x011d:
            r9 = r5
        L_0x011e:
            androidx.fragment.app.FragmentActivity r10 = r7.getActivity()
            java.lang.String r0 = "promo_dialog"
            if (r10 == 0) goto L_0x0131
            androidx.fragment.app.j r10 = r10.getSupportFragmentManager()
            if (r10 == 0) goto L_0x0131
            androidx.fragment.app.Fragment r10 = r10.c((java.lang.String) r0)
            goto L_0x0132
        L_0x0131:
            r10 = r5
        L_0x0132:
            if (r10 == 0) goto L_0x0139
            if (r9 == 0) goto L_0x0139
            r9.a((androidx.fragment.app.Fragment) r10)
        L_0x0139:
            if (r9 == 0) goto L_0x013e
            r9.a((java.lang.String) r5)
        L_0x013e:
            com.paytm.network.model.IJRPaytmDataModel r8 = r8.b()
            boolean r10 = r8 instanceof net.one97.travelpass.model.PartnersOfferData
            if (r10 != 0) goto L_0x0147
            r8 = r5
        L_0x0147:
            net.one97.travelpass.model.PartnersOfferData r8 = (net.one97.travelpass.model.PartnersOfferData) r8
            net.one97.travelpass.ui.fragment.l$a r10 = net.one97.travelpass.ui.fragment.l.f30752b
            if (r8 == 0) goto L_0x0151
            java.lang.String r5 = r8.getPromocode()
        L_0x0151:
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>()
            java.lang.String r10 = net.one97.travelpass.ui.fragment.l.f30753f
            java.io.Serializable r5 = (java.io.Serializable) r5
            r8.putSerializable(r10, r5)
            net.one97.travelpass.ui.fragment.l r10 = new net.one97.travelpass.ui.fragment.l
            r10.<init>()
            r10.setArguments(r8)
            if (r9 == 0) goto L_0x016c
            r10.show((androidx.fragment.app.q) r9, (java.lang.String) r0)
        L_0x016c:
            return
        L_0x016d:
            if (r8 == 0) goto L_0x0174
            com.paytm.network.model.IJRPaytmDataModel r8 = r8.b()
            goto L_0x0175
        L_0x0174:
            r8 = r5
        L_0x0175:
            boolean r9 = r8 instanceof net.one97.travelpass.model.PartnersOfferData
            if (r9 != 0) goto L_0x017a
            r8 = r5
        L_0x017a:
            net.one97.travelpass.model.PartnersOfferData r8 = (net.one97.travelpass.model.PartnersOfferData) r8
            net.one97.travelpass.model.MyPassesResponse r9 = r7.f30674b
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            if (r9 == 0) goto L_0x019d
            if (r8 == 0) goto L_0x019d
            java.lang.String r8 = r8.getTncId()
            com.paytm.network.model.IJRPaytmDataModel r8 = net.one97.travelpass.e.c.a((net.one97.travelpass.model.MyPassesResponse) r9, (java.lang.String) r8)
            boolean r9 = r8 instanceof net.one97.travelpass.model.TravelPassMetaData.TncData
            if (r9 != 0) goto L_0x0194
            r8 = r5
        L_0x0194:
            net.one97.travelpass.model.TravelPassMetaData$TncData r8 = (net.one97.travelpass.model.TravelPassMetaData.TncData) r8
            if (r8 == 0) goto L_0x019e
            java.util.ArrayList r5 = r8.getTncContent()
            goto L_0x019e
        L_0x019d:
            r5 = r10
        L_0x019e:
            r8 = r5
            java.util.Collection r8 = (java.util.Collection) r8
            if (r8 == 0) goto L_0x01a9
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x01aa
        L_0x01a9:
            r3 = 1
        L_0x01aa:
            if (r3 != 0) goto L_0x01db
            net.one97.travelpass.ui.fragment.c r8 = new net.one97.travelpass.ui.fragment.c
            r8.<init>()
            android.os.Bundle r9 = new android.os.Bundle
            r9.<init>()
            java.io.Serializable r5 = (java.io.Serializable) r5
            r9.putSerializable(r6, r5)
            r8.setArguments(r9)
            androidx.fragment.app.FragmentActivity r9 = r7.getActivity()
            if (r9 == 0) goto L_0x01db
            androidx.fragment.app.FragmentActivity r9 = r7.getActivity()
            if (r9 != 0) goto L_0x01cd
            kotlin.g.b.k.a()
        L_0x01cd:
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            androidx.fragment.app.j r9 = r9.getSupportFragmentManager()
            java.lang.String r10 = r8.getTag()
            r8.show((androidx.fragment.app.j) r9, (java.lang.String) r10)
        L_0x01db:
            return
        L_0x01dc:
            net.one97.travelpass.ui.b.b r9 = r8.c()
            net.one97.travelpass.ui.b.b r0 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_HOW_TO_USE
            if (r9 != r0) goto L_0x0223
            net.one97.travelpass.ui.a r9 = net.one97.travelpass.ui.a.f30575a
            int r9 = net.one97.travelpass.ui.a.d()
            if (r10 != 0) goto L_0x01ed
            goto L_0x0207
        L_0x01ed:
            int r10 = r10.intValue()
            if (r10 != r9) goto L_0x0207
            com.paytm.network.model.IJRPaytmDataModel r8 = r8.b()
            boolean r9 = r8 instanceof net.one97.travelpass.model.TravelPassMetaData.TypeCardData
            if (r9 != 0) goto L_0x01fc
            r8 = r5
        L_0x01fc:
            net.one97.travelpass.model.TravelPassMetaData$TypeCardData r8 = (net.one97.travelpass.model.TravelPassMetaData.TypeCardData) r8
            if (r8 == 0) goto L_0x0204
            java.lang.String r5 = r8.getDeeplink()
        L_0x0204:
            r7.a((java.lang.String) r5)
        L_0x0207:
            net.one97.travelpass.e.d$a r8 = net.one97.travelpass.e.d.f30331a
            long r8 = r7.j
            java.lang.String r5 = java.lang.String.valueOf(r8)
            java.lang.String r8 = "passId"
            kotlin.g.b.k.c(r5, r8)
            r4 = 0
            r6 = 48
            java.lang.String r0 = "custom-event"
            java.lang.String r1 = "/travel-pass/home-mypasses"
            java.lang.String r2 = "travel_pass_mypasses"
            java.lang.String r3 = "howtouse_clicked"
            net.one97.travelpass.e.d.a.a((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (int) r6)
            return
        L_0x0223:
            net.one97.travelpass.ui.b.b r9 = r8.c()
            net.one97.travelpass.ui.b.b r0 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_PRICE_DETAILS_ITEM
            if (r9 != r0) goto L_0x02ff
            net.one97.travelpass.ui.a r9 = net.one97.travelpass.ui.a.f30575a
            int r9 = net.one97.travelpass.ui.a.i()
            if (r10 != 0) goto L_0x0234
            return
        L_0x0234:
            int r10 = r10.intValue()
            if (r10 != r9) goto L_0x02ff
            com.paytm.network.model.IJRPaytmDataModel r8 = r8.b()
            boolean r9 = r8 instanceof net.one97.travelpass.model.PassData.PassFields
            if (r9 != 0) goto L_0x0243
            r8 = r5
        L_0x0243:
            net.one97.travelpass.model.PassData$PassFields r8 = (net.one97.travelpass.model.PassData.PassFields) r8
            if (r8 == 0) goto L_0x024c
            java.lang.String r9 = r8.getClickUrl()
            goto L_0x024d
        L_0x024c:
            r9 = r5
        L_0x024d:
            if (r9 == 0) goto L_0x02ff
            if (r8 != 0) goto L_0x0254
            kotlin.g.b.k.a()
        L_0x0254:
            java.lang.String r8 = r8.getClickUrl()
            java.lang.String r9 = "data!!.clickUrl"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.lang.String r9 = "clickUrl"
            kotlin.g.b.k.c(r8, r9)
            r7.g()
            net.one97.travelpass.g.a r10 = r7.f30676d
            if (r10 == 0) goto L_0x02ff
            android.content.Context r0 = r7.getContext()
            kotlin.g.b.k.c(r8, r9)
            if (r0 == 0) goto L_0x02ff
            net.one97.travelpass.d.a r1 = r10.f30476f
            if (r1 == 0) goto L_0x02ff
            net.one97.travelpass.g.a$b r1 = new net.one97.travelpass.g.a$b
            r1.<init>(r10)
            com.paytm.network.listener.b r1 = (com.paytm.network.listener.b) r1
            java.lang.String r10 = "context"
            kotlin.g.b.k.c(r0, r10)
            kotlin.g.b.k.c(r8, r9)
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.util.HashMap r10 = net.one97.travelpass.d.a.a(r0)
            java.util.Map r10 = (java.util.Map) r10
            r9.putAll(r10)
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x02ea
            if (r0 != 0) goto L_0x029f
            goto L_0x02ea
        L_0x029f:
            android.net.Uri r8 = android.net.Uri.parse(r8)
            android.net.Uri$Builder r8 = r8.buildUpon()
            com.paytm.network.b r10 = new com.paytm.network.b
            r10.<init>()
            com.paytm.network.b r10 = r10.a((android.content.Context) r0)
            com.paytm.network.a$c r0 = com.paytm.network.a.c.TRAVEL_PASS
            com.paytm.network.b r10 = r10.a((com.paytm.network.a.c) r0)
            com.paytm.network.a$b r0 = com.paytm.network.a.b.SILENT
            com.paytm.network.b r10 = r10.a((com.paytm.network.a.b) r0)
            java.lang.String r0 = "travel_pass_my_passes"
            com.paytm.network.b r10 = r10.c(r0)
            com.paytm.network.a$a r0 = com.paytm.network.a.C0715a.GET
            com.paytm.network.b r10 = r10.a((com.paytm.network.a.C0715a) r0)
            android.net.Uri r8 = r8.build()
            java.lang.String r8 = r8.toString()
            com.paytm.network.b r8 = r10.a((java.lang.String) r8)
            java.util.Map r9 = (java.util.Map) r9
            com.paytm.network.b r8 = r8.a((java.util.Map<java.lang.String, java.lang.String>) r9)
            net.one97.travelpass.model.BookingDetailsResponse r9 = new net.one97.travelpass.model.BookingDetailsResponse
            r9.<init>()
            com.paytm.network.model.IJRPaytmDataModel r9 = (com.paytm.network.model.IJRPaytmDataModel) r9
            com.paytm.network.b r8 = r8.a((com.paytm.network.model.IJRPaytmDataModel) r9)
            com.paytm.network.b r8 = r8.a((com.paytm.network.listener.b) r1)
            goto L_0x02eb
        L_0x02ea:
            r8 = r5
        L_0x02eb:
            if (r8 == 0) goto L_0x02fc
            com.paytm.network.a r8 = r8.l()
            if (r8 == 0) goto L_0x02f6
            r8.b((boolean) r4)
        L_0x02f6:
            if (r8 == 0) goto L_0x02fb
            r8.a()
        L_0x02fb:
            return
        L_0x02fc:
            r1.handleErrorCode(r2, r5, r5)
        L_0x02ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.a.onItemClickedItem(net.one97.travelpass.ui.c.j, java.lang.Integer, java.lang.Integer):void");
    }

    /* access modifiers changed from: private */
    public final void a(List<Integer> list) {
        net.one97.travelpass.a.c cVar = this.f30673a;
        if (cVar == null) {
            k.a("recyclerAdapter");
        }
        if (cVar != null && this.f30677e != null) {
            net.one97.travelpass.a.c cVar2 = this.f30673a;
            if (cVar2 == null) {
                k.a("recyclerAdapter");
            }
            cVar2.a(this.f30677e);
            if (list != null) {
                int i2 = 0;
                int a2 = kotlin.a.k.a(list);
                if (a2 >= 0) {
                    while (true) {
                        net.one97.travelpass.a.c cVar3 = this.f30673a;
                        if (cVar3 == null) {
                            k.a("recyclerAdapter");
                        }
                        cVar3.notifyItemChanged(list.get(i2).intValue());
                        if (i2 != a2) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                net.one97.travelpass.a.c cVar4 = this.f30673a;
                if (cVar4 == null) {
                    k.a("recyclerAdapter");
                }
                cVar4.notifyDataSetChanged();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(int i2) {
        this.f30677e = net.one97.travelpass.e.c.a(this.f30674b, this.j, i2);
    }

    /* access modifiers changed from: private */
    public final void e() {
        this.f30680h = net.one97.travelpass.e.c.a((List<? extends j>) this.f30677e);
    }

    public final void a() {
        if (getContext() == null || com.paytm.utility.b.c(getContext())) {
            i();
            g();
            f();
            return;
        }
        h();
    }

    private void f() {
        net.one97.travelpass.g.a aVar = this.f30676d;
        if (aVar != null) {
            aVar.b(getContext());
        }
    }

    private void g() {
        ProgressBar progressBar;
        net.one97.travelpass.b.a aVar = this.f30675c;
        if (aVar != null && (progressBar = aVar.f30060c) != null) {
            progressBar.setVisibility(0);
        }
    }

    public final void b() {
        ProgressBar progressBar;
        net.one97.travelpass.b.a aVar = this.f30675c;
        if (aVar != null && (progressBar = aVar.f30060c) != null) {
            progressBar.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            f.a aVar = net.one97.travelpass.e.f.f30332a;
            f.a.a(getContext(), str);
            return;
        }
        j jVar = this.f30680h;
        if (jVar != null) {
            if ((jVar != null ? jVar.b() : null) != null) {
                j jVar2 = this.f30680h;
                IJRPaytmDataModel b2 = jVar2 != null ? jVar2.b() : null;
                if (!(b2 instanceof PassData)) {
                    b2 = null;
                }
                PassData passData = (PassData) b2;
                if (passData == null || !passData.isCanRedeem()) {
                    if (getContext() != null) {
                        b.a aVar2 = net.one97.travelpass.e.b.f30322a;
                        Context context = getContext();
                        if (context == null) {
                            k.a();
                        }
                        k.a((Object) context, "context!!");
                        b.a.c(context);
                    }
                    f.a aVar3 = net.one97.travelpass.e.f.f30332a;
                    f.a.a(getContext(), "paytmmp://travelpass?scrn=passDet");
                    return;
                }
                if (p.a(passData.getCategory(), "bus", true)) {
                    f.a aVar4 = net.one97.travelpass.e.f.f30332a;
                    f.a.a(getContext(), "paytmmp://busticket");
                } else if (p.a(passData.getCategory(), "flights", true)) {
                    f.a aVar5 = net.one97.travelpass.e.f.f30332a;
                    f.a.a(getContext(), "paytmmp://flightticket");
                } else if (p.a(passData.getCategory(), "train", true)) {
                    f.a aVar6 = net.one97.travelpass.e.f.f30332a;
                    f.a.a(getContext(), "paytmmp://flightticket");
                }
                if (getContext() != null) {
                    b.a aVar7 = net.one97.travelpass.e.b.f30322a;
                    Context context2 = getContext();
                    if (context2 == null) {
                        k.a();
                    }
                    k.a((Object) context2, "context!!");
                    b.a.b(context2);
                }
                j.a aVar8 = net.one97.travelpass.e.j.f30335a;
                j.a.a(getContext(), passData.getPromocode());
            }
        }
    }

    public final void c() {
        Button button;
        net.one97.travelpass.ui.c.j jVar = this.f30680h;
        if (jVar != null) {
            if ((jVar != null ? jVar.b() : null) != null) {
                net.one97.travelpass.ui.c.j jVar2 = this.f30680h;
                IJRPaytmDataModel b2 = jVar2 != null ? jVar2.b() : null;
                if (!(b2 instanceof PassData)) {
                    b2 = null;
                }
                PassData passData = (PassData) b2;
                if (passData == null) {
                    return;
                }
                if (!passData.isCanRedeem()) {
                    Button button2 = this.f30681i;
                    if (button2 != null) {
                        button2.setText(getString(R.string.view_passes));
                    }
                } else if (p.a(passData.getCategory(), "bus", true)) {
                    Button button3 = this.f30681i;
                    if (button3 != null) {
                        button3.setText(getString(R.string.book_bus));
                    }
                } else if (p.a(passData.getCategory(), "flights", true)) {
                    Button button4 = this.f30681i;
                    if (button4 != null) {
                        button4.setText(getString(R.string.book_flight));
                    }
                } else if (p.a(passData.getCategory(), "train", true) && (button = this.f30681i) != null) {
                    button.setText(getString(R.string.book_train));
                }
            }
        }
    }

    private void h() {
        String string = getString(R.string.tp_cant_connect);
        k.a((Object) string, "getString(R.string.tp_cant_connect)");
        String string2 = getString(R.string.tp_check_your_network);
        k.a((Object) string2, "getString(R.string.tp_check_your_network)");
        a(string, string2);
    }

    public final void a(o<String, String> oVar) {
        k.c(oVar, "errorDetails");
        a(oVar.getFirst(), oVar.getSecond());
    }

    private void a(String str, String str2) {
        y yVar;
        Button button;
        y yVar2;
        RoboTextView roboTextView;
        y yVar3;
        RoboTextView roboTextView2;
        y yVar4;
        LinearLayout linearLayout;
        k.c(str, "title");
        k.c(str2, "message");
        net.one97.travelpass.b.a aVar = this.f30675c;
        if (!(aVar == null || (yVar4 = aVar.f30058a) == null || (linearLayout = yVar4.f30306b) == null)) {
            linearLayout.setVisibility(0);
        }
        net.one97.travelpass.b.a aVar2 = this.f30675c;
        if (!(aVar2 == null || (yVar3 = aVar2.f30058a) == null || (roboTextView2 = yVar3.f30308d) == null)) {
            roboTextView2.setText(str);
        }
        net.one97.travelpass.b.a aVar3 = this.f30675c;
        if (!(aVar3 == null || (yVar2 = aVar3.f30058a) == null || (roboTextView = yVar2.f30307c) == null)) {
            roboTextView.setText(str2);
        }
        net.one97.travelpass.b.a aVar4 = this.f30675c;
        if (!(aVar4 == null || (yVar = aVar4.f30058a) == null || (button = yVar.f30305a) == null)) {
            button.setOnClickListener(new b(this));
        }
        Button button2 = this.f30681i;
        if (button2 != null) {
            button2.setVisibility(8);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30683a;

        b(a aVar) {
            this.f30683a = aVar;
        }

        public final void onClick(View view) {
            this.f30683a.a();
        }
    }

    private void i() {
        y yVar;
        LinearLayout linearLayout;
        Button button = this.f30681i;
        if (button != null) {
            button.setVisibility(0);
        }
        net.one97.travelpass.b.a aVar = this.f30675c;
        if (aVar != null && (yVar = aVar.f30058a) != null && (linearLayout = yVar.f30306b) != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 3) {
            a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0062, code lost:
        r0 = r0.f30059b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r5, android.os.Bundle r6) {
        /*
            r4 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r5, r0)
            r0 = r4
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            androidx.lifecycle.al r0 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r0)
            java.lang.Class<net.one97.travelpass.g.a> r1 = net.one97.travelpass.g.a.class
            androidx.lifecycle.ai r0 = r0.a(r1)
            net.one97.travelpass.g.a r0 = (net.one97.travelpass.g.a) r0
            r4.f30676d = r0
            r4.d()
            r4.e()
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r1 = r4.getContext()
            r2 = 1
            r3 = 0
            r0.<init>(r1, r2, r3)
            net.one97.travelpass.b.a r1 = r4.f30675c
            if (r1 == 0) goto L_0x0034
            androidx.recyclerview.widget.RecyclerView r1 = r1.f30061d
            if (r1 == 0) goto L_0x0034
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r0
            r1.setLayoutManager(r0)
        L_0x0034:
            java.util.ArrayList<net.one97.travelpass.ui.c.j> r0 = r4.f30677e
            if (r0 == 0) goto L_0x005e
            net.one97.travelpass.a.c r0 = new net.one97.travelpass.a.c
            android.content.Context r1 = r4.getContext()
            java.util.ArrayList<net.one97.travelpass.ui.c.j> r2 = r4.f30677e
            r3 = r4
            com.one97.travelpass.a.c r3 = (com.one97.travelpass.a.c) r3
            r0.<init>(r1, r2, r3)
            r4.f30673a = r0
            net.one97.travelpass.b.a r0 = r4.f30675c
            if (r0 == 0) goto L_0x005e
            androidx.recyclerview.widget.RecyclerView r0 = r0.f30061d
            if (r0 == 0) goto L_0x005e
            net.one97.travelpass.a.c r1 = r4.f30673a
            if (r1 != 0) goto L_0x0059
            java.lang.String r2 = "recyclerAdapter"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0059:
            androidx.recyclerview.widget.RecyclerView$a r1 = (androidx.recyclerview.widget.RecyclerView.a) r1
            r0.setAdapter(r1)
        L_0x005e:
            net.one97.travelpass.b.a r0 = r4.f30675c
            if (r0 == 0) goto L_0x0069
            net.one97.travelpass.b.bc r0 = r0.f30059b
            if (r0 == 0) goto L_0x0069
            android.widget.Button r0 = r0.f30157a
            goto L_0x006a
        L_0x0069:
            r0 = 0
        L_0x006a:
            r4.f30681i = r0
            android.widget.Button r0 = r4.f30681i
            if (r0 == 0) goto L_0x007a
            net.one97.travelpass.ui.fragment.a$a r1 = new net.one97.travelpass.ui.fragment.a$a
            r1.<init>(r4)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x007a:
            net.one97.travelpass.g.a r0 = r4.f30676d
            if (r0 == 0) goto L_0x0091
            androidx.lifecycle.y<net.one97.travelpass.model.MyPassesResponse> r0 = r0.f30477g
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0091
            r1 = r4
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            net.one97.travelpass.ui.fragment.a$c r2 = new net.one97.travelpass.ui.fragment.a$c
            r2.<init>(r4)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x0091:
            net.one97.travelpass.g.a r0 = r4.f30676d
            if (r0 == 0) goto L_0x00a8
            androidx.lifecycle.y<net.one97.travelpass.e.a> r0 = r0.f30472b
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x00a8
            r1 = r4
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            net.one97.travelpass.ui.fragment.a$d r2 = new net.one97.travelpass.ui.fragment.a$d
            r2.<init>(r4)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x00a8:
            net.one97.travelpass.g.a r0 = r4.f30676d
            if (r0 == 0) goto L_0x00bd
            androidx.lifecycle.y<net.one97.travelpass.model.BookingDetailsResponse> r0 = r0.f30478h
            if (r0 == 0) goto L_0x00bd
            r1 = r4
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            net.one97.travelpass.ui.fragment.a$e r2 = new net.one97.travelpass.ui.fragment.a$e
            r2.<init>(r4)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x00bd:
            net.one97.travelpass.g.a r0 = r4.f30676d
            if (r0 == 0) goto L_0x00d2
            androidx.lifecycle.y<net.one97.travelpass.e.a> r0 = r0.f30475e
            if (r0 == 0) goto L_0x00d2
            r1 = r4
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            net.one97.travelpass.ui.fragment.a$f r2 = new net.one97.travelpass.ui.fragment.a$f
            r2.<init>(r4)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x00d2:
            r4.a()
            super.onViewCreated(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.a.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}

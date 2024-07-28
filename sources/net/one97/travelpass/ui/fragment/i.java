package net.one97.travelpass.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.travel.utils.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.travelpass.R;
import net.one97.travelpass.b.y;
import net.one97.travelpass.e.b;
import net.one97.travelpass.e.d;
import net.one97.travelpass.e.f;
import net.one97.travelpass.e.j;
import net.one97.travelpass.g.a;
import net.one97.travelpass.model.InternalOfferData;
import net.one97.travelpass.model.PartnersOfferData;
import net.one97.travelpass.model.PassData;
import net.one97.travelpass.model.TravelPass;
import net.one97.travelpass.model.TravelPassData;
import net.one97.travelpass.model.TravelPassMetaData;
import net.one97.travelpass.model.TravelPassSubscribeResponse;
import net.one97.travelpass.model.VerticalData;
import net.one97.travelpass.model.VerticalPassesData;
import net.one97.travelpass.ui.c.j;
import org.json.JSONObject;

public final class i extends g implements com.one97.travelpass.a.c {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.travelpass.a.c f30732a;

    /* renamed from: b  reason: collision with root package name */
    public TravelPass f30733b;

    /* renamed from: c  reason: collision with root package name */
    String f30734c = "";

    /* renamed from: d  reason: collision with root package name */
    Integer f30735d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30736e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.travelpass.b.c f30737f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.travelpass.g.a f30738g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<j> f30739h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private net.one97.travelpass.e.h f30740i = new net.one97.travelpass.e.h();
    private String j;
    private Button k;
    private j l;
    private HashMap m;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    static final class c<T> implements z<TravelPassSubscribeResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f30743a;

        c(i iVar) {
            this.f30743a = iVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String status;
            TravelPassSubscribeResponse travelPassSubscribeResponse = (TravelPassSubscribeResponse) obj;
            if (travelPassSubscribeResponse != null) {
                TravelPassSubscribeResponse.NotifyMeResponse body = travelPassSubscribeResponse.getBody();
                Boolean bool = null;
                if ((body != null ? body.getStatus() : null) != null) {
                    TravelPassSubscribeResponse.NotifyMeResponse body2 = travelPassSubscribeResponse.getBody();
                    if (!(body2 == null || (status = body2.getStatus()) == null)) {
                        bool = Boolean.valueOf(p.a(status, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, true));
                    }
                    if (bool == null) {
                        k.a();
                    }
                    if (bool.booleanValue()) {
                        g.handleErrorCode$default(this.f30743a, (Integer) null, travelPassSubscribeResponse, (NetworkCustomError) null, 5, (Object) null);
                    }
                }
                i iVar = this.f30743a;
                iVar.f30736e = true;
                i.a(iVar, true, travelPassSubscribeResponse);
                Integer num = this.f30743a.f30735d;
                if (num == null || num.intValue() != -1) {
                    i iVar2 = this.f30743a;
                    String str = iVar2.f30734c;
                    Integer num2 = this.f30743a.f30735d;
                    if (num2 == null) {
                        k.a();
                    }
                    iVar2.a(str, num2.intValue(), Boolean.TRUE);
                }
            }
            this.f30743a.b();
        }
    }

    static final class d<T> implements z<net.one97.travelpass.e.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f30744a;

        d(i iVar) {
            this.f30744a = iVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num;
            net.one97.travelpass.e.a aVar = (net.one97.travelpass.e.a) obj;
            i iVar = this.f30744a;
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
            iVar.handleErrorCode(num, iJRPaytmDataModel, networkCustomError);
            this.f30744a.b();
        }
    }

    static final class e<T> implements z<TravelPassSubscribeResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f30745a;

        e(i iVar) {
            this.f30745a = iVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String status;
            TravelPassSubscribeResponse travelPassSubscribeResponse = (TravelPassSubscribeResponse) obj;
            if (travelPassSubscribeResponse != null) {
                TravelPassSubscribeResponse.NotifyMeResponse body = travelPassSubscribeResponse.getBody();
                Boolean bool = null;
                if ((body != null ? body.getStatus() : null) != null) {
                    TravelPassSubscribeResponse.NotifyMeResponse body2 = travelPassSubscribeResponse.getBody();
                    if (!(body2 == null || (status = body2.getStatus()) == null)) {
                        bool = Boolean.valueOf(p.a(status, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, true));
                    }
                    if (bool == null) {
                        k.a();
                    }
                    if (bool.booleanValue()) {
                        g.handleErrorCode$default(this.f30745a, (Integer) null, travelPassSubscribeResponse, (NetworkCustomError) null, 5, (Object) null);
                    }
                }
                i iVar = this.f30745a;
                iVar.f30736e = true;
                i.a(iVar, false, travelPassSubscribeResponse);
                Integer num = this.f30745a.f30735d;
                if (num == null || num.intValue() != -1) {
                    i iVar2 = this.f30745a;
                    String str = iVar2.f30734c;
                    Integer num2 = this.f30745a.f30735d;
                    if (num2 == null) {
                        k.a();
                    }
                    iVar2.a(str, num2.intValue(), Boolean.TRUE);
                }
            }
            this.f30745a.b();
        }
    }

    static final class f<T> implements z<net.one97.travelpass.e.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f30746a;

        f(i iVar) {
            this.f30746a = iVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num;
            net.one97.travelpass.e.a aVar = (net.one97.travelpass.e.a) obj;
            i iVar = this.f30746a;
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
            iVar.handleErrorCode(num, iJRPaytmDataModel, networkCustomError);
            this.f30746a.b();
        }
    }

    static final class g<T> implements z<TravelPass> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f30747a;

        g(i iVar) {
            this.f30747a = iVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String status;
            TravelPass travelPass = (TravelPass) obj;
            if (this.f30747a.getContext() != null) {
                b.a aVar = net.one97.travelpass.e.b.f30322a;
                Context context = this.f30747a.getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                b.a.d(context);
            }
            if (travelPass != null) {
                TravelPassData body = travelPass.getBody();
                if ((body != null ? body.getStatus() : null) != null) {
                    TravelPassData body2 = travelPass.getBody();
                    Boolean valueOf = (body2 == null || (status = body2.getStatus()) == null) ? null : Boolean.valueOf(p.a(status, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, true));
                    if (valueOf == null) {
                        k.a();
                    }
                    if (valueOf.booleanValue()) {
                        this.f30747a.a((o<String, String>) g.processErrorState$default(this.f30747a, (Integer) null, travelPass, (NetworkCustomError) null, 5, (Object) null));
                    }
                }
                i iVar = this.f30747a;
                iVar.f30733b = travelPass;
                String str = iVar.f30734c;
                Integer num = this.f30747a.f30735d;
                if (num == null) {
                    k.a();
                }
                i.a(iVar, str, num.intValue(), (Boolean) null, 4);
                this.f30747a.e();
                this.f30747a.f();
                if (this.f30747a.f30734c != null) {
                    d.a aVar2 = net.one97.travelpass.e.d.f30331a;
                    String str2 = this.f30747a.f30734c;
                    if (str2 == null) {
                        k.a();
                    }
                    d.a.b(str2);
                }
            }
            this.f30747a.b();
        }
    }

    static final class h<T> implements z<net.one97.travelpass.e.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f30748a;

        h(i iVar) {
            this.f30748a = iVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num;
            net.one97.travelpass.e.a aVar = (net.one97.travelpass.e.a) obj;
            this.f30748a.b();
            i iVar = this.f30748a;
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
            this.f30748a.a(iVar.processErrorState(num, iJRPaytmDataModel, networkCustomError));
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        q.a(context);
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
        Bundle arguments = getArguments();
        String str = null;
        this.f30734c = arguments != null ? arguments.getString("verticalType") : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("passId");
        }
        this.j = str;
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        this.f30737f = (net.one97.travelpass.b.c) androidx.databinding.f.a(layoutInflater, R.layout.fragment_travel_pass_detail, viewGroup, false);
        net.one97.travelpass.b.c cVar = this.f30737f;
        if (cVar == null) {
            k.a();
        }
        return cVar.getRoot();
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f30741a;

        a(i iVar) {
            this.f30741a = iVar;
        }

        public final void onClick(View view) {
            new net.one97.travelpass.e.k();
            if (net.one97.travelpass.e.k.a(this.f30741a.getContext())) {
                i.b(this.f30741a);
            } else {
                this.f30741a.a(4);
            }
        }
    }

    public final void a() {
        if (getContext() == null || com.paytm.utility.b.c(getContext())) {
            h();
            d();
            c();
            return;
        }
        g();
    }

    private void c() {
        net.one97.travelpass.g.a aVar = this.f30738g;
        if (aVar != null) {
            aVar.a(getContext());
        }
    }

    private final void a(String str) {
        com.paytm.network.b bVar;
        if (getContext() == null || com.paytm.utility.b.c(getContext())) {
            new net.one97.travelpass.e.k();
            if (!net.one97.travelpass.e.k.a(getContext())) {
                a((int) AppConstants.REQUEST_CODE.ADD_PRIMARY_EMAIL);
                return;
            }
            d();
            net.one97.travelpass.g.a aVar = this.f30738g;
            if (aVar != null) {
                Context context = getContext();
                k.c(str, "passId");
                if (context != null) {
                    if (!(str.length() == 0) && aVar.f30476f != null) {
                        com.paytm.network.listener.b fVar = new a.f(aVar);
                        k.c(context, "context");
                        k.c(str, "passId");
                        k.c(fVar, "paytmCommonApiListener");
                        k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
                        String a2 = net.one97.travelpass.d.b().a("tpassSubscribePass");
                        com.paytm.network.a aVar2 = null;
                        if (TextUtils.isEmpty(a2) || context == null) {
                            bVar = null;
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.putAll(net.one97.travelpass.d.a.a(context));
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("passId", str);
                            bVar = new com.paytm.network.b().a(context).a(a.c.TRAVEL_PASS).a(a.b.SILENT).c("travel_pass_home").a(a.C0715a.POST).a(Uri.parse(a2).buildUpon().build().toString()).a((Map<String, String>) hashMap).b(jSONObject.toString()).a((IJRPaytmDataModel) new TravelPassSubscribeResponse()).a(fVar);
                        }
                        if (bVar != null) {
                            aVar2 = bVar.l();
                        }
                        if (aVar2 != null) {
                            aVar2.b(true);
                        }
                        if (aVar2 != null) {
                            aVar2.a();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        j.a aVar3 = net.one97.travelpass.e.j.f30335a;
        Context context2 = getContext();
        if (context2 == null) {
            k.a();
        }
        k.a((Object) context2, "context!!");
        j.a.a(context2);
    }

    private final void b(String str) {
        com.paytm.network.b bVar;
        if (getContext() == null || com.paytm.utility.b.c(getContext())) {
            new net.one97.travelpass.e.k();
            if (!net.one97.travelpass.e.k.a(getContext())) {
                a((int) AppConstants.REQUEST_CODE.ADD_SECONDARY_EMAIL);
                return;
            }
            d();
            net.one97.travelpass.g.a aVar = this.f30738g;
            if (aVar != null) {
                Context context = getContext();
                k.c(str, "passId");
                if (context != null) {
                    if (!(str.length() == 0) && aVar.f30476f != null) {
                        com.paytm.network.listener.b gVar = new a.g(aVar);
                        k.c(context, "context");
                        k.c(str, "passId");
                        k.c(gVar, "paytmCommonApiListener");
                        k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
                        String a2 = net.one97.travelpass.d.b().a("tpassUnsubscribePass");
                        com.paytm.network.a aVar2 = null;
                        if (TextUtils.isEmpty(a2) || context == null) {
                            bVar = null;
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.putAll(net.one97.travelpass.d.a.a(context));
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("passId", str);
                            bVar = new com.paytm.network.b().a(context).a(a.c.TRAVEL_PASS).a(a.b.SILENT).c("travel_pass_home").a(a.C0715a.POST).a(Uri.parse(a2).buildUpon().build().toString()).a((Map<String, String>) hashMap).b(jSONObject.toString()).a((IJRPaytmDataModel) new TravelPassSubscribeResponse()).a(gVar);
                        }
                        if (bVar != null) {
                            aVar2 = bVar.l();
                        }
                        if (aVar2 != null) {
                            aVar2.b(true);
                        }
                        if (aVar2 != null) {
                            aVar2.a();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        j.a aVar3 = net.one97.travelpass.e.j.f30335a;
        Context context2 = getContext();
        if (context2 == null) {
            k.a();
        }
        k.a((Object) context2, "context!!");
        j.a.a(context2);
    }

    private void d() {
        ProgressBar progressBar;
        RelativeLayout relativeLayout;
        net.one97.travelpass.b.c cVar = this.f30737f;
        if (!(cVar == null || (relativeLayout = cVar.f30221c) == null)) {
            relativeLayout.setVisibility(0);
        }
        net.one97.travelpass.b.c cVar2 = this.f30737f;
        if (cVar2 != null && (progressBar = cVar2.f30222d) != null) {
            progressBar.setVisibility(0);
        }
    }

    public final void b() {
        ProgressBar progressBar;
        RelativeLayout relativeLayout;
        net.one97.travelpass.b.c cVar = this.f30737f;
        if (!(cVar == null || (relativeLayout = cVar.f30221c) == null)) {
            relativeLayout.setVisibility(8);
        }
        net.one97.travelpass.b.c cVar2 = this.f30737f;
        if (cVar2 != null && (progressBar = cVar2.f30222d) != null) {
            progressBar.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void a(int i2) {
        Intent intent = new Intent();
        intent.putExtra("VERTICAL_NAME", "BusTicket");
        k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
        net.one97.travelpass.d.b().a(getContext(), intent, i2);
    }

    /* access modifiers changed from: private */
    public final void e() {
        net.one97.travelpass.ui.c.j jVar;
        List list = this.f30739h;
        k.c(list, "viewHolderModelList");
        if (!list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                net.one97.travelpass.ui.c.j jVar2 = (net.one97.travelpass.ui.c.j) it2.next();
                if (jVar2.c() == net.one97.travelpass.ui.b.b.TRAVEL_PASS_CAROUSEL) {
                    ArrayList<net.one97.travelpass.ui.c.j> a2 = jVar2.a();
                    Collection collection = a2;
                    if (!(collection == null || collection.isEmpty())) {
                        jVar = a2.get(jVar2.j());
                        break;
                    }
                }
            }
            this.l = jVar;
        }
        jVar = null;
        this.l = jVar;
    }

    static /* synthetic */ void a(i iVar, String str, int i2, Boolean bool, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        iVar.a(str, i2, bool);
    }

    /* access modifiers changed from: private */
    public final void a(String str, int i2, Boolean bool) {
        CharSequence charSequence = this.j;
        int i3 = 0;
        boolean z = true;
        if (!(charSequence == null || charSequence.length() == 0)) {
            o<String, Integer> f2 = this.f30740i != null ? net.one97.travelpass.e.h.f(this.f30733b, this.j) : null;
            TravelPass travelPass = this.f30733b;
            if (f2 == null) {
                k.a();
            }
            a(travelPass, str, f2.getSecond().intValue());
        } else {
            a(this.f30733b, str, i2);
        }
        if (k.a((Object) bool, (Object) Boolean.TRUE)) {
            ArrayList<net.one97.travelpass.ui.c.j> arrayList = this.f30739h;
            Collection collection = arrayList;
            if (collection != null && !collection.isEmpty()) {
                z = false;
            }
            if (!z) {
                ArrayList arrayList2 = new ArrayList();
                int a2 = kotlin.a.k.a(arrayList);
                if (a2 >= 0) {
                    while (true) {
                        net.one97.travelpass.ui.b.b c2 = arrayList.get(i3).c();
                        if (!(c2 == net.one97.travelpass.ui.b.b.TRAVEL_PASS_CAROUSEL || c2 == net.one97.travelpass.ui.b.b.TRAVEL_PASS_CAROUSEL_ITEM || c2 == net.one97.travelpass.ui.b.b.TRAVEL_PASS_TABS || c2 == net.one97.travelpass.ui.b.b.TRAVEL_PASS_TAB_ITEM)) {
                            arrayList2.add(Integer.valueOf(i3));
                        }
                        if (i3 == a2) {
                            break;
                        }
                        i3++;
                    }
                }
            }
        }
        ArrayList<net.one97.travelpass.ui.c.j> arrayList3 = this.f30739h;
        if (arrayList3 != null) {
            net.one97.travelpass.a.c cVar = this.f30732a;
            if (cVar == null) {
                k.a("recyclerAdapter");
            }
            cVar.a(arrayList3);
            net.one97.travelpass.a.c cVar2 = this.f30732a;
            if (cVar2 == null) {
                k.a("recyclerAdapter");
            }
            cVar2.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void f() {
        net.one97.travelpass.ui.c.j jVar = this.l;
        if (jVar != null) {
            Double d2 = null;
            IJRPaytmDataModel b2 = jVar != null ? jVar.b() : null;
            if (!(b2 instanceof PassData)) {
                b2 = null;
            }
            PassData passData = (PassData) b2;
            if (passData == null) {
                return;
            }
            if (passData.isDisable()) {
                Button button = this.k;
                if (button != null) {
                    button.setVisibility(8);
                    return;
                }
                return;
            }
            Button button2 = this.k;
            if (button2 != null) {
                button2.setVisibility(0);
            }
            net.one97.travelpass.ui.c.j jVar2 = this.l;
            if (jVar2 != null) {
                if (jVar2 != null) {
                    d2 = Double.valueOf(jVar2.k());
                }
                if (d2 == null) {
                    k.a();
                }
                double doubleValue = d2.doubleValue();
                if (doubleValue != -1.0d) {
                    String string = getString(R.string.purchase_button_text, Double.valueOf(doubleValue));
                    k.a((Object) string, "getString(R.string.purch…_button_text, priceValue)");
                    Button button3 = this.k;
                    if (button3 != null) {
                        button3.setText(string);
                    }
                }
            }
        }
    }

    public final void onItemClickedItem(net.one97.travelpass.ui.c.j jVar, Integer num, Integer num2) {
        net.one97.travelpass.ui.c.j jVar2 = jVar;
        Integer num3 = num;
        if (jVar2 != null) {
            boolean z = false;
            String str = null;
            if (jVar.c() == net.one97.travelpass.ui.b.b.TRAVEL_PASS_TAB_ITEM) {
                IJRPaytmDataModel b2 = jVar.b();
                if (b2 != null) {
                    VerticalData verticalData = (VerticalData) b2;
                    this.f30734c = verticalData.getType();
                    this.f30735d = 0;
                    this.j = "";
                    this.l = null;
                    a(this, verticalData.getType(), 0, (Boolean) null, 6);
                    e();
                    f();
                    if (this.f30734c != null) {
                        d.a aVar = net.one97.travelpass.e.d.f30331a;
                        String str2 = this.f30734c;
                        if (str2 == null) {
                            k.a();
                        }
                        d.a.b(str2);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.travelpass.model.VerticalData");
            } else if (jVar.c() == net.one97.travelpass.ui.b.b.TRAVEL_PASS_CAROUSEL_ITEM) {
                if (num3 == null || num.intValue() != -1) {
                    net.one97.travelpass.ui.a aVar2 = net.one97.travelpass.ui.a.f30575a;
                    int c2 = net.one97.travelpass.ui.a.c();
                    if (num2 != null && num2.intValue() == c2) {
                        IJRPaytmDataModel b3 = jVar.b();
                        if (!(b3 instanceof PassData)) {
                            b3 = null;
                        }
                        PassData passData = (PassData) b3;
                        this.l = jVar2;
                        this.f30735d = num3;
                        if (passData != null) {
                            str = passData.getTravelPassId();
                        }
                        this.j = str;
                        f();
                        String str3 = this.f30734c;
                        if (num3 == null) {
                            k.a();
                        }
                        a(str3, num.intValue(), Boolean.TRUE);
                    }
                }
            } else if (jVar.c() == net.one97.travelpass.ui.b.b.TRAVEL_PASS_TEAMS_CONDITIONS) {
                if (!(getContext() == null || this.j == null)) {
                    b.a aVar3 = net.one97.travelpass.e.b.f30322a;
                    Context context = getContext();
                    if (context == null) {
                        k.a();
                    }
                    k.a((Object) context, "context!!");
                    String str4 = this.j;
                    if (str4 == null) {
                        k.a();
                    }
                    k.c(context, "context");
                    k.c(str4, "passId");
                    b.a.a(context, net.one97.travelpass.e.b.j, net.one97.travelpass.e.b.q, (String) null, (String) null, str4, (String) null, net.one97.travelpass.e.b.f30326e, (String) null, 344);
                }
                if (jVar2 != null && jVar.b() != null) {
                    IJRPaytmDataModel b4 = jVar.b();
                    if (!(b4 instanceof TravelPassMetaData.TncData)) {
                        b4 = null;
                    }
                    TravelPassMetaData.TncData tncData = (TravelPassMetaData.TncData) b4;
                    if (tncData != null) {
                        Collection tncContent = tncData.getTncContent();
                        if (tncContent == null || tncContent.isEmpty()) {
                            z = true;
                        }
                        if (!z) {
                            c cVar = new c();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("dataList", tncData.getTncContent());
                            cVar.setArguments(bundle);
                            if (getActivity() != null) {
                                FragmentActivity activity = getActivity();
                                if (activity == null) {
                                    k.a();
                                }
                                k.a((Object) activity, "activity!!");
                                cVar.show(activity.getSupportFragmentManager(), cVar.getTag());
                            }
                        }
                    }
                }
            } else if (jVar.c() == net.one97.travelpass.ui.b.b.TRAVEL_PASS_PARTNER_OFFERS_ITEM) {
                net.one97.travelpass.ui.a aVar4 = net.one97.travelpass.ui.a.f30575a;
                int c3 = net.one97.travelpass.ui.a.c();
                if (num2 == null || num2.intValue() != c3) {
                    net.one97.travelpass.ui.a aVar5 = net.one97.travelpass.ui.a.f30575a;
                    int b5 = net.one97.travelpass.ui.a.b();
                    if (num2 != null && num2.intValue() == b5) {
                        IJRPaytmDataModel b6 = jVar2 != null ? jVar.b() : null;
                        if (!(b6 instanceof PartnersOfferData)) {
                            b6 = null;
                        }
                        ArrayList<String> a2 = net.one97.travelpass.e.h.a((PartnersOfferData) b6, this.f30733b);
                        Collection collection = a2;
                        if (collection == null || collection.isEmpty()) {
                            z = true;
                        }
                        if (!z) {
                            c cVar2 = new c();
                            Bundle bundle2 = new Bundle();
                            bundle2.putSerializable("dataList", a2);
                            cVar2.setArguments(bundle2);
                            if (getActivity() != null) {
                                FragmentActivity activity2 = getActivity();
                                if (activity2 == null) {
                                    k.a();
                                }
                                k.a((Object) activity2, "activity!!");
                                cVar2.show(activity2.getSupportFragmentManager(), cVar2.getTag());
                            }
                        }
                        IJRPaytmDataModel b7 = jVar.b();
                        if (!(b7 instanceof PartnersOfferData)) {
                            b7 = null;
                        }
                        PartnersOfferData partnersOfferData = (PartnersOfferData) b7;
                        if (partnersOfferData != null && this.l != null) {
                            String partnerOfferName = partnersOfferData.getPartnerOfferName();
                            String partnerOfferId = partnersOfferData.getPartnerOfferId();
                            if (!TextUtils.isEmpty(partnerOfferName) && !TextUtils.isEmpty(partnerOfferId) && this.j != null) {
                                d.a aVar6 = net.one97.travelpass.e.d.f30331a;
                                k.a((Object) partnerOfferName, "offerName");
                                k.a((Object) partnerOfferId, "offerId");
                                String str5 = this.j;
                                if (str5 == null) {
                                    k.a();
                                }
                                k.c(partnerOfferName, "bannerName");
                                k.c(partnerOfferId, "bannerId");
                                k.c(str5, "passId");
                                d.a.a("custom-event", "/travel-pass/details", "travel_pass_pdp", "offer_clicked", partnerOfferName, partnerOfferId, str5);
                            }
                        }
                    }
                } else if (this.j != null) {
                    d.a aVar7 = net.one97.travelpass.e.d.f30331a;
                    String str6 = this.j;
                    if (str6 == null) {
                        k.a();
                    }
                    k.c(str6, "passId");
                    d.a.a("custom-event", "/travel-pass/details", "travel_pass_pdp", "partneroffer_scrolled", (String) null, str6, 48);
                }
            } else if (jVar.c() == net.one97.travelpass.ui.b.b.TRAVEL_PASS_INTERNAL_OFFERS_ITEM) {
                if (this.j != null) {
                    d.a aVar8 = net.one97.travelpass.e.d.f30331a;
                    String str7 = this.j;
                    if (str7 == null) {
                        k.a();
                    }
                    k.c(str7, "passId");
                    d.a.a("custom-event", "/travel-pass/details", "travel_pass_pdp", "internaloffer_clicked", (String) null, str7, 48);
                }
                IJRPaytmDataModel b8 = jVar2 != null ? jVar.b() : null;
                if (!(b8 instanceof InternalOfferData)) {
                    b8 = null;
                }
                ArrayList<String> a3 = net.one97.travelpass.e.h.a((InternalOfferData) b8, this.f30733b);
                Collection collection2 = a3;
                if (collection2 == null || collection2.isEmpty()) {
                    z = true;
                }
                if (!z) {
                    c cVar3 = new c();
                    Bundle bundle3 = new Bundle();
                    bundle3.putSerializable("dataList", a3);
                    cVar3.setArguments(bundle3);
                    if (getActivity() != null) {
                        FragmentActivity activity3 = getActivity();
                        if (activity3 == null) {
                            k.a();
                        }
                        k.a((Object) activity3, "activity!!");
                        cVar3.show(activity3.getSupportFragmentManager(), cVar3.getTag());
                    }
                }
            } else if (jVar.c() == net.one97.travelpass.ui.b.b.TRAVEL_PASS_HOW_TO_USE) {
                net.one97.travelpass.ui.a aVar9 = net.one97.travelpass.ui.a.f30575a;
                int d2 = net.one97.travelpass.ui.a.d();
                if (num2 != null && num2.intValue() == d2) {
                    IJRPaytmDataModel b9 = jVar.b();
                    if (!(b9 instanceof TravelPassMetaData.TypeCardData)) {
                        b9 = null;
                    }
                    TravelPassMetaData.TypeCardData typeCardData = (TravelPassMetaData.TypeCardData) b9;
                    String deeplink = typeCardData != null ? typeCardData.getDeeplink() : null;
                    CharSequence charSequence = deeplink;
                    if (charSequence == null || charSequence.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        f.a aVar10 = net.one97.travelpass.e.f.f30332a;
                        f.a.a(getContext(), deeplink);
                    } else {
                        net.one97.travelpass.ui.c.j jVar3 = this.l;
                        if (jVar3 != null) {
                            if ((jVar3 != null ? jVar3.b() : null) != null) {
                                net.one97.travelpass.ui.c.j jVar4 = this.l;
                                IJRPaytmDataModel b10 = jVar4 != null ? jVar4.b() : null;
                                if (!(b10 instanceof PassData)) {
                                    b10 = null;
                                }
                                PassData passData2 = (PassData) b10;
                                if (passData2 == null || !passData2.isCanRedeem()) {
                                    f.a aVar11 = net.one97.travelpass.e.f.f30332a;
                                    f.a.a(getContext(), "paytmmp://travelpass?scrn=passDet");
                                } else {
                                    if (p.a(passData2.getCategory(), "bus", true)) {
                                        f.a aVar12 = net.one97.travelpass.e.f.f30332a;
                                        f.a.a(getContext(), "paytmmp://busticket");
                                    } else if (p.a(passData2.getCategory(), "flights", true)) {
                                        f.a aVar13 = net.one97.travelpass.e.f.f30332a;
                                        f.a.a(getContext(), "paytmmp://flightticket");
                                    } else if (p.a(passData2.getCategory(), "train", true)) {
                                        f.a aVar14 = net.one97.travelpass.e.f.f30332a;
                                        f.a.a(getContext(), "paytmmp://flightticket");
                                    }
                                    j.a aVar15 = net.one97.travelpass.e.j.f30335a;
                                    j.a.a(getContext(), passData2.getPromocode());
                                }
                            }
                        }
                    }
                }
                if (this.j != null) {
                    d.a aVar16 = net.one97.travelpass.e.d.f30331a;
                    String str8 = this.j;
                    if (str8 == null) {
                        k.a();
                    }
                    k.c(str8, "passId");
                    d.a.a("custom-event", "/travel-pass/details", "travel_pass_pdp", "howtouse_clicked", (String) null, str8, 48);
                }
            } else if (jVar.c() == net.one97.travelpass.ui.b.b.TRAVEL_PASS_SUBSCRIBE_ITEM) {
                a(jVar);
            } else if (jVar.c() == net.one97.travelpass.ui.b.b.TRAVEL_PASS_FAQ_ITEM && this.j != null) {
                d.a aVar17 = net.one97.travelpass.e.d.f30331a;
                String str9 = this.j;
                if (str9 == null) {
                    k.a();
                }
                k.c(str9, "passId");
                d.a.a("custom-event", "/travel-pass/details", "travel_pass_pdp", "faq_clicked", "question_asked", str9, 32);
            }
        }
    }

    private void a(net.one97.travelpass.ui.c.j jVar) {
        k.c(jVar, "viewHolderModel");
        IJRPaytmDataModel b2 = jVar.b();
        if (!(b2 instanceof PassData)) {
            b2 = null;
        }
        PassData passData = (PassData) b2;
        if (passData == null) {
            return;
        }
        if (passData.isSubscribed()) {
            String travelPassId = passData.getTravelPassId();
            k.a((Object) travelPassId, "passData.travelPassId");
            b(travelPassId);
            return;
        }
        String travelPassId2 = passData.getTravelPassId();
        k.a((Object) travelPassId2, "passData.travelPassId");
        a(travelPassId2);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 == 1101 || i2 == 1102) {
            net.one97.travelpass.ui.c.j jVar = this.l;
            if (jVar != null) {
                if (jVar == null) {
                    k.a();
                }
                a(jVar);
            }
        } else if (i2 == 3) {
            a();
        }
    }

    private void g() {
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
        net.one97.travelpass.b.c cVar = this.f30737f;
        if (!(cVar == null || (yVar4 = cVar.f30219a) == null || (linearLayout = yVar4.f30306b) == null)) {
            linearLayout.setVisibility(0);
        }
        net.one97.travelpass.b.c cVar2 = this.f30737f;
        if (!(cVar2 == null || (yVar3 = cVar2.f30219a) == null || (roboTextView2 = yVar3.f30308d) == null)) {
            roboTextView2.setText(str);
        }
        net.one97.travelpass.b.c cVar3 = this.f30737f;
        if (!(cVar3 == null || (yVar2 = cVar3.f30219a) == null || (roboTextView = yVar2.f30307c) == null)) {
            roboTextView.setText(str2);
        }
        net.one97.travelpass.b.c cVar4 = this.f30737f;
        if (cVar4 != null && (yVar = cVar4.f30219a) != null && (button = yVar.f30305a) != null) {
            button.setOnClickListener(new b(this));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f30742a;

        b(i iVar) {
            this.f30742a = iVar;
        }

        public final void onClick(View view) {
            this.f30742a.a();
        }
    }

    private void h() {
        y yVar;
        LinearLayout linearLayout;
        net.one97.travelpass.b.c cVar = this.f30737f;
        if (cVar != null && (yVar = cVar.f30219a) != null && (linearLayout = yVar.f30306b) != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        r0 = r0.f30220b;
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
            r4.f30738g = r0
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.fragment.app.FragmentActivity r1 = r4.getActivity()
            android.content.Context r1 = (android.content.Context) r1
            r2 = 1
            r3 = 0
            r0.<init>(r1, r2, r3)
            net.one97.travelpass.b.c r1 = r4.f30737f
            if (r1 == 0) goto L_0x0030
            androidx.recyclerview.widget.RecyclerView r1 = r1.f30223e
            if (r1 == 0) goto L_0x0030
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r0
            r1.setLayoutManager(r0)
        L_0x0030:
            java.util.ArrayList<net.one97.travelpass.ui.c.j> r0 = r4.f30739h
            if (r0 == 0) goto L_0x005c
            net.one97.travelpass.a.c r0 = new net.one97.travelpass.a.c
            androidx.fragment.app.FragmentActivity r1 = r4.getActivity()
            android.content.Context r1 = (android.content.Context) r1
            java.util.ArrayList<net.one97.travelpass.ui.c.j> r2 = r4.f30739h
            r3 = r4
            com.one97.travelpass.a.c r3 = (com.one97.travelpass.a.c) r3
            r0.<init>(r1, r2, r3)
            r4.f30732a = r0
            net.one97.travelpass.b.c r0 = r4.f30737f
            if (r0 == 0) goto L_0x005c
            androidx.recyclerview.widget.RecyclerView r0 = r0.f30223e
            if (r0 == 0) goto L_0x005c
            net.one97.travelpass.a.c r1 = r4.f30732a
            if (r1 != 0) goto L_0x0057
            java.lang.String r2 = "recyclerAdapter"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0057:
            androidx.recyclerview.widget.RecyclerView$a r1 = (androidx.recyclerview.widget.RecyclerView.a) r1
            r0.setAdapter(r1)
        L_0x005c:
            net.one97.travelpass.b.c r0 = r4.f30737f
            if (r0 == 0) goto L_0x0067
            net.one97.travelpass.b.bc r0 = r0.f30220b
            if (r0 == 0) goto L_0x0067
            android.widget.Button r0 = r0.f30157a
            goto L_0x0068
        L_0x0067:
            r0 = 0
        L_0x0068:
            r4.k = r0
            android.widget.Button r0 = r4.k
            if (r0 == 0) goto L_0x0078
            net.one97.travelpass.ui.fragment.i$a r1 = new net.one97.travelpass.ui.fragment.i$a
            r1.<init>(r4)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x0078:
            net.one97.travelpass.g.a r0 = r4.f30738g
            if (r0 == 0) goto L_0x0090
            androidx.lifecycle.y<net.one97.travelpass.model.TravelPassSubscribeResponse> r0 = r0.f30479i
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0090
            androidx.lifecycle.q r1 = r4.getViewLifecycleOwner()
            net.one97.travelpass.ui.fragment.i$c r2 = new net.one97.travelpass.ui.fragment.i$c
            r2.<init>(r4)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x0090:
            net.one97.travelpass.g.a r0 = r4.f30738g
            if (r0 == 0) goto L_0x00a8
            androidx.lifecycle.y<net.one97.travelpass.e.a> r0 = r0.j
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x00a8
            androidx.lifecycle.q r1 = r4.getViewLifecycleOwner()
            net.one97.travelpass.ui.fragment.i$d r2 = new net.one97.travelpass.ui.fragment.i$d
            r2.<init>(r4)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x00a8:
            net.one97.travelpass.g.a r0 = r4.f30738g
            if (r0 == 0) goto L_0x00c0
            androidx.lifecycle.y<net.one97.travelpass.model.TravelPassSubscribeResponse> r0 = r0.k
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x00c0
            androidx.lifecycle.q r1 = r4.getViewLifecycleOwner()
            net.one97.travelpass.ui.fragment.i$e r2 = new net.one97.travelpass.ui.fragment.i$e
            r2.<init>(r4)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x00c0:
            net.one97.travelpass.g.a r0 = r4.f30738g
            if (r0 == 0) goto L_0x00d8
            androidx.lifecycle.y<net.one97.travelpass.e.a> r0 = r0.l
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x00d8
            androidx.lifecycle.q r1 = r4.getViewLifecycleOwner()
            net.one97.travelpass.ui.fragment.i$f r2 = new net.one97.travelpass.ui.fragment.i$f
            r2.<init>(r4)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x00d8:
            net.one97.travelpass.g.a r0 = r4.f30738g
            if (r0 == 0) goto L_0x00f0
            androidx.lifecycle.y<net.one97.travelpass.model.TravelPass> r0 = r0.f30471a
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x00f0
            androidx.lifecycle.q r1 = r4.getViewLifecycleOwner()
            net.one97.travelpass.ui.fragment.i$g r2 = new net.one97.travelpass.ui.fragment.i$g
            r2.<init>(r4)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x00f0:
            net.one97.travelpass.g.a r0 = r4.f30738g
            if (r0 == 0) goto L_0x0108
            androidx.lifecycle.y<net.one97.travelpass.e.a> r0 = r0.f30472b
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0108
            androidx.lifecycle.q r1 = r4.getViewLifecycleOwner()
            net.one97.travelpass.ui.fragment.i$h r2 = new net.one97.travelpass.ui.fragment.i$h
            r2.<init>(r4)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x0108:
            r4.a()
            super.onViewCreated(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.i.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        if ((r12.length() == 0) == false) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(net.one97.travelpass.model.TravelPass r11, java.lang.String r12, int r13) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            net.one97.travelpass.ui.c.j r1 = net.one97.travelpass.e.h.a((net.one97.travelpass.model.TravelPass) r11, (java.lang.String) r12)
            java.util.ArrayList r2 = r1.a()
            java.util.Collection r2 = (java.util.Collection) r2
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x001c
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r2 = 0
            goto L_0x001d
        L_0x001c:
            r2 = 1
        L_0x001d:
            if (r2 != 0) goto L_0x002c
            java.util.ArrayList r2 = r1.a()
            int r2 = r2.size()
            if (r2 <= r4) goto L_0x002c
            r0.add(r1)
        L_0x002c:
            if (r12 == 0) goto L_0x003d
            r1 = r12
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0039
            r1 = 1
            goto L_0x003a
        L_0x0039:
            r1 = 0
        L_0x003a:
            if (r1 != 0) goto L_0x003d
            goto L_0x0046
        L_0x003d:
            java.lang.String r12 = net.one97.travelpass.e.h.a((net.one97.travelpass.model.TravelPass) r11)
            if (r12 != 0) goto L_0x0046
            kotlin.g.b.k.a()
        L_0x0046:
            net.one97.travelpass.ui.c.j r1 = net.one97.travelpass.e.h.b((net.one97.travelpass.model.TravelPass) r11, (java.lang.String) r12)
            java.util.ArrayList r2 = r1.a()
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x005b
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r2 = 0
            goto L_0x005c
        L_0x005b:
            r2 = 1
        L_0x005c:
            if (r2 != 0) goto L_0x0067
            r2 = -1
            if (r13 == r2) goto L_0x0064
            r1.a((int) r13)
        L_0x0064:
            r0.add(r1)
        L_0x0067:
            net.one97.travelpass.model.PassData r1 = net.one97.travelpass.e.h.a(r11, r12, r13)
            if (r1 == 0) goto L_0x00ad
            java.lang.String r2 = r1.getSubscriptionText()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x007e
            int r2 = r2.length()
            if (r2 != 0) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            r2 = 0
            goto L_0x007f
        L_0x007e:
            r2 = 1
        L_0x007f:
            if (r2 != 0) goto L_0x00ad
            java.lang.String r2 = r1.getSubscriptionButtonLabel()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0092
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0090
            goto L_0x0092
        L_0x0090:
            r2 = 0
            goto L_0x0093
        L_0x0092:
            r2 = 1
        L_0x0093:
            if (r2 != 0) goto L_0x00ad
            java.lang.String r2 = "passData"
            kotlin.g.b.k.c(r1, r2)
            net.one97.travelpass.ui.c.j r2 = new net.one97.travelpass.ui.c.j
            r2.<init>()
            net.one97.travelpass.ui.b.b r5 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_SUBSCRIBE_ITEM
            r2.a((net.one97.travelpass.ui.b.b) r5)
            r5 = r1
            com.paytm.network.model.IJRPaytmDataModel r5 = (com.paytm.network.model.IJRPaytmDataModel) r5
            r2.a((com.paytm.network.model.IJRPaytmDataModel) r5)
            r0.add(r2)
        L_0x00ad:
            r2 = 0
            if (r1 == 0) goto L_0x0101
            java.util.List r5 = r1.getFields()
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x00c1
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x00bf
            goto L_0x00c1
        L_0x00bf:
            r5 = 0
            goto L_0x00c2
        L_0x00c1:
            r5 = 1
        L_0x00c2:
            if (r5 != 0) goto L_0x0101
            java.util.List r5 = r1.getFields()
            if (r5 == 0) goto L_0x00f9
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.util.ArrayList r5 = net.one97.travelpass.e.h.a((java.util.ArrayList<net.one97.travelpass.model.PassData.PassFields>) r5)
            r6 = r5
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x0101
            java.lang.String r7 = "fields"
            kotlin.g.b.k.c(r5, r7)
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x00f2
            net.one97.travelpass.ui.c.j r6 = new net.one97.travelpass.ui.c.j
            r6.<init>()
            net.one97.travelpass.ui.b.b r7 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_PRICE_DETAILS
            r6.a((net.one97.travelpass.ui.b.b) r7)
            r6.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r5)
            goto L_0x00f3
        L_0x00f2:
            r6 = r2
        L_0x00f3:
            if (r6 == 0) goto L_0x0101
            r0.add(r6)
            goto L_0x0101
        L_0x00f9:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.travelpass.model.PassData.PassFields> /* = java.util.ArrayList<net.one97.travelpass.model.PassData.PassFields> */"
            r11.<init>(r12)
            throw r11
        L_0x0101:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r13)
            net.one97.travelpass.ui.c.j r6 = new net.one97.travelpass.ui.c.j
            r6.<init>()
            net.one97.travelpass.ui.b.b r7 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_PARTNER_OFFERS
            r6.a((net.one97.travelpass.ui.b.b) r7)
            if (r11 == 0) goto L_0x0122
            net.one97.travelpass.model.TravelPassData r7 = r11.getBody()
            if (r7 == 0) goto L_0x0122
            net.one97.travelpass.model.TravelPassMetaData r7 = r7.getMetadata()
            if (r7 == 0) goto L_0x0122
            java.lang.String r7 = r7.getCardLevelPartnerOfferHeading()
            goto L_0x0123
        L_0x0122:
            r7 = r2
        L_0x0123:
            r6.a((java.lang.String) r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            if (r11 == 0) goto L_0x0175
            r8 = r12
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x013b
            int r9 = r8.length()
            if (r9 != 0) goto L_0x0139
            goto L_0x013b
        L_0x0139:
            r9 = 0
            goto L_0x013c
        L_0x013b:
            r9 = 1
        L_0x013c:
            if (r9 != 0) goto L_0x0175
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            if (r11 == 0) goto L_0x016f
            if (r8 == 0) goto L_0x0152
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0150
            goto L_0x0152
        L_0x0150:
            r8 = 0
            goto L_0x0153
        L_0x0152:
            r8 = 1
        L_0x0153:
            if (r8 != 0) goto L_0x016f
            if (r5 != 0) goto L_0x015a
            kotlin.g.b.k.a()
        L_0x015a:
            int r5 = r5.intValue()
            net.one97.travelpass.model.PassData r5 = net.one97.travelpass.e.h.a(r11, r12, r5)
            if (r5 == 0) goto L_0x016f
            java.util.List r5 = r5.getPartnerOffers()
            java.util.ArrayList r5 = net.one97.travelpass.e.h.a((net.one97.travelpass.model.TravelPass) r11, (java.util.List<java.lang.String>) r5)
            r7 = r5
            java.util.List r7 = (java.util.List) r7
        L_0x016f:
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.util.ArrayList r7 = net.one97.travelpass.e.h.d(r7)
        L_0x0175:
            r6.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r7)
            java.util.ArrayList r5 = r6.a()
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x0189
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0187
            goto L_0x0189
        L_0x0187:
            r5 = 0
            goto L_0x018a
        L_0x0189:
            r5 = 1
        L_0x018a:
            if (r5 != 0) goto L_0x018f
            r0.add(r6)
        L_0x018f:
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            net.one97.travelpass.ui.c.j r5 = new net.one97.travelpass.ui.c.j
            r5.<init>()
            net.one97.travelpass.ui.b.b r7 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_INTERNAL_OFFERS
            r5.a((net.one97.travelpass.ui.b.b) r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            if (r11 == 0) goto L_0x01ec
            r8 = r12
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x01b2
            int r9 = r8.length()
            if (r9 != 0) goto L_0x01b0
            goto L_0x01b2
        L_0x01b0:
            r9 = 0
            goto L_0x01b3
        L_0x01b2:
            r9 = 1
        L_0x01b3:
            if (r9 != 0) goto L_0x01ec
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            if (r11 == 0) goto L_0x01e6
            if (r8 == 0) goto L_0x01c9
            int r8 = r8.length()
            if (r8 != 0) goto L_0x01c7
            goto L_0x01c9
        L_0x01c7:
            r8 = 0
            goto L_0x01ca
        L_0x01c9:
            r8 = 1
        L_0x01ca:
            if (r8 != 0) goto L_0x01e6
            if (r13 != 0) goto L_0x01d1
            kotlin.g.b.k.a()
        L_0x01d1:
            int r13 = r13.intValue()
            net.one97.travelpass.model.PassData r12 = net.one97.travelpass.e.h.a(r11, r12, r13)
            if (r12 == 0) goto L_0x01e6
            java.util.List r12 = r12.getInternalOffers()
            java.util.ArrayList r12 = net.one97.travelpass.e.h.b((net.one97.travelpass.model.TravelPass) r11, (java.util.List<java.lang.String>) r12)
            r7 = r12
            java.util.List r7 = (java.util.List) r7
        L_0x01e6:
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.util.ArrayList r7 = net.one97.travelpass.e.h.e(r7)
        L_0x01ec:
            r5.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r7)
            java.util.ArrayList r12 = r5.a()
            java.util.Collection r12 = (java.util.Collection) r12
            if (r12 == 0) goto L_0x0200
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x01fe
            goto L_0x0200
        L_0x01fe:
            r12 = 0
            goto L_0x0201
        L_0x0200:
            r12 = 1
        L_0x0201:
            if (r12 != 0) goto L_0x022f
            java.util.ArrayList r12 = r6.a()
            java.util.Collection r12 = (java.util.Collection) r12
            if (r12 == 0) goto L_0x0214
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x0212
            goto L_0x0214
        L_0x0212:
            r12 = 0
            goto L_0x0215
        L_0x0214:
            r12 = 1
        L_0x0215:
            if (r12 == 0) goto L_0x022c
            if (r11 == 0) goto L_0x0229
            net.one97.travelpass.model.TravelPassData r12 = r11.getBody()
            if (r12 == 0) goto L_0x0229
            net.one97.travelpass.model.TravelPassMetaData r12 = r12.getMetadata()
            if (r12 == 0) goto L_0x0229
            java.lang.String r2 = r12.getCardLevelPartnerOfferHeading()
        L_0x0229:
            r5.a((java.lang.String) r2)
        L_0x022c:
            r0.add(r5)
        L_0x022f:
            if (r1 == 0) goto L_0x0249
            java.lang.String r12 = r1.getHowToUseId()
            if (r12 == 0) goto L_0x0249
            java.lang.String r12 = r1.getHowToUseId()
            java.lang.String r13 = "selectedPassAtPosition.howToUseId"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            java.util.ArrayList r12 = net.one97.travelpass.e.h.c(r11, r12)
            java.util.Collection r12 = (java.util.Collection) r12
            r0.addAll(r12)
        L_0x0249:
            if (r1 == 0) goto L_0x027a
            java.lang.String r12 = r1.getFaqId()
            if (r12 == 0) goto L_0x027a
            java.lang.String r12 = r1.getFaqId()
            net.one97.travelpass.ui.c.j r13 = new net.one97.travelpass.ui.c.j
            r13.<init>()
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_FAQ
            r13.a((net.one97.travelpass.ui.b.b) r2)
            java.util.ArrayList r12 = net.one97.travelpass.e.h.d(r11, r12)
            r13.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r12)
            java.util.ArrayList r12 = r13.a()
            java.util.Collection r12 = (java.util.Collection) r12
            if (r12 == 0) goto L_0x0274
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x0275
        L_0x0274:
            r3 = 1
        L_0x0275:
            if (r3 != 0) goto L_0x027a
            r0.add(r13)
        L_0x027a:
            if (r1 == 0) goto L_0x02a0
            java.lang.String r12 = r1.getTncId()
            if (r12 == 0) goto L_0x02a0
            java.lang.String r12 = r1.getTncId()
            net.one97.travelpass.ui.c.j r13 = new net.one97.travelpass.ui.c.j
            r13.<init>()
            net.one97.travelpass.ui.b.b r1 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_TEAMS_CONDITIONS
            r13.a((net.one97.travelpass.ui.b.b) r1)
            com.paytm.network.model.IJRPaytmDataModel r11 = net.one97.travelpass.e.h.e(r11, r12)
            r13.a((com.paytm.network.model.IJRPaytmDataModel) r11)
            com.paytm.network.model.IJRPaytmDataModel r11 = r13.b()
            if (r11 == 0) goto L_0x02a0
            r0.add(r13)
        L_0x02a0:
            r10.f30739h = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.i.a(net.one97.travelpass.model.TravelPass, java.lang.String, int):void");
    }

    public static final /* synthetic */ void b(i iVar) {
        net.one97.travelpass.ui.c.j jVar = iVar.l;
        String str = null;
        IJRPaytmDataModel b2 = jVar != null ? jVar.b() : null;
        if (!(b2 instanceof PassData)) {
            b2 = null;
        }
        PassData passData = (PassData) b2;
        if (!(iVar.getContext() == null || passData == null)) {
            b.a aVar = net.one97.travelpass.e.b.f30322a;
            Context context = iVar.getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            String category = passData.getCategory();
            k.a((Object) category, "passDataObj.category");
            String valueOf = String.valueOf(passData.getPrice());
            k.c(context, "context");
            k.c(category, "passCategory");
            k.c(valueOf, "passPrice");
            b.a.a(context, net.one97.travelpass.e.b.j, net.one97.travelpass.e.b.r, category, (String) null, (String) null, valueOf, net.one97.travelpass.e.b.f30326e, (String) null, 304);
        }
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putSerializable("pass-data", passData);
        TravelPass travelPass = iVar.f30733b;
        if (passData != null) {
            str = passData.getTncId();
        }
        bundle.putSerializable("pass_tnc", net.one97.travelpass.e.h.e(travelPass, str));
        dVar.setArguments(bundle);
        FragmentActivity activity = iVar.getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        dVar.show(activity.getSupportFragmentManager(), dVar.getTag());
    }

    public static final /* synthetic */ void a(i iVar, boolean z, TravelPassSubscribeResponse travelPassSubscribeResponse) {
        Integer num;
        TravelPass travelPass = iVar.f30733b;
        if (travelPass != null && (num = iVar.f30735d) != null && travelPass != null && num != null && iVar.f30734c != null) {
            if (travelPass == null) {
                k.a();
            }
            Integer num2 = iVar.f30735d;
            if (num2 == null) {
                k.a();
            }
            int intValue = num2.intValue();
            String str = iVar.f30734c;
            if (str == null) {
                k.a();
            }
            k.c(travelPass, "travelPass");
            k.c(str, "verticalType");
            k.c(travelPassSubscribeResponse, "subscriptionResponse");
            VerticalPassesData a2 = net.one97.travelpass.e.h.a(str, travelPass);
            String str2 = null;
            List<PassData> verticalPassesData = a2 != null ? a2.getVerticalPassesData() : null;
            if (verticalPassesData != null && intValue <= verticalPassesData.size()) {
                PassData passData = verticalPassesData.get(intValue);
                k.a((Object) passData, "selectedPass");
                passData.setSubscribed(z);
                TravelPassSubscribeResponse.NotifyMeResponse body = travelPassSubscribeResponse.getBody();
                passData.setSubscriptionButtonLabel(body != null ? body.getSubscriptionButtonLabel() : null);
                TravelPassSubscribeResponse.NotifyMeResponse body2 = travelPassSubscribeResponse.getBody();
                if (body2 != null) {
                    str2 = body2.getSubscriptionText();
                }
                passData.setSubscriptionText(str2);
            }
            iVar.f30733b = travelPass;
        }
    }
}

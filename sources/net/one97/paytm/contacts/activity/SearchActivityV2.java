package net.one97.paytm.contacts.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.g.b.x;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.base.BaseActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.p2p.DestinationPayment;
import net.one97.paytm.common.entity.p2p.ExtraData;
import net.one97.paytm.common.entity.p2p.GlobalError;
import net.one97.paytm.common.entity.p2p.MerchantInfo;
import net.one97.paytm.common.entity.p2p.PPBLLimits;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.p2p.PaymentOptionItem;
import net.one97.paytm.common.entity.p2p.ReceiverInfo;
import net.one97.paytm.common.entity.p2p.SenderDisplayInformation;
import net.one97.paytm.common.entity.p2p.SenderInfo;
import net.one97.paytm.common.entity.p2p.SourcePayment;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.RecentScan;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.entities.beans.MTTopViewBean;
import net.one97.paytm.contacts.entities.beans.P2MRecentScan;
import net.one97.paytm.contacts.entities.beans.P2PRecentSendMoney;
import net.one97.paytm.contacts.entities.beans.VPADetails;
import net.one97.paytm.contacts.sync.ContactSyncLifeObserver;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.ValidateVpaResponse;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.requestmoney.b.a.a;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.utils.ae;
import net.one97.paytm.utils.af;
import net.one97.paytm.utils.x;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.newdesign.activity.PaySendInfoActivity;
import net.one97.paytm.wallet.newdesign.universalp2p.c.a;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;
import org.json.JSONException;
import org.json.JSONObject;

public final class SearchActivityV2 extends BaseActivity implements net.one97.paytm.contacts.e {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.contacts.a.a f50032a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.contacts.a.c f50033b;

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.contacts.a.b f50034c;

    /* renamed from: e  reason: collision with root package name */
    int f50035e = e.C0905e.PAY.getType();

    /* renamed from: f  reason: collision with root package name */
    private boolean f50036f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f50037g;

    /* renamed from: h  reason: collision with root package name */
    private final int f50038h = 1;

    /* renamed from: i  reason: collision with root package name */
    private final int f50039i = 100;
    private boolean j;
    private TextWatcher k;
    private boolean l;
    private final int m = H5ErrorCode.HTTP_NOT_IMPLEMENTED;
    private boolean n = true;
    private HashMap o;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this.o == null) {
            this.o = new HashMap();
        }
        View view = (View) this.o.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.o.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b<T> implements z<net.one97.paytm.network.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchActivityV2 f50041a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f50042b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f50043c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f50044d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ContactDetail f50045e;

        b(SearchActivityV2 searchActivityV2, String str, boolean z, String str2, ContactDetail contactDetail) {
            this.f50041a = searchActivityV2;
            this.f50042b = str;
            this.f50043c = z;
            this.f50044d = str2;
            this.f50045e = contactDetail;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.network.f fVar = (net.one97.paytm.network.f) obj;
            IJRPaytmDataModel iJRPaytmDataModel = null;
            if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
                LinearLayout linearLayout = (LinearLayout) this.f50041a._$_findCachedViewById(R.id.proceedBtn);
                kotlin.g.b.k.a((Object) linearLayout, "proceedBtn");
                linearLayout.setClickable(false);
                this.f50041a.g(false);
                if (fVar.f55797b != null && (fVar.f55797b instanceof PaymentCombinationAPIResponse)) {
                    PaymentCombinationAPIResponse paymentCombinationAPIResponse = (PaymentCombinationAPIResponse) fVar.f55797b;
                    if (paymentCombinationAPIResponse.getCategory() != null && p.a(paymentCombinationAPIResponse.getCategory(), "P2P", true)) {
                        if (this.f50041a.f50035e == e.C0905e.PAY.getType()) {
                            this.f50041a.c().b("");
                        } else {
                            this.f50041a.b().a((ContactDetail) null);
                        }
                        this.f50041a.a((IJRDataModel) fVar.f55797b);
                    } else if (p.a(((PaymentCombinationAPIResponse) fVar.f55797b).getCategory(), "P2M", true)) {
                        SearchActivityV2 searchActivityV2 = this.f50041a;
                        Activity activity = searchActivityV2;
                        if (fVar != null) {
                            iJRPaytmDataModel = fVar.f55797b;
                        }
                        SearchActivityV2.a(searchActivityV2, activity, (PaymentCombinationAPIResponse) iJRPaytmDataModel, this.f50042b);
                        net.one97.paytm.wallet.utility.a.a aVar = net.one97.paytm.wallet.utility.a.a.f72261c;
                        net.one97.paytm.wallet.utility.a.a.d();
                    }
                }
            } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR && fVar.f55798c != null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f50041a._$_findCachedViewById(R.id.proceedBtn);
                kotlin.g.b.k.a((Object) linearLayout2, "proceedBtn");
                linearLayout2.setClickable(true);
                this.f50041a.g(false);
                if (this.f50041a.f50035e == e.C0905e.PAY.getType()) {
                    this.f50041a.c().b("");
                } else {
                    this.f50041a.b().a((ContactDetail) null);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("key_is_from_fragment", false);
                ae aeVar = ae.f69602a;
                if (ae.a(fVar.f55798c.f55799a)) {
                    ae aeVar2 = ae.f69602a;
                    SearchActivityV2 searchActivityV22 = this.f50041a;
                    if (searchActivityV22 != null) {
                        ae.a(searchActivityV22, fVar.f55798c.f55799a, new NetworkCustomError(), bundle, "generic_api_call_fail");
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.app.Activity");
                } else if (this.f50043c) {
                    SearchActivityV2 searchActivityV23 = this.f50041a;
                    SearchActivityV2.a(searchActivityV23, com.paytm.utility.b.j((Context) searchActivityV23), com.paytm.utility.b.l((Context) this.f50041a), this.f50044d, this.f50042b);
                } else {
                    SearchActivityV2 searchActivityV24 = this.f50041a;
                    ContactDetail contactDetail = this.f50045e;
                    if (contactDetail == null) {
                        kotlin.g.b.k.a();
                    }
                    searchActivityV24.a((IJRDataModel) contactDetail);
                }
            } else if (fVar.f55796a == net.one97.paytm.network.h.CANCELLED) {
                LinearLayout linearLayout3 = (LinearLayout) this.f50041a._$_findCachedViewById(R.id.proceedBtn);
                kotlin.g.b.k.a((Object) linearLayout3, "proceedBtn");
                linearLayout3.setClickable(true);
                this.f50041a.g(false);
                if (this.f50041a.f50035e == e.C0905e.PAY.getType()) {
                    this.f50041a.c().b("");
                } else {
                    this.f50041a.b().a((ContactDetail) null);
                }
            }
        }
    }

    static final class i<T> implements z<LinkedHashSet<IJRDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.d f50054a;

        i(x.d dVar) {
            this.f50054a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f50054a.a(new ArrayList((LinkedHashSet) obj));
        }
    }

    static final class j<T> implements z<LinkedHashSet<IJRDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.d f50055a;

        j(x.d dVar) {
            this.f50055a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f50055a.a(new ArrayList((LinkedHashSet) obj));
        }
    }

    public final net.one97.paytm.contacts.a.a b() {
        net.one97.paytm.contacts.a.a aVar = this.f50032a;
        if (aVar == null) {
            kotlin.g.b.k.a("mAdapter");
        }
        return aVar;
    }

    public final net.one97.paytm.contacts.a.b c() {
        net.one97.paytm.contacts.a.b bVar = this.f50034c;
        if (bVar == null) {
            kotlin.g.b.k.a("mContactPayAdatper");
        }
        return bVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lyt_search_activity_v2);
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            kotlin.g.b.k.a((Object) window, "window");
            View decorView = window.getDecorView();
            kotlin.g.b.k.a((Object) decorView, "view");
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            Window window2 = getWindow();
            kotlin.g.b.k.a((Object) window2, "window");
            window2.setStatusBarColor(-1);
        }
        ((EditText) _$_findCachedViewById(R.id.searchViewEdt1)).requestFocus();
        getWindow().setSoftInputMode(4);
        Intent intent = getIntent();
        if (intent != null) {
            Intent intent2 = getIntent();
            net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
            this.f50035e = intent2.getIntExtra(net.one97.paytm.contacts.utils.e.h(), e.C0905e.PAY.getType());
            this.f50036f = intent.getBooleanExtra("syncData", false);
            this.l = intent.getBooleanExtra("isFromViewAll", false);
        }
        if (this.f50035e == e.C0905e.MONEY_TRANSFER_VIEW_ALL.getType() || this.f50035e == e.C0905e.MONEY_TRANSFER.getType()) {
            getLifecycle().a(new ContactSyncLifeObserver());
        }
        if (this.f50035e == e.C0905e.PAY.getType()) {
            this.f50034c = new net.one97.paytm.contacts.a.b(this, this, this.f50035e);
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_search_list);
            kotlin.g.b.k.a((Object) recyclerView, "rv_search_list");
            net.one97.paytm.contacts.a.b bVar = this.f50034c;
            if (bVar == null) {
                kotlin.g.b.k.a("mContactPayAdatper");
            }
            recyclerView.setAdapter(bVar);
        } else {
            this.f50032a = new net.one97.paytm.contacts.a.a(this, this, this.f50035e);
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.rv_search_list);
            kotlin.g.b.k.a((Object) recyclerView2, "rv_search_list");
            net.one97.paytm.contacts.a.a aVar = this.f50032a;
            if (aVar == null) {
                kotlin.g.b.k.a("mAdapter");
            }
            recyclerView2.setAdapter(aVar);
        }
        net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
        String p = net.one97.paytm.contacts.utils.e.p();
        net.one97.paytm.contacts.utils.e eVar3 = net.one97.paytm.contacts.utils.e.f50261a;
        String b2 = net.one97.paytm.contacts.utils.e.b(this.f50035e);
        Context context = this;
        net.one97.paytm.contacts.utils.e eVar4 = net.one97.paytm.contacts.utils.e.f50261a;
        sendGATags(p, "mt_p2p_to_mob_no_screen_loaded", b2, "", context, net.one97.paytm.contacts.utils.e.q());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(R.id.rv_search_list);
        kotlin.g.b.k.a((Object) recyclerView3, "rv_search_list");
        recyclerView3.setLayoutManager(linearLayoutManager);
        if (this.l || this.f50035e == e.C0905e.CONTACT_ONLY_WITH_RESULT.getType()) {
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.toolBarContainer);
            kotlin.g.b.k.a((Object) relativeLayout, "toolBarContainer");
            af.a((View) relativeLayout, true);
        }
        ((AppCompatImageView) _$_findCachedViewById(R.id.clearImv1)).setOnClickListener(new d(this));
        ((ImageView) _$_findCachedViewById(R.id.backImv)).setOnClickListener(new e(this));
        this.k = new h(this);
        ((EditText) _$_findCachedViewById(R.id.searchViewEdt1)).setOnClickListener(new f(this));
        EditText editText = (EditText) _$_findCachedViewById(R.id.searchViewEdt1);
        TextWatcher textWatcher = this.k;
        if (textWatcher == null) {
            kotlin.g.b.k.a("mSmallSearchEdt");
        }
        editText.addTextChangedListener(textWatcher);
        ((LinearLayout) _$_findCachedViewById(R.id.proceedBtn)).setOnClickListener(new g(this));
        d();
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchActivityV2 f50048a;

        d(SearchActivityV2 searchActivityV2) {
            this.f50048a = searchActivityV2;
        }

        public final void onClick(View view) {
            ((EditText) this.f50048a._$_findCachedViewById(R.id.searchViewEdt1)).setText("");
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchActivityV2 f50049a;

        e(SearchActivityV2 searchActivityV2) {
            this.f50049a = searchActivityV2;
        }

        public final void onClick(View view) {
            SearchActivityV2 searchActivityV2 = this.f50049a;
            net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
            net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
            searchActivityV2.sendGATags(net.one97.paytm.contacts.utils.e.p(), "back_button_clicked", "", "", this.f50049a, net.one97.paytm.contacts.utils.e.q());
            SearchActivityV2.a(this.f50049a);
            this.f50049a.onBackPressed();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchActivityV2 f50050a;

        f(SearchActivityV2 searchActivityV2) {
            this.f50050a = searchActivityV2;
        }

        public final void onClick(View view) {
            SearchActivityV2 searchActivityV2 = this.f50050a;
            net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
            net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
            searchActivityV2.sendGATags(net.one97.paytm.contacts.utils.e.p(), CJRGTMConstants.MT_V4_SEARCH_CLICKED, "", "", this.f50050a, net.one97.paytm.contacts.utils.e.q());
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchActivityV2 f50051a;

        g(SearchActivityV2 searchActivityV2) {
            this.f50051a = searchActivityV2;
        }

        public final void onClick(View view) {
            this.f50051a.f();
        }
    }

    private final void d() {
        net.one97.paytm.common.widgets.a.a((LottieAnimationView) _$_findCachedViewById(R.id.loader));
        x.e eVar = new x.e();
        eVar.element = this;
        a((x.d) new c(this, eVar));
    }

    public static final class c implements x.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchActivityV2 f50046a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f50047b;

        c(SearchActivityV2 searchActivityV2, x.e eVar) {
            this.f50046a = searchActivityV2;
            this.f50047b = eVar;
        }

        public final void a(ArrayList<IJRDataModel> arrayList) {
            kotlin.g.b.k.c(arrayList, "contactList");
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f50046a._$_findCachedViewById(R.id.loader));
            if (this.f50046a.f50035e != e.C0905e.PAY.getType()) {
                if (this.f50046a.f50035e == e.C0905e.CONTACT_ONLY_WITH_RESULT.getType()) {
                    arrayList.addAll(0, SearchActivityV2.e(net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM((SearchActivityV2) this.f50047b.element, "is_pay_mt_icon_visible", true)));
                } else if (this.f50046a.b() != null) {
                    if (this.f50046a.f50035e == e.C0905e.MONEY_TRANSFER_VIEW_ALL.getType()) {
                        arrayList.addAll(0, SearchActivityV2.e(true));
                    } else {
                        arrayList.addAll(0, SearchActivityV2.e(net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM((SearchActivityV2) this.f50047b.element, "is_mt_icon_visible", true)));
                    }
                }
                net.one97.paytm.contacts.a.a b2 = this.f50046a.b();
                kotlin.g.b.k.c(arrayList, "list");
                b2.f49937b.clear();
                b2.f49936a.clear();
                Collection collection = arrayList;
                b2.f49937b.addAll(collection);
                b2.f49936a.addAll(collection);
                this.f50046a.b().notifyDataSetChanged();
            } else if (this.f50046a.c() != null) {
                arrayList.addAll(0, SearchActivityV2.e(net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM((SearchActivityV2) this.f50047b.element, "is_pay_mt_icon_visible", true)));
                net.one97.paytm.contacts.a.b c2 = this.f50046a.c();
                kotlin.g.b.k.c(arrayList, "list");
                c2.f49978b.clear();
                c2.f49977a.clear();
                Collection collection2 = arrayList;
                c2.f49978b.addAll(collection2);
                c2.f49977a.addAll(collection2);
                this.f50046a.c().notifyDataSetChanged();
            }
            SearchActivityV2 searchActivityV2 = this.f50046a;
            Context context = searchActivityV2;
            List<String> n = net.one97.paytm.wallet.utility.a.n(context);
            searchActivityV2.f50033b = new net.one97.paytm.contacts.a.c(context, searchActivityV2);
            RecyclerView recyclerView = (RecyclerView) searchActivityV2._$_findCachedViewById(R.id.upiTagRv);
            kotlin.g.b.k.a((Object) recyclerView, "upiTagRv");
            net.one97.paytm.contacts.a.c cVar = searchActivityV2.f50033b;
            if (cVar == null) {
                kotlin.g.b.k.a("mVPASuggestionAdapter");
            }
            recyclerView.setAdapter(cVar);
            RecyclerView recyclerView2 = (RecyclerView) searchActivityV2._$_findCachedViewById(R.id.upiTagRv);
            kotlin.g.b.k.a((Object) recyclerView2, "upiTagRv");
            recyclerView2.setLayoutManager(new LinearLayoutManager(context, 0, false));
            net.one97.paytm.contacts.a.c cVar2 = searchActivityV2.f50033b;
            if (cVar2 == null) {
                kotlin.g.b.k.a("mVPASuggestionAdapter");
            }
            kotlin.g.b.k.a((Object) n, "vpaTags");
            kotlin.g.b.k.c(n, "list");
            Collection collection3 = n;
            cVar2.f50025b.addAll(collection3);
            cVar2.f50024a.addAll(collection3);
            cVar2.notifyDataSetChanged();
        }
    }

    private final void a(x.d dVar) {
        if (this.f50036f) {
            net.one97.paytm.contacts.utils.c.f50249c.a((Context) this, this.f50035e, e.b.BEN_PHONE_TYPE.getType(), this.f50035e != e.C0905e.PAY.getType() ? new Integer[]{Integer.valueOf(e.g.PHONEBOOK.getType()), Integer.valueOf(e.g.TRANSFER_BEN.getType()), Integer.valueOf(e.g.PHONE_BOOK_SERVER_SYNC.getType())} : new Integer[]{Integer.valueOf(e.g.PHONEBOOK.getType()), Integer.valueOf(e.g.PHONE_BOOK_SERVER_SYNC.getType())}).observe(this, new i(dVar));
        } else if (this.j) {
            net.one97.paytm.contacts.utils.c.f50249c.a((Context) this, this.f50035e, e.b.BEN_PHONE_TYPE.getType(), new Integer[]{Integer.valueOf(e.g.PHONEBOOK.getType()), Integer.valueOf(e.g.PHONE_BOOK_SERVER_SYNC.getType())}).observe(this, new j(dVar));
            this.j = true;
        } else {
            net.one97.paytm.contacts.utils.a aVar = net.one97.paytm.contacts.utils.a.f50219b;
            net.one97.paytm.contacts.utils.a.a((Activity) this, dVar, this.f50035e);
        }
    }

    private final void f(boolean z) {
        if (Build.VERSION.SDK_INT >= 23 && androidx.core.content.b.a((Context) this, "android.permission.READ_CONTACTS") != 0) {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, this.f50038h);
        } else if (z) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.goToSettingTv);
            kotlin.g.b.k.a((Object) textView, "goToSettingTv");
            af.a((View) textView, false);
            net.one97.paytm.common.widgets.a.a((LottieAnimationView) _$_findCachedViewById(R.id.loader));
            this.j = true;
            d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f4, code lost:
        if ((r0 == null || r0.isEmpty()) != false) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0122, code lost:
        if ((r0 == null || r0.isEmpty()) != false) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0179, code lost:
        if ((r0.f49937b.get(0) instanceof net.one97.paytm.contacts.entities.beans.MTTopViewBean) != false) goto L_0x017b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onRequestPermissionsResult(int r10, java.lang.String[] r11, int[] r12) {
        /*
            r9 = this;
            java.lang.String r0 = "permissions"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r0 = "grantResults"
            kotlin.g.b.k.c(r12, r0)
            int r0 = r9.f50038h
            if (r10 != r0) goto L_0x021b
            boolean r0 = com.paytm.utility.s.a((int[]) r12)
            r1 = 1
            if (r0 == 0) goto L_0x003a
            net.one97.paytm.contacts.utils.e r0 = net.one97.paytm.contacts.utils.e.f50261a
            java.lang.String r3 = net.one97.paytm.contacts.utils.e.p()
            r7 = r9
            android.content.Context r7 = (android.content.Context) r7
            net.one97.paytm.contacts.utils.e r0 = net.one97.paytm.contacts.utils.e.f50261a
            java.lang.String r8 = net.one97.paytm.contacts.utils.e.q()
            java.lang.String r4 = "allow_contact_access_clicked"
            java.lang.String r5 = "permission_granted"
            java.lang.String r6 = ""
            r2 = r9
            r2.sendGATags(r3, r4, r5, r6, r7, r8)
            r9.f(r1)
            boolean r0 = r9.f50037g
            if (r0 == 0) goto L_0x021b
            r9.e()
            goto L_0x021b
        L_0x003a:
            net.one97.paytm.contacts.utils.e r0 = net.one97.paytm.contacts.utils.e.f50261a
            java.lang.String r3 = net.one97.paytm.contacts.utils.e.p()
            r7 = r9
            android.content.Context r7 = (android.content.Context) r7
            net.one97.paytm.contacts.utils.e r0 = net.one97.paytm.contacts.utils.e.f50261a
            java.lang.String r8 = net.one97.paytm.contacts.utils.e.q()
            java.lang.String r4 = "allow_contact_access_clicked"
            java.lang.String r5 = "permission_denied"
            java.lang.String r6 = ""
            r2 = r9
            r2.sendGATags(r3, r4, r5, r6, r7, r8)
            r0 = r9
            android.app.Activity r0 = (android.app.Activity) r0
            java.lang.String r2 = "android.permission.READ_CONTACTS"
            boolean r0 = androidx.core.app.a.a((android.app.Activity) r0, (java.lang.String) r2)
            java.lang.String r2 = "mContactPayAdatper"
            java.lang.String r3 = "mAdapter"
            if (r0 != 0) goto L_0x00c9
            int r0 = r9.f50035e
            net.one97.paytm.contacts.utils.e$e r4 = net.one97.paytm.contacts.utils.e.C0905e.PAY
            int r4 = r4.getType()
            if (r0 != r4) goto L_0x009b
            net.one97.paytm.contacts.a.b r0 = r9.f50034c
            if (r0 != 0) goto L_0x0073
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0073:
            if (r0 == 0) goto L_0x00c9
            net.one97.paytm.contacts.a.b r0 = r9.f50034c
            if (r0 != 0) goto L_0x007c
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x007c:
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r4 = r0.f49977a
            java.util.Iterator r4 = r4.iterator()
        L_0x0082:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00c9
            java.lang.Object r5 = r4.next()
            net.one97.paytm.common.entity.IJRDataModel r5 = (net.one97.paytm.common.entity.IJRDataModel) r5
            boolean r6 = r5 instanceof net.one97.paytm.contacts.entities.beans.MTTopViewBean
            if (r6 == 0) goto L_0x0082
            net.one97.paytm.contacts.entities.beans.MTTopViewBean r5 = (net.one97.paytm.contacts.entities.beans.MTTopViewBean) r5
            r5.setShowSettingOption(r1)
            r0.notifyDataSetChanged()
            goto L_0x00c9
        L_0x009b:
            net.one97.paytm.contacts.a.a r0 = r9.f50032a
            if (r0 != 0) goto L_0x00a2
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00a2:
            if (r0 == 0) goto L_0x00c9
            net.one97.paytm.contacts.a.a r0 = r9.f50032a
            if (r0 != 0) goto L_0x00ab
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00ab:
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r4 = r0.f49936a
            java.util.Iterator r4 = r4.iterator()
        L_0x00b1:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00c9
            java.lang.Object r5 = r4.next()
            net.one97.paytm.common.entity.IJRDataModel r5 = (net.one97.paytm.common.entity.IJRDataModel) r5
            boolean r6 = r5 instanceof net.one97.paytm.contacts.entities.beans.MTTopViewBean
            if (r6 == 0) goto L_0x00b1
            net.one97.paytm.contacts.entities.beans.MTTopViewBean r5 = (net.one97.paytm.contacts.entities.beans.MTTopViewBean) r5
            r5.setShowSettingOption(r1)
            r0.notifyDataSetChanged()
        L_0x00c9:
            int r0 = r9.f50035e
            net.one97.paytm.contacts.utils.e$e r4 = net.one97.paytm.contacts.utils.e.C0905e.PAY
            int r4 = r4.getType()
            r5 = 0
            if (r0 != r4) goto L_0x00f8
            net.one97.paytm.contacts.a.b r0 = r9.f50034c
            if (r0 != 0) goto L_0x00db
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00db:
            if (r0 == 0) goto L_0x021b
            net.one97.paytm.contacts.a.b r0 = r9.f50034c
            if (r0 != 0) goto L_0x00e4
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00e4:
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r0 = r0.f49978b
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x00f3
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00f1
            goto L_0x00f3
        L_0x00f1:
            r0 = 0
            goto L_0x00f4
        L_0x00f3:
            r0 = 1
        L_0x00f4:
            if (r0 == 0) goto L_0x021b
            goto L_0x017b
        L_0x00f8:
            int r0 = r9.f50035e
            net.one97.paytm.contacts.utils.e$e r2 = net.one97.paytm.contacts.utils.e.C0905e.MONEY_TRANSFER
            int r2 = r2.getType()
            if (r0 != r2) goto L_0x0125
            net.one97.paytm.contacts.a.a r0 = r9.f50032a
            if (r0 != 0) goto L_0x0109
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0109:
            if (r0 == 0) goto L_0x021b
            net.one97.paytm.contacts.a.a r0 = r9.f50032a
            if (r0 != 0) goto L_0x0112
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0112:
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r0 = r0.f49937b
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x0121
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x011f
            goto L_0x0121
        L_0x011f:
            r0 = 0
            goto L_0x0122
        L_0x0121:
            r0 = 1
        L_0x0122:
            if (r0 == 0) goto L_0x021b
            goto L_0x017b
        L_0x0125:
            int r0 = r9.f50035e
            net.one97.paytm.contacts.utils.e$e r2 = net.one97.paytm.contacts.utils.e.C0905e.MONEY_TRANSFER_VIEW_ALL
            int r2 = r2.getType()
            if (r0 != r2) goto L_0x021b
            net.one97.paytm.contacts.a.a r0 = r9.f50032a
            if (r0 != 0) goto L_0x0136
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0136:
            if (r0 == 0) goto L_0x021b
            net.one97.paytm.contacts.a.a r0 = r9.f50032a
            if (r0 != 0) goto L_0x013f
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x013f:
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r0 = r0.f49937b
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x014e
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x014c
            goto L_0x014e
        L_0x014c:
            r0 = 0
            goto L_0x014f
        L_0x014e:
            r0 = 1
        L_0x014f:
            if (r0 != 0) goto L_0x017b
            net.one97.paytm.contacts.a.a r0 = r9.f50032a
            if (r0 != 0) goto L_0x0158
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0158:
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r0 = r0.f49937b
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x0167
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0165
            goto L_0x0167
        L_0x0165:
            r0 = 0
            goto L_0x0168
        L_0x0167:
            r0 = 1
        L_0x0168:
            if (r0 != 0) goto L_0x021b
            net.one97.paytm.contacts.a.a r0 = r9.f50032a
            if (r0 != 0) goto L_0x0171
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0171:
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r0 = r0.f49937b
            java.lang.Object r0 = r0.get(r5)
            boolean r0 = r0 instanceof net.one97.paytm.contacts.entities.beans.MTTopViewBean
            if (r0 == 0) goto L_0x021b
        L_0x017b:
            int r0 = net.one97.paytm.wallet.R.string.contacts_go_to_settings
            java.lang.String r0 = r9.getString(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r3 = net.one97.paytm.wallet.R.string.settings
            java.lang.String r3 = r9.getString(r3)
            r2.append(r3)
            java.lang.String r3 = "."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r0 = 32
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 6
            int r2 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.String) r2, (int) r5, (boolean) r5, (int) r4)
            int r0 = r0.length()
            int r4 = net.one97.paytm.wallet.R.id.goToSettingTv
            android.view.View r4 = r9._$_findCachedViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r6 = "goToSettingTv"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            android.text.SpannableString r7 = new android.text.SpannableString
            r7.<init>(r3)
            net.one97.paytm.contacts.activity.SearchActivityV2$a r3 = new net.one97.paytm.contacts.activity.SearchActivityV2$a
            r3.<init>(r9)
            r8 = 33
            r7.setSpan(r3, r2, r0, r8)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r4.setText(r7)
            int r0 = net.one97.paytm.wallet.R.id.goToSettingTv
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r0.setClickable(r1)
            int r0 = net.one97.paytm.wallet.R.id.goToSettingTv
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.text.method.MovementMethod r2 = android.text.method.LinkMovementMethod.getInstance()
            r0.setMovementMethod(r2)
            int r0 = net.one97.paytm.wallet.R.id.goToSettingTv
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.utils.af.a((android.view.View) r0, (boolean) r5)
            int r0 = net.one97.paytm.wallet.R.id.proceedBtn
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r2 = "proceedBtn"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.utils.af.a((android.view.View) r0, (boolean) r1)
        L_0x021b:
            super.onRequestPermissionsResult(r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.contacts.activity.SearchActivityV2.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    private final void e() {
        this.f50037g = false;
        WalletSharedPrefs.setContactSyncConcentAsked();
        if (com.paytm.utility.b.c((Context) this)) {
            net.one97.paytm.contacts.c.a aVar = net.one97.paytm.contacts.c.a.f50123a;
            net.one97.paytm.contacts.c.a.a();
        }
    }

    public static final class a extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchActivityV2 f50040a;

        a(SearchActivityV2 searchActivityV2) {
            this.f50040a = searchActivityV2;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "widget");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.f50040a.getPackageName(), (String) null));
            this.f50040a.startActivityForResult(intent, 101);
        }

        public final void updateDrawState(TextPaint textPaint) {
            kotlin.g.b.k.c(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f50040a.getResources().getColor(R.color.color_00b9f5));
        }
    }

    /* access modifiers changed from: private */
    public final void f() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.proceedBtn);
        kotlin.g.b.k.a((Object) linearLayout, "proceedBtn");
        linearLayout.setClickable(false);
        g(true);
        net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
        a2.b("entered");
        a2.a(a.e.CONATCT_SCREEN);
        a2.a(a.C1450a.CONTACT_PROCEED_CLICKED);
        a2.a(a.b.WAlLET_SEND_MONEY);
        Context context = this;
        a2.b(context);
        String g2 = g();
        kotlin.g.b.k.a((Object) a2, "universalP2PGAEventManager");
        a2.a(a.c.MOBILE_NUMBER_ENTERED);
        a2.a("no");
        String a3 = net.one97.paytm.wallet.utility.a.a(g2);
        CharSequence charSequence = g2;
        if (TextUtils.isEmpty(charSequence) || !net.one97.paytm.wallet.utility.a.y(g2)) {
            if (!TextUtils.isEmpty(a3)) {
                x.a aVar = net.one97.paytm.utils.x.f69805a;
                kotlin.g.b.k.a((Object) a3, "filterNumber");
                if (x.a.a(a3)) {
                    net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
                    String p = net.one97.paytm.contacts.utils.e.p();
                    String valueOf = String.valueOf(WalletSharedPrefs.isUPIOnboarded());
                    net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
                    sendGATags(p, "new_mob_upiid_enterd", valueOf, "", context, net.one97.paytm.contacts.utils.e.q());
                    a(a3, (String) null, true, (ContactDetail) null);
                    return;
                }
            }
            if (TextUtils.isEmpty(charSequence) || !net.one97.paytm.wallet.utility.a.y(g2)) {
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.proceedBtn);
                kotlin.g.b.k.a((Object) linearLayout2, "proceedBtn");
                linearLayout2.setClickable(false);
                g(false);
                String string = getString(R.string.money_transfer_enter_valid_mobile);
                kotlin.g.b.k.a((Object) string, "getString(R.string.money…nsfer_enter_valid_mobile)");
                a(string);
                return;
            }
            c(g2);
            return;
        }
        net.one97.paytm.contacts.utils.e eVar3 = net.one97.paytm.contacts.utils.e.f50261a;
        String p2 = net.one97.paytm.contacts.utils.e.p();
        String valueOf2 = String.valueOf(WalletSharedPrefs.isUPIOnboarded());
        net.one97.paytm.contacts.utils.e eVar4 = net.one97.paytm.contacts.utils.e.f50261a;
        sendGATags(p2, "new_mob_upiid_enterd", valueOf2, "", context, net.one97.paytm.contacts.utils.e.q());
        c(g2);
    }

    public final void a(IJRDataModel iJRDataModel) {
        kotlin.g.b.k.c(iJRDataModel, "data");
        net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
        Activity activity = this;
        int i2 = this.f50035e;
        net.one97.paytm.wallet.utility.d.a(activity, iJRDataModel, i2, this.m, i2 == e.C0905e.PAY.getType());
    }

    public final void a(String str, String str2, boolean z, ContactDetail contactDetail) {
        kotlin.g.b.k.c(str, "phoneNo");
        net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
        net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
        sendGATags(net.one97.paytm.contacts.utils.e.p(), CJRGTMConstants.MT_V4_CONTACT_CLICKED, "", "", this, net.one97.paytm.contacts.utils.e.q());
        if (this.f50035e == e.C0905e.CONTACT_ONLY_WITH_RESULT.getType()) {
            net.one97.paytm.contacts.a.a aVar = this.f50032a;
            if (aVar == null) {
                kotlin.g.b.k.a("mAdapter");
            }
            aVar.a((ContactDetail) null);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("contact", contactDetail);
            intent.putExtras(bundle);
            setResult(-1, intent);
            finish();
            return;
        }
        net.one97.paytm.wallet.utility.a.a aVar2 = net.one97.paytm.wallet.utility.a.a.f72261c;
        if (net.one97.paytm.wallet.utility.a.a.c() != null) {
            net.one97.paytm.wallet.utility.a.a aVar3 = net.one97.paytm.wallet.utility.a.a.f72261c;
            net.one97.paytm.network.a c2 = net.one97.paytm.wallet.utility.a.a.c();
            if (c2 != null) {
                c2.b();
            }
            net.one97.paytm.wallet.utility.a.a aVar4 = net.one97.paytm.wallet.utility.a.a.f72261c;
            net.one97.paytm.wallet.utility.a.a.d();
        }
        net.one97.paytm.wallet.utility.a.a.f72261c.a(this, str, "PHONE_NUMEBR", str2, this.f50035e == e.C0905e.PAY.getType()).observe(this, new b(this, str, z, str2, contactDetail));
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "msg");
        TextView textView = (TextView) _$_findCachedViewById(R.id.errorMsgTv1);
        kotlin.g.b.k.a((Object) textView, "errorMsgTv1");
        a(str, textView);
    }

    public final void b(boolean z) {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.proceedBtn);
        kotlin.g.b.k.a((Object) linearLayout, "proceedBtn");
        af.a((View) linearLayout, z);
    }

    public final void a(ContactDetail contactDetail) {
        kotlin.g.b.k.c(contactDetail, "contactDetail");
        net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
        String p = net.one97.paytm.contacts.utils.e.p();
        Context context = this;
        net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
        sendGATags(p, CJRGTMConstants.MT_V4_BENEFICIARY_CLICKED, "", "", context, net.one97.paytm.contacts.utils.e.q());
        if (TextUtils.isEmpty(contactDetail.getPrimaryPhoneNumber()) || TextUtils.isEmpty(net.one97.paytm.wallet.utility.a.a(contactDetail.getPrimaryPhoneNumber())) || net.one97.paytm.wallet.utility.a.a(contactDetail.getPrimaryPhoneNumber()).length() < 10) {
            a((IJRDataModel) contactDetail);
            return;
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.proceedBtn);
        kotlin.g.b.k.a((Object) linearLayout, "proceedBtn");
        linearLayout.setClickable(false);
        g(true);
        net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
        a2.b("entered");
        a2.a(a.e.CONATCT_SCREEN);
        a2.a(a.C1450a.CONTACT_PROCEED_CLICKED);
        a2.a(a.b.WAlLET_SEND_MONEY);
        a2.b(context);
        kotlin.g.b.k.a((Object) a2, "universalP2PGAEventManager");
        a2.a(a.c.MOBILE_NUMBER_ENTERED);
        a2.a("no");
        String a3 = net.one97.paytm.wallet.utility.a.a(contactDetail.getPrimaryPhoneNumber());
        kotlin.g.b.k.a((Object) a3, "filterNumber");
        a(a3, contactDetail.getContactName(), false, contactDetail);
    }

    public final void c(boolean z) {
        if (!z && this.f50033b != null) {
            net.one97.paytm.contacts.a.c cVar = this.f50033b;
            if (cVar == null) {
                kotlin.g.b.k.a("mVPASuggestionAdapter");
            }
            cVar.f50024a.clear();
            cVar.f50024a.addAll(cVar.f50025b);
            cVar.notifyDataSetChanged();
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.upiTagRv);
        kotlin.g.b.k.a((Object) recyclerView, "upiTagRv");
        af.a((View) recyclerView, z);
    }

    public final void b(String str) {
        int a2;
        kotlin.g.b.k.c(str, "vpaSuggestion");
        String g2 = g();
        CharSequence charSequence = g2;
        if (p.a(charSequence, (CharSequence) "@", false) && (a2 = p.a(charSequence, "@", 0, false, 6)) != -1) {
            int i2 = a2 + 1;
            if (g2 != null) {
                g2 = g2.substring(0, i2);
                kotlin.g.b.k.a((Object) g2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        EditText editText = (EditText) _$_findCachedViewById(R.id.searchViewEdt1);
        kotlin.g.b.k.a((Object) editText, "searchViewEdt1");
        editText.setText(kotlin.g.b.k.a(g2, (Object) str));
        editText.setSelection(editText.length());
        f();
    }

    public static final class k implements a.C1402a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchActivityV2 f50056a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f50057b;

        k(SearchActivityV2 searchActivityV2, String str) {
            this.f50056a = searchActivityV2;
            this.f50057b = str;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel instanceof ValidateVpaResponse) {
                LinearLayout linearLayout = (LinearLayout) this.f50056a._$_findCachedViewById(R.id.proceedBtn);
                kotlin.g.b.k.a((Object) linearLayout, "proceedBtn");
                linearLayout.setClickable(true);
                this.f50056a.g(false);
                ValidateVpaResponse validateVpaResponse = (ValidateVpaResponse) upiBaseDataModel;
                String respCode = validateVpaResponse.getRespCode();
                if (respCode == null) {
                    respCode = "";
                }
                if (p.a(validateVpaResponse.getStatus(), "success", true) && p.a("0", respCode, true)) {
                    String name = validateVpaResponse.getName();
                    if (name == null) {
                        name = "";
                    }
                    if (!TextUtils.isEmpty(name)) {
                        SearchActivityV2 searchActivityV2 = this.f50056a;
                        VPADetails vPADetails = new VPADetails(this.f50057b, name);
                        kotlin.g.b.k.c(vPADetails, "vpaDetails");
                        searchActivityV2.a((IJRDataModel) vPADetails);
                        return;
                    }
                    SearchActivityV2 searchActivityV22 = this.f50056a;
                    net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
                    searchActivityV22.a(net.one97.paytm.contacts.utils.e.a((Context) this.f50056a, respCode));
                } else if (p.a("1006", respCode, true)) {
                    SearchActivityV2.d(this.f50056a);
                } else {
                    SearchActivityV2 searchActivityV23 = this.f50056a;
                    net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
                    searchActivityV23.a(net.one97.paytm.contacts.utils.e.a((Context) this.f50056a, respCode));
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            LinearLayout linearLayout = (LinearLayout) this.f50056a._$_findCachedViewById(R.id.proceedBtn);
            kotlin.g.b.k.a((Object) linearLayout, "proceedBtn");
            linearLayout.setClickable(true);
            this.f50056a.g(false);
            SearchActivityV2 searchActivityV2 = this.f50056a;
            String string = searchActivityV2.getString(R.string.vpa_verify_failed);
            kotlin.g.b.k.a((Object) string, "getString(R.string.vpa_verify_failed)");
            searchActivityV2.a(string);
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", false);
            if (upiCustomVolleyError != null) {
                ae aeVar = ae.f69602a;
                String str = upiCustomVolleyError.getmErrorCode();
                kotlin.g.b.k.a((Object) str, "networkError.getmErrorCode()");
                if (ae.a(str)) {
                    ae aeVar2 = ae.f69602a;
                    ae.a((Activity) this, 401, new NetworkCustomError(), bundle, "generic_api_call_fail");
                }
            }
        }
    }

    private final void c(String str) {
        net.one97.paytm.upi.requestmoney.b.a.b.a.a((Context) this).b(new k(this, str), "vpaRequest", str, "", "Screen");
    }

    public final void onDestroy() {
        super.onDestroy();
        net.one97.paytm.upi.requestmoney.b.a.b.a.a((Context) this).a("vpaRequest");
    }

    public final void a(RecentScan recentScan) {
        kotlin.g.b.k.c(recentScan, "recentScan");
        try {
            JSONObject jSONObject = new JSONObject(recentScan.getScanResult());
            jSONObject.remove("ORDER_ID");
            if (!com.paytm.utility.b.r((Context) this)) {
                Intent intent = new Intent(this, PaySendInfoActivity.class);
                intent.putExtra("dest", "qr_send_money");
                intent.putExtra("qr_scan_result", jSONObject.toString());
                startActivity(intent);
                finish();
                return;
            }
            String uniqKey = recentScan.getUniqKey();
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.k.a((Object) jSONObject2, "scanResultJson.toString()");
            CJRQRScanResultModel cJRQRScanResultModel = new CJRQRScanResultModel();
            try {
                cJRQRScanResultModel.parseData(new JSONObject(jSONObject2), (Context) this);
            } catch (JSONException unused) {
            }
            if (p.a("QR_CODE_REQUEST_MONEY", cJRQRScanResultModel.getRequestType(), true)) {
                Intent intent2 = new Intent();
                intent2.putExtra("NAME", cJRQRScanResultModel.getName());
                intent2.putExtra("PHONE_NUMBER", cJRQRScanResultModel.getMobileNo());
                intent2.putExtra("MODE", "RECENT_SCAN");
                net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
                kotlin.g.b.k.a((Object) a2, "universalP2PGAEventManager");
                a2.a(a.c.QR_SCAN_PAYTM_P2P);
                a2.a(H5AppHandler.CHECK_VALUE);
                net.one97.paytm.wallet.utility.a.a(intent2, (Activity) this);
                finish();
            } else {
                Intent intent3 = new Intent(this, AJRQRActivity.class);
                intent3.putExtra("OPERATION", "scan");
                intent3.putExtra("scan_result", jSONObject2);
                intent3.putExtra("QR_CODE_ID", cJRQRScanResultModel.getQrCodeId());
                intent3.putExtra("qrScanTime", String.valueOf(System.currentTimeMillis()));
                intent3.putExtra("is_from_recent", true);
                startActivityForResult(intent3, this.m);
            }
            if (!TextUtils.isEmpty(uniqKey) && uniqKey.length() == 24) {
                kotlin.g.b.k.a((Object) net.one97.paytm.b.a.e.a(), "SingleAPIManager.getInstance()");
                if (net.one97.paytm.b.a.e.f()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("ssotoken", com.paytm.utility.d.a(this));
                    net.one97.paytm.b.a.e.a().a(this, (String) null, uniqKey, hashMap);
                    return;
                }
                net.one97.paytm.wallet.utility.a.d((Context) this, uniqKey);
            }
        } catch (Exception unused2) {
        }
    }

    public final void d(boolean z) {
        this.f50037g = z;
        f(false);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == this.f50039i) {
            ((LinearLayout) _$_findCachedViewById(R.id.proceedBtn)).performClick();
        }
        if (i2 == this.m) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.proceedBtn);
            kotlin.g.b.k.a((Object) linearLayout, "proceedBtn");
            linearLayout.setClickable(true);
            g(false);
            if (this.f50035e == e.C0905e.PAY.getType()) {
                net.one97.paytm.contacts.a.b bVar = this.f50034c;
                if (bVar == null) {
                    kotlin.g.b.k.a("mContactPayAdatper");
                }
                String g2 = g();
                kotlin.g.b.k.c(g2, "query");
                Iterator<IJRDataModel> it2 = bVar.f49978b.iterator();
                while (it2.hasNext()) {
                    IJRDataModel next = it2.next();
                    if (next instanceof ContactDetail) {
                        ContactDetail contactDetail = (ContactDetail) next;
                        if (contactDetail.isSelected()) {
                            contactDetail.setSelected(false);
                        }
                    } else if (next instanceof P2PRecentSendMoney) {
                        ((P2PRecentSendMoney) next).setSelected(false);
                    } else if (next instanceof P2MRecentScan) {
                        ((P2MRecentScan) next).setSelected(false);
                    }
                }
                bVar.f49977a.clear();
                bVar.f49977a.addAll(bVar.f49978b);
                if (TextUtils.isEmpty(g2)) {
                    bVar.notifyDataSetChanged();
                } else {
                    bVar.a(g2);
                }
            } else if (this.f50035e == e.C0905e.MONEY_TRANSFER.getType() || this.f50035e == e.C0905e.MONEY_TRANSFER_VIEW_ALL.getType()) {
                net.one97.paytm.contacts.a.a aVar = this.f50032a;
                if (aVar == null) {
                    kotlin.g.b.k.a("mAdapter");
                }
                String g3 = g();
                kotlin.g.b.k.c(g3, "query");
                Iterator<IJRDataModel> it3 = aVar.f49937b.iterator();
                while (it3.hasNext()) {
                    IJRDataModel next2 = it3.next();
                    if (next2 instanceof ContactDetail) {
                        ContactDetail contactDetail2 = (ContactDetail) next2;
                        if (contactDetail2.isSelected()) {
                            contactDetail2.setSelected(false);
                        }
                    }
                }
                aVar.f49936a.clear();
                aVar.f49936a.addAll(aVar.f49937b);
                if (TextUtils.isEmpty(g3)) {
                    aVar.notifyDataSetChanged();
                } else {
                    aVar.a(g3);
                }
            }
        }
        if (i2 != 101) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a((Context) this, "android.permission.READ_CONTACTS") == 0) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.goToSettingTv);
            kotlin.g.b.k.a((Object) textView, "goToSettingTv");
            af.a((View) textView, false);
            net.one97.paytm.common.widgets.a.a((LottieAnimationView) _$_findCachedViewById(R.id.loader));
            d();
            if (this.f50037g) {
                e();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void g(boolean z) {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) _$_findCachedViewById(R.id.proceedLoader);
        if (z) {
            net.one97.paytm.common.widgets.a.a(lottieAnimationView);
        } else {
            net.one97.paytm.common.widgets.a.b(lottieAnimationView);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.payTv);
        kotlin.g.b.k.a((Object) textView, "payTv");
        af.a((View) textView, !z);
    }

    public final void a() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
        startActivityForResult(intent, 101);
    }

    public final void onBackPressed() {
        super.onBackPressed();
        if (this.f50035e == e.C0905e.PAY.getType()) {
            overridePendingTransition(R.anim.do_not_move, R.anim.wallet_bottom_down);
        }
    }

    public final void a(int i2) {
        if (i2 == e.d.CONTACT_PERMISSION_ALLOW.getType()) {
            net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
            net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
            sendGATags(net.one97.paytm.contacts.utils.e.p(), CJRGTMConstants.MT_V4_CONTACT_PERMISSION_CLICKED, "", "", this, net.one97.paytm.contacts.utils.e.q());
        } else if (i2 == e.d.PRIVACY_ALLOW.getType()) {
            net.one97.paytm.contacts.utils.e eVar3 = net.one97.paytm.contacts.utils.e.f50261a;
            net.one97.paytm.contacts.utils.e eVar4 = net.one97.paytm.contacts.utils.e.f50261a;
            sendGATags(net.one97.paytm.contacts.utils.e.p(), CJRGTMConstants.MT_V4_CONTACT_TNC_CLICKED, "", "", this, net.one97.paytm.contacts.utils.e.q());
        }
    }

    public static final class h implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchActivityV2 f50052a;

        /* renamed from: b  reason: collision with root package name */
        private int f50053b;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        h(SearchActivityV2 searchActivityV2) {
            this.f50052a = searchActivityV2;
        }

        public final void afterTextChanged(Editable editable) {
            String str;
            String valueOf = String.valueOf(editable);
            if (valueOf != null) {
                String obj = p.b(valueOf).toString();
                if (!(obj.length() == this.f50053b + 1 || obj.length() == this.f50053b - 1)) {
                    x.a aVar = net.one97.paytm.utils.x.f69805a;
                    kotlin.g.b.k.c(obj, "pastedText");
                    if (!net.one97.paytm.wallet.utility.a.D(obj)) {
                        str = new l("[^0-9]+").replace((CharSequence) obj, "");
                        if (str.length() > 10) {
                            str = net.one97.paytm.wallet.utility.a.E(str);
                            if (str.length() == 12) {
                                kotlin.g.b.k.a((Object) str, "phoneNumberExcludedLeadingZeroes");
                                if (p.b(str, "91", false)) {
                                    str = str.substring(2);
                                    kotlin.g.b.k.a((Object) str, "(this as java.lang.String).substring(startIndex)");
                                }
                            }
                            kotlin.g.b.k.a((Object) str, "phoneNumberExcludedLeadingZeroes");
                        }
                    } else {
                        str = obj;
                    }
                    if (!kotlin.g.b.k.a((Object) str, (Object) obj)) {
                        CharSequence charSequence = str;
                        if (net.one97.paytm.wallet.d.l.a(charSequence)) {
                            ((EditText) this.f50052a._$_findCachedViewById(R.id.searchViewEdt1)).setText(charSequence);
                            ((EditText) this.f50052a._$_findCachedViewById(R.id.searchViewEdt1)).setSelection(str.length());
                            obj = str;
                        }
                    }
                }
                this.f50053b = obj.length();
                SearchActivityV2.a(this.f50052a, obj);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        }
    }

    private final String g() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.searchViewEdt1);
        kotlin.g.b.k.a((Object) editText, "searchViewEdt1");
        return editText.getText().toString();
    }

    private static void a(String str, TextView textView) {
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            textView.setText("");
        } else {
            textView.setText(charSequence);
        }
        af.a((View) textView, !TextUtils.isEmpty(charSequence));
    }

    public final void a(boolean z) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.errorMsgTv1);
        kotlin.g.b.k.a((Object) textView, "errorMsgTv1");
        af.a((View) textView, false);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.proceedBtn);
        kotlin.g.b.k.a((Object) linearLayout, "proceedBtn");
        af.a((View) linearLayout, z);
    }

    public static final /* synthetic */ void a(SearchActivityV2 searchActivityV2) {
        View currentFocus;
        Object systemService = searchActivityV2.getSystemService("input_method");
        if (systemService != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager.isActive() && (currentFocus = searchActivityV2.getCurrentFocus()) != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static final /* synthetic */ ArrayList e(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(new MTTopViewBean(false, false));
        }
        return arrayList;
    }

    public static final /* synthetic */ void a(SearchActivityV2 searchActivityV2, Activity activity, PaymentCombinationAPIResponse paymentCombinationAPIResponse, String str) {
        if (paymentCombinationAPIResponse.getMerchantInfo() != null) {
            Intent intent = new Intent(activity, AJRQRActivity.class);
            intent.putExtra("OPERATION", "contact");
            intent.putExtra("mobile", str);
            intent.putExtra("is_from_mobile_number", true);
            intent.putExtra("launchFrom", searchActivityV2.f50035e);
            intent.putExtra("paysend_result", paymentCombinationAPIResponse);
            activity.startActivityForResult(intent, searchActivityV2.m);
        }
    }

    public static final /* synthetic */ void a(SearchActivityV2 searchActivityV2, String str, String str2, String str3, String str4) {
        PaymentCombinationAPIResponse paymentCombinationAPIResponse = new PaymentCombinationAPIResponse((SenderInfo) null, (MerchantInfo) null, (ReceiverInfo) null, (List) null, (GlobalError) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (ExtraData) null, (Boolean) null, 4095, (kotlin.g.b.g) null);
        SenderInfo senderInfo = new SenderInfo((String) null, (String) null, (String) null, (String) null, 15, (kotlin.g.b.g) null);
        senderInfo.setName(str);
        senderInfo.setPhoneNumber(str2);
        paymentCombinationAPIResponse.setSenderInfo(senderInfo);
        ReceiverInfo receiverInfo = new ReceiverInfo((String) null, (String) null, (String) null, (String) null, (String) null, 31, (kotlin.g.b.g) null);
        receiverInfo.setName(str3);
        receiverInfo.setPhoneNumber(str4);
        paymentCombinationAPIResponse.setReceiverInfo(receiverInfo);
        paymentCombinationAPIResponse.setCategory("P2P");
        paymentCombinationAPIResponse.setStatus("SUCCESS");
        paymentCombinationAPIResponse.setRespCode("0000");
        paymentCombinationAPIResponse.setRespMessage("SUCCESS");
        PaymentOptionItem paymentOptionItem = new PaymentOptionItem((SourcePayment) null, (DestinationPayment) null, (String) null, (String) null, (String) null, (Integer) null, (PPBLLimits) null, (HashMap) null, (Integer) null, (String) null, (SenderDisplayInformation) null, (SenderDisplayInformation) null, (Integer) null, (Double) null, 16383, (kotlin.g.b.g) null);
        paymentOptionItem.setCombinationName("WALLET-WALLET");
        SourcePayment sourcePayment = new SourcePayment((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, 8191, (kotlin.g.b.g) null);
        sourcePayment.setPaymentType(SDKConstants.AI_KEY_WALLET);
        sourcePayment.setPaymentInstrumentStatus("ENABLED");
        DestinationPayment destinationPayment = new DestinationPayment((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (kotlin.g.b.g) null);
        destinationPayment.setPaymentType(SDKConstants.AI_KEY_WALLET);
        paymentOptionItem.setSourcePayment(sourcePayment);
        paymentOptionItem.setDestinationPayment(destinationPayment);
        ArrayList arrayList = new ArrayList();
        arrayList.add(paymentOptionItem);
        paymentCombinationAPIResponse.setPaymentOptionList(arrayList);
        ExtraData extraData = new ExtraData((String) null, (String) null, false, false, false, false, 63, (kotlin.g.b.g) null);
        if (!TextUtils.isEmpty((CharSequence) null)) {
            extraData.setAmount((String) null);
            extraData.setAmountEditable(false);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            extraData.setComment((String) null);
            extraData.setCommentEditable(false);
        }
        paymentCombinationAPIResponse.setExtraData(extraData);
        searchActivityV2.a((IJRDataModel) paymentCombinationAPIResponse);
    }

    public static final /* synthetic */ void d(SearchActivityV2 searchActivityV2) {
        Intent intent = new Intent(searchActivityV2, UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        intent.setFlags(536870912);
        searchActivityV2.startActivityForResult(intent, searchActivityV2.f50039i);
    }

    public static final /* synthetic */ void a(SearchActivityV2 searchActivityV2, String str) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) searchActivityV2._$_findCachedViewById(R.id.clearImv1);
        kotlin.g.b.k.a((Object) appCompatImageView, "clearImv1");
        CharSequence charSequence = str;
        boolean z = false;
        if (TextUtils.isEmpty(charSequence)) {
            af.a((View) appCompatImageView, false);
        } else {
            af.a((View) appCompatImageView, true);
        }
        if (searchActivityV2.f50035e == e.C0905e.PAY.getType()) {
            try {
                net.one97.paytm.contacts.a.b bVar = searchActivityV2.f50034c;
                if (bVar == null) {
                    kotlin.g.b.k.a("mContactPayAdatper");
                }
                if (bVar != null) {
                    LinearLayout linearLayout = (LinearLayout) searchActivityV2._$_findCachedViewById(R.id.proceedBtn);
                    kotlin.g.b.k.a((Object) linearLayout, "proceedBtn");
                    linearLayout.setClickable(true);
                    net.one97.paytm.contacts.a.b bVar2 = searchActivityV2.f50034c;
                    if (bVar2 == null) {
                        kotlin.g.b.k.a("mContactPayAdatper");
                    }
                    bVar2.a(str);
                }
            } catch (Exception unused) {
            }
        } else {
            net.one97.paytm.contacts.a.a aVar = searchActivityV2.f50032a;
            if (aVar == null) {
                kotlin.g.b.k.a("mAdapter");
            }
            if (aVar != null) {
                LinearLayout linearLayout2 = (LinearLayout) searchActivityV2._$_findCachedViewById(R.id.proceedBtn);
                kotlin.g.b.k.a((Object) linearLayout2, "proceedBtn");
                linearLayout2.setClickable(true);
                net.one97.paytm.contacts.a.a aVar2 = searchActivityV2.f50032a;
                if (aVar2 == null) {
                    kotlin.g.b.k.a("mAdapter");
                }
                aVar2.a(str);
            }
        }
        if (searchActivityV2.f50033b != null) {
            net.one97.paytm.contacts.a.c cVar = searchActivityV2.f50033b;
            if (cVar == null) {
                kotlin.g.b.k.a("mVPASuggestionAdapter");
            }
            if (cVar != null && p.a(charSequence, (CharSequence) "@", false)) {
                net.one97.paytm.contacts.a.c cVar2 = searchActivityV2.f50033b;
                if (cVar2 == null) {
                    kotlin.g.b.k.a("mVPASuggestionAdapter");
                }
                kotlin.g.b.k.c(str, "q");
                String substring = str.substring(p.a(charSequence, "@", 0, false, 6) + 1, str.length());
                kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (substring != null) {
                    String lowerCase = substring.toLowerCase();
                    kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    ArrayList arrayList = new ArrayList();
                    CharSequence charSequence2 = lowerCase;
                    if (charSequence2.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        for (String str2 : cVar2.f50025b) {
                            if ((str2 instanceof String) && p.a((CharSequence) str2, charSequence2, false)) {
                                arrayList.add(str2);
                            }
                        }
                        if (arrayList.size() == 0) {
                            cVar2.f50024a.clear();
                            cVar2.f50024a.addAll(cVar2.f50025b);
                        } else {
                            cVar2.f50024a.clear();
                            cVar2.f50024a.addAll(arrayList);
                        }
                    } else {
                        cVar2.f50024a.clear();
                        cVar2.f50024a.addAll(cVar2.f50025b);
                    }
                    cVar2.notifyDataSetChanged();
                    return;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
    }
}

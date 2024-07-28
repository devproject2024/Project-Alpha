package net.one97.paytm.o2o.movies.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import io.reactivex.rxjava3.a.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.movies.booking.CJRPrevalidate;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRGetMovieCancelProtectMetadata;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieGetCancelProtect;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRCashWalletResponse;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.app.VerifyPromoResultListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CreateOrderResponse;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;
import net.one97.paytm.o2o.movies.activity.AJRMovieOrderSummary;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRCampaign;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRConvenienceFee;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMCart;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRPaymentData;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRPaymentInfo;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRPromoMetaData;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRReleaseSeats;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeatItems;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassWrapperModel;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovies;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat;
import net.one97.paytm.o2o.movies.entity.BookingData;
import net.one97.paytm.o2o.movies.entity.CJRFoodBeverageSetResponseV2;
import net.one97.paytm.o2o.movies.entity.CJRMovieNewCancellationProtect;
import net.one97.paytm.o2o.movies.entity.CJRMovieOffers;
import net.one97.paytm.o2o.movies.entity.CJRMoviePromoStatus;
import net.one97.paytm.o2o.movies.entity.CJRSetSeatData;
import net.one97.paytm.o2o.movies.entity.CJRUserWalletBalance;
import net.one97.paytm.o2o.movies.utils.j;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class b extends androidx.lifecycle.a implements com.paytm.network.listener.b, PaytmSDKRequestClient, VerifyPromoCallbackListener, OnPromoActivityDestroyListener, g {
    static final String A = A;
    static final String B = B;
    public static final a C = new a((byte) 0);
    private final String D = CLPConstants.FOOD;
    private final String E = "FOOD_VOUCHER";
    private final CompletableJob F;
    private ProgressDialog G;
    private ArrayList<CJRFoodBeverageItemV2> H;
    private CJRSetSeat I;
    private CJRPrevalidate J;
    /* access modifiers changed from: private */
    public String K;
    /* access modifiers changed from: private */
    public double L;
    private CJRConvenienceFee M;
    private CJRCashWallet N;
    private net.one97.paytm.o2o.movies.d.c O;
    /* access modifiers changed from: private */
    public boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private int V;
    private double W;
    private double X;
    private int Y;
    private ArrayList<CJRFoodBeverageItemV2> Z;

    /* renamed from: a  reason: collision with root package name */
    public BookingData f74886a;
    private String aA;
    private boolean aB;
    private boolean aC;
    /* access modifiers changed from: private */
    public String aD;
    private CJRMovieGetCancelProtect aE;
    private CJRMovieOffers aF;
    private boolean aG;
    private boolean aH;
    private boolean aI;
    private final io.reactivex.rxjava3.b.b aJ;
    private final Application aK;
    private CJRMovieNewCancellationProtect aa;
    private CJRMovieGetCancelProtect ab;
    private boolean ac;
    private boolean ad;
    private CJRFoodBeverageSetResponseV2 ae;
    private String af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private String ak;
    /* access modifiers changed from: private */
    public CJRMovieCart al;
    private double am;
    private double an;
    private int ao;
    private boolean ap;
    private PaytmSDKRequestClient.OnCheckoutResponse aq;
    /* access modifiers changed from: private */
    public int ar;
    /* access modifiers changed from: private */
    public String as;
    /* access modifiers changed from: private */
    public String at;
    private String au;
    private String av;
    private String aw;
    private VerifyPromoResultListener ax;
    /* access modifiers changed from: private */
    public boolean ay;
    private PaytmSDKRequestClient.OtherPayOptionsListener az;

    /* renamed from: b  reason: collision with root package name */
    public final CoroutineScope f74887b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f74888c;

    /* renamed from: d  reason: collision with root package name */
    CJRAddSeat f74889d;

    /* renamed from: e  reason: collision with root package name */
    public String f74890e;

    /* renamed from: f  reason: collision with root package name */
    public String f74891f;

    /* renamed from: g  reason: collision with root package name */
    public String f74892g;

    /* renamed from: h  reason: collision with root package name */
    public String f74893h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f74894i;
    /* access modifiers changed from: package-private */
    public int j;
    public boolean k;
    public y<CJRConvenienceFee> l;
    public y<CJRUserWalletBalance> m;
    public y<CJRUserMoviePassModel> n;
    public y<CJRMovieOffers> o;
    public y<CJRAddSeat> p;
    public y<CJRSetSeatData> q;
    public y<CJRMovieNewCancellationProtect> r;
    public y<CJRMoviePromoStatus> s;
    public y<Boolean> t;
    public y<Boolean> u;
    public y<Boolean> v;
    public y<Boolean> w;
    public y<Boolean> x;
    public y<Boolean> y;
    public final y<Intent> z;

    static final class h<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final h f74898a = new h();

        h() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    public final void createOrderInfoFragment(PaytmSDKRequestClient.ShowOrderInfoFragment showOrderInfoFragment, Object obj) {
        k.c(showOrderInfoFragment, "showOrderInfoFragment");
        k.c(obj, "o");
    }

    public final boolean isConvFeeEnabled() {
        return false;
    }

    public final void verifyCart(PaytmSDKRequestClient.CallbackData callbackData, PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse) {
        k.c(callbackData, "callbackData");
        k.c(onVerifyResponse, "onVerifyResponse");
    }

    static final class g<T> implements io.reactivex.rxjava3.d.g<Intent> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f74897a;

        g(b bVar) {
            this.f74897a = bVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f74897a.z.setValue((Intent) obj);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        p<Intent> a2;
        io.reactivex.rxjava3.b.c subscribe;
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.aK = application;
        Application application2 = null;
        this.F = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.f74887b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(this.F));
        this.av = "";
        this.l = new y<>();
        this.m = new y<>();
        this.n = new y<>();
        this.o = new y<>();
        this.p = new y<>();
        this.q = new y<>();
        this.r = new y<>();
        this.s = new y<>();
        this.t = new y<>();
        this.u = new y<>();
        this.v = new y<>();
        this.w = new y<>();
        this.x = new y<>();
        this.y = new y<>();
        this.aG = true;
        this.aH = true;
        this.aI = true;
        this.aJ = new io.reactivex.rxjava3.b.b();
        this.z = new y<>();
        Application application3 = this.aK;
        Context context = application3 instanceof Context ? application3 : application2;
        if (context != null && (a2 = net.one97.paytm.o2o.movies.common.e.a(context, "action.order.session.expire")) != null && (subscribe = a2.subscribe(new g(this), h.f74898a)) != null) {
            net.one97.paytm.o2o.movies.common.i.a(subscribe, this.aJ);
        }
    }

    public static final /* synthetic */ BookingData b(b bVar) {
        BookingData bookingData = bVar.f74886a;
        if (bookingData == null) {
            k.a("mBookingData");
        }
        return bookingData;
    }

    private final JSONObject f() throws JSONException {
        ArrayList<net.one97.paytm.o2o.movies.common.movies.booking.a> arrayList;
        try {
            if (this.I != null) {
                CJRSetSeat cJRSetSeat = this.I;
                CJRSetSeatItems items = cJRSetSeat != null ? cJRSetSeat.getItems() : null;
                if (!(items == null || (arrayList = items.get_3dglasses()) == null || arrayList.size() <= 0)) {
                    JSONObject jSONObject = new JSONObject();
                    int i2 = 0;
                    net.one97.paytm.o2o.movies.common.movies.booking.a aVar = arrayList.get(0);
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    CJRSetSeat cJRSetSeat2 = this.I;
                    if (cJRSetSeat2 == null) {
                        k.a();
                    }
                    ArrayList<net.one97.paytm.o2o.movies.common.movies.booking.c> rules = cJRSetSeat2.getRules();
                    k.a((Object) rules, "rules");
                    int size = rules.size();
                    while (i2 < size) {
                        net.one97.paytm.o2o.movies.common.movies.booking.c cVar = rules.get(i2);
                        if (!kotlin.m.p.a("3dglasses", cVar.f75144a, true) || !kotlin.m.p.a("v1", cVar.f75145b, true)) {
                            i2++;
                        } else {
                            float floatValue = aVar.f75140b.floatValue();
                            BookingData bookingData = this.f74886a;
                            if (bookingData == null) {
                                k.a("mBookingData");
                            }
                            this.am = Double.parseDouble(n.a((double) (floatValue * ((float) bookingData.getMSelectedSeatList().size()))));
                            float floatValue2 = aVar.f75142d.floatValue();
                            BookingData bookingData2 = this.f74886a;
                            if (bookingData2 == null) {
                                k.a("mBookingData");
                            }
                            this.an = Double.parseDouble(n.a((double) (floatValue2 * ((float) bookingData2.getMSelectedSeatList().size()))));
                            jSONObject.put("id", String.valueOf(aVar.f75139a.intValue()));
                            BookingData bookingData3 = this.f74886a;
                            if (bookingData3 == null) {
                                k.a("mBookingData");
                            }
                            jSONObject.put("quantity", bookingData3.getMSelectedSeatList().size());
                            jSONObject.put("unitPrice", aVar.f75140b);
                            jSONObject.put("price", this.am);
                            jSONObject.put("unitCharges", aVar.f75142d);
                            jSONObject.put("charges", this.an);
                            Integer num = aVar.f75141c;
                            k.a((Object) num, "glassItem.productId");
                            this.ao = num.intValue();
                            jSONArray.put(jSONObject);
                            jSONObject2.put("items", jSONArray);
                            jSONObject2.put("totalCharges", this.an);
                            jSONObject2.put(EMIConstants.TOTAL_PRICE, this.am);
                            return jSONObject2;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private final double g() {
        BookingData bookingData = this.f74886a;
        if (bookingData == null) {
            k.a("mBookingData");
        }
        if (bookingData.getMSelectedMoviesSession().isFreeSeating()) {
            BookingData bookingData2 = this.f74886a;
            if (bookingData2 == null) {
                k.a("mBookingData");
            }
            if (bookingData2.getMSelectedMoviesSession().isTokenFeeOnly()) {
                return 0.0d;
            }
            BookingData bookingData3 = this.f74886a;
            if (bookingData3 == null) {
                k.a("mBookingData");
            }
            CJRObjSeat cJRObjSeat = (CJRObjSeat) kotlin.a.k.e(bookingData3.getMSelectedSeatList());
            if (cJRObjSeat == null) {
                return 0.0d;
            }
            BookingData bookingData4 = this.f74886a;
            if (bookingData4 == null) {
                k.a("mBookingData");
            }
            return ((double) bookingData4.getSeatCount()) * (cJRObjSeat.getPrice() + cJRObjSeat.getVoucherPrice());
        }
        BookingData bookingData5 = this.f74886a;
        if (bookingData5 == null) {
            k.a("mBookingData");
        }
        Iterator<CJRObjSeat> it2 = bookingData5.getMSelectedSeatList().iterator();
        while (true) {
            double d2 = 0.0d;
            while (true) {
                if (!it2.hasNext()) {
                    return d2;
                }
                CJRObjSeat next = it2.next();
                BookingData bookingData6 = this.f74886a;
                if (bookingData6 == null) {
                    k.a("mBookingData");
                }
                if (!bookingData6.getMSelectedMoviesSession().isTokenFeeOnly()) {
                    k.a((Object) next, "objSeat");
                    d2 = d2 + next.getPrice() + next.getVoucherPrice();
                }
            }
        }
    }

    private final String h() {
        String areaDesc;
        BookingData bookingData = this.f74886a;
        if (bookingData == null) {
            k.a("mBookingData");
        }
        CJRObjSeat cJRObjSeat = (CJRObjSeat) kotlin.a.k.e(bookingData.getMSelectedSeatList());
        if (cJRObjSeat == null || (areaDesc = cJRObjSeat.getAreaDesc()) == null) {
            return null;
        }
        return net.one97.paytm.o2o.movies.common.a.d.b(areaDesc);
    }

    private final boolean i() {
        CJRMCart cart;
        CJRPaymentInfo cJRPaymentInfo;
        CJRMovieCart cJRMovieCart = this.al;
        if (cJRMovieCart == null || (cart = cJRMovieCart.getCart()) == null || (cJRPaymentInfo = cart.paymentInfo) == null || cJRPaymentInfo.native_withdraw != 1) {
            return false;
        }
        return true;
    }

    public final void a(ArrayList<CJRFoodBeverageItemV2> arrayList, boolean z2, int i2, boolean z3, CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect, boolean z4, double d2) {
        this.P = true;
        this.Q = z2;
        this.ad = z4;
        boolean a2 = a(arrayList);
        a(arrayList, i2, cJRMovieNewCancellationProtect, z3, this.aE, this.f74893h, d2);
        a(a2, false);
    }

    public final void a(String str, int i2, CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect, boolean z2, boolean z3, String str2, boolean z4, String str3, double d2, String str4, boolean z5) {
        ArrayList<CJRFoodBeverageItemV2> a2 = net.one97.paytm.o2o.movies.utils.g.a().a(false);
        boolean a3 = a(a2);
        a(a2, i2, cJRMovieNewCancellationProtect, z2, this.aE, str3, d2);
        if (z4) {
            this.as = str2;
            this.aD = str4;
        }
        this.ay = true;
        this.ar = 0;
        String str5 = str;
        a(str, z3, a3, z5);
    }

    private final void a(String str, boolean z2, boolean z3, boolean z4) {
        this.aj = z2;
        this.K = str;
        this.P = false;
        a(z3, z4);
    }

    private final void a(boolean z2, boolean z3) {
        if (this.ag || z2) {
            this.T = false;
            j();
            this.al = null;
        } else if (!this.ah) {
            b(z3);
        } else if (this.P) {
            if (this.aB) {
                c(z3);
            } else if (this.aC || this.al == null) {
                n();
            } else {
                q();
            }
        } else if (this.aB) {
            c(z3);
        } else {
            n();
        }
        this.aC = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
        r0 = b(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean a(java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2> r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x0014
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2> r1 = r2.Z
            if (r1 != 0) goto L_0x000b
            boolean r1 = r2.ah
            if (r1 == 0) goto L_0x0011
        L_0x000b:
            boolean r0 = r2.b((java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2>) r3)
            if (r0 == 0) goto L_0x0014
        L_0x0011:
            r2.c((java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2>) r3)
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.b.a(java.util.ArrayList):boolean");
    }

    private final boolean b(ArrayList<CJRFoodBeverageItemV2> arrayList) {
        if (arrayList == null || this.Z == null) {
            return (arrayList != null && this.Z == null) || (this.Z != null && arrayList == null);
        }
        int size = arrayList.size();
        ArrayList<CJRFoodBeverageItemV2> arrayList2 = this.Z;
        if (arrayList2 == null) {
            k.a();
        }
        if (size != arrayList2.size()) {
            return true;
        }
        ArrayList<CJRFoodBeverageItemV2> arrayList3 = this.Z;
        if (arrayList3 == null) {
            k.a();
        }
        int size2 = arrayList3.size();
        int i2 = 0;
        while (i2 < size2) {
            String str = arrayList.get(i2).getmID();
            ArrayList<CJRFoodBeverageItemV2> arrayList4 = this.Z;
            if (arrayList4 == null) {
                k.a();
            }
            if (kotlin.m.p.a(str, arrayList4.get(i2).getmID(), true)) {
                int i3 = arrayList.get(i2).getmFoodQauntitySelected();
                ArrayList<CJRFoodBeverageItemV2> arrayList5 = this.Z;
                if (arrayList5 == null) {
                    k.a();
                }
                if (i3 == arrayList5.get(i2).getmFoodQauntitySelected()) {
                    i2++;
                }
            }
            return true;
        }
    }

    public final void a(boolean z2) {
        this.t.setValue(Boolean.TRUE);
        this.K = null;
        this.ak = null;
        this.at = null;
        this.as = null;
        this.aC = true;
        if (z2) {
            this.ah = false;
        }
    }

    private final void a(ArrayList<CJRFoodBeverageItemV2> arrayList, int i2, CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect, boolean z2, CJRMovieGetCancelProtect cJRMovieGetCancelProtect, String str, double d2) {
        this.aB = this.S != z2;
        this.S = z2;
        this.ab = cJRMovieGetCancelProtect;
        this.H = arrayList;
        this.Y = i2;
        this.f74893h = str;
        this.L = d2;
        this.aa = cJRMovieNewCancellationProtect;
        if (cJRMovieNewCancellationProtect == null) {
            this.S = false;
        }
    }

    private final void c(ArrayList<CJRFoodBeverageItemV2> arrayList) {
        if (arrayList != null) {
            this.Z = new ArrayList<>();
            Iterator<CJRFoodBeverageItemV2> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRFoodBeverageItemV2 next = it2.next();
                CJRFoodBeverageItemV2 cJRFoodBeverageItemV2 = new CJRFoodBeverageItemV2();
                cJRFoodBeverageItemV2.setmID(next.getmID());
                cJRFoodBeverageItemV2.setmFoodQauntitySelected(next.getmFoodQauntitySelected());
                ArrayList<CJRFoodBeverageItemV2> arrayList2 = this.Z;
                if (arrayList2 == null) {
                    k.a();
                }
                arrayList2.add(cJRFoodBeverageItemV2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void j() {
        com.paytm.utility.b.j();
        BookingData bookingData = this.f74886a;
        if (bookingData == null) {
            k.a("mBookingData");
        }
        if (bookingData.getMSelectedSeatList().size() > 0) {
            Application application = getApplication();
            k.a((Object) application, "getApplication<Application>()");
            if (com.paytm.utility.b.c(application.getApplicationContext())) {
                a();
                Application application2 = getApplication();
                k.a((Object) application2, "getApplication<Application>()");
                Context applicationContext = application2.getApplicationContext();
                BookingData bookingData2 = this.f74886a;
                if (bookingData2 == null) {
                    k.a("mBookingData");
                }
                CJRMoviesSession mSelectedMoviesSession = bookingData2.getMSelectedMoviesSession();
                BookingData bookingData3 = this.f74886a;
                if (bookingData3 == null) {
                    k.a("mBookingData");
                }
                int seatCount = bookingData3.getSeatCount();
                String str = this.f74891f;
                BookingData bookingData4 = this.f74886a;
                if (bookingData4 == null) {
                    k.a("mBookingData");
                }
                j.a(applicationContext, mSelectedMoviesSession, seatCount, str, bookingData4.getMSelectedSeatList().get(0), this);
                return;
            }
            b();
            Application application3 = getApplication();
            k.a((Object) application3, "getApplication<Application>()");
            Context applicationContext2 = application3.getApplicationContext();
            Application application4 = getApplication();
            k.a((Object) application4, "getApplication<Application>()");
            String string = application4.getApplicationContext().getString(R.string.no_connection);
            Application application5 = getApplication();
            k.a((Object) application5, "getApplication<Application>()");
            com.paytm.utility.b.b(applicationContext2, string, application5.getApplicationContext().getString(R.string.no_internet));
        }
    }

    private final void k() {
        HashMap hashMap = new HashMap();
        com.paytm.utility.b.j();
        Map map = hashMap;
        map.put("Content-Type", "application/json");
        map.put("ClientId", "paytm");
        JSONObject d2 = d(this.H);
        StringBuilder sb = new StringBuilder();
        k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
        String a2 = net.one97.paytm.o2o.movies.common.b.c.a("movieSetItemV2", (String) null);
        if (TextUtils.isEmpty(a2)) {
            a2 = "https://digital-apiproxy.paytm.com/v2/movies/set-items";
        }
        sb.append(a2);
        sb.append("?");
        String sb2 = sb.toString();
        if (URLUtil.isValidUrl(sb2)) {
            Application application = getApplication();
            k.a((Object) application, "getApplication<Application>()");
            String s2 = com.paytm.utility.b.s(application.getApplicationContext(), sb2);
            k.a((Object) s2, "CJRAppCommonUtility.addD….applicationContext, url)");
            com.paytm.network.a a3 = a(s2, (Map<String, String>) map, d2.toString(), (IJRPaytmDataModel) new CJRFoodBeverageSetResponseV2());
            Application application2 = getApplication();
            k.a((Object) application2, "getApplication<Application>()");
            if (com.paytm.utility.b.c(application2.getApplicationContext())) {
                a();
                a3.a();
                return;
            }
            b();
            a(a3, false);
        }
    }

    private JSONObject d(ArrayList<CJRFoodBeverageItemV2> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            BookingData bookingData = this.f74886a;
            if (bookingData == null) {
                k.a("mBookingData");
            }
            jSONObject.put("providerId", bookingData.getMSelectedMoviesSession().getProviderId());
            CJRAddSeat cJRAddSeat = this.f74889d;
            if (cJRAddSeat == null) {
                k.a();
            }
            if (cJRAddSeat.getTempTransId() != null) {
                CJRAddSeat cJRAddSeat2 = this.f74889d;
                if (cJRAddSeat2 == null) {
                    k.a();
                }
                jSONObject.put("tempTransId", cJRAddSeat2.getTempTransId());
                CJRAddSeat cJRAddSeat3 = this.f74889d;
                if (cJRAddSeat3 == null) {
                    k.a();
                }
                jSONObject.put("bookingId", cJRAddSeat3.getTempTransId());
            } else {
                jSONObject.put("tempTransId", this.f74891f);
                jSONObject.put("bookingId", this.f74891f);
            }
            BookingData bookingData2 = this.f74886a;
            if (bookingData2 == null) {
                k.a("mBookingData");
            }
            jSONObject.put("paytmCinemaId", bookingData2.getMSelectedMoviesSession().getCinemaID());
            BookingData bookingData3 = this.f74886a;
            if (bookingData3 == null) {
                k.a("mBookingData");
            }
            jSONObject.put("showDateTime", bookingData3.getMSelectedMoviesSession().getRealShowDateTime());
            BookingData bookingData4 = this.f74886a;
            if (bookingData4 == null) {
                k.a("mBookingData");
            }
            jSONObject.put(H5Param.SESSION_ID, bookingData4.getMSelectedMoviesSession().getSessionID());
            BookingData bookingData5 = this.f74886a;
            if (bookingData5 == null) {
                k.a("mBookingData");
            }
            jSONObject.put("ticketCount", bookingData5.getSeatCount());
            JSONObject jSONObject2 = new JSONObject();
            if (arrayList != null && arrayList.size() > 0) {
                JSONObject a2 = a(arrayList, this.D);
                if (a2 != null) {
                    jSONObject2.put("food", a2);
                }
                JSONObject a3 = a(arrayList, this.E);
                if (a3 != null) {
                    jSONObject2.put(CJRFoodBeverageItemV2.FOOD_VOUCHER, a3);
                }
            }
            if (f() != null) {
                jSONObject2.put("3dglasses", f());
            }
            jSONObject.put("data", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be A[Catch:{ Exception -> 0x0148 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final org.json.JSONObject a(java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2> r18, java.lang.String r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            org.json.JSONArray r2 = new org.json.JSONArray
            r2.<init>()
            r3 = 0
            java.lang.String r4 = r0.D     // Catch:{ Exception -> 0x0148 }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r4)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r5 = "food_voucher"
            r6 = 0
            if (r4 == 0) goto L_0x0061
            r1 = r18
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ Exception -> 0x0148 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0148 }
            r4.<init>()     // Catch:{ Exception -> 0x0148 }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ Exception -> 0x0148 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0148 }
        L_0x0024:
            boolean r7 = r1.hasNext()     // Catch:{ Exception -> 0x0148 }
            if (r7 == 0) goto L_0x0041
            java.lang.Object r7 = r1.next()     // Catch:{ Exception -> 0x0148 }
            r8 = r7
            net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2 r8 = (net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2) r8     // Catch:{ Exception -> 0x0148 }
            java.lang.String r8 = r8.getType()     // Catch:{ Exception -> 0x0148 }
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r5)     // Catch:{ Exception -> 0x0148 }
            r8 = r8 ^ 1
            if (r8 == 0) goto L_0x0024
            r4.add(r7)     // Catch:{ Exception -> 0x0148 }
            goto L_0x0024
        L_0x0041:
            r1 = r4
            java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x0148 }
            int r4 = r1.size()     // Catch:{ Exception -> 0x0148 }
            if (r4 <= 0) goto L_0x00bc
            java.lang.Object r4 = r1.get(r6)     // Catch:{ Exception -> 0x0148 }
            net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2 r4 = (net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2) r4     // Catch:{ Exception -> 0x0148 }
            java.lang.String r4 = r4.getmProductID()     // Catch:{ Exception -> 0x0148 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0148 }
            r0.U = r4     // Catch:{ Exception -> 0x0148 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0148 }
            r4.<init>()     // Catch:{ Exception -> 0x0148 }
        L_0x005f:
            r3 = r4
            goto L_0x00bc
        L_0x0061:
            java.lang.String r4 = r0.E     // Catch:{ Exception -> 0x0148 }
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r4)     // Catch:{ Exception -> 0x0148 }
            if (r1 == 0) goto L_0x00b2
            r1 = r18
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ Exception -> 0x0148 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0148 }
            r4.<init>()     // Catch:{ Exception -> 0x0148 }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ Exception -> 0x0148 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0148 }
        L_0x0078:
            boolean r7 = r1.hasNext()     // Catch:{ Exception -> 0x0148 }
            if (r7 == 0) goto L_0x0093
            java.lang.Object r7 = r1.next()     // Catch:{ Exception -> 0x0148 }
            r8 = r7
            net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2 r8 = (net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2) r8     // Catch:{ Exception -> 0x0148 }
            java.lang.String r8 = r8.getType()     // Catch:{ Exception -> 0x0148 }
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r5)     // Catch:{ Exception -> 0x0148 }
            if (r8 == 0) goto L_0x0078
            r4.add(r7)     // Catch:{ Exception -> 0x0148 }
            goto L_0x0078
        L_0x0093:
            r1 = r4
            java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x0148 }
            int r4 = r1.size()     // Catch:{ Exception -> 0x0148 }
            if (r4 <= 0) goto L_0x00bc
            java.lang.Object r4 = r1.get(r6)     // Catch:{ Exception -> 0x0148 }
            net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2 r4 = (net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2) r4     // Catch:{ Exception -> 0x0148 }
            java.lang.String r4 = r4.getmProductID()     // Catch:{ Exception -> 0x0148 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0148 }
            r0.V = r4     // Catch:{ Exception -> 0x0148 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0148 }
            r4.<init>()     // Catch:{ Exception -> 0x0148 }
            goto L_0x005f
        L_0x00b2:
            java.util.List r1 = java.util.Collections.emptyList()     // Catch:{ Exception -> 0x0148 }
            java.lang.String r4 = "Collections.emptyList()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x0148 }
            r1 = r3
        L_0x00bc:
            if (r3 == 0) goto L_0x0148
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ Exception -> 0x0148 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0148 }
            r4 = 0
            r6 = r4
        L_0x00c7:
            boolean r8 = r1.hasNext()     // Catch:{ Exception -> 0x0148 }
            if (r8 == 0) goto L_0x0139
            java.lang.Object r8 = r1.next()     // Catch:{ Exception -> 0x0148 }
            net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2 r8 = (net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2) r8     // Catch:{ Exception -> 0x0148 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0148 }
            r9.<init>()     // Catch:{ Exception -> 0x0148 }
            int r10 = r8.getmFoodQauntitySelected()     // Catch:{ Exception -> 0x0148 }
            java.lang.String r11 = r8.getmPrice()     // Catch:{ Exception -> 0x0148 }
            java.lang.String r12 = "item.getmPrice()"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x0148 }
            double r11 = java.lang.Double.parseDouble(r11)     // Catch:{ Exception -> 0x0148 }
            double r13 = (double) r10     // Catch:{ Exception -> 0x0148 }
            double r13 = r13 * r11
            double r4 = r4 + r13
            r18 = r4
            double r4 = r0.W     // Catch:{ Exception -> 0x0148 }
            double r4 = r4 + r13
            r0.W = r4     // Catch:{ Exception -> 0x0148 }
            java.lang.String r4 = r8.getmConvinienceFee()     // Catch:{ Exception -> 0x0148 }
            java.lang.String r5 = "item.getmConvinienceFee()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x0148 }
            double r4 = java.lang.Double.parseDouble(r4)     // Catch:{ Exception -> 0x0148 }
            double r6 = r6 + r4
            r15 = r6
            double r6 = r0.X     // Catch:{ Exception -> 0x0148 }
            double r6 = r6 + r4
            r0.X = r6     // Catch:{ Exception -> 0x0148 }
            java.lang.String r6 = "id"
            java.lang.String r7 = r8.getmID()     // Catch:{ Exception -> 0x0148 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x0148 }
            r9.put(r6, r7)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r6 = "quantity"
            r9.put(r6, r10)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r6 = "unit_price"
            r9.put(r6, r11)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r6 = "price"
            r9.put(r6, r13)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r6 = "productId"
            java.lang.String r7 = r8.getmProductID()     // Catch:{ Exception -> 0x0148 }
            r9.put(r6, r7)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r6 = "conv_fee"
            r9.put(r6, r4)     // Catch:{ Exception -> 0x0148 }
            r2.put(r9)     // Catch:{ Exception -> 0x0148 }
            r4 = r18
            r6 = r15
            goto L_0x00c7
        L_0x0139:
            java.lang.String r1 = "totalPrice"
            r3.put(r1, r4)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r1 = "totalCharges"
            r3.put(r1, r6)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r1 = "items"
            r3.put(r1, r2)     // Catch:{ Exception -> 0x0148 }
        L_0x0148:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.b.a(java.util.ArrayList, java.lang.String):org.json.JSONObject");
    }

    private final void a(boolean z2, CJRFoodBeverageSetResponseV2 cJRFoodBeverageSetResponseV2, CJRMovieGetCancelProtect cJRMovieGetCancelProtect, boolean z3) {
        com.paytm.utility.b.j();
        k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
        String a2 = net.one97.paytm.o2o.movies.common.b.c.a("moviesPrevalidate", (String) null);
        if (URLUtil.isValidUrl(a2)) {
            Application application = getApplication();
            k.a((Object) application, "getApplication<Application>()");
            String d2 = com.paytm.utility.b.d(application.getApplicationContext(), a2);
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ClientId", "paytm");
            String b2 = b(z2, cJRFoodBeverageSetResponseV2, cJRMovieGetCancelProtect, z3);
            "prevalidate : ".concat(String.valueOf(b2));
            com.paytm.utility.b.j();
            k.a((Object) d2, "url");
            com.paytm.network.a a3 = a(d2, (Map<String, String>) hashMap, b2, (IJRPaytmDataModel) new CJRPrevalidate());
            Application application2 = getApplication();
            k.a((Object) application2, "getApplication<Application>()");
            if (com.paytm.utility.b.c(application2.getApplicationContext())) {
                a();
                a3.a();
                return;
            }
            b();
            a(a3, false);
        }
    }

    /* access modifiers changed from: private */
    public final void l() {
        com.paytm.utility.b.j();
        k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
        String a2 = net.one97.paytm.o2o.movies.common.b.c.a("moviesCheckInsuranceV2", (String) null);
        if (TextUtils.isEmpty(a2)) {
            a2 = "https://apiproxy.paytm.com/v2/movies/get-insurance-eligiblity";
        }
        if (URLUtil.isValidUrl(a2)) {
            Application application = getApplication();
            k.a((Object) application, "getApplication<Application>()");
            String d2 = com.paytm.utility.b.d(application.getApplicationContext(), a2);
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ClientId", "paytm");
            BookingData bookingData = this.f74886a;
            if (bookingData == null) {
                k.a("mBookingData");
            }
            CJRMoviesSession mSelectedMoviesSession = bookingData.getMSelectedMoviesSession();
            BookingData bookingData2 = this.f74886a;
            if (bookingData2 == null) {
                k.a("mBookingData");
            }
            CJRMovies mSelectedMovie = bookingData2.getMSelectedMovie();
            String str = this.f74891f;
            String str2 = this.f74890e;
            String str3 = this.f74892g;
            BookingData bookingData3 = this.f74886a;
            if (bookingData3 == null) {
                k.a("mBookingData");
            }
            ArrayList<CJRObjSeat> mSelectedSeatList = bookingData3.getMSelectedSeatList();
            CJRConvenienceFee cJRConvenienceFee = this.M;
            BookingData bookingData4 = this.f74886a;
            if (bookingData4 == null) {
                k.a("mBookingData");
            }
            String a3 = a(mSelectedMoviesSession, mSelectedMovie, str, str2, str3, mSelectedSeatList, cJRConvenienceFee, bookingData4.getSeatCount());
            "prevalidate : ".concat(String.valueOf(a3));
            com.paytm.utility.b.j();
            k.a((Object) d2, "url");
            com.paytm.network.a a4 = a(d2, (Map<String, String>) hashMap, a3, (IJRPaytmDataModel) new CJRMovieNewCancellationProtect());
            Application application2 = getApplication();
            k.a((Object) application2, "getApplication<Application>()");
            if (com.paytm.utility.b.c(application2.getApplicationContext())) {
                a();
                a4.a();
                return;
            }
            b();
            a(a4, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f A[SYNTHETIC, Splitter:B:24:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092 A[Catch:{ JSONException -> 0x00a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m() {
        /*
            r7 = this;
            net.one97.paytm.o2o.movies.common.b.c r0 = net.one97.paytm.o2o.movies.common.b.c.a()
            java.lang.String r1 = "MoviesGTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = "moviesGetInsuranceCart"
            r1 = 0
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.c.a(r0, r1)
            boolean r1 = android.webkit.URLUtil.isValidUrl(r0)
            if (r1 != 0) goto L_0x0017
            return
        L_0x0017:
            android.app.Application r1 = r7.getApplication()
            java.lang.String r2 = "getApplication<Application>()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r0 = com.paytm.utility.b.d((android.content.Context) r1, (java.lang.String) r0)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r3 = "ClientId"
            java.lang.String r4 = "paytm"
            r1.put(r3, r4)
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json"
            r1.put(r3, r4)
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r4 = r7.I     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r5 = "transId"
            if (r4 == 0) goto L_0x006a
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r4 = r7.I     // Catch:{ JSONException -> 0x00a7 }
            if (r4 != 0) goto L_0x004f
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x00a7 }
        L_0x004f:
            java.lang.String r4 = r4.getTempTransId()     // Catch:{ JSONException -> 0x00a7 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ JSONException -> 0x00a7 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x00a7 }
            if (r4 != 0) goto L_0x006a
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r4 = r7.I     // Catch:{ JSONException -> 0x00a7 }
            if (r4 != 0) goto L_0x0062
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x00a7 }
        L_0x0062:
            java.lang.String r4 = r4.getTempTransId()     // Catch:{ JSONException -> 0x00a7 }
            r3.put(r5, r4)     // Catch:{ JSONException -> 0x00a7 }
            goto L_0x0079
        L_0x006a:
            java.lang.String r4 = r7.f74891f     // Catch:{ JSONException -> 0x00a7 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ JSONException -> 0x00a7 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x00a7 }
            if (r4 != 0) goto L_0x0079
            java.lang.String r4 = r7.f74891f     // Catch:{ JSONException -> 0x00a7 }
            r3.put(r5, r4)     // Catch:{ JSONException -> 0x00a7 }
        L_0x0079:
            net.one97.paytm.o2o.movies.entity.BookingData r4 = r7.f74886a     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r5 = "mBookingData"
            if (r4 != 0) goto L_0x0082
            kotlin.g.b.k.a((java.lang.String) r5)     // Catch:{ JSONException -> 0x00a7 }
        L_0x0082:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r4 = r4.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r4 = r4.getProviderId()     // Catch:{ JSONException -> 0x00a7 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ JSONException -> 0x00a7 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x00a7 }
            if (r4 != 0) goto L_0x00a8
            java.lang.String r4 = "providerId"
            net.one97.paytm.o2o.movies.entity.BookingData r6 = r7.f74886a     // Catch:{ JSONException -> 0x00a7 }
            if (r6 != 0) goto L_0x009b
            kotlin.g.b.k.a((java.lang.String) r5)     // Catch:{ JSONException -> 0x00a7 }
        L_0x009b:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r5 = r6.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r5 = r5.getProviderId()     // Catch:{ JSONException -> 0x00a7 }
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x00a7 }
            goto L_0x00a8
        L_0x00a7:
        L_0x00a8:
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "jsonRequest.toString()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r4 = java.lang.String.valueOf(r3)
            java.lang.String r5 = " getInsuranceCartApi : "
            r5.concat(r4)
            com.paytm.utility.b.j()
            java.lang.String r4 = "url"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieGetCancelProtect r4 = new net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieGetCancelProtect
            r4.<init>()
            com.paytm.network.model.IJRPaytmDataModel r4 = (com.paytm.network.model.IJRPaytmDataModel) r4
            com.paytm.network.a r0 = r7.a((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.String>) r1, (java.lang.String) r3, (com.paytm.network.model.IJRPaytmDataModel) r4)
            android.app.Application r1 = r7.getApplication()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            android.content.Context r1 = r1.getApplicationContext()
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r1)
            if (r1 == 0) goto L_0x00e5
            r7.a()
            r0.a()
            return
        L_0x00e5:
            r7.b()
            r1 = 1
            r7.a((com.paytm.network.a) r0, (boolean) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.b.m():void");
    }

    /* access modifiers changed from: package-private */
    public final com.paytm.network.a a(String str, Map<String, String> map, IJRPaytmDataModel iJRPaytmDataModel) {
        return a(str, map, (String) null, a.C0715a.GET, iJRPaytmDataModel);
    }

    /* access modifiers changed from: package-private */
    public final com.paytm.network.a a(String str, Map<String, String> map, String str2, IJRPaytmDataModel iJRPaytmDataModel) {
        return a(str, map, str2, a.C0715a.POST, iJRPaytmDataModel);
    }

    private final com.paytm.network.a a(String str, Map<String, String> map, String str2, a.C0715a aVar, IJRPaytmDataModel iJRPaytmDataModel) {
        net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
        Application application = getApplication();
        k.a((Object) application, "getApplication<Application>()");
        cVar.f42877a = application.getApplicationContext();
        cVar.f42878b = a.c.MOVIES;
        cVar.f42879c = aVar;
        cVar.f42880d = str;
        cVar.f42881e = null;
        cVar.f42882f = map;
        cVar.f42883g = null;
        cVar.f42884h = str2;
        cVar.f42885i = iJRPaytmDataModel;
        cVar.j = this;
        cVar.n = a.b.USER_FACING;
        cVar.o = "movies";
        cVar.t = n.h("CJRJustTicketsBookingApiManager");
        com.paytm.network.a l2 = cVar.l();
        l2.f42859c = false;
        k.a((Object) l2, "networkCall");
        return l2;
    }

    private static double a(ArrayList<CJRObjSeat> arrayList, CJRMoviesSession cJRMoviesSession, int i2) {
        if (cJRMoviesSession == null || !cJRMoviesSession.isFreeSeating()) {
            Iterator<CJRObjSeat> it2 = arrayList.iterator();
            while (true) {
                double d2 = 0.0d;
                while (true) {
                    if (!it2.hasNext()) {
                        return d2;
                    }
                    CJRObjSeat next = it2.next();
                    if (cJRMoviesSession == null || !cJRMoviesSession.isTokenFeeOnly()) {
                        k.a((Object) next, "objSeat");
                        d2 = d2 + next.getPrice() + next.getVoucherPrice();
                    }
                }
            }
        } else {
            CJRObjSeat cJRObjSeat = (CJRObjSeat) kotlin.a.k.e(arrayList);
            if (cJRObjSeat == null || cJRMoviesSession.isTokenFeeOnly()) {
                return 0.0d;
            }
            return (cJRObjSeat.getPrice() + cJRObjSeat.getVoucherPrice()) * ((double) i2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:164:0x03d3 A[ADDED_TO_REGION, Catch:{ JSONException -> 0x053a }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0406 A[Catch:{ JSONException -> 0x053a }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0409 A[Catch:{ JSONException -> 0x053a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String b(boolean r23, net.one97.paytm.o2o.movies.entity.CJRFoodBeverageSetResponseV2 r24, net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieGetCancelProtect r25, boolean r26) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            r2 = r25
            java.lang.String r3 = "seatCodes"
            java.lang.String r4 = "getApplication<Application>()"
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            org.json.JSONArray r6 = new org.json.JSONArray
            r6.<init>()
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r8 = "product_id"
            java.lang.String r9 = r0.f74893h     // Catch:{ JSONException -> 0x053d }
            r7.put(r8, r9)     // Catch:{ JSONException -> 0x053d }
            java.lang.String r8 = "qty"
            java.lang.String r9 = "1"
            r7.put(r8, r9)     // Catch:{ JSONException -> 0x053d }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x053d }
            r8.<init>()     // Catch:{ JSONException -> 0x053d }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x053d }
            r9.<init>()     // Catch:{ JSONException -> 0x053d }
            double r10 = r22.g()     // Catch:{ JSONException -> 0x053d }
            java.lang.String r12 = "price"
            java.lang.String r13 = net.one97.paytm.o2o.movies.utils.n.a((double) r10)     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r8, (java.lang.String) r12, (java.lang.String) r13)     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.common.movies.booking.CJRConvenienceFee r12 = r0.M     // Catch:{ JSONException -> 0x053d }
            if (r12 == 0) goto L_0x005a
            net.one97.paytm.o2o.movies.common.movies.booking.CJRConvenienceFee r12 = r0.M     // Catch:{ JSONException -> 0x053d }
            if (r12 != 0) goto L_0x0049
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x053d }
        L_0x0049:
            java.lang.String r12 = r12.getTotalCommision()     // Catch:{ JSONException -> 0x053d }
            double r12 = java.lang.Double.parseDouble(r12)     // Catch:{ JSONException -> 0x053d }
            java.lang.String r14 = "conv_fee"
            java.lang.Double r12 = java.lang.Double.valueOf(r12)     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r8, (java.lang.String) r14, (java.lang.Object) r12)     // Catch:{ JSONException -> 0x053d }
        L_0x005a:
            java.lang.String r12 = "movie"
            net.one97.paytm.o2o.movies.entity.BookingData r13 = r0.f74886a     // Catch:{ JSONException -> 0x053d }
            java.lang.String r14 = "mBookingData"
            if (r13 != 0) goto L_0x0065
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053d }
        L_0x0065:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovies r13 = r13.getMSelectedMovie()     // Catch:{ JSONException -> 0x053d }
            java.lang.String r13 = r13.getTitle()     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r8, (org.json.JSONObject) r9, (java.lang.String) r12, (java.lang.String) r13)     // Catch:{ JSONException -> 0x053d }
            java.lang.String r12 = "movieCode"
            net.one97.paytm.o2o.movies.entity.BookingData r13 = r0.f74886a     // Catch:{ JSONException -> 0x053d }
            if (r13 != 0) goto L_0x0079
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053d }
        L_0x0079:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r13 = r13.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053d }
            java.lang.String r13 = r13.getMovieCode()     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r12, (java.lang.String) r13)     // Catch:{ JSONException -> 0x053d }
            java.lang.String r12 = "cinema"
            net.one97.paytm.o2o.movies.entity.BookingData r13 = r0.f74886a     // Catch:{ JSONException -> 0x053d }
            if (r13 != 0) goto L_0x008d
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053d }
        L_0x008d:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r13 = r13.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053d }
            java.lang.String r13 = r13.getCinemaName()     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (org.json.JSONObject) r8, (java.lang.String) r12, (java.lang.String) r13)     // Catch:{ JSONException -> 0x053d }
            java.lang.String r12 = "showTime"
            net.one97.paytm.o2o.movies.entity.BookingData r13 = r0.f74886a     // Catch:{ JSONException -> 0x053d }
            if (r13 != 0) goto L_0x00a1
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053d }
        L_0x00a1:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r13 = r13.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053d }
            java.lang.String r13 = r13.getRealShowDateTime()     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (org.json.JSONObject) r8, (java.lang.String) r12, (java.lang.String) r13)     // Catch:{ JSONException -> 0x053d }
            java.lang.String r12 = "cinemaId"
            net.one97.paytm.o2o.movies.entity.BookingData r13 = r0.f74886a     // Catch:{ JSONException -> 0x053d }
            if (r13 != 0) goto L_0x00b5
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053d }
        L_0x00b5:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r13 = r13.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053d }
            java.lang.String r13 = r13.getCinemaID()     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (org.json.JSONObject) r8, (java.lang.String) r12, (java.lang.String) r13)     // Catch:{ JSONException -> 0x053d }
            java.lang.String r12 = "providerId"
            net.one97.paytm.o2o.movies.entity.BookingData r13 = r0.f74886a     // Catch:{ JSONException -> 0x053d }
            if (r13 != 0) goto L_0x00c9
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053d }
        L_0x00c9:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r13 = r13.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053d }
            java.lang.String r13 = r13.getProviderId()     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (org.json.JSONObject) r8, (java.lang.String) r12, (java.lang.String) r13)     // Catch:{ JSONException -> 0x053d }
            java.lang.String r12 = "ticketCount"
            net.one97.paytm.o2o.movies.entity.BookingData r13 = r0.f74886a     // Catch:{ JSONException -> 0x053d }
            if (r13 != 0) goto L_0x00dd
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053d }
        L_0x00dd:
            int r13 = r13.getSeatCount()     // Catch:{ JSONException -> 0x053d }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r8, (org.json.JSONObject) r9, (java.lang.String) r12, (java.lang.Object) r13)     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.entity.BookingData r12 = r0.f74886a     // Catch:{ JSONException -> 0x053d }
            if (r12 != 0) goto L_0x00ef
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053d }
        L_0x00ef:
            java.util.ArrayList r12 = r12.getMSelectedSeatList()     // Catch:{ JSONException -> 0x053d }
            java.util.List r12 = (java.util.List) r12     // Catch:{ JSONException -> 0x053d }
            java.lang.Object r12 = kotlin.a.k.e(r12)     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat r12 = (net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat) r12     // Catch:{ JSONException -> 0x053d }
            if (r12 == 0) goto L_0x0111
            java.lang.String r13 = "seatAreaCode"
            java.lang.String r15 = r12.getAreaCode()     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r13, (java.lang.String) r15)     // Catch:{ JSONException -> 0x053d }
            java.lang.String r13 = "circleName"
            java.lang.String r12 = r12.getAreaCircleName()     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r13, (java.lang.String) r12)     // Catch:{ JSONException -> 0x053d }
            kotlin.x r12 = kotlin.x.f47997a     // Catch:{ JSONException -> 0x053d }
        L_0x0111:
            java.lang.String r12 = "configuration"
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r7, (java.lang.String) r12, (java.lang.Object) r8)     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r8 = r0.I     // Catch:{ JSONException -> 0x053d }
            java.lang.String r12 = "transId"
            if (r8 == 0) goto L_0x012a
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r8 = r0.I     // Catch:{ JSONException -> 0x053d }
            if (r8 != 0) goto L_0x0123
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x053d }
        L_0x0123:
            java.lang.String r8 = r8.getTempTransId()     // Catch:{ JSONException -> 0x053d }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r12, (java.lang.String) r8)     // Catch:{ JSONException -> 0x053d }
        L_0x012a:
            net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat r8 = r0.f74889d     // Catch:{ JSONException -> 0x053d }
            java.lang.String r13 = "bookingIndex"
            java.lang.String r15 = "uniqueBookingId"
            r16 = r5
            java.lang.String r5 = "bookingId"
            if (r8 == 0) goto L_0x0160
            net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat r8 = r0.f74889d     // Catch:{ JSONException -> 0x053a }
            if (r8 != 0) goto L_0x013d
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x053a }
        L_0x013d:
            java.lang.String r8 = r8.getBookingId()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r5, (java.lang.String) r8)     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat r8 = r0.f74889d     // Catch:{ JSONException -> 0x053a }
            if (r8 != 0) goto L_0x014b
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x053a }
        L_0x014b:
            java.lang.String r8 = r8.getUniqueBookingId()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r15, (java.lang.String) r8)     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat r8 = r0.f74889d     // Catch:{ JSONException -> 0x053a }
            if (r8 != 0) goto L_0x0159
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x053a }
        L_0x0159:
            java.lang.String r8 = r8.getBookingIndex()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r13, (java.lang.String) r8)     // Catch:{ JSONException -> 0x053a }
        L_0x0160:
            java.lang.String r8 = "sessionId"
            r17 = r6
            net.one97.paytm.o2o.movies.entity.BookingData r6 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r6 != 0) goto L_0x016b
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x016b:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r6 = r6.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r6 = r6.getSessionID()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r8, (java.lang.String) r6)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r6 = "branchCode"
            net.one97.paytm.o2o.movies.entity.BookingData r8 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r8 != 0) goto L_0x017f
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x017f:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = r8.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r8 = r8.getBranchCode()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r6, (java.lang.String) r8)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r6 = "address"
            net.one97.paytm.o2o.movies.entity.BookingData r8 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r8 != 0) goto L_0x0193
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x0193:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = r8.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r8 = r8.getAddress()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r6, (java.lang.String) r8)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r6 = "screenNum"
            net.one97.paytm.o2o.movies.entity.BookingData r8 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r8 != 0) goto L_0x01a7
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x01a7:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = r8.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r8 = r8.getScreenNumber()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r6, (java.lang.String) r8)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r6 = "multipleEticket"
            net.one97.paytm.o2o.movies.entity.BookingData r8 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r8 != 0) goto L_0x01bb
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x01bb:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = r8.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r8 = r8.getMultipleTickets()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r6, (java.lang.String) r8)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r6 = "audi"
            net.one97.paytm.o2o.movies.entity.BookingData r8 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r8 != 0) goto L_0x01cf
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x01cf:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = r8.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r8 = r8.getAudi()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r6, (java.lang.String) r8)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r6 = "latitude"
            net.one97.paytm.o2o.movies.entity.BookingData r8 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r8 != 0) goto L_0x01e3
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x01e3:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = r8.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r8 = r8.getmLatitude()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r6, (java.lang.String) r8)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r6 = "longitude"
            net.one97.paytm.o2o.movies.entity.BookingData r8 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r8 != 0) goto L_0x01f7
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x01f7:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = r8.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r8 = r8.getmLongitude()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r6, (java.lang.String) r8)     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r6 = r0.I     // Catch:{ JSONException -> 0x0233 }
            if (r6 == 0) goto L_0x0233
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0233 }
            r6.<init>()     // Catch:{ JSONException -> 0x0233 }
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r8 = r0.I     // Catch:{ JSONException -> 0x0233 }
            if (r8 != 0) goto L_0x0212
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x0233 }
        L_0x0212:
            java.util.ArrayList r8 = r8.getSeatCodes()     // Catch:{ JSONException -> 0x0233 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ JSONException -> 0x0233 }
        L_0x021a:
            boolean r18 = r8.hasNext()     // Catch:{ JSONException -> 0x0233 }
            if (r18 == 0) goto L_0x0230
            java.lang.Object r18 = r8.next()     // Catch:{ JSONException -> 0x0233 }
            r19 = r8
            r8 = r18
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ JSONException -> 0x0233 }
            r6.put(r8)     // Catch:{ JSONException -> 0x0233 }
            r8 = r19
            goto L_0x021a
        L_0x0230:
            r9.put(r3, r6)     // Catch:{ JSONException -> 0x0233 }
        L_0x0233:
            java.lang.String r6 = "totalTicketPrice"
            r9.put(r6, r10)     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r6 = r0.I     // Catch:{ JSONException -> 0x053a }
            java.lang.String r8 = "seatType"
            java.lang.String r10 = "seatIdsReturned"
            if (r6 == 0) goto L_0x026f
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r6 = r0.I     // Catch:{ JSONException -> 0x053a }
            if (r6 != 0) goto L_0x0247
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x053a }
        L_0x0247:
            java.lang.String r6 = r6.getSeatInfo()     // Catch:{ JSONException -> 0x053a }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ JSONException -> 0x053a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x053a }
            if (r6 != 0) goto L_0x026f
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r6 = r0.I     // Catch:{ JSONException -> 0x053a }
            if (r6 != 0) goto L_0x025a
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x053a }
        L_0x025a:
            java.lang.String r6 = r6.getSeatInfo()     // Catch:{ JSONException -> 0x053a }
            r9.put(r10, r6)     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r6 = r0.I     // Catch:{ JSONException -> 0x053a }
            if (r6 != 0) goto L_0x0268
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x053a }
        L_0x0268:
            java.lang.String r6 = r6.getSeatInfo()     // Catch:{ JSONException -> 0x053a }
            r9.put(r8, r6)     // Catch:{ JSONException -> 0x053a }
        L_0x026f:
            java.lang.String r6 = r22.h()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r11 = "isPromoAutoApply"
            r18 = r7
            r7 = r26
            r9.put(r11, r7)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r7 = "_seatType"
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r7, (java.lang.String) r6)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r6 = "language"
            net.one97.paytm.o2o.movies.entity.BookingData r7 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r7 != 0) goto L_0x028a
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x028a:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovies r7 = r7.getMSelectedMovie()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r7 = r7.getLanguage()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r6 = "movieImageUrl"
            net.one97.paytm.o2o.movies.entity.BookingData r7 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r7 != 0) goto L_0x029e
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x029e:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovies r7 = r7.getMSelectedMovie()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r7 = r7.getImageURL()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r6 = "censor"
            net.one97.paytm.o2o.movies.entity.BookingData r7 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r7 != 0) goto L_0x02b2
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x02b2:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovies r7 = r7.getMSelectedMovie()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r7 = r7.getCensor()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r6 = "duration"
            net.one97.paytm.o2o.movies.entity.BookingData r7 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r7 != 0) goto L_0x02c6
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x02c6:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovies r7 = r7.getMSelectedMovie()     // Catch:{ JSONException -> 0x053a }
            int r7 = r7.getDuration()     // Catch:{ JSONException -> 0x053a }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x053a }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x053a }
            r6.<init>()     // Catch:{ JSONException -> 0x053a }
            android.app.Application r7 = r22.getApplication()     // Catch:{ JSONException -> 0x053a }
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)     // Catch:{ JSONException -> 0x053a }
            android.content.Context r7 = r7.getApplicationContext()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r7 = com.paytm.utility.b.j((android.content.Context) r7)     // Catch:{ JSONException -> 0x053a }
            android.app.Application r11 = r22.getApplication()     // Catch:{ JSONException -> 0x053a }
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r4)     // Catch:{ JSONException -> 0x053a }
            android.content.Context r11 = r11.getApplicationContext()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r11 = com.paytm.utility.b.m((android.content.Context) r11)     // Catch:{ JSONException -> 0x053a }
            r19 = r8
            android.app.Application r8 = r22.getApplication()     // Catch:{ JSONException -> 0x053a }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)     // Catch:{ JSONException -> 0x053a }
            android.content.Context r8 = r8.getApplicationContext()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r8 = com.paytm.utility.b.l((android.content.Context) r8)     // Catch:{ JSONException -> 0x053a }
            r20 = r4
            java.lang.String r4 = "name"
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r6, (java.lang.String) r4, (java.lang.String) r7)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r4 = "email"
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r6, (java.lang.String) r4, (java.lang.String) r11)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r4 = "mobileNumber"
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r6, (java.lang.String) r4, (java.lang.String) r8)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r4 = "passenger"
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r4, (java.lang.Object) r6)     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.common.movies.booking.CJRConvenienceFee r4 = r0.M     // Catch:{ JSONException -> 0x053a }
            if (r4 == 0) goto L_0x0343
            net.one97.paytm.o2o.movies.common.movies.booking.CJRConvenienceFee r4 = r0.M     // Catch:{ JSONException -> 0x053a }
            if (r4 != 0) goto L_0x032a
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x053a }
        L_0x032a:
            a((org.json.JSONObject) r9, (net.one97.paytm.o2o.movies.common.movies.booking.CJRConvenienceFee) r4)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r4 = "totalCommision"
            net.one97.paytm.o2o.movies.common.movies.booking.CJRConvenienceFee r6 = r0.M     // Catch:{ JSONException -> 0x053a }
            if (r6 != 0) goto L_0x0336
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x053a }
        L_0x0336:
            java.lang.String r6 = r6.getTotalCommision()     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r4, (java.lang.String) r6)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r4 = "convFeeApiVersion"
            r6 = 2
            r9.put(r4, r6)     // Catch:{ JSONException -> 0x053a }
        L_0x0343:
            java.lang.String r4 = "citySearched"
            java.lang.String r6 = r0.f74892g     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r4, (java.lang.String) r6)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r4 = "multipleEticketSelected"
            r6 = 1
            r9.put(r4, r6)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r4 = "source"
            java.lang.String r7 = r0.f74890e     // Catch:{ JSONException -> 0x053a }
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r9, (java.lang.String) r4, (java.lang.String) r7)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r4 = "freeSeating"
            net.one97.paytm.o2o.movies.entity.BookingData r7 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r7 != 0) goto L_0x0360
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x0360:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r7 = r7.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053a }
            boolean r7 = r7.isFreeSeating()     // Catch:{ JSONException -> 0x053a }
            r9.put(r4, r7)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r4 = "tokenFeeOnly"
            net.one97.paytm.o2o.movies.entity.BookingData r7 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r7 != 0) goto L_0x0374
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x0374:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r7 = r7.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053a }
            boolean r7 = r7.isTokenFeeOnly()     // Catch:{ JSONException -> 0x053a }
            r9.put(r4, r7)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r4 = "tokenFeePickupTime"
            net.one97.paytm.o2o.movies.entity.BookingData r7 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r7 != 0) goto L_0x0388
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x0388:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r7 = r7.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053a }
            int r7 = r7.getTokenFeePickupTime()     // Catch:{ JSONException -> 0x053a }
            r9.put(r4, r7)     // Catch:{ JSONException -> 0x053a }
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2> r4 = r0.H     // Catch:{ JSONException -> 0x053a }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ JSONException -> 0x053a }
            if (r4 == 0) goto L_0x03a2
            boolean r4 = r4.isEmpty()     // Catch:{ JSONException -> 0x053a }
            if (r4 == 0) goto L_0x03a0
            goto L_0x03a2
        L_0x03a0:
            r4 = 0
            goto L_0x03a3
        L_0x03a2:
            r4 = 1
        L_0x03a3:
            r4 = r4 ^ r6
            java.lang.String r8 = "isFoodVoucherPresent"
            java.lang.String r11 = "isFoodPresent"
            r21 = 0
            if (r1 == 0) goto L_0x040c
            if (r23 == 0) goto L_0x03cb
            if (r4 == 0) goto L_0x03cb
            java.lang.String r7 = r1.mFood     // Catch:{ JSONException -> 0x053a }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ JSONException -> 0x053a }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x053a }
            if (r7 != 0) goto L_0x03cb
            java.lang.String r7 = r0.D     // Catch:{ JSONException -> 0x053a }
            org.json.JSONObject r7 = r0.a((net.one97.paytm.o2o.movies.entity.CJRFoodBeverageSetResponseV2) r1, (java.lang.String) r7)     // Catch:{ JSONException -> 0x053a }
            if (r7 == 0) goto L_0x03c6
            r9.put(r11, r6)     // Catch:{ JSONException -> 0x053a }
            goto L_0x03d1
        L_0x03c6:
            r7 = 0
            r9.put(r11, r7)     // Catch:{ JSONException -> 0x053a }
            goto L_0x03cf
        L_0x03cb:
            r7 = 0
            r9.put(r11, r7)     // Catch:{ JSONException -> 0x053a }
        L_0x03cf:
            r7 = r21
        L_0x03d1:
            if (r23 == 0) goto L_0x03f0
            if (r4 == 0) goto L_0x03f0
            java.lang.String r4 = r1.mFoodVoucher     // Catch:{ JSONException -> 0x053a }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ JSONException -> 0x053a }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x053a }
            if (r4 != 0) goto L_0x03f0
            java.lang.String r4 = r0.E     // Catch:{ JSONException -> 0x053a }
            org.json.JSONObject r4 = r0.a((net.one97.paytm.o2o.movies.entity.CJRFoodBeverageSetResponseV2) r1, (java.lang.String) r4)     // Catch:{ JSONException -> 0x053a }
            if (r4 == 0) goto L_0x03eb
            r9.put(r8, r6)     // Catch:{ JSONException -> 0x053a }
            goto L_0x03f6
        L_0x03eb:
            r4 = 0
            r9.put(r8, r4)     // Catch:{ JSONException -> 0x053a }
            goto L_0x03f4
        L_0x03f0:
            r4 = 0
            r9.put(r8, r4)     // Catch:{ JSONException -> 0x053a }
        L_0x03f4:
            r4 = r21
        L_0x03f6:
            java.lang.String r8 = r1.m3dGlass     // Catch:{ JSONException -> 0x053a }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ JSONException -> 0x053a }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x053a }
            if (r8 != 0) goto L_0x0409
            org.json.JSONObject r1 = r0.a((net.one97.paytm.o2o.movies.entity.CJRFoodBeverageSetResponseV2) r1)     // Catch:{ JSONException -> 0x053a }
            if (r1 == 0) goto L_0x0409
            kotlin.x r8 = kotlin.x.f47997a     // Catch:{ JSONException -> 0x053a }
            goto L_0x0417
        L_0x0409:
            r1 = r21
            goto L_0x0417
        L_0x040c:
            r1 = 0
            r9.put(r11, r1)     // Catch:{ JSONException -> 0x053a }
            r9.put(r8, r1)     // Catch:{ JSONException -> 0x053a }
            r1 = r21
            r4 = r1
            r7 = r4
        L_0x0417:
            int r8 = r0.Y     // Catch:{ JSONException -> 0x053a }
            if (r8 != r6) goto L_0x0420
            java.lang.String r8 = "isMandatoryVoucher"
            r9.put(r8, r6)     // Catch:{ JSONException -> 0x053a }
        L_0x0420:
            boolean r8 = r0.S     // Catch:{ JSONException -> 0x053a }
            java.lang.String r11 = "isInsurancePresentV2"
            if (r8 == 0) goto L_0x0439
            r9.put(r11, r6)     // Catch:{ JSONException -> 0x053a }
            org.json.JSONObject r6 = r0.a((net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieGetCancelProtect) r2)     // Catch:{ JSONException -> 0x053a }
            if (r6 == 0) goto L_0x0434
            java.lang.String r8 = "insurance"
            r9.put(r8, r6)     // Catch:{ JSONException -> 0x053a }
        L_0x0434:
            org.json.JSONObject r21 = r0.b((net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieGetCancelProtect) r2)     // Catch:{ JSONException -> 0x053a }
            goto L_0x043d
        L_0x0439:
            r2 = 0
            r9.put(r11, r2)     // Catch:{ JSONException -> 0x053a }
        L_0x043d:
            r2 = r21
            net.one97.paytm.o2o.movies.entity.CJRMovieNewCancellationProtect r6 = r0.aa     // Catch:{ JSONException -> 0x053a }
            if (r6 == 0) goto L_0x0462
            net.one97.paytm.o2o.movies.entity.CJRMovieNewCancellationProtect r6 = r0.aa     // Catch:{ JSONException -> 0x053a }
            if (r6 != 0) goto L_0x044a
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x053a }
        L_0x044a:
            java.lang.String r6 = r6.metaObject     // Catch:{ JSONException -> 0x053a }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ JSONException -> 0x053a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x053a }
            if (r6 != 0) goto L_0x0462
            java.lang.String r6 = "meta"
            net.one97.paytm.o2o.movies.entity.CJRMovieNewCancellationProtect r8 = r0.aa     // Catch:{ JSONException -> 0x053a }
            if (r8 != 0) goto L_0x045d
            kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x053a }
        L_0x045d:
            java.lang.String r8 = r8.metaObject     // Catch:{ JSONException -> 0x053a }
            r9.put(r6, r8)     // Catch:{ JSONException -> 0x053a }
        L_0x0462:
            net.one97.paytm.o2o.movies.entity.BookingData r6 = r0.f74886a     // Catch:{ JSONException -> 0x053a }
            if (r6 != 0) goto L_0x0469
            kotlin.g.b.k.a((java.lang.String) r14)     // Catch:{ JSONException -> 0x053a }
        L_0x0469:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r6 = r6.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x053a }
            boolean r6 = r6.isFreeSeating()     // Catch:{ JSONException -> 0x053a }
            if (r6 == 0) goto L_0x04f1
            net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat r6 = r0.f74889d     // Catch:{ JSONException -> 0x053a }
            if (r6 == 0) goto L_0x04f1
            java.lang.String r8 = r6.getTempTransId()     // Catch:{ JSONException -> 0x053a }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ JSONException -> 0x053a }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x053a }
            if (r8 != 0) goto L_0x048a
            java.lang.String r8 = r6.getTempTransId()     // Catch:{ JSONException -> 0x053a }
            r9.put(r12, r8)     // Catch:{ JSONException -> 0x053a }
        L_0x048a:
            java.lang.String r8 = r6.getBookingId()     // Catch:{ JSONException -> 0x053a }
            r9.put(r5, r8)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r5 = r6.getUniqueBookingId()     // Catch:{ JSONException -> 0x053a }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ JSONException -> 0x053a }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x053a }
            if (r5 != 0) goto L_0x04a4
            java.lang.String r5 = r6.getUniqueBookingId()     // Catch:{ JSONException -> 0x053a }
            r9.put(r15, r5)     // Catch:{ JSONException -> 0x053a }
        L_0x04a4:
            java.lang.String r5 = r6.getBookingIndex()     // Catch:{ JSONException -> 0x053a }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ JSONException -> 0x053a }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x053a }
            if (r5 != 0) goto L_0x04b7
            java.lang.String r5 = r6.getBookingIndex()     // Catch:{ JSONException -> 0x053a }
            r9.put(r13, r5)     // Catch:{ JSONException -> 0x053a }
        L_0x04b7:
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x053a }
            r5.<init>()     // Catch:{ JSONException -> 0x053a }
            java.util.ArrayList r8 = r6.getSeatCodes()     // Catch:{ JSONException -> 0x053a }
            if (r8 == 0) goto L_0x04da
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ JSONException -> 0x053a }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ JSONException -> 0x053a }
        L_0x04c8:
            boolean r11 = r8.hasNext()     // Catch:{ JSONException -> 0x053a }
            if (r11 == 0) goto L_0x04d8
            java.lang.Object r11 = r8.next()     // Catch:{ JSONException -> 0x053a }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ JSONException -> 0x053a }
            r5.put(r11)     // Catch:{ JSONException -> 0x053a }
            goto L_0x04c8
        L_0x04d8:
            kotlin.x r8 = kotlin.x.f47997a     // Catch:{ JSONException -> 0x053a }
        L_0x04da:
            r9.put(r3, r5)     // Catch:{ JSONException -> 0x053a }
            java.lang.String r3 = r6.getSeatInfo()     // Catch:{ JSONException -> 0x053a }
            if (r3 == 0) goto L_0x04f1
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.a.d.b(r3)     // Catch:{ JSONException -> 0x053a }
            if (r3 == 0) goto L_0x04f1
            r9.put(r10, r3)     // Catch:{ JSONException -> 0x053a }
            r5 = r19
            r9.put(r5, r3)     // Catch:{ JSONException -> 0x053a }
        L_0x04f1:
            java.lang.String r3 = "meta_data"
            r5 = r18
            r5.put(r3, r9)     // Catch:{ JSONException -> 0x053a }
            r3 = r17
            r3.put(r5)     // Catch:{ JSONException -> 0x053a }
            if (r7 == 0) goto L_0x0502
            r3.put(r7)     // Catch:{ JSONException -> 0x053a }
        L_0x0502:
            if (r4 == 0) goto L_0x0507
            r3.put(r4)     // Catch:{ JSONException -> 0x053a }
        L_0x0507:
            boolean r4 = r0.S     // Catch:{ JSONException -> 0x053a }
            if (r4 == 0) goto L_0x0510
            if (r2 == 0) goto L_0x0510
            r3.put(r2)     // Catch:{ JSONException -> 0x053a }
        L_0x0510:
            if (r1 == 0) goto L_0x0515
            r3.put(r1)     // Catch:{ JSONException -> 0x053a }
        L_0x0515:
            java.lang.String r1 = "cart_items"
            r2 = r16
            r2.put(r1, r3)     // Catch:{ JSONException -> 0x053e }
            java.lang.String r1 = "channel"
            java.lang.String r3 = com.paytm.utility.c.f43762a     // Catch:{ JSONException -> 0x053e }
            r2.put(r1, r3)     // Catch:{ JSONException -> 0x053e }
            android.app.Application r1 = r22.getApplication()     // Catch:{ JSONException -> 0x053e }
            r3 = r20
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)     // Catch:{ JSONException -> 0x053e }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ JSONException -> 0x053e }
            java.lang.String r1 = com.paytm.utility.b.Q((android.content.Context) r1)     // Catch:{ JSONException -> 0x053e }
            java.lang.String r3 = "version"
            net.one97.paytm.o2o.movies.utils.j.a((org.json.JSONObject) r2, (java.lang.String) r3, (java.lang.String) r1)     // Catch:{ JSONException -> 0x053e }
            goto L_0x053e
        L_0x053a:
            r2 = r16
            goto L_0x053e
        L_0x053d:
            r2 = r5
        L_0x053e:
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "jsonCart.toString()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.b.b(boolean, net.one97.paytm.o2o.movies.entity.CJRFoodBeverageSetResponseV2, net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieGetCancelProtect, boolean):java.lang.String");
    }

    private final JSONObject a(CJRFoodBeverageSetResponseV2 cJRFoodBeverageSetResponseV2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject.put(CLPConstants.PRODUCT_ID, this.ao);
            jSONObject.put("qty", "1");
            jSONObject2.put("price", this.am);
            jSONObject2.put("charges", this.an);
            jSONObject2.put("ty", "3dglasses");
            jSONObject.putOpt(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject2);
            jSONObject3.put("item", new JSONObject(cJRFoodBeverageSetResponseV2.m3dGlass));
            jSONObject.put("meta_data", jSONObject3);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private final String a(CJRMoviesSession cJRMoviesSession, CJRMovies cJRMovies, String str, String str2, String str3, ArrayList<CJRObjSeat> arrayList, CJRConvenienceFee cJRConvenienceFee, int i2) {
        CJRMoviesSession cJRMoviesSession2 = cJRMoviesSession;
        String str4 = str2;
        String str5 = str3;
        ArrayList<CJRObjSeat> arrayList2 = arrayList;
        CJRConvenienceFee cJRConvenienceFee2 = cJRConvenienceFee;
        int i3 = i2;
        JSONObject jSONObject = new JSONObject();
        if (arrayList2 == null) {
            try {
                k.a();
            } catch (JSONException unused) {
            }
        }
        double a2 = a(arrayList2, cJRMoviesSession2, i3);
        if (!TextUtils.isEmpty(cJRMovies.getTitle())) {
            jSONObject.put("movie", cJRMovies.getTitle());
            jSONObject.put("movieCode", cJRMoviesSession2 != null ? cJRMoviesSession.getMovieCode() : null);
        }
        if (cJRMoviesSession2 != null) {
            j.a(jSONObject, "cinema", cJRMoviesSession.getCinemaName());
            j.a(jSONObject, "showTime", cJRMoviesSession.getRealShowDateTime());
            j.a(jSONObject, "cinemaId", cJRMoviesSession.getCinemaID());
            j.a(jSONObject, "providerId", cJRMoviesSession.getProviderId());
        }
        jSONObject.put("ticketCount", i3);
        j.a(jSONObject, SDKConstants.KEY_TRANS_ID, str);
        if (cJRMoviesSession2 != null) {
            j.a(jSONObject, H5Param.SESSION_ID, cJRMoviesSession.getSessionID());
            j.a(jSONObject, "branchCode", cJRMoviesSession.getBranchCode());
            j.a(jSONObject, AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, cJRMoviesSession.getAddress());
            j.a(jSONObject, "screenNum", cJRMoviesSession.getScreenNumber());
            j.a(jSONObject, "multipleEticket", cJRMoviesSession.getMultipleTickets());
            j.a(jSONObject, "audi", cJRMoviesSession.getAudi());
            j.a(jSONObject, "latitude", cJRMoviesSession.getmLatitude());
            j.a(jSONObject, "longitude", cJRMoviesSession.getmLongitude());
        }
        if (arrayList.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            int size = arrayList2.size();
            String str6 = "";
            double d2 = 0.0d;
            int i4 = 0;
            while (i4 < size) {
                CJRObjSeat cJRObjSeat = arrayList2.get(i4);
                k.a((Object) cJRObjSeat, "selectedSeatList[j]");
                CJRObjSeat cJRObjSeat2 = cJRObjSeat;
                StringBuilder sb = new StringBuilder();
                int i5 = size;
                sb.append(cJRObjSeat2.getPhyRowId());
                sb.append("-");
                sb.append(cJRObjSeat2.getSeatNumber());
                jSONArray.put(sb.toString());
                if (TextUtils.isEmpty(str6)) {
                    String areaDesc = cJRObjSeat2.getAreaDesc();
                    k.a((Object) areaDesc, "objSeat.areaDesc");
                    str6 = areaDesc;
                }
                stringBuffer.append(cJRObjSeat2.getPhyRowId() + cJRObjSeat2.getSeatNumber());
                if (i4 != arrayList.size() - 1) {
                    stringBuffer.append(',');
                }
                double d3 = d2;
                if (d3 == 0.0d) {
                    d3 = cJRObjSeat2.getPrice() + cJRObjSeat2.getVoucherPrice();
                }
                d2 = d3;
                i4++;
                CJRMoviesSession cJRMoviesSession3 = cJRMoviesSession;
                String str7 = str2;
                arrayList2 = arrayList;
                size = i5;
            }
            String str8 = str6 + '-' + stringBuffer;
            jSONArray2.put(str8);
            jSONObject.put("seatIds", jSONArray);
            jSONObject.put("seatCodes", jSONArray2);
            jSONObject.put("singleTicketPrice", d2);
            j.a(jSONObject, "seatType", str6);
            j.a(jSONObject, "seatIdsReturned", str8);
        }
        if (cJRConvenienceFee2 != null) {
            jSONObject.put("convFee", Double.parseDouble(cJRConvenienceFee.getTotalCommision()));
        }
        jSONObject.put("totalTicketPrice", a2);
        jSONObject.put("isFreeMovie", 0);
        if (!TextUtils.isEmpty(cJRMovies.getLanguage())) {
            jSONObject.put("language", cJRMovies.getLanguage());
        }
        if (!TextUtils.isEmpty(cJRMovies.getImageURL())) {
            jSONObject.put("movieImageUrl", cJRMovies.getImageURL());
        }
        if (!TextUtils.isEmpty(cJRMovies.getCensor())) {
            jSONObject.put("censor", cJRMovies.getCensor());
        }
        jSONObject.put(AppConstants.DURATION, cJRMovies.getDuration());
        JSONObject jSONObject2 = new JSONObject();
        Application application = getApplication();
        k.a((Object) application, "getApplication<Application>()");
        String j2 = com.paytm.utility.b.j(application.getApplicationContext());
        Application application2 = getApplication();
        k.a((Object) application2, "getApplication<Application>()");
        String m2 = com.paytm.utility.b.m(application2.getApplicationContext());
        Application application3 = getApplication();
        k.a((Object) application3, "getApplication<Application>()");
        String l2 = com.paytm.utility.b.l(application3.getApplicationContext());
        if (!TextUtils.isEmpty(j2)) {
            jSONObject2.put("name", j2);
        }
        if (!TextUtils.isEmpty(m2)) {
            jSONObject2.put(AppConstants.KEY_EMAIL, m2);
        }
        if (!TextUtils.isEmpty(l2)) {
            jSONObject2.put("mobileNumber", l2);
        }
        jSONObject.put("passenger", jSONObject2);
        if (cJRConvenienceFee2 != null) {
            a(jSONObject, cJRConvenienceFee2);
            if (!TextUtils.isEmpty(cJRConvenienceFee.getTotalCommision())) {
                jSONObject.put("totalCommision", cJRConvenienceFee.getTotalCommision());
            }
            jSONObject.put("convFeeApiVersion", 2);
        }
        if (!TextUtils.isEmpty(str5)) {
            jSONObject.put("citySearched", str5);
            jSONObject.put("paytmCityName", str5);
        }
        jSONObject.put("multipleEticketSelected", true);
        String str9 = str2;
        if (!TextUtils.isEmpty(str9)) {
            jSONObject.put("source", str9);
        }
        if (cJRMoviesSession != null) {
            jSONObject.put("freeSeating", cJRMoviesSession.isFreeSeating());
            jSONObject.put("tokenFeeOnly", cJRMoviesSession.isTokenFeeOnly());
            jSONObject.put("tokenFeePickupTime", cJRMoviesSession.getTokenFeePickupTime());
        }
        jSONObject.put("channel", com.paytm.utility.c.f43762a);
        Application application4 = getApplication();
        k.a((Object) application4, "getApplication<Application>()");
        String Q2 = com.paytm.utility.b.Q(application4.getApplicationContext());
        if (!TextUtils.isEmpty(Q2)) {
            jSONObject.put("version", Q2);
        }
        Application application5 = getApplication();
        k.a((Object) application5, "getApplication<Application>()");
        String n2 = com.paytm.utility.b.n(application5.getApplicationContext());
        if (!TextUtils.isEmpty(n2)) {
            jSONObject.put("user_id", n2);
        }
        String jSONObject3 = jSONObject.toString();
        k.a((Object) jSONObject3, "jsonCart.toString()");
        return jSONObject3;
    }

    private final JSONObject a(CJRFoodBeverageSetResponseV2 cJRFoodBeverageSetResponseV2, String str) {
        JSONObject jSONObject;
        String str2;
        double d2;
        JSONObject jSONObject2;
        double d3;
        String str3;
        CJRFoodBeverageSetResponseV2 cJRFoodBeverageSetResponseV22 = cJRFoodBeverageSetResponseV2;
        String str4 = str;
        try {
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            String str5 = "ty";
            double d4 = 0.0d;
            if (!k.a((Object) str4, (Object) this.D)) {
                String str6 = str5;
                if (k.a((Object) str4, (Object) this.E)) {
                    if (cJRFoodBeverageSetResponseV22.mFoodVoucher == null) {
                        return null;
                    }
                    ArrayList<CJRFoodBeverageItemV2> arrayList = this.H;
                    if (arrayList != null) {
                        Collection arrayList2 = new ArrayList();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            Object next = it2.next();
                            Iterator it3 = it2;
                            String str7 = str6;
                            if (kotlin.m.p.a(CJRFoodBeverageItemV2.FOOD_VOUCHER, ((CJRFoodBeverageItemV2) next).getType(), true)) {
                                arrayList2.add(next);
                            }
                            it2 = it3;
                            str6 = str7;
                        }
                        str2 = str6;
                        double d5 = 0.0d;
                        for (Iterator it4 = ((List) arrayList2).iterator(); it4.hasNext(); it4 = it4) {
                            CJRFoodBeverageItemV2 cJRFoodBeverageItemV2 = (CJRFoodBeverageItemV2) it4.next();
                            String str8 = cJRFoodBeverageItemV2.getmPrice();
                            k.a((Object) str8, "it.getmPrice()");
                            d5 += Double.parseDouble(str8) * ((double) cJRFoodBeverageItemV2.getmFoodQauntitySelected());
                        }
                        d2 = d5;
                    } else {
                        str2 = str6;
                        d2 = 0.0d;
                    }
                    ArrayList<CJRFoodBeverageItemV2> arrayList3 = this.H;
                    if (arrayList3 != null) {
                        Collection arrayList4 = new ArrayList();
                        Iterator it5 = arrayList3.iterator();
                        while (it5.hasNext()) {
                            Object next2 = it5.next();
                            Iterator it6 = it5;
                            JSONObject jSONObject6 = jSONObject5;
                            if (kotlin.m.p.a(CJRFoodBeverageItemV2.FOOD_VOUCHER, ((CJRFoodBeverageItemV2) next2).getType(), true)) {
                                arrayList4.add(next2);
                            }
                            it5 = it6;
                            jSONObject5 = jSONObject6;
                        }
                        jSONObject2 = jSONObject5;
                        for (CJRFoodBeverageItemV2 cJRFoodBeverageItemV22 : (List) arrayList4) {
                            String str9 = cJRFoodBeverageItemV22.getmConvinienceFee();
                            k.a((Object) str9, "it.getmConvinienceFee()");
                            d4 += Double.parseDouble(str9);
                        }
                    } else {
                        jSONObject2 = jSONObject5;
                    }
                    jSONObject4.put("price", d2);
                    jSONObject4.put("conv_fee", d4);
                    ArrayList<CJRFoodBeverageItemV2> arrayList5 = this.H;
                    int i2 = 0;
                    if (arrayList5 != null) {
                        Collection arrayList6 = new ArrayList();
                        for (Object next3 : arrayList5) {
                            if (kotlin.m.p.a(CJRFoodBeverageItemV2.FOOD_VOUCHER, ((CJRFoodBeverageItemV2) next3).getType(), true)) {
                                arrayList6.add(next3);
                            }
                        }
                        for (CJRFoodBeverageItemV2 cJRFoodBeverageItemV23 : (List) arrayList6) {
                            i2 += cJRFoodBeverageItemV23.getmFoodQauntitySelected();
                        }
                    }
                    jSONObject3.put("qty", String.valueOf(i2));
                    jSONObject3.put(CLPConstants.PRODUCT_ID, this.V);
                    JSONObject jSONObject7 = new JSONObject(cJRFoodBeverageSetResponseV22.mFoodVoucher);
                    jSONObject = jSONObject2;
                    jSONObject.put(CJRFoodBeverageItemV2.FOOD_VOUCHER, jSONObject7);
                    String b2 = net.one97.paytm.o2o.movies.common.a.d.b(jSONObject7.optString("totalCharges"));
                    if (b2 == null) {
                        b2 = "0";
                    }
                    jSONObject4.put("charges", b2);
                    jSONObject4.put(str2, CJRFoodBeverageItemV2.FOOD_VOUCHER);
                    jSONObject3.putOpt(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject4);
                    jSONObject3.put("meta_data", jSONObject);
                    return jSONObject3;
                }
            } else if (cJRFoodBeverageSetResponseV22.mFood == null) {
                return null;
            } else {
                ArrayList<CJRFoodBeverageItemV2> arrayList7 = this.H;
                if (arrayList7 != null) {
                    Collection arrayList8 = new ArrayList();
                    Iterator it7 = arrayList7.iterator();
                    while (it7.hasNext()) {
                        try {
                            Object next4 = it7.next();
                            Iterator it8 = it7;
                            if (!k.a((Object) ((CJRFoodBeverageItemV2) next4).getType(), (Object) CJRFoodBeverageItemV2.FOOD_VOUCHER)) {
                                arrayList8.add(next4);
                            }
                            it7 = it8;
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                    double d6 = 0.0d;
                    for (Iterator it9 = ((List) arrayList8).iterator(); it9.hasNext(); it9 = it9) {
                        CJRFoodBeverageItemV2 cJRFoodBeverageItemV24 = (CJRFoodBeverageItemV2) it9.next();
                        String str10 = cJRFoodBeverageItemV24.getmPrice();
                        k.a((Object) str10, "it.getmPrice()");
                        d6 += Double.parseDouble(str10) * ((double) cJRFoodBeverageItemV24.getmFoodQauntitySelected());
                    }
                    d3 = d6;
                } else {
                    d3 = 0.0d;
                }
                ArrayList<CJRFoodBeverageItemV2> arrayList9 = this.H;
                if (arrayList9 != null) {
                    Collection arrayList10 = new ArrayList();
                    Iterator it10 = arrayList9.iterator();
                    while (it10.hasNext()) {
                        String str11 = str5;
                        Object next5 = it10.next();
                        Iterator it11 = it10;
                        if (!k.a((Object) ((CJRFoodBeverageItemV2) next5).getType(), (Object) CJRFoodBeverageItemV2.FOOD_VOUCHER)) {
                            arrayList10.add(next5);
                        }
                        it10 = it11;
                        str5 = str11;
                    }
                    str3 = str5;
                    for (CJRFoodBeverageItemV2 cJRFoodBeverageItemV25 : (List) arrayList10) {
                        String str12 = cJRFoodBeverageItemV25.getmConvinienceFee();
                        k.a((Object) str12, "it.getmConvinienceFee()");
                        d4 += Double.parseDouble(str12);
                    }
                } else {
                    str3 = str5;
                }
                jSONObject4.put("price", d3);
                jSONObject4.put("conv_fee", d4);
                jSONObject3.put("qty", "1");
                jSONObject3.put(CLPConstants.PRODUCT_ID, this.U);
                jSONObject5.put("food_beverages", new JSONObject(cJRFoodBeverageSetResponseV22.mFood));
                jSONObject4.put(str3, "fd");
            }
            jSONObject = jSONObject5;
            jSONObject3.putOpt(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject4);
            jSONObject3.put("meta_data", jSONObject);
            return jSONObject3;
        } catch (Exception unused2) {
            return null;
        }
    }

    private final JSONObject a(CJRMovieGetCancelProtect cJRMovieGetCancelProtect) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.aa != null) {
                CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect = this.aa;
                if (cJRMovieNewCancellationProtect == null) {
                    k.a();
                }
                jSONObject.put("message", cJRMovieNewCancellationProtect.getMessage());
                com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
                CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect2 = this.aa;
                if (cJRMovieNewCancellationProtect2 == null) {
                    k.a();
                }
                jSONObject.put("terms_cond", new JSONObject(fVar.a((Object) cJRMovieNewCancellationProtect2.getTermsCond())));
                CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect3 = this.aa;
                if (cJRMovieNewCancellationProtect3 == null) {
                    k.a();
                }
                jSONObject.put("total_insurance_price", cJRMovieNewCancellationProtect3.getTotalInsurancePrice());
                CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect4 = this.aa;
                if (cJRMovieNewCancellationProtect4 == null) {
                    k.a();
                }
                jSONObject.put("price_per_ticket", cJRMovieNewCancellationProtect4.getPricePerTicket());
                CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect5 = this.aa;
                if (cJRMovieNewCancellationProtect5 == null) {
                    k.a();
                }
                jSONObject.put("max_claim_amount", cJRMovieNewCancellationProtect5.getMaxClaimAmount());
                CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect6 = this.aa;
                if (cJRMovieNewCancellationProtect6 == null) {
                    k.a();
                }
                jSONObject.put("insurance_end_date", cJRMovieNewCancellationProtect6.getInsuranceEndDate());
                CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect7 = this.aa;
                if (cJRMovieNewCancellationProtect7 == null) {
                    k.a();
                }
                Boolean promocodeAllowed = cJRMovieNewCancellationProtect7.getPromocodeAllowed();
                k.a((Object) promocodeAllowed, "movieInsuranceModel!!.promocodeAllowed");
                jSONObject.put("promocodeAllowed", promocodeAllowed.booleanValue());
                com.google.gsonhtcfix.f fVar2 = new com.google.gsonhtcfix.f();
                CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect8 = this.aa;
                if (cJRMovieNewCancellationProtect8 == null) {
                    k.a();
                }
                jSONObject.put("total_price_tax_split", new JSONObject(fVar2.a((Object) cJRMovieNewCancellationProtect8.getTotalPriceTaxSplit())));
                com.google.gsonhtcfix.f fVar3 = new com.google.gsonhtcfix.f();
                CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect9 = this.aa;
                if (cJRMovieNewCancellationProtect9 == null) {
                    k.a();
                }
                jSONObject.put("showTaxInformation", new JSONArray(fVar3.a((Object) cJRMovieNewCancellationProtect9.getShowTaxInformation())));
            }
            if (!(cJRMovieGetCancelProtect == null || cJRMovieGetCancelProtect.getMeta_data() == null)) {
                CJRGetMovieCancelProtectMetadata meta_data = cJRMovieGetCancelProtect.getMeta_data();
                k.a((Object) meta_data, "cjrGetInsuranceMetadata");
                Integer insurance_id = meta_data.getInsurance_id();
                k.a((Object) insurance_id, "cjrGetInsuranceMetadata.insurance_id");
                jSONObject.put("insurance_id", insurance_id.intValue());
                Double insured_item_price = meta_data.getInsured_item_price();
                k.a((Object) insured_item_price, "cjrGetInsuranceMetadata.insured_item_price");
                jSONObject.put("insured_item_price", insured_item_price.doubleValue());
                jSONObject.put("start_date", meta_data.getStart_date_time());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private final JSONObject b(CJRMovieGetCancelProtect cJRMovieGetCancelProtect) {
        try {
            JSONObject jSONObject = new JSONObject(new com.google.gsonhtcfix.f().a((Object) cJRMovieGetCancelProtect));
            CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect = this.aa;
            if (cJRMovieNewCancellationProtect == null) {
                k.a();
            }
            if (!TextUtils.isEmpty(cJRMovieNewCancellationProtect.metaObject)) {
                try {
                    CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect2 = this.aa;
                    if (cJRMovieNewCancellationProtect2 == null) {
                        k.a();
                    }
                    jSONObject.getJSONObject("meta_data").put("meta", new JSONObject(cJRMovieNewCancellationProtect2.metaObject));
                } catch (Exception unused) {
                }
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static void a(JSONObject jSONObject, CJRConvenienceFee cJRConvenienceFee) {
        ArrayList<CJRTaxInfo> taxList = cJRConvenienceFee.getTaxList();
        if (taxList != null && taxList.size() > 0) {
            Iterator<CJRTaxInfo> it2 = taxList.iterator();
            while (it2.hasNext()) {
                CJRTaxInfo next = it2.next();
                k.a((Object) next, "tax");
                if (!TextUtils.isEmpty(next.getKey()) && !TextUtils.isEmpty(next.getValue())) {
                    try {
                        jSONObject.put(next.getKey(), next.getValue());
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        ArrayList<CJRTaxInfo> totalTaxList = cJRConvenienceFee.getTotalTaxList();
        if (totalTaxList != null && totalTaxList.size() > 0) {
            Iterator<CJRTaxInfo> it3 = totalTaxList.iterator();
            while (it3.hasNext()) {
                CJRTaxInfo next2 = it3.next();
                k.a((Object) next2, "totalTax");
                if (!TextUtils.isEmpty(next2.getKey()) && !TextUtils.isEmpty(next2.getValue())) {
                    try {
                        jSONObject.put(next2.getKey(), next2.getValue());
                    } catch (JSONException unused2) {
                    }
                }
            }
        }
    }

    private final void n() {
        String str;
        JSONObject jSONObject;
        com.paytm.utility.b.j();
        k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
        String c2 = net.one97.paytm.o2o.movies.common.b.c.c();
        Application application = getApplication();
        k.a((Object) application, "getApplication<Application>()");
        String b2 = com.paytm.utility.c.b(c2, application.getApplicationContext());
        StringBuilder sb = new StringBuilder();
        sb.append("&payment_info=1");
        sb.append("&payment_info_version=2");
        sb.append("&native_withdraw=1");
        if (this.ar == 1) {
            sb.append("&manual_promocode=1");
        }
        String str2 = b2 + sb.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        Application application2 = getApplication();
        k.a((Object) application2, "getApplication<Application>()");
        HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) hashMap, application2.getApplicationContext());
        k.a((Object) a2, "CJRAppCommonUtility.addS…on>().applicationContext)");
        Map<String, String> map = a2;
        map.put("ClientId", "paytm");
        CJRPrevalidate cJRPrevalidate = this.J;
        if (cJRPrevalidate != null) {
            if (cJRPrevalidate == null) {
                k.a();
            }
            str = cJRPrevalidate.getCartBody();
            k.a((Object) str, "mPrevalidate!!.cartBody");
            if (!TextUtils.isEmpty(this.as)) {
                StringBuilder sb2 = new StringBuilder(str);
                int a3 = kotlin.m.p.a((CharSequence) str, "}", kotlin.m.p.d(str));
                StringBuilder sb3 = new StringBuilder(",\"paymentFilters\":");
                String str3 = this.as;
                if (str3 == null) {
                    k.a();
                }
                sb3.append(str3);
                sb2.insert(a3, sb3.toString());
                str = sb2.toString();
                k.a((Object) str, "stringBuilder.toString()");
            } else if (!TextUtils.isEmpty(this.at)) {
                StringBuilder sb4 = new StringBuilder(str);
                sb4.insert(kotlin.m.p.a((CharSequence) str, "}", kotlin.m.p.d(str)), this.at);
                str = sb4.toString();
                k.a((Object) str, "stringBuilder.toString()");
            }
            if ((TextUtils.isEmpty(this.as) || this.ar == 1 || !TextUtils.isEmpty(this.at)) && !TextUtils.isEmpty(this.K)) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("action", "applypromo");
                    jSONObject.put("globalcode", this.K);
                    this.aA = ",\"promo_action\":" + jSONObject.toString();
                    StringBuilder sb5 = new StringBuilder(str);
                    sb5.insert(kotlin.m.p.a((CharSequence) str, "}", kotlin.m.p.d(str)), this.aA);
                    String sb6 = sb5.toString();
                    k.a((Object) sb6, "cartBuilder.toString()");
                    str = sb6;
                } catch (JSONException unused) {
                }
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                this.aA = null;
            }
        } else {
            str = "";
        }
        net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
        Application application3 = getApplication();
        k.a((Object) application3, "getApplication<Application>()");
        cVar.f42877a = application3.getApplicationContext();
        cVar.f42878b = a.c.MOVIES;
        cVar.f42879c = a.C0715a.POST;
        cVar.f42880d = str2;
        cVar.f42881e = null;
        cVar.f42882f = map;
        cVar.f42883g = null;
        cVar.f42884h = str;
        cVar.f42885i = new CJRMovieCart();
        cVar.j = new C1483b(this);
        cVar.n = a.b.USER_FACING;
        cVar.o = "movies";
        cVar.t = n.h("CJRJustTicketsBookingApiManager");
        com.paytm.network.a l2 = cVar.l();
        l2.f42859c = false;
        Application application4 = getApplication();
        k.a((Object) application4, "getApplication<Application>()");
        if (com.paytm.utility.b.c(application4.getApplicationContext())) {
            a();
            l2.a();
            return;
        }
        b();
        k.a((Object) l2, "networkCall");
        a(l2, false);
    }

    /* renamed from: net.one97.paytm.o2o.movies.b.b$b  reason: collision with other inner class name */
    public static final class C1483b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f74895a;

        C1483b(b bVar) {
            this.f74895a = bVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            HashMap<String, CJRCampaign> hashMap;
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            CJRMovieCart cJRMovieCart = (CJRMovieCart) iJRPaytmDataModel;
            if (this.f74895a.as != null) {
                if (this.f74895a.ay) {
                    if (cJRMovieCart.getCart() != null) {
                        CJRMCart cart = cJRMovieCart.getCart();
                        k.a((Object) cart, "cart.cart");
                        if (cart.getInstruments() == null) {
                            com.paytm.utility.b.b((Context) this.f74895a.f74888c, "Could not apply promocode", "Sorry, this promocode is temporarily unavailable. Please try again.");
                            this.f74895a.b();
                            return;
                        }
                    }
                    String str = cJRMovieCart.getCart().paymentInfo.mid;
                    PaytmSDKRequestClient.VerifyResponseData verifyResponseData = new PaytmSDKRequestClient.VerifyResponseData();
                    verifyResponseData.setPromoCode(this.f74895a.K);
                    verifyResponseData.setIs8DigitBin(b.b(this.f74895a.as));
                    verifyResponseData.setOfferText(this.f74895a.aD);
                    net.one97.paytm.o2o.movies.common.c.c cVar = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    String str2 = str;
                    Context g2 = this.f74895a.f74888c;
                    Activity g3 = this.f74895a.f74888c;
                    if (g3 != null) {
                        androidx.fragment.app.j supportFragmentManager = ((AppCompatActivity) g3).getSupportFragmentManager();
                        double l = this.f74895a.L;
                        CJRMCart cart2 = cJRMovieCart.getCart();
                        k.a((Object) cart2, "cart.cart");
                        CJPayMethodResponse instruments = cart2.getInstruments();
                        b bVar = this.f74895a;
                        cVar.openPromoPayOptionsBottomSheet(str2, g2, supportFragmentManager, l, instruments, bVar, bVar, verifyResponseData);
                    } else {
                        throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                    }
                } else {
                    b.a(this.f74895a, cJRMovieCart);
                }
                this.f74895a.as = null;
                return;
            }
            if (this.f74895a.ar == 1) {
                this.f74895a.ar = 0;
                CJRPromoMetaData cJRPromoMetaData = cJRMovieCart.getCart().promoMetaData;
                if (!(cJRPromoMetaData == null || (hashMap = cJRPromoMetaData.campData) == null)) {
                    CJRCampaign cJRCampaign = hashMap.get(this.f74895a.K);
                    if (cJRCampaign == null) {
                        k.a();
                    }
                    if (kotlin.m.p.a(Constants.BANK_OFFER_KEY, cJRCampaign.campaignType, true)) {
                        b.a(this.f74895a, cJRMovieCart);
                        return;
                    }
                }
            }
            if (!this.f74895a.P) {
                this.f74895a.b();
            }
            this.f74895a.al = cJRMovieCart;
            b.c(this.f74895a, cJRMovieCart);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "error");
            Application application = this.f74895a.getApplication();
            k.a((Object) application, "getApplication<Application>()");
            if (application.getApplicationContext() != null) {
                this.f74895a.K = null;
                this.f74895a.at = null;
                this.f74895a.b();
                this.f74895a.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
            }
        }
    }

    /* access modifiers changed from: private */
    public static Boolean b(String str) {
        try {
            if (str == null) {
                k.a();
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("is8DigitBin")) {
                return Boolean.valueOf(jSONObject.getBoolean("is8DigitBin"));
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    private final void o() {
        k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
        String a2 = net.one97.paytm.o2o.movies.common.b.c.a("checkBalance", (String) null);
        Application application = getApplication();
        k.a((Object) application, "getApplication<Application>()");
        String b2 = com.paytm.utility.b.b(application.getApplicationContext(), a2);
        Map hashMap = new HashMap();
        net.one97.paytm.o2o.movies.common.c.c cVar = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b;
        Application application2 = getApplication();
        k.a((Object) application2, "getApplication<Application>()");
        String sSOToken = cVar.getSSOToken(application2.getApplicationContext());
        k.a((Object) sSOToken, "MoviesController.getMovi…on>().applicationContext)");
        hashMap.put("ssotoken", sSOToken);
        k.a((Object) b2, "url");
        com.paytm.network.a a3 = a(b2, (Map<String, String>) hashMap, (String) null, (IJRPaytmDataModel) new CJRCashWallet());
        Application application3 = getApplication();
        k.a((Object) application3, "getApplication<Application>()");
        if (com.paytm.utility.b.c(application3.getApplicationContext())) {
            a();
            a3.a();
            return;
        }
        b();
        a(a3, false);
    }

    private final void p() {
        com.paytm.utility.b.j();
        try {
            Application application = getApplication();
            k.a((Object) application, "getApplication<Application>()");
            if (application.getApplicationContext() != null) {
                net.one97.paytm.o2o.movies.common.c.c cVar = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b;
                Application application2 = getApplication();
                k.a((Object) application2, "getApplication<Application>()");
                String sSOToken = cVar.getSSOToken(application2.getApplicationContext());
                if (!TextUtils.isEmpty(sSOToken)) {
                    Application application3 = getApplication();
                    k.a((Object) application3, "getApplication<Application>()");
                    if (com.paytm.utility.b.c(application3.getApplicationContext())) {
                        a();
                        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getWalletTokenMovies(sSOToken, this.f74888c, new c(this));
                        return;
                    }
                    b();
                    Application application4 = getApplication();
                    k.a((Object) application4, "getApplication<Application>()");
                    Context applicationContext = application4.getApplicationContext();
                    Application application5 = getApplication();
                    k.a((Object) application5, "getApplication<Application>()");
                    String string = application5.getApplicationContext().getString(R.string.no_connection);
                    Application application6 = getApplication();
                    k.a((Object) application6, "getApplication<Application>()");
                    com.paytm.utility.b.b(applicationContext, string, application6.getApplicationContext().getString(R.string.no_internet));
                    return;
                }
                b();
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.showSessionTimeoutAlert(this.f74888c, (String) null, (Bundle) null, (Exception) null);
            }
        } catch (Exception unused) {
            b();
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f74896a;

        c(b bVar) {
            this.f74896a = bVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (this.f74896a.f74888c != null) {
                Activity g2 = this.f74896a.f74888c;
                if (g2 == null || !g2.isFinishing()) {
                    this.f74896a.b();
                }
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (!(iJRPaytmDataModel instanceof CJRPGTokenList)) {
                iJRPaytmDataModel = null;
            }
            CJRPGTokenList cJRPGTokenList = (CJRPGTokenList) iJRPaytmDataModel;
            if (cJRPGTokenList != null) {
                this.f74896a.a(cJRPGTokenList);
            }
        }
    }

    private final void q() {
        this.af = null;
        if (this.Q) {
            o();
        } else if (i()) {
            r();
        } else {
            p();
        }
    }

    private final void r() {
        a();
        this.ap = true;
        PaytmSDK.setCheckoutCallbackListener(this);
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.fetchPaymentOptions(this.f74888c, this.G, this.al, this.az, this.at != null, this);
        this.az = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        if (r0.size() <= 0) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(boolean r9) {
        /*
            r8 = this;
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r0 = r8.I
            r1 = 0
            if (r0 == 0) goto L_0x0056
            if (r0 != 0) goto L_0x000a
            kotlin.g.b.k.a()
        L_0x000a:
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeatItems r0 = r0.getItems()
            if (r0 == 0) goto L_0x0056
            java.util.ArrayList r0 = r0.get_3dglasses()
            if (r0 == 0) goto L_0x0056
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0056
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r0 = r8.I
            if (r0 != 0) goto L_0x0023
            kotlin.g.b.k.a()
        L_0x0023:
            java.util.ArrayList r0 = r0.getRules()
            java.lang.String r2 = "rules"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            r3 = 0
        L_0x0034:
            if (r1 >= r2) goto L_0x0055
            java.lang.Object r4 = r0.get(r1)
            net.one97.paytm.o2o.movies.common.movies.booking.c r4 = (net.one97.paytm.o2o.movies.common.movies.booking.c) r4
            java.lang.String r5 = r4.f75144a
            r6 = 1
            java.lang.String r7 = "3dglasses"
            boolean r5 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r5, (boolean) r6)
            if (r5 == 0) goto L_0x0052
            java.lang.String r4 = r4.f75145b
            java.lang.String r5 = "v1"
            boolean r4 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r4, (boolean) r6)
            if (r4 == 0) goto L_0x0052
            r3 = 1
        L_0x0052:
            int r1 = r1 + 1
            goto L_0x0034
        L_0x0055:
            r1 = r3
        L_0x0056:
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2> r0 = r8.H
            if (r0 == 0) goto L_0x0065
            if (r0 != 0) goto L_0x005f
            kotlin.g.b.k.a()
        L_0x005f:
            int r0 = r0.size()
            if (r0 > 0) goto L_0x0067
        L_0x0065:
            if (r1 == 0) goto L_0x006f
        L_0x0067:
            r0 = 0
            r8.W = r0
            r8.k()
            return
        L_0x006f:
            r8.c((boolean) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.b.b(boolean):void");
    }

    private final void c(boolean z2) {
        if (this.T || !this.S) {
            a(this.ac, this.ae, this.aE, z2);
        } else if (this.ai) {
            this.ai = false;
            m();
        } else {
            l();
        }
    }

    @kotlin.d.b.a.f(b = "CJRBookingApiManager.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.o2o.movies.helper.CJRBookingApiManager$handleAddSeatApiResponse$1")
    static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = bVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            d dVar2 = new d(this.this$0, dVar);
            dVar2.p$ = (CoroutineScope) obj;
            return dVar2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                b.s(this.this$0);
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.d.b.a.f(b = "CJRBookingApiManager.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.o2o.movies.helper.CJRBookingApiManager$handleConvenienceFeeApiResponse$1")
    static final class e extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(b bVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = bVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            e eVar = new e(this.this$0, dVar);
            eVar.p$ = (CoroutineScope) obj;
            return eVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((e) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x00ca A[Catch:{ JSONException -> 0x01b7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00dd A[Catch:{ JSONException -> 0x01b7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00f5 A[Catch:{ JSONException -> 0x01b7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0108 A[Catch:{ JSONException -> 0x01b7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0120 A[Catch:{ JSONException -> 0x01b7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0133 A[Catch:{ JSONException -> 0x01b7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x014b A[Catch:{ JSONException -> 0x01b7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x0159 A[Catch:{ JSONException -> 0x01b7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0180 A[Catch:{ JSONException -> 0x01b7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x018e A[Catch:{ JSONException -> 0x01b7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01a8 A[Catch:{ JSONException -> 0x01b7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01f1  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01fd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
                int r0 = r10.label
                if (r0 != 0) goto L_0x0206
                kotlin.ResultKt.a((java.lang.Object) r11)
                net.one97.paytm.o2o.movies.b.b r11 = r10.this$0
                boolean r11 = r11.k
                if (r11 == 0) goto L_0x0016
                net.one97.paytm.o2o.movies.b.b r11 = r10.this$0
                r11.l()
            L_0x0016:
                net.one97.paytm.o2o.movies.b.b r11 = r10.this$0
                java.lang.String r0 = net.one97.paytm.o2o.movies.b.b.A
                com.paytm.utility.b.j()
                net.one97.paytm.o2o.movies.common.b.c r0 = net.one97.paytm.o2o.movies.common.b.c.a()
                java.lang.String r1 = "MoviesGTMLoader.getInstance()"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                r0 = 0
                java.lang.String r1 = "moviesAddSeat"
                java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.c.a(r1, r0)
                boolean r1 = android.webkit.URLUtil.isValidUrl(r0)
                if (r1 == 0) goto L_0x0203
                net.one97.paytm.o2o.movies.entity.BookingData r1 = r11.f74886a
                java.lang.String r2 = "mBookingData"
                if (r1 != 0) goto L_0x003c
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x003c:
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r1 = r1.getMSelectedMoviesSession()
                java.lang.String r1 = r1.getMovieCode()
                net.one97.paytm.o2o.movies.entity.BookingData r3 = r11.f74886a
                if (r3 != 0) goto L_0x004b
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x004b:
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r3 = r3.getMSelectedMoviesSession()
                java.lang.String r3 = r3.getCinemaID()
                net.one97.paytm.o2o.movies.entity.BookingData r4 = r11.f74886a
                if (r4 != 0) goto L_0x005a
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x005a:
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r4 = r4.getMSelectedMoviesSession()
                java.lang.String r4 = r4.getSessionID()
                android.app.Application r5 = r11.getApplication()
                java.lang.String r6 = "getApplication<Application>()"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
                android.content.Context r5 = r5.getApplicationContext()
                java.lang.String r0 = com.paytm.utility.b.a((android.content.Context) r5, (java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r3, (java.lang.String) r4)
                java.util.HashMap r1 = new java.util.HashMap
                r1.<init>()
                java.util.Map r1 = (java.util.Map) r1
                java.lang.String r3 = "Content-Type"
                java.lang.String r4 = "application/json"
                r1.put(r3, r4)
                java.lang.String r3 = "ClientId"
                java.lang.String r4 = "paytm"
                r1.put(r3, r4)
                org.json.JSONObject r3 = new org.json.JSONObject
                r3.<init>()
                r4 = 1
                net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat r5 = r11.f74889d     // Catch:{ JSONException -> 0x01b7 }
                java.lang.String r7 = "tempTransId"
                if (r5 == 0) goto L_0x00b7
                net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat r5 = r11.f74889d     // Catch:{ JSONException -> 0x01b7 }
                if (r5 != 0) goto L_0x009c
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x01b7 }
            L_0x009c:
                java.lang.String r5 = r5.getTempTransId()     // Catch:{ JSONException -> 0x01b7 }
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ JSONException -> 0x01b7 }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x01b7 }
                if (r5 != 0) goto L_0x00b7
                net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat r5 = r11.f74889d     // Catch:{ JSONException -> 0x01b7 }
                if (r5 != 0) goto L_0x00af
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x01b7 }
            L_0x00af:
                java.lang.String r5 = r5.getTempTransId()     // Catch:{ JSONException -> 0x01b7 }
                r3.put(r7, r5)     // Catch:{ JSONException -> 0x01b7 }
                goto L_0x00c6
            L_0x00b7:
                java.lang.String r5 = r11.f74891f     // Catch:{ JSONException -> 0x01b7 }
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ JSONException -> 0x01b7 }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x01b7 }
                if (r5 != 0) goto L_0x00c6
                java.lang.String r5 = r11.f74891f     // Catch:{ JSONException -> 0x01b7 }
                r3.put(r7, r5)     // Catch:{ JSONException -> 0x01b7 }
            L_0x00c6:
                net.one97.paytm.o2o.movies.entity.BookingData r5 = r11.f74886a     // Catch:{ JSONException -> 0x01b7 }
                if (r5 != 0) goto L_0x00cd
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ JSONException -> 0x01b7 }
            L_0x00cd:
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r5 = r5.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x01b7 }
                java.lang.String r5 = r5.getProviderId()     // Catch:{ JSONException -> 0x01b7 }
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ JSONException -> 0x01b7 }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x01b7 }
                if (r5 != 0) goto L_0x00f1
                java.lang.String r5 = "providerId"
                net.one97.paytm.o2o.movies.entity.BookingData r7 = r11.f74886a     // Catch:{ JSONException -> 0x01b7 }
                if (r7 != 0) goto L_0x00e6
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ JSONException -> 0x01b7 }
            L_0x00e6:
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r7 = r7.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x01b7 }
                java.lang.String r7 = r7.getProviderId()     // Catch:{ JSONException -> 0x01b7 }
                r3.put(r5, r7)     // Catch:{ JSONException -> 0x01b7 }
            L_0x00f1:
                net.one97.paytm.o2o.movies.entity.BookingData r5 = r11.f74886a     // Catch:{ JSONException -> 0x01b7 }
                if (r5 != 0) goto L_0x00f8
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ JSONException -> 0x01b7 }
            L_0x00f8:
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r5 = r5.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x01b7 }
                java.lang.String r5 = r5.getCinemaID()     // Catch:{ JSONException -> 0x01b7 }
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ JSONException -> 0x01b7 }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x01b7 }
                if (r5 != 0) goto L_0x011c
                java.lang.String r5 = "cinemaId"
                net.one97.paytm.o2o.movies.entity.BookingData r7 = r11.f74886a     // Catch:{ JSONException -> 0x01b7 }
                if (r7 != 0) goto L_0x0111
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ JSONException -> 0x01b7 }
            L_0x0111:
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r7 = r7.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x01b7 }
                java.lang.String r7 = r7.getCinemaID()     // Catch:{ JSONException -> 0x01b7 }
                r3.put(r5, r7)     // Catch:{ JSONException -> 0x01b7 }
            L_0x011c:
                net.one97.paytm.o2o.movies.entity.BookingData r5 = r11.f74886a     // Catch:{ JSONException -> 0x01b7 }
                if (r5 != 0) goto L_0x0123
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ JSONException -> 0x01b7 }
            L_0x0123:
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r5 = r5.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x01b7 }
                java.lang.String r5 = r5.getSessionID()     // Catch:{ JSONException -> 0x01b7 }
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ JSONException -> 0x01b7 }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x01b7 }
                if (r5 != 0) goto L_0x0147
                java.lang.String r5 = "sessionId"
                net.one97.paytm.o2o.movies.entity.BookingData r7 = r11.f74886a     // Catch:{ JSONException -> 0x01b7 }
                if (r7 != 0) goto L_0x013c
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ JSONException -> 0x01b7 }
            L_0x013c:
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r7 = r7.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x01b7 }
                java.lang.String r7 = r7.getSessionID()     // Catch:{ JSONException -> 0x01b7 }
                r3.put(r5, r7)     // Catch:{ JSONException -> 0x01b7 }
            L_0x0147:
                net.one97.paytm.o2o.movies.entity.BookingData r5 = r11.f74886a     // Catch:{ JSONException -> 0x01b7 }
                if (r5 != 0) goto L_0x014e
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ JSONException -> 0x01b7 }
            L_0x014e:
                java.util.ArrayList r5 = r5.getMSelectedSeatList()     // Catch:{ JSONException -> 0x01b7 }
                int r5 = r5.size()     // Catch:{ JSONException -> 0x01b7 }
                r7 = 0
                if (r5 <= 0) goto L_0x0179
                java.lang.String r5 = "ticketType"
                net.one97.paytm.o2o.movies.entity.BookingData r8 = r11.f74886a     // Catch:{ JSONException -> 0x01b7 }
                if (r8 != 0) goto L_0x0163
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ JSONException -> 0x01b7 }
            L_0x0163:
                java.util.ArrayList r8 = r8.getMSelectedSeatList()     // Catch:{ JSONException -> 0x01b7 }
                java.lang.Object r8 = r8.get(r7)     // Catch:{ JSONException -> 0x01b7 }
                java.lang.String r9 = "mBookingData.mSelectedSeatList[0]"
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ JSONException -> 0x01b7 }
                net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat r8 = (net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat) r8     // Catch:{ JSONException -> 0x01b7 }
                java.lang.String r8 = r8.getTypeCode()     // Catch:{ JSONException -> 0x01b7 }
                r3.put(r5, r8)     // Catch:{ JSONException -> 0x01b7 }
            L_0x0179:
                java.lang.String r5 = "ticketcount"
                net.one97.paytm.o2o.movies.entity.BookingData r8 = r11.f74886a     // Catch:{ JSONException -> 0x01b7 }
                if (r8 != 0) goto L_0x0183
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ JSONException -> 0x01b7 }
            L_0x0183:
                int r8 = r8.getSeatCount()     // Catch:{ JSONException -> 0x01b7 }
                r3.put(r5, r8)     // Catch:{ JSONException -> 0x01b7 }
                int r5 = r11.j     // Catch:{ JSONException -> 0x01b7 }
                if (r5 == 0) goto L_0x018f
                r7 = 1
            L_0x018f:
                java.lang.String r5 = net.one97.paytm.o2o.movies.b.b.A     // Catch:{ JSONException -> 0x01b7 }
                java.lang.String r5 = "cancelOld : "
                java.lang.String r8 = java.lang.String.valueOf(r7)     // Catch:{ JSONException -> 0x01b7 }
                r5.concat(r8)     // Catch:{ JSONException -> 0x01b7 }
                com.paytm.utility.b.j()     // Catch:{ JSONException -> 0x01b7 }
                java.lang.String r5 = "cancelOld"
                r3.put(r5, r7)     // Catch:{ JSONException -> 0x01b7 }
                java.lang.String r5 = "freeSeating"
                net.one97.paytm.o2o.movies.entity.BookingData r7 = r11.f74886a     // Catch:{ JSONException -> 0x01b7 }
                if (r7 != 0) goto L_0x01ab
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ JSONException -> 0x01b7 }
            L_0x01ab:
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r2 = r7.getMSelectedMoviesSession()     // Catch:{ JSONException -> 0x01b7 }
                boolean r2 = r2.isFreeSeating()     // Catch:{ JSONException -> 0x01b7 }
                r3.put(r5, r2)     // Catch:{ JSONException -> 0x01b7 }
                goto L_0x01b8
            L_0x01b7:
            L_0x01b8:
                java.lang.String r2 = r3.toString()
                java.lang.String r3 = "jsonRequest.toString()"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                java.lang.String r3 = net.one97.paytm.o2o.movies.b.b.B
                java.lang.String r3 = java.lang.String.valueOf(r2)
                java.lang.String r5 = " addSeat : "
                r5.concat(r3)
                com.paytm.utility.b.j()
                java.lang.String r3 = "url"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
                net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat r3 = new net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat
                r3.<init>()
                com.paytm.network.model.IJRPaytmDataModel r3 = (com.paytm.network.model.IJRPaytmDataModel) r3
                com.paytm.network.a r0 = r11.a((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.String>) r1, (java.lang.String) r2, (com.paytm.network.model.IJRPaytmDataModel) r3)
                android.app.Application r1 = r11.getApplication()
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
                android.content.Context r1 = r1.getApplicationContext()
                boolean r1 = com.paytm.utility.b.c((android.content.Context) r1)
                if (r1 == 0) goto L_0x01fd
                int r1 = r11.j
                int r1 = r1 + r4
                r11.j = r1
                r11.a()
                r0.a()
                goto L_0x0203
            L_0x01fd:
                r11.b()
                r11.a((com.paytm.network.a) r0, (boolean) r4)
            L_0x0203:
                kotlin.x r11 = kotlin.x.f47997a
                return r11
            L_0x0206:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.b.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void a(CJRUserMoviePassWrapperModel cJRUserMoviePassWrapperModel) {
        ArrayList<CJRUserMoviePassModel> activePass;
        if (cJRUserMoviePassWrapperModel == null || (activePass = cJRUserMoviePassWrapperModel.getActivePass()) == null || activePass.size() <= 0) {
            CJRMovieOffers cJRMovieOffers = this.aF;
            if (cJRMovieOffers != null) {
                this.o.setValue(cJRMovieOffers);
            } else {
                this.n = null;
            }
        } else {
            y<CJRUserMoviePassModel> yVar = this.n;
            if (yVar == null) {
                k.a();
            }
            yVar.setValue(activePass.get(0));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(com.paytm.network.a aVar, boolean z2) {
        Activity activity = this.f74888c;
        if (activity != null) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle(activity.getResources().getString(R.string.no_connection));
                builder.setMessage(activity.getResources().getString(R.string.no_internet));
                builder.setPositiveButton(activity.getResources().getString(R.string.network_retry_yes), new i(activity, this, z2, aVar));
                builder.show();
            } catch (Exception unused) {
                x xVar = x.f47997a;
            }
        }
    }

    static final class i implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f74899a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f74900b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f74901c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.a f74902d;

        i(Activity activity, b bVar, boolean z, com.paytm.network.a aVar) {
            this.f74899a = activity;
            this.f74900b = bVar;
            this.f74901c = z;
            this.f74902d = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            if (com.paytm.utility.b.c((Context) this.f74899a)) {
                if (this.f74901c) {
                    b bVar = this.f74900b;
                    bVar.j = bVar.j + 1;
                }
                this.f74900b.a();
                this.f74902d.a();
                return;
            }
            this.f74900b.a(this.f74902d, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (k.a((Object) this.w.getValue(), (Object) Boolean.FALSE)) {
            this.w.postValue(Boolean.TRUE);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.w.postValue(Boolean.FALSE);
    }

    private final void c(String str) {
        try {
            HashMap hashMap = new HashMap();
            Map map = hashMap;
            BookingData bookingData = this.f74886a;
            if (bookingData == null) {
                k.a("mBookingData");
            }
            CJRMovies mSelectedMovie = bookingData.getMSelectedMovie();
            BookingData bookingData2 = this.f74886a;
            if (bookingData2 == null) {
                k.a("mBookingData");
            }
            map.put(SDKConstants.EVENT_KEY_SCREEN_NAME, n.a(mSelectedMovie, bookingData2.getMSelectedMoviesSession()));
            hashMap.put("movie_promocode_status", str);
            if (!TextUtils.isEmpty(this.K)) {
                hashMap.put("movie_promocode", this.K);
            }
            if (!TextUtils.isEmpty(this.f74892g)) {
                hashMap.put("movie_city_name", this.f74892g);
            }
            Application application = getApplication();
            k.a((Object) application, "getApplication<Application>()");
            String n2 = com.paytm.utility.b.n(application.getApplicationContext());
            if (!TextUtils.isEmpty(n2)) {
                hashMap.put("movie_user_id", n2);
            }
            if (!TextUtils.isEmpty(this.f74890e)) {
                hashMap.put("movie_cinema_listing_type", this.f74890e);
            }
            BookingData bookingData3 = this.f74886a;
            if (bookingData3 == null) {
                k.a("mBookingData");
            }
            if (!TextUtils.isEmpty(bookingData3.getMSelectedMoviesSession().getRealShowDateTime())) {
                Map map2 = hashMap;
                BookingData bookingData4 = this.f74886a;
                if (bookingData4 == null) {
                    k.a("mBookingData");
                }
                map2.put("movie_show_timing_bucket", bookingData4.getMSelectedMoviesSession().getRealShowDateTime());
            }
            Application application2 = getApplication();
            k.a((Object) application2, "getApplication<Application>()");
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap("movie_seat_promocode_applied", hashMap, application2.getApplicationContext());
        } catch (Exception unused) {
        }
    }

    public final void c() {
        if (this.af != null) {
            this.T = false;
            this.ai = false;
            this.ah = false;
            this.P = false;
            this.ag = true;
            this.al = null;
            this.J = null;
            this.at = null;
        }
        this.ap = false;
    }

    public final void d() {
        if (this.I != null) {
            if (!TextUtils.isEmpty(this.af)) {
                Application application = getApplication();
                k.a((Object) application, "getApplication<Application>()");
                j.c(application.getApplicationContext(), this.af);
                return;
            }
            k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
            String a2 = net.one97.paytm.o2o.movies.common.b.c.a("movies_seat_release", (String) null);
            if (URLUtil.isValidUrl(a2)) {
                BookingData bookingData = this.f74886a;
                if (bookingData == null) {
                    k.a("mBookingData");
                }
                String movieCode = bookingData.getMSelectedMoviesSession().getMovieCode();
                BookingData bookingData2 = this.f74886a;
                if (bookingData2 == null) {
                    k.a("mBookingData");
                }
                String cinemaID = bookingData2.getMSelectedMoviesSession().getCinemaID();
                BookingData bookingData3 = this.f74886a;
                if (bookingData3 == null) {
                    k.a("mBookingData");
                }
                String sessionID = bookingData3.getMSelectedMoviesSession().getSessionID();
                Application application2 = getApplication();
                k.a((Object) application2, "getApplication<Application>()");
                String a3 = com.paytm.utility.b.a(application2.getApplicationContext(), a2, movieCode, cinemaID, sessionID);
                Map<String, String> hashMap = new HashMap<>();
                hashMap.put("Content-Type", "application/json");
                hashMap.put("ClientId", "paytm");
                hashMap.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                try {
                    if (this.f74889d != null) {
                        CJRSetSeat cJRSetSeat = this.I;
                        if (cJRSetSeat == null) {
                            k.a();
                        }
                        if (!TextUtils.isEmpty(cJRSetSeat.getTempTransId())) {
                            CJRSetSeat cJRSetSeat2 = this.I;
                            if (cJRSetSeat2 == null) {
                                k.a();
                            }
                            jSONObject.put(SDKConstants.KEY_TRANS_ID, cJRSetSeat2.getTempTransId());
                        }
                    }
                    BookingData bookingData4 = this.f74886a;
                    if (bookingData4 == null) {
                        k.a("mBookingData");
                    }
                    if (!TextUtils.isEmpty(bookingData4.getMSelectedMoviesSession().getProviderId())) {
                        BookingData bookingData5 = this.f74886a;
                        if (bookingData5 == null) {
                            k.a("mBookingData");
                        }
                        jSONObject.put("providerId", bookingData5.getMSelectedMoviesSession().getProviderId());
                    }
                    BookingData bookingData6 = this.f74886a;
                    if (bookingData6 == null) {
                        k.a("mBookingData");
                    }
                    if (!TextUtils.isEmpty(bookingData6.getMSelectedMoviesSession().getCinemaID())) {
                        BookingData bookingData7 = this.f74886a;
                        if (bookingData7 == null) {
                            k.a("mBookingData");
                        }
                        jSONObject.put("cinemaId", bookingData7.getMSelectedMoviesSession().getCinemaID());
                    }
                    BookingData bookingData8 = this.f74886a;
                    if (bookingData8 == null) {
                        k.a("mBookingData");
                    }
                    if (!TextUtils.isEmpty(bookingData8.getMSelectedMoviesSession().getSessionID())) {
                        BookingData bookingData9 = this.f74886a;
                        if (bookingData9 == null) {
                            k.a("mBookingData");
                        }
                        jSONObject.put(H5Param.SESSION_ID, bookingData9.getMSelectedMoviesSession().getSessionID());
                    }
                    if (this.f74889d != null) {
                        CJRAddSeat cJRAddSeat = this.f74889d;
                        if (cJRAddSeat == null) {
                            k.a();
                        }
                        if (!TextUtils.isEmpty(cJRAddSeat.getBookingId())) {
                            CJRAddSeat cJRAddSeat2 = this.f74889d;
                            if (cJRAddSeat2 == null) {
                                k.a();
                            }
                            jSONObject.put("bookingId", cJRAddSeat2.getBookingId());
                        }
                    }
                } catch (JSONException unused) {
                }
                String jSONObject2 = jSONObject.toString();
                k.a((Object) jSONObject2, "jsonRequest.toString()");
                " releaseSeat : ".concat(String.valueOf(jSONObject2));
                com.paytm.utility.b.j();
                net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
                Application application3 = getApplication();
                k.a((Object) application3, "getApplication<Application>()");
                cVar.f42877a = application3.getApplicationContext();
                cVar.f42878b = a.c.MOVIES;
                cVar.f42879c = a.C0715a.POST;
                cVar.f42885i = new CJRReleaseSeats();
                cVar.f42880d = a3;
                cVar.f42881e = null;
                cVar.f42882f = hashMap;
                cVar.f42883g = null;
                cVar.f42884h = jSONObject2;
                cVar.j = this;
                cVar.n = a.b.USER_FACING;
                cVar.o = "movies";
                cVar.t = n.h("CJRJustTicketsBookingApiManager");
                com.paytm.network.a l2 = cVar.l();
                l2.f42859c = false;
                l2.a();
            }
        }
    }

    private final String a(PaytmSDKRequestClient.CallbackData callbackData) {
        try {
            JSONArray jSONArray = callbackData.getOfferBody().getJSONArray("offerBreakup");
            if (jSONArray.length() > 0) {
                Object obj = jSONArray.get(0);
                if (obj != null) {
                    String optString = ((JSONObject) obj).optString("promocodeApplied", "");
                    if (!TextUtils.isEmpty(optString)) {
                        this.av = optString.toString();
                    }
                } else {
                    throw new u("null cannot be cast to non-null type org.json.JSONObject");
                }
            }
            String str = ",\"payment_offers_applied\":" + callbackData.getOfferBody();
            k.a((Object) str, "StringBuilder().append(\"…ata.offerBody).toString()");
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        CreateOrderResponse createOrderResponse;
        String str;
        k.c(iJRPaytmDataModel, "dataModel");
        Application application = getApplication();
        k.a((Object) application, "getApplication<Application>()");
        if (application.getApplicationContext() != null) {
            ArrayList arrayList = null;
            boolean z2 = false;
            if (iJRPaytmDataModel instanceof CJRConvenienceFee) {
                this.aG = false;
                CJRConvenienceFee cJRConvenienceFee = (CJRConvenienceFee) iJRPaytmDataModel;
                this.M = cJRConvenienceFee;
                this.l.setValue(cJRConvenienceFee);
                Job unused = BuildersKt__Builders_commonKt.launch$default(this.f74887b, Dispatchers.getDefault(), (CoroutineStart) null, new e(this, (kotlin.d.d) null), 2, (Object) null);
            } else if (iJRPaytmDataModel instanceof CJRAddSeat) {
                this.aH = false;
                CJRAddSeat cJRAddSeat = (CJRAddSeat) iJRPaytmDataModel;
                this.f74889d = cJRAddSeat;
                BookingData bookingData = this.f74886a;
                if (bookingData == null) {
                    k.a("mBookingData");
                }
                if (bookingData.getMSelectedMoviesSession().isFreeSeating()) {
                    this.p.setValue(cJRAddSeat);
                    if (this.k) {
                        this.k = false;
                        b();
                        return;
                    }
                    b(false);
                    return;
                }
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(this.f74887b, Dispatchers.getDefault(), (CoroutineStart) null, new d(this, (kotlin.d.d) null), 2, (Object) null);
            } else if (iJRPaytmDataModel instanceof CJRSetSeat) {
                this.aI = false;
                CJRSetSeat cJRSetSeat = (CJRSetSeat) iJRPaytmDataModel;
                this.I = cJRSetSeat;
                if (cJRSetSeat != null) {
                    if (!TextUtils.isEmpty(cJRSetSeat.getTempTransId())) {
                        this.f74891f = cJRSetSeat.getTempTransId();
                    }
                    CJRSetSeatItems items = cJRSetSeat.getItems();
                    k.a((Object) items, "setSeat.items");
                    ArrayList<CJRFoodBeverageItemV2> fnbAndVouchers = items.getFnbAndVouchers();
                    if (fnbAndVouchers != null) {
                        net.one97.paytm.o2o.movies.utils.g a2 = net.one97.paytm.o2o.movies.utils.g.a();
                        k.a((Object) a2, "CJRFoodBeverageModel.getInstance()");
                        ArrayList<CJRFoodBeverageItemV2> arrayList2 = a2.f75924a;
                        if (arrayList2 != null) {
                            HashMap hashMap = new HashMap();
                            int size = fnbAndVouchers.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                CJRFoodBeverageItemV2 cJRFoodBeverageItemV2 = fnbAndVouchers.get(i2);
                                k.a((Object) cJRFoodBeverageItemV2, "newFoodList[i]");
                                CJRFoodBeverageItemV2 cJRFoodBeverageItemV22 = cJRFoodBeverageItemV2;
                                hashMap.put(cJRFoodBeverageItemV22.getmID(), cJRFoodBeverageItemV22);
                            }
                            if (arrayList2 != null) {
                                int size2 = arrayList2.size();
                                ArrayList arrayList3 = null;
                                for (int i3 = 0; i3 < size2; i3++) {
                                    CJRFoodBeverageItemV2 cJRFoodBeverageItemV23 = arrayList2.get(i3);
                                    if (cJRFoodBeverageItemV23.getmFoodQauntitySelected() > 0) {
                                        CJRFoodBeverageItemV2 cJRFoodBeverageItemV24 = (CJRFoodBeverageItemV2) hashMap.get(cJRFoodBeverageItemV23.getmID());
                                        if (cJRFoodBeverageItemV24 != null) {
                                            cJRFoodBeverageItemV24.setmFoodQauntitySelected(cJRFoodBeverageItemV23.getmFoodQauntitySelected());
                                        } else {
                                            if (arrayList3 == null) {
                                                arrayList3 = new ArrayList();
                                            }
                                            arrayList3.add(cJRFoodBeverageItemV23.getmItemName());
                                        }
                                    }
                                }
                                arrayList = arrayList3;
                            }
                        }
                    }
                }
                this.q.setValue(new CJRSetSeatData(cJRSetSeat, this.k, arrayList));
                if (arrayList != null) {
                    ArrayList<CJRFoodBeverageItemV2> arrayList4 = new ArrayList<>();
                    net.one97.paytm.o2o.movies.utils.g a3 = net.one97.paytm.o2o.movies.utils.g.a();
                    k.a((Object) a3, "CJRFoodBeverageModel.getInstance()");
                    ArrayList<CJRFoodBeverageItemV2> arrayList5 = a3.f75924a;
                    if (arrayList5 != null) {
                        int size3 = arrayList5.size();
                        for (int i4 = 0; i4 < size3; i4++) {
                            if (arrayList5.get(i4).getmFoodQauntitySelected() > 0) {
                                arrayList4.add(0, arrayList5.get(i4));
                            }
                        }
                        this.H = arrayList4;
                    }
                } else if (this.k) {
                    this.k = false;
                    b();
                } else {
                    b(false);
                }
            } else if (iJRPaytmDataModel instanceof CJRPrevalidate) {
                this.J = (CJRPrevalidate) iJRPaytmDataModel;
                this.ag = false;
                this.ah = true;
                n();
            } else if (iJRPaytmDataModel instanceof CJRCashWallet) {
                CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
                if (cJRCashWallet == null || cJRCashWallet.getResponse() == null) {
                    this.N = null;
                    if (i()) {
                        r();
                    } else {
                        p();
                    }
                } else {
                    this.N = cJRCashWallet;
                    double d2 = this.L;
                    CJRCashWalletResponse response = cJRCashWallet.getResponse();
                    k.a((Object) response, "cashWallet.response");
                    if (d2 <= response.getAmount() || !i()) {
                        p();
                    } else {
                        r();
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                a((CJRPGTokenList) iJRPaytmDataModel);
            } else if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel;
                if (cJRRechargePayment == null || cJRRechargePayment.getStatus() == null || !kotlin.m.p.a(cJRRechargePayment.getStatus(), "SUCCESS", true)) {
                    b();
                    if (cJRRechargePayment != null && cJRRechargePayment.getCode() == 401) {
                        NetworkCustomError networkCustomError = new NetworkCustomError();
                        k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                        if (!TextUtils.isEmpty(net.one97.paytm.o2o.movies.common.b.c.a("cartCheckout", (String) null))) {
                            k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                            networkCustomError.setUrl(net.one97.paytm.o2o.movies.common.b.c.a("cartCheckout", (String) null));
                            if (cJRRechargePayment.getError() != null) {
                                CJRError error = cJRRechargePayment.getError();
                                k.a((Object) error, "rechargePayment.error");
                                if (!TextUtils.isEmpty(error.getMessage())) {
                                    CJRError error2 = cJRRechargePayment.getError();
                                    k.a((Object) error2, "rechargePayment.error");
                                    networkCustomError.setAlertMessage(error2.getMessage());
                                }
                            }
                        }
                        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.showSessionTimeoutAlert(this.f74888c, (String) null, (Bundle) null, networkCustomError);
                    } else if (cJRRechargePayment != null && cJRRechargePayment.getError() != null) {
                        Application application2 = getApplication();
                        k.a((Object) application2, "getApplication<Application>()");
                        Context applicationContext = application2.getApplicationContext();
                        CJRError error3 = cJRRechargePayment.getError();
                        k.a((Object) error3, "rechargePayment.error");
                        String title = error3.getTitle();
                        CJRError error4 = cJRRechargePayment.getError();
                        k.a((Object) error4, "rechargePayment.error");
                        com.paytm.utility.b.b(applicationContext, title, error4.getMessage());
                    }
                } else {
                    if (cJRRechargePayment.getOrderId() != null) {
                        this.af = cJRRechargePayment.getOrderId();
                    }
                    if (this.ap) {
                        try {
                            if (kotlin.m.p.a("gzip", cJRRechargePayment.getNetworkResponse().headers.get("Content-Encoding"), true)) {
                                str = com.paytm.network.b.g.a(com.paytm.network.b.g.a(cJRRechargePayment.getNetworkResponse().data));
                                k.a((Object) str, "GzipUtils.convertString(…nt.networkResponse.data))");
                            } else {
                                byte[] bArr = cJRRechargePayment.getNetworkResponse().data;
                                k.a((Object) bArr, "rechargePayment.networkResponse.data");
                                str = new String(bArr, kotlin.m.d.f47971a);
                            }
                            createOrderResponse = (CreateOrderResponse) new com.google.gsonhtcfix.f().a(str, CreateOrderResponse.class);
                        } catch (Exception unused3) {
                            createOrderResponse = null;
                        }
                        PaytmSDKRequestClient.CheckoutResponseData checkoutResponseData = new PaytmSDKRequestClient.CheckoutResponseData();
                        checkoutResponseData.setCreateOrderResponse(createOrderResponse);
                        PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse = this.aq;
                        if (onCheckoutResponse != null) {
                            if (onCheckoutResponse == null) {
                                k.a();
                            }
                            onCheckoutResponse.onCheckoutSuccess(checkoutResponseData);
                        }
                        b();
                    } else if (!this.R || !this.Q) {
                        if (kotlin.m.p.a("1", cJRRechargePayment.isNativeEnabled(), true)) {
                            a();
                            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.fetchPaymentOptions(this.f74888c, cJRRechargePayment, this.G, this.al);
                            return;
                        }
                        b();
                        net.one97.paytm.o2o.movies.common.c.c cVar = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b;
                        k.a((Object) cVar, "MoviesController.getMovieEventListener()");
                        Intent intent = new Intent(this.f74888c, cVar.getPaytmActivityMap().get("paymentActivity"));
                        if (!TextUtils.isEmpty(cJRRechargePayment.getmTxnToken())) {
                            intent.putExtra("txnToken", cJRRechargePayment.getmTxnToken());
                            intent.putExtra("mid", cJRRechargePayment.getMID());
                            intent.putExtra("orderid", cJRRechargePayment.getOrderId());
                            intent.putExtra("nativeSdkEnabled", true);
                            intent.putExtra("price", cJRRechargePayment.getTxnAmount());
                            CJRMovieCart cJRMovieCart = this.al;
                            if (cJRMovieCart != null) {
                                intent.putExtra("recharge cart", cJRMovieCart);
                            }
                        } else {
                            k.a((Object) intent.putExtra("nativeSdkEnabled", false), "intent.putExtra(\"nativeSdkEnabled\", false)");
                        }
                        intent.putExtra(UpiConstants.FROM, "MoviesPage");
                        intent.putExtra("is_movie_ticket", true);
                        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
                        Activity activity = this.f74888c;
                        if (activity == null) {
                            k.a();
                        }
                        activity.startActivityForResult(intent, 4524);
                    } else if (cJRRechargePayment.getOrderId() != null) {
                        String orderId = cJRRechargePayment.getOrderId();
                        Activity activity2 = this.f74888c;
                        if (activity2 != null) {
                            Intent intent2 = new Intent(activity2, AJRMovieOrderSummary.class);
                            intent2.putExtra(UpiConstants.FROM, "Payment");
                            intent2.putExtra("order_id", orderId);
                            intent2.putExtra(AppConstants.IS_CANCEL, false);
                            intent2.addFlags(268435456);
                            activity2.startActivity(intent2);
                        }
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRFoodBeverageSetResponseV2) {
                CJRFoodBeverageSetResponseV2 cJRFoodBeverageSetResponseV2 = (CJRFoodBeverageSetResponseV2) iJRPaytmDataModel;
                if (cJRFoodBeverageSetResponseV2 != null) {
                    this.ae = cJRFoodBeverageSetResponseV2;
                    this.ac = true;
                    c(false);
                }
            } else if (iJRPaytmDataModel instanceof CJRMovieNewCancellationProtect) {
                CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect = (CJRMovieNewCancellationProtect) iJRPaytmDataModel;
                if (cJRMovieNewCancellationProtect != null) {
                    boolean z3 = this.aa == null;
                    this.aa = cJRMovieNewCancellationProtect;
                    this.r.setValue(cJRMovieNewCancellationProtect);
                    if (!cJRMovieNewCancellationProtect.getInsuranceAvailable() && !z3) {
                        Boolean value = this.v.getValue();
                        y<Boolean> yVar = this.v;
                        if (value != null && !value.booleanValue()) {
                            z2 = true;
                        }
                        yVar.setValue(Boolean.valueOf(z2));
                    } else if (z3) {
                        this.ai = true;
                    } else {
                        m();
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRMovieGetCancelProtect) {
                CJRMovieGetCancelProtect cJRMovieGetCancelProtect = (CJRMovieGetCancelProtect) iJRPaytmDataModel;
                this.aE = cJRMovieGetCancelProtect;
                if (cJRMovieGetCancelProtect != null) {
                    this.T = true;
                    a(this.ac, this.ae, cJRMovieGetCancelProtect, false);
                }
            } else if (iJRPaytmDataModel instanceof CJRUserWalletBalance) {
                this.m.setValue(iJRPaytmDataModel);
            } else if (iJRPaytmDataModel instanceof CJRUserMoviePassWrapperModel) {
                a((CJRUserMoviePassWrapperModel) iJRPaytmDataModel);
            } else if (iJRPaytmDataModel instanceof CJRMovieOffers) {
                this.aF = (CJRMovieOffers) iJRPaytmDataModel;
                this.o.setValue(this.aF);
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x015b */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0167 A[Catch:{ NotFoundException | Exception -> 0x0256 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleErrorCode(int r8, com.paytm.network.model.IJRPaytmDataModel r9, com.paytm.network.model.NetworkCustomError r10) {
        /*
            r7 = this;
            java.lang.String r8 = "errorStatus.statusError.getmMessage()"
            java.lang.String r0 = "title"
            java.lang.String r1 = "status"
            java.lang.String r2 = "message"
            boolean r3 = r9 instanceof net.one97.paytm.o2o.movies.entity.CJRUserWalletBalance
            if (r3 == 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.String r3 = "error.networkResponse.data"
            if (r10 == 0) goto L_0x005e
            com.paytm.network.model.NetworkResponse r4 = r10.networkResponse
            if (r4 == 0) goto L_0x005e
            com.paytm.network.model.NetworkResponse r4 = r10.networkResponse
            byte[] r4 = r4.data
            if (r4 == 0) goto L_0x005e
            com.paytm.network.model.NetworkResponse r4 = r10.networkResponse     // Catch:{ JSONException -> 0x005d }
            byte[] r4 = r4.data     // Catch:{ JSONException -> 0x005d }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)     // Catch:{ JSONException -> 0x005d }
            java.lang.String r5 = new java.lang.String     // Catch:{ JSONException -> 0x005d }
            java.nio.charset.Charset r6 = kotlin.m.d.f47971a     // Catch:{ JSONException -> 0x005d }
            r5.<init>(r4, r6)     // Catch:{ JSONException -> 0x005d }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x005d }
            r4.<init>(r5)     // Catch:{ JSONException -> 0x005d }
            boolean r5 = r4.has(r1)     // Catch:{ JSONException -> 0x005d }
            if (r5 == 0) goto L_0x005e
            org.json.JSONObject r1 = r4.getJSONObject(r1)     // Catch:{ JSONException -> 0x005d }
            boolean r4 = r1.has(r2)     // Catch:{ JSONException -> 0x005d }
            if (r4 == 0) goto L_0x005e
            org.json.JSONObject r1 = r1.getJSONObject(r2)     // Catch:{ JSONException -> 0x005d }
            boolean r4 = r1.has(r0)     // Catch:{ JSONException -> 0x005d }
            if (r4 == 0) goto L_0x004f
            java.lang.String r0 = r1.getString(r0)     // Catch:{ JSONException -> 0x005d }
            r10.setmAlertTitle(r0)     // Catch:{ JSONException -> 0x005d }
        L_0x004f:
            boolean r0 = r1.has(r2)     // Catch:{ JSONException -> 0x005d }
            if (r0 == 0) goto L_0x005e
            java.lang.String r0 = r1.getString(r2)     // Catch:{ JSONException -> 0x005d }
            r10.setAlertMessage(r0)     // Catch:{ JSONException -> 0x005d }
            goto L_0x005e
        L_0x005d:
        L_0x005e:
            boolean r0 = r9 instanceof net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart
            r1 = 0
            if (r0 != 0) goto L_0x006f
            boolean r0 = r9 instanceof net.one97.paytm.common.entity.movies.booking.CJRPrevalidate
            if (r0 != 0) goto L_0x006f
            boolean r0 = r9 instanceof net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat
            if (r0 != 0) goto L_0x006f
            boolean r0 = r9 instanceof net.one97.paytm.o2o.movies.entity.CJRFoodBeverageSetResponseV2
            if (r0 == 0) goto L_0x0095
        L_0x006f:
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ApiResponseError r0 = new net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ApiResponseError
            r0.<init>()
            if (r10 == 0) goto L_0x008b
            java.lang.String r2 = r10.getAlertMessage()
            r0.setErrorMsg(r2)
            java.lang.String r2 = r10.getAlertTitle()
            r0.setErrorTitle(r2)
            int r2 = r10.getStatusCode()
            r0.setStatusCode(r2)
        L_0x008b:
            r0.setShouldClosePG(r1)
            net.one97.paytm.nativesdk.app.VerifyPromoResultListener r2 = r7.ax
            if (r2 == 0) goto L_0x0095
            r2.onVerifyPromoNetworkError(r0)
        L_0x0095:
            net.one97.paytm.o2o.movies.d.c r0 = r7.O
            r2 = 0
            if (r0 == 0) goto L_0x00a6
            boolean r4 = r9 instanceof net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat
            if (r4 == 0) goto L_0x009f
            goto L_0x00a6
        L_0x009f:
            boolean r0 = r9 instanceof net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassWrapperModel
            if (r0 == 0) goto L_0x00a6
            r7.a((net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassWrapperModel) r2)
        L_0x00a6:
            boolean r0 = r9 instanceof net.one97.paytm.common.entity.recharge.CJRRechargePayment
            if (r0 != 0) goto L_0x00ae
            boolean r0 = r9 instanceof net.one97.paytm.common.entity.wallet.CJRCashWallet
            if (r0 == 0) goto L_0x00d5
        L_0x00ae:
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$OnCheckoutResponse r0 = r7.aq
            if (r0 == 0) goto L_0x00d5
            if (r10 == 0) goto L_0x00d5
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ApiResponseError r0 = new net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ApiResponseError
            r0.<init>()
            int r4 = r10.getStatusCode()
            r0.setStatusCode(r4)
            java.lang.String r4 = r10.getAlertTitle()
            r0.setErrorTitle(r4)
            java.lang.String r4 = r10.getAlertMessage()
            r0.setErrorMsg(r4)
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$OnCheckoutResponse r4 = r7.aq
            if (r4 == 0) goto L_0x00d5
            r4.onCheckoutError(r0)
        L_0x00d5:
            android.app.Application r0 = r7.getApplication()
            java.lang.String r4 = "getApplication<Application>()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 != 0) goto L_0x00e5
            return
        L_0x00e5:
            r7.b()
            boolean r0 = r9 instanceof net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat
            r4 = 412(0x19c, float:5.77E-43)
            if (r0 == 0) goto L_0x00fe
            if (r10 == 0) goto L_0x00fe
            int r5 = r10.getStatusCode()
            if (r5 != r4) goto L_0x00fe
            androidx.lifecycle.y<java.lang.Boolean> r8 = r7.y
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            r8.postValue(r9)
            return
        L_0x00fe:
            boolean r5 = r9 instanceof net.one97.paytm.o2o.movies.common.movies.booking.CJRConvenienceFee
            if (r5 == 0) goto L_0x0106
            boolean r5 = r7.aG
            if (r5 != 0) goto L_0x0114
        L_0x0106:
            boolean r9 = r9 instanceof net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat
            if (r9 == 0) goto L_0x010e
            boolean r9 = r7.aH
            if (r9 != 0) goto L_0x0114
        L_0x010e:
            if (r0 == 0) goto L_0x011c
            boolean r9 = r7.aI
            if (r9 == 0) goto L_0x011c
        L_0x0114:
            androidx.lifecycle.y<java.lang.Boolean> r8 = r7.x
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            r8.postValue(r9)
            return
        L_0x011c:
            android.app.Activity r9 = r7.f74888c     // Catch:{ NotFoundException | Exception -> 0x0256 }
            if (r9 == 0) goto L_0x0256
            if (r9 == 0) goto L_0x0129
            boolean r0 = net.one97.paytm.o2o.movies.common.a.a.a(r9)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            if (r0 == 0) goto L_0x0129
            goto L_0x012a
        L_0x0129:
            r9 = r2
        L_0x012a:
            if (r9 == 0) goto L_0x0256
            if (r10 == 0) goto L_0x0256
            com.paytm.network.model.NetworkResponse r0 = r10.networkResponse     // Catch:{ NotFoundException | Exception -> 0x0256 }
            byte[] r0 = r0.data     // Catch:{ NotFoundException | Exception -> 0x0256 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r3 = new java.lang.String     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.nio.charset.Charset r5 = kotlin.m.d.f47971a     // Catch:{ NotFoundException | Exception -> 0x0256 }
            r3.<init>(r0, r5)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x015b }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x015b }
            if (r0 != 0) goto L_0x015b
            com.paytm.network.model.CJRIllegalCodeError r0 = new com.paytm.network.model.CJRIllegalCodeError     // Catch:{ Exception -> 0x015b }
            r0.<init>()     // Catch:{ Exception -> 0x015b }
            com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x015a }
            r2.<init>()     // Catch:{ Exception -> 0x015a }
            java.lang.Class r5 = r0.getClass()     // Catch:{ Exception -> 0x015a }
            java.lang.Object r2 = r2.a((java.lang.String) r3, r5)     // Catch:{ Exception -> 0x015a }
            com.paytm.network.model.CJRIllegalCodeError r2 = (com.paytm.network.model.CJRIllegalCodeError) r2     // Catch:{ Exception -> 0x015a }
            goto L_0x015b
        L_0x015a:
            r2 = r0
        L_0x015b:
            int r0 = r10.getStatusCode()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r3 = r10.getUrl()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            r5 = 410(0x19a, float:5.75E-43)
            if (r0 == r5) goto L_0x0247
            r5 = 401(0x191, float:5.62E-43)
            if (r0 != r5) goto L_0x016d
            goto L_0x0247
        L_0x016d:
            r5 = 1
            if (r0 != r4) goto L_0x01b3
            r8 = r3
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ NotFoundException | Exception -> 0x0256 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            if (r8 != 0) goto L_0x01a5
            java.lang.String r8 = "url"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r8)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r8 = "get-insurance-cart"
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ NotFoundException | Exception -> 0x0256 }
            boolean r8 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.CharSequence) r8, false)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            if (r8 == 0) goto L_0x01a5
            androidx.lifecycle.y<java.lang.Boolean> r8 = r7.v     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.Object r8 = r8.getValue()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ NotFoundException | Exception -> 0x0256 }
            androidx.lifecycle.y<java.lang.Boolean> r9 = r7.v     // Catch:{ NotFoundException | Exception -> 0x0256 }
            if (r8 == 0) goto L_0x019d
            boolean r8 = r8.booleanValue()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            if (r8 != 0) goto L_0x019d
            r1 = 1
        L_0x019d:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r1)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            r9.setValue(r8)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            return
        L_0x01a5:
            android.content.Context r9 = (android.content.Context) r9     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r8 = r10.getAlertTitle()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r10 = r10.getAlertMessage()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            com.paytm.utility.b.b((android.content.Context) r9, (java.lang.String) r8, (java.lang.String) r10)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            return
        L_0x01b3:
            if (r2 == 0) goto L_0x01e9
            com.paytm.network.model.CJRStatusError r0 = r2.getStatusError()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            if (r0 == 0) goto L_0x01e9
            com.paytm.network.model.CJRStatusError r0 = r2.getStatusError()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            com.paytm.network.model.CJRError r0 = r0.getmMessage()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            if (r0 == 0) goto L_0x01e9
            android.content.Context r9 = (android.content.Context) r9     // Catch:{ NotFoundException | Exception -> 0x0256 }
            com.paytm.network.model.CJRStatusError r10 = r2.getStatusError()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            com.paytm.network.model.CJRError r10 = r10.getmMessage()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r8)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r10 = r10.getTitle()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            com.paytm.network.model.CJRStatusError r0 = r2.getStatusError()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            com.paytm.network.model.CJRError r0 = r0.getmMessage()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r8 = r0.getMessage()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            com.paytm.utility.b.b((android.content.Context) r9, (java.lang.String) r10, (java.lang.String) r8)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            return
        L_0x01e9:
            net.one97.paytm.o2o.movies.common.c.b r8 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ NotFoundException | Exception -> 0x0256 }
            net.one97.paytm.o2o.movies.common.c.c r8 = r8.f75033b     // Catch:{ NotFoundException | Exception -> 0x0256 }
            r0 = r9
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ NotFoundException | Exception -> 0x0256 }
            boolean r8 = r8.checkErrorCode(r0, r10)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            if (r8 != 0) goto L_0x0256
            java.lang.String r8 = "parsing_error"
            java.lang.String r0 = r10.getMessage()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r5)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            if (r8 == 0) goto L_0x0214
            android.content.Context r9 = (android.content.Context) r9     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r8 = r10.getUrl()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            int r10 = r10.getStatusCode()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            com.paytm.utility.b.d((android.content.Context) r9, (java.lang.String) r8, (java.lang.String) r10)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            return
        L_0x0214:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NotFoundException | Exception -> 0x0256 }
            r8.<init>()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            android.content.res.Resources r0 = r9.getResources()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            int r1 = net.one97.paytm.o2o.movies.R.string.network_error_message     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            r8.append(r0)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r0 = " "
            r8.append(r0)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r10 = r10.getUrl()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            r8.append(r10)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r8 = r8.toString()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            r10 = r9
            android.content.Context r10 = (android.content.Context) r10     // Catch:{ NotFoundException | Exception -> 0x0256 }
            android.content.res.Resources r9 = r9.getResources()     // Catch:{ NotFoundException | Exception -> 0x0256 }
            int r0 = net.one97.paytm.o2o.movies.R.string.network_error_heading     // Catch:{ NotFoundException | Exception -> 0x0256 }
            java.lang.String r9 = r9.getString(r0)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            com.paytm.utility.b.b((android.content.Context) r10, (java.lang.String) r9, (java.lang.String) r8)     // Catch:{ NotFoundException | Exception -> 0x0256 }
            goto L_0x0256
        L_0x0247:
            net.one97.paytm.o2o.movies.common.c.b r8 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ NotFoundException | Exception -> 0x0256 }
            net.one97.paytm.o2o.movies.common.c.c r0 = r8.f75033b     // Catch:{ NotFoundException | Exception -> 0x0256 }
            android.app.Activity r1 = r7.f74888c     // Catch:{ NotFoundException | Exception -> 0x0256 }
            r2 = r10
            java.lang.Exception r2 = (java.lang.Exception) r2     // Catch:{ NotFoundException | Exception -> 0x0256 }
            r3 = 0
            r4 = 0
            r5 = 0
            r0.handleError(r1, r2, r3, r4, r5)     // Catch:{ NotFoundException | Exception -> 0x0256 }
        L_0x0256:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.b.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
    }

    public final void doCheckout(PaytmSDKRequestClient.CallbackData callbackData, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse) {
        k.c(callbackData, "callbackData");
        k.c(onCheckoutResponse, "onCheckoutResponse");
        ArrayList<PaymentIntent> paymentIntents = callbackData.getPaymentIntents();
        this.aw = a(callbackData);
        if (paymentIntents != null) {
            this.au = ",\"payment_intent\":".concat(String.valueOf(new com.google.gsonhtcfix.f().a((Object) paymentIntents)));
        } else {
            this.au = null;
        }
        this.aq = onCheckoutResponse;
        p();
    }

    public final void applyAnotherOffer(PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
        k.c(applyAnotherOfferListener, "applyAnotherOfferListener");
        s();
        applyAnotherOfferListener.onSuccess();
    }

    public final void onOtherPayModeSelected(boolean z2, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener) {
        k.c(otherPayOptionsListener, "otherPayOptionsListener");
        this.az = otherPayOptionsListener;
        s();
        if (z2) {
            c();
        }
        a(false, false);
    }

    public final void onPromoSelected(String str, int i2, String str2, VerifyPromoResultListener verifyPromoResultListener) {
        k.c(verifyPromoResultListener, "listener");
        this.ar = i2;
        this.as = str2;
        this.ax = verifyPromoResultListener;
        this.at = null;
        this.K = null;
        this.ay = false;
        a(str, false, a(this.H), false);
    }

    public final void onPaymentIntentSelected(String str, ArrayList<PaymentIntent> arrayList, String str2, VerifyPromoResultListener verifyPromoResultListener) {
        k.c(str, "promoCode");
        k.c(str2, "enableUpiPsp");
        k.c(verifyPromoResultListener, "listener");
        this.ax = verifyPromoResultListener;
        this.K = str;
        StringBuilder sb = new StringBuilder();
        if (arrayList != null) {
            String a2 = new com.google.gsonhtcfix.f().a((Object) arrayList);
            sb.append(",\"payment_intent\":");
            sb.append(a2);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(",\"enable_upi_psp\":\"");
            sb.append(str2);
            sb.append("\"");
        }
        this.at = sb.toString();
        n();
    }

    public final void clearPromoCode(String str, PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
        k.c(str, "s");
        k.c(applyAnotherOfferListener, "applyAnotherOfferListener");
        s();
        applyAnotherOfferListener.onSuccess();
    }

    private final void s() {
        Boolean value = this.u.getValue();
        this.u.setValue(Boolean.valueOf(value != null && !value.booleanValue()));
        a(false);
    }

    public final void onPromoSearchActivityDestroy(boolean z2) {
        if (!z2) {
            this.K = null;
            this.as = null;
            this.at = null;
            this.ar = 0;
        }
        b();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCleared() {
        super.onCleared();
        try {
            Job.DefaultImpls.cancel$default(this.F, (CancellationException) null, 1, (Object) null);
        } catch (VerifyError e2) {
            PaytmSDK.getCallbackListener().logException("CJRMovieBookingApiManager", "Coroutine verify exception caught", e2);
        } catch (Exception e3) {
            PaytmSDK.getCallbackListener().logException("CJRMovieBookingApiManager", "Coroutine clear exception caught", e3);
        }
        try {
            this.aJ.a();
        } catch (Exception unused) {
        }
    }

    public final void e() {
        b();
    }

    @kotlin.d.b.a.f(b = "CJRBookingApiManager.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.o2o.movies.helper.CJRBookingApiManager$init$1")
    public static final class f extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(b bVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = bVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            f fVar = new f(this.this$0, dVar);
            fVar.p$ = (CoroutineScope) obj;
            return fVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((f) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                this.this$0.j();
                b bVar = this.this$0;
                HashMap hashMap = new HashMap();
                Map map = hashMap;
                map.put("Content-Type", "application/json");
                map.put("ClientId", "paytm");
                Application application = bVar.getApplication();
                k.a((Object) application, "getApplication<Application>()");
                HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) hashMap, application.getApplicationContext());
                k.a((Object) a2, "CJRAppCommonUtility.addS…on>().applicationContext)");
                k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                String a3 = net.one97.paytm.o2o.movies.common.b.c.a("fetchMoviesUserBalance", (String) null);
                if (TextUtils.isEmpty(a3)) {
                    a3 = "https://apiproxy-moviesv2.paytm.com/v1/movies/user/balance";
                }
                k.a((Object) a3, "url");
                bVar.a(a3, (Map<String, String>) a2, (IJRPaytmDataModel) new CJRUserWalletBalance()).a();
                b bVar2 = this.this$0;
                b.a(bVar2, b.b(bVar2).getSeatPrice(), b.b(this.this$0).getMSelectedMoviesSession());
                if (this.this$0.f74894i) {
                    b bVar3 = this.this$0;
                    bVar3.f74892g = b.b(bVar3).getMCitySearched();
                    k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                    String a4 = net.one97.paytm.o2o.movies.common.b.c.a("movie_pass_get_codes_url", (String) null);
                    if (URLUtil.isValidUrl(a4)) {
                        Application application2 = bVar3.getApplication();
                        k.a((Object) application2, "getApplication<Application>()");
                        String n = com.paytm.utility.b.n(application2.getApplicationContext());
                        if (!TextUtils.isEmpty(bVar3.f74892g) && !TextUtils.isEmpty(n)) {
                            String str = a4 + "?city=" + bVar3.f74892g + "&customerId=" + n;
                            Application application3 = bVar3.getApplication();
                            k.a((Object) application3, "getApplication<Application>()");
                            Context applicationContext = application3.getApplicationContext();
                            k.a((Object) applicationContext, "getApplication<Application>().applicationContext");
                            String s = com.paytm.utility.b.s(applicationContext.getApplicationContext(), str);
                            Map hashMap2 = new HashMap();
                            hashMap2.put("ClientId", "paytm");
                            k.a((Object) s, "url");
                            bVar3.a(s, (Map<String, String>) hashMap2, (IJRPaytmDataModel) new CJRUserMoviePassWrapperModel((String) null, (ArrayList<CJRUserMoviePassModel>) null, (List<CJRUserMoviePassModel>) null)).a();
                        }
                    }
                }
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x026f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.CJRPGTokenList r13) {
        /*
            r12 = this;
            java.lang.String r0 = "cart_items"
            net.one97.paytm.o2o.movies.common.c.b r1 = net.one97.paytm.o2o.movies.common.c.b.f75032a
            net.one97.paytm.o2o.movies.common.c.c r1 = r1.f75033b
            java.lang.String r13 = r1.getPgToken(r13)
            r1 = r13
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L_0x0276
            java.lang.String r1 = "walletSSOToken"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r1)
            com.paytm.utility.b.j()
            android.app.Application r1 = r12.getApplication()
            java.lang.String r3 = "getApplication<Application>()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            android.content.Context r1 = r1.getApplicationContext()
            if (r1 == 0) goto L_0x0275
            r1 = 0
            r12.R = r1
            net.one97.paytm.o2o.movies.common.b.c r4 = net.one97.paytm.o2o.movies.common.b.c.a()
            java.lang.String r5 = "MoviesGTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r4 = "moviesCheckoutUrl"
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.c.a(r4, r2)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 == 0) goto L_0x0045
            java.lang.String r2 = "https://apiproxy-moviesv2.paytm.com/v1/movies/expresscart/checkout"
        L_0x0045:
            android.app.Application r4 = r12.getApplication()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            android.content.Context r4 = r4.getApplicationContext()
            java.lang.String r2 = com.paytm.utility.c.b((java.lang.String) r2, (android.content.Context) r4)
            java.lang.String r4 = com.paytm.utility.b.k()
            android.net.Uri r5 = android.net.Uri.parse(r2)
            java.lang.String r6 = "Uri.parse(url)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.String r5 = r5.getQuery()
            java.lang.String r6 = "&client_id="
            if (r5 == 0) goto L_0x0084
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            java.lang.String r2 = "&wallet_token="
            r5.append(r2)
            r5.append(r13)
            r5.append(r6)
            r5.append(r4)
            java.lang.String r13 = r5.toString()
            goto L_0x009e
        L_0x0084:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            java.lang.String r2 = "?wallet_token="
            r5.append(r2)
            r5.append(r13)
            r5.append(r6)
            r5.append(r4)
            java.lang.String r13 = r5.toString()
        L_0x009e:
            java.lang.String r2 = "POST"
            java.lang.String r13 = com.paytm.utility.b.d((java.lang.String) r13, (java.lang.String) r2)
            net.one97.paytm.o2o.movies.utils.i r2 = net.one97.paytm.o2o.movies.utils.i.a()
            java.lang.String r4 = "CJRMovieSearchResponseHo…erSingleton.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.String r2 = r2.k
            if (r2 == 0) goto L_0x00cb
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.a.d.b(r2)
            if (r2 == 0) goto L_0x00cb
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r13)
            java.lang.String r13 = "&custom_device_id="
            r4.append(r13)
            r4.append(r2)
            java.lang.String r13 = r4.toString()
        L_0x00cb:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r4 = r2
            java.util.Map r4 = (java.util.Map) r4
            java.lang.String r5 = "Content-Type"
            java.lang.String r6 = "application/json"
            r4.put(r5, r6)
            java.lang.String r5 = "ClientId"
            java.lang.String r6 = "paytm"
            r4.put(r5, r6)
            android.app.Application r4 = r12.getApplication()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            android.content.Context r4 = r4.getApplicationContext()
            java.util.HashMap r2 = com.paytm.utility.b.a((java.util.HashMap<java.lang.String, java.lang.String>) r2, (android.content.Context) r4)
            java.lang.String r4 = "CJRAppCommonUtility.addS…on>().applicationContext)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            net.one97.paytm.o2o.movies.common.c.b r4 = net.one97.paytm.o2o.movies.common.c.b.f75032a
            net.one97.paytm.o2o.movies.common.c.c r4 = r4.f75033b
            r4.clearRisk()
            net.one97.paytm.o2o.movies.common.c.b r4 = net.one97.paytm.o2o.movies.common.c.b.f75032a
            net.one97.paytm.o2o.movies.common.c.c r5 = r4.f75033b
            android.app.Application r4 = r12.getApplication()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            android.content.Context r6 = r4.getApplicationContext()
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r5.setRiskExtendedInfo(r6, r7, r8, r9, r10)
            net.one97.paytm.o2o.movies.common.c.b r4 = net.one97.paytm.o2o.movies.common.c.b.f75032a
            net.one97.paytm.o2o.movies.common.c.c r4 = r4.f75033b
            java.lang.String r5 = "MoviesController.getMovieEventListener()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r4 = r4.getJsonOfRiskExtendedInfo()
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0130
            r5 = r2
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r6 = "risk_extended_info"
            r5.put(r6, r4)
        L_0x0130:
            net.one97.paytm.o2o.movies.common.c.b r4 = net.one97.paytm.o2o.movies.common.c.b.f75032a
            net.one97.paytm.o2o.movies.common.c.c r4 = r4.f75033b
            r4.clearRisk()
            net.one97.paytm.common.entity.movies.booking.CJRPrevalidate r4 = r12.J
            if (r4 == 0) goto L_0x0200
            if (r4 != 0) goto L_0x0140
            kotlin.g.b.k.a()
        L_0x0140:
            java.lang.String r4 = r4.getCartBody()
            java.lang.String r5 = "mPrevalidate!!.cartBody"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r5 = r12.av     // Catch:{ Exception -> 0x01ab }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x01ab }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01ab }
            if (r5 != 0) goto L_0x01ab
            com.google.gsonhtcfix.f r5 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x01ab }
            r5.<init>()     // Catch:{ Exception -> 0x01ab }
            java.lang.Class<com.google.gsonhtcfix.o> r6 = com.google.gsonhtcfix.o.class
            java.lang.Object r5 = r5.a((java.lang.String) r4, r6)     // Catch:{ Exception -> 0x01ab }
            java.lang.String r6 = "Gson().fromJson(movieCart, JsonObject::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x01ab }
            com.google.gsonhtcfix.o r5 = (com.google.gsonhtcfix.o) r5     // Catch:{ Exception -> 0x01ab }
            com.google.gsonhtcfix.i r5 = r5.c(r0)     // Catch:{ Exception -> 0x01ab }
            com.google.gsonhtcfix.i r6 = new com.google.gsonhtcfix.i     // Catch:{ Exception -> 0x01ab }
            r6.<init>()     // Catch:{ Exception -> 0x01ab }
            java.util.List<com.google.gsonhtcfix.l> r7 = r5.f39821a     // Catch:{ Exception -> 0x01ab }
            int r7 = r7.size()     // Catch:{ Exception -> 0x01ab }
            r8 = 0
        L_0x0175:
            if (r8 >= r7) goto L_0x0197
            java.util.List<com.google.gsonhtcfix.l> r9 = r5.f39821a     // Catch:{ Exception -> 0x01ab }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ Exception -> 0x01ab }
            com.google.gsonhtcfix.l r9 = (com.google.gsonhtcfix.l) r9     // Catch:{ Exception -> 0x01ab }
            java.lang.String r10 = "cartItem.get(i)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)     // Catch:{ Exception -> 0x01ab }
            com.google.gsonhtcfix.o r9 = r9.g()     // Catch:{ Exception -> 0x01ab }
            java.lang.String r10 = "bank_promocode"
            java.lang.String r11 = r12.av     // Catch:{ Exception -> 0x01ab }
            r9.a((java.lang.String) r10, (java.lang.String) r11)     // Catch:{ Exception -> 0x01ab }
            com.google.gsonhtcfix.l r9 = (com.google.gsonhtcfix.l) r9     // Catch:{ Exception -> 0x01ab }
            r6.a(r9)     // Catch:{ Exception -> 0x01ab }
            int r8 = r8 + 1
            goto L_0x0175
        L_0x0197:
            com.google.gsonhtcfix.o r5 = new com.google.gsonhtcfix.o     // Catch:{ Exception -> 0x01ab }
            r5.<init>()     // Catch:{ Exception -> 0x01ab }
            com.google.gsonhtcfix.l r6 = (com.google.gsonhtcfix.l) r6     // Catch:{ Exception -> 0x01ab }
            r5.a((java.lang.String) r0, (com.google.gsonhtcfix.l) r6)     // Catch:{ Exception -> 0x01ab }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x01ab }
            java.lang.String r5 = "jsonObject.toString()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x01ab }
            goto L_0x01ac
        L_0x01ab:
            r0 = r4
        L_0x01ac:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            java.lang.String r0 = r12.au
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r5 = "}"
            if (r0 != 0) goto L_0x01c6
            int r0 = r4.lastIndexOf(r5)
            java.lang.String r6 = r12.au
            r4.insert(r0, r6)
        L_0x01c6:
            java.lang.String r0 = r12.aw
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01d9
            int r0 = r4.lastIndexOf(r5)
            java.lang.String r6 = r12.aw
            r4.insert(r0, r6)
        L_0x01d9:
            java.lang.String r0 = r12.K
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01f6
            java.lang.String r0 = r12.aA
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01f6
            int r0 = r4.lastIndexOf(r5)
            java.lang.String r5 = r12.aA
            r4.insert(r0, r5)
        L_0x01f6:
            java.lang.String r0 = r4.toString()
            java.lang.String r4 = "stringBuilder.toString()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            goto L_0x0202
        L_0x0200:
            java.lang.String r0 = ""
        L_0x0202:
            java.lang.String r4 = java.lang.String.valueOf(r0)
            java.lang.String r5 = "cartCheckout : "
            r5.concat(r4)
            com.paytm.utility.b.j()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r13)
            net.one97.paytm.common.entity.wallet.CJRCashWallet r13 = r12.N
            if (r13 == 0) goto L_0x023c
            boolean r5 = r12.Q
            if (r5 == 0) goto L_0x023c
            if (r13 != 0) goto L_0x0223
            kotlin.g.b.k.a()
        L_0x0223:
            net.one97.paytm.common.entity.wallet.CJRCashWalletResponse r13 = r13.getResponse()
            java.lang.String r5 = "mCashWallet!!.response"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r5)
            double r5 = r13.getAmount()
            double r7 = r12.L
            int r13 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r13 > 0) goto L_0x023c
            r13 = 1
            r12.R = r13
            java.lang.String r13 = "&withdraw=1"
            goto L_0x023e
        L_0x023c:
            java.lang.String r13 = "&native_withdraw=1"
        L_0x023e:
            r4.append(r13)
            java.lang.String r13 = r4.toString()
            java.lang.String r4 = "url"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r4)
            java.util.Map r2 = (java.util.Map) r2
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r4 = new net.one97.paytm.common.entity.recharge.CJRRechargePayment
            r4.<init>()
            com.paytm.network.model.IJRPaytmDataModel r4 = (com.paytm.network.model.IJRPaytmDataModel) r4
            com.paytm.network.a r13 = r12.a((java.lang.String) r13, (java.util.Map<java.lang.String, java.lang.String>) r2, (java.lang.String) r0, (com.paytm.network.model.IJRPaytmDataModel) r4)
            android.app.Application r0 = r12.getApplication()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            android.content.Context r0 = r0.getApplicationContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x026f
            r12.a()
            r13.a()
            return
        L_0x026f:
            r12.b()
            r12.a((com.paytm.network.a) r13, (boolean) r1)
        L_0x0275:
            return
        L_0x0276:
            r12.b()
            net.one97.paytm.o2o.movies.common.c.b r13 = net.one97.paytm.o2o.movies.common.c.b.f75032a
            net.one97.paytm.o2o.movies.common.c.c r13 = r13.f75033b
            android.app.Activity r0 = r12.f74888c
            r13.showSessionTimeoutAlert(r0, r2, r2, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.b.a(net.one97.paytm.common.entity.CJRPGTokenList):void");
    }

    public final void a(String str, double d2, ArrayList<CJRFoodBeverageItemV2> arrayList, int i2, CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect, boolean z2, String str2) {
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.openPromoScreen("", this.f74888c, d2, str, this, this);
        a(arrayList, i2, cJRMovieNewCancellationProtect, z2, this.aE, str2, d2);
    }

    public static final /* synthetic */ void a(b bVar, double d2, CJRMoviesSession cJRMoviesSession) {
        if (net.one97.paytm.o2o.movies.common.a.a.a(bVar.f74888c) && com.paytm.utility.b.c((Context) bVar.f74888c)) {
            try {
                k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                String a2 = net.one97.paytm.o2o.movies.common.b.c.a("movieTicketCategoryId", (String) null);
                if (TextUtils.isEmpty(a2)) {
                    a2 = "80491,118442";
                }
                k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                String a3 = net.one97.paytm.o2o.movies.common.b.c.a("moviePromoSearchUrl", (String) null);
                k.a((Object) a3, "MoviesGTMLoader.getInsta…).moviePromoOffersPartOne");
                String a4 = kotlin.m.p.a(a3, "v1", "v2", false);
                k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                String a5 = net.one97.paytm.o2o.movies.common.b.c.a("moviePromoSearchUrlExtension", (String) null);
                k.a((Object) a5, "MoviesGTMLoader.getInsta…).moviePromoOffersPartTwo");
                String str = a4 + bVar.f74893h + a5;
                if (URLUtil.isValidUrl(str)) {
                    String a6 = n.a("formatId", cJRMoviesSession.getFrmtId(), n.a("movieId", cJRMoviesSession.getMovieCode(), n.a("cinemaId", cJRMoviesSession.getCinemaID(), n.a("category_id", a2, n.a("price", Double.toString(d2), com.paytm.utility.b.s(bVar.f74888c, str))))));
                    HashMap hashMap = new HashMap();
                    String a7 = kotlin.m.p.a("sso_token=", "=", "", false);
                    String sSOToken = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getSSOToken(bVar.f74888c);
                    k.a((Object) sSOToken, "MoviesController.getMovi…().getSSOToken(mActivity)");
                    hashMap.put(a7, sSOToken);
                    hashMap.put("clientId", "paytm");
                    net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
                    cVar.f42877a = bVar.f74888c;
                    cVar.f42878b = a.c.MOVIES;
                    cVar.f42879c = a.C0715a.GET;
                    cVar.f42880d = a6;
                    cVar.f42881e = null;
                    cVar.f42882f = hashMap;
                    cVar.f42883g = null;
                    cVar.f42884h = null;
                    cVar.f42885i = new CJRMovieOffers();
                    cVar.j = bVar;
                    cVar.n = a.b.USER_FACING;
                    cVar.o = "movies";
                    cVar.t = n.h("FJRPostOrderFoodAndBeverages");
                    com.paytm.network.a l2 = cVar.l();
                    l2.f42859c = false;
                    l2.a();
                }
            } catch (Exception unused) {
            }
        }
    }

    public static final /* synthetic */ void a(b bVar, CJRMovieCart cJRMovieCart) {
        PaytmSDKRequestClient.VerifyResponseData verifyResponseData = new PaytmSDKRequestClient.VerifyResponseData();
        CJRMCart cart = cJRMovieCart.getCart();
        k.a((Object) cart, "cart.cart");
        verifyResponseData.setOfferText(cart.getPromoText());
        try {
            CJRMCart cart2 = cJRMovieCart.getCart();
            k.a((Object) cart2, "cart.cart");
            Double valueOf = Double.valueOf(cart2.getPaytmCashBack());
            k.a((Object) valueOf, "java.lang.Double.valueOf(cart.cart.paytmCashBack)");
            verifyResponseData.setPaytmCashBack(valueOf.doubleValue());
            CJRMCart cart3 = cJRMovieCart.getCart();
            k.a((Object) cart3, "cart.cart");
            Double valueOf2 = Double.valueOf(cart3.getPaytmDiscount());
            k.a((Object) valueOf2, "java.lang.Double.valueOf(cart.cart.paytmDiscount)");
            verifyResponseData.setPaytmDiscount(valueOf2.doubleValue());
            verifyResponseData.setMid(cJRMovieCart.getCart().paymentInfo.mid);
            CJRPromoMetaData cJRPromoMetaData = cJRMovieCart.getCart().promoMetaData;
            if (!(cJRPromoMetaData == null || cJRPromoMetaData.paymentData == null)) {
                CJRPaymentData cJRPaymentData = cJRPromoMetaData.paymentData;
                if (cJRPaymentData.is8DigitBin != null) {
                    verifyResponseData.setIs8DigitBin(cJRPaymentData.is8DigitBin);
                }
            }
        } catch (Exception unused) {
        }
        VerifyPromoResultListener verifyPromoResultListener = bVar.ax;
        if (verifyPromoResultListener == null) {
            k.a();
        }
        CJRMCart cart4 = cJRMovieCart.getCart();
        k.a((Object) cart4, "cart.cart");
        verifyPromoResultListener.onVerifyPromoSuccess(cart4.getInstruments(), false, verifyResponseData);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a7, code lost:
        if (r5.subSequence(r6, r7 + 1).toString().length() == 0) goto L_0x01a9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void c(net.one97.paytm.o2o.movies.b.b r12, net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart r13) {
        /*
            if (r13 == 0) goto L_0x020b
            net.one97.paytm.common.entity.shopping.CJRCartStatus r0 = r13.getCartStatus()
            if (r0 == 0) goto L_0x020b
            net.one97.paytm.common.entity.shopping.CJRCartStatus r0 = r13.getCartStatus()
            java.lang.String r1 = "rechargeCart.cartStatus"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.getResult()
            if (r0 == 0) goto L_0x020b
            net.one97.paytm.common.entity.shopping.CJRCartStatus r0 = r13.getCartStatus()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.getResult()
            java.lang.String r1 = "SUCCESS"
            r2 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
            if (r0 == 0) goto L_0x020b
            net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a
            net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b
            android.app.Application r3 = r12.getApplication()
            java.lang.String r4 = "getApplication<Application>()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            android.content.Context r3 = r3.getApplicationContext()
            boolean r0 = r0.containsError(r13, r3)
            if (r0 != 0) goto L_0x020b
            net.one97.paytm.o2o.movies.common.movies.booking.CJRMCart r13 = r13.getCart()
            android.app.Application r0 = r12.getApplication()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 == 0) goto L_0x020b
            r0 = 0
            r3 = 0
            if (r13 == 0) goto L_0x015c
            java.lang.String r5 = r13.getPromoStatus()
            if (r5 == 0) goto L_0x015c
            java.lang.String r5 = r13.getPromoStatus()
            boolean r1 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r2)
            if (r1 == 0) goto L_0x015c
            java.util.ArrayList r1 = r13.getCartItems()
            if (r1 == 0) goto L_0x0102
            java.util.ArrayList r1 = r13.getCartItems()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0102
            r1 = r0
            r4 = 0
        L_0x0079:
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x008b
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x00ff
        L_0x008b:
            java.util.ArrayList r5 = r13.getCartItems()
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x00ff
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$VerifyResponseData r0 = new net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$VerifyResponseData
            r0.<init>()
            java.lang.String r1 = r13.getPromoText()
            r0.setOfferText(r1)
            java.lang.String r1 = r13.getPaytmCashBack()     // Catch:{ Exception -> 0x00ca }
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r5 = "java.lang.Double.valueOf(cart.paytmCashBack)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)     // Catch:{ Exception -> 0x00ca }
            double r5 = r1.doubleValue()     // Catch:{ Exception -> 0x00ca }
            r0.setPaytmCashBack(r5)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r1 = r13.getPaytmDiscount()     // Catch:{ Exception -> 0x00ca }
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r5 = "java.lang.Double.valueOf(cart.paytmDiscount)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)     // Catch:{ Exception -> 0x00ca }
            double r5 = r1.doubleValue()     // Catch:{ Exception -> 0x00ca }
            r0.setPaytmDiscount(r5)     // Catch:{ Exception -> 0x00ca }
            goto L_0x00cb
        L_0x00ca:
        L_0x00cb:
            net.one97.paytm.nativesdk.app.VerifyPromoResultListener r1 = r12.ax
            if (r1 == 0) goto L_0x00db
            if (r1 != 0) goto L_0x00d4
            kotlin.g.b.k.a()
        L_0x00d4:
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r5 = r13.getInstruments()
            r1.onVerifyPromoSuccess(r5, r2, r0)
        L_0x00db:
            java.util.ArrayList r0 = r13.getCartItems()
            java.lang.Object r0 = r0.get(r4)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            java.lang.String r1 = "cartProduct"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = r0.getPromoCode()
            r12.K = r1
            java.lang.String r1 = r12.K
            r12.ak = r1
            java.lang.String r0 = r0.getPromoText()
            int r4 = r4 + 1
            r11 = r1
            r1 = r0
            r0 = r11
            goto L_0x0079
        L_0x00ff:
            r6 = r0
            r0 = r1
            goto L_0x0103
        L_0x0102:
            r6 = r0
        L_0x0103:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0110
            java.lang.String r0 = r13.getPromoText()
        L_0x0110:
            r8 = r0
            java.lang.String r0 = r13.getPaytmCashBack()
            java.lang.String r1 = "0"
            boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r2)
            if (r0 == 0) goto L_0x0122
            java.lang.String r0 = r13.getPaytmPGCashBack()
            goto L_0x0126
        L_0x0122:
            java.lang.String r0 = r13.getPaytmCashBack()
        L_0x0126:
            r7 = r0
            net.one97.paytm.o2o.movies.entity.CJRMoviePromoStatus r0 = new net.one97.paytm.o2o.movies.entity.CJRMoviePromoStatus
            r5 = 1
            boolean r9 = r12.aj
            java.lang.String r10 = r13.getPaytmDiscount()
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            androidx.lifecycle.y<net.one97.paytm.o2o.movies.entity.CJRMoviePromoStatus> r13 = r12.s
            r13.setValue(r0)
            java.lang.String r13 = r12.at
            if (r13 == 0) goto L_0x0147
            r12.Q = r3
            androidx.lifecycle.y<java.lang.Boolean> r13 = r12.t
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r13.setValue(r0)
            goto L_0x014e
        L_0x0147:
            androidx.lifecycle.y<java.lang.Boolean> r13 = r12.t
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r13.setValue(r0)
        L_0x014e:
            boolean r13 = r12.P
            if (r13 == 0) goto L_0x0155
            r12.q()
        L_0x0155:
            java.lang.String r13 = "Promocode Applied"
            r12.c((java.lang.String) r13)
            goto L_0x0209
        L_0x015c:
            if (r13 == 0) goto L_0x0163
            java.lang.String r1 = r13.getPromoFailureText()
            goto L_0x0164
        L_0x0163:
            r1 = r0
        L_0x0164:
            boolean r5 = r12.P
            if (r5 == 0) goto L_0x016d
            r12.q()
            goto L_0x0207
        L_0x016d:
            if (r1 == 0) goto L_0x01a9
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r6 = r5.length()
            int r6 = r6 - r2
            r7 = r6
            r6 = 0
            r8 = 0
        L_0x017a:
            if (r6 > r7) goto L_0x019a
            if (r8 != 0) goto L_0x0180
            r9 = r6
            goto L_0x0181
        L_0x0180:
            r9 = r7
        L_0x0181:
            char r9 = r5.charAt(r9)
            r10 = 32
            if (r9 > r10) goto L_0x018b
            r9 = 1
            goto L_0x018c
        L_0x018b:
            r9 = 0
        L_0x018c:
            if (r8 != 0) goto L_0x0195
            if (r9 != 0) goto L_0x0192
            r8 = 1
            goto L_0x017a
        L_0x0192:
            int r6 = r6 + 1
            goto L_0x017a
        L_0x0195:
            if (r9 == 0) goto L_0x019a
            int r7 = r7 + -1
            goto L_0x017a
        L_0x019a:
            int r7 = r7 + r2
            java.lang.CharSequence r2 = r5.subSequence(r6, r7)
            java.lang.String r2 = r2.toString()
            int r2 = r2.length()
            if (r2 != 0) goto L_0x01c6
        L_0x01a9:
            android.app.Application r1 = r12.getApplication()     // Catch:{ Exception -> 0x01c4 }
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x01c4 }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r2 = "getApplication<Application>().applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x01c4 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x01c4 }
            int r2 = net.one97.paytm.o2o.movies.R.string.msg_invalid_recharge_promo_code     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x01c4 }
            goto L_0x01c6
        L_0x01c4:
            java.lang.String r1 = "Invalid"
        L_0x01c6:
            r8 = r1
            net.one97.paytm.nativesdk.app.VerifyPromoResultListener r1 = r12.ax
            if (r1 == 0) goto L_0x01d3
            if (r1 != 0) goto L_0x01d0
            kotlin.g.b.k.a()
        L_0x01d0:
            r1.onVerifyPromoError(r8)
        L_0x01d3:
            boolean r1 = r12.ay
            if (r1 == 0) goto L_0x01f8
            java.lang.String r1 = r12.at
            if (r1 != 0) goto L_0x01f8
            net.one97.paytm.o2o.movies.entity.CJRMoviePromoStatus r1 = new net.one97.paytm.o2o.movies.entity.CJRMoviePromoStatus
            r5 = 0
            java.lang.String r6 = r12.K
            if (r13 != 0) goto L_0x01e5
            kotlin.g.b.k.a()
        L_0x01e5:
            java.lang.String r7 = r13.getPaytmCashBack()
            boolean r9 = r12.aj
            java.lang.String r10 = r13.getPaytmDiscount()
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            androidx.lifecycle.y<net.one97.paytm.o2o.movies.entity.CJRMoviePromoStatus> r13 = r12.s
            r13.setValue(r1)
        L_0x01f8:
            boolean r13 = r12.aj
            if (r13 == 0) goto L_0x01ff
            java.lang.String r13 = r12.ak
            goto L_0x0200
        L_0x01ff:
            r13 = r0
        L_0x0200:
            r12.K = r13
            java.lang.String r13 = "Promocode Error"
            r12.c((java.lang.String) r13)
        L_0x0207:
            r12.at = r0
        L_0x0209:
            r12.aj = r3
        L_0x020b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.b.c(net.one97.paytm.o2o.movies.b.b, net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart):void");
    }

    public static final /* synthetic */ void s(b bVar) {
        com.paytm.utility.b.j();
        k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
        String a2 = net.one97.paytm.o2o.movies.common.b.c.a("moviesSetSeat", (String) null);
        if (URLUtil.isValidUrl(a2)) {
            BookingData bookingData = bVar.f74886a;
            if (bookingData == null) {
                k.a("mBookingData");
            }
            String movieCode = bookingData.getMSelectedMoviesSession().getMovieCode();
            BookingData bookingData2 = bVar.f74886a;
            if (bookingData2 == null) {
                k.a("mBookingData");
            }
            String cinemaID = bookingData2.getMSelectedMoviesSession().getCinemaID();
            BookingData bookingData3 = bVar.f74886a;
            if (bookingData3 == null) {
                k.a("mBookingData");
            }
            String sessionID = bookingData3.getMSelectedMoviesSession().getSessionID();
            Application application = bVar.getApplication();
            k.a((Object) application, "getApplication<Application>()");
            String a3 = com.paytm.utility.b.a(application.getApplicationContext(), a2, movieCode, cinemaID, sessionID);
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ClientId", "paytm");
            JSONObject jSONObject = new JSONObject();
            try {
                if (bVar.f74889d != null) {
                    CJRAddSeat cJRAddSeat = bVar.f74889d;
                    if (cJRAddSeat == null) {
                        k.a();
                    }
                    if (!TextUtils.isEmpty(cJRAddSeat.getTempTransId())) {
                        CJRAddSeat cJRAddSeat2 = bVar.f74889d;
                        if (cJRAddSeat2 == null) {
                            k.a();
                        }
                        jSONObject.put("tempTransId", cJRAddSeat2.getTempTransId());
                    }
                }
                BookingData bookingData4 = bVar.f74886a;
                if (bookingData4 == null) {
                    k.a("mBookingData");
                }
                if (!TextUtils.isEmpty(bookingData4.getMSelectedMoviesSession().getProviderId())) {
                    BookingData bookingData5 = bVar.f74886a;
                    if (bookingData5 == null) {
                        k.a("mBookingData");
                    }
                    jSONObject.put("providerId", bookingData5.getMSelectedMoviesSession().getProviderId());
                }
                BookingData bookingData6 = bVar.f74886a;
                if (bookingData6 == null) {
                    k.a("mBookingData");
                }
                if (!TextUtils.isEmpty(bookingData6.getMSelectedMoviesSession().getCinemaID())) {
                    BookingData bookingData7 = bVar.f74886a;
                    if (bookingData7 == null) {
                        k.a("mBookingData");
                    }
                    jSONObject.put("cinemaId", bookingData7.getMSelectedMoviesSession().getCinemaID());
                }
                BookingData bookingData8 = bVar.f74886a;
                if (bookingData8 == null) {
                    k.a("mBookingData");
                }
                if (!TextUtils.isEmpty(bookingData8.getMSelectedMoviesSession().getSessionID())) {
                    BookingData bookingData9 = bVar.f74886a;
                    if (bookingData9 == null) {
                        k.a("mBookingData");
                    }
                    jSONObject.put(H5Param.SESSION_ID, bookingData9.getMSelectedMoviesSession().getSessionID());
                }
                BookingData bookingData10 = bVar.f74886a;
                if (bookingData10 == null) {
                    k.a("mBookingData");
                }
                if (!TextUtils.isEmpty(bookingData10.getMSelectedMoviesSession().getRealShowDateTime())) {
                    BookingData bookingData11 = bVar.f74886a;
                    if (bookingData11 == null) {
                        k.a("mBookingData");
                    }
                    jSONObject.put("showDateTime", bookingData11.getMSelectedMoviesSession().getRealShowDateTime());
                }
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                BookingData bookingData12 = bVar.f74886a;
                if (bookingData12 == null) {
                    k.a("mBookingData");
                }
                Iterator<CJRObjSeat> it2 = bookingData12.getMSelectedSeatList().iterator();
                while (it2.hasNext()) {
                    CJRObjSeat next = it2.next();
                    k.a((Object) next, "objSeat");
                    jSONArray.put(next.getAreaCode());
                    jSONArray2.put(next.getGridSeatAreaNum());
                    jSONArray3.put(Integer.toString(next.getGridSeatRowId()));
                    jSONArray4.put(Integer.toString(next.getGridSeatNum()));
                }
                jSONObject.put("areaCategoryCode", jSONArray);
                jSONObject.put("areaNumber", jSONArray2);
                jSONObject.put("gridSeatRowId", jSONArray3);
                jSONObject.put("gridSeatNumber", jSONArray4);
            } catch (JSONException unused) {
            }
            String jSONObject2 = jSONObject.toString();
            k.a((Object) jSONObject2, "jsonRequest.toString()");
            "setSeat : ".concat(String.valueOf(jSONObject2));
            com.paytm.utility.b.j();
            k.a((Object) a3, "url");
            com.paytm.network.a a4 = bVar.a(a3, (Map<String, String>) hashMap, jSONObject2, (IJRPaytmDataModel) new CJRSetSeat());
            Application application2 = bVar.getApplication();
            k.a((Object) application2, "getApplication<Application>()");
            if (com.paytm.utility.b.c(application2.getApplicationContext())) {
                bVar.a();
                a4.a();
                return;
            }
            bVar.b();
            bVar.a(a4, false);
        }
    }
}

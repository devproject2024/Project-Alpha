package net.one97.paytm.hotel4.view.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.google.android.material.appbar.AppBarLayout;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.u;
import net.one97.paytm.common.entity.BookingStatus;
import net.one97.paytm.common.entity.shopping.CJRActionResponse;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.OrderSummary;
import net.one97.paytm.hotel4.service.model.details.PaytmImages;
import net.one97.paytm.hotel4.service.model.ordersummary.CancelOrderModel;
import net.one97.paytm.hotel4.service.model.ordersummary.MetaData;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotel4.viewmodel.DataViewModel;
import net.one97.paytm.hotel4.viewmodel.ErrorViewModel;
import net.one97.paytm.hotel4.viewmodel.HotelBookingStatusViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.bo;
import net.one97.paytm.hotels2.entity.hoteldetail.ProviderPhoneNumber;
import net.one97.paytm.hotels2.fragment.FJRContactHotelBottomFragment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionHistory;

public final class AJRHotelsBookingStatusNew extends AJRHotelBaseActivity {

    /* renamed from: c  reason: collision with root package name */
    private long f29052c = 5000;

    /* renamed from: d  reason: collision with root package name */
    private bo f29053d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29054e;

    /* renamed from: f  reason: collision with root package name */
    private HotelBookingStatusViewModel f29055f;

    /* renamed from: g  reason: collision with root package name */
    private ErrorViewModel f29056g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f29057h = "";

    /* renamed from: i  reason: collision with root package name */
    private BookingStatus f29058i;
    private final String j = "url";
    /* access modifiers changed from: private */
    public net.one97.paytm.hotels2.utils.b k;
    /* access modifiers changed from: private */
    public boolean l;
    private DataViewModel m;
    private boolean n;
    /* access modifiers changed from: private */
    public boolean o;
    /* access modifiers changed from: private */
    public boolean p;
    /* access modifiers changed from: private */
    public int q = 1;
    private Handler r = new b(this);

    static final class q implements DialogInterface.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        public static final q f29077a = new q();

        q() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    public static final /* synthetic */ void b() {
    }

    static final class f<T> implements z<ErrorData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29066a;

        f(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29066a = aJRHotelsBookingStatusNew;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer statusCode;
            ErrorData errorData = (ErrorData) obj;
            this.f29066a.a();
            AJRHotelsBookingStatusNew.a(this.f29066a).D.b();
            ShimmerFrameLayout shimmerFrameLayout = AJRHotelsBookingStatusNew.a(this.f29066a).D;
            kotlin.g.b.k.a((Object) shimmerFrameLayout, "activityHotelBookingBinding.shimmerFrameLayout");
            shimmerFrameLayout.setVisibility(8);
            AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew = this.f29066a;
            kotlin.g.b.k.a((Object) errorData, "data");
            kotlin.g.b.k.c(errorData, "error");
            Integer statusCode2 = errorData.getStatusCode();
            if (statusCode2 != null && statusCode2.intValue() == 901) {
                com.paytm.utility.b.a((Context) aJRHotelsBookingStatusNew, aJRHotelsBookingStatusNew.getResources().getString(R.string.hotels_hotel_no_internet_title), aJRHotelsBookingStatusNew.getResources().getString(R.string.hotels_hotel_no_internet_message));
                return;
            }
            Integer statusCode3 = errorData.getStatusCode();
            if ((statusCode3 != null && statusCode3.intValue() == 410) || ((statusCode = errorData.getStatusCode()) != null && statusCode.intValue() == 401)) {
                net.one97.paytm.hotels2.utils.c.b().a((FragmentActivity) aJRHotelsBookingStatusNew);
            } else if (!TextUtils.isEmpty(errorData.getMessage())) {
                com.paytm.utility.b.b((Context) aJRHotelsBookingStatusNew, errorData.getTitle(), errorData.getMessage());
            } else {
                com.paytm.utility.b.b((Context) aJRHotelsBookingStatusNew, aJRHotelsBookingStatusNew.getResources().getString(R.string.hotels_hotel_something_went_wrong), aJRHotelsBookingStatusNew.getResources().getString(R.string.hotels_hotel_error_message));
            }
        }
    }

    static final class g<T> implements z<ErrorData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29067a;

        g(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29067a = aJRHotelsBookingStatusNew;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer statusCode;
            ErrorData errorData = (ErrorData) obj;
            if (errorData != null && (statusCode = errorData.getStatusCode()) != null && statusCode.intValue() == 401) {
                this.f29067a.p = true;
                net.one97.paytm.hotels2.utils.c.b().a((FragmentActivity) this.f29067a);
            }
        }
    }

    static final class h<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29068a;

        h(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29068a = aJRHotelsBookingStatusNew;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew = this.f29068a;
            aJRHotelsBookingStatusNew.a(aJRHotelsBookingStatusNew, (String) obj);
        }
    }

    static final class i<T> implements z<ArrayList<ProviderPhoneNumber>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29069a;

        i(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29069a = aJRHotelsBookingStatusNew;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            this.f29069a.a();
            if (arrayList != null) {
                String string = this.f29069a.getString(R.string.hotels_hotels_summary_icon);
                kotlin.g.b.k.a((Object) string, "getString(R.string.hotels_hotels_summary_icon)");
                String string2 = this.f29069a.getString(R.string.hotels_call_clicked);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.hotels_call_clicked)");
                new HashMap().put(string, string2);
                if (arrayList.size() > 0) {
                    FJRContactHotelBottomFragment fJRContactHotelBottomFragment = new FJRContactHotelBottomFragment();
                    fJRContactHotelBottomFragment.setNumbersList(arrayList);
                    fJRContactHotelBottomFragment.show(this.f29069a.getSupportFragmentManager(), "");
                }
            }
        }
    }

    static final class j<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29070a;

        j(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29070a = aJRHotelsBookingStatusNew;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                AJRHotelsBookingStatusNew.e(this.f29070a);
            }
        }
    }

    static final class k<T> implements z<OrderSummary> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29071a;

        k(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29071a = aJRHotelsBookingStatusNew;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            OrderSummary orderSummary = (OrderSummary) obj;
            StringBuilder sb = new StringBuilder(" orderSummary observer called Status >>");
            sb.append(orderSummary != null ? orderSummary.getStatus() : null);
            com.paytm.utility.q.d(sb.toString());
            if (orderSummary == null) {
                this.f29071a.a();
                AJRHotelsBookingStatusNew.a(this.f29071a).D.b();
                ShimmerFrameLayout shimmerFrameLayout = AJRHotelsBookingStatusNew.a(this.f29071a).D;
                kotlin.g.b.k.a((Object) shimmerFrameLayout, "activityHotelBookingBinding.shimmerFrameLayout");
                shimmerFrameLayout.setVisibility(8);
                AJRHotelsBookingStatusNew.b(this.f29071a).sendOpenPulseEvent();
                AJRHotelsBookingStatusNew.f(this.f29071a).getTitle().postValue("Oops! Something Went Wrong");
                AJRHotelsBookingStatusNew.f(this.f29071a).getActionButton1Text().postValue("Retry Search");
                AJRHotelsBookingStatusNew.f(this.f29071a).getActionButton2Text().postValue("Go Back To Homepage");
                AJRHotelsBookingStatusNew.f(this.f29071a).getMessage().postValue("This is something from our end. Please try again");
                AJRHotelsBookingStatusNew.f(this.f29071a).getShowActionButton1().postValue(Boolean.TRUE);
                AJRHotelsBookingStatusNew.f(this.f29071a).getShowActionButton2().postValue(Boolean.TRUE);
                AJRHotelsBookingStatusNew.f(this.f29071a).getShowCloseButton().postValue(Boolean.FALSE);
                AJRHotelsBookingStatusNew.a(this.f29071a, new net.one97.paytm.hotel4.view.ui.a.c(), "ErrorFragment");
                return;
            }
            com.paytm.utility.q.d("orderSummary observe called Status >> inside cancel order else");
            this.f29071a.a();
            AJRHotelsBookingStatusNew.a(this.f29071a).D.b();
            ShimmerFrameLayout shimmerFrameLayout2 = AJRHotelsBookingStatusNew.a(this.f29071a).D;
            kotlin.g.b.k.a((Object) shimmerFrameLayout2, "activityHotelBookingBinding.shimmerFrameLayout");
            shimmerFrameLayout2.setVisibility(8);
            AJRHotelsBookingStatusNew.a(this.f29071a, orderSummary);
            AJRHotelsBookingStatusNew.b(this.f29071a).sendOpenPulseEvent();
        }
    }

    static final class l<T> implements z<CJRActionResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29072a;

        l(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29072a = aJRHotelsBookingStatusNew;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRActionResponse cJRActionResponse = (CJRActionResponse) obj;
            this.f29072a.a();
            if (cJRActionResponse != null && cJRActionResponse.getActions() != null) {
                ArrayList<CJROrderSummaryAction> actions = cJRActionResponse.getActions();
                kotlin.g.b.k.a((Object) actions, "it.actions");
                if (actions.size() > 0) {
                    CJROrderSummaryAction cJROrderSummaryAction = actions.get(0);
                    kotlin.g.b.k.a((Object) cJROrderSummaryAction, "actions[0]");
                    CJROrderSummaryAction cJROrderSummaryAction2 = cJROrderSummaryAction;
                    if (!TextUtils.isEmpty(cJROrderSummaryAction2.getLabel())) {
                        String label = cJROrderSummaryAction2.getLabel();
                        kotlin.g.b.k.a((Object) label, "action.label");
                        if (kotlin.m.p.a((CharSequence) label, (CharSequence) "Cancel Booking", false)) {
                            AJRHotelsBookingStatusNew.e(this.f29072a);
                            return;
                        }
                    }
                    if (kotlin.m.p.a(cJROrderSummaryAction2.getUiControl(), "browser", true) && cJROrderSummaryAction2.getUrlParams() != null) {
                        CJROrderSummaryActionURLParams urlParams = cJROrderSummaryAction2.getUrlParams();
                        kotlin.g.b.k.a((Object) urlParams, "action\n                 …               .urlParams");
                        if (!TextUtils.isEmpty(urlParams.getUrl())) {
                            AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew = this.f29072a;
                            CJROrderSummaryActionURLParams urlParams2 = cJROrderSummaryAction2.getUrlParams();
                            kotlin.g.b.k.a((Object) urlParams2, "action.urlParams");
                            aJRHotelsBookingStatusNew.k = new net.one97.paytm.hotels2.utils.b(urlParams2.getUrl(), this.f29072a.f29057h, this.f29072a);
                            net.one97.paytm.hotels2.utils.b g2 = this.f29072a.k;
                            if (g2 == null) {
                                kotlin.g.b.k.a();
                            }
                            g2.execute(new Void[0]);
                        }
                    }
                }
            }
        }
    }

    static final class m<T> implements z<kotlin.o<? extends String, ? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29073a;

        m(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29073a = aJRHotelsBookingStatusNew;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            kotlin.o oVar = (kotlin.o) obj;
            if (oVar != null) {
                oVar.getSecond();
                String str = (String) oVar.getFirst();
                if (kotlin.g.b.k.a((Object) str, (Object) ErrorViewModel.Companion.getACTION1())) {
                    this.f29073a.o = true;
                    this.f29073a.onBackPressed();
                    ShimmerFrameLayout shimmerFrameLayout = AJRHotelsBookingStatusNew.a(this.f29073a).D;
                    kotlin.g.b.k.a((Object) shimmerFrameLayout, "activityHotelBookingBinding.shimmerFrameLayout");
                    shimmerFrameLayout.setVisibility(0);
                    AJRHotelsBookingStatusNew.a(this.f29073a).D.a();
                    AJRHotelsBookingStatusNew.b(this.f29073a).getOrderDetails();
                } else if (kotlin.g.b.k.a((Object) str, (Object) ErrorViewModel.Companion.getACTION2())) {
                    this.f29073a.finish();
                }
            }
        }
    }

    static final class n<T> implements z<CJROrderedCart> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29074a;

        n(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29074a = aJRHotelsBookingStatusNew;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJROrderedCart cJROrderedCart = (CJROrderedCart) obj;
            this.f29074a.a();
            if (cJROrderedCart != null) {
                this.f29074a.l = true;
                AJRHotelsBookingStatusNew.b();
            }
        }
    }

    public static final /* synthetic */ bo a(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
        bo boVar = aJRHotelsBookingStatusNew.f29053d;
        if (boVar == null) {
            kotlin.g.b.k.a("activityHotelBookingBinding");
        }
        return boVar;
    }

    public static final /* synthetic */ HotelBookingStatusViewModel b(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
        HotelBookingStatusViewModel hotelBookingStatusViewModel = aJRHotelsBookingStatusNew.f29055f;
        if (hotelBookingStatusViewModel == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        return hotelBookingStatusViewModel;
    }

    public static final /* synthetic */ DataViewModel c(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
        DataViewModel dataViewModel = aJRHotelsBookingStatusNew.m;
        if (dataViewModel == null) {
            kotlin.g.b.k.a("dataViewModel");
        }
        return dataViewModel;
    }

    public static final /* synthetic */ ErrorViewModel f(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
        ErrorViewModel errorViewModel = aJRHotelsBookingStatusNew.f29056g;
        if (errorViewModel == null) {
            kotlin.g.b.k.a("errorViewModel");
        }
        return errorViewModel;
    }

    public static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29062a;

        b(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29062a = aJRHotelsBookingStatusNew;
        }

        public final void handleMessage(Message message) {
            kotlin.g.b.k.c(message, "msg");
            super.handleMessage(message);
            if (!this.f29062a.isFinishing()) {
                if ((Build.VERSION.SDK_INT < 17 || !this.f29062a.isDestroyed()) && message.what == this.f29062a.q) {
                    AJRHotelsBookingStatusNew.b(this.f29062a).getOrderDetails();
                }
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        y<ErrorData> cancelRefundError;
        y<CancelOrderModel> cancelRefundResponse;
        super.onCreate(bundle);
        com.paytm.utility.q.d("onCreate called");
        FragmentActivity fragmentActivity = this;
        ai a2 = am.a(fragmentActivity).a(DataViewModel.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…ataViewModel::class.java]");
        this.m = (DataViewModel) a2;
        ai a3 = am.a(fragmentActivity).a(ErrorViewModel.class);
        kotlin.g.b.k.a((Object) a3, "ViewModelProviders.of(th…rorViewModel::class.java)");
        this.f29056g = (ErrorViewModel) a3;
        ai a4 = am.a(fragmentActivity).a(HotelBookingStatusViewModel.class);
        kotlin.g.b.k.a((Object) a4, "ViewModelProviders.of(th…tusViewModel::class.java]");
        this.f29055f = (HotelBookingStatusViewModel) a4;
        ViewDataBinding a5 = androidx.databinding.f.a(this, R.layout.h4_hotel_booking_activity);
        kotlin.g.b.k.a((Object) a5, "DataBindingUtil.setConte…4_hotel_booking_activity)");
        this.f29053d = (bo) a5;
        bo boVar = this.f29053d;
        if (boVar == null) {
            kotlin.g.b.k.a("activityHotelBookingBinding");
        }
        setContentView(boVar.getRoot());
        HotelBookingStatusViewModel hotelBookingStatusViewModel = this.f29055f;
        if (hotelBookingStatusViewModel == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        boVar.a(hotelBookingStatusViewModel);
        bo boVar2 = this.f29053d;
        if (boVar2 == null) {
            kotlin.g.b.k.a("activityHotelBookingBinding");
        }
        ShimmerFrameLayout shimmerFrameLayout = boVar2.D;
        kotlin.g.b.k.a((Object) shimmerFrameLayout, "activityHotelBookingBinding.shimmerFrameLayout");
        shimmerFrameLayout.setVisibility(0);
        bo boVar3 = this.f29053d;
        if (boVar3 == null) {
            kotlin.g.b.k.a("activityHotelBookingBinding");
        }
        boVar3.D.a();
        HotelBookingStatusViewModel hotelBookingStatusViewModel2 = this.f29055f;
        if (hotelBookingStatusViewModel2 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        Intent intent = getIntent();
        kotlin.g.b.k.a((Object) intent, "intent");
        hotelBookingStatusViewModel2.setup(intent, this);
        HotelBookingStatusViewModel hotelBookingStatusViewModel3 = this.f29055f;
        if (hotelBookingStatusViewModel3 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        this.f29058i = hotelBookingStatusViewModel3.getBooking();
        HotelBookingStatusViewModel hotelBookingStatusViewModel4 = this.f29055f;
        if (hotelBookingStatusViewModel4 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        this.f29057h = hotelBookingStatusViewModel4.getOrderId();
        bo boVar4 = this.f29053d;
        if (boVar4 == null) {
            kotlin.g.b.k.a("activityHotelBookingBinding");
        }
        setSupportActionBar(boVar4.H);
        setTitle("");
        HotelBookingStatusViewModel hotelBookingStatusViewModel5 = this.f29055f;
        if (hotelBookingStatusViewModel5 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        androidx.lifecycle.q qVar = this;
        hotelBookingStatusViewModel5.getSharePressed().observe(qVar, new d(this));
        HotelBookingStatusViewModel hotelBookingStatusViewModel6 = this.f29055f;
        if (hotelBookingStatusViewModel6 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        hotelBookingStatusViewModel6.getOrderSummaryError().observe(qVar, new g(this));
        HotelBookingStatusViewModel hotelBookingStatusViewModel7 = this.f29055f;
        if (hotelBookingStatusViewModel7 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        hotelBookingStatusViewModel7.getProgressStatus().observe(qVar, new h(this));
        HotelBookingStatusViewModel hotelBookingStatusViewModel8 = this.f29055f;
        if (hotelBookingStatusViewModel8 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        hotelBookingStatusViewModel8.getCallHotelClickObserver().observe(qVar, new i(this));
        HotelBookingStatusViewModel hotelBookingStatusViewModel9 = this.f29055f;
        if (hotelBookingStatusViewModel9 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        hotelBookingStatusViewModel9.getCancelBookingClickObserver().observe(qVar, new j(this));
        HotelBookingStatusViewModel hotelBookingStatusViewModel10 = this.f29055f;
        if (hotelBookingStatusViewModel10 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        hotelBookingStatusViewModel10.getOrderSummary().observe(qVar, new k(this));
        HotelBookingStatusViewModel hotelBookingStatusViewModel11 = this.f29055f;
        if (hotelBookingStatusViewModel11 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        hotelBookingStatusViewModel11.getActionResponse().observe(qVar, new l(this));
        ErrorViewModel errorViewModel = this.f29056g;
        if (errorViewModel == null) {
            kotlin.g.b.k.a("errorViewModel");
        }
        errorViewModel.getButtonClickEvent().observe(qVar, new m(this));
        HotelBookingStatusViewModel hotelBookingStatusViewModel12 = this.f29055f;
        if (hotelBookingStatusViewModel12 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        hotelBookingStatusViewModel12.getOrderedCart().observe(qVar, new n(this));
        HotelBookingStatusViewModel hotelBookingStatusViewModel13 = this.f29055f;
        if (hotelBookingStatusViewModel13 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        if (!(hotelBookingStatusViewModel13 == null || (cancelRefundResponse = hotelBookingStatusViewModel13.getCancelRefundResponse()) == null)) {
            cancelRefundResponse.observe(qVar, new e(this));
        }
        HotelBookingStatusViewModel hotelBookingStatusViewModel14 = this.f29055f;
        if (hotelBookingStatusViewModel14 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        if (!(hotelBookingStatusViewModel14 == null || (cancelRefundError = hotelBookingStatusViewModel14.getCancelRefundError()) == null)) {
            cancelRefundError.observe(qVar, new f(this));
        }
        bo boVar5 = this.f29053d;
        if (boVar5 == null) {
            kotlin.g.b.k.a("activityHotelBookingBinding");
        }
        boVar5.f29272a.a((AppBarLayout.b) new c(this));
        HotelBookingStatusViewModel hotelBookingStatusViewModel15 = this.f29055f;
        if (hotelBookingStatusViewModel15 == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        if (!hotelBookingStatusViewModel15.getOrderDetails()) {
            finish();
        }
        com.paytm.utility.q.d("onCreate End called");
    }

    static final class c implements AppBarLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29063a;

        c(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29063a = aJRHotelsBookingStatusNew;
        }

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            CharSequence charSequence;
            AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew = this.f29063a;
            int abs = Math.abs(i2);
            kotlin.g.b.k.a((Object) appBarLayout, "appBarLayout");
            if (abs - appBarLayout.getTotalScrollRange() == 0) {
                TextView textView = AJRHotelsBookingStatusNew.a(this.f29063a).f29274c;
                kotlin.g.b.k.a((Object) textView, "activityHotelBookingBinding.bookingID");
                textView.setVisibility(8);
                charSequence = AJRHotelsBookingStatusNew.b(this.f29063a).getBookingId();
            } else {
                TextView textView2 = AJRHotelsBookingStatusNew.a(this.f29063a).f29274c;
                kotlin.g.b.k.a((Object) textView2, "activityHotelBookingBinding.bookingID");
                textView2.setVisibility(0);
            }
            aJRHotelsBookingStatusNew.setTitle(charSequence);
        }
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share, menu);
        return true;
    }

    public final void onResume() {
        super.onResume();
        if (this.p) {
            this.p = false;
            HotelBookingStatusViewModel hotelBookingStatusViewModel = this.f29055f;
            if (hotelBookingStatusViewModel == null) {
                kotlin.g.b.k.a("hotelBookingStatusViewModel");
            }
            if (!hotelBookingStatusViewModel.getOrderDetails()) {
                finish();
            }
        }
        Context context = this;
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        super.attachBaseContext(context);
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null) {
            kotlin.g.b.k.a();
        }
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return super.onOptionsItemSelected(menuItem);
        }
        if (itemId == R.id.share_menu) {
            HotelBookingStatusViewModel hotelBookingStatusViewModel = this.f29055f;
            if (hotelBookingStatusViewModel == null) {
                kotlin.g.b.k.a("hotelBookingStatusViewModel");
            }
            hotelBookingStatusViewModel.onSharePressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public final void onPause() {
        super.onPause();
        try {
            net.one97.paytm.hotels2.utils.b bVar = this.k;
            if (bVar == null) {
                kotlin.g.b.k.a();
            }
            if (bVar.b() != null) {
                net.one97.paytm.hotels2.utils.b bVar2 = this.k;
                if (bVar2 == null) {
                    kotlin.g.b.k.a();
                }
                unregisterReceiver(bVar2.b());
            }
        } catch (IllegalArgumentException | RuntimeException unused) {
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        kotlin.g.b.k.c(bundle, "outState");
        super.onSaveInstanceState(bundle);
        String str = this.j;
        kotlin.g.b.k.a((Object) net.one97.paytm.hotels2.utils.e.a(), "HotelsGTMLoader.getInstance()");
        bundle.putString(str, net.one97.paytm.hotels2.utils.e.h());
    }

    static final class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MetaData f29078a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29079b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OrderSummary f29080c;

        r(MetaData metaData, AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew, OrderSummary orderSummary) {
            this.f29078a = metaData;
            this.f29079b = aJRHotelsBookingStatusNew;
            this.f29080c = orderSummary;
        }

        public final void onClick(View view) {
            AJRHotelsBookingStatusNew.c(this.f29079b).setShowClose(true);
            AJRHotelsBookingStatusNew.c(this.f29079b).setTitle("Policies");
            AJRHotelsBookingStatusNew.c(this.f29079b).setShowRecyclerViewList(true);
            AJRHotelsBookingStatusNew.c(this.f29079b).getRecyclerListData().postValue(this.f29078a.hotelPolicy.getOther());
            AJRHotelsBookingStatusNew.a(this.f29079b, new net.one97.paytm.hotel4.view.ui.a.z(), "DataFragment");
        }
    }

    static final class s implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MetaData f29081a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29082b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OrderSummary f29083c;

        s(MetaData metaData, AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew, OrderSummary orderSummary) {
            this.f29081a = metaData;
            this.f29082b = aJRHotelsBookingStatusNew;
            this.f29083c = orderSummary;
        }

        public final void onClick(View view) {
            AJRHotelsBookingStatusNew.c(this.f29082b).setShowClose(true);
            AJRHotelsBookingStatusNew.c(this.f29082b).setTitle("Terms & Conditions");
            AJRHotelsBookingStatusNew.c(this.f29082b).setShowRecyclerViewList(true);
            AJRHotelsBookingStatusNew.c(this.f29082b).getRecyclerListData().postValue(this.f29081a.tnc.getConditions());
            AJRHotelsBookingStatusNew.a(this.f29082b, new net.one97.paytm.hotel4.view.ui.a.z(), "DataFragment");
        }
    }

    private final void c() {
        this.f29054e = true;
        HotelBookingStatusViewModel hotelBookingStatusViewModel = this.f29055f;
        if (hotelBookingStatusViewModel == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        if (!hotelBookingStatusViewModel.checkIfHotelFromBooking() && this.r != null) {
            Message obtain = Message.obtain();
            obtain.what = this.q;
            this.r.sendMessageDelayed(obtain, this.f29052c);
            this.f29052c += 5000;
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29059a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f29060b;

        a(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew, Fragment fragment) {
            this.f29059a = aJRHotelsBookingStatusNew;
            this.f29060b = fragment;
        }

        public final void run() {
            net.one97.paytm.hotels2.utils.c.b().a(this.f29060b);
            NestedScrollView nestedScrollView = AJRHotelsBookingStatusNew.a(this.f29059a).w;
            kotlin.g.b.k.a((Object) nestedScrollView, "activityHotelBookingBinding.nestedView");
            nestedScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f29061a;

                {
                    this.f29061a = r1;
                }

                public final void onScrollChanged() {
                    NestedScrollView nestedScrollView = AJRHotelsBookingStatusNew.a(this.f29061a.f29059a).w;
                    NestedScrollView nestedScrollView2 = AJRHotelsBookingStatusNew.a(this.f29061a.f29059a).w;
                    kotlin.g.b.k.a((Object) nestedScrollView2, "activityHotelBookingBinding.nestedView");
                    View childAt = nestedScrollView.getChildAt(nestedScrollView2.getChildCount() - 1);
                    if (childAt != null) {
                        int bottom = childAt.getBottom();
                        NestedScrollView nestedScrollView3 = AJRHotelsBookingStatusNew.a(this.f29061a.f29059a).w;
                        kotlin.g.b.k.a((Object) nestedScrollView3, "activityHotelBookingBinding.nestedView");
                        int height = nestedScrollView3.getHeight();
                        NestedScrollView nestedScrollView4 = AJRHotelsBookingStatusNew.a(this.f29061a.f29059a).w;
                        kotlin.g.b.k.a((Object) nestedScrollView4, "activityHotelBookingBinding.nestedView");
                        if (bottom - (height + nestedScrollView4.getScrollY()) == 0) {
                            net.one97.paytm.hotels2.utils.c.b().a(this.f29061a.f29060b);
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.view.View");
                }
            });
        }
    }

    static final class o implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29075a;

        o(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29075a = aJRHotelsBookingStatusNew;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            Intent intent = new Intent(this.f29075a, AJRHotelOrderSummaryActivity.class);
            intent.putExtra("metaData", AJRHotelsBookingStatusNew.b(this.f29075a).getMetaData().getValue());
            intent.putExtra("orderid", AJRHotelsBookingStatusNew.b(this.f29075a).getOrderId());
            intent.putExtra("requestId", AJRHotelsBookingStatusNew.b(this.f29075a).getRequestId());
            dialogInterface.dismiss();
            this.f29075a.startActivity(intent);
        }
    }

    static final class p implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final p f29076a = new p();

        p() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        net.one97.paytm.hotels2.utils.b bVar;
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if ((!com.paytm.utility.s.a() || com.paytm.utility.s.c((Activity) this)) && i2 == 56 && (bVar = this.k) != null) {
            bVar.a();
        }
    }

    public final void onBackPressed(View view) {
        kotlin.g.b.k.c(view, "view");
        Fragment d2 = d();
        if (d2 == null || !(d2 instanceof net.one97.paytm.hotel4.view.ui.a.z)) {
            finish();
        } else {
            ((net.one97.paytm.hotel4.view.ui.a.z) d2).dismiss();
        }
    }

    public final void onBackPressed() {
        Fragment d2 = d();
        if (d2 != null && (d2 instanceof net.one97.paytm.hotel4.view.ui.a.z)) {
            super.onBackPressed();
        } else if (this.o) {
            this.o = false;
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    private final Fragment d() {
        androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.f() == 0) {
            return null;
        }
        androidx.fragment.app.j supportFragmentManager2 = getSupportFragmentManager();
        androidx.fragment.app.j supportFragmentManager3 = getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager3, "supportFragmentManager");
        j.a b2 = supportFragmentManager2.b(supportFragmentManager3.f() - 1);
        kotlin.g.b.k.a((Object) b2, "supportFragmentManager.g….backStackEntryCount - 1)");
        return getSupportFragmentManager().c(b2.g());
    }

    private final void a(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(67108864);
            getWindow().addFlags(Integer.MIN_VALUE);
            Window window = getWindow();
            kotlin.g.b.k.a((Object) window, "window");
            window.setStatusBarColor(androidx.core.content.b.c(this, i2));
        }
    }

    public final void onNewIntent(Intent intent) {
        com.paytm.utility.q.d("onNewIntent called");
        bo boVar = this.f29053d;
        if (boVar == null) {
            kotlin.g.b.k.a("activityHotelBookingBinding");
        }
        ShimmerFrameLayout shimmerFrameLayout = boVar.D;
        kotlin.g.b.k.a((Object) shimmerFrameLayout, "activityHotelBookingBinding.shimmerFrameLayout");
        shimmerFrameLayout.setVisibility(0);
        bo boVar2 = this.f29053d;
        if (boVar2 == null) {
            kotlin.g.b.k.a("activityHotelBookingBinding");
        }
        boVar2.D.a();
        HotelBookingStatusViewModel hotelBookingStatusViewModel = this.f29055f;
        if (hotelBookingStatusViewModel == null) {
            kotlin.g.b.k.a("hotelBookingStatusViewModel");
        }
        hotelBookingStatusViewModel.getOrderDetails();
        super.onNewIntent(intent);
    }

    static final class d<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29064a;

        d(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29064a = aJRHotelsBookingStatusNew;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.hotels2.utils.c.b();
        }
    }

    static final class e<T> implements z<CancelOrderModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelsBookingStatusNew f29065a;

        e(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
            this.f29065a = aJRHotelsBookingStatusNew;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f29065a.a();
            com.paytm.utility.q.d("cancelRefundResponse observe called Status ");
            AJRHotelsBookingStatusNew.a(this.f29065a).D.b();
            ShimmerFrameLayout shimmerFrameLayout = AJRHotelsBookingStatusNew.a(this.f29065a).D;
            kotlin.g.b.k.a((Object) shimmerFrameLayout, "activityHotelBookingBinding.shimmerFrameLayout");
            shimmerFrameLayout.setVisibility(8);
            StringBuilder sb = new StringBuilder("cancelRefundResponse observe called Status before updateUI called ");
            OrderSummary value = AJRHotelsBookingStatusNew.b(this.f29065a).getOrderSummary().getValue();
            String str = null;
            sb.append(value != null ? value.getStatus() : null);
            com.paytm.utility.q.d(sb.toString());
            AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew = this.f29065a;
            AJRHotelsBookingStatusNew.a(aJRHotelsBookingStatusNew, AJRHotelsBookingStatusNew.b(aJRHotelsBookingStatusNew).getOrderSummary().getValue());
            StringBuilder sb2 = new StringBuilder("cancelRefundResponse observe called Status after updateUI called ");
            OrderSummary value2 = AJRHotelsBookingStatusNew.b(this.f29065a).getOrderSummary().getValue();
            if (value2 != null) {
                str = value2.getStatus();
            }
            sb2.append(str);
            com.paytm.utility.q.d(sb2.toString());
            AJRHotelsBookingStatusNew.b(this.f29065a).sendOpenPulseEvent();
        }
    }

    public static final /* synthetic */ void a(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew, Fragment fragment, String str) {
        androidx.fragment.app.j supportFragmentManager = aJRHotelsBookingStatusNew.getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
        androidx.fragment.app.q a2 = supportFragmentManager.a();
        kotlin.g.b.k.a((Object) a2, "manager.beginTransaction()");
        a2.a(str);
        if (fragment instanceof androidx.fragment.app.b) {
            ((androidx.fragment.app.b) fragment).show(a2, str);
            return;
        }
        a2.b(R.id.fragment_container, fragment, str);
        a2.c();
    }

    public static final /* synthetic */ void e(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew) {
        AlertDialog.Builder builder = new AlertDialog.Builder(aJRHotelsBookingStatusNew);
        builder.setMessage("Do you want to cancel the hotel booking ?");
        builder.setTitle("Cancel Hotel Booking");
        builder.setPositiveButton(aJRHotelsBookingStatusNew.getString(R.string.hotels_hotel_yes), new o(aJRHotelsBookingStatusNew));
        builder.setNegativeButton(aJRHotelsBookingStatusNew.getString(R.string.hotels_hotel_no), p.f29076a);
        builder.setOnCancelListener(q.f29077a);
        builder.show();
    }

    public static final /* synthetic */ void a(AJRHotelsBookingStatusNew aJRHotelsBookingStatusNew, OrderSummary orderSummary) {
        ArrayList<CJROrderedCart> arrayList;
        List<String> full;
        ArrayList<CJROrderedCart> orderedCartList = orderSummary != null ? orderSummary.getOrderedCartList() : null;
        if (orderedCartList == null) {
            kotlin.g.b.k.a();
        }
        if (!orderedCartList.isEmpty()) {
            if (orderSummary != null) {
                arrayList = orderSummary.getOrderedCartList();
            } else {
                arrayList = null;
            }
            if (arrayList == null) {
                kotlin.g.b.k.a();
            }
            CJROrderedCart cJROrderedCart = arrayList.get(0);
            a.C0498a aVar = net.one97.paytm.hotel4.utils.a.f28631a;
            bo boVar = aJRHotelsBookingStatusNew.f29053d;
            if (boVar == null) {
                kotlin.g.b.k.a("activityHotelBookingBinding");
            }
            a.C0498a.a(boVar.B, net.one97.paytm.hotel4.utils.f.b("save_voucher"));
            a.C0498a aVar2 = net.one97.paytm.hotel4.utils.a.f28631a;
            bo boVar2 = aJRHotelsBookingStatusNew.f29053d;
            if (boVar2 == null) {
                kotlin.g.b.k.a("activityHotelBookingBinding");
            }
            a.C0498a.a(boVar2.f29278g, net.one97.paytm.hotel4.utils.f.b("call_hotel"));
            a.C0498a aVar3 = net.one97.paytm.hotel4.utils.a.f28631a;
            bo boVar3 = aJRHotelsBookingStatusNew.f29053d;
            if (boVar3 == null) {
                kotlin.g.b.k.a("activityHotelBookingBinding");
            }
            a.C0498a.a(boVar3.f29280i, net.one97.paytm.hotel4.utils.f.b("cancel_booking"));
            kotlin.g.b.k.a((Object) cJROrderedCart, "it");
            MetaData metaData = orderSummary.getMetaData(cJROrderedCart);
            HotelBookingStatusViewModel hotelBookingStatusViewModel = aJRHotelsBookingStatusNew.f29055f;
            if (hotelBookingStatusViewModel == null) {
                kotlin.g.b.k.a("hotelBookingStatusViewModel");
            }
            hotelBookingStatusViewModel.getMetaData().setValue(metaData);
            bo boVar4 = aJRHotelsBookingStatusNew.f29053d;
            if (boVar4 == null) {
                kotlin.g.b.k.a("activityHotelBookingBinding");
            }
            boVar4.invalidateAll();
            int i2 = 8;
            PaytmImages paytmImages = metaData.paytmImages;
            if (!(paytmImages == null || (full = paytmImages.getFull()) == null || full.size() <= 1)) {
                a.C0498a aVar4 = net.one97.paytm.hotel4.utils.a.f28631a;
                bo boVar5 = aJRHotelsBookingStatusNew.f29053d;
                if (boVar5 == null) {
                    kotlin.g.b.k.a("activityHotelBookingBinding");
                }
                a.C0498a.a(boVar5.z.f29299b, full.get(1));
            }
            String status = orderSummary.getStatus();
            if (status != null) {
                switch (status.hashCode()) {
                    case -1879307469:
                        if (status.equals(CJRAutomaticSubscriptionHistory.PROCESSING)) {
                            com.paytm.utility.q.d("Status BOOKING_PENDING");
                            aJRHotelsBookingStatusNew.a(R.color.color_f5a109);
                            bo boVar6 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar6 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            boVar6.H.setBackgroundColor(aJRHotelsBookingStatusNew.getResources().getColor(R.color.color_f5a109));
                            a.C0498a aVar5 = net.one97.paytm.hotel4.utils.a.f28631a;
                            bo boVar7 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar7 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            a.C0498a.a(boVar7.J, net.one97.paytm.hotel4.utils.f.b("pending_background"));
                            a.C0498a aVar6 = net.one97.paytm.hotel4.utils.a.f28631a;
                            bo boVar8 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar8 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            a.C0498a.a(boVar8.p, net.one97.paytm.hotel4.utils.f.b("booking_pending_hotel"));
                            aJRHotelsBookingStatusNew.a(R.color.color_f5a109);
                            bo boVar9 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar9 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            boVar9.I.setBackgroundColor(aJRHotelsBookingStatusNew.getResources().getColor(R.color.color_f5a109));
                            aJRHotelsBookingStatusNew.c();
                            break;
                        }
                        break;
                    case -1814410959:
                        if (status.equals("Cancelled")) {
                            com.paytm.utility.q.d("Status cancel");
                            a.C0498a aVar7 = net.one97.paytm.hotel4.utils.a.f28631a;
                            bo boVar10 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar10 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            a.C0498a.a(boVar10.J, net.one97.paytm.hotel4.utils.f.b("failed_background"));
                            a.C0498a aVar8 = net.one97.paytm.hotel4.utils.a.f28631a;
                            bo boVar11 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar11 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            a.C0498a.a(boVar11.p, net.one97.paytm.hotel4.utils.f.b("booking_failed_hotel"));
                            aJRHotelsBookingStatusNew.a(R.color.color_hotel_red_warning_text);
                            bo boVar12 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar12 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            boVar12.H.setBackgroundColor(aJRHotelsBookingStatusNew.getResources().getColor(R.color.color_hotel_red_warning_text));
                            bo boVar13 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar13 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            boVar13.I.setBackgroundColor(aJRHotelsBookingStatusNew.getResources().getColor(R.color.color_hotel_red_warning_text));
                            if (aJRHotelsBookingStatusNew.f29054e) {
                                HotelBookingStatusViewModel hotelBookingStatusViewModel2 = aJRHotelsBookingStatusNew.f29055f;
                                if (hotelBookingStatusViewModel2 == null) {
                                    kotlin.g.b.k.a("hotelBookingStatusViewModel");
                                }
                                hotelBookingStatusViewModel2.sendOpenPulseEvent();
                                break;
                            }
                        }
                        break;
                    case -1421588876:
                        if (status.equals("In Process")) {
                            com.paytm.utility.q.d("Status BOOKING_PENDING");
                            aJRHotelsBookingStatusNew.a(R.color.color_f5a109);
                            bo boVar14 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar14 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            boVar14.H.setBackgroundColor(aJRHotelsBookingStatusNew.getResources().getColor(R.color.color_f5a109));
                            a.C0498a aVar9 = net.one97.paytm.hotel4.utils.a.f28631a;
                            bo boVar15 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar15 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            a.C0498a.a(boVar15.J, net.one97.paytm.hotel4.utils.f.b("pending_background"));
                            a.C0498a aVar10 = net.one97.paytm.hotel4.utils.a.f28631a;
                            bo boVar16 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar16 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            a.C0498a.a(boVar16.p, net.one97.paytm.hotel4.utils.f.b("booking_pending_hotel"));
                            aJRHotelsBookingStatusNew.a(R.color.color_f5a109);
                            bo boVar17 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar17 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            boVar17.I.setBackgroundColor(aJRHotelsBookingStatusNew.getResources().getColor(R.color.color_f5a109));
                            aJRHotelsBookingStatusNew.c();
                            break;
                        }
                        break;
                    case 1259833018:
                        if (status.equals("Successful")) {
                            com.paytm.utility.q.d("Status sucess");
                            a.C0498a aVar11 = net.one97.paytm.hotel4.utils.a.f28631a;
                            bo boVar18 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar18 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            a.C0498a.a(boVar18.J, net.one97.paytm.hotel4.utils.f.b("success_background"));
                            a.C0498a aVar12 = net.one97.paytm.hotel4.utils.a.f28631a;
                            bo boVar19 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar19 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            a.C0498a.a(boVar19.p, net.one97.paytm.hotel4.utils.f.b("success_confirm_img_hotel"));
                            aJRHotelsBookingStatusNew.a(R.color.color23b55e);
                            bo boVar20 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar20 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            boVar20.H.setBackgroundColor(aJRHotelsBookingStatusNew.getResources().getColor(R.color.color23b55e));
                            bo boVar21 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar21 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            boVar21.I.setBackgroundColor(aJRHotelsBookingStatusNew.getResources().getColor(R.color.color23b55e));
                            if (aJRHotelsBookingStatusNew.f29054e) {
                                HotelBookingStatusViewModel hotelBookingStatusViewModel3 = aJRHotelsBookingStatusNew.f29055f;
                                if (hotelBookingStatusViewModel3 == null) {
                                    kotlin.g.b.k.a("hotelBookingStatusViewModel");
                                }
                                hotelBookingStatusViewModel3.sendOpenPulseEvent();
                            }
                            i2 = 0;
                            break;
                        }
                        break;
                    case 2096857181:
                        if (status.equals(SDKConstants.GA_NATIVE_FAILED)) {
                            com.paytm.utility.q.d("Status BOOKING_FAILED");
                            a.C0498a aVar13 = net.one97.paytm.hotel4.utils.a.f28631a;
                            bo boVar22 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar22 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            a.C0498a.a(boVar22.J, net.one97.paytm.hotel4.utils.f.b("failed_background"));
                            a.C0498a aVar14 = net.one97.paytm.hotel4.utils.a.f28631a;
                            bo boVar23 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar23 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            a.C0498a.a(boVar23.p, net.one97.paytm.hotel4.utils.f.b("booking_failed_hotel"));
                            aJRHotelsBookingStatusNew.a(R.color.color_hotel_red_warning_text);
                            bo boVar24 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar24 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            boVar24.H.setBackgroundColor(aJRHotelsBookingStatusNew.getResources().getColor(R.color.color_hotel_red_warning_text));
                            bo boVar25 = aJRHotelsBookingStatusNew.f29053d;
                            if (boVar25 == null) {
                                kotlin.g.b.k.a("activityHotelBookingBinding");
                            }
                            boVar25.I.setBackgroundColor(aJRHotelsBookingStatusNew.getResources().getColor(R.color.color_hotel_red_warning_text));
                            if (aJRHotelsBookingStatusNew.f29054e) {
                                HotelBookingStatusViewModel hotelBookingStatusViewModel4 = aJRHotelsBookingStatusNew.f29055f;
                                if (hotelBookingStatusViewModel4 == null) {
                                    kotlin.g.b.k.a("hotelBookingStatusViewModel");
                                }
                                hotelBookingStatusViewModel4.sendOpenPulseEvent();
                                break;
                            }
                        }
                        break;
                }
            }
            bo boVar26 = aJRHotelsBookingStatusNew.f29053d;
            if (boVar26 == null) {
                kotlin.g.b.k.a("activityHotelBookingBinding");
            }
            LinearLayout linearLayout = boVar26.f29276e;
            kotlin.g.b.k.a((Object) linearLayout, "activityHotelBookingBinding.bottomButtons");
            linearLayout.setVisibility(i2);
            if (!aJRHotelsBookingStatusNew.n) {
                Bundle bundle = new Bundle();
                Fragment a2 = net.one97.paytm.hotels2.utils.c.b().a((WeakReference<View>) null);
                net.one97.paytm.hotels2.utils.e.a();
                String a3 = net.one97.paytm.hotels2.utils.e.a("hotelStoreFrontUrlOrderSummary", "");
                bundle.putBoolean("bundle_extra_clp_parallax_animation_required", false);
                bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
                bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
                bundle.putString("origin", "hotel");
                bundle.putString("EXTRA_STORE_FRONT_ALTERNATE_URL", a3);
                bundle.putString("store_front_url_key", "hotel");
                kotlin.g.b.k.a((Object) a2, "mEndlessScrollFragment");
                a2.setArguments(bundle);
                androidx.fragment.app.j supportFragmentManager = aJRHotelsBookingStatusNew.getSupportFragmentManager();
                kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
                androidx.fragment.app.q a4 = supportFragmentManager.a();
                kotlin.g.b.k.a((Object) a4, "fragmentManager.beginTransaction()");
                a4.a(R.id.store_front_container, a2, "endLessScroll").b();
                new Handler().postDelayed(new a(aJRHotelsBookingStatusNew, a2), 1000);
                aJRHotelsBookingStatusNew.n = true;
            }
            bo boVar27 = aJRHotelsBookingStatusNew.f29053d;
            if (boVar27 == null) {
                kotlin.g.b.k.a("activityHotelBookingBinding");
            }
            boVar27.G.f29319d.setOnClickListener(new r(metaData, aJRHotelsBookingStatusNew, orderSummary));
            bo boVar28 = aJRHotelsBookingStatusNew.f29053d;
            if (boVar28 == null) {
                kotlin.g.b.k.a("activityHotelBookingBinding");
            }
            boVar28.G.f29316a.setOnClickListener(new s(metaData, aJRHotelsBookingStatusNew, orderSummary));
            ArrayList<CJROrderedCart> orderedCartList2 = orderSummary.getOrderedCartList();
            if (orderedCartList2 == null) {
                kotlin.g.b.k.a();
            }
            CJROrderedCart cJROrderedCart2 = orderedCartList2.get(0);
            kotlin.g.b.k.a((Object) cJROrderedCart2, "cjrOrderSummary.orderedCartList!![0]");
            if (cJROrderedCart2.getPromoText() != null) {
                HotelBookingStatusViewModel hotelBookingStatusViewModel5 = aJRHotelsBookingStatusNew.f29055f;
                if (hotelBookingStatusViewModel5 == null) {
                    kotlin.g.b.k.a("hotelBookingStatusViewModel");
                }
                y<String> cashBackText = hotelBookingStatusViewModel5.getCashBackText();
                ArrayList<CJROrderedCart> orderedCartList3 = orderSummary.getOrderedCartList();
                if (orderedCartList3 == null) {
                    kotlin.g.b.k.a();
                }
                CJROrderedCart cJROrderedCart3 = orderedCartList3.get(0);
                kotlin.g.b.k.a((Object) cJROrderedCart3, "cjrOrderSummary.orderedCartList!![0]");
                cashBackText.setValue(cJROrderedCart3.getPromoText());
                ArrayList<CJROrderedCart> orderedCartList4 = orderSummary.getOrderedCartList();
                if (orderedCartList4 == null) {
                    kotlin.g.b.k.a();
                }
                CJROrderedCart cJROrderedCart4 = orderedCartList4.get(0);
                kotlin.g.b.k.a((Object) cJROrderedCart4, "cjrOrderSummary.orderedCartList!![0]");
                if (cJROrderedCart4.getTotalCashBack() > 0.0d) {
                    HotelBookingStatusViewModel hotelBookingStatusViewModel6 = aJRHotelsBookingStatusNew.f29055f;
                    if (hotelBookingStatusViewModel6 == null) {
                        kotlin.g.b.k.a("hotelBookingStatusViewModel");
                    }
                    y<String> cashBackPrice = hotelBookingStatusViewModel6.getCashBackPrice();
                    StringBuilder sb = new StringBuilder();
                    sb.append(aJRHotelsBookingStatusNew.getString(R.string.h4_hotels_rupees).toString());
                    int i3 = metaData.priceData.totalPriceWithTax;
                    ArrayList<CJROrderedCart> orderedCartList5 = orderSummary.getOrderedCartList();
                    if (orderedCartList5 == null) {
                        kotlin.g.b.k.a();
                    }
                    CJROrderedCart cJROrderedCart5 = orderedCartList5.get(0);
                    kotlin.g.b.k.a((Object) cJROrderedCart5, "cjrOrderSummary.orderedCartList!![0]");
                    sb.append(i3 - ((int) cJROrderedCart5.getTotalCashBack()));
                    cashBackPrice.setValue(sb.toString());
                }
            }
        }
    }
}

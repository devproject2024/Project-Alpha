package net.one97.paytm.hotel4.view.ui.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.CJRError;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.hotel4.service.model.BillingAddress;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.GSTDetails;
import net.one97.paytm.hotel4.service.model.UserDetails;
import net.one97.paytm.hotel4.service.model.details.CancellationData;
import net.one97.paytm.hotel4.service.model.details.CancellationPolicy;
import net.one97.paytm.hotel4.service.model.details.SubRoomOptions;
import net.one97.paytm.hotel4.service.model.promocode.PromoCodeApply;
import net.one97.paytm.hotel4.service.model.promocode.PromoCodeApplyData;
import net.one97.paytm.hotel4.service.model.promocode.PromocodeDataItem;
import net.one97.paytm.hotel4.service.model.promocode.PromocodeResponse;
import net.one97.paytm.hotel4.viewmodel.DataViewModel;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.ErrorDialogViewModel;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.dq;

public final class u extends b implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public DetailsViewModel f28972a;

    /* renamed from: b  reason: collision with root package name */
    public ReviewViewModel f28973b;

    /* renamed from: c  reason: collision with root package name */
    public RoomSelectionViewModel f28974c;

    /* renamed from: d  reason: collision with root package name */
    public SharedViewModel f28975d;

    /* renamed from: e  reason: collision with root package name */
    public SRPViewModel f28976e;

    /* renamed from: f  reason: collision with root package name */
    public SRPHeaderViewModel f28977f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorDialogViewModel f28978g;

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.hotel4.view.a.n f28979h;

    /* renamed from: i  reason: collision with root package name */
    public net.one97.paytm.hotel4.view.a.l f28980i;
    public net.one97.paytm.hotel4.view.a.m j;
    private dq k;
    private LottieAnimationView l;
    /* access modifiers changed from: private */
    public LottieAnimationView m;
    private DataViewModel n;

    static final class c<T> implements z<CJRRechargePayment> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28983a;

        c(u uVar) {
            this.f28983a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            u.a(this.f28983a, (CJRRechargePayment) obj);
        }
    }

    static final class d<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28984a;

        d(u uVar) {
            this.f28984a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            u uVar = this.f28984a;
            kotlin.g.b.k.a((Object) bool, "status");
            u.c(uVar, bool.booleanValue());
        }
    }

    static final class e<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28985a;

        e(u uVar) {
            this.f28985a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (kotlin.g.b.k.a((Object) (Boolean) obj, (Object) Boolean.FALSE)) {
                u uVar = this.f28985a;
                ErrorDialogViewModel errorDialogViewModel = uVar.f28978g;
                if (errorDialogViewModel == null) {
                    kotlin.g.b.k.a("errorDialogViewModel");
                }
                u.a(uVar, errorDialogViewModel.getTag().getValue());
            }
        }
    }

    static final class f<T> implements z<List<? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28986a;

        f(u uVar) {
            this.f28986a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            net.one97.paytm.hotel4.utils.e eVar = net.one97.paytm.hotel4.utils.e.f28642a;
            FragmentActivity activity = this.f28986a.getActivity();
            FragmentActivity activity2 = this.f28986a.getActivity();
            net.one97.paytm.hotel4.utils.e.a(activity, (List<String>) list, activity2 != null ? activity2.getString(R.string.h4_room_inclusion) : null, this.f28986a.b());
        }
    }

    static final class i<T> implements z<PromocodeResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28989a;

        i(u uVar) {
            this.f28989a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            u.a(this.f28989a, (PromocodeResponse) obj);
        }
    }

    static final class j<T> implements z<PromoCodeApply> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28990a;

        j(u uVar) {
            this.f28990a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            u.a(this.f28990a, (PromoCodeApply) obj);
        }
    }

    static final class k<T> implements z<ErrorData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28991a;

        k(u uVar) {
            this.f28991a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f28991a.a((ErrorData) obj);
        }
    }

    static final class l<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28992a;

        l(u uVar) {
            this.f28992a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            u uVar = this.f28992a;
            kotlin.g.b.k.a((Object) bool, "status");
            bool.booleanValue();
            u.b(uVar);
        }
    }

    static final class m<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28993a;

        m(u uVar) {
            this.f28993a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            u uVar = this.f28993a;
            kotlin.g.b.k.a((Object) bool, "status");
            u.a(uVar, bool.booleanValue());
        }
    }

    static final class o<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28995a;

        o(u uVar) {
            this.f28995a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            u uVar = this.f28995a;
            kotlin.g.b.k.a((Object) bool, "status");
            u.b(uVar, bool.booleanValue());
        }
    }

    static final class p<T> implements z<CancellationPolicy> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28996a;

        p(u uVar) {
            this.f28996a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CancellationPolicy cancellationPolicy = (CancellationPolicy) obj;
            if (cancellationPolicy != null) {
                u.d(this.f28996a).setTitle("Hotel Cancellation Policy");
                u.d(this.f28996a).setShowClose(true);
                y<List<String>> recyclerListData = u.d(this.f28996a).getRecyclerListData();
                CancellationData data = cancellationPolicy.getData();
                if (data == null) {
                    kotlin.g.b.k.a();
                }
                recyclerListData.setValue(data.getCancellationPolicyList());
                u.d(this.f28996a).setShowRecyclerViewList(true);
                this.f28996a.a().showData();
            }
        }
    }

    public static final /* synthetic */ dq a(u uVar) {
        dq dqVar = uVar.k;
        if (dqVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        return dqVar;
    }

    public static final /* synthetic */ DataViewModel d(u uVar) {
        DataViewModel dataViewModel = uVar.n;
        if (dataViewModel == null) {
            kotlin.g.b.k.a("dataViewModel");
        }
        return dataViewModel;
    }

    public final ReviewViewModel a() {
        ReviewViewModel reviewViewModel = this.f28973b;
        if (reviewViewModel == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        return reviewViewModel;
    }

    public final SharedViewModel b() {
        SharedViewModel sharedViewModel = this.f28975d;
        if (sharedViewModel == null) {
            kotlin.g.b.k.a("sharedViewModel");
        }
        return sharedViewModel;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        dq a2 = dq.a(layoutInflater, viewGroup);
        kotlin.g.b.k.a((Object) a2, "H4ReviewScreenBinding.in…flater, container, false)");
        this.k = a2;
        ReviewViewModel reviewViewModel = this.f28973b;
        if (reviewViewModel == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        if (reviewViewModel.getApplyPromoData() != null) {
            dq dqVar = this.k;
            if (dqVar == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            dqVar.f29513d.post(new a(this));
        }
        dq dqVar2 = this.k;
        if (dqVar2 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        return dqVar2.f29512c;
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28981a;

        a(u uVar) {
            this.f28981a = uVar;
        }

        public final void run() {
            NestedScrollView nestedScrollView = u.a(this.f28981a).f29513d;
            View view = this.f28981a.getView();
            if (view == null) {
                kotlin.g.b.k.a();
            }
            View findViewById = view.findViewById(R.id.view_rb_promocode);
            kotlin.g.b.k.a((Object) findViewById, "view!!.findViewById<View>(R.id.view_rb_promocode)");
            nestedScrollView.c(findViewById.getTop());
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        String str = null;
        if (i2 == 800) {
            ReviewViewModel reviewViewModel = this.f28973b;
            if (reviewViewModel == null) {
                kotlin.g.b.k.a("reviewViewModel");
            }
            net.one97.paytm.hotel4.service.a.e reviewRepository = reviewViewModel.getReviewRepository();
            if (!TextUtils.isEmpty(reviewRepository != null ? reviewRepository.d() : null)) {
                ReviewViewModel reviewViewModel2 = this.f28973b;
                if (reviewViewModel2 == null) {
                    kotlin.g.b.k.a("reviewViewModel");
                }
                reviewViewModel2.setUserDetails();
                ReviewViewModel reviewViewModel3 = this.f28973b;
                if (reviewViewModel3 == null) {
                    kotlin.g.b.k.a("reviewViewModel");
                }
                PromocodeDataItem applyPromoData = reviewViewModel3.getApplyPromoData();
                if (applyPromoData != null) {
                    ReviewViewModel reviewViewModel4 = this.f28973b;
                    if (reviewViewModel4 == null) {
                        kotlin.g.b.k.a("reviewViewModel");
                    }
                    ReviewViewModel.onPromoCodeClick$default(reviewViewModel4, applyPromoData, false, 2, (Object) null);
                }
            }
        } else if (i2 == 801) {
            ReviewViewModel reviewViewModel5 = this.f28973b;
            if (reviewViewModel5 == null) {
                kotlin.g.b.k.a("reviewViewModel");
            }
            net.one97.paytm.hotel4.service.a.e reviewRepository2 = reviewViewModel5.getReviewRepository();
            if (reviewRepository2 != null) {
                str = reviewRepository2.d();
            }
            if (!TextUtils.isEmpty(str)) {
                ReviewViewModel reviewViewModel6 = this.f28973b;
                if (reviewViewModel6 == null) {
                    kotlin.g.b.k.a("reviewViewModel");
                }
                reviewViewModel6.getProcessToPayTapped().setValue(Boolean.FALSE);
                ReviewViewModel reviewViewModel7 = this.f28973b;
                if (reviewViewModel7 == null) {
                    kotlin.g.b.k.a("reviewViewModel");
                }
                reviewViewModel7.onProcessToPayPressed();
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(SharedViewModel.class);
            kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f28975d = (SharedViewModel) a2;
            SharedViewModel sharedViewModel = this.f28975d;
            if (sharedViewModel == null) {
                kotlin.g.b.k.a("sharedViewModel");
            }
            ViewModelFactory viewModelFactory = new ViewModelFactory(sharedViewModel);
            ai a3 = am.a(activity).a(DataViewModel.class);
            kotlin.g.b.k.a((Object) a3, "ViewModelProviders.of(it…ataViewModel::class.java]");
            this.n = (DataViewModel) a3;
            ai a4 = am.a(activity).a(ErrorDialogViewModel.class);
            kotlin.g.b.k.a((Object) a4, "ViewModelProviders.of(it…logViewModel::class.java]");
            this.f28978g = (ErrorDialogViewModel) a4;
            al.b bVar = viewModelFactory;
            ai a5 = am.a(activity, bVar).a(SRPViewModel.class);
            kotlin.g.b.k.a((Object) a5, "ViewModelProviders.of(it…SRPViewModel::class.java)");
            this.f28976e = (SRPViewModel) a5;
            ai a6 = am.a(activity, bVar).a(SRPHeaderViewModel.class);
            kotlin.g.b.k.a((Object) a6, "ViewModelProviders.of(it…derViewModel::class.java)");
            this.f28977f = (SRPHeaderViewModel) a6;
            ai a7 = am.a(activity, bVar).a(RoomSelectionViewModel.class);
            kotlin.g.b.k.a((Object) a7, "ViewModelProviders.of(it…ionViewModel::class.java)");
            this.f28974c = (RoomSelectionViewModel) a7;
            ai a8 = am.a(activity, bVar).a(DetailsViewModel.class);
            kotlin.g.b.k.a((Object) a8, "ViewModelProviders.of(it…ilsViewModel::class.java)");
            this.f28972a = (DetailsViewModel) a8;
            ai a9 = am.a(activity, bVar).a(ReviewViewModel.class);
            kotlin.g.b.k.a((Object) a9, "ViewModelProviders.of(it…iewViewModel::class.java)");
            this.f28973b = (ReviewViewModel) a9;
            ReviewViewModel reviewViewModel = this.f28973b;
            if (reviewViewModel == null) {
                kotlin.g.b.k.a("reviewViewModel");
            }
            this.f28979h = new net.one97.paytm.hotel4.view.a.n(reviewViewModel);
            ReviewViewModel reviewViewModel2 = this.f28973b;
            if (reviewViewModel2 == null) {
                kotlin.g.b.k.a("reviewViewModel");
            }
            FragmentActivity activity2 = getActivity();
            Application application = null;
            Application application2 = activity2 != null ? activity2.getApplication() : null;
            if (application2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "it");
            reviewViewModel2.initRepository(new net.one97.paytm.hotel4.service.a.e(application2, activity));
            ReviewViewModel reviewViewModel3 = this.f28973b;
            if (reviewViewModel3 == null) {
                kotlin.g.b.k.a("reviewViewModel");
            }
            reviewViewModel3.onClearPromoCodePressed();
            ReviewViewModel reviewViewModel4 = this.f28973b;
            if (reviewViewModel4 == null) {
                kotlin.g.b.k.a("reviewViewModel");
            }
            reviewViewModel4.get_hotelGSTUserEnabled().postValue(Boolean.FALSE);
            ReviewViewModel reviewViewModel5 = this.f28973b;
            if (reviewViewModel5 == null) {
                kotlin.g.b.k.a("reviewViewModel");
            }
            reviewViewModel5.setPromoCodeData((PromocodeResponse) null);
            if (getActivity() != null) {
                RoomSelectionViewModel roomSelectionViewModel = this.f28974c;
                if (roomSelectionViewModel == null) {
                    kotlin.g.b.k.a("roomSelectViewModel");
                }
                if (roomSelectionViewModel.get_selectedRoomData().getValue() != null) {
                    ReviewViewModel reviewViewModel6 = this.f28973b;
                    if (reviewViewModel6 == null) {
                        kotlin.g.b.k.a("reviewViewModel");
                    }
                    FragmentActivity activity3 = getActivity();
                    if (activity3 != null) {
                        application = activity3.getApplication();
                    }
                    reviewViewModel6.initDetailsRepository(new net.one97.paytm.hotel4.service.a.d(application));
                    ReviewViewModel reviewViewModel7 = this.f28973b;
                    if (reviewViewModel7 == null) {
                        kotlin.g.b.k.a("reviewViewModel");
                    }
                    RoomSelectionViewModel roomSelectionViewModel2 = this.f28974c;
                    if (roomSelectionViewModel2 == null) {
                        kotlin.g.b.k.a("roomSelectViewModel");
                    }
                    SubRoomOptions value = roomSelectionViewModel2.get_selectedRoomData().getValue();
                    if (value == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) value, "roomSelectViewModel._selectedRoomData.value!!");
                    reviewViewModel7.fetchPromoData(value);
                }
            }
        }
        ReviewViewModel reviewViewModel8 = this.f28973b;
        if (reviewViewModel8 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        q qVar = this;
        reviewViewModel8.getApiProcessToPaySuccess().observe(qVar, new c(this));
        ReviewViewModel reviewViewModel9 = this.f28973b;
        if (reviewViewModel9 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel9.getApiCallSuccess().observe(qVar, new i(this));
        ReviewViewModel reviewViewModel10 = this.f28973b;
        if (reviewViewModel10 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel10.getApiCallSuccessApplyPromoCode().observe(qVar, new j(this));
        ReviewViewModel reviewViewModel11 = this.f28973b;
        if (reviewViewModel11 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel11.getApiCallFailure().observe(qVar, new k(this));
        ReviewViewModel reviewViewModel12 = this.f28973b;
        if (reviewViewModel12 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel12.get_validateUserDetails().observe(qVar, new l(this));
        ReviewViewModel reviewViewModel13 = this.f28973b;
        if (reviewViewModel13 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel13.getSuccessWalletTokenListener().observe(qVar, new m(this));
        ReviewViewModel reviewViewModel14 = this.f28973b;
        if (reviewViewModel14 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel14.get_userDetails().observe(qVar, new n(this));
        ReviewViewModel reviewViewModel15 = this.f28973b;
        if (reviewViewModel15 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel15.getSuccessWalletTokenForPromoApplyListener().observe(qVar, new o(this));
        ReviewViewModel reviewViewModel16 = this.f28973b;
        if (reviewViewModel16 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel16.getSuccessCancellationListener().observe(qVar, new p(this));
        ReviewViewModel reviewViewModel17 = this.f28973b;
        if (reviewViewModel17 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel17.getProcodeLoader().observe(qVar, new d(this));
        ReviewViewModel reviewViewModel18 = this.f28973b;
        if (reviewViewModel18 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel18.isErrorPopUpVisible().observe(qVar, new e(this));
        RoomSelectionViewModel roomSelectionViewModel3 = this.f28974c;
        if (roomSelectionViewModel3 == null) {
            kotlin.g.b.k.a("roomSelectViewModel");
        }
        roomSelectionViewModel3.getAllInclusionsDialogListener().observe(qVar, new f(this));
        ReviewViewModel reviewViewModel19 = this.f28973b;
        if (reviewViewModel19 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel19.getGstTncDialogListener().observe(qVar, new g(this));
        ReviewViewModel reviewViewModel20 = this.f28973b;
        if (reviewViewModel20 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel20.getOfferTncDialogListener().observe(qVar, new h(this));
        ReviewViewModel reviewViewModel21 = this.f28973b;
        if (reviewViewModel21 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel21.setAppContext(getActivity());
        RoomSelectionViewModel roomSelectionViewModel4 = this.f28974c;
        if (roomSelectionViewModel4 == null) {
            kotlin.g.b.k.a("roomSelectViewModel");
        }
        if (roomSelectionViewModel4.get_selectedRoomFinalPriceWithTax().getValue() != null) {
            RoomSelectionViewModel roomSelectionViewModel5 = this.f28974c;
            if (roomSelectionViewModel5 == null) {
                kotlin.g.b.k.a("roomSelectViewModel");
            }
            if (roomSelectionViewModel5.get_title().getValue() != null) {
                ReviewViewModel reviewViewModel22 = this.f28973b;
                if (reviewViewModel22 == null) {
                    kotlin.g.b.k.a("reviewViewModel");
                }
                RoomSelectionViewModel roomSelectionViewModel6 = this.f28974c;
                if (roomSelectionViewModel6 == null) {
                    kotlin.g.b.k.a("roomSelectViewModel");
                }
                String value2 = roomSelectionViewModel6.get_title().getValue();
                if (value2 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) value2, "roomSelectViewModel._title.value!!");
                String str = value2;
                RoomSelectionViewModel roomSelectionViewModel7 = this.f28974c;
                if (roomSelectionViewModel7 == null) {
                    kotlin.g.b.k.a("roomSelectViewModel");
                }
                reviewViewModel22.sendPageOpenPulseEvent(str, roomSelectionViewModel7.get_selectedRoomFinalPriceWithTax().getValue());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:94:0x016a, code lost:
        if (r11.booleanValue() == false) goto L_0x016c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r11, android.os.Bundle r12) {
        /*
            r10 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r11, r0)
            super.onViewCreated(r11, r12)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            java.lang.String r12 = "dataBinding"
            if (r11 != 0) goto L_0x0012
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0012:
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r10.f28973b
            java.lang.String r1 = "reviewViewModel"
            if (r0 != 0) goto L_0x001b
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x001b:
            r11.a((net.one97.paytm.hotel4.viewmodel.ReviewViewModel) r0)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0025
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0025:
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r0 = r10.f28974c
            java.lang.String r2 = "roomSelectViewModel"
            if (r0 != 0) goto L_0x002e
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x002e:
            r11.a((net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel) r0)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0038
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0038:
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r0 = r10.f28972a
            java.lang.String r3 = "detailsViewModel"
            if (r0 != 0) goto L_0x0041
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0041:
            r11.a((net.one97.paytm.hotel4.viewmodel.DetailsViewModel) r0)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x004b
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x004b:
            r0 = r10
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            r11.setLifecycleOwner(r0)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x0058
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0058:
            androidx.lifecycle.y r11 = r11.get_validateUserDetails()
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r11.postValue(r0)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x0068
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0068:
            androidx.lifecycle.y r11 = r11.getSelectedData()
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r0 = r10.f28972a
            if (r0 != 0) goto L_0x0073
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0073:
            androidx.lifecycle.y r0 = r0.getSelectedData()
            java.lang.Object r0 = r0.getValue()
            r11.postValue(r0)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x0085
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0085:
            androidx.lifecycle.y r11 = r11.getProcessToPayRequestID()
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r0 = r10.f28972a
            if (r0 != 0) goto L_0x0090
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0090:
            net.one97.paytm.hotel4.service.model.details.HotelDetails r0 = r0.getDetailsResponse()
            r4 = 0
            if (r0 == 0) goto L_0x009c
            net.one97.paytm.hotel4.service.model.details.Extra r0 = r0.getExtra()
            goto L_0x009d
        L_0x009c:
            r0 = r4
        L_0x009d:
            if (r0 != 0) goto L_0x00a2
            kotlin.g.b.k.a()
        L_0x00a2:
            java.lang.String r0 = r0.getRequestId()
            r11.postValue(r0)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x00b0
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00b0:
            androidx.lifecycle.y r11 = r11.get_hotelName()
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r0 = r10.f28974c
            if (r0 != 0) goto L_0x00bb
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00bb:
            androidx.lifecycle.y r0 = r0.get_title()
            java.lang.Object r0 = r0.getValue()
            r11.postValue(r0)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x00cd
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00cd:
            androidx.lifecycle.y r11 = r11.get_hotelFullAddress()
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r0 = r10.f28972a
            if (r0 != 0) goto L_0x00d8
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00d8:
            androidx.lifecycle.y r0 = r0.get_fullAddress()
            java.lang.Object r0 = r0.getValue()
            r11.postValue(r0)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x00ea
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00ea:
            androidx.lifecycle.y r11 = r11.get_hotelGSTEnabled()
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r0 = r10.f28972a
            if (r0 != 0) goto L_0x00f5
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00f5:
            net.one97.paytm.hotel4.service.model.details.HotelDetails r0 = r0.getDetailsResponse()
            if (r0 != 0) goto L_0x00fe
            kotlin.g.b.k.a()
        L_0x00fe:
            net.one97.paytm.hotel4.service.model.details.Data r0 = r0.getData()
            if (r0 != 0) goto L_0x0107
            kotlin.g.b.k.a()
        L_0x0107:
            boolean r0 = r0.getShowAddGstin()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r11.postValue(r0)
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r11 = r10.f28972a
            if (r11 != 0) goto L_0x0119
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0119:
            net.one97.paytm.hotel4.service.model.details.HotelDetails r11 = r11.getDetailsResponse()
            if (r11 != 0) goto L_0x0122
            kotlin.g.b.k.a()
        L_0x0122:
            net.one97.paytm.hotel4.service.model.details.Data r11 = r11.getData()
            if (r11 != 0) goto L_0x012b
            kotlin.g.b.k.a()
        L_0x012b:
            boolean r11 = r11.getShowAddGstin()
            r0 = 0
            if (r11 == 0) goto L_0x016c
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x0139
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0139:
            androidx.lifecycle.y r11 = r11.get_hotelGSTUserEnabled()
            if (r11 == 0) goto L_0x016c
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x0146
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0146:
            androidx.lifecycle.y r11 = r11.get_hotelGSTUserEnabled()
            java.lang.Object r11 = r11.getValue()
            if (r11 == 0) goto L_0x016c
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x0157
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0157:
            androidx.lifecycle.y r11 = r11.get_hotelGSTUserEnabled()
            java.lang.Object r11 = r11.getValue()
            if (r11 != 0) goto L_0x0164
            kotlin.g.b.k.a()
        L_0x0164:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x0176
        L_0x016c:
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x0173
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0173:
            r11.isUserGSTEnabled(r0)
        L_0x0176:
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r11 = r10.f28972a
            if (r11 != 0) goto L_0x017d
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x017d:
            androidx.lifecycle.y r11 = r11.get_image0_url()
            net.one97.paytm.hotel4.utils.a$a r5 = net.one97.paytm.hotel4.utils.a.f28631a
            net.one97.paytm.hotels2.b.dq r5 = r10.k
            if (r5 != 0) goto L_0x018a
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x018a:
            net.one97.paytm.hotels2.b.dc r5 = r5.j
            android.widget.ImageView r5 = r5.f29447a
            java.lang.Object r11 = r11.getValue()
            java.lang.String r11 = (java.lang.String) r11
            r6 = 240(0xf0, float:3.36E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            net.one97.paytm.hotel4.utils.a.C0498a.a((android.widget.ImageView) r5, (java.lang.String) r11, (java.lang.Integer) r7)
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r11 = r10.f28974c
            if (r11 != 0) goto L_0x01a4
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01a4:
            androidx.lifecycle.y r11 = r11.get_selectedRoomTypeData()
            java.lang.Object r11 = r11.getValue()
            if (r11 != 0) goto L_0x01b1
            kotlin.g.b.k.a()
        L_0x01b1:
            net.one97.paytm.hotel4.service.model.details.RoomOption r11 = (net.one97.paytm.hotel4.service.model.details.RoomOption) r11
            net.one97.paytm.hotel4.service.model.details.Images r11 = r11.getImages()
            if (r11 != 0) goto L_0x01bc
            kotlin.g.b.k.a()
        L_0x01bc:
            java.util.List r11 = r11.getFull()
            r5 = 1
            if (r11 == 0) goto L_0x0235
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r11 = r10.f28974c
            if (r11 != 0) goto L_0x01ca
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01ca:
            androidx.lifecycle.y r11 = r11.get_selectedRoomTypeData()
            java.lang.Object r11 = r11.getValue()
            if (r11 != 0) goto L_0x01d7
            kotlin.g.b.k.a()
        L_0x01d7:
            net.one97.paytm.hotel4.service.model.details.RoomOption r11 = (net.one97.paytm.hotel4.service.model.details.RoomOption) r11
            net.one97.paytm.hotel4.service.model.details.Images r11 = r11.getImages()
            if (r11 != 0) goto L_0x01e2
            kotlin.g.b.k.a()
        L_0x01e2:
            java.util.List r11 = r11.getFull()
            if (r11 != 0) goto L_0x01eb
            kotlin.g.b.k.a()
        L_0x01eb:
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            r11 = r11 ^ r5
            if (r11 == 0) goto L_0x0235
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r11 = r10.f28974c
            if (r11 != 0) goto L_0x01fb
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01fb:
            androidx.lifecycle.y r11 = r11.get_selectedRoomTypeData()
            java.lang.Object r11 = r11.getValue()
            if (r11 != 0) goto L_0x0208
            kotlin.g.b.k.a()
        L_0x0208:
            net.one97.paytm.hotel4.service.model.details.RoomOption r11 = (net.one97.paytm.hotel4.service.model.details.RoomOption) r11
            net.one97.paytm.hotel4.service.model.details.Images r11 = r11.getImages()
            if (r11 != 0) goto L_0x0213
            kotlin.g.b.k.a()
        L_0x0213:
            java.util.List r11 = r11.getFull()
            if (r11 == 0) goto L_0x0220
            java.lang.Object r11 = r11.get(r0)
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x0221
        L_0x0220:
            r11 = r4
        L_0x0221:
            net.one97.paytm.hotel4.utils.a$a r7 = net.one97.paytm.hotel4.utils.a.f28631a
            net.one97.paytm.hotels2.b.dq r7 = r10.k
            if (r7 != 0) goto L_0x022a
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x022a:
            net.one97.paytm.hotels2.b.do r7 = r7.l
            android.widget.ImageView r7 = r7.f29502b
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            net.one97.paytm.hotel4.utils.a.C0498a.a((android.widget.ImageView) r7, (java.lang.String) r11, (java.lang.Integer) r6)
        L_0x0235:
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r11 = r10.f28974c
            if (r11 != 0) goto L_0x023c
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x023c:
            androidx.lifecycle.y r11 = r11.get_selectedRoomData()
            java.lang.Object r11 = r11.getValue()
            net.one97.paytm.hotel4.service.model.details.SubRoomOptions r11 = (net.one97.paytm.hotel4.service.model.details.SubRoomOptions) r11
            if (r11 == 0) goto L_0x024d
            java.util.List r11 = r11.getSubRoomProviders()
            goto L_0x024e
        L_0x024d:
            r11 = r4
        L_0x024e:
            if (r11 != 0) goto L_0x0253
            kotlin.g.b.k.a()
        L_0x0253:
            java.lang.Object r11 = r11.get(r0)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r11 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r11
            java.util.List r11 = r11.getIncludes()
            if (r11 != 0) goto L_0x0262
            kotlin.g.b.k.a()
        L_0x0262:
            r6 = r11
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r5
            java.lang.String r7 = "dataBinding.viewRbRoomDetail.tvRoomOptnOne"
            r8 = 8
            if (r6 == 0) goto L_0x0288
            net.one97.paytm.hotels2.b.dq r6 = r10.k
            if (r6 != 0) goto L_0x0277
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0277:
            net.one97.paytm.hotels2.b.do r6 = r6.l
            android.widget.TextView r6 = r6.n
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.Object r7 = r11.get(r0)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            goto L_0x0299
        L_0x0288:
            net.one97.paytm.hotels2.b.dq r6 = r10.k
            if (r6 != 0) goto L_0x028f
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x028f:
            net.one97.paytm.hotels2.b.do r6 = r6.l
            android.widget.TextView r6 = r6.n
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            r6.setVisibility(r8)
        L_0x0299:
            int r6 = r11.size()
            java.lang.String r7 = "dataBinding.viewRbRoomDetail.tvRoomOptnTwo"
            if (r6 <= r5) goto L_0x02b9
            net.one97.paytm.hotels2.b.dq r6 = r10.k
            if (r6 != 0) goto L_0x02a8
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x02a8:
            net.one97.paytm.hotels2.b.do r6 = r6.l
            android.widget.TextView r6 = r6.p
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.Object r5 = r11.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6.setText(r5)
            goto L_0x02ca
        L_0x02b9:
            net.one97.paytm.hotels2.b.dq r5 = r10.k
            if (r5 != 0) goto L_0x02c0
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x02c0:
            net.one97.paytm.hotels2.b.do r5 = r5.l
            android.widget.TextView r5 = r5.p
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            r5.setVisibility(r8)
        L_0x02ca:
            int r5 = r11.size()
            r6 = 2
            if (r5 <= r6) goto L_0x02ec
            net.one97.paytm.hotels2.b.dq r5 = r10.k
            if (r5 != 0) goto L_0x02d8
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x02d8:
            net.one97.paytm.hotels2.b.do r5 = r5.l
            android.widget.TextView r5 = r5.o
            java.lang.String r6 = "dataBinding.viewRbRoomDetail.tvRoomOptnThree"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r6 = 2
            java.lang.Object r6 = r11.get(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
            goto L_0x02ff
        L_0x02ec:
            net.one97.paytm.hotels2.b.dq r5 = r10.k
            if (r5 != 0) goto L_0x02f3
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x02f3:
            net.one97.paytm.hotels2.b.do r5 = r5.l
            android.widget.TextView r5 = r5.o
            java.lang.String r6 = "dataBinding.viewRbRoomDetail.tvRoomOptnThree"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r5.setVisibility(r8)
        L_0x02ff:
            int r5 = r11.size()
            r6 = 3
            java.lang.String r7 = "dataBinding.viewRbRoomDetail.tvPlusRoomInclusion"
            if (r5 <= r6) goto L_0x0346
            net.one97.paytm.hotels2.b.dq r5 = r10.k
            if (r5 != 0) goto L_0x030f
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x030f:
            net.one97.paytm.hotels2.b.do r5 = r5.l
            android.widget.TextView r5 = r5.f29509i
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r9 = "+ "
            r6.<init>(r9)
            int r11 = r11.size()
            int r11 = r11 + -3
            r6.append(r11)
            java.lang.String r11 = " more inclusions"
            r6.append(r11)
            java.lang.String r11 = r6.toString()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r5.setText(r11)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x033b
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x033b:
            net.one97.paytm.hotels2.b.do r11 = r11.l
            android.widget.TextView r11 = r11.f29509i
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r7)
            r11.setVisibility(r0)
            goto L_0x0357
        L_0x0346:
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x034d
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x034d:
            net.one97.paytm.hotels2.b.do r11 = r11.l
            android.widget.TextView r11 = r11.f29509i
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r7)
            r11.setVisibility(r8)
        L_0x0357:
            org.json.JSONObject r11 = new org.json.JSONObject
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r5 = r10.f28974c
            if (r5 != 0) goto L_0x0360
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0360:
            androidx.lifecycle.y r5 = r5.get_selectedRoomData()
            java.lang.Object r5 = r5.getValue()
            net.one97.paytm.hotel4.service.model.details.SubRoomOptions r5 = (net.one97.paytm.hotel4.service.model.details.SubRoomOptions) r5
            if (r5 == 0) goto L_0x0371
            java.util.List r5 = r5.getSubRoomProviders()
            goto L_0x0372
        L_0x0371:
            r5 = r4
        L_0x0372:
            if (r5 != 0) goto L_0x0377
            kotlin.g.b.k.a()
        L_0x0377:
            java.lang.Object r5 = r5.get(r0)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r5 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r5
            com.google.gsonhtcfix.o r5 = r5.getBookParams()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r11.<init>(r5)
            net.one97.paytm.hotels2.b.dq r5 = r10.k
            if (r5 != 0) goto L_0x038f
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x038f:
            net.one97.paytm.hotels2.b.do r5 = r5.l
            android.widget.TextView r5 = r5.l
            java.lang.String r6 = "dataBinding.viewRbRoomDetail.tvRoomMealsPlan"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.String r6 = "mealPlan"
            java.lang.String r6 = r11.optString(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
            java.lang.String r5 = "freeCancellable"
            boolean r5 = r11.optBoolean(r5)
            java.lang.String r6 = "dataBinding.viewRbRoomDetail.tvOptionsNoRefund"
            java.lang.String r7 = "dataBinding.viewRbRoomDetail.tvOptionsRefund"
            if (r5 == 0) goto L_0x03fc
            net.one97.paytm.hotels2.b.dq r5 = r10.k
            if (r5 != 0) goto L_0x03b6
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x03b6:
            net.one97.paytm.hotels2.b.do r5 = r5.l
            android.widget.TextView r5 = r5.f29508h
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            r5.setVisibility(r0)
            net.one97.paytm.hotels2.b.dq r5 = r10.k
            if (r5 != 0) goto L_0x03c7
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x03c7:
            net.one97.paytm.hotels2.b.do r5 = r5.l
            android.widget.TextView r5 = r5.f29507g
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r6 = 4
            r5.setVisibility(r6)
            net.one97.paytm.hotels2.b.dq r5 = r10.k
            if (r5 != 0) goto L_0x03d9
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x03d9:
            net.one97.paytm.hotels2.b.do r5 = r5.l
            android.widget.TextView r5 = r5.f29508h
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Free Cancellation till "
            r6.<init>(r7)
            java.lang.String r7 = "freeCancellableTill"
            java.lang.String r9 = ""
            java.lang.String r11 = r11.optString(r7, r9)
            r6.append(r11)
            java.lang.String r11 = r6.toString()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r5.setText(r11)
            goto L_0x0434
        L_0x03fc:
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0403
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0403:
            net.one97.paytm.hotels2.b.do r11 = r11.l
            android.widget.TextView r11 = r11.f29508h
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r7)
            r5 = 4
            r11.setVisibility(r5)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0415
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0415:
            net.one97.paytm.hotels2.b.do r11 = r11.l
            android.widget.TextView r11 = r11.f29507g
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r6)
            r11.setVisibility(r0)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0426
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0426:
            net.one97.paytm.hotels2.b.do r11 = r11.l
            android.widget.TextView r11 = r11.f29507g
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r6)
            java.lang.String r5 = "Non-Refundable"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r11.setText(r5)
        L_0x0434:
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x043b
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x043b:
            net.one97.paytm.hotels2.b.dk r11 = r11.k
            androidx.recyclerview.widget.RecyclerView r11 = r11.f29485c
            java.lang.String r5 = "dataBinding.viewRbPromocode.recycleviewPromocode"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            net.one97.paytm.hotel4.view.a.n r5 = r10.f28979h
            if (r5 != 0) goto L_0x044d
            java.lang.String r6 = "promoCodeAdapter"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x044d:
            androidx.recyclerview.widget.RecyclerView$a r5 = (androidx.recyclerview.widget.RecyclerView.a) r5
            r11.setAdapter(r5)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0459
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0459:
            net.one97.paytm.hotels2.b.dk r11 = r11.k
            androidx.recyclerview.widget.RecyclerView r11 = r11.f29485c
            android.view.View r11 = (android.view.View) r11
            androidx.core.h.u.c((android.view.View) r11, (boolean) r0)
            net.one97.paytm.hotel4.view.a.l r11 = new net.one97.paytm.hotel4.view.a.l
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r5 = r10.f28974c
            if (r5 != 0) goto L_0x046b
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x046b:
            androidx.lifecycle.y r5 = r5.get_selectedRoomData()
            java.lang.Object r5 = r5.getValue()
            net.one97.paytm.hotel4.service.model.details.SubRoomOptions r5 = (net.one97.paytm.hotel4.service.model.details.SubRoomOptions) r5
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r6 = r10.f28975d
            if (r6 != 0) goto L_0x047f
            java.lang.String r7 = "sharedViewModel"
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x047f:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r6 = r6.getSearchInput()
            if (r6 != 0) goto L_0x0488
            kotlin.g.b.k.a()
        L_0x0488:
            int r6 = r6.getNumOfNights()
            r11.<init>(r5, r6)
            r10.f28980i = r11
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0498
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0498:
            net.one97.paytm.hotels2.b.de r11 = r11.f29514e
            androidx.recyclerview.widget.RecyclerView r11 = r11.f29456a
            java.lang.String r5 = "dataBinding.viewFareBreakup.rvRoomConfig"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            net.one97.paytm.hotel4.view.a.l r5 = r10.f28980i
            if (r5 != 0) goto L_0x04aa
            java.lang.String r6 = "roomConfigAdapter"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x04aa:
            androidx.recyclerview.widget.RecyclerView$a r5 = (androidx.recyclerview.widget.RecyclerView.a) r5
            r11.setAdapter(r5)
            net.one97.paytm.hotel4.view.a.l r11 = r10.f28980i
            if (r11 != 0) goto L_0x04b8
            java.lang.String r5 = "roomConfigAdapter"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x04b8:
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r5 = r10.f28975d
            if (r5 != 0) goto L_0x04c2
            java.lang.String r6 = "sharedViewModel"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x04c2:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r5 = r5.getSearchInput()
            if (r5 != 0) goto L_0x04cb
            kotlin.g.b.k.a()
        L_0x04cb:
            java.util.ArrayList r5 = r5.getRooms()
            java.util.List r5 = (java.util.List) r5
            r11.a(r5)
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r11 = r10.f28974c
            if (r11 != 0) goto L_0x04db
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x04db:
            androidx.lifecycle.y r11 = r11.get_selectedRoomData()
            java.lang.Object r11 = r11.getValue()
            if (r11 != 0) goto L_0x04e8
            kotlin.g.b.k.a()
        L_0x04e8:
            net.one97.paytm.hotel4.service.model.details.SubRoomOptions r11 = (net.one97.paytm.hotel4.service.model.details.SubRoomOptions) r11
            java.util.List r11 = r11.getSubRoomProviders()
            if (r11 != 0) goto L_0x04f3
            kotlin.g.b.k.a()
        L_0x04f3:
            java.lang.Object r11 = r11.get(r0)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r11 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r11
            net.one97.paytm.hotel4.service.model.details.PriceData r11 = r11.getPriceData()
            if (r11 != 0) goto L_0x0502
            kotlin.g.b.k.a()
        L_0x0502:
            java.util.ArrayList r11 = r11.getMTaxesList()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            if (r11 == 0) goto L_0x0544
            int r5 = r11.size()
            if (r5 <= 0) goto L_0x0544
            java.util.Iterator r11 = r11.iterator()
        L_0x0519:
            boolean r5 = r11.hasNext()
            if (r5 == 0) goto L_0x0544
            java.lang.Object r5 = r11.next()
            com.google.gsonhtcfix.o r5 = (com.google.gsonhtcfix.o) r5
            net.one97.paytm.hotel4.utils.e r6 = net.one97.paytm.hotel4.utils.e.f28642a
            org.json.JSONObject r6 = new org.json.JSONObject
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            net.one97.paytm.hotel4.service.model.details.TaxData r5 = net.one97.paytm.hotel4.utils.e.a((org.json.JSONObject) r6)
            java.lang.String r6 = r5.getPrice()
            java.lang.String r7 = "0.0"
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r7, (boolean) r0)
            if (r6 != 0) goto L_0x0519
            r2.add(r5)
            goto L_0x0519
        L_0x0544:
            net.one97.paytm.hotel4.view.a.m r11 = new net.one97.paytm.hotel4.view.a.m
            r11.<init>()
            r10.j = r11
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0552
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0552:
            net.one97.paytm.hotels2.b.de r11 = r11.f29514e
            androidx.recyclerview.widget.RecyclerView r11 = r11.f29457b
            java.lang.String r5 = "this.dataBinding.viewFareBreakup.rvRoomConfigTax"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            net.one97.paytm.hotel4.view.a.m r5 = r10.j
            java.lang.String r6 = "roomConfigTaxAdapter"
            if (r5 != 0) goto L_0x0565
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0565:
            androidx.recyclerview.widget.RecyclerView$a r5 = (androidx.recyclerview.widget.RecyclerView.a) r5
            r11.setAdapter(r5)
            net.one97.paytm.hotel4.view.a.m r11 = r10.j
            if (r11 != 0) goto L_0x0571
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0571:
            r11.a(r2)
            int r11 = r2.size()
            if (r11 <= 0) goto L_0x05be
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0581
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0581:
            net.one97.paytm.hotels2.b.de r11 = r11.f29514e
            android.view.View r11 = r11.f29463h
            java.lang.String r5 = "dataBinding.viewFareBreakup.vLine"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            r11.setVisibility(r0)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0594
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0594:
            net.one97.paytm.hotels2.b.de r11 = r11.f29514e
            androidx.recyclerview.widget.RecyclerView r11 = r11.f29457b
            java.lang.String r5 = "dataBinding.viewFareBreakup.rvRoomConfigTax"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            r11.setVisibility(r0)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x05a7
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x05a7:
            net.one97.paytm.hotels2.b.de r11 = r11.f29514e
            android.widget.TextView r11 = r11.f29459d
            java.lang.String r5 = "dataBinding.viewFareBreakup.tvTax"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            r11.setVisibility(r0)
            net.one97.paytm.hotel4.view.a.m r11 = r10.j
            if (r11 != 0) goto L_0x05ba
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x05ba:
            r11.a(r2)
            goto L_0x05f7
        L_0x05be:
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x05c5
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x05c5:
            net.one97.paytm.hotels2.b.de r11 = r11.f29514e
            android.view.View r11 = r11.f29463h
            java.lang.String r0 = "dataBinding.viewFareBreakup.vLine"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            r11.setVisibility(r8)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x05d8
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x05d8:
            net.one97.paytm.hotels2.b.de r11 = r11.f29514e
            androidx.recyclerview.widget.RecyclerView r11 = r11.f29457b
            java.lang.String r0 = "dataBinding.viewFareBreakup.rvRoomConfigTax"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            r11.setVisibility(r8)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x05eb
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x05eb:
            net.one97.paytm.hotels2.b.de r11 = r11.f29514e
            android.widget.TextView r11 = r11.f29459d
            java.lang.String r0 = "dataBinding.viewFareBreakup.tvTax"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            r11.setVisibility(r8)
        L_0x05f7:
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x05fe
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x05fe:
            net.one97.paytm.hotels2.b.dk r11 = r11.k
            com.airbnb.lottie.LottieAnimationView r11 = r11.f29484b
            r10.l = r11
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x060b
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x060b:
            net.one97.paytm.hotel4.service.model.promocode.PromocodeResponse r11 = r11.getPromoCodeResponse()
            if (r11 != 0) goto L_0x0616
            com.airbnb.lottie.LottieAnimationView r11 = r10.l
            net.one97.paytm.common.widgets.a.a(r11)
        L_0x0616:
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x061d
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x061d:
            com.airbnb.lottie.LottieAnimationView r11 = r11.f29511b
            r10.m = r11
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x0628
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0628:
            r11.updatePaxCount()
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x0632
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0632:
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r0 = r10.f28972a
            if (r0 != 0) goto L_0x0639
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0639:
            androidx.lifecycle.y r0 = r0.getSelectedData()
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r0 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r0
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r2 = r10.f28972a
            if (r2 != 0) goto L_0x064a
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x064a:
            net.one97.paytm.hotel4.service.model.details.HotelDetails r2 = r2.getDetailsResponse()
            if (r2 == 0) goto L_0x0654
            net.one97.paytm.hotel4.service.model.details.Extra r4 = r2.getExtra()
        L_0x0654:
            if (r4 != 0) goto L_0x0659
            kotlin.g.b.k.a()
        L_0x0659:
            java.lang.String r2 = r4.getRequestId()
            r11.updateReviewBookingEvent(r0, r2)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0667
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0667:
            net.one97.paytm.hotels2.b.cy r11 = r11.f29517h
            android.widget.EditText r11 = r11.f29435f
            r0 = r10
            android.view.View$OnFocusChangeListener r0 = (android.view.View.OnFocusChangeListener) r0
            r11.setOnFocusChangeListener(r0)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0678
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0678:
            net.one97.paytm.hotels2.b.cy r11 = r11.f29517h
            android.widget.EditText r11 = r11.f29433d
            r11.setOnFocusChangeListener(r0)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0686
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0686:
            net.one97.paytm.hotels2.b.cy r11 = r11.f29517h
            android.widget.EditText r11 = r11.f29432c
            r11.setOnFocusChangeListener(r0)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x0694
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0694:
            net.one97.paytm.hotels2.b.cy r11 = r11.f29517h
            android.widget.EditText r11 = r11.f29434e
            r11.setOnFocusChangeListener(r0)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x06a2
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x06a2:
            net.one97.paytm.hotels2.b.cu r11 = r11.f29516g
            net.one97.paytm.hotels2.b.cw r11 = r11.f29414c
            android.widget.EditText r11 = r11.f29422b
            r11.setOnFocusChangeListener(r0)
            net.one97.paytm.hotels2.b.dq r11 = r10.k
            if (r11 != 0) goto L_0x06b2
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x06b2:
            net.one97.paytm.hotels2.b.cu r11 = r11.f29516g
            net.one97.paytm.hotels2.b.cw r11 = r11.f29414c
            android.widget.EditText r11 = r11.f29421a
            r11.setOnFocusChangeListener(r0)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r11 = r10.f28973b
            if (r11 != 0) goto L_0x06c2
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x06c2:
            r11.setUserDetails()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.u.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:96:0x016e, code lost:
        r5 = (r5 = r5.f29516g).f29414c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onFocusChange(android.view.View r4, boolean r5) {
        /*
            r3 = this;
            net.one97.paytm.hotels2.b.dq r5 = r3.k
            java.lang.String r0 = "dataBinding"
            if (r5 != 0) goto L_0x0009
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0009:
            net.one97.paytm.hotels2.b.cy r5 = r5.f29517h
            android.widget.EditText r5 = r5.f29435f
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            java.lang.String r1 = "null cannot be cast to non-null type android.widget.TextView"
            java.lang.String r2 = "reviewViewModel"
            if (r5 == 0) goto L_0x0050
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r5 = r3.f28973b
            if (r5 != 0) goto L_0x001e
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x001e:
            androidx.lifecycle.y r5 = r5.get_userDetails()
            java.lang.Object r5 = r5.getValue()
            if (r5 != 0) goto L_0x002b
            kotlin.g.b.k.a()
        L_0x002b:
            net.one97.paytm.hotel4.service.model.UserDetails r5 = (net.one97.paytm.hotel4.service.model.UserDetails) r5
            if (r4 == 0) goto L_0x004a
            r0 = r4
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r5.setFirstname(r0)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r5 = r3.f28973b
            if (r5 != 0) goto L_0x0044
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0044:
            androidx.lifecycle.y r5 = r5.get_userName()
            goto L_0x0189
        L_0x004a:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r1)
            throw r4
        L_0x0050:
            net.one97.paytm.hotels2.b.dq r5 = r3.k
            if (r5 != 0) goto L_0x0057
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0057:
            net.one97.paytm.hotels2.b.cy r5 = r5.f29517h
            android.widget.EditText r5 = r5.f29433d
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x009a
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r5 = r3.f28973b
            if (r5 != 0) goto L_0x0068
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0068:
            androidx.lifecycle.y r5 = r5.get_userDetails()
            java.lang.Object r5 = r5.getValue()
            if (r5 != 0) goto L_0x0075
            kotlin.g.b.k.a()
        L_0x0075:
            net.one97.paytm.hotel4.service.model.UserDetails r5 = (net.one97.paytm.hotel4.service.model.UserDetails) r5
            if (r4 == 0) goto L_0x0094
            r0 = r4
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r5.setLastname(r0)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r5 = r3.f28973b
            if (r5 != 0) goto L_0x008e
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x008e:
            androidx.lifecycle.y r5 = r5.get_userLName()
            goto L_0x0189
        L_0x0094:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r1)
            throw r4
        L_0x009a:
            net.one97.paytm.hotels2.b.dq r5 = r3.k
            if (r5 != 0) goto L_0x00a1
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00a1:
            net.one97.paytm.hotels2.b.cy r5 = r5.f29517h
            android.widget.EditText r5 = r5.f29432c
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x00e4
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r5 = r3.f28973b
            if (r5 != 0) goto L_0x00b2
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00b2:
            androidx.lifecycle.y r5 = r5.get_userDetails()
            java.lang.Object r5 = r5.getValue()
            if (r5 != 0) goto L_0x00bf
            kotlin.g.b.k.a()
        L_0x00bf:
            net.one97.paytm.hotel4.service.model.UserDetails r5 = (net.one97.paytm.hotel4.service.model.UserDetails) r5
            if (r4 == 0) goto L_0x00de
            r0 = r4
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r5.setEmail(r0)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r5 = r3.f28973b
            if (r5 != 0) goto L_0x00d8
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00d8:
            androidx.lifecycle.y r5 = r5.get_userEmail()
            goto L_0x0189
        L_0x00de:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r1)
            throw r4
        L_0x00e4:
            net.one97.paytm.hotels2.b.dq r5 = r3.k
            if (r5 != 0) goto L_0x00eb
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00eb:
            net.one97.paytm.hotels2.b.cy r5 = r5.f29517h
            android.widget.EditText r5 = r5.f29434e
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x012d
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r5 = r3.f28973b
            if (r5 != 0) goto L_0x00fc
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00fc:
            androidx.lifecycle.y r5 = r5.get_userDetails()
            java.lang.Object r5 = r5.getValue()
            if (r5 != 0) goto L_0x0109
            kotlin.g.b.k.a()
        L_0x0109:
            net.one97.paytm.hotel4.service.model.UserDetails r5 = (net.one97.paytm.hotel4.service.model.UserDetails) r5
            if (r4 == 0) goto L_0x0127
            r0 = r4
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r5.setMobile(r0)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r5 = r3.f28973b
            if (r5 != 0) goto L_0x0122
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0122:
            androidx.lifecycle.y r5 = r5.get_userMobile()
            goto L_0x0189
        L_0x0127:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r1)
            throw r4
        L_0x012d:
            net.one97.paytm.hotels2.b.dq r5 = r3.k
            if (r5 != 0) goto L_0x0134
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0134:
            net.one97.paytm.hotels2.b.cu r5 = r5.f29516g
            net.one97.paytm.hotels2.b.cw r5 = r5.f29414c
            android.widget.EditText r5 = r5.f29422b
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0161
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r5 = r3.f28973b
            if (r5 != 0) goto L_0x0147
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0147:
            androidx.lifecycle.y r5 = r5.get_gstNumber()
            if (r4 == 0) goto L_0x015b
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            r5.setValue(r4)
            return
        L_0x015b:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r1)
            throw r4
        L_0x0161:
            net.one97.paytm.hotels2.b.dq r5 = r3.k
            if (r5 != 0) goto L_0x0168
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0168:
            if (r5 == 0) goto L_0x0175
            net.one97.paytm.hotels2.b.cu r5 = r5.f29516g
            if (r5 == 0) goto L_0x0175
            net.one97.paytm.hotels2.b.cw r5 = r5.f29414c
            if (r5 == 0) goto L_0x0175
            android.widget.EditText r5 = r5.f29421a
            goto L_0x0176
        L_0x0175:
            r5 = 0
        L_0x0176:
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x019d
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r5 = r3.f28973b
            if (r5 != 0) goto L_0x0183
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0183:
            androidx.lifecycle.y r5 = r5.get_gstCompanyName()
            if (r4 == 0) goto L_0x0197
        L_0x0189:
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            r5.setValue(r4)
            goto L_0x019d
        L_0x0197:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r1)
            throw r4
        L_0x019d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.u.onFocusChange(android.view.View, boolean):void");
    }

    /* access modifiers changed from: private */
    public final void c() {
        net.one97.paytm.common.widgets.a.b(this.m);
        ReviewViewModel reviewViewModel = this.f28973b;
        if (reviewViewModel == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel.getProcessToPayTapped().setValue(Boolean.FALSE);
    }

    public final void onResume() {
        super.onResume();
        ReviewViewModel reviewViewModel = this.f28973b;
        if (reviewViewModel == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel.getProcessToPayTapped().setValue(Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public final void a(ErrorData errorData) {
        Integer statusCode;
        ReviewViewModel reviewViewModel = this.f28973b;
        if (reviewViewModel == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel.getProcessToPayTapped().setValue(Boolean.FALSE);
        c();
        net.one97.paytm.common.widgets.a.b(this.l);
        if (errorData == null || (statusCode = errorData.getStatusCode()) == null || statusCode.intValue() != 401) {
            com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.hotels_hotel_something_went_wrong), getResources().getString(R.string.hotels_hotel_error_message));
        } else {
            net.one97.paytm.hotels2.utils.c.b().a(getActivity());
        }
    }

    private final GSTDetails d() {
        dq dqVar = this.k;
        if (dqVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        EditText editText = dqVar.f29516g.f29414c.f29422b;
        kotlin.g.b.k.a((Object) editText, "dataBinding.viewRbGstEna….viewGstInfo.tetGstNumber");
        String obj = editText.getText().toString();
        Boolean bool = Boolean.TRUE;
        dq dqVar2 = this.k;
        if (dqVar2 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        EditText editText2 = dqVar2.f29516g.f29414c.f29421a;
        kotlin.g.b.k.a((Object) editText2, "dataBinding.viewRbGstEna…GstInfo.tetGstCompanyName");
        return new GSTDetails(obj, bool, new BillingAddress(editText2.getText().toString(), "", ""));
    }

    private final void a(GSTDetails gSTDetails) {
        ReviewViewModel reviewViewModel = this.f28973b;
        if (reviewViewModel == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel.setGST(gSTDetails);
        net.one97.paytm.common.widgets.a.a(this.m);
        ReviewViewModel reviewViewModel2 = this.f28973b;
        if (reviewViewModel2 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        if (!reviewViewModel2.checkLoginStatusForPTP(getActivity())) {
            ReviewViewModel reviewViewModel3 = this.f28973b;
            if (reviewViewModel3 == null) {
                kotlin.g.b.k.a("reviewViewModel");
            }
            reviewViewModel3.getProcessToPayTapped().setValue(Boolean.FALSE);
            c();
        }
    }

    public static final class b implements net.one97.paytm.hotels2.a.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28982a;

        b(u uVar) {
            this.f28982a = uVar;
        }

        public final void a() {
            net.one97.paytm.common.widgets.a.a(this.f28982a.m);
        }

        public final void b() {
            this.f28982a.c();
        }

        public final void c() {
            net.one97.paytm.common.widgets.a.b(this.f28982a.m);
            net.one97.paytm.hotels2.utils.c.b().a((Context) this.f28982a.getActivity(), "hotel_review_new", "proceed_to_pay_clicked", "", "", "", "60");
        }
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    static final class n<T> implements z<UserDetails> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28994a;

        n(u uVar) {
            this.f28994a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            u.c(this.f28994a);
        }
    }

    static final class g<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28987a;

        g(u uVar) {
            this.f28987a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f28987a.getString(R.string.h4_gst_tnc_line1));
            arrayList.add(this.f28987a.getString(R.string.h4_gst_tnc_line2));
            arrayList.add(this.f28987a.getString(R.string.h4_gst_tnc_line3));
            net.one97.paytm.hotel4.utils.e eVar = net.one97.paytm.hotel4.utils.e.f28642a;
            net.one97.paytm.hotel4.utils.e.a(this.f28987a.getActivity(), arrayList, this.f28987a.getString(R.string.h4_terms_conditions), false, false, this.f28987a.b());
        }
    }

    static final class h<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f28988a;

        h(u uVar) {
            this.f28988a = uVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = new ArrayList();
            PromocodeDataItem value = this.f28988a.a().getPromoCodeSelectedForTnC().getValue();
            if (value == null) {
                kotlin.g.b.k.a();
            }
            arrayList.add(value.getTerms());
            net.one97.paytm.hotel4.utils.e eVar = net.one97.paytm.hotel4.utils.e.f28642a;
            net.one97.paytm.hotel4.utils.e.a(this.f28988a.getActivity(), arrayList, this.f28988a.getString(R.string.h4_terms_conditions), true, true, this.f28988a.b());
        }
    }

    public static final /* synthetic */ void a(u uVar, CJRRechargePayment cJRRechargePayment) {
        if (cJRRechargePayment == null) {
            uVar.c();
            uVar.a((ErrorData) null);
        } else if (cJRRechargePayment.getStatus() != null && kotlin.m.p.a(cJRRechargePayment.getStatus(), "SUCCESS", true)) {
            net.one97.paytm.hotels2.utils.c.b().a((Activity) uVar.getActivity(), cJRRechargePayment, (net.one97.paytm.hotels2.a.a) new b(uVar));
        } else if (cJRRechargePayment.getError() != null && cJRRechargePayment.getmCode() == 406) {
            CJRError error = cJRRechargePayment.getError();
            kotlin.g.b.k.a((Object) error, "rechargePayment.error");
            if (!TextUtils.isEmpty(error.getTitle())) {
                CJRError error2 = cJRRechargePayment.getError();
                kotlin.g.b.k.a((Object) error2, "rechargePayment.error");
                if (!TextUtils.isEmpty(error2.getMessage())) {
                    uVar.c();
                    CJRError error3 = cJRRechargePayment.getError();
                    kotlin.g.b.k.a((Object) error3, "rechargePayment.error");
                    String title = error3.getTitle();
                    CJRError error4 = cJRRechargePayment.getError();
                    kotlin.g.b.k.a((Object) error4, "rechargePayment.error");
                    com.paytm.utility.b.b((Context) uVar.getActivity(), title, error4.getMessage());
                }
            }
        } else if (cJRRechargePayment.getError() == null || !(cJRRechargePayment.getmCode() == 410 || cJRRechargePayment.getmCode() == 401)) {
            uVar.c();
            uVar.a((ErrorData) null);
        } else {
            uVar.c();
            net.one97.paytm.hotels2.utils.c.b().a(uVar.getActivity());
        }
    }

    public static final /* synthetic */ void a(u uVar, PromocodeResponse promocodeResponse) {
        net.one97.paytm.common.widgets.a.b(uVar.l);
        if (promocodeResponse != null) {
            ReviewViewModel reviewViewModel = uVar.f28973b;
            if (reviewViewModel == null) {
                kotlin.g.b.k.a("reviewViewModel");
            }
            reviewViewModel.setPromoCodeData(promocodeResponse);
            List<PromocodeDataItem> codes = promocodeResponse.getCodes();
            if (codes == null) {
                kotlin.g.b.k.a();
            }
            if (codes.size() <= 2) {
                net.one97.paytm.hotel4.view.a.n nVar = uVar.f28979h;
                if (nVar == null) {
                    kotlin.g.b.k.a("promoCodeAdapter");
                }
                nVar.a(promocodeResponse.getCodes());
            } else {
                net.one97.paytm.hotel4.view.a.n nVar2 = uVar.f28979h;
                if (nVar2 == null) {
                    kotlin.g.b.k.a("promoCodeAdapter");
                }
                nVar2.a(promocodeResponse.getCodes().subList(0, 2));
            }
            List<PromocodeDataItem> codes2 = promocodeResponse.getCodes();
            if (codes2 == null) {
                kotlin.g.b.k.a();
            }
            if (codes2.size() <= 2) {
                dq dqVar = uVar.k;
                if (dqVar == null) {
                    kotlin.g.b.k.a("dataBinding");
                }
                TextView textView = dqVar.k.f29486d;
                kotlin.g.b.k.a((Object) textView, "dataBinding.viewRbPromocode.tvMoreOffer");
                textView.setVisibility(8);
                dq dqVar2 = uVar.k;
                if (dqVar2 == null) {
                    kotlin.g.b.k.a("dataBinding");
                }
                View view = dqVar2.k.f29488f;
                kotlin.g.b.k.a((Object) view, "dataBinding.viewRbPromocode.vLine");
                view.setVisibility(8);
                return;
            }
            dq dqVar3 = uVar.k;
            if (dqVar3 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            TextView textView2 = dqVar3.k.f29486d;
            kotlin.g.b.k.a((Object) textView2, "dataBinding.viewRbPromocode.tvMoreOffer");
            textView2.setVisibility(0);
            dq dqVar4 = uVar.k;
            if (dqVar4 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            View view2 = dqVar4.k.f29488f;
            kotlin.g.b.k.a((Object) view2, "dataBinding.viewRbPromocode.vLine");
            view2.setVisibility(0);
            ReviewViewModel reviewViewModel2 = uVar.f28973b;
            if (reviewViewModel2 == null) {
                kotlin.g.b.k.a("reviewViewModel");
            }
            y<String> morePromocodeText = reviewViewModel2.getMorePromocodeText();
            StringBuilder sb = new StringBuilder("+");
            List<PromocodeDataItem> codes3 = promocodeResponse.getCodes();
            if (codes3 == null) {
                kotlin.g.b.k.a();
            }
            sb.append(codes3.size() - 2);
            sb.append(" More Offers");
            morePromocodeText.postValue(sb.toString());
            return;
        }
        Toast.makeText(uVar.getContext(), "ERROR fetching data", 0).show();
    }

    public static final /* synthetic */ void a(u uVar, PromoCodeApply promoCodeApply) {
        ReviewViewModel reviewViewModel = uVar.f28973b;
        if (reviewViewModel == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel.getProcodeLoader().postValue(Boolean.FALSE);
        if (promoCodeApply != null) {
            PromoCodeApplyData data = promoCodeApply.getData();
            if (data == null) {
                kotlin.g.b.k.a();
            }
            if (data.getPromocode() != null) {
                PromoCodeApplyData data2 = promoCodeApply.getData();
                if (data2 == null) {
                    kotlin.g.b.k.a();
                }
                String promocode = data2.getPromocode();
                if (promocode == null) {
                    kotlin.g.b.k.a();
                }
                if (promocode.length() > 0) {
                    ReviewViewModel reviewViewModel2 = uVar.f28973b;
                    if (reviewViewModel2 == null) {
                        kotlin.g.b.k.a("reviewViewModel");
                    }
                    reviewViewModel2.setApplyPromoCodeData(promoCodeApply);
                    return;
                }
            }
        }
        ReviewViewModel reviewViewModel3 = uVar.f28973b;
        if (reviewViewModel3 == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel3.setApplyPromoData((PromocodeDataItem) null);
        if (promoCodeApply != null) {
            PromoCodeApplyData data3 = promoCodeApply.getData();
            if (data3 == null) {
                kotlin.g.b.k.a();
            }
            if (data3.getPromotext() != null) {
                Context activity = uVar.getActivity();
                String string = uVar.getResources().getString(R.string.error_dialog_title);
                PromoCodeApplyData data4 = promoCodeApply.getData();
                if (data4 == null) {
                    kotlin.g.b.k.a();
                }
                com.paytm.utility.b.b(activity, string, data4.getPromotext());
                return;
            }
        }
        com.paytm.utility.b.b((Context) uVar.getActivity(), uVar.getResources().getString(R.string.error_dialog_title), "PromoCode not applied");
    }

    public static final /* synthetic */ void b(u uVar) {
        dq dqVar = uVar.k;
        if (dqVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        EditText editText = dqVar.f29517h.f29435f;
        kotlin.g.b.k.a((Object) editText, "dataBinding.viewRbGuestDetail.tetName");
        Editable text = editText.getText();
        if (text == null) {
            kotlin.g.b.k.a();
        }
        String obj = kotlin.m.p.b(text).toString();
        dq dqVar2 = uVar.k;
        if (dqVar2 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        EditText editText2 = dqVar2.f29517h.f29433d;
        kotlin.g.b.k.a((Object) editText2, "dataBinding.viewRbGuestDetail.tetLname");
        Editable text2 = editText2.getText();
        if (text2 == null) {
            kotlin.g.b.k.a();
        }
        String obj2 = kotlin.m.p.b(text2).toString();
        dq dqVar3 = uVar.k;
        if (dqVar3 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        EditText editText3 = dqVar3.f29517h.f29432c;
        kotlin.g.b.k.a((Object) editText3, "dataBinding.viewRbGuestDetail.tetEmail");
        Editable text3 = editText3.getText();
        if (text3 == null) {
            kotlin.g.b.k.a();
        }
        String obj3 = kotlin.m.p.b(text3).toString();
        dq dqVar4 = uVar.k;
        if (dqVar4 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        EditText editText4 = dqVar4.f29517h.f29434e;
        kotlin.g.b.k.a((Object) editText4, "dataBinding.viewRbGuestDetail.tetMobile");
        Editable text4 = editText4.getText();
        if (text4 == null) {
            kotlin.g.b.k.a();
        }
        UserDetails userDetails = new UserDetails("", obj, obj2, obj3, kotlin.m.p.b(text4).toString());
        ReviewViewModel reviewViewModel = uVar.f28973b;
        if (reviewViewModel == null) {
            kotlin.g.b.k.a("reviewViewModel");
        }
        reviewViewModel.get_userDetails().postValue(userDetails);
    }

    public static final /* synthetic */ void a(u uVar, boolean z) {
        if (!z) {
            uVar.c();
            net.one97.paytm.hotels2.utils.c.b().a(uVar.getActivity());
        } else if (com.paytm.utility.b.c((Context) uVar.getActivity())) {
            ReviewViewModel reviewViewModel = uVar.f28973b;
            if (reviewViewModel == null) {
                kotlin.g.b.k.a("reviewViewModel");
            }
            reviewViewModel.initPaymentProcess();
        } else {
            uVar.c();
            com.paytm.utility.b.a((Context) uVar.getActivity(), uVar.getResources().getString(R.string.hotels_hotel_no_internet_title), uVar.getResources().getString(R.string.hotels_hotel_no_internet_message));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void c(net.one97.paytm.hotel4.view.ui.a.u r6) {
        /*
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r6.f28973b
            java.lang.String r1 = "reviewViewModel"
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            androidx.lifecycle.y r0 = r0.get_validateUserDetails()
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x0016
            kotlin.g.b.k.a()
        L_0x0016:
            java.lang.String r2 = "reviewViewModel._validateUserDetails.value!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x013b
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r6.f28973b
            if (r0 != 0) goto L_0x002a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x002a:
            java.lang.String r0 = r0.validateUserData()
            java.lang.String r2 = "6"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)
            java.lang.String r3 = "errorDialogViewModel"
            if (r2 == 0) goto L_0x0106
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r6.f28973b
            if (r0 != 0) goto L_0x003f
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x003f:
            androidx.lifecycle.y r0 = r0.get_hotelGSTEnabled()
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x004c
            kotlin.g.b.k.a()
        L_0x004c:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = 1
            r4 = 0
            if (r0 == 0) goto L_0x0074
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r6.f28973b
            if (r0 != 0) goto L_0x005d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x005d:
            androidx.lifecycle.y r0 = r0.get_hotelGSTUserEnabled()
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x006a
            kotlin.g.b.k.a()
        L_0x006a:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0074
            r0 = 1
            goto L_0x0075
        L_0x0074:
            r0 = 0
        L_0x0075:
            if (r0 == 0) goto L_0x0101
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r6.f28973b
            if (r0 != 0) goto L_0x007e
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x007e:
            net.one97.paytm.hotel4.service.model.GSTDetails r5 = r6.d()
            java.lang.String r5 = r5.getGstin()
            boolean r0 = r0.isValidGST(r5)
            if (r0 == 0) goto L_0x00d9
            net.one97.paytm.hotel4.service.model.GSTDetails r0 = r6.d()
            net.one97.paytm.hotel4.service.model.BillingAddress r0 = r0.getBilling_address()
            if (r0 != 0) goto L_0x0099
            kotlin.g.b.k.a()
        L_0x0099:
            java.lang.String r0 = r0.getName()
            int r0 = r0.length()
            r5 = 3
            if (r0 <= r5) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            r2 = 0
        L_0x00a6:
            if (r2 == 0) goto L_0x00b1
            net.one97.paytm.hotel4.service.model.GSTDetails r0 = r6.d()
            r6.a((net.one97.paytm.hotel4.service.model.GSTDetails) r0)
            goto L_0x012b
        L_0x00b1:
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r6.f28973b
            if (r0 != 0) goto L_0x00b8
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00b8:
            androidx.lifecycle.y r0 = r0.getProcessToPayTapped()
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.setValue(r2)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r6.f28973b
            if (r0 != 0) goto L_0x00c8
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00c8:
            android.content.Context r1 = r6.getContext()
            net.one97.paytm.hotel4.viewmodel.ErrorDialogViewModel r6 = r6.f28978g
            if (r6 != 0) goto L_0x00d3
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00d3:
            java.lang.String r2 = "5"
            r0.showPromptDialog(r1, r6, r2)
            return
        L_0x00d9:
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r6.f28973b
            if (r0 != 0) goto L_0x00e0
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00e0:
            androidx.lifecycle.y r0 = r0.getProcessToPayTapped()
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.setValue(r2)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r0 = r6.f28973b
            if (r0 != 0) goto L_0x00f0
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00f0:
            android.content.Context r1 = r6.getContext()
            net.one97.paytm.hotel4.viewmodel.ErrorDialogViewModel r6 = r6.f28978g
            if (r6 != 0) goto L_0x00fb
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00fb:
            java.lang.String r2 = "4"
            r0.showPromptDialog(r1, r6, r2)
            return
        L_0x0101:
            r0 = 0
            r6.a((net.one97.paytm.hotel4.service.model.GSTDetails) r0)
            goto L_0x012b
        L_0x0106:
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r2 = r6.f28973b
            if (r2 != 0) goto L_0x010d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x010d:
            androidx.lifecycle.y r2 = r2.getProcessToPayTapped()
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r2.setValue(r4)
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r2 = r6.f28973b
            if (r2 != 0) goto L_0x011d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x011d:
            android.content.Context r4 = r6.getContext()
            net.one97.paytm.hotel4.viewmodel.ErrorDialogViewModel r5 = r6.f28978g
            if (r5 != 0) goto L_0x0128
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0128:
            r2.showPromptDialog(r4, r5, r0)
        L_0x012b:
            net.one97.paytm.hotel4.viewmodel.ReviewViewModel r6 = r6.f28973b
            if (r6 != 0) goto L_0x0132
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0132:
            androidx.lifecycle.y r6 = r6.get_validateUserDetails()
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r6.postValue(r0)
        L_0x013b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.u.c(net.one97.paytm.hotel4.view.ui.a.u):void");
    }

    public static final /* synthetic */ void b(u uVar, boolean z) {
        if (!com.paytm.utility.b.c((Context) uVar.getActivity())) {
            com.paytm.utility.b.a((Context) uVar.getActivity(), uVar.getResources().getString(R.string.hotels_hotel_no_internet_title), uVar.getResources().getString(R.string.hotels_hotel_no_internet_message));
        } else if (z) {
            ReviewViewModel reviewViewModel = uVar.f28973b;
            if (reviewViewModel == null) {
                kotlin.g.b.k.a("reviewViewModel");
            }
            reviewViewModel.applyPromoCode();
        }
    }

    public static final /* synthetic */ void c(u uVar, boolean z) {
        if (z) {
            net.one97.paytm.common.widgets.a.a(uVar.l);
        } else {
            net.one97.paytm.common.widgets.a.b(uVar.l);
        }
    }

    public static final /* synthetic */ void a(u uVar, String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        dq dqVar = uVar.k;
                        if (dqVar == null) {
                            kotlin.g.b.k.a("dataBinding");
                        }
                        dqVar.f29517h.f29435f.requestFocus();
                        return;
                    }
                    return;
                case 49:
                    if (str.equals("1")) {
                        dq dqVar2 = uVar.k;
                        if (dqVar2 == null) {
                            kotlin.g.b.k.a("dataBinding");
                        }
                        dqVar2.f29517h.f29433d.requestFocus();
                        return;
                    }
                    return;
                case 50:
                    if (str.equals("2")) {
                        dq dqVar3 = uVar.k;
                        if (dqVar3 == null) {
                            kotlin.g.b.k.a("dataBinding");
                        }
                        dqVar3.f29517h.f29432c.requestFocus();
                        return;
                    }
                    return;
                case 51:
                    if (str.equals("3")) {
                        dq dqVar4 = uVar.k;
                        if (dqVar4 == null) {
                            kotlin.g.b.k.a("dataBinding");
                        }
                        dqVar4.f29517h.f29434e.requestFocus();
                        return;
                    }
                    return;
                case 52:
                    if (str.equals("4")) {
                        dq dqVar5 = uVar.k;
                        if (dqVar5 == null) {
                            kotlin.g.b.k.a("dataBinding");
                        }
                        dqVar5.f29516g.f29414c.f29422b.requestFocus();
                        return;
                    }
                    return;
                case 53:
                    if (str.equals("5")) {
                        dq dqVar6 = uVar.k;
                        if (dqVar6 == null) {
                            kotlin.g.b.k.a("dataBinding");
                        }
                        dqVar6.f29516g.f29414c.f29421a.requestFocus();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}

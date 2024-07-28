package net.one97.paytm.hotel4.view.ui.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.details.PaytmImages;
import net.one97.paytm.hotel4.service.model.ordersummary.CancelOrderModel;
import net.one97.paytm.hotel4.service.model.ordersummary.CancelRefundData;
import net.one97.paytm.hotel4.service.model.ordersummary.MetaData;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel;
import net.one97.paytm.hotel4.viewmodel.DataViewModel;
import net.one97.paytm.hotel4.viewmodel.ErrorDialogViewModel;
import net.one97.paytm.hotels2.R;

public final class s extends net.one97.paytm.i.h {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.hotels2.b.a f28946a;

    /* renamed from: b  reason: collision with root package name */
    CancelOrderViewModel f28947b;

    /* renamed from: c  reason: collision with root package name */
    DataViewModel f28948c;

    /* renamed from: d  reason: collision with root package name */
    public z f28949d;

    /* renamed from: e  reason: collision with root package name */
    ProgressDialog f28950e;

    /* renamed from: f  reason: collision with root package name */
    ErrorDialogViewModel f28951f;

    /* renamed from: g  reason: collision with root package name */
    com.travel.utils.h f28952g = new com.travel.utils.h(750);

    /* renamed from: h  reason: collision with root package name */
    private LottieAnimationView f28953h;

    static final class a<T> implements z<CancelOrderModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f28954a;

        a(s sVar) {
            this.f28954a = sVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CancelOrderModel cancelOrderModel = (CancelOrderModel) obj;
            s sVar = this.f28954a;
            CancelOrderViewModel cancelOrderViewModel = sVar.f28947b;
            CancelRefundData cancelRefundData = null;
            if (cancelOrderViewModel != null) {
                cancelOrderViewModel.setRefundDetails(cancelOrderModel != null ? cancelOrderModel.getData() : null);
            }
            net.one97.paytm.hotels2.b.a aVar = sVar.f28946a;
            if (aVar == null) {
                k.a("dataBinding");
            }
            if (aVar != null) {
                CancelOrderViewModel cancelOrderViewModel2 = sVar.f28947b;
                if (cancelOrderViewModel2 != null) {
                    cancelRefundData = cancelOrderViewModel2.getRefundDetails();
                }
                aVar.a(cancelRefundData);
            }
            sVar.a(false);
        }
    }

    static final class b<T> implements z<ErrorData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f28955a;

        b(s sVar) {
            this.f28955a = sVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ErrorData errorData = (ErrorData) obj;
            s sVar = this.f28955a;
            k.a((Object) errorData, "data");
            k.c(errorData, "data");
            sVar.a(false);
            sVar.a(errorData);
        }
    }

    static final class c<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f28956a;

        c(s sVar) {
            this.f28956a = sVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            s sVar = this.f28956a;
            k.a((Object) bool, "data");
            if (bool.booleanValue()) {
                net.one97.paytm.hotels2.b.a aVar = sVar.f28946a;
                if (aVar == null) {
                    k.a("dataBinding");
                }
                LinearLayout linearLayout = aVar.k;
                k.a((Object) linearLayout, "this.dataBinding.linearCancelLyout");
                linearLayout.setVisibility(8);
                return;
            }
            net.one97.paytm.hotels2.b.a aVar2 = sVar.f28946a;
            if (aVar2 == null) {
                k.a("dataBinding");
            }
            LinearLayout linearLayout2 = aVar2.k;
            k.a((Object) linearLayout2, "this.dataBinding.linearCancelLyout");
            if (linearLayout2.getVisibility() != 0) {
                net.one97.paytm.hotels2.b.a aVar3 = sVar.f28946a;
                if (aVar3 == null) {
                    k.a("dataBinding");
                }
                LinearLayout linearLayout3 = aVar3.k;
                k.a((Object) linearLayout3, "this.dataBinding.linearCancelLyout");
                linearLayout3.setVisibility(0);
            } else if (TextUtils.isEmpty(sVar.a())) {
                Toast.makeText(sVar.getContext(), "Please Select Cancellation Reason", 1).show();
            } else {
                net.one97.paytm.hotels2.b.a aVar4 = sVar.f28946a;
                if (aVar4 == null) {
                    k.a("dataBinding");
                }
                LinearLayout linearLayout4 = aVar4.k;
                k.a((Object) linearLayout4, "this.dataBinding.linearCancelLyout");
                linearLayout4.setVisibility(8);
                if (sVar.f28950e == null) {
                    sVar.f28950e = new ProgressDialog(sVar.getContext());
                }
                ProgressDialog progressDialog = sVar.f28950e;
                if (progressDialog != null) {
                    Context context = sVar.getContext();
                    progressDialog.setMessage(context != null ? context.getString(R.string.h4_cancel_progress_message) : null);
                }
                ProgressDialog progressDialog2 = sVar.f28950e;
                if (progressDialog2 != null) {
                    progressDialog2.setCancelable(false);
                }
                ProgressDialog progressDialog3 = sVar.f28950e;
                if (progressDialog3 != null) {
                    progressDialog3.setCanceledOnTouchOutside(false);
                }
                ProgressDialog progressDialog4 = sVar.f28950e;
                if (progressDialog4 != null) {
                    progressDialog4.show();
                }
                CancelOrderViewModel cancelOrderViewModel = sVar.f28947b;
                if (cancelOrderViewModel != null) {
                    cancelOrderViewModel.doCancelBookingApiCall(sVar.getContext(), sVar.a());
                }
            }
        }
    }

    static final class e<T> implements z<CancelOrderModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f28958a;

        e(s sVar) {
            this.f28958a = sVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v5, types: [androidx.fragment.app.q] */
        /* JADX WARNING: type inference failed for: r1v7 */
        /* JADX WARNING: type inference failed for: r1v8 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r6) {
            /*
                r5 = this;
                net.one97.paytm.hotel4.service.model.ordersummary.CancelOrderModel r6 = (net.one97.paytm.hotel4.service.model.ordersummary.CancelOrderModel) r6
                net.one97.paytm.hotel4.view.ui.a.s r0 = r5.f28958a
                r0.b()
                r1 = 0
                if (r6 == 0) goto L_0x000f
                java.lang.String r2 = r6.getCode()
                goto L_0x0010
            L_0x000f:
                r2 = r1
            L_0x0010:
                r3 = 0
                java.lang.String r4 = "200"
                boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)
                java.lang.String r3 = ""
                if (r2 == 0) goto L_0x007a
                if (r6 == 0) goto L_0x0022
                java.lang.String r6 = r6.getMessage()
                goto L_0x0023
            L_0x0022:
                r6 = r1
            L_0x0023:
                net.one97.paytm.hotel4.utils.b$a r2 = new net.one97.paytm.hotel4.utils.b$a
                r2.<init>()
                r2.a(r3)
                java.lang.String r6 = java.lang.String.valueOf(r6)
                r2.b(r6)
                java.lang.String r6 = "OK"
                r2.c(r6)
                net.one97.paytm.hotel4.viewmodel.ErrorDialogViewModel r6 = r0.f28951f
                java.lang.String r3 = "errorDialogViewModel"
                if (r6 != 0) goto L_0x0040
                kotlin.g.b.k.a((java.lang.String) r3)
            L_0x0040:
                com.travel.utils.l r6 = r6.getTag()
                java.lang.String r4 = "7"
                r6.postValue(r4)
                net.one97.paytm.hotel4.viewmodel.ErrorDialogViewModel r6 = r0.f28951f
                if (r6 != 0) goto L_0x0050
                kotlin.g.b.k.a((java.lang.String) r3)
            L_0x0050:
                com.travel.utils.l r6 = r6.getErrorObject()
                r6.postValue(r2)
                net.one97.paytm.hotel4.view.ui.a.f r6 = new net.one97.paytm.hotel4.view.ui.a.f
                r6.<init>()
                r2 = r0
                androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
                r6.a((androidx.fragment.app.Fragment) r2)
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                if (r0 == 0) goto L_0x006d
                androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
                goto L_0x006e
            L_0x006d:
                r0 = r1
            L_0x006e:
                if (r0 == 0) goto L_0x0074
                androidx.fragment.app.q r1 = r0.a()
            L_0x0074:
                if (r1 == 0) goto L_0x0079
                r6.show((androidx.fragment.app.q) r1, (java.lang.String) r4)
            L_0x0079:
                return
            L_0x007a:
                if (r6 == 0) goto L_0x0081
                java.lang.String r2 = r6.getMessage()
                goto L_0x0082
            L_0x0081:
                r2 = r1
            L_0x0082:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x009a
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                android.content.Context r0 = (android.content.Context) r0
                if (r6 == 0) goto L_0x0096
                java.lang.String r1 = r6.getMessage()
            L_0x0096:
                com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r3, (java.lang.String) r1)
                return
            L_0x009a:
                androidx.fragment.app.FragmentActivity r6 = r0.getActivity()
                android.content.Context r6 = (android.content.Context) r6
                android.content.res.Resources r1 = r0.getResources()
                int r2 = net.one97.paytm.hotels2.R.string.hotels_hotel_something_went_wrong
                java.lang.String r1 = r1.getString(r2)
                android.content.res.Resources r0 = r0.getResources()
                int r2 = net.one97.paytm.hotels2.R.string.hotels_hotel_error_message
                java.lang.String r0 = r0.getString(r2)
                com.paytm.utility.b.b((android.content.Context) r6, (java.lang.String) r1, (java.lang.String) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.s.e.onChanged(java.lang.Object):void");
        }
    }

    static final class f<T> implements z<ErrorData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f28959a;

        f(s sVar) {
            this.f28959a = sVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            s sVar = this.f28959a;
            sVar.b();
            sVar.a((ErrorData) obj);
        }
    }

    public static final /* synthetic */ net.one97.paytm.hotels2.b.a a(s sVar) {
        net.one97.paytm.hotels2.b.a aVar = sVar.f28946a;
        if (aVar == null) {
            k.a("dataBinding");
        }
        return aVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        y<MetaData> metaData;
        MetaData value;
        PaytmImages paytmImages;
        List<String> full;
        y<Boolean> closePaymentDetails;
        y<Boolean> closeCancelBookinScreen;
        y<ErrorData> cancelBookingError;
        y<CancelOrderModel> cancelBookingResponse;
        y<Boolean> cancellationPolicy;
        y<Boolean> cancelButtonClick;
        y<ErrorData> cancelRefundError;
        y<CancelOrderModel> cancelRefundResponse;
        k.c(layoutInflater, "inflater");
        net.one97.paytm.hotels2.b.a a2 = net.one97.paytm.hotels2.b.a.a(getLayoutInflater(), viewGroup);
        k.a((Object) a2, "H4CancelOrderLyoutBindin…flater, container, false)");
        this.f28946a = a2;
        net.one97.paytm.hotels2.b.a aVar = this.f28946a;
        if (aVar == null) {
            k.a("dataBinding");
        }
        this.f28953h = (LottieAnimationView) aVar.getRoot().findViewById(R.id.lottieAnim);
        net.one97.paytm.hotels2.b.a aVar2 = this.f28946a;
        if (aVar2 == null) {
            k.a("dataBinding");
        }
        q qVar = this;
        aVar2.setLifecycleOwner(qVar);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f28947b = (CancelOrderViewModel) am.a(activity).a(CancelOrderViewModel.class);
            ai a3 = am.a(activity).a(DataViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…ataViewModel::class.java]");
            this.f28948c = (DataViewModel) a3;
            ai a4 = am.a(activity).a(ErrorDialogViewModel.class);
            k.a((Object) a4, "ViewModelProviders.of(it…logViewModel::class.java]");
            this.f28951f = (ErrorDialogViewModel) a4;
            CancelOrderViewModel cancelOrderViewModel = this.f28947b;
            if (cancelOrderViewModel != null) {
                cancelOrderViewModel.getCancelRefundDetails(getContext());
            }
            a(true);
            CancelOrderViewModel cancelOrderViewModel2 = this.f28947b;
            if (!(cancelOrderViewModel2 == null || (cancelRefundResponse = cancelOrderViewModel2.getCancelRefundResponse()) == null)) {
                cancelRefundResponse.observe(qVar, new a(this));
            }
            CancelOrderViewModel cancelOrderViewModel3 = this.f28947b;
            if (!(cancelOrderViewModel3 == null || (cancelRefundError = cancelOrderViewModel3.getCancelRefundError()) == null)) {
                cancelRefundError.observe(qVar, new b(this));
            }
            CancelOrderViewModel cancelOrderViewModel4 = this.f28947b;
            if (!(cancelOrderViewModel4 == null || (cancelButtonClick = cancelOrderViewModel4.getCancelButtonClick()) == null)) {
                cancelButtonClick.observe(qVar, new c(this));
            }
            CancelOrderViewModel cancelOrderViewModel5 = this.f28947b;
            if (!(cancelOrderViewModel5 == null || (cancellationPolicy = cancelOrderViewModel5.getCancellationPolicy()) == null)) {
                cancellationPolicy.observe(qVar, new d(this));
            }
            CancelOrderViewModel cancelOrderViewModel6 = this.f28947b;
            if (!(cancelOrderViewModel6 == null || (cancelBookingResponse = cancelOrderViewModel6.getCancelBookingResponse()) == null)) {
                cancelBookingResponse.observe(qVar, new e(this));
            }
            CancelOrderViewModel cancelOrderViewModel7 = this.f28947b;
            if (!(cancelOrderViewModel7 == null || (cancelBookingError = cancelOrderViewModel7.getCancelBookingError()) == null)) {
                cancelBookingError.observe(qVar, new f(this));
            }
            CancelOrderViewModel cancelOrderViewModel8 = this.f28947b;
            if (!(cancelOrderViewModel8 == null || (closeCancelBookinScreen = cancelOrderViewModel8.getCloseCancelBookinScreen()) == null)) {
                closeCancelBookinScreen.observe(qVar, new g(this));
            }
            CancelOrderViewModel cancelOrderViewModel9 = this.f28947b;
            if (!(cancelOrderViewModel9 == null || (closePaymentDetails = cancelOrderViewModel9.getClosePaymentDetails()) == null)) {
                closePaymentDetails.observe(qVar, new h(this));
            }
            net.one97.paytm.hotels2.b.a aVar3 = this.f28946a;
            if (aVar3 == null) {
                k.a("dataBinding");
            }
            aVar3.f29097c.f29791c.setOnClickListener(new i(this));
        }
        net.one97.paytm.hotels2.b.a aVar4 = this.f28946a;
        if (aVar4 == null) {
            k.a("dataBinding");
        }
        aVar4.a(this.f28947b);
        CancelOrderViewModel cancelOrderViewModel10 = this.f28947b;
        if (!(cancelOrderViewModel10 == null || (metaData = cancelOrderViewModel10.getMetaData()) == null || (value = metaData.getValue()) == null || (paytmImages = value.paytmImages) == null || (full = paytmImages.getFull()) == null || full.size() <= 1)) {
            a.C0498a aVar5 = net.one97.paytm.hotel4.utils.a.f28631a;
            net.one97.paytm.hotels2.b.a aVar6 = this.f28946a;
            if (aVar6 == null) {
                k.a("dataBinding");
            }
            a.C0498a.a(aVar6.f29098d.f29889b, full.get(1));
        }
        net.one97.paytm.hotels2.b.a aVar7 = this.f28946a;
        if (aVar7 == null) {
            k.a("dataBinding");
        }
        return aVar7.getRoot();
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f28962a;

        i(s sVar) {
            this.f28962a = sVar;
        }

        public final void onClick(View view) {
            LinearLayout linearLayout = s.a(this.f28962a).m;
            k.a((Object) linearLayout, "this.dataBinding.linearPaymentInfoLyout");
            linearLayout.setVisibility(0);
        }
    }

    public final void a(ErrorData errorData) {
        Integer statusCode;
        Integer statusCode2;
        Integer statusCode3;
        if (errorData != null && (statusCode3 = errorData.getStatusCode()) != null && statusCode3.intValue() == 901) {
            com.paytm.utility.b.a((Context) getActivity(), getResources().getString(R.string.hotels_hotel_no_internet_title), getResources().getString(R.string.hotels_hotel_no_internet_message));
        } else if (errorData != null && (((statusCode = errorData.getStatusCode()) != null && statusCode.intValue() == 410) || ((statusCode2 = errorData.getStatusCode()) != null && statusCode2.intValue() == 401))) {
            net.one97.paytm.hotels2.utils.c.b().a(getActivity());
        } else if (errorData == null || TextUtils.isEmpty(errorData.getMessage())) {
            com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.hotels_hotel_something_went_wrong), getResources().getString(R.string.hotels_hotel_error_message));
        } else {
            com.paytm.utility.b.b((Context) getActivity(), errorData.getTitle(), errorData.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        if (z) {
            net.one97.paytm.common.widgets.a.a(this.f28953h);
        } else {
            net.one97.paytm.common.widgets.a.b(this.f28953h);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getSelectedCancelReason();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a() {
        /*
            r4 = this;
            net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel r0 = r4.f28947b
            if (r0 == 0) goto L_0x0011
            androidx.lifecycle.y r0 = r0.getSelectedCancelReason()
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = r0.getValue()
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            java.lang.String r1 = "dataBinding"
            if (r0 != 0) goto L_0x0017
            goto L_0x0039
        L_0x0017:
            int r2 = r0.intValue()
            r3 = 1
            if (r2 != r3) goto L_0x0039
            net.one97.paytm.hotels2.b.a r0 = r4.f28946a
            if (r0 != 0) goto L_0x0025
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0025:
            net.one97.paytm.hotels2.b.e r0 = r0.f29096b
            android.widget.TextView r0 = r0.f29557c
            java.lang.String r1 = "this.dataBinding.cancelOrderReason.txtViewOptions1"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            goto L_0x00cc
        L_0x0039:
            if (r0 != 0) goto L_0x003c
            goto L_0x005e
        L_0x003c:
            int r2 = r0.intValue()
            r3 = 2
            if (r2 != r3) goto L_0x005e
            net.one97.paytm.hotels2.b.a r0 = r4.f28946a
            if (r0 != 0) goto L_0x004a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x004a:
            net.one97.paytm.hotels2.b.e r0 = r0.f29096b
            android.widget.TextView r0 = r0.f29558d
            java.lang.String r1 = "this.dataBinding.cancelOrderReason.txtViewOptions2"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            goto L_0x00cc
        L_0x005e:
            if (r0 != 0) goto L_0x0061
            goto L_0x0082
        L_0x0061:
            int r2 = r0.intValue()
            r3 = 3
            if (r2 != r3) goto L_0x0082
            net.one97.paytm.hotels2.b.a r0 = r4.f28946a
            if (r0 != 0) goto L_0x006f
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x006f:
            net.one97.paytm.hotels2.b.e r0 = r0.f29096b
            android.widget.TextView r0 = r0.f29559e
            java.lang.String r1 = "this.dataBinding.cancelOrderReason.txtViewOptions3"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            goto L_0x00cc
        L_0x0082:
            if (r0 != 0) goto L_0x0085
            goto L_0x00a6
        L_0x0085:
            int r2 = r0.intValue()
            r3 = 4
            if (r2 != r3) goto L_0x00a6
            net.one97.paytm.hotels2.b.a r0 = r4.f28946a
            if (r0 != 0) goto L_0x0093
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0093:
            net.one97.paytm.hotels2.b.e r0 = r0.f29096b
            android.widget.TextView r0 = r0.f29560f
            java.lang.String r1 = "this.dataBinding.cancelOrderReason.txtViewOptions4"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            goto L_0x00cc
        L_0x00a6:
            if (r0 != 0) goto L_0x00a9
            goto L_0x00ca
        L_0x00a9:
            int r0 = r0.intValue()
            r2 = 5
            if (r0 != r2) goto L_0x00ca
            net.one97.paytm.hotels2.b.a r0 = r4.f28946a
            if (r0 != 0) goto L_0x00b7
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00b7:
            net.one97.paytm.hotels2.b.e r0 = r0.f29096b
            android.widget.EditText r0 = r0.f29561g
            java.lang.String r1 = "this.dataBinding.cancelOrderReason.txtViewOptions5"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            goto L_0x00cc
        L_0x00ca:
            java.lang.String r0 = ""
        L_0x00cc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.s.a():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        ProgressDialog progressDialog = this.f28950e;
        if (progressDialog != null && progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    static final class d<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f28957a;

        d(s sVar) {
            this.f28957a = sVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
            r1 = (r1 = (r1 = r1.getMetaData()).getValue()).cancellationPolicy;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r5) {
            /*
                r4 = this;
                net.one97.paytm.hotel4.view.ui.a.s r5 = r4.f28957a
                com.travel.utils.h r0 = r5.f28952g
                java.lang.String r1 = "openCancellationPolicy"
                boolean r0 = r0.a(r1)
                if (r0 != 0) goto L_0x0095
                net.one97.paytm.hotel4.viewmodel.DataViewModel r0 = r5.f28948c
                java.lang.String r1 = "dataViewModel"
                if (r0 != 0) goto L_0x0015
                kotlin.g.b.k.a((java.lang.String) r1)
            L_0x0015:
                r2 = 1
                r0.setShowClose(r2)
                net.one97.paytm.hotel4.viewmodel.DataViewModel r0 = r5.f28948c
                if (r0 != 0) goto L_0x0020
                kotlin.g.b.k.a((java.lang.String) r1)
            L_0x0020:
                java.lang.String r3 = "Cancellation Policy"
                r0.setTitle(r3)
                net.one97.paytm.hotel4.viewmodel.DataViewModel r0 = r5.f28948c
                if (r0 != 0) goto L_0x002c
                kotlin.g.b.k.a((java.lang.String) r1)
            L_0x002c:
                r0.setShowRecyclerViewList(r2)
                net.one97.paytm.hotel4.viewmodel.DataViewModel r0 = r5.f28948c
                if (r0 != 0) goto L_0x0036
                kotlin.g.b.k.a((java.lang.String) r1)
            L_0x0036:
                androidx.lifecycle.y r0 = r0.getRecyclerListData()
                net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel r1 = r5.f28947b
                if (r1 == 0) goto L_0x0057
                androidx.lifecycle.y r1 = r1.getMetaData()
                if (r1 == 0) goto L_0x0057
                java.lang.Object r1 = r1.getValue()
                net.one97.paytm.hotel4.service.model.ordersummary.MetaData r1 = (net.one97.paytm.hotel4.service.model.ordersummary.MetaData) r1
                if (r1 == 0) goto L_0x0057
                java.lang.String r1 = r1.cancellationPolicy
                if (r1 == 0) goto L_0x0057
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.util.List r1 = kotlin.m.p.g(r1)
                goto L_0x0058
            L_0x0057:
                r1 = 0
            L_0x0058:
                r0.postValue(r1)
                net.one97.paytm.hotel4.view.ui.a.z r0 = new net.one97.paytm.hotel4.view.ui.a.z
                r0.<init>()
                r5.f28949d = r0
                net.one97.paytm.hotel4.view.ui.a.z r0 = r5.f28949d
                if (r0 != 0) goto L_0x0069
                kotlin.g.b.k.a()
            L_0x0069:
                androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
                java.lang.String r1 = "DataFragment"
                androidx.fragment.app.j r5 = r5.getChildFragmentManager()
                java.lang.String r2 = "this.childFragmentManager"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
                androidx.fragment.app.q r5 = r5.a()
                java.lang.String r2 = "manager.beginTransaction()"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
                r5.a((java.lang.String) r1)
                boolean r2 = r0 instanceof androidx.fragment.app.b
                if (r2 == 0) goto L_0x008d
                androidx.fragment.app.b r0 = (androidx.fragment.app.b) r0
                r0.show((androidx.fragment.app.q) r5, (java.lang.String) r1)
                return
            L_0x008d:
                int r2 = net.one97.paytm.hotels2.R.id.fragment_container
                r5.b(r2, r0, r1)
                r5.c()
            L_0x0095:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.s.d.onChanged(java.lang.Object):void");
        }
    }

    static final class g<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f28960a;

        g(s sVar) {
            this.f28960a = sVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            FragmentActivity activity = this.f28960a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    static final class h<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f28961a;

        h(s sVar) {
            this.f28961a = sVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            LinearLayout linearLayout = s.a(this.f28961a).m;
            k.a((Object) linearLayout, "this.dataBinding.linearPaymentInfoLyout");
            linearLayout.setVisibility(8);
        }
    }
}

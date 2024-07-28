package net.one97.paytm.acceptPayment.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.business.common_module.a.a.b;
import com.business.common_module.utilities.LogUtility;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.BaseFragment;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import com.business.merchant_payments.common.view.CommonOverlayDialogFragment;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.homepagedialogs.HomePageSuccessPopup;
import com.business.merchant_payments.homepagedialogs.PaymentNotificationData;
import com.business.merchant_payments.homepagedialogs.PaymentNotificationFragment;
import com.business.merchant_payments.model.customcards.CustomCardUIModel;
import com.business.merchant_payments.model.primary.RewardsBalance;
import com.business.merchant_payments.newhome.AmountOnHoldDialogFragment;
import com.business.merchant_payments.newhome.HomeRVAdapter;
import com.business.merchant_payments.newhome.HomeRVListener;
import com.business.merchant_payments.newhome.SelectDateBottomSheet;
import com.business.merchant_payments.newhome.listener.IAcceptPaymentMainActivityListener;
import com.business.merchant_payments.payment.CustomCardViewModel;
import com.business.merchant_payments.payment.model.GenericErrorModel;
import com.business.merchant_payments.payment.model.PaymentsTransactionModel;
import com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo;
import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;
import com.business.merchant_payments.payment.view.OnlineTxnDetailsActivity;
import com.business.merchant_payments.payment.view.PaymentListActivity;
import com.business.merchant_payments.payment.view.RefundDetailsActivity;
import com.business.merchant_payments.payment.view.ReversalDetailsActivity;
import com.business.merchant_payments.payment.viewmodel.PaymentsViewModel;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.business.merchant_payments.settlement.model.BWSettlementCardSummaryAdapterModel;
import com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel;
import com.business.merchant_payments.settlement.model.LabelModel;
import com.business.merchant_payments.settlement.model.M2BModel;
import com.business.merchant_payments.settlement.model.M2BOrderListItemModel;
import com.business.merchant_payments.settlement.model.NoSettlementsDataAdapterModel;
import com.business.merchant_payments.settlement.model.SettlementBillListDetailModel;
import com.business.merchant_payments.settlement.model.SettlementBillListItemModel;
import com.business.merchant_payments.settlement.model.SettlementBillListModel;
import com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel;
import com.business.merchant_payments.settlement.view.OrderListDateRangeActivityMP;
import com.business.merchant_payments.utility.MPConstants;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.business.merchantprofile.common.ProfileGTMConstants;
import com.paytm.business.merchantprofile.common.utility.AppUtility;
import com.paytm.business.merchantprofile.databinding.PrPaymentsInActiveMerchantBinding;
import com.paytm.business.merchantprofile.inactivemerchant.AccountActivationState;
import com.paytm.business.merchantprofile.inactivemerchant.AccountReactivationRequestEvent;
import com.paytm.business.merchantprofile.inactivemerchant.Error;
import com.paytm.business.merchantprofile.inactivemerchant.InActiveMerchantViewHolder;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantReactivationSuccess;
import com.paytm.business.merchantprofile.inactivemerchant.Success;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.acceptPayment.R;
import org.greenrobot.eventbus.ThreadMode;
import retrofit2.Response;

public final class b extends BaseFragment implements CommonOverlayDialogFragment.CommonOverlayDialogListener, PaymentNotificationFragment.PaymentNotificationFragmentListener {

    /* renamed from: a  reason: collision with root package name */
    public static final String f52093a = "AcceptPaymentFragment";

    /* renamed from: b  reason: collision with root package name */
    public static final a f52094b = new a((byte) 0);
    private final z<com.business.common_module.utilities.a.b<TodaySettlementSummaryCardModel>> A = new r(this);
    private final z<com.business.common_module.utilities.a.b<SettlementBillListDetailModel>> B = new l(this);
    private final z<com.business.common_module.utilities.a.b<SettlementBillListDetailModel>> C = new n(this);
    private final z<BWSettlementM2BTransactionDetailObservableModel> D = new k(this);
    /* access modifiers changed from: private */
    public final SwipeRefreshLayout.b E = new q(this);
    private HashMap F;

    /* renamed from: c  reason: collision with root package name */
    boolean f52095c;

    /* renamed from: d  reason: collision with root package name */
    a f52096d;

    /* renamed from: e  reason: collision with root package name */
    HomeRVListener f52097e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.acceptPayment.a.i f52098f;

    /* renamed from: g  reason: collision with root package name */
    private CustomCardViewModel f52099g;

    /* renamed from: h  reason: collision with root package name */
    private PaymentsViewModel f52100h;

    /* renamed from: i  reason: collision with root package name */
    private HomeRVAdapter f52101i;
    /* access modifiers changed from: private */
    public ArrayList<Object> j;
    private boolean k;
    private boolean l;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public int n = 1;
    /* access modifiers changed from: private */
    public final SimpleDateFormat o = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US);
    /* access modifiers changed from: private */
    public Calendar p;
    /* access modifiers changed from: private */
    public Calendar q;
    /* access modifiers changed from: private */
    public int r;
    /* access modifiers changed from: private */
    public boolean s;
    /* access modifiers changed from: private */
    public Snackbar t;
    /* access modifiers changed from: private */
    public boolean u;
    /* access modifiers changed from: private */
    public String v;
    /* access modifiers changed from: private */
    public com.business.common_module.a.a.b w;
    /* access modifiers changed from: private */
    public final m x = new m(this);
    /* access modifiers changed from: private */
    public final p y = new p(this);
    private final z<com.business.common_module.utilities.a.b<SettlementBillListModel>> z = new o(this);

    public final void initUI() {
    }

    static final class f<T> implements z<ArrayList<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52106a;

        f(b bVar) {
            this.f52106a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            b bVar = this.f52106a;
            kotlin.g.b.k.b(arrayList, "it");
            b.b(bVar, arrayList);
        }
    }

    static final class g<T> implements z<ArrayList<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52107a;

        g(b bVar) {
            this.f52107a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            b bVar = this.f52107a;
            kotlin.g.b.k.b(arrayList, "it");
            b.c(bVar, arrayList);
        }
    }

    static final class h<T> implements z<RewardsBalance> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52108a;

        h(b bVar) {
            this.f52108a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            RewardsBalance rewardsBalance = (RewardsBalance) obj;
            b bVar = this.f52108a;
            kotlin.g.b.k.b(rewardsBalance, "it");
            b.a(bVar, rewardsBalance);
        }
    }

    static final class i<T> implements z<SanitizedResponseModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52109a;

        i(b bVar) {
            this.f52109a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            SanitizedResponseModel sanitizedResponseModel = (SanitizedResponseModel) obj;
            b bVar = this.f52109a;
            List<View> rvWidgets = sanitizedResponseModel.getRvWidgets();
            kotlin.g.b.k.b(sanitizedResponseModel, "it");
            b.a(bVar, (List) rvWidgets, sanitizedResponseModel);
        }
    }

    static final class j<T> implements z<MerchantAccountActivationUIState> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52110a;

        j(b bVar) {
            this.f52110a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            FragmentActivity activity;
            MerchantAccountActivationUIState merchantAccountActivationUIState = (MerchantAccountActivationUIState) obj;
            if ((merchantAccountActivationUIState instanceof Error) && (activity = this.f52110a.getActivity()) != null) {
                kotlin.g.b.k.b(activity, "activity");
                if (!activity.isFinishing() && b.a(this.f52110a).isPaymentsTabSelected().get()) {
                    Error error = (Error) merchantAccountActivationUIState;
                    Object response = error.getResponse();
                    if (!(response instanceof Response)) {
                        response = null;
                    }
                    if (ErrorUtil.handleInvalidToken("UMP", (Response) response)) {
                        activity.finish();
                    }
                    b bVar = this.f52110a;
                    CoordinatorLayout coordinatorLayout = b.d(bVar).f51999d;
                    Object response2 = error.getResponse();
                    if (!(response2 instanceof Response)) {
                        response2 = null;
                    }
                    bVar.t = Snackbar.a((android.view.View) coordinatorLayout, (CharSequence) ErrorUtil.getErrorMessage((Response<?>) (Response) response2), 0);
                    Snackbar c2 = this.f52110a.t;
                    if (c2 != null) {
                        c2.c();
                    }
                }
            }
        }
    }

    static final class k<T> implements z<BWSettlementM2BTransactionDetailObservableModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52111a;

        k(b bVar) {
            this.f52111a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            BWSettlementM2BTransactionDetailObservableModel bWSettlementM2BTransactionDetailObservableModel = (BWSettlementM2BTransactionDetailObservableModel) obj;
            FragmentActivity activity = this.f52111a.getActivity();
            if (activity != null) {
                kotlin.g.b.k.b(activity, "act");
                if (!activity.isFinishing()) {
                    if ((activity instanceof BaseActivity) && !b.a(this.f52111a).isPaymentsTabSelected().get() && !ErrorUtil.handleInvalidToken("UMP", bWSettlementM2BTransactionDetailObservableModel.getWrappedData().f7356a)) {
                        ((BaseActivity) activity).removeProgressDialog();
                    }
                    b bVar = this.f52111a;
                    kotlin.g.b.k.b(bWSettlementM2BTransactionDetailObservableModel, "it");
                    b.a(bVar, bWSettlementM2BTransactionDetailObservableModel);
                }
            }
        }
    }

    static final class l<T> implements z<com.business.common_module.utilities.a.b<SettlementBillListDetailModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52112a;

        l(b bVar) {
            this.f52112a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.business.common_module.utilities.a.b bVar = (com.business.common_module.utilities.a.b) obj;
            FragmentActivity activity = this.f52112a.getActivity();
            if (activity != null) {
                kotlin.g.b.k.b(activity, "act");
                if (!activity.isFinishing()) {
                    if ((activity instanceof BaseActivity) && !b.a(this.f52112a).isPaymentsTabSelected().get() && !ErrorUtil.handleInvalidToken("UMP", bVar.f7356a)) {
                        ((BaseActivity) activity).removeProgressDialog();
                    }
                    b bVar2 = this.f52112a;
                    kotlin.g.b.k.b(bVar, "it");
                    b.a(bVar2, bVar, false);
                }
            }
        }
    }

    static final class n<T> implements z<com.business.common_module.utilities.a.b<SettlementBillListDetailModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52115a;

        n(b bVar) {
            this.f52115a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.business.common_module.utilities.a.b bVar = (com.business.common_module.utilities.a.b) obj;
            FragmentActivity activity = this.f52115a.getActivity();
            if (activity != null) {
                kotlin.g.b.k.b(activity, "act");
                if (!activity.isFinishing()) {
                    if ((activity instanceof BaseActivity) && !b.a(this.f52115a).isPaymentsTabSelected().get() && !ErrorUtil.handleInvalidToken("UMP", bVar.f7356a)) {
                        ((BaseActivity) activity).removeProgressDialog();
                    }
                    b bVar2 = this.f52115a;
                    kotlin.g.b.k.b(bVar, "it");
                    b.a(bVar2, bVar, true);
                }
            }
        }
    }

    static final class o<T> implements z<com.business.common_module.utilities.a.b<SettlementBillListModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52116a;

        o(b bVar) {
            this.f52116a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.business.common_module.utilities.a.b bVar = (com.business.common_module.utilities.a.b) obj;
            FragmentActivity activity = this.f52116a.getActivity();
            if (activity != null) {
                kotlin.g.b.k.b(activity, "act");
                if (!activity.isFinishing() && !b.a(this.f52116a).isPaymentsTabSelected().get()) {
                    b bVar2 = this.f52116a;
                    kotlin.g.b.k.b(bVar, "it");
                    b.a(bVar2, bVar);
                }
            }
        }
    }

    static final class r<T> implements z<com.business.common_module.utilities.a.b<TodaySettlementSummaryCardModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52119a;

        r(b bVar) {
            this.f52119a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.business.common_module.utilities.a.b bVar = (com.business.common_module.utilities.a.b) obj;
            FragmentActivity activity = this.f52119a.getActivity();
            if (activity != null) {
                kotlin.g.b.k.b(activity, "act");
                if (!activity.isFinishing() && !b.a(this.f52119a).isPaymentsTabSelected().get() && !ErrorUtil.handleInvalidToken("UMP", bVar.f7356a)) {
                    b bVar2 = this.f52119a;
                    kotlin.g.b.k.b(bVar, "it");
                    b.b(bVar2, bVar);
                }
            }
        }
    }

    public static final /* synthetic */ a a(b bVar) {
        a aVar = bVar.f52096d;
        if (aVar == null) {
            kotlin.g.b.k.a("mViewModel");
        }
        return aVar;
    }

    public static final /* synthetic */ PaymentsViewModel b(b bVar) {
        PaymentsViewModel paymentsViewModel = bVar.f52100h;
        if (paymentsViewModel == null) {
            kotlin.g.b.k.a("paymentsViewModel");
        }
        return paymentsViewModel;
    }

    public static final /* synthetic */ net.one97.paytm.acceptPayment.a.i d(b bVar) {
        net.one97.paytm.acceptPayment.a.i iVar = bVar.f52098f;
        if (iVar == null) {
            kotlin.g.b.k.a("mBinding");
        }
        return iVar;
    }

    public static final /* synthetic */ ArrayList g(b bVar) {
        ArrayList<Object> arrayList = bVar.j;
        if (arrayList == null) {
            kotlin.g.b.k.a("mHomeItemsList");
        }
        return arrayList;
    }

    public static final /* synthetic */ HomeRVAdapter h(b bVar) {
        HomeRVAdapter homeRVAdapter = bVar.f52101i;
        if (homeRVAdapter == null) {
            kotlin.g.b.k.a("mAdapter");
        }
        return homeRVAdapter;
    }

    public static final /* synthetic */ Calendar l(b bVar) {
        Calendar calendar = bVar.p;
        if (calendar == null) {
            kotlin.g.b.k.a("mStartCalendar");
        }
        return calendar;
    }

    public static final /* synthetic */ Calendar m(b bVar) {
        Calendar calendar = bVar.q;
        if (calendar == null) {
            kotlin.g.b.k.a("mEndCalendar");
        }
        return calendar;
    }

    public static final /* synthetic */ CustomCardViewModel s(b bVar) {
        CustomCardViewModel customCardViewModel = bVar.f52099g;
        if (customCardViewModel == null) {
            kotlin.g.b.k.a("customCardViewModel");
        }
        return customCardViewModel;
    }

    public static final /* synthetic */ HomeRVListener y(b bVar) {
        HomeRVListener homeRVListener = bVar.f52097e;
        if (homeRVListener == null) {
            kotlin.g.b.k.a("mHomeRvListener");
        }
        return homeRVListener;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class m extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52113a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f52114b;

        m(b bVar) {
            this.f52113a = bVar;
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            kotlin.g.b.k.d(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            int indexOf = b.g(this.f52113a).indexOf(b.a(this.f52113a).f52089d);
            int indexOf2 = b.g(this.f52113a).indexOf(b.a(this.f52113a).f52090e);
            int i4 = indexOf + 1;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                if (i4 < ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition()) {
                    int i5 = indexOf2 - 2;
                    RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                    if (layoutManager2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    } else if (i5 > ((LinearLayoutManager) layoutManager2).findLastCompletelyVisibleItemPosition()) {
                        b.b(this.f52113a).getGoToTopVisibility().set(true);
                        if (!this.f52114b) {
                            this.f52114b = true;
                            GAGTMTagAnalytics.getSingleInstance().sendEvent(this.f52113a.getContext(), "HomePage", "Payments Scroll to Top", "", "", "Promo Impression", "");
                            return;
                        }
                        return;
                    }
                }
                this.f52114b = false;
                b.b(this.f52113a).getGoToTopVisibility().set(false);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    public static final class p extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52117a;

        p(b bVar) {
            this.f52117a = bVar;
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            kotlin.g.b.k.d(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            kotlin.g.b.k.a((Object) linearLayoutManager);
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            if (!this.f52117a.m && this.f52117a.s && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition > 0) {
                b.x(this.f52117a);
            }
        }
    }

    /* access modifiers changed from: private */
    public final IAcceptPaymentMainActivityListener a() {
        if (getActivity() == null) {
            return null;
        }
        FragmentActivity activity = getActivity();
        kotlin.g.b.k.a((Object) activity);
        kotlin.g.b.k.b(activity, "activity!!");
        if (activity.isFinishing() || !(getActivity() instanceof IAcceptPaymentMainActivityListener)) {
            return null;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            return (IAcceptPaymentMainActivityListener) activity2;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.business.merchant_payments.newhome.listener.IAcceptPaymentMainActivityListener");
    }

    static final class q implements SwipeRefreshLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52118a;

        q(b bVar) {
            this.f52118a = bVar;
        }

        public final void onRefresh() {
            Snackbar c2 = this.f52118a.t;
            if (c2 != null) {
                c2.d();
            }
            this.f52118a.t = null;
            IAcceptPaymentMainActivityListener r = this.f52118a.a();
            if (r != null) {
                r.onRefresh();
            }
            if (b.a(this.f52118a).isPaymentsTabSelected().get()) {
                b.h(this.f52118a).setFirstTransaction(true);
                this.f52118a.b();
                b.a(this.f52118a).f52091f.setMerchantDataUpdated(false);
                GAGTMTagAnalytics.getSingleInstance().sendEvent(this.f52118a.mContext, "HomePage", "Pull to Refersh", "", "Payment");
                return;
            }
            GAGTMTagAnalytics.getSingleInstance().sendEvent(this.f52118a.mContext, "HomePage", "Pull to Refersh", "", "Settlement");
            b.y(this.f52118a).onSettlementTabClick();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 1) {
            String str = null;
            String stringExtra = intent != null ? intent.getStringExtra("intent_extra_selected_start_date") : null;
            if (intent != null) {
                str = intent.getStringExtra("intent_extra_selected_end_date");
            }
            boolean z2 = false;
            if (!(stringExtra == null || kotlin.m.p.a(stringExtra))) {
                if (str == null || kotlin.m.p.a(str)) {
                    z2 = true;
                }
                if (!z2) {
                    a aVar = this.f52096d;
                    if (aVar == null) {
                        kotlin.g.b.k.a("mViewModel");
                    }
                    if (aVar.isPaymentsTabSelected().get()) {
                        a(stringExtra, str);
                        GAGTMTagAnalytics.getSingleInstance().sendEvent(getContext(), "HomePage", "View Past Payments Date Range Selected", "", stringExtra + ";" + str + ";" + String.valueOf(DateUtility.getDaysFromToday("dd MMMM yy", stringExtra)) + ";" + String.valueOf(DateUtility.getDaysFromToday("dd MMMM yy", str)));
                        return;
                    }
                    b(stringExtra, str);
                    return;
                }
            }
            Context context = getContext();
            PaymentsConfig instance = PaymentsConfig.getInstance();
            kotlin.g.b.k.b(instance, "PaymentsConfig.getInstance()");
            Toast.makeText(context, instance.getAppContext().getString(R.string.mp_label_inavlid_date_range_selected_error), 1).show();
        }
    }

    private final void a(String str, String str2) {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            kotlin.g.b.k.a((Object) activity);
            kotlin.g.b.k.b(activity, "activity!!");
            if (!activity.isFinishing()) {
                Intent intent = new Intent(getContext(), PaymentListActivity.class);
                intent.putExtra("startDate", str);
                intent.putExtra("endDate", str2);
                startActivity(intent);
            }
        }
    }

    private final void b(String str, String str2) {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            kotlin.g.b.k.a((Object) activity);
            kotlin.g.b.k.b(activity, "activity!!");
            if (!activity.isFinishing()) {
                Intent intent = new Intent(getContext(), OrderListDateRangeActivityMP.class);
                intent.putExtra("startDate", str);
                intent.putExtra("endDate", str2);
                intent.putExtra("dateRangeType", 1);
                startActivity(intent);
            }
        }
    }

    public final android.view.View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.d(layoutInflater, "inflater");
        net.one97.paytm.acceptPayment.a.i a2 = net.one97.paytm.acceptPayment.a.i.a(layoutInflater, viewGroup);
        kotlin.g.b.k.b(a2, "ApFragmentBinding.inflat…flater, container, false)");
        this.f52098f = a2;
        ai a3 = new al(this).a(a.class);
        kotlin.g.b.k.b(a3, "ViewModelProvider(this).…(APViewModel::class.java)");
        this.f52096d = (a) a3;
        ai a4 = new al(this).a(PaymentsViewModel.class);
        kotlin.g.b.k.b(a4, "ViewModelProvider(this).…ntsViewModel::class.java)");
        this.f52100h = (PaymentsViewModel) a4;
        ai a5 = new al(this).a(CustomCardViewModel.class);
        kotlin.g.b.k.b(a5, "ViewModelProvider(this).…ardViewModel::class.java)");
        this.f52099g = (CustomCardViewModel) a5;
        Context context = getContext();
        if (context != null) {
            this.w = new com.business.common_module.a.a.b((AppCompatActivity) context, new e(this));
            a aVar = this.f52096d;
            if (aVar == null) {
                kotlin.g.b.k.a("mViewModel");
            }
            aVar.getMTodaySettlementSummary().observe(getViewLifecycleOwner(), this.A);
            a aVar2 = this.f52096d;
            if (aVar2 == null) {
                kotlin.g.b.k.a("mViewModel");
            }
            aVar2.getMSettlementBillListModel().observe(getViewLifecycleOwner(), this.z);
            a aVar3 = this.f52096d;
            if (aVar3 == null) {
                kotlin.g.b.k.a("mViewModel");
            }
            aVar3.getMAlreadySettledBillListModel().observe(getViewLifecycleOwner(), this.B);
            a aVar4 = this.f52096d;
            if (aVar4 == null) {
                kotlin.g.b.k.a("mViewModel");
            }
            aVar4.getMPendingSettleListModel().observe(getViewLifecycleOwner(), this.C);
            a aVar5 = this.f52096d;
            if (aVar5 == null) {
                kotlin.g.b.k.a("mViewModel");
            }
            aVar5.getMSelectedSettledBillListDetail().observe(getViewLifecycleOwner(), this.D);
            PaymentsViewModel paymentsViewModel = this.f52100h;
            if (paymentsViewModel == null) {
                kotlin.g.b.k.a("paymentsViewModel");
            }
            paymentsViewModel.getPaymentModelList().observe(getViewLifecycleOwner(), new f(this));
            CustomCardViewModel customCardViewModel = this.f52099g;
            if (customCardViewModel == null) {
                kotlin.g.b.k.a("customCardViewModel");
            }
            customCardViewModel.getCustomCardModelList().observe(getViewLifecycleOwner(), new g(this));
            PaymentsViewModel paymentsViewModel2 = this.f52100h;
            if (paymentsViewModel2 == null) {
                kotlin.g.b.k.a("paymentsViewModel");
            }
            paymentsViewModel2.getRewardPointsBalance().observe(getViewLifecycleOwner(), new h(this));
            a aVar6 = this.f52096d;
            if (aVar6 == null) {
                kotlin.g.b.k.a("mViewModel");
            }
            aVar6.getMStoreFrontAPIResponse().observe(getViewLifecycleOwner(), new i(this));
            a aVar7 = this.f52096d;
            if (aVar7 == null) {
                kotlin.g.b.k.a("mViewModel");
            }
            aVar7.f52091f.getInactiveMerchantData().getUiState().observe(getViewLifecycleOwner(), new j(this));
            this.j = new ArrayList<>();
            this.f52097e = new C0932b();
            IAcceptPaymentMainActivityListener a6 = a();
            if (a6 != null) {
                HomeRVListener homeRVListener = this.f52097e;
                if (homeRVListener == null) {
                    kotlin.g.b.k.a("mHomeRvListener");
                }
                if (homeRVListener != null) {
                    a6.initialiseInactiveMerchantListener((InactiveMerchantListener) homeRVListener);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener");
                }
            }
            Context context2 = getContext();
            kotlin.g.b.k.a((Object) context2);
            kotlin.g.b.k.b(context2, "context!!");
            ArrayList<Object> arrayList = this.j;
            if (arrayList == null) {
                kotlin.g.b.k.a("mHomeItemsList");
            }
            HomeRVListener homeRVListener2 = this.f52097e;
            if (homeRVListener2 == null) {
                kotlin.g.b.k.a("mHomeRvListener");
            }
            a aVar8 = this.f52096d;
            if (aVar8 == null) {
                kotlin.g.b.k.a("mViewModel");
            }
            this.f52101i = new HomeRVAdapter(context2, arrayList, homeRVListener2, aVar8);
            net.one97.paytm.acceptPayment.a.i iVar = this.f52098f;
            if (iVar == null) {
                kotlin.g.b.k.a("mBinding");
            }
            RecyclerView recyclerView = iVar.f51997b;
            kotlin.g.b.k.b(recyclerView, "mBinding.homeRv");
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            net.one97.paytm.acceptPayment.a.i iVar2 = this.f52098f;
            if (iVar2 == null) {
                kotlin.g.b.k.a("mBinding");
            }
            RecyclerView recyclerView2 = iVar2.f51997b;
            kotlin.g.b.k.b(recyclerView2, "mBinding.homeRv");
            HomeRVAdapter homeRVAdapter = this.f52101i;
            if (homeRVAdapter == null) {
                kotlin.g.b.k.a("mAdapter");
            }
            recyclerView2.setAdapter(homeRVAdapter);
            net.one97.paytm.acceptPayment.a.i iVar3 = this.f52098f;
            if (iVar3 == null) {
                kotlin.g.b.k.a("mBinding");
            }
            iVar3.f51997b.setHasFixedSize(true);
            net.one97.paytm.acceptPayment.a.i iVar4 = this.f52098f;
            if (iVar4 == null) {
                kotlin.g.b.k.a("mBinding");
            }
            RecyclerView recyclerView3 = iVar4.f51997b;
            kotlin.g.b.k.b(recyclerView3, "mBinding.homeRv");
            recyclerView3.setItemAnimator(new androidx.recyclerview.widget.g());
            net.one97.paytm.acceptPayment.a.i iVar5 = this.f52098f;
            if (iVar5 == null) {
                kotlin.g.b.k.a("mBinding");
            }
            iVar5.f51997b.addOnScrollListener(this.x);
            net.one97.paytm.acceptPayment.a.i iVar6 = this.f52098f;
            if (iVar6 == null) {
                kotlin.g.b.k.a("mBinding");
            }
            iVar6.f51998c.setOnRefreshListener(this.E);
            a aVar9 = this.f52096d;
            if (aVar9 == null) {
                kotlin.g.b.k.a("mViewModel");
            }
            aVar9.callStoreFrontAPI();
            Bundle arguments = getArguments();
            if (arguments != null) {
                String string = arguments.getString("type");
                if (!(string == null || string.length() == 0)) {
                    if (kotlin.g.b.k.a((Object) arguments.getString("type"), (Object) "SETTLEMENTS")) {
                        HomeRVListener homeRVListener3 = this.f52097e;
                        if (homeRVListener3 == null) {
                            kotlin.g.b.k.a("mHomeRvListener");
                        }
                        homeRVListener3.onSettlementTabClick();
                    } else {
                        a aVar10 = this.f52096d;
                        if (aVar10 == null) {
                            kotlin.g.b.k.a("mViewModel");
                        }
                        aVar10.isPaymentsTabSelected().set(true);
                        b();
                    }
                }
            }
            this.l = true;
            PaymentsConfig.getInstance();
            net.one97.paytm.acceptPayment.a.i iVar7 = this.f52098f;
            if (iVar7 == null) {
                kotlin.g.b.k.a("mBinding");
            }
            android.view.View root = iVar7.getRoot();
            kotlin.g.b.k.b(root, "mBinding.root");
            return root;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    public static final class e implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52105a;

        public final void onCustomDateSelected(String str) {
            kotlin.g.b.k.d(str, "identifier");
        }

        e(b bVar) {
            this.f52105a = bVar;
        }

        public final void onCustomDateSelected(String str, String str2, String str3) {
            kotlin.g.b.k.d(str, "startDate");
            kotlin.g.b.k.d(str2, "endDate");
            kotlin.g.b.k.d(str3, "identifier");
            b.a(this.f52105a, str, str2);
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        a aVar = this.f52096d;
        if (aVar == null) {
            kotlin.g.b.k.a("mViewModel");
        }
        aVar.callStoreFrontAPI();
        IAcceptPaymentMainActivityListener a2 = a();
        if (a2 != null) {
            a2.closeInactiveMerchantBottomSheet();
        }
    }

    @org.greenrobot.eventbus.j(a = ThreadMode.MAIN, b = true)
    public final void onAccountActivationRequest(AccountReactivationRequestEvent accountReactivationRequestEvent) {
        kotlin.g.b.k.d(accountReactivationRequestEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        org.greenrobot.eventbus.c.a().e(accountReactivationRequestEvent);
        a aVar = this.f52096d;
        if (aVar == null) {
            kotlin.g.b.k.a("mViewModel");
        }
        aVar.f52091f.getMerchantAccountState(Boolean.TRUE);
    }

    public final void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.a().b(this);
    }

    private final void a(String str) {
        this.s = false;
        this.n = 1;
        HomeRVAdapter homeRVAdapter = this.f52101i;
        if (homeRVAdapter == null) {
            kotlin.g.b.k.a("mAdapter");
        }
        if (homeRVAdapter.isShimmerShowing()) {
            HomeRVAdapter homeRVAdapter2 = this.f52101i;
            if (homeRVAdapter2 == null) {
                kotlin.g.b.k.a("mAdapter");
            }
            HomeRVAdapter.removeSettlementShimmer$default(homeRVAdapter2, 0, 0, false, kotlin.m.p.a("payments_tab", str, true), 7, (Object) null);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52104a;

        d(b bVar) {
            this.f52104a = bVar;
        }

        public final void onClick(android.view.View view) {
            this.f52104a.E.onRefresh();
            b.h(this.f52104a).resetLastExpandedItemIndex();
        }
    }

    static final class s implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52120a;

        s(b bVar) {
            this.f52120a = bVar;
        }

        public final void onClick(android.view.View view) {
            this.f52120a.s = true;
            this.f52120a.m = true;
            a a2 = b.a(this.f52120a);
            int i2 = this.f52120a.n;
            String format = this.f52120a.o.format(b.l(this.f52120a).getTime());
            kotlin.g.b.k.b(format, "mDateFormat.format(mStartCalendar.time)");
            String format2 = this.f52120a.o.format(b.m(this.f52120a).getTime());
            kotlin.g.b.k.b(format2, "mDateFormat.format(mEndCalendar.time)");
            a2.getSettlementBillList(i2, format, format2, 50);
            Snackbar c2 = this.f52120a.t;
            if (c2 != null) {
                c2.d();
            }
        }
    }

    private final void c() {
        String str;
        if (com.business.common_module.utilities.i.a(PaymentsConfig.getInstance().application)) {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            kotlin.g.b.k.b(instance, "PaymentsConfig.getInstance()");
            str = instance.getAppContext().getString(R.string.mp_oops_something_went_wrong);
        } else {
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            kotlin.g.b.k.b(instance2, "PaymentsConfig.getInstance()");
            str = instance2.getAppContext().getString(R.string.no_internet);
        }
        kotlin.g.b.k.b(str, "if (NetworkUtility.isNet…ing(R.string.no_internet)");
        Toast.makeText(getContext(), str, 1).show();
    }

    public final void onResume() {
        super.onResume();
        if (this.l) {
            this.l = false;
        } else {
            Snackbar snackbar = this.t;
            if (snackbar != null) {
                snackbar.d();
            }
            this.t = null;
            a aVar = this.f52096d;
            if (aVar == null) {
                kotlin.g.b.k.a("mViewModel");
            }
            if (aVar.isPaymentsTabSelected().get()) {
                b();
            } else {
                HomeRVListener homeRVListener = this.f52097e;
                if (homeRVListener == null) {
                    kotlin.g.b.k.a("mHomeRvListener");
                }
                homeRVListener.onSettlementTabClick();
            }
        }
        if (this.f52095c) {
            this.f52095c = false;
            if (net.one97.paytm.acceptPayment.d.a.f52050a.c()) {
                CustomCardViewModel customCardViewModel = this.f52099g;
                if (customCardViewModel == null) {
                    kotlin.g.b.k.a("customCardViewModel");
                }
                customCardViewModel.getCustomCardsInfo();
            }
        }
        if (this.k) {
            this.k = false;
            if (net.one97.paytm.acceptPayment.d.a.f52050a.c()) {
                PaymentsViewModel paymentsViewModel = this.f52100h;
                if (paymentsViewModel == null) {
                    kotlin.g.b.k.a("paymentsViewModel");
                }
                paymentsViewModel.fetchPaymentsData();
            }
        }
    }

    /* renamed from: net.one97.paytm.acceptPayment.home.b$b  reason: collision with other inner class name */
    public final class C0932b implements HomeRVListener, InactiveMerchantListener {
        public final void getAccountReActivationStatus() {
        }

        public final void onCTAClick(CustomCardUIModel customCardUIModel, int i2) {
        }

        public final void onDateRangeDownloadStatementClick() {
        }

        public final void onReactivationFailure() {
        }

        public final void onReactivationInProgress() {
        }

        public final void showInstantSettlementCoachmark(android.view.View view) {
            kotlin.g.b.k.d(view, "itemView");
        }

        public C0932b() {
        }

        public final void onShowMoreClick() {
            if (b.a(b.this).isPaymentsTabSelected().get()) {
                b.b(b.this).handleShowMoreClick();
            }
        }

        public final void onPaymentsTabClick() {
            if (!b.a(b.this).isPaymentsTabSelected().get()) {
                b.a(b.this).isPaymentsTabSelected().set(true);
                b.this.u = false;
                b.this.m = false;
                b.this.s = false;
                b.this.n = 1;
                b.this.r = 0;
                Snackbar c2 = b.this.t;
                if (c2 != null) {
                    c2.d();
                }
                b.d(b.this).f51997b.removeOnScrollListener(b.this.y);
                b.d(b.this).f51997b.addOnScrollListener(b.this.x);
                if (net.one97.paytm.acceptPayment.d.a.f52050a.c()) {
                    b.b(b.this).fetchPaymentsData();
                }
            }
            SwipeRefreshLayout swipeRefreshLayout = b.d(b.this).f51998c;
            kotlin.g.b.k.b(swipeRefreshLayout, "mBinding.homeRvSwipeRefreshLayout");
            swipeRefreshLayout.setRefreshing(false);
        }

        public final void onSettlementTabClick() {
            if (b.a(b.this).isPaymentsTabSelected().get()) {
                b.a(b.this).isPaymentsTabSelected().set(false);
            }
            int indexOf = b.g(b.this).indexOf(b.a(b.this).f52089d);
            int indexOf2 = b.g(b.this).indexOf(b.a(b.this).f52090e);
            b bVar = b.this;
            ArrayList g2 = b.g(bVar);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = g2.iterator();
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.k.a();
                }
                if (i2 > indexOf && i2 < indexOf2) {
                    z = false;
                }
                if (z) {
                    arrayList.add(next);
                }
                i2 = i3;
            }
            bVar.j = arrayList;
            b.d(b.this).f51997b.removeOnScrollListener(b.this.x);
            b.d(b.this).f51997b.addOnScrollListener(b.this.y);
            b.this.m = true;
            b.this.s = true;
            if (b.a(b.this).isBwWalletSettlement()) {
                b bVar2 = b.this;
                Calendar instance = Calendar.getInstance();
                instance.set(11, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                instance.add(5, -31);
                kotlin.g.b.k.b(instance, "Calendar.getInstance().a…H, -31)\n                }");
                bVar2.p = instance;
                b bVar3 = b.this;
                Calendar instance2 = Calendar.getInstance();
                instance2.set(11, 23);
                instance2.set(12, 59);
                instance2.set(13, 59);
                instance2.add(5, -1);
                kotlin.g.b.k.b(instance2, "Calendar.getInstance().a…TH, -1)\n                }");
                bVar3.q = instance2;
            } else {
                b bVar4 = b.this;
                Calendar instance3 = Calendar.getInstance();
                instance3.set(11, 0);
                instance3.set(12, 0);
                instance3.set(13, 0);
                instance3.add(5, -30);
                kotlin.g.b.k.b(instance3, "Calendar.getInstance().a…, -30)\n\n                }");
                bVar4.p = instance3;
                b bVar5 = b.this;
                Calendar instance4 = Calendar.getInstance();
                kotlin.g.b.k.b(instance4, "Calendar.getInstance()");
                bVar5.q = instance4;
            }
            b.h(b.this).resetLastExpandedItemIndex();
            if (!com.business.common_module.utilities.i.a(PaymentsConfig.getInstance().application)) {
                b.this.m = false;
                b.this.s = false;
                SwipeRefreshLayout swipeRefreshLayout = b.d(b.this).f51998c;
                kotlin.g.b.k.b(swipeRefreshLayout, "mBinding.homeRvSwipeRefreshLayout");
                swipeRefreshLayout.setRefreshing(false);
                b.g(b.this).add(indexOf + 1, new GenericErrorModel(new C0933b(this)));
                b.this.v = null;
            } else if (b.a(b.this).isSettlementPermissionPresent() || b.a(b.this).isInstantSettlementPermissionPresent()) {
                b.g(b.this).addAll(indexOf + 1, P4BSettlementsDataHelperMP.INSTANCE.getAdapterDataWithShimmerLayout());
                b.a(b.this).getTodaySettlementSummary();
                a a2 = b.a(b.this);
                int i4 = b.this.n;
                String format = b.this.o.format(b.l(b.this).getTime());
                kotlin.g.b.k.b(format, "mDateFormat.format(mStartCalendar.time)");
                String format2 = b.this.o.format(b.m(b.this).getTime());
                kotlin.g.b.k.b(format2, "mDateFormat.format(mEndCalendar.time)");
                a2.getSettlementBillList(i4, format, format2, 50);
            } else {
                SwipeRefreshLayout swipeRefreshLayout2 = b.d(b.this).f51998c;
                kotlin.g.b.k.b(swipeRefreshLayout2, "mBinding.homeRvSwipeRefreshLayout");
                swipeRefreshLayout2.setRefreshing(false);
                b.this.m = false;
                b.this.s = false;
                if (b.this.getActivity() != null) {
                    FragmentActivity activity = b.this.getActivity();
                    kotlin.g.b.k.a((Object) activity);
                    kotlin.g.b.k.b(activity, "activity!!");
                    if (!activity.isFinishing()) {
                        GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
                        Context context = b.this.getContext();
                        singleInstance.sendEvent(context, "HomePage", "Settlement Widget", "", "No Settlement;" + b.a(b.this).getMMerchantSettlemntTypeGA());
                    }
                }
                b.g(b.this).add(new NoSettlementsDataAdapterModel(R.drawable.mp_no_settlements_permissions, R.string.mp_label_no_seettlements_permissions_text, 8, false));
                b.this.v = null;
            }
            b.h(b.this).updateRVAdapterList(b.g(b.this));
        }

        /* renamed from: net.one97.paytm.acceptPayment.home.b$b$b  reason: collision with other inner class name */
        static final class C0933b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0932b f52103a;

            C0933b(C0932b bVar) {
                this.f52103a = bVar;
            }

            public final void onClick(android.view.View view) {
                this.f52103a.onSettlementTabClick();
            }
        }

        public final void onTransactionItemClick(OrderDetail orderDetail) {
            Intent intent;
            String str;
            kotlin.g.b.k.d(orderDetail, "detail");
            boolean z = true;
            if (kotlin.m.p.a("REFUND", orderDetail.getBizType(), true)) {
                intent = new Intent(b.this.getContext(), RefundDetailsActivity.class);
            } else {
                if (!kotlin.m.p.a(AppConstants.ApiNames.VOID, orderDetail.getBizType(), true) && !kotlin.m.p.a(AppConstants.ApiNames.REVERSAL, orderDetail.getBizType(), true)) {
                    AdditionalInfo additionalInfo = orderDetail.getAdditionalInfo();
                    if (additionalInfo != null) {
                        str = additionalInfo.getCancelRequestType();
                    } else {
                        str = null;
                    }
                    if (str == null || (!kotlin.m.p.a(additionalInfo.getCancelRequestType(), AppConstants.ApiNames.REVERSAL, true) && !kotlin.m.p.a(additionalInfo.getCancelRequestType(), AppConstants.ApiNames.VOID, true))) {
                        z = false;
                    }
                    if (!z) {
                        intent = new Intent(b.this.getContext(), OnlineTxnDetailsActivity.class);
                    }
                }
                intent = new Intent(b.this.getContext(), ReversalDetailsActivity.class);
            }
            intent.putExtra(AppConstants.TRANSACTION_OBJECT_V2, orderDetail);
            FragmentActivity activity = b.this.getActivity();
            if (activity != null) {
                activity.startActivity(intent);
            }
        }

        public final void onToggleCompressState(boolean z, int i2) {
            b.h(b.this).onToggleCompressState(!z, i2);
        }

        public final void onContactUsClick(String str) {
            kotlin.g.b.k.d(str, "phoneNumber");
            GAGTMTagAnalytics.getSingleInstance().sendEvent(b.this.getContext(), "HomePage", "Account Deactivated -> Call MHD Clicked", "", "");
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse("tel: ".concat(String.valueOf(str))));
            b.this.startActivity(intent);
        }

        public final MerchantAccountState getInactivateMerchantData() {
            return b.a(b.this).f52091f.getInactiveMerchantData();
        }

        public final String getHelpLineNumber() {
            return AppUtility.getMHDHelpLineNumber();
        }

        public final void reactivateMerchantAccount() {
            Context context = b.this.getContext();
            if (context != null) {
                PaymentsConfig.getInstance().eventPublisher.a(context, "HomePage", "Account Deactivated - Reactivation CTA Clicked", "", "");
                com.business.common_module.b.c cVar = PaymentsConfig.getInstance().deepLinkUtils;
                StringBuilder sb = new StringBuilder("paytmba://business-app/ump-web?url=");
                sb.append(GTMDataProviderImpl.Companion.getMInstance().getUMPBaseUrl());
                PaymentsConfig instance = PaymentsConfig.getInstance();
                kotlin.g.b.k.b(instance, "PaymentsConfig.getInstance()");
                sb.append(instance.getGTMDataProvider().getString(ProfileGTMConstants.INSTANT_REACTIVATION_REACT_URL, ""));
                cVar.a(context, sb.toString());
            }
        }

        public final void onReactivationSuccessful() {
            b.this.b();
        }

        public final RecyclerView.v getInactivateMerchantViewHolder(ViewGroup viewGroup) {
            kotlin.g.b.k.d(viewGroup, "parent");
            PrPaymentsInActiveMerchantBinding inflate = PrPaymentsInActiveMerchantBinding.inflate(LayoutInflater.from(b.this.mContext), viewGroup, false);
            kotlin.g.b.k.b(inflate, "PrPaymentsInActiveMercha…mContext), parent, false)");
            Context context = b.this.mContext;
            kotlin.g.b.k.b(context, "mContext");
            return new InActiveMerchantViewHolder(context, this, inflate);
        }

        public final boolean isInactiveMerchantData(Object obj) {
            kotlin.g.b.k.d(obj, "data");
            return obj instanceof MerchantAccountState;
        }

        public final void onInactiveMerchantDataChange(AccountActivationState accountActivationState, MerchantAccountActivationUIState merchantAccountActivationUIState) {
            kotlin.g.b.k.d(accountActivationState, "state");
            kotlin.g.b.k.d(merchantAccountActivationUIState, "uiState");
            Job unused = BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.s.a(b.this), Dispatchers.getMain(), (CoroutineStart) null, new a(this, merchantAccountActivationUIState, accountActivationState, (kotlin.d.d) null), 2, (Object) null);
        }

        public final void onCardClosed(CustomCardUIModel customCardUIModel, int i2) {
            if (customCardUIModel != null) {
                b.s(b.this).handleCustomCardClosed(customCardUIModel);
            }
        }

        public final void onCustomCardClick(CustomCardUIModel customCardUIModel, int i2) {
            if (customCardUIModel != null && b.this.getContext() != null && !TextUtils.isEmpty(customCardUIModel.getDeeplink())) {
                com.business.common_module.b.c cVar = PaymentsConfig.getInstance().deepLinkUtils;
                Context context = b.this.getContext();
                kotlin.g.b.k.a((Object) context);
                cVar.a(context, customCardUIModel.getDeeplink());
                b bVar = b.this;
                bVar.f52095c = true;
                b.s(bVar).handleCustomCardClicked(customCardUIModel);
            }
        }

        public final void onSettleNowClick(String str) {
            kotlin.g.b.k.d(str, "amount");
            if (MPConstants.isP4BClient()) {
                Bundle bundle = new Bundle();
                bundle.putString("extras", str);
                bundle.putInt("activity_result_constant", 709);
                new StringBuilder("paytmba://business-app/ump-web?url=").append(GTMDataProviderImpl.Companion.getMInstance().getSettleNowUrl());
                Context context = b.this.getContext();
                if (context != null) {
                    PaymentsConfig.getInstance().deepLinkUtils.a(context);
                    return;
                }
                return;
            }
            String c2 = GTMDataProviderImpl.Companion.getMInstance().getString(PaymentsGTMConstants.AP_SETTLE_NOW_URL, "");
            Context context2 = b.this.getContext();
            if (context2 != null) {
                com.business.common_module.b.c cVar = PaymentsConfig.getInstance().deepLinkUtils;
                cVar.a(context2, "paytmmp://accept_money?featuretype=ump-web&settlementValue=" + str + "&url=" + c2);
            }
        }

        public final void onCarryForwardBalanceClick(LinkedHashMap<String, String> linkedHashMap) {
            kotlin.g.b.k.d(linkedHashMap, "holdAmountMap");
            AmountOnHoldDialogFragment.Companion.newInstance(linkedHashMap).show(b.this.getChildFragmentManager(), "amountOnHoldDialog");
        }

        public final void onDisabledSettleNowInfoClicked() {
            FragmentActivity activity = b.this.getActivity();
            if (activity != null) {
                com.paytm.business.b.a.a.a aVar = new com.paytm.business.b.a.a.a();
                kotlin.g.b.k.b(activity, "it");
                aVar.show(activity.getSupportFragmentManager(), com.paytm.business.b.a.a.a.class.getSimpleName());
            }
        }

        public final void onMDRChangesClick() {
            FragmentActivity activity = b.this.getActivity();
            if (activity != null) {
                CommonOverlayDialogFragment.Companion companion = CommonOverlayDialogFragment.Companion;
                String string = b.this.getString(R.string.mp_label_val_mdr_charges);
                kotlin.g.b.k.b(string, "getString(R.string.mp_label_val_mdr_charges)");
                String string2 = b.this.getString(R.string.mp_label_mdr_description);
                kotlin.g.b.k.b(string2, "getString(R.string.mp_label_mdr_description)");
                String string3 = b.this.getString(R.string.mp_label_mdr_btn_txt);
                kotlin.g.b.k.b(string3, "getString(R.string.mp_label_mdr_btn_txt)");
                companion.newInstance(string, string2, string3, (AcceptPaymentMainActivity) activity).show(b.this.getChildFragmentManager(), "mdrChargesDialog");
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type net.one97.paytm.acceptPayment.home.AcceptPaymentMainActivity");
        }

        public final void onExpandBusinessWalletSummaryCard(boolean z, int i2) {
            FragmentActivity activity = b.this.getActivity();
            if (activity == null) {
                return;
            }
            if (z) {
                b.h(b.this).onAlreadySettledSettlementResponse((ArrayList<M2BOrderListItemModel>) null);
                return;
            }
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).showProgressDialog();
            }
            b.a(b.this).getAlreadySettledBillList(false);
        }

        public final void onExpandBWPendingSummaryCard(boolean z) {
            FragmentActivity activity = b.this.getActivity();
            if (activity == null) {
                return;
            }
            if (z) {
                b.h(b.this).onPendingSettlementResponse((ArrayList<M2BOrderListItemModel>) null);
                return;
            }
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).showProgressDialog();
            }
            b.a(b.this).getAlreadySettledBillList(true);
        }

        public final void onBWSettlementItemClick(boolean z, int i2, SettlementBillListItemModel settlementBillListItemModel) {
            kotlin.g.b.k.d(settlementBillListItemModel, "modelData");
            FragmentActivity activity = b.this.getActivity();
            if (activity != null) {
                kotlin.g.b.k.b(activity, "act");
                if (activity.isFinishing()) {
                    return;
                }
                if (z) {
                    b.h(b.this).onSettlementBillListItemDetailResponse(i2, (ArrayList<M2BOrderListItemModel>) null, (ArrayList<LabelModel>) null);
                    return;
                }
                if (activity instanceof BaseActivity) {
                    ((BaseActivity) activity).showProgressDialog();
                }
                a a2 = b.a(b.this);
                String startDateOfTimeStamp = DateUtility.getStartDateOfTimeStamp(settlementBillListItemModel.getSettlementTime());
                kotlin.g.b.k.b(startDateOfTimeStamp, "DateUtility.getStartDate…modelData.settlementTime)");
                String endDateOfDifferentFormat = DateUtility.getEndDateOfDifferentFormat(settlementBillListItemModel.getSettlementTime(), "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                kotlin.g.b.k.b(endDateOfDifferentFormat, "DateUtility.getEndDateOf…teUtility.V2_TIME_FORMAT)");
                a2.getSettlementBillListDetail(startDateOfTimeStamp, endDateOfDifferentFormat, i2);
            }
        }

        public final void onSettlmentDateRangeClick() {
            FragmentActivity activity = b.this.getActivity();
            if (activity != null) {
                kotlin.g.b.k.b(activity, "it");
                if (!activity.isFinishing()) {
                    a();
                }
            }
        }

        private final void a() {
            SelectDateBottomSheet selectDateBottomSheet = new SelectDateBottomSheet();
            selectDateBottomSheet.setCalenderUtl(b.this.w);
            selectDateBottomSheet.show(b.this.getChildFragmentManager(), SelectDateBottomSheet.class.getSimpleName());
        }

        public final void onDateRangeHeaderBackPressed() {
            FragmentActivity activity = b.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        public final void onViewPastPaymentsClick() {
            a();
        }

        @kotlin.d.b.a.f(b = "AcceptPaymentFragment.kt", c = {870}, d = "invokeSuspend", e = "net.one97.paytm.acceptPayment.home.AcceptPaymentFragment$HomeFragmentRVListener$onInactiveMerchantDataChange$1")
        /* renamed from: net.one97.paytm.acceptPayment.home.b$b$a */
        static final class a extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            final /* synthetic */ AccountActivationState $state;
            final /* synthetic */ MerchantAccountActivationUIState $uiState;
            Object L$0;
            int label;
            private CoroutineScope p$;
            final /* synthetic */ C0932b this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C0932b bVar, MerchantAccountActivationUIState merchantAccountActivationUIState, AccountActivationState accountActivationState, kotlin.d.d dVar) {
                super(2, dVar);
                this.this$0 = bVar;
                this.$uiState = merchantAccountActivationUIState;
                this.$state = accountActivationState;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                kotlin.g.b.k.d(dVar, "completion");
                a aVar = new a(this.this$0, this.$uiState, this.$state, dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                IAcceptPaymentMainActivityListener r;
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.a(obj);
                    this.L$0 = this.p$;
                    this.label = 1;
                    if (DelayKt.delay(100, this) == aVar) {
                        return aVar;
                    }
                } else if (i2 == 1) {
                    ResultKt.a(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if ((this.$uiState instanceof Success) && !(this.$state instanceof MerchantReactivationSuccess) && (r = b.this.a()) != null) {
                    r.showInactiveMerchantBottomSheet();
                }
                return x.f47997a;
            }
        }
    }

    static final class c extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ IAcceptPaymentMainActivityListener $it;
        Object L$0;
        Object L$1;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(IAcceptPaymentMainActivityListener iAcceptPaymentMainActivityListener, kotlin.d.d dVar, b bVar) {
            super(2, dVar);
            this.$it = iAcceptPaymentMainActivityListener;
            this.this$0 = bVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.d(dVar, "completion");
            c cVar = new c(this.$it, dVar, this.this$0);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                Bundle bundle = new Bundle();
                bundle.putString("message", this.this$0.getString(R.string.mp_reactivation_success));
                this.$it.addFragment(HomePageSuccessPopup.class, bundle, 16908290);
                this.L$0 = coroutineScope;
                this.L$1 = bundle;
                this.label = 1;
                if (DelayKt.delay(4000, this) == aVar) {
                    return aVar;
                }
            } else if (i2 == 1) {
                ResultKt.a(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.$it.removeFragment(HomePageSuccessPopup.class);
            return x.f47997a;
        }
    }

    public final void onClose() {
        com.business.common_module.b.j jVar = PaymentsConfig.getInstance().appSharedPreference;
        Context context = getContext();
        kotlin.g.b.k.a((Object) context);
        kotlin.g.b.k.b(context, "context!!");
        PaymentNotificationData value = getData().getValue();
        jVar.a(context, "payment_notification_closed", value != null ? value.getId() : null);
        if (getActivity() instanceof IAcceptPaymentMainActivityListener) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((IAcceptPaymentMainActivityListener) activity).removeFragment(PaymentNotificationFragment.class);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.business.merchant_payments.newhome.listener.IAcceptPaymentMainActivityListener");
            }
        }
        a aVar = this.f52096d;
        if (aVar == null) {
            kotlin.g.b.k.a("mViewModel");
        }
        aVar.getPaymentNotificationData().setValue(null);
    }

    public final void onPaymentNotificationClick() {
        PaymentsTransactionModel paymentsTransactionModel;
        OrderDetail orderDetail;
        com.business.common_module.b.e eVar = PaymentsConfig.getInstance().eventPublisher;
        Context context = getContext();
        kotlin.g.b.k.a((Object) context);
        eVar.a(context, "accept_payments_home", "payment_notification_popup_clicked", "", "");
        PaymentNotificationData value = getData().getValue();
        if (value != null && (paymentsTransactionModel = value.getPaymentsTransactionModel()) != null && (orderDetail = paymentsTransactionModel.getOrderDetail()) != null) {
            HomeRVListener homeRVListener = this.f52097e;
            if (homeRVListener == null) {
                kotlin.g.b.k.a("mHomeRvListener");
            }
            homeRVListener.onTransactionItemClick(orderDetail);
        }
    }

    public final y<PaymentNotificationData> getData() {
        a aVar = this.f52096d;
        if (aVar == null) {
            kotlin.g.b.k.a("mViewModel");
        }
        return aVar.getPaymentNotificationData();
    }

    public final void onDialogButtonClick() {
        com.business.common_module.b.c cVar = PaymentsConfig.getInstance().deepLinkUtils;
        Context context = getContext();
        kotlin.g.b.k.a((Object) context);
        cVar.a(context, "paytmba://business-app/h/limits-and-charges/upgrade-limits");
    }

    public static final /* synthetic */ void a(b bVar, String str, String str2) {
        if (kotlin.m.p.a(str) || kotlin.m.p.a(str2)) {
            Toast.makeText(bVar.getContext(), bVar.getString(R.string.mp_label_inavlid_date_range_selected_error), 0).show();
            return;
        }
        LogUtility.d("home_fragmennt_date", "====>" + str + "===>" + str2);
        a aVar = bVar.f52096d;
        if (aVar == null) {
            kotlin.g.b.k.a("mViewModel");
        }
        if (aVar.isPaymentsTabSelected().get()) {
            bVar.a(str, str2);
            GAGTMTagAnalytics.getSingleInstance().sendEvent(bVar.mContext, "HomePage", "View Past Payments Date Range Selected", "", "", "", str + ";" + str2 + ";" + String.valueOf(DateUtility.getDaysFromToday("dd MMMM yy", str)) + ";" + String.valueOf(DateUtility.getDaysFromToday("dd MMMM yy", str2)));
            return;
        }
        bVar.b(str, str2);
    }

    public static final /* synthetic */ void b(b bVar, ArrayList arrayList) {
        try {
            if (bVar.getActivity() != null) {
                FragmentActivity activity = bVar.getActivity();
                kotlin.g.b.k.a((Object) activity);
                kotlin.g.b.k.b(activity, "activity!!");
                if (!activity.isFinishing()) {
                    a aVar = bVar.f52096d;
                    if (aVar == null) {
                        kotlin.g.b.k.a("mViewModel");
                    }
                    if (aVar.isPaymentsTabSelected().get()) {
                        ArrayList<Object> arrayList2 = bVar.j;
                        if (arrayList2 == null) {
                            kotlin.g.b.k.a("mHomeItemsList");
                        }
                        a aVar2 = bVar.f52096d;
                        if (aVar2 == null) {
                            kotlin.g.b.k.a("mViewModel");
                        }
                        int indexOf = arrayList2.indexOf(aVar2.f52089d);
                        ArrayList<Object> arrayList3 = bVar.j;
                        if (arrayList3 == null) {
                            kotlin.g.b.k.a("mHomeItemsList");
                        }
                        a aVar3 = bVar.f52096d;
                        if (aVar3 == null) {
                            kotlin.g.b.k.a("mViewModel");
                        }
                        int indexOf2 = arrayList3.indexOf(aVar3.f52090e);
                        if (indexOf == -1 || indexOf2 == -1) {
                            LogUtility.d(bVar.f52093a, "Unassigned Payment widget indexes !!");
                            return;
                        }
                        ArrayList<Object> arrayList4 = bVar.j;
                        if (arrayList4 == null) {
                            kotlin.g.b.k.a("mHomeItemsList");
                        }
                        ArrayList<Object> arrayList5 = new ArrayList<>();
                        Iterator<T> it2 = arrayList4.iterator();
                        int i2 = 0;
                        while (true) {
                            boolean z2 = true;
                            if (!it2.hasNext()) {
                                break;
                            }
                            T next = it2.next();
                            int i3 = i2 + 1;
                            if (i2 < 0) {
                                kotlin.a.k.a();
                            }
                            if (i2 > indexOf && i2 < indexOf2) {
                                z2 = false;
                            }
                            if (z2) {
                                arrayList5.add(next);
                            }
                            i2 = i3;
                        }
                        bVar.j = arrayList5;
                        arrayList5.addAll(indexOf + 1, arrayList);
                        HomeRVAdapter homeRVAdapter = bVar.f52101i;
                        if (homeRVAdapter == null) {
                            kotlin.g.b.k.a("mAdapter");
                        }
                        ArrayList<Object> arrayList6 = bVar.j;
                        if (arrayList6 == null) {
                            kotlin.g.b.k.a("mHomeItemsList");
                        }
                        homeRVAdapter.updateRVAdapterList(arrayList6);
                    }
                }
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public static final /* synthetic */ void c(b bVar, ArrayList arrayList) {
        try {
            if (bVar.getActivity() != null) {
                FragmentActivity activity = bVar.getActivity();
                kotlin.g.b.k.a((Object) activity);
                kotlin.g.b.k.b(activity, "activity!!");
                if (!activity.isFinishing()) {
                    ArrayList<Object> arrayList2 = bVar.j;
                    if (arrayList2 == null) {
                        kotlin.g.b.k.a("mHomeItemsList");
                    }
                    a aVar = bVar.f52096d;
                    if (aVar == null) {
                        kotlin.g.b.k.a("mViewModel");
                    }
                    int indexOf = arrayList2.indexOf(aVar.f52087b);
                    ArrayList<Object> arrayList3 = bVar.j;
                    if (arrayList3 == null) {
                        kotlin.g.b.k.a("mHomeItemsList");
                    }
                    a aVar2 = bVar.f52096d;
                    if (aVar2 == null) {
                        kotlin.g.b.k.a("mViewModel");
                    }
                    int indexOf2 = arrayList3.indexOf(aVar2.f52088c);
                    if (indexOf == -1 || indexOf2 == -1) {
                        LogUtility.d(bVar.f52093a, "Unassigned Custom card widget indexes !!");
                        return;
                    }
                    ArrayList<Object> arrayList4 = bVar.j;
                    if (arrayList4 == null) {
                        kotlin.g.b.k.a("mHomeItemsList");
                    }
                    ArrayList<Object> arrayList5 = new ArrayList<>();
                    Iterator<T> it2 = arrayList4.iterator();
                    int i2 = 0;
                    while (true) {
                        boolean z2 = true;
                        if (!it2.hasNext()) {
                            break;
                        }
                        T next = it2.next();
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            kotlin.a.k.a();
                        }
                        if (i2 > indexOf && i2 < indexOf2) {
                            z2 = false;
                        }
                        if (z2) {
                            arrayList5.add(next);
                        }
                        i2 = i3;
                    }
                    bVar.j = arrayList5;
                    arrayList5.addAll(indexOf + 1, arrayList);
                    HomeRVAdapter homeRVAdapter = bVar.f52101i;
                    if (homeRVAdapter == null) {
                        kotlin.g.b.k.a("mAdapter");
                    }
                    ArrayList<Object> arrayList6 = bVar.j;
                    if (arrayList6 == null) {
                        kotlin.g.b.k.a("mHomeItemsList");
                    }
                    homeRVAdapter.updateRVAdapterList(arrayList6);
                }
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public static final /* synthetic */ void a(b bVar, RewardsBalance rewardsBalance) {
        FragmentActivity activity = bVar.getActivity();
        if (activity != null && (activity instanceof IAcceptPaymentMainActivityListener)) {
            String activeBalance = rewardsBalance.getActiveBalance();
            if (!(activeBalance == null || activeBalance.length() == 0)) {
                String activeBalance2 = rewardsBalance.getActiveBalance();
                kotlin.g.b.k.a((Object) activeBalance2);
                ((IAcceptPaymentMainActivityListener) activity).updateRewardPoints(activeBalance2);
                return;
            }
            ((IAcceptPaymentMainActivityListener) activity).updateRewardPoints("--");
        }
    }

    public static final /* synthetic */ void a(b bVar, List list, SanitizedResponseModel sanitizedResponseModel) {
        HashSet<String> duplicateIdMap;
        try {
            if (bVar.getActivity() != null) {
                FragmentActivity activity = bVar.getActivity();
                kotlin.g.b.k.a((Object) activity);
                kotlin.g.b.k.b(activity, "activity!!");
                if (!activity.isFinishing()) {
                    if (!(list == null || list.isEmpty())) {
                        a aVar = bVar.f52096d;
                        if (aVar == null) {
                            kotlin.g.b.k.a("mViewModel");
                        }
                        ArrayList<Object> a2 = aVar.a((List<? extends com.paytmmall.clpartifact.modal.clpCommon.View>) list);
                        ArrayList<Object> arrayList = bVar.j;
                        if (arrayList == null) {
                            kotlin.g.b.k.a("mHomeItemsList");
                        }
                        arrayList.clear();
                        ArrayList<Object> arrayList2 = bVar.j;
                        if (arrayList2 == null) {
                            kotlin.g.b.k.a("mHomeItemsList");
                        }
                        arrayList2.addAll(a2);
                        if (!PaymentsConfig.getInstance().merchantDataProvider.c()) {
                            ArrayList<Object> arrayList3 = bVar.j;
                            if (arrayList3 == null) {
                                kotlin.g.b.k.a("mHomeItemsList");
                            }
                            a aVar2 = bVar.f52096d;
                            if (aVar2 == null) {
                                kotlin.g.b.k.a("mViewModel");
                            }
                            int indexOf = arrayList3.indexOf(aVar2.f52089d);
                            ArrayList<Object> arrayList4 = bVar.j;
                            if (arrayList4 == null) {
                                kotlin.g.b.k.a("mHomeItemsList");
                            }
                            a aVar3 = bVar.f52096d;
                            if (aVar3 == null) {
                                kotlin.g.b.k.a("mViewModel");
                            }
                            int indexOf2 = arrayList4.indexOf(aVar3.f52090e);
                            if (!(indexOf == -1 || indexOf2 == -1)) {
                                ArrayList<Object> arrayList5 = bVar.j;
                                if (arrayList5 == null) {
                                    kotlin.g.b.k.a("mHomeItemsList");
                                }
                                ArrayList<Object> arrayList6 = new ArrayList<>();
                                int i2 = 0;
                                for (T next : arrayList5) {
                                    int i3 = i2 + 1;
                                    if (i2 < 0) {
                                        kotlin.a.k.a();
                                    }
                                    if (i2 <= indexOf || i2 >= indexOf2) {
                                        arrayList6.add(next);
                                    }
                                    i2 = i3;
                                }
                                bVar.j = arrayList6;
                                int i4 = indexOf + 1;
                                a aVar4 = bVar.f52096d;
                                if (aVar4 == null) {
                                    kotlin.g.b.k.a("mViewModel");
                                }
                                arrayList6.add(i4, aVar4.f52091f.getInactiveMerchantData());
                            }
                        }
                        HomeRVAdapter homeRVAdapter = bVar.f52101i;
                        if (homeRVAdapter == null) {
                            kotlin.g.b.k.a("mAdapter");
                        }
                        ArrayList<Object> arrayList7 = bVar.j;
                        if (arrayList7 == null) {
                            kotlin.g.b.k.a("mHomeItemsList");
                        }
                        homeRVAdapter.updateRVAdapterList(arrayList7);
                        net.one97.paytm.acceptPayment.a.i iVar = bVar.f52098f;
                        if (iVar == null) {
                            kotlin.g.b.k.a("mBinding");
                        }
                        SwipeRefreshLayout swipeRefreshLayout = iVar.f51998c;
                        kotlin.g.b.k.b(swipeRefreshLayout, "mBinding.homeRvSwipeRefreshLayout");
                        swipeRefreshLayout.setRefreshing(false);
                        HomeRVAdapter homeRVAdapter2 = bVar.f52101i;
                        if (homeRVAdapter2 == null) {
                            kotlin.g.b.k.a("mAdapter");
                        }
                        if (homeRVAdapter2.getMGAListener() == null) {
                            HomeRVAdapter homeRVAdapter3 = bVar.f52101i;
                            if (homeRVAdapter3 == null) {
                                kotlin.g.b.k.a("mAdapter");
                            }
                            homeRVAdapter3.setMGAListener(sanitizedResponseModel.getGaListener());
                        } else {
                            HomeRVAdapter homeRVAdapter4 = bVar.f52101i;
                            if (homeRVAdapter4 == null) {
                                kotlin.g.b.k.a("mAdapter");
                            }
                            StoreFrontGAHandler mGAListener = homeRVAdapter4.getMGAListener();
                            if (!(mGAListener == null || (duplicateIdMap = mGAListener.getDuplicateIdMap()) == null)) {
                                duplicateIdMap.clear();
                            }
                        }
                        if (net.one97.paytm.acceptPayment.d.a.f52050a.c()) {
                            PaymentsViewModel paymentsViewModel = bVar.f52100h;
                            if (paymentsViewModel == null) {
                                kotlin.g.b.k.a("paymentsViewModel");
                            }
                            paymentsViewModel.fetchPaymentsData();
                            if (PaymentsConfig.getInstance().merchantDataProvider.c()) {
                                a aVar5 = bVar.f52096d;
                                if (aVar5 == null) {
                                    kotlin.g.b.k.a("mViewModel");
                                }
                                if (MerchantAccountStateManager.isAccountReactivationPending$default(aVar5.f52091f, (Boolean) null, 1, (Object) null)) {
                                    a aVar6 = bVar.f52096d;
                                    if (aVar6 == null) {
                                        kotlin.g.b.k.a("mViewModel");
                                    }
                                    aVar6.f52091f.isAccountReactivationPending(Boolean.FALSE);
                                    IAcceptPaymentMainActivityListener a3 = bVar.a();
                                    if (a3 != null) {
                                        androidx.lifecycle.q viewLifecycleOwner = bVar.getViewLifecycleOwner();
                                        kotlin.g.b.k.b(viewLifecycleOwner, "viewLifecycleOwner");
                                        Job unused = BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.s.a(viewLifecycleOwner), Dispatchers.getMain(), (CoroutineStart) null, new c(a3, (kotlin.d.d) null, bVar), 2, (Object) null);
                                    }
                                }
                            }
                        } else {
                            a aVar7 = bVar.f52096d;
                            if (aVar7 == null) {
                                kotlin.g.b.k.a("mViewModel");
                            }
                            MerchantAccountStateManager.getMerchantAccountState$default(aVar7.f52091f, (Boolean) null, 1, (Object) null);
                        }
                        if (net.one97.paytm.acceptPayment.d.a.f52050a.c()) {
                            CustomCardViewModel customCardViewModel = bVar.f52099g;
                            if (customCardViewModel == null) {
                                kotlin.g.b.k.a("customCardViewModel");
                            }
                            customCardViewModel.getCustomCardsInfo();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public static final /* synthetic */ void x(b bVar) {
        HomeRVAdapter homeRVAdapter = bVar.f52101i;
        if (homeRVAdapter == null) {
            kotlin.g.b.k.a("mAdapter");
        }
        if (!homeRVAdapter.isShimmerShowing()) {
            HomeRVAdapter homeRVAdapter2 = bVar.f52101i;
            if (homeRVAdapter2 == null) {
                kotlin.g.b.k.a("mAdapter");
            }
            homeRVAdapter2.addLoadingFooter();
        }
        bVar.m = true;
        a aVar = bVar.f52096d;
        if (aVar == null) {
            kotlin.g.b.k.a("mViewModel");
        }
        int i2 = bVar.n;
        SimpleDateFormat simpleDateFormat = bVar.o;
        Calendar calendar = bVar.p;
        if (calendar == null) {
            kotlin.g.b.k.a("mStartCalendar");
        }
        String format = simpleDateFormat.format(calendar.getTime());
        kotlin.g.b.k.b(format, "mDateFormat.format(mStartCalendar.time)");
        SimpleDateFormat simpleDateFormat2 = bVar.o;
        Calendar calendar2 = bVar.q;
        if (calendar2 == null) {
            kotlin.g.b.k.a("mEndCalendar");
        }
        String format2 = simpleDateFormat2.format(calendar2.getTime());
        kotlin.g.b.k.b(format2, "mDateFormat.format(mEndCalendar.time)");
        aVar.getSettlementBillList(i2, format, format2, 50);
    }

    public static final /* synthetic */ void a(b bVar, com.business.common_module.utilities.a.b bVar2) {
        String str;
        net.one97.paytm.acceptPayment.a.i iVar = bVar.f52098f;
        if (iVar == null) {
            kotlin.g.b.k.a("mBinding");
        }
        SwipeRefreshLayout swipeRefreshLayout = iVar.f51998c;
        kotlin.g.b.k.b(swipeRefreshLayout, "mBinding.homeRvSwipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(false);
        bVar.m = false;
        HomeRVAdapter homeRVAdapter = bVar.f52101i;
        if (homeRVAdapter == null) {
            kotlin.g.b.k.a("mAdapter");
        }
        homeRVAdapter.removeLoadingFooter();
        String str2 = bVar.v;
        ArrayList<SettlementBillListItemModel> arrayList = null;
        bVar.v = null;
        if (bVar2.f7357b == com.business.common_module.utilities.a.e.SUCCESS) {
            SettlementBillListModel settlementBillListModel = (SettlementBillListModel) bVar2.f7358c;
            if (settlementBillListModel != null) {
                arrayList = settlementBillListModel.getSettlementBillList();
            }
            if (arrayList == null || arrayList.size() <= 0) {
                bVar.a(str2);
                return;
            }
            HomeRVAdapter homeRVAdapter2 = bVar.f52101i;
            if (homeRVAdapter2 == null) {
                kotlin.g.b.k.a("mAdapter");
            }
            HomeRVAdapter.addSettlements$default(homeRVAdapter2, arrayList, false, kotlin.m.p.a("payments_tab", str2, true), 2, (Object) null);
            if (arrayList.size() == 50) {
                bVar.n++;
            } else {
                bVar.a(str2);
            }
        } else if (!ErrorUtil.handleInvalidToken(bVar2.f7356a)) {
            bVar.s = false;
            HomeRVAdapter homeRVAdapter3 = bVar.f52101i;
            if (homeRVAdapter3 == null) {
                kotlin.g.b.k.a("mAdapter");
            }
            if (homeRVAdapter3.isShimmerShowing()) {
                HomeRVAdapter homeRVAdapter4 = bVar.f52101i;
                if (homeRVAdapter4 == null) {
                    kotlin.g.b.k.a("mAdapter");
                }
                homeRVAdapter4.showErrorUI(0, new d(bVar));
                return;
            }
            net.one97.paytm.acceptPayment.a.i iVar2 = bVar.f52098f;
            if (iVar2 == null) {
                kotlin.g.b.k.a("mBinding");
            }
            CoordinatorLayout coordinatorLayout = iVar2.f51999d;
            if (com.business.common_module.utilities.i.a(PaymentsConfig.getInstance().application)) {
                PaymentsConfig instance = PaymentsConfig.getInstance();
                kotlin.g.b.k.b(instance, "PaymentsConfig.getInstance()");
                str = instance.getAppContext().getString(R.string.mp_oops_something_went_wrong);
            } else {
                PaymentsConfig instance2 = PaymentsConfig.getInstance();
                kotlin.g.b.k.b(instance2, "PaymentsConfig.getInstance()");
                str = instance2.getAppContext().getString(R.string.no_internet);
            }
            Snackbar a2 = Snackbar.a((android.view.View) coordinatorLayout, (CharSequence) str, -2);
            PaymentsConfig instance3 = PaymentsConfig.getInstance();
            kotlin.g.b.k.b(instance3, "PaymentsConfig.getInstance()");
            Snackbar a3 = a2.a((CharSequence) instance3.getAppContext().getString(R.string.retry), (View.OnClickListener) new s(bVar));
            bVar.t = a3;
            a3.c();
        }
    }

    public static final /* synthetic */ void b(b bVar, com.business.common_module.utilities.a.b bVar2) {
        net.one97.paytm.acceptPayment.a.i iVar = bVar.f52098f;
        if (iVar == null) {
            kotlin.g.b.k.a("mBinding");
        }
        SwipeRefreshLayout swipeRefreshLayout = iVar.f51998c;
        kotlin.g.b.k.b(swipeRefreshLayout, "mBinding.homeRvSwipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(false);
        com.business.common_module.utilities.a.e eVar = bVar2.f7357b;
        kotlin.g.b.k.b(eVar, "response.status");
        Object summaryCardModel = P4BSettlementsDataHelperMP.INSTANCE.getSummaryCardModel((TodaySettlementSummaryCardModel) bVar2.f7358c, eVar);
        if (summaryCardModel instanceof BWSettlementCardSummaryAdapterModel) {
            BWSettlementCardSummaryAdapterModel bWSettlementCardSummaryAdapterModel = (BWSettlementCardSummaryAdapterModel) summaryCardModel;
            PaymentsConfig instance = PaymentsConfig.getInstance();
            kotlin.g.b.k.b(instance, "PaymentsConfig.getInstance()");
            boolean shouldShowSettlementToolTip = com.business.merchant_payments.common.utility.AppUtility.shouldShowSettlementToolTip(instance.getAppContext());
            if (shouldShowSettlementToolTip) {
                bWSettlementCardSummaryAdapterModel.setShouldShowSettlementToolTip(true);
                PaymentsConfig instance2 = PaymentsConfig.getInstance();
                kotlin.g.b.k.b(instance2, "PaymentsConfig.getInstance()");
                com.business.merchant_payments.common.utility.AppUtility.onShowSettlementToolTip(instance2.getAppContext());
            } else if (bVar.u) {
                bWSettlementCardSummaryAdapterModel.setShouldShowSettlementToolTip(true);
                shouldShowSettlementToolTip = true;
            } else {
                bWSettlementCardSummaryAdapterModel.setShouldShowSettlementToolTip(false);
            }
            bVar.u = shouldShowSettlementToolTip;
        }
        HomeRVAdapter homeRVAdapter = bVar.f52101i;
        if (homeRVAdapter == null) {
            kotlin.g.b.k.a("mAdapter");
        }
        homeRVAdapter.updateSettlementSummary(summaryCardModel);
    }

    public static final /* synthetic */ void a(b bVar, com.business.common_module.utilities.a.b bVar2, boolean z2) {
        com.business.common_module.utilities.a.e eVar = bVar2.f7357b;
        if (eVar == null || c.f52121a[eVar.ordinal()] != 1) {
            bVar.c();
            return;
        }
        SettlementBillListDetailModel settlementBillListDetailModel = (SettlementBillListDetailModel) bVar2.f7358c;
        if (settlementBillListDetailModel != null) {
            M2BModel m2b = settlementBillListDetailModel.getM2b();
            ArrayList<M2BOrderListItemModel> arrayList = null;
            if ((m2b != null ? m2b.getOrderList() : null) == null) {
                return;
            }
            if (z2) {
                HomeRVAdapter homeRVAdapter = bVar.f52101i;
                if (homeRVAdapter == null) {
                    kotlin.g.b.k.a("mAdapter");
                }
                M2BModel m2b2 = settlementBillListDetailModel.getM2b();
                if (m2b2 != null) {
                    arrayList = m2b2.getOrderList();
                }
                kotlin.g.b.k.a((Object) arrayList);
                homeRVAdapter.onPendingSettlementResponse(arrayList);
                return;
            }
            HomeRVAdapter homeRVAdapter2 = bVar.f52101i;
            if (homeRVAdapter2 == null) {
                kotlin.g.b.k.a("mAdapter");
            }
            M2BModel m2b3 = settlementBillListDetailModel.getM2b();
            if (m2b3 != null) {
                arrayList = m2b3.getOrderList();
            }
            kotlin.g.b.k.a((Object) arrayList);
            homeRVAdapter2.onAlreadySettledSettlementResponse(arrayList);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        r1 = r1.getM2b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.acceptPayment.home.b r3, com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel r4) {
        /*
            com.business.common_module.utilities.a.b r0 = r4.getWrappedData()
            com.business.common_module.utilities.a.e r1 = r0.f7357b
            if (r1 == 0) goto L_0x0048
            int[] r2 = net.one97.paytm.acceptPayment.home.c.f52122b
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L_0x0014
            goto L_0x0048
        L_0x0014:
            com.business.merchant_payments.newhome.HomeRVAdapter r3 = r3.f52101i
            if (r3 != 0) goto L_0x001d
            java.lang.String r1 = "mAdapter"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x001d:
            int r4 = r4.getPosition()
            T r1 = r0.f7358c
            com.business.merchant_payments.settlement.model.SettlementBillListDetailModel r1 = (com.business.merchant_payments.settlement.model.SettlementBillListDetailModel) r1
            r2 = 0
            if (r1 == 0) goto L_0x0033
            com.business.merchant_payments.settlement.model.M2BModel r1 = r1.getM2b()
            if (r1 == 0) goto L_0x0033
            java.util.ArrayList r1 = r1.getOrderList()
            goto L_0x0034
        L_0x0033:
            r1 = r2
        L_0x0034:
            T r0 = r0.f7358c
            com.business.merchant_payments.settlement.model.SettlementBillListDetailModel r0 = (com.business.merchant_payments.settlement.model.SettlementBillListDetailModel) r0
            if (r0 == 0) goto L_0x0044
            com.business.merchant_payments.settlement.model.SettlementAmountDetailsModel r0 = r0.getAmountDetails()
            if (r0 == 0) goto L_0x0044
            java.util.ArrayList r2 = r0.getSettlementAmountDetails()
        L_0x0044:
            r3.onSettlementBillListItemDetailResponse(r4, r1, r2)
            return
        L_0x0048:
            r3.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.home.b.a(net.one97.paytm.acceptPayment.home.b, com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.F;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

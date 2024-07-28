package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.localbroadcastmanager.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.w;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.FetchOptionsRequest;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.MandateAccountDetails;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.SavedMandateBanksItem;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.instruments.InstrumentListeneres;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.InstrumentsSelectionManager;
import net.one97.paytm.nativesdk.instruments.InstrumentsSelectionManagerImpl;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.cod.view.CodView;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.DebitCreditCreditCardsView;
import net.one97.paytm.nativesdk.instruments.emi.view.EmiView;
import net.one97.paytm.nativesdk.instruments.netbanking.view.NetBankingView;
import net.one97.paytm.nativesdk.instruments.savedCard.view.SavedCardView;
import net.one97.paytm.nativesdk.instruments.upicollect.view.UpiCollectViewNew;
import net.one97.paytm.nativesdk.instruments.upionboarding.UpiOnboardingView;
import net.one97.paytm.nativesdk.instruments.upipush.view.UpiPushView;
import net.one97.paytm.nativesdk.instruments.wallet.view.WalletView;
import net.one97.paytm.nativesdk.paymethods.listeners.CashierInstrumentListner;
import net.one97.paytm.nativesdk.paymethods.listeners.OnBottomSheetChangeListener;
import net.one97.paytm.nativesdk.paymethods.model.PaymentInstrumentView;

public abstract class BaseInstrumentSheet extends h implements CashierInstrumentListner, OnBottomSheetChangeListener {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "BaseInstrumentSheet";
    private HashMap _$_findViewCache;
    private final BroadcastReceiver broadcastReceiver = new BaseInstrumentSheet$broadcastReceiver$1(this);
    /* access modifiers changed from: private */
    public CashierInstrumentCom cashierInstrumentCom;
    private PaymentModes codPayMode;
    private int codViewPosition;
    private int emiViewPosition;
    private PaytmBaseView giftVoucher;
    private boolean initialized = true;
    public Instruments instruments;
    /* access modifiers changed from: private */
    public ArrayList<PaytmBaseView> instrumentsBaseView = new ArrayList<>();
    private boolean isWalletValid;
    private Context mContext;
    private InstrumentsSelectionManager mInstrumentsSelectionManager;
    private boolean pendingInstrumentSelection;
    private PaytmBaseView walletView;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public abstract void addPaymentInstruments(boolean z);

    public abstract void addViewInScrollView(View view, boolean z);

    public abstract void fetchAllPaymentOffers(CJPayMethodResponse cJPayMethodResponse);

    public abstract void hideBankOfferStrip();

    public abstract NestedScrollView provideScrollView();

    public abstract void removeAllViews();

    public abstract void sendGAEvent();

    public abstract void showHiddenInstruments();

    public abstract void updateTotalAmount(String str);

    public final PaymentModes getCodPayMode() {
        return this.codPayMode;
    }

    public final void setCodPayMode(PaymentModes paymentModes) {
        this.codPayMode = paymentModes;
    }

    public final Instruments getInstruments() {
        Instruments instruments2 = this.instruments;
        if (instruments2 == null) {
            k.a("instruments");
        }
        return instruments2;
    }

    public final void setInstruments(Instruments instruments2) {
        k.c(instruments2, "<set-?>");
        this.instruments = instruments2;
    }

    public final PaytmBaseView getWalletView() {
        return this.walletView;
    }

    public final void setWalletView(PaytmBaseView paytmBaseView) {
        this.walletView = paytmBaseView;
    }

    /* access modifiers changed from: protected */
    public final boolean getPendingInstrumentSelection() {
        return this.pendingInstrumentSelection;
    }

    /* access modifiers changed from: protected */
    public final void setPendingInstrumentSelection(boolean z) {
        this.pendingInstrumentSelection = z;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cashierInstrumentCom = new CashierInstrumentCom();
        this.instruments = new Instruments(this.cashierInstrumentCom);
        Context appContext = PaytmSDK.getAppContext();
        if (appContext != null) {
            InstrumentsSelectionManagerImpl instrumentsSelectionManagerImpl = new InstrumentsSelectionManagerImpl((Application) appContext, w.INSTANCE);
            this.mInstrumentsSelectionManager = instrumentsSelectionManagerImpl;
            getLifecycle().a(instrumentsSelectionManagerImpl);
            InstrumentsSelectionManager instrumentsSelectionManager = this.mInstrumentsSelectionManager;
            if (instrumentsSelectionManager == null) {
                k.a("mInstrumentsSelectionManager");
            }
            instrumentsSelectionManager.registerCallback(new BaseInstrumentSheet$onCreate$1(this));
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(SDKConstants.EMI_REFRESH_FILTER);
            intentFilter.addAction(SDKConstants.TOOLBAR_AMOUNT_REFRESH);
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            a.a(context.getApplicationContext()).a(this.broadcastReceiver, intentFilter);
            StringBuilder sb = new StringBuilder("mid: ");
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            sb.append(merchantInstance.getMid());
            SDKUtility.dropBreadCrumbs(TAG, sb.toString());
            StringBuilder sb2 = new StringBuilder("orderId: ");
            MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
            sb2.append(merchantInstance2.getOrderId());
            SDKUtility.dropBreadCrumbs(TAG, sb2.toString());
            return;
        }
        throw new u("null cannot be cast to non-null type android.app.Application");
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        this.mContext = context;
    }

    public void onDetach() {
        super.onDetach();
        this.mContext = null;
    }

    public void onStop() {
        super.onStop();
        if (!this.instrumentsBaseView.isEmpty()) {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.UNREGISTER_BROADCAST_PBP);
            if (getContext() != null) {
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                a.a(context.getApplicationContext()).a(this.broadcastReceiver);
            }
            if (getContext() != null) {
                Context context2 = getContext();
                if (context2 == null) {
                    k.a();
                }
                k.a((Object) context2, "context!!");
                a.a(context2.getApplicationContext()).a(intent);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.UNREGISTER_BROADCAST);
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            a.a(context.getApplicationContext()).a(intent);
        } catch (NullPointerException e2) {
            LogUtility.e("InstrumentSheet", e2.toString());
        }
        int size = this.instrumentsBaseView.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.instrumentsBaseView.get(i2).onDestroy();
        }
        this.cashierInstrumentCom = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        PaytmBaseView paytmBaseView = this.walletView;
        if (!(paytmBaseView == null || paytmBaseView == null)) {
            paytmBaseView.onDestroy();
        }
        _$_clearFindViewByIdCache();
    }

    /* access modifiers changed from: protected */
    public final BroadcastReceiver getBroadcastReceiver() {
        return this.broadcastReceiver;
    }

    public final void toggleCODView(PaymentModes paymentModes) {
        k.c(paymentModes, "modes");
        boolean showCOD = toShowCOD(paymentModes);
        int i2 = this.codViewPosition;
        if (i2 >= 0 && i2 < this.instrumentsBaseView.size()) {
            PaytmBaseView paytmBaseView = this.instrumentsBaseView.get(this.codViewPosition);
            k.a((Object) paytmBaseView, "instrumentsBaseView[codViewPosition]");
            PaytmBaseView paytmBaseView2 = paytmBaseView;
            if (paytmBaseView2 != null && (paytmBaseView2 instanceof CodView)) {
                if (showCOD) {
                    View view = ((CodView) paytmBaseView2).getView();
                    k.a((Object) view, "paytmBaseView.view");
                    view.setVisibility(0);
                    return;
                }
                View view2 = ((CodView) paytmBaseView2).getView();
                k.a((Object) view2, "paytmBaseView.view");
                view2.setVisibility(8);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0051 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean toShowCOD(net.one97.paytm.nativesdk.common.model.PaymentModes r7) {
        /*
            r6 = this;
            double r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.getDiffAmount()
            java.util.ArrayList r2 = r7.getPayChannelOptions()
            r3 = 0
            if (r2 == 0) goto L_0x0049
            java.util.ArrayList r2 = r7.getPayChannelOptions()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0049
            java.util.ArrayList r2 = r7.getPayChannelOptions()
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r4 = "merchantPayMethod.payChannelOptions[0]"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            net.one97.paytm.nativesdk.common.model.PayChannelOptions r2 = (net.one97.paytm.nativesdk.common.model.PayChannelOptions) r2
            net.one97.paytm.nativesdk.common.model.MinAmount r2 = r2.getMinAmount()
            if (r2 == 0) goto L_0x0049
            java.util.ArrayList r7 = r7.getPayChannelOptions()
            java.lang.Object r7 = r7.get(r3)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            net.one97.paytm.nativesdk.common.model.PayChannelOptions r7 = (net.one97.paytm.nativesdk.common.model.PayChannelOptions) r7
            net.one97.paytm.nativesdk.common.model.MinAmount r7 = r7.getMinAmount()
            java.lang.String r2 = "merchantPayMethod.payChannelOptions[0].minAmount"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            java.lang.String r7 = r7.getValue()
            double r4 = net.one97.paytm.nativesdk.Utils.SDKUtility.parseDouble(r7)
            goto L_0x004b
        L_0x0049:
            r4 = 0
        L_0x004b:
            int r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x0051
            r7 = 1
            return r7
        L_0x0051:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet.toShowCOD(net.one97.paytm.nativesdk.common.model.PaymentModes):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        if (java.lang.Double.parseDouble(r0) < 1.0d) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0081, code lost:
        if (r0.isPaytmWalletChecked() == false) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a6, code lost:
        if (r0.isPaytmWalletChecked() != false) goto L_0x00a8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openAutoInstrument() {
        /*
            r7 = this;
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r1 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            boolean r0 = r0.isWalletEnabledOnMerchant()
            r2 = 0
            if (r0 == 0) goto L_0x005e
            boolean r0 = r7.isWalletValid
            if (r0 == 0) goto L_0x005e
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            boolean r0 = r0.isWalletAmountSufficientToPay()
            if (r0 != 0) goto L_0x005e
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            boolean r0 = r0.isPaytmWalletChecked()
            if (r0 != 0) goto L_0x0047
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            net.one97.paytm.nativesdk.Utils.PayMethodType r3 = net.one97.paytm.nativesdk.Utils.PayMethodType.BALANCE
            java.lang.String r0 = r0.getInstrumentBalance(r3)
            if (r0 != 0) goto L_0x003d
            kotlin.g.b.k.a()
        L_0x003d:
            double r3 = java.lang.Double.parseDouble(r0)
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x005e
        L_0x0047:
            java.util.ArrayList<net.one97.paytm.nativesdk.instruments.PaytmBaseView> r0 = r7.instrumentsBaseView
            if (r0 == 0) goto L_0x00d3
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00d3
            java.util.ArrayList<net.one97.paytm.nativesdk.instruments.PaytmBaseView> r0 = r7.instrumentsBaseView
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.nativesdk.instruments.PaytmBaseView r0 = (net.one97.paytm.nativesdk.instruments.PaytmBaseView) r0
            r0.openAutoInstrument()
            goto L_0x00d3
        L_0x005e:
            boolean r0 = r7.isWalletValid
            if (r0 == 0) goto L_0x00be
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.getPaymentFlowAvailable()
            r3 = 1
            java.lang.String r4 = "ADDANDPAY"
            boolean r0 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r0, (boolean) r3)
            if (r0 == 0) goto L_0x0084
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            boolean r0 = r0.isPaytmWalletChecked()
            if (r0 != 0) goto L_0x0084
            goto L_0x00be
        L_0x0084:
            boolean r0 = r7.isWalletValid
            if (r0 == 0) goto L_0x00a8
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.getPaymentFlowAvailable()
            java.lang.String r4 = "NONE"
            boolean r0 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r0, (boolean) r3)
            if (r0 == 0) goto L_0x00d3
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            boolean r0 = r0.isPaytmWalletChecked()
            if (r0 == 0) goto L_0x00d3
        L_0x00a8:
            java.util.ArrayList<net.one97.paytm.nativesdk.instruments.PaytmBaseView> r0 = r7.instrumentsBaseView
            if (r0 == 0) goto L_0x00d3
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00d3
            java.util.ArrayList<net.one97.paytm.nativesdk.instruments.PaytmBaseView> r0 = r7.instrumentsBaseView
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.nativesdk.instruments.PaytmBaseView r0 = (net.one97.paytm.nativesdk.instruments.PaytmBaseView) r0
            r0.openAutoInstrument()
            goto L_0x00d3
        L_0x00be:
            java.util.ArrayList<net.one97.paytm.nativesdk.instruments.PaytmBaseView> r0 = r7.instrumentsBaseView
            if (r0 == 0) goto L_0x00d3
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00d3
            java.util.ArrayList<net.one97.paytm.nativesdk.instruments.PaytmBaseView> r0 = r7.instrumentsBaseView
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.nativesdk.instruments.PaytmBaseView r0 = (net.one97.paytm.nativesdk.instruments.PaytmBaseView) r0
            r0.openAutoInstrument()
        L_0x00d3:
            r7.sendGAEvent()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet.openAutoInstrument():void");
    }

    private final void selectNextInstrument() {
        Object obj;
        Collection arrayList = new ArrayList();
        for (Object next : this.instrumentsBaseView) {
            if (((PaytmBaseView) next).isSelected()) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (!list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (((PaytmBaseView) obj) instanceof WalletView) {
                    break;
                }
            }
            if (obj == null) {
                return;
            }
        }
        broadcastForNextInstrumentSelection();
    }

    private final void broadcastForNextInstrumentSelection() {
        a.a(PaytmSDK.getAppContext()).a(new Intent(SDKConstants.SELECT_NEXT_INSTRUMENT));
    }

    public final void disableSelectedUpiOption(String str) {
        ArrayList<PaytmBaseView> arrayList;
        if (str != null && (arrayList = this.instrumentsBaseView) != null && !arrayList.isEmpty()) {
            int size = this.instrumentsBaseView.size();
            for (int i2 = 0; i2 < size; i2++) {
                PaytmBaseView paytmBaseView = this.instrumentsBaseView.get(i2);
                k.a((Object) paytmBaseView, "instrumentsBaseView[i]");
                PaytmBaseView paytmBaseView2 = paytmBaseView;
                if ((paytmBaseView2 instanceof UpiPushView) && paytmBaseView2.isSelected()) {
                    ((UpiPushView) paytmBaseView2).disableSelectedUpiPayOption(str);
                }
            }
        }
    }

    public final void onWebViewFinished() {
        ArrayList<PaytmBaseView> arrayList = this.instrumentsBaseView;
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = this.instrumentsBaseView.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.instrumentsBaseView.get(i2).hidePaymentsLoader();
            }
        }
    }

    public final void onWalletStateChange() {
        ArrayList<PaytmBaseView> arrayList = this.instrumentsBaseView;
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = this.instrumentsBaseView.size();
            for (int i2 = 0; i2 < size; i2++) {
                PaytmBaseView paytmBaseView = this.instrumentsBaseView.get(i2);
                k.a((Object) paytmBaseView, "instrumentsBaseView[i]");
                PaytmBaseView paytmBaseView2 = paytmBaseView;
                if (paytmBaseView2 instanceof UpiPushView) {
                    ((UpiPushView) paytmBaseView2).onWalletStateChange();
                }
            }
        }
    }

    public final void autoSelectUpiPushView(String str) {
        if (str != null && !this.instrumentsBaseView.isEmpty()) {
            int size = this.instrumentsBaseView.size();
            for (int i2 = 0; i2 < size; i2++) {
                PaytmBaseView paytmBaseView = this.instrumentsBaseView.get(i2);
                k.a((Object) paytmBaseView, "instrumentsBaseView[i]");
                PaytmBaseView paytmBaseView2 = paytmBaseView;
                if (paytmBaseView2 instanceof UpiPushView) {
                    UpiPushView upiPushView = (UpiPushView) paytmBaseView2;
                    if (p.a(str, upiPushView.getPgBankCode(), true)) {
                        upiPushView.selectUpiEncouragementView();
                        return;
                    }
                }
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        String str2;
        String str3;
        super.onActivityResult(i2, i3, intent);
        int i4 = 0;
        String str4 = "";
        if (i2 == 187) {
            ArrayList<PaytmBaseView> arrayList = this.instrumentsBaseView;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (!(intent == null || intent.getExtras() == null)) {
                    Bundle extras = intent.getExtras();
                    if (extras == null) {
                        k.a();
                    }
                    str4 = extras.getString("Status", str4);
                    k.a((Object) str4, "data.extras!!.getString(\"Status\", \"\")");
                }
                DirectPaymentBL instance = DirectPaymentBL.getInstance();
                k.a((Object) instance, "DirectPaymentBL.getInstance()");
                if (instance.getUpiOptionsModel() != null) {
                    int size = this.instrumentsBaseView.size();
                    while (i4 < size) {
                        PaytmBaseView paytmBaseView = this.instrumentsBaseView.get(i4);
                        k.a((Object) paytmBaseView, "instrumentsBaseView[i]");
                        PaytmBaseView paytmBaseView2 = paytmBaseView;
                        if (paytmBaseView2 != null && (paytmBaseView2 instanceof UpiCollectViewNew)) {
                            ((UpiCollectViewNew) paytmBaseView2).onActivityResult(str4);
                        }
                        i4++;
                    }
                }
            }
        } else if (i2 == 10) {
            ArrayList<PaytmBaseView> arrayList2 = this.instrumentsBaseView;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
                k.a((Object) instance2, "DirectPaymentBL.getInstance()");
                if (instance2.getUpiOptionsModel() != null) {
                    int size2 = this.instrumentsBaseView.size();
                    while (i4 < size2) {
                        PaytmBaseView paytmBaseView3 = this.instrumentsBaseView.get(i4);
                        k.a((Object) paytmBaseView3, "instrumentsBaseView[i]");
                        PaytmBaseView paytmBaseView4 = paytmBaseView3;
                        if (paytmBaseView4 != null && (paytmBaseView4 instanceof UpiCollectViewNew)) {
                            ((UpiCollectViewNew) paytmBaseView4).onActivityResult(str4);
                        }
                        i4++;
                    }
                }
            }
        } else if (i2 == 1002) {
            if (i3 == -1) {
                if (intent == null) {
                    k.a();
                }
                str4 = intent.getStringExtra("upi_mpin");
                k.a((Object) str4, "data!!.getStringExtra(SDKConstants.EXTRA_UPI_MPIN)");
                str3 = intent.getStringExtra("seq_no");
                k.a((Object) str3, "data.getStringExtra(SDKConstants.EXTRA_SEQ_NO)");
                str2 = intent.getStringExtra("device_id");
                k.a((Object) str2, "data.getStringExtra(SDKConstants.EXTRA_DEVICE_ID)");
                str = intent.getStringExtra(SDKConstants.EXTRA_PUSH_TYPE);
                k.a((Object) str, "data.getStringExtra(SDKConstants.EXTRA_PUSH_TYPE)");
            } else {
                str3 = str4;
                str2 = str3;
                str = str2;
            }
            if (!TextUtils.isEmpty(str4)) {
                int size3 = this.instrumentsBaseView.size();
                while (i4 < size3) {
                    PaytmBaseView paytmBaseView5 = this.instrumentsBaseView.get(i4);
                    k.a((Object) paytmBaseView5, "instrumentsBaseView[i]");
                    PaytmBaseView paytmBaseView6 = paytmBaseView5;
                    if ((paytmBaseView6 instanceof UpiCollectViewNew) && (p.a(SDKConstants.PUSH_FROM_COLLECT, str, true) || p.a("intent", str, true))) {
                        ((UpiCollectViewNew) paytmBaseView6).makeUpiPushPayment(str4, str3, str2, str);
                    } else if ((paytmBaseView6 instanceof UpiPushView) && p.a(SDKConstants.PUSH_FROM_PUSH, str, true)) {
                        ((UpiPushView) paytmBaseView6).makeUpiPushPayment(str4, str3, str2);
                    } else if ((paytmBaseView6 instanceof SavedCardView) && p.a(SDKConstants.PUSH_FROM_PUSH, str, true)) {
                        ((SavedCardView) paytmBaseView6).makeUpiPushPayment(str4, str3, str2);
                    } else if ((paytmBaseView6 instanceof NetBankingView) && p.a(SDKConstants.PUSH_FROM_PUSH, str, true)) {
                        ((NetBankingView) paytmBaseView6).makeUpiPushPayment(str4, str3, str2);
                    } else if ((paytmBaseView6 instanceof DebitCreditCreditCardsView) && p.a(SDKConstants.PUSH_FROM_PUSH, str, true)) {
                        ((DebitCreditCreditCardsView) paytmBaseView6).makeUpiPushPayment(str4, str3, str2);
                    }
                    i4++;
                }
            }
        } else if (i3 == -1 && i2 == 233) {
            int size4 = this.instrumentsBaseView.size();
            while (i4 < size4) {
                PaytmBaseView paytmBaseView7 = this.instrumentsBaseView.get(i4);
                k.a((Object) paytmBaseView7, "instrumentsBaseView[i]");
                PaytmBaseView paytmBaseView8 = paytmBaseView7;
                if (paytmBaseView8 instanceof UpiPushView) {
                    ((UpiPushView) paytmBaseView8).getBalance();
                }
                i4++;
            }
        } else if (i2 == 352 || i2 == 144 || i2 == 304) {
            if (i3 == -1) {
                DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
                k.a((Object) instance3, "DirectPaymentBL.getInstance()");
                instance3.setUpiOnBoarded(true);
                updateUpiProfileData();
                return;
            }
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_ONBOARDING, SDKConstants.GA_UPI_ONBOARDING_RESULT, SDKConstants.GA_NATIVE_FAILED, str4, merchantInstance.getMid()));
        } else if (i3 == -1 && i2 == 1139) {
            if (PaytmSDK.getUpiCallBackListener() != null) {
                PaytmSDK.getUpiCallBackListener().startBankVpaCreationActivity(getActivity(), SDKUtils.getPrimaryVpaAddress(), intent, 304);
            }
        } else if (i3 == -1 && i2 == 234) {
            int size5 = this.instrumentsBaseView.size();
            while (i4 < size5) {
                PaytmBaseView paytmBaseView9 = this.instrumentsBaseView.get(i4);
                k.a((Object) paytmBaseView9, "instrumentsBaseView[i]");
                PaytmBaseView paytmBaseView10 = paytmBaseView9;
                if (paytmBaseView10 instanceof UpiPushView) {
                    ((UpiPushView) paytmBaseView10).updateSetPinLayout();
                }
                i4++;
            }
        } else {
            int size6 = this.instrumentsBaseView.size();
            while (i4 < size6) {
                this.instrumentsBaseView.get(i4).onActivityResult(i2, i3, intent);
                i4++;
            }
        }
    }

    private final void updateUpiProfileData() {
        int size = this.instrumentsBaseView.size();
        for (int i2 = 0; i2 < size; i2++) {
            PaytmBaseView paytmBaseView = this.instrumentsBaseView.get(i2);
            k.a((Object) paytmBaseView, "instrumentsBaseView[i]");
            PaytmBaseView paytmBaseView2 = paytmBaseView;
            if (paytmBaseView2 instanceof UpiOnboardingView) {
                ((UpiOnboardingView) paytmBaseView2).showPaymentLoader();
            }
        }
        Context context = getContext();
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String mid = merchantInstance.getMid();
        String ssoToken = MerchantBL.getMerchantInstance().getSsoToken();
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        String amount = merchantInstance2.getAmount();
        k.a((Object) amount, "MerchantBL.getMerchantInstance().amount");
        new FetchOptionsRequest(context, mid, ssoToken, Double.parseDouble(amount), (FetchPayOptionsListener) new BaseInstrumentSheet$updateUpiProfileData$fetchOptionsRequest$1(this)).executeRequest();
    }

    public void inflatePaymentInstruments(List<? extends PaymentInstrumentView> list) {
        PaytmBaseView paytmBaseView;
        View view;
        k.c(list, "pgInstruments");
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.getCjPayMethodResponse() == null) {
            SDKUtility.logException(TAG, "Fetch Payment Response is null", new Throwable());
            return;
        }
        for (PaymentInstrumentView paymentInstrumentView : list) {
            try {
                if (paymentInstrumentView instanceof PaymentInstrumentView.WalletView) {
                    if (this.walletView == null) {
                        Instruments instruments2 = this.instruments;
                        if (instruments2 == null) {
                            k.a("instruments");
                        }
                        Context context = getContext();
                        PaymentModes paymentModes = ((PaymentInstrumentView.WalletView) paymentInstrumentView).getPaymentModes();
                        boolean isInstrumentValid = ((PaymentInstrumentView.WalletView) paymentInstrumentView).isInstrumentValid();
                        InstrumentsSelectionManager instrumentsSelectionManager = this.mInstrumentsSelectionManager;
                        if (instrumentsSelectionManager == null) {
                            k.a("mInstrumentsSelectionManager");
                        }
                        this.walletView = instruments2.getWalletView(context, paymentModes, isInstrumentValid, instrumentsSelectionManager);
                    }
                    PaytmBaseView paytmBaseView2 = this.walletView;
                    if (paytmBaseView2 != null) {
                        paytmBaseView2.setInstrumentName(SDKConstants.GA_KEY_BALANCE);
                    }
                    PaytmBaseView paytmBaseView3 = this.walletView;
                    if (paytmBaseView3 == null) {
                        k.a();
                    }
                    addInstrument(paytmBaseView3);
                    PaytmBaseView paytmBaseView4 = this.walletView;
                    if (!(paytmBaseView4 == null || (view = paytmBaseView4.getView()) == null)) {
                        addViewInScrollView(view, true);
                        x xVar = x.f47997a;
                    }
                    this.isWalletValid = ((PaymentInstrumentView.WalletView) paymentInstrumentView).isInstrumentValid();
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.BankMandateView) {
                    Instruments instruments3 = this.instruments;
                    if (instruments3 == null) {
                        k.a("instruments");
                    }
                    Context context2 = getContext();
                    PaymentModes paymentModes2 = ((PaymentInstrumentView.BankMandateView) paymentInstrumentView).getPaymentModes();
                    MandateAccountDetails mandateAccountDetails = ((PaymentInstrumentView.BankMandateView) paymentInstrumentView).getMandateAccountDetails();
                    InstrumentsSelectionManager instrumentsSelectionManager2 = this.mInstrumentsSelectionManager;
                    if (instrumentsSelectionManager2 == null) {
                        k.a("mInstrumentsSelectionManager");
                    }
                    PaytmBaseView bankMandateView = instruments3.getBankMandateView(context2, paymentModes2, mandateAccountDetails, instrumentsSelectionManager2);
                    k.a((Object) bankMandateView, "bankMandateView");
                    bankMandateView.setInstrumentName(SDKConstants.GA_KEY_BANK_MANDATE);
                    addInstrument(bankMandateView);
                    View view2 = bankMandateView.getView();
                    k.a((Object) view2, "bankMandateView.view");
                    addViewInScrollView$default(this, view2, false, 2, (Object) null);
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.SavedMandateView) {
                    Instruments instruments4 = this.instruments;
                    if (instruments4 == null) {
                        k.a("instruments");
                    }
                    Context context3 = getContext();
                    PaymentModes paymentModes3 = ((PaymentInstrumentView.SavedMandateView) paymentInstrumentView).getPaymentModes();
                    SavedMandateBanksItem savedMandateBanksItem = ((PaymentInstrumentView.SavedMandateView) paymentInstrumentView).getSavedMandateBanksItem();
                    InstrumentsSelectionManager instrumentsSelectionManager3 = this.mInstrumentsSelectionManager;
                    if (instrumentsSelectionManager3 == null) {
                        k.a("mInstrumentsSelectionManager");
                    }
                    PaytmBaseView savedMandateView = instruments4.getSavedMandateView(context3, paymentModes3, savedMandateBanksItem, instrumentsSelectionManager3);
                    k.a((Object) savedMandateView, "bankMandateView");
                    savedMandateView.setInstrumentName(SDKConstants.GA_KEY_BANK_MANDATE);
                    addInstrument(savedMandateView);
                    View view3 = savedMandateView.getView();
                    k.a((Object) view3, "bankMandateView.view");
                    addViewInScrollView$default(this, view3, false, 2, (Object) null);
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.GiftVoucher) {
                    if (this.giftVoucher == null) {
                        Instruments instruments5 = this.instruments;
                        if (instruments5 == null) {
                            k.a("instruments");
                        }
                        this.giftVoucher = instruments5.getGiftVoucherView(this, getContext(), ((PaymentInstrumentView.GiftVoucher) paymentInstrumentView).getPaymentModes(), Boolean.valueOf(((PaymentInstrumentView.GiftVoucher) paymentInstrumentView).isInstrumentValid()));
                    }
                    PaytmBaseView paytmBaseView5 = this.giftVoucher;
                    if (paytmBaseView5 == null) {
                        k.a();
                    }
                    addInstrument(paytmBaseView5);
                    PaytmBaseView paytmBaseView6 = this.giftVoucher;
                    if (paytmBaseView6 == null) {
                        k.a();
                    }
                    View view4 = paytmBaseView6.getView();
                    k.a((Object) view4, "giftVoucher!!.view");
                    addViewInScrollView$default(this, view4, false, 2, (Object) null);
                    PaytmBaseView paytmBaseView7 = this.giftVoucher;
                    if (paytmBaseView7 == null) {
                        k.a();
                    }
                    paytmBaseView7.setInstrumentName("Gift Voucher");
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.UPIPushView) {
                    Instruments instruments6 = this.instruments;
                    if (instruments6 == null) {
                        k.a("instruments");
                    }
                    PaytmBaseView upiPushViewSingle = instruments6.getUpiPushViewSingle(getContext(), ((PaymentInstrumentView.UPIPushView) paymentInstrumentView).getVpaDetails(), ((PaymentInstrumentView.UPIPushView) paymentInstrumentView).getPaymentModes());
                    k.a((Object) upiPushViewSingle, "upiPushView");
                    addInstrument(upiPushViewSingle);
                    View view5 = upiPushViewSingle.getView();
                    k.a((Object) view5, "upiPushView.view");
                    addViewInScrollView$default(this, view5, false, 2, (Object) null);
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.UpiOnboardingView) {
                    Context context4 = getContext();
                    Instruments instruments7 = this.instruments;
                    if (instruments7 == null) {
                        k.a("instruments");
                    }
                    UpiOnboardingView upiOnboardingView = new UpiOnboardingView(context4, instruments7);
                    addInstrument(upiOnboardingView);
                    PaytmBaseView upiOnBoardingView = upiOnboardingView.getUpiOnBoardingView();
                    k.a((Object) upiOnBoardingView, "upiOnboardingView.upiOnBoardingView");
                    View view6 = upiOnBoardingView.getView();
                    k.a((Object) view6, "upiOnboardingView.upiOnBoardingView.view");
                    addViewInScrollView$default(this, view6, false, 2, (Object) null);
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.PaytmBankView) {
                    PaytmBaseView paytmPaymentsBankView = new Instruments(this.cashierInstrumentCom).getPaytmPaymentsBankView(getContext(), ((PaymentInstrumentView.PaytmBankView) paymentInstrumentView).getPaymentModes(), true, false);
                    k.a((Object) paytmPaymentsBankView, "ppblView");
                    addInstrument(paytmPaymentsBankView);
                    View view7 = paytmPaymentsBankView.getView();
                    k.a((Object) view7, "ppblView.view");
                    addViewInScrollView(view7, true);
                    paytmPaymentsBankView.setInstrumentName(SDKConstants.GA_KEY_PPB);
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.PostpaidView) {
                    if (((PaymentInstrumentView.PostpaidView) paymentInstrumentView).isAddMoney()) {
                        paytmBaseView = new Instruments(this.cashierInstrumentCom).getDigitalCreditView(getContext(), ((PaymentInstrumentView.PostpaidView) paymentInstrumentView).getPaymentModes(), true);
                        k.a((Object) paytmBaseView, "Instruments(cashierInstr…ument.paymentModes, true)");
                    } else {
                        paytmBaseView = new Instruments(this.cashierInstrumentCom).getPaytmPaymentsBankView(getContext(), ((PaymentInstrumentView.PostpaidView) paymentInstrumentView).getPaymentModes(), true, true);
                        k.a((Object) paytmBaseView, "Instruments(cashierInstr…paymentModes, true, true)");
                    }
                    paytmBaseView.setInstrumentName(SDKConstants.GA_KEY_POSTPAID);
                    addInstrument(paytmBaseView);
                    View view8 = paytmBaseView.getView();
                    k.a((Object) view8, "postpaidView.view");
                    addViewInScrollView(view8, true);
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.SavedCardView) {
                    Instruments instruments8 = this.instruments;
                    if (instruments8 == null) {
                        k.a("instruments");
                    }
                    PaytmBaseView savedCardView = instruments8.getSavedCardView(getContext(), ((PaymentInstrumentView.SavedCardView) paymentInstrumentView).getSavedInstrument(), false);
                    k.a((Object) savedCardView, "paytmBaseView");
                    addInstrument(savedCardView);
                    View view9 = savedCardView.getView();
                    k.a((Object) view9, "paytmBaseView.view");
                    addViewInScrollView$default(this, view9, false, 2, (Object) null);
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.CreditCardView) {
                    Instruments instruments9 = this.instruments;
                    if (instruments9 == null) {
                        k.a("instruments");
                    }
                    Context context5 = getContext();
                    DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
                    k.a((Object) instance2, "DirectPaymentBL.getInstance()");
                    PaytmBaseView pgOnlyCreditCardsView = instruments9.getPgOnlyCreditCardsView(context5, instance2.getCjPayMethodResponse(), (LinearLayout) null);
                    k.a((Object) pgOnlyCreditCardsView, "creditCardsView");
                    addInstrument(pgOnlyCreditCardsView);
                    View view10 = pgOnlyCreditCardsView.getView();
                    k.a((Object) view10, "creditCardsView.view");
                    addViewInScrollView$default(this, view10, false, 2, (Object) null);
                    pgOnlyCreditCardsView.setInstrumentName("Credit Card");
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.DebitCardView) {
                    Instruments instruments10 = this.instruments;
                    if (instruments10 == null) {
                        k.a("instruments");
                    }
                    Context context6 = getContext();
                    DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
                    k.a((Object) instance3, "DirectPaymentBL.getInstance()");
                    PaytmBaseView pgOnlyDebitCardsView = instruments10.getPgOnlyDebitCardsView(context6, instance3.getCjPayMethodResponse(), (LinearLayout) null);
                    k.a((Object) pgOnlyDebitCardsView, "debitCardView");
                    addInstrument(pgOnlyDebitCardsView);
                    View view11 = pgOnlyDebitCardsView.getView();
                    k.a((Object) view11, "debitCardView.view");
                    addViewInScrollView$default(this, view11, false, 2, (Object) null);
                    pgOnlyDebitCardsView.setInstrumentName("Debit Card");
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.UPIColletView) {
                    Instruments instruments11 = this.instruments;
                    if (instruments11 == null) {
                        k.a("instruments");
                    }
                    PaytmBaseView upiCollectViewNew = instruments11.getUpiCollectViewNew(getContext(), ((PaymentInstrumentView.UPIColletView) paymentInstrumentView).getPaymentModes());
                    k.a((Object) upiCollectViewNew, "upiView");
                    addInstrument(upiCollectViewNew);
                    View view12 = upiCollectViewNew.getView();
                    k.a((Object) view12, "upiView.view");
                    addViewInScrollView$default(this, view12, false, 2, (Object) null);
                    upiCollectViewNew.setInstrumentName(SDKConstants.GA_KEY_UPI_COllECT);
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.EMIView) {
                    Instruments instruments12 = this.instruments;
                    if (instruments12 == null) {
                        k.a("instruments");
                    }
                    PaytmBaseView emiView = instruments12.getEmiView(getContext(), ((PaymentInstrumentView.EMIView) paymentInstrumentView).getPaymentModes());
                    k.a((Object) emiView, "emiView");
                    addInstrument(emiView);
                    View view13 = emiView.getView();
                    k.a((Object) view13, "emiView.view");
                    addViewInScrollView$default(this, view13, false, 2, (Object) null);
                    emiView.setInstrumentName(SDKConstants.GA_KEY_EMI);
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.NetBankingView) {
                    Instruments instruments13 = this.instruments;
                    if (instruments13 == null) {
                        k.a("instruments");
                    }
                    PaytmBaseView netBankingView = instruments13.getNetBankingView(getContext(), ((PaymentInstrumentView.NetBankingView) paymentInstrumentView).getPaymentModes(), true, true);
                    k.a((Object) netBankingView, "netBankingView");
                    addInstrument(netBankingView);
                    View view14 = netBankingView.getView();
                    k.a((Object) view14, "netBankingView.view");
                    addViewInScrollView$default(this, view14, false, 2, (Object) null);
                    netBankingView.setInstrumentName(SDKConstants.GA_KEY_NETBANKING);
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.CODView) {
                    Instruments instruments14 = this.instruments;
                    if (instruments14 == null) {
                        k.a("instruments");
                    }
                    PaytmBaseView cODView = instruments14.getCODView(getContext());
                    k.a((Object) cODView, "codView");
                    addInstrument(cODView);
                    View view15 = cODView.getView();
                    k.a((Object) view15, "codView.view");
                    addViewInScrollView$default(this, view15, false, 2, (Object) null);
                    this.codPayMode = ((PaymentInstrumentView.CODView) paymentInstrumentView).getPaymentModes();
                    if (this.codPayMode != null) {
                        PaymentModes paymentModes4 = this.codPayMode;
                        if (paymentModes4 == null) {
                            k.a();
                        }
                        toggleCODView(paymentModes4);
                        x xVar2 = x.f47997a;
                    }
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.AOAView) {
                    Instruments instruments15 = this.instruments;
                    if (instruments15 == null) {
                        k.a("instruments");
                    }
                    PaytmBaseView aoaWalletView = instruments15.getAoaWalletView(getContext());
                    k.a((Object) aoaWalletView, "aoaWalletView");
                    addInstrument(aoaWalletView);
                    View view16 = aoaWalletView.getView();
                    k.a((Object) view16, "aoaWalletView.view");
                    addViewInScrollView$default(this, view16, false, 2, (Object) null);
                    aoaWalletView.setInstrumentName(SDKConstants.GA_KEY_AOA_WALLET);
                } else if (paymentInstrumentView instanceof PaymentInstrumentView.Divider) {
                    View inflate = LayoutInflater.from(getContext()).inflate(R.layout.line_xml, (ViewGroup) null, false);
                    k.a((Object) inflate, "LayoutInflater.from(cont…ut.line_xml, null, false)");
                    addViewInScrollView(inflate, false);
                }
            } catch (Exception e2) {
                SDKUtility.logCrashAndException(TAG, "some payment instruments not inflated", e2);
            }
        }
        InstrumentsSelectionManager instrumentsSelectionManager4 = this.mInstrumentsSelectionManager;
        if (instrumentsSelectionManager4 == null) {
            k.a("mInstrumentsSelectionManager");
        }
        instrumentsSelectionManager4.resetInstruments(this.instrumentsBaseView);
        if (this.initialized || this.pendingInstrumentSelection) {
            this.initialized = false;
            if (this.pendingInstrumentSelection) {
                this.pendingInstrumentSelection = false;
                broadcastForNextInstrumentSelection();
            } else {
                this.pendingInstrumentSelection = false;
                selectNextInstrument();
            }
        }
        DirectPaymentBL instance4 = DirectPaymentBL.getInstance();
        k.a((Object) instance4, "DirectPaymentBL.getInstance()");
        instance4.setOpeningAuto(false);
    }

    public final void addInstrument(PaytmBaseView paytmBaseView) {
        k.c(paytmBaseView, "paytmBaseView");
        if (paytmBaseView instanceof EmiView) {
            this.emiViewPosition = this.instrumentsBaseView.size();
        } else if (paytmBaseView instanceof CodView) {
            this.codViewPosition = this.instrumentsBaseView.size();
        }
        this.instrumentsBaseView.add(paytmBaseView);
    }

    /* access modifiers changed from: protected */
    public final void reInitializeVariables() {
        this.initialized = true;
        this.codPayMode = null;
        this.emiViewPosition = -1;
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        instance.setEmiMin(0.0d);
        DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
        k.a((Object) instance2, "DirectPaymentBL.getInstance()");
        instance2.setEmiMax(-1.0d);
    }

    final class CashierInstrumentCom extends InstrumentListeneres {
        private String x = "";

        public final void closeCashier() {
        }

        public CashierInstrumentCom() {
        }

        public final String getX() {
            return this.x;
        }

        public final void setX(String str) {
            this.x = str;
        }

        public final void loadInstruments(boolean z) {
            PaytmBaseView walletView;
            View view;
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            instance.setPaymentFlowBankOffer(z ? SDKConstants.ADDANDPAY : SDKConstants.NATIVE_SDK_NONE);
            BaseInstrumentSheet baseInstrumentSheet = BaseInstrumentSheet.this;
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            baseInstrumentSheet.handleFPOResponseBankOffers(instance2.getCjPayMethodResponse());
            BaseInstrumentSheet.this.removeAllViews();
            BaseInstrumentSheet.this.instrumentsBaseView.clear();
            BaseInstrumentSheet baseInstrumentSheet2 = BaseInstrumentSheet.this;
            boolean z2 = true;
            if (!z || (walletView = baseInstrumentSheet2.getWalletView()) == null || (view = walletView.getView()) == null || !view.isEnabled()) {
                z2 = false;
            }
            baseInstrumentSheet2.addPaymentInstruments(z2);
            BaseInstrumentSheet.this.reInitializeVariables();
        }

        public final NestedScrollView getScrollView() {
            return BaseInstrumentSheet.this.provideScrollView();
        }
    }

    public static /* synthetic */ void addViewInScrollView$default(BaseInstrumentSheet baseInstrumentSheet, View view, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            baseInstrumentSheet.addViewInScrollView(view, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addViewInScrollView");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r4 = r8.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleFPOResponseBankOffers(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r8) {
        /*
            r7 = this;
            boolean r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.isAppInvokeFlow()
            java.lang.String r1 = "NONE"
            r2 = 2402104(0x24a738, float:3.366065E-39)
            java.lang.String r3 = "DirectPaymentBL.getInstance()"
            if (r0 == 0) goto L_0x0080
            r0 = 0
            if (r8 == 0) goto L_0x001b
            net.one97.paytm.nativesdk.common.model.Body r4 = r8.getBody()
            if (r4 == 0) goto L_0x001b
            net.one97.paytm.nativesdk.common.model.SimplifiedPaymentsOffer r4 = r4.getSimplifiedPaymentsOffer()
            goto L_0x001c
        L_0x001b:
            r4 = r0
        L_0x001c:
            if (r4 == 0) goto L_0x007c
            net.one97.paytm.nativesdk.DirectPaymentBL r4 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            java.lang.String r4 = r4.getPaymentFlowBankOffer()
            if (r4 != 0) goto L_0x002c
            return
        L_0x002c:
            int r5 = r4.hashCode()
            r6 = -1112662222(0xffffffffbdae1f32, float:-0.08502044)
            if (r5 == r6) goto L_0x0042
            if (r5 == r2) goto L_0x0038
            return
        L_0x0038:
            boolean r0 = r4.equals(r1)
            if (r0 == 0) goto L_0x00ac
            r7.processOffers(r8)
            return
        L_0x0042:
            java.lang.String r1 = "ADDANDPAY"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x00ac
            net.one97.paytm.nativesdk.DirectPaymentBL r1 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            boolean r1 = r1.isPaytmWalletChecked()
            if (r1 == 0) goto L_0x0078
            r7.handleInvalidOfferCases()
            android.content.Context r8 = r7.getContext()
            if (r8 == 0) goto L_0x0064
            android.content.Context r0 = r8.getApplicationContext()
        L_0x0064:
            if (r0 != 0) goto L_0x0069
            kotlin.g.b.k.a()
        L_0x0069:
            androidx.localbroadcastmanager.a.a r8 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r0)
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "hide_bulk_offer"
            r0.<init>(r1)
            r8.a((android.content.Intent) r0)
            return
        L_0x0078:
            r7.processOffers(r8)
            return
        L_0x007c:
            r7.handleInvalidOfferCases()
            return
        L_0x0080:
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.lang.String r0 = r0.getPaymentFlowBankOffer()
            if (r0 != 0) goto L_0x008e
            return
        L_0x008e:
            int r3 = r0.hashCode()
            if (r3 == r2) goto L_0x00a3
            r1 = 2145539580(0x7fe255fc, float:NaN)
            if (r3 == r1) goto L_0x009a
            goto L_0x00ac
        L_0x009a:
            java.lang.String r1 = "HYBRID"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00ac
            goto L_0x00a9
        L_0x00a3:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00ac
        L_0x00a9:
            r7.fetchAllPaymentOffers(r8)
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet.handleFPOResponseBankOffers(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r7.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void processOffers(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x000e
            net.one97.paytm.nativesdk.common.model.Body r1 = r7.getBody()
            if (r1 == 0) goto L_0x000e
            net.one97.paytm.nativesdk.common.model.SimplifiedPaymentsOffer r1 = r1.getSimplifiedPaymentsOffer()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            net.one97.paytm.nativesdk.DirectPaymentBL r2 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r3 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r2.setSimplifiedPaymentsOffer(r1)
            net.one97.paytm.nativesdk.MerchantBL r2 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r3 = "MerchantBL.getMerchantInstance()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            if (r1 == 0) goto L_0x002b
            java.lang.String r4 = r1.getValidatePromo()
            goto L_0x002c
        L_0x002b:
            r4 = r0
        L_0x002c:
            java.lang.String r5 = "true"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            r2.setValidatePromo(r4)
            net.one97.paytm.nativesdk.MerchantBL r2 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            if (r1 == 0) goto L_0x0044
            java.lang.String r3 = r1.getPromoCode()
            goto L_0x0045
        L_0x0044:
            r3 = r0
        L_0x0045:
            r2.setAppInvokePromoCode(r3)
            if (r1 == 0) goto L_0x004f
            java.lang.String r2 = r1.getApplyAvailablePromo()
            goto L_0x0050
        L_0x004f:
            r2 = r0
        L_0x0050:
            java.lang.String r3 = "apply_available_offer"
            java.util.Map r2 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParamsBO(r3, r2)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r2)
            if (r1 == 0) goto L_0x0060
            java.lang.String r2 = r1.getValidatePromo()
            goto L_0x0061
        L_0x0060:
            r2 = r0
        L_0x0061:
            java.lang.String r3 = "validate_promo_status"
            java.util.Map r2 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParamsBO(r3, r2)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r2)
            if (r1 == 0) goto L_0x0072
            java.lang.String r2 = r1.getPromoCode()
            goto L_0x0073
        L_0x0072:
            r2 = r0
        L_0x0073:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x008a
            if (r1 == 0) goto L_0x0081
            java.lang.String r0 = r1.getPromoCode()
        L_0x0081:
            java.lang.String r1 = "promo_code_present"
            java.util.Map r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParamsBO(r1, r0)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r0)
        L_0x008a:
            r6.fetchAllPaymentOffers(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet.processOffers(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse):void");
    }

    private final void handleInvalidOfferCases() {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        instance.setBankOffersAvailable(false);
        hideBankOfferStrip();
    }
}

package net.one97.paytm.nativesdk.instruments.wallet.view;

import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.databinding.f;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.localbroadcastmanager.a.a;
import com.alipay.mobile.h5container.api.H5Param;
import com.appsflyer.internal.referrer.Payload;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.common.listeners.SetOnAlertButtonListeners;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SubWalletDetail;
import net.one97.paytm.nativesdk.databinding.WalletLytInstrumentInfoBinding;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.InstrumentsSelectionManager;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.emi.view.EmiView;
import net.one97.paytm.nativesdk.instruments.savedCard.view.SavedCardView;
import net.one97.paytm.nativesdk.instruments.wallet.listeners.WalletListener;
import net.one97.paytm.nativesdk.instruments.wallet.view.OtpView;
import net.one97.paytm.nativesdk.instruments.wallet.viewmodel.ToolbarState;
import net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletToolbarViewModel;
import net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletViewModel;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;
import net.one97.paytm.nativesdk.walletOtp.WalletOtpResponse;

public class WalletView extends PaytmBaseView implements WalletListener, OtpView.OtpViewWatcher {
    /* access modifiers changed from: private */
    public BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (DirectPaymentBL.getInstance().isRemainingAmountInDecimals() || DirectPaymentBL.getInstance().isWalletAmountSufficientToPay()) {
                return;
            }
            if (SDKConstants.DISABLE_WALLET_UPI_COLLECT.equalsIgnoreCase(intent.getAction())) {
                if (!WalletView.this.isValid) {
                    return;
                }
                if (!DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().isWalletOnly() || !SDKConstants.ADDANDPAY.equalsIgnoreCase(DirectPaymentBL.getInstance().getPaymentFlowAvailable())) {
                    boolean unused = WalletView.this.isValid = false;
                    WalletView.this.enableDisableView(false);
                    WalletView.this.walletViewModel.setValid(false);
                    WalletView.this.walletViewModel.payMethodSelected((View) null);
                    WalletView.this.deselectView();
                    WalletView.this.walletViewModel.setAlreadySelected(false);
                    DirectPaymentBL.getInstance().setPaytmWalletChecked(false, context);
                }
            } else if (SDKConstants.ENABLE_WALLET_UPI_COLLECT.equalsIgnoreCase(intent.getAction())) {
                if (!WalletView.this.isValid && WalletView.this.walletViewModel.canEnableWallet()) {
                    boolean unused2 = WalletView.this.isValid = true;
                    WalletView.this.walletViewModel.setValid(true);
                    WalletView.this.enableDisableView(true);
                    if (SDKUtility.isHybridSupported() && DirectPaymentBL.getInstance().getPaytmBaseView() != null) {
                        DirectPaymentBL.getInstance().getPaytmBaseView().refreshLayout();
                    }
                }
            } else if (SDKConstants.DESELECT_WALLET.equalsIgnoreCase(intent.getAction())) {
                WalletView.this.walletViewModel.payMethodSelected((View) null);
            } else if (SDKConstants.UNREGISTER_BROADCAST.equalsIgnoreCase(intent.getAction())) {
                a.a(context).a(WalletView.this.broadcastReceiver);
            }
        }
    };
    private RelativeLayout btnProceed;
    /* access modifiers changed from: private */
    public boolean isValid;
    /* access modifiers changed from: private */
    public OtpView mOtpView;
    private BroadcastReceiver networkConnectivityReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction()) && SDKUtility.isNetworkAvailable(context) && WalletView.this.walletViewModel != null && WalletView.this.walletViewModel.isWalletSelected()) {
                WalletView.this.walletViewModel.fetchConvenienceFee();
            }
        }
    };
    /* access modifiers changed from: private */
    public int resendCount;
    /* access modifiers changed from: private */
    public WalletLytInstrumentInfoBinding walletLytInstrumentInfoBinding;
    private WalletToolbarViewModel walletToolbarViewModel;
    /* access modifiers changed from: private */
    public WalletViewModel walletViewModel;

    public void changeBehaviour(boolean z) {
    }

    public void changeOfferTextBgColor(int i2, int i3, boolean z) {
    }

    public WalletView(Context context, Instruments instruments, boolean z) {
        super(instruments);
        this.context = context;
        this.isValid = z;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SDKConstants.DISABLE_WALLET_UPI_COLLECT);
        intentFilter.addAction(SDKConstants.ENABLE_WALLET_UPI_COLLECT);
        intentFilter.addAction(SDKConstants.UNREGISTER_BROADCAST);
        intentFilter.addAction(SDKConstants.DESELECT_WALLET);
        a.a(context).a(this.broadcastReceiver, intentFilter);
        if (context != null) {
            context.registerReceiver(this.networkConnectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void registerObserVer() {
        this.walletViewModel.mWalletOtpResponse.observe((q) this.context, new z<WalletOtpResponse>() {
            /* JADX WARNING: Code restructure failed: missing block: B:47:0x00db, code lost:
                net.one97.paytm.nativesdk.Utils.DialogUtility.showDialog(net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.access$1100(r5.this$0), r6, new net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.AnonymousClass3.AnonymousClass5(r5));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e9, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:52:0x0107, code lost:
                net.one97.paytm.nativesdk.Utils.DialogUtility.showDialog(net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.access$800(r5.this$0), r6, new net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.AnonymousClass3.AnonymousClass2(r5));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:0x0115, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:57:0x013f, code lost:
                net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.access$200(r5.this$0).hasWalletOtpSent = true;
                r6 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance().getSsoMobileNumber();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:0x0153, code lost:
                if (android.text.TextUtils.isEmpty(r6) != false) goto L_0x0160;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:59:0x0155, code lost:
                r6 = "OTP sent to  ".concat(java.lang.String.valueOf(r6));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:60:0x0160, code lost:
                r6 = "Otp Sent to Mobile number ";
             */
            /* JADX WARNING: Code restructure failed: missing block: B:61:0x0162, code lost:
                android.widget.Toast.makeText(net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.access$600(r5.this$0), r6, 0).show();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onChanged(net.one97.paytm.nativesdk.walletOtp.WalletOtpResponse r6) {
                /*
                    r5 = this;
                    if (r6 == 0) goto L_0x016f
                    net.one97.paytm.nativesdk.walletOtp.Body r0 = r6.getBody()
                    if (r0 == 0) goto L_0x016f
                    net.one97.paytm.nativesdk.walletOtp.Body r0 = r6.getBody()
                    net.one97.paytm.nativesdk.walletOtp.ResultInfo r0 = r0.getResultInfo()
                    if (r0 == 0) goto L_0x016f
                    net.one97.paytm.nativesdk.walletOtp.Body r0 = r6.getBody()
                    net.one97.paytm.nativesdk.walletOtp.ResultInfo r0 = r0.getResultInfo()
                    java.lang.String r0 = r0.getResultCode()
                    net.one97.paytm.nativesdk.walletOtp.Body r6 = r6.getBody()
                    net.one97.paytm.nativesdk.walletOtp.ResultInfo r6 = r6.getResultInfo()
                    java.lang.String r6 = r6.getResultMsg()
                    boolean r1 = android.text.TextUtils.isEmpty(r6)
                    if (r1 == 0) goto L_0x0032
                    java.lang.String r6 = "Some Error occured "
                L_0x0032:
                    boolean r1 = android.text.TextUtils.isEmpty(r0)
                    if (r1 != 0) goto L_0x016f
                    r1 = -1
                    int r2 = r0.hashCode()
                    r3 = 0
                    r4 = 1
                    switch(r2) {
                        case -1173931575: goto L_0x009f;
                        case 1537: goto L_0x0095;
                        case 1538: goto L_0x008b;
                        case 49588: goto L_0x0081;
                        case 51511: goto L_0x0077;
                        case 51602: goto L_0x006d;
                        case 51605: goto L_0x0063;
                        case 52507: goto L_0x0059;
                        case 52563: goto L_0x004f;
                        case 1507429: goto L_0x0044;
                        default: goto L_0x0042;
                    }
                L_0x0042:
                    goto L_0x00a9
                L_0x0044:
                    java.lang.String r2 = "1006"
                    boolean r0 = r0.equals(r2)
                    if (r0 == 0) goto L_0x00a9
                    r1 = 9
                    goto L_0x00a9
                L_0x004f:
                    java.lang.String r2 = "531"
                    boolean r0 = r0.equals(r2)
                    if (r0 == 0) goto L_0x00a9
                    r1 = 6
                    goto L_0x00a9
                L_0x0059:
                    java.lang.String r2 = "517"
                    boolean r0 = r0.equals(r2)
                    if (r0 == 0) goto L_0x00a9
                    r1 = 5
                    goto L_0x00a9
                L_0x0063:
                    java.lang.String r2 = "434"
                    boolean r0 = r0.equals(r2)
                    if (r0 == 0) goto L_0x00a9
                    r1 = 7
                    goto L_0x00a9
                L_0x006d:
                    java.lang.String r2 = "431"
                    boolean r0 = r0.equals(r2)
                    if (r0 == 0) goto L_0x00a9
                    r1 = 4
                    goto L_0x00a9
                L_0x0077:
                    java.lang.String r2 = "403"
                    boolean r0 = r0.equals(r2)
                    if (r0 == 0) goto L_0x00a9
                    r1 = 3
                    goto L_0x00a9
                L_0x0081:
                    java.lang.String r2 = "202"
                    boolean r0 = r0.equals(r2)
                    if (r0 == 0) goto L_0x00a9
                    r1 = 2
                    goto L_0x00a9
                L_0x008b:
                    java.lang.String r2 = "02"
                    boolean r0 = r0.equals(r2)
                    if (r0 == 0) goto L_0x00a9
                    r1 = 1
                    goto L_0x00a9
                L_0x0095:
                    java.lang.String r2 = "01"
                    boolean r0 = r0.equals(r2)
                    if (r0 == 0) goto L_0x00a9
                    r1 = 0
                    goto L_0x00a9
                L_0x009f:
                    java.lang.String r2 = "00000900"
                    boolean r0 = r0.equals(r2)
                    if (r0 == 0) goto L_0x00a9
                    r1 = 8
                L_0x00a9:
                    switch(r1) {
                        case 0: goto L_0x0116;
                        case 1: goto L_0x013f;
                        case 2: goto L_0x00f9;
                        case 3: goto L_0x0107;
                        case 4: goto L_0x00ea;
                        case 5: goto L_0x00cd;
                        case 6: goto L_0x00db;
                        case 7: goto L_0x00be;
                        case 8: goto L_0x00be;
                        case 9: goto L_0x00ae;
                        default: goto L_0x00ac;
                    }
                L_0x00ac:
                    goto L_0x016f
                L_0x00ae:
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView r0 = net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.this
                    android.content.Context r0 = r0.context
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$7 r1 = new net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$7
                    r1.<init>()
                    net.one97.paytm.nativesdk.Utils.DialogUtility.showDialog(r0, r6, r1)
                    goto L_0x016f
                L_0x00be:
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView r0 = net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.this
                    android.content.Context r0 = r0.context
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$6 r1 = new net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$6
                    r1.<init>()
                    net.one97.paytm.nativesdk.Utils.DialogUtility.showDialog(r0, r6, r1)
                    return
                L_0x00cd:
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView r0 = net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.this
                    android.content.Context r0 = r0.context
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$4 r1 = new net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$4
                    r1.<init>()
                    net.one97.paytm.nativesdk.Utils.DialogUtility.showDialog(r0, r6, r1)
                L_0x00db:
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView r0 = net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.this
                    android.content.Context r0 = r0.context
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$5 r1 = new net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$5
                    r1.<init>()
                    net.one97.paytm.nativesdk.Utils.DialogUtility.showDialog(r0, r6, r1)
                    return
                L_0x00ea:
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView r0 = net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.this
                    android.content.Context r0 = r0.context
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$3 r1 = new net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$3
                    r1.<init>()
                    net.one97.paytm.nativesdk.Utils.DialogUtility.showDialog(r0, r6, r1)
                    return
                L_0x00f9:
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView r0 = net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.this
                    android.content.Context r0 = r0.context
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$1 r1 = new net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$1
                    r1.<init>()
                    net.one97.paytm.nativesdk.Utils.DialogUtility.showDialog(r0, r6, r1)
                L_0x0107:
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView r0 = net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.this
                    android.content.Context r0 = r0.context
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$2 r1 = new net.one97.paytm.nativesdk.instruments.wallet.view.WalletView$3$2
                    r1.<init>()
                    net.one97.paytm.nativesdk.Utils.DialogUtility.showDialog(r0, r6, r1)
                    return
                L_0x0116:
                    net.one97.paytm.nativesdk.DirectPaymentBL r6 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
                    net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r6 = r6.getCjPayMethodResponse()
                    net.one97.paytm.nativesdk.common.model.Body r6 = r6.getBody()
                    boolean r6 = r6.isWalletOnly()
                    if (r6 == 0) goto L_0x013f
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView r6 = net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.this
                    net.one97.paytm.nativesdk.databinding.WalletLytInstrumentInfoBinding r6 = r6.walletLytInstrumentInfoBinding
                    android.widget.TextView r6 = r6.tvSendOtp
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView r0 = net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.this
                    android.content.Context r0 = r0.context
                    int r1 = net.one97.paytm.nativesdk.R.string.pay_securely
                    java.lang.String r0 = r0.getString(r1)
                    r6.setText(r0)
                L_0x013f:
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView r6 = net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.this
                    net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletViewModel r6 = r6.walletViewModel
                    r6.hasWalletOtpSent = r4
                    net.one97.paytm.nativesdk.MerchantBL r6 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
                    java.lang.String r6 = r6.getSsoMobileNumber()
                    boolean r0 = android.text.TextUtils.isEmpty(r6)
                    if (r0 != 0) goto L_0x0160
                    java.lang.String r6 = java.lang.String.valueOf(r6)
                    java.lang.String r0 = "OTP sent to  "
                    java.lang.String r6 = r0.concat(r6)
                    goto L_0x0162
                L_0x0160:
                    java.lang.String r6 = "Otp Sent to Mobile number "
                L_0x0162:
                    net.one97.paytm.nativesdk.instruments.wallet.view.WalletView r0 = net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.this
                    android.content.Context r0 = r0.context
                    android.widget.Toast r6 = android.widget.Toast.makeText(r0, r6, r3)
                    r6.show()
                L_0x016f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.instruments.wallet.view.WalletView.AnonymousClass3.onChanged(net.one97.paytm.nativesdk.walletOtp.WalletOtpResponse):void");
            }
        });
        this.walletViewModel.mWalletValidateOtpResponse.observe((q) this.context, new z<WalletOtpResponse>() {
            public void onChanged(WalletOtpResponse walletOtpResponse) {
                if (walletOtpResponse != null && walletOtpResponse.getBody() != null && walletOtpResponse.getBody().getResultInfo() != null) {
                    String resultMsg = walletOtpResponse.getBody().getResultInfo().getResultMsg();
                    if (TextUtils.isEmpty(resultMsg)) {
                        resultMsg = "Some Error occured ";
                    }
                    if (walletOtpResponse.getBody().getResultInfo().equals(AppConstants.FEED_SUB_TYPE)) {
                        if (!TextUtils.isEmpty(walletOtpResponse.getBody().getResultInfo().getResultMsg())) {
                            final String resultMsg2 = walletOtpResponse.getBody().getResultInfo().getResultMsg();
                            DialogUtility.showDialog(WalletView.this.context, resultMsg2, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    if (PaytmSDK.getCallbackListener() != null) {
                                        PaytmSDK.getCallbackListener().onTransactionCancel(resultMsg2);
                                    }
                                }
                            });
                            return;
                        }
                        DialogUtility.showDialog(WalletView.this.context, "Some Error Occured", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                if (PaytmSDK.getCallbackListener() != null) {
                                    PaytmSDK.getCallbackListener().onTransactionCancel("Some Error Occured");
                                }
                            }
                        });
                    } else if (walletOtpResponse.getBody().getResultInfo() != null) {
                        String resultCode = walletOtpResponse.getBody().getResultInfo().getResultCode();
                        if (!TextUtils.isEmpty(resultCode)) {
                            char c2 = 65535;
                            switch (resultCode.hashCode()) {
                                case -1173931575:
                                    if (resultCode.equals("00000900")) {
                                        c2 = 5;
                                        break;
                                    }
                                    break;
                                case 1537:
                                    if (resultCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                                        c2 = 0;
                                        break;
                                    }
                                    break;
                                case 51511:
                                    if (resultCode.equals("403")) {
                                        c2 = 1;
                                        break;
                                    }
                                    break;
                                case 51605:
                                    if (resultCode.equals("434")) {
                                        c2 = 4;
                                        break;
                                    }
                                    break;
                                case 52503:
                                    if (resultCode.equals("513")) {
                                        c2 = 2;
                                        break;
                                    }
                                    break;
                                case 54399:
                                    if (resultCode.equals("708")) {
                                        c2 = 3;
                                        break;
                                    }
                                    break;
                            }
                            if (c2 == 0) {
                                DirectPaymentBL.getInstance().setWalletOtpValidated(true);
                                WalletView.this.mOtpView.hideOtpViewProgress();
                                if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay()) {
                                    WalletView.this.mOtpView.setVisibility(8);
                                    WalletView.this.walletViewModel.proceedClicked(WalletView.this.walletLytInstrumentInfoBinding.walletOtpView.findViewById(R.id.payButton));
                                    return;
                                }
                                WalletView.this.mOtpView.setVisibility(8);
                                WalletView.this.loadInstruments(true);
                            } else if (c2 == 1 || c2 == 2) {
                                WalletView.this.mOtpView.otpError(true);
                                WalletView.this.mOtpView.hideOtpViewProgress();
                            } else if (c2 == 3 || c2 == 4) {
                                WalletView.this.mOtpView.hideOtpViewProgress();
                                DialogUtility.showDialog(WalletView.this.context, resultMsg, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                        PaytmSDK.getCallbackListener().onTransactionCancel("Maximum otp reached for user");
                                    }
                                });
                            } else if (c2 == 5) {
                                WalletView.this.mOtpView.hideOtpViewProgress();
                                DialogUtility.showDialog(WalletView.this.context, resultMsg, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                        if (PaytmSDK.getCallbackListener() != null) {
                                            PaytmSDK.getCallbackListener().onSessionExpire(new CustomVolleyError());
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            }
        });
    }

    public PaytmBaseView getWalletView(PaymentModes paymentModes, InstrumentsSelectionManager instrumentsSelectionManager) {
        this.walletLytInstrumentInfoBinding = (WalletLytInstrumentInfoBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.wallet_lyt_instrument_info, (ViewGroup) null, false);
        this.view = this.walletLytInstrumentInfoBinding.getRoot();
        this.walletToolbarViewModel = (WalletToolbarViewModel) new al((ao) this.context, (al.b) al.a.a((Application) this.context.getApplicationContext())).a(WalletToolbarViewModel.class);
        this.mOtpView = (OtpView) this.view.findViewById(R.id.wallet_otp_view);
        enableDisableView(this.isValid);
        this.walletLytInstrumentInfoBinding.tvBankOffer.setMovementMethod(LinkMovementMethod.getInstance());
        this.walletLytInstrumentInfoBinding.tvConvFee.setMovementMethod(LinkMovementMethod.getInstance());
        this.walletViewModel = new WalletViewModel(this.context, paymentModes, this, this.isValid, instrumentsSelectionManager);
        if (DirectPaymentBL.getInstance().isSubsCriptionFlow() && !DirectPaymentBL.getInstance().isWalletOtpValidated()) {
            this.walletLytInstrumentInfoBinding.btnProceed.setVisibility(8);
            this.walletLytInstrumentInfoBinding.tvSendOtp.setVisibility(0);
            this.walletViewModel.walletSendOtpButtVisibility.set(0);
            this.walletViewModel.hideOtpView();
            this.walletLytInstrumentInfoBinding.tvSendOtp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    WalletView.this.walletLytInstrumentInfoBinding.tvSendOtp.setVisibility(8);
                    WalletView.this.walletLytInstrumentInfoBinding.walletOtpView.setVisibility(0);
                    WalletView.this.mOtpView.setWalletOtpTcVisibilty(8);
                    WalletView.this.walletViewModel.walletOtpTxtVisibility.set(8);
                    WalletView.this.walletViewModel.sendWalletOtp();
                }
            });
            if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay()) {
                this.mOtpView.setpayButtonText(this.context.getString(R.string.confirm_otp));
                String string = this.context.getString(R.string.wallet_otp_text_confirm);
                this.walletViewModel.walletOtpTxtVisibility.set(0);
                this.walletLytInstrumentInfoBinding.tvWalletOtpTc.setText(string);
            } else {
                String string2 = this.context.getString(R.string.wallet_otp_text_add);
                this.walletViewModel.walletOtpTxtVisibility.set(0);
                this.walletLytInstrumentInfoBinding.tvWalletOtpTc.setText(string2);
                this.mOtpView.setpayButtonText("Add and Pay");
            }
            this.walletViewModel.proceedVisible.set(8);
            this.mOtpView.setOtpCalllback(this);
            this.mOtpView.startOtpDetection(this.context);
        }
        this.walletLytInstrumentInfoBinding.setWalletViewModel(this.walletViewModel);
        this.walletToolbarViewModel.getWalletSelection().observe((q) this.context, new z<ToolbarState>() {
            public void onChanged(ToolbarState toolbarState) {
                if (toolbarState instanceof ToolbarState.WalletView) {
                    WalletView.this.selectWallet();
                }
            }
        });
        this.walletToolbarViewModel.initializeToolbar(this.walletViewModel.mPrimaryInformation.get(), paymentModes, ToolbarState.WalletView.INSTANCE);
        this.view = this.walletLytInstrumentInfoBinding.getRoot();
        registerObserVer();
        this.walletLytInstrumentInfoBinding.llWalletSelectContainer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WalletView.this.selectWallet();
            }
        });
        this.walletViewModel.setPaySecurelyText();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                WalletView.this.walletViewModel.setAmount();
            }
        }, 100);
        return this;
    }

    private void scrollScrollView() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                ObjectAnimator.ofInt(WalletView.this.instruments.getScrollView(), "scrollY", new int[]{0}).setDuration(500).start();
            }
        }, 200);
    }

    /* access modifiers changed from: private */
    public void enableDisableView(boolean z) {
        if (z) {
            this.walletLytInstrumentInfoBinding.txtPrimaryInfo.setAlpha(1.0f);
            this.walletLytInstrumentInfoBinding.txtPrimaryInfo.setAlpha(1.0f);
            this.walletLytInstrumentInfoBinding.txtSecondaryInfo.setAlpha(1.0f);
            this.walletLytInstrumentInfoBinding.rbCardNumber.setAlpha(1.0f);
            this.walletLytInstrumentInfoBinding.llWalletView.setClickable(true);
            this.walletLytInstrumentInfoBinding.llWalletSelectContainer.setClickable(true);
            this.walletLytInstrumentInfoBinding.llWalletView.setFocusable(true);
            return;
        }
        this.walletLytInstrumentInfoBinding.txtPrimaryInfo.setAlpha(0.4f);
        this.walletLytInstrumentInfoBinding.txtPrimaryInfo.setAlpha(0.4f);
        this.walletLytInstrumentInfoBinding.txtSecondaryInfo.setAlpha(0.4f);
        this.walletLytInstrumentInfoBinding.rbCardNumber.setAlpha(0.4f);
        this.walletLytInstrumentInfoBinding.llWalletView.setClickable(false);
        this.walletLytInstrumentInfoBinding.llWalletSelectContainer.setClickable(false);
        this.walletLytInstrumentInfoBinding.llWalletView.setFocusable(false);
    }

    public void shouldEnableProceed(boolean z) {
        this.walletLytInstrumentInfoBinding.btnProceed.setEnabled(z);
        this.walletLytInstrumentInfoBinding.btnProceed.setClickable(z);
        this.walletLytInstrumentInfoBinding.llWalletSelectContainer.setClickable(z);
    }

    public void closeView() {
        if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay()) {
            this.walletViewModel.payMethodSelected((View) null);
        } else if (DirectPaymentBL.getInstance().isSubsCriptionFlow() && SDKConstants.ADDANDPAY.equalsIgnoreCase(DirectPaymentBL.getInstance().getPaymentFlowAvailable()) && !DirectPaymentBL.getInstance().isWalletOtpValidated()) {
            this.walletViewModel.hideOtpView();
            this.walletViewModel.payMethodSelected((View) null);
        }
    }

    public void openAutoInstrument() {
        this.walletViewModel.selectPayMethod();
    }

    public void closeCachierSheet() {
        this.instruments.closeCashierSheet();
    }

    public void deselectView() {
        if (DirectPaymentBL.getInstance().getCjPayMethodResponse() != null && DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody() != null) {
            if ((!DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().isWalletOnly() || !SDKConstants.ADDANDPAY.equalsIgnoreCase(DirectPaymentBL.getInstance().getPaymentFlowAvailable())) && !SDKUtils.isOnlyWalletPresent()) {
                this.walletLytInstrumentInfoBinding.tvBankOffer.setVisibility(8);
                this.walletLytInstrumentInfoBinding.txtPrimaryInfo.setTypeface((Typeface) null, 0);
                this.walletToolbarViewModel.selectInstrument(false, ToolbarState.WalletView.INSTANCE);
                this.walletLytInstrumentInfoBinding.rbCardNumber.setChecked(false);
                this.walletViewModel.proceedVisible.set(8);
                if (DirectPaymentBL.getInstance().isSubsCriptionFlow()) {
                    hideSubscriptionViews();
                }
                this.walletViewModel.convFeeTextVisibility.set(8);
                if (DirectPaymentBL.getInstance().getPaytmBaseView() != null && (DirectPaymentBL.getInstance().getPaytmBaseView() instanceof WalletView) && !SDKUtility.isHybridSupported()) {
                    DirectPaymentBL.getInstance().setPaytmBaseView((PaytmBaseView) null);
                }
                setSelected(false);
                this.walletViewModel.showHideBankOfferError(false);
            }
        }
    }

    private void hideSubscriptionViews() {
        if (this.mOtpView.getVisibility() == 0) {
            this.mOtpView.setVisibility(8);
        }
        if (this.walletLytInstrumentInfoBinding.tvSendOtp.getVisibility() == 0) {
            this.mOtpView.setVisibility(8);
        }
        if (this.walletLytInstrumentInfoBinding.tvWalletOtpTc.getVisibility() == 0) {
            this.mOtpView.setVisibility(8);
        }
    }

    public void disableView(boolean z) {
        enableDisableView(!z);
        changeBehaviour(false);
    }

    private void enableDisableOtpView(boolean z) {
        if (z) {
            this.walletLytInstrumentInfoBinding.tvSendOtp.setVisibility(0);
        } else {
            this.walletLytInstrumentInfoBinding.tvSendOtp.setVisibility(8);
        }
    }

    public void setSelectedView() {
        if (!SDKUtility.isHybridSupported() || !DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
            DirectPaymentBL.getInstance().setPaytmBaseView(this);
        }
        this.walletLytInstrumentInfoBinding.txtPrimaryInfo.setTypeface((Typeface) null, 1);
        if (!DirectPaymentBL.getInstance().isWalletAmountSufficientToPay()) {
            this.walletToolbarViewModel.selectInstrument(true, ToolbarState.WalletView.INSTANCE);
        }
        this.walletLytInstrumentInfoBinding.rbCardNumber.setChecked(true);
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_CLICKED, SDKConstants.AI_KEY_WALLET, H5Param.DEFAULT_LONG_PRESSO_LOGIN));
        }
        changeBehaviour(false);
        setSelected(true);
        this.walletViewModel.showHideBankOfferError(true);
    }

    public void loadInstruments(boolean z) {
        this.instruments.loadInstruments(z);
    }

    public void changeOutsidePaytmWallet(boolean z) {
        this.walletToolbarViewModel.selectInstrument(z, ToolbarState.WalletView.INSTANCE);
    }

    public void inflateBalanceViews(ArrayList<SubWalletDetail> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TextView textView = (TextView) LayoutInflater.from(this.context).inflate(R.layout.native_item_wallet_balance, this.walletLytInstrumentInfoBinding.llWalletBalance, false);
            textView.setText(arrayList.get(i2).getDisplayName() + " " + this.context.getString(R.string.rupee_symbol) + arrayList.get(i2).getBalance());
            this.walletLytInstrumentInfoBinding.llWalletBalance.addView(textView);
        }
    }

    public Object getVerifyResponseModel() {
        return this.walletViewModel.getVerifyResponseModel();
    }

    public void enableProceedButton() {
        this.walletLytInstrumentInfoBinding.btnProceed.setEnabled(true);
        this.walletLytInstrumentInfoBinding.btnProceed.setClickable(true);
    }

    public void disableProceedButton() {
        this.walletLytInstrumentInfoBinding.btnProceed.setEnabled(false);
        this.walletLytInstrumentInfoBinding.btnProceed.setClickable(false);
    }

    public void startCheckingOfferAnimation() {
        SDKUtility.startAnimation(this.walletLytInstrumentInfoBinding.ltvGetOffers);
    }

    public void stopCheckingOfferAnimation() {
        SDKUtility.stopAnimation(this.walletLytInstrumentInfoBinding.ltvGetOffers);
    }

    private boolean isTenureSelected() {
        if (!this.isValid || DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() || DirectPaymentBL.getInstance().isRemainingAmountInDecimals() || !DirectPaymentBL.getInstance().isMultiItemEmiFlow()) {
            return false;
        }
        if (DirectPaymentBL.getInstance().getPaytmBaseView() instanceof EmiView) {
            return ((EmiView) DirectPaymentBL.getInstance().getPaytmBaseView()).isTenureSelected();
        }
        if (DirectPaymentBL.getInstance().getPaytmBaseView() instanceof SavedCardView) {
            return ((SavedCardView) DirectPaymentBL.getInstance().getPaytmBaseView()).isTenureSelected();
        }
        if (DirectPaymentBL.getInstance().getLastSelectedEmiSavedView() != null) {
            return ((SavedCardView) DirectPaymentBL.getInstance().getPaytmBaseView()).isTenureSelected();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void selectWallet() {
        if (isTenureSelected()) {
            showTenureDialog();
        } else {
            this.walletViewModel.payMethodSelected((View) null);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.context != null) {
                this.context.unregisterReceiver(this.networkConnectivityReceiver);
                a.a(this.context).a(this.broadcastReceiver);
            }
        } catch (Exception unused) {
        }
    }

    private void showTenureDialog() {
        DialogUtility.showTwoButtonDialogNew(this.context, "Are you sure?", !this.walletLytInstrumentInfoBinding.rbCardNumber.isChecked() ? "If you select Paytm Balance, you will have to re-select the EMI tenure to proceed with payment" : "If you uncheck Paytm Balance, you will have to re-select the EMI tenure to proceed with payment.", Payload.RESPONSE_OK, "Cancel", new SetOnAlertButtonListeners() {
            public void onNegativeClicked() {
            }

            public void onPositiveClicked() {
                WalletView.this.walletViewModel.payMethodSelected((View) null);
            }
        });
    }

    public boolean isHybridDisabled() {
        return this.walletViewModel.isHybridDisabled();
    }

    public boolean isEmiHybridDisabled() {
        return this.walletViewModel.isEmiHybridDisabled();
    }

    public void onOtpClickedValidated(String str) {
        this.walletViewModel.validateWalletOtp(str);
    }

    public void onResendOtpClicked() {
        if (this.resendCount < Constants.MAXIMUM_RESEND_LIMIT) {
            this.walletViewModel.sendWalletOtp();
        } else {
            Toast.makeText(this.context, "Maximum Resend limit Reached,Please try again in 10 sc", 0).show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int unused = WalletView.this.resendCount = 0;
                }
            }, 10000);
        }
        this.resendCount++;
    }
}

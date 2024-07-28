package net.one97.paytm.nativesdk.instruments;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import androidx.localbroadcastmanager.a.a;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.android.volley.Request;
import net.one97.paytm.nativesdk.ApiSession;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.CustomSnackBar;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.bank_mandate.view.BankMandateAllOtherBanksFragment;
import net.one97.paytm.nativesdk.bank_mandate.view.BankMandateFindIFSCFragment;
import net.one97.paytm.nativesdk.bank_mandate.view.BankMandateStateCityBrFragment;
import net.one97.paytm.nativesdk.bank_mandate.view.BankMandateSubscriptionDetailsFragment;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.listeners.ActivityInteractor;
import net.one97.paytm.nativesdk.common.listeners.PayFragmentInteractor;
import net.one97.paytm.nativesdk.common.listeners.SetOnAlertButtonListeners;
import net.one97.paytm.nativesdk.common.listeners.WalletStateChangeListener;
import net.one97.paytm.nativesdk.common.view.activity.BaseActivity;
import net.one97.paytm.nativesdk.databinding.NativeInstrumentBinding;
import net.one97.paytm.nativesdk.instruments.netbanking.view.NetBankingView;
import net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.listeners.OnBottomSheetChangeListener;
import net.one97.paytm.nativesdk.paymethods.listeners.OnPayMethodSelectedListener;
import net.one97.paytm.nativesdk.paymethods.listeners.UpiEncouragementListener;
import net.one97.paytm.nativesdk.paymethods.views.fragments.AppInvokeSheet;
import net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet;
import net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet;
import net.one97.paytm.nativesdk.paymethods.views.fragments.LoadingInstrumentFragment;
import net.one97.paytm.nativesdk.paymethods.views.fragments.OrderSummaryFragment;
import net.one97.paytm.nativesdk.transcation.PayFragment;
import net.one97.paytm.nativesdk.transcation.view.TranscationStatusSheet;
import net.one97.paytm.nativesdk.widget.RetryBottomSheet;
import net.one97.paytm.upi.common.upi.CommonPayParams;

public class InstrumentActivity extends BaseActivity implements ActivityInteractor, PayFragmentInteractor, WalletStateChangeListener, OnBottomSheetChangeListener, OnPayMethodSelectedListener, UpiEncouragementListener {
    public static int PAYACTIVITY_REQUEST_CODE = 11;
    public static int SHOW_ALERT = 12;
    private AlertDialog backPressAlertDialog;
    /* access modifiers changed from: private */
    public NativeInstrumentBinding binding;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (SDKConstants.ONBOARDING_BROADCAST.equalsIgnoreCase(intent.getAction())) {
                SDKUtility.openUPIOnboarding(InstrumentActivity.this);
            }
        }
    };
    private boolean disableUiInteraction = false;
    private Handler orderSummaryHandler;
    private Runnable orderSummaryRunnable;
    private boolean shouldKillActivity = true;
    /* access modifiers changed from: private */
    public TranscationStatusSheet transcationStatusSheet;

    public void OnPayMethodSelected() {
    }

    public void addPageVisibleGAEvent() {
    }

    public String getChildClassName() {
        return "InstrumentActivity";
    }

    public void onDestroy() {
        super.onDestroy();
        PaytmBaseView.isOnceClicked = false;
        ApiSession.getInstance().destroySession();
        unregisterBroadCast(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r4) {
        /*
            r3 = this;
            net.one97.paytm.nativesdk.MerchantBL r0 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            boolean r0 = r0.isTransparentAppInvoke()
            if (r0 != 0) goto L_0x000f
            int r0 = net.one97.paytm.nativesdk.R.style.NativePaytmAppTheme
            r3.setTheme(r0)
        L_0x000f:
            super.onCreate(r4)
            int r4 = net.one97.paytm.nativesdk.R.layout.native_instrument
            androidx.databinding.ViewDataBinding r4 = androidx.databinding.f.a(r3, r4)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentBinding r4 = (net.one97.paytm.nativesdk.databinding.NativeInstrumentBinding) r4
            r3.binding = r4
            androidx.appcompat.app.ActionBar r4 = r3.getSupportActionBar()
            if (r4 == 0) goto L_0x0029
            androidx.appcompat.app.ActionBar r4 = r3.getSupportActionBar()
            r4.f()
        L_0x0029:
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            boolean r4 = r4.isTransparentAppInvoke()
            java.lang.String r0 = "transaction_amount"
            java.lang.String r1 = ""
            if (r4 == 0) goto L_0x0050
            java.lang.String r4 = "bottom_sheet_app_invoke"
            java.util.Map r4 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParams(r4, r1)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r4)
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r4 = r4.getAmount()
            java.util.Map r4 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParams(r0, r4)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r4)
            goto L_0x0072
        L_0x0050:
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            boolean r4 = r4.isAppInvoke()
            if (r4 == 0) goto L_0x0072
            java.lang.String r4 = "full_screen_app_invoke"
            java.util.Map r4 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParams(r4, r1)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r4)
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r4 = r4.getAmount()
            java.util.Map r4 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParams(r0, r4)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r4)
        L_0x0072:
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            boolean r4 = r4.isTransparentAppInvoke()
            if (r4 == 0) goto L_0x0089
            androidx.lifecycle.k r4 = r3.getLifecycle()
            net.one97.paytm.nativesdk.paymethods.views.fragments.AppInvokeLifecycleListener r0 = new net.one97.paytm.nativesdk.paymethods.views.fragments.AppInvokeLifecycleListener
            r0.<init>(r3)
            r4.a(r0)
            goto L_0x0097
        L_0x0089:
            net.one97.paytm.nativesdk.DirectPaymentBL r4 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            boolean r4 = r4.isFetchPayCallRequired()
            if (r4 == 0) goto L_0x0097
            r3.openLoadingSheet()
            goto L_0x009a
        L_0x0097:
            r3.openInstrumentationSheet()
        L_0x009a:
            boolean r4 = net.one97.paytm.nativesdk.Utils.SDKUtility.isAppInvokeFlow()
            if (r4 == 0) goto L_0x00a7
            net.one97.paytm.nativesdk.common.helpers.PCFHelperAIO r4 = net.one97.paytm.nativesdk.common.helpers.PCFHelperAIO.getInstance()
            net.one97.paytm.nativesdk.PaytmSDK.setCheckoutCallbackListener(r4)
        L_0x00a7:
            net.one97.paytm.nativesdk.DirectPaymentBL r4 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r4 = r4.getCjPayMethodResponse()
            r0 = 0
            if (r4 == 0) goto L_0x00e2
            net.one97.paytm.nativesdk.DirectPaymentBL r4 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r4 = r4.getCjPayMethodResponse()
            net.one97.paytm.nativesdk.common.model.Body r4 = r4.getBody()
            if (r4 == 0) goto L_0x00e2
            net.one97.paytm.nativesdk.DirectPaymentBL r4 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r4 = r4.getCjPayMethodResponse()
            net.one97.paytm.nativesdk.common.model.Body r4 = r4.getBody()
            net.one97.paytm.nativesdk.common.model.PromoCodeData r4 = r4.getPromoCodeData()
            if (r4 == 0) goto L_0x00db
            net.one97.paytm.nativesdk.DirectPaymentBL r4 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            r2 = 1
            r4.setPromoCodeExist(r2)
            goto L_0x00e2
        L_0x00db:
            net.one97.paytm.nativesdk.DirectPaymentBL r4 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            r4.setPromoCodeExist(r0)
        L_0x00e2:
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            boolean r4 = r4.isRetryTransaction()
            if (r4 == 0) goto L_0x00fe
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r4 = r4.getRetryErrorMsg()
            r3.showRetryDialog(r4)
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            r4.setRetryTransaction(r0)
        L_0x00fe:
            java.util.Map r4 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r1, r1, r1, r1)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r4)
            net.one97.paytm.nativesdk.Utils.NativeOtpHelper r4 = new net.one97.paytm.nativesdk.Utils.NativeOtpHelper
            r0 = 0
            r4.<init>(r3, r0)
            boolean r0 = r4.hasReadSmsPermission()
            if (r0 == 0) goto L_0x011a
            boolean r0 = r4.hasOnlyReceiveSmsPermission()
            if (r0 != 0) goto L_0x011a
            r4.requestReceiveSmsPermission()
        L_0x011a:
            boolean r0 = r4.hasReadSmsPermission()
            if (r0 != 0) goto L_0x0129
            boolean r0 = r4.hasOnlyReceiveSmsPermission()
            if (r0 == 0) goto L_0x0129
            r4.requestReadSmsPermission()
        L_0x0129:
            android.content.IntentFilter r4 = new android.content.IntentFilter
            r4.<init>()
            java.lang.String r0 = "ONBOARDING_BROADCAST"
            r4.addAction(r0)
            android.content.Context r0 = r3.getApplicationContext()
            androidx.localbroadcastmanager.a.a r0 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r0)
            android.content.BroadcastReceiver r1 = r3.broadcastReceiver
            r0.a(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.instruments.InstrumentActivity.onCreate(android.os.Bundle):void");
    }

    private void unregisterBroadCast(Context context) {
        try {
            a.a(context).a(this.broadcastReceiver);
        } catch (Exception unused) {
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onBackPressed() {
        Fragment c2 = getSupportFragmentManager().c(PayFragment.class.getSimpleName());
        if (c2 instanceof PayFragment) {
            ((PayFragment) c2).onBackPressed();
            return;
        }
        Fragment c3 = getSupportFragmentManager().c(InstrumentsSheet.class.getName());
        if (c3 instanceof InstrumentsSheet) {
            InstrumentsSheet instrumentsSheet = (InstrumentsSheet) c3;
            if (instrumentsSheet.isOrderPopupShowing()) {
                instrumentsSheet.dismissPopupWindow();
                return;
            }
        }
        Fragment c4 = getSupportFragmentManager().c(BankMandateAllOtherBanksFragment.class.getSimpleName());
        if (c4 instanceof BankMandateAllOtherBanksFragment) {
            ((BankMandateAllOtherBanksFragment) c4).onBackPressed();
            return;
        }
        Fragment c5 = getSupportFragmentManager().c(BankMandateFindIFSCFragment.class.getSimpleName());
        if (c5 instanceof BankMandateFindIFSCFragment) {
            ((BankMandateFindIFSCFragment) c5).onBackPressed();
            return;
        }
        Fragment c6 = getSupportFragmentManager().c(BankMandateStateCityBrFragment.class.getSimpleName());
        if (c6 instanceof BankMandateStateCityBrFragment) {
            ((BankMandateStateCityBrFragment) c6).onBackPressed();
            return;
        }
        Fragment c7 = getSupportFragmentManager().c(BankMandateSubscriptionDetailsFragment.class.getSimpleName());
        if (c7 instanceof BankMandateSubscriptionDetailsFragment) {
            ((BankMandateSubscriptionDetailsFragment) c7).onBackPressed();
            return;
        }
        if (SDKUtility.isNetBankingTransactionProcessing()) {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_REDIRECTION, SDKConstants.GA_NB_REDIRECTION_BACK_CLICKED, DirectPaymentBL.getInstance().getBankName()));
        } else {
            PaytmBaseView paytmBaseView = DirectPaymentBL.getInstance().getPaytmBaseView();
            if (paytmBaseView instanceof NetBankingView) {
                ((NetBankingView) paytmBaseView).sendGAEventBackPressed();
            }
        }
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("back_button_clicked", "", ""));
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams("back_button_clicked", ""));
        }
        if (this.backPressAlertDialog == null) {
            DialogUtility.showTwoButtonDialogNew(this, getString(R.string.native_back_press_title), (String) null, CommonPayParams.Builder.YES, CommonPayParams.Builder.NO, new SetOnAlertButtonListeners() {
                public void onPositiveClicked() {
                    InstrumentActivity.this.callCloseOrder();
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.GA_KEY_CANCEL_PAYMENT, CommonPayParams.Builder.YES, ""));
                    if (SDKUtility.isAppInvokeFlow()) {
                        SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_CANCEL_TRANSACTION_CLICKED, CommonPayParams.Builder.YES));
                    }
                    if (SDKUtility.isNetBankingTransactionProcessing()) {
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_REDIRECTION, SDKConstants.GA_NB_REDIRECTION_BACK_CLICKED_CONFIRMED, DirectPaymentBL.getInstance().getBankName()));
                    }
                    InstrumentActivity.this.dismissAlertDialog();
                }

                public void onNegativeClicked() {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.GA_KEY_CANCEL_PAYMENT, CommonPayParams.Builder.NO, ""));
                    if (SDKUtility.isNetBankingTransactionProcessing()) {
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_REDIRECTION, SDKConstants.GA_NB_REDIRECTION_BACK_CLICKED_CANCELLED, DirectPaymentBL.getInstance().getBankName()));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Fragment c2 = getSupportFragmentManager().c(PayFragment.class.getSimpleName());
        if (c2 instanceof PayFragment) {
            ((PayFragment) c2).onUserLeaveHint();
        } else if (SDKUtility.isNetBankingTransactionProcessing()) {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_REDIRECTION, SDKConstants.GA_NB_REDIRECTION_HOME_CLICKED, DirectPaymentBL.getInstance().getBankName()));
        }
    }

    /* access modifiers changed from: private */
    public void dismissAlertDialog() {
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().onBackPressedCancelTransaction();
        }
        Intent intent = new Intent("kill");
        intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
        a.a(getApplicationContext()).a(intent);
    }

    /* access modifiers changed from: private */
    public void callCloseOrder() {
        if (MerchantBL.getMerchantInstance().getOrderId() != null) {
            NativeSDKRepository.getInstance().notifyServerAboutCloseOrder();
        }
    }

    public void saveActivityFromFinish(String str) {
        if (getChildClassName().equalsIgnoreCase(str)) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    TranscationStatusSheet unused = InstrumentActivity.this.transcationStatusSheet = new TranscationStatusSheet();
                    InstrumentActivity.this.transcationStatusSheet.setCancelable(false);
                    InstrumentActivity.this.transcationStatusSheet.show(InstrumentActivity.this.getSupportFragmentManager(), (String) null);
                }
            }, 200);
        } else {
            finish();
        }
    }

    public void onResume() {
        super.onResume();
    }

    private void showRetryDialog(String str, TransactionProcessor transactionProcessor) {
        if (transactionProcessor == null || !transactionProcessor.isOnClickFlow()) {
            showRetryDialog(str);
        } else {
            RetryBottomSheet.getInstance(str).show(getSupportFragmentManager(), RetryBottomSheet.TAG);
        }
    }

    private void showRetryDialog(String str) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_retry, (ViewGroup) null, false);
        if (!TextUtils.isEmpty(str)) {
            ((TextView) inflate.findViewById(R.id.tv_rejection)).setText(str);
        }
        final AlertDialog create = new AlertDialog.Builder(this).setView(inflate).create();
        inflate.findViewById(R.id.tv_okGotIt).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
            }
        });
        if (create.getWindow() != null) {
            create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        create.show();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        create.getWindow().setLayout(DialogUtility.getDialogWidth(this), -2);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != PAYACTIVITY_REQUEST_CODE || i3 != SHOW_ALERT) {
            Fragment c2 = getSupportFragmentManager().c(InstrumentsSheet.class.getName());
            if (c2 != null) {
                c2.onActivityResult(i2, i3, intent);
            }
            Fragment c3 = getSupportFragmentManager().c(AppInvokeSheet.TAG);
            if (c3 != null) {
                c3.onActivityResult(i2, i3, intent);
            }
        } else if (intent != null) {
            showRetryDialog(intent.getStringExtra("data"));
        }
    }

    private void showUpiDialog() {
        if (DirectPaymentBL.getInstance().getUpiOptionsModel() != null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_upi_opening_app, (ViewGroup) null, false);
            final AlertDialog create = new AlertDialog.Builder(this).setView(inflate).create();
            create.setCancelable(false);
            ((TextView) inflate.findViewById(R.id.tv_please_wait_upi)).setText(getString(R.string.native_please_wait_upi, new Object[]{DirectPaymentBL.getInstance().getUpiOptionsModel().getAppName()}));
            ((ImageView) inflate.findViewById(R.id.iv_appIcon)).setImageDrawable(DirectPaymentBL.getInstance().getUpiOptionsModel().getDrawable());
            create.getWindow().setLayout((int) (((double) Resources.getSystem().getDisplayMetrics().widthPixels) * 0.7d), -2);
            create.show();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    create.dismiss();
                    DirectPaymentBL.getInstance().setUpiOptionsModel((UpiOptionsModel) null);
                }
            }, 6000);
        }
    }

    public boolean shouldKillActivity() {
        return this.shouldKillActivity;
    }

    public void autoSelectUpiPushView(String str) {
        Fragment c2 = getSupportFragmentManager().c(InstrumentsSheet.class.getName());
        if (c2 instanceof BaseInstrumentSheet) {
            ((BaseInstrumentSheet) c2).autoSelectUpiPushView(str);
        }
        Fragment c3 = getSupportFragmentManager().c(AppInvokeSheet.TAG);
        if (c3 instanceof BaseInstrumentSheet) {
            ((BaseInstrumentSheet) c3).autoSelectUpiPushView(str);
        }
    }

    public void onNetworkUnavailable(Request request) {
        DialogUtility.showTwoButtonDialogNew(this, getResources().getString(R.string.alert), getResources().getString(R.string.internet_not_available), "Retry", "Exit", new SetOnAlertButtonListeners() {
            public void onPositiveClicked() {
            }

            public void onNegativeClicked() {
                if (PaytmSDK.getCallbackListener() != null) {
                    PaytmSDK.getCallbackListener().networkError();
                }
                a.a((Context) InstrumentActivity.this).a(new Intent("kill"));
            }
        });
    }

    public void onChangeBottomSheet(String str, boolean z) {
        openInstrumentationSheet();
    }

    public void openInstrumentationSheet() {
        String str;
        Fragment fragment;
        removeAllCallbacks();
        Fragment c2 = getSupportFragmentManager().c(InstrumentsSheet.class.getName());
        if (c2 == null) {
            getWindow().clearFlags(TarConstants.EOF_BLOCK);
            if (MerchantBL.getMerchantInstance().isTransparentAppInvoke()) {
                fragment = AppInvokeSheet.getInstance(getIntent().getStringExtra(SDKConstants.KEY_INSTRUMENT_PRIMARY_INFO), getIntent().getStringExtra(SDKConstants.KEY_INSTRUMENT_SECONDARY_INFO), getIntent().getIntExtra(SDKConstants.MERCHANT_LOGO, 0));
                str = AppInvokeSheet.TAG;
            } else {
                fragment = InstrumentsSheet.getInstance(getIntent().getStringExtra(SDKConstants.KEY_INSTRUMENT_PRIMARY_INFO), getIntent().getStringExtra(SDKConstants.KEY_INSTRUMENT_SECONDARY_INFO), getIntent().getIntExtra(SDKConstants.MERCHANT_LOGO, 0));
                str = InstrumentsSheet.class.getName();
            }
            getSupportFragmentManager().a((String) null, 0);
            getSupportFragmentManager().a().a(R.id.fragment_container, fragment, str).k().c(fragment).b();
        } else if (c2 instanceof InstrumentsSheet) {
            ((InstrumentsSheet) c2).refreshUpiView();
        }
    }

    private void openLoadingSheet() {
        Bundle bundle = new Bundle();
        LoadingInstrumentFragment loadingInstrumentFragment = new LoadingInstrumentFragment();
        bundle.putString(SDKConstants.INTENT, SDKConstants.SELECTED);
        loadingInstrumentFragment.setArguments(bundle);
        loadingInstrumentFragment.setBottomSheetChangeListener(this);
        getSupportFragmentManager().a().a(R.anim.slide_in_right, 0, 0, 0).k().a(R.id.fragment_container, loadingInstrumentFragment, LoadingInstrumentFragment.class.getName()).b();
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        removeAllCallbacks();
    }

    private void removeAllCallbacks() {
        Runnable runnable;
        Handler handler = this.orderSummaryHandler;
        if (!(handler == null || (runnable = this.orderSummaryRunnable) == null)) {
            handler.removeCallbacks(runnable);
        }
        this.shouldKillActivity = true;
    }

    public void disableUiInteraction() {
        DirectPaymentBL.getInstance().setTransactionProcessing(true);
        setDisableUiInteraction(true);
        findViewById(R.id.disableClickView).setVisibility(0);
        findViewById(R.id.disableClickView).setClickable(true);
    }

    public void enableUiInteraction() {
        DirectPaymentBL.getInstance().setTransactionProcessing(false);
        setDisableUiInteraction(false);
        findViewById(R.id.disableClickView).setVisibility(8);
        findViewById(R.id.disableClickView).setClickable(false);
        AlertDialog alertDialog = this.backPressAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void disableSelectedUpiPayOption(String str) {
        Fragment c2 = getSupportFragmentManager().c(InstrumentsSheet.class.getName());
        if (c2 instanceof BaseInstrumentSheet) {
            ((BaseInstrumentSheet) c2).disableSelectedUpiOption(str);
        }
        Fragment c3 = getSupportFragmentManager().c(AppInvokeSheet.TAG);
        if (c3 instanceof BaseInstrumentSheet) {
            ((BaseInstrumentSheet) c3).disableSelectedUpiOption(str);
        }
    }

    public void onPaymentFailed(String str, String str2, TransactionProcessor transactionProcessor) {
        if (SDKConstants.VISA_GOOGLE_SAFTEY_NET_ERROR.equals(str2) && DirectPaymentBL.getInstance().getPaytmBaseView() != null) {
            DirectPaymentBL.getInstance().getPaytmBaseView().setIsVSCPEligible(false);
            DirectPaymentBL.getInstance().getPaytmBaseView().refreshLayout();
        }
        showRetryDialog(str, transactionProcessor);
    }

    public boolean isDisableUiInteraction() {
        return this.disableUiInteraction;
    }

    public void setDisableUiInteraction(boolean z) {
        this.disableUiInteraction = z;
    }

    public void backToCashierPage(Fragment fragment, String str, boolean z) {
        onWebPageFinish();
        q a2 = getSupportFragmentManager().a();
        a2.a(fragment);
        a2.c();
        if (z) {
            if (DirectPaymentBL.getInstance().getPaytmBaseView() != null) {
                DirectPaymentBL.getInstance().getPaytmBaseView().refreshLayout();
            }
            showRetryDialog(str);
        }
    }

    public void addPayFragment(Bundle bundle) {
        PayFragment payFragment = new PayFragment();
        payFragment.setArguments(bundle);
        q a2 = getSupportFragmentManager().a();
        a2.a(R.id.fragment_container, payFragment, PayFragment.class.getSimpleName());
        a2.c();
    }

    public void onWebPageFinish() {
        enableUiInteraction();
        Fragment c2 = getSupportFragmentManager().c(InstrumentsSheet.class.getName());
        if (c2 instanceof BaseInstrumentSheet) {
            ((BaseInstrumentSheet) c2).onWebViewFinished();
        }
        Fragment c3 = getSupportFragmentManager().c(AppInvokeSheet.TAG);
        if (c3 instanceof BaseInstrumentSheet) {
            ((BaseInstrumentSheet) c3).onWebViewFinished();
        }
        SDKUtils.dismissLoadingSheet(this);
    }

    public void onWalletStateChange() {
        Fragment c2 = getSupportFragmentManager().c(InstrumentsSheet.class.getName());
        if (c2 instanceof BaseInstrumentSheet) {
            ((BaseInstrumentSheet) c2).onWalletStateChange();
        }
        Fragment c3 = getSupportFragmentManager().c(AppInvokeSheet.TAG);
        if (c3 instanceof BaseInstrumentSheet) {
            ((BaseInstrumentSheet) c3).onWalletStateChange();
        }
    }

    public void showErrorMsg(String str, String str2, String str3, boolean z) {
        final View inflate = LayoutInflater.from(this).inflate(R.layout.layout_error_msg, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_errorMsg);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(str2);
        }
        inflate.findViewById(R.id.tv_action).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomSnackBar.hideView(InstrumentActivity.this.binding.clContentView, inflate);
            }
        });
        if (!z) {
            inflate.setBackgroundColor(getResources().getColor(R.color.red));
        }
        inflate.setVisibility(8);
        CustomSnackBar.showView(this.binding.clContentView, inflate, CustomSnackBar.Duration.LENGTH_LONG);
    }

    public void showOrderInfoFragment(Bundle bundle, String str, boolean z) {
        this.shouldKillActivity = z;
        removeAllFragments();
        OrderSummaryFragment orderSummaryFragment = new OrderSummaryFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("data", bundle);
        bundle2.putString(SDKConstants.STATUS, str);
        orderSummaryFragment.setArguments(bundle2);
        orderSummaryFragment.show(getSupportFragmentManager(), OrderSummaryFragment.TAG);
        startTimer(bundle);
    }

    public void removeAllFragments() {
        for (Fragment a2 : getSupportFragmentManager().f3424a.d()) {
            getSupportFragmentManager().a().a(a2).c();
        }
    }

    private void startTimer(final Bundle bundle) {
        this.orderSummaryHandler = new Handler();
        this.orderSummaryRunnable = new Runnable() {
            public void run() {
                if (!InstrumentActivity.this.isFinishing()) {
                    if (PaytmSDK.getCallbackListener() != null) {
                        PaytmSDK.getCallbackListener().onTransactionResponse(bundle);
                    }
                    InstrumentActivity.this.finish();
                }
            }
        };
        this.orderSummaryHandler.postDelayed(this.orderSummaryRunnable, 2000);
    }

    public boolean isUIEnable() {
        return !this.disableUiInteraction;
    }
}

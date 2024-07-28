package net.one97.paytm.nativesdk.instruments.upicollect.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.databinding.f;
import androidx.localbroadcastmanager.a.a;
import androidx.recyclerview.widget.GridLayoutManager;
import com.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.HealthType;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBinding;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.upicollect.listeners.UpiCollectListener;
import net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel;
import net.one97.paytm.nativesdk.instruments.upicollect.view.UpiAppListAdapter;
import net.one97.paytm.nativesdk.instruments.upicollect.viewmodel.UpiCollectViewModelNew;
import net.one97.paytm.nativesdk.instruments.upipush.model.MetaData;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public class UpiCollectViewNew extends PaytmBaseView implements UpiCollectListener {
    public static final int REQUEST_CODE_ALL_APPS = 10;
    public static final int REQUEST_CODE_UPI_APP = 187;
    /* access modifiers changed from: private */
    public BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (SDKConstants.APP_SELECTED_FROM_UPI_LIST.equalsIgnoreCase(intent.getAction())) {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_ONBOARDING, SDKConstants.UPI_HANDLE_SELECTED, MerchantBL.getMerchantInstance().getOrderId(), intent.getStringExtra("dataName"), MerchantBL.getMerchantInstance().getMid()));
                try {
                    a.a(UpiCollectViewNew.this.context).a(UpiCollectViewNew.this.broadcastReceiver);
                } catch (Exception e2) {
                    LogUtility.printStackTrace(e2);
                }
                ResolveInfo resolveInfo = (ResolveInfo) intent.getParcelableExtra("dataInfo");
                if (resolveInfo != null) {
                    if ("net.one97.paytm".equalsIgnoreCase(resolveInfo.activityInfo.packageName)) {
                        VpaBankAccountDetail primaryVpa = UpiCollectViewNew.this.upiCollectViewModel.getPrimaryVpa();
                        if (primaryVpa == null || !SDKUtility.isUpiPushEnabled() || !SDKUtility.isPaytmApp(UpiCollectViewNew.this.context)) {
                            UpiCollectViewNew.this.upiCollectViewModel.setSelectedUpiOptionsModel(new UpiOptionsModel(resolveInfo, intent.getStringExtra("dataName"), resolveInfo.loadIcon(UpiCollectViewNew.this.context.getPackageManager())));
                            boolean unused = UpiCollectViewNew.this.isToShowDialog = true;
                            return;
                        }
                        SDKUtility.startUpiPush(UpiCollectViewNew.this.context, primaryVpa, "intent", "");
                        return;
                    }
                    UpiCollectViewNew.this.upiAppListAdapter.setSelectedPosition(UpiCollectViewNew.this.getPosition(intent.getStringExtra("dataName")));
                    UpiCollectViewNew.this.upiAppListAdapter.notifyDataSetChanged();
                    UpiCollectViewNew.this.upiCollectViewModel.setSelectedUpiOptionsModel(new UpiOptionsModel(resolveInfo, intent.getStringExtra("dataName"), resolveInfo.loadIcon(UpiCollectViewNew.this.context.getPackageManager())));
                    boolean unused2 = UpiCollectViewNew.this.isToShowDialog = true;
                }
            }
        }
    };
    private AlertDialog dialogFetchDeeplink;
    private boolean isEnhancedViewEnabled = true;
    /* access modifiers changed from: private */
    public boolean isToShowDialog = false;
    private PaymentModes paymentModes;
    /* access modifiers changed from: private */
    public UpiAppListAdapter upiAppListAdapter;
    private ArrayList<UpiOptionsModel> upiAppsInstalled;
    /* access modifiers changed from: private */
    public UpiCollectLayoutNewBinding upiCollectLayoutBinding;
    /* access modifiers changed from: private */
    public UpiCollectViewModelNew upiCollectViewModel;
    private ArrayList<UpiOptionsModel> upiOptionsModels = new ArrayList<>();

    public void setPaySecurelyText(String str) {
    }

    public void onIntentFlowComplete() {
        UpiAppListAdapter upiAppListAdapter2 = this.upiAppListAdapter;
        if (upiAppListAdapter2 != null) {
            if (upiAppListAdapter2.getSelectedPosition() > 3) {
                this.upiAppListAdapter.setSelectedPosition(0);
                ArrayList<UpiOptionsModel> arrayList = this.upiAppsInstalled;
                if (arrayList != null && arrayList.size() > 0) {
                    this.upiCollectViewModel.setSelectedUpiOptionsModel(this.upiAppsInstalled.get(0));
                }
            }
            this.upiAppListAdapter.notifyDataSetChanged();
        }
    }

    public void startLottieAnimation() {
        LottieAnimationView lottieAnimationView = this.upiCollectLayoutBinding.ltvGetOffers;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
    }

    public void showUpiIntent() {
        this.upiCollectViewModel.vpaInputLayoutVisibility.set(this.upiCollectViewModel.isUpiIntentEnabled() ? 0 : 8);
        this.upiCollectViewModel.upiCollectVisibility.set(8);
        ArrayList<UpiOptionsModel> arrayList = this.upiAppsInstalled;
        if (arrayList == null || arrayList.size() != 1 || !this.upiAppsInstalled.get(0).getAppName().equalsIgnoreCase("Paytm") || !SDKUtility.isPaytmApp(this.context)) {
            this.upiCollectLayoutBinding.btnProceed.setVisibility(8);
            this.upiCollectLayoutBinding.btnProceed2.setVisibility(0);
            if (SDKUtility.shouldShowValidatePromoError()) {
                UpiCollectViewModelNew upiCollectViewModelNew = this.upiCollectViewModel;
                upiCollectViewModelNew.setValidatePromoText(upiCollectViewModelNew.isUpiIntentSelected());
            }
        } else {
            this.upiCollectViewModel.vpaInputLayoutVisibility.set(8);
            this.upiCollectLayoutBinding.btnProceed.setVisibility(0);
            this.upiCollectLayoutBinding.btnProceed2.setVisibility(8);
        }
        if (!SDKUtility.isUpiIntentEnabled()) {
            disableIntentView();
        }
    }

    public void changeOfferTextColor(int i2) {
        this.upiCollectLayoutBinding.tvCheckingOffers1.setTextColor(i2);
    }

    public void changeCheckOfferText(String str, int i2) {
        this.upiCollectViewModel.showCheckOffer();
        this.upiCollectLayoutBinding.tvCheckForOffers.setText(str);
        this.upiCollectLayoutBinding.tvCheckForOffers.setTextColor(i2);
    }

    public void viewClicked() {
        setSelected(true);
    }

    /* access modifiers changed from: private */
    public int getPosition(String str) {
        if (str == null || this.upiAppsInstalled == null) {
            return 0;
        }
        for (int i2 = 0; i2 < this.upiAppsInstalled.size(); i2++) {
            if (str.equalsIgnoreCase(this.upiAppsInstalled.get(i2).getAppName())) {
                return i2;
            }
        }
        return 0;
    }

    public UpiCollectViewNew(Context context, Instruments instruments, PaymentModes paymentModes2) {
        super(instruments);
        this.context = context;
        this.paymentModes = paymentModes2;
    }

    public void refreshLayout() {
        this.upiCollectViewModel.refreshLayout();
        this.upiCollectViewModel.setPaySecurelyText();
    }

    public PaytmBaseView getUpiCollectView() {
        this.upiCollectLayoutBinding = (UpiCollectLayoutNewBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.upi_collect_layout_new, (ViewGroup) null, false);
        this.upiCollectViewModel = new UpiCollectViewModelNew(this.context, this.paymentModes, this);
        this.upiCollectLayoutBinding.setUpiCollectModel(this.upiCollectViewModel);
        this.upiCollectLayoutBinding.etUpiAddress.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                UpiCollectViewNew.this.changeVpaEditTextUi(false, (String) null);
                UpiCollectViewNew upiCollectViewNew = UpiCollectViewNew.this;
                upiCollectViewNew.changeCheckOfferText(upiCollectViewNew.context.getString(R.string.native_check_offers), Color.parseColor("#00baf2"));
                UpiCollectViewNew.this.upiCollectViewModel.clearOffer();
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (charSequence.length() == 0) {
                    UpiCollectViewNew.this.upiCollectLayoutBinding.etUpiAddress.setTypeface((Typeface) null, 0);
                } else {
                    UpiCollectViewNew.this.upiCollectLayoutBinding.etUpiAddress.setTypeface((Typeface) null, 1);
                }
            }

            public void afterTextChanged(Editable editable) {
                UpiCollectViewNew.this.upiCollectViewModel.setVpaVerified(false);
                UpiCollectViewNew.this.upiCollectViewModel.verifiedIconVisibility.set(8);
                UpiCollectViewNew.this.upiCollectViewModel.verifiedProgressVisibility.set(8);
            }
        });
        this.view = this.upiCollectLayoutBinding.getRoot();
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("upi").authority("pay");
        this.upiAppsInstalled = (ArrayList) SDKUtility.getUpiAppsInstalled(this.context, builder.toString());
        if (DirectPaymentBL.getInstance().isSubsCriptionFlow()) {
            this.upiAppsInstalled = SDKUtils.filterSortMandateApps(this.upiAppsInstalled);
        }
        this.upiCollectViewModel.setUpiAppsInstalled(this.upiAppsInstalled);
        if (this.upiAppsInstalled.size() == 0 && !this.upiCollectViewModel.isUpiCollectEnabled()) {
            this.upiCollectLayoutBinding.getRoot().setVisibility(8);
        }
        ArrayList<UpiOptionsModel> arrayList = this.upiAppsInstalled;
        if (arrayList != null && arrayList.size() > 0) {
            this.upiCollectViewModel.setSelectedUpiOptionsModel(this.upiAppsInstalled.get(0));
        }
        this.upiCollectViewModel.vpaInputLayoutVisibility.set(8);
        this.upiCollectViewModel.upiCollectVisibility.set(8);
        this.upiAppListAdapter = new UpiAppListAdapter(this.upiAppsInstalled, new UpiAppListAdapter.OnClickUpiApp() {
            public void onClick(UpiOptionsModel upiOptionsModel, boolean z) {
                UpiCollectViewNew.this.upiCollectLayoutBinding.btnProceed.setVisibility(8);
                UpiCollectViewNew.this.upiCollectLayoutBinding.btnProceed2.setVisibility(0);
                UpiCollectViewNew.this.upiCollectLayoutBinding.etUpiAddress.getText().clear();
                UpiCollectViewNew.this.upiCollectLayoutBinding.etUpiAddress.clearFocus();
                UpiCollectViewNew.this.upiCollectLayoutBinding.etDummy.requestFocus();
                if (z) {
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(SDKConstants.APP_SELECTED_FROM_UPI_LIST);
                        a.a(UpiCollectViewNew.this.context).a(UpiCollectViewNew.this.broadcastReceiver, intentFilter);
                    } catch (Exception e2) {
                        LogUtility.printStackTrace(e2);
                    }
                    Intent intent = new Intent(UpiCollectViewNew.this.context, UpiBankAppsListActivity.class);
                    if (UpiCollectViewNew.this.context instanceof Activity) {
                        UpiCollectViewNew.this.context.startActivity(intent);
                        return;
                    }
                    return;
                }
                UpiCollectViewNew.this.upiCollectViewModel.setSelectedUpiOptionsModel(upiOptionsModel);
            }
        });
        this.upiCollectLayoutBinding.rvUpiApps.setLayoutManager(new GridLayoutManager(this.context, 5) {
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.upiCollectLayoutBinding.rvUpiApps.setAdapter(this.upiAppListAdapter);
        this.upiCollectViewModel.setPaySecurelyText();
        this.upiCollectLayoutBinding.etUpiAddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    UpiCollectViewNew.this.upiCollectLayoutBinding.btnProceed.setVisibility(0);
                    UpiCollectViewNew.this.upiCollectLayoutBinding.btnProceed2.setVisibility(8);
                    UpiCollectViewNew.this.upiCollectViewModel.showCheckOffer();
                    UpiCollectViewNew.this.upiCollectViewModel.setSelectedUpiOptionsModel((UpiOptionsModel) null);
                    UpiCollectViewNew.this.upiAppListAdapter.clearSelected();
                    UpiCollectViewNew.this.upiCollectViewModel.setUpiIntentSelected(false);
                } else if (UpiCollectViewNew.this.upiCollectLayoutBinding.paysecurely != null && UpiCollectViewNew.this.upiCollectLayoutBinding.paysecurely.getVisibility() == 0) {
                    UpiCollectViewNew.this.upiCollectLayoutBinding.btnProceed.setVisibility(8);
                    UpiCollectViewNew.this.upiCollectLayoutBinding.btnProceed2.setVisibility(0);
                    UpiCollectViewNew.this.upiCollectViewModel.checkOfferVisibility.set(8);
                    UpiCollectViewNew.this.upiCollectViewModel.setUpiIntentSelected(true);
                }
            }
        });
        this.upiCollectLayoutBinding.etUpiAddress.getText().clear();
        this.upiCollectLayoutBinding.etUpiAddress.clearFocus();
        this.upiCollectLayoutBinding.llVerifyVpaContainer.setVisibility(8);
        if (this.isToShowDialog) {
            this.upiCollectViewModel.fetchDeepLinkForIntentFlow(this.upiCollectLayoutBinding.btnProceed2);
            this.isToShowDialog = false;
        }
        this.upiCollectViewModel.disableMessageIntentVisibility.set(8);
        this.upiCollectViewModel.disableMessageCollectVisibility.set(8);
        this.upiCollectViewModel.disableMessage.set("");
        if (SDKUtility.isUpiCollectEnabled() || SDKUtility.isUpiIntentEnabled()) {
            setNPCIHealthData();
        } else {
            this.upiCollectLayoutBinding.tvError.setTextColor(b.c(this.context, R.color.red));
            this.upiCollectLayoutBinding.tvError.setText(this.context.getString(R.string.disable_paymode_error_message));
            this.upiCollectLayoutBinding.tvError.setVisibility(0);
            disableUPIView();
        }
        return this;
    }

    private void setNPCIHealthData() {
        MetaData uPIHealth = SDKUtils.getUPIHealth(this.context);
        if (uPIHealth == null || uPIHealth.getNpciHealthCategory() == null) {
            this.upiCollectLayoutBinding.tvError.setVisibility(8);
        } else if (uPIHealth.getNpciHealthCategory().equalsIgnoreCase(HealthType.RED.name())) {
            this.upiCollectLayoutBinding.tvError.setTextColor(b.c(this.context, R.color.red));
            this.upiCollectLayoutBinding.tvError.setText(uPIHealth.getNpciHealthMsg());
            this.upiCollectLayoutBinding.tvError.setVisibility(0);
            this.upiCollectLayoutBinding.tvError.setAlpha(0.4f);
            disableUPIView();
        } else if (uPIHealth.getNpciHealthCategory().equalsIgnoreCase(HealthType.YELLOW.name())) {
            this.upiCollectLayoutBinding.tvError.setVisibility(0);
            this.upiCollectLayoutBinding.tvError.setTextColor(b.c(this.context, R.color.yellow_color));
            this.upiCollectLayoutBinding.tvError.setText(uPIHealth.getNpciHealthMsg());
            this.upiCollectLayoutBinding.tvError.setAlpha(1.0f);
        } else {
            this.upiCollectLayoutBinding.tvError.setVisibility(8);
        }
        SDKUtility.handlePromotionVisibility(this.upiCollectLayoutBinding.tvPromotion, 0);
    }

    public void openAutoInstrument() {
        this.upiCollectViewModel.bhimUpiClicked((View) null);
        isOnceClicked = true;
    }

    public void closeView() {
        ArrayList<UpiOptionsModel> arrayList = this.upiAppsInstalled;
        if (arrayList != null && arrayList.size() > 0) {
            this.upiCollectViewModel.setSelectedUpiOptionsModel(this.upiAppsInstalled.get(0));
        }
        if (this.upiAppListAdapter.getSelectedPosition() < 0) {
            this.upiAppListAdapter.setSelectedPosition(0);
        }
        SDKUtility.handlePromotionVisibility(this.upiCollectLayoutBinding.tvPromotion, 0);
        this.upiCollectLayoutBinding.btnProceed.setVisibility(8);
        this.upiCollectLayoutBinding.btnProceed2.setVisibility(8);
        this.upiCollectLayoutBinding.etUpiAddress.clearFocus();
        this.upiCollectLayoutBinding.etUpiAddress.getText().clear();
        this.upiCollectLayoutBinding.etDummy.requestFocus();
        this.upiCollectViewModel.hideBhimUpi();
        this.upiCollectLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_right_chevron_dark);
        this.upiCollectLayoutBinding.txtBhimUpi.setTypeface((Typeface) null, 0);
        this.upiCollectViewModel.upiCollectVisibility.set(8);
        closeKeyboard();
    }

    public void clearVpaAddress() {
        this.upiCollectLayoutBinding.etUpiAddress.setText("");
    }

    public void changeArrowIcon(boolean z) {
        if (z) {
            this.upiCollectLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_down_chevron_dark);
            this.upiCollectLayoutBinding.txtBhimUpi.setTypeface((Typeface) null, 1);
            DirectPaymentBL.getInstance().closeOpnedView();
            DirectPaymentBL.getInstance().setPaytmBaseView(this);
            return;
        }
        this.upiCollectLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_right_chevron_dark);
        this.upiCollectLayoutBinding.txtBhimUpi.setTypeface((Typeface) null, 0);
        DirectPaymentBL.getInstance().setPaytmBaseView((PaytmBaseView) null);
        SDKUtility.collapse(this.upiCollectLayoutBinding.topLayout);
    }

    public void showAnimation(boolean z) {
        if (!z && isOnceClicked) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ObjectAnimator.ofInt(UpiCollectViewNew.this.instruments.getScrollView(), "scrollY", new int[]{(int) UpiCollectViewNew.this.getView().getY()}).setDuration(500).start();
                }
            }, 50);
            SDKUtility.expand(this.upiCollectLayoutBinding.topLayout, 500);
        }
    }

    public void closeKeyboard() {
        try {
            if (!SDKUtility.hideKeyboard((Activity) this.context)) {
                SDKUtility.hideKeyboard(this.upiCollectLayoutBinding.etUpiAddress, this.context);
            }
        } catch (Exception unused) {
        }
    }

    public void changeVpaEditTextUi(boolean z, String str) {
        if (z) {
            this.upiCollectViewModel.isInValidVPA.set(true);
            this.upiCollectLayoutBinding.txtErrorMsg.setTextColor(b.c(this.context, R.color.native_error_color));
            this.upiCollectLayoutBinding.txtErrorMsg.setText(str);
            this.upiCollectLayoutBinding.txtErrorMsg.setVisibility(0);
            this.upiCollectLayoutBinding.etUpiAddress.setBackgroundResource(R.drawable.edit_text_error_bg);
            return;
        }
        this.upiCollectViewModel.isInValidVPA.set(false);
        if (SDKConstants.VPA_VERIFIED.equalsIgnoreCase(str)) {
            this.upiCollectLayoutBinding.txtErrorMsg.setText("");
            this.upiCollectLayoutBinding.txtErrorMsg.setVisibility(8);
            this.upiCollectLayoutBinding.txtErrorMsg.setTextColor(this.context.getResources().getColor(R.color.light_black));
            this.upiCollectLayoutBinding.etUpiAddress.setBackgroundResource(R.drawable.edit_text_verified_bg);
            return;
        }
        this.upiCollectLayoutBinding.txtErrorMsg.setText(str);
        this.upiCollectLayoutBinding.txtErrorMsg.setVisibility(8);
        this.upiCollectLayoutBinding.txtErrorMsg.setTextColor(this.context.getResources().getColor(R.color.light_black));
        this.upiCollectLayoutBinding.etUpiAddress.setBackgroundResource(R.drawable.white_background_with_border);
    }

    /* access modifiers changed from: protected */
    public void disableUPIView() {
        this.upiCollectViewModel.radioChecked.set(false);
        this.upiCollectViewModel.vpaInputLayoutVisibility.set(8);
        this.upiCollectViewModel.upiCollectVisibility.set(8);
        this.upiCollectLayoutBinding.disableClickViewUpi.setVisibility(0);
        this.upiCollectLayoutBinding.cardTextLayout.setClickable(false);
        this.upiCollectLayoutBinding.cardTextLayout.setEnabled(false);
        this.upiCollectLayoutBinding.cardTextLayout.setFocusable(false);
    }

    private void disableCollectView() {
        this.upiCollectViewModel.disableMessage.set(this.context.getString(R.string.disable_paymode_error_message));
        this.upiCollectViewModel.disableMessageCollectVisibility.set(0);
        this.upiCollectLayoutBinding.tvError.setVisibility(8);
        this.upiCollectLayoutBinding.llVerifyVpaContainer.setVisibility(8);
        this.upiCollectLayoutBinding.btnProceed.setVisibility(8);
        this.upiCollectLayoutBinding.tvDisableErrorMessageIntent.setVisibility(8);
        this.upiCollectLayoutBinding.llCheckForOffers.setVisibility(8);
        this.upiCollectLayoutBinding.tvVpaDesc.setVisibility(8);
        this.upiCollectLayoutBinding.tvEnterUpiVpa.setAlpha(0.4f);
        this.upiCollectLayoutBinding.etUpiAddress.setAlpha(0.4f);
        this.upiCollectLayoutBinding.etUpiAddress.setFocusable(false);
        this.upiCollectLayoutBinding.etUpiAddress.setClickable(false);
        this.upiCollectLayoutBinding.etUpiAddress.setEnabled(false);
    }

    private void disableIntentView() {
        this.upiCollectViewModel.disableMessage.set(this.context.getString(R.string.disable_paymode_error_message));
        this.upiCollectViewModel.disableMessageIntentVisibility.set(0);
        this.upiCollectLayoutBinding.tvError.setVisibility(8);
        this.upiCollectLayoutBinding.btnProceed2.setVisibility(8);
        this.upiCollectLayoutBinding.tvSelectUpiApp.setAlpha(0.4f);
        this.upiCollectLayoutBinding.rvUpiApps.setAlpha(0.4f);
        this.upiCollectLayoutBinding.llUpiIntent.setClickable(false);
    }

    public void selectView() {
        refreshLayout();
        this.upiCollectViewModel.upiCollectVisibility.set(this.upiCollectViewModel.isUpiCollectEnabled() ? 0 : 8);
        this.upiCollectViewModel.upiIntentSeparatorVisibility.set((!this.upiCollectViewModel.isUpiCollectEnabled() || !this.upiCollectViewModel.isUpiIntentEnabled()) ? 8 : 0);
        this.upiCollectLayoutBinding.etDummy.requestFocus();
        this.upiCollectLayoutBinding.etUpiAddress.clearFocus();
        this.upiAppListAdapter.setSelectedPosition(0);
        ArrayList<UpiOptionsModel> arrayList = this.upiAppsInstalled;
        if (arrayList != null && arrayList.size() > 0) {
            this.upiCollectViewModel.setSelectedUpiOptionsModel(this.upiAppsInstalled.get(0));
        }
        this.upiAppListAdapter.notifyDataSetChanged();
        if (!SDKUtility.isUpiCollectEnabled()) {
            disableCollectView();
        }
        SDKUtility.handlePromotionVisibility(this.upiCollectLayoutBinding.tvPromotion, 8);
    }

    public void createFetchDeeplinkDialog() {
        if (this.upiCollectViewModel.getSelectedUpiOptionsModel() != null) {
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.dialog_upi_opening_app, (ViewGroup) null, false);
            this.dialogFetchDeeplink = new AlertDialog.Builder(this.context).setView(inflate).create();
            this.dialogFetchDeeplink.setCancelable(false);
            ((TextView) inflate.findViewById(R.id.tv_please_wait_upi)).setText(this.context.getString(R.string.native_opening_app, new Object[]{this.upiCollectViewModel.getSelectedUpiOptionsModel().getAppName()}));
            ((ImageView) inflate.findViewById(R.id.iv_bank_icon)).setImageDrawable(this.upiCollectViewModel.getSelectedUpiOptionsModel().getDrawable());
            this.dialogFetchDeeplink.getWindow().setLayout((int) (((double) Resources.getSystem().getDisplayMetrics().widthPixels) * 0.7d), -2);
            this.dialogFetchDeeplink.show();
        }
    }

    public void hideFetchDeeplinkDialog() {
        AlertDialog alertDialog = this.dialogFetchDeeplink;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void onActivityResult(String str) {
        UpiCollectViewModelNew upiCollectViewModelNew = this.upiCollectViewModel;
        if (upiCollectViewModelNew != null && upiCollectViewModelNew.isUpiActivityStarted()) {
            onIntentFlowComplete();
            this.upiCollectViewModel.setUpiActivityStarted(false);
            PaymentInstrument paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), NativeSdkGtmLoader.getUpiTransactionStatus(), PayUtility.getUpiCollectWithAppParam(this.upiCollectViewModel.getTransId(), this.upiCollectViewModel.getCashierRequestId()));
            paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI_INTENT);
            paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_DEFAULT);
            if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
            } else {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
            }
            if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("FAILURE")) {
                new TransactionProcessor(this.context, BaseViewModel.PaymentType.UPI_INTENT, paymentInstrument).makeTransactionStatusRequest(this.upiCollectViewModel.getTransId(), this.upiCollectLayoutBinding.btnProceed2);
            }
        }
    }

    public void makeUpiPushPayment(String str, String str2, String str3, String str4) {
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()));
        if ("intent".equalsIgnoreCase(str4)) {
            LogUtility.d("testTag", "inside intent view");
            TransactionProcessor transactionProcessor = new TransactionProcessor(this.context, "upi_push", new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), addAuthDefaultParams, this.upiCollectViewModel.getProcessTransactionRequest(str, str2, str3, str4)));
            if (SDKUtility.isHybridCase() && this.paymentModes.getHybridPaymentOffer() != null) {
                transactionProcessor.setOfferBody(new com.google.gson.f().b(this.paymentModes.getHybridPaymentOffer()));
            } else if (!SDKUtility.isHybridCase() && this.paymentModes.getPaymentOffer() != null) {
                transactionProcessor.setOfferBody(new com.google.gson.f().b(this.paymentModes.getPaymentOffer()));
            }
            transactionProcessor.setPaymentIntent(this.upiCollectViewModel.getPaymentIntent());
            transactionProcessor.startTransaction(this.upiCollectLayoutBinding.btnProceed2);
        } else if (SDKConstants.PUSH_FROM_COLLECT.equalsIgnoreCase(str4)) {
            LogUtility.d("testTag", "inside collect view");
            TransactionProcessor transactionProcessor2 = new TransactionProcessor(this.context, "upi_push", new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), addAuthDefaultParams, this.upiCollectViewModel.getProcessTransactionRequest(str, str2, str3, str4)));
            if (SDKUtility.isHybridCase() && this.paymentModes.getHybridPaymentOffer() != null) {
                transactionProcessor2.setOfferBody(new com.google.gson.f().b(this.paymentModes.getHybridPaymentOffer()));
            } else if (!SDKUtility.isHybridCase() && this.paymentModes.getPaymentOffer() != null) {
                transactionProcessor2.setOfferBody(new com.google.gson.f().b(this.paymentModes.getPaymentOffer()));
            }
            transactionProcessor2.setPaymentIntent(this.upiCollectViewModel.getPaymentIntent());
            transactionProcessor2.startTransaction(this.upiCollectLayoutBinding.btnProceed);
        }
    }

    public void hidePaymentsLoader() {
        UpiCollectLayoutNewBinding upiCollectLayoutNewBinding;
        UpiCollectViewModelNew upiCollectViewModelNew = this.upiCollectViewModel;
        if (upiCollectViewModelNew != null && (upiCollectLayoutNewBinding = this.upiCollectLayoutBinding) != null) {
            upiCollectViewModelNew.hidePaymentProgressbar(upiCollectLayoutNewBinding.btnProceed);
            this.upiCollectViewModel.hidePaymentProgressbar(this.upiCollectLayoutBinding.btnProceed2);
        }
    }

    public void setEnhancedViewEnabled(boolean z) {
        this.isEnhancedViewEnabled = z;
    }

    public boolean isEnhancedViewEnabled() {
        return this.isEnhancedViewEnabled;
    }

    public void enableProceedButton() {
        this.upiCollectLayoutBinding.btnProceed.setEnabled(true);
        this.upiCollectLayoutBinding.btnProceed.setClickable(true);
        this.upiCollectLayoutBinding.btnProceed2.setEnabled(true);
        this.upiCollectLayoutBinding.btnProceed2.setClickable(true);
    }

    public void disableProceedButton() {
        this.upiCollectLayoutBinding.btnProceed.setEnabled(false);
        this.upiCollectLayoutBinding.btnProceed.setClickable(false);
        this.upiCollectLayoutBinding.btnProceed2.setEnabled(false);
        this.upiCollectLayoutBinding.btnProceed2.setClickable(false);
    }

    public void startCheckingOfferAnimation() {
        if (this.upiCollectViewModel.isUpiIntentSelected()) {
            SDKUtility.startAnimation(this.upiCollectLayoutBinding.ltvGetOffers1);
        } else {
            SDKUtility.startAnimation(this.upiCollectLayoutBinding.ltvGetOffers);
        }
    }

    public void stopCheckingOfferAnimation() {
        SDKUtility.stopAnimation(this.upiCollectLayoutBinding.ltvGetOffers);
        SDKUtility.stopAnimation(this.upiCollectLayoutBinding.ltvGetOffers1);
    }

    public void changeOfferTextBgColor(int i2, int i3, boolean z) {
        this.upiCollectLayoutBinding.tvBankOffer.setBackgroundColor(i2);
        this.upiCollectLayoutBinding.tvBankOffer.setTextColor(i3);
        SDKUtility.setPaddingBankOffer(this.upiCollectLayoutBinding.tvBankOffer, z, this.context, 15, 26, 10, 10);
    }

    public Object getVerifyResponseModel() {
        return this.upiCollectViewModel.getVerifyResponseModel();
    }
}

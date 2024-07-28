package com.business.merchant_payments.newhome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.TextView;
import android.widget.Toast;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.h;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.d;
import com.business.common_module.utilities.b;
import com.business.common_module.utilities.c;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.acceptpayments.QRDetailActivity;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.GTMScreenViewsConstants;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.common.viewmodel.BaseViewModel;
import com.business.merchant_payments.databinding.MpProfileQrPagerItemLayoutBinding;
import com.business.merchant_payments.databinding.MpQrViewBinding;
import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import com.business.merchant_payments.event.QrEditEvent;
import com.business.merchant_payments.event.QrShareEvent;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.mapqr.utility.ScanQRHandler;
import com.business.merchant_payments.model.qrsummarymodel.QRSummary;
import com.business.merchant_payments.model.qrsummarymodel.QRSummaryListItem;
import com.business.merchant_payments.model.utrmodel.StringToQRGenerator;
import com.business.merchant_payments.newhome.ManageQrViewHandler;
import com.business.merchant_payments.utility.BackgroundTaskExecutor;
import com.business.merchant_payments.utility.BusinessShareUtility;
import com.business.merchant_payments.utility.NetworkService;
import com.business.merchant_payments.utility.QRCodeGenerator;
import com.business.merchant_payments.utility.QRCodeShareHelper;
import java.util.List;
import kotlin.g.a.a;
import org.greenrobot.eventbus.c;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageQrViewHandler {
    public Activity activity;
    public boolean automaticallyDownloadQR;
    public BackgroundTaskExecutor backgroundTaskExecutor = new BackgroundTaskExecutor();
    public boolean isNoPermissionViewVisible;
    public MpQrViewBinding mBinding;
    public String mBusinessName;
    public String mToBeHighlightedSection;
    public MpProfileQrPagerItemLayoutBinding profileQrPagerItemLayoutBinding;
    public final QrViewModel qrViewModel;
    public QrPageItemViewModelNew viewModel;
    public String viewToBeHighLighted;

    public ManageQrViewHandler(QrViewModel qrViewModel2, MpQrViewBinding mpQrViewBinding, final Activity activity2) {
        this.mBinding = mpQrViewBinding;
        this.activity = activity2;
        this.qrViewModel = qrViewModel2;
        mpQrViewBinding.setModel(qrViewModel2);
        this.mBinding.rlOrderQrCode.setOnClickListener(new View.OnClickListener(activity2) {
            private final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ManageQrViewHandler.this.lambda$new$0$ManageQrViewHandler(this.f$1, view);
            }
        });
        this.mBinding.rlDownloadMyQr.setOnClickListener(new View.OnClickListener(activity2) {
            private final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ManageQrViewHandler.this.lambda$new$1$ManageQrViewHandler(this.f$1, view);
            }
        });
        this.mBinding.rlActivateQr.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View view) {
                GAGTMTagAnalytics.getSingleInstance().sendEvent(activity2, "HomePage", "ActivateQRClicked", "", "");
                if (AppUtility.isEdcFlavour().booleanValue()) {
                    Activity activity = activity2;
                    Toast.makeText(activity, activity.getResources().getString(R.string.mp_qr_scan_error_msg), 1).show();
                    return;
                }
                new ScanQRHandler().scanQR(activity2, false);
            }
        });
        this.mBinding.rlShareMyQr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GAGTMTagAnalytics.getSingleInstance().sendEvent(activity2, "HomePage", "DownloadAndPrintQRClicked", "", "");
                if (ManageQrViewHandler.this.isNoPermissionViewVisible) {
                    Activity activity = activity2;
                    Toast.makeText(activity, activity.getString(R.string.mp_access_denied_error), 1).show();
                } else if (ManageQrViewHandler.this.viewModel != null) {
                    ManageQrViewHandler.this.viewModel.onShareBtnClicked(false);
                }
            }
        });
        this.mBinding.qrContainer.verifyQrPopupContainer.verifyQrNo.setOnClickListener(new View.OnClickListener(activity2) {
            private final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ManageQrViewHandler.this.lambda$new$2$ManageQrViewHandler(this.f$1, view);
            }
        });
        this.mBinding.qrContainer.verifyQrPopupContainer.verifyQrYes.setOnClickListener(new View.OnClickListener(activity2) {
            private final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ManageQrViewHandler.this.lambda$new$3$ManageQrViewHandler(this.f$1, view);
            }
        });
        setDownLoadShareClickableFalse();
        this.profileQrPagerItemLayoutBinding = this.mBinding.qrContainer;
        if (GTMDataProviderImpl.Companion.getMInstance().isShowOrderQr()) {
            this.mBinding.rlOrderQrCode.setVisibility(0);
        } else {
            this.mBinding.rlOrderQrCode.setVisibility(8);
        }
        if (!PaymentsConfig.getInstance().getMerchantDataProvider().d()) {
            showNoPermissionView();
        }
        this.mBinding.qrContainer.llRetry.setOnClickListener(new View.OnClickListener(qrViewModel2) {
            private final /* synthetic */ QrViewModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ManageQrViewHandler.this.lambda$new$4$ManageQrViewHandler(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$new$0$ManageQrViewHandler(Activity activity2, View view) {
        GAGTMTagAnalytics.getSingleInstance().sendEvent(activity2, "HomePage", "OrderQRClicked", "", "");
        openOrderQR();
    }

    public /* synthetic */ void lambda$new$1$ManageQrViewHandler(Activity activity2, View view) {
        GAGTMTagAnalytics.getSingleInstance().sendEvent(activity2, "HomePage", "DownloadAndPrintQRClicked", "", "");
        if (this.isNoPermissionViewVisible) {
            Toast.makeText(activity2, activity2.getString(R.string.mp_access_denied_error), 1).show();
            return;
        }
        QrPageItemViewModelNew qrPageItemViewModelNew = this.viewModel;
        if (qrPageItemViewModelNew != null) {
            qrPageItemViewModelNew.onShareBtnClicked(true);
        }
    }

    public /* synthetic */ void lambda$new$2$ManageQrViewHandler(Activity activity2, View view) {
        saveVerifyQrActionTimeStamp();
        this.viewModel.showVerifyQrPopup.set(false);
        openQRDetailActivity(activity2);
        GAGTMTagAnalytics.getSingleInstance().sendEvent(activity2, "verify_qr_do_you_have_a_standee_popup", "no", "", "");
    }

    public /* synthetic */ void lambda$new$3$ManageQrViewHandler(Activity activity2, View view) {
        saveVerifyQrActionTimeStamp();
        new ScanQRHandler().scanQR(activity2, true);
        this.viewModel.showVerifyQrPopup.set(false);
        GAGTMTagAnalytics.getSingleInstance().sendEvent(activity2, "verify_qr_do_you_have_a_standee_popup", H5AppHandler.CHECK_VALUE, "", "");
    }

    public /* synthetic */ void lambda$new$4$ManageQrViewHandler(QrViewModel qrViewModel2, View view) {
        qrViewModel2.updateManageQrTabSetting();
        showDummyImage();
    }

    private void saveVerifyQrActionTimeStamp() {
        APSharedPreferences.getInstance().saveVerifyQrActionTimeStamp(System.currentTimeMillis());
    }

    private void openQRDetailActivity(Context context) {
        context.startActivity(new Intent(context, QRDetailActivity.class));
    }

    public float getWidth() {
        return (float) this.activity.getResources().getDisplayMetrics().widthPixels;
    }

    public QrPageItemViewModelNew getViewModel() {
        return this.viewModel;
    }

    public void openOrderQR() {
        PaymentsConfig.getInstance().getDeepLinkUtils().a(this.activity, "paytmba://business-app/h/my-account/manage-qr/order-qr");
    }

    public void updatePagerView(List<QRSummaryListItem> list, boolean z) {
        if (this.activity != null && list != null && list.get(0) != null) {
            QrPageItemViewModelNew qrPageItemViewModelNew = new QrPageItemViewModelNew(list.get(0), APSharedPreferences.getInstance().getMerchantDisplayName(this.activity));
            this.viewModel = qrPageItemViewModelNew;
            qrPageItemViewModelNew.getShareQrEvent().observe((q) this.activity, new z() {
                public final void onChanged(Object obj) {
                    ManageQrViewHandler.this.shareQrImage((QrShareEvent) obj);
                }
            });
            this.viewModel.getToastCommandLiveData().observe((q) this.activity, new z() {
                public final void onChanged(Object obj) {
                    ManageQrViewHandler.this.lambda$updatePagerView$5$ManageQrViewHandler((String) obj);
                }
            });
            this.profileQrPagerItemLayoutBinding.setViewModel(this.viewModel);
            this.viewModel.updateBindings();
            hideDummyImage();
            hideReloadQrView();
            hideNoPermissionView();
            this.mBinding.rlShareMyQr.setClickable(true);
            this.mBinding.rlDownloadMyQr.setClickable(true);
            if (this.automaticallyDownloadQR) {
                this.automaticallyDownloadQR = false;
                this.viewModel.onShareBtnClicked(true);
            }
            if (!TextUtils.isEmpty(this.viewToBeHighLighted)) {
                highlightParticularSection(this.viewToBeHighLighted);
            }
            this.mBusinessName = APSharedPreferences.getInstance().getMerchantDisplayName(this.activity);
        }
    }

    public /* synthetic */ void lambda$updatePagerView$5$ManageQrViewHandler(String str) {
        Toast.makeText(this.activity, str, 1).show();
    }

    /* access modifiers changed from: private */
    public void shareQrImage(QrShareEvent qrShareEvent) {
        Activity activity2 = this.activity;
        if (activity2 == null) {
            return;
        }
        if (b.a(activity2)) {
            openShareSheet(qrShareEvent);
        } else {
            b.a(this.activity, qrShareEvent.isForDownload() ? 201 : 202);
        }
    }

    public void hideDummyImage() {
        this.mBinding.qrContainer.qrDummyImage.setVisibility(8);
        this.isNoPermissionViewVisible = false;
        this.mBinding.qrContainer.qrShimmer.setVisibility(8);
        this.mBinding.qrContainer.qrShimmer.stopShimmer();
    }

    public void showDummyImage() {
        this.mBinding.qrContainer.qrDummyImage.setVisibility(0);
        this.mBinding.qrContainer.llRetry.setVisibility(8);
        this.mBinding.qrContainer.qrImage.setVisibility(8);
        this.mBinding.qrContainer.llNoPermission.setVisibility(8);
        setDownLoadShareClickableFalse();
        this.isNoPermissionViewVisible = false;
        this.mBinding.qrContainer.qrShimmer.setVisibility(0);
        this.mBinding.qrContainer.qrShimmer.startShimmer();
    }

    private void setDownLoadShareClickableFalse() {
        this.mBinding.rlShareMyQr.setClickable(false);
        this.mBinding.rlDownloadMyQr.setClickable(false);
    }

    private void openShareSheet(final QrShareEvent qrShareEvent) {
        this.backgroundTaskExecutor.execute(new a(qrShareEvent) {
            private final /* synthetic */ QrShareEvent f$1;

            {
                this.f$1 = r2;
            }

            public final Object invoke() {
                return ManageQrViewHandler.this.lambda$openShareSheet$6$ManageQrViewHandler(this.f$1);
            }
        }, new BackgroundTaskExecutor.BackgroundTaskListener<Uri>() {
            public void onError(Exception exc) {
            }

            public void onSuccess(Uri uri) {
                if (qrShareEvent.isForDownload()) {
                    QRCodeShareHelper.downloadQrCode(uri, qrShareEvent.getQrType(), ManageQrViewHandler.this.activity, qrShareEvent.getQrBitmap(), ManageQrViewHandler.this.mBusinessName);
                } else {
                    BusinessShareUtility.shareQrImage(uri, qrShareEvent.getQrShareLink(), ManageQrViewHandler.this.activity);
                }
            }
        });
    }

    public /* synthetic */ Uri lambda$openShareSheet$6$ManageQrViewHandler(QrShareEvent qrShareEvent) {
        return QRCodeShareHelper.getSharableQrImageUri(qrShareEvent.getQrType(), qrShareEvent.getQrBitmap(), qrShareEvent.getQrDisplayName(), this.activity);
    }

    public void showReloadQrView() {
        this.mBinding.qrContainer.qrDummyImage.setVisibility(0);
        this.mBinding.qrContainer.llRetry.setVisibility(0);
        this.mBinding.qrContainer.qrImage.setVisibility(8);
        this.mBinding.qrContainer.llNoPermission.setVisibility(8);
        this.mBinding.qrContainer.qrShimmer.setVisibility(8);
        this.mBinding.qrContainer.qrShimmer.stopShimmer();
        setDownLoadShareClickableFalse();
    }

    public void hideReloadQrView() {
        this.mBinding.qrContainer.llRetry.setVisibility(8);
    }

    public void showNoPermissionView() {
        this.isNoPermissionViewVisible = true;
        this.mBinding.qrContainer.qrDummyImage.setVisibility(0);
        this.mBinding.qrContainer.llNoPermission.setVisibility(0);
        this.mBinding.qrContainer.llRetry.setVisibility(8);
        this.mBinding.qrContainer.qrImage.setVisibility(8);
        this.mBinding.rlShareMyQr.setClickable(true);
        this.mBinding.rlDownloadMyQr.setClickable(true);
    }

    public void hideNoPermissionView() {
        this.mBinding.qrContainer.llNoPermission.setVisibility(8);
        this.isNoPermissionViewVisible = false;
    }

    public void setDownLoadQR(boolean z) {
        this.automaticallyDownloadQR = z;
    }

    public void setViewToBeHighLighted(String str) {
        this.viewToBeHighLighted = str;
    }

    public class QrPageItemViewModelNew extends BaseViewModel {
        public String businessName;
        public boolean isCreateUpi;
        public QRSummaryListItem item;
        public y<QrShareEvent> mShareQrEvent = new y<>();
        public i<Bitmap> mShareQrImage = new i<>();
        public i<String> nameOnQr = new i<>("");
        public final int qrDimen = PaymentsConfig.getInstance().getAppContext().getResources().getDimensionPixelSize(R.dimen.dimen_250dp);
        public i<Bitmap> qrImage = new i<>();
        public ObservableBoolean shareButtonEnabled = new ObservableBoolean(true);
        public String shareLink = null;
        public ObservableBoolean shareLinkFetchInProgress = new ObservableBoolean(false);
        public d<String> showToastMessageCmd;
        public ObservableBoolean showVerifyQrPopup = new ObservableBoolean(false);
        public i<String> toPayText = new i<>("");

        public QrPageItemViewModelNew(QRSummaryListItem qRSummaryListItem, String str) {
            this.item = qRSummaryListItem;
            this.businessName = str;
            this.showToastMessageCmd = new d<>();
            if (this.item.isUpiQr()) {
                this.isCreateUpi = true;
            }
            this.showVerifyQrPopup.addOnPropertyChangedCallback(new h.a(ManageQrViewHandler.this) {
                public void onPropertyChanged(h hVar, int i2) {
                    if (QrPageItemViewModelNew.this.showVerifyQrPopup.get()) {
                        GAGTMTagAnalytics.getSingleInstance().sendEvent(ManageQrViewHandler.this.activity, "verify_qr_do_you_have_a_standee_popup", "shown", "", "");
                    }
                }
            });
        }

        public LiveData<String> getToastCommandLiveData() {
            return this.showToastMessageCmd;
        }

        public LiveData<QrShareEvent> getShareQrEvent() {
            return this.mShareQrEvent;
        }

        public void updateBindings() {
            QRSummaryListItem qRSummaryListItem = this.item;
            if (qRSummaryListItem != null) {
                this.nameOnQr.set(qRSummaryListItem.getmDisplayName());
                if (!this.item.isUpiQr() && !TextUtils.isEmpty(this.item.getmQRCodeID())) {
                    createQrImageFromText(this.item.getmQRCodeID());
                } else if (this.item.isUpiQr() && !TextUtils.isEmpty(this.item.getmDeepLink())) {
                    createQrImageFromText(this.item.getmDeepLink());
                }
            }
            String str = this.businessName;
            if (str != null) {
                this.toPayText.set(str);
            }
        }

        private void createQrImageFromText(String str) {
            APSharedPreferences.getInstance().saveQrText(str);
            ManageQrViewHandler.this.mBinding.qrContainer.qrImage.setVisibility(0);
            try {
                new Thread(new Runnable(str) {
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        ManageQrViewHandler.QrPageItemViewModelNew.this.lambda$createQrImageFromText$0$ManageQrViewHandler$QrPageItemViewModelNew(this.f$1);
                    }
                }).start();
            } catch (Exception e2) {
                LogUtility.printStackTrace(e2);
            }
        }

        public /* synthetic */ void lambda$createQrImageFromText$0$ManageQrViewHandler$QrPageItemViewModelNew(String str) {
            int i2 = this.qrDimen;
            this.qrImage.set(QRCodeGenerator.getQrCodeBitmap(str, i2, i2, AppConstants.QR_KEY_BLACK, 0));
        }

        public void onShareBtnClicked(final boolean z) {
            if (TextUtils.isEmpty(this.businessName)) {
                this.showToastMessageCmd.setValue(PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_error_unable_to_share_qr));
            } else if (!TextUtils.isEmpty(this.shareLink)) {
                checkQrImageAndShare(this.shareLink, z);
            } else if (!PaymentsConfig.getInstance().getGTMDataProvider().getBoolean(PaymentsGTMConstants.KEY_IS_LINK_SHARING_ENABLE, false)) {
                checkQrImageAndShare((String) null, z);
            } else if (!com.business.common_module.utilities.i.a(PaymentsConfig.getInstance().getApplication())) {
                checkQrImageAndShare((String) null, z);
            } else {
                String shareableQrLink = GTMDataProviderImpl.Companion.getMInstance().getShareableQrLink();
                if (!URLUtil.isValidUrl(shareableQrLink)) {
                    checkQrImageAndShare((String) null, z);
                    return;
                }
                NetworkService networkService = PaymentsConfig.getInstance().getNetworkService();
                this.shareLinkFetchInProgress.set(true);
                this.shareButtonEnabled.set(false);
                networkService.getShareableQrLink(shareableQrLink + this.item.getmQRCodeID(), RequestParamUtil.getRequestHeaderParam(PaymentsConfig.getInstance().getAppContext())).enqueue(new Callback<String>() {
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()) {
                            String unused = QrPageItemViewModelNew.this.shareLink = response.body();
                        } else if (response.code() == 410 || response.code() == 400 || response.code() == 401) {
                            ErrorUtil.handleAPIError("", "UMP", response, false);
                            return;
                        } else {
                            String unused2 = QrPageItemViewModelNew.this.shareLink = null;
                        }
                        QrPageItemViewModelNew qrPageItemViewModelNew = QrPageItemViewModelNew.this;
                        qrPageItemViewModelNew.checkQrImageAndShare(qrPageItemViewModelNew.shareLink, z);
                    }

                    public void onFailure(Call<String> call, Throwable th) {
                        String unused = QrPageItemViewModelNew.this.shareLink = null;
                        QrPageItemViewModelNew.this.checkQrImageAndShare((String) null, z);
                    }
                });
                if (!z) {
                    GAGTMTagAnalytics.getSingleInstance().sendEvent(getContext(), "Accept Payment", GTMScreenViewsConstants.SHOW_QR_EVENT_ACTION, "", "Share QR");
                }
            }
        }

        /* access modifiers changed from: private */
        public void checkQrImageAndShare(final String str, final boolean z) {
            String str2;
            if (this.mShareQrImage.get() == null) {
                this.mShareQrImage.addOnPropertyChangedCallback(new h.a() {
                    public void onPropertyChanged(h hVar, int i2) {
                        if (QrPageItemViewModelNew.this.mShareQrImage.get() != null) {
                            QrPageItemViewModelNew qrPageItemViewModelNew = QrPageItemViewModelNew.this;
                            qrPageItemViewModelNew.shareQr(qrPageItemViewModelNew.item.getmQRType(), (Bitmap) QrPageItemViewModelNew.this.mShareQrImage.get(), str, z);
                        }
                    }
                });
                if (this.item.isUpiQr()) {
                    str2 = this.item.getmDeepLink();
                } else {
                    str2 = this.item.getmQRCodeID();
                }
                new StringToQRGenerator(this.mShareQrImage, true, 775, -16777216).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str2});
                return;
            }
            shareQr(this.item.getmQRType(), this.mShareQrImage.get(), str, z);
        }

        /* access modifiers changed from: private */
        public void shareQr(String str, Bitmap bitmap, String str2, boolean z) {
            this.shareLinkFetchInProgress.set(false);
            this.shareButtonEnabled.set(true);
            QrShareEvent qrShareEvent = new QrShareEvent(str, -1, bitmap, this.item.getmDisplayName(), str2, (QRSummaryListItem) null);
            qrShareEvent.setForDownload(z);
            this.mShareQrEvent.setValue(qrShareEvent);
        }

        public void openQRNotifications(int i2) {
            c.a().c(new QrEditEvent(i2, AppConstants.QR_Constants.KEY_EDIT_QR));
        }
    }

    public void openQRNotificationScreen(int i2) {
        this.viewModel.openQRNotifications(i2);
    }

    public void highlightParticularSection(String str) {
        final TextView textView;
        if (str != null && !str.isEmpty()) {
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1211138760) {
                if (hashCode != -1146907411) {
                    if (hashCode != -743759231) {
                        if (hashCode == 1234305202 && str.equals(DeepLinkConstant.FEATURES.ORDER_QR)) {
                            c2 = 0;
                        }
                    } else if (str.equals("share_qr")) {
                        c2 = 1;
                    }
                } else if (str.equals("activate_qr")) {
                    c2 = 3;
                }
            } else if (str.equals(DeepLinkConstant.FEATURES.DOWNLOAD_QR)) {
                c2 = 2;
            }
            if (c2 == 0) {
                textView = this.mBinding.rlOrderQrCode;
            } else if (c2 == 1) {
                textView = this.mBinding.rlShareMyQr;
            } else if (c2 != 2) {
                textView = c2 != 3 ? null : this.mBinding.rlActivateQr;
            } else {
                textView = this.mBinding.rlDownloadMyQr;
            }
            if (textView != null) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        c.a aVar = com.business.common_module.utilities.c.f7365a;
                        c.a.a(textView, (Context) ManageQrViewHandler.this.activity);
                    }
                }, 1000);
            }
        }
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void updateQRView(QRSummary qRSummary) {
        if (qRSummary != null) {
            updatePagerView(qRSummary.getmQRSummaryList(), false);
        }
    }

    public void permissionGranted(boolean z) {
        getViewModel().onShareBtnClicked(z);
    }

    public void setQRLoadingImage(boolean z) {
        if (z) {
            showDummyImage();
        } else {
            hideDummyImage();
        }
    }

    public void showVerifyQrFlow() {
        QrPageItemViewModelNew qrPageItemViewModelNew = this.viewModel;
        if (qrPageItemViewModelNew != null) {
            qrPageItemViewModelNew.showVerifyQrPopup.set(true);
        }
    }
}

package net.one97.paytm.nativesdk.instruments.netbanking.viewmodel;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableInt;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.b;
import com.google.gson.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.nativesdk.ApiSession;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.common.model.HasLowSuccess;
import net.one97.paytm.nativesdk.common.model.MerchantPayMethod;
import net.one97.paytm.nativesdk.common.model.PayChannelOption;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SelectedInstrument;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.netbanking.listeners.NetBankingProviderListner;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.Body;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NBResponse;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NbPayOption;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public class AllNetBankingListViewModel extends BaseViewModel implements Response.ErrorListener, Response.Listener {
    private static final String TAG = AllNetBankingListViewModel.class.getCanonicalName();
    private List<PayChannelOption> bankList = new ArrayList();
    private boolean isCalledFromCashierSheet;
    private boolean isEmiBanks;
    /* access modifiers changed from: private */
    public NetBankingProviderListner listener;
    private Context mContext;
    private MerchantPayMethod netBanking = this.netBanking;
    public ObservableInt netbakingRecyclerVisiblity = new ObservableInt();
    private String payMode;
    public ObservableInt proceedButtonVisibility;
    public ObservableInt progressBarVisiblity = new ObservableInt();
    private String selectedChannelCode;
    private SelectedInstrument selectedInstrument;

    public void deselectView() {
    }

    public AllNetBankingListViewModel(Context context, boolean z, final NetBankingProviderListner netBankingProviderListner, boolean z2) {
        super(context, (BaseViewActions) null);
        this.mContext = context;
        this.isEmiBanks = z;
        this.listener = netBankingProviderListner;
        this.netbakingRecyclerVisiblity.set(8);
        this.isCalledFromCashierSheet = z2;
        if (this.isEmiBanks) {
            new Handler().post(new Runnable() {
                public void run() {
                    PaymentModes instrument = DirectPaymentBL.getInstance().getInstrument(PayMethodType.EMI);
                    if (instrument == null || instrument.getPayChannelOptions() == null || instrument.getPayChannelOptions().size() <= 0) {
                        netBankingProviderListner.onNetBankingListReceived((NbPayOption) null);
                    } else {
                        String b2 = new f().b(instrument);
                        netBankingProviderListner.onNetBankingListReceived((NbPayOption) new f().a(b2, NbPayOption.class));
                    }
                    AllNetBankingListViewModel.this.progressBarVisiblity.set(8);
                }
            });
        } else {
            callNBAPI();
        }
    }

    public static void loadImage(ImageView imageView, String str) {
        LogUtility.d(TAG, "Image - ".concat(String.valueOf(str)));
        b.b(imageView.getContext()).a(str).a(imageView);
    }

    public void setLowSuccessVisiblity(View view, HasLowSuccess hasLowSuccess) {
        if (hasLowSuccess != null) {
            view.setVisibility(hasLowSuccess.getStatus() ? 0 : 4);
        }
    }

    private void callNBAPI() {
        if (ApiSession.getInstance().getNetbankingResponse() != null) {
            new Handler().post(new Runnable() {
                public void run() {
                    AllNetBankingListViewModel.this.onResponse(ApiSession.getInstance().getNetbankingResponse());
                }
            });
        } else {
            NativeSDKRepository.getInstance().fetchNBDetails(this.isCalledFromCashierSheet ? "MERCHANT" : "ADD_MONEY", new PaymentMethodDataSource.Callback<NBResponse>() {
                public void onResponse(NBResponse nBResponse) {
                    AllNetBankingListViewModel.this.progressBarVisiblity.set(8);
                    AllNetBankingListViewModel.this.netbakingRecyclerVisiblity.set(0);
                    ApiSession.getInstance().setNetbankingResponse(nBResponse);
                    Body body = nBResponse.getBody();
                    if (body == null || body.getNbPayOption() == null || body.getNbPayOption().getPayChannelOptions() == null || body.getNbPayOption().getPayChannelOptions().size() <= 0) {
                        AllNetBankingListViewModel.this.listener.onNetBankingListReceived((NbPayOption) null);
                    } else {
                        AllNetBankingListViewModel.this.listener.onNetBankingListReceived(body.getNbPayOption());
                    }
                }

                public void onErrorResponse(VolleyError volleyError, NBResponse nBResponse) {
                    if (volleyError instanceof CustomVolleyError) {
                        CustomVolleyError customVolleyError = (CustomVolleyError) volleyError;
                        if (customVolleyError.getUrl().contains(NativeSdkGtmLoader.getNBList(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()))) {
                            AllNetBankingListViewModel.this.listener.onNetBankingListReceived((NbPayOption) null);
                        }
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.API_TIME_OUT, customVolleyError.getUrl(), customVolleyError.getUrl()));
                    }
                }
            });
        }
    }

    private Request getNBRequest() {
        HashMap hashMap = new HashMap();
        hashMap.put("SSO_TOKEN", MerchantBL.getMerchantInstance().getSsoToken());
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, NativeSdkGtmLoader.getNBList(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()), hashMap, (Map<String, String>) null, APIReqtGenerator.createJsonForNBAPI(this.isCalledFromCashierSheet ? "MERCHANT" : "ADD_MONEY", false), this, this, NBResponse.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        return volleyPostRequest;
    }

    public void onErrorResponse(VolleyError volleyError) {
        if (volleyError instanceof CustomVolleyError) {
            CustomVolleyError customVolleyError = (CustomVolleyError) volleyError;
            if (customVolleyError.getUrl().contains(NativeSdkGtmLoader.getNBList(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()))) {
                this.listener.onNetBankingListReceived((NbPayOption) null);
            }
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.API_TIME_OUT, customVolleyError.getUrl(), customVolleyError.getUrl()));
        }
    }

    public void onResponse(Object obj) {
        if (obj instanceof NBResponse) {
            this.progressBarVisiblity.set(8);
            this.netbakingRecyclerVisiblity.set(0);
            NBResponse nBResponse = (NBResponse) obj;
            ApiSession.getInstance().setNetbankingResponse(nBResponse);
            Body body = nBResponse.getBody();
            if (body == null || body.getNbPayOption() == null || body.getNbPayOption().getPayChannelOptions() == null || body.getNbPayOption().getPayChannelOptions().size() <= 0) {
                this.listener.onNetBankingListReceived((NbPayOption) null);
            } else {
                this.listener.onNetBankingListReceived(body.getNbPayOption());
            }
        }
    }

    private void goForTransaction(View view) {
        HashMap<String, String> nBTranscationParam = PayUtility.getNBTranscationParam(this.payMode, this.selectedChannelCode);
        new TransactionProcessor(this.mContext, "Net banking", new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.mContext, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), nBTranscationParam)).startTransaction(view);
    }

    public void completeTransaction(AppCompatActivity appCompatActivity) {
        goForTransaction((View) null);
    }

    public void bankSelectedProceedClicked(View view) {
        goForTransaction(view);
    }

    public void setSelectedInstrument(PayChannelOptions payChannelOptions) {
        this.selectedInstrument = new SelectedInstrument();
        this.selectedInstrument.setPrimaryName("Net Banking");
        this.selectedInstrument.setSecondaryName(payChannelOptions.getChannelName());
        this.selectedInstrument.setBaseViewModel(this);
        this.selectedChannelCode = payChannelOptions.getChannelCode();
        DirectPaymentBL.getInstance().setSelectedInstrument(this.selectedInstrument);
    }

    public void onClose(View view) {
        this.listener.onArrowClicked();
    }

    public void setPayMode(String str) {
        this.payMode = str;
    }
}

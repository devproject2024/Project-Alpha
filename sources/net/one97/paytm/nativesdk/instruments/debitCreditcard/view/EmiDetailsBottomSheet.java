package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.VolleyError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.nativesdk.ApiSession;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.WebViewActivity;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.listeners.SetOnAlertButtonListeners;
import net.one97.paytm.nativesdk.common.model.ApplyPromoRequest;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.CardPaymentIntentData;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.view.fragment.CustomBottomSheetDialogFragment;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.adapter.EmiDetailAdapter;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.listeners.SetOnEmiClickListener;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiChannelInfo;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.utility.DebitCreditCardUtility;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

public class EmiDetailsBottomSheet extends CustomBottomSheetDialogFragment {
    /* access modifiers changed from: private */
    public String aggregatePgConveneinceFee;
    private String cardHash;
    private String cardNumber;
    private String channelCode;
    /* access modifiers changed from: private */
    public EmiConvenienceFeeListener convenienceFeeListener;
    /* access modifiers changed from: private */
    public double emiConvenienceFee;
    private String emiType;
    private ViewGroup emptyLayout;
    /* access modifiers changed from: private */
    public String feePercent;
    /* access modifiers changed from: private */
    public String instantDiscount;
    /* access modifiers changed from: private */
    public SetOnEmiClickListener listener;
    private LottieAnimationView mFetchPayMethodsProgress;
    private ViewGroup minHeightLayout;
    /* access modifiers changed from: private */
    public ArrayList<PaymentIntent> paymentIntents;
    /* access modifiers changed from: private */
    public ApplyPromoResponse.PaymentOffer paymentOffer;
    private RecyclerView recyclerView;
    private String savedCardId;
    private int selectedPosition = -1;
    /* access modifiers changed from: private */
    public Object verifyResponseModel;

    public interface EmiConvenienceFeeListener {
        void setEmiConvenienceFeeResponse(Object obj, ArrayList<PaymentIntent> arrayList, String str);
    }

    public void setSelectedPosition(int i2) {
        this.selectedPosition = i2;
    }

    public static EmiDetailsBottomSheet getInstance(String str, String str2, String str3, String str4, int i2, double d2, String str5, String str6, SetOnEmiClickListener setOnEmiClickListener, EmiConvenienceFeeListener emiConvenienceFeeListener) {
        EmiDetailsBottomSheet emiDetailsBottomSheet = new EmiDetailsBottomSheet();
        emiDetailsBottomSheet.channelCode = str;
        emiDetailsBottomSheet.listener = setOnEmiClickListener;
        emiDetailsBottomSheet.selectedPosition = i2;
        emiDetailsBottomSheet.savedCardId = str3;
        emiDetailsBottomSheet.cardNumber = str4;
        emiDetailsBottomSheet.emiType = str2;
        emiDetailsBottomSheet.emiConvenienceFee = d2;
        emiDetailsBottomSheet.cardHash = str5;
        emiDetailsBottomSheet.convenienceFeeListener = emiConvenienceFeeListener;
        emiDetailsBottomSheet.instantDiscount = str6;
        return emiDetailsBottomSheet;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.emi_details_layout, viewGroup, false);
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_emi);
        this.minHeightLayout = (ViewGroup) inflate.findViewById(R.id.min_height_layout);
        this.emptyLayout = (ViewGroup) inflate.findViewById(R.id.list_empty_layout_container);
        inflate.findViewById(R.id.imgCross).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EmiDetailsBottomSheet.this.dismiss();
            }
        });
        inflate.findViewById(R.id.tnc).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EmiDetailsBottomSheet.this.clickTnC();
            }
        });
        this.mFetchPayMethodsProgress = (LottieAnimationView) inflate.findViewById(R.id.dot_progress_bar);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            getBankOffers();
        } else if (!ConvenienceFeeController.getInstance().isConvenienceFeeEnabled() || this.emiConvenienceFee != 0.0d) {
            callEmiDetailsApi();
        } else {
            fetchConvenienceFeeForEmi();
        }
        return inflate;
    }

    private void startAnimation() {
        this.mFetchPayMethodsProgress.setVisibility(0);
        this.mFetchPayMethodsProgress.setAnimation("Payments-Loader.json");
        this.mFetchPayMethodsProgress.loop(true);
        this.mFetchPayMethodsProgress.playAnimation();
    }

    private void stopAnimation() {
        this.mFetchPayMethodsProgress.cancelAnimation();
        this.mFetchPayMethodsProgress.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void callEmiDetailsApi() {
        final EmiResponse emiResposne = ApiSession.getInstance().getEmiResposne(this.channelCode);
        if (emiResposne != null) {
            new Handler().post(new Runnable() {
                public void run() {
                    EmiDetailsBottomSheet.this.onApiResponse(emiResposne);
                }
            });
            return;
        }
        startAnimation();
        NativeSDKRepository.getInstance().fetchEmiDetails(this.channelCode, this.emiType, new PaymentMethodDataSource.Callback<EmiResponse>() {
            public void onResponse(EmiResponse emiResponse) {
                EmiDetailsBottomSheet.this.onApiResponse(emiResponse);
            }

            public void onErrorResponse(VolleyError volleyError, EmiResponse emiResponse) {
                EmiDetailsBottomSheet.this.showEmptyOrRecyclerView(true);
                EmiDetailsBottomSheet.this.showServerFailureAlert(volleyError);
            }
        });
    }

    /* access modifiers changed from: private */
    public void onApiResponse(EmiResponse emiResponse) {
        if (emiResponse == null || emiResponse.getBody() == null || emiResponse.getBody().getEmiDetail() == null || emiResponse.getBody().getEmiDetail().getEmiChannelInfos() == null || emiResponse.getBody().getEmiDetail().getEmiChannelInfos().size() <= 0) {
            showEmptyOrRecyclerView(true);
            return;
        }
        ApiSession.getInstance().setEmiResponse(this.channelCode, emiResponse);
        showEmptyOrRecyclerView(false);
        calculateEmiPerMonth(emiResponse.getBody().getEmiDetail().getEmiChannelInfos());
        EmiDetailAdapter emiDetailAdapter = new EmiDetailAdapter(getContext(), emiResponse.getBody().getEmiDetail().getEmiChannelInfos(), new SetOnEmiClickListener() {
            public void onClick(EmiChannelInfo emiChannelInfo, int i2, String str) {
                EmiDetailsBottomSheet.this.listener.onClick(emiChannelInfo, i2, str);
                if (EmiDetailsBottomSheet.this.paymentIntents != null) {
                    EmiDetailsBottomSheet.this.convenienceFeeListener.setEmiConvenienceFeeResponse(EmiDetailsBottomSheet.this.verifyResponseModel, EmiDetailsBottomSheet.this.paymentIntents, EmiDetailsBottomSheet.this.aggregatePgConveneinceFee);
                }
                EmiDetailsBottomSheet.this.dismiss();
            }
        });
        if (!TextUtils.isEmpty(this.instantDiscount)) {
            emiDetailAdapter.setInstantDiscount(this.instantDiscount);
        }
        emiDetailAdapter.setSelectedPosition(this.selectedPosition);
        this.recyclerView.setAdapter(emiDetailAdapter);
    }

    private void calculateEmiPerMonth(List<EmiChannelInfo> list) {
        if (list != null && !list.isEmpty()) {
            String valueOf = String.valueOf(this.emiConvenienceFee);
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.get(i2).calculateEmiPerMonth(this.instantDiscount, valueOf);
            }
        }
    }

    /* access modifiers changed from: private */
    public void showEmptyOrRecyclerView(boolean z) {
        stopAnimation();
        if (z) {
            this.minHeightLayout.setVisibility(0);
            this.recyclerView.setVisibility(8);
            this.emptyLayout.setVisibility(0);
            return;
        }
        this.minHeightLayout.setVisibility(8);
        this.recyclerView.setVisibility(0);
        this.emptyLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void showServerFailureAlert(VolleyError volleyError) {
        String str;
        try {
            str = DebitCreditCardUtility.getFailureReponse(new String(volleyError.networkResponse.data, AppConstants.UTF_8), getContext());
        } catch (Exception unused) {
            str = getContext().getResources().getString(R.string.server_communication_failed);
        }
        DialogUtility.showTwoButtonDialogNew(getActivity(), getContext().getResources().getString(R.string.unknown_error), str, "Exit", "Retry", new SetOnAlertButtonListeners() {
            public void onPositiveClicked() {
                EmiDetailsBottomSheet.this.dismiss();
            }

            public void onNegativeClicked() {
                EmiDetailsBottomSheet.this.callEmiDetailsApi();
            }
        });
    }

    private void getBankOffers() {
        startAnimation();
        ApplyPromoRequest.PaymentOption paymentOption = new ApplyPromoRequest.PaymentOption();
        StringBuilder sb = new StringBuilder();
        sb.append(SDKUtility.getDiffAmount());
        paymentOption.setTransactionAmount(sb.toString());
        paymentOption.setPayMethod(PayMethodType.EMI.name());
        paymentOption.setBankCode(this.channelCode);
        if (!TextUtils.isEmpty(this.savedCardId)) {
            paymentOption.setSavedCardId(this.savedCardId);
        } else if (!TextUtils.isEmpty(this.cardNumber)) {
            paymentOption.setCardNo(this.cardNumber);
        }
        NativeSDKRepository.getInstance().applyOffer(APIReqtGenerator.getApplyPromoRequestObj(true, paymentOption, MerchantBL.getMerchantInstance().getAppInvokePromoCode()), new PaymentMethodDataSource.Callback<ApplyPromoResponse>() {
            public void onResponse(ApplyPromoResponse applyPromoResponse) {
                if (applyPromoResponse == null || applyPromoResponse.getBody() == null || applyPromoResponse.getBody().getPaymentOffer() == null) {
                    DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                } else {
                    ApplyPromoResponse.PaymentOffer unused = EmiDetailsBottomSheet.this.paymentOffer = applyPromoResponse.getBody().getPaymentOffer();
                    if (!TextUtils.isEmpty(applyPromoResponse.getBody().getPaymentOffer().getTotalInstantDiscount())) {
                        String unused2 = EmiDetailsBottomSheet.this.instantDiscount = applyPromoResponse.getBody().getPaymentOffer().getTotalInstantDiscount();
                    }
                    SDKUtils.setPromoCodeFromApplyPromoResponse(applyPromoResponse);
                }
                if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
                    EmiDetailsBottomSheet.this.fetchConvenienceFeeForEmi();
                } else {
                    EmiDetailsBottomSheet.this.callEmiDetailsApi();
                }
            }

            public void onErrorResponse(VolleyError volleyError, ApplyPromoResponse applyPromoResponse) {
                if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
                    EmiDetailsBottomSheet.this.fetchConvenienceFeeForEmi();
                } else {
                    EmiDetailsBottomSheet.this.callEmiDetailsApi();
                }
                DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
            }
        });
    }

    public void fetchConvenienceFeeForEmi() {
        if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled() && !TextUtils.isEmpty(this.emiType)) {
            CardPaymentIntentData cardPaymentIntentData = new CardPaymentIntentData();
            cardPaymentIntentData.setCardHash(this.cardHash);
            double parseDouble = SDKUtility.parseDouble(this.instantDiscount);
            this.paymentIntents = ConvenienceFeeController.getInstance().buildPaymentIntent(PayMethodType.EMI.name(), (ArrayList<String>) null, (ArrayList<String>) null, cardPaymentIntentData, this.emiType, Double.valueOf(parseDouble));
            getConvenienceFee();
        }
    }

    private void getConvenienceFee() {
        startAnimation();
        PaytmSDKRequestClient.CallbackData callbackData = new PaytmSDKRequestClient.CallbackData();
        callbackData.setPaymentIntents(this.paymentIntents);
        SDKUtility.addOfferInCallBackData(callbackData, this.paymentOffer);
        DirectPaymentBL.getInstance().getRequestClient().verifyCart(callbackData, new PaytmSDKRequestClient.OnVerifyResponse() {
            public void onVerifySuccess(PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
                if (verifyResponseData == null || verifyResponseData.getConvFeeResponse() == null) {
                    EmiDetailsBottomSheet.this.showEmptyOrRecyclerView(true);
                    SDKUtility.handleVerticalError((PaytmSDKRequestClient.ApiResponseError) null, EmiDetailsBottomSheet.this.getActivity());
                    return;
                }
                PaytmSDKRequestClient.ConvFeeResponse convFeeResponse = verifyResponseData.getConvFeeResponse();
                Object unused = EmiDetailsBottomSheet.this.verifyResponseModel = verifyResponseData.getVerifyModel();
                ArrayList unused2 = EmiDetailsBottomSheet.this.paymentIntents = ConvenienceFeeController.Companion.getInstance().setConvFeeResponse(convFeeResponse, (ArrayList<PaymentIntent>) EmiDetailsBottomSheet.this.paymentIntents, verifyResponseData.getVerifyModel());
                String unused3 = EmiDetailsBottomSheet.this.aggregatePgConveneinceFee = convFeeResponse.getAggregatePGConvFee();
                String unused4 = EmiDetailsBottomSheet.this.feePercent = convFeeResponse.getFeePercent();
                Iterator it2 = EmiDetailsBottomSheet.this.paymentIntents.iterator();
                while (it2.hasNext()) {
                    PaymentIntent paymentIntent = (PaymentIntent) it2.next();
                    if (PayMethodType.EMI.name().equalsIgnoreCase(paymentIntent.getMode())) {
                        double unused5 = EmiDetailsBottomSheet.this.emiConvenienceFee = paymentIntent.getConvFee();
                    }
                }
                EmiDetailsBottomSheet.this.callEmiDetailsApi();
            }

            public void onVerifyError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                SDKUtility.handleVerticalError(apiResponseError, EmiDetailsBottomSheet.this.getActivity());
            }
        });
    }

    public void clickTnC() {
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.putExtra(Constants.WEB_URL, Constants.TNC_URL);
            getActivity().startActivity(intent);
        }
    }

    public Dialog getDialog() {
        return super.getDialog();
    }
}

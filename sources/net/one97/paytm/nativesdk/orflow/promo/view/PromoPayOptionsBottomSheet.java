package net.one97.paytm.nativesdk.orflow.promo.view;

import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CardDetails;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaAccountDetail;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;

public final class PromoPayOptionsBottomSheet extends BasePromoPayOptionSheet<PromoPayOptionViewModel> {
    public static final Companion Companion = new Companion((g) null);
    private HashMap _$_findViewCache;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<PaymentIntent> f55772f;
    /* access modifiers changed from: private */
    public PromoPayOptionListAdapter mPayOptionListAdapter;
    public ArrayList<PromoPayOptionAdapterParam> mPayOptionsList;
    private int prevSelectedPosition;
    /* access modifiers changed from: private */
    public PromoPayOptionAdapterParam selectedPayOption;
    private int selectedPayOptionPosition;

    private final void disablePayButton() {
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
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

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final ArrayList<PromoPayOptionAdapterParam> getMPayOptionsList() {
        ArrayList<PromoPayOptionAdapterParam> arrayList = this.mPayOptionsList;
        if (arrayList == null) {
            k.a("mPayOptionsList");
        }
        return arrayList;
    }

    public final void setMPayOptionsList(ArrayList<PromoPayOptionAdapterParam> arrayList) {
        k.c(arrayList, "<set-?>");
        this.mPayOptionsList = arrayList;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PromoPayOptionsBottomSheet getInstance(CJPayMethodResponse cJPayMethodResponse) {
            k.c(cJPayMethodResponse, "cjPayMethodResponse");
            PromoHelper.Companion.getInstance().setCjPayMethodResponse(cJPayMethodResponse);
            return new PromoPayOptionsBottomSheet();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NativeSDKRepository.init(getContext(), true);
        PromoHelper.Companion.getInstance().addVerifyPromoObserver(this);
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        merchantInstance.setSsoToken(PromoHelper.Companion.getInstance().getSsoToken());
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        merchantInstance2.setMid(PromoHelper.Companion.getInstance().getMid());
        Utility.INSTANCE.sendBankOffersEvent(getContext(), Utility.INSTANCE.getBankOfferEventParams(Utility.EVENT_CATEGORY_BANKOFFER, Utility.ACTION_SAVEDINSTRUMENT_LOADED, "", PromoHelper.Companion.getInstance().getVerticalName()));
    }

    public final PromoPayOptionViewModel getViewModel() {
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            k.a();
        }
        return new PromoPayOptionViewModel(application);
    }

    public final int getLayoutId() {
        return R.layout.fragment_promo_payoptions;
    }

    public final void initView() {
        View.OnClickListener onClickListener = this;
        ((ImageView) _$_findCachedViewById(R.id.img_cancel)).setOnClickListener(onClickListener);
        ((LinearLayout) _$_findCachedViewById(R.id.llApplyOffer)).setOnClickListener(onClickListener);
        setValidateVPAObserver();
        fetchCardDetailObserver();
        checkBalanceObserver();
        populateList();
    }

    private final void populateList() {
        CJPayMethodResponse cjPayMethodResponse = PromoHelper.Companion.getInstance().getCjPayMethodResponse();
        RecyclerView.f fVar = null;
        if ((cjPayMethodResponse != null ? cjPayMethodResponse.getBody() : null) == null) {
            dismissAllowingStateLoss();
            return;
        }
        String offerText = PromoHelper.Companion.getInstance().getOfferText();
        if (offerText != null) {
            if (!(!(offerText.length() == 0))) {
                offerText = null;
            }
            if (offerText != null) {
                String concat = "<b>OFFER: </b> ".concat(String.valueOf(offerText));
                TextView textView = (TextView) getMView().findViewById(R.id.tvOfferText);
                if (textView != null) {
                    textView.setVisibility(0);
                    textView.setText(Html.fromHtml(concat));
                }
            }
        }
        this.mPayOptionsList = ((PromoPayOptionViewModel) getMViewModel()).getPayOptionsList();
        ArrayList<PromoPayOptionAdapterParam> arrayList = this.mPayOptionsList;
        if (arrayList == null) {
            k.a("mPayOptionsList");
        }
        if ((arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue() != 0) {
            ArrayList<PromoPayOptionAdapterParam> arrayList2 = this.mPayOptionsList;
            if (arrayList2 == null) {
                k.a("mPayOptionsList");
            }
            PromoPayOptionAdapterParam promoPayOptionAdapterParam = arrayList2.get(0);
            k.a((Object) promoPayOptionAdapterParam, "mPayOptionsList.get(0)");
            promoPayOptionAdapterParam.setSelected(true);
            this.selectedPayOptionPosition = 0;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "this.context!!");
            ArrayList<PromoPayOptionAdapterParam> arrayList3 = this.mPayOptionsList;
            if (arrayList3 == null) {
                k.a("mPayOptionsList");
            }
            this.mPayOptionListAdapter = new PromoPayOptionListAdapter(context, arrayList3, this);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_promo_pay_options);
            if (recyclerView != null) {
                recyclerView.setLayoutManager(linearLayoutManager);
            }
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.rv_promo_pay_options);
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(this.mPayOptionListAdapter);
            }
            RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(R.id.rv_promo_pay_options);
            if (recyclerView3 != null) {
                recyclerView3.setFocusable(false);
            }
            RecyclerView recyclerView4 = (RecyclerView) _$_findCachedViewById(R.id.rv_promo_pay_options);
            Context context2 = recyclerView4 != null ? recyclerView4.getContext() : null;
            if (context2 == null) {
                k.a();
            }
            MyDividerItemDecoration myDividerItemDecoration = new MyDividerItemDecoration(context2, R.drawable.bg_or_flow_seperator);
            RecyclerView recyclerView5 = (RecyclerView) _$_findCachedViewById(R.id.rv_promo_pay_options);
            if (recyclerView5 != null) {
                recyclerView5.addItemDecoration(myDividerItemDecoration);
            }
            RecyclerView recyclerView6 = (RecyclerView) _$_findCachedViewById(R.id.rv_promo_pay_options);
            if (recyclerView6 != null) {
                fVar = recyclerView6.getItemAnimator();
            }
            if (fVar != null) {
                ((androidx.recyclerview.widget.g) fVar).f();
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.DefaultItemAnimator");
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.img_cancel;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismissAllowingStateLoss();
            return;
        }
        int i3 = R.id.newCardContainer;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i4 = R.id.savedCardContainer;
            if (valueOf == null || valueOf.intValue() != i4) {
                int i5 = R.id.newVPAContainer;
                if (valueOf == null || valueOf.intValue() != i5) {
                    int i6 = R.id.llApplyOffer;
                    if (valueOf != null && valueOf.intValue() == i6) {
                        int i7 = this.selectedPayOptionPosition;
                        ArrayList<PromoPayOptionAdapterParam> arrayList = this.mPayOptionsList;
                        if (arrayList == null) {
                            k.a("mPayOptionsList");
                        }
                        if (i7 <= arrayList.size() - 1) {
                            SDKUtility.hideKeyboard(getActivity());
                            ArrayList<PromoPayOptionAdapterParam> arrayList2 = this.mPayOptionsList;
                            if (arrayList2 == null) {
                                k.a("mPayOptionsList");
                            }
                            this.selectedPayOption = arrayList2.get(this.selectedPayOptionPosition);
                            onApplyOfferClick(this.selectedPayOption);
                            scrollRecyclerView();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        Object tag = view.getTag();
        if (tag != null) {
            int intValue = ((Integer) tag).intValue();
            ArrayList<PromoPayOptionAdapterParam> arrayList3 = this.mPayOptionsList;
            if (arrayList3 == null) {
                k.a("mPayOptionsList");
            }
            int size = arrayList3.size();
            int i8 = 0;
            while (i8 < size) {
                ArrayList<PromoPayOptionAdapterParam> arrayList4 = this.mPayOptionsList;
                if (arrayList4 == null) {
                    k.a("mPayOptionsList");
                }
                PromoPayOptionAdapterParam promoPayOptionAdapterParam = arrayList4.get(i8);
                k.a((Object) promoPayOptionAdapterParam, "mPayOptionsList.get(i)");
                promoPayOptionAdapterParam.setSelected(i8 == intValue);
                i8++;
            }
            this.prevSelectedPosition = this.selectedPayOptionPosition;
            this.selectedPayOptionPosition = intValue;
            ArrayList<PromoPayOptionAdapterParam> arrayList5 = this.mPayOptionsList;
            if (arrayList5 == null) {
                k.a("mPayOptionsList");
            }
            PromoPayOptionAdapterParam promoPayOptionAdapterParam2 = arrayList5.get(intValue);
            k.a((Object) promoPayOptionAdapterParam2, "mPayOptionsList.get(pos)");
            if (TextUtils.isEmpty(promoPayOptionAdapterParam2.getPromoErrorMessage())) {
                enablePayButton();
            } else {
                disablePayButton();
            }
            notifyItemChanged();
            scrollRecyclerView();
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.Int");
    }

    private final void onApplyOfferClick(PromoPayOptionAdapterParam promoPayOptionAdapterParam) {
        BaseDataModel data;
        VpaAccountDetail vpaDetail;
        if (!SDKUtility.isNetworkAvailable(getContext())) {
            Toast.makeText(getContext(), getString(R.string.no_internet), 0).show();
        } else if (promoPayOptionAdapterParam == null || promoPayOptionAdapterParam.getData() == null) {
            Toast.makeText(getContext(), "Please select a payment method to apply offer", 0).show();
        } else {
            showLoadingState();
            String str = null;
            switch (promoPayOptionAdapterParam.getVIEWTYPE()) {
                case 0:
                    BaseDataModel data2 = promoPayOptionAdapterParam.getData();
                    if (data2 != null) {
                        SavedInstruments savedInstruments = (SavedInstruments) data2;
                        ArrayList arrayList = new ArrayList();
                        PaymentIntent paymentIntent = new PaymentIntent();
                        CardDetails cardDetails = savedInstruments.getCardDetails();
                        k.a((Object) cardDetails, "selectedCard.cardDetails");
                        paymentIntent.setCardHash(cardDetails.getCardHash());
                        CardDetails cardDetails2 = savedInstruments.getCardDetails();
                        k.a((Object) cardDetails2, "selectedCard.cardDetails");
                        paymentIntent.setBin6(cardDetails2.getFirstSixDigit());
                        CardDetails cardDetails3 = savedInstruments.getCardDetails();
                        k.a((Object) cardDetails3, "selectedCard.cardDetails");
                        String firstEightDigit = cardDetails3.getFirstEightDigit();
                        if (firstEightDigit != null) {
                            paymentIntent.setBin8(firstEightDigit);
                        }
                        PromoPayOptionAdapterParam promoPayOptionAdapterParam2 = this.selectedPayOption;
                        if (promoPayOptionAdapterParam2 != null) {
                            str = promoPayOptionAdapterParam2.getMode();
                        }
                        paymentIntent.setMode(str);
                        paymentIntent.setBanks(new ArrayList());
                        if (savedInstruments.getIssuingBank() != null) {
                            paymentIntent.getBanks().add(savedInstruments.getIssuingBank());
                        }
                        paymentIntent.setChannels(new ArrayList());
                        paymentIntent.getChannels().add(savedInstruments.getChannelCode());
                        paymentIntent.setTxnAmount(PromoHelper.Companion.getInstance().getAmount());
                        arrayList.add(paymentIntent);
                        PromoHelper.Companion.getInstance().onPaymentModeSelected(arrayList, promoPayOptionAdapterParam);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.common.model.SavedInstruments");
                case 1:
                    ArrayList arrayList2 = new ArrayList();
                    PaymentIntent paymentIntent2 = new PaymentIntent();
                    PromoPayOptionAdapterParam promoPayOptionAdapterParam3 = this.selectedPayOption;
                    paymentIntent2.setMode(promoPayOptionAdapterParam3 != null ? promoPayOptionAdapterParam3.getMode() : null);
                    paymentIntent2.setTxnAmount(PromoHelper.Companion.getInstance().getAmount());
                    paymentIntent2.setBanks(new ArrayList());
                    PromoPayOptionAdapterParam promoPayOptionAdapterParam4 = this.selectedPayOption;
                    if (!(promoPayOptionAdapterParam4 == null || (data = promoPayOptionAdapterParam4.getData()) == null)) {
                        ArrayList<String> banks = paymentIntent2.getBanks();
                        if (!(data instanceof PayChannelOptions)) {
                            data = null;
                        }
                        PayChannelOptions payChannelOptions = (PayChannelOptions) data;
                        if (payChannelOptions != null) {
                            str = payChannelOptions.getChannelCode();
                        }
                        banks.add(str);
                    }
                    arrayList2.add(paymentIntent2);
                    PromoHelper.Companion.getInstance().onPaymentModeSelected(arrayList2, promoPayOptionAdapterParam);
                    return;
                case 2:
                    if (((PromoPayOptionViewModel) getMViewModel()).isCardNumberInvalid(promoPayOptionAdapterParam.getCardNumber(), Integer.valueOf(promoPayOptionAdapterParam.getCardSizeShouldBe()))) {
                        PromoPayOptionAdapterParam promoPayOptionAdapterParam5 = this.selectedPayOption;
                        if (promoPayOptionAdapterParam5 != null) {
                            promoPayOptionAdapterParam5.setInputError(getString(R.string.enter_valid_card_number));
                        }
                        PromoPayOptionListAdapter promoPayOptionListAdapter = this.mPayOptionListAdapter;
                        if (promoPayOptionListAdapter != null) {
                            promoPayOptionListAdapter.notifyDataSetChanged();
                        }
                        hideLoadingState();
                        scrollRecyclerViewWithDelay();
                        return;
                    }
                    PromoPayOptionAdapterParam promoPayOptionAdapterParam6 = this.selectedPayOption;
                    if ((promoPayOptionAdapterParam6 != null ? promoPayOptionAdapterParam6.getMode() : null) != null) {
                        PromoPayOptionViewModel promoPayOptionViewModel = (PromoPayOptionViewModel) getMViewModel();
                        PromoPayOptionAdapterParam promoPayOptionAdapterParam7 = this.selectedPayOption;
                        if (promoPayOptionAdapterParam7 != null) {
                            str = promoPayOptionAdapterParam7.getMode();
                        }
                        if (str == null) {
                            k.a();
                        }
                        String cardNumber = promoPayOptionAdapterParam.getCardNumber();
                        k.a((Object) cardNumber, "selectedItem.cardNumber");
                        if (!promoPayOptionViewModel.isBinPayModeSame(str, p.a(cardNumber, "-", "", false))) {
                            showErrorDebitInCreditCard();
                            return;
                        }
                    }
                    String cardNumber2 = promoPayOptionAdapterParam.getCardNumber();
                    k.a((Object) cardNumber2, "selectedItem.cardNumber");
                    ((PromoPayOptionViewModel) getMViewModel()).fetchCardDetails(p.a(cardNumber2, "-", "", false));
                    return;
                case 3:
                    ArrayList arrayList3 = new ArrayList();
                    PaymentIntent paymentIntent3 = new PaymentIntent();
                    BaseDataModel data3 = promoPayOptionAdapterParam.getData();
                    if (!(data3 instanceof VpaBankAccountDetail)) {
                        data3 = null;
                    }
                    VpaBankAccountDetail vpaBankAccountDetail = (VpaBankAccountDetail) data3;
                    if (!(vpaBankAccountDetail == null || (vpaDetail = vpaBankAccountDetail.getVpaDetail()) == null)) {
                        str = vpaDetail.getName();
                    }
                    paymentIntent3.setVpa(str);
                    paymentIntent3.setMode(promoPayOptionAdapterParam.getMode());
                    paymentIntent3.setTxnAmount(PromoHelper.Companion.getInstance().getAmount());
                    arrayList3.add(paymentIntent3);
                    PromoHelper.Companion.getInstance().onPaymentModeSelected(arrayList3, promoPayOptionAdapterParam);
                    return;
                case 4:
                    if (TextUtils.isEmpty(promoPayOptionAdapterParam.getUpiAddress())) {
                        promoPayOptionAdapterParam.setInputError(getString(R.string.native_enter_vpa_address));
                        PromoPayOptionListAdapter promoPayOptionListAdapter2 = this.mPayOptionListAdapter;
                        if (promoPayOptionListAdapter2 != null) {
                            promoPayOptionListAdapter2.notifyDataSetChanged();
                        }
                        scrollRecyclerViewWithDelay();
                        hideLoadingState();
                        return;
                    }
                    String upiAddress = promoPayOptionAdapterParam.getUpiAddress();
                    k.a((Object) upiAddress, "selectedItem.upiAddress");
                    if (!p.a((CharSequence) upiAddress, (CharSequence) "@", false)) {
                        promoPayOptionAdapterParam.setInputError(getString(R.string.native_enter_valid_vpa_address));
                        PromoPayOptionListAdapter promoPayOptionListAdapter3 = this.mPayOptionListAdapter;
                        if (promoPayOptionListAdapter3 != null) {
                            promoPayOptionListAdapter3.notifyDataSetChanged();
                        }
                        scrollRecyclerViewWithDelay();
                        hideLoadingState();
                        return;
                    }
                    ((PromoPayOptionViewModel) getMViewModel()).validateVPA(promoPayOptionAdapterParam.getUpiAddress());
                    return;
                case 5:
                    ArrayList arrayList4 = new ArrayList();
                    PaymentIntent paymentIntent4 = new PaymentIntent();
                    paymentIntent4.setMode(promoPayOptionAdapterParam.getMode());
                    paymentIntent4.setTxnAmount(PromoHelper.Companion.getInstance().getAmount());
                    arrayList4.add(paymentIntent4);
                    PromoHelper.Companion.getInstance().onPaymentModeSelected(arrayList4, promoPayOptionAdapterParam);
                    return;
                case 6:
                    ArrayList arrayList5 = new ArrayList();
                    PaymentIntent paymentIntent5 = new PaymentIntent();
                    paymentIntent5.setMode(promoPayOptionAdapterParam.getMode());
                    paymentIntent5.setTxnAmount(PromoHelper.Companion.getInstance().getAmount());
                    arrayList5.add(paymentIntent5);
                    PromoHelper.Companion.getInstance().onPaymentModeSelected(arrayList5, promoPayOptionAdapterParam);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showErrorDebitInCreditCard() {
        PromoPayOptionAdapterParam promoPayOptionAdapterParam = this.selectedPayOption;
        if (p.a(SDKConstants.CREDIT, promoPayOptionAdapterParam != null ? promoPayOptionAdapterParam.getMode() : null, true)) {
            PromoPayOptionAdapterParam promoPayOptionAdapterParam2 = this.selectedPayOption;
            if (promoPayOptionAdapterParam2 != null) {
                promoPayOptionAdapterParam2.setInputError(getString(R.string.input_error_debit_in_credit));
            }
        } else {
            PromoPayOptionAdapterParam promoPayOptionAdapterParam3 = this.selectedPayOption;
            if (promoPayOptionAdapterParam3 != null) {
                promoPayOptionAdapterParam3.setInputError(getString(R.string.input_error_credit_in_debit));
            }
        }
        PromoPayOptionListAdapter promoPayOptionListAdapter = this.mPayOptionListAdapter;
        if (promoPayOptionListAdapter != null) {
            promoPayOptionListAdapter.notifyDataSetChanged();
        }
        hideLoadingState();
        scrollRecyclerViewWithDelay();
    }

    private final void setValidateVPAObserver() {
        ((PromoPayOptionViewModel) getMViewModel()).getValidateVPAObserver().observe(this, new PromoPayOptionsBottomSheet$setValidateVPAObserver$1(this));
    }

    private final void fetchCardDetailObserver() {
        ((PromoPayOptionViewModel) getMViewModel()).getFetchCardDetailObserver().observe(this, new PromoPayOptionsBottomSheet$fetchCardDetailObserver$1(this));
    }

    private final void checkBalanceObserver() {
        ((PromoPayOptionViewModel) getMViewModel()).getCheckBalanceObserver().observe(this, new PromoPayOptionsBottomSheet$checkBalanceObserver$1(this));
    }

    /* access modifiers changed from: private */
    public final void applyOfferPostPaid() {
        PromoPayOptionViewModel promoPayOptionViewModel = (PromoPayOptionViewModel) getMViewModel();
        PromoPayOptionAdapterParam promoPayOptionAdapterParam = this.selectedPayOption;
        CJRFetchBalanceResponse fetchBalanceResponse = promoPayOptionAdapterParam != null ? promoPayOptionAdapterParam.getFetchBalanceResponse() : null;
        if (fetchBalanceResponse == null) {
            k.a();
        }
        if (promoPayOptionViewModel.hasSufficientBalance(fetchBalanceResponse)) {
            applyOffer();
            hideLoadingState();
            return;
        }
        PromoHelper.Companion.getInstance().clearPromo(new PromoPayOptionsBottomSheet$applyOfferPostPaid$1(this));
    }

    /* access modifiers changed from: private */
    public final void onPromoCodeRemoved(String str) {
        disablePayButton();
        PromoPayOptionAdapterParam promoPayOptionAdapterParam = this.selectedPayOption;
        if (promoPayOptionAdapterParam != null) {
            promoPayOptionAdapterParam.setPromoErrorMessage(str);
        }
        PromoPayOptionListAdapter promoPayOptionListAdapter = this.mPayOptionListAdapter;
        if (promoPayOptionListAdapter != null) {
            promoPayOptionListAdapter.notifyDataSetChanged();
        }
        scrollRecyclerView();
        hideLoadingState();
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onVerifyPromoSuccess(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r8, boolean r9, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.VerifyResponseData r10) {
        /*
            r7 = this;
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r8 = r7.selectedPayOption
            r9 = 0
            if (r8 == 0) goto L_0x000c
            int r8 = r8.getVIEWTYPE()
            r0 = 5
            if (r8 == r0) goto L_0x0017
        L_0x000c:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r8 = r7.selectedPayOption
            if (r8 == 0) goto L_0x003b
            int r8 = r8.getVIEWTYPE()
            r0 = 6
            if (r8 != r0) goto L_0x003b
        L_0x0017:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r8 = r7.selectedPayOption
            if (r8 == 0) goto L_0x0020
            net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse r8 = r8.getFetchBalanceResponse()
            goto L_0x0021
        L_0x0020:
            r8 = r9
        L_0x0021:
            if (r8 == 0) goto L_0x0027
            r7.applyOfferPostPaid()
            goto L_0x003e
        L_0x0027:
            androidx.lifecycle.ai r8 = r7.getMViewModel()
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionViewModel r8 = (net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionViewModel) r8
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = r7.selectedPayOption
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = r0.getMode()
            goto L_0x0037
        L_0x0036:
            r0 = r9
        L_0x0037:
            r8.checkBalance(r0)
            goto L_0x003e
        L_0x003b:
            r7.applyOffer()
        L_0x003e:
            if (r10 == 0) goto L_0x0044
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ConvFeeResponse r9 = r10.getConvFeeResponse()
        L_0x0044:
            if (r9 == 0) goto L_0x0078
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r8 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r8 = r8.getInstance()
            java.util.ArrayList r8 = r8.getPaymentIntent()
            if (r8 == 0) goto L_0x0078
            net.one97.paytm.nativesdk.ConvenienceFeeOrController$Companion r8 = net.one97.paytm.nativesdk.ConvenienceFeeOrController.Companion
            net.one97.paytm.nativesdk.ConvenienceFeeOrController r8 = r8.getInstance()
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ConvFeeResponse r9 = r10.getConvFeeResponse()
            java.lang.String r0 = "data.convFeeResponse"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r0 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r0 = r0.getInstance()
            java.util.ArrayList r0 = r0.getPaymentIntent()
            if (r0 != 0) goto L_0x0070
            kotlin.g.b.k.a()
        L_0x0070:
            java.lang.Object r10 = r10.getVerifyModel()
            r8.setConvFeeResponse((net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.ConvFeeResponse) r9, (java.util.ArrayList<net.one97.paytm.nativesdk.common.model.PaymentIntent>) r0, (java.lang.Object) r10)
            goto L_0x0081
        L_0x0078:
            net.one97.paytm.nativesdk.ConvenienceFeeOrController$Companion r8 = net.one97.paytm.nativesdk.ConvenienceFeeOrController.Companion
            net.one97.paytm.nativesdk.ConvenienceFeeOrController r8 = r8.getInstance()
            r8.resetConvenienceFee()
        L_0x0081:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r8 = r7.selectedPayOption
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x0092
            int r8 = r8.getVIEWTYPE()
            r10 = 2
            if (r8 != r10) goto L_0x0092
            java.lang.String r8 = "New Card"
        L_0x0090:
            r4 = r8
            goto L_0x00a0
        L_0x0092:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r8 = r7.selectedPayOption
            if (r8 == 0) goto L_0x009f
            int r8 = r8.getVIEWTYPE()
            if (r8 != 0) goto L_0x009f
            java.lang.String r8 = "Saved Card"
            goto L_0x0090
        L_0x009f:
            r4 = r9
        L_0x00a0:
            net.one97.paytm.nativesdk.orflow.Utility r8 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            android.content.Context r10 = r7.getContext()
            net.one97.paytm.nativesdk.orflow.Utility r0 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r1 = r7.selectedPayOption
            if (r1 == 0) goto L_0x00b5
            java.lang.String r1 = r1.getMode()
            if (r1 != 0) goto L_0x00b3
            goto L_0x00b5
        L_0x00b3:
            r3 = r1
            goto L_0x00b6
        L_0x00b5:
            r3 = r9
        L_0x00b6:
            java.lang.String r1 = "bank_offer"
            java.lang.String r2 = "apply_offer_clicked"
            java.lang.String r5 = "successful"
            java.lang.String r6 = ""
            java.util.Map r9 = r0.getBankOfferEventParams(r1, r2, r3, r4, r5, r6)
            r8.sendBankOffersEvent(r10, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet.onVerifyPromoSuccess(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse, boolean, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$VerifyResponseData):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onVerifyPromoError(java.lang.String r11) {
        /*
            r10 = this;
            r10.hideLoadingState()
            r0 = r11
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001a
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = r10.selectedPayOption
            if (r0 == 0) goto L_0x0024
            int r1 = net.one97.paytm.nativesdk.R.string.default_promo_payoption_error_msg
            java.lang.String r1 = r10.getString(r1)
            r0.setNonPromoErrorMessage(r1)
            goto L_0x0024
        L_0x001a:
            r10.disablePayButton()
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = r10.selectedPayOption
            if (r0 == 0) goto L_0x0024
            r0.setPromoErrorMessage(r11)
        L_0x0024:
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionListAdapter r0 = r10.mPayOptionListAdapter
            if (r0 == 0) goto L_0x002b
            r0.notifyDataSetChanged()
        L_0x002b:
            r10.scrollRecyclerViewWithDelay()
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = r10.selectedPayOption
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x003f
            int r0 = r0.getVIEWTYPE()
            r2 = 2
            if (r0 != r2) goto L_0x003f
            java.lang.String r0 = "New Card"
        L_0x003d:
            r6 = r0
            goto L_0x004d
        L_0x003f:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = r10.selectedPayOption
            if (r0 == 0) goto L_0x004c
            int r0 = r0.getVIEWTYPE()
            if (r0 != 0) goto L_0x004c
            java.lang.String r0 = "Saved Card"
            goto L_0x003d
        L_0x004c:
            r6 = r1
        L_0x004d:
            net.one97.paytm.nativesdk.orflow.Utility r0 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            android.content.Context r9 = r10.getContext()
            net.one97.paytm.nativesdk.orflow.Utility r2 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r3 = r10.selectedPayOption
            if (r3 == 0) goto L_0x0062
            java.lang.String r3 = r3.getMode()
            if (r3 != 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r5 = r3
            goto L_0x0063
        L_0x0062:
            r5 = r1
        L_0x0063:
            if (r11 != 0) goto L_0x0067
            r8 = r1
            goto L_0x0068
        L_0x0067:
            r8 = r11
        L_0x0068:
            java.lang.String r3 = "bank_offer"
            java.lang.String r4 = "apply_offer_clicked"
            java.lang.String r7 = "failed"
            java.util.Map r11 = r2.getBankOfferEventParams(r3, r4, r5, r6, r7, r8)
            r0.sendBankOffersEvent(r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet.onVerifyPromoError(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0084, code lost:
        if (r11 == null) goto L_0x0086;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onVerifyPromoNetworkError(net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.ApiResponseError r11) {
        /*
            r10 = this;
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = r10.selectedPayOption
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0011
            int r0 = r0.getVIEWTYPE()
            r2 = 2
            if (r0 != r2) goto L_0x0011
            java.lang.String r0 = "New Card"
        L_0x000f:
            r6 = r0
            goto L_0x001f
        L_0x0011:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = r10.selectedPayOption
            if (r0 == 0) goto L_0x001e
            int r0 = r0.getVIEWTYPE()
            if (r0 != 0) goto L_0x001e
            java.lang.String r0 = "Saved Card"
            goto L_0x000f
        L_0x001e:
            r6 = r1
        L_0x001f:
            net.one97.paytm.nativesdk.orflow.Utility r0 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            android.content.Context r9 = r10.getContext()
            net.one97.paytm.nativesdk.orflow.Utility r2 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r3 = r10.selectedPayOption
            if (r3 == 0) goto L_0x0034
            java.lang.String r3 = r3.getMode()
            if (r3 != 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r5 = r3
            goto L_0x0035
        L_0x0034:
            r5 = r1
        L_0x0035:
            if (r11 == 0) goto L_0x0040
            java.lang.String r3 = r11.getErrorMsg()
            if (r3 != 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r8 = r3
            goto L_0x0041
        L_0x0040:
            r8 = r1
        L_0x0041:
            java.lang.String r3 = "bank_offer"
            java.lang.String r4 = "apply_offer_clicked"
            java.lang.String r7 = "failed"
            java.util.Map r1 = r2.getBankOfferEventParams(r3, r4, r5, r6, r7, r8)
            r0.sendBankOffersEvent(r9, r1)
            r10.hideLoadingState()
            r0 = 1
            if (r11 == 0) goto L_0x0067
            boolean r1 = r11.isClosePgWithoutError()
            if (r1 != r0) goto L_0x0067
            r10.dismissAllowingStateLoss()
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x0066
            r11.finish()
        L_0x0066:
            return
        L_0x0067:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r1 = r10.selectedPayOption
            if (r1 == 0) goto L_0x008f
            if (r11 == 0) goto L_0x0086
            java.lang.String r11 = r11.getErrorMsg()
            if (r11 == 0) goto L_0x0086
            r2 = r11
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x007e
            r2 = 1
            goto L_0x007f
        L_0x007e:
            r2 = 0
        L_0x007f:
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r11 = 0
        L_0x0084:
            if (r11 != 0) goto L_0x008c
        L_0x0086:
            int r11 = net.one97.paytm.nativesdk.R.string.default_promo_payoption_error_msg
            java.lang.String r11 = r10.getString(r11)
        L_0x008c:
            r1.setNonPromoErrorMessage(r11)
        L_0x008f:
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionListAdapter r11 = r10.mPayOptionListAdapter
            if (r11 == 0) goto L_0x0096
            r11.notifyDataSetChanged()
        L_0x0096:
            r10.scrollRecyclerViewWithDelay()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet.onVerifyPromoNetworkError(net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ApiResponseError):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r1 == null) goto L_0x001e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onNonPromoError(java.lang.String r11) {
        /*
            r10 = this;
            r10.hideLoadingState()
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = r10.selectedPayOption
            if (r0 == 0) goto L_0x0027
            if (r11 == 0) goto L_0x001e
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r2 = 1
            if (r1 != 0) goto L_0x0015
            r1 = 1
            goto L_0x0016
        L_0x0015:
            r1 = 0
        L_0x0016:
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x001b
            r1 = r11
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            if (r1 != 0) goto L_0x0024
        L_0x001e:
            int r1 = net.one97.paytm.nativesdk.R.string.default_promo_payoption_error_msg
            java.lang.String r1 = r10.getString(r1)
        L_0x0024:
            r0.setNonPromoErrorMessage(r1)
        L_0x0027:
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionListAdapter r0 = r10.mPayOptionListAdapter
            if (r0 == 0) goto L_0x002e
            r0.notifyDataSetChanged()
        L_0x002e:
            r10.scrollRecyclerViewWithDelay()
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = r10.selectedPayOption
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0042
            int r0 = r0.getVIEWTYPE()
            r2 = 2
            if (r0 != r2) goto L_0x0042
            java.lang.String r0 = "New Card"
        L_0x0040:
            r6 = r0
            goto L_0x0050
        L_0x0042:
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = r10.selectedPayOption
            if (r0 == 0) goto L_0x004f
            int r0 = r0.getVIEWTYPE()
            if (r0 != 0) goto L_0x004f
            java.lang.String r0 = "Saved Card"
            goto L_0x0040
        L_0x004f:
            r6 = r1
        L_0x0050:
            net.one97.paytm.nativesdk.orflow.Utility r0 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            android.content.Context r9 = r10.getContext()
            net.one97.paytm.nativesdk.orflow.Utility r2 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r3 = r10.selectedPayOption
            if (r3 == 0) goto L_0x0065
            java.lang.String r3 = r3.getMode()
            if (r3 != 0) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r5 = r3
            goto L_0x0066
        L_0x0065:
            r5 = r1
        L_0x0066:
            if (r11 != 0) goto L_0x006a
            r8 = r1
            goto L_0x006b
        L_0x006a:
            r8 = r11
        L_0x006b:
            java.lang.String r3 = "bank_offer"
            java.lang.String r4 = "apply_offer_clicked"
            java.lang.String r7 = "failed"
            java.util.Map r11 = r2.getBankOfferEventParams(r3, r4, r5, r6, r7, r8)
            r0.sendBankOffersEvent(r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet.onNonPromoError(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final void scrollRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_promo_pay_options);
        if (recyclerView != null) {
            recyclerView.scrollToPosition(this.selectedPayOptionPosition);
        }
    }

    private final void scrollRecyclerViewWithDelay() {
        scrollRecyclerView();
        new Handler().postDelayed(new PromoPayOptionsBottomSheet$scrollRecyclerViewWithDelay$1(this), 50);
    }

    private final void notifyItemChanged() {
        PromoPayOptionListAdapter promoPayOptionListAdapter = this.mPayOptionListAdapter;
        if (promoPayOptionListAdapter != null) {
            promoPayOptionListAdapter.notifyItemChanged(this.selectedPayOptionPosition);
        }
        PromoPayOptionListAdapter promoPayOptionListAdapter2 = this.mPayOptionListAdapter;
        if (promoPayOptionListAdapter2 != null) {
            promoPayOptionListAdapter2.notifyItemChanged(this.prevSelectedPosition);
        }
    }

    private final void enablePayButton() {
        ((LinearLayout) getMView().findViewById(R.id.llApplyOffer)).setOnClickListener(this);
        ((LinearLayout) getMView().findViewById(R.id.llApplyOffer)).setBackgroundResource(R.drawable.nativesdk_button_click);
    }

    private final void showLoadingState() {
        disableUiInteraction();
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading);
        ((LinearLayout) getMView().findViewById(R.id.llApplyOffer)).setBackgroundResource(R.drawable.promo_pay_button_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading);
        k.a((Object) lottieAnimationView2, "mView.ltv_loading");
        lottieAnimationView2.setVisibility(0);
        TextView textView = (TextView) getMView().findViewById(R.id.tvApplyOffer);
        k.a((Object) textView, "mView.tvApplyOffer");
        textView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void hideLoadingState() {
        enableUiInteraction();
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading);
        ((LinearLayout) getMView().findViewById(R.id.llApplyOffer)).setBackgroundResource(R.drawable.promo_pay_button_click);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading);
        k.a((Object) lottieAnimationView2, "mView.ltv_loading");
        lottieAnimationView2.setVisibility(8);
        TextView textView = (TextView) getMView().findViewById(R.id.tvApplyOffer);
        k.a((Object) textView, "mView.tvApplyOffer");
        textView.setVisibility(0);
    }

    public final void enableUiInteraction() {
        FrameLayout frameLayout = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout, "mView.disableClickView");
        frameLayout.setVisibility(8);
        FrameLayout frameLayout2 = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout2, "mView.disableClickView");
        frameLayout2.setClickable(false);
    }

    public final void disableUiInteraction() {
        FrameLayout frameLayout = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout, "mView.disableClickView");
        frameLayout.setVisibility(0);
        FrameLayout frameLayout2 = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout2, "mView.disableClickView");
        frameLayout2.setClickable(true);
    }

    public static class MyDividerItemDecoration extends RecyclerView.h {
        private final int[] attrs;
        private final Context context;
        private Drawable divider;

        public MyDividerItemDecoration(Context context2) {
            k.c(context2, "context");
            this.context = context2;
            this.attrs = new int[]{16843284};
            TypedArray obtainStyledAttributes = this.context.obtainStyledAttributes(this.attrs);
            this.divider = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
        }

        public final Context getContext() {
            return this.context;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public MyDividerItemDecoration(Context context2, int i2) {
            this(context2);
            k.c(context2, "context");
            this.divider = b.a(context2, i2);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
            k.c(canvas, "c");
            k.c(recyclerView, "parent");
            k.c(sVar, "state");
            int paddingLeft = recyclerView.getPaddingLeft() + SDKUtility.convertDpToPixel(this.context, 36);
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount() - 1;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = recyclerView.getChildAt(i2);
                k.a((Object) childAt, "child");
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams != null) {
                    int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
                    Drawable drawable = this.divider;
                    Integer valueOf = drawable != null ? Integer.valueOf(drawable.getIntrinsicHeight()) : null;
                    if (valueOf == null) {
                        k.a();
                    }
                    int intValue = valueOf.intValue() + bottom;
                    Drawable drawable2 = this.divider;
                    if (drawable2 != null) {
                        drawable2.setBounds(paddingLeft, bottom, width, intValue);
                    }
                    Drawable drawable3 = this.divider;
                    if (drawable3 != null) {
                        drawable3.draw(canvas);
                    }
                    i2++;
                } else {
                    throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                }
            }
        }
    }
}

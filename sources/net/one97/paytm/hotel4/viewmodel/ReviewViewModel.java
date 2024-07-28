package net.one97.paytm.hotel4.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.appsflyer.share.Constants;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.p;
import com.sendbird.android.constant.StringSet;
import com.travel.utils.h;
import com.travel.utils.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.hotel4.service.a.d;
import net.one97.paytm.hotel4.service.a.e;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.GSTDetails;
import net.one97.paytm.hotel4.service.model.UserDetails;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotel4.service.model.details.CancellationPolicy;
import net.one97.paytm.hotel4.service.model.details.PriceData;
import net.one97.paytm.hotel4.service.model.details.ReviewBookingEvent;
import net.one97.paytm.hotel4.service.model.details.SubRoomOptions;
import net.one97.paytm.hotel4.service.model.details.SubRoomProvider;
import net.one97.paytm.hotel4.service.model.promocode.PromoCodeApply;
import net.one97.paytm.hotel4.service.model.promocode.PromocodeDataItem;
import net.one97.paytm.hotel4.service.model.promocode.PromocodeResponse;
import net.one97.paytm.hotel4.utils.d;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.hotels2.utils.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONObject;

public final class ReviewViewModel extends BaseViewModel {
    private y<List<String>> _GSTTncData = new y<>();
    private y<String> _gstCompanyName = new y<>();
    private y<String> _gstNumber = new y<>();
    private y<String> _hotelFullAddress = new y<>();
    private y<Boolean> _hotelGSTEnabled = new y<>();
    private y<Boolean> _hotelGSTUserEnabled = new y<>();
    private y<String> _hotelName = new y<>();
    private y<Boolean> _isApplyPromoCodeViewVisible = new y<>();
    private y<String> _promoCodeApplyCashBack = new y<>();
    private y<Boolean> _promoCodeApplyCashBackVisibility = new y<>();
    private y<String> _promoCodeApplyCode = new y<>();
    private y<String> _promoCodeApplyText = new y<>();
    private y<String> _promoCodePTPText = new y<>();
    private y<PromocodeDataItem> _promoCodeSelected = new y<>();
    private y<UserDetails> _userDetails = new y<>();
    private y<String> _userEmail = new y<>();
    private y<String> _userLName = new y<>();
    private y<String> _userMobile = new y<>();
    private y<String> _userName = new y<>();
    private y<Boolean> _validateUserDetails = new y<>();
    private y<String> adultCount = new y<>();
    private l<ErrorData> apiCallFailure = new l<>();
    private l<PromocodeResponse> apiCallSuccess = new l<>();
    private l<PromoCodeApply> apiCallSuccessApplyPromoCode = new l<>();
    private l<CJRRechargePayment> apiProcessToPaySuccess = new l<>();
    private PromocodeDataItem applyPromoData;
    private y<String> childCount = new y<>();
    private Context context;
    private h debounceClick = new h(750);
    private String enteredPromoCode = "";
    private GSTDetails gstData;
    private l<Boolean> gstTncDialogListener = new l<>();
    private l<Boolean> isErrorPopUpVisible = new l<>();
    private y<String> morePromocodeText = new y<>();
    private l<Boolean> offerTncDialogListener = new l<>();
    private y<String> processToPayRequestID = new y<>();
    private y<Boolean> processToPayTapped = new y<>();
    private y<Boolean> procodeLoader = new y<>();
    private PromoCodeApply promoCodeApplyResponse;
    private d promoCodeRepo;
    private PromocodeResponse promoCodeResponse;
    private y<PromocodeDataItem> promoCodeSelectedForTnC = new y<>();
    private e reviewRepository;
    private y<String> roomCount = new y<>();
    private y<SRPDataItem> selectedData = new y<>();
    private y<SubRoomOptions> selectedRoomData = new y<>();
    private l<CancellationPolicy> successCancellationListener = new l<>();
    private l<Boolean> successWalletTokenForPromoApplyListener = new l<>();
    private l<Boolean> successWalletTokenListener = new l<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReviewViewModel(SharedViewModel sharedViewModel) {
        super(sharedViewModel);
        k.c(sharedViewModel, "parent");
    }

    public final y<Boolean> getProcessToPayTapped() {
        return this.processToPayTapped;
    }

    public final void setProcessToPayTapped(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.processToPayTapped = yVar;
    }

    public final String getEnteredPromoCode() {
        return this.enteredPromoCode;
    }

    public final void setEnteredPromoCode(String str) {
        k.c(str, "<set-?>");
        this.enteredPromoCode = str;
    }

    public final y<SRPDataItem> getSelectedData() {
        return this.selectedData;
    }

    public final void setSelectedData(y<SRPDataItem> yVar) {
        k.c(yVar, "<set-?>");
        this.selectedData = yVar;
    }

    public final y<String> getProcessToPayRequestID() {
        return this.processToPayRequestID;
    }

    public final void setProcessToPayRequestID(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this.processToPayRequestID = yVar;
    }

    public final y<String> get_hotelName() {
        return this._hotelName;
    }

    public final void set_hotelName(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._hotelName = yVar;
    }

    public final y<String> get_hotelFullAddress() {
        return this._hotelFullAddress;
    }

    public final void set_hotelFullAddress(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._hotelFullAddress = yVar;
    }

    public final y<Boolean> get_hotelGSTEnabled() {
        return this._hotelGSTEnabled;
    }

    public final void set_hotelGSTEnabled(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this._hotelGSTEnabled = yVar;
    }

    public final y<Boolean> get_hotelGSTUserEnabled() {
        return this._hotelGSTUserEnabled;
    }

    public final void set_hotelGSTUserEnabled(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this._hotelGSTUserEnabled = yVar;
    }

    public final y<List<String>> get_GSTTncData() {
        return this._GSTTncData;
    }

    public final void set_GSTTncData(y<List<String>> yVar) {
        k.c(yVar, "<set-?>");
        this._GSTTncData = yVar;
    }

    public final y<PromocodeDataItem> get_promoCodeSelected() {
        return this._promoCodeSelected;
    }

    public final void set_promoCodeSelected(y<PromocodeDataItem> yVar) {
        k.c(yVar, "<set-?>");
        this._promoCodeSelected = yVar;
    }

    public final y<PromocodeDataItem> getPromoCodeSelectedForTnC() {
        return this.promoCodeSelectedForTnC;
    }

    public final void setPromoCodeSelectedForTnC(y<PromocodeDataItem> yVar) {
        k.c(yVar, "<set-?>");
        this.promoCodeSelectedForTnC = yVar;
    }

    public final y<SubRoomOptions> getSelectedRoomData() {
        return this.selectedRoomData;
    }

    public final void setSelectedRoomData(y<SubRoomOptions> yVar) {
        k.c(yVar, "<set-?>");
        this.selectedRoomData = yVar;
    }

    public final y<Boolean> get_validateUserDetails() {
        return this._validateUserDetails;
    }

    public final void set_validateUserDetails(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this._validateUserDetails = yVar;
    }

    public final y<Boolean> get_isApplyPromoCodeViewVisible() {
        return this._isApplyPromoCodeViewVisible;
    }

    public final void set_isApplyPromoCodeViewVisible(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this._isApplyPromoCodeViewVisible = yVar;
    }

    public final l<Boolean> getSuccessWalletTokenListener() {
        return this.successWalletTokenListener;
    }

    public final void setSuccessWalletTokenListener(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.successWalletTokenListener = lVar;
    }

    public final l<Boolean> getSuccessWalletTokenForPromoApplyListener() {
        return this.successWalletTokenForPromoApplyListener;
    }

    public final void setSuccessWalletTokenForPromoApplyListener(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.successWalletTokenForPromoApplyListener = lVar;
    }

    public final l<CancellationPolicy> getSuccessCancellationListener() {
        return this.successCancellationListener;
    }

    public final void setSuccessCancellationListener(l<CancellationPolicy> lVar) {
        k.c(lVar, "<set-?>");
        this.successCancellationListener = lVar;
    }

    public final y<String> getAdultCount() {
        return this.adultCount;
    }

    public final void setAdultCount(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this.adultCount = yVar;
    }

    public final y<String> getChildCount() {
        return this.childCount;
    }

    public final void setChildCount(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this.childCount = yVar;
    }

    public final y<String> getRoomCount() {
        return this.roomCount;
    }

    public final void setRoomCount(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this.roomCount = yVar;
    }

    public final y<String> getMorePromocodeText() {
        return this.morePromocodeText;
    }

    public final void setMorePromocodeText(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this.morePromocodeText = yVar;
    }

    public final PromocodeResponse getPromoCodeResponse() {
        return this.promoCodeResponse;
    }

    public final void setPromoCodeResponse(PromocodeResponse promocodeResponse) {
        this.promoCodeResponse = promocodeResponse;
    }

    public final PromoCodeApply getPromoCodeApplyResponse() {
        return this.promoCodeApplyResponse;
    }

    public final void setPromoCodeApplyResponse(PromoCodeApply promoCodeApply) {
        this.promoCodeApplyResponse = promoCodeApply;
    }

    public final d getPromoCodeRepo() {
        return this.promoCodeRepo;
    }

    public final void setPromoCodeRepo(d dVar) {
        this.promoCodeRepo = dVar;
    }

    public final PromocodeDataItem getApplyPromoData() {
        return this.applyPromoData;
    }

    public final void setApplyPromoData(PromocodeDataItem promocodeDataItem) {
        this.applyPromoData = promocodeDataItem;
    }

    public final GSTDetails getGstData() {
        return this.gstData;
    }

    public final void setGstData(GSTDetails gSTDetails) {
        this.gstData = gSTDetails;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        this.context = context2;
    }

    public final y<Boolean> getProcodeLoader() {
        return this.procodeLoader;
    }

    public final void setProcodeLoader(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.procodeLoader = yVar;
    }

    public final l<PromoCodeApply> getApiCallSuccessApplyPromoCode() {
        return this.apiCallSuccessApplyPromoCode;
    }

    public final void setApiCallSuccessApplyPromoCode(l<PromoCodeApply> lVar) {
        k.c(lVar, "<set-?>");
        this.apiCallSuccessApplyPromoCode = lVar;
    }

    public final y<String> get_promoCodeApplyCashBack() {
        return this._promoCodeApplyCashBack;
    }

    public final void set_promoCodeApplyCashBack(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._promoCodeApplyCashBack = yVar;
    }

    public final y<Boolean> get_promoCodeApplyCashBackVisibility() {
        return this._promoCodeApplyCashBackVisibility;
    }

    public final void set_promoCodeApplyCashBackVisibility(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this._promoCodeApplyCashBackVisibility = yVar;
    }

    public final y<String> get_promoCodePTPText() {
        return this._promoCodePTPText;
    }

    public final void set_promoCodePTPText(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._promoCodePTPText = yVar;
    }

    public final y<String> get_promoCodeApplyText() {
        return this._promoCodeApplyText;
    }

    public final void set_promoCodeApplyText(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._promoCodeApplyText = yVar;
    }

    public final y<String> get_promoCodeApplyCode() {
        return this._promoCodeApplyCode;
    }

    public final void set_promoCodeApplyCode(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._promoCodeApplyCode = yVar;
    }

    public final l<PromocodeResponse> getApiCallSuccess() {
        return this.apiCallSuccess;
    }

    public final void setApiCallSuccess(l<PromocodeResponse> lVar) {
        k.c(lVar, "<set-?>");
        this.apiCallSuccess = lVar;
    }

    public final l<ErrorData> getApiCallFailure() {
        return this.apiCallFailure;
    }

    public final void setApiCallFailure(l<ErrorData> lVar) {
        k.c(lVar, "<set-?>");
        this.apiCallFailure = lVar;
    }

    public final l<CJRRechargePayment> getApiProcessToPaySuccess() {
        return this.apiProcessToPaySuccess;
    }

    public final void setApiProcessToPaySuccess(l<CJRRechargePayment> lVar) {
        k.c(lVar, "<set-?>");
        this.apiProcessToPaySuccess = lVar;
    }

    public final y<UserDetails> get_userDetails() {
        return this._userDetails;
    }

    public final void set_userDetails(y<UserDetails> yVar) {
        k.c(yVar, "<set-?>");
        this._userDetails = yVar;
    }

    public final y<String> get_userName() {
        return this._userName;
    }

    public final void set_userName(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._userName = yVar;
    }

    public final y<String> get_userLName() {
        return this._userLName;
    }

    public final void set_userLName(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._userLName = yVar;
    }

    public final y<String> get_userEmail() {
        return this._userEmail;
    }

    public final void set_userEmail(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._userEmail = yVar;
    }

    public final y<String> get_userMobile() {
        return this._userMobile;
    }

    public final void set_userMobile(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._userMobile = yVar;
    }

    public final y<String> get_gstNumber() {
        return this._gstNumber;
    }

    public final void set_gstNumber(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._gstNumber = yVar;
    }

    public final y<String> get_gstCompanyName() {
        return this._gstCompanyName;
    }

    public final void set_gstCompanyName(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._gstCompanyName = yVar;
    }

    public final l<Boolean> isErrorPopUpVisible() {
        return this.isErrorPopUpVisible;
    }

    public final void setErrorPopUpVisible(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.isErrorPopUpVisible = lVar;
    }

    public final l<Boolean> getGstTncDialogListener() {
        return this.gstTncDialogListener;
    }

    public final void setGstTncDialogListener(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.gstTncDialogListener = lVar;
    }

    public final l<Boolean> getOfferTncDialogListener() {
        return this.offerTncDialogListener;
    }

    public final void setOfferTncDialogListener(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.offerTncDialogListener = lVar;
    }

    public final e getReviewRepository() {
        return this.reviewRepository;
    }

    public final void setReviewRepository(e eVar) {
        this.reviewRepository = eVar;
    }

    public final void initRepository(e eVar) {
        k.c(eVar, "repo");
        this.reviewRepository = eVar;
    }

    public final void setGST(GSTDetails gSTDetails) {
        this.gstData = gSTDetails;
    }

    public final void setAppContext(Context context2) {
        this.context = context2;
    }

    public final void onMorePromoCodePressed() {
        getParent().postScreenNavigationEvent("8", "444");
    }

    public final void onClearPromoCodePressed() {
        this._isApplyPromoCodeViewVisible.postValue(Boolean.FALSE);
        this._promoCodeApplyCashBackVisibility.postValue(Boolean.FALSE);
        this.promoCodeApplyResponse = null;
        this.applyPromoData = null;
        this._promoCodeSelected.postValue(null);
    }

    public final void onBackPressed() {
        getParent().postScreenNavigationEvent("8", "7");
    }

    public final void onProcessToPayPressed() {
        if (!this.debounceClick.a("processToPayButton") && !k.a((Object) this.processToPayTapped.getValue(), (Object) Boolean.TRUE)) {
            this.processToPayTapped.setValue(Boolean.TRUE);
            this._validateUserDetails.postValue(Boolean.TRUE);
        }
    }

    public final boolean checkLoginStatusForPTP(Context context2) {
        e eVar = this.reviewRepository;
        if (TextUtils.isEmpty(eVar != null ? eVar.d() : null)) {
            c.b().a(context2, new Intent(), 801);
            return false;
        }
        e eVar2 = this.reviewRepository;
        if (eVar2 == null) {
            return true;
        }
        eVar2.a(this.successWalletTokenListener, (Activity) context2);
        return true;
    }

    private final boolean checkLoginStatusForPromo(Context context2) {
        e eVar = this.reviewRepository;
        if (TextUtils.isEmpty(eVar != null ? eVar.d() : null)) {
            c.b().a(context2, new Intent(), 800);
            return false;
        }
        e eVar2 = this.reviewRepository;
        if (eVar2 == null) {
            return true;
        }
        eVar2.a(this.successWalletTokenForPromoApplyListener, (Activity) context2);
        return true;
    }

    public final void initPaymentProcess() {
        SubRoomOptions value = this.selectedRoomData.getValue();
        List<SubRoomProvider> subRoomProviders = value != null ? value.getSubRoomProviders() : null;
        if (subRoomProviders == null) {
            k.a();
        }
        PriceData priceData = subRoomProviders.get(0).getPriceData();
        if (priceData == null) {
            k.a();
        }
        sendProcessToPayPulseEvent(Double.valueOf(priceData.getTotalPriceWithTax()));
        e eVar = this.reviewRepository;
        if (eVar != null) {
            SRPDataItem value2 = this.selectedData.getValue();
            if (value2 == null) {
                k.a();
            }
            k.a((Object) value2, "selectedData.value!!");
            SRPDataItem sRPDataItem = value2;
            PromocodeDataItem promocodeDataItem = this.applyPromoData;
            SubRoomOptions value3 = this.selectedRoomData.getValue();
            if (value3 == null) {
                k.a();
            }
            k.a((Object) value3, "selectedRoomData.value!!");
            SubRoomOptions subRoomOptions = value3;
            CJRHotelSearchInput searchInput = getParent().getSearchInput();
            if (searchInput == null) {
                k.a();
            }
            String value4 = this.processToPayRequestID.getValue();
            if (value4 == null) {
                k.a();
            }
            k.a((Object) value4, "processToPayRequestID.value!!");
            String str = value4;
            UserDetails value5 = this._userDetails.getValue();
            if (value5 == null) {
                k.a();
            }
            k.a((Object) value5, "_userDetails.value!!");
            UserDetails userDetails = value5;
            GSTDetails gSTDetails = this.gstData;
            y<CJRRechargePayment> yVar = this.apiProcessToPaySuccess;
            y<ErrorData> yVar2 = this.apiCallFailure;
            k.c(sRPDataItem, "selectedHotel");
            k.c(subRoomOptions, "selectedRoomData");
            k.c(searchInput, "inputSearchData");
            k.c(str, "processTopayRequestID");
            k.c(userDetails, "userData");
            k.c(yVar, "successProcessPayListener");
            k.c(yVar2, "failureListener");
            eVar.f28622i = yVar;
            eVar.l = yVar2;
            eVar.f28614a = sRPDataItem;
            eVar.f28615b = subRoomOptions;
            eVar.f28616c = searchInput;
            eVar.f28617d = promocodeDataItem;
            eVar.f28618e = userDetails;
            eVar.f28619f = gSTDetails;
            k.a((Object) net.one97.paytm.hotels2.utils.e.a(), "HotelsGTMLoader.getInstance()");
            Uri.Builder buildUpon = Uri.parse(net.one97.paytm.hotels2.utils.e.p()).buildUpon();
            buildUpon.appendQueryParameter("requestId", str);
            buildUpon.appendQueryParameter("native_withdraw", "1");
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put(AppConstants.SSO_TOKEN, eVar.d());
            a l = new b().a((Context) eVar.m).a(a.b.SILENT).c("8").a(a.c.HOTELS).a(a.C0715a.POST).a(buildUpon.build().toString()).h().a((Map<String, String>) hashMap).b((Map) null).b(eVar.c().toString()).a((IJRPaytmDataModel) new CJRRechargePayment()).a((com.paytm.network.listener.b) new e.a()).a(true).l();
            k.a((Object) l, "networking");
            l.a(true);
            l.a();
            x xVar = x.f47997a;
        }
    }

    public final void setPromoCodeData(PromocodeResponse promocodeResponse) {
        this.promoCodeResponse = promocodeResponse;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setApplyPromoCodeData(net.one97.paytm.hotel4.service.model.promocode.PromoCodeApply r9) {
        /*
            r8 = this;
            java.lang.String r0 = "response"
            kotlin.g.b.k.c(r9, r0)
            r8.promoCodeApplyResponse = r9
            net.one97.paytm.hotel4.service.model.promocode.PromoCodeApplyData r0 = r9.getData()
            r1 = 0
            if (r0 == 0) goto L_0x0013
            java.lang.Integer r0 = r0.getPaytm_cashback()
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            net.one97.paytm.hotel4.service.model.promocode.PromoCodeApplyData r2 = r9.getData()
            if (r2 == 0) goto L_0x001f
            java.lang.String r2 = r2.getPromotext()
            goto L_0x0020
        L_0x001f:
            r2 = r1
        L_0x0020:
            net.one97.paytm.hotel4.service.model.promocode.PromoCodeApplyData r9 = r9.getData()
            if (r9 == 0) goto L_0x002b
            java.lang.String r9 = r9.getPromocode()
            goto L_0x002c
        L_0x002b:
            r9 = r1
        L_0x002c:
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x00d3
            int r5 = r0.intValue()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0042
            r5 = 1
            goto L_0x0043
        L_0x0042:
            r5 = 0
        L_0x0043:
            if (r5 == 0) goto L_0x00d3
            int r5 = r0.intValue()
            if (r5 != 0) goto L_0x0053
            androidx.lifecycle.y<java.lang.Boolean> r1 = r8._promoCodeApplyCashBackVisibility
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r1.postValue(r5)
            goto L_0x00bc
        L_0x0053:
            androidx.lifecycle.y<java.lang.Boolean> r5 = r8._promoCodeApplyCashBackVisibility
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r5.postValue(r6)
            androidx.lifecycle.y<net.one97.paytm.hotel4.service.model.details.SubRoomOptions> r5 = r8.selectedRoomData
            java.lang.Object r5 = r5.getValue()
            if (r5 != 0) goto L_0x0065
            kotlin.g.b.k.a()
        L_0x0065:
            net.one97.paytm.hotel4.service.model.details.SubRoomOptions r5 = (net.one97.paytm.hotel4.service.model.details.SubRoomOptions) r5
            java.util.List r5 = r5.getSubRoomProviders()
            if (r5 != 0) goto L_0x0070
            kotlin.g.b.k.a()
        L_0x0070:
            java.lang.Object r5 = r5.get(r4)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r5 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r5
            net.one97.paytm.hotel4.service.model.details.PriceData r5 = r5.getPriceData()
            if (r5 == 0) goto L_0x0084
            double r5 = r5.getTotalPriceWithTax()
            java.lang.Double r1 = java.lang.Double.valueOf(r5)
        L_0x0084:
            if (r1 != 0) goto L_0x0089
            kotlin.g.b.k.a()
        L_0x0089:
            double r5 = r1.doubleValue()
            int r1 = (int) r5
            int r5 = r0.intValue()
            int r1 = r1 - r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "With cashback of ₹"
            r5.<init>(r6)
            int r6 = r0.intValue()
            double r6 = (double) r6
            java.lang.String r6 = com.paytm.utility.b.a((double) r6)
            r5.append(r6)
            java.lang.String r6 = ", your effective price is ₹"
            r5.append(r6)
            double r6 = (double) r1
            java.lang.String r1 = com.paytm.utility.b.a((double) r6)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            androidx.lifecycle.y<java.lang.String> r5 = r8._promoCodePTPText
            r5.postValue(r1)
        L_0x00bc:
            androidx.lifecycle.y<java.lang.String> r1 = r8._promoCodeApplyCashBack
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.lang.String r0 = " Cashback"
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r1.postValue(r0)
            goto L_0x00e1
        L_0x00d3:
            androidx.lifecycle.y<java.lang.Boolean> r0 = r8._promoCodeApplyCashBackVisibility
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.postValue(r1)
            androidx.lifecycle.y<java.lang.String> r0 = r8._promoCodeApplyCashBack
            java.lang.String r1 = "0 Cashback"
            r0.postValue(r1)
        L_0x00e1:
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
            java.lang.String r1 = ""
            if (r2 == 0) goto L_0x0110
            java.lang.String r5 = r2.toString()
            if (r5 == 0) goto L_0x010a
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.CharSequence r5 = kotlin.m.p.b(r5)
            java.lang.String r5 = r5.toString()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0101
            r5 = 1
            goto L_0x0102
        L_0x0101:
            r5 = 0
        L_0x0102:
            if (r5 == 0) goto L_0x0110
            androidx.lifecycle.y<java.lang.String> r5 = r8._promoCodeApplyText
            r5.postValue(r2)
            goto L_0x0115
        L_0x010a:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r0)
            throw r9
        L_0x0110:
            androidx.lifecycle.y<java.lang.String> r2 = r8._promoCodeApplyText
            r2.postValue(r1)
        L_0x0115:
            if (r9 == 0) goto L_0x0142
            java.lang.String r2 = r9.toString()
            if (r2 == 0) goto L_0x013c
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r0 = kotlin.m.p.b(r2)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0130
            goto L_0x0131
        L_0x0130:
            r3 = 0
        L_0x0131:
            if (r3 == 0) goto L_0x0142
            androidx.lifecycle.y<java.lang.String> r0 = r8._promoCodeApplyCode
            r0.postValue(r9)
            r8.sendPulseEventForPromocodeSelected(r9)
            goto L_0x0147
        L_0x013c:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r0)
            throw r9
        L_0x0142:
            androidx.lifecycle.y<java.lang.String> r9 = r8._promoCodeApplyCode
            r9.postValue(r1)
        L_0x0147:
            androidx.lifecycle.y<java.lang.Boolean> r9 = r8._isApplyPromoCodeViewVisible
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r9.postValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.ReviewViewModel.setApplyPromoCodeData(net.one97.paytm.hotel4.service.model.promocode.PromoCodeApply):void");
    }

    public final void initDetailsRepository(d dVar) {
        k.c(dVar, "repo");
        this.promoCodeRepo = dVar;
    }

    public final void updatePaxCount() {
        ArrayList<CJRRoom> rooms;
        y<String> yVar = this.childCount;
        CJRHotelSearchInput searchInput = getParent().getSearchInput();
        Integer num = null;
        yVar.postValue(String.valueOf(searchInput != null ? Integer.valueOf(searchInput.getChildCount()) : null));
        y<String> yVar2 = this.adultCount;
        CJRHotelSearchInput searchInput2 = getParent().getSearchInput();
        yVar2.postValue(String.valueOf(searchInput2 != null ? Integer.valueOf(searchInput2.getAdultCount()) : null));
        y<String> yVar3 = this.roomCount;
        CJRHotelSearchInput searchInput3 = getParent().getSearchInput();
        if (!(searchInput3 == null || (rooms = searchInput3.getRooms()) == null)) {
            num = Integer.valueOf(rooms.size());
        }
        yVar3.postValue(String.valueOf(num));
    }

    public final String validateUserData() {
        UserDetails value = this._userDetails.getValue();
        if (value == null) {
            k.a();
        }
        if (value.getFirstname() == null) {
            return "0";
        }
        UserDetails value2 = this._userDetails.getValue();
        if (value2 == null) {
            k.a();
        }
        String firstname = value2.getFirstname();
        if (firstname == null) {
            k.a();
        }
        boolean z = true;
        if (!(firstname.length() > 0)) {
            return "0";
        }
        UserDetails value3 = this._userDetails.getValue();
        if (value3 == null) {
            k.a();
        }
        if (value3.getLastname() == null) {
            return "1";
        }
        UserDetails value4 = this._userDetails.getValue();
        if (value4 == null) {
            k.a();
        }
        String lastname = value4.getLastname();
        if (lastname == null) {
            k.a();
        }
        if (lastname.length() <= 0) {
            z = false;
        }
        if (!z) {
            return "1";
        }
        UserDetails value5 = this._userDetails.getValue();
        if (value5 == null) {
            k.a();
        }
        if (value5.getEmail() == null) {
            return "2";
        }
        UserDetails value6 = this._userDetails.getValue();
        if (value6 == null) {
            k.a();
        }
        if (!p.c(value6.getEmail())) {
            return "2";
        }
        UserDetails value7 = this._userDetails.getValue();
        if (value7 == null) {
            k.a();
        }
        if (value7.getMobile() == null) {
            return "3";
        }
        UserDetails value8 = this._userDetails.getValue();
        if (value8 == null) {
            k.a();
        }
        return !p.d(value8.getMobile()) ? "3" : "6";
    }

    public final boolean isValidGST(String str) {
        k.c(str, "gstIN");
        return p.b(str);
    }

    public final void applyPromoCode() {
        this.procodeLoader.postValue(Boolean.TRUE);
        e eVar = this.reviewRepository;
        if (eVar != null) {
            PromocodeDataItem promocodeDataItem = this.applyPromoData;
            if (promocodeDataItem == null) {
                k.a();
            }
            SRPDataItem value = this.selectedData.getValue();
            if (value == null) {
                k.a();
            }
            k.a((Object) value, "selectedData.value!!");
            SRPDataItem sRPDataItem = value;
            SubRoomOptions value2 = this.selectedRoomData.getValue();
            if (value2 == null) {
                k.a();
            }
            k.a((Object) value2, "selectedRoomData.value!!");
            SubRoomOptions subRoomOptions = value2;
            CJRHotelSearchInput searchInput = getParent().getSearchInput();
            if (searchInput == null) {
                k.a();
            }
            y<PromoCodeApply> yVar = this.apiCallSuccessApplyPromoCode;
            y<ErrorData> yVar2 = this.apiCallFailure;
            k.c(promocodeDataItem, "selectedPromoCode");
            k.c(sRPDataItem, "selectedHotel");
            k.c(subRoomOptions, "selectedRoomData");
            k.c(searchInput, "inputSearchData");
            k.c(yVar, "successCheckPromoListener");
            k.c(yVar2, "failureCheckPromoListener");
            eVar.f28620g = yVar;
            eVar.f28621h = yVar2;
            eVar.f28617d = promocodeDataItem;
            eVar.f28614a = sRPDataItem;
            eVar.f28615b = subRoomOptions;
            eVar.f28616c = searchInput;
            k.a((Object) net.one97.paytm.hotels2.utils.e.a(), "HotelsGTMLoader.getInstance()");
            String n = net.one97.paytm.hotels2.utils.e.n();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            a l = new b().a((Context) eVar.m).a(a.b.SILENT).c("8").a(a.c.HOTELS).a(a.C0715a.POST).a(n).h().a((Map<String, String>) hashMap).b((Map) null).b(eVar.c().toString()).a((IJRPaytmDataModel) new PromoCodeApply()).a((com.paytm.network.listener.b) new e.a()).a(true).l();
            k.a((Object) l, "networking");
            l.a(true);
            l.a();
        }
    }

    public final void applyPromoCodeButtonCLicked() {
        if (getParent().getContext() == null || com.paytm.utility.b.c(getParent().getContext())) {
            String replace = new kotlin.m.l("\\s").replace((CharSequence) this.enteredPromoCode, "");
            if (replace != null) {
                String obj = kotlin.m.p.b(replace).toString();
                if (!(obj.length() == 0)) {
                    PromocodeDataItem promocodeDataItem = new PromocodeDataItem(obj, (String) null, (String) null, (Integer) null, 14, (g) null);
                    this._promoCodeSelected.postValue(promocodeDataItem);
                    this.applyPromoData = promocodeDataItem;
                    if (checkLoginStatusForPromo(this.context)) {
                        applyPromoCode();
                        return;
                    }
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        }
        Context context2 = getParent().getContext();
        Context context3 = getParent().getContext();
        if (context3 == null) {
            k.a();
        }
        String string = context3.getResources().getString(R.string.hotels_hotel_no_internet_title);
        Context context4 = getParent().getContext();
        if (context4 == null) {
            k.a();
        }
        com.paytm.utility.b.a(context2, string, context4.getResources().getString(R.string.hotels_hotel_no_internet_message));
    }

    public static /* synthetic */ void onPromoCodeClick$default(ReviewViewModel reviewViewModel, PromocodeDataItem promocodeDataItem, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        reviewViewModel.onPromoCodeClick(promocodeDataItem, z);
    }

    public final void onPromoCodeClick(PromocodeDataItem promocodeDataItem, boolean z) {
        k.c(promocodeDataItem, "promoData");
        if (!this.debounceClick.a("promoCodeButton")) {
            this._promoCodeSelected.postValue(promocodeDataItem);
            this.applyPromoData = promocodeDataItem;
            boolean checkLoginStatusForPromo = checkLoginStatusForPromo(this.context);
            if (z && checkLoginStatusForPromo) {
                if (getParent().getContext() == null || !com.paytm.utility.b.c(getParent().getContext())) {
                    Context context2 = getParent().getContext();
                    Context context3 = getParent().getContext();
                    if (context3 == null) {
                        k.a();
                    }
                    String string = context3.getResources().getString(R.string.hotels_hotel_no_internet_title);
                    Context context4 = getParent().getContext();
                    if (context4 == null) {
                        k.a();
                    }
                    com.paytm.utility.b.a(context2, string, context4.getResources().getString(R.string.hotels_hotel_no_internet_message));
                    return;
                }
                applyPromoCode();
            }
        }
    }

    public final Boolean isGSTEnabled() {
        return this._hotelGSTEnabled.getValue();
    }

    public final void isUserGSTEnabled(boolean z) {
        if (z) {
            sendPulseEvent("gst_checkbox");
        }
        this._hotelGSTUserEnabled.postValue(Boolean.valueOf(z));
    }

    public final void fetchPromoData(SubRoomOptions subRoomOptions) {
        k.c(subRoomOptions, "selectedRoom");
        this.selectedRoomData.postValue(subRoomOptions);
        List<SubRoomProvider> subRoomProviders = subRoomOptions.getSubRoomProviders();
        if (subRoomProviders == null) {
            k.a();
        }
        String optString = new JSONObject(String.valueOf(subRoomProviders.get(0).getBookParams())).optString(Constants.URL_MEDIA_SOURCE);
        d dVar = this.promoCodeRepo;
        if (dVar != null) {
            l<PromocodeResponse> lVar = this.apiCallSuccess;
            l<ErrorData> lVar2 = this.apiCallFailure;
            k.a((Object) optString, "Pid");
            k.c(lVar, "sucessListener");
            k.c(lVar2, "failureListener");
            k.c(optString, Constants.URL_MEDIA_SOURCE);
            dVar.f28611c = lVar;
            dVar.f28612d = lVar2;
            StringBuilder sb = new StringBuilder();
            net.one97.paytm.hotels2.utils.e.a();
            sb.append(net.one97.paytm.hotels2.utils.e.s());
            sb.append(optString);
            sb.append(dVar.f28609a);
            String sb2 = sb.toString();
            a l = new b().a((Context) dVar.f28610b).a(a.b.SILENT).c("promosearch").a(a.c.FLIGHT).a(a.C0715a.GET).a(sb2).h().a((Map<String, String>) new HashMap()).b((Map) null).b((String) null).a((IJRPaytmDataModel) new PromocodeResponse()).a((com.paytm.network.listener.b) new d.a()).a(true).l();
            k.a((Object) l, "networking");
            l.a(true);
            l.a();
        }
    }

    public final void updateReviewBookingEvent(SRPDataItem sRPDataItem, String str) {
        e eVar;
        if (sRPDataItem != null && str != null && (eVar = this.reviewRepository) != null) {
            k.c(sRPDataItem, "selectedHotel");
            k.c(str, "processTopayRequestID");
            k.a((Object) net.one97.paytm.hotels2.utils.e.a(), "HotelsGTMLoader.getInstance()");
            Uri.Builder buildUpon = Uri.parse(net.one97.paytm.hotels2.utils.e.q()).buildUpon();
            buildUpon.appendQueryParameter("requestId", str);
            buildUpon.appendQueryParameter("id", sRPDataItem.getId());
            buildUpon.appendQueryParameter("hotel", sRPDataItem.getName());
            buildUpon.appendQueryParameter("client", StringSet.Android);
            buildUpon.appendQueryParameter("deviceIdentifier", H5AppHandler.CHECK_VALUE);
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.SSO_TOKEN, eVar.d());
            a l = new b().a((Context) eVar.m).a(a.b.SILENT).c("8").a(a.c.HOTELS).a(a.C0715a.POST).a(buildUpon.build().toString()).h().a((Map<String, String>) hashMap).b((Map) null).b((String) null).a((IJRPaytmDataModel) new ReviewBookingEvent()).a((com.paytm.network.listener.b) new e.a()).a(true).l();
            k.a((Object) l, "networking");
            l.a(true);
            l.a();
        }
    }

    public final void setUserDetails() {
        ArrayList arrayList;
        net.one97.paytm.hotel4.utils.e eVar = net.one97.paytm.hotel4.utils.e.f28642a;
        if (!net.one97.paytm.hotel4.utils.e.a(this._userName.getValue())) {
            net.one97.paytm.hotel4.utils.e eVar2 = net.one97.paytm.hotel4.utils.e.f28642a;
            if (!net.one97.paytm.hotel4.utils.e.a(this._userLName.getValue())) {
                net.one97.paytm.hotel4.utils.e eVar3 = net.one97.paytm.hotel4.utils.e.f28642a;
                if (!net.one97.paytm.hotel4.utils.e.a(this._userEmail.getValue())) {
                    net.one97.paytm.hotel4.utils.e eVar4 = net.one97.paytm.hotel4.utils.e.f28642a;
                    if (!net.one97.paytm.hotel4.utils.e.a(this._userMobile.getValue())) {
                        String str = null;
                        String str2 = "";
                        if (this.reviewRepository != null) {
                            arrayList = new ArrayList();
                            d.a aVar = net.one97.paytm.hotel4.utils.d.f28640a;
                            net.one97.paytm.hotels2.utils.d b2 = c.b();
                            k.a((Object) b2, "HotelController.getHotelEventListener()");
                            Context a2 = b2.a();
                            k.a((Object) a2, "HotelController.getHotelEventListener().appContext");
                            Context applicationContext = a2.getApplicationContext();
                            k.a((Object) applicationContext, "HotelController.getHotel…ontext.applicationContext");
                            com.paytm.b.a.a a3 = d.a.a(applicationContext);
                            arrayList.add(a3.b("userName", str2, true));
                            arrayList.add(a3.b(com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL, str2, true));
                            arrayList.add(a3.b("mobile", str2, true));
                        } else {
                            arrayList = null;
                        }
                        if (arrayList != null && arrayList.size() > 0) {
                            String str3 = (String) arrayList.get(0);
                            k.a((Object) str3, "userDetails?.get(0)");
                            if (str3.length() > 0) {
                                String str4 = (String) arrayList.get(0);
                                k.a((Object) str4, "userDetails?.get(0)");
                                List b3 = kotlin.m.p.a((CharSequence) str4, new String[]{" "});
                                if (b3.isEmpty()) {
                                    y<String> yVar = this._userName;
                                    if (b3 != null) {
                                        str = (String) b3.get(0);
                                    }
                                    yVar.setValue(str);
                                } else {
                                    y<String> yVar2 = this._userName;
                                    if (b3 != null) {
                                        str = (String) b3.get(0);
                                    }
                                    yVar2.setValue(str);
                                    StringBuffer stringBuffer = new StringBuffer();
                                    int size = b3.size();
                                    for (int i2 = 1; i2 < size; i2++) {
                                        stringBuffer.append(((String) b3.get(i2)) + " ");
                                    }
                                    str2 = stringBuffer.toString();
                                    k.a((Object) str2, "lname.toString()");
                                    this._userLName.setValue(str2);
                                }
                            } else {
                                this._userName.setValue((String) arrayList.get(0));
                            }
                            this._userEmail.setValue((String) arrayList.get(1));
                            this._userMobile.setValue((String) arrayList.get(2));
                            new UserDetails("", (String) arrayList.get(0), str2, (String) arrayList.get(1), (String) arrayList.get(2));
                        }
                    }
                }
            }
        }
    }

    public final void openTnC() {
        if (!this.debounceClick.a("openTnC")) {
            sendPulseEvent("view_tnc");
            this.offerTncDialogListener.postValue(Boolean.TRUE);
        }
    }

    public final void openTnCOfGST() {
        if (!this.debounceClick.a("openTnCofGST")) {
            this.gstTncDialogListener.postValue(Boolean.TRUE);
        }
    }

    public final void showData() {
        getParent().postScreenNavigationEvent("8", "1113");
    }

    public final void showCancellationPolicy() {
        if (!this.debounceClick.a("showCancellationPolicy")) {
            if (getParent().getContext() != null && com.paytm.utility.b.c(getParent().getContext())) {
                e eVar = this.reviewRepository;
                if (eVar != null) {
                    CJRHotelSearchInput searchInput = getParent().getSearchInput();
                    if (searchInput == null) {
                        k.a();
                    }
                    eVar.f28616c = searchInput;
                    SRPDataItem value = this.selectedData.getValue();
                    if (value == null) {
                        k.a();
                    }
                    eVar.f28614a = value;
                    SubRoomOptions value2 = this.selectedRoomData.getValue();
                    if (value2 == null) {
                        k.a();
                    }
                    eVar.f28615b = value2;
                    y<CancellationPolicy> yVar = this.successCancellationListener;
                    k.c(yVar, "successCancellationListener");
                    eVar.j = yVar;
                    k.a((Object) net.one97.paytm.hotels2.utils.e.a(), "HotelsGTMLoader.getInstance()");
                    String o = net.one97.paytm.hotels2.utils.e.o();
                    Map hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    Map hashMap2 = new HashMap();
                    hashMap2.put("requestId", "");
                    a l = new b().a((Context) eVar.m).a(a.b.SILENT).c("8").a(a.c.HOTELS).a(a.C0715a.POST).a(o).h().a((Map<String, String>) hashMap).b(hashMap2).b(eVar.c().toString()).a((IJRPaytmDataModel) new CancellationPolicy()).a((com.paytm.network.listener.b) new e.a()).a(true).l();
                    k.a((Object) l, "networking");
                    l.a(true);
                    l.a();
                }
            } else if (getParent().getContext() != null) {
                Context context2 = getParent().getContext();
                Context context3 = getParent().getContext();
                if (context3 == null) {
                    k.a();
                }
                String string = context3.getResources().getString(R.string.hotels_hotel_no_internet_title);
                Context context4 = getParent().getContext();
                if (context4 == null) {
                    k.a();
                }
                com.paytm.utility.b.a(context2, string, context4.getResources().getString(R.string.hotels_hotel_no_internet_message));
            }
        }
    }

    private final void sendPulseEventForPromocodeSelected(String str) {
        HashMap hashMap = new HashMap();
        if (getParent().getSearchInput() != null) {
            Map map = hashMap;
            CJRHotelSearchInput searchInput = getParent().getSearchInput();
            if (searchInput == null) {
                k.a();
            }
            String city = searchInput.getCity();
            if (city != null) {
                map.put("event_label", city);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
        }
        Map map2 = hashMap;
        String value = this._hotelName.getValue();
        if (value != null) {
            map2.put("event_label2", value);
            if (str != null) {
                map2.put("event_label3", str);
                c.b().a("customEvent", "Review Page", "hotels_review", "promo_applied", map2);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Any");
        }
        throw new u("null cannot be cast to non-null type kotlin.Any");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
        r3 = r3.getRooms();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendPageOpenPulseEvent(java.lang.String r10, java.lang.Double r11) {
        /*
            r9 = this;
            java.lang.String r0 = "name"
            kotlin.g.b.k.c(r10, r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r1 = r9.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r1.getSearchInput()
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Any"
            if (r1 == 0) goto L_0x0063
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r3 = r9.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r3 = r3.getSearchInput()
            if (r3 != 0) goto L_0x0026
            kotlin.g.b.k.a()
        L_0x0026:
            java.lang.String r3 = r3.getCity()
            if (r3 == 0) goto L_0x005d
            java.lang.Object r3 = (java.lang.Object) r3
            java.lang.String r4 = "event_label"
            r1.put(r4, r3)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r3 = r9.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r3 = r3.getSearchInput()
            if (r3 == 0) goto L_0x004c
            java.util.ArrayList r3 = r3.getRooms()
            if (r3 == 0) goto L_0x004c
            int r3 = r3.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x004d
        L_0x004c:
            r3 = 0
        L_0x004d:
            if (r3 == 0) goto L_0x0057
            java.lang.Object r3 = (java.lang.Object) r3
            java.lang.String r4 = "event_label3"
            r1.put(r4, r3)
            goto L_0x0063
        L_0x0057:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r2)
            throw r10
        L_0x005d:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r2)
            throw r10
        L_0x0063:
            r8 = r0
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r10 = (java.lang.Object) r10
            java.lang.String r0 = "event_label2"
            r8.put(r0, r10)
            if (r11 == 0) goto L_0x0086
            java.lang.Object r11 = (java.lang.Object) r11
            java.lang.String r10 = "event_label4"
            r8.put(r10, r11)
            net.one97.paytm.hotels2.utils.d r3 = net.one97.paytm.hotels2.utils.c.b()
            java.lang.String r4 = "customEvent"
            java.lang.String r5 = "Review Page"
            java.lang.String r6 = "hotels_review"
            java.lang.String r7 = "page_opened"
            r3.a(r4, r5, r6, r7, r8)
            return
        L_0x0086:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.ReviewViewModel.sendPageOpenPulseEvent(java.lang.String, java.lang.Double):void");
    }

    public final void sendPulseEvent(String str) {
        k.c(str, "EVENT_ACTION");
        HashMap hashMap = new HashMap();
        if (getParent().getSearchInput() != null) {
            Map map = hashMap;
            CJRHotelSearchInput searchInput = getParent().getSearchInput();
            if (searchInput == null) {
                k.a();
            }
            String city = searchInput.getCity();
            if (city != null) {
                map.put("event_label", city);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
        }
        Map map2 = hashMap;
        String value = this._hotelName.getValue();
        if (value != null) {
            map2.put("event_label2", value);
            c.b().a("customEvent", "Review Page", "hotels_review", str, map2);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.Any");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        r3 = r3.getRooms();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendProcessToPayPulseEvent(java.lang.Double r10) {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r1 = r9.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r1.getSearchInput()
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Any"
            if (r1 == 0) goto L_0x005e
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r3 = r9.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r3 = r3.getSearchInput()
            if (r3 != 0) goto L_0x0021
            kotlin.g.b.k.a()
        L_0x0021:
            java.lang.String r3 = r3.getCity()
            if (r3 == 0) goto L_0x0058
            java.lang.Object r3 = (java.lang.Object) r3
            java.lang.String r4 = "event_label"
            r1.put(r4, r3)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r3 = r9.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r3 = r3.getSearchInput()
            if (r3 == 0) goto L_0x0047
            java.util.ArrayList r3 = r3.getRooms()
            if (r3 == 0) goto L_0x0047
            int r3 = r3.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0048
        L_0x0047:
            r3 = 0
        L_0x0048:
            if (r3 == 0) goto L_0x0052
            java.lang.Object r3 = (java.lang.Object) r3
            java.lang.String r4 = "event_label3"
            r1.put(r4, r3)
            goto L_0x005e
        L_0x0052:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r2)
            throw r10
        L_0x0058:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r2)
            throw r10
        L_0x005e:
            r8 = r0
            java.util.Map r8 = (java.util.Map) r8
            androidx.lifecycle.y<java.lang.String> r0 = r9._hotelName
            java.lang.Object r0 = r0.getValue()
            if (r0 == 0) goto L_0x008d
            java.lang.String r1 = "event_label2"
            r8.put(r1, r0)
            if (r10 == 0) goto L_0x0087
            java.lang.Object r10 = (java.lang.Object) r10
            java.lang.String r0 = "event_label4"
            r8.put(r0, r10)
            net.one97.paytm.hotels2.utils.d r3 = net.one97.paytm.hotels2.utils.c.b()
            java.lang.String r4 = "customEvent"
            java.lang.String r5 = "Review Page"
            java.lang.String r6 = "hotels_review"
            java.lang.String r7 = "proceed_to_pay_tapped"
            r3.a(r4, r5, r6, r7, r8)
            return
        L_0x0087:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r2)
            throw r10
        L_0x008d:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.ReviewViewModel.sendProcessToPayPulseEvent(java.lang.Double):void");
    }

    public final void showPromptDialog(Context context2, ErrorDialogViewModel errorDialogViewModel, String str) {
        k.c(errorDialogViewModel, "dialogViewModel");
        k.c(str, "tag");
        errorDialogViewModel.getTag().postValue(str);
        errorDialogViewModel.getErrorObject().postValue(new net.one97.paytm.hotel4.utils.b(context2).a(str));
        this.isErrorPopUpVisible.postValue(Boolean.TRUE);
        getParent().postScreenNavigationEvent("8", SDKConstants.UPI_LIMIT_EXCEED_ERROR);
    }
}

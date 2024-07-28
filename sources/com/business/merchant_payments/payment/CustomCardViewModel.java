package com.business.merchant_payments.payment;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.business.common_module.b.e;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.model.customcards.CustomCardUIModel;
import com.business.merchant_payments.model.customcards.DynamicCustomCardDataModel;
import com.business.merchant_payments.model.customcards.nextDayCustomCards;
import com.google.gson.f;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import retrofit2.Call;
import retrofit2.Response;

public final class CustomCardViewModel extends c {
    public final String BODY_TXT = "body";
    public final String CARDS_TO_SHOW_NEXT_DAY = "3,4,5";
    public final String CTA_TXT = Item.KEY_CTA;
    public final String HEADER_TXT = H5Logger.HEADER;
    public final String NEVER_SHOW_AGAIN_CARDS = "6,7";
    public final y<b<List<DynamicCustomCardDataModel>>> customCardAPIData = new y<>();
    public LiveData<ArrayList<Object>> customCardModelList = new y();

    public final void initDefaultParams() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomCardViewModel(Application application) {
        super(application);
        k.d(application, "application");
    }

    public final LiveData<ArrayList<Object>> getCustomCardModelList() {
        return this.customCardModelList;
    }

    public final void setCustomCardModelList(LiveData<ArrayList<Object>> liveData) {
        k.d(liveData, "<set-?>");
        this.customCardModelList = liveData;
    }

    public final y<b<List<DynamicCustomCardDataModel>>> getCustomCardAPIData() {
        return this.customCardAPIData;
    }

    public enum CustomCardId {
        CARD_ID_1(1),
        CARD_ID_2(2),
        CARD_ID_3(3),
        CARD_ID_4(4),
        CARD_ID_5(5),
        CARD_ID_6(6),
        CARD_ID_7(7),
        CARD_ID_8(8),
        CARD_ID_9(9),
        CARD_ID_10(10),
        CARD_ID_11(11),
        CARD_ID_12(12),
        CARD_ID_13(13);
        
        public final int value;

        /* access modifiers changed from: public */
        CustomCardId(int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public final void getCustomCardsInfo() {
        APSharedPreferences instance = APSharedPreferences.getInstance();
        k.b(instance, "APSharedPreferences.getInstance()");
        String neverShowCards = instance.getNeverShowCards();
        APSharedPreferences instance2 = APSharedPreferences.getInstance();
        k.b(instance2, "APSharedPreferences.getInstance()");
        String customCardsNextDay = instance2.getCustomCardsNextDay();
        nextDayCustomCards nextdaycustomcards = !TextUtils.isEmpty(customCardsNextDay) ? (nextDayCustomCards) new f().a(customCardsNextDay, nextDayCustomCards.class) : null;
        if (nextdaycustomcards != null) {
            if (!DateUtility.checkTodaysDate(new Date(nextdaycustomcards.getTimestamp()))) {
                APSharedPreferences.getInstance().removePreviousDayCards();
            } else {
                k.b(neverShowCards, "excludeCards");
                if (neverShowCards.length() == 0) {
                    neverShowCards = nextdaycustomcards.getCards();
                } else {
                    neverShowCards = neverShowCards + ',' + nextdaycustomcards.getCards();
                }
            }
        }
        k.b(neverShowCards, "excludeCards");
        callCustomCardsAPI(neverShowCards);
    }

    private final void callCustomCardsAPI(String str) {
        this.customCardAPIData.setValue(b.a());
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (!i.a(instance.getApplication())) {
            this.customCardAPIData.setValue(b.a("NO NETWORK"));
        }
        String str2 = GTMDataProviderImpl.Companion.getMInstance().getUMPBaseUrl() + GTMDataProviderImpl.Companion.getMInstance().getCustomCardUrl();
        if (!URLUtil.isValidUrl(str2)) {
            this.customCardAPIData.setValue(b.a((Response<?>) null));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.QueryParams.SHOW_SETTLEMENT_CARDS, "True");
        hashMap.put(AppConstants.QueryParams.EXCLUDE, str);
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        Call<List<DynamicCustomCardDataModel>> callCustomCardsApi = instance2.getNetworkService().callCustomCardsApi(str2, RequestParamUtil.getRequestHeaderMidParam(getContext()), hashMap);
        k.b(callCustomCardsApi, "PaymentsConfig.getInstan…Param(context), queryMap)");
        callCustomCardsApi.enqueue(new CustomCardViewModel$callCustomCardsAPI$1(this));
    }

    /* access modifiers changed from: private */
    public final void handleCustomCardResponse(List<DynamicCustomCardDataModel> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            CustomCardUIModel customCardUIData = getCustomCardUIData(list.get(i2));
            arrayList.add(i2, customCardUIData);
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            e eventPublisher = instance.getEventPublisher();
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            Context appContext = instance2.getAppContext();
            eventPublisher.a(appContext, "HomePage", "Yellow Cards-" + customCardUIData.getCardId(), "", getCardGAEventLabel(customCardUIData), "Promo Impression", "");
        }
        LiveData<ArrayList<Object>> liveData = this.customCardModelList;
        if (liveData != null) {
            ((y) liveData).setValue(arrayList);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
    }

    private final String getCardGAEventLabel(CustomCardUIModel customCardUIModel) {
        String str;
        try {
            String headerText = customCardUIModel.getHeaderText();
            if (headerText == null || headerText == null) {
                headerText = "";
            }
            if (customCardUIModel.isCtaVisible()) {
                str = customCardUIModel.getCtaText();
                if (str == null || str == null) {
                    str = "";
                }
            } else {
                str = "NA";
            }
            return headerText + ';' + str;
        } catch (Exception unused) {
            return "";
        }
    }

    private final CustomCardUIModel getCustomCardUIData(DynamicCustomCardDataModel dynamicCustomCardDataModel) {
        String str;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        String str4;
        String str5;
        int i2;
        int i3;
        int stringNameForCard = getStringNameForCard(dynamicCustomCardDataModel.getCardId(), this.HEADER_TXT);
        int stringNameForCard2 = getStringNameForCard(dynamicCustomCardDataModel.getCardId(), this.BODY_TXT);
        int stringNameForCard3 = getStringNameForCard(dynamicCustomCardDataModel.getCardId(), this.CTA_TXT);
        boolean ctaVisible = dynamicCustomCardDataModel.getCtaVisible();
        boolean showHeaderArrow = dynamicCustomCardDataModel.getShowHeaderArrow();
        if (stringNameForCard == 0 || stringNameForCard == -1) {
            str = dynamicCustomCardDataModel.getDefaultHeader();
        } else {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            str = instance.getAppContext().getString(stringNameForCard);
            k.b(str, "PaymentsConfig.getInstan…xt.getString(headerResId)");
        }
        if (stringNameForCard2 == 0 || stringNameForCard2 == -1) {
            str2 = dynamicCustomCardDataModel.getDefaultBody();
        } else {
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            str2 = instance2.getAppContext().getString(stringNameForCard2);
            k.b(str2, "PaymentsConfig.getInstan…text.getString(bodyResId)");
        }
        String str6 = str2;
        if (stringNameForCard3 == 0 || stringNameForCard3 == -1) {
            str3 = dynamicCustomCardDataModel.getDefaultCta();
        } else {
            PaymentsConfig instance3 = PaymentsConfig.getInstance();
            k.b(instance3, "PaymentsConfig.getInstance()");
            str3 = instance3.getAppContext().getString(stringNameForCard3);
            k.b(str3, "PaymentsConfig.getInstan…ntext.getString(ctaResId)");
        }
        String str7 = str3;
        boolean z3 = false;
        boolean z4 = str7 == null || str7.length() == 0 ? false : ctaVisible;
        if (Integer.valueOf(dynamicCustomCardDataModel.getCardId()).equals(Integer.valueOf(CustomCardId.CARD_ID_9.getValue())) || Integer.valueOf(dynamicCustomCardDataModel.getCardId()).equals(Integer.valueOf(CustomCardId.CARD_ID_10.getValue())) || Integer.valueOf(dynamicCustomCardDataModel.getCardId()).equals(Integer.valueOf(CustomCardId.CARD_ID_11.getValue()))) {
            z2 = true;
            z = false;
        } else {
            z2 = false;
            z = true;
        }
        String cardColor = dynamicCustomCardDataModel.getCardColor();
        if (cardColor == null || cardColor.length() == 0) {
            str4 = "#ebf8fe";
        } else {
            str4 = "#" + dynamicCustomCardDataModel.getCardColor();
        }
        int parseColor = Color.parseColor(str4);
        String headerColor = dynamicCustomCardDataModel.getHeaderColor();
        if (headerColor == null || headerColor.length() == 0) {
            str5 = "#00b9f5";
        } else {
            str5 = "#" + dynamicCustomCardDataModel.getHeaderColor();
        }
        int parseColor2 = Color.parseColor(str5);
        String bodyColor = dynamicCustomCardDataModel.getBodyColor();
        if (bodyColor == null || bodyColor.length() == 0) {
            i2 = Color.parseColor("#222222");
        } else {
            i2 = Color.parseColor("#" + dynamicCustomCardDataModel.getBodyColor());
        }
        int i4 = i2;
        String ctaColor = dynamicCustomCardDataModel.getCtaColor();
        if (ctaColor == null || ctaColor.length() == 0) {
            z3 = true;
        }
        if (z3) {
            i3 = Color.parseColor("#222222");
        } else {
            i3 = Color.parseColor("#" + dynamicCustomCardDataModel.getCtaColor());
        }
        return new CustomCardUIModel(str, str6, str7, parseColor2, !TextUtils.isEmpty(dynamicCustomCardDataModel.getIconUrl()), dynamicCustomCardDataModel.getHeaderParams(), dynamicCustomCardDataModel.getCtaParams(), dynamicCustomCardDataModel.getBodyParams(), dynamicCustomCardDataModel.getDeeplink(), dynamicCustomCardDataModel.getIconUrl(), z4, dynamicCustomCardDataModel.getCloseable(), showHeaderArrow, parseColor, dynamicCustomCardDataModel.getCardId(), R.drawable.mp_ic_blue_right_arrow, z2, z, i4, i3);
    }

    private final int getStringNameForCard(int i2, String str) {
        try {
            Field declaredField = R.string.class.getDeclaredField("mp_card_" + String.valueOf(i2) + "_" + str);
            k.b(declaredField, "R.string::class.java.getDeclaredField(stringName)");
            return declaredField.getInt(declaredField);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: com.business.merchant_payments.model.customcards.nextDayCustomCards} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setCardPreferences(int r5) {
        /*
            r4 = this;
            java.lang.String r0 = r4.NEVER_SHOW_AGAIN_CARDS
            java.lang.String r1 = java.lang.String.valueOf(r5)
            r2 = 0
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r1, (boolean) r2)
            r1 = 44
            java.lang.String r3 = "APSharedPreferences.getInstance()"
            if (r0 == 0) goto L_0x0050
            com.business.merchant_payments.common.utility.APSharedPreferences r0 = com.business.merchant_payments.common.utility.APSharedPreferences.getInstance()
            kotlin.g.b.k.b(r0, r3)
            java.lang.String r0 = r0.getNeverShowCards()
            java.lang.String r3 = "savedCards"
            kotlin.g.b.k.b(r0, r3)
            int r3 = r0.length()
            if (r3 != 0) goto L_0x0028
            r2 = 1
        L_0x0028:
            if (r2 == 0) goto L_0x0036
            com.business.merchant_payments.common.utility.APSharedPreferences r0 = com.business.merchant_payments.common.utility.APSharedPreferences.getInstance()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.saveNeverShowCards(r5)
            return
        L_0x0036:
            com.business.merchant_payments.common.utility.APSharedPreferences r2 = com.business.merchant_payments.common.utility.APSharedPreferences.getInstance()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r1)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            r2.saveNeverShowCards(r5)
            return
        L_0x0050:
            java.lang.String r0 = r4.CARDS_TO_SHOW_NEXT_DAY
            java.lang.String r2 = java.lang.String.valueOf(r5)
            boolean r0 = kotlin.m.p.c((java.lang.CharSequence) r0, (java.lang.CharSequence) r2)
            if (r0 == 0) goto L_0x00b5
            com.business.merchant_payments.common.utility.APSharedPreferences r0 = com.business.merchant_payments.common.utility.APSharedPreferences.getInstance()
            kotlin.g.b.k.b(r0, r3)
            java.lang.String r0 = r0.getCustomCardsNextDay()
            r2 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x007c
            com.google.gson.f r2 = new com.google.gson.f
            r2.<init>()
            java.lang.Class<com.business.merchant_payments.model.customcards.nextDayCustomCards> r3 = com.business.merchant_payments.model.customcards.nextDayCustomCards.class
            java.lang.Object r0 = r2.a((java.lang.String) r0, r3)
            r2 = r0
            com.business.merchant_payments.model.customcards.nextDayCustomCards r2 = (com.business.merchant_payments.model.customcards.nextDayCustomCards) r2
        L_0x007c:
            if (r2 == 0) goto L_0x0098
            java.lang.String r0 = r2.getCards()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r1)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            r2.setCards(r5)
            goto L_0x00a5
        L_0x0098:
            com.business.merchant_payments.model.customcards.nextDayCustomCards r2 = new com.business.merchant_payments.model.customcards.nextDayCustomCards
            java.lang.String r5 = java.lang.String.valueOf(r5)
            long r0 = java.lang.System.currentTimeMillis()
            r2.<init>(r5, r0)
        L_0x00a5:
            com.business.merchant_payments.common.utility.APSharedPreferences r5 = com.business.merchant_payments.common.utility.APSharedPreferences.getInstance()
            com.google.gson.f r0 = new com.google.gson.f
            r0.<init>()
            java.lang.String r0 = r0.b(r2)
            r5.saveNextDayCardPreference(r0)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.CustomCardViewModel.setCardPreferences(int):void");
    }

    public final void handleCustomCardClicked(CustomCardUIModel customCardUIModel) {
        k.d(customCardUIModel, PayUtility.CARD_INFO);
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        e eventPublisher = instance.getEventPublisher();
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        Context appContext = instance2.getAppContext();
        eventPublisher.a(appContext, "HomePage", "Yellow Cards-" + customCardUIModel.getCardId(), "", getCardGAEventLabel(customCardUIModel), "Promo Click", "");
        ArrayList value = this.customCardModelList.getValue();
        if (value != null) {
            value.remove(customCardUIModel);
            LiveData<ArrayList<Object>> liveData = this.customCardModelList;
            if (liveData != null) {
                ((y) liveData).setValue(value);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
        }
    }

    public final void handleCustomCardClosed(CustomCardUIModel customCardUIModel) {
        k.d(customCardUIModel, PayUtility.CARD_INFO);
        ArrayList value = this.customCardModelList.getValue();
        if (value != null) {
            value.remove(customCardUIModel);
            LiveData<ArrayList<Object>> liveData = this.customCardModelList;
            if (liveData != null) {
                ((y) liveData).setValue(value);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */>");
            }
        }
        setCardPreferences(customCardUIModel.getCardId());
    }
}

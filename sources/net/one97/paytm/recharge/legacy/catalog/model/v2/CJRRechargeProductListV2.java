package net.one97.paytm.recharge.legacy.catalog.model.v2;

import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.recharge.legacy.catalog.model.CJRRichMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRRechargeProductListV2 extends IJRPaytmDataModel implements IJRDataModel {
    private static final CharSequence RECHARGE_TEXT = "Recharge";
    private static final String SPECIAL_RECHARGE_TEXT = "Special Recharge";
    private static final CharSequence SPECIAL_TEXT = "Special";
    private static final String TAG = "CJRRechargeProductListV2";
    private static final CharSequence TALKTIME_TEXT = "Talktime";
    private static final String TALKTIME_TOPUP_TEXT = "Talktime Topup";
    private static final CharSequence TOPUP_TEXT = "Topup";
    @b(a = "button_obj")
    private CJRButtonPrefetch buttonPrefetch;
    @b(a = "dealsFastforward")
    private boolean dealsFastForward;
    @b(a = "disclaimer_fastforward")
    private String disclaimerFastForward;
    @b(a = "ff_text")
    private String ff_text;
    @b(a = "group_arr")
    private List<List<String>> groupArr;
    @b(a = "grouping")
    private CJRRechargeProductListGroupArrV2 groupingData;
    @b(a = "heading")
    private String heading;
    private int id;
    @b(a = "long_rich_desc")
    private String longRichDesc;
    private HashMap<RechargeProductListKeyV2, List<CJRRechargeProductV2>> mOperatorCircleToProductMap;
    private Map<String, LocalizedOperatorIcon> mOperatorIconMap;
    private HashMap<String, List<CJRRechargeProductV2>> mOperatorToProductMap;
    private Long mServerResponseTime;
    private String mUrlType;
    @b(a = "message")
    private String message;
    @b(a = "meta_description")
    private String metaDescription;
    @b(a = "meta_keyword")
    private String metaKeyword;
    @b(a = "meta_title")
    private String metaTitle;
    private String name;
    @b(a = "product_list")
    private List<CJRRechargeProductV2> productListV2;
    @b(a = "protection_url")
    private String protectionUrl;
    @b(a = "recents_prefill")
    private boolean recentsPrefill;
    @b(a = "showFastforward")
    private boolean showFastForward;
    @b(a = "showHelp")
    private boolean showHelp;
    @b(a = "show_upgrade")
    private boolean showUpgrade;
    @b(a = "storefront_url")
    private String storeFrontUrl;
    @b(a = "top_level_category_header")
    private TopLevelCategoryHeader topLevelCategoryHeader;

    public void setMetaTitle(String str) {
        this.metaTitle = str;
    }

    public String getMetaTitle() {
        return this.metaTitle;
    }

    public void setLongRichDesc(String str) {
        this.longRichDesc = str;
    }

    public String getLongRichDesc() {
        return this.longRichDesc;
    }

    public String getMetaDescription() {
        return this.metaDescription;
    }

    public void setMetaDescription(String str) {
        this.metaDescription = str;
    }

    public String getMetaKeyword() {
        return this.metaKeyword;
    }

    public void setShowFastForward(boolean z) {
        this.showFastForward = z;
    }

    public boolean getShowFastForward() {
        return this.showFastForward;
    }

    public void setDealsFastForward(boolean z) {
        this.dealsFastForward = z;
    }

    public boolean isDealsFastForward() {
        return this.dealsFastForward;
    }

    public String getMessage() {
        return this.message;
    }

    public String getStoreFrontUrl() {
        return this.storeFrontUrl;
    }

    public void setGroupArr(List<List<String>> list) {
        this.groupArr = list;
    }

    public List<List<String>> getGroupArr() {
        return this.groupArr;
    }

    public void setHeading(String str) {
        this.heading = str;
    }

    public String getHeading() {
        return this.heading;
    }

    public void setGroupingData(CJRRechargeProductListGroupArrV2 cJRRechargeProductListGroupArrV2) {
        this.groupingData = cJRRechargeProductListGroupArrV2;
    }

    public CJRRechargeProductListGroupArrV2 getGroupingData() {
        return this.groupingData;
    }

    public CJRButtonPrefetch getButtonPrefetch() {
        return this.buttonPrefetch;
    }

    public void setProductListV2(List<CJRRechargeProductV2> list) {
        this.productListV2 = list;
    }

    public List<CJRRechargeProductV2> getProductListV2() {
        return this.productListV2;
    }

    public String getUrlType() {
        return this.mUrlType;
    }

    public void setUrlType(String str) {
        this.mUrlType = str;
    }

    public Map<RechargeProductListKeyV2, List<CJRRechargeProductV2>> getOperatorCircleToProductMap() {
        return this.mOperatorCircleToProductMap;
    }

    public void setOperatorCircleToProductMap(Map<RechargeProductListKeyV2, List<CJRRechargeProductV2>> map) {
        this.mOperatorCircleToProductMap = new HashMap<>(map);
    }

    public Long getServerResponseTime() {
        return this.mServerResponseTime;
    }

    public void setServerResponseTime(Long l) {
        this.mServerResponseTime = l;
    }

    public Map<String, List<CJRRechargeProductV2>> getOperatorToProductMap() {
        return this.mOperatorToProductMap;
    }

    public void setOperatorToProductMap(HashMap<String, List<CJRRechargeProductV2>> hashMap) {
        this.mOperatorToProductMap = hashMap;
    }

    public String getProtectionUrl() {
        return this.protectionUrl;
    }

    public void setProtectionUrl(String str) {
        this.protectionUrl = str;
    }

    public void setFf_text(String str) {
        this.ff_text = str;
    }

    public String getFf_text() {
        return this.ff_text;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Map<String, LocalizedOperatorIcon> getmOperatorIconMap() {
        return this.mOperatorIconMap;
    }

    public void setmOperatorIconMap(Map<String, LocalizedOperatorIcon> map) {
        this.mOperatorIconMap = map;
    }

    public boolean isShowUpgrade() {
        return this.showUpgrade;
    }

    public void setShowUpgrade(boolean z) {
        this.showUpgrade = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0314, code lost:
        if (java.lang.Integer.parseInt(r4) == 1) goto L_0x0318;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseJsonData(java.lang.String r28) {
        /*
            r27 = this;
            r11 = r27
            java.lang.String r0 = "top_level_category_header"
            java.lang.String r1 = "showFastforward"
            java.lang.String r2 = "heading"
            java.lang.String r3 = "meta_description"
            java.lang.String r4 = "long_rich_desc"
            java.lang.String r5 = "recents_prefill"
            java.lang.String r6 = "meta_title"
            java.lang.String r7 = "name"
            java.lang.String r8 = "id"
            java.lang.String r12 = "display_name"
            java.lang.String r13 = "filter_name"
            java.lang.String r14 = "attributes"
            boolean r9 = android.text.TextUtils.isEmpty(r28)
            if (r9 == 0) goto L_0x0021
            return
        L_0x0021:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0425 }
            r10 = r28
            r9.<init>(r10)     // Catch:{ Exception -> 0x0425 }
            boolean r10 = r9.has(r8)     // Catch:{ Exception -> 0x0425 }
            if (r10 == 0) goto L_0x0035
            int r8 = r9.getInt(r8)     // Catch:{ Exception -> 0x0425 }
            r11.setId(r8)     // Catch:{ Exception -> 0x0425 }
        L_0x0035:
            boolean r8 = r9.has(r7)     // Catch:{ Exception -> 0x0425 }
            if (r8 == 0) goto L_0x0042
            java.lang.String r7 = r9.getString(r7)     // Catch:{ Exception -> 0x0425 }
            r11.setName(r7)     // Catch:{ Exception -> 0x0425 }
        L_0x0042:
            boolean r7 = r9.has(r6)     // Catch:{ Exception -> 0x0425 }
            if (r7 == 0) goto L_0x004f
            java.lang.String r6 = r9.getString(r6)     // Catch:{ Exception -> 0x0425 }
            r11.setMetaTitle(r6)     // Catch:{ Exception -> 0x0425 }
        L_0x004f:
            boolean r6 = r9.has(r5)     // Catch:{ Exception -> 0x0425 }
            if (r6 == 0) goto L_0x005c
            boolean r5 = r9.getBoolean(r5)     // Catch:{ Exception -> 0x0425 }
            r11.setRecentsPrefill(r5)     // Catch:{ Exception -> 0x0425 }
        L_0x005c:
            boolean r5 = r9.has(r4)     // Catch:{ Exception -> 0x0425 }
            if (r5 == 0) goto L_0x0069
            java.lang.String r4 = r9.getString(r4)     // Catch:{ Exception -> 0x0425 }
            r11.setLongRichDesc(r4)     // Catch:{ Exception -> 0x0425 }
        L_0x0069:
            boolean r4 = r9.has(r3)     // Catch:{ Exception -> 0x0425 }
            if (r4 == 0) goto L_0x0076
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x0425 }
            r11.setMetaDescription(r3)     // Catch:{ Exception -> 0x0425 }
        L_0x0076:
            boolean r3 = r9.has(r2)     // Catch:{ Exception -> 0x0425 }
            if (r3 == 0) goto L_0x0083
            java.lang.String r2 = r9.getString(r2)     // Catch:{ Exception -> 0x0425 }
            r11.setHeading(r2)     // Catch:{ Exception -> 0x0425 }
        L_0x0083:
            boolean r2 = r9.has(r1)     // Catch:{ Exception -> 0x0425 }
            if (r2 == 0) goto L_0x0090
            boolean r1 = r9.getBoolean(r1)     // Catch:{ Exception -> 0x0425 }
            r11.setShowFastForward(r1)     // Catch:{ Exception -> 0x0425 }
        L_0x0090:
            boolean r1 = r9.has(r0)     // Catch:{ Exception -> 0x0425 }
            if (r1 == 0) goto L_0x00bd
            org.json.JSONObject r0 = r9.getJSONObject(r0)     // Catch:{ Exception -> 0x0425 }
            net.one97.paytm.recharge.legacy.catalog.model.v2.TopLevelCategoryHeader r1 = new net.one97.paytm.recharge.legacy.catalog.model.v2.TopLevelCategoryHeader     // Catch:{ Exception -> 0x0425 }
            r1.<init>()     // Catch:{ Exception -> 0x0425 }
            java.lang.String r2 = "title"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ Exception -> 0x0425 }
            r1.setTitle(r2)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r2 = "description"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ Exception -> 0x0425 }
            r1.setDescription(r2)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r2 = "deeplink"
            java.lang.String r0 = r0.optString(r2)     // Catch:{ Exception -> 0x0425 }
            r1.setDeeplink(r0)     // Catch:{ Exception -> 0x0425 }
            r11.setTopLevelCategoryHeader(r1)     // Catch:{ Exception -> 0x0425 }
        L_0x00bd:
            java.lang.String r0 = "disclaimer_fastforward"
            boolean r0 = r9.has(r0)     // Catch:{ Exception -> 0x0425 }
            if (r0 == 0) goto L_0x00ce
            java.lang.String r0 = "disclaimer_fastforward"
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x0425 }
            r11.setDisclaimerFastForward(r0)     // Catch:{ Exception -> 0x0425 }
        L_0x00ce:
            java.lang.String r0 = "dealsFastforward"
            boolean r0 = r9.has(r0)     // Catch:{ Exception -> 0x0425 }
            if (r0 == 0) goto L_0x00df
            java.lang.String r0 = "dealsFastforward"
            boolean r0 = r9.getBoolean(r0)     // Catch:{ Exception -> 0x0425 }
            r11.setDealsFastForward(r0)     // Catch:{ Exception -> 0x0425 }
        L_0x00df:
            java.lang.String r0 = "protection_url"
            boolean r0 = r9.has(r0)     // Catch:{ Exception -> 0x0425 }
            if (r0 == 0) goto L_0x00f0
            java.lang.String r0 = "protection_url"
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x0425 }
            r11.setProtectionUrl(r0)     // Catch:{ Exception -> 0x0425 }
        L_0x00f0:
            java.lang.String r0 = "ff_text"
            boolean r0 = r9.has(r0)     // Catch:{ Exception -> 0x0425 }
            if (r0 == 0) goto L_0x0101
            java.lang.String r0 = "ff_text"
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x0425 }
            r11.setFf_text(r0)     // Catch:{ Exception -> 0x0425 }
        L_0x0101:
            java.lang.String r0 = "show_upgrade"
            boolean r0 = r9.has(r0)     // Catch:{ Exception -> 0x0425 }
            if (r0 == 0) goto L_0x0112
            java.lang.String r0 = "show_upgrade"
            boolean r0 = r9.getBoolean(r0)     // Catch:{ Exception -> 0x0425 }
            r11.setShowUpgrade(r0)     // Catch:{ Exception -> 0x0425 }
        L_0x0112:
            java.lang.String r0 = "showHelp"
            boolean r0 = r9.has(r0)     // Catch:{ Exception -> 0x0425 }
            if (r0 == 0) goto L_0x0123
            java.lang.String r0 = "showHelp"
            boolean r0 = r9.getBoolean(r0)     // Catch:{ Exception -> 0x0425 }
            r11.setShowHelp(r0)     // Catch:{ Exception -> 0x0425 }
        L_0x0123:
            java.lang.String r0 = "group_arr"
            boolean r0 = r9.has(r0)     // Catch:{ Exception -> 0x0425 }
            r15 = 0
            if (r0 == 0) goto L_0x0161
            java.lang.String r0 = "group_arr"
            org.json.JSONArray r0 = r9.getJSONArray(r0)     // Catch:{ Exception -> 0x0425 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0425 }
            r1.<init>()     // Catch:{ Exception -> 0x0425 }
            r2 = 0
        L_0x0138:
            int r3 = r0.length()     // Catch:{ Exception -> 0x0425 }
            if (r2 >= r3) goto L_0x015e
            org.json.JSONArray r3 = r0.getJSONArray(r2)     // Catch:{ Exception -> 0x0425 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0425 }
            r4.<init>()     // Catch:{ Exception -> 0x0425 }
            r5 = 0
        L_0x0148:
            int r6 = r3.length()     // Catch:{ Exception -> 0x0425 }
            if (r5 >= r6) goto L_0x0158
            java.lang.String r6 = r3.getString(r5)     // Catch:{ Exception -> 0x0425 }
            r4.add(r6)     // Catch:{ Exception -> 0x0425 }
            int r5 = r5 + 1
            goto L_0x0148
        L_0x0158:
            r1.add(r4)     // Catch:{ Exception -> 0x0425 }
            int r2 = r2 + 1
            goto L_0x0138
        L_0x015e:
            r11.setGroupArr(r1)     // Catch:{ Exception -> 0x0425 }
        L_0x0161:
            java.lang.String r0 = "button_obj"
            boolean r0 = r9.has(r0)     // Catch:{ Exception -> 0x0425 }
            if (r0 == 0) goto L_0x01eb
            java.lang.String r0 = "button_obj"
            org.json.JSONObject r0 = r9.getJSONObject(r0)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r1 = "prefetch"
            boolean r1 = r0.has(r1)     // Catch:{ Exception -> 0x0425 }
            if (r1 == 0) goto L_0x01eb
            java.lang.String r1 = "prefetch"
            org.json.JSONObject r0 = r0.getJSONObject(r1)     // Catch:{ Exception -> 0x0425 }
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRButtonPrefetch r1 = new net.one97.paytm.recharge.legacy.catalog.model.v2.CJRButtonPrefetch     // Catch:{ Exception -> 0x0425 }
            r1.<init>()     // Catch:{ Exception -> 0x0425 }
            r11.buttonPrefetch = r1     // Catch:{ Exception -> 0x0425 }
            java.lang.String r1 = "0"
            boolean r1 = r0.has(r1)     // Catch:{ Exception -> 0x0425 }
            if (r1 == 0) goto L_0x01b8
            java.lang.String r1 = "0"
            org.json.JSONObject r0 = r0.getJSONObject(r1)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r1 = "pre"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r2 = "processing"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r3 = "post"
            java.lang.String r0 = r0.optString(r3)     // Catch:{ Exception -> 0x0425 }
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRPrefetchObj r3 = new net.one97.paytm.recharge.legacy.catalog.model.v2.CJRPrefetchObj     // Catch:{ Exception -> 0x0425 }
            r3.<init>()     // Catch:{ Exception -> 0x0425 }
            r3.setPreText(r1)     // Catch:{ Exception -> 0x0425 }
            r3.setProcessingText(r2)     // Catch:{ Exception -> 0x0425 }
            r3.setPostText(r0)     // Catch:{ Exception -> 0x0425 }
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRButtonPrefetch r0 = r11.buttonPrefetch     // Catch:{ Exception -> 0x0425 }
            r0.setPrefetchObjZero(r3)     // Catch:{ Exception -> 0x0425 }
            goto L_0x01eb
        L_0x01b8:
            java.lang.String r1 = "1"
            boolean r1 = r0.has(r1)     // Catch:{ Exception -> 0x0425 }
            if (r1 == 0) goto L_0x01eb
            java.lang.String r1 = "1"
            org.json.JSONObject r0 = r0.getJSONObject(r1)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r1 = "pre"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r2 = "processing"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r3 = "post"
            java.lang.String r0 = r0.optString(r3)     // Catch:{ Exception -> 0x0425 }
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRPrefetchObj r3 = new net.one97.paytm.recharge.legacy.catalog.model.v2.CJRPrefetchObj     // Catch:{ Exception -> 0x0425 }
            r3.<init>()     // Catch:{ Exception -> 0x0425 }
            r3.setPreText(r1)     // Catch:{ Exception -> 0x0425 }
            r3.setProcessingText(r2)     // Catch:{ Exception -> 0x0425 }
            r3.setPostText(r0)     // Catch:{ Exception -> 0x0425 }
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRButtonPrefetch r0 = r11.buttonPrefetch     // Catch:{ Exception -> 0x0425 }
            r0.setPrefetchObjOne(r3)     // Catch:{ Exception -> 0x0425 }
        L_0x01eb:
            java.lang.String r0 = "grouping"
            boolean r0 = r9.has(r0)     // Catch:{ Exception -> 0x0425 }
            if (r0 == 0) goto L_0x0288
            java.lang.String r0 = "grouping"
            org.json.JSONObject r0 = r9.getJSONObject(r0)     // Catch:{ Exception -> 0x0425 }
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrV2 r1 = new net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrV2     // Catch:{ Exception -> 0x0425 }
            r1.<init>()     // Catch:{ Exception -> 0x0425 }
            r11.groupingData = r1     // Catch:{ Exception -> 0x0425 }
            java.util.List<java.util.List<java.lang.String>> r1 = r11.groupArr     // Catch:{ Exception -> 0x0425 }
            if (r1 == 0) goto L_0x0288
            java.util.List<java.util.List<java.lang.String>> r1 = r11.groupArr     // Catch:{ Exception -> 0x0425 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0425 }
            if (r1 <= 0) goto L_0x0288
            java.util.List<java.util.List<java.lang.String>> r1 = r11.groupArr     // Catch:{ Exception -> 0x0425 }
            java.lang.Object r1 = r1.get(r15)     // Catch:{ Exception -> 0x0425 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x0425 }
            if (r1 == 0) goto L_0x0288
            int r2 = r1.size()     // Catch:{ Exception -> 0x0425 }
            if (r2 <= 0) goto L_0x0288
            r2 = 0
        L_0x021d:
            int r3 = r1.size()     // Catch:{ Exception -> 0x0425 }
            if (r2 >= r3) goto L_0x0288
            java.lang.Object r3 = r1.get(r2)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0425 }
            boolean r4 = r0.has(r3)     // Catch:{ Exception -> 0x0425 }
            if (r4 == 0) goto L_0x0285
            org.json.JSONObject r4 = r0.getJSONObject(r3)     // Catch:{ Exception -> 0x0425 }
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrItemV2 r5 = new net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrItemV2     // Catch:{ Exception -> 0x0425 }
            r5.<init>()     // Catch:{ Exception -> 0x0425 }
            java.lang.String r6 = "key"
            java.lang.String r6 = r4.optString(r6)     // Catch:{ Exception -> 0x0425 }
            r5.setKey(r6)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r6 = "brandImage"
            boolean r6 = r4.optBoolean(r6)     // Catch:{ Exception -> 0x0425 }
            r5.setBrandImage(r6)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r6 = "label"
            java.lang.String r6 = r4.optString(r6)     // Catch:{ Exception -> 0x0425 }
            r5.setLabel(r6)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r6 = "type"
            java.lang.String r4 = r4.optString(r6)     // Catch:{ Exception -> 0x0425 }
            r5.setType(r4)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r4 = "operator"
            boolean r4 = r3.contains(r4)     // Catch:{ Exception -> 0x0425 }
            if (r4 == 0) goto L_0x026a
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrV2 r3 = r11.groupingData     // Catch:{ Exception -> 0x0425 }
            r3.setOperatorItem(r5)     // Catch:{ Exception -> 0x0425 }
            goto L_0x0285
        L_0x026a:
            java.lang.String r4 = "circle"
            boolean r4 = r3.contains(r4)     // Catch:{ Exception -> 0x0425 }
            if (r4 == 0) goto L_0x0278
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrV2 r3 = r11.groupingData     // Catch:{ Exception -> 0x0425 }
            r3.setCircleItem(r5)     // Catch:{ Exception -> 0x0425 }
            goto L_0x0285
        L_0x0278:
            java.lang.String r4 = "product"
            boolean r3 = r3.contains(r4)     // Catch:{ Exception -> 0x0425 }
            if (r3 == 0) goto L_0x0285
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrV2 r3 = r11.groupingData     // Catch:{ Exception -> 0x0425 }
            r3.setProductTypeItem(r5)     // Catch:{ Exception -> 0x0425 }
        L_0x0285:
            int r2 = r2 + 1
            goto L_0x021d
        L_0x0288:
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrV2 r0 = r11.groupingData     // Catch:{ Exception -> 0x0425 }
            if (r0 == 0) goto L_0x0424
            java.lang.String r0 = "product_list"
            boolean r0 = r9.has(r0)     // Catch:{ Exception -> 0x0425 }
            if (r0 == 0) goto L_0x0424
            java.lang.String r0 = "product_list"
            org.json.JSONArray r0 = r9.getJSONArray(r0)     // Catch:{ Exception -> 0x0425 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0425 }
            r1.<init>()     // Catch:{ Exception -> 0x0425 }
            r11.productListV2 = r1     // Catch:{ Exception -> 0x0425 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0425 }
            r1.<init>()     // Catch:{ Exception -> 0x0425 }
            r11.mOperatorCircleToProductMap = r1     // Catch:{ Exception -> 0x0425 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0425 }
            r1.<init>()     // Catch:{ Exception -> 0x0425 }
            r11.mOperatorToProductMap = r1     // Catch:{ Exception -> 0x0425 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0425 }
            r1.<init>()     // Catch:{ Exception -> 0x0425 }
            r11.mOperatorIconMap = r1     // Catch:{ Exception -> 0x0425 }
            r10 = 0
        L_0x02b7:
            int r1 = r0.length()     // Catch:{ Exception -> 0x0425 }
            if (r10 >= r1) goto L_0x0424
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrV2 r1 = r11.groupingData     // Catch:{ Exception -> 0x0425 }
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrItemV2 r1 = r1.getOperatorItem()     // Catch:{ Exception -> 0x0425 }
            if (r1 == 0) goto L_0x041e
            org.json.JSONObject r8 = r0.getJSONObject(r10)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r9 = r8.optString(r13)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r7 = r8.optString(r12)     // Catch:{ Exception -> 0x0425 }
            boolean r1 = r8.has(r14)     // Catch:{ Exception -> 0x0425 }
            r2 = 0
            if (r1 == 0) goto L_0x0327
            org.json.JSONObject r1 = r8.optJSONObject(r14)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r3 = "image"
            boolean r1 = r1.isNull(r3)     // Catch:{ Exception -> 0x0425 }
            if (r1 != 0) goto L_0x02ef
            org.json.JSONObject r1 = r8.optJSONObject(r14)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r2 = "image"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ Exception -> 0x0425 }
            r2 = r1
        L_0x02ef:
            org.json.JSONObject r1 = r8.optJSONObject(r14)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r3 = "regEx"
            java.lang.String r1 = r1.optString(r3)     // Catch:{ Exception -> 0x0425 }
            org.json.JSONObject r3 = r8.optJSONObject(r14)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r4 = "min_android_version"
            java.lang.String r3 = r3.optString(r4)     // Catch:{ Exception -> 0x0425 }
            org.json.JSONObject r4 = r8.optJSONObject(r14)     // Catch:{ Exception -> 0x031d }
            java.lang.String r5 = "schedulable"
            java.lang.String r4 = r4.optString(r5)     // Catch:{ Exception -> 0x031d }
            if (r4 == 0) goto L_0x0317
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x031d }
            r5 = 1
            if (r4 != r5) goto L_0x0317
            goto L_0x0318
        L_0x0317:
            r5 = 0
        L_0x0318:
            r16 = r1
            r17 = r3
            goto L_0x032c
        L_0x031d:
            java.lang.String r4 = "problem in parsing scedulable flag"
            com.paytm.utility.q.c(r4)     // Catch:{ Exception -> 0x0425 }
            r16 = r1
            r17 = r3
            goto L_0x032b
        L_0x0327:
            r16 = r2
            r17 = r16
        L_0x032b:
            r5 = 0
        L_0x032c:
            net.one97.paytm.recharge.legacy.catalog.model.v2.LocalizedOperatorIcon r1 = new net.one97.paytm.recharge.legacy.catalog.model.v2.LocalizedOperatorIcon     // Catch:{ Exception -> 0x0425 }
            r1.<init>()     // Catch:{ Exception -> 0x0425 }
            r1.setOperatorDisplayName(r7)     // Catch:{ Exception -> 0x0425 }
            r1.setOperatorIconUrl(r2)     // Catch:{ Exception -> 0x0425 }
            r1.setSchedulable(r5)     // Catch:{ Exception -> 0x0425 }
            java.util.Map<java.lang.String, net.one97.paytm.recharge.legacy.catalog.model.v2.LocalizedOperatorIcon> r2 = r11.mOperatorIconMap     // Catch:{ Exception -> 0x0425 }
            r2.put(r9, r1)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r1 = "variants"
            org.json.JSONArray r6 = r8.optJSONArray(r1)     // Catch:{ Exception -> 0x0425 }
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrV2 r1 = r11.groupingData     // Catch:{ Exception -> 0x0425 }
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrItemV2 r1 = r1.getCircleItem()     // Catch:{ Exception -> 0x0425 }
            if (r1 == 0) goto L_0x03fe
            if (r6 == 0) goto L_0x03fe
            r8 = 0
        L_0x0350:
            int r1 = r6.length()     // Catch:{ Exception -> 0x0425 }
            if (r8 >= r1) goto L_0x041e
            org.json.JSONObject r5 = r6.getJSONObject(r8)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r18 = r5.optString(r13)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r19 = r5.optString(r12)     // Catch:{ Exception -> 0x0425 }
            org.json.JSONObject r1 = r5.optJSONObject(r14)     // Catch:{ Exception -> 0x0425 }
            if (r1 == 0) goto L_0x0374
            org.json.JSONObject r1 = r5.optJSONObject(r14)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r2 = "min_android_version"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ Exception -> 0x0425 }
            r17 = r1
        L_0x0374:
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrV2 r1 = r11.groupingData     // Catch:{ Exception -> 0x0425 }
            net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListGroupArrItemV2 r1 = r1.getProductType()     // Catch:{ Exception -> 0x0425 }
            if (r1 == 0) goto L_0x03d4
            java.lang.String r1 = "variants"
            org.json.JSONArray r5 = r5.getJSONArray(r1)     // Catch:{ Exception -> 0x0425 }
            r4 = 0
        L_0x0383:
            int r1 = r5.length()     // Catch:{ Exception -> 0x0425 }
            if (r4 >= r1) goto L_0x03c9
            org.json.JSONObject r3 = r5.getJSONObject(r4)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r20 = r3.optString(r13)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r21 = r3.optString(r12)     // Catch:{ Exception -> 0x0425 }
            r1 = r27
            r2 = r9
            r22 = r3
            r3 = r7
            r23 = r4
            r4 = r18
            r24 = r5
            r5 = r19
            r25 = r6
            r6 = r20
            r20 = r7
            r7 = r21
            r21 = r8
            r8 = r22
            r22 = r9
            r9 = r16
            r26 = r10
            r10 = r17
            r1.populateProductsFromJson(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0425 }
            int r4 = r23 + 1
            r7 = r20
            r8 = r21
            r9 = r22
            r5 = r24
            r6 = r25
            r10 = r26
            goto L_0x0383
        L_0x03c9:
            r25 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r26 = r10
            goto L_0x03f2
        L_0x03d4:
            r25 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r26 = r10
            r6 = 0
            r7 = 0
            r1 = r27
            r2 = r22
            r3 = r20
            r4 = r18
            r8 = r5
            r5 = r19
            r9 = r16
            r10 = r17
            r1.populateProductsFromJson(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0425 }
        L_0x03f2:
            int r8 = r21 + 1
            r7 = r20
            r9 = r22
            r6 = r25
            r10 = r26
            goto L_0x0350
        L_0x03fe:
            r20 = r7
            r22 = r9
            r26 = r10
            java.lang.String r1 = "products"
            boolean r1 = r8.has(r1)     // Catch:{ Exception -> 0x0425 }
            if (r1 == 0) goto L_0x0420
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r1 = r27
            r2 = r22
            r3 = r20
            r9 = r16
            r10 = r17
            r1.populateProductsFromJson(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0425 }
            goto L_0x0420
        L_0x041e:
            r26 = r10
        L_0x0420:
            int r10 = r26 + 1
            goto L_0x02b7
        L_0x0424:
            return
        L_0x0425:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.model.v2.CJRRechargeProductListV2.parseJsonData(java.lang.String):void");
    }

    private CJRRechargeProductV2 populateProductsFromJson(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject, String str7, String str8) throws JSONException {
        List list;
        List list2;
        String str9 = str;
        String str10 = str3;
        String str11 = str5;
        JSONObject jSONObject2 = jSONObject.getJSONObject("products");
        CJRRechargeProductV2 cJRRechargeProductV2 = new CJRRechargeProductV2();
        int optInt = jSONObject2.optInt("id");
        if (optInt != 0) {
            cJRRechargeProductV2.setProductId(String.valueOf(optInt));
        }
        if (jSONObject2.has(CLPConstants.ATTRIBUTE)) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject(CLPConstants.ATTRIBUTE);
            CJRRechargeProductAttributesV2 cJRRechargeProductAttributesV2 = new CJRRechargeProductAttributesV2();
            cJRRechargeProductAttributesV2.setRechargeTypeDisplayName(str6);
            cJRRechargeProductAttributesV2.setRechargeTypeFilterName(str11);
            if (!TextUtils.isEmpty(str5)) {
                if (str11.equalsIgnoreCase(TALKTIME_TOPUP_TEXT) || str11.contains(TALKTIME_TEXT) || str11.contains(TOPUP_TEXT)) {
                    cJRRechargeProductAttributesV2.setTalktimeTopup(true);
                } else if (str11.equalsIgnoreCase(SPECIAL_RECHARGE_TEXT) || str11.contains(SPECIAL_TEXT) || str11.contains(RECHARGE_TEXT)) {
                    cJRRechargeProductAttributesV2.setSpecialRecharge(true);
                }
            }
            String optString = jSONObject3.optString("prefetch");
            if (!TextUtils.isEmpty(optString)) {
                cJRRechargeProductAttributesV2.setPrefetch(optString);
            }
            String optString2 = jSONObject3.optString("post_order_view_type");
            if (!TextUtils.isEmpty(optString2)) {
                cJRRechargeProductAttributesV2.setPostOrderViewType(optString2);
            }
            if (jSONObject3.has("voda_fetchbill")) {
                cJRRechargeProductAttributesV2.setVodaFetchbill(jSONObject3.getString("voda_fetchbill"));
            }
            if (jSONObject3.has("One2One_offer")) {
                cJRRechargeProductAttributesV2.setOne2OneOfferEnabled(jSONObject3.getString("One2One_offer"));
            }
            if (jSONObject3.has("dynamic_plan_category_label")) {
                cJRRechargeProductAttributesV2.setDynamicPlanCategoryLabel(jSONObject3.getString("dynamic_plan_category_label"));
            }
            if (jSONObject3.has("One2One_offer_text")) {
                cJRRechargeProductAttributesV2.setOne2OneOfferText(jSONObject3.getString("One2One_offer_text"));
            }
            if (jSONObject3.has("One2One_offer_disclaimer")) {
                cJRRechargeProductAttributesV2.setOne2OneOfferDisclaimer(jSONObject3.getString("One2One_offer_disclaimer"));
            }
            if (jSONObject3.has("service")) {
                cJRRechargeProductAttributesV2.setService(jSONObject3.getString("service"));
            }
            if (jSONObject3.has("paytype")) {
                cJRRechargeProductAttributesV2.setPaytype(jSONObject3.getString("paytype"));
            }
            if (jSONObject3.has("dynamic_plan")) {
                cJRRechargeProductAttributesV2.setIsDynamicPlan(jSONObject3.getInt("dynamic_plan"));
            }
            if (jSONObject3.has("remindable")) {
                cJRRechargeProductAttributesV2.setRemindable(jSONObject3.getString("remindable"));
            }
            if (jSONObject3.has("operator_alert")) {
                cJRRechargeProductAttributesV2.setIsOperatorAlert(jSONObject3.getString("operator_alert"));
            }
            String optString3 = jSONObject3.optString("fetch_amount");
            if (!TextUtils.isEmpty(optString3)) {
                cJRRechargeProductAttributesV2.setFetch_amount(optString3);
            }
            String optString4 = jSONObject3.optString("deals_message");
            if (!TextUtils.isEmpty(optString4)) {
                cJRRechargeProductAttributesV2.setDealsMessage(optString4);
            }
            String optString5 = jSONObject3.optString("schedulable");
            if (!TextUtils.isEmpty(optString5)) {
                cJRRechargeProductAttributesV2.setSchedulable(optString5);
            }
            JSONObject optJSONObject = jSONObject3.optJSONObject("error");
            if (optJSONObject != null) {
                CJRRechargeProductAttributesErrorV2 cJRRechargeProductAttributesErrorV2 = new CJRRechargeProductAttributesErrorV2();
                cJRRechargeProductAttributesErrorV2.setTitle(optJSONObject.optString("title"));
                cJRRechargeProductAttributesErrorV2.setProceed(optJSONObject.optInt("proceed"));
                cJRRechargeProductAttributesErrorV2.setMessage(optJSONObject.optString("message"));
                cJRRechargeProductAttributesErrorV2.setOkButton(optJSONObject.optString("okbutton"));
                cJRRechargeProductAttributesErrorV2.setCancelButton(optJSONObject.optString("cancelButton"));
                cJRRechargeProductAttributesV2.setErrorV2(cJRRechargeProductAttributesErrorV2);
            }
            JSONObject optJSONObject2 = jSONObject3.optJSONObject(H5Plugin.CommonEvents.ALERT);
            if (optJSONObject2 != null) {
                CJRRechargeProductAttributesAlertV2 cJRRechargeProductAttributesAlertV2 = new CJRRechargeProductAttributesAlertV2();
                cJRRechargeProductAttributesAlertV2.setTitle(optJSONObject2.optString("title"));
                cJRRechargeProductAttributesAlertV2.setHeading(optJSONObject2.optString("heading"));
                cJRRechargeProductAttributesAlertV2.setMessage(optJSONObject2.optString("message"));
                cJRRechargeProductAttributesAlertV2.setOkButton(optJSONObject2.optString("okbutton"));
                cJRRechargeProductAttributesAlertV2.setCancelButton(optJSONObject2.optString("cancelButton"));
                cJRRechargeProductAttributesAlertV2.setCheckBoxText(optJSONObject2.optString("checkbox_text"));
                JSONArray optJSONArray = jSONObject3.optJSONArray("rich_message");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        ((CJRRichMessage) arrayList.get(i2)).setImage(optJSONObject2.optString(H5ResourceHandlerUtil.IMAGE));
                        ((CJRRichMessage) arrayList.get(i2)).setText(optJSONObject2.optString(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX));
                        ((CJRRichMessage) arrayList.get(i2)).setSub_heading(optJSONObject2.optString("subheading"));
                    }
                    cJRRechargeProductAttributesAlertV2.setRichMessage(arrayList);
                }
                cJRRechargeProductAttributesV2.setAlertV2(cJRRechargeProductAttributesAlertV2);
            }
            cJRRechargeProductAttributesV2.setCircleFilter(str10);
            cJRRechargeProductAttributesV2.setCircleDisplay(str4);
            cJRRechargeProductAttributesV2.setOperatorFilter(str9);
            cJRRechargeProductAttributesV2.setOperatorDisplay(str2);
            if (!TextUtils.isEmpty(str7)) {
                cJRRechargeProductAttributesV2.setRegEx(str7);
            }
            if (!TextUtils.isEmpty(str8)) {
                cJRRechargeProductAttributesV2.setMinAndroidVersion(str8);
            }
            cJRRechargeProductV2.setRechargeProductAttributesV2(cJRRechargeProductAttributesV2);
        }
        if (jSONObject2.has("input_fields")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("input_fields");
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                CJRRechargeInputFieldsTypeV2 cJRRechargeInputFieldsTypeV2 = new CJRRechargeInputFieldsTypeV2();
                JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
                if (jSONObject4.has("config_key")) {
                    cJRRechargeInputFieldsTypeV2.setConfigKey(jSONObject4.getString("config_key"));
                }
                if (jSONObject4.has("title")) {
                    cJRRechargeInputFieldsTypeV2.setTitle(jSONObject4.getString("title"));
                }
                if (jSONObject4.has("regex")) {
                    String string = jSONObject4.getString("regex");
                    cJRRechargeInputFieldsTypeV2.setRegex(string);
                    if (cJRRechargeProductV2.getRechargeProductAttributesV2() != null && TextUtils.isEmpty(cJRRechargeProductV2.getRechargeProductAttributesV2().getRegEx())) {
                        cJRRechargeProductV2.getRechargeProductAttributesV2().setRegEx(string);
                    }
                }
                if (jSONObject4.has("type")) {
                    cJRRechargeInputFieldsTypeV2.setType(jSONObject4.getString("type"));
                }
                if (jSONObject4.has("mandatory")) {
                    cJRRechargeInputFieldsTypeV2.setMandatory(jSONObject4.getBoolean("mandatory"));
                }
                if (jSONObject4.has("min")) {
                    String string2 = jSONObject4.getString("min");
                    cJRRechargeInputFieldsTypeV2.setMin(string2);
                    if (cJRRechargeProductV2.getRechargeProductAttributesV2() != null && TextUtils.isEmpty(cJRRechargeProductV2.getRechargeProductAttributesV2().getMin_amount())) {
                        cJRRechargeProductV2.getRechargeProductAttributesV2().setMin_amount(String.valueOf(string2));
                    }
                }
                if (jSONObject4.has("max")) {
                    String string3 = jSONObject4.getString("max");
                    cJRRechargeInputFieldsTypeV2.setMax(string3);
                    if (cJRRechargeProductV2.getRechargeProductAttributesV2() != null && TextUtils.isEmpty(cJRRechargeProductV2.getRechargeProductAttributesV2().getMax_amount())) {
                        cJRRechargeProductV2.getRechargeProductAttributesV2().setMax_amount(String.valueOf(string3));
                    }
                }
                if (jSONObject4.has("message")) {
                    cJRRechargeInputFieldsTypeV2.setMessage(jSONObject4.getString("message"));
                }
                arrayList2.add(cJRRechargeInputFieldsTypeV2);
            }
            cJRRechargeProductV2.setInputFieldsTypeV2List(arrayList2);
        }
        this.productListV2.add(cJRRechargeProductV2);
        if (!TextUtils.isEmpty(str)) {
            RechargeProductListKeyV2 rechargeProductListKeyV2 = new RechargeProductListKeyV2(str9, str10);
            if (!TextUtils.isEmpty(str3)) {
                if (this.mOperatorCircleToProductMap.containsKey(rechargeProductListKeyV2)) {
                    list2 = this.mOperatorCircleToProductMap.get(rechargeProductListKeyV2);
                } else {
                    list2 = new ArrayList();
                    this.mOperatorCircleToProductMap.put(rechargeProductListKeyV2, list2);
                }
                list2.add(cJRRechargeProductV2);
            }
            if (this.mOperatorToProductMap.containsKey(str9)) {
                list = this.mOperatorToProductMap.get(str9);
            } else {
                ArrayList arrayList3 = new ArrayList();
                this.mOperatorToProductMap.put(str9, arrayList3);
                list = arrayList3;
            }
            list.add(cJRRechargeProductV2);
        }
        return cJRRechargeProductV2;
    }

    public String getDisclaimerFastForward() {
        return this.disclaimerFastForward;
    }

    public void setDisclaimerFastForward(String str) {
        this.disclaimerFastForward = str;
    }

    public boolean isRecentsPrefill() {
        return this.recentsPrefill;
    }

    public void setRecentsPrefill(boolean z) {
        this.recentsPrefill = z;
    }

    public TopLevelCategoryHeader getTopLevelCategoryHeader() {
        return this.topLevelCategoryHeader;
    }

    public void setTopLevelCategoryHeader(TopLevelCategoryHeader topLevelCategoryHeader2) {
        this.topLevelCategoryHeader = topLevelCategoryHeader2;
    }

    public boolean isShowHelp() {
        return this.showHelp;
    }

    public void setShowHelp(boolean z) {
        this.showHelp = z;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRRechargeProductListV2 cJRRechargeProductListV2 = new CJRRechargeProductListV2();
        cJRRechargeProductListV2.parseJsonData(str);
        cJRRechargeProductListV2.setUrlType(getUrlType());
        cJRRechargeProductListV2.setServerResponseTime(Long.valueOf(new Date().getTime()));
        return cJRRechargeProductListV2;
    }
}

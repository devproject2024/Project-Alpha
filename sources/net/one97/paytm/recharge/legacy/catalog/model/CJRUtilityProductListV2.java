package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.recharge.legacy.catalog.model.v2.TopLevelCategoryHeader;
import net.one97.paytm.recharge.model.rechargeutility.CJRUtilityBottomTabData;

public class CJRUtilityProductListV2 extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "bottom_strip_utility")
    private List<CJRUtilityBottomTabData> bottomTabDataList = new ArrayList();
    @b(a = "button_obj")
    private CJRUtilityButtonObjectV2 buttonObj;
    @b(a = "canonical_url")
    private String canonicalUrl;
    @b(a = "dealsFastforward")
    private boolean dealsFastforward;
    @b(a = "disclaimer")
    private String disclaimer;
    @b(a = "disclaimer_html")
    private String disclaimer_html;
    @b(a = "extra_description")
    private Object extraDescription;
    @b(a = "ff_text")
    private String ffText;
    @b(a = "ga_key")
    private String gaKey;
    @b(a = "grouping")
    private Map<String, CJRUtilityGroupFieldV2> groupFieldMap;
    private int groupLevel = 1;
    @b(a = "group_arr")
    private List<List<String>> grouping = new ArrayList();
    @b(a = "heading")
    private String heading;
    @b(a = "id")
    private int id;
    private boolean isCached = false;
    private boolean isConvertedToFilterResponse;
    @b(a = "long_rich_desc")
    private String longRichDesc;
    @b(a = "message")
    private String message;
    @b(a = "meta_description")
    private String metaDescription;
    @b(a = "meta_keyword")
    private String metaKeyword;
    @b(a = "meta_title")
    private String metaTitle;
    @b(a = "name")
    private String name;
    private CJRUtilityProductListV2 nextLevelProductList;
    @b(a = "protection_url")
    private String protectionUrl;
    @b(a = "rc")
    private List<CJRUtilityRcV2> rc = null;
    @b(a = "recents_prefill")
    private boolean recentsPrefill;
    private Map<Integer, CJRUtilitySelectedGroupItemV2> selectedGroupItemHashMap = new HashMap();
    @b(a = "showFastforward")
    private boolean showFastforward;
    @b(a = "showHelp")
    private boolean showHelp;
    @b(a = "show_upgrade")
    private boolean showUpgrade;
    @b(a = "storefront_url")
    private Object storefrontUrl;
    @b(a = "top_level_category_header")
    private TopLevelCategoryHeader topLevelCategoryHeader;
    @b(a = "url")
    private String url;
    @b(a = "product_list")
    private List<CJRUtilityVariantV2> variantList = new ArrayList();

    public boolean isCached() {
        return this.isCached;
    }

    public void setIsCached(boolean z) {
        this.isCached = z;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getMetaTitle() {
        return this.metaTitle;
    }

    public void setMetaTitle(String str) {
        this.metaTitle = str;
    }

    public String getLongRichDesc() {
        return this.longRichDesc;
    }

    public void setLongRichDesc(String str) {
        this.longRichDesc = str;
    }

    public Object getExtraDescription() {
        return this.extraDescription;
    }

    public void setExtraDescription(Object obj) {
        this.extraDescription = obj;
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

    public void setMetaKeyword(String str) {
        this.metaKeyword = str;
    }

    public String getHeading() {
        return this.heading;
    }

    public void setHeading(String str) {
        this.heading = str;
    }

    public Boolean getShowFastforward() {
        return Boolean.valueOf(this.showFastforward);
    }

    public void setShowFastforward(Boolean bool) {
        this.showFastforward = bool.booleanValue();
    }

    public boolean isDealsFastforward() {
        return this.dealsFastforward;
    }

    public void setDealsFastforward(boolean z) {
        this.dealsFastforward = z;
    }

    public String getFfText() {
        return this.ffText;
    }

    public void setFfText(String str) {
        this.ffText = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getDisclaimer() {
        return this.disclaimer;
    }

    public void setDisclaimer(String str) {
        this.disclaimer = str;
    }

    public CJRUtilityButtonObjectV2 getButtonObj() {
        return this.buttonObj;
    }

    public void setButtonObj(CJRUtilityButtonObjectV2 cJRUtilityButtonObjectV2) {
        this.buttonObj = cJRUtilityButtonObjectV2;
    }

    public String getGAEventScreenName() {
        return "/" + this.gaKey;
    }

    public String getGaKey() {
        return this.gaKey;
    }

    public void setGaKey(String str) {
        this.gaKey = str;
    }

    public String getCanonicalUrl() {
        return this.canonicalUrl;
    }

    public void setCanonicalUrl(String str) {
        this.canonicalUrl = str;
    }

    public Object getStorefrontUrl() {
        return this.storefrontUrl;
    }

    public void setStorefrontUrl(Object obj) {
        this.storefrontUrl = obj;
    }

    public Map<String, CJRUtilityGroupFieldV2> getGroupFieldMap() {
        return this.groupFieldMap;
    }

    public void setGroupFieldMap(Map<String, CJRUtilityGroupFieldV2> map) {
        this.groupFieldMap = map;
    }

    public List<List<String>> getGrouping() {
        return this.grouping;
    }

    public void setGrouping(List<List<String>> list) {
        this.grouping = list;
    }

    public List<CJRUtilityVariantV2> getVariantList() {
        return this.variantList;
    }

    public void setVariantList(List<CJRUtilityVariantV2> list) {
        this.variantList = list;
    }

    public CJRUtilityGroupFieldV2 getGroupFieldV2(int i2) {
        List<List<String>> list = this.grouping;
        if (list != null) {
            int size = list.size();
            int i3 = this.groupLevel;
            if (size > i3 - 1 && this.grouping.get(i3 - 1) != null && i2 < this.grouping.get(this.groupLevel - 1).size() && this.groupFieldMap.get(this.grouping.get(this.groupLevel - 1).get(i2)) != null) {
                return this.groupFieldMap.get(this.grouping.get(this.groupLevel - 1).get(i2));
            }
        }
        return null;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public List<CJRUtilityRcV2> getRc() {
        return this.rc;
    }

    public void setRc(List<CJRUtilityRcV2> list) {
        this.rc = list;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getGroupKeyWithTypeCheckbox() {
        for (int i2 = 0; i2 < this.grouping.size(); i2++) {
            if (!(this.grouping.get(i2) == null || this.groupFieldMap.get(this.grouping.get(i2).get(0)) == null)) {
                for (int i3 = 0; i3 < this.grouping.get(i2).size(); i3++) {
                    if ("checkbox".equalsIgnoreCase(this.groupFieldMap.get(this.grouping.get(i2).get(i3)).getType())) {
                        return this.groupFieldMap.get(this.grouping.get(i2).get(i3)).getKey();
                    }
                }
                continue;
            }
        }
        return null;
    }

    public boolean isShowUpgrade() {
        return this.showUpgrade;
    }

    public void setShowUpgrade(boolean z) {
        this.showUpgrade = z;
    }

    public String getProtectionUrl() {
        return this.protectionUrl;
    }

    public void setProtectionUrl(String str) {
        this.protectionUrl = str;
    }

    public boolean isRecentsPrefill() {
        return this.recentsPrefill;
    }

    public void setRecentsPrefill(boolean z) {
        this.recentsPrefill = z;
    }

    public boolean isConvertedToFilterResponse() {
        return this.isConvertedToFilterResponse;
    }

    public void setConvertedToFilterResponse(boolean z) {
        this.isConvertedToFilterResponse = z;
    }

    public TopLevelCategoryHeader getTopLevelCategoryHeader() {
        return this.topLevelCategoryHeader;
    }

    public void setTopLevelCategoryHeader(TopLevelCategoryHeader topLevelCategoryHeader2) {
        this.topLevelCategoryHeader = topLevelCategoryHeader2;
    }

    public String getDisclaimer_html() {
        return this.disclaimer_html;
    }

    public void setDisclaimer_html(String str) {
        this.disclaimer_html = str;
    }

    public boolean isShowHelp() {
        return this.showHelp;
    }

    public void setShowHelp(boolean z) {
        this.showHelp = z;
    }

    public CJRUtilityProductListV2 getNextLevelProductList() {
        return this.nextLevelProductList;
    }

    public void setNextLevelProductList(CJRUtilityProductListV2 cJRUtilityProductListV2) {
        this.nextLevelProductList = cJRUtilityProductListV2;
        CJRUtilityProductListV2 cJRUtilityProductListV22 = this.nextLevelProductList;
        if (cJRUtilityProductListV22 != null) {
            cJRUtilityProductListV22.setGroupLevel(this.groupLevel + 1);
        }
    }

    public CJRUtilityProductListV2 getLastUtilityProductList() {
        CJRUtilityProductListV2 cJRUtilityProductListV2 = this.nextLevelProductList;
        if (cJRUtilityProductListV2 == null) {
            return this;
        }
        return cJRUtilityProductListV2.getLastUtilityProductList();
    }

    public Map<Integer, CJRUtilitySelectedGroupItemV2> getSelectedGroupItemHashMap() {
        return this.selectedGroupItemHashMap;
    }

    public void addItemToSelectedHashMap(int i2, CJRUtilitySelectedGroupItemV2 cJRUtilitySelectedGroupItemV2) {
        this.selectedGroupItemHashMap.put(Integer.valueOf(i2), cJRUtilitySelectedGroupItemV2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0002 A[LOOP:0: B:1:0x0002->B:4:0x0010, LOOP_START, PHI: r4 
      PHI: (r4v2 int) = (r4v1 int), (r4v9 int) binds: [B:0:0x0000, B:4:0x0010] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2> getVariantListForGroupIndexForSelectedItems(int r4) {
        /*
            r3 = this;
            r0 = -1
            int r4 = r4 + r0
        L_0x0002:
            java.util.Map<java.lang.Integer, net.one97.paytm.recharge.legacy.catalog.model.CJRUtilitySelectedGroupItemV2> r1 = r3.selectedGroupItemHashMap
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x0012
            int r4 = r4 + -1
            if (r4 != r0) goto L_0x0002
        L_0x0012:
            if (r4 != r0) goto L_0x001a
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            return r4
        L_0x001a:
            java.util.Map<java.lang.Integer, net.one97.paytm.recharge.legacy.catalog.model.CJRUtilitySelectedGroupItemV2> r0 = r3.selectedGroupItemHashMap
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = r0.get(r4)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilitySelectedGroupItemV2 r4 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilitySelectedGroupItemV2) r4
            java.util.List r4 = r4.getItemVarientList()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2.getVariantListForGroupIndexForSelectedItems(int):java.util.List");
    }

    public List<String> getNextGroupingList() {
        int i2 = 0;
        while (i2 < this.grouping.size()) {
            if (this.grouping.get(i2) == null || this.groupFieldMap.get(this.grouping.get(i2).get(0)) == null) {
                i2++;
            } else {
                int i3 = i2 + 1;
                if (this.grouping.size() > i3) {
                    return this.grouping.get(i3);
                }
                return null;
            }
        }
        return null;
    }

    public List<String> getCurrentGroupList() {
        for (int i2 = 0; i2 < this.grouping.size(); i2++) {
            if (this.grouping.get(i2) != null && this.groupFieldMap.get(this.grouping.get(i2).get(0)) != null) {
                return this.grouping.get(i2);
            }
        }
        return null;
    }

    public int getGroupLevel() {
        return this.groupLevel;
    }

    public void setGroupLevel(int i2) {
        this.groupLevel = i2;
    }

    public void setSelectedGroupItemHashMap(Map<Integer, CJRUtilitySelectedGroupItemV2> map) {
        this.selectedGroupItemHashMap = map;
    }

    public List<CJRUtilityBottomTabData> getBottomTabDataList() {
        return this.bottomTabDataList;
    }
}

package net.one97.paytm.recharge.model.v4;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.recharge.legacy.catalog.model.v2.TopLevelCategoryHeader;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public final class CJRCategoryData extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "productListInLastGrouping")
    private final int _productListInLastGrouping;
    @b(a = "aggrAttrs")
    private List<List<CJRAggrAttrsItem>> aggrAttrs;
    @b(a = "alert")
    private final Object alert;
    @b(a = "applicableCities")
    private final List<Object> applicableCities;
    @b(a = "attributes")
    private final List<GroupAttributesItem> attributes;
    @b(a = "bottomStripUtilities")
    private final List<Object> bottomStripUtilities;
    @b(a = "buttonObject")
    private final CJRUtilityButtonObjectV4 buttonObject;
    private int cachedLangId;
    @b(a = "canonicalUrl")
    private final String canonicalUrl;
    @b(a = "categoryHeader")
    private final String categoryHeader;
    @b(a = "categoryId")
    private final Long categoryId;
    @b(a = "dealsFastForward")
    private final Integer dealsFastForward;
    @b(a = "description")
    private final String description;
    @b(a = "disclaimer")
    private final String disclaimer;
    @b(a = "disclaimerFastForward")
    private final String disclaimerFastForward;
    @b(a = "disclaimerHtml")
    private final String disclaimerHtml;
    @b(a = "displayName")
    private final String displayName;
    @b(a = "extnAttrs")
    private final CJRExtensionAttributes extnAttrs;
    @b(a = "extraDescription")
    private final String extraDescription;
    @b(a = "fastForwardText")
    private final String fastForwardText;
    @b(a = "gaKey")
    private final String gaKey;
    private int groupLevel;
    @b(a = "groupingCollapsible")
    private final Integer groupingCollapsible;
    @b(a = "groupings")
    private final CJRGroupings groupings;
    @b(a = "inputFields")
    private final List<CJRInputFieldsItem> inputFields;
    @b(a = "logoUrl")
    private final Object logoUrl;
    @b(a = "message")
    private final String message;
    @b(a = "metaDescription")
    private final String metaDescription;
    @b(a = "metaInfo")
    private final CJRMetaInfo metaInfo;
    @b(a = "metaKeyword")
    private final String metaKeyword;
    @b(a = "metaTitle")
    private final String metaTitle;
    private CJRCategoryData nextLevelGroupingData;
    @b(a = "protectionUrl")
    private final CJRProtectionUrl protectionUrl;
    @b(a = "recentsPrefill")
    private final Integer recentsPrefill;
    @b(a = "relatedCategories")
    private final List<CJRRelatedCategory> relatedCategories;
    private Map<String, CJRSelectedGroupItem> selectedGroupItemHashMap;
    @b(a = "showFastForward")
    private final Integer showFastForward;
    @b(a = "showHelp")
    private final Integer showHelp;
    @b(a = "showUpgrade")
    private final Integer showUpgrade;
    @b(a = "skipDeals")
    private final Integer skipDeals;
    @b(a = "staticForm")
    private final Integer staticForm;
    private int statusCode;
    @b(a = "topLevelCategoryHeader")
    private final TopLevelCategoryHeader topLevelCategoryHeader;
    @b(a = "verticalId")
    private final String verticalId;

    public CJRCategoryData() {
        this((List) null, (Integer) null, (Integer) null, (Integer) null, (List) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (CJRProtectionUrl) null, (Object) null, (Integer) null, (CJRUtilityButtonObjectV4) null, (Integer) null, (Integer) null, (String) null, (TopLevelCategoryHeader) null, (String) null, (String) null, (String) null, (Long) null, (List) null, (Integer) null, (String) null, (Object) null, (String) null, (CJRMetaInfo) null, (Integer) null, (CJRGroupings) null, (String) null, (List) null, (String) null, (String) null, (CJRExtensionAttributes) null, (CJRCategoryData) null, (Map) null, 0, 0, (List) null, 0, 0, -1, 4095, (g) null);
    }

    private final Integer component2() {
        return this.showFastForward;
    }

    private final int component43() {
        return this._productListInLastGrouping;
    }

    public static /* synthetic */ CJRCategoryData copy$default(CJRCategoryData cJRCategoryData, List list, Integer num, Integer num2, Integer num3, List list2, String str, List list3, String str2, String str3, String str4, String str5, String str6, CJRProtectionUrl cJRProtectionUrl, Object obj, Integer num4, CJRUtilityButtonObjectV4 cJRUtilityButtonObjectV4, Integer num5, Integer num6, String str7, TopLevelCategoryHeader topLevelCategoryHeader2, String str8, String str9, String str10, Long l, List list4, Integer num7, String str11, Object obj2, String str12, CJRMetaInfo cJRMetaInfo, Integer num8, CJRGroupings cJRGroupings, String str13, List list5, String str14, String str15, CJRExtensionAttributes cJRExtensionAttributes, CJRCategoryData cJRCategoryData2, Map map, int i2, int i3, List list6, int i4, int i5, int i6, int i7, Object obj3) {
        CJRCategoryData cJRCategoryData3 = cJRCategoryData;
        int i8 = i6;
        int i9 = i7;
        return cJRCategoryData.copy((i8 & 1) != 0 ? cJRCategoryData3.bottomStripUtilities : list, (i8 & 2) != 0 ? cJRCategoryData3.showFastForward : num, (i8 & 4) != 0 ? cJRCategoryData3.showUpgrade : num2, (i8 & 8) != 0 ? cJRCategoryData3.groupingCollapsible : num3, (i8 & 16) != 0 ? cJRCategoryData3.applicableCities : list2, (i8 & 32) != 0 ? cJRCategoryData3.displayName : str, (i8 & 64) != 0 ? cJRCategoryData3.relatedCategories : list3, (i8 & 128) != 0 ? cJRCategoryData3.description : str2, (i8 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRCategoryData3.disclaimerHtml : str3, (i8 & 512) != 0 ? cJRCategoryData3.metaDescription : str4, (i8 & TarConstants.EOF_BLOCK) != 0 ? cJRCategoryData3.fastForwardText : str5, (i8 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cJRCategoryData3.disclaimerFastForward : str6, (i8 & 4096) != 0 ? cJRCategoryData3.protectionUrl : cJRProtectionUrl, (i8 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cJRCategoryData3.alert : obj, (i8 & 16384) != 0 ? cJRCategoryData3.showHelp : num4, (i8 & 32768) != 0 ? cJRCategoryData3.buttonObject : cJRUtilityButtonObjectV4, (i8 & 65536) != 0 ? cJRCategoryData3.recentsPrefill : num5, (i8 & 131072) != 0 ? cJRCategoryData3.skipDeals : num6, (i8 & 262144) != 0 ? cJRCategoryData3.disclaimer : str7, (i8 & 524288) != 0 ? cJRCategoryData3.topLevelCategoryHeader : topLevelCategoryHeader2, (i8 & 1048576) != 0 ? cJRCategoryData3.extraDescription : str8, (i8 & 2097152) != 0 ? cJRCategoryData3.categoryHeader : str9, (i8 & 4194304) != 0 ? cJRCategoryData3.canonicalUrl : str10, (i8 & 8388608) != 0 ? cJRCategoryData3.categoryId : l, (i8 & 16777216) != 0 ? cJRCategoryData3.aggrAttrs : list4, (i8 & 33554432) != 0 ? cJRCategoryData3.dealsFastForward : num7, (i8 & 67108864) != 0 ? cJRCategoryData3.message : str11, (i8 & 134217728) != 0 ? cJRCategoryData3.logoUrl : obj2, (i8 & 268435456) != 0 ? cJRCategoryData3.verticalId : str12, (i8 & 536870912) != 0 ? cJRCategoryData3.metaInfo : cJRMetaInfo, (i8 & 1073741824) != 0 ? cJRCategoryData3.staticForm : num8, (i8 & Integer.MIN_VALUE) != 0 ? cJRCategoryData3.groupings : cJRGroupings, (i9 & 1) != 0 ? cJRCategoryData3.metaTitle : str13, (i9 & 2) != 0 ? cJRCategoryData3.attributes : list5, (i9 & 4) != 0 ? cJRCategoryData3.gaKey : str14, (i9 & 8) != 0 ? cJRCategoryData3.metaKeyword : str15, (i9 & 16) != 0 ? cJRCategoryData3.extnAttrs : cJRExtensionAttributes, (i9 & 32) != 0 ? cJRCategoryData3.nextLevelGroupingData : cJRCategoryData2, (i9 & 64) != 0 ? cJRCategoryData3.selectedGroupItemHashMap : map, (i9 & 128) != 0 ? cJRCategoryData3.statusCode : i2, (i9 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRCategoryData3.groupLevel : i3, (i9 & 512) != 0 ? cJRCategoryData3.inputFields : list6, (i9 & TarConstants.EOF_BLOCK) != 0 ? cJRCategoryData3._productListInLastGrouping : i4, (i9 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cJRCategoryData3.cachedLangId : i5);
    }

    public final List<Object> component1() {
        return this.bottomStripUtilities;
    }

    public final String component10() {
        return this.metaDescription;
    }

    public final String component11() {
        return this.fastForwardText;
    }

    public final String component12() {
        return this.disclaimerFastForward;
    }

    public final CJRProtectionUrl component13() {
        return this.protectionUrl;
    }

    public final Object component14() {
        return this.alert;
    }

    public final Integer component15() {
        return this.showHelp;
    }

    public final CJRUtilityButtonObjectV4 component16() {
        return this.buttonObject;
    }

    public final Integer component17() {
        return this.recentsPrefill;
    }

    public final Integer component18() {
        return this.skipDeals;
    }

    public final String component19() {
        return this.disclaimer;
    }

    public final TopLevelCategoryHeader component20() {
        return this.topLevelCategoryHeader;
    }

    public final String component21() {
        return this.extraDescription;
    }

    public final String component22() {
        return this.categoryHeader;
    }

    public final String component23() {
        return this.canonicalUrl;
    }

    public final Long component24() {
        return this.categoryId;
    }

    public final List<List<CJRAggrAttrsItem>> component25() {
        return this.aggrAttrs;
    }

    public final Integer component26() {
        return this.dealsFastForward;
    }

    public final String component27() {
        return this.message;
    }

    public final Object component28() {
        return this.logoUrl;
    }

    public final String component29() {
        return this.verticalId;
    }

    public final Integer component3() {
        return this.showUpgrade;
    }

    public final CJRMetaInfo component30() {
        return this.metaInfo;
    }

    public final Integer component31() {
        return this.staticForm;
    }

    public final CJRGroupings component32() {
        return this.groupings;
    }

    public final String component33() {
        return this.metaTitle;
    }

    public final List<GroupAttributesItem> component34() {
        return this.attributes;
    }

    public final String component35() {
        return this.gaKey;
    }

    public final String component36() {
        return this.metaKeyword;
    }

    public final CJRExtensionAttributes component37() {
        return this.extnAttrs;
    }

    public final CJRCategoryData component38() {
        return this.nextLevelGroupingData;
    }

    public final Map<String, CJRSelectedGroupItem> component39() {
        return this.selectedGroupItemHashMap;
    }

    public final Integer component4() {
        return this.groupingCollapsible;
    }

    public final int component40() {
        return this.statusCode;
    }

    public final int component41() {
        return this.groupLevel;
    }

    public final List<CJRInputFieldsItem> component42() {
        return this.inputFields;
    }

    public final int component44() {
        return this.cachedLangId;
    }

    public final List<Object> component5() {
        return this.applicableCities;
    }

    public final String component6() {
        return this.displayName;
    }

    public final List<CJRRelatedCategory> component7() {
        return this.relatedCategories;
    }

    public final String component8() {
        return this.description;
    }

    public final String component9() {
        return this.disclaimerHtml;
    }

    public final CJRCategoryData copy(List<? extends Object> list, Integer num, Integer num2, Integer num3, List<? extends Object> list2, String str, List<CJRRelatedCategory> list3, String str2, String str3, String str4, String str5, String str6, CJRProtectionUrl cJRProtectionUrl, Object obj, Integer num4, CJRUtilityButtonObjectV4 cJRUtilityButtonObjectV4, Integer num5, Integer num6, String str7, TopLevelCategoryHeader topLevelCategoryHeader2, String str8, String str9, String str10, Long l, List<List<CJRAggrAttrsItem>> list4, Integer num7, String str11, Object obj2, String str12, CJRMetaInfo cJRMetaInfo, Integer num8, CJRGroupings cJRGroupings, String str13, List<GroupAttributesItem> list5, String str14, String str15, CJRExtensionAttributes cJRExtensionAttributes, CJRCategoryData cJRCategoryData, Map<String, CJRSelectedGroupItem> map, int i2, int i3, List<CJRInputFieldsItem> list6, int i4, int i5) {
        List<? extends Object> list7 = list;
        k.c(map, "selectedGroupItemHashMap");
        return new CJRCategoryData(list, num, num2, num3, list2, str, list3, str2, str3, str4, str5, str6, cJRProtectionUrl, obj, num4, cJRUtilityButtonObjectV4, num5, num6, str7, topLevelCategoryHeader2, str8, str9, str10, l, list4, num7, str11, obj2, str12, cJRMetaInfo, num8, cJRGroupings, str13, list5, str14, str15, cJRExtensionAttributes, cJRCategoryData, map, i2, i3, list6, i4, i5);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRCategoryData) {
                CJRCategoryData cJRCategoryData = (CJRCategoryData) obj;
                if (k.a((Object) this.bottomStripUtilities, (Object) cJRCategoryData.bottomStripUtilities) && k.a((Object) this.showFastForward, (Object) cJRCategoryData.showFastForward) && k.a((Object) this.showUpgrade, (Object) cJRCategoryData.showUpgrade) && k.a((Object) this.groupingCollapsible, (Object) cJRCategoryData.groupingCollapsible) && k.a((Object) this.applicableCities, (Object) cJRCategoryData.applicableCities) && k.a((Object) this.displayName, (Object) cJRCategoryData.displayName) && k.a((Object) this.relatedCategories, (Object) cJRCategoryData.relatedCategories) && k.a((Object) this.description, (Object) cJRCategoryData.description) && k.a((Object) this.disclaimerHtml, (Object) cJRCategoryData.disclaimerHtml) && k.a((Object) this.metaDescription, (Object) cJRCategoryData.metaDescription) && k.a((Object) this.fastForwardText, (Object) cJRCategoryData.fastForwardText) && k.a((Object) this.disclaimerFastForward, (Object) cJRCategoryData.disclaimerFastForward) && k.a((Object) this.protectionUrl, (Object) cJRCategoryData.protectionUrl) && k.a(this.alert, cJRCategoryData.alert) && k.a((Object) this.showHelp, (Object) cJRCategoryData.showHelp) && k.a((Object) this.buttonObject, (Object) cJRCategoryData.buttonObject) && k.a((Object) this.recentsPrefill, (Object) cJRCategoryData.recentsPrefill) && k.a((Object) this.skipDeals, (Object) cJRCategoryData.skipDeals) && k.a((Object) this.disclaimer, (Object) cJRCategoryData.disclaimer) && k.a((Object) this.topLevelCategoryHeader, (Object) cJRCategoryData.topLevelCategoryHeader) && k.a((Object) this.extraDescription, (Object) cJRCategoryData.extraDescription) && k.a((Object) this.categoryHeader, (Object) cJRCategoryData.categoryHeader) && k.a((Object) this.canonicalUrl, (Object) cJRCategoryData.canonicalUrl) && k.a((Object) this.categoryId, (Object) cJRCategoryData.categoryId) && k.a((Object) this.aggrAttrs, (Object) cJRCategoryData.aggrAttrs) && k.a((Object) this.dealsFastForward, (Object) cJRCategoryData.dealsFastForward) && k.a((Object) this.message, (Object) cJRCategoryData.message) && k.a(this.logoUrl, cJRCategoryData.logoUrl) && k.a((Object) this.verticalId, (Object) cJRCategoryData.verticalId) && k.a((Object) this.metaInfo, (Object) cJRCategoryData.metaInfo) && k.a((Object) this.staticForm, (Object) cJRCategoryData.staticForm) && k.a((Object) this.groupings, (Object) cJRCategoryData.groupings) && k.a((Object) this.metaTitle, (Object) cJRCategoryData.metaTitle) && k.a((Object) this.attributes, (Object) cJRCategoryData.attributes) && k.a((Object) this.gaKey, (Object) cJRCategoryData.gaKey) && k.a((Object) this.metaKeyword, (Object) cJRCategoryData.metaKeyword) && k.a((Object) this.extnAttrs, (Object) cJRCategoryData.extnAttrs) && k.a((Object) this.nextLevelGroupingData, (Object) cJRCategoryData.nextLevelGroupingData) && k.a((Object) this.selectedGroupItemHashMap, (Object) cJRCategoryData.selectedGroupItemHashMap)) {
                    if (this.statusCode == cJRCategoryData.statusCode) {
                        if ((this.groupLevel == cJRCategoryData.groupLevel) && k.a((Object) this.inputFields, (Object) cJRCategoryData.inputFields)) {
                            if (this._productListInLastGrouping == cJRCategoryData._productListInLastGrouping) {
                                if (this.cachedLangId == cJRCategoryData.cachedLangId) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List<Object> list = this.bottomStripUtilities;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Integer num = this.showFastForward;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.showUpgrade;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.groupingCollapsible;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 31;
        List<Object> list2 = this.applicableCities;
        int hashCode5 = (hashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str = this.displayName;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        List<CJRRelatedCategory> list3 = this.relatedCategories;
        int hashCode7 = (hashCode6 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str2 = this.description;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.disclaimerHtml;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.metaDescription;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.fastForwardText;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.disclaimerFastForward;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 31;
        CJRProtectionUrl cJRProtectionUrl = this.protectionUrl;
        int hashCode13 = (hashCode12 + (cJRProtectionUrl != null ? cJRProtectionUrl.hashCode() : 0)) * 31;
        Object obj = this.alert;
        int hashCode14 = (hashCode13 + (obj != null ? obj.hashCode() : 0)) * 31;
        Integer num4 = this.showHelp;
        int hashCode15 = (hashCode14 + (num4 != null ? num4.hashCode() : 0)) * 31;
        CJRUtilityButtonObjectV4 cJRUtilityButtonObjectV4 = this.buttonObject;
        int hashCode16 = (hashCode15 + (cJRUtilityButtonObjectV4 != null ? cJRUtilityButtonObjectV4.hashCode() : 0)) * 31;
        Integer num5 = this.recentsPrefill;
        int hashCode17 = (hashCode16 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.skipDeals;
        int hashCode18 = (hashCode17 + (num6 != null ? num6.hashCode() : 0)) * 31;
        String str7 = this.disclaimer;
        int hashCode19 = (hashCode18 + (str7 != null ? str7.hashCode() : 0)) * 31;
        TopLevelCategoryHeader topLevelCategoryHeader2 = this.topLevelCategoryHeader;
        int hashCode20 = (hashCode19 + (topLevelCategoryHeader2 != null ? topLevelCategoryHeader2.hashCode() : 0)) * 31;
        String str8 = this.extraDescription;
        int hashCode21 = (hashCode20 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.categoryHeader;
        int hashCode22 = (hashCode21 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.canonicalUrl;
        int hashCode23 = (hashCode22 + (str10 != null ? str10.hashCode() : 0)) * 31;
        Long l = this.categoryId;
        int hashCode24 = (hashCode23 + (l != null ? l.hashCode() : 0)) * 31;
        List<List<CJRAggrAttrsItem>> list4 = this.aggrAttrs;
        int hashCode25 = (hashCode24 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Integer num7 = this.dealsFastForward;
        int hashCode26 = (hashCode25 + (num7 != null ? num7.hashCode() : 0)) * 31;
        String str11 = this.message;
        int hashCode27 = (hashCode26 + (str11 != null ? str11.hashCode() : 0)) * 31;
        Object obj2 = this.logoUrl;
        int hashCode28 = (hashCode27 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        String str12 = this.verticalId;
        int hashCode29 = (hashCode28 + (str12 != null ? str12.hashCode() : 0)) * 31;
        CJRMetaInfo cJRMetaInfo = this.metaInfo;
        int hashCode30 = (hashCode29 + (cJRMetaInfo != null ? cJRMetaInfo.hashCode() : 0)) * 31;
        Integer num8 = this.staticForm;
        int hashCode31 = (hashCode30 + (num8 != null ? num8.hashCode() : 0)) * 31;
        CJRGroupings cJRGroupings = this.groupings;
        int hashCode32 = (hashCode31 + (cJRGroupings != null ? cJRGroupings.hashCode() : 0)) * 31;
        String str13 = this.metaTitle;
        int hashCode33 = (hashCode32 + (str13 != null ? str13.hashCode() : 0)) * 31;
        List<GroupAttributesItem> list5 = this.attributes;
        int hashCode34 = (hashCode33 + (list5 != null ? list5.hashCode() : 0)) * 31;
        String str14 = this.gaKey;
        int hashCode35 = (hashCode34 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.metaKeyword;
        int hashCode36 = (hashCode35 + (str15 != null ? str15.hashCode() : 0)) * 31;
        CJRExtensionAttributes cJRExtensionAttributes = this.extnAttrs;
        int hashCode37 = (hashCode36 + (cJRExtensionAttributes != null ? cJRExtensionAttributes.hashCode() : 0)) * 31;
        CJRCategoryData cJRCategoryData = this.nextLevelGroupingData;
        int hashCode38 = (hashCode37 + (cJRCategoryData != null ? cJRCategoryData.hashCode() : 0)) * 31;
        Map<String, CJRSelectedGroupItem> map = this.selectedGroupItemHashMap;
        int hashCode39 = (((((hashCode38 + (map != null ? map.hashCode() : 0)) * 31) + this.statusCode) * 31) + this.groupLevel) * 31;
        List<CJRInputFieldsItem> list6 = this.inputFields;
        if (list6 != null) {
            i2 = list6.hashCode();
        }
        return ((((hashCode39 + i2) * 31) + this._productListInLastGrouping) * 31) + this.cachedLangId;
    }

    public final String toString() {
        return "";
    }

    public final List<Object> getBottomStripUtilities() {
        return this.bottomStripUtilities;
    }

    public final Integer getShowUpgrade() {
        return this.showUpgrade;
    }

    public final Integer getGroupingCollapsible() {
        return this.groupingCollapsible;
    }

    public final List<Object> getApplicableCities() {
        return this.applicableCities;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final List<CJRRelatedCategory> getRelatedCategories() {
        return this.relatedCategories;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDisclaimerHtml() {
        return this.disclaimerHtml;
    }

    public final String getMetaDescription() {
        return this.metaDescription;
    }

    public final String getFastForwardText() {
        return this.fastForwardText;
    }

    public final String getDisclaimerFastForward() {
        return this.disclaimerFastForward;
    }

    public final CJRProtectionUrl getProtectionUrl() {
        return this.protectionUrl;
    }

    public final Object getAlert() {
        return this.alert;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRCategoryData(java.util.List r44, java.lang.Integer r45, java.lang.Integer r46, java.lang.Integer r47, java.util.List r48, java.lang.String r49, java.util.List r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, net.one97.paytm.recharge.model.v4.CJRProtectionUrl r56, java.lang.Object r57, java.lang.Integer r58, net.one97.paytm.recharge.model.v4.CJRUtilityButtonObjectV4 r59, java.lang.Integer r60, java.lang.Integer r61, java.lang.String r62, net.one97.paytm.recharge.legacy.catalog.model.v2.TopLevelCategoryHeader r63, java.lang.String r64, java.lang.String r65, java.lang.String r66, java.lang.Long r67, java.util.List r68, java.lang.Integer r69, java.lang.String r70, java.lang.Object r71, java.lang.String r72, net.one97.paytm.recharge.model.v4.CJRMetaInfo r73, java.lang.Integer r74, net.one97.paytm.recharge.model.v4.CJRGroupings r75, java.lang.String r76, java.util.List r77, java.lang.String r78, java.lang.String r79, net.one97.paytm.recharge.model.v4.CJRExtensionAttributes r80, net.one97.paytm.recharge.model.v4.CJRCategoryData r81, java.util.Map r82, int r83, int r84, java.util.List r85, int r86, int r87, int r88, int r89, kotlin.g.b.g r90) {
        /*
            r43 = this;
            r0 = r88
            r1 = r89
            r2 = r0 & 1
            if (r2 == 0) goto L_0x000a
            r2 = 0
            goto L_0x000c
        L_0x000a:
            r2 = r44
        L_0x000c:
            r4 = r0 & 2
            if (r4 == 0) goto L_0x0012
            r4 = 0
            goto L_0x0014
        L_0x0012:
            r4 = r45
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = 0
            goto L_0x001c
        L_0x001a:
            r5 = r46
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = 0
            goto L_0x0024
        L_0x0022:
            r6 = r47
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r48
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r49
        L_0x0034:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r50
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r51
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = 0
            goto L_0x004c
        L_0x004a:
            r11 = r52
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0052
            r12 = 0
            goto L_0x0054
        L_0x0052:
            r12 = r53
        L_0x0054:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005a
            r13 = 0
            goto L_0x005c
        L_0x005a:
            r13 = r54
        L_0x005c:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            r14 = 0
            goto L_0x0064
        L_0x0062:
            r14 = r55
        L_0x0064:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x006a
            r15 = 0
            goto L_0x006c
        L_0x006a:
            r15 = r56
        L_0x006c:
            r3 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x0072
            r3 = 0
            goto L_0x0074
        L_0x0072:
            r3 = r57
        L_0x0074:
            r16 = r3
            r3 = r0 & 16384(0x4000, float:2.2959E-41)
            r17 = 0
            if (r3 == 0) goto L_0x0081
            java.lang.Integer r3 = java.lang.Integer.valueOf(r17)
            goto L_0x0083
        L_0x0081:
            r3 = r58
        L_0x0083:
            r18 = 32768(0x8000, float:4.5918E-41)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x008d
            r18 = 0
            goto L_0x008f
        L_0x008d:
            r18 = r59
        L_0x008f:
            r19 = 65536(0x10000, float:9.18355E-41)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x0098
            r19 = 0
            goto L_0x009a
        L_0x0098:
            r19 = r60
        L_0x009a:
            r20 = 131072(0x20000, float:1.83671E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00a3
            r20 = 0
            goto L_0x00a5
        L_0x00a3:
            r20 = r61
        L_0x00a5:
            r21 = 262144(0x40000, float:3.67342E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ae
            r21 = 0
            goto L_0x00b0
        L_0x00ae:
            r21 = r62
        L_0x00b0:
            r22 = 524288(0x80000, float:7.34684E-40)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00b9
            r22 = 0
            goto L_0x00bb
        L_0x00b9:
            r22 = r63
        L_0x00bb:
            r23 = 1048576(0x100000, float:1.469368E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00c4
            r23 = 0
            goto L_0x00c6
        L_0x00c4:
            r23 = r64
        L_0x00c6:
            r24 = 2097152(0x200000, float:2.938736E-39)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00cf
            r24 = 0
            goto L_0x00d1
        L_0x00cf:
            r24 = r65
        L_0x00d1:
            r25 = 4194304(0x400000, float:5.877472E-39)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00da
            r25 = 0
            goto L_0x00dc
        L_0x00da:
            r25 = r66
        L_0x00dc:
            r26 = 8388608(0x800000, float:1.17549435E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00e5
            r26 = 0
            goto L_0x00e7
        L_0x00e5:
            r26 = r67
        L_0x00e7:
            r27 = 16777216(0x1000000, float:2.3509887E-38)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00f0
            r27 = 0
            goto L_0x00f2
        L_0x00f0:
            r27 = r68
        L_0x00f2:
            r28 = 33554432(0x2000000, float:9.403955E-38)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00fb
            r28 = 0
            goto L_0x00fd
        L_0x00fb:
            r28 = r69
        L_0x00fd:
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x0106
            r29 = 0
            goto L_0x0108
        L_0x0106:
            r29 = r70
        L_0x0108:
            r30 = 134217728(0x8000000, float:3.85186E-34)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x0111
            r30 = 0
            goto L_0x0113
        L_0x0111:
            r30 = r71
        L_0x0113:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x011c
            r31 = 0
            goto L_0x011e
        L_0x011c:
            r31 = r72
        L_0x011e:
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x0127
            r32 = 0
            goto L_0x0129
        L_0x0127:
            r32 = r73
        L_0x0129:
            r33 = 1073741824(0x40000000, float:2.0)
            r33 = r0 & r33
            if (r33 == 0) goto L_0x0132
            r33 = 0
            goto L_0x0134
        L_0x0132:
            r33 = r74
        L_0x0134:
            r34 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r34
            if (r0 == 0) goto L_0x013c
            r0 = 0
            goto L_0x013e
        L_0x013c:
            r0 = r75
        L_0x013e:
            r34 = r1 & 1
            if (r34 == 0) goto L_0x0145
            r34 = 0
            goto L_0x0147
        L_0x0145:
            r34 = r76
        L_0x0147:
            r35 = r1 & 2
            if (r35 == 0) goto L_0x014e
            r35 = 0
            goto L_0x0150
        L_0x014e:
            r35 = r77
        L_0x0150:
            r36 = r1 & 4
            if (r36 == 0) goto L_0x0157
            r36 = 0
            goto L_0x0159
        L_0x0157:
            r36 = r78
        L_0x0159:
            r37 = r1 & 8
            if (r37 == 0) goto L_0x0160
            r37 = 0
            goto L_0x0162
        L_0x0160:
            r37 = r79
        L_0x0162:
            r38 = r1 & 16
            if (r38 == 0) goto L_0x0169
            r38 = 0
            goto L_0x016b
        L_0x0169:
            r38 = r80
        L_0x016b:
            r39 = r1 & 32
            if (r39 == 0) goto L_0x0172
            r39 = 0
            goto L_0x0174
        L_0x0172:
            r39 = r81
        L_0x0174:
            r40 = r1 & 64
            if (r40 == 0) goto L_0x0180
            java.util.HashMap r40 = new java.util.HashMap
            r40.<init>()
            java.util.Map r40 = (java.util.Map) r40
            goto L_0x0182
        L_0x0180:
            r40 = r82
        L_0x0182:
            r88 = r0
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x018a
            r0 = 0
            goto L_0x018c
        L_0x018a:
            r0 = r83
        L_0x018c:
            r41 = r0
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0194
            r0 = 0
            goto L_0x0196
        L_0x0194:
            r0 = r84
        L_0x0196:
            r42 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x019e
            r0 = 0
            goto L_0x01a0
        L_0x019e:
            r0 = r85
        L_0x01a0:
            r90 = r0
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01a7
            goto L_0x01a9
        L_0x01a7:
            r17 = r86
        L_0x01a9:
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01af
            r0 = -1
            goto L_0x01b1
        L_0x01af:
            r0 = r87
        L_0x01b1:
            r44 = r43
            r45 = r2
            r46 = r4
            r47 = r5
            r48 = r6
            r49 = r7
            r50 = r8
            r51 = r9
            r52 = r10
            r53 = r11
            r54 = r12
            r55 = r13
            r56 = r14
            r57 = r15
            r58 = r16
            r59 = r3
            r60 = r18
            r61 = r19
            r62 = r20
            r63 = r21
            r64 = r22
            r65 = r23
            r66 = r24
            r67 = r25
            r68 = r26
            r69 = r27
            r70 = r28
            r71 = r29
            r72 = r30
            r73 = r31
            r74 = r32
            r75 = r33
            r76 = r88
            r77 = r34
            r78 = r35
            r79 = r36
            r80 = r37
            r81 = r38
            r82 = r39
            r83 = r40
            r84 = r41
            r85 = r42
            r86 = r90
            r87 = r17
            r88 = r0
            r44.<init>(r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRCategoryData.<init>(java.util.List, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.util.List, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.recharge.model.v4.CJRProtectionUrl, java.lang.Object, java.lang.Integer, net.one97.paytm.recharge.model.v4.CJRUtilityButtonObjectV4, java.lang.Integer, java.lang.Integer, java.lang.String, net.one97.paytm.recharge.legacy.catalog.model.v2.TopLevelCategoryHeader, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.util.List, java.lang.Integer, java.lang.String, java.lang.Object, java.lang.String, net.one97.paytm.recharge.model.v4.CJRMetaInfo, java.lang.Integer, net.one97.paytm.recharge.model.v4.CJRGroupings, java.lang.String, java.util.List, java.lang.String, java.lang.String, net.one97.paytm.recharge.model.v4.CJRExtensionAttributes, net.one97.paytm.recharge.model.v4.CJRCategoryData, java.util.Map, int, int, java.util.List, int, int, int, int, kotlin.g.b.g):void");
    }

    public final Integer getShowHelp() {
        return this.showHelp;
    }

    public final CJRUtilityButtonObjectV4 getButtonObject() {
        return this.buttonObject;
    }

    public final Integer getRecentsPrefill() {
        return this.recentsPrefill;
    }

    public final Integer getSkipDeals() {
        return this.skipDeals;
    }

    public final String getDisclaimer() {
        return this.disclaimer;
    }

    public final TopLevelCategoryHeader getTopLevelCategoryHeader() {
        return this.topLevelCategoryHeader;
    }

    public final String getExtraDescription() {
        return this.extraDescription;
    }

    public final String getCategoryHeader() {
        return this.categoryHeader;
    }

    public final String getCanonicalUrl() {
        return this.canonicalUrl;
    }

    public final Long getCategoryId() {
        return this.categoryId;
    }

    public final List<List<CJRAggrAttrsItem>> getAggrAttrs() {
        return this.aggrAttrs;
    }

    public final void setAggrAttrs(List<List<CJRAggrAttrsItem>> list) {
        this.aggrAttrs = list;
    }

    public final Integer getDealsFastForward() {
        return this.dealsFastForward;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Object getLogoUrl() {
        return this.logoUrl;
    }

    public final String getVerticalId() {
        return this.verticalId;
    }

    public final CJRMetaInfo getMetaInfo() {
        return this.metaInfo;
    }

    public final Integer getStaticForm() {
        return this.staticForm;
    }

    public final CJRGroupings getGroupings() {
        return this.groupings;
    }

    public final String getMetaTitle() {
        return this.metaTitle;
    }

    public final List<GroupAttributesItem> getAttributes() {
        return this.attributes;
    }

    public final String getGaKey() {
        return this.gaKey;
    }

    public final String getMetaKeyword() {
        return this.metaKeyword;
    }

    public final CJRExtensionAttributes getExtnAttrs() {
        return this.extnAttrs;
    }

    public final CJRCategoryData getNextLevelGroupingData() {
        return this.nextLevelGroupingData;
    }

    public final void setNextLevelGroupingData(CJRCategoryData cJRCategoryData) {
        this.nextLevelGroupingData = cJRCategoryData;
    }

    public final Map<String, CJRSelectedGroupItem> getSelectedGroupItemHashMap() {
        return this.selectedGroupItemHashMap;
    }

    public final void setSelectedGroupItemHashMap(Map<String, CJRSelectedGroupItem> map) {
        k.c(map, "<set-?>");
        this.selectedGroupItemHashMap = map;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(int i2) {
        this.statusCode = i2;
    }

    public final int getGroupLevel() {
        return this.groupLevel;
    }

    public final void setGroupLevel(int i2) {
        this.groupLevel = i2;
    }

    public final List<CJRInputFieldsItem> getInputFields() {
        return this.inputFields;
    }

    public final int getCachedLangId() {
        return this.cachedLangId;
    }

    public final void setCachedLangId(int i2) {
        this.cachedLangId = i2;
    }

    public CJRCategoryData(List<? extends Object> list, Integer num, Integer num2, Integer num3, List<? extends Object> list2, String str, List<CJRRelatedCategory> list3, String str2, String str3, String str4, String str5, String str6, CJRProtectionUrl cJRProtectionUrl, Object obj, Integer num4, CJRUtilityButtonObjectV4 cJRUtilityButtonObjectV4, Integer num5, Integer num6, String str7, TopLevelCategoryHeader topLevelCategoryHeader2, String str8, String str9, String str10, Long l, List<List<CJRAggrAttrsItem>> list4, Integer num7, String str11, Object obj2, String str12, CJRMetaInfo cJRMetaInfo, Integer num8, CJRGroupings cJRGroupings, String str13, List<GroupAttributesItem> list5, String str14, String str15, CJRExtensionAttributes cJRExtensionAttributes, CJRCategoryData cJRCategoryData, Map<String, CJRSelectedGroupItem> map, int i2, int i3, List<CJRInputFieldsItem> list6, int i4, int i5) {
        Map<String, CJRSelectedGroupItem> map2 = map;
        k.c(map2, "selectedGroupItemHashMap");
        this.bottomStripUtilities = list;
        this.showFastForward = num;
        this.showUpgrade = num2;
        this.groupingCollapsible = num3;
        this.applicableCities = list2;
        this.displayName = str;
        this.relatedCategories = list3;
        this.description = str2;
        this.disclaimerHtml = str3;
        this.metaDescription = str4;
        this.fastForwardText = str5;
        this.disclaimerFastForward = str6;
        this.protectionUrl = cJRProtectionUrl;
        this.alert = obj;
        this.showHelp = num4;
        this.buttonObject = cJRUtilityButtonObjectV4;
        this.recentsPrefill = num5;
        this.skipDeals = num6;
        this.disclaimer = str7;
        this.topLevelCategoryHeader = topLevelCategoryHeader2;
        this.extraDescription = str8;
        this.categoryHeader = str9;
        this.canonicalUrl = str10;
        this.categoryId = l;
        this.aggrAttrs = list4;
        this.dealsFastForward = num7;
        this.message = str11;
        this.logoUrl = obj2;
        this.verticalId = str12;
        this.metaInfo = cJRMetaInfo;
        this.staticForm = num8;
        this.groupings = cJRGroupings;
        this.metaTitle = str13;
        this.attributes = list5;
        this.gaKey = str14;
        this.metaKeyword = str15;
        this.extnAttrs = cJRExtensionAttributes;
        this.nextLevelGroupingData = cJRCategoryData;
        this.selectedGroupItemHashMap = map2;
        this.statusCode = i2;
        this.groupLevel = i3;
        this.inputFields = list6;
        this._productListInLastGrouping = i4;
        this.cachedLangId = i5;
    }

    /* renamed from: getDealsFastForward  reason: collision with other method in class */
    public final boolean m764getDealsFastForward() {
        Integer num = this.dealsFastForward;
        return num != null && num.intValue() == 1;
    }

    public final boolean showFastForward() {
        Integer num = this.showFastForward;
        return num != null && num.intValue() == 1;
    }

    public final boolean isProductListInLastGrouping() {
        return this._productListInLastGrouping == 1;
    }

    public final void setNextGroupingData(CJRCategoryData cJRCategoryData) {
        k.c(cJRCategoryData, "nextLevelGroupingData");
        this.nextLevelGroupingData = cJRCategoryData;
        CJRCategoryData cJRCategoryData2 = this.nextLevelGroupingData;
        if (cJRCategoryData2 != null) {
            cJRCategoryData2.groupLevel = this.groupLevel + 1;
        }
        CJRCategoryData cJRCategoryData3 = this.nextLevelGroupingData;
        if (cJRCategoryData3 != null) {
            cJRCategoryData3.aggrAttrs = this.aggrAttrs;
        }
    }

    public final CJRCategoryData getLastGroupingData() {
        CJRCategoryData cJRCategoryData = this;
        while (true) {
            CJRCategoryData cJRCategoryData2 = cJRCategoryData.nextLevelGroupingData;
            if (cJRCategoryData2 == null) {
                return cJRCategoryData;
            }
            if (cJRCategoryData2 == null) {
                return null;
            }
            cJRCategoryData = cJRCategoryData2;
        }
    }

    public final void addItemToSelectedHashMap(CJRSelectedGroupItem cJRSelectedGroupItem) {
        k.c(cJRSelectedGroupItem, "selectedGroupItem");
        this.selectedGroupItemHashMap.put(cJRSelectedGroupItem.getGroupName(), cJRSelectedGroupItem);
    }

    public final CJRSelectedGroupItem getSelectedGroupItem(String str) {
        k.c(str, "groupName");
        return this.selectedGroupItemHashMap.get(str);
    }

    public final void removeItemFromSelectedHashMap(String str) {
        k.c(str, "groupName");
        List<List<CJRAggrAttrsItem>> list = this.aggrAttrs;
        if (list != null) {
            for (List<CJRAggrAttrsItem> list2 : list) {
                boolean z = false;
                if (list2 != null) {
                    for (CJRAggrAttrsItem cJRAggrAttrsItem : list2) {
                        String str2 = null;
                        if (!z) {
                            if (p.a(str, cJRAggrAttrsItem != null ? cJRAggrAttrsItem.getValue() : null, true)) {
                                z = true;
                            }
                        }
                        if (z) {
                            Map<String, CJRSelectedGroupItem> map = this.selectedGroupItemHashMap;
                            if (cJRAggrAttrsItem != null) {
                                str2 = cJRAggrAttrsItem.getValue();
                            }
                            map.remove(str2);
                        }
                    }
                    continue;
                }
                if (z) {
                    return;
                }
            }
        }
    }

    public final void removeAllSelections() {
        this.nextLevelGroupingData = null;
        this.selectedGroupItemHashMap.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: net.one97.paytm.recharge.model.v4.GroupAttributesItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: net.one97.paytm.recharge.model.v4.GroupAttributesItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: net.one97.paytm.recharge.model.v4.GroupAttributesItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: net.one97.paytm.recharge.model.v4.GroupAttributesItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final net.one97.paytm.recharge.model.v4.GroupAttributesItem getGroupFieldV2(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "groupName"
            kotlin.g.b.k.c(r6, r0)
            java.util.List<net.one97.paytm.recharge.model.v4.GroupAttributesItem> r0 = r5.attributes
            r1 = 0
            if (r0 == 0) goto L_0x002f
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0010:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            r3 = r2
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r3 = (net.one97.paytm.recharge.model.v4.GroupAttributesItem) r3
            if (r3 == 0) goto L_0x0024
            java.lang.String r3 = r3.getName()
            goto L_0x0025
        L_0x0024:
            r3 = r1
        L_0x0025:
            r4 = 0
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r6, (boolean) r4)
            if (r3 == 0) goto L_0x0010
            r1 = r2
        L_0x002d:
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r1 = (net.one97.paytm.recharge.model.v4.GroupAttributesItem) r1
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRCategoryData.getGroupFieldV2(java.lang.String):net.one97.paytm.recharge.model.v4.GroupAttributesItem");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0105 A[EDGE_INSN: B:105:0x0105->B:66:0x0105 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0075 A[SYNTHETIC] */
    public final java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem> getGroupingItemList(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "groupName"
            kotlin.g.b.k.c(r8, r0)
            net.one97.paytm.recharge.model.v4.CJRGroupings r0 = r7.groupings
            r1 = 0
            if (r0 == 0) goto L_0x0152
            java.lang.String r2 = r0.getAggKey()
            r3 = 1
            boolean r2 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r2, (boolean) r3)
            if (r2 == 0) goto L_0x001c
            net.one97.paytm.recharge.model.v4.CJRGroupings r8 = r7.groupings
            java.util.List r8 = r8.getAggs()
            return r8
        L_0x001c:
            java.util.List r2 = r0.getAggs()
            r4 = 0
            if (r2 == 0) goto L_0x0030
            java.lang.Object r2 = r2.get(r4)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r2
            if (r2 == 0) goto L_0x0030
            java.lang.String r2 = r2.getValue()
            goto L_0x0031
        L_0x0030:
            r2 = r1
        L_0x0031:
            java.lang.String r5 = "N/A"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r4)
            if (r2 != r3) goto L_0x0049
            java.util.List r2 = r0.getAggs()
            if (r2 != 0) goto L_0x0042
            kotlin.g.b.k.a()
        L_0x0042:
            java.lang.Object r2 = r2.get(r4)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r2
            goto L_0x004a
        L_0x0049:
            r2 = r1
        L_0x004a:
            if (r2 == 0) goto L_0x005f
            java.util.List r6 = r2.getAggs()
            if (r6 == 0) goto L_0x005f
            java.lang.Object r6 = r6.get(r4)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6
            if (r6 == 0) goto L_0x005f
            java.lang.String r6 = r6.getValue()
            goto L_0x0060
        L_0x005f:
            r6 = r1
        L_0x0060:
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r5, (boolean) r4)
            if (r6 != r3) goto L_0x0075
            if (r2 == 0) goto L_0x0049
            java.util.List r2 = r2.getAggs()
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = r2.get(r4)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r2
            goto L_0x004a
        L_0x0075:
            java.lang.String r0 = r0.getAggKey()
            if (r2 == 0) goto L_0x008e
            java.lang.String r0 = r2.getAggKey()
            java.lang.String r6 = r2.getAggKey()
            boolean r6 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r6, (boolean) r3)
            if (r6 == 0) goto L_0x008e
            java.util.List r8 = r2.getAggs()
            return r8
        L_0x008e:
            java.util.Map<java.lang.String, net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem> r6 = r7.selectedGroupItemHashMap
            java.lang.Object r0 = r6.get(r0)
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r0 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r0
            if (r0 == 0) goto L_0x0152
            java.util.Map<java.lang.String, net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem> r0 = r7.selectedGroupItemHashMap
            net.one97.paytm.recharge.model.v4.CJRGroupings r6 = r7.groupings
            java.lang.String r6 = r6.getAggKey()
            java.lang.Object r0 = r0.get(r6)
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r0 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r0
            if (r0 == 0) goto L_0x00ad
            java.lang.String r0 = r0.getValue()
            goto L_0x00ae
        L_0x00ad:
            r0 = r1
        L_0x00ae:
            net.one97.paytm.recharge.model.v4.CJRGroupings r6 = r7.groupings
            java.util.List r6 = r6.getAggs()
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r7.getSelectedAggsItem(r0, r6)
            if (r2 == 0) goto L_0x00d6
            java.util.Map<java.lang.String, net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem> r0 = r7.selectedGroupItemHashMap
            java.lang.String r6 = r2.getAggKey()
            java.lang.Object r0 = r0.get(r6)
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r0 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r0
            if (r0 == 0) goto L_0x00cd
            java.lang.String r0 = r0.getValue()
            goto L_0x00ce
        L_0x00cd:
            r0 = r1
        L_0x00ce:
            java.util.List r2 = r2.getAggs()
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r7.getSelectedAggsItem(r0, r2)
        L_0x00d6:
            if (r0 == 0) goto L_0x0152
        L_0x00d8:
            if (r0 == 0) goto L_0x00ed
            java.util.List r2 = r0.getAggs()
            if (r2 == 0) goto L_0x00ed
            java.lang.Object r2 = r2.get(r4)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r2
            if (r2 == 0) goto L_0x00ed
            java.lang.String r2 = r2.getValue()
            goto L_0x00ee
        L_0x00ed:
            r2 = r1
        L_0x00ee:
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r4)
            if (r2 != r3) goto L_0x0105
            if (r0 == 0) goto L_0x0103
            java.util.List r0 = r0.getAggs()
            if (r0 == 0) goto L_0x0103
            java.lang.Object r0 = r0.get(r4)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r0
            goto L_0x00d8
        L_0x0103:
            r0 = r1
            goto L_0x00d8
        L_0x0105:
            if (r0 == 0) goto L_0x010c
            java.lang.String r2 = r0.getAggKey()
            goto L_0x010d
        L_0x010c:
            r2 = r1
        L_0x010d:
            boolean r2 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r2, (boolean) r3)
            if (r2 == 0) goto L_0x011b
            if (r0 == 0) goto L_0x011a
            java.util.List r8 = r0.getAggs()
            return r8
        L_0x011a:
            return r1
        L_0x011b:
            java.util.Map<java.lang.String, net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem> r2 = r7.selectedGroupItemHashMap
            if (r0 == 0) goto L_0x0124
            java.lang.String r6 = r0.getAggKey()
            goto L_0x0125
        L_0x0124:
            r6 = r1
        L_0x0125:
            java.lang.Object r2 = r2.get(r6)
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r2 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r2
            if (r2 == 0) goto L_0x00d6
            java.util.Map<java.lang.String, net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem> r2 = r7.selectedGroupItemHashMap
            if (r0 == 0) goto L_0x0136
            java.lang.String r6 = r0.getAggKey()
            goto L_0x0137
        L_0x0136:
            r6 = r1
        L_0x0137:
            java.lang.Object r2 = r2.get(r6)
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r2 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r2
            if (r2 == 0) goto L_0x0144
            java.lang.String r2 = r2.getValue()
            goto L_0x0145
        L_0x0144:
            r2 = r1
        L_0x0145:
            if (r0 == 0) goto L_0x014c
            java.util.List r0 = r0.getAggs()
            goto L_0x014d
        L_0x014c:
            r0 = r1
        L_0x014d:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r7.getSelectedAggsItem(r2, r0)
            goto L_0x00d6
        L_0x0152:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRCategoryData.getGroupingItemList(java.lang.String):java.util.List");
    }

    public final CJRAggsItem getGroupingItem(String str) {
        k.c(str, "groupName");
        CJRGroupings cJRGroupings = this.groupings;
        if (cJRGroupings != null && (!this.selectedGroupItemHashMap.isEmpty()) && this.selectedGroupItemHashMap.get(cJRGroupings.getAggKey()) != null) {
            CJRSelectedGroupItem cJRSelectedGroupItem = this.selectedGroupItemHashMap.get(this.groupings.getAggKey());
            CJRAggsItem selectedAggsItem = getSelectedAggsItem(cJRSelectedGroupItem != null ? cJRSelectedGroupItem.getValue() : null, this.groupings.getAggs());
            while (selectedAggsItem != null) {
                if (!p.a(str, selectedAggsItem.getAggKey(), true)) {
                    if (selectedAggsItem.getAggKey() == null || this.selectedGroupItemHashMap.get(selectedAggsItem.getAggKey()) == null) {
                        break;
                    }
                    CJRSelectedGroupItem cJRSelectedGroupItem2 = this.selectedGroupItemHashMap.get(selectedAggsItem != null ? selectedAggsItem.getAggKey() : null);
                    selectedAggsItem = getSelectedAggsItem(cJRSelectedGroupItem2 != null ? cJRSelectedGroupItem2.getValue() : null, selectedAggsItem != null ? selectedAggsItem.getAggs() : null);
                } else {
                    return selectedAggsItem;
                }
            }
        }
        return null;
    }

    private final CJRAggsItem getSelectedAggsItem(String str, List<CJRAggsItem> list) {
        if (list != null) {
            for (CJRAggsItem cJRAggsItem : list) {
                if (str != null) {
                    if (p.a(str, cJRAggsItem != null ? cJRAggsItem.getValue() : null, true)) {
                        return cJRAggsItem;
                    }
                }
            }
        }
        return null;
    }

    public final CJRNextGroupData getNextGroupItemData() {
        CJRGroupings cJRGroupings = this.groupings;
        if (cJRGroupings != null) {
            Collection aggs = cJRGroupings.getAggs();
            CJRAggsItem cJRAggsItem = ((aggs == null || aggs.isEmpty()) || !p.a(cJRGroupings.getAggs().get(0).getValue(), "N/A", false)) ? null : cJRGroupings.getAggs().get(0);
            while (true) {
                Collection aggs2 = cJRAggsItem != null ? cJRAggsItem.getAggs() : null;
                if (!(aggs2 == null || aggs2.isEmpty())) {
                    if (cJRAggsItem == null) {
                        k.a();
                    }
                    List<CJRAggsItem> aggs3 = cJRAggsItem.getAggs();
                    if (aggs3 == null) {
                        k.a();
                    }
                    if (!p.a(aggs3.get(0).getValue(), "N/A", false)) {
                        break;
                    }
                    List<CJRAggsItem> aggs4 = cJRAggsItem.getAggs();
                    if (aggs4 == null) {
                        k.a();
                    }
                    cJRAggsItem = aggs4.get(0);
                } else {
                    break;
                }
            }
            String aggKey = cJRGroupings.getAggKey();
            if (cJRAggsItem != null) {
                aggKey = cJRAggsItem.getAggKey();
            }
            if (this.selectedGroupItemHashMap.get(aggKey) == null) {
                return getNextValidGroupItemData();
            }
            CJRSelectedGroupItem cJRSelectedGroupItem = this.selectedGroupItemHashMap.get(this.groupings.getAggKey());
            CJRAggsItem selectedAggsItem = getSelectedAggsItem(cJRSelectedGroupItem != null ? cJRSelectedGroupItem.getValue() : null, this.groupings.getAggs());
            if (cJRAggsItem != null) {
                CJRSelectedGroupItem cJRSelectedGroupItem2 = this.selectedGroupItemHashMap.get(cJRAggsItem.getAggKey());
                selectedAggsItem = getSelectedAggsItem(cJRSelectedGroupItem2 != null ? cJRSelectedGroupItem2.getValue() : null, cJRAggsItem.getAggs());
            }
            while (selectedAggsItem != null) {
                while (selectedAggsItem != null) {
                    Collection aggs5 = selectedAggsItem != null ? selectedAggsItem.getAggs() : null;
                    if (!(aggs5 == null || aggs5.isEmpty())) {
                        if (selectedAggsItem == null) {
                            k.a();
                        }
                        List<CJRAggsItem> aggs6 = selectedAggsItem.getAggs();
                        if (aggs6 == null) {
                            k.a();
                        }
                        if (!p.a(aggs6.get(0).getValue(), "N/A", false)) {
                            break;
                        }
                        if (selectedAggsItem == null) {
                            k.a();
                        }
                        List<CJRAggsItem> aggs7 = selectedAggsItem.getAggs();
                        if (aggs7 == null) {
                            k.a();
                        }
                        selectedAggsItem = aggs7.get(0);
                    } else {
                        break;
                    }
                }
                if (this.selectedGroupItemHashMap.get(selectedAggsItem != null ? selectedAggsItem.getAggKey() : null) == null) {
                    return getNextValidGroupItemData(selectedAggsItem);
                }
                CJRSelectedGroupItem cJRSelectedGroupItem3 = this.selectedGroupItemHashMap.get(selectedAggsItem != null ? selectedAggsItem.getAggKey() : null);
                selectedAggsItem = getSelectedAggsItem(cJRSelectedGroupItem3 != null ? cJRSelectedGroupItem3.getValue() : null, selectedAggsItem != null ? selectedAggsItem.getAggs() : null);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
        if (kotlin.m.p.a(r2.get(0).getValue(), "N/A", false) == false) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final net.one97.paytm.recharge.model.v4.CJRNextGroupData getNextValidGroupItemData(net.one97.paytm.recharge.model.v4.CJRAggsItem r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0008
            java.lang.String r1 = r6.getAggKey()
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r1 = r5.getGroupAttributesItemWithName(r1)
            if (r6 == 0) goto L_0x00b1
            java.util.List r2 = r6.getAggs()
            if (r2 == 0) goto L_0x00b1
            int r2 = r2.size()
            r3 = 0
            int r2 = kotlin.g.b.k.a((int) r2, (int) r3)
            if (r2 <= 0) goto L_0x00b1
        L_0x0020:
            if (r6 == 0) goto L_0x0027
            java.util.List r2 = r6.getAggs()
            goto L_0x0028
        L_0x0027:
            r2 = r0
        L_0x0028:
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x0035
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r2 = 0
            goto L_0x0036
        L_0x0035:
            r2 = 1
        L_0x0036:
            if (r2 != 0) goto L_0x0058
            if (r6 != 0) goto L_0x003d
            kotlin.g.b.k.a()
        L_0x003d:
            java.util.List r2 = r6.getAggs()
            if (r2 != 0) goto L_0x0046
            kotlin.g.b.k.a()
        L_0x0046:
            java.lang.Object r2 = r2.get(r3)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r2
            java.lang.String r2 = r2.getValue()
            java.lang.String r4 = "N/A"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)
            if (r2 != 0) goto L_0x0060
        L_0x0058:
            if (r1 == 0) goto L_0x007d
            boolean r1 = r1.showField()
            if (r1 != 0) goto L_0x007d
        L_0x0060:
            if (r6 == 0) goto L_0x006f
            java.util.List r6 = r6.getAggs()
            if (r6 == 0) goto L_0x006f
            java.lang.Object r6 = r6.get(r3)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6
            goto L_0x0070
        L_0x006f:
            r6 = r0
        L_0x0070:
            if (r6 == 0) goto L_0x0077
            java.lang.String r1 = r6.getAggKey()
            goto L_0x0078
        L_0x0077:
            r1 = r0
        L_0x0078:
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r1 = r5.getGroupAttributesItemWithName(r1)
            goto L_0x0020
        L_0x007d:
            if (r6 == 0) goto L_0x00b1
            java.util.List r1 = r6.getAggs()
            if (r1 == 0) goto L_0x00b1
            int r1 = r1.size()
            int r1 = kotlin.g.b.k.a((int) r1, (int) r3)
            if (r1 <= 0) goto L_0x00b1
            net.one97.paytm.recharge.model.v4.CJRNextGroupData r1 = new net.one97.paytm.recharge.model.v4.CJRNextGroupData
            int r2 = r5.groupLevel
            if (r6 == 0) goto L_0x009a
            java.lang.String r3 = r6.getAggKey()
            goto L_0x009b
        L_0x009a:
            r3 = r0
        L_0x009b:
            if (r6 == 0) goto L_0x00a2
            java.lang.String r4 = r6.getAggKey()
            goto L_0x00a3
        L_0x00a2:
            r4 = r0
        L_0x00a3:
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r4 = r5.getGroupAttributesItemWithName(r4)
            if (r6 == 0) goto L_0x00ad
            java.util.List r0 = r6.getAggs()
        L_0x00ad:
            r1.<init>(r2, r3, r4, r0)
            return r1
        L_0x00b1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRCategoryData.getNextValidGroupItemData(net.one97.paytm.recharge.model.v4.CJRAggsItem):net.one97.paytm.recharge.model.v4.CJRNextGroupData");
    }

    private final CJRNextGroupData getNextValidGroupItemData() {
        List<CJRAggsItem> aggs;
        String value;
        CJRGroupings cJRGroupings = this.groupings;
        GroupAttributesItem groupAttributesItemWithName = getGroupAttributesItemWithName(cJRGroupings != null ? cJRGroupings.getAggKey() : null);
        CJRGroupings cJRGroupings2 = this.groupings;
        if (cJRGroupings2 == null || (aggs = cJRGroupings2.getAggs()) == null || k.a(aggs.size(), 0) <= 0 || (value = this.groupings.getAggs().get(0).getValue()) == null) {
            return null;
        }
        if (value.equals("N/A") || (groupAttributesItemWithName != null && !groupAttributesItemWithName.showField())) {
            return getNextValidGroupItemData(this.groupings.getAggs().get(0));
        }
        return new CJRNextGroupData(this.groupLevel, this.groupings.getAggKey(), groupAttributesItemWithName, this.groupings.getAggs());
    }

    private final GroupAttributesItem getGroupAttributesItemWithName(String str) {
        List<GroupAttributesItem> list = this.attributes;
        if (list != null) {
            for (GroupAttributesItem groupAttributesItem : list) {
                if (p.a(groupAttributesItem != null ? groupAttributesItem.getName() : null, str, true)) {
                    return groupAttributesItem;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        r0 = (net.one97.paytm.recharge.model.v4.CJRAggrAttrsItem) (r0 = r2.get(r0)).get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isGroupAPICallRequired() {
        /*
            r4 = this;
            java.util.List<java.util.List<net.one97.paytm.recharge.model.v4.CJRAggrAttrsItem>> r0 = r4.aggrAttrs
            r1 = 0
            if (r0 == 0) goto L_0x0040
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0040
            java.util.List<java.util.List<net.one97.paytm.recharge.model.v4.CJRAggrAttrsItem>> r2 = r4.aggrAttrs
            if (r2 == 0) goto L_0x0040
            r3 = 1
            int r0 = r0 - r3
            java.lang.Object r2 = r2.get(r0)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x0040
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0040
            java.util.List<java.util.List<net.one97.paytm.recharge.model.v4.CJRAggrAttrsItem>> r2 = r4.aggrAttrs
            if (r2 == 0) goto L_0x0038
            java.lang.Object r0 = r2.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0038
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.recharge.model.v4.CJRAggrAttrsItem r0 = (net.one97.paytm.recharge.model.v4.CJRAggrAttrsItem) r0
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = r0.getValue()
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r0 = r4.getGroupAttributesItemWithName(r0)
            if (r0 != 0) goto L_0x0040
            return r3
        L_0x0040:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRCategoryData.isGroupAPICallRequired():boolean");
    }

    public final JSONArray getFilterJSON() {
        JSONArray jSONArray = new JSONArray();
        x.e eVar = new x.e();
        for (CJRSelectedGroupItem cJRSelectedGroupItem : this.selectedGroupItemHashMap.values()) {
            eVar.element = new JSONObject();
            JSONObject jSONObject = (JSONObject) eVar.element;
            if (jSONObject != null) {
                jSONObject.put("key", cJRSelectedGroupItem.getGroupName());
            }
            JSONObject jSONObject2 = (JSONObject) eVar.element;
            if (jSONObject2 != null) {
                jSONObject2.put("value", cJRSelectedGroupItem.getValue());
            }
            jSONArray.put((JSONObject) eVar.element);
        }
        return jSONArray;
    }

    public final String getGroupInputFieldValuesForGA() {
        String str = "";
        for (CJRSelectedGroupItem cJRSelectedGroupItem : this.selectedGroupItemHashMap.values()) {
            if (k.a((Object) str, (Object) "")) {
                str = cJRSelectedGroupItem.getValue();
            } else {
                str = str + "/" + cJRSelectedGroupItem.getValue();
            }
        }
        return str;
    }

    public final String getURLQueryParams() {
        StringBuilder sb = new StringBuilder();
        for (CJRSelectedGroupItem cJRSelectedGroupItem : this.selectedGroupItemHashMap.values()) {
            sb.append(AppConstants.AND_SIGN + URLEncoder.encode(cJRSelectedGroupItem.getGroupName(), AppConstants.UTF_8));
            sb.append("=" + URLEncoder.encode(cJRSelectedGroupItem.getValue(), AppConstants.UTF_8));
        }
        String sb2 = sb.toString();
        k.a((Object) sb2, "queryParams.toString()");
        return sb2;
    }

    public final JSONArray getNextGroupingJSONArray() {
        List<List<CJRAggrAttrsItem>> list;
        String value;
        List<GroupAttributesItem> list2 = this.attributes;
        if (!(list2 == null || list2.size() <= 0 || (list = this.aggrAttrs) == null)) {
            if (list == null) {
                k.a();
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                List<List<CJRAggrAttrsItem>> list3 = this.aggrAttrs;
                if (list3 == null) {
                    k.a();
                }
                List<CJRAggrAttrsItem> list4 = list3.get(i2);
                if (list4 != null) {
                    for (CJRAggrAttrsItem cJRAggrAttrsItem : list4) {
                        if (!(cJRAggrAttrsItem == null || (value = cJRAggrAttrsItem.getValue()) == null)) {
                            GroupAttributesItem groupAttributesItem = this.attributes.get(0);
                            if (value.equals(groupAttributesItem != null ? groupAttributesItem.getName() : null)) {
                                JSONArray jSONArray = new JSONArray();
                                List<List<CJRAggrAttrsItem>> list5 = this.aggrAttrs;
                                if (list5 == null) {
                                    k.a();
                                }
                                List<CJRAggrAttrsItem> list6 = list5.get(i2 + 1);
                                if (list6 != null) {
                                    for (CJRAggrAttrsItem cJRAggrAttrsItem2 : list6) {
                                        jSONArray.put(cJRAggrAttrsItem2 != null ? cJRAggrAttrsItem2.getValue() : null);
                                    }
                                }
                                return jSONArray;
                            }
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public final boolean isRecentsPreFillEnabled() {
        Integer num = this.recentsPrefill;
        return num != null && num.intValue() == 1;
    }

    public final boolean isPreFillFirstRecentEnabled() {
        CJRExtensionAttributes cJRExtensionAttributes = this.extnAttrs;
        return cJRExtensionAttributes != null && cJRExtensionAttributes.isPreFillFirstRecentEnabled();
    }

    public final boolean isGroupPresentInCategory(String str) {
        List<List<CJRAggrAttrsItem>> list;
        CharSequence charSequence = str;
        if (!(charSequence == null || p.a(charSequence)) && (list = this.aggrAttrs) != null) {
            for (List<CJRAggrAttrsItem> list2 : list) {
                if (list2 != null) {
                    for (CJRAggrAttrsItem cJRAggrAttrsItem : list2) {
                        if (p.a(cJRAggrAttrsItem != null ? cJRAggrAttrsItem.getValue() : null, str, true)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    public final String getGAEventCategory() {
        return this.gaKey;
    }

    public final String getGAEventScreenName() {
        return "/" + this.gaKey;
    }
}

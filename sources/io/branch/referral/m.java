package io.branch.referral;

import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiContract;

public final class m {

    public enum a {
        IdentityID("identity_id"),
        Identity("identity"),
        DeviceFingerprintID("device_fingerprint_id"),
        SessionID("session_id"),
        LinkClickID("link_click_id"),
        GoogleSearchInstallReferrer("google_search_install_referrer"),
        GooglePlayInstallReferrer("install_referrer_extras"),
        ClickedReferrerTimeStamp("clicked_referrer_ts"),
        InstallBeginTimeStamp(Payload.INSTALL_BEGIN_TS),
        FaceBookAppLinkChecked("facebook_app_link_checked"),
        BranchLinkUsed("branch_used"),
        ReferringBranchIdentity("referring_branch_identity"),
        BranchIdentity("branch_identity"),
        BranchKey("branch_key"),
        BranchData("branch_data"),
        Bucket("bucket"),
        DefaultBucket("default"),
        Amount("amount"),
        CalculationType("calculation_type"),
        Location("location"),
        Type("type"),
        CreationSource("creation_source"),
        Prefix("prefix"),
        Expiration("expiration"),
        Event(AppConstants.NOTIFICATION_DETAILS.EVENT),
        Metadata("metadata"),
        CommerceData("commerce_data"),
        ReferralCode("referral_code"),
        Total("total"),
        Unique("unique"),
        Length("length"),
        Direction("direction"),
        BeginAfterID("begin_after_id"),
        Link("link"),
        ReferringData("referring_data"),
        ReferringLink("referring_link"),
        IsFullAppConv("is_full_app_conversion"),
        Data("data"),
        OS("os"),
        HardwareID("hardware_id"),
        AndroidID(UpiContract.DeviceInfoColumns.ANDROID_ID),
        UnidentifiedDevice("unidentified_device"),
        HardwareIDType("hardware_id_type"),
        HardwareIDTypeVendor("vendor_id"),
        HardwareIDTypeRandom("random"),
        IsHardwareIDReal("is_hardware_id_real"),
        AppVersion("app_version"),
        APILevel("os_version"),
        Country(AddEditGstinViewModelKt.BODY_PARAM_COUNTRY),
        Language("language"),
        IsReferrable("is_referrable"),
        Update("update"),
        OriginalInstallTime("first_install_time"),
        FirstInstallTime("latest_install_time"),
        LastUpdateTime("latest_update_time"),
        PreviousUpdateTime("previous_update_time"),
        URIScheme("uri_scheme"),
        AppLinks("app_links"),
        AppIdentifier("app_identifier"),
        LinkIdentifier("link_identifier"),
        GoogleAdvertisingID("google_advertising_id"),
        AAID("aaid"),
        FireAdId("fire_ad_id"),
        LATVal("lat_val"),
        LimitedAdTracking("limit_ad_tracking"),
        limitFacebookTracking("limit_facebook_tracking"),
        Debug("debug"),
        Brand(CLPConstants.BRAND_PARAMS),
        Model("model"),
        ScreenDpi("screen_dpi"),
        ScreenHeight("screen_height"),
        ScreenWidth("screen_width"),
        WiFi("wifi"),
        LocalIP("local_ip"),
        UserData("user_data"),
        AdvertisingIDs("advertising_ids"),
        DeveloperIdentity("developer_identity"),
        UserAgent("user_agent"),
        SDK("sdk"),
        SdkVersion(com.paytm.notification.data.datasource.a.f43086g),
        UIMode("ui_mode"),
        InstallMetadata("install_metadata"),
        LATDAttributionWindow("attribution_window"),
        Clicked_Branch_Link("+clicked_branch_link"),
        IsFirstSession("+is_first_session"),
        AndroidDeepLinkPath("$android_deeplink_path"),
        DeepLinkPath("$deeplink_path"),
        AndroidAppLinkURL("android_app_link_url"),
        AndroidPushNotificationKey("branch"),
        AndroidPushIdentifier("push_identifier"),
        ForceNewBranchSession("branch_force_new_session"),
        CanonicalIdentifier("$canonical_identifier"),
        ContentTitle("$og_title"),
        ContentDesc("$og_description"),
        ContentImgUrl("$og_image_url"),
        CanonicalUrl("$canonical_url"),
        ContentType("$content_type"),
        PublicallyIndexable("$publicly_indexable"),
        LocallyIndexable("$locally_indexable"),
        ContentKeyWords("$keywords"),
        ContentExpiryTime("$exp_date"),
        Params("params"),
        SharedLink("$shared_link"),
        ShareError("$share_error"),
        External_Intent_URI("external_intent_uri"),
        External_Intent_Extra("external_intent_extra"),
        Last_Round_Trip_Time("lrtt"),
        Branch_Round_Trip_Time("brtt"),
        Branch_Instrumentation("instrumentation"),
        Queue_Wait_Time("qwt"),
        InstantDeepLinkSession("instant_dl_session"),
        BranchViewData("branch_view_data"),
        BranchViewID("id"),
        BranchViewAction("action"),
        BranchViewNumOfUse("number_of_use"),
        BranchViewUrl("url"),
        BranchViewHtml("html"),
        Path(H5TabbarUtils.MATCH_TYPE_PATH),
        ViewList("view_list"),
        ContentActionView("view"),
        ContentPath("content_path"),
        ContentNavPath("content_nav_path"),
        ReferralLink("referral_link"),
        ContentData("content_data"),
        ContentEvents(EventsModuleManager.MODULE_NAME),
        ContentAnalyticsMode("content_analytics_mode"),
        ContentDiscovery(H5Param.CAN_DESTROY),
        Environment("environment"),
        InstantApp("INSTANT_APP"),
        NativeApp("FULL_APP"),
        CustomerEventAlias("customer_event_alias"),
        TransactionID(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID),
        Currency("currency"),
        Revenue("revenue"),
        Shipping("shipping"),
        Tax("tax"),
        Coupon("coupon"),
        Affiliation("affiliation"),
        Description(RequestConfirmationDialogFragment.KEY_DESCRIPTION),
        SearchQuery(StringSet.search_query),
        AdType("ad_type"),
        CPUType("cpu_type"),
        DeviceBuildId("build"),
        Locale(ContactsConstant.LOCALE),
        ConnectionType("connection_type"),
        DeviceCarrier("device_carrier"),
        PluginType("plugin_type"),
        PluginVersion("plugin_version"),
        OSVersionAndroid("os_version_android"),
        Name("name"),
        CustomData("custom_data"),
        EventData("event_data"),
        ContentItems("content_items"),
        ContentSchema("$content_schema"),
        Price("$price"),
        PriceCurrency("$currency"),
        Quantity("$quantity"),
        SKU("$sku"),
        ProductName("$product_name"),
        ProductBrand("$product_brand"),
        ProductCategory("$product_category"),
        ProductVariant("$product_variant"),
        Rating("$rating"),
        RatingAverage("$rating_average"),
        RatingCount("$rating_count"),
        RatingMax("$rating_max"),
        AddressStreet("$address_street"),
        AddressCity("$address_city"),
        AddressRegion("$address_region"),
        AddressCountry("$address_country"),
        AddressPostalCode("$address_postal_code"),
        Latitude("$latitude"),
        Longitude("$longitude"),
        ImageCaptions("$image_captions"),
        Condition("$condition"),
        CreationTimestamp("$creation_timestamp"),
        TrackingDisabled("tracking_disabled"),
        Instant(Payload.INSTANT);
        
        private String key;

        private a(String str) {
            this.key = "";
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }

        public final String toString() {
            return this.key;
        }
    }

    public enum d {
        RedeemRewards("v1/redeem"),
        GetURL("v1/url"),
        GetApp("v1/app-link-settings"),
        RegisterInstall("v1/install"),
        RegisterClose("v1/close"),
        RegisterOpen("v1/open"),
        GetCredits("v1/credits/"),
        GetCreditHistory("v1/credithistory"),
        CompletedAction("v1/event"),
        IdentifyUser("v1/profile"),
        Logout("v1/logout"),
        ContentEvent("v1/content-events"),
        TrackStandardEvent("v2/event/standard"),
        TrackCustomEvent("v2/event/custom"),
        GetCPID("v1/cpid"),
        GetLATD("v1/cpid/latd");
        
        private String key;

        private d(String str) {
            this.key = "";
            this.key = str;
        }

        public final String getPath() {
            return this.key;
        }

        public final String toString() {
            return this.key;
        }
    }

    public enum b {
        Tags("tags"),
        Alias("alias"),
        Type("type"),
        Duration(AppConstants.DURATION),
        Channel("channel"),
        Feature("feature"),
        Stage("stage"),
        Campaign("campaign"),
        Data("data"),
        URL("url");
        
        private String key;

        private b(String str) {
            this.key = "";
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }

        public final String toString() {
            return this.key;
        }
    }

    public enum c {
        imei("imei");
        
        private String key;

        private c(String str) {
            this.key = "";
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }

        public final String toString() {
            return this.key;
        }
    }
}

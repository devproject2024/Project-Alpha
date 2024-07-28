package net.one97.paytm.deeplink;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.kych5.b.a;
import net.one97.paytm.upgradeKyc.activity.AJRNonKYCDeeplink;
import net.one97.paytm.upgradeKyc.activity.AadharUpdateActivity;
import net.one97.paytm.upgradeKyc.activity.BankProfileActivity;
import net.one97.paytm.upgradeKyc.activity.InPersonVerification;
import net.one97.paytm.upgradeKyc.activity.TransparentActivity;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity;
import net.one97.paytm.upgradeKyc.activity.VerifyDocActivity;
import net.one97.paytm.upgradeKyc.videokyc.activity.VideoKycActivity;
import net.one97.paytm.upgradeKyc.videokyc.activity.VideoKycChatStatusActivity;
import net.one97.paytm.utils.ag;
import net.one97.paytm.wallet.newdesign.nearby.NearByMainActivity;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final v f50378a = new v();

    private v() {
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (context instanceof Activity) {
            boolean z = false;
            if (p.a(deepLinkData.f50284b, "kyc_module", false)) {
                if (p.a(deepLinkData.f50288f, "ca-update", false)) {
                    u.a();
                    Context appContext = CJRJarvisApplication.getAppContext();
                    if (appContext != null) {
                        u.a((Application) appContext);
                        a aVar = a.f51045a;
                        a.a(context);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.app.Application");
                } else if (p.a(deepLinkData.f50288f, "fraud_redressal", false)) {
                    u.a();
                    Context appContext2 = CJRJarvisApplication.getAppContext();
                    if (appContext2 != null) {
                        u.a((Application) appContext2);
                        a aVar2 = a.f51045a;
                        a.a(context, deepLinkData);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.app.Application");
                }
            }
            Intent intent = new Intent();
            if (p.a(deepLinkData.f50284b, "upgrade_wallet", false)) {
                k.a((Object) intent.setClass(context, UpgradeKycActivity.class), "intent.setClass(context,…eKycActivity::class.java)");
            } else if (p.a(deepLinkData.f50284b, "add_pan", false)) {
                intent.putExtra("kyc_pan_deeplink", true);
                k.a((Object) intent.setClass(context, AJRNonKYCDeeplink.class), "intent.setClass(context,…nKYCDeeplink::class.java)");
            } else if (p.a(deepLinkData.f50284b, "min_kyc", false)) {
                intent.setClass(context, VerifyDocActivity.class);
                if (deepLinkData.f50288f != null && p.a(deepLinkData.f50288f, "popup", false)) {
                    intent.setClass(context, TransparentActivity.class);
                }
                if (deepLinkData.f50283a != null) {
                    String str = deepLinkData.f50283a;
                    if (str == null) {
                        k.a();
                    }
                    if (p.a((CharSequence) str, (CharSequence) "callbackDl", false)) {
                        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
                        String str2 = deepLinkData.f50283a;
                        if (str2 == null) {
                            k.a();
                        }
                        Uri parse = Uri.parse(p.a(str2, '$', '&'));
                        String str3 = null;
                        if (!(parse == null || parse == null)) {
                            str3 = parse.getQueryParameter("callbackDl");
                        }
                        cJRHomePageItem.setCallBackUrl(str3);
                        intent.putExtra("extra_home_data", cJRHomePageItem);
                    }
                }
                if (deepLinkData.f50288f != null && p.a(deepLinkData.f50288f, "onboarding", false)) {
                    if (!a(context)) {
                        Activity activity = (Activity) context;
                        Intent intent2 = new Intent(activity, VerifyDocActivity.class);
                        intent2.putExtra("is_from_onboarding_flow", true);
                        activity.startActivityForResult(intent2, 2002);
                        return;
                    }
                    return;
                }
            } else if (p.a(deepLinkData.f50284b, "nearby", false)) {
                intent.setClass(context, NearByMainActivity.class);
                if (deepLinkData.f50288f != null && p.a(deepLinkData.f50288f, "FASTag", false)) {
                    z = true;
                }
                intent.putExtra("isForFastTag", z);
            } else if (p.a(deepLinkData.f50284b, "add_aadhaar", false)) {
                intent.setClass(context, AadharUpdateActivity.class);
            } else if (!p.a(deepLinkData.f50284b, "upgrade_kyc", false) || !p.a(deepLinkData.f50288f, "aotp", false)) {
                if (!p.a(deepLinkData.f50284b, "bank_profile", false)) {
                    if (p.a(deepLinkData.f50284b, "video_kyc", false) && deepLinkData.f50288f != null) {
                        String str4 = deepLinkData.f50288f;
                        if (str4 != null) {
                            switch (str4.hashCode()) {
                                case -1281977283:
                                    if (str4.equals("failed")) {
                                        intent.setClass(context, VideoKycChatStatusActivity.class);
                                        intent.putExtra("video_kyc_status", "failed");
                                        break;
                                    }
                                    break;
                                case 348678395:
                                    if (str4.equals("submitted")) {
                                        intent.setClass(context, VideoKycChatStatusActivity.class);
                                        intent.putExtra("video_kyc_status", "submitted");
                                        break;
                                    }
                                    break;
                                case 1325712544:
                                    if (str4.equals("proceed_video_kyc")) {
                                        intent.setClass(context, VideoKycActivity.class);
                                        break;
                                    }
                                    break;
                                case 1701013372:
                                    if (str4.equals("proceed_video_kyc_internal")) {
                                        intent.setClass(context, VideoKycActivity.class);
                                        intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
                                        break;
                                    }
                                    break;
                                case 1907236282:
                                    if (str4.equals("cst_priority_customerV2")) {
                                        intent.setClass(context, UpgradeKycActivity.class);
                                        intent.putExtra("isCstPriorityCustomer", true);
                                        break;
                                    }
                                    break;
                            }
                        }
                    } else {
                        intent.setClass(context, UpgradeKycActivity.class);
                    }
                } else {
                    intent.setClass(context, BankProfileActivity.class);
                }
            } else {
                intent.setClass(context, InPersonVerification.class);
            }
            context.startActivity(intent);
        }
    }

    public static boolean a(Context context) {
        k.c(context, "context");
        ag.a aVar = ag.f69605a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        return ag.a.a(applicationContext).b("is_min_kyc", false, true);
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50284b, "upgrade_kyc", false) || p.a(deepLinkData.f50284b, "upgrade_wallet", false) || p.a(deepLinkData.f50284b, "add_pan", false) || p.a(deepLinkData.f50284b, "min_kyc", false) || p.a(deepLinkData.f50284b, "nearby", false) || p.a(deepLinkData.f50284b, "add_aadhaar", false) || p.a(deepLinkData.f50284b, "video_kyc", false) || p.a(deepLinkData.f50284b, "bank_profile", false) || p.a(deepLinkData.f50284b, "kyc_module", false)) {
            return true;
        }
        return false;
    }
}

package net.one97.paytm.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;
import net.one97.paytm.wallet.newdesign.postcard.MyPostcardAnimationActivity;
import net.one97.paytm.wallet.newdesign.postcard.PostCardMainActivity;
import net.one97.paytm.wallet.p2p.P2PReferShopActivity;
import net.one97.paytm.wallet.splitbill.activity.SBLandingPageActivity;
import net.one97.paytm.wallet.utility.a;

public final class bc {
    private static boolean a(String str, DeepLinkData deepLinkData) {
        Uri parse;
        if (str == null || str.length() == 0 || !UpiConstants.URL_TYPE_CASH_WALLET.equalsIgnoreCase(deepLinkData.f50284b) || (parse = Uri.parse(str)) == null || !"contact_search".equalsIgnoreCase(parse.getQueryParameter("featuretype")) || !UpiConstants.WALLET_TYPE_MONEY_TRANSFER.equalsIgnoreCase(parse.getQueryParameter("type"))) {
            return false;
        }
        return true;
    }

    private static boolean b(String str, DeepLinkData deepLinkData) {
        Uri parse;
        if (str == null || str.length() == 0 || !UpiConstants.URL_TYPE_CASH_WALLET.equalsIgnoreCase(deepLinkData.f50284b) || (parse = Uri.parse(str)) == null || !"contact_search".equalsIgnoreCase(parse.getQueryParameter("featuretype")) || !"viewAll".equalsIgnoreCase(parse.getQueryParameter("type"))) {
            return false;
        }
        return true;
    }

    private static void a(Context context, String str) {
        CJRHomePageItem deeplinkDataItem = b.a().getDeeplinkDataItem(context, str);
        if (TextUtils.isEmpty(deeplinkDataItem.getFeatureType()) || !deeplinkDataItem.getFeatureType().equalsIgnoreCase("claimLifafa")) {
            if (!TextUtils.isEmpty(b.a().getWalletSSOToken(context))) {
                Intent intent = new Intent(context, MyPostcardAnimationActivity.class);
                intent.putExtra("from_deep_link", true);
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(context, b.a().getAuthActivityClass());
            intent2.putExtra("resultant activity", PostCardMainActivity.class.getName());
            Bundle bundle = new Bundle();
            bundle.putSerializable("extra_home_data", deeplinkDataItem);
            bundle.putString("origin", "deeplinking");
            intent2.putExtra("resultant activity_bundle", bundle);
            context.startActivity(intent2);
        } else if (!TextUtils.isEmpty(b.a().getWalletSSOToken(context))) {
            Intent intent3 = new Intent(context, MyPostcardAnimationActivity.class);
            intent3.putExtra("from_deep_link", true);
            intent3.putExtra("lifafa_key", deeplinkDataItem.getLifafaId());
            context.startActivity(intent3);
        } else {
            Intent intent4 = new Intent(context, b.a().getAuthActivityClass());
            intent4.putExtra("resultant activity", MyPostcardAnimationActivity.class.getName());
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("extra_home_data", deeplinkDataItem);
            bundle2.putString("origin", "deeplinking");
            intent4.putExtra("resultant activity_bundle", bundle2);
            context.startActivity(intent4);
        }
    }

    public static boolean a(DeepLinkData deepLinkData) {
        return UpiConstants.URL_TYPE_CASH_WALLET.equalsIgnoreCase(deepLinkData.f50284b) || "link_payment".equalsIgnoreCase(deepLinkData.f50284b) || "split_bill".equalsIgnoreCase(deepLinkData.f50284b) || "scan_pay".equalsIgnoreCase(deepLinkData.f50284b) || "lifafa".equalsIgnoreCase(deepLinkData.f50284b) || a.q(deepLinkData.f50283a) || "refer_merchant".equalsIgnoreCase(deepLinkData.f50284b);
    }

    public static void a(Context context, String str, DeepLinkData deepLinkData) {
        Intent intent;
        if (UpiConstants.URL_TYPE_CASH_WALLET.equalsIgnoreCase(deepLinkData.f50284b) || "scan_pay".equalsIgnoreCase(deepLinkData.f50284b)) {
            if (a(str, deepLinkData)) {
                e eVar = e.f50261a;
                intent = e.a(context, e.c.MT.getType());
            } else if (b(str, deepLinkData)) {
                e eVar2 = e.f50261a;
                intent = e.a(context, e.c.VIEWALL.getType());
            } else {
                Intent intent2 = new Intent(context, PaySendActivityV2.class);
                if (!(deepLinkData == null || deepLinkData.f50290h == null)) {
                    intent2.putExtra("isFromScan", deepLinkData.f50290h.getBoolean("isFromScan", false));
                }
                intent2.putExtra("isFromDeeplink", true);
                intent = intent2;
            }
        } else if ("link_payment".equalsIgnoreCase(deepLinkData.f50284b)) {
            intent = new Intent(context, AJRQRActivity.class);
        } else if ("lifafa".equalsIgnoreCase(deepLinkData.f50284b)) {
            a(context, str);
            return;
        } else if ("split_bill".equalsIgnoreCase(deepLinkData.f50284b)) {
            Intent intent3 = new Intent(context, SBLandingPageActivity.class);
            intent3.addFlags(268435456);
            Bundle o = a.o(str);
            if (o != null) {
                intent3.putExtras(o);
            }
            context.startActivity(intent3);
            ArrayList arrayList = new ArrayList();
            arrayList.add("deepLink");
            net.one97.paytm.wallet.splitbill.e.b.a(context, "split_bill", "splitbill_home", arrayList, "", "deeplink", "split_bill");
            return;
        } else if (a.q(str)) {
            intent = new Intent(context, PaySendActivityV2.class);
            intent.putExtra("showTagline", true);
        } else {
            intent = "refer_merchant".equalsIgnoreCase(deepLinkData.f50284b) ? new Intent(context, P2PReferShopActivity.class) : null;
        }
        if (intent != null) {
            CJRHomePageItem deeplinkDataItem = b.a().getDeeplinkDataItem(context, str);
            intent.addFlags(268435456);
            intent.putExtra("extra_home_data", deeplinkDataItem);
            context.startActivity(intent);
            return;
        }
        q.b("intent is null in WalletDeepLinkHandler.handleDeepLink");
    }
}

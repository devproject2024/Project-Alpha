package net.one97.paytm.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.paytm_finance.R;

public final class f {

    public static final class a extends l implements m<String, Integer, x> {
        final /* synthetic */ Activity $activity$inlined;
        final /* synthetic */ Uri $uri;
        final /* synthetic */ String $uriString$inlined;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Uri uri, String str, Activity activity) {
            super(2);
            this.$uri = uri;
            this.$uriString$inlined = str;
            this.$activity$inlined = activity;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((String) obj, ((Number) obj2).intValue());
            return x.f47997a;
        }

        public final void invoke(String str, int i2) {
            String str2;
            k.c(str, "url");
            Uri uri = this.$uri;
            Activity activity = this.$activity$inlined;
            String queryParameter = uri.getQueryParameter(RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            if (queryParameter == null) {
                Object[] objArr = new Object[1];
                String queryParameter2 = uri.getQueryParameter("campaignDisplayName");
                if (queryParameter2 == null) {
                    queryParameter2 = "offer";
                }
                objArr[0] = queryParameter2;
                queryParameter = activity.getString(R.string.branch_share_message, objArr);
                k.a((Object) queryParameter, "activity.getString(R.str…DISPLAY_NAME) ?: \"offer\")");
            }
            String queryParameter3 = this.$uri.getQueryParameter("title");
            String str3 = queryParameter + ' ';
            if (Build.VERSION.SDK_INT >= 24) {
                str2 = str3 + Html.fromHtml(str, 0).toString();
            } else {
                str2 = str3 + Html.fromHtml(str).toString();
            }
            Activity activity2 = this.$activity$inlined;
            k.c(activity2, "actvity");
            k.c(str2, "context");
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str2);
            intent.putExtra("android.intent.extra.SUBJECT", queryParameter3);
            activity2.startActivity(Intent.createChooser(intent, "Share via"));
        }
    }
}

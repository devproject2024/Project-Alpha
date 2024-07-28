package net.one97.paytm.dynamic.module.feed;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.j;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.AJRProfileActivity;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.deeplink.m;
import net.one97.paytm.feed.e.a;
import net.one97.paytm.feed.ui.feed.f;
import net.one97.paytm.feed.ui.feed.sheroes.SheroesActivity;
import net.one97.paytm.feed.ui.feed.sheroes.b;
import net.one97.paytm.j.c;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.t;

public final class InboxFeedHelper implements a, f, b {
    public static final InboxFeedHelper INSTANCE = new InboxFeedHelper();
    private static final String SCREEN_NAME = "feed";
    private static final String SHEROES_TPI_CLIENT_ID = "tpi_client_id";
    private static final c gtmLoader;
    /* access modifiers changed from: private */
    public static boolean isSheroesNetworkApiInProcess;

    public final void collapseAppBar() {
    }

    public final void onFeedTabSelect(String str, String str2) {
        k.c(str, "actionName");
        k.c(str2, "eventLabel");
    }

    public final void onScrollToTop() {
    }

    public final void onUserLoggedIn(Context context) {
        k.c(context, "context");
    }

    static {
        c a2 = c.a();
        k.a((Object) a2, "GTMLoader.getInstance()");
        gtmLoader = a2;
    }

    private InboxFeedHelper() {
    }

    public final void getFragment(Context context, SheroesActivity.c cVar) {
        k.c(context, "context");
        k.c(cVar, "listener");
        loginSheroes(context, cVar);
    }

    public final void loginSheroes(Context context, SheroesActivity.c cVar) {
        k.c(context, "context");
        k.c(cVar, "listener");
        if (!SheroesSdk.isInitialized()) {
            return;
        }
        if (!SheroesSdk.isLoggedInUser()) {
            getFeedCreadentials(context, cVar);
        } else {
            cVar.getSheroesFragment(SheroesSdk.getFeedFragment());
        }
    }

    private final void getFeedCreadentials(Context context, SheroesActivity.c cVar) {
        if (!isSheroesNetworkApiInProcess) {
            isSheroesNetworkApiInProcess = true;
            String Q = c.Q();
            Map hashMap = new HashMap();
            String m = com.paytm.utility.b.m();
            k.a((Object) m, "CJRAppCommonUtility.getAuthorizationValue()");
            hashMap.put("Authorization", m);
            hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
            hashMap.put(SHEROES_TPI_CLIENT_ID, BuildConfig.SHEROES_CLIENT);
            String b2 = t.b(context);
            k.a((Object) b2, "CJRServerUtility.getSSOToken(context)");
            hashMap.put("session_token", b2);
            com.paytm.network.a l = new com.paytm.network.b().a(context).a(a.c.INBOX).a(a.b.SILENT).c(SCREEN_NAME).a(a.C0715a.GET).a(Q).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new SheroesAuthModel()).a((com.paytm.network.listener.b) new InboxFeedHelper$getFeedCreadentials$networking$1(cVar)).l();
            l.b(true);
            l.a();
        }
    }

    public final void expandAppBar() {
        m mVar = m.f50358c;
        m.b();
    }

    public final void getUserData(Context context) {
        k.c(context, "context");
        InboxFeedDataProvider.INSTANCE.loadInboxDataFromGTM(context);
    }

    public final void onDispatchDeeplink(Context context, String str) {
        k.c(context, "context");
        k.c(str, "deepLinkUrl");
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public final void onLoginLinkify(Context context) {
        k.c(context, "context");
        Intent intent = new Intent(context, AJRAuthActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public final void onEditProfileClicked(Context context) {
        k.c(context, "context");
        Intent intent = new Intent(context, AJRProfileActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public final void onFeedTabSelect(int i2) {
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.c(i2);
    }

    public final void onMovedToInbox(Context context, boolean z, j jVar) {
        k.c(context, "context");
        k.c(jVar, "childFragmentMaanger");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.a(context, z, jVar);
    }

    public final void sendEvent(Context context, Map<String, ? extends Object> map) {
        k.c(context, "context");
        k.c(map, Item.CTA_URL_TYPE_MAP);
        net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, (Map<String, Object>) map, context);
    }

    public final void loadH5Container(Context context, String str, String str2, String str3) {
        k.c(context, "context");
        k.c(str, "deepLinkUrl");
        k.c(str2, "matchId");
        k.c(str3, "postId");
        m mVar = m.f50358c;
        m.a(context, str, str2, str3);
    }

    public final void loadH5Container(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "deepLinkUrl");
        k.c(str2, H5Param.SESSION_ID);
        m mVar = m.f50358c;
        m.a(context, str, str2);
    }

    public final void logOutSheroes() {
        try {
            SheroesSdk.logOut();
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }
}

package net.one97.paytm.dynamic.module.feed;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.paytm.utility.a;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.feed.e.b;
import net.one97.paytm.feed.repository.models.Category;
import net.one97.paytm.feed.ui.feed.FeedFragment;
import net.one97.paytm.feed.ui.feed.f;
import net.one97.paytm.feed.ui.feed.sheroes.SheroesActivity;
import net.one97.paytm.j.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.utils.n;
import net.one97.paytm.utils.t;

public final class InboxFeedDataProvider {
    public static final InboxFeedDataProvider INSTANCE = new InboxFeedDataProvider();
    private static String KEY_FEED_TAB_VIDEO_URL = "feed_video_url";
    private static String SHEROES_API_KEY;
    private static boolean isInitCalled;
    private static SwitchObservable switchTab = new SwitchObservable();

    static {
        String str = n.f69767a;
        try {
            if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
                str = "R9qekT4ew0nwjdW1rzXwDLS4rP2xIRNywkcv2muXKyqp1jyPCq";
            }
        } catch (Exception unused) {
        }
        SHEROES_API_KEY = str;
    }

    private InboxFeedDataProvider() {
    }

    public final String getKEY_FEED_TAB_VIDEO_URL() {
        return KEY_FEED_TAB_VIDEO_URL;
    }

    public final void setKEY_FEED_TAB_VIDEO_URL(String str) {
        k.c(str, "<set-?>");
        KEY_FEED_TAB_VIDEO_URL = str;
    }

    public final SwitchObservable getSwitchTab() {
        return switchTab;
    }

    public final void setSwitchTab(SwitchObservable switchObservable) {
        k.c(switchObservable, "<set-?>");
        switchTab = switchObservable;
    }

    public final boolean isInitCalled() {
        return isInitCalled;
    }

    public final void setInitCalled(boolean z) {
        isInitCalled = z;
    }

    public final String getSHEROES_API_KEY() {
        return SHEROES_API_KEY;
    }

    public final void setSHEROES_API_KEY(String str) {
        k.c(str, "<set-?>");
        SHEROES_API_KEY = str;
    }

    public final void loadInboxDataFromGTM(Context context) {
        k.c(context, "context");
        b.f34268c.a(context, getUserInfo(context));
    }

    private final Map<String, String> getUserInfo(Context context) {
        HashMap hashMap = new HashMap();
        k.a((Object) c.a(), "GTMLoader.getInstance()");
        hashMap.put("categories", c.T());
        k.a((Object) c.a(), "GTMLoader.getInstance()");
        hashMap.put("post_flags", c.U());
        k.a((Object) c.a(), "GTMLoader.getInstance()");
        hashMap.put("comment_flags", c.V());
        hashMap.put("cust_id", a.a(context));
        hashMap.put("name", com.paytm.utility.b.aa(context));
        hashMap.put(StringSet.token, t.b(context));
        hashMap.put("avatar", com.paytm.utility.b.al(context));
        hashMap.put("gender", com.paytm.utility.b.ae(context));
        hashMap.put("mobile", a.b(context));
        hashMap.put("latitude", a.g(context));
        hashMap.put("longitude", a.h(context));
        c.a();
        hashMap.put("merchant_action_url", c.X());
        k.a((Object) c.a(), "GTMLoader.getInstance()");
        hashMap.put("feed_sheroes_login", String.valueOf(c.ab()));
        c.a();
        hashMap.put("base_url", c.W());
        String str = KEY_FEED_TAB_VIDEO_URL;
        c.a();
        hashMap.put(str, c.Y());
        if (TextUtils.isEmpty(a.i(context))) {
            hashMap.put("paytm_app_lang", "EN");
        } else {
            String i2 = a.i(context);
            k.a((Object) i2, "ApplaunchUtility.getAppLanguage(context)");
            if (i2 != null) {
                String upperCase = i2.toUpperCase();
                k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                hashMap.put("paytm_app_lang", upperCase);
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        return hashMap;
    }

    public final void sendLogoutEventToInbox() {
        b bVar = b.f34268c;
        b.w();
    }

    public final void sendLoginEventToInbox(Context context) {
        k.c(context, "context");
        b bVar = b.f34268c;
        b.a(getUserInfo(context), context);
    }

    public final void onUserProfileUpdate(Context context) {
        k.c(context, "context");
        b bVar = b.f34268c;
        b.a(getUserInfo(context));
    }

    public final boolean isFeedDeeplink(String str) {
        k.c(str, "urlType");
        b bVar = b.f34268c;
        return b.b(str);
    }

    public final void openDeepLinkActivity(Context context, String str) {
        k.c(context, "context");
        k.c(str, "url");
        b bVar = b.f34268c;
        b.b(context, str);
    }

    public final void openSheroes(Context context) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (!(applicationContext instanceof Application)) {
                    applicationContext = null;
                }
                Application application = (Application) applicationContext;
                if (application != null) {
                    INSTANCE.initFeedModule(application);
                }
                INSTANCE.initSheroes(context);
                Intent intent = new Intent(context, SheroesActivity.class);
                intent.addFlags(536870912);
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public final Object canOpenDeepLink(String str) {
        return str != null ? Boolean.valueOf(p.a(str, "inbox", true)) : Boolean.FALSE;
    }

    public final void switchToInboxtab(String str) {
        k.c(str, "deepLinkUrl");
        switchTab.setValue(str);
    }

    public final boolean initFeedModule(Application application) {
        k.c(application, "application");
        try {
            if (isInitCalled) {
                return isInitCalled;
            }
            b.f34268c.a(application);
            b.f34268c.a((net.one97.paytm.feed.ui.feed.sheroes.b) InboxFeedHelper.INSTANCE, (f) InboxFeedHelper.INSTANCE, (net.one97.paytm.feed.e.a) InboxFeedHelper.INSTANCE);
            net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
            net.one97.paytm.feed.repository.b.a(application.getApplicationContext());
            Context applicationContext = application.getApplicationContext();
            k.a((Object) applicationContext, "application.applicationContext");
            lateInitFeedModule(applicationContext);
            isInitCalled = true;
            return true;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return isInitCalled;
        } catch (NoClassDefFoundError e3) {
            q.b(e3.getMessage());
            return isInitCalled;
        }
    }

    public final void initSheroes(Context context) {
        k.c(context, "context");
        SheroesSdk.sdkInitialize(context.getApplicationContext(), SHEROES_API_KEY, InboxFeedDataProvider$initSheroes$1.INSTANCE, new InboxFeedDataProvider$initSheroes$2(context));
    }

    public final Fragment getFeedFragment() {
        FeedFragment.a aVar = FeedFragment.f34877i;
        return FeedFragment.a.a((Bundle) null);
    }

    public final Fragment getFollowingFragment() {
        FeedFragment.a aVar = FeedFragment.f34877i;
        String b2 = FeedFragment.a.b();
        FeedFragment.a aVar2 = FeedFragment.f34877i;
        Category category = new Category(b2, FeedFragment.a.b(), "", "");
        Bundle bundle = new Bundle();
        FeedFragment.a aVar3 = FeedFragment.f34877i;
        bundle.putParcelable(FeedFragment.a.a(), category);
        FeedFragment.a aVar4 = FeedFragment.f34877i;
        return FeedFragment.a.a(bundle);
    }

    public final void lateInitFeedModule(Context context) {
        k.c(context, "context");
        b bVar = b.f34268c;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        Context applicationContext2 = context.getApplicationContext();
        k.a((Object) applicationContext2, "context.applicationContext");
        bVar.a(applicationContext, getUserInfo(applicationContext2));
    }

    public final void sendGA(String str) {
        k.c(str, "eventName");
        net.one97.paytm.feed.events.a.a aVar = net.one97.paytm.feed.events.a.a.f34296a;
        net.one97.paytm.feed.events.a.a.a(str, "");
    }

    public static final class SwitchObservable extends Observable {
        private String name = "Observable";

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            k.c(str, "<set-?>");
            this.name = str;
        }

        public final void setValue(String str) {
            setChanged();
            notifyObservers(str);
        }
    }

    public final void onFollowingOpen(Context context) {
        k.c(context, "context");
        b bVar = b.f34268c;
        b.e(context);
    }

    public final void onBookmarkOpen(Context context) {
        k.c(context, "context");
        b bVar = b.f34268c;
        b.f(context);
    }

    public final void onLanguageOpen(Context context) {
        k.c(context, "context");
        b bVar = b.f34268c;
        b.d(context);
    }
}

package net.one97.paytm.dynamic.module.feed;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.deeplink.m;

public final class FeedModuleManager implements m.a {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "FeedModuleManager";

    public final void init() {
    }

    public final void init(Application application) {
        k.c(application, "application");
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    static {
        m mVar = m.f50358c;
        m.a((m.a) new FeedModuleManager());
    }

    public final void logOutSheroes() {
        InboxFeedHelper.INSTANCE.logOutSheroes();
    }

    public final void openProfileScreen(Context context) {
        k.c(context, "context");
        InboxFeedDataProvider.INSTANCE.onLanguageOpen(context);
    }

    public final void openDeepLinkActivity(Context context, String str) {
        k.c(context, "context");
        k.c(str, "deeplink");
        InboxFeedDataProvider.INSTANCE.openDeepLinkActivity(context, str);
    }

    public final void onUserProfileUpdate(Context context) {
        k.c(context, "context");
        InboxFeedDataProvider.INSTANCE.onUserProfileUpdate(context);
    }

    public final void onTabSwitched(Context context, int i2) {
        k.c(context, "context");
        InboxFeedHelper.INSTANCE.onFeedTabSelect(i2);
    }

    public final void onTabSwitched(Context context, boolean z, j jVar) {
        k.c(context, "context");
        k.c(jVar, "childFragmentManager");
        InboxFeedHelper.INSTANCE.onMovedToInbox(context, z, jVar);
    }

    public final void onUserLoggedIn(Context context) {
        k.c(context, "context");
        InboxFeedDataProvider.INSTANCE.sendLoginEventToInbox(context);
    }

    public final void onUserLoggedOut() {
        InboxFeedDataProvider.INSTANCE.sendLogoutEventToInbox();
    }

    public final void initInbox(Application application) {
        k.c(application, "application");
        InboxFeedDataProvider.INSTANCE.initFeedModule(application);
    }

    public final void lateInitInbox(Context context) {
        k.c(context, "context");
        InboxFeedDataProvider.INSTANCE.lateInitFeedModule(context);
    }

    public final void sendGaEvent(Context context, String str) {
        k.c(context, "context");
        k.c(str, "eventName");
        InboxFeedDataProvider.INSTANCE.sendGA(str);
    }

    public final void openFollowingScreen(Context context) {
        k.c(context, "context");
        InboxFeedDataProvider.INSTANCE.onFollowingOpen(context);
    }

    public final void openBookmark(Context context) {
        k.c(context, "context");
        InboxFeedDataProvider.INSTANCE.onBookmarkOpen(context);
    }

    public final Fragment getFeedFragment() {
        return InboxFeedDataProvider.INSTANCE.getFeedFragment();
    }

    public final Fragment getFollowingFragment() {
        return InboxFeedDataProvider.INSTANCE.getFollowingFragment();
    }
}

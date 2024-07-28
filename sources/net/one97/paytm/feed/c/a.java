package net.one97.paytm.feed.c;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import kotlin.g.b.k;
import net.one97.paytm.feed.ui.feed.FeedFragment;
import net.one97.paytm.feed.ui.feed.actions.comment.FeedCommentActivity;
import net.one97.paytm.feed.ui.feed.actions.d;
import net.one97.paytm.feed.ui.feed.e;
import net.one97.paytm.feed.ui.feed.livetv.category.LiveTvCategoryAcitivity;
import net.one97.paytm.feed.ui.feed.livetv.category.c;
import net.one97.paytm.feed.ui.feed.livetv.channel.ChannelAcitivity;
import net.one97.paytm.feed.ui.feed.video.FullVideoActivity;
import net.one97.paytm.feed.ui.publisher.FeedProviderActivity;
import net.one97.paytm.feed.ui.publisher.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f34255a = new a();

    private a() {
    }

    public static ai a(AppCompatActivity appCompatActivity) {
        k.c(appCompatActivity, "activity");
        if (appCompatActivity instanceof FeedProviderActivity) {
            return new b();
        }
        if (appCompatActivity instanceof LiveTvCategoryAcitivity) {
            return new c(net.one97.paytm.feed.repository.a.b.f34366b);
        }
        if (appCompatActivity instanceof FeedCommentActivity) {
            return new net.one97.paytm.feed.ui.feed.actions.comment.c();
        }
        if (appCompatActivity instanceof ChannelAcitivity) {
            return new net.one97.paytm.feed.ui.feed.livetv.channel.b(net.one97.paytm.feed.repository.a.b.f34366b);
        }
        if (appCompatActivity instanceof FullVideoActivity) {
            return new net.one97.paytm.feed.ui.feed.video.a();
        }
        return new androidx.lifecycle.a(appCompatActivity.getApplication());
    }

    public static ai a(Fragment fragment) {
        k.c(fragment, "fragment");
        if (fragment instanceof FeedFragment) {
            return new e(net.one97.paytm.feed.repository.a.b.f34366b);
        }
        if (fragment instanceof d) {
            return new net.one97.paytm.feed.ui.feed.actions.b();
        }
        if (fragment instanceof net.one97.paytm.feed.ui.feed.o.a) {
            return new net.one97.paytm.feed.ui.feed.actions.b();
        }
        FragmentActivity activity = fragment.getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            k.a();
        }
        return new androidx.lifecycle.a(application);
    }

    public static net.one97.paytm.feed.repository.a.b a() {
        return net.one97.paytm.feed.repository.a.b.f34366b;
    }
}

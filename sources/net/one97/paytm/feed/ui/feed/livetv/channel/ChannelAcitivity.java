package net.one97.paytm.feed.ui.feed.livetv.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.g;
import net.one97.paytm.feed.repository.models.livetv.Channel;
import net.one97.paytm.feed.ui.base.FeedBaseActivity;
import net.one97.paytm.feed.utility.n;

public final class ChannelAcitivity extends FeedBaseActivity<g, b> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f35127d = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.feed.ui.feed.livetv.category.a.a f35128c;

    static final class c<T> implements io.reactivex.rxjava3.d.g<ArrayList<Channel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView f35130a;

        c(RecyclerView recyclerView) {
            this.f35130a = recyclerView;
        }

        public final /* synthetic */ void accept(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            RecyclerView.a adapter = this.f35130a.getAdapter();
            if (adapter != null) {
                k.a((Object) arrayList, "newList");
                ((net.one97.paytm.feed.ui.feed.livetv.category.a.a) adapter).a(arrayList);
                arrayList.size();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.feed.ui.feed.livetv.category.item.LiveTvCategoryItemAdapter");
        }
    }

    public final int c() {
        return R.layout.feed_channel_grid_view;
    }

    public final HashMap<Integer, Object> d() {
        return new HashMap<>();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChannelAcitivity f35129a;

        b(ChannelAcitivity channelAcitivity) {
            this.f35129a = channelAcitivity;
        }

        public final void onClick(View view) {
            this.f35129a.onBackPressed();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void e() {
        Toolbar toolbar = ((g) a()).f34166d;
        setSupportActionBar(toolbar);
        toolbar.setContentInsetStartWithNavigation(0);
        toolbar.setNavigationOnClickListener(new b(this));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(true);
            supportActionBar.a(true);
            supportActionBar.c(false);
        }
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        Bundle extras = intent.getExtras();
        String string = extras != null ? extras.getString("name") : null;
        if (string != null) {
            Toolbar toolbar2 = ((g) a()).f34166d;
            k.a((Object) toolbar2, "dataBinding.toolbar");
            toolbar2.setTitle((CharSequence) string);
        }
        Intent intent2 = getIntent();
        k.a((Object) intent2, "intent");
        Bundle extras2 = intent2.getExtras();
        String string2 = extras2 != null ? extras2.getString("id") : null;
        if (string2 != null) {
            k.c(string2, "<set-?>");
            ((b) b()).f35132b = string2;
        }
        RecyclerView recyclerView = ((g) a()).f34163a;
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator((RecyclerView.f) null);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new n());
        this.f35128c = new net.one97.paytm.feed.ui.feed.livetv.category.a.a();
        net.one97.paytm.feed.ui.feed.livetv.category.a.a aVar = this.f35128c;
        if (aVar == null) {
            k.a("liveTvCategoryAdapter");
        }
        recyclerView.setAdapter(aVar);
        ((b) b()).f35133c.subscribe(new c(recyclerView));
        if (!TextUtils.isEmpty(((b) b()).f35132b)) {
            Context applicationContext = getApplicationContext();
            k.a((Object) applicationContext, "applicationContext");
            String str = ((b) b()).f35132b;
            ProgressBar progressBar = ((g) a()).f34164b;
            k.a((Object) progressBar, "dataBinding.feedLoadingProgress");
            ((b) b()).a(applicationContext, str, progressBar);
        }
    }
}

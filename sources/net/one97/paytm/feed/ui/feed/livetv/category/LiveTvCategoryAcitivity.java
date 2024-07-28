package net.one97.paytm.feed.ui.feed.livetv.category;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import io.reactivex.rxjava3.d.g;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.cu;
import net.one97.paytm.feed.repository.models.livetv.ChannelCategory;
import net.one97.paytm.feed.ui.base.FeedBaseActivity;

public final class LiveTvCategoryAcitivity extends FeedBaseActivity<cu, c> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f35111d = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    public a f35112c;

    static final class b<T> implements g<ArrayList<ChannelCategory>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveTvCategoryAcitivity f35113a;

        b(LiveTvCategoryAcitivity liveTvCategoryAcitivity) {
            this.f35113a = liveTvCategoryAcitivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            a aVar = this.f35113a.f35112c;
            if (aVar == null) {
                k.a("liveTvCategoryAdapter");
            }
            if (arrayList != null) {
                aVar.f35115a.addAll(arrayList);
            }
            aVar.notifyDataSetChanged();
            arrayList.size();
        }
    }

    public final int c() {
        return R.layout.feed_tv_category;
    }

    public final HashMap<Integer, Object> d() {
        return new HashMap<>();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveTvCategoryAcitivity f35114a;

        c(LiveTvCategoryAcitivity liveTvCategoryAcitivity) {
            this.f35114a = liveTvCategoryAcitivity;
        }

        public final void onClick(View view) {
            this.f35114a.onBackPressed();
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
        Toolbar toolbar = ((cu) a()).f34100d;
        setSupportActionBar(toolbar);
        toolbar.setContentInsetStartWithNavigation(0);
        toolbar.setNavigationOnClickListener(new c(this));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(true);
            supportActionBar.a(true);
            supportActionBar.c(false);
        }
        RecyclerView recyclerView = ((cu) a()).f34097a;
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator((RecyclerView.f) null);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        Context context = recyclerView.getContext();
        k.a((Object) context, "context");
        this.f35112c = new a(context);
        a aVar = this.f35112c;
        if (aVar == null) {
            k.a("liveTvCategoryAdapter");
        }
        recyclerView.setAdapter(aVar);
        i iVar = new i(recyclerView.getContext(), 1);
        Context context2 = recyclerView.getContext();
        if (context2 == null) {
            k.a();
        }
        Drawable a2 = androidx.core.content.b.a(context2, R.drawable.feed_divider);
        if (a2 == null) {
            k.a();
        }
        iVar.a(a2);
        recyclerView.addItemDecoration(iVar);
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        ProgressBar progressBar = ((cu) a()).f34098b;
        k.a((Object) progressBar, "dataBinding.feedLoadingProgress");
        ((c) b()).a(applicationContext, progressBar);
        ((c) b()).f35123b.subscribe(new b(this));
    }
}

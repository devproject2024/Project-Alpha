package net.one97.paytm.feed.ui.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.language.FeedLanguage;
import net.one97.paytm.feed.repository.models.language.FeedLanguageData;
import net.one97.paytm.feed.utility.j;
import net.one97.paytm.i.h;

public final class b extends h implements net.one97.paytm.feed.ui.a.a.b, c {

    /* renamed from: a  reason: collision with root package name */
    private TextView f34816a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f34817b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f34818c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f34819d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f34820e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public net.one97.paytm.feed.ui.a.a.a f34821f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Context f34822g;

    /* renamed from: h  reason: collision with root package name */
    private d f34823h = new d();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f34824i;
    /* access modifiers changed from: private */
    public ArrayList<String> j = new ArrayList<>();
    /* access modifiers changed from: private */
    public ProgressBar k;
    private HashMap l;

    static final class a extends l implements kotlin.g.a.b<FeedLanguage, x> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar) {
            super(1);
            this.this$0 = bVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FeedLanguage) obj);
            return x.f47997a;
        }

        public final void invoke(FeedLanguage feedLanguage) {
            ProgressBar c2 = this.this$0.k;
            if (c2 != null) {
                c2.setVisibility(8);
            }
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.a(false);
            if (feedLanguage == null || !(!feedLanguage.getLanguages().isEmpty())) {
                b.g(this.this$0);
            } else if (feedLanguage.isBoard()) {
                for (FeedLanguageData next : feedLanguage.getLanguages()) {
                    if (next.isSelected()) {
                        this.this$0.j.add(next.getLanguageCode());
                    }
                }
                if (this.this$0.j.size() != 0) {
                    net.one97.paytm.feed.repository.b bVar2 = net.one97.paytm.feed.repository.b.f34608a;
                    String arrayList = this.this$0.j.toString();
                    k.a((Object) arrayList, "selectedLanguage.toString()");
                    net.one97.paytm.feed.repository.b.a(arrayList);
                } else {
                    net.one97.paytm.feed.repository.b bVar3 = net.one97.paytm.feed.repository.b.f34608a;
                    net.one97.paytm.feed.repository.b.a("[en]");
                }
                if (!p.a(this.this$0.getTag(), "settings", true)) {
                    net.one97.paytm.feed.repository.b bVar4 = net.one97.paytm.feed.repository.b.f34608a;
                    net.one97.paytm.feed.repository.b.a();
                    net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
                    net.one97.paytm.feed.e.c.k();
                    net.one97.paytm.feed.ui.a.a.a e2 = this.this$0.f34821f;
                    if (e2 != null) {
                        e2.a();
                        return;
                    }
                    return;
                }
                a f2 = this.this$0.f34824i;
                if (f2 != null) {
                    List<FeedLanguageData> languages = feedLanguage.getLanguages();
                    if (languages != null) {
                        f2.a((ArrayList<FeedLanguageData>) (ArrayList) languages);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.feed.repository.models.language.FeedLanguageData> /* = java.util.ArrayList<net.one97.paytm.feed.repository.models.language.FeedLanguageData> */");
                    }
                }
                net.one97.paytm.feed.events.a.a aVar = net.one97.paytm.feed.events.a.a.f34296a;
                net.one97.paytm.feed.events.a.a.a("v2_feed_language_display", "profile setting screen");
            } else {
                new StringBuilder("Adapter :: ").append(this.this$0.f34824i);
                net.one97.paytm.feed.events.a.a aVar2 = net.one97.paytm.feed.events.a.a.f34296a;
                net.one97.paytm.feed.events.a.a.a("v2_feed_language_display", "profile setting screen");
                a f3 = this.this$0.f34824i;
                if (f3 != null) {
                    List<FeedLanguageData> languages2 = feedLanguage.getLanguages();
                    if (languages2 != null) {
                        f3.a((ArrayList<FeedLanguageData>) (ArrayList) languages2);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.feed.repository.models.language.FeedLanguageData> /* = java.util.ArrayList<net.one97.paytm.feed.repository.models.language.FeedLanguageData> */");
                }
            }
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
        this.f34822g = context;
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a(this.f34822g);
        com.google.android.play.core.splitcompat.a.b(this.f34822g);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.feed_language_fragment, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.feed_language_continue);
        k.a((Object) findViewById, "view.findViewById(R.id.feed_language_continue)");
        this.f34816a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.feed_language_error);
        k.a((Object) findViewById2, "view.findViewById(R.id.feed_language_error)");
        this.f34817b = (TextView) findViewById2;
        this.k = (ProgressBar) view.findViewById(R.id.feed_loading_progress);
        View findViewById3 = view.findViewById(R.id.feed_language_info);
        k.a((Object) findViewById3, "view.findViewById(R.id.feed_language_info)");
        this.f34818c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.feed_language_header);
        k.a((Object) findViewById4, "view.findViewById(R.id.feed_language_header)");
        this.f34819d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.feed_language_recyclerview);
        k.a((Object) findViewById5, "view.findViewById(R.id.feed_language_recyclerview)");
        this.f34820e = (RecyclerView) findViewById5;
        TextView textView = this.f34816a;
        if (textView == null) {
            k.a("proceed");
        }
        textView.setOnClickListener(new C0566b(this));
        RecyclerView recyclerView = this.f34820e;
        if (recyclerView == null) {
            k.a("recyclerview");
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator((RecyclerView.f) null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f34822g, 1, false));
        this.f34824i = new a(this);
        recyclerView.setAdapter(this.f34824i);
        a();
        if (p.a(getTag(), "settings", true)) {
            TextView textView2 = this.f34818c;
            if (textView2 == null) {
                k.a("languageInfo");
            }
            textView2.setVisibility(8);
            TextView textView3 = this.f34819d;
            if (textView3 == null) {
                k.a("languageHeader");
            }
            textView3.setVisibility(8);
        }
    }

    /* renamed from: net.one97.paytm.feed.ui.a.b$b  reason: collision with other inner class name */
    static final class C0566b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34825a;

        C0566b(b bVar) {
            this.f34825a = bVar;
        }

        public final void onClick(View view) {
            Context a2 = this.f34825a.f34822g;
            if (a2 != null) {
                j jVar = j.f35397a;
                if (j.e(a2)) {
                    b.b(this.f34825a);
                } else {
                    Toast.makeText(this.f34825a.f34822g, R.string.language_no_internet, 0).show();
                }
            }
        }
    }

    public final void a(FeedLanguageData feedLanguageData, CheckBox checkBox) {
        k.c(feedLanguageData, "feedLanguageData");
        k.c(checkBox, "checkBox");
        if (this.j.contains(feedLanguageData.getLanguageCode())) {
            this.j.remove(feedLanguageData.getLanguageCode());
            checkBox.setChecked(false);
            feedLanguageData.setSelected(false);
        } else {
            this.j.add(feedLanguageData.getLanguageCode());
            checkBox.setChecked(true);
            feedLanguageData.setSelected(true);
        }
        if (this.j.size() > 0) {
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.A();
            TextView textView = this.f34816a;
            if (textView == null) {
                k.a("proceed");
            }
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = this.f34816a;
        if (textView2 == null) {
            k.a("proceed");
        }
        textView2.setVisibility(4);
        TextView textView3 = this.f34816a;
        if (textView3 == null) {
            k.a("proceed");
        }
        textView3.setVisibility(8);
    }

    public final void onStart() {
        super.onStart();
        a aVar = this.f34824i;
        if (aVar != null) {
            aVar.a((c) this);
        }
    }

    public final void onStop() {
        super.onStop();
        a aVar = this.f34824i;
        if (aVar != null) {
            aVar.a((c) null);
        }
    }

    public final void a() {
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        if (net.one97.paytm.feed.e.b.C() || p.a(getTag(), "settings", true)) {
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.a(true);
            Context context = this.f34822g;
            if (context != null) {
                j jVar = j.f35397a;
                if (j.e(context)) {
                    ProgressBar progressBar = this.k;
                    if (progressBar != null) {
                        progressBar.setVisibility(0);
                    }
                    b();
                    net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                    if (net.one97.paytm.feed.e.b.h() != null) {
                        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
                        net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
                        net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
                        String h2 = net.one97.paytm.feed.e.b.h();
                        if (h2 == null) {
                            k.a();
                        }
                        a2.b(context, "/content-users/v1/getUserlanguage/", h2, (kotlin.g.a.b<? super FeedLanguage, x>) new a(this));
                        return;
                    }
                    net.one97.paytm.feed.e.b bVar5 = net.one97.paytm.feed.e.b.f34268c;
                    net.one97.paytm.feed.e.b.a(false);
                    return;
                }
                c();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34826a;

        c(b bVar) {
            this.f34826a = bVar;
        }

        public final void onClick(View view) {
            this.f34826a.a();
        }
    }

    private final void b() {
        TextView textView = this.f34817b;
        if (textView == null) {
            k.a("error");
        }
        textView.setVisibility(8);
    }

    private final void c() {
        Context context;
        if (isAdded() && (context = this.f34822g) != null) {
            TextView textView = this.f34817b;
            if (textView == null) {
                k.a("error");
            }
            textView.setVisibility(0);
            TextView textView2 = this.f34817b;
            if (textView2 == null) {
                k.a("error");
            }
            textView2.setText(getString(R.string.feed_retry));
            Drawable a2 = androidx.core.content.b.a(context, R.drawable.feed_no_internet);
            TextView textView3 = this.f34817b;
            if (textView3 == null) {
                k.a("error");
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, a2, (Drawable) null, (Drawable) null);
            TextView textView4 = this.f34817b;
            if (textView4 == null) {
                k.a("error");
            }
            textView4.setOnClickListener(new d(this));
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34827a;

        d(b bVar) {
            this.f34827a = bVar;
        }

        public final void onClick(View view) {
            this.f34827a.a();
        }
    }

    public final void a(boolean z) {
        FragmentActivity activity;
        if (z && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    public final void onDestroy() {
        Context context = this.f34822g;
        if (context != null) {
            net.one97.paytm.feed.repository.a.a a2 = net.one97.paytm.feed.repository.a.a.f34362b.a(context);
            k.c("lang", "tag");
            a2.a().cancelAll((Object) "lang");
        }
        super.onDestroy();
    }

    public static final /* synthetic */ void b(b bVar) {
        androidx.fragment.app.j supportFragmentManager;
        if (bVar.j.size() > 0) {
            d dVar = bVar.f34823h;
            dVar.f34828a = bVar;
            String arrayList = bVar.j.toString();
            k.a((Object) arrayList, "selectedLanguage.toString()");
            k.c(arrayList, "languages");
            dVar.f34829b = arrayList;
            FragmentActivity activity = bVar.getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                bVar.f34823h.show(supportFragmentManager, H5Param.PROGRESS);
                return;
            }
            return;
        }
        Toast.makeText(bVar.f34822g, R.string.feed_language_check, 0).show();
    }

    public static final /* synthetic */ void g(b bVar) {
        Context context;
        if (bVar.isAdded() && (context = bVar.f34822g) != null) {
            TextView textView = bVar.f34817b;
            if (textView == null) {
                k.a("error");
            }
            textView.setVisibility(0);
            TextView textView2 = bVar.f34817b;
            if (textView2 == null) {
                k.a("error");
            }
            textView2.setText(context.getString(R.string.feed_server_error));
            Drawable a2 = androidx.core.content.b.a(context, R.drawable.feed_no_data);
            TextView textView3 = bVar.f34817b;
            if (textView3 == null) {
                k.a("error");
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, a2, (Drawable) null, (Drawable) null);
            TextView textView4 = bVar.f34817b;
            if (textView4 == null) {
                k.a("error");
            }
            textView4.setOnClickListener(new c(bVar));
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

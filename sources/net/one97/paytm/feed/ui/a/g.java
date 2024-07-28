package net.one97.paytm.feed.ui.a;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.language.FeedLanguageData;

public final class g extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    TextView f34845a;

    /* renamed from: b  reason: collision with root package name */
    TextView f34846b;

    /* renamed from: c  reason: collision with root package name */
    CheckBox f34847c;

    /* renamed from: d  reason: collision with root package name */
    LinearLayout f34848d;

    /* renamed from: e  reason: collision with root package name */
    private final View f34849e;

    /* renamed from: f  reason: collision with root package name */
    private c f34850f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(View view, c cVar) {
        super(view);
        k.c(view, "view");
        this.f34849e = view;
        this.f34850f = cVar;
        View findViewById = this.f34849e.findViewById(R.id.feed_language_original);
        k.a((Object) findViewById, "view.findViewById(R.id.feed_language_original)");
        this.f34845a = (TextView) findViewById;
        View findViewById2 = this.f34849e.findViewById(R.id.feed_language_in_english);
        k.a((Object) findViewById2, "view.findViewById(R.id.feed_language_in_english)");
        this.f34846b = (TextView) findViewById2;
        View findViewById3 = this.f34849e.findViewById(R.id.feed_language_checkbox);
        k.a((Object) findViewById3, "view.findViewById(R.id.feed_language_checkbox)");
        this.f34847c = (CheckBox) findViewById3;
        View findViewById4 = this.f34849e.findViewById(R.id.feed_langauge_container);
        k.a((Object) findViewById4, "view.findViewById(R.id.feed_langauge_container)");
        this.f34848d = (LinearLayout) findViewById4;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f34851a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedLanguageData f34852b;

        a(g gVar, FeedLanguageData feedLanguageData) {
            this.f34851a = gVar;
            this.f34852b = feedLanguageData;
        }

        public final void onClick(View view) {
            g.a(this.f34851a, this.f34852b);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f34853a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedLanguageData f34854b;

        b(g gVar, FeedLanguageData feedLanguageData) {
            this.f34853a = gVar;
            this.f34854b = feedLanguageData;
        }

        public final void onClick(View view) {
            g.a(this.f34853a, this.f34854b);
        }
    }

    public static final /* synthetic */ void a(g gVar, FeedLanguageData feedLanguageData) {
        c cVar = gVar.f34850f;
        if (cVar != null) {
            cVar.a(feedLanguageData, gVar.f34847c);
        }
    }
}

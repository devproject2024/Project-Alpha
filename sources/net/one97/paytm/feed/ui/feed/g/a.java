package net.one97.paytm.feed.ui.feed.g;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.ag;
import net.one97.paytm.feed.repository.models.language.FeedLanguage;
import net.one97.paytm.feed.ui.base.b;

public final class a extends b<ag, FeedLanguage, androidx.lifecycle.a> {

    /* renamed from: b  reason: collision with root package name */
    public b f35053b;

    /* renamed from: c  reason: collision with root package name */
    public c f35054c;

    /* renamed from: d  reason: collision with root package name */
    public final C0579a f35055d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f35056e = ((RecyclerView) this.f35058g.findViewById(R.id.langauge_container));

    /* renamed from: f  reason: collision with root package name */
    private GridLayoutManager f35057f;

    /* renamed from: g  reason: collision with root package name */
    private final View f35058g;

    /* renamed from: net.one97.paytm.feed.ui.feed.g.a$a  reason: collision with other inner class name */
    public interface C0579a {
        void a(int i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, C0579a aVar) {
        super(view);
        k.c(view, "view");
        k.c(aVar, "languageResponseHandler");
        this.f35058g = view;
        this.f35055d = aVar;
        RecyclerView recyclerView = this.f35056e;
        if (recyclerView != null) {
            recyclerView.setItemAnimator((RecyclerView.f) null);
            this.f35057f = new GridLayoutManager(recyclerView.getContext(), 3);
            recyclerView.setLayoutManager(this.f35057f);
            this.f35053b = new b();
            recyclerView.setAdapter(this.f35053b);
        }
    }
}

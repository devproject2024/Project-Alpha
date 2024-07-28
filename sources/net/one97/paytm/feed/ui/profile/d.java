package net.one97.paytm.feed.ui.profile;

import android.view.View;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.de;
import net.one97.paytm.feed.repository.models.profile.Following;
import net.one97.paytm.feed.ui.profile.f;

public final class d extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    de f35304a = ((de) de.bind(f.a(), this.f35305b, R.layout.view_holder_following));

    /* renamed from: b  reason: collision with root package name */
    private View f35305b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view) {
        super(view);
        k.c(view, "view");
        this.f35305b = view;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.a f35306a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Following f35307b;

        a(f.a aVar, Following following) {
            this.f35306a = aVar;
            this.f35307b = following;
        }

        public final void onClick(View view) {
            this.f35306a.a(this.f35307b.getUserId());
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.a f35308a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Following f35309b;

        b(f.a aVar, Following following) {
            this.f35308a = aVar;
            this.f35309b = following;
        }

        public final void onClick(View view) {
            this.f35308a.a(this.f35309b.getUserId());
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.a f35310a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f35311b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Following f35312c;

        c(f.a aVar, int i2, Following following) {
            this.f35310a = aVar;
            this.f35311b = i2;
            this.f35312c = following;
        }

        public final void onClick(View view) {
            this.f35310a.a(this.f35311b, this.f35312c.getFollowing(), this.f35312c.getUserId());
        }
    }
}

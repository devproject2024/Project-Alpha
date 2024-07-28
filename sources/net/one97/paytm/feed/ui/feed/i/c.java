package net.one97.paytm.feed.ui.feed.i;

import kotlin.g.b.k;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.repository.models.polls.Polls;
import net.one97.paytm.feed.ui.feed.d;

public final class c extends d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f35078a = this.f35079b.isVoted();

    /* renamed from: b  reason: collision with root package name */
    public final Polls f35079b;

    public c(Polls polls) {
        k.c(polls, "polls");
        this.f35079b = polls;
    }

    public final void a() {
        this.f35078a = true;
        this.f35079b.setVoted(true);
        a(a.x);
    }
}

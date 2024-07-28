package net.one97.paytm.feed.ui.feed.i;

import android.content.Context;
import android.widget.RadioGroup;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.feed.repository.models.polls.Options;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f35072a;

    /* renamed from: b  reason: collision with root package name */
    public c f35073b;

    /* renamed from: c  reason: collision with root package name */
    d f35074c;

    /* renamed from: net.one97.paytm.feed.ui.feed.i.a$a  reason: collision with other inner class name */
    public static final class C0581a extends l implements b<List<? extends Options>, x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ RadioGroup $radioGroup;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0581a(a aVar, Context context, RadioGroup radioGroup) {
            super(1);
            this.this$0 = aVar;
            this.$context = context;
            this.$radioGroup = radioGroup;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<Options>) (List) obj);
            return x.f47997a;
        }

        public final void invoke(List<Options> list) {
            if (list != null) {
                d dVar = this.this$0.f35074c;
                if (dVar != null) {
                    dVar.a(this.$context, list);
                }
                a aVar = this.this$0;
                aVar.f35074c = null;
                aVar.f35073b.a();
                return;
            }
            this.this$0.f35072a = true;
            this.$radioGroup.clearCheck();
        }
    }

    public a(c cVar, d dVar) {
        k.c(cVar, "viewModel");
        this.f35073b = cVar;
        this.f35074c = dVar;
    }
}

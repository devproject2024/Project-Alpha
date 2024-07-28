package net.one97.paytm.paymentsBank.slfd.nominee.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.nominee.a.a;

public final class a extends RecyclerView.a<C0338a> {

    /* renamed from: a  reason: collision with root package name */
    final a.C0337a f19242a;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0338a aVar = (C0338a) vVar;
        k.c(aVar, "holder");
        this.f19242a.a(aVar, i2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        return new C0338a(this, from != null ? from.inflate(R.layout.item_fd_nominee, viewGroup, false) : null);
    }

    public a(a.C0337a aVar) {
        k.c(aVar, "presenter");
        this.f19242a = aVar;
    }

    public final int getItemCount() {
        return this.f19242a.c();
    }

    /* renamed from: net.one97.paytm.paymentsBank.slfd.nominee.view.a$a  reason: collision with other inner class name */
    public final class C0338a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public RadioButton f19243a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19244b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19245c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f19246d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f19247e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ a f19248f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0338a(a aVar, View view) {
            super(view);
            if (view == null) {
                k.a();
            }
            this.f19248f = aVar;
            View findViewById = view.findViewById(R.id.rb_nominee);
            if (findViewById != null) {
                this.f19243a = (RadioButton) findViewById;
                View findViewById2 = view.findViewById(R.id.tv_nominee_name);
                if (findViewById2 != null) {
                    this.f19244b = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.tv_relationship);
                    if (findViewById3 != null) {
                        this.f19245c = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.tv_nominee_address);
                        if (findViewById4 != null) {
                            this.f19246d = (TextView) findViewById4;
                            View findViewById5 = view.findViewById(R.id.tv_nominee_contact_no);
                            if (findViewById5 != null) {
                                this.f19247e = (TextView) findViewById5;
                                return;
                            }
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.RadioButton");
        }

        public final void a(boolean z) {
            this.f19243a.setChecked(z);
        }

        /* renamed from: net.one97.paytm.paymentsBank.slfd.nominee.view.a$a$a  reason: collision with other inner class name */
        public static final class C0339a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0338a f19249a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f19250b;

            public C0339a(C0338a aVar, int i2) {
                this.f19249a = aVar;
                this.f19250b = i2;
            }

            public final void onClick(View view) {
                this.f19249a.f19248f.f19242a.a(this.f19250b);
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.slfd.nominee.view.a$a$b */
        public static final class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0338a f19251a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f19252b;

            public b(C0338a aVar, int i2) {
                this.f19251a = aVar;
                this.f19252b = i2;
            }

            public final void onClick(View view) {
                this.f19251a.f19248f.f19242a.a(this.f19252b);
            }
        }
    }
}

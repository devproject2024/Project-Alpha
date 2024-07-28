package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.w;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.h;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.widget.CJRContactListV8;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.c.e;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;
import net.one97.paytm.upi.f;

public final class g extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    CJRContactListV8.a f60496a;

    /* renamed from: b  reason: collision with root package name */
    private final int f60497b = 1;

    /* renamed from: c  reason: collision with root package name */
    private final int f60498c = 2;

    /* renamed from: d  reason: collision with root package name */
    private final int f60499d = 6;

    public g(CJRContactListV8.a aVar) {
        k.c(aVar, "options");
        this.f60496a = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f60497b) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_contact_item_v8, viewGroup, false);
            k.a((Object) inflate, "view");
            return new a(this, inflate, this.f60496a.f61862c);
        } else if (i2 == this.f60499d) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v3_my_number_view, viewGroup, false);
            k.a((Object) inflate2, "view");
            return new c(this, inflate2, this.f60496a.f61862c);
        } else {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_contact_item_header_v8, viewGroup, false);
            k.a((Object) inflate3, "view");
            return new b(this, inflate3);
        }
    }

    public final int getItemCount() {
        List<? extends ContactItemModel> list = this.f60496a.f61861b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ContactItemModel contactItemModel;
        ContactItemModel contactItemModel2;
        k.c(vVar, "holder");
        if (vVar instanceof b) {
            List<? extends ContactItemModel> list = this.f60496a.f61861b;
            if (list != null && (contactItemModel2 = (ContactItemModel) list.get(i2)) != null) {
                b bVar = (b) vVar;
                k.c(contactItemModel2, "contact");
                bVar.f60513a.setText(contactItemModel2.getName());
                bVar.f60514b.setVisibility(8);
                return;
            }
            return;
        }
        List<? extends ContactItemModel> list2 = this.f60496a.f61861b;
        if (list2 != null && (contactItemModel = (ContactItemModel) list2.get(i2)) != null) {
            ((a) vVar).a(i2, contactItemModel, "");
        }
    }

    public final int getItemViewType(int i2) {
        if (this.f60496a.f61861b != null) {
            return this.f60497b;
        }
        return this.f60498c;
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f60513a;

        /* renamed from: b  reason: collision with root package name */
        final View f60514b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f60515c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g gVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f60515c = gVar;
            View findViewById = view.findViewById(R.id.headerTv);
            if (findViewById != null) {
                this.f60513a = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.headerDivider);
                k.a((Object) findViewById2, "itemView.findViewById(R.id.headerDivider)");
                this.f60514b = findViewById2;
                this.f60513a.setTextColor(androidx.core.content.b.c(view.getContext(), R.color.color_506d85));
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final CJRRechargeLottieAnimationView f60500a;

        /* renamed from: b  reason: collision with root package name */
        ContactItemModel f60501b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f60502c;

        /* renamed from: d  reason: collision with root package name */
        private final Context f60503d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f60504e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f60505f;

        /* renamed from: g  reason: collision with root package name */
        private final TextView f60506g;

        /* renamed from: h  reason: collision with root package name */
        private final ImageView f60507h;

        /* renamed from: i  reason: collision with root package name */
        private final RelativeLayout f60508i;
        private final View j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar, View view, final h.c cVar) {
            super(view);
            k.c(view, "itemView");
            this.f60502c = gVar;
            this.f60503d = view.getContext();
            View findViewById = view.findViewById(R.id.beneficiary_circle);
            if (findViewById != null) {
                this.f60505f = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.beneficiary_no_name_icon);
                if (findViewById2 != null) {
                    this.f60507h = (ImageView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.beneficiary_name);
                    if (findViewById3 != null) {
                        this.f60504e = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.beneficiary_number);
                        if (findViewById4 != null) {
                            this.f60506g = (TextView) findViewById4;
                            View findViewById5 = view.findViewById(R.id.parent_layout);
                            if (findViewById5 != null) {
                                this.f60508i = (RelativeLayout) findViewById5;
                                View findViewById6 = view.findViewById(R.id.separator);
                                k.a((Object) findViewById6, "itemView.findViewById(R.id.separator)");
                                this.j = findViewById6;
                                View findViewById7 = view.findViewById(R.id.loader_animation);
                                if (findViewById7 != null) {
                                    this.f60500a = (CJRRechargeLottieAnimationView) findViewById7;
                                    this.j.setVisibility(8);
                                    this.f60508i.setOnClickListener(new View.OnClickListener(this) {

                                        /* renamed from: a  reason: collision with root package name */
                                        final /* synthetic */ a f60509a;

                                        {
                                            this.f60509a = r1;
                                        }

                                        public final void onClick(View view) {
                                            ContactItemModel contactItemModel;
                                            e eVar = e.INSTANCE;
                                            k.a((Object) view, "view");
                                            Context context = view.getContext();
                                            k.a((Object) context, "view.context");
                                            if (!eVar.validateIsAlreadyClicked(context, e.INSTANCE.getDELAY_1000_MILLI()) && (contactItemModel = this.f60509a.f60501b) != null) {
                                                a aVar = this.f60509a;
                                                ai.a(aVar.f60500a);
                                                aVar.f60500a.playAnimation();
                                                new Handler().postDelayed(new C1170a(contactItemModel, this), 200);
                                            }
                                        }

                                        /* renamed from: net.one97.paytm.recharge.common.a.g$a$1$a  reason: collision with other inner class name */
                                        static final class C1170a implements Runnable {

                                            /* renamed from: a  reason: collision with root package name */
                                            final /* synthetic */ ContactItemModel f60511a;

                                            /* renamed from: b  reason: collision with root package name */
                                            final /* synthetic */ AnonymousClass1 f60512b;

                                            C1170a(ContactItemModel contactItemModel, AnonymousClass1 r2) {
                                                this.f60511a = contactItemModel;
                                                this.f60512b = r2;
                                            }

                                            public final void run() {
                                                h.c cVar = cVar;
                                                if (cVar != null) {
                                                    cVar.a(this.f60511a, this.f60512b.f60509a.getAdapterPosition(), false);
                                                }
                                            }
                                        }
                                    });
                                    return;
                                }
                                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }

        public final void a(int i2, ContactItemModel contactItemModel, String str) {
            k.c(contactItemModel, "contactItemModel");
            k.c(str, "searchedString");
            this.f60501b = contactItemModel;
            a();
            String photoUri = contactItemModel.getPhotoUri();
            String name = contactItemModel.getName();
            CharSequence charSequence = name;
            if (!TextUtils.isEmpty(charSequence)) {
                this.f60504e.setText(charSequence);
                d dVar = d.f64967a;
                TextView textView = this.f60505f;
                k.a((Object) name, "name");
                d.a(textView, name, i2);
            } else {
                this.f60504e.setText("");
                this.f60505f.setText("");
                this.f60507h.setVisibility(0);
            }
            if (!TextUtils.isEmpty(photoUri)) {
                this.f60507h.setVisibility(0);
                this.f60505f.setVisibility(8);
                w.a().a(photoUri).a(R.drawable.v3_default_logo_contact).b(R.drawable.v3_default_logo_contact).a(this.f60507h);
            } else {
                a aVar = this;
                aVar.f60507h.setVisibility(8);
                aVar.f60505f.setVisibility(0);
            }
            if (net.one97.paytm.recharge.common.utils.g.c(str)) {
                String phnNo = contactItemModel.getPhnNo();
                k.a((Object) phnNo, "contactItemModel.phnNo");
                int a2 = p.a((CharSequence) phnNo, str, 0, false, 6);
                SpannableString spannableString = new SpannableString(contactItemModel.getPhnNo());
                if (a2 != -1) {
                    View view = this.itemView;
                    k.a((Object) view, "itemView");
                    spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(view.getContext(), R.color.color_00ACED)), a2, str.length() + a2, 18);
                }
                this.f60506g.setText(spannableString);
                return;
            }
            this.f60506g.setText(contactItemModel.getPhnNo());
        }

        public final void a() {
            this.f60500a.cancelAnimation();
            f.c((View) this.f60500a);
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f60516a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f60517b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f60518c;

        /* renamed from: d  reason: collision with root package name */
        final ImageView f60519d;

        /* renamed from: e  reason: collision with root package name */
        final CJRRechargeLottieAnimationView f60520e;

        /* renamed from: f  reason: collision with root package name */
        ContactItemModel f60521f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ g f60522g;

        /* renamed from: h  reason: collision with root package name */
        private final RelativeLayout f60523h;

        /* renamed from: i  reason: collision with root package name */
        private final View f60524i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(g gVar, View view, final h.c cVar) {
            super(view);
            k.c(view, "itemView");
            this.f60522g = gVar;
            View findViewById = view.findViewById(R.id.beneficiary_circle);
            if (findViewById != null) {
                this.f60517b = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.beneficiary_no_name_icon);
                if (findViewById2 != null) {
                    this.f60519d = (ImageView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.beneficiary_name);
                    if (findViewById3 != null) {
                        this.f60516a = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.beneficiary_number);
                        if (findViewById4 != null) {
                            this.f60518c = (TextView) findViewById4;
                            View findViewById5 = view.findViewById(R.id.parentRL);
                            if (findViewById5 != null) {
                                this.f60523h = (RelativeLayout) findViewById5;
                                View findViewById6 = view.findViewById(R.id.separator);
                                if (findViewById6 != null) {
                                    this.f60524i = findViewById6;
                                    View findViewById7 = view.findViewById(R.id.loader_animation);
                                    if (findViewById7 != null) {
                                        this.f60520e = (CJRRechargeLottieAnimationView) findViewById7;
                                        this.f60524i.setVisibility(8);
                                        this.f60523h.setOnClickListener(new View.OnClickListener(this) {

                                            /* renamed from: a  reason: collision with root package name */
                                            final /* synthetic */ c f60525a;

                                            {
                                                this.f60525a = r1;
                                            }

                                            public final void onClick(View view) {
                                                ContactItemModel contactItemModel;
                                                e eVar = e.INSTANCE;
                                                k.a((Object) view, "view");
                                                Context context = view.getContext();
                                                k.a((Object) context, "view.context");
                                                if (!eVar.validateIsAlreadyClicked(context, e.INSTANCE.getDELAY_1000_MILLI()) && (contactItemModel = this.f60525a.f60521f) != null) {
                                                    c cVar = this.f60525a;
                                                    ai.a(cVar.f60520e);
                                                    cVar.f60520e.playAnimation();
                                                    new Handler().postDelayed(new a(contactItemModel, this), 200);
                                                }
                                            }

                                            /* renamed from: net.one97.paytm.recharge.common.a.g$c$1$a */
                                            static final class a implements Runnable {

                                                /* renamed from: a  reason: collision with root package name */
                                                final /* synthetic */ ContactItemModel f60527a;

                                                /* renamed from: b  reason: collision with root package name */
                                                final /* synthetic */ AnonymousClass1 f60528b;

                                                a(ContactItemModel contactItemModel, AnonymousClass1 r2) {
                                                    this.f60527a = contactItemModel;
                                                    this.f60528b = r2;
                                                }

                                                public final void run() {
                                                    h.c cVar = cVar;
                                                    if (cVar != null) {
                                                        cVar.a(this.f60527a, this.f60528b.f60525a.getAdapterPosition(), false);
                                                    }
                                                }
                                            }
                                        });
                                        return;
                                    }
                                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView");
                                }
                                throw new u("null cannot be cast to non-null type android.view.View");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }

        public final void a() {
            this.f60520e.cancelAnimation();
            ai.b(this.f60520e);
        }
    }
}

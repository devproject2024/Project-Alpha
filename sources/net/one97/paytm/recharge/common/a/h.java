package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.text.TextUtils;
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
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.widget.CJRContactListV8;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.c.e;

public final class h extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private final int f60529a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final int f60530b = 2;

    /* renamed from: c  reason: collision with root package name */
    private final CJRContactListV8.a f60531c;

    public interface c {

        public static final class a {
        }

        void a(ContactItemModel contactItemModel, int i2, boolean z);

        void e();
    }

    public h(CJRContactListV8.a aVar) {
        k.c(aVar, "options");
        this.f60531c = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f60529a) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_contact_item_v8, viewGroup, false);
            k.a((Object) inflate, "view");
            c cVar = this.f60531c.f61862c;
            if (cVar == null) {
                k.a();
            }
            return new b(this, inflate, cVar);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_contact_item_header_v8, viewGroup, false);
        k.a((Object) inflate2, "view");
        return new a(this, inflate2);
    }

    public final int getItemCount() {
        List<? extends ContactItemModel> list = this.f60531c.f61861b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (vVar instanceof a) {
            a aVar = (a) vVar;
            List<? extends ContactItemModel> list = this.f60531c.f61861b;
            if (list == null) {
                k.a();
            }
            ContactItemModel contactItemModel = (ContactItemModel) list.get(i2);
            k.c(contactItemModel, "contact");
            aVar.f60532a.setText(contactItemModel.getName());
            return;
        }
        b bVar = (b) vVar;
        List<? extends ContactItemModel> list2 = this.f60531c.f61861b;
        if (list2 == null) {
            k.a();
        }
        bVar.a(i2, (ContactItemModel) list2.get(i2));
    }

    public final int getItemViewType(int i2) {
        if (this.f60531c.f61861b != null) {
            return this.f60529a;
        }
        return this.f60530b;
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f60532a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f60533b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h hVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f60533b = hVar;
            View findViewById = view.findViewById(R.id.headerTv);
            if (findViewById != null) {
                this.f60532a = (TextView) findViewById;
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ContactItemModel f60534a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f60535b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f60536c;

        /* renamed from: d  reason: collision with root package name */
        private final TextView f60537d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f60538e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f60539f;

        /* renamed from: g  reason: collision with root package name */
        private final ImageView f60540g;

        /* renamed from: h  reason: collision with root package name */
        private final RelativeLayout f60541h;

        /* renamed from: i  reason: collision with root package name */
        private final View f60542i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(h hVar, View view, final c cVar) {
            super(view);
            k.c(view, "itemView");
            k.c(cVar, "mItemClickListener");
            this.f60535b = hVar;
            this.f60536c = view.getContext();
            View findViewById = view.findViewById(R.id.beneficiary_circle);
            if (findViewById != null) {
                this.f60538e = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.beneficiary_no_name_icon);
                if (findViewById2 != null) {
                    this.f60540g = (ImageView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.beneficiary_name);
                    if (findViewById3 != null) {
                        this.f60537d = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.beneficiary_number);
                        if (findViewById4 != null) {
                            this.f60539f = (TextView) findViewById4;
                            View findViewById5 = view.findViewById(R.id.parent_layout);
                            if (findViewById5 != null) {
                                this.f60541h = (RelativeLayout) findViewById5;
                                View findViewById6 = view.findViewById(R.id.separator);
                                k.a((Object) findViewById6, "itemView.findViewById(R.id.separator)");
                                this.f60542i = findViewById6;
                                this.f60541h.setOnClickListener(new View.OnClickListener(this) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ b f60543a;

                                    {
                                        this.f60543a = r1;
                                    }

                                    public final void onClick(View view) {
                                        ContactItemModel contactItemModel;
                                        e eVar = e.INSTANCE;
                                        k.a((Object) view, "view");
                                        Context context = view.getContext();
                                        k.a((Object) context, "view.context");
                                        if (!eVar.validateIsAlreadyClicked(context, e.INSTANCE.getDELAY_1000_MILLI()) && (contactItemModel = this.f60543a.f60534a) != null) {
                                            cVar.a(contactItemModel, this.f60543a.getAdapterPosition(), false);
                                        }
                                    }
                                });
                                return;
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

        public final void a(int i2, ContactItemModel contactItemModel) {
            k.c(contactItemModel, "contactItemModel");
            this.f60534a = contactItemModel;
            String photoUri = contactItemModel.getPhotoUri();
            String name = contactItemModel.getName();
            this.f60539f.setText(contactItemModel.getPhnNo());
            CharSequence charSequence = name;
            if (!TextUtils.isEmpty(charSequence)) {
                this.f60537d.setText(charSequence);
                d dVar = d.f64967a;
                TextView textView = this.f60538e;
                if (name == null) {
                    k.a();
                }
                d.a(textView, name, i2);
            } else {
                this.f60537d.setText("");
                this.f60538e.setText("");
                this.f60540g.setVisibility(0);
            }
            if (!TextUtils.isEmpty(photoUri)) {
                this.f60540g.setVisibility(0);
                this.f60538e.setVisibility(8);
                w.a().a(photoUri).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(this.f60540g);
                return;
            }
            b bVar = this;
            bVar.f60540g.setVisibility(8);
            bVar.f60538e.setVisibility(0);
        }
    }
}

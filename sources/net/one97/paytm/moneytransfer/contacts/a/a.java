package net.one97.paytm.moneytransfer.contacts.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.CircularProgressBar;
import net.one97.paytm.upi.requestmoney.model.ContactItemModel;

public final class a extends RecyclerView.a<RecyclerView.v> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    Context f53908a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<ContactItemModel> f53909b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ContactItemModel> f53910c;

    /* renamed from: d  reason: collision with root package name */
    d f53911d;

    /* renamed from: e  reason: collision with root package name */
    public String f53912e = "";

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Integer> f53913f;

    /* renamed from: g  reason: collision with root package name */
    int f53914g = -1;

    /* renamed from: h  reason: collision with root package name */
    private final int f53915h;

    /* renamed from: i  reason: collision with root package name */
    private final int f53916i = 1;
    private C0963a j = new C0963a();

    public interface d {
        void a(ContactItemModel contactItemModel);

        void a(boolean z);

        void b();
    }

    public final Filter getFilter() {
        return this.j;
    }

    public a(ArrayList<ContactItemModel> arrayList, Context context, d dVar) {
        k.c(arrayList, "contactList");
        this.f53908a = context;
        this.f53909b = arrayList;
        this.f53911d = dVar;
        this.f53913f = new ArrayList<>();
        ArrayList<Integer> arrayList2 = this.f53913f;
        if (arrayList2 == null) {
            k.a("colorList");
        }
        arrayList2.add(Integer.valueOf(Color.parseColor("#2cce86")));
        ArrayList<Integer> arrayList3 = this.f53913f;
        if (arrayList3 == null) {
            k.a("colorList");
        }
        arrayList3.add(Integer.valueOf(Color.parseColor("#6c7cff")));
        ArrayList<Integer> arrayList4 = this.f53913f;
        if (arrayList4 == null) {
            k.a("colorList");
        }
        arrayList4.add(Integer.valueOf(Color.parseColor("#ffa400")));
        ArrayList<Integer> arrayList5 = this.f53913f;
        if (arrayList5 == null) {
            k.a("colorList");
        }
        arrayList5.add(Integer.valueOf(Color.parseColor("#b069ec")));
        ArrayList<Integer> arrayList6 = this.f53913f;
        if (arrayList6 == null) {
            k.a("colorList");
        }
        arrayList6.add(Integer.valueOf(Color.parseColor("#40cdd8")));
        ArrayList<Integer> arrayList7 = this.f53913f;
        if (arrayList7 == null) {
            k.a("colorList");
        }
        arrayList7.add(Integer.valueOf(Color.parseColor("#fd5c7f")));
        ArrayList<Integer> arrayList8 = this.f53913f;
        if (arrayList8 == null) {
            k.a("colorList");
        }
        arrayList8.add(Integer.valueOf(Color.parseColor("#f2c110")));
        ArrayList<Integer> arrayList9 = this.f53913f;
        if (arrayList9 == null) {
            k.a("colorList");
        }
        arrayList9.add(Integer.valueOf(Color.parseColor("#f36bb4")));
        ArrayList<Integer> arrayList10 = this.f53913f;
        if (arrayList10 == null) {
            k.a("colorList");
        }
        arrayList10.add(Integer.valueOf(Color.parseColor("#3ab6f4")));
        ArrayList<Integer> arrayList11 = this.f53913f;
        if (arrayList11 == null) {
            k.a("colorList");
        }
        arrayList11.add(Integer.valueOf(Color.parseColor("#a6b7be")));
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f53915h) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_list_header, (ViewGroup) null);
            k.a((Object) inflate, "LayoutInflater.from(pare…ontact_list_header, null)");
            return new b(inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_list_item, (ViewGroup) null);
        k.a((Object) inflate2, "LayoutInflater.from(pare….contact_list_item, null)");
        x.e eVar = new x.e();
        eVar.element = new c(this, inflate2);
        inflate2.setOnClickListener(new e(this, eVar));
        return (c) eVar.element;
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53929a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f53930b;

        e(a aVar, x.e eVar) {
            this.f53929a = aVar;
            this.f53930b = eVar;
        }

        public final void onClick(View view) {
            d dVar;
            if (this.f53929a.f53909b != null && (dVar = this.f53929a.f53911d) != null) {
                ArrayList<ContactItemModel> arrayList = this.f53929a.f53909b;
                ContactItemModel contactItemModel = arrayList != null ? arrayList.get(((c) this.f53930b.element).getAdapterPosition()) : null;
                if (contactItemModel == null) {
                    k.a();
                }
                k.a((Object) contactItemModel, "contactList?.get(holder.adapterPosition)!!");
                ((c) this.f53930b.element).getAdapterPosition();
                dVar.a(contactItemModel);
            }
        }
    }

    public final int getItemCount() {
        Collection collection = this.f53909b;
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        ArrayList<ContactItemModel> arrayList = this.f53909b;
        Integer valueOf = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        if (valueOf == null) {
            k.a();
        }
        return valueOf.intValue();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ArrayList<ContactItemModel> arrayList;
        ContactItemModel contactItemModel;
        ContactItemModel contactItemModel2;
        k.c(vVar, "holder");
        if (vVar instanceof b) {
            ArrayList<ContactItemModel> arrayList2 = this.f53909b;
            if (arrayList2 != null && (contactItemModel2 = arrayList2.get(i2)) != null) {
                k.a((Object) contactItemModel2, "it");
                k.c(contactItemModel2, "contactInfo");
                ((b) vVar).f53918a.setText(contactItemModel2.getName());
            }
        } else if ((vVar instanceof c) && (arrayList = this.f53909b) != null && (contactItemModel = arrayList.get(i2)) != null) {
            c cVar = (c) vVar;
            k.a((Object) contactItemModel, "it");
            k.c(contactItemModel, "contactItemModel");
            String photoUri = contactItemModel.getPhotoUri();
            String name = contactItemModel.getName();
            String phnNo = contactItemModel.getPhnNo();
            k.a((Object) phnNo, "contactItemModel.phnNo");
            cVar.a(phnNo, cVar.f53923d);
            Integer num = null;
            if (!TextUtils.isEmpty(name)) {
                k.a((Object) name, "name");
                cVar.a(name, cVar.f53922c);
                cVar.f53920a.setText(net.one97.paytm.wallet.utility.e.a(name));
                ArrayList<Integer> arrayList3 = cVar.f53926g.f53913f;
                if (arrayList3 == null) {
                    k.a("colorList");
                }
                Integer num2 = arrayList3.get(cVar.getAdapterPosition() % 10);
                k.a((Object) num2, "colorList.get(adapterPosition % 10)");
                int intValue = num2.intValue();
                Drawable background = cVar.f53920a.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = null;
                }
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(intValue);
                }
                cVar.f53920a.setBackground(gradientDrawable);
            }
            if (!TextUtils.isEmpty(photoUri)) {
                cVar.f53921b.setVisibility(0);
                cVar.f53920a.setVisibility(8);
                w.a().a(photoUri).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(cVar.f53921b);
            } else {
                cVar.f53921b.setVisibility(8);
                cVar.f53920a.setVisibility(0);
            }
            if (cVar.f53926g.f53914g == i2) {
                cVar.f53925f.setVisibility(0);
            } else {
                cVar.f53925f.setVisibility(4);
            }
            d dVar = cVar.f53926g.f53911d;
            if (dVar != null) {
                dVar.b();
            }
            d dVar2 = cVar.f53926g.f53911d;
            if (dVar2 != null) {
                dVar2.a(false);
            }
            ArrayList<ContactItemModel> arrayList4 = cVar.f53926g.f53909b;
            if (arrayList4 != null) {
                num = Integer.valueOf(arrayList4.size());
            }
            if (num == null) {
                k.a();
            }
            if (i2 == num.intValue() - 1) {
                cVar.f53924e.setVisibility(4);
            } else {
                cVar.f53924e.setVisibility(0);
            }
        }
    }

    public final void a(ArrayList<ContactItemModel> arrayList) {
        d dVar;
        k.c(arrayList, "newList");
        if (arrayList.size() == 0 && (dVar = this.f53911d) != null) {
            dVar.a(true);
        }
        if (arrayList.size() != 0) {
            this.f53909b = arrayList;
            notifyDataSetChanged();
            return;
        }
        ArrayList<ContactItemModel> arrayList2 = this.f53909b;
        if (arrayList2 == null || (arrayList2 != null && arrayList2.size() == 0)) {
            this.f53909b = arrayList;
            notifyItemRangeInserted(0, arrayList.size());
            return;
        }
        this.f53909b = arrayList;
        notifyDataSetChanged();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r0.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getItemViewType(int r2) {
        /*
            r1 = this;
            java.util.ArrayList<net.one97.paytm.upi.requestmoney.model.ContactItemModel> r0 = r1.f53909b
            if (r0 == 0) goto L_0x0015
            java.lang.Object r2 = r0.get(r2)
            net.one97.paytm.upi.requestmoney.model.ContactItemModel r2 = (net.one97.paytm.upi.requestmoney.model.ContactItemModel) r2
            if (r2 == 0) goto L_0x0015
            boolean r2 = r2.ismIsHeading()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x0016
        L_0x0015:
            r2 = 0
        L_0x0016:
            if (r2 != 0) goto L_0x001b
            kotlin.g.b.k.a()
        L_0x001b:
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0024
            int r2 = r1.f53915h
            return r2
        L_0x0024:
            int r2 = r1.f53916i
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.contacts.a.a.getItemViewType(int):int");
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f53918a;

        /* renamed from: b  reason: collision with root package name */
        private View f53919b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "view");
            this.f53919b = view;
            View findViewById = this.f53919b.findViewById(R.id.tv_header_title);
            k.a((Object) findViewById, "view.findViewById<TextView>(R.id.tv_header_title)");
            this.f53918a = (TextView) findViewById;
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f53920a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f53921b;

        /* renamed from: c  reason: collision with root package name */
        TextView f53922c;

        /* renamed from: d  reason: collision with root package name */
        TextView f53923d;

        /* renamed from: e  reason: collision with root package name */
        View f53924e;

        /* renamed from: f  reason: collision with root package name */
        CircularProgressBar f53925f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ a f53926g;

        /* renamed from: h  reason: collision with root package name */
        private ConstraintLayout f53927h;

        /* renamed from: i  reason: collision with root package name */
        private View f53928i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, View view) {
            super(view);
            k.c(view, "view");
            this.f53926g = aVar;
            this.f53928i = view;
            View findViewById = this.f53928i.findViewById(R.id.tv_initials);
            k.a((Object) findViewById, "view.findViewById(R.id.tv_initials)");
            this.f53920a = (TextView) findViewById;
            View findViewById2 = this.f53928i.findViewById(R.id.iv_profile_pic);
            k.a((Object) findViewById2, "view.findViewById(R.id.iv_profile_pic)");
            this.f53921b = (ImageView) findViewById2;
            View findViewById3 = this.f53928i.findViewById(R.id.tv_contact_name);
            k.a((Object) findViewById3, "view.findViewById(R.id.tv_contact_name)");
            this.f53922c = (TextView) findViewById3;
            View findViewById4 = this.f53928i.findViewById(R.id.tv_contact_number);
            k.a((Object) findViewById4, "view.findViewById(R.id.tv_contact_number)");
            this.f53923d = (TextView) findViewById4;
            View findViewById5 = this.f53928i.findViewById(R.id.cl_parent);
            k.a((Object) findViewById5, "view.findViewById(R.id.cl_parent)");
            this.f53927h = (ConstraintLayout) findViewById5;
            View findViewById6 = this.f53928i.findViewById(R.id.divider);
            k.a((Object) findViewById6, "view.findViewById(R.id.divider)");
            this.f53924e = findViewById6;
            View findViewById7 = this.f53928i.findViewById(R.id.progress_bar);
            k.a((Object) findViewById7, "view.findViewById(R.id.progress_bar)");
            this.f53925f = (CircularProgressBar) findViewById7;
        }

        public final void a(String str, TextView textView) {
            k.c(str, "data");
            k.c(textView, "view");
            if (!TextUtils.isEmpty(this.f53926g.f53912e)) {
                CharSequence charSequence = str;
                if (!TextUtils.isEmpty(charSequence)) {
                    try {
                        String lowerCase = str.toLowerCase();
                        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                        CharSequence charSequence2 = lowerCase;
                        String str2 = this.f53926g.f53912e;
                        if (str2 != null) {
                            String lowerCase2 = str2.toLowerCase();
                            k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                            int a2 = p.a(charSequence2, lowerCase2, 0, false, 6);
                            int length = this.f53926g.f53912e.length() + a2;
                            Spannable spannableString = new SpannableString(str);
                            Context context = this.f53926g.f53908a;
                            if (context == null) {
                                k.a();
                            }
                            spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.black)), a2, length, 33);
                            spannableString.setSpan(new StyleSpan(1), a2, length, 33);
                            textView.setText(spannableString);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    } catch (Exception unused) {
                        if (!TextUtils.isEmpty(charSequence)) {
                            textView.setText(charSequence);
                            return;
                        }
                        return;
                    }
                }
            }
            CharSequence charSequence3 = str;
            if (!TextUtils.isEmpty(charSequence3)) {
                textView.setText(charSequence3);
            }
        }
    }

    /* renamed from: net.one97.paytm.moneytransfer.contacts.a.a$a  reason: collision with other inner class name */
    public final class C0963a extends Filter {
        public C0963a() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            String valueOf = String.valueOf(charSequence);
            if (valueOf != null) {
                String lowerCase = valueOf.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                a aVar = a.this;
                k.c(lowerCase, "<set-?>");
                aVar.f53912e = lowerCase;
                Filter.FilterResults filterResults = new Filter.FilterResults();
                if (lowerCase == null || lowerCase.length() <= 0) {
                    ArrayList<ContactItemModel> arrayList = a.this.f53909b;
                    Integer valueOf2 = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
                    if (valueOf2 == null) {
                        k.a();
                    }
                    filterResults.count = valueOf2.intValue();
                    filterResults.values = a.this.f53909b;
                } else {
                    ArrayList<ContactItemModel> a2 = a(a.this.f53912e);
                    filterResults.count = a2.size();
                    filterResults.values = a2;
                }
                return filterResults;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0051, code lost:
            if (kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r10, false) == false) goto L_0x005a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.util.ArrayList<net.one97.paytm.upi.requestmoney.model.ContactItemModel> a(java.lang.String r10) {
            /*
                r9 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                net.one97.paytm.moneytransfer.contacts.a.a r1 = net.one97.paytm.moneytransfer.contacts.a.a.this
                java.util.ArrayList<net.one97.paytm.upi.requestmoney.model.ContactItemModel> r1 = r1.f53910c
                if (r1 == 0) goto L_0x00a7
                r2 = 0
                int r3 = r1.size()
            L_0x0010:
                if (r2 >= r3) goto L_0x00a7
                java.lang.Object r4 = r1.get(r2)
                java.lang.String r5 = "it.get(i)"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                net.one97.paytm.upi.requestmoney.model.ContactItemModel r4 = (net.one97.paytm.upi.requestmoney.model.ContactItemModel) r4
                java.lang.String r4 = r4.getName()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                java.lang.String r6 = "null cannot be cast to non-null type java.lang.String"
                java.lang.String r7 = "(this as java.lang.String).toLowerCase()"
                if (r4 != 0) goto L_0x005a
                java.lang.Object r4 = r1.get(r2)
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                net.one97.paytm.upi.requestmoney.model.ContactItemModel r4 = (net.one97.paytm.upi.requestmoney.model.ContactItemModel) r4
                java.lang.String r4 = r4.getName()
                java.lang.String r8 = "it.get(i).name"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
                if (r4 == 0) goto L_0x0054
                java.lang.String r4 = r4.toLowerCase()
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                r8 = r10
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                boolean r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r8, false)
                if (r4 != 0) goto L_0x0095
                goto L_0x005a
            L_0x0054:
                kotlin.u r10 = new kotlin.u
                r10.<init>(r6)
                throw r10
            L_0x005a:
                java.lang.Object r4 = r1.get(r2)
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                net.one97.paytm.upi.requestmoney.model.ContactItemModel r4 = (net.one97.paytm.upi.requestmoney.model.ContactItemModel) r4
                java.lang.String r4 = r4.getPhnNo()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 != 0) goto L_0x00a3
                java.lang.Object r4 = r1.get(r2)
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                net.one97.paytm.upi.requestmoney.model.ContactItemModel r4 = (net.one97.paytm.upi.requestmoney.model.ContactItemModel) r4
                java.lang.String r4 = r4.getPhnNo()
                java.lang.String r5 = "it.get(i).phnNo"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                if (r4 == 0) goto L_0x009d
                java.lang.String r4 = r4.toLowerCase()
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                r5 = r10
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                boolean r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, false)
                if (r4 == 0) goto L_0x00a3
            L_0x0095:
                java.lang.Object r4 = r1.get(r2)
                r0.add(r4)
                goto L_0x00a3
            L_0x009d:
                kotlin.u r10 = new kotlin.u
                r10.<init>(r6)
                throw r10
            L_0x00a3:
                int r2 = r2 + 1
                goto L_0x0010
            L_0x00a7:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.contacts.a.a.C0963a.a(java.lang.String):java.util.ArrayList");
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            a aVar = a.this;
            Object obj = filterResults != null ? filterResults.values : null;
            if (obj != null) {
                aVar.a((ArrayList) obj);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.upi.requestmoney.model.ContactItemModel> /* = java.util.ArrayList<net.one97.paytm.upi.requestmoney.model.ContactItemModel> */");
        }
    }
}

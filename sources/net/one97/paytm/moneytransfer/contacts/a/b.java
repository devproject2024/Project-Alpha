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
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.model.ContactItemModel;
import net.one97.paytm.moneytransfer.utils.CircularProgressBar;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.upi.util.CircleTransform;

public final class b extends RecyclerView.a<RecyclerView.v> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    Context f53932a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<ContactItemModel> f53933b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ContactItemModel> f53934c;

    /* renamed from: d  reason: collision with root package name */
    d f53935d;

    /* renamed from: e  reason: collision with root package name */
    public String f53936e = "";

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Integer> f53937f;

    /* renamed from: g  reason: collision with root package name */
    int f53938g = -1;

    /* renamed from: h  reason: collision with root package name */
    ContactItemModel f53939h;

    /* renamed from: i  reason: collision with root package name */
    private final int f53940i;
    private final int j = 1;
    private a k = new a();

    public interface d {
        void a(ContactItemModel contactItemModel, int i2);

        void a(boolean z);

        void c();
    }

    public final Filter getFilter() {
        return this.k;
    }

    public b(ArrayList<ContactItemModel> arrayList, Context context, d dVar) {
        k.c(arrayList, "contactList");
        this.f53932a = context;
        this.f53933b = arrayList;
        this.f53935d = dVar;
        this.f53937f = new ArrayList<>();
        ArrayList<Integer> arrayList2 = this.f53937f;
        if (arrayList2 == null) {
            k.a("colorList");
        }
        arrayList2.add(Integer.valueOf(Color.parseColor("#2cce86")));
        ArrayList<Integer> arrayList3 = this.f53937f;
        if (arrayList3 == null) {
            k.a("colorList");
        }
        arrayList3.add(Integer.valueOf(Color.parseColor("#6c7cff")));
        ArrayList<Integer> arrayList4 = this.f53937f;
        if (arrayList4 == null) {
            k.a("colorList");
        }
        arrayList4.add(Integer.valueOf(Color.parseColor("#ffa400")));
        ArrayList<Integer> arrayList5 = this.f53937f;
        if (arrayList5 == null) {
            k.a("colorList");
        }
        arrayList5.add(Integer.valueOf(Color.parseColor("#b069ec")));
        ArrayList<Integer> arrayList6 = this.f53937f;
        if (arrayList6 == null) {
            k.a("colorList");
        }
        arrayList6.add(Integer.valueOf(Color.parseColor("#40cdd8")));
        ArrayList<Integer> arrayList7 = this.f53937f;
        if (arrayList7 == null) {
            k.a("colorList");
        }
        arrayList7.add(Integer.valueOf(Color.parseColor("#fd5c7f")));
        ArrayList<Integer> arrayList8 = this.f53937f;
        if (arrayList8 == null) {
            k.a("colorList");
        }
        arrayList8.add(Integer.valueOf(Color.parseColor("#f2c110")));
        ArrayList<Integer> arrayList9 = this.f53937f;
        if (arrayList9 == null) {
            k.a("colorList");
        }
        arrayList9.add(Integer.valueOf(Color.parseColor("#f36bb4")));
        ArrayList<Integer> arrayList10 = this.f53937f;
        if (arrayList10 == null) {
            k.a("colorList");
        }
        arrayList10.add(Integer.valueOf(Color.parseColor("#3ab6f4")));
        ArrayList<Integer> arrayList11 = this.f53937f;
        if (arrayList11 == null) {
            k.a("colorList");
        }
        arrayList11.add(Integer.valueOf(Color.parseColor("#a6b7be")));
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f53940i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_contact_list_header, (ViewGroup) null);
            k.a((Object) inflate, "LayoutInflater.from(pare…ontact_list_header, null)");
            return new C0964b(inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_contact_list_item, (ViewGroup) null);
        k.a((Object) inflate2, "LayoutInflater.from(pare…_contact_list_item, null)");
        x.e eVar = new x.e();
        eVar.element = new c(this, inflate2);
        inflate2.setOnClickListener(new e(this, eVar));
        return (c) eVar.element;
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f53953a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f53954b;

        e(b bVar, x.e eVar) {
            this.f53953a = bVar;
            this.f53954b = eVar;
        }

        public final void onClick(View view) {
            d dVar;
            if (((c) this.f53954b.element).getAdapterPosition() != -1 && this.f53953a.f53933b != null && (dVar = this.f53953a.f53935d) != null) {
                ArrayList<ContactItemModel> arrayList = this.f53953a.f53933b;
                ContactItemModel contactItemModel = arrayList != null ? arrayList.get(((c) this.f53954b.element).getAdapterPosition()) : null;
                if (contactItemModel == null) {
                    k.a();
                }
                k.a((Object) contactItemModel, "contactList?.get(holder.adapterPosition)!!");
                dVar.a(contactItemModel, ((c) this.f53954b.element).getAdapterPosition());
            }
        }
    }

    public final int getItemCount() {
        Collection collection = this.f53933b;
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        ArrayList<ContactItemModel> arrayList = this.f53933b;
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
        if (vVar instanceof C0964b) {
            ArrayList<ContactItemModel> arrayList2 = this.f53933b;
            if (arrayList2 != null && (contactItemModel2 = arrayList2.get(i2)) != null) {
                k.a((Object) contactItemModel2, "it");
                k.c(contactItemModel2, "contactInfo");
                ((C0964b) vVar).f53942a.setText(contactItemModel2.getName());
            }
        } else if ((vVar instanceof c) && (arrayList = this.f53933b) != null && (contactItemModel = arrayList.get(i2)) != null) {
            c cVar = (c) vVar;
            k.a((Object) contactItemModel, "it");
            k.c(contactItemModel, "contactItemModel");
            String photoUri = contactItemModel.getPhotoUri();
            String name = contactItemModel.getName();
            String phnNo = contactItemModel.getPhnNo();
            k.a((Object) phnNo, "contactItemModel.phnNo");
            cVar.a(phnNo, cVar.f53947d);
            if (!TextUtils.isEmpty(name)) {
                k.a((Object) name, "name");
                cVar.a(name, cVar.f53946c);
                cVar.f53944a.setText(m.a(name));
                ArrayList<Integer> arrayList3 = cVar.f53950g.f53937f;
                if (arrayList3 == null) {
                    k.a("colorList");
                }
                Integer num = arrayList3.get(cVar.getAdapterPosition() % 10);
                k.a((Object) num, "colorList.get(adapterPosition % 10)");
                int intValue = num.intValue();
                Drawable background = cVar.f53944a.getBackground();
                if (background != null) {
                    GradientDrawable gradientDrawable = (GradientDrawable) background;
                    gradientDrawable.setColor(intValue);
                    cVar.f53944a.setBackground(gradientDrawable);
                } else {
                    throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                }
            }
            if (!TextUtils.isEmpty(photoUri)) {
                cVar.f53945b.setVisibility(0);
                cVar.f53944a.setVisibility(8);
                w.a().a(photoUri).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(cVar.f53945b);
            } else {
                cVar.f53945b.setVisibility(8);
                cVar.f53944a.setVisibility(0);
            }
            if (contactItemModel.isSelected()) {
                cVar.f53949f.setVisibility(0);
                cVar.f53950g.f53938g = cVar.getAdapterPosition();
                cVar.f53950g.f53939h = contactItemModel;
            } else {
                cVar.f53949f.setVisibility(4);
            }
            d dVar = cVar.f53950g.f53935d;
            if (dVar != null) {
                dVar.c();
            }
            d dVar2 = cVar.f53950g.f53935d;
            if (dVar2 != null) {
                dVar2.a(false);
            }
            ArrayList<ContactItemModel> arrayList4 = cVar.f53950g.f53933b;
            Integer valueOf = arrayList4 != null ? Integer.valueOf(arrayList4.size()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (i2 == valueOf.intValue() - 1) {
                cVar.f53948e.setVisibility(4);
            } else {
                cVar.f53948e.setVisibility(0);
            }
        }
    }

    public final void a(ArrayList<ContactItemModel> arrayList) {
        k.c(arrayList, "newList");
        if (arrayList.size() == 0) {
            this.f53933b = arrayList;
            notifyDataSetChanged();
            d dVar = this.f53935d;
            if (dVar != null) {
                dVar.a(true);
                return;
            }
            return;
        }
        ArrayList<ContactItemModel> arrayList2 = this.f53933b;
        if (arrayList2 == null || (arrayList2 != null && arrayList2.size() == 0)) {
            this.f53933b = arrayList;
            notifyItemRangeInserted(0, arrayList.size());
            return;
        }
        this.f53933b = arrayList;
        notifyDataSetChanged();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r0.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getItemViewType(int r2) {
        /*
            r1 = this;
            java.util.ArrayList<net.one97.paytm.moneytransfer.model.ContactItemModel> r0 = r1.f53933b
            if (r0 == 0) goto L_0x0015
            java.lang.Object r2 = r0.get(r2)
            net.one97.paytm.moneytransfer.model.ContactItemModel r2 = (net.one97.paytm.moneytransfer.model.ContactItemModel) r2
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
            int r2 = r1.f53940i
            return r2
        L_0x0024:
            int r2 = r1.j
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.contacts.a.b.getItemViewType(int):int");
    }

    /* renamed from: net.one97.paytm.moneytransfer.contacts.a.b$b  reason: collision with other inner class name */
    public static final class C0964b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f53942a;

        /* renamed from: b  reason: collision with root package name */
        private View f53943b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0964b(View view) {
            super(view);
            k.c(view, "view");
            this.f53943b = view;
            View findViewById = this.f53943b.findViewById(R.id.tv_header_title);
            k.a((Object) findViewById, "view.findViewById<TextView>(R.id.tv_header_title)");
            this.f53942a = (TextView) findViewById;
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f53944a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f53945b;

        /* renamed from: c  reason: collision with root package name */
        TextView f53946c;

        /* renamed from: d  reason: collision with root package name */
        TextView f53947d;

        /* renamed from: e  reason: collision with root package name */
        View f53948e;

        /* renamed from: f  reason: collision with root package name */
        CircularProgressBar f53949f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ b f53950g;

        /* renamed from: h  reason: collision with root package name */
        private ConstraintLayout f53951h;

        /* renamed from: i  reason: collision with root package name */
        private View f53952i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, View view) {
            super(view);
            k.c(view, "view");
            this.f53950g = bVar;
            this.f53952i = view;
            View findViewById = this.f53952i.findViewById(R.id.tv_initials);
            k.a((Object) findViewById, "view.findViewById(R.id.tv_initials)");
            this.f53944a = (TextView) findViewById;
            View findViewById2 = this.f53952i.findViewById(R.id.iv_profile_pic);
            k.a((Object) findViewById2, "view.findViewById(R.id.iv_profile_pic)");
            this.f53945b = (ImageView) findViewById2;
            View findViewById3 = this.f53952i.findViewById(R.id.tv_contact_name);
            k.a((Object) findViewById3, "view.findViewById(R.id.tv_contact_name)");
            this.f53946c = (TextView) findViewById3;
            View findViewById4 = this.f53952i.findViewById(R.id.tv_contact_number);
            k.a((Object) findViewById4, "view.findViewById(R.id.tv_contact_number)");
            this.f53947d = (TextView) findViewById4;
            View findViewById5 = this.f53952i.findViewById(R.id.cl_parent);
            k.a((Object) findViewById5, "view.findViewById(R.id.cl_parent)");
            this.f53951h = (ConstraintLayout) findViewById5;
            View findViewById6 = this.f53952i.findViewById(R.id.divider);
            k.a((Object) findViewById6, "view.findViewById(R.id.divider)");
            this.f53948e = findViewById6;
            View findViewById7 = this.f53952i.findViewById(R.id.progress_bar);
            k.a((Object) findViewById7, "view.findViewById(R.id.progress_bar)");
            this.f53949f = (CircularProgressBar) findViewById7;
        }

        public final void a(String str, TextView textView) {
            k.c(str, "data");
            k.c(textView, "view");
            if (!TextUtils.isEmpty(this.f53950g.f53936e)) {
                CharSequence charSequence = str;
                if (!TextUtils.isEmpty(charSequence)) {
                    try {
                        String lowerCase = str.toLowerCase();
                        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                        CharSequence charSequence2 = lowerCase;
                        String str2 = this.f53950g.f53936e;
                        if (str2 != null) {
                            String lowerCase2 = str2.toLowerCase();
                            k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                            int a2 = p.a(charSequence2, lowerCase2, 0, false, 6);
                            int length = this.f53950g.f53936e.length() + a2;
                            Spannable spannableString = new SpannableString(str);
                            Context context = this.f53950g.f53932a;
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

    public final class a extends Filter {
        public a() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            String valueOf = String.valueOf(charSequence);
            if (valueOf != null) {
                String lowerCase = valueOf.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                b bVar = b.this;
                k.c(lowerCase, "<set-?>");
                bVar.f53936e = lowerCase;
                Filter.FilterResults filterResults = new Filter.FilterResults();
                if (lowerCase == null || lowerCase.length() <= 0) {
                    ArrayList<ContactItemModel> arrayList = b.this.f53933b;
                    Integer valueOf2 = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
                    if (valueOf2 == null) {
                        k.a();
                    }
                    filterResults.count = valueOf2.intValue();
                    filterResults.values = b.this.f53933b;
                } else {
                    ArrayList<ContactItemModel> a2 = a(b.this.f53936e);
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
        private final java.util.ArrayList<net.one97.paytm.moneytransfer.model.ContactItemModel> a(java.lang.String r10) {
            /*
                r9 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                net.one97.paytm.moneytransfer.contacts.a.b r1 = net.one97.paytm.moneytransfer.contacts.a.b.this
                java.util.ArrayList<net.one97.paytm.moneytransfer.model.ContactItemModel> r1 = r1.f53934c
                if (r1 == 0) goto L_0x00a7
                r2 = 0
                int r3 = r1.size()
            L_0x0010:
                if (r2 >= r3) goto L_0x00a7
                java.lang.Object r4 = r1.get(r2)
                java.lang.String r5 = "it.get(i)"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                net.one97.paytm.moneytransfer.model.ContactItemModel r4 = (net.one97.paytm.moneytransfer.model.ContactItemModel) r4
                java.lang.String r4 = r4.getName()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                java.lang.String r6 = "null cannot be cast to non-null type java.lang.String"
                java.lang.String r7 = "(this as java.lang.String).toLowerCase()"
                if (r4 != 0) goto L_0x005a
                java.lang.Object r4 = r1.get(r2)
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                net.one97.paytm.moneytransfer.model.ContactItemModel r4 = (net.one97.paytm.moneytransfer.model.ContactItemModel) r4
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
                net.one97.paytm.moneytransfer.model.ContactItemModel r4 = (net.one97.paytm.moneytransfer.model.ContactItemModel) r4
                java.lang.String r4 = r4.getPhnNo()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 != 0) goto L_0x00a3
                java.lang.Object r4 = r1.get(r2)
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                net.one97.paytm.moneytransfer.model.ContactItemModel r4 = (net.one97.paytm.moneytransfer.model.ContactItemModel) r4
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
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.contacts.a.b.a.a(java.lang.String):java.util.ArrayList");
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            b bVar = b.this;
            Object obj = filterResults != null ? filterResults.values : null;
            if (obj != null) {
                bVar.a((ArrayList<ContactItemModel>) (ArrayList) obj);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.moneytransfer.model.ContactItemModel> /* = java.util.ArrayList<net.one97.paytm.moneytransfer.model.ContactItemModel> */");
        }
    }

    public final void a(int i2) {
        ArrayList<ContactItemModel> arrayList = this.f53933b;
        if (!(arrayList == null || i2 == -1)) {
            ContactItemModel contactItemModel = arrayList.get(i2);
            k.a((Object) contactItemModel, "it[newPosition]");
            contactItemModel.setSelected(true);
        }
        ContactItemModel contactItemModel2 = this.f53939h;
        if (contactItemModel2 != null) {
            contactItemModel2.setSelected(false);
        }
        int i3 = this.f53938g;
        this.f53938g = i2;
        notifyItemChanged(i3);
        int i4 = this.f53938g;
        if (i4 >= 0 && i4 < getItemCount()) {
            notifyItemChanged(this.f53938g);
        }
    }
}

package com.paytm.android.chat.contact;

import android.content.Context;
import android.graphics.Color;
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
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.view.ChatHeadView;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class e extends RecyclerView.a<RecyclerView.v> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    Context f41855a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<a> f41856b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<a> f41857c;

    /* renamed from: d  reason: collision with root package name */
    C0694e f41858d;

    /* renamed from: e  reason: collision with root package name */
    String f41859e = "";

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Integer> f41860f;

    /* renamed from: g  reason: collision with root package name */
    boolean f41861g = true;

    /* renamed from: h  reason: collision with root package name */
    private final int f41862h;

    /* renamed from: i  reason: collision with root package name */
    private final int f41863i = 1;
    private final int j = 2;
    private final int k = 3;
    private View l;
    private a m = new a();
    private int n = -1;

    /* renamed from: com.paytm.android.chat.contact.e$e  reason: collision with other inner class name */
    public interface C0694e {
        void a(a aVar);
    }

    public final Filter getFilter() {
        return this.m;
    }

    public e(ArrayList<a> arrayList, Context context, C0694e eVar) {
        k.c(arrayList, "contactList");
        this.f41855a = context;
        this.f41856b = arrayList;
        this.f41858d = eVar;
        this.f41860f = new ArrayList<>();
        ArrayList<Integer> arrayList2 = this.f41860f;
        if (arrayList2 == null) {
            k.a("colorList");
        }
        arrayList2.add(Integer.valueOf(Color.parseColor("#FC5C7E")));
        ArrayList<Integer> arrayList3 = this.f41860f;
        if (arrayList3 == null) {
            k.a("colorList");
        }
        arrayList3.add(Integer.valueOf(Color.parseColor("#F1C10E")));
        ArrayList<Integer> arrayList4 = this.f41860f;
        if (arrayList4 == null) {
            k.a("colorList");
        }
        arrayList4.add(Integer.valueOf(Color.parseColor("#F36BB4")));
        ArrayList<Integer> arrayList5 = this.f41860f;
        if (arrayList5 == null) {
            k.a("colorList");
        }
        arrayList5.add(Integer.valueOf(Color.parseColor("#2ACE86")));
        ArrayList<Integer> arrayList6 = this.f41860f;
        if (arrayList6 == null) {
            k.a("colorList");
        }
        arrayList6.add(Integer.valueOf(Color.parseColor("#40CED8")));
        ArrayList<Integer> arrayList7 = this.f41860f;
        if (arrayList7 == null) {
            k.a("colorList");
        }
        arrayList7.add(Integer.valueOf(Color.parseColor("#3BB6F4")));
        ArrayList<Integer> arrayList8 = this.f41860f;
        if (arrayList8 == null) {
            k.a("colorList");
        }
        arrayList8.add(Integer.valueOf(Color.parseColor("#6C7BFF")));
        ArrayList<Integer> arrayList9 = this.f41860f;
        if (arrayList9 == null) {
            k.a("colorList");
        }
        arrayList9.add(Integer.valueOf(Color.parseColor("#B069EC")));
        ArrayList<Integer> arrayList10 = this.f41860f;
        if (arrayList10 == null) {
            k.a("colorList");
        }
        arrayList10.add(Integer.valueOf(Color.parseColor("#FFA400")));
        ArrayList<Integer> arrayList11 = this.f41860f;
        if (arrayList11 == null) {
            k.a("colorList");
        }
        arrayList11.add(Integer.valueOf(Color.parseColor("#F352A4")));
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f41862h) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_contact_list_header, (ViewGroup) null);
            k.a((Object) inflate, "LayoutInflater.from(pare…ontact_list_header, null)");
            return new c(inflate);
        } else if (i2 == this.j) {
            if (this.l == null) {
                this.l = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item_footer_empty, (ViewGroup) null);
            }
            View view = this.l;
            if (view == null) {
                k.a();
            }
            return new b(view);
        } else {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_contact_list_item, (ViewGroup) null);
            k.a((Object) inflate2, "LayoutInflater.from(pare…_contact_list_item, null)");
            x.e eVar = new x.e();
            eVar.element = new d(this, inflate2);
            inflate2.setOnClickListener(new f(this, eVar));
            return (d) eVar.element;
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f41875a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f41876b;

        f(e eVar, x.e eVar2) {
            this.f41875a = eVar;
            this.f41876b = eVar2;
        }

        public final void onClick(View view) {
            C0694e eVar;
            ArrayList<a> arrayList = this.f41875a.f41856b;
            a aVar = null;
            Integer valueOf = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.intValue() > ((d) this.f41876b.element).getAdapterPosition() && this.f41875a.f41856b != null && (eVar = this.f41875a.f41858d) != null) {
                ArrayList<a> arrayList2 = this.f41875a.f41856b;
                if (arrayList2 != null) {
                    aVar = arrayList2.get(((d) this.f41876b.element).getAdapterPosition());
                }
                if (aVar == null) {
                    k.a();
                }
                k.a((Object) aVar, "contactList?.get(holder.adapterPosition)!!");
                ((d) this.f41876b.element).getAdapterPosition();
                eVar.a(aVar);
            }
        }
    }

    public final int getItemCount() {
        Collection collection = this.f41856b;
        int i2 = 0;
        if (!(collection == null || collection.isEmpty())) {
            ArrayList<a> arrayList = this.f41856b;
            Integer valueOf = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
            if (valueOf == null) {
                k.a();
            }
            i2 = valueOf.intValue();
        }
        return this.l != null ? i2 + 1 : i2;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ArrayList<a> arrayList;
        a aVar;
        a aVar2;
        k.c(vVar, "holder");
        int itemViewType = getItemViewType(i2);
        if (itemViewType != this.j && itemViewType != this.k) {
            if (vVar instanceof c) {
                ArrayList<a> arrayList2 = this.f41856b;
                if (arrayList2 != null && (aVar2 = arrayList2.get(i2)) != null) {
                    k.a((Object) aVar2, "it");
                    k.c(aVar2, "contactInfo");
                    ((c) vVar).f41866a.setText(aVar2.getName());
                }
            } else if ((vVar instanceof d) && (arrayList = this.f41856b) != null && (aVar = arrayList.get(i2)) != null) {
                d dVar = (d) vVar;
                k.a((Object) aVar, "it");
                k.c(aVar, "contactItemModel");
                String photoUri = aVar.getPhotoUri();
                String name = aVar.getName();
                String phnNo = aVar.getPhnNo();
                CharSequence phnNo2 = aVar.getPhnNo();
                if (!(phnNo2 == null || phnNo2.length() == 0)) {
                    dVar.f41870c.setText(aVar.getPhnNo());
                }
                CharSequence charSequence = name;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    k.a((Object) name, "name");
                    TextView textView = dVar.f41869b;
                    k.c(name, "data");
                    k.c(textView, "view");
                    if (!TextUtils.isEmpty(dVar.f41872e.f41859e) && !TextUtils.isEmpty(charSequence)) {
                        try {
                            String lowerCase = name.toLowerCase();
                            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                            CharSequence charSequence2 = lowerCase;
                            String str = dVar.f41872e.f41859e;
                            if (str != null) {
                                String lowerCase2 = str.toLowerCase();
                                k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                                int a2 = p.a(charSequence2, lowerCase2, 0, false, 6);
                                int length = dVar.f41872e.f41859e.length() + a2;
                                Spannable spannableString = new SpannableString(name);
                                Context context = dVar.f41872e.f41855a;
                                if (context == null) {
                                    k.a();
                                }
                                spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.black)), a2, length, 33);
                                spannableString.setSpan(new StyleSpan(1), a2, length, 33);
                                textView.setText(spannableString);
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        } catch (Exception unused) {
                            if (!TextUtils.isEmpty(charSequence)) {
                                textView.setText(charSequence);
                            }
                        }
                    } else if (!TextUtils.isEmpty(charSequence)) {
                        textView.setText(charSequence);
                    }
                }
                dVar.f41868a.setUI(photoUri, name, name, phnNo);
                if (dVar.f41872e.f41861g) {
                    ArrayList<a> arrayList3 = dVar.f41872e.f41856b;
                    Integer valueOf = arrayList3 != null ? Integer.valueOf(arrayList3.size()) : null;
                    if (valueOf == null) {
                        k.a();
                    }
                    if (i2 != valueOf.intValue() - 1) {
                        dVar.f41871d.setVisibility(0);
                        return;
                    }
                }
                dVar.f41871d.setVisibility(4);
            }
        }
    }

    public final void a(ArrayList<a> arrayList) {
        Collection collection = arrayList;
        if (collection == null || collection.isEmpty()) {
            this.f41856b = arrayList;
            notifyDataSetChanged();
            return;
        }
        ArrayList<a> arrayList2 = this.f41856b;
        if (arrayList2 == null || (arrayList2 != null && arrayList2.size() == 0)) {
            this.f41856b = arrayList;
            notifyItemRangeInserted(0, arrayList.size());
            return;
        }
        this.f41856b = arrayList;
        notifyDataSetChanged();
    }

    public final int getItemViewType(int i2) {
        a aVar;
        if (this.l != null && i2 == getItemCount() - 1) {
            return this.j;
        }
        ArrayList<a> arrayList = this.f41856b;
        if (arrayList != null) {
            Boolean bool = null;
            Integer valueOf = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.intValue() > 0) {
                ArrayList<a> arrayList2 = this.f41856b;
                Integer valueOf2 = arrayList2 != null ? Integer.valueOf(arrayList2.size()) : null;
                if (valueOf2 == null) {
                    k.a();
                }
                if (i2 < valueOf2.intValue()) {
                    ArrayList<a> arrayList3 = this.f41856b;
                    if (!(arrayList3 == null || (aVar = arrayList3.get(i2)) == null)) {
                        bool = Boolean.valueOf(aVar.ismIsHeading());
                    }
                    if (bool == null) {
                        k.a();
                    }
                    if (bool.booleanValue()) {
                        return this.f41862h;
                    }
                }
            }
        }
        return this.f41863i;
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        private View f41865a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "view");
            this.f41865a = view;
        }
    }

    public static final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f41866a;

        /* renamed from: b  reason: collision with root package name */
        private View f41867b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            k.c(view, "view");
            this.f41867b = view;
            View findViewById = this.f41867b.findViewById(R.id.tv_header_title);
            k.a((Object) findViewById, "view.findViewById<TextView>(R.id.tv_header_title)");
            this.f41866a = (TextView) findViewById;
        }
    }

    public final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ChatHeadView f41868a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41869b;

        /* renamed from: c  reason: collision with root package name */
        TextView f41870c;

        /* renamed from: d  reason: collision with root package name */
        View f41871d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ e f41872e;

        /* renamed from: f  reason: collision with root package name */
        private ConstraintLayout f41873f;

        /* renamed from: g  reason: collision with root package name */
        private View f41874g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(e eVar, View view) {
            super(view);
            k.c(view, "view");
            this.f41872e = eVar;
            this.f41874g = view;
            View findViewById = this.f41874g.findViewById(R.id.tv_initials);
            k.a((Object) findViewById, "view.findViewById(R.id.tv_initials)");
            this.f41868a = (ChatHeadView) findViewById;
            View findViewById2 = this.f41874g.findViewById(R.id.tv_contact_name);
            k.a((Object) findViewById2, "view.findViewById(R.id.tv_contact_name)");
            this.f41869b = (TextView) findViewById2;
            View findViewById3 = this.f41874g.findViewById(R.id.tv_contact_number);
            k.a((Object) findViewById3, "view.findViewById(R.id.tv_contact_number)");
            this.f41870c = (TextView) findViewById3;
            View findViewById4 = this.f41874g.findViewById(R.id.cl_parent);
            k.a((Object) findViewById4, "view.findViewById(R.id.cl_parent)");
            this.f41873f = (ConstraintLayout) findViewById4;
            View findViewById5 = this.f41874g.findViewById(R.id.divider);
            k.a((Object) findViewById5, "view.findViewById(R.id.divider)");
            this.f41871d = findViewById5;
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
                e eVar = e.this;
                k.c(lowerCase, "<set-?>");
                eVar.f41859e = lowerCase;
                Filter.FilterResults filterResults = new Filter.FilterResults();
                if (lowerCase.length() <= 0 || lowerCase.equals("null")) {
                    ArrayList<a> arrayList = e.this.f41856b;
                    Integer valueOf2 = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
                    if (valueOf2 == null) {
                        k.a();
                    }
                    filterResults.count = valueOf2.intValue();
                    filterResults.values = e.this.f41856b;
                } else {
                    ArrayList<a> a2 = a(e.this.f41859e);
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
        private final java.util.ArrayList<com.paytm.android.chat.contact.a> a(java.lang.String r10) {
            /*
                r9 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                com.paytm.android.chat.contact.e r1 = com.paytm.android.chat.contact.e.this
                java.util.ArrayList<com.paytm.android.chat.contact.a> r1 = r1.f41857c
                if (r1 == 0) goto L_0x00a7
                r2 = 0
                int r3 = r1.size()
            L_0x0010:
                if (r2 >= r3) goto L_0x00a7
                java.lang.Object r4 = r1.get(r2)
                java.lang.String r5 = "it.get(i)"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                com.paytm.android.chat.contact.a r4 = (com.paytm.android.chat.contact.a) r4
                java.lang.String r4 = r4.getName()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                java.lang.String r6 = "null cannot be cast to non-null type java.lang.String"
                java.lang.String r7 = "(this as java.lang.String).toLowerCase()"
                if (r4 != 0) goto L_0x005a
                java.lang.Object r4 = r1.get(r2)
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                com.paytm.android.chat.contact.a r4 = (com.paytm.android.chat.contact.a) r4
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
                com.paytm.android.chat.contact.a r4 = (com.paytm.android.chat.contact.a) r4
                java.lang.String r4 = r4.getPhnNo()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 != 0) goto L_0x00a3
                java.lang.Object r4 = r1.get(r2)
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                com.paytm.android.chat.contact.a r4 = (com.paytm.android.chat.contact.a) r4
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
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.contact.e.a.a(java.lang.String):java.util.ArrayList");
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            e eVar = e.this;
            Object obj = filterResults != null ? filterResults.values : null;
            if (obj != null) {
                eVar.a((ArrayList<a>) (ArrayList) obj);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.paytm.android.chat.contact.ChatContactItemModel> /* = java.util.ArrayList<com.paytm.android.chat.contact.ChatContactItemModel> */");
        }
    }

    public final void a(String str) {
        k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        this.f41859e = str;
    }

    public final void b(ArrayList<a> arrayList) {
        k.c(arrayList, "originalList");
        this.f41857c = arrayList;
    }
}

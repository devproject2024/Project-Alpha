package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.contactsSdk.database.Tables;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.g;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.common.e.ae;
import net.one97.paytm.recharge.common.e.j;
import net.one97.paytm.recharge.common.widget.CJRContactListV8;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.widgets.c.d;

public final class r extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends CJRFrequentOrder> f60657a;

    /* renamed from: b  reason: collision with root package name */
    public p f60658b;

    /* renamed from: c  reason: collision with root package name */
    public List<? extends ContactItemModel> f60659c;

    /* renamed from: d  reason: collision with root package name */
    public g f60660d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Object> f60661e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Object> f60662f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public boolean f60663g;

    /* renamed from: h  reason: collision with root package name */
    public j f60664h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f60665i;
    private ae j;
    private final int k;
    private final int l = 1;
    private final int m = 2;
    private final int n = 4;
    private final int o = 5;
    private final int p = 6;
    private boolean q;
    private String r = "";

    public r(Context context) {
        k.c(context, "context");
        this.f60665i = context;
    }

    public final void a(List<? extends ContactItemModel> list, CJRContactListV8.a aVar) {
        List<? extends ContactItemModel> list2;
        k.c(list, Tables.CONTACTS);
        k.c(aVar, "options");
        this.f60659c = list;
        if (this.f60661e == null) {
            this.f60661e = new ArrayList<>();
        }
        if (this.f60662f == null) {
            this.f60662f = new ArrayList<>();
        }
        List<? extends ContactItemModel> list3 = aVar.f61861b;
        if (list3 != null) {
            ArrayList<Object> arrayList = this.f60661e;
            if (arrayList != null && (!arrayList.isEmpty()) && (list2 = this.f60659c) != null && (!list2.isEmpty())) {
                ArrayList<Object> arrayList2 = this.f60662f;
                if (arrayList2 != null) {
                    arrayList2.add((byte) 1);
                }
                ArrayList<Object> arrayList3 = this.f60661e;
                if (arrayList3 != null) {
                    arrayList3.add((byte) 1);
                }
            }
            ArrayList<Object> arrayList4 = this.f60661e;
            if (arrayList4 != null) {
                arrayList4.addAll(list3);
            }
            ArrayList<Object> arrayList5 = this.f60662f;
            if (arrayList5 != null) {
                arrayList5.addAll(list3);
            }
            ArrayList<Object> arrayList6 = this.f60661e;
            if (arrayList6 != null) {
                if (arrayList6 == null) {
                    k.a();
                }
                notifyItemRangeChanged(arrayList6.size() - 1, list3.size() + 1);
            }
        }
        g gVar = this.f60660d;
        if (gVar == null) {
            this.f60660d = new g(aVar);
        } else if (gVar != null) {
            k.c(aVar, "latestOption");
            gVar.f60496a = aVar;
        }
    }

    public final void a() {
        this.f60663g = true;
        this.q = true;
    }

    public final int getItemViewType(int i2) {
        ArrayList<Object> arrayList = this.f60662f;
        if (arrayList == null) {
            return -1;
        }
        if (arrayList == null) {
            k.a();
        }
        if (arrayList.get(i2) instanceof CJRFrequentOrder) {
            return this.k;
        }
        ArrayList<Object> arrayList2 = this.f60662f;
        if (arrayList2 == null) {
            k.a();
        }
        if (arrayList2.get(i2) instanceof Byte) {
            return this.o;
        }
        ArrayList<Object> arrayList3 = this.f60662f;
        if (arrayList3 == null) {
            k.a();
        }
        if (arrayList3.get(i2) instanceof String) {
            return this.n;
        }
        ArrayList<Object> arrayList4 = this.f60662f;
        if (arrayList4 == null) {
            k.a();
        }
        if (!(arrayList4.get(i2) instanceof ContactItemModel)) {
            return -1;
        }
        ArrayList<Object> arrayList5 = this.f60662f;
        if (arrayList5 == null) {
            k.a();
        }
        Object obj = arrayList5.get(i2);
        if (obj == null) {
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.ContactItemModel");
        } else if (((ContactItemModel) obj).ismIsHeading()) {
            return this.p;
        } else {
            return this.l;
        }
    }

    public final int getItemCount() {
        ArrayList<Object> arrayList = this.f60662f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.k) {
            p pVar = this.f60658b;
            if (pVar == null) {
                k.a();
            }
            return pVar.onCreateViewHolder(viewGroup, i2);
        } else if (i2 == this.m) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v8_content_enter_mobile_number_contact_header, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…ct_header, parent, false)");
            return new a(inflate);
        } else if (i2 == this.l || i2 == this.p) {
            g gVar = this.f60660d;
            if (gVar == null) {
                k.a();
            }
            return gVar.onCreateViewHolder(viewGroup, i2);
        } else if (i2 == this.n) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_contact_item_header_v8, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(pare…header_v8, parent, false)");
            return new b(this, inflate2);
        } else if (i2 == this.o) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v3_list_separator_view, viewGroup, false);
            k.a((Object) inflate3, "LayoutInflater.from(pare…ator_view, parent, false)");
            return new c(inflate3);
        } else {
            throw new RuntimeException("View Holder Not Defined");
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        int itemViewType = getItemViewType(i2);
        Object obj = null;
        if (itemViewType == this.k) {
            if (vVar instanceof p.d) {
                p.d dVar = (p.d) vVar;
                String str = this.r;
                k.c(str, "searchedString");
                dVar.f60652a = str;
                ArrayList<Object> arrayList = this.f60662f;
                if (arrayList != null) {
                    obj = arrayList.get(i2);
                }
                if (obj != null) {
                    dVar.a(i2, (CJRFrequentOrder) obj);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.recharge.CJRFrequentOrder");
            }
        } else if (itemViewType == this.l) {
            if (vVar instanceof g.a) {
                g.a aVar = (g.a) vVar;
                ArrayList<Object> arrayList2 = this.f60662f;
                if (arrayList2 != null) {
                    obj = arrayList2.get(i2);
                }
                if (obj != null) {
                    aVar.a(i2, (ContactItemModel) obj, this.r);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.ContactItemModel");
            }
        } else if (itemViewType == this.m) {
            if (vVar instanceof a) {
                ((a) vVar).f60666a.setText(R.string.title_from_contacts);
            }
        } else if (itemViewType == this.n) {
            if (vVar instanceof b) {
                b bVar = (b) vVar;
                ArrayList<Object> arrayList3 = this.f60662f;
                if (arrayList3 != null) {
                    obj = arrayList3.get(i2);
                }
                if (obj != null) {
                    String str2 = (String) obj;
                    k.c(str2, "title");
                    bVar.f60667a.setText(str2);
                    bVar.f60668b.setVisibility(8);
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.String");
            }
        } else if (itemViewType == this.o) {
        } else {
            if (itemViewType != this.p) {
                throw new RuntimeException("View Holder Not Defined");
            } else if (vVar instanceof g.c) {
                g.c cVar = (g.c) vVar;
                ArrayList<Object> arrayList4 = this.f60662f;
                if (arrayList4 != null) {
                    obj = arrayList4.get(i2);
                }
                if (obj != null) {
                    ContactItemModel contactItemModel = (ContactItemModel) obj;
                    k.c(contactItemModel, "contactItemModel");
                    cVar.f60521f = contactItemModel;
                    String photoUri = contactItemModel.getPhotoUri();
                    String name = contactItemModel.getName();
                    CharSequence charSequence = name;
                    if (!TextUtils.isEmpty(charSequence)) {
                        cVar.f60516a.setText(charSequence);
                        d dVar2 = d.f64967a;
                        TextView textView = cVar.f60517b;
                        k.a((Object) name, "name");
                        d.a(textView, name, i2);
                    } else {
                        cVar.f60516a.setText("");
                        cVar.f60517b.setText("");
                        cVar.f60519d.setVisibility(0);
                    }
                    if (!TextUtils.isEmpty(photoUri)) {
                        cVar.f60519d.setVisibility(0);
                        cVar.f60517b.setVisibility(8);
                        w.a().a(photoUri).a(R.drawable.v3_default_logo_contact).b(R.drawable.v3_default_logo_contact).a(cVar.f60519d);
                    } else {
                        g.c cVar2 = cVar;
                        cVar2.f60519d.setVisibility(8);
                        cVar2.f60517b.setVisibility(0);
                    }
                    cVar.f60518c.setText(contactItemModel.getPhnNo());
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.ContactItemModel");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f2, code lost:
        if (kotlin.m.p.a(r5, (java.lang.CharSequence) r14, false) == true) goto L_0x00f4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0145 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r17, java.lang.String r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            java.lang.String r2 = "tag"
            kotlin.g.b.k.c(r1, r2)
            r2 = r17
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x001b
            boolean r2 = kotlin.m.p.a(r2)
            if (r2 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r2 = 0
            goto L_0x001c
        L_0x001b:
            r2 = 1
        L_0x001c:
            if (r2 != 0) goto L_0x0161
            java.lang.String r2 = r17.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r6 = r2.length()
            int r6 = r6 - r4
            r7 = r6
            r6 = 0
            r8 = 0
        L_0x002c:
            if (r6 > r7) goto L_0x004c
            if (r8 != 0) goto L_0x0032
            r9 = r6
            goto L_0x0033
        L_0x0032:
            r9 = r7
        L_0x0033:
            char r9 = r2.charAt(r9)
            r10 = 32
            if (r9 > r10) goto L_0x003d
            r9 = 1
            goto L_0x003e
        L_0x003d:
            r9 = 0
        L_0x003e:
            if (r8 != 0) goto L_0x0047
            if (r9 != 0) goto L_0x0044
            r8 = 1
            goto L_0x002c
        L_0x0044:
            int r6 = r6 + 1
            goto L_0x002c
        L_0x0047:
            if (r9 == 0) goto L_0x004c
            int r7 = r7 + -1
            goto L_0x002c
        L_0x004c:
            int r7 = r7 + r4
            java.lang.CharSequence r2 = r2.subSequence(r6, r7)
            java.lang.String r2 = r2.toString()
            java.util.Locale r6 = java.util.Locale.getDefault()
            java.lang.String r7 = "Locale.getDefault()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r8 = "null cannot be cast to non-null type java.lang.String"
            if (r2 == 0) goto L_0x015b
            java.lang.String r2 = r2.toLowerCase(r6)
            java.lang.String r6 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            r0.r = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList<java.lang.Object> r9 = r0.f60661e
            if (r9 == 0) goto L_0x014a
            if (r9 != 0) goto L_0x007b
            kotlin.g.b.k.a()
        L_0x007b:
            java.util.Collection r9 = (java.util.Collection) r9
            int r9 = r9.size()
            r10 = 0
            r11 = 0
        L_0x0083:
            if (r10 >= r9) goto L_0x014a
            java.util.ArrayList<java.lang.Object> r12 = r0.f60661e
            if (r12 != 0) goto L_0x008c
            kotlin.g.b.k.a()
        L_0x008c:
            java.lang.Object r12 = r12.get(r10)
            java.lang.String r13 = "originalItems!![i]"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            boolean r13 = r12 instanceof net.one97.paytm.common.entity.recharge.CJRFrequentOrder
            if (r13 == 0) goto L_0x00a7
            r11 = r12
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r11 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r11
            java.lang.String r13 = r11.getRechargeNumber()
            java.lang.String r11 = r11.getContactName()
            r14 = r11
            r11 = 0
            goto L_0x00bd
        L_0x00a7:
            boolean r13 = r12 instanceof net.one97.paytm.recharge.model.ContactItemModel
            if (r13 == 0) goto L_0x00bb
            r11 = r12
            net.one97.paytm.recharge.model.ContactItemModel r11 = (net.one97.paytm.recharge.model.ContactItemModel) r11
            java.lang.String r13 = r11.getPhnNo()
            java.lang.String r14 = r11.getName()
            boolean r11 = r11.ismIsHeading()
            goto L_0x00bd
        L_0x00bb:
            r13 = 0
            r14 = 0
        L_0x00bd:
            java.lang.String r15 = r0.r
            if (r13 == 0) goto L_0x00c7
            boolean r5 = kotlin.m.p.b(r13, r15, r3)
            if (r5 == r4) goto L_0x00f4
        L_0x00c7:
            boolean r5 = r0.q
            if (r5 == 0) goto L_0x0102
            if (r14 == 0) goto L_0x0102
            java.util.Locale r5 = java.util.Locale.getDefault()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            if (r14 == 0) goto L_0x00fc
            java.lang.String r5 = r14.toLowerCase(r5)
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            if (r5 == 0) goto L_0x0102
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r15 == 0) goto L_0x00f6
            java.lang.String r14 = r15.toLowerCase()
            java.lang.String r15 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r15)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.CharSequence) r14, false)
            if (r5 != r4) goto L_0x0102
        L_0x00f4:
            r5 = 1
            goto L_0x0103
        L_0x00f6:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r8)
            throw r1
        L_0x00fc:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r8)
            throw r1
        L_0x0102:
            r5 = 0
        L_0x0103:
            if (r5 == 0) goto L_0x0145
            r5 = r2
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
            r14 = 0
        L_0x010d:
            boolean r15 = r5.hasNext()
            if (r15 == 0) goto L_0x013e
            java.lang.Object r15 = r5.next()
            boolean r3 = r15 instanceof net.one97.paytm.common.entity.recharge.CJRFrequentOrder
            if (r3 == 0) goto L_0x0122
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r15 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r15
            java.lang.String r3 = r15.getRechargeNumber()
            goto L_0x012e
        L_0x0122:
            boolean r3 = r15 instanceof net.one97.paytm.recharge.model.ContactItemModel
            if (r3 == 0) goto L_0x012d
            net.one97.paytm.recharge.model.ContactItemModel r15 = (net.one97.paytm.recharge.model.ContactItemModel) r15
            java.lang.String r3 = r15.getPhnNo()
            goto L_0x012e
        L_0x012d:
            r3 = 0
        L_0x012e:
            if (r3 == 0) goto L_0x0138
            boolean r3 = r3.equals(r13)
            if (r3 != r4) goto L_0x0138
            r3 = 1
            goto L_0x0139
        L_0x0138:
            r3 = 0
        L_0x0139:
            if (r3 == 0) goto L_0x013c
            r14 = 1
        L_0x013c:
            r3 = 0
            goto L_0x010d
        L_0x013e:
            if (r14 != 0) goto L_0x0145
            if (r11 != 0) goto L_0x0145
            r2.add(r12)
        L_0x0145:
            int r10 = r10 + 1
            r3 = 0
            goto L_0x0083
        L_0x014a:
            java.util.ArrayList<java.lang.Object> r3 = r0.f60662f
            if (r3 == 0) goto L_0x0151
            r3.clear()
        L_0x0151:
            java.util.ArrayList<java.lang.Object> r3 = r0.f60662f
            if (r3 == 0) goto L_0x0182
            java.util.Collection r2 = (java.util.Collection) r2
            r3.addAll(r2)
            goto L_0x0182
        L_0x015b:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r8)
            throw r1
        L_0x0161:
            java.util.ArrayList<java.lang.Object> r2 = r0.f60662f
            if (r2 == 0) goto L_0x0168
            r2.clear()
        L_0x0168:
            java.util.ArrayList<java.lang.Object> r2 = r0.f60662f
            if (r2 == 0) goto L_0x017e
            java.util.ArrayList<java.lang.Object> r3 = r0.f60661e
            if (r3 == 0) goto L_0x0176
            java.util.Collection r3 = (java.util.Collection) r3
            r2.addAll(r3)
            goto L_0x017e
        L_0x0176:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any>"
            r1.<init>(r2)
            throw r1
        L_0x017e:
            java.lang.String r2 = ""
            r0.r = r2
        L_0x0182:
            net.one97.paytm.recharge.common.e.ae r2 = r0.j
            if (r2 == 0) goto L_0x018a
            r3 = 0
            r2.a_(r1, r3, r3)
        L_0x018a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.a.r.a(java.lang.String, java.lang.String):void");
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f60666a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            this.f60666a = (TextView) view.findViewById(R.id.text_title_contact);
        }
    }

    public static final class c extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f60667a;

        /* renamed from: b  reason: collision with root package name */
        final View f60668b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ r f60669c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(r rVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f60669c = rVar;
            View findViewById = view.findViewById(R.id.headerTv);
            if (findViewById != null) {
                this.f60667a = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.headerDivider);
                k.a((Object) findViewById2, "itemView.findViewById(R.id.headerDivider)");
                this.f60668b = findViewById2;
                this.f60667a.setTextColor(androidx.core.content.b.c(view.getContext(), R.color.color_506d85));
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final Integer a(char c2) {
        ArrayList<Object> arrayList = this.f60661e;
        if (arrayList != null) {
            if (arrayList == null) {
                k.a();
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList<Object> arrayList2 = this.f60661e;
                if (arrayList2 == null) {
                    k.a();
                }
                Object obj = arrayList2.get(i2);
                k.a(obj, "originalItems!![i]");
                if (obj instanceof ContactItemModel) {
                    ContactItemModel contactItemModel = (ContactItemModel) obj;
                    if (!contactItemModel.ismIsHeading()) {
                        String name = contactItemModel.getName();
                        k.a((Object) name, "model.name");
                        CharSequence charSequence = name;
                        k.d(charSequence, "$this$startsWith");
                        boolean z = true;
                        if (charSequence.length() <= 0 || !kotlin.m.a.a(charSequence.charAt(0), c2, true)) {
                            z = false;
                        }
                        if (z) {
                            ArrayList<Object> arrayList3 = this.f60661e;
                            if (arrayList3 != null) {
                                return Integer.valueOf(arrayList3.indexOf(obj));
                            }
                            return null;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return -1;
    }

    public final void a(ContactItemModel contactItemModel, CJRContactListV8.a aVar) {
        k.c(contactItemModel, "contact");
        k.c(aVar, "options");
        if (this.f60661e == null) {
            this.f60661e = new ArrayList<>();
        }
        if (this.f60662f == null) {
            this.f60662f = new ArrayList<>();
        }
        ArrayList<Object> arrayList = this.f60661e;
        if (arrayList != null) {
            arrayList.add(contactItemModel);
        }
        ArrayList<Object> arrayList2 = this.f60662f;
        if (arrayList2 != null) {
            arrayList2.add(contactItemModel);
        }
        if (this.f60660d == null) {
            this.f60660d = new g(aVar);
        }
    }

    public final void a(ae aeVar) {
        k.c(aeVar, "listener");
        this.j = aeVar;
    }
}

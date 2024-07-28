package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.j.e;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.j;
import net.one97.paytm.recharge.common.e.o;
import net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public final class m extends RecyclerView.a<b> {

    /* renamed from: c  reason: collision with root package name */
    public static final a f60613c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    List<CJRAggsItem> f60614a;

    /* renamed from: b  reason: collision with root package name */
    j f60615b;

    /* renamed from: d  reason: collision with root package name */
    private String f60616d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<CJRAggsItem> f60617e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f60618f;

    /* renamed from: g  reason: collision with root package name */
    private final o f60619g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f60620h;

    /* renamed from: i  reason: collision with root package name */
    private Integer f60621i;
    private Integer j;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        View view;
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        List<CJRAggsItem> list = this.f60617e;
        if (list == null) {
            k.a();
        }
        CJRAggsItem cJRAggsItem = list.get(i2);
        if (!p.a("shimmer", cJRAggsItem != null ? cJRAggsItem.getViewType() : null, true)) {
            List<CJRAggsItem> list2 = this.f60617e;
            if (list2 == null) {
                k.a();
            }
            CJRAggsItem cJRAggsItem2 = list2.get(i2);
            if (k.a((Object) this.f60620h, (Object) Boolean.TRUE) && (view = bVar.f60624c) != null) {
                view.setBackground(androidx.core.content.b.a(this.f60618f, R.drawable.rounded_white_background_grey_border_0_5dp));
            }
            TextView textView = bVar.f60622a;
            if (textView != null) {
                textView.setText(cJRAggsItem2.getDisplayValue());
            }
            w a2 = w.a();
            List<CJRAggsItem> list3 = this.f60617e;
            if (list3 == null) {
                k.a();
            }
            a2.a(list3.get(i2).getImageUrl()).a(bVar.f60623b);
            if (String.valueOf(cJRAggsItem2.hashCode()).equals(this.f60616d)) {
                ImageView imageView = bVar.f60625d;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                Integer num = this.j;
                CJRSelectOperatorViewV8.a aVar = CJRSelectOperatorViewV8.f61954f;
                int d2 = CJRSelectOperatorViewV8.m;
                if (num != null && num.intValue() == d2) {
                    ImageView imageView2 = bVar.f60623b;
                    ViewGroup.LayoutParams layoutParams = imageView2 != null ? imageView2.getLayoutParams() : null;
                    if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
                        layoutParams = null;
                    }
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.gravity = 17;
                    }
                    ImageView imageView3 = bVar.f60623b;
                    if (imageView3 != null) {
                        imageView3.setLayoutParams(layoutParams2);
                    }
                    View view2 = bVar.f60626e;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                }
            } else {
                ImageView imageView4 = bVar.f60625d;
                if (imageView4 != null) {
                    imageView4.setVisibility(8);
                }
                Integer num2 = this.j;
                CJRSelectOperatorViewV8.a aVar2 = CJRSelectOperatorViewV8.f61954f;
                int d3 = CJRSelectOperatorViewV8.m;
                if (num2 != null && num2.intValue() == d3) {
                    ImageView imageView5 = bVar.f60623b;
                    ViewGroup.LayoutParams layoutParams3 = imageView5 != null ? imageView5.getLayoutParams() : null;
                    if (!(layoutParams3 instanceof FrameLayout.LayoutParams)) {
                        layoutParams3 = null;
                    }
                    FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                    if (layoutParams4 != null) {
                        layoutParams4.gravity = 49;
                    }
                    ImageView imageView6 = bVar.f60623b;
                    if (imageView6 != null) {
                        imageView6.setLayoutParams(layoutParams4);
                    }
                    View view3 = bVar.f60626e;
                    if (view3 != null) {
                        view3.setVisibility(8);
                    }
                }
            }
            bVar.f60627f = this.f60617e;
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        b bVar;
        k.c(viewGroup, "parent");
        CJRSelectOperatorViewV8.a aVar = CJRSelectOperatorViewV8.f61954f;
        if (i2 == CJRSelectOperatorViewV8.k) {
            View inflate = LayoutInflater.from(this.f60618f).inflate(R.layout.content_item_select_operator_without_border_v8, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(cont…border_v8, parent, false)");
            bVar = new b(this, inflate, this.f60619g, this.f60617e);
        } else {
            CJRSelectOperatorViewV8.a aVar2 = CJRSelectOperatorViewV8.f61954f;
            if (i2 == CJRSelectOperatorViewV8.j) {
                View inflate2 = LayoutInflater.from(this.f60618f).inflate(R.layout.content_item_select_operator_with_border_v8, viewGroup, false);
                k.a((Object) inflate2, "LayoutInflater.from(cont…border_v8, parent, false)");
                bVar = new b(this, inflate2, this.f60619g, this.f60617e);
            } else {
                CJRSelectOperatorViewV8.a aVar3 = CJRSelectOperatorViewV8.f61954f;
                if (i2 == CJRSelectOperatorViewV8.m) {
                    View inflate3 = LayoutInflater.from(this.f60618f).inflate(R.layout.v3_content_item_select_operator_with_border, viewGroup, false);
                    k.a((Object) inflate3, "LayoutInflater.from(cont…th_border, parent, false)");
                    bVar = new b(this, inflate3, this.f60619g, this.f60617e);
                } else {
                    View inflate4 = LayoutInflater.from(this.f60618f).inflate(R.layout.content_item_select_operator_shimmer_v8, viewGroup, false);
                    k.a((Object) inflate4, "LayoutInflater.from(cont…himmer_v8, parent, false)");
                    bVar = new b(this, inflate4, this.f60619g, this.f60617e);
                }
            }
        }
        return bVar;
    }

    public m(Context context, List<CJRAggsItem> list, o oVar, j jVar, Boolean bool, Integer num, Integer num2) {
        k.c(context, "context");
        this.f60618f = context;
        this.f60614a = list;
        this.f60619g = oVar;
        this.f60615b = jVar;
        this.f60620h = bool;
        this.f60621i = num;
        this.j = num2;
        List<CJRAggsItem> list2 = this.f60614a;
        if (list2 != null) {
            this.f60617e = list2;
            if (list2 == null) {
                k.a();
            }
            if (kotlin.a.k.a(e.a(0, list2.size()), this.f60621i)) {
                List<CJRAggsItem> list3 = this.f60614a;
                if (list3 == null) {
                    k.a();
                }
                Integer num3 = this.f60621i;
                if (num3 == null) {
                    k.a();
                }
                this.f60616d = String.valueOf(list3.get(num3.intValue()).hashCode());
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final int getItemViewType(int i2) {
        List<CJRAggsItem> list = this.f60614a;
        if (list != null && i2 < list.size()) {
            List<CJRAggsItem> list2 = this.f60614a;
            if (list2 == null) {
                k.a();
            }
            if (p.a("shimmer", list2.get(i2).getViewType(), true)) {
                CJRSelectOperatorViewV8.a aVar = CJRSelectOperatorViewV8.f61954f;
                return CJRSelectOperatorViewV8.l;
            }
        }
        Integer num = this.j;
        if (num != null) {
            return num.intValue();
        }
        CJRSelectOperatorViewV8.a aVar2 = CJRSelectOperatorViewV8.f61954f;
        return CJRSelectOperatorViewV8.j;
    }

    public final int getItemCount() {
        List<CJRAggsItem> list = this.f60617e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static final class c extends Filter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f60631a;

        public c(m mVar) {
            this.f60631a = mVar;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            k.c(charSequence, "constraint");
            k.c(filterResults, "results");
            m mVar = this.f60631a;
            Object obj = filterResults.values;
            if (obj != null) {
                mVar.f60617e = (ArrayList) obj;
                List a2 = this.f60631a.f60617e;
                if (a2 == null) {
                    k.a();
                }
                if (a2.isEmpty()) {
                    CharSequence obj2 = charSequence.toString();
                    int length = obj2.length() - 1;
                    int i2 = 0;
                    boolean z = false;
                    while (i2 <= length) {
                        boolean z2 = obj2.charAt(!z ? i2 : length) <= ' ';
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (!z2) {
                            z = true;
                        } else {
                            i2++;
                        }
                    }
                    if (obj2.subSequence(i2, length + 1).toString().length() > 0) {
                        j jVar = this.f60631a.f60615b;
                        if (jVar != null) {
                            jVar.a(true);
                        }
                    } else {
                        j jVar2 = this.f60631a.f60615b;
                        if (jVar2 != null) {
                            jVar2.a(false);
                        }
                    }
                } else {
                    j jVar3 = this.f60631a.f60615b;
                    if (jVar3 != null) {
                        jVar3.a(false);
                    }
                }
                this.f60631a.notifyDataSetChanged();
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.recharge.model.v4.CJRAggsItem> /* = java.util.ArrayList<net.one97.paytm.recharge.model.v4.CJRAggsItem> */");
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList arrayList = new ArrayList();
            if (charSequence == null || charSequence.length() == 0) {
                List<CJRAggsItem> list = this.f60631a.f60614a;
                if (list == null) {
                    k.a();
                }
                filterResults.count = list.size();
                filterResults.values = this.f60631a.f60614a;
            } else {
                CharSequence obj = charSequence.toString();
                int length = obj.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length) {
                    boolean z2 = obj.charAt(!z ? i2 : length) <= ' ';
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (!z2) {
                        z = true;
                    } else {
                        i2++;
                    }
                }
                String obj2 = obj.subSequence(i2, length + 1).toString();
                Locale locale = Locale.getDefault();
                k.a((Object) locale, "Locale.getDefault()");
                if (obj2 != null) {
                    String lowerCase = obj2.toLowerCase(locale);
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    List a2 = this.f60631a.f60617e;
                    if (a2 == null) {
                        k.a();
                    }
                    int size = a2.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        List a3 = this.f60631a.f60617e;
                        if (a3 == null) {
                            k.a();
                        }
                        CJRAggsItem cJRAggsItem = (CJRAggsItem) a3.get(i3);
                        if (!TextUtils.isEmpty(cJRAggsItem.getDisplayValue())) {
                            String displayValue = cJRAggsItem.getDisplayValue();
                            if (displayValue == null) {
                                displayValue = "";
                            }
                            Locale locale2 = Locale.getDefault();
                            k.a((Object) locale2, "Locale.getDefault()");
                            if (displayValue != null) {
                                String lowerCase2 = displayValue.toLowerCase(locale2);
                                k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                                if (p.a((CharSequence) lowerCase2, (CharSequence) lowerCase, false)) {
                                    List a4 = this.f60631a.f60617e;
                                    if (a4 == null) {
                                        k.a();
                                    }
                                    arrayList.add(a4.get(i3));
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                    }
                    filterResults.count = arrayList.size();
                    filterResults.values = arrayList;
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            return filterResults;
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f60622a = ((TextView) this.itemView.findViewById(R.id.operator_name));

        /* renamed from: b  reason: collision with root package name */
        ImageView f60623b = ((ImageView) this.itemView.findViewById(R.id.operator_image));

        /* renamed from: c  reason: collision with root package name */
        View f60624c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f60625d;

        /* renamed from: e  reason: collision with root package name */
        View f60626e;

        /* renamed from: f  reason: collision with root package name */
        List<CJRAggsItem> f60627f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ m f60628g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(m mVar, View view, final o oVar, List<CJRAggsItem> list) {
            super(view);
            k.c(view, "view");
            this.f60628g = mVar;
            this.f60627f = list;
            View findViewById = this.itemView.findViewById(R.id.listItemContainer);
            this.f60624c = !(findViewById instanceof View) ? null : findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.checked_image);
            this.f60625d = (ImageView) (!(findViewById2 instanceof ImageView) ? null : findViewById2);
            View findViewById3 = this.itemView.findViewById(R.id.operator_selection_border);
            this.f60626e = !(findViewById3 instanceof View) ? null : findViewById3;
            this.itemView.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f60629a;

                {
                    this.f60629a = r1;
                }

                public final void onClick(View view) {
                    o oVar;
                    List<CJRAggsItem> list = this.f60629a.f60627f;
                    if (list == null) {
                        k.a();
                    }
                    CJRAggsItem cJRAggsItem = list.get(this.f60629a.getAdapterPosition());
                    if (!p.a("shimmer", cJRAggsItem != null ? cJRAggsItem.getViewType() : null, true) && (oVar = oVar) != null) {
                        List<CJRAggsItem> list2 = this.f60629a.f60627f;
                        if (list2 == null) {
                            k.a();
                        }
                        oVar.a(list2.get(this.f60629a.getAdapterPosition()), this.f60629a.getAdapterPosition());
                    }
                }
            });
        }
    }
}

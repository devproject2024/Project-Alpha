package net.one97.paytm.recharge.presentation.f;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.widgets.i;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions;
import net.one97.paytm.recharge.domain.entities.CJRPaymentModes;
import net.one97.paytm.recharge.presentation.a.f;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticPaymentKnowMore;
import net.one97.paytm.recharge.presentation.d.d;
import net.one97.paytm.recharge.widgets.c.e;

public final class g extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final RadioButton f64860a = ((RadioButton) this.f64863d.findViewById(R.id.radio_btn));

    /* renamed from: b  reason: collision with root package name */
    final RecyclerView f64861b = ((RecyclerView) this.f64863d.findViewById(R.id.popular_bank_list));

    /* renamed from: c  reason: collision with root package name */
    final ConstraintLayout f64862c = ((ConstraintLayout) this.f64863d.findViewById(R.id.other_bank_list_group_lyt));

    /* renamed from: d  reason: collision with root package name */
    final View f64863d;

    /* renamed from: e  reason: collision with root package name */
    final d f64864e;

    /* renamed from: f  reason: collision with root package name */
    final String f64865f;

    /* renamed from: g  reason: collision with root package name */
    final String f64866g;

    /* renamed from: h  reason: collision with root package name */
    final net.one97.paytm.recharge.presentation.d.c f64867h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f64868i = ((TextView) this.f64863d.findViewById(R.id.txt_bank_name));
    private final ImageView j = ((ImageView) this.f64863d.findViewById(R.id.ic_info));
    private f k;
    private Object l;
    private String m;

    public final void onClick(View view) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(View view, String str, d dVar, String str2, String str3, net.one97.paytm.recharge.presentation.d.c cVar) {
        super(view);
        k.c(view, "mItemView");
        this.f64863d = view;
        this.m = str;
        this.f64864e = dVar;
        this.f64865f = str2;
        this.f64866g = str3;
        this.f64867h = cVar;
        this.f64861b.setHasFixedSize(true);
        RecyclerView recyclerView = this.f64861b;
        k.a((Object) recyclerView, "popularBankList");
        recyclerView.setLayoutManager(new GridLayoutManager(this.f64863d.getContext(), 3));
        this.f64861b.addItemDecoration(new i(3, com.paytm.utility.b.c(10), false));
    }

    public final <T> void a(T t) {
        ArrayList<CJRPayChannelOptions> payChannelOptions;
        this.l = t;
        RadioButton radioButton = this.f64860a;
        k.a((Object) radioButton, "radioBtn");
        radioButton.setEnabled(true);
        RadioButton radioButton2 = this.f64860a;
        k.a((Object) radioButton2, "radioBtn");
        radioButton2.setChecked(false);
        TextView textView = this.f64868i;
        k.a((Object) textView, "tvBankName");
        textView.setEnabled(true);
        this.f64863d.requestFocus();
        RadioButton radioButton3 = this.f64860a;
        k.a((Object) radioButton3, "radioBtn");
        radioButton3.setClickable(false);
        if (t instanceof CJRPaymentModes) {
            TextView textView2 = this.f64868i;
            k.a((Object) textView2, "tvBankName");
            Context context = this.f64863d.getContext();
            String str = null;
            textView2.setText(context != null ? context.getString(R.string.paytm_e_mandate) : null);
            CJRPaymentModes cJRPaymentModes = (CJRPaymentModes) t;
            if (!(cJRPaymentModes.getPayChannelOptions() == null || (payChannelOptions = cJRPaymentModes.getPayChannelOptions()) == null || !(!payChannelOptions.isEmpty()))) {
                if (this.k == null) {
                    String paymentMode = cJRPaymentModes.getPaymentMode();
                    if (paymentMode == null) {
                        paymentMode = "";
                    }
                    this.k = new f(paymentMode, a(cJRPaymentModes.getPayChannelOptions()), this.f64867h);
                }
                RecyclerView recyclerView = this.f64861b;
                k.a((Object) recyclerView, "popularBankList");
                recyclerView.setAdapter(this.k);
            }
            if (!TextUtils.isEmpty(this.m) && p.a(SDKConstants.TYPE_BANK_MANDATE, this.m, true)) {
                TextView textView3 = this.f64868i;
                k.a((Object) textView3, "tvBankName");
                Context context2 = this.f64863d.getContext();
                if (context2 != null) {
                    str = context2.getString(R.string.paytm_new_emandate);
                }
                textView3.setText(str);
            }
            if (cJRPaymentModes.isSelected()) {
                RecyclerView recyclerView2 = this.f64861b;
                k.a((Object) recyclerView2, "popularBankList");
                ExtensionsKt.visible(recyclerView2);
                RadioButton radioButton4 = this.f64860a;
                k.a((Object) radioButton4, "radioBtn");
                radioButton4.setChecked(true);
                ArrayList<CJRPayChannelOptions> payChannelOptions2 = cJRPaymentModes.getPayChannelOptions();
                if (payChannelOptions2 == null) {
                    k.a();
                }
                if (payChannelOptions2.size() > 6) {
                    ConstraintLayout constraintLayout = this.f64862c;
                    k.a((Object) constraintLayout, "otherBankListGroup");
                    ExtensionsKt.visible(constraintLayout);
                } else {
                    ConstraintLayout constraintLayout2 = this.f64862c;
                    k.a((Object) constraintLayout2, "otherBankListGroup");
                    ExtensionsKt.gone(constraintLayout2);
                }
            } else {
                RadioButton radioButton5 = this.f64860a;
                k.a((Object) radioButton5, "radioBtn");
                radioButton5.setChecked(false);
                RecyclerView recyclerView3 = this.f64861b;
                k.a((Object) recyclerView3, "popularBankList");
                ExtensionsKt.gone(recyclerView3);
                ConstraintLayout constraintLayout3 = this.f64862c;
                k.a((Object) constraintLayout3, "otherBankListGroup");
                ExtensionsKt.gone(constraintLayout3);
            }
            this.f64863d.setOnClickListener(new a(this, t));
            ConstraintLayout constraintLayout4 = this.f64862c;
            if (constraintLayout4 != null) {
                constraintLayout4.setOnClickListener(new b(this, t));
            }
            ImageView imageView = this.j;
            if (imageView != null) {
                imageView.setOnClickListener(new c(this));
            }
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f64869a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f64870b;

        a(g gVar, Object obj) {
            this.f64869a = gVar;
            this.f64870b = obj;
        }

        public final void onClick(View view) {
            String str;
            RadioButton radioButton = this.f64869a.f64860a;
            k.a((Object) radioButton, "radioBtn");
            if (!radioButton.isChecked()) {
                ((CJRPaymentModes) this.f64870b).setSelected(true);
                RadioButton radioButton2 = this.f64869a.f64860a;
                k.a((Object) radioButton2, "radioBtn");
                radioButton2.setChecked(true);
                RecyclerView recyclerView = this.f64869a.f64861b;
                k.a((Object) recyclerView, "popularBankList");
                ExtensionsKt.visible(recyclerView);
                ArrayList<CJRPayChannelOptions> payChannelOptions = ((CJRPaymentModes) this.f64870b).getPayChannelOptions();
                if (payChannelOptions == null) {
                    k.a();
                }
                if (payChannelOptions.size() > 6) {
                    ConstraintLayout constraintLayout = this.f64869a.f64862c;
                    k.a((Object) constraintLayout, "otherBankListGroup");
                    ExtensionsKt.visible(constraintLayout);
                } else {
                    ConstraintLayout constraintLayout2 = this.f64869a.f64862c;
                    k.a((Object) constraintLayout2, "otherBankListGroup");
                    ExtensionsKt.gone(constraintLayout2);
                }
                g gVar = this.f64869a;
                try {
                    if (TextUtils.isEmpty(gVar.f64865f) || !p.a(gVar.f64865f, "manage_screen", true)) {
                        a.C1160a aVar = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                        str = net.one97.paytm.recharge.automatic.b.a.a.p;
                    } else {
                        a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                        str = net.one97.paytm.recharge.automatic.b.a.a.B;
                    }
                    String str2 = str;
                    net.one97.paytm.recharge.automatic.c.a.a aVar3 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                    View view2 = gVar.itemView;
                    k.a((Object) view2, "itemView");
                    Context context = view2.getContext();
                    k.a((Object) context, "itemView.context");
                    a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                    String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                    String str3 = gVar.f64866g;
                    if (str3 == null) {
                        str3 = "";
                    }
                    String str4 = str3;
                    a.C1160a aVar5 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                    net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, str2, "", str4, net.one97.paytm.recharge.automatic.b.a.a.P, "emandate");
                } catch (Throwable unused) {
                }
                d dVar = this.f64869a.f64864e;
                if (dVar != null) {
                    dVar.a(this.f64869a.getAdapterPosition(), 4);
                }
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f64871a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f64872b;

        b(g gVar, Object obj) {
            this.f64871a = gVar;
            this.f64872b = obj;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.presentation.d.c cVar;
            e eVar = e.INSTANCE;
            k.a((Object) view, "it");
            if (!eVar.validateIsAlreadyClicked(view) && (cVar = this.f64871a.f64867h) != null) {
                cVar.a((CJRPaymentModes) this.f64872b);
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f64873a;

        c(g gVar) {
            this.f64873a = gVar;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f64873a.f64863d.getContext(), AJRAutomaticPaymentKnowMore.class);
            intent.putExtra("from", SDKConstants.TYPE_BANK_MANDATE);
            this.f64873a.f64863d.getContext().startActivity(intent);
        }
    }

    public final void a(boolean z) {
        RadioButton radioButton = this.f64860a;
        if (radioButton != null) {
            radioButton.setChecked(z);
        }
    }

    private static ArrayList<CJRPayChannelOptions> a(ArrayList<CJRPayChannelOptions> arrayList) {
        ArrayList<CJRPayChannelOptions> arrayList2 = new ArrayList<>();
        if (arrayList != null && (!arrayList.isEmpty()) && arrayList.size() > 6) {
            int i2 = 0;
            net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
            ArrayList<String> q = net.one97.paytm.recharge.automatic.c.a.b.q();
            Iterator<CJRPayChannelOptions> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRPayChannelOptions next = it2.next();
                if (i2 >= 6) {
                    break;
                }
                Iterator<String> it3 = q.iterator();
                while (it3.hasNext()) {
                    if (p.a(it3.next(), next.getChannelCode(), true)) {
                        i2++;
                        arrayList2.add(next);
                    }
                }
            }
            Iterator<CJRPayChannelOptions> it4 = arrayList.iterator();
            while (it4.hasNext()) {
                CJRPayChannelOptions next2 = it4.next();
                if (i2 >= 6) {
                    break;
                }
                Iterator<String> it5 = q.iterator();
                while (it5.hasNext()) {
                    if (!p.a(it5.next(), next2.getChannelCode(), true)) {
                        i2++;
                        arrayList2.add(next2);
                    }
                }
            }
        }
        return arrayList2;
    }
}

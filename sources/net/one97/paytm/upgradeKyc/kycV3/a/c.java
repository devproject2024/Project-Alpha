package net.one97.paytm.upgradeKyc.kycV3.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.upgradeKyc.AvailableSlots;
import net.one97.paytm.common.entity.upgradeKyc.TimeSlots;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.kycV3.a.b;

public final class c extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private List<IJRDataModel> f66057a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final int f66058b;

    /* renamed from: c  reason: collision with root package name */
    private final int f66059c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final b.C1323b f66060d;

    public c(b.C1323b bVar) {
        k.c(bVar, "slotClickListener");
        this.f66060d = bVar;
    }

    public final void a(List<? extends IJRDataModel> list) {
        k.c(list, "itemList");
        this.f66057a.clear();
        Collection collection = list;
        if (!collection.isEmpty()) {
            this.f66057a.addAll(collection);
        }
        notifyDataSetChanged();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f66059c) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kyc_slot_picker_date_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…date_item, parent, false)");
            return new a(inflate, this.f66060d);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kyc_slot_picker_date_item, viewGroup, false);
        k.a((Object) inflate2, "LayoutInflater.from(pare…date_item, parent, false)");
        return new a(inflate2, this.f66060d);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2, List<Object> list) {
        k.c(vVar, "holder");
        k.c(list, "payloads");
        super.onBindViewHolder(vVar, i2, list);
        if (!list.isEmpty()) {
            Object obj = list.get(0);
            if (k.a(obj, (Object) "timeSelected")) {
                if (vVar instanceof a) {
                    a aVar = (a) vVar;
                    TextView textView = aVar.f66062b;
                    TextView textView2 = aVar.f66062b;
                    k.a((Object) textView2, "holder.title");
                    textView.setTextColor(androidx.core.content.b.c(textView2.getContext(), com.paytm.utility.R.color.white));
                    TextView textView3 = aVar.f66062b;
                    k.a((Object) textView3, "holder.title");
                    textView3.setActivated(true);
                }
            } else if (k.a(obj, (Object) "timeUnselected") && (vVar instanceof a)) {
                a aVar2 = (a) vVar;
                TextView textView4 = aVar2.f66062b;
                TextView textView5 = aVar2.f66062b;
                k.a((Object) textView5, "holder.title");
                textView4.setTextColor(androidx.core.content.b.c(textView5.getContext(), com.paytm.utility.R.color.black));
                TextView textView6 = aVar2.f66062b;
                k.a((Object) textView6, "holder.title");
                textView6.setActivated(false);
            }
        }
    }

    public final int getItemCount() {
        return this.f66057a.size();
    }

    public final int getItemViewType(int i2) {
        if (this.f66057a.get(i2) instanceof TimeSlots) {
            return this.f66059c;
        }
        return this.f66058b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0181  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r18, int r19) {
        /*
            r17 = this;
            r0 = r18
            r1 = r19
            java.lang.String r2 = "holder"
            kotlin.g.b.k.c(r0, r2)
            boolean r2 = r0 instanceof net.one97.paytm.upgradeKyc.kycV3.a.c.a
            if (r2 == 0) goto L_0x01c4
            r2 = 0
            r0.setIsRecyclable(r2)
            r3 = r17
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r4 = r3.f66057a
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.common.entity.IJRDataModel r4 = (net.one97.paytm.common.entity.IJRDataModel) r4
            boolean r5 = r4 instanceof net.one97.paytm.common.entity.upgradeKyc.AvailableSlots
            if (r5 == 0) goto L_0x01c4
            net.one97.paytm.upgradeKyc.kycV3.a.c$a r0 = (net.one97.paytm.upgradeKyc.kycV3.a.c.a) r0
            net.one97.paytm.common.entity.upgradeKyc.AvailableSlots r4 = (net.one97.paytm.common.entity.upgradeKyc.AvailableSlots) r4
            java.lang.String r5 = "item"
            kotlin.g.b.k.c(r4, r5)
            java.lang.String r5 = r4.getTimeRange()
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r8 = "title"
            if (r7 != 0) goto L_0x0185
            if (r5 != 0) goto L_0x003c
            kotlin.g.b.k.a()
        L_0x003c:
            android.widget.TextView r7 = r0.f66062b
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.String r10 = "timeRange"
            kotlin.g.b.k.c(r5, r10)
            kotlin.g.b.k.c(r7, r8)
            java.lang.String r5 = "TO"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            java.util.List r5 = kotlin.m.p.a((java.lang.CharSequence) r6, (java.lang.String[]) r5)
            android.content.Context r10 = r0.f66061a
            int r11 = net.one97.paytm.upgradeKyc.R.string.ninetotweleve
            java.lang.String r10 = r10.getString(r11)
            java.lang.Object r11 = r5.get(r2)
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            java.lang.String r12 = "AM"
            r13 = r12
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r11 = kotlin.m.p.a((java.lang.CharSequence) r11, (java.lang.CharSequence) r13, (boolean) r2)
            java.lang.String r13 = "PM"
            java.lang.String r14 = "NOON"
            java.lang.String r15 = ""
            if (r11 == 0) goto L_0x007f
            java.lang.Object r11 = r5.get(r2)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r11 = kotlin.m.p.a(r11, r12, r15, r2)
            r9 = r11
        L_0x007d:
            r11 = 1
            goto L_0x00b5
        L_0x007f:
            java.lang.Object r11 = r5.get(r2)
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r9 = r14
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = kotlin.m.p.a((java.lang.CharSequence) r11, (java.lang.CharSequence) r9, (boolean) r2)
            if (r9 == 0) goto L_0x0099
            java.lang.Object r9 = r5.get(r2)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r9 = kotlin.m.p.a(r9, r14, r15, r2)
            goto L_0x007d
        L_0x0099:
            java.lang.Object r9 = r5.get(r2)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r11 = r13
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r9 = kotlin.m.p.a((java.lang.CharSequence) r9, (java.lang.CharSequence) r11, (boolean) r2)
            if (r9 == 0) goto L_0x00b3
            java.lang.Object r9 = r5.get(r2)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r9 = kotlin.m.p.a(r9, r13, r15, r2)
            goto L_0x007d
        L_0x00b3:
            r9 = r15
            goto L_0x007d
        L_0x00b5:
            java.lang.Object r16 = r5.get(r11)
            r11 = r16
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r3 = r12
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.m.p.a((java.lang.CharSequence) r11, (java.lang.CharSequence) r3, (boolean) r2)
            java.lang.String r11 = " "
            if (r3 == 0) goto L_0x00e9
            r3 = 1
            java.lang.Object r5 = r5.get(r3)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            android.content.Context r11 = r0.f66061a
            int r14 = net.one97.paytm.upgradeKyc.R.string.kyc_am
            java.lang.String r11 = r11.getString(r14)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            java.lang.String r15 = kotlin.m.p.a(r5, r12, r11, r2)
        L_0x00e7:
            r11 = 0
            goto L_0x0147
        L_0x00e9:
            r3 = 1
            java.lang.Object r12 = r5.get(r3)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r2 = r14
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r12, (java.lang.CharSequence) r2, false)
            if (r2 == 0) goto L_0x0119
            java.lang.Object r2 = r5.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r11)
            android.content.Context r11 = r0.f66061a
            int r12 = net.one97.paytm.upgradeKyc.R.string.kyc_noon
            java.lang.String r11 = r11.getString(r12)
            r5.append(r11)
            java.lang.String r5 = r5.toString()
            r11 = 0
            java.lang.String r15 = kotlin.m.p.a(r2, r14, r5, r11)
            goto L_0x0147
        L_0x0119:
            java.lang.Object r2 = r5.get(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12 = r13
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r12, false)
            if (r2 == 0) goto L_0x00e7
            java.lang.Object r2 = r5.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r11)
            android.content.Context r5 = r0.f66061a
            int r11 = net.one97.paytm.upgradeKyc.R.string.kyc_pm
            java.lang.String r5 = r5.getString(r11)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r11 = 0
            java.lang.String r15 = kotlin.m.p.a(r2, r13, r3, r11)
        L_0x0147:
            r2 = r9
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x016d
            r2 = r15
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x016d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            java.lang.String r3 = " - "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r10 = r2.toString()
        L_0x016d:
            java.lang.String r2 = "formattedTitle"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r2)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r2 = r10.length()
            if (r2 != 0) goto L_0x017b
            r11 = 1
        L_0x017b:
            if (r11 != 0) goto L_0x0181
            r7.setText(r10)
            goto L_0x0197
        L_0x0181:
            r7.setText(r6)
            goto L_0x0197
        L_0x0185:
            android.widget.TextView r2 = r0.f66062b
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            android.content.Context r3 = r0.f66061a
            int r5 = net.one97.paytm.upgradeKyc.R.string.ninetotweleve
            java.lang.String r3 = r3.getString(r5)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
        L_0x0197:
            if (r1 != 0) goto L_0x01b8
            android.widget.TextView r1 = r0.f66062b
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            r2 = 1
            r1.setActivated(r2)
            android.widget.TextView r1 = r0.f66062b
            android.view.View r2 = r0.itemView
            java.lang.String r3 = "itemView"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.content.Context r2 = r2.getContext()
            int r3 = com.paytm.utility.R.color.white
            int r2 = androidx.core.content.b.c(r2, r3)
            r1.setTextColor(r2)
        L_0x01b8:
            android.widget.TextView r1 = r0.f66062b
            net.one97.paytm.upgradeKyc.kycV3.a.c$a$a r2 = new net.one97.paytm.upgradeKyc.kycV3.a.c$a$a
            r2.<init>(r0, r4)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
        L_0x01c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.kycV3.a.c.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final Context f66061a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f66062b;

        /* renamed from: c  reason: collision with root package name */
        final b.C1323b f66063c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view, b.C1323b bVar) {
            super(view);
            k.c(view, "itemView");
            k.c(bVar, "listener");
            this.f66063c = bVar;
            this.f66061a = view.getContext();
            this.f66062b = (TextView) view.findViewById(R.id.slot_date);
        }

        /* renamed from: net.one97.paytm.upgradeKyc.kycV3.a.c$a$a  reason: collision with other inner class name */
        static final class C1324a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f66064a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AvailableSlots f66065b;

            C1324a(a aVar, AvailableSlots availableSlots) {
                this.f66064a = aVar;
                this.f66065b = availableSlots;
            }

            public final void onClick(View view) {
                b.C1323b bVar = this.f66064a.f66063c;
                String timeRange = this.f66065b.getTimeRange();
                if (timeRange == null) {
                    k.a();
                }
                bVar.b(timeRange, this.f66064a.getAdapterPosition());
            }
        }
    }
}

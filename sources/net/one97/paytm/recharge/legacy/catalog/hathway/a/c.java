package net.one97.paytm.recharge.legacy.catalog.hathway.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails;
import net.one97.paytm.common.entity.shopping.CJRService;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.legacy.catalog.hathway.activity.CJRAddOnGroupMainActivity;

@Deprecated
public final class c extends RecyclerView.a<a> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static boolean f62945b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static String f62946c = "basepack";
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public int f62947a;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final CheckBox f62948d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<String> f62949e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Activity f62950f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<CJRPlanExpiryDetails>> f62951g = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.recharge.legacy.catalog.hathway.c.a f62952h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public CJRService f62953i;
    /* access modifiers changed from: private */
    public b j;

    public interface b {
        void a(Integer num, boolean z, int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        int i3;
        boolean z;
        String str;
        String str2;
        a aVar = (a) vVar;
        aVar.f62955b.setVisibility(i2 == this.f62951g.size() - 1 ? 8 : 0);
        String str3 = this.f62949e.get(i2);
        if (str3.equalsIgnoreCase(f62946c)) {
            CJRPlanExpiryDetails cJRPlanExpiryDetails = (CJRPlanExpiryDetails) this.f62951g.get(str3).get(0);
            q.d("detailspackagename" + cJRPlanExpiryDetails.getPackagename());
            String formatedDateWithFullYear = cJRPlanExpiryDetails.getFormatedDateWithFullYear();
            if (Integer.parseInt(cJRPlanExpiryDetails.getPlanduration()) > 1) {
                str2 = " " + " Validity: " + cJRPlanExpiryDetails.getPlanduration() + " " + this.f62950f.getResources().getString(R.string.month) + ", ";
            } else {
                str2 = " Validity: " + cJRPlanExpiryDetails.getPlanduration() + " " + this.f62950f.getResources().getString(R.string.month) + ", ";
            }
            aVar.f62956c.setText(cJRPlanExpiryDetails.getPackname().toUpperCase());
            aVar.f62957d.setText(str2 + this.f62950f.getResources().getString(R.string.expiry) + ": " + formatedDateWithFullYear);
            aVar.f62957d.setClickable(false);
            aVar.f62957d.setTextColor(Color.parseColor("#999999"));
            z = cJRPlanExpiryDetails.isChecked();
            i3 = z ? Integer.parseInt(cJRPlanExpiryDetails.getAmount()) : 0;
        } else {
            String str4 = null;
            if (str3.equalsIgnoreCase("addon")) {
                str4 = this.f62950f.getString(R.string.view_add_on);
                str = this.f62950f.getString(R.string.view_add_on_packs);
            } else if (str3.equalsIgnoreCase("alacart")) {
                str4 = this.f62950f.getString(R.string.ala_carte);
                str = this.f62950f.getString(R.string.view_ala_carte);
            } else {
                str = null;
            }
            aVar.f62957d.setClickable(true);
            aVar.f62957d.setText(str);
            aVar.f62957d.setTag(str4);
            boolean z2 = false;
            int i4 = 0;
            int i5 = 0;
            for (CJRPlanExpiryDetails cJRPlanExpiryDetails2 : this.f62951g.get(str3)) {
                if (cJRPlanExpiryDetails2.isChecked()) {
                    i5 += Integer.parseInt(cJRPlanExpiryDetails2.getAmount());
                    i4++;
                }
                z2 |= cJRPlanExpiryDetails2.isChecked();
            }
            if (!z2 || i4 >= this.f62951g.get(str3).size()) {
                aVar.f62956c.setText(this.f62950f.getString(R.string.cable_plan_count_placeholder, new Object[]{str4, Integer.valueOf(this.f62951g.get(str3).size())}));
            } else {
                aVar.f62956c.setText(this.f62950f.getString(R.string.cable_plan_selected_count_placeholder, new Object[]{str4, Integer.valueOf(i4), Integer.valueOf(this.f62951g.get(str3).size())}));
            }
            z = z2;
            i3 = i5;
        }
        if (aVar.f62954a.isChecked() ^ z) {
            aVar.f62954a.setTag(Boolean.FALSE);
        }
        aVar.f62954a.setChecked(z);
        aVar.f62959f.setText(this.f62950f.getString(R.string.price_container_re, new Object[]{String.valueOf(i3)}));
    }

    c(Activity activity, List<CJRPlanExpiryDetails> list, net.one97.paytm.recharge.legacy.catalog.hathway.c.a aVar, CJRService cJRService, CheckBox checkBox, b bVar) {
        this.f62950f = activity;
        this.f62952h = aVar;
        this.f62953i = cJRService;
        this.f62948d = checkBox;
        this.j = bVar;
        a(list, false);
    }

    public final void a(List<CJRPlanExpiryDetails> list, boolean z) {
        if (z) {
            for (Map.Entry<String, List<CJRPlanExpiryDetails>> value : this.f62951g.entrySet()) {
                ((List) value.getValue()).clear();
            }
        }
        for (CJRPlanExpiryDetails next : list) {
            if (!this.f62951g.containsKey(next.getPackagename())) {
                this.f62951g.put(next.getPackagename(), new ArrayList());
            }
            this.f62951g.get(next.getPackagename()).add(next);
        }
        c();
        if (z) {
            notifyDataSetChanged();
        }
    }

    private void c() {
        if (this.f62951g.size() > 0) {
            this.f62949e.clear();
            this.f62949e.addAll(this.f62951g.keySet());
        }
        Collections.sort(this.f62949e, Collections.reverseOrder());
    }

    public final int getItemCount() {
        return this.f62949e.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public CheckBox f62954a;

        /* renamed from: b  reason: collision with root package name */
        public View f62955b;

        /* renamed from: c  reason: collision with root package name */
        TextView f62956c;

        /* renamed from: d  reason: collision with root package name */
        TextView f62957d;

        /* renamed from: e  reason: collision with root package name */
        TextView f62958e;

        /* renamed from: f  reason: collision with root package name */
        TextView f62959f;

        /* renamed from: g  reason: collision with root package name */
        RecyclerView f62960g;

        a(View view) {
            super(view);
            this.f62956c = (TextView) view.findViewById(R.id.cable_name);
            this.f62954a = (CheckBox) view.findViewById(R.id.utility_check_box);
            this.f62959f = (TextView) view.findViewById(R.id.cable_price);
            this.f62957d = (TextView) view.findViewById(R.id.cable_view_details);
            this.f62955b = view.findViewById(R.id.cable_view_seperator);
            this.f62958e = (TextView) view.findViewById(R.id.txt_rupee_symbol);
            this.f62958e.setVisibility(8);
            this.f62955b.setVisibility(0);
            this.f62960g = (RecyclerView) view.findViewById(R.id.rv_cable_child_list);
            this.f62960g.setHasFixedSize(true);
            this.f62960g.setLayoutManager(new LinearLayoutManager(c.this.f62950f.getBaseContext()));
            this.f62954a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(c.this) {
                /* JADX WARNING: Removed duplicated region for block: B:20:0x0099  */
                /* JADX WARNING: Removed duplicated region for block: B:50:0x005b A[SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onCheckedChanged(android.widget.CompoundButton r10, boolean r11) {
                    /*
                        r9 = this;
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this
                        int r0 = r0.getAdapterPosition()
                        r1 = r11 ^ 1
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r2 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c r2 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.this
                        java.util.List r2 = r2.f62949e
                        java.lang.Object r0 = r2.get(r0)
                        java.lang.String r0 = (java.lang.String) r0
                        java.lang.String r2 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.f62946c
                        boolean r2 = r0.equalsIgnoreCase(r2)
                        r3 = 0
                        if (r2 == 0) goto L_0x0046
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r1 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c r1 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.this
                        java.util.Map r1 = r1.f62951g
                        java.lang.Object r0 = r1.get(r0)
                        java.util.List r0 = (java.util.List) r0
                        java.lang.Object r0 = r0.get(r3)
                        net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails r0 = (net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails) r0
                        java.lang.String r1 = r0.getAmount()
                        int r1 = java.lang.Integer.parseInt(r1)
                        boolean r2 = r0.isChecked()
                        r0.setChecked(r11)
                        goto L_0x00c5
                    L_0x0046:
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r2 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c r2 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.this
                        java.util.Map r2 = r2.f62951g
                        java.lang.Object r2 = r2.get(r0)
                        java.util.List r2 = (java.util.List) r2
                        java.util.Iterator r2 = r2.iterator()
                        r5 = r1
                        r1 = 0
                        r4 = 0
                    L_0x005b:
                        boolean r6 = r2.hasNext()
                        r7 = 1
                        if (r6 == 0) goto L_0x009d
                        java.lang.Object r6 = r2.next()
                        net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails r6 = (net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails) r6
                        boolean r8 = r6.isChecked()
                        if (r8 != r7) goto L_0x006f
                        r1 = 1
                    L_0x006f:
                        if (r11 == 0) goto L_0x0081
                        boolean r7 = r6.isChecked()
                        if (r7 != 0) goto L_0x0081
                        java.lang.String r7 = r6.getAmount()
                        int r7 = java.lang.Integer.parseInt(r7)
                    L_0x007f:
                        int r4 = r4 + r7
                        goto L_0x0092
                    L_0x0081:
                        if (r11 != 0) goto L_0x0092
                        boolean r7 = r6.isChecked()
                        if (r7 == 0) goto L_0x0092
                        java.lang.String r7 = r6.getAmount()
                        int r7 = java.lang.Integer.parseInt(r7)
                        goto L_0x007f
                    L_0x0092:
                        boolean r7 = r6.isChecked()
                        r5 = r5 | r7
                        if (r11 != 0) goto L_0x005b
                        r6.setChecked(r11)
                        goto L_0x005b
                    L_0x009d:
                        if (r1 != 0) goto L_0x00c3
                        if (r11 != r7) goto L_0x00c3
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r1 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c r1 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.this
                        java.util.Map r1 = r1.f62951g
                        java.lang.Object r0 = r1.get(r0)
                        java.util.List r0 = (java.util.List) r0
                        java.util.Iterator r0 = r0.iterator()
                    L_0x00b3:
                        boolean r1 = r0.hasNext()
                        if (r1 == 0) goto L_0x00c3
                        java.lang.Object r1 = r0.next()
                        net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails r1 = (net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails) r1
                        r1.setChecked(r7)
                        goto L_0x00b3
                    L_0x00c3:
                        r1 = r4
                        r2 = r5
                    L_0x00c5:
                        r0 = r11 ^ r2
                        if (r0 == 0) goto L_0x0158
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.this
                        java.util.Map r0 = r0.f62951g
                        java.util.Set r0 = r0.entrySet()
                        java.util.Iterator r0 = r0.iterator()
                    L_0x00d9:
                        boolean r2 = r0.hasNext()
                        if (r2 == 0) goto L_0x0101
                        java.lang.Object r2 = r0.next()
                        java.util.Map$Entry r2 = (java.util.Map.Entry) r2
                        java.lang.Object r2 = r2.getValue()
                        java.util.List r2 = (java.util.List) r2
                        java.util.Iterator r2 = r2.iterator()
                    L_0x00ef:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L_0x00d9
                        java.lang.Object r4 = r2.next()
                        net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails r4 = (net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails) r4
                        boolean r4 = r4.isChecked()
                        r3 = r3 | r4
                        goto L_0x00ef
                    L_0x0101:
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.this
                        android.widget.CheckBox r0 = r0.f62948d
                        boolean r0 = r0.isChecked()
                        r0 = r0 ^ r3
                        if (r0 == 0) goto L_0x0128
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.this
                        android.widget.CheckBox r0 = r0.f62948d
                        java.lang.Boolean r2 = java.lang.Boolean.FALSE
                        r0.setTag(r2)
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.this
                        android.widget.CheckBox r0 = r0.f62948d
                        r0.setChecked(r3)
                    L_0x0128:
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.c.a r0 = r0.f62952h
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
                        r0.a(r2, r11)
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$b r0 = r0.j
                        if (r0 == 0) goto L_0x0158
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c r0 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$b r0 = r0.j
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r2 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c r2 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.this
                        int r2 = r2.f62947a
                        r0.a(r1, r11, r2)
                    L_0x0158:
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c$a r11 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.this     // Catch:{ IllegalStateException -> 0x015f }
                        net.one97.paytm.recharge.legacy.catalog.hathway.a.c r11 = net.one97.paytm.recharge.legacy.catalog.hathway.a.c.this     // Catch:{ IllegalStateException -> 0x015f }
                        r11.notifyDataSetChanged()     // Catch:{ IllegalStateException -> 0x015f }
                    L_0x015f:
                        java.lang.Boolean r11 = java.lang.Boolean.TRUE
                        r10.setTag(r11)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.hathway.a.c.a.AnonymousClass1.onCheckedChanged(android.widget.CompoundButton, boolean):void");
                }
            });
            this.f62957d.setOnClickListener(new View.OnClickListener(c.this) {
                public final void onClick(View view) {
                    if (!c.f62945b) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key_plain_expiry_list", c.this.f62953i);
                        bundle.putInt("list_position", c.this.f62947a);
                        bundle.putString("key_pack_name", (String) a.this.f62957d.getTag());
                        Intent intent = new Intent(c.this.f62950f, CJRAddOnGroupMainActivity.class);
                        intent.putExtras(bundle);
                        c.this.f62950f.startActivityForResult(intent, 92);
                    }
                }
            });
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cable_check_box_item, viewGroup, false));
    }
}

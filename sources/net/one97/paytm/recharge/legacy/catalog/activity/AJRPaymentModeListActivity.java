package net.one97.paytm.recharge.legacy.catalog.activity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.o;
import net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity;

@Deprecated
public class AJRPaymentModeListActivity extends CJRRechargeBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private ListView f62790a;

    /* renamed from: b  reason: collision with root package name */
    private o f62791b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f62792c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<String> f62793d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, String> f62794e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<String> f62795f = new ArrayList<>();

    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_payment_mode_list);
        this.s = true;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("title")) {
                setTitle(extras.getString("title"));
                setTitleColor(-16777216);
            }
            if (extras.containsKey("payment_mode_list")) {
                this.f62792c = extras.getStringArrayList("payment_mode_list");
            }
            if (extras.containsKey("convenience_fee_map")) {
                this.f62794e = (HashMap) getIntent().getSerializableExtra("convenience_fee_map");
            }
        }
        this.f62793d = new ArrayList<>();
        ArrayList<String> arrayList = this.f62792c;
        if (!(arrayList == null || this.f62794e == null)) {
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String lowerCase = it2.next().toLowerCase();
                if (this.f62794e.containsKey(lowerCase)) {
                    this.f62795f.add(this.f62794e.get(lowerCase));
                    this.f62793d.add(lowerCase);
                }
            }
        }
        this.f62790a = (ListView) findViewById(R.id.payment_mode_list);
        this.f62791b = new o(this, this.f62793d, this.f62795f);
        this.f62790a.setAdapter(this.f62791b);
        this.f62790a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                /*
                    r0 = this;
                    android.widget.Adapter r2 = r1.getAdapter()
                    java.lang.Object r2 = r2.getItem(r3)
                    java.lang.String r2 = (java.lang.String) r2
                    android.widget.Adapter r1 = r1.getAdapter()
                    net.one97.paytm.recharge.common.a.o r1 = (net.one97.paytm.recharge.common.a.o) r1
                    java.util.ArrayList<java.lang.String> r1 = r1.f60642a
                    java.lang.Object r1 = r1.get(r3)
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.String r1 = com.paytm.utility.b.x((java.lang.String) r1)
                    android.content.Intent r4 = new android.content.Intent
                    r4.<init>()
                    java.lang.String r5 = "intent_extra_item_index"
                    r4.putExtra(r5, r3)
                    java.lang.String r3 = "payment_mode_selected"
                    r4.putExtra(r3, r2)
                    java.lang.String r2 = "convenience_fee_selected"
                    r4.putExtra(r2, r1)
                    net.one97.paytm.recharge.legacy.catalog.activity.AJRPaymentModeListActivity r1 = net.one97.paytm.recharge.legacy.catalog.activity.AJRPaymentModeListActivity.this
                    r2 = -1
                    r1.setResult(r2, r4)
                    net.one97.paytm.recharge.legacy.catalog.activity.AJRPaymentModeListActivity r1 = net.one97.paytm.recharge.legacy.catalog.activity.AJRPaymentModeListActivity.this
                    r1.finish()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.activity.AJRPaymentModeListActivity.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}

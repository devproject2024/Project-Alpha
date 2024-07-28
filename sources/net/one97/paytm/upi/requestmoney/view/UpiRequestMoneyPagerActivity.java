package net.one97.paytm.upi.requestmoney.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.requestmoney.view.g;
import net.one97.paytm.upi.util.CirclePageIndicator;
import net.one97.paytm.upi.util.UpiCustomViewPagerTrasfomationView;

public class UpiRequestMoneyPagerActivity extends PaytmActivity implements g.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Fragment> f69317a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<UpiPendingRequestModel> f69318b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.viewpager.widget.a f69319c;

    /* renamed from: d  reason: collision with root package name */
    private UpiCustomViewPagerTrasfomationView f69320d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f69321e;

    /* renamed from: f  reason: collision with root package name */
    private CirclePageIndicator f69322f;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upi_request_money_pager);
        if (Build.VERSION.SDK_INT == 26) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        if (getIntent() != null) {
            this.f69318b = (ArrayList) getIntent().getSerializableExtra("pendingRequestModelArrayList");
        }
        this.f69320d = (UpiCustomViewPagerTrasfomationView) findViewById(R.id.view_pager_upi);
        this.f69321e = (ImageView) findViewById(R.id.upi_close_button);
        this.f69322f = (CirclePageIndicator) findViewById(R.id.cpi_qr_pager);
        this.f69321e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiRequestMoneyPagerActivity.this.finish();
            }
        });
        this.f69317a = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        ArrayList<UpiPendingRequestModel> arrayList2 = this.f69318b;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            for (int i2 = 0; i2 < this.f69318b.size(); i2++) {
                if (!this.f69318b.get(i2).getType().equalsIgnoreCase("COLLECT") || !(this.f69318b.get(i2).getMandateDetails() == null || this.f69318b.get(i2).getMandateDetails().getUmn() == null)) {
                    arrayList.add(this.f69318b.get(i2));
                } else {
                    this.f69317a.add(g.a(this.f69318b.get(i2)));
                }
            }
        }
        if (!this.f69317a.isEmpty() || arrayList.isEmpty()) {
            this.f69319c = new a(getSupportFragmentManager(), this.f69317a);
            this.f69320d.setAdapter(this.f69319c);
            this.f69320d.setAnimationEnabled(true);
            this.f69320d.setFadeEnabled(true);
            this.f69320d.setFadeFactor(0.6f);
            this.f69321e.setVisibility(0);
            if (this.f69317a.size() > 1) {
                this.f69322f.setVisibility(0);
                this.f69322f.setViewPager(this.f69320d);
                return;
            }
            this.f69322f.setVisibility(8);
            return;
        }
        UpiPendingRequestModel upiPendingRequestModel = (UpiPendingRequestModel) arrayList.get(0);
        net.one97.paytm.upi.mandate.d.a aVar = net.one97.paytm.upi.mandate.d.a.f67112a;
        net.one97.paytm.upi.mandate.c.a.a(net.one97.paytm.upi.mandate.d.a.a(upiPendingRequestModel), getSupportFragmentManager(), upiPendingRequestModel);
        this.f69321e.setVisibility(8);
    }

    public void attachBaseContext(Context context) {
        if (i.a().m == null) {
            super.attachBaseContext(context);
        }
        ContextWrapper d2 = i.a().m.d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public final void a() {
        if (this.f69317a.size() == 1) {
            finish();
        }
        this.f69317a.remove(this.f69320d.getCurrentItem());
        this.f69319c.notifyDataSetChanged();
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Toast.makeText(this, getString(R.string.upi_spam_marked_success, new Object[]{str}), 1).show();
        }
        ArrayList<Fragment> arrayList = this.f69317a;
        if (arrayList != null && arrayList.size() >= this.f69320d.getCurrentItem() && this.f69317a.get(this.f69320d.getCurrentItem()) != null && (this.f69317a.get(this.f69320d.getCurrentItem()) instanceof g)) {
            String payeeVa = ((g) this.f69317a.get(this.f69320d.getCurrentItem())).f69443a.getPayeeVa();
            String payerVa = ((g) this.f69317a.get(this.f69320d.getCurrentItem())).f69443a.getPayerVa();
            this.f69317a.remove(this.f69320d.getCurrentItem());
            Iterator<Fragment> it2 = this.f69317a.iterator();
            while (it2.hasNext()) {
                g gVar = (g) it2.next();
                String payerVa2 = gVar.f69443a.getPayerVa();
                String payeeVa2 = gVar.f69443a.getPayeeVa();
                if (!TextUtils.isEmpty(payerVa2) && !TextUtils.isEmpty(payeeVa2) && payerVa.equalsIgnoreCase(payerVa2) && payeeVa.equalsIgnoreCase(payeeVa2)) {
                    it2.remove();
                }
            }
        }
        ArrayList<Fragment> arrayList2 = this.f69317a;
        if (arrayList2 == null || arrayList2.size() == 0) {
            finish();
        }
        this.f69319c.notifyDataSetChanged();
    }

    public static class a extends o {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<Fragment> f69324a;

        public final int getItemPosition(Object obj) {
            return -2;
        }

        public a(j jVar, ArrayList<Fragment> arrayList) {
            super(jVar);
            this.f69324a = arrayList;
        }

        public final Fragment getItem(int i2) {
            return this.f69324a.get(i2);
        }

        public final int getCount() {
            return this.f69324a.size();
        }
    }
}

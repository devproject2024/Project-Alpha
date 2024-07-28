package net.one97.paytm.wallet.splitbill.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.o;
import net.one97.paytm.wallet.splitbill.b.b;
import net.one97.paytm.wallet.splitbill.b.d;
import net.one97.paytm.wallet.splitbill.c.l;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;

public class SBSplitBillActivity extends PaytmActivity implements b, d {

    /* renamed from: a  reason: collision with root package name */
    private TabLayout f72052a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ViewPager f72053b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public o f72054c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<SBContactDetail> f72055d = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f72056e;

    /* renamed from: f  reason: collision with root package name */
    private String f72057f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<SBContactDetail> f72058g = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<SBContactDetail> f72059h = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f72060i = true;

    public final void a(SBContactDetail sBContactDetail) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sb_activity_split_bill);
        if (getIntent() != null) {
            if (getIntent().hasExtra("list")) {
                this.f72055d = (ArrayList) getIntent().getSerializableExtra("list");
            }
            if (getIntent().hasExtra("bill_amount")) {
                this.f72056e = getIntent().getStringExtra("bill_amount");
            }
            if (getIntent().hasExtra("split_options")) {
                this.f72057f = getIntent().getStringExtra("split_options");
            }
            if (getIntent().hasExtra("paid_contact_list")) {
                this.f72058g = (ArrayList) getIntent().getSerializableExtra("paid_contact_list");
            }
            if (getIntent().hasExtra("split_contact_list")) {
                this.f72059h = (ArrayList) getIntent().getSerializableExtra("split_contact_list");
            }
            if (getIntent().hasExtra("equally_switch")) {
                this.f72060i = getIntent().getBooleanExtra("equally_switch", true);
            }
        }
        this.f72052a = (TabLayout) findViewById(R.id.tl_card_tabs);
        this.f72053b = (ViewPager) findViewById(R.id.vp_card);
        this.f72054c = new o(this, getSupportFragmentManager(), this.f72055d, this.f72056e, this.f72057f, this.f72058g, this.f72059h, this.f72060i);
        this.f72053b.setAdapter(this.f72054c);
        if (this.f72057f.equalsIgnoreCase("paid_by")) {
            this.f72053b.setCurrentItem(0);
        } else {
            this.f72053b.setCurrentItem(1);
        }
        this.f72052a.setupWithViewPager(this.f72053b);
        this.f72053b.addOnPageChangeListener(new ViewPager.e() {
            public final void onPageScrollStateChanged(int i2) {
            }

            public final void onPageScrolled(int i2, float f2, int i3) {
                SBSplitBillActivity.a(SBSplitBillActivity.this, i2);
            }

            public final void onPageSelected(int i2) {
                SBSplitBillActivity.a(SBSplitBillActivity.this, i2);
            }
        });
        ((ImageView) findViewById(R.id.split_back_button)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBSplitBillActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.tvDone)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                boolean z;
                if (SBSplitBillActivity.this.f72053b.getCurrentItem() == 0) {
                    Iterator it2 = SBSplitBillActivity.this.f72058g.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (((SBContactDetail) it2.next()).getmIsSelectedForPay()) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        ((l) SBSplitBillActivity.this.f72054c.instantiateItem(SBSplitBillActivity.this.f72053b, SBSplitBillActivity.this.f72053b.getCurrentItem())).a(true);
                        return;
                    }
                    SBSplitBillActivity sBSplitBillActivity = SBSplitBillActivity.this;
                    if (sBSplitBillActivity.c((ArrayList<SBContactDetail>) sBSplitBillActivity.f72058g)) {
                        Intent intent = new Intent(SBSplitBillActivity.this, SBEnterBillActivity.class);
                        intent.putExtra("paid_contact_list", SBSplitBillActivity.this.f72058g);
                        intent.putExtra("split_contact_list", SBSplitBillActivity.this.f72059h);
                        intent.putExtra("equally_switch", SBSplitBillActivity.this.f72060i);
                        intent.putExtra("bill_amount", SBSplitBillActivity.this.f72056e);
                        SBSplitBillActivity.this.setResult(-1, intent);
                        SBSplitBillActivity.this.finish();
                        return;
                    }
                    ((l) SBSplitBillActivity.this.f72054c.instantiateItem(SBSplitBillActivity.this.f72053b, SBSplitBillActivity.this.f72053b.getCurrentItem())).a(false);
                    return;
                }
                if (!SBSplitBillActivity.this.f72060i) {
                    SBSplitBillActivity sBSplitBillActivity2 = SBSplitBillActivity.this;
                    if (!sBSplitBillActivity2.d((ArrayList<SBContactDetail>) sBSplitBillActivity2.f72059h)) {
                        ((l) SBSplitBillActivity.this.f72054c.instantiateItem(SBSplitBillActivity.this.f72053b, SBSplitBillActivity.this.f72053b.getCurrentItem())).a(false);
                        return;
                    }
                }
                Intent intent2 = new Intent(SBSplitBillActivity.this, SBEnterBillActivity.class);
                intent2.putExtra("paid_contact_list", SBSplitBillActivity.this.f72058g);
                intent2.putExtra("split_contact_list", SBSplitBillActivity.this.f72059h);
                intent2.putExtra("equally_switch", SBSplitBillActivity.this.f72060i);
                intent2.putExtra("bill_amount", SBSplitBillActivity.this.f72056e);
                SBSplitBillActivity.this.setResult(-1, intent2);
                SBSplitBillActivity.this.finish();
            }
        });
    }

    public final void a(ArrayList<SBContactDetail> arrayList) {
        this.f72058g = arrayList;
    }

    public final void b(ArrayList<SBContactDetail> arrayList) {
        this.f72059h = arrayList;
    }

    public final void a(boolean z) {
        this.f72060i = z;
    }

    public final boolean c(ArrayList<SBContactDetail> arrayList) {
        Iterator<SBContactDetail> it2 = arrayList.iterator();
        double d2 = 0.0d;
        while (it2.hasNext()) {
            SBContactDetail next = it2.next();
            if (next.getmIsSelectedForPay()) {
                d2 += Double.parseDouble(next.getmAmount());
            }
        }
        return d2 == Double.parseDouble(this.f72056e);
    }

    public final boolean d(ArrayList<SBContactDetail> arrayList) {
        Iterator<SBContactDetail> it2 = arrayList.iterator();
        double d2 = 0.0d;
        while (it2.hasNext()) {
            d2 += Double.parseDouble(it2.next().getmAmount());
        }
        return d2 == Double.parseDouble(this.f72056e);
    }

    static /* synthetic */ void a(SBSplitBillActivity sBSplitBillActivity, int i2) {
        boolean z;
        try {
            View currentFocus = sBSplitBillActivity.getCurrentFocus();
            if (currentFocus != null) {
                ((InputMethodManager) sBSplitBillActivity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        } catch (Exception unused) {
        }
        if (i2 == 1) {
            Iterator<SBContactDetail> it2 = sBSplitBillActivity.f72058g.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().getmIsSelectedForPay()) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                sBSplitBillActivity.f72053b.setCurrentItem(0);
                o oVar = sBSplitBillActivity.f72054c;
                ViewPager viewPager = sBSplitBillActivity.f72053b;
                ((l) oVar.instantiateItem(viewPager, viewPager.getCurrentItem())).a(true);
            } else if (!sBSplitBillActivity.c(sBSplitBillActivity.f72058g)) {
                sBSplitBillActivity.f72053b.setCurrentItem(0);
                o oVar2 = sBSplitBillActivity.f72054c;
                ViewPager viewPager2 = sBSplitBillActivity.f72053b;
                ((l) oVar2.instantiateItem(viewPager2, viewPager2.getCurrentItem())).a(false);
            }
        } else if (!sBSplitBillActivity.f72060i && !sBSplitBillActivity.d(sBSplitBillActivity.f72059h)) {
            sBSplitBillActivity.f72053b.setCurrentItem(1);
            o oVar3 = sBSplitBillActivity.f72054c;
            ViewPager viewPager3 = sBSplitBillActivity.f72053b;
            ((l) oVar3.instantiateItem(viewPager3, viewPager3.getCurrentItem())).a(false);
        }
    }
}

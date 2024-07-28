package net.one97.paytm.wallet.splitbill.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;

public class SBSplitBillForTwoActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f72064a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f72065b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f72066c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f72067d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f72068e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f72069f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f72070g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f72071h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f72072i;
    private TextView j;
    private TextView k;
    private TextView l;
    private ArrayList<SBContactDetail> m = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<SBContactDetail> n = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<SBContactDetail> o = new ArrayList<>();
    private boolean p = true;
    /* access modifiers changed from: private */
    public int q = -1;

    public void onCreate(Bundle bundle) {
        ArrayList<SBContactDetail> arrayList;
        super.onCreate(bundle);
        setContentView(R.layout.sb_split_bill_for_two_activity);
        if (getIntent() != null) {
            if (getIntent().hasExtra("bill_amount")) {
                this.f72067d = getIntent().getStringExtra("bill_amount");
            }
            if (getIntent().hasExtra("list")) {
                this.m = (ArrayList) getIntent().getSerializableExtra("list");
            }
            if (getIntent().hasExtra("paid_contact_list")) {
                this.n = (ArrayList) getIntent().getSerializableExtra("paid_contact_list");
            }
            if (getIntent().hasExtra("split_contact_list")) {
                this.o = (ArrayList) getIntent().getSerializableExtra("split_contact_list");
            }
            if (getIntent().hasExtra("equally_switch")) {
                this.p = getIntent().getBooleanExtra("equally_switch", true);
            }
        }
        this.f72064a = (ImageView) findViewById(R.id.split_back_button);
        this.f72065b = (TextView) findViewById(R.id.tvDone);
        this.f72066c = (TextView) findViewById(R.id.tvAmount);
        this.f72068e = (ImageView) findViewById(R.id.iv_radio_button1);
        this.f72069f = (ImageView) findViewById(R.id.iv_radio_button2);
        this.f72070g = (ImageView) findViewById(R.id.iv_radio_button3);
        this.f72071h = (ImageView) findViewById(R.id.iv_radio_button4);
        this.f72072i = (TextView) findViewById(R.id.tv_option1);
        this.j = (TextView) findViewById(R.id.tv_option2);
        this.k = (TextView) findViewById(R.id.tv_option3);
        this.l = (TextView) findViewById(R.id.tv_option4);
        if (this.f72067d != null) {
            TextView textView = this.f72066c;
            textView.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + this.f72067d);
        }
        if (!(this.m == null || (arrayList = this.n) == null || this.o == null)) {
            if (a(arrayList)) {
                Iterator<SBContactDetail> it2 = this.n.iterator();
                String str = "";
                String str2 = str;
                while (it2.hasNext()) {
                    SBContactDetail next = it2.next();
                    if (!next.getmName().equalsIgnoreCase("You")) {
                        str = next.getmName();
                    }
                    if (next.getmIsSelectedForPay()) {
                        str2 = next.getmName();
                    }
                }
                this.f72072i.setText("You paid and split equally");
                TextView textView2 = this.j;
                textView2.setText(str + " paid and split equally");
                TextView textView3 = this.k;
                textView3.setText("You have to pay ₹" + this.f72067d + " to " + str);
                TextView textView4 = this.l;
                textView4.setText(str + " has to pay you ₹" + this.f72067d);
                if (str2.equalsIgnoreCase("You") && this.p) {
                    this.q = 1;
                } else if (str2.equalsIgnoreCase("You") && !this.p) {
                    this.q = 4;
                } else if (!str2.equalsIgnoreCase("You") && this.p) {
                    this.q = 2;
                } else if (!str2.equalsIgnoreCase("You") && !this.p) {
                    this.q = 3;
                }
                a(this.q);
            } else {
                this.f72072i.setText("You paid and split equally");
                TextView textView5 = this.j;
                textView5.setText(this.m.get(1).getmName() + " paid and split equally");
                TextView textView6 = this.k;
                textView6.setText("You have to pay ₹" + this.f72067d + " to " + this.m.get(1).getmName());
                TextView textView7 = this.l;
                textView7.setText(this.m.get(1).getmName() + " has to pay you ₹" + this.f72067d);
                this.q = 1;
                a(this.q);
            }
        }
        this.f72068e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int unused = SBSplitBillForTwoActivity.this.q = 1;
                SBSplitBillForTwoActivity sBSplitBillForTwoActivity = SBSplitBillForTwoActivity.this;
                sBSplitBillForTwoActivity.a(sBSplitBillForTwoActivity.q);
            }
        });
        this.f72072i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int unused = SBSplitBillForTwoActivity.this.q = 1;
                SBSplitBillForTwoActivity sBSplitBillForTwoActivity = SBSplitBillForTwoActivity.this;
                sBSplitBillForTwoActivity.a(sBSplitBillForTwoActivity.q);
            }
        });
        this.f72069f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int unused = SBSplitBillForTwoActivity.this.q = 2;
                SBSplitBillForTwoActivity sBSplitBillForTwoActivity = SBSplitBillForTwoActivity.this;
                sBSplitBillForTwoActivity.a(sBSplitBillForTwoActivity.q);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int unused = SBSplitBillForTwoActivity.this.q = 2;
                SBSplitBillForTwoActivity sBSplitBillForTwoActivity = SBSplitBillForTwoActivity.this;
                sBSplitBillForTwoActivity.a(sBSplitBillForTwoActivity.q);
            }
        });
        this.f72070g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int unused = SBSplitBillForTwoActivity.this.q = 3;
                SBSplitBillForTwoActivity sBSplitBillForTwoActivity = SBSplitBillForTwoActivity.this;
                sBSplitBillForTwoActivity.a(sBSplitBillForTwoActivity.q);
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int unused = SBSplitBillForTwoActivity.this.q = 3;
                SBSplitBillForTwoActivity sBSplitBillForTwoActivity = SBSplitBillForTwoActivity.this;
                sBSplitBillForTwoActivity.a(sBSplitBillForTwoActivity.q);
            }
        });
        this.f72071h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int unused = SBSplitBillForTwoActivity.this.q = 4;
                SBSplitBillForTwoActivity sBSplitBillForTwoActivity = SBSplitBillForTwoActivity.this;
                sBSplitBillForTwoActivity.a(sBSplitBillForTwoActivity.q);
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int unused = SBSplitBillForTwoActivity.this.q = 4;
                SBSplitBillForTwoActivity sBSplitBillForTwoActivity = SBSplitBillForTwoActivity.this;
                sBSplitBillForTwoActivity.a(sBSplitBillForTwoActivity.q);
            }
        });
        this.f72064a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBSplitBillForTwoActivity.this.finish();
            }
        });
        this.f72065b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int a2 = SBSplitBillForTwoActivity.this.q;
                if (a2 == 1) {
                    Iterator it2 = SBSplitBillForTwoActivity.this.n.iterator();
                    while (it2.hasNext()) {
                        SBContactDetail sBContactDetail = (SBContactDetail) it2.next();
                        if (sBContactDetail.getmName().equalsIgnoreCase("You")) {
                            sBContactDetail.setmAmount(SBSplitBillForTwoActivity.this.f72067d);
                            sBContactDetail.setmIsSelectedForPay(true);
                        } else {
                            sBContactDetail.setmIsSelectedForPay(false);
                            sBContactDetail.setmAmount("0");
                        }
                    }
                    Iterator it3 = SBSplitBillForTwoActivity.this.o.iterator();
                    while (it3.hasNext()) {
                        ((SBContactDetail) it3.next()).setmAmount(String.valueOf(Double.parseDouble(SBSplitBillForTwoActivity.this.f72067d) / 2.0d));
                    }
                    SBSplitBillForTwoActivity.c(SBSplitBillForTwoActivity.this, 1);
                } else if (a2 == 2) {
                    Iterator it4 = SBSplitBillForTwoActivity.this.n.iterator();
                    while (it4.hasNext()) {
                        SBContactDetail sBContactDetail2 = (SBContactDetail) it4.next();
                        if (!sBContactDetail2.getmName().equalsIgnoreCase("You")) {
                            sBContactDetail2.setmAmount(SBSplitBillForTwoActivity.this.f72067d);
                            sBContactDetail2.setmIsSelectedForPay(true);
                        } else {
                            sBContactDetail2.setmAmount("0");
                            sBContactDetail2.setmIsSelectedForPay(false);
                        }
                    }
                    Iterator it5 = SBSplitBillForTwoActivity.this.o.iterator();
                    while (it5.hasNext()) {
                        ((SBContactDetail) it5.next()).setmAmount(String.valueOf(Double.parseDouble(SBSplitBillForTwoActivity.this.f72067d) / 2.0d));
                    }
                    SBSplitBillForTwoActivity.c(SBSplitBillForTwoActivity.this, 2);
                } else if (a2 == 3) {
                    Iterator it6 = SBSplitBillForTwoActivity.this.n.iterator();
                    while (it6.hasNext()) {
                        SBContactDetail sBContactDetail3 = (SBContactDetail) it6.next();
                        if (!sBContactDetail3.getmName().equalsIgnoreCase("You")) {
                            sBContactDetail3.setmAmount(SBSplitBillForTwoActivity.this.f72067d);
                            sBContactDetail3.setmIsSelectedForPay(true);
                        } else {
                            sBContactDetail3.setmAmount("0");
                            sBContactDetail3.setmIsSelectedForPay(false);
                        }
                    }
                    Iterator it7 = SBSplitBillForTwoActivity.this.o.iterator();
                    while (it7.hasNext()) {
                        SBContactDetail sBContactDetail4 = (SBContactDetail) it7.next();
                        if (sBContactDetail4.getmName().equalsIgnoreCase("You")) {
                            sBContactDetail4.setmAmount(SBSplitBillForTwoActivity.this.f72067d);
                        } else {
                            sBContactDetail4.setmAmount("0");
                        }
                    }
                    SBSplitBillForTwoActivity.c(SBSplitBillForTwoActivity.this, 3);
                } else if (a2 != 4) {
                    Toast.makeText(SBSplitBillForTwoActivity.this, "Please select one option to continue.", 0).show();
                } else {
                    Iterator it8 = SBSplitBillForTwoActivity.this.n.iterator();
                    while (it8.hasNext()) {
                        SBContactDetail sBContactDetail5 = (SBContactDetail) it8.next();
                        if (sBContactDetail5.getmName().equalsIgnoreCase("You")) {
                            sBContactDetail5.setmAmount(SBSplitBillForTwoActivity.this.f72067d);
                            sBContactDetail5.setmIsSelectedForPay(true);
                        } else {
                            sBContactDetail5.setmAmount("0");
                            sBContactDetail5.setmIsSelectedForPay(false);
                        }
                    }
                    Iterator it9 = SBSplitBillForTwoActivity.this.o.iterator();
                    while (it9.hasNext()) {
                        SBContactDetail sBContactDetail6 = (SBContactDetail) it9.next();
                        if (!sBContactDetail6.getmName().equalsIgnoreCase("You")) {
                            sBContactDetail6.setmAmount(SBSplitBillForTwoActivity.this.f72067d);
                        } else {
                            sBContactDetail6.setmAmount("0");
                        }
                    }
                    SBSplitBillForTwoActivity.c(SBSplitBillForTwoActivity.this, 4);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (i2 == 1) {
            this.p = true;
            this.f72068e.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_active));
            this.f72069f.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_inactive));
            this.f72070g.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_inactive));
            this.f72071h.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_inactive));
        } else if (i2 == 2) {
            this.p = true;
            this.f72068e.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_inactive));
            this.f72069f.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_active));
            this.f72070g.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_inactive));
            this.f72071h.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_inactive));
        } else if (i2 == 3) {
            this.p = false;
            this.f72068e.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_inactive));
            this.f72069f.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_inactive));
            this.f72070g.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_active));
            this.f72071h.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_inactive));
        } else if (i2 == 4) {
            this.p = false;
            this.f72068e.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_inactive));
            this.f72069f.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_inactive));
            this.f72070g.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_inactive));
            this.f72071h.setBackground(b.a((Context) this, R.drawable.ic_sb_ic_radio_active));
        }
    }

    private static boolean a(ArrayList<SBContactDetail> arrayList) {
        Iterator<SBContactDetail> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (it2.next().getmIsSelectedForPay()) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void c(SBSplitBillForTwoActivity sBSplitBillForTwoActivity, int i2) {
        boolean z = true;
        if (!(i2 == 1 || i2 == 2 || (i2 != 3 && i2 != 4))) {
            z = false;
        }
        Intent intent = new Intent(sBSplitBillForTwoActivity, SBEnterBillActivity.class);
        intent.putExtra("paid_contact_list", sBSplitBillForTwoActivity.n);
        intent.putExtra("bill_amount", sBSplitBillForTwoActivity.f72067d);
        intent.putExtra("split_contact_list", sBSplitBillForTwoActivity.o);
        intent.putExtra("equally_switch", z);
        sBSplitBillForTwoActivity.setResult(-1, intent);
        sBSplitBillForTwoActivity.finish();
    }
}

package net.one97.paytm.wallet.splitbill.a;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.b.d;
import net.one97.paytm.wallet.splitbill.e.b;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;

public final class l extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<SBContactDetail> f71897a;

    /* renamed from: b  reason: collision with root package name */
    int f71898b;

    /* renamed from: c  reason: collision with root package name */
    d f71899c;

    /* renamed from: d  reason: collision with root package name */
    net.one97.paytm.wallet.splitbill.c.l f71900d;

    /* renamed from: e  reason: collision with root package name */
    Double f71901e;

    /* renamed from: f  reason: collision with root package name */
    private Activity f71902f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f71903g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<SBContactDetail> f71904h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<SBContactDetail> f71905i = new ArrayList<>();
    private ArrayList<String> j = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        String str;
        final a aVar = (a) vVar;
        aVar.f71913b.setText(this.f71897a.get(i2).getmName());
        aVar.f71914c.setBackgroundColor(Color.parseColor(this.j.get(i2 % 10)));
        if (this.f71897a.get(i2).getmName() != null) {
            str = b.a(this.f71897a.get(i2).getmName());
        } else {
            str = "";
        }
        TextView textView = aVar.f71914c;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        textView.setText(str);
        if (this.f71898b == 1) {
            if (this.f71903g) {
                aVar.f71917f.setVisibility(0);
                aVar.f71917f.setText(new DecimalFormat("##.##").format(a(this.f71897a.get(i2).getmAmount())));
                aVar.f71917f.setSelection(aVar.f71917f.getText().length());
            } else if (this.f71897a.get(i2).getmAmount().equalsIgnoreCase("0")) {
                aVar.f71917f.clearFocus();
                aVar.f71917f.setVisibility(0);
                aVar.f71917f.setSelection(aVar.f71917f.getText().length());
            } else {
                aVar.f71917f.setVisibility(0);
                aVar.f71917f.setText(new DecimalFormat("##.##").format(a(this.f71897a.get(i2).getmAmount())));
                aVar.f71917f.setSelection(aVar.f71917f.getText().length());
            }
            this.f71905i.add(this.f71897a.get(i2));
            this.f71899c.b(this.f71905i);
        } else {
            if (this.f71897a.get(i2).getmIsSelectedForPay()) {
                if (!this.f71897a.get(i2).getmAmount().equalsIgnoreCase("0")) {
                    aVar.f71915d.setVisibility(0);
                    aVar.f71917f.setText(new DecimalFormat("##.##").format(a(this.f71897a.get(i2).getmAmount())));
                } else {
                    aVar.f71917f.setText("");
                    aVar.f71915d.setVisibility(4);
                }
                aVar.f71912a.setVisibility(0);
                aVar.f71914c.setVisibility(4);
                aVar.f71917f.setVisibility(0);
                aVar.f71917f.setSelection(aVar.f71917f.getText().length());
            } else {
                aVar.f71915d.setVisibility(4);
                aVar.f71912a.setVisibility(4);
                aVar.f71914c.setVisibility(0);
                aVar.f71917f.setVisibility(4);
            }
            this.f71904h.add(this.f71897a.get(i2));
            this.f71899c.a(this.f71904h);
        }
        aVar.f71917f.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0086, code lost:
                r10 = false;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void afterTextChanged(android.text.Editable r10) {
                /*
                    r9 = this;
                    net.one97.paytm.wallet.splitbill.a.l r10 = net.one97.paytm.wallet.splitbill.a.l.this
                    net.one97.paytm.wallet.splitbill.c.l r10 = r10.f71900d
                    r10.b()
                    net.one97.paytm.wallet.splitbill.a.l r10 = net.one97.paytm.wallet.splitbill.a.l.this
                    int r10 = r10.f71898b
                    java.lang.String r0 = "0"
                    r1 = 1
                    if (r10 != r1) goto L_0x009e
                    net.one97.paytm.wallet.splitbill.a.l$a r10 = r7
                    android.widget.EditText r10 = r10.f71917f
                    android.text.Editable r10 = r10.getText()
                    java.lang.String r10 = r10.toString()
                    boolean r2 = android.text.TextUtils.isEmpty(r10)
                    if (r2 == 0) goto L_0x0033
                    net.one97.paytm.wallet.splitbill.a.l r10 = net.one97.paytm.wallet.splitbill.a.l.this
                    java.util.ArrayList<net.one97.paytm.wallet.splitbill.model.SBContactDetail> r10 = r10.f71897a
                    int r2 = r8
                    java.lang.Object r10 = r10.get(r2)
                    net.one97.paytm.wallet.splitbill.model.SBContactDetail r10 = (net.one97.paytm.wallet.splitbill.model.SBContactDetail) r10
                    r10.setmAmount(r0)
                    r10 = r0
                    goto L_0x0042
                L_0x0033:
                    net.one97.paytm.wallet.splitbill.a.l r0 = net.one97.paytm.wallet.splitbill.a.l.this
                    java.util.ArrayList<net.one97.paytm.wallet.splitbill.model.SBContactDetail> r0 = r0.f71897a
                    int r2 = r8
                    java.lang.Object r0 = r0.get(r2)
                    net.one97.paytm.wallet.splitbill.model.SBContactDetail r0 = (net.one97.paytm.wallet.splitbill.model.SBContactDetail) r0
                    r0.setmAmount(r10)
                L_0x0042:
                    r0 = 0
                    r2 = 0
                L_0x0044:
                    net.one97.paytm.wallet.splitbill.a.l r3 = net.one97.paytm.wallet.splitbill.a.l.this
                    java.util.ArrayList<net.one97.paytm.wallet.splitbill.model.SBContactDetail> r3 = r3.f71897a
                    int r3 = r3.size()
                    if (r2 >= r3) goto L_0x008b
                    int r3 = r8
                    if (r2 == r3) goto L_0x0088
                    net.one97.paytm.wallet.splitbill.a.l r3 = net.one97.paytm.wallet.splitbill.a.l.this
                    java.util.ArrayList<net.one97.paytm.wallet.splitbill.model.SBContactDetail> r3 = r3.f71897a
                    java.lang.Object r3 = r3.get(r2)
                    net.one97.paytm.wallet.splitbill.model.SBContactDetail r3 = (net.one97.paytm.wallet.splitbill.model.SBContactDetail) r3
                    java.lang.String r3 = r3.getmAmount()
                    double r3 = java.lang.Double.parseDouble(r3)
                    double r5 = java.lang.Double.parseDouble(r10)
                    int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r7 != 0) goto L_0x0086
                    double r3 = java.lang.Double.parseDouble(r10)
                    net.one97.paytm.wallet.splitbill.a.l r5 = net.one97.paytm.wallet.splitbill.a.l.this
                    java.lang.Double r5 = r5.f71901e
                    double r5 = r5.doubleValue()
                    net.one97.paytm.wallet.splitbill.a.l r7 = net.one97.paytm.wallet.splitbill.a.l.this
                    java.util.ArrayList<net.one97.paytm.wallet.splitbill.model.SBContactDetail> r7 = r7.f71897a
                    int r7 = r7.size()
                    double r7 = (double) r7
                    double r5 = r5 / r7
                    int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r7 == 0) goto L_0x0088
                L_0x0086:
                    r10 = 0
                    goto L_0x008c
                L_0x0088:
                    int r2 = r2 + 1
                    goto L_0x0044
                L_0x008b:
                    r10 = 1
                L_0x008c:
                    if (r10 == 0) goto L_0x0096
                    net.one97.paytm.wallet.splitbill.a.l r10 = net.one97.paytm.wallet.splitbill.a.l.this
                    net.one97.paytm.wallet.splitbill.c.l r10 = r10.f71900d
                    r10.a((boolean) r1, (boolean) r0)
                    return
                L_0x0096:
                    net.one97.paytm.wallet.splitbill.a.l r10 = net.one97.paytm.wallet.splitbill.a.l.this
                    net.one97.paytm.wallet.splitbill.c.l r10 = r10.f71900d
                    r10.a((boolean) r0, (boolean) r1)
                    return
                L_0x009e:
                    net.one97.paytm.wallet.splitbill.a.l$a r10 = r7
                    android.widget.EditText r10 = r10.f71917f
                    android.text.Editable r10 = r10.getText()
                    java.lang.String r10 = r10.toString()
                    boolean r1 = android.text.TextUtils.isEmpty(r10)
                    if (r1 == 0) goto L_0x00c0
                    net.one97.paytm.wallet.splitbill.a.l r10 = net.one97.paytm.wallet.splitbill.a.l.this
                    java.util.ArrayList<net.one97.paytm.wallet.splitbill.model.SBContactDetail> r10 = r10.f71897a
                    int r1 = r8
                    java.lang.Object r10 = r10.get(r1)
                    net.one97.paytm.wallet.splitbill.model.SBContactDetail r10 = (net.one97.paytm.wallet.splitbill.model.SBContactDetail) r10
                    r10.setmAmount(r0)
                    goto L_0x00cf
                L_0x00c0:
                    net.one97.paytm.wallet.splitbill.a.l r0 = net.one97.paytm.wallet.splitbill.a.l.this
                    java.util.ArrayList<net.one97.paytm.wallet.splitbill.model.SBContactDetail> r0 = r0.f71897a
                    int r1 = r8
                    java.lang.Object r0 = r0.get(r1)
                    net.one97.paytm.wallet.splitbill.model.SBContactDetail r0 = (net.one97.paytm.wallet.splitbill.model.SBContactDetail) r0
                    r0.setmAmount(r10)
                L_0x00cf:
                    net.one97.paytm.wallet.splitbill.a.l r10 = net.one97.paytm.wallet.splitbill.a.l.this
                    net.one97.paytm.wallet.splitbill.b.d r10 = r10.f71899c
                    net.one97.paytm.wallet.splitbill.a.l r0 = net.one97.paytm.wallet.splitbill.a.l.this
                    java.util.ArrayList<net.one97.paytm.wallet.splitbill.model.SBContactDetail> r0 = r0.f71897a
                    r10.a((java.util.ArrayList<net.one97.paytm.wallet.splitbill.model.SBContactDetail>) r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.splitbill.a.l.AnonymousClass2.afterTextChanged(android.text.Editable):void");
            }
        });
        aVar.f71916e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (l.this.f71898b == 0) {
                    l.this.f71900d.a();
                    l lVar = l.this;
                    a aVar = aVar;
                    int i2 = i2;
                    lVar.f71900d.b();
                    if (lVar.f71897a.get(i2).getmIsSelectedForPay()) {
                        aVar.f71912a.setVisibility(4);
                        aVar.f71914c.setVisibility(0);
                        aVar.f71917f.setVisibility(4);
                        aVar.f71917f.setText("");
                        aVar.f71915d.setVisibility(4);
                        lVar.f71897a.get(i2).setmIsSelectedForPay(false);
                        lVar.f71897a.get(i2).setmAmount("0");
                        return;
                    }
                    aVar.f71912a.setVisibility(0);
                    aVar.f71914c.setVisibility(4);
                    aVar.f71917f.setVisibility(0);
                    aVar.f71917f.setText("");
                    aVar.f71915d.setVisibility(0);
                    lVar.f71897a.get(i2).setmIsSelectedForPay(true);
                    lVar.f71897a.get(i2).setmAmount("0");
                }
            }
        });
    }

    public l(ArrayList<SBContactDetail> arrayList, Activity activity, net.one97.paytm.wallet.splitbill.c.l lVar, double d2, boolean z, int i2) {
        this.f71902f = activity;
        this.f71897a = arrayList;
        this.f71903g = z;
        this.f71898b = i2;
        this.f71899c = (d) this.f71902f;
        this.f71900d = lVar;
        this.f71901e = Double.valueOf(d2);
    }

    public final int getItemCount() {
        if (this.f71897a.size() > 0) {
            return this.f71897a.size();
        }
        return 0;
    }

    private static Double a(String str) {
        if (TextUtils.isEmpty(str)) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf(Double.parseDouble(str));
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f71912a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71913b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71914c;

        /* renamed from: d  reason: collision with root package name */
        TextView f71915d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f71916e;

        /* renamed from: f  reason: collision with root package name */
        EditText f71917f;

        /* renamed from: h  reason: collision with root package name */
        private RelativeLayout f71919h;

        public a(View view) {
            super(view);
            this.f71912a = (ImageView) view.findViewById(R.id.imgTick);
            this.f71913b = (TextView) view.findViewById(R.id.name);
            this.f71914c = (TextView) view.findViewById(R.id.mp_initial_name_tv);
            this.f71919h = (RelativeLayout) view.findViewById(R.id.mp_initial_name_rl);
            this.f71915d = (TextView) view.findViewById(R.id.tv_rupee_symbol);
            this.f71917f = (EditText) view.findViewById(R.id.editAmount);
            this.f71916e = (RelativeLayout) view.findViewById(R.id.parentLayout);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_split_bill_item, (ViewGroup) null));
    }
}

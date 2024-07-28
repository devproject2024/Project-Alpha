package net.one97.paytm.moneytransfer.view.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.i.f;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.m;

public final class c extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f54438a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f54439b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f54440c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f54441d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f54442e;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.bank_health_bottomsheet, viewGroup, false);
        k.a((Object) inflate, "view");
        View.OnClickListener onClickListener = this;
        inflate.findViewById(R.id.cross_iv).setOnClickListener(onClickListener);
        inflate.findViewById(R.id.linearLayout2).setOnClickListener(onClickListener);
        String str = null;
        this.f54438a = inflate != null ? (TextView) inflate.findViewById(R.id.title) : null;
        this.f54439b = inflate != null ? (TextView) inflate.findViewById(R.id.message) : null;
        this.f54441d = inflate != null ? (ImageView) inflate.findViewById(R.id.bankImageView) : null;
        this.f54440c = inflate != null ? (TextView) inflate.findViewById(R.id.proceedTV) : null;
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            CharSequence string = arguments != null ? arguments.getString("neft_error_message") : null;
            if (!TextUtils.isEmpty(string) && (textView4 = this.f54438a) != null) {
                textView4.setText(string);
            }
            Bundle arguments2 = getArguments();
            CharSequence string2 = arguments2 != null ? arguments2.getString("neft_tooltip_message") : null;
            if (!TextUtils.isEmpty(string2) && (textView3 = this.f54439b) != null) {
                textView3.setText(string2);
            }
            Bundle arguments3 = getArguments();
            m.a(this.f54441d, arguments3 != null ? arguments3.getString("ifsc") : null, getContext());
            Bundle arguments4 = getArguments();
            if (arguments4 != null) {
                str = arguments4.getString("category");
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -2070168808) {
                    if (hashCode != 81009) {
                        if (hashCode == 1876962931 && str.equals("NPCI_DOWN_TIME") && (textView2 = this.f54440c) != null) {
                            textView2.setText(getString(R.string.ok_got_it_with_comma));
                        }
                    } else if (str.equals("RED")) {
                        if (!a()) {
                            TextView textView5 = this.f54440c;
                            if (textView5 != null) {
                                textView5.setText(getString(R.string.ok_got_it_with_comma));
                            }
                        } else if (b() <= 1) {
                            TextView textView6 = this.f54440c;
                            if (textView6 != null) {
                                textView6.setText(getString(R.string.mt_add_another_bank_account));
                            }
                        } else {
                            TextView textView7 = this.f54440c;
                            if (textView7 != null) {
                                textView7.setText(getString(R.string.use_another_account));
                            }
                        }
                    }
                } else if (str.equals("SCHEDULED_DOWN_TIME") && (textView = this.f54440c) != null) {
                    textView.setText(getString(R.string.ok_got_it_with_comma));
                }
                TextView textView8 = this.f54440c;
                if (textView8 != null) {
                    textView8.setVisibility(0);
                }
            }
        }
        return inflate;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        r4 = r4.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x000e
            int r0 = r4.getId()
            int r1 = net.one97.paytm.moneytransfer.R.id.cross_iv
            if (r0 != r1) goto L_0x000e
            r3.c()
            return
        L_0x000e:
            if (r4 == 0) goto L_0x0090
            int r4 = r4.getId()
            int r0 = net.one97.paytm.moneytransfer.R.id.linearLayout2
            if (r4 != r0) goto L_0x0090
            android.widget.TextView r4 = r3.f54440c
            r0 = 0
            if (r4 == 0) goto L_0x0028
            java.lang.CharSequence r4 = r4.getText()
            if (r4 == 0) goto L_0x0028
            java.lang.String r4 = r4.toString()
            goto L_0x0029
        L_0x0028:
            r4 = r0
        L_0x0029:
            r1 = 1
            if (r4 == 0) goto L_0x003b
            int r2 = net.one97.paytm.moneytransfer.R.string.ok_got_it_with_comma
            java.lang.String r2 = r3.getString(r2)
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r2, (boolean) r1)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            goto L_0x003c
        L_0x003b:
            r4 = r0
        L_0x003c:
            if (r4 != 0) goto L_0x0041
            kotlin.g.b.k.a()
        L_0x0041:
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x008d
            boolean r4 = r3.a()
            if (r4 == 0) goto L_0x008d
            int r4 = r3.b()
            if (r4 > r1) goto L_0x008d
            androidx.fragment.app.Fragment r4 = r3.getParentFragment()
            boolean r4 = r4 instanceof net.one97.paytm.moneytransfer.view.fragments.n
            if (r4 == 0) goto L_0x0071
            androidx.fragment.app.Fragment r4 = r3.getParentFragment()
            if (r4 == 0) goto L_0x0069
            net.one97.paytm.moneytransfer.view.fragments.n r4 = (net.one97.paytm.moneytransfer.view.fragments.n) r4
            if (r4 == 0) goto L_0x0089
            r4.f()
            goto L_0x0089
        L_0x0069:
            kotlin.u r4 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.moneytransfer.view.fragments.MoneyTransferPaymentFragment"
            r4.<init>(r0)
            throw r4
        L_0x0071:
            androidx.fragment.app.Fragment r4 = r3.getParentFragment()
            boolean r4 = r4 instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b
            if (r4 == 0) goto L_0x0089
            androidx.fragment.app.Fragment r4 = r3.getParentFragment()
            boolean r1 = r4 instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b
            if (r1 != 0) goto L_0x0082
            r4 = r0
        L_0x0082:
            net.one97.paytm.moneytransferv4.home.presentation.a.b r4 = (net.one97.paytm.moneytransferv4.home.presentation.a.b) r4
            if (r4 == 0) goto L_0x0089
            r4.e()
        L_0x0089:
            r3.c()
            return
        L_0x008d:
            r3.c()
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.c.onClick(android.view.View):void");
    }

    private final boolean a() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("payer_or_payee") : null;
        if (!TextUtils.isEmpty(string)) {
            return p.a(string, "PAYER", true);
        }
        return false;
    }

    private final int b() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt("bank_count", 0);
        }
        return 0;
    }

    private final void c() {
        if (d()) {
            dismissAllowingStateLoss();
        }
    }

    private final boolean d() {
        return getActivity() != null && isAdded() && isResumed();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f54442e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

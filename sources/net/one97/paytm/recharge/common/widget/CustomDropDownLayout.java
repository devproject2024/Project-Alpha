package net.one97.paytm.recharge.common.widget;

import android.view.View;
import android.widget.LinearLayout;
import java.util.HashMap;

public final class CustomDropDownLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f61985a;

    private View a(int i2) {
        if (this.f61985a == null) {
            this.f61985a = new HashMap();
        }
        View view = (View) this.f61985a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f61985a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002e, code lost:
        r6 = r6.getLabel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CustomDropDownLayout(android.content.Context r4, net.one97.paytm.recharge.model.v4.GroupAttributesItem r5, net.one97.paytm.recharge.model.v4.CJRAggsItem r6, java.lang.String r7, int r8, final android.view.View.OnClickListener r9) {
        /*
            r3 = this;
            java.lang.String r0 = "groupAttributesItem"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r0 = "groupName"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r0 = "dropdownClickListener"
            kotlin.g.b.k.c(r9, r0)
            r3.<init>(r4)
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            int r0 = net.one97.paytm.recharge.R.layout.recharge_utility_group_filed_drop_down_digital_catalog
            r1 = r3
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r2 = 1
            r4.inflate(r0, r1, r2)
            int r4 = net.one97.paytm.recharge.R.id.text_input_layout_utility
            android.view.View r4 = r3.a(r4)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            java.lang.String r0 = "text_input_layout_utility"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            if (r6 == 0) goto L_0x0037
            java.lang.String r6 = r6.getLabel()
            if (r6 == 0) goto L_0x0037
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            goto L_0x003e
        L_0x0037:
            java.lang.String r5 = r5.getDisplayName()
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
        L_0x003e:
            r4.setHint(r6)
            int r4 = net.one97.paytm.recharge.R.id.group_field_textview
            android.view.View r4 = r3.a(r4)
            android.widget.EditText r4 = (android.widget.EditText) r4
            net.one97.paytm.recharge.common.widget.CustomDropDownLayout$1 r5 = new net.one97.paytm.recharge.common.widget.CustomDropDownLayout$1
            r5.<init>(r9)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r4.setOnClickListener(r5)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            r4.add(r5, r6)
            r4.add(r2, r7)
            int r5 = net.one97.paytm.recharge.R.id.group_field_textview
            android.view.View r5 = r3.a(r5)
            android.widget.EditText r5 = (android.widget.EditText) r5
            java.lang.String r6 = "group_field_textview"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r5.setTag(r4)
            r3.setTag(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomDropDownLayout.<init>(android.content.Context, net.one97.paytm.recharge.model.v4.GroupAttributesItem, net.one97.paytm.recharge.model.v4.CJRAggsItem, java.lang.String, int, android.view.View$OnClickListener):void");
    }
}

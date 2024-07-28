package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import org.npci.upi.security.pinactivitycomponent.widget.FormItemPager;
import org.npci.upi.security.pinactivitycomponent.widget.FormItemView;
import org.npci.upi.security.pinactivitycomponent.widget.a;
import org.npci.upi.security.pinactivitycomponent.widget.m;

public class ao extends ae implements m {
    private static final String s = ae.class.getSimpleName();
    LinearLayout q;
    LinearLayout r;
    private int t = 0;
    private Timer u = null;
    private Boolean v = null;
    private HashMap w = new HashMap();
    private boolean x = false;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: org.npci.upi.security.pinactivitycomponent.widget.FormItemPager} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: org.npci.upi.security.pinactivitycomponent.widget.FormItemView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: org.npci.upi.security.pinactivitycomponent.widget.FormItemPager} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: org.npci.upi.security.pinactivitycomponent.widget.FormItemPager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.view.View r15) {
        /*
            r14 = this;
            java.lang.String r0 = "dLength"
            java.lang.String r1 = "MPIN"
            int r2 = org.npci.upi.security.pinactivitycomponent.R.id.main_inner_layout
            android.view.View r15 = r15.findViewById(r2)
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            org.json.JSONArray r2 = r14.f72924c
            if (r2 == 0) goto L_0x011d
            r2 = 0
        L_0x0011:
            org.json.JSONArray r3 = r14.f72924c
            int r3 = r3.length()
            if (r2 >= r3) goto L_0x011d
            org.json.JSONArray r3 = r14.f72924c     // Catch:{ Exception -> 0x0119 }
            org.json.JSONObject r3 = r3.getJSONObject(r2)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r4 = "subtype"
            java.lang.String r4 = r3.getString(r4)     // Catch:{ Exception -> 0x0119 }
            int r5 = r3.optInt(r0)     // Catch:{ Exception -> 0x0119 }
            if (r5 != 0) goto L_0x002d
            r5 = 6
            goto L_0x0031
        L_0x002d:
            int r5 = r3.optInt(r0)     // Catch:{ Exception -> 0x0119 }
        L_0x0031:
            boolean r6 = r4.equals(r1)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r7 = "TOTP"
            java.lang.String r8 = "HOTP"
            java.lang.String r9 = "EMAIL"
            java.lang.String r10 = "SMS"
            java.lang.String r11 = "OTP"
            java.lang.String r12 = "ATMPIN"
            java.lang.String r13 = "NMPIN"
            if (r6 != 0) goto L_0x006f
            boolean r6 = r4.equals(r13)     // Catch:{ Exception -> 0x0119 }
            if (r6 != 0) goto L_0x006f
            boolean r6 = r12.equals(r4)     // Catch:{ Exception -> 0x0119 }
            if (r6 != 0) goto L_0x006f
            boolean r6 = r11.equals(r4)     // Catch:{ Exception -> 0x0119 }
            if (r6 != 0) goto L_0x006f
            boolean r6 = r10.equals(r4)     // Catch:{ Exception -> 0x0119 }
            if (r6 != 0) goto L_0x006f
            boolean r6 = r9.equals(r4)     // Catch:{ Exception -> 0x0119 }
            if (r6 != 0) goto L_0x006f
            boolean r6 = r8.equals(r4)     // Catch:{ Exception -> 0x0119 }
            if (r6 != 0) goto L_0x006f
            boolean r6 = r7.equals(r4)     // Catch:{ Exception -> 0x0119 }
            if (r6 == 0) goto L_0x0119
        L_0x006f:
            boolean r6 = r4.equals(r13)     // Catch:{ Exception -> 0x0119 }
            if (r6 != 0) goto L_0x00e8
            boolean r6 = r4.equals(r1)     // Catch:{ Exception -> 0x0119 }
            if (r6 == 0) goto L_0x0082
            boolean r6 = r14.e()     // Catch:{ Exception -> 0x0119 }
            if (r6 == 0) goto L_0x0082
            goto L_0x00e8
        L_0x0082:
            java.lang.String r6 = ""
            boolean r13 = r4.equals(r1)     // Catch:{ Exception -> 0x0119 }
            if (r13 == 0) goto L_0x0091
            int r4 = org.npci.upi.security.pinactivitycomponent.R.string.npci_mpin_title     // Catch:{ Exception -> 0x0119 }
        L_0x008c:
            java.lang.String r6 = r14.getString(r4)     // Catch:{ Exception -> 0x0119 }
            goto L_0x00d8
        L_0x0091:
            boolean r11 = r11.equals(r4)     // Catch:{ Exception -> 0x0119 }
            if (r11 != 0) goto L_0x00b9
            boolean r10 = r10.equals(r4)     // Catch:{ Exception -> 0x0119 }
            if (r10 != 0) goto L_0x00b9
            boolean r9 = r9.equals(r4)     // Catch:{ Exception -> 0x0119 }
            if (r9 != 0) goto L_0x00b9
            boolean r8 = r8.equals(r4)     // Catch:{ Exception -> 0x0119 }
            if (r8 != 0) goto L_0x00b9
            boolean r7 = r7.equals(r4)     // Catch:{ Exception -> 0x0119 }
            if (r7 == 0) goto L_0x00b0
            goto L_0x00b9
        L_0x00b0:
            boolean r4 = r12.equals(r4)     // Catch:{ Exception -> 0x0119 }
            if (r4 == 0) goto L_0x00d8
            int r4 = org.npci.upi.security.pinactivitycomponent.R.string.npci_atm_title     // Catch:{ Exception -> 0x0119 }
            goto L_0x008c
        L_0x00b9:
            int r4 = org.npci.upi.security.pinactivitycomponent.R.string.npci_otp_title     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = r14.getString(r4)     // Catch:{ Exception -> 0x0119 }
            r14.f72928g = r2     // Catch:{ Exception -> 0x0119 }
            androidx.fragment.app.FragmentActivity r4 = r14.getActivity()     // Catch:{ Exception -> 0x0119 }
            boolean r4 = r4 instanceof org.npci.upi.security.pinactivitycomponent.GetCredential     // Catch:{ Exception -> 0x0119 }
            if (r4 == 0) goto L_0x00d8
            androidx.fragment.app.FragmentActivity r4 = r14.getActivity()     // Catch:{ Exception -> 0x0119 }
            org.npci.upi.security.pinactivitycomponent.GetCredential r4 = (org.npci.upi.security.pinactivitycomponent.GetCredential) r4     // Catch:{ Exception -> 0x0119 }
            boolean r4 = r4.checkSMSReadPermission()     // Catch:{ Exception -> 0x0119 }
            if (r4 == 0) goto L_0x00d8
            r14.b((int) r5)     // Catch:{ Exception -> 0x0119 }
        L_0x00d8:
            org.npci.upi.security.pinactivitycomponent.widget.FormItemView r4 = r14.a(r6, r2, r5)     // Catch:{ Exception -> 0x0119 }
            r4.setFormDataTag(r3)     // Catch:{ Exception -> 0x0119 }
            java.util.ArrayList r3 = r14.f72927f     // Catch:{ Exception -> 0x0119 }
        L_0x00e1:
            r3.add(r4)     // Catch:{ Exception -> 0x0119 }
            r15.addView(r4)     // Catch:{ Exception -> 0x0119 }
            goto L_0x0119
        L_0x00e8:
            int r4 = org.npci.upi.security.pinactivitycomponent.R.string.npci_set_mpin_title     // Catch:{ Exception -> 0x0119 }
            java.lang.String r4 = r14.getString(r4)     // Catch:{ Exception -> 0x0119 }
            org.npci.upi.security.pinactivitycomponent.widget.FormItemView r4 = r14.a(r4, r2, r5)     // Catch:{ Exception -> 0x0119 }
            int r6 = org.npci.upi.security.pinactivitycomponent.R.string.npci_confirm_mpin_title     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = r14.getString(r6)     // Catch:{ Exception -> 0x0119 }
            org.npci.upi.security.pinactivitycomponent.widget.FormItemView r5 = r14.a(r6, r2, r5)     // Catch:{ Exception -> 0x0119 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0119 }
            r6.<init>()     // Catch:{ Exception -> 0x0119 }
            r6.add(r4)     // Catch:{ Exception -> 0x0119 }
            r6.add(r5)     // Catch:{ Exception -> 0x0119 }
            org.npci.upi.security.pinactivitycomponent.widget.FormItemPager r4 = new org.npci.upi.security.pinactivitycomponent.widget.FormItemPager     // Catch:{ Exception -> 0x0119 }
            androidx.fragment.app.FragmentActivity r5 = r14.getActivity()     // Catch:{ Exception -> 0x0119 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0119 }
            r4.a((java.util.ArrayList) r6, (org.npci.upi.security.pinactivitycomponent.widget.m) r14)     // Catch:{ Exception -> 0x0119 }
            r4.setFormDataTag(r3)     // Catch:{ Exception -> 0x0119 }
            java.util.ArrayList r3 = r14.f72927f     // Catch:{ Exception -> 0x0119 }
            goto L_0x00e1
        L_0x0119:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x011d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.npci.upi.security.pinactivitycomponent.ao.a(android.view.View):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r0 = (org.npci.upi.security.pinactivitycomponent.widget.FormItemView) r7.f72927f.get(r7.f72928g);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r7 = this;
            int r0 = r7.f72928g
            r1 = -1
            if (r0 == r1) goto L_0x0035
            java.util.ArrayList r0 = r7.f72927f
            int r1 = r7.f72928g
            java.lang.Object r0 = r0.get(r1)
            boolean r0 = r0 instanceof org.npci.upi.security.pinactivitycomponent.widget.FormItemView
            if (r0 == 0) goto L_0x0035
            java.util.ArrayList r0 = r7.f72927f
            int r1 = r7.f72928g
            java.lang.Object r0 = r0.get(r1)
            org.npci.upi.security.pinactivitycomponent.widget.FormItemView r0 = (org.npci.upi.security.pinactivitycomponent.widget.FormItemView) r0
            java.lang.String r1 = r0.getInputValue()
            if (r1 == 0) goto L_0x002b
            int r1 = r1.length()
            int r2 = r0.getInputLength()
            if (r1 == r2) goto L_0x0035
        L_0x002b:
            int r1 = org.npci.upi.security.pinactivitycomponent.R.string.invalid_otp
            java.lang.String r1 = r7.getString(r1)
            r7.b(r0, r1)
            return
        L_0x0035:
            r0 = 0
            r1 = 0
        L_0x0037:
            java.util.ArrayList r2 = r7.f72927f
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x006c
            java.util.ArrayList r2 = r7.f72927f
            java.lang.Object r2 = r2.get(r1)
            boolean r2 = r2 instanceof org.npci.upi.security.pinactivitycomponent.widget.FormItemView
            if (r2 == 0) goto L_0x0069
            java.util.ArrayList r2 = r7.f72927f
            java.lang.Object r2 = r2.get(r1)
            org.npci.upi.security.pinactivitycomponent.widget.FormItemView r2 = (org.npci.upi.security.pinactivitycomponent.widget.FormItemView) r2
            java.lang.String r3 = r2.getInputValue()
            int r3 = r3.length()
            int r4 = r2.getInputLength()
            if (r3 == r4) goto L_0x0069
            int r0 = org.npci.upi.security.pinactivitycomponent.R.string.componentMessage
            java.lang.String r0 = r7.getString(r0)
            r7.b(r2, r0)
            return
        L_0x0069:
            int r1 = r1 + 1
            goto L_0x0037
        L_0x006c:
            boolean r1 = r7.x
            if (r1 != 0) goto L_0x010b
            r1 = 1
            r7.x = r1
        L_0x0073:
            java.util.ArrayList r2 = r7.f72927f
            int r2 = r2.size()
            if (r0 >= r2) goto L_0x00e1
            java.util.ArrayList r2 = r7.f72927f     // Catch:{ Exception -> 0x00d8 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ Exception -> 0x00d8 }
            org.npci.upi.security.pinactivitycomponent.widget.a r2 = (org.npci.upi.security.pinactivitycomponent.widget.a) r2     // Catch:{ Exception -> 0x00d8 }
            java.lang.Object r2 = r2.getFormDataTag()     // Catch:{ Exception -> 0x00d8 }
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r3 = "type"
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r4 = "subtype"
            java.lang.String r2 = r2.getString(r4)     // Catch:{ Exception -> 0x00d8 }
            org.json.JSONObject r4 = r7.f72923b     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r5 = "credential"
            java.util.ArrayList r6 = r7.f72927f     // Catch:{ Exception -> 0x00d8 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ Exception -> 0x00d8 }
            org.npci.upi.security.pinactivitycomponent.widget.a r6 = (org.npci.upi.security.pinactivitycomponent.widget.a) r6     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r6 = r6.getInputValue()     // Catch:{ Exception -> 0x00d8 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x00d8 }
            android.content.Context r4 = r7.p     // Catch:{ Exception -> 0x00d8 }
            org.npci.upi.security.pinactivitycomponent.GetCredential r4 = (org.npci.upi.security.pinactivitycomponent.GetCredential) r4     // Catch:{ Exception -> 0x00d8 }
            org.npci.upi.security.pinactivitycomponent.c r4 = r4.getCLContext()     // Catch:{ Exception -> 0x00d8 }
            org.npci.upi.security.pinactivitycomponent.aq r4 = r4.a()     // Catch:{ Exception -> 0x00d8 }
            org.json.JSONObject r5 = r7.f72923b     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r4 = r4.a((org.json.JSONObject) r5)     // Catch:{ Exception -> 0x00d8 }
            android.content.Context r5 = r7.p     // Catch:{ Exception -> 0x00d8 }
            org.npci.upi.security.pinactivitycomponent.GetCredential r5 = (org.npci.upi.security.pinactivitycomponent.GetCredential) r5     // Catch:{ Exception -> 0x00d8 }
            org.npci.upi.security.pinactivitycomponent.c r5 = r5.getCLContext()     // Catch:{ Exception -> 0x00d8 }
            org.npci.upi.security.pinactivitycomponent.j r5 = r5.b()     // Catch:{ Exception -> 0x00d8 }
            org.json.JSONObject r6 = r7.f72923b     // Catch:{ Exception -> 0x00d8 }
            in.org.npci.commonlibrary.Message r3 = r5.a(r4, r3, r2, r6)     // Catch:{ Exception -> 0x00d8 }
            if (r3 == 0) goto L_0x00de
            java.util.HashMap r4 = r7.w     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r3 = org.npci.upi.security.pinactivitycomponent.w.a(r3)     // Catch:{ Exception -> 0x00d8 }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x00d8 }
            goto L_0x00de
        L_0x00d8:
            r2 = move-exception
            java.lang.String r3 = s
            org.npci.upi.security.pinactivitycomponent.ad.a((java.lang.String) r3, (java.lang.Exception) r2)
        L_0x00de:
            int r0 = r0 + 1
            goto L_0x0073
        L_0x00e1:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.util.HashMap r2 = r7.w
            java.lang.String r3 = "credBlocks"
            r0.putSerializable(r3, r2)
            android.content.Context r2 = r7.p
            org.npci.upi.security.pinactivitycomponent.GetCredential r2 = (org.npci.upi.security.pinactivitycomponent.GetCredential) r2
            org.npci.upi.security.pinactivitycomponent.c r2 = r2.getCLContext()
            android.os.ResultReceiver r2 = r2.d()
            r2.send(r1, r0)
            android.content.Context r0 = r7.p
            org.npci.upi.security.pinactivitycomponent.GetCredential r0 = (org.npci.upi.security.pinactivitycomponent.GetCredential) r0
            org.npci.upi.security.pinactivitycomponent.c r0 = r0.getCLContext()
            android.app.Activity r0 = r0.c()
            r0.finish()
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.npci.upi.security.pinactivitycomponent.ao.d():void");
    }

    private boolean e() {
        Boolean bool;
        Boolean bool2 = this.v;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        if (this.f72924c != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f72924c.length(); i2++) {
                try {
                    String string = this.f72924c.getJSONObject(i2).getString(CLConstants.FIELD_SUBTYPE);
                    if (string != null) {
                        arrayList.add(string);
                    }
                } catch (Exception e2) {
                    ad.a(s, e2);
                }
            }
            if (arrayList.contains("OTP") || arrayList.contains("SMS") || arrayList.contains("EMAIL") || arrayList.contains(CLConstants.CREDTYPE_HOTP) || (arrayList.contains(CLConstants.CREDTYPE_TOTP) && arrayList.contains("MPIN"))) {
                bool = Boolean.TRUE;
                this.v = bool;
                return this.v.booleanValue();
            }
        }
        bool = Boolean.FALSE;
        this.v = bool;
        return this.v.booleanValue();
    }

    private void f() {
        if (this.f72928g != -1 && (this.f72927f.get(this.f72928g) instanceof FormItemView)) {
            FormItemView formItemView = (FormItemView) this.f72927f.get(this.f72928g);
            a(formItemView);
            formItemView.setNonMaskedField();
        }
        int size = this.f72927f.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 != this.f72928g) {
                a aVar = (a) this.f72927f.get(i2);
                Drawable a2 = b.a((Context) getActivity(), R.drawable.ic_visibility_on);
                Drawable a3 = b.a((Context) getActivity(), R.drawable.ic_visibility_off);
                String string = getString(R.string.action_hide);
                String string2 = getString(R.string.action_show);
                aVar.a(string2, a2, new ap(this, aVar, string, string2, a3, a2), 0, true, true);
            }
        }
    }

    public void a() {
        if (this.t >= this.f72927f.size() - 1) {
            d();
        } else if (((a) this.f72927f.get(this.t + 1)).a()) {
            this.t++;
            if (this.t >= this.f72927f.size() - 1) {
                d();
            }
        }
    }

    public void a(int i2) {
        if (!(this.f72927f.get(i2) instanceof FormItemPager)) {
            this.t = i2;
        }
    }

    public void a(int i2, String str) {
        if (this.f72928g != -1 && this.f72928g == i2 && (this.f72927f.get(this.f72928g) instanceof FormItemView)) {
            a(this.u);
            ((FormItemView) this.f72927f.get(this.f72928g)).a(false);
            ((FormItemView) this.f72927f.get(this.f72928g)).a("", (View.OnClickListener) null, false, false);
            ((FormItemView) this.f72927f.get(this.f72928g)).a(b.a((Context) getActivity(), R.drawable.ic_tick_ok), true);
        }
    }

    public void a(View view, String str) {
        b(view, str);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_pin, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.r = (LinearLayout) view.findViewById(R.id.main_inner_layout);
        this.q = (LinearLayout) view.findViewById(R.id.main_layout);
        b();
        a(view);
        f();
    }
}

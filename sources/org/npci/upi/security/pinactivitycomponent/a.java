package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;
import androidx.core.content.b;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.widget.FormItemPager;
import org.npci.upi.security.pinactivitycomponent.widget.FormItemView;
import org.npci.upi.security.pinactivitycomponent.widget.m;

public class a extends ae implements m {
    private static final String q = a.class.getSimpleName();
    private HashMap r = new HashMap();
    private int s = 0;
    private boolean t = false;
    private ViewSwitcher u = null;

    private void a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.switcherLayout1);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.switcherLayout2);
        this.u = (ViewSwitcher) view.findViewById(R.id.view_switcher);
        if (this.f72924c != null) {
            for (int i2 = 0; i2 < this.f72924c.length(); i2++) {
                try {
                    JSONObject jSONObject = this.f72924c.getJSONObject(i2);
                    String string = jSONObject.getString(CLConstants.FIELD_SUBTYPE);
                    int optInt = jSONObject.optInt(CLConstants.FIELD_DLENGTH) == 0 ? 6 : jSONObject.optInt(CLConstants.FIELD_DLENGTH);
                    if (string.equals("MPIN")) {
                        FormItemView a2 = a(getString(R.string.npci_set_mpin_title), i2, optInt);
                        FormItemView a3 = a(getString(R.string.npci_confirm_mpin_title), i2, optInt);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(a2);
                        arrayList.add(a3);
                        FormItemPager formItemPager = new FormItemPager(getActivity());
                        formItemPager.a(arrayList, (m) this);
                        formItemPager.setFormDataTag(jSONObject);
                        this.f72927f.add(formItemPager);
                        linearLayout2.addView(formItemPager);
                    } else {
                        String str = "";
                        if (string.equals("ATMPIN")) {
                            str = getString(R.string.npci_atm_title);
                        } else if ("OTP".equals(string) || "SMS".equals(string) || "EMAIL".equals(string) || CLConstants.CREDTYPE_HOTP.equals(string) || CLConstants.CREDTYPE_TOTP.equals(string)) {
                            str = getString(R.string.npci_otp_title);
                            this.f72928g = i2;
                            if ((getActivity() instanceof GetCredential) && ((GetCredential) getActivity()).checkSMSReadPermission()) {
                                b(optInt);
                            }
                        }
                        FormItemView a4 = a(str, i2, optInt);
                        a4.setFormDataTag(jSONObject);
                        this.f72927f.add(a4);
                        linearLayout.addView(a4);
                    }
                } catch (Exception unused) {
                }
            }
        }
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
            boolean r1 = r7.t
            if (r1 != 0) goto L_0x010b
            r1 = 1
            r7.t = r1
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
            java.util.HashMap r4 = r7.r     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r3 = org.npci.upi.security.pinactivitycomponent.w.a(r3)     // Catch:{ Exception -> 0x00d8 }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x00d8 }
            goto L_0x00de
        L_0x00d8:
            r2 = move-exception
            java.lang.String r3 = q
            org.npci.upi.security.pinactivitycomponent.ad.a((java.lang.String) r3, (java.lang.Exception) r2)
        L_0x00de:
            int r0 = r0 + 1
            goto L_0x0073
        L_0x00e1:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.util.HashMap r2 = r7.r
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
        throw new UnsupportedOperationException("Method not decompiled: org.npci.upi.security.pinactivitycomponent.a.d():void");
    }

    private void e() {
        if (this.f72928g != -1 && (this.f72927f.get(this.f72928g) instanceof FormItemView)) {
            FormItemView formItemView = (FormItemView) this.f72927f.get(this.f72928g);
            a(formItemView);
            formItemView.setNonMaskedField();
        }
        int size = this.f72927f.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 != this.f72928g) {
                org.npci.upi.security.pinactivitycomponent.widget.a aVar = (org.npci.upi.security.pinactivitycomponent.widget.a) this.f72927f.get(i2);
                Drawable a2 = b.a((Context) getActivity(), R.drawable.ic_visibility_on);
                Drawable a3 = b.a((Context) getActivity(), R.drawable.ic_visibility_off);
                String string = getString(R.string.action_hide);
                String string2 = getString(R.string.action_show);
                aVar.a(string2, a2, new b(this, aVar, string, string2, a3, a2), 0, true, true);
            }
        }
    }

    public void a() {
        int i2 = this.s;
        if (i2 == 0) {
            ((org.npci.upi.security.pinactivitycomponent.widget.a) this.f72927f.get(this.s + 1)).a();
            this.s++;
            return;
        }
        if (i2 == 1) {
            if (((FormItemView) this.f72927f.get(0)).getInputLength() != ((org.npci.upi.security.pinactivitycomponent.widget.a) this.f72927f.get(0)).getInputValue().length()) {
                b((View) this.f72927f.get(0), getString(R.string.npci_otp_title));
                return;
            } else if (((FormItemView) this.f72927f.get(1)).getInputLength() != ((org.npci.upi.security.pinactivitycomponent.widget.a) this.f72927f.get(1)).getInputValue().length()) {
                b((View) this.f72927f.get(1), getString(R.string.npci_atm_title));
                return;
            } else {
                ViewSwitcher viewSwitcher = this.u;
                if (viewSwitcher != null) {
                    viewSwitcher.showNext();
                    this.s = 2;
                    return;
                }
            }
        }
        if (this.s != 2) {
            d();
        } else if (((org.npci.upi.security.pinactivitycomponent.widget.a) this.f72927f.get(this.s)).a()) {
            d();
        }
    }

    public void a(int i2) {
        if (!(this.f72927f.get(i2) instanceof FormItemPager)) {
            this.s = i2;
        }
    }

    public void a(int i2, String str) {
        if (this.f72928g != -1 && this.f72928g == i2 && (this.f72927f.get(this.f72928g) instanceof FormItemView)) {
            a(this.f72930i);
            ((FormItemView) this.f72927f.get(this.f72928g)).a(false);
            ((FormItemView) this.f72927f.get(this.f72928g)).a("", (View.OnClickListener) null, false, false);
            ((FormItemView) this.f72927f.get(this.f72928g)).a(b.a((Context) getActivity(), R.drawable.ic_tick_ok), true);
        }
    }

    public void a(View view, String str) {
        b(view, str);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_atmpin, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        b();
        a(view);
        e();
    }
}

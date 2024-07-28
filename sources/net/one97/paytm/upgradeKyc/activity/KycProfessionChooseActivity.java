package net.one97.paytm.upgradeKyc.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.a.b;
import net.one97.paytm.upgradeKyc.activity.b;

public final class KycProfessionChooseActivity extends UpgradeKycBaseActivity implements View.OnClickListener, b.a {

    /* renamed from: a  reason: collision with root package name */
    private String f65339a = "";

    /* renamed from: b  reason: collision with root package name */
    private b f65340b;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<String> f65341d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private String f65342e = "";

    /* renamed from: f  reason: collision with root package name */
    private String[] f65343f = {"professional", "government job", "private sector job", "public sector job", "business", "student", "house wife", "retired", "self employed", "others"};

    /* renamed from: g  reason: collision with root package name */
    private HashMap f65344g;

    public final View a(int i2) {
        if (this.f65344g == null) {
            this.f65344g = new HashMap();
        }
        View view = (View) this.f65344g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65344g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return -1;
    }

    public final void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            ImageView imageView = (ImageView) a(R.id.profession_iv_back_button);
            k.a((Object) imageView, "profession_iv_back_button");
            if (id == imageView.getId()) {
                onBackPressed();
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ca, code lost:
        if (r1.equals("aadhaar_profession") != false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d3, code lost:
        if (r1.equals("profession") != false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d5, code lost:
        r0 = getString(net.one97.paytm.upgradeKyc.R.string.kyc_select_title_prof) + " " + getString(net.one97.paytm.upgradeKyc.R.string.kyc_profession);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0140, code lost:
        r0 = getString(net.one97.paytm.upgradeKyc.R.string.kyc_select_title_prof);
        kotlin.g.b.k.a((java.lang.Object) r0, "getString(R.string.kyc_select_title_prof)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x014b, code lost:
        r6.setText(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            android.content.Intent r6 = r5.getIntent()
            if (r6 == 0) goto L_0x015f
            android.content.Intent r6 = r5.getIntent()
            java.lang.String r0 = "option"
            boolean r6 = r6.hasExtra(r0)
            if (r6 == 0) goto L_0x015f
            android.content.Intent r6 = r5.getIntent()
            java.lang.String r6 = r6.getStringExtra(r0)
            if (r6 != 0) goto L_0x0022
            kotlin.g.b.k.a()
        L_0x0022:
            r5.f65342e = r6
            java.lang.String r6 = r5.f65342e
            java.lang.String r0 = "Sub-Profession"
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r0)
            if (r6 == 0) goto L_0x003f
            android.content.Intent r6 = r5.getIntent()
            java.lang.String r1 = "main_profession"
            java.lang.String r6 = r6.getStringExtra(r1)
            if (r6 != 0) goto L_0x003d
            kotlin.g.b.k.a()
        L_0x003d:
            r5.f65339a = r6
        L_0x003f:
            java.lang.String r6 = r5.f65342e
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r0)
            if (r2 == 0) goto L_0x005b
            android.content.res.Resources r6 = r5.getResources()
            java.lang.String r2 = r5.f65339a
            int r2 = a((java.lang.String) r2)
            java.lang.String[] r6 = r6.getStringArray(r2)
            goto L_0x0067
        L_0x005b:
            android.content.res.Resources r2 = r5.getResources()
            int r6 = a((java.lang.String) r6)
            java.lang.String[] r6 = r2.getStringArray(r6)
        L_0x0067:
            int r2 = r6.length
            r3 = 0
        L_0x0069:
            if (r3 >= r2) goto L_0x0073
            r4 = r6[r3]
            r1.add(r4)
            int r3 = r3 + 1
            goto L_0x0069
        L_0x0073:
            r5.f65341d = r1
            net.one97.paytm.upgradeKyc.a.b r6 = new net.one97.paytm.upgradeKyc.a.b
            r1 = r5
            android.content.Context r1 = (android.content.Context) r1
            java.util.ArrayList<java.lang.String> r2 = r5.f65341d
            r6.<init>(r1, r2)
            r5.f65340b = r6
            net.one97.paytm.upgradeKyc.a.b r6 = r5.f65340b
            java.lang.String r1 = "radioButtonListAdapter"
            if (r6 != 0) goto L_0x008a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x008a:
            r2 = r5
            net.one97.paytm.upgradeKyc.a.b$a r2 = (net.one97.paytm.upgradeKyc.a.b.a) r2
            java.lang.String r3 = "listner"
            kotlin.g.b.k.c(r2, r3)
            r6.f65199b = r2
            int r6 = net.one97.paytm.upgradeKyc.R.id.optionListView
            android.view.View r6 = r5.a((int) r6)
            android.widget.ListView r6 = (android.widget.ListView) r6
            java.lang.String r2 = "optionListView"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
            net.one97.paytm.upgradeKyc.a.b r2 = r5.f65340b
            if (r2 != 0) goto L_0x00a8
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00a8:
            android.widget.ListAdapter r2 = (android.widget.ListAdapter) r2
            r6.setAdapter(r2)
            int r6 = net.one97.paytm.upgradeKyc.R.id.heading_tv
            android.view.View r6 = r5.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0150
            java.lang.String r1 = r5.f65342e
            int r2 = r1.hashCode()
            java.lang.String r3 = " "
            switch(r2) {
                case -1985098007: goto L_0x011b;
                case -1645073654: goto L_0x00f4;
                case -1210261252: goto L_0x00cd;
                case 71784621: goto L_0x00c4;
                default: goto L_0x00c2;
            }
        L_0x00c2:
            goto L_0x0140
        L_0x00c4:
            java.lang.String r0 = "aadhaar_profession"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0140
            goto L_0x00d5
        L_0x00cd:
            java.lang.String r0 = "profession"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0140
        L_0x00d5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = net.one97.paytm.upgradeKyc.R.string.kyc_select_title_prof
            java.lang.String r1 = r5.getString(r1)
            r0.append(r1)
            r0.append(r3)
            int r1 = net.one97.paytm.upgradeKyc.R.string.kyc_profession
            java.lang.String r1 = r5.getString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x014b
        L_0x00f4:
            java.lang.String r0 = "Annual Income"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0140
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = net.one97.paytm.upgradeKyc.R.string.kyc_select_title_prof
            java.lang.String r1 = r5.getString(r1)
            r0.append(r1)
            r0.append(r3)
            int r1 = net.one97.paytm.upgradeKyc.R.string.kyc_annual_income
            java.lang.String r1 = r5.getString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x014b
        L_0x011b:
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0140
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = net.one97.paytm.upgradeKyc.R.string.kyc_select_title_prof
            java.lang.String r1 = r5.getString(r1)
            r0.append(r1)
            r0.append(r3)
            int r1 = net.one97.paytm.upgradeKyc.R.string.kyc_sub_profession
            java.lang.String r1 = r5.getString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x014b
        L_0x0140:
            int r0 = net.one97.paytm.upgradeKyc.R.string.kyc_select_title_prof
            java.lang.String r0 = r5.getString(r0)
            java.lang.String r1 = "getString(R.string.kyc_select_title_prof)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
        L_0x014b:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
        L_0x0150:
            int r6 = net.one97.paytm.upgradeKyc.R.id.profession_iv_back_button
            android.view.View r6 = r5.a((int) r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r0 = r5
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r6.setOnClickListener(r0)
            return
        L_0x015f:
            r6 = r5
            android.content.Context r6 = (android.content.Context) r6
            int r0 = net.one97.paytm.upgradeKyc.R.string.some_went_wrong
            java.lang.String r0 = r5.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 1
            android.widget.Toast r6 = android.widget.Toast.makeText(r6, r0, r1)
            r6.show()
            r5.onBackPressed()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.KycProfessionChooseActivity.onCreate(android.os.Bundle):void");
    }

    public final int a() {
        return R.layout.fragment_profession_selector_view;
    }

    private static int a(String str) {
        switch (str.hashCode()) {
            case -1789857552:
                if (str.equals("HOUSE_WIFE")) {
                    return R.array.kyc_profession_housewife_array;
                }
                break;
            case -1645073654:
                if (str.equals("Annual Income")) {
                    return R.array.kyc_annual_income_array;
                }
                break;
            case -1579073575:
                if (str.equals("SALARIED")) {
                    return R.array.kyc_profession_salaried_array;
                }
                break;
            case -1210261252:
                if (str.equals("profession")) {
                    return R.array.kyc_profession_category_array;
                }
                break;
            case -1161163237:
                if (str.equals("STUDENT")) {
                    return R.array.kyc_profession_student_array;
                }
                break;
            case -1090176954:
                if (str.equals("UNEMPLOYED")) {
                    return R.array.kyc_profession_unemployed_array;
                }
                break;
            case -203112920:
                if (str.equals("PROFESSIONAL_SELF_EMPLOYED")) {
                    return R.array.kyc_profession_self_array;
                }
                break;
            case 71784621:
                if (str.equals("aadhaar_profession")) {
                    return R.array.kyc_profession_array;
                }
                break;
            case 1392507928:
                if (str.equals("SELF_EMPLOYED_OWN_BUSINESS")) {
                    return R.array.kyc_profession_self_own_array;
                }
                break;
            case 1816100745:
                if (str.equals("RETIRED")) {
                    return R.array.kyc_profession_retired_array;
                }
                break;
        }
        return R.array.kyc_profession_default_array;
    }

    public final void b(int i2) {
        Intent intent = new Intent();
        intent.putExtra("option", this.f65342e);
        b bVar = this.f65340b;
        if (bVar == null) {
            k.a("radioButtonListAdapter");
        }
        String str = bVar.f65200c.get(bVar.f65198a);
        k.a((Object) str, "optionsList[selectedPos]");
        intent.putExtra("display_text", str);
        String str2 = this.f65342e;
        String str3 = "";
        switch (str2.hashCode()) {
            case -1985098007:
                if (str2.equals("Sub-Profession")) {
                    String str4 = this.f65339a;
                    switch (str4.hashCode()) {
                        case -1789857552:
                            if (str4.equals("HOUSE_WIFE")) {
                                str3 = b.c.values()[i2].toString();
                                break;
                            }
                            break;
                        case -1579073575:
                            if (str4.equals("SALARIED")) {
                                str3 = b.h.values()[i2].toString();
                                break;
                            }
                            break;
                        case -1161163237:
                            if (str4.equals("STUDENT")) {
                                str3 = b.j.values()[i2].toString();
                                break;
                            }
                            break;
                        case -1090176954:
                            if (str4.equals("UNEMPLOYED")) {
                                str3 = b.k.values()[i2].toString();
                                break;
                            }
                            break;
                        case -203112920:
                            if (str4.equals("PROFESSIONAL_SELF_EMPLOYED")) {
                                str3 = b.f.values()[i2].toString();
                                break;
                            }
                            break;
                        case 1392507928:
                            if (str4.equals("SELF_EMPLOYED_OWN_BUSINESS")) {
                                str3 = b.i.values()[i2].toString();
                                break;
                            }
                            break;
                        case 1816100745:
                            if (str4.equals("RETIRED")) {
                                str3 = b.g.values()[i2].toString();
                                break;
                            }
                            break;
                    }
                }
                break;
            case -1645073654:
                if (str2.equals("Annual Income")) {
                    str3 = b.C1292b.values()[i2].toString();
                    k.a((Object) str3, "KYCConstants.AnnualIncome.values()[pos].toString()");
                    break;
                }
                break;
            case -1210261252:
                if (str2.equals("profession")) {
                    str3 = b.l.values()[i2].toString();
                    break;
                }
                break;
            case 71784621:
                if (str2.equals("aadhaar_profession")) {
                    str3 = b.a.values()[i2].toString();
                    k.a((Object) str3, "KYCConstants.AadhaarProf….values()[pos].toString()");
                    break;
                }
                break;
        }
        intent.putExtra("api_value", str3);
        setResult(-1, intent);
        finish();
    }
}

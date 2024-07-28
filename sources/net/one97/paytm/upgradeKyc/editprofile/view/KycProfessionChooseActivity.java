package net.one97.paytm.upgradeKyc.editprofile.view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.upgradeKyc.editprofile.a.a;

public final class KycProfessionChooseActivity extends PaytmActivity implements View.OnClickListener, a.C1306a {

    /* renamed from: a  reason: collision with root package name */
    public a f65895a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f65896b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private String f65897c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f65898d = "";

    /* renamed from: e  reason: collision with root package name */
    private HashMap f65899e;

    private View a(int i2) {
        if (this.f65899e == null) {
            this.f65899e = new HashMap();
        }
        View view = (View) this.f65899e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65899e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
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
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            int r7 = net.one97.paytm.landingpage.R.layout.fragment_profession_selector_view
            r6.setContentView((int) r7)
            android.content.Intent r7 = r6.getIntent()
            if (r7 == 0) goto L_0x0029
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "option"
            boolean r7 = r7.hasExtra(r0)
            if (r7 == 0) goto L_0x0029
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r7 = r7.getStringExtra(r0)
            java.lang.String r0 = "intent.getStringExtra(OPTION)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            r6.f65897c = r7
        L_0x0029:
            java.lang.String r7 = r6.f65897c
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.res.Resources r1 = r6.getResources()
            java.lang.String r2 = "profession"
            boolean r3 = r2.equals(r7)
            java.lang.String r4 = "Annual Income"
            if (r3 == 0) goto L_0x0041
            java.lang.String r3 = "profession_cat"
            goto L_0x004b
        L_0x0041:
            boolean r3 = r4.equals(r7)
            if (r3 == 0) goto L_0x004a
            java.lang.String r3 = "annual_income"
            goto L_0x004b
        L_0x004a:
            r3 = r2
        L_0x004b:
            r6.f65898d = r3
            int r3 = r7.hashCode()
            r5 = 0
            switch(r3) {
                case -1645073654: goto L_0x00ac;
                case -1532195959: goto L_0x00a1;
                case -1210261252: goto L_0x0098;
                case -370172847: goto L_0x008d;
                case -214492645: goto L_0x0082;
                case 418195558: goto L_0x0077;
                case 1100160744: goto L_0x006c;
                case 1148672424: goto L_0x0061;
                case 1997911033: goto L_0x0056;
                default: goto L_0x0055;
            }
        L_0x0055:
            goto L_0x00b5
        L_0x0056:
            java.lang.String r2 = "Salaried"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x00b5
            int r7 = net.one97.paytm.landingpage.R.array.profession_salaried_array
            goto L_0x00b6
        L_0x0061:
            java.lang.String r2 = "Self Employed/Own Business"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x00b5
            int r7 = net.one97.paytm.landingpage.R.array.profession_self_own_array
            goto L_0x00b6
        L_0x006c:
            java.lang.String r2 = "Professional Self Employed"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x00b5
            int r7 = net.one97.paytm.landingpage.R.array.profession_self_array
            goto L_0x00b6
        L_0x0077:
            java.lang.String r2 = "Unemployed"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x00b5
            int r7 = net.one97.paytm.landingpage.R.array.profession_unemployed_array
            goto L_0x00b6
        L_0x0082:
            java.lang.String r2 = "Student"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x00b5
            int r7 = net.one97.paytm.landingpage.R.array.profession_student_array
            goto L_0x00b6
        L_0x008d:
            java.lang.String r2 = "House Wife"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x00b5
            int r7 = net.one97.paytm.landingpage.R.array.profession_housewife_array
            goto L_0x00b6
        L_0x0098:
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x00b5
            int r7 = net.one97.paytm.landingpage.R.array.profession_category_array
            goto L_0x00b6
        L_0x00a1:
            java.lang.String r2 = "Retired"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x00b5
            int r7 = net.one97.paytm.landingpage.R.array.profession_retired_array
            goto L_0x00b6
        L_0x00ac:
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x00b5
            int r7 = net.one97.paytm.landingpage.R.array.annual_income_array
            goto L_0x00b6
        L_0x00b5:
            r7 = 0
        L_0x00b6:
            java.lang.String[] r7 = r1.getStringArray(r7)
            java.lang.String r1 = "resources.getStringArray(getSavedListID(option))"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            int r1 = r7.length
            r2 = 0
        L_0x00c1:
            if (r2 >= r1) goto L_0x00cb
            r3 = r7[r2]
            r0.add(r3)
            int r2 = r2 + 1
            goto L_0x00c1
        L_0x00cb:
            r6.f65896b = r0
            net.one97.paytm.upgradeKyc.editprofile.a.a r7 = new net.one97.paytm.upgradeKyc.editprofile.a.a
            r0 = r6
            android.content.Context r0 = (android.content.Context) r0
            java.util.ArrayList<java.lang.String> r1 = r6.f65896b
            r7.<init>(r0, r1)
            r6.f65895a = r7
            net.one97.paytm.upgradeKyc.editprofile.a.a r7 = r6.f65895a
            java.lang.String r0 = "radioButtonListAdapter"
            if (r7 != 0) goto L_0x00e2
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00e2:
            r1 = r6
            net.one97.paytm.upgradeKyc.editprofile.a.a$a r1 = (net.one97.paytm.upgradeKyc.editprofile.a.a.C1306a) r1
            java.lang.String r2 = "listner"
            kotlin.g.b.k.c(r1, r2)
            r7.f65803a = r1
            int r7 = net.one97.paytm.landingpage.R.id.optionListView
            android.view.View r7 = r6.a(r7)
            android.widget.ListView r7 = (android.widget.ListView) r7
            java.lang.String r1 = "optionListView"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            net.one97.paytm.upgradeKyc.editprofile.a.a r1 = r6.f65895a
            if (r1 != 0) goto L_0x0100
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0100:
            android.widget.ListAdapter r1 = (android.widget.ListAdapter) r1
            r7.setAdapter(r1)
            int r7 = net.one97.paytm.landingpage.R.id.heading_tv
            android.view.View r7 = r6.a(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0123
            int r0 = net.one97.paytm.landingpage.R.string.kyc_select_title
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r6.b()
            r1[r5] = r2
            java.lang.String r0 = r6.getString(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7.setText(r0)
        L_0x0123:
            int r7 = net.one97.paytm.landingpage.R.id.profession_iv_back_button
            android.view.View r7 = r6.a(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r0 = r6
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r7.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.view.KycProfessionChooseActivity.onCreate(android.os.Bundle):void");
    }

    private final String b() {
        if (!"profession_cat".equals(this.f65898d)) {
            return "annual_income".equals(this.f65898d) ? "Annual Income" : "Sub-Profession";
        }
        String A = b.A("profession");
        k.a((Object) A, "CJRAppCommonUtility.toCamelCase(PROFESSION)");
        return A;
    }

    public final void a() {
        a aVar = this.f65895a;
        if (aVar == null) {
            k.a("radioButtonListAdapter");
        }
        CharSequence a2 = aVar.a();
        if (!(a2 == null || a2.length() == 0)) {
            Intent intent = new Intent();
            intent.putExtra("type", this.f65898d);
            a aVar2 = this.f65895a;
            if (aVar2 == null) {
                k.a("radioButtonListAdapter");
            }
            intent.putExtra("option_value", aVar2.a());
            setResult(-1, intent);
            finish();
            return;
        }
        Toast.makeText(this, getString(R.string.kyc_select_error, new Object[]{b()}), 0).show();
    }
}

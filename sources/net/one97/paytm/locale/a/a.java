package net.one97.paytm.locale.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.b;
import androidx.fragment.app.j;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.utility.n;
import net.one97.paytm.common.b.d;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.ao;

public class a extends b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f53073a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f53074b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f53075c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f53076d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f53077e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f53078f;

    /* renamed from: g  reason: collision with root package name */
    private String f53079g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f53080h;

    public a() {
        ao.a(a.class, "Constructor");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_inapp_push_locale, viewGroup);
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x026e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r17, android.os.Bundle r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            super.onViewCreated(r17, r18)
            int r2 = net.one97.paytm.landingpage.R.id.title1_tv
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f53073a = r2
            int r2 = net.one97.paytm.landingpage.R.id.title2_tv
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f53074b = r2
            int r2 = net.one97.paytm.landingpage.R.id.choose_lang_tv
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f53075c = r2
            int r2 = net.one97.paytm.landingpage.R.id.close_imv
            android.view.View r2 = r1.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.f53076d = r2
            int r2 = net.one97.paytm.landingpage.R.id.choose_lang_ll
            android.view.View r2 = r1.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r0.f53077e = r2
            int r2 = net.one97.paytm.landingpage.R.id.choose_another_language_tv
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f53078f = r2
            int r2 = net.one97.paytm.landingpage.R.id.change_lang_tv
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.f53080h = r1
            android.widget.ImageView r1 = r0.f53076d
            r1.setOnClickListener(r0)
            android.widget.LinearLayout r1 = r0.f53077e
            r1.setOnClickListener(r0)
            android.widget.TextView r1 = r0.f53078f
            r1.setOnClickListener(r0)
            android.os.Bundle r1 = r16.getArguments()
            if (r1 != 0) goto L_0x0065
            r16.dismiss()
        L_0x0065:
            android.os.Bundle r1 = r16.getArguments()
            java.lang.String r2 = "locale"
            java.lang.String r1 = r1.getString(r2)
            r0.f53079g = r1
            java.lang.String r1 = r0.f53079g
            java.lang.String r2 = "hi"
            boolean r1 = r1.equals(r2)
            java.lang.String r3 = "te"
            java.lang.String r4 = "gu"
            java.lang.String r5 = "bn"
            java.lang.String r6 = "or"
            java.lang.String r7 = "mr"
            java.lang.String r8 = "kn"
            java.lang.String r9 = "ta"
            java.lang.String r10 = "pa"
            java.lang.String r11 = "ml"
            if (r1 != 0) goto L_0x0118
            java.lang.String r1 = r0.f53079g
            boolean r1 = r1.equals(r11)
            if (r1 == 0) goto L_0x009f
            int r1 = net.one97.paytm.landingpage.R.string.choose_dialog_title1_ml
            java.lang.String r1 = r0.getString(r1)
            goto L_0x011e
        L_0x009f:
            java.lang.String r1 = r0.f53079g
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x00af
            int r1 = net.one97.paytm.landingpage.R.string.choose_dialog_title1_pa
            java.lang.String r1 = r0.getString(r1)
            goto L_0x011e
        L_0x00af:
            java.lang.String r1 = r0.f53079g
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x00be
            int r1 = net.one97.paytm.landingpage.R.string.choose_dialog_title1_mr
            java.lang.String r1 = r0.getString(r1)
            goto L_0x011e
        L_0x00be:
            java.lang.String r1 = r0.f53079g
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00cd
            int r1 = net.one97.paytm.landingpage.R.string.choose_dialog_title1_or
            java.lang.String r1 = r0.getString(r1)
            goto L_0x011e
        L_0x00cd:
            java.lang.String r1 = r0.f53079g
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x00dc
            int r1 = net.one97.paytm.landingpage.R.string.choose_dialog_title1_bn
            java.lang.String r1 = r0.getString(r1)
            goto L_0x011e
        L_0x00dc:
            java.lang.String r1 = r0.f53079g
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x00eb
            int r1 = net.one97.paytm.landingpage.R.string.choose_dialog_title1_ta
            java.lang.String r1 = r0.getString(r1)
            goto L_0x011e
        L_0x00eb:
            java.lang.String r1 = r0.f53079g
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x00fa
            int r1 = net.one97.paytm.landingpage.R.string.choose_dialog_title1_kn
            java.lang.String r1 = r0.getString(r1)
            goto L_0x011e
        L_0x00fa:
            java.lang.String r1 = r0.f53079g
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0109
            int r1 = net.one97.paytm.landingpage.R.string.choose_dialog_title1_gu
            java.lang.String r1 = r0.getString(r1)
            goto L_0x011e
        L_0x0109:
            java.lang.String r1 = r0.f53079g
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0118
            int r1 = net.one97.paytm.landingpage.R.string.choose_dialog_title1_te
            java.lang.String r1 = r0.getString(r1)
            goto L_0x011e
        L_0x0118:
            int r1 = net.one97.paytm.landingpage.R.string.choose_dialog_title1_hi
            java.lang.String r1 = r0.getString(r1)
        L_0x011e:
            java.lang.String r12 = r0.f53079g
            boolean r12 = r12.equals(r2)
            if (r12 != 0) goto L_0x01af
            java.lang.String r12 = r0.f53079g
            boolean r12 = r12.equals(r11)
            if (r12 == 0) goto L_0x0136
            int r12 = net.one97.paytm.landingpage.R.string.choose_dialog_title2_ml
            java.lang.String r12 = r0.getString(r12)
            goto L_0x01b5
        L_0x0136:
            java.lang.String r12 = r0.f53079g
            boolean r12 = r12.equals(r10)
            if (r12 == 0) goto L_0x0146
            int r12 = net.one97.paytm.landingpage.R.string.choose_dialog_title2_pa
            java.lang.String r12 = r0.getString(r12)
            goto L_0x01b5
        L_0x0146:
            java.lang.String r12 = r0.f53079g
            boolean r12 = r12.equals(r7)
            if (r12 == 0) goto L_0x0155
            int r12 = net.one97.paytm.landingpage.R.string.choose_dialog_title2_mr
            java.lang.String r12 = r0.getString(r12)
            goto L_0x01b5
        L_0x0155:
            java.lang.String r12 = r0.f53079g
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x0164
            int r12 = net.one97.paytm.landingpage.R.string.choose_dialog_title2_or
            java.lang.String r12 = r0.getString(r12)
            goto L_0x01b5
        L_0x0164:
            java.lang.String r12 = r0.f53079g
            boolean r12 = r12.equals(r5)
            if (r12 == 0) goto L_0x0173
            int r12 = net.one97.paytm.landingpage.R.string.choose_dialog_title2_bn
            java.lang.String r12 = r0.getString(r12)
            goto L_0x01b5
        L_0x0173:
            java.lang.String r12 = r0.f53079g
            boolean r12 = r12.equals(r9)
            if (r12 == 0) goto L_0x0182
            int r12 = net.one97.paytm.landingpage.R.string.choose_dialog_title2_ta
            java.lang.String r12 = r0.getString(r12)
            goto L_0x01b5
        L_0x0182:
            java.lang.String r12 = r0.f53079g
            boolean r12 = r12.equals(r8)
            if (r12 == 0) goto L_0x0191
            int r12 = net.one97.paytm.landingpage.R.string.choose_dialog_title2_kn
            java.lang.String r12 = r0.getString(r12)
            goto L_0x01b5
        L_0x0191:
            java.lang.String r12 = r0.f53079g
            boolean r12 = r12.equals(r4)
            if (r12 == 0) goto L_0x01a0
            int r12 = net.one97.paytm.landingpage.R.string.choose_dialog_title2_gu
            java.lang.String r12 = r0.getString(r12)
            goto L_0x01b5
        L_0x01a0:
            java.lang.String r12 = r0.f53079g
            boolean r12 = r12.equals(r3)
            if (r12 == 0) goto L_0x01af
            int r12 = net.one97.paytm.landingpage.R.string.choose_dialog_title2_te
            java.lang.String r12 = r0.getString(r12)
            goto L_0x01b5
        L_0x01af:
            int r12 = net.one97.paytm.landingpage.R.string.choose_dialog_title2_hi
            java.lang.String r12 = r0.getString(r12)
        L_0x01b5:
            java.lang.String r13 = r0.f53079g
            boolean r13 = r13.equals(r2)
            if (r13 != 0) goto L_0x0246
            java.lang.String r13 = r0.f53079g
            boolean r13 = r13.equals(r11)
            if (r13 == 0) goto L_0x01cd
            int r13 = net.one97.paytm.landingpage.R.string.choose_dialog_choose_lang_ml
            java.lang.String r13 = r0.getString(r13)
            goto L_0x024c
        L_0x01cd:
            java.lang.String r13 = r0.f53079g
            boolean r13 = r13.equals(r10)
            if (r13 == 0) goto L_0x01dd
            int r13 = net.one97.paytm.landingpage.R.string.choose_dialog_choose_lang_pa
            java.lang.String r13 = r0.getString(r13)
            goto L_0x024c
        L_0x01dd:
            java.lang.String r13 = r0.f53079g
            boolean r13 = r13.equals(r7)
            if (r13 == 0) goto L_0x01ec
            int r13 = net.one97.paytm.landingpage.R.string.choose_dialog_choose_lang_mr
            java.lang.String r13 = r0.getString(r13)
            goto L_0x024c
        L_0x01ec:
            java.lang.String r13 = r0.f53079g
            boolean r13 = r13.equals(r6)
            if (r13 == 0) goto L_0x01fb
            int r13 = net.one97.paytm.landingpage.R.string.choose_dialog_choose_lang_or
            java.lang.String r13 = r0.getString(r13)
            goto L_0x024c
        L_0x01fb:
            java.lang.String r13 = r0.f53079g
            boolean r13 = r13.equals(r5)
            if (r13 == 0) goto L_0x020a
            int r13 = net.one97.paytm.landingpage.R.string.choose_dialog_choose_lang_bn
            java.lang.String r13 = r0.getString(r13)
            goto L_0x024c
        L_0x020a:
            java.lang.String r13 = r0.f53079g
            boolean r13 = r13.equals(r9)
            if (r13 == 0) goto L_0x0219
            int r13 = net.one97.paytm.landingpage.R.string.choose_dialog_choose_lang_ta
            java.lang.String r13 = r0.getString(r13)
            goto L_0x024c
        L_0x0219:
            java.lang.String r13 = r0.f53079g
            boolean r13 = r13.equals(r8)
            if (r13 == 0) goto L_0x0228
            int r13 = net.one97.paytm.landingpage.R.string.choose_dialog_choose_lang_kn
            java.lang.String r13 = r0.getString(r13)
            goto L_0x024c
        L_0x0228:
            java.lang.String r13 = r0.f53079g
            boolean r13 = r13.equals(r4)
            if (r13 == 0) goto L_0x0237
            int r13 = net.one97.paytm.landingpage.R.string.choose_dialog_choose_lang_gu
            java.lang.String r13 = r0.getString(r13)
            goto L_0x024c
        L_0x0237:
            java.lang.String r13 = r0.f53079g
            boolean r13 = r13.equals(r3)
            if (r13 == 0) goto L_0x0246
            int r13 = net.one97.paytm.landingpage.R.string.choose_dialog_choose_lang_te
            java.lang.String r13 = r0.getString(r13)
            goto L_0x024c
        L_0x0246:
            int r13 = net.one97.paytm.landingpage.R.string.choose_dialog_choose_lang_hi
            java.lang.String r13 = r0.getString(r13)
        L_0x024c:
            android.widget.TextView r14 = r0.f53073a
            r14.setText(r1)
            android.widget.TextView r1 = r0.f53074b
            r1.setText(r12)
            android.widget.TextView r1 = r0.f53075c
            r1.setText(r13)
            r1 = 1
            r0.setCancelable(r1)
            android.widget.TextView r12 = r0.f53080h
            int r13 = net.one97.paytm.landingpage.R.string.change_app_lang
            java.lang.Object[] r14 = new java.lang.Object[r1]
            r15 = 0
            java.lang.String r1 = r0.f53079g
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x02e4
            boolean r2 = r1.equals(r11)
            if (r2 == 0) goto L_0x027c
            int r1 = net.one97.paytm.landingpage.R.string.malyalam_en
            java.lang.String r1 = r0.getString(r1)
            goto L_0x02ea
        L_0x027c:
            boolean r2 = r1.equals(r10)
            if (r2 == 0) goto L_0x0289
            int r1 = net.one97.paytm.landingpage.R.string.punjabi_en
            java.lang.String r1 = r0.getString(r1)
            goto L_0x02ea
        L_0x0289:
            boolean r2 = r1.equals(r7)
            if (r2 == 0) goto L_0x0296
            int r1 = net.one97.paytm.landingpage.R.string.marathi_en
            java.lang.String r1 = r0.getString(r1)
            goto L_0x02ea
        L_0x0296:
            boolean r2 = r1.equals(r6)
            if (r2 == 0) goto L_0x02a3
            int r1 = net.one97.paytm.landingpage.R.string.oriya_en
            java.lang.String r1 = r0.getString(r1)
            goto L_0x02ea
        L_0x02a3:
            boolean r2 = r1.equals(r5)
            if (r2 == 0) goto L_0x02b0
            int r1 = net.one97.paytm.landingpage.R.string.bangla_en
            java.lang.String r1 = r0.getString(r1)
            goto L_0x02ea
        L_0x02b0:
            boolean r2 = r1.equals(r9)
            if (r2 == 0) goto L_0x02bd
            int r1 = net.one97.paytm.landingpage.R.string.tamil_en
            java.lang.String r1 = r0.getString(r1)
            goto L_0x02ea
        L_0x02bd:
            boolean r2 = r1.equals(r8)
            if (r2 == 0) goto L_0x02ca
            int r1 = net.one97.paytm.landingpage.R.string.kannada_en
            java.lang.String r1 = r0.getString(r1)
            goto L_0x02ea
        L_0x02ca:
            boolean r2 = r1.equals(r4)
            if (r2 == 0) goto L_0x02d7
            int r1 = net.one97.paytm.landingpage.R.string.gujrati_en
            java.lang.String r1 = r0.getString(r1)
            goto L_0x02ea
        L_0x02d7:
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x02e4
            int r1 = net.one97.paytm.landingpage.R.string.telugu_en
            java.lang.String r1 = r0.getString(r1)
            goto L_0x02ea
        L_0x02e4:
            int r1 = net.one97.paytm.landingpage.R.string.hindi_en
            java.lang.String r1 = r0.getString(r1)
        L_0x02ea:
            r14[r15] = r1
            java.lang.String r1 = r0.getString(r13, r14)
            r12.setText(r1)
            java.lang.String r1 = r0.f53079g
            boolean r1 = r1.equalsIgnoreCase(r9)
            r2 = 1108344832(0x42100000, float:36.0)
            if (r1 == 0) goto L_0x0304
            android.widget.TextView r1 = r0.f53073a
            r3 = 1
            r1.setTextSize(r3, r2)
            return
        L_0x0304:
            r3 = 1
            java.lang.String r1 = r0.f53079g
            boolean r1 = r1.equalsIgnoreCase(r10)
            if (r1 == 0) goto L_0x0313
            android.widget.TextView r1 = r0.f53073a
            r1.setTextSize(r3, r2)
            return
        L_0x0313:
            java.lang.String r1 = r0.f53079g
            boolean r1 = r1.equalsIgnoreCase(r8)
            if (r1 == 0) goto L_0x0321
            android.widget.TextView r1 = r0.f53073a
            r1.setTextSize(r3, r2)
            return
        L_0x0321:
            java.lang.String r1 = r0.f53079g
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 == 0) goto L_0x032e
            android.widget.TextView r1 = r0.f53073a
            r1.setTextSize(r3, r2)
        L_0x032e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.locale.a.a.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public void onClick(View view) {
        if (view == this.f53076d) {
            dismissAllowingStateLoss();
        } else if (view == this.f53077e) {
            a("paytmmp://change_language?locale=" + this.f53079g);
            dismissAllowingStateLoss();
        } else if (view == this.f53078f) {
            a("paytmmp://change_language");
            dismissAllowingStateLoss();
        }
    }

    public void onPause() {
        super.onPause();
        dismissAllowingStateLoss();
    }

    private void a(String str) {
        d.b().a((Context) getActivity(), str);
    }

    public static void a(Context context, j jVar) {
        boolean z = true;
        String b2 = ag.a(context.getApplicationContext()).b("language_suggest_push_locale", "", true);
        if (!b2.equals("") && n.a().equalsIgnoreCase("en")) {
            if (System.currentTimeMillis() <= ag.a(context.getApplicationContext()).b("language_suggest_popup_timestamp", 0, true) + d.a().a()) {
                z = false;
            }
            if (z && (context instanceof Activity)) {
                new Handler().postDelayed(new Runnable(context, b2, jVar) {
                    private final /* synthetic */ Context f$0;
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ j f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        a.a(this.f$0, this.f$1, this.f$2);
                    }
                }, 1500);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, String str, j jVar) {
        if (!((Activity) context).isFinishing()) {
            try {
                a aVar = new a();
                Bundle bundle = new Bundle();
                bundle.putString(ContactsConstant.LOCALE, str);
                aVar.setArguments(bundle);
                aVar.show(jVar.a(), a.class.getName());
                ag.a(context.getApplicationContext()).a("language_suggest_popup_timestamp", System.currentTimeMillis(), true);
                ag.a(context.getApplicationContext()).a("language_suggest_push_locale", true);
            } catch (Exception unused) {
            }
        }
    }
}

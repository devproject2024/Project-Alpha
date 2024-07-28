package net.one97.paytm.moneytransfer.view.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.b;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.Events;

public final class d extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    String f54443a;

    /* renamed from: b  reason: collision with root package name */
    String f54444b;

    /* renamed from: c  reason: collision with root package name */
    String f54445c;

    /* renamed from: d  reason: collision with root package name */
    String f54446d;

    /* renamed from: e  reason: collision with root package name */
    String f54447e;

    /* renamed from: f  reason: collision with root package name */
    b f54448f;

    /* renamed from: g  reason: collision with root package name */
    private EditText f54449g;

    /* renamed from: h  reason: collision with root package name */
    private TextInputLayout f54450h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f54451i;
    private HashMap j;

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r5, android.view.ViewGroup r6, android.os.Bundle r7) {
        /*
            r4 = this;
            java.lang.String r7 = "inflater"
            kotlin.g.b.k.c(r5, r7)
            int r7 = net.one97.paytm.moneytransfer.R.layout.layout_money_transfer_v2_new_account
            r0 = 0
            android.view.View r5 = r5.inflate(r7, r6, r0)
            java.lang.String r6 = "view"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            kotlin.g.b.k.c(r5, r6)
            int r6 = net.one97.paytm.moneytransfer.R.id.edit_p2b_account_number
            android.view.View r6 = r5.findViewById(r6)
            android.widget.EditText r6 = (android.widget.EditText) r6
            r4.f54449g = r6
            int r6 = net.one97.paytm.moneytransfer.R.id.float_p2b_account_number
            android.view.View r6 = r5.findViewById(r6)
            com.google.android.material.textfield.TextInputLayout r6 = (com.google.android.material.textfield.TextInputLayout) r6
            r4.f54450h = r6
            int r6 = net.one97.paytm.moneytransfer.R.id.receiver_bank_iv
            android.view.View r6 = r5.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r4.f54451i = r6
            int r6 = net.one97.paytm.moneytransfer.R.id.cross_iv
            android.view.View r6 = r5.findViewById(r6)
            r7 = r4
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r6.setOnClickListener(r7)
            int r6 = net.one97.paytm.moneytransfer.R.id.w_custom_dialog_btn_positive
            android.view.View r6 = r5.findViewById(r6)
            r6.setOnClickListener(r7)
            int r6 = net.one97.paytm.moneytransfer.R.id.bank_name_tv
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r7 = net.one97.paytm.moneytransfer.R.id.bankLogoName
            android.view.View r7 = r5.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r1 = net.one97.paytm.moneytransfer.R.id.bank_ifsc_tv
            android.view.View r1 = r5.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = net.one97.paytm.moneytransfer.R.id.name_tv
            android.view.View r2 = r5.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0071
            java.lang.String r3 = r4.f54446d
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
        L_0x0071:
            if (r6 == 0) goto L_0x007a
            java.lang.String r2 = r4.f54445c
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r6.setText(r2)
        L_0x007a:
            if (r7 == 0) goto L_0x0083
            java.lang.String r6 = r4.f54445c
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7.setText(r6)
        L_0x0083:
            if (r1 == 0) goto L_0x008c
            java.lang.String r6 = r4.f54444b
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1.setText(r6)
        L_0x008c:
            java.lang.String r6 = r4.f54443a
            if (r6 == 0) goto L_0x00c6
            if (r6 == 0) goto L_0x00be
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.CharSequence r6 = kotlin.m.p.b(r6)
            java.lang.String r6 = r6.toString()
            if (r6 == 0) goto L_0x00c6
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            kotlin.m.l r7 = new kotlin.m.l
            java.lang.String r1 = "[0123456789]"
            r7.<init>((java.lang.String) r1)
            java.lang.String r1 = ""
            java.lang.String r6 = r7.replace((java.lang.CharSequence) r6, (java.lang.String) r1)
            if (r6 == 0) goto L_0x00c6
            int r6 = r6.length()
            if (r6 != 0) goto L_0x00c6
            android.widget.EditText r6 = r4.f54449g
            if (r6 == 0) goto L_0x00cf
            r7 = 2
            r6.setInputType(r7)
            goto L_0x00cf
        L_0x00be:
            kotlin.u r5 = new kotlin.u
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.CharSequence"
            r5.<init>(r6)
            throw r5
        L_0x00c6:
            android.widget.EditText r6 = r4.f54449g
            if (r6 == 0) goto L_0x00cf
            r7 = 129(0x81, float:1.81E-43)
            r6.setInputType(r7)
        L_0x00cf:
            android.widget.EditText r6 = r4.f54449g
            if (r6 == 0) goto L_0x00d6
            r6.requestFocus()
        L_0x00d6:
            android.widget.EditText r6 = r4.f54449g
            if (r6 != 0) goto L_0x00dd
            kotlin.g.b.k.a()
        L_0x00dd:
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.EditText) r6)
            java.lang.String r6 = r4.f54444b
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x018d
            android.widget.ImageView r6 = r4.f54451i
            if (r6 == 0) goto L_0x00f1
            r6.setVisibility(r0)
        L_0x00f1:
            java.lang.String r6 = r4.f54444b
            if (r6 == 0) goto L_0x0196
            android.widget.ImageView r7 = r4.f54451i
            if (r7 != 0) goto L_0x00fc
            kotlin.g.b.k.a()
        L_0x00fc:
            java.lang.String r1 = "imageView"
            kotlin.g.b.k.c(r7, r1)
            java.lang.String r1 = "ifscCode"
            kotlin.g.b.k.c(r6, r1)
            r1 = r6
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 0
            if (r2 != 0) goto L_0x012a
            java.lang.String r2 = "ICIC"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r2, (boolean) r0)
            if (r0 == 0) goto L_0x012a
            android.content.Context r6 = r4.getContext()
            if (r6 == 0) goto L_0x0126
            int r0 = net.one97.paytm.moneytransfer.R.drawable.icici_bank_logo
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r6, (int) r0)
        L_0x0126:
            r7.setImageDrawable(r3)
            goto L_0x0196
        L_0x012a:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x0149
            r0 = 1
            java.lang.String r2 = "UPI"
            boolean r0 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r2, (boolean) r0)
            if (r0 == 0) goto L_0x0149
            android.content.Context r6 = r4.getContext()
            if (r6 == 0) goto L_0x0145
            int r0 = net.one97.paytm.moneytransfer.R.drawable.ic_bhim
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r6, (int) r0)
        L_0x0145:
            r7.setImageDrawable(r3)
            goto L_0x0196
        L_0x0149:
            boolean r0 = android.webkit.URLUtil.isValidUrl(r6)
            if (r0 == 0) goto L_0x0167
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r6 = r0.a((java.lang.String) r6)
            int r0 = net.one97.paytm.moneytransfer.R.drawable.ic_default_bank
            com.squareup.picasso.aa r6 = r6.a((int) r0)
            int r0 = net.one97.paytm.moneytransfer.R.drawable.ic_default_bank
            com.squareup.picasso.aa r6 = r6.b((int) r0)
            r6.a((android.widget.ImageView) r7)
            goto L_0x0196
        L_0x0167:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x0196
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            android.content.Context r1 = r4.getContext()
            java.lang.String r6 = net.one97.paytm.upi.util.UpiRequestBuilder.getBankIconUrl(r1, r6)
            com.squareup.picasso.aa r6 = r0.a((java.lang.String) r6)
            int r0 = net.one97.paytm.moneytransfer.R.drawable.ic_default_bank
            com.squareup.picasso.aa r6 = r6.a((int) r0)
            int r0 = net.one97.paytm.moneytransfer.R.drawable.ic_default_bank
            com.squareup.picasso.aa r6 = r6.b((int) r0)
            r6.a((android.widget.ImageView) r7)
            goto L_0x0196
        L_0x018d:
            android.widget.ImageView r6 = r4.f54451i
            if (r6 == 0) goto L_0x0196
            r7 = 8
            r6.setVisibility(r7)
        L_0x0196:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.d.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(a.f54452a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class a implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f54452a = new a();

        a() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    from.setState(3);
                    from.setPeekHeight(500);
                    from.setHideable(true);
                    from.setSkipCollapsed(true);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.MoneyTransferBottomSheetDialogStyle);
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.cross_iv) {
            dismiss();
        } else if (view != null && view.getId() == R.id.w_custom_dialog_btn_positive) {
            EditText editText = this.f54449g;
            j jVar = null;
            String valueOf = String.valueOf(editText != null ? editText.getText() : null);
            if (TextUtils.isEmpty(valueOf)) {
                TextInputLayout textInputLayout = this.f54450h;
                if (textInputLayout != null) {
                    textInputLayout.setError(getString(R.string.money_transfer_re_entr_acc_no));
                }
            } else if (valueOf.equals(this.f54443a)) {
                net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, CJRGTMConstants.MT_V4_CONFIRM_CLICKED, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "", "");
                if (getActivity() != null) {
                    dismiss();
                    net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, Events.Action.PROCEED_CLICKED, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "bank_account", "new_account_entered");
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isVPA", false);
                    bundle.putString("vpa", this.f54443a);
                    bundle.putString("username", this.f54446d);
                    bundle.putString("ifsc", this.f54444b);
                    bundle.putString("bankname", this.f54445c);
                    bundle.putString("mobile", this.f54447e);
                    bundle.putInt("source_of_initiation", MoneyTransferV3Activity.c.NEW_ACCOUNT.ordinal());
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        jVar = activity.getSupportFragmentManager();
                    }
                    m.a(bundle, jVar, R.id.fragmentContainer);
                }
            } else {
                TextInputLayout textInputLayout2 = this.f54450h;
                if (textInputLayout2 != null) {
                    textInputLayout2.setError(getString(R.string.bank_account_different_text));
                }
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

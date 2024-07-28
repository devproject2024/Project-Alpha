package net.one97.paytm.wallet.newdesign.independencedaypostcard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.utility.q;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import net.one97.paytm.i.h;
import net.one97.paytm.utils.n;
import net.one97.paytm.wallet.R;

public class c extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f70975a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f70976b;

    /* renamed from: c  reason: collision with root package name */
    private a f70977c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public EditText f70978d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f70979e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.paytm.utility.h f70980f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextInputLayout f70981g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextInputLayout f70982h;

    /* renamed from: i  reason: collision with root package name */
    private TextInputLayout f70983i;
    private TextWatcher j = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            c.this.f70981g.setError((CharSequence) null);
        }
    };
    private TextWatcher k = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            c.this.f70982h.setError((CharSequence) null);
            try {
                if (!TextUtils.isEmpty(charSequence) && Double.parseDouble(charSequence.toString()) > n.j.doubleValue()) {
                    c.this.f70982h.setError(c.this.getString(R.string.amount_limit_error));
                }
            } catch (NumberFormatException e2) {
                q.d(String.valueOf(e2));
            }
        }
    };

    public interface a {
        void a(String str);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if (context instanceof a) {
                this.f70977c = (a) context;
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        a(r5);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r4, android.view.ViewGroup r5, android.os.Bundle r6) {
        /*
            r3 = this;
            int r6 = net.one97.paytm.wallet.R.layout.fragment_send_postcard_independance
            r0 = 0
            android.view.View r4 = r4.inflate(r6, r5, r0)
            int r5 = net.one97.paytm.wallet.R.id.iv_back_button     // Catch:{ Exception -> 0x00e5 }
            android.view.View r5 = r4.findViewById(r5)     // Catch:{ Exception -> 0x00e5 }
            android.widget.ImageView r5 = (android.widget.ImageView) r5     // Catch:{ Exception -> 0x00e5 }
            r3.f70975a = r5     // Catch:{ Exception -> 0x00e5 }
            int r5 = net.one97.paytm.wallet.R.id.ivBtnSend     // Catch:{ Exception -> 0x00e5 }
            android.view.View r5 = r4.findViewById(r5)     // Catch:{ Exception -> 0x00e5 }
            android.widget.ImageView r5 = (android.widget.ImageView) r5     // Catch:{ Exception -> 0x00e5 }
            r3.f70976b = r5     // Catch:{ Exception -> 0x00e5 }
            int r5 = net.one97.paytm.wallet.R.id.lyt_send_postcard     // Catch:{ Exception -> 0x00e5 }
            android.view.View r5 = r4.findViewById(r5)     // Catch:{ Exception -> 0x00e5 }
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5     // Catch:{ Exception -> 0x00e5 }
            r3.f70979e = r5     // Catch:{ Exception -> 0x00e5 }
            androidx.fragment.app.FragmentActivity r5 = r3.getActivity()     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r5 = net.one97.paytm.wallet.utility.a.b((android.content.Context) r5)     // Catch:{ Exception -> 0x00e5 }
            androidx.fragment.app.FragmentActivity r6 = r3.getActivity()     // Catch:{ Exception -> 0x006b }
            java.io.File r6 = r6.getExternalCacheDir()     // Catch:{ Exception -> 0x006b }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x006b }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = "/"
            int r2 = r5.lastIndexOf(r2)     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = r5.substring(r2)     // Catch:{ Exception -> 0x006b }
            r1.<init>(r6, r2)     // Catch:{ Exception -> 0x006b }
            boolean r6 = r1.exists()     // Catch:{ Exception -> 0x006b }
            if (r6 == 0) goto L_0x0067
            java.lang.String r6 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x006b }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeFile(r6)     // Catch:{ Exception -> 0x006b }
            if (r6 == 0) goto L_0x0063
            android.widget.FrameLayout r1 = r3.f70979e     // Catch:{ Exception -> 0x006b }
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Exception -> 0x006b }
            r2.<init>(r6)     // Catch:{ Exception -> 0x006b }
            r1.setBackground(r2)     // Catch:{ Exception -> 0x006b }
            goto L_0x006e
        L_0x0063:
            r3.a((java.lang.String) r5)     // Catch:{ Exception -> 0x006b }
            goto L_0x006e
        L_0x0067:
            r3.a((java.lang.String) r5)     // Catch:{ Exception -> 0x006b }
            goto L_0x006e
        L_0x006b:
            r3.a((java.lang.String) r5)     // Catch:{ Exception -> 0x00e5 }
        L_0x006e:
            int r5 = net.one97.paytm.wallet.R.id.edit_account_input_layout     // Catch:{ Exception -> 0x00e5 }
            android.view.View r5 = r4.findViewById(r5)     // Catch:{ Exception -> 0x00e5 }
            com.google.android.material.textfield.TextInputLayout r5 = (com.google.android.material.textfield.TextInputLayout) r5     // Catch:{ Exception -> 0x00e5 }
            r3.f70981g = r5     // Catch:{ Exception -> 0x00e5 }
            int r5 = net.one97.paytm.wallet.R.id.edit_amount_input_layout     // Catch:{ Exception -> 0x00e5 }
            android.view.View r5 = r4.findViewById(r5)     // Catch:{ Exception -> 0x00e5 }
            com.google.android.material.textfield.TextInputLayout r5 = (com.google.android.material.textfield.TextInputLayout) r5     // Catch:{ Exception -> 0x00e5 }
            r3.f70982h = r5     // Catch:{ Exception -> 0x00e5 }
            int r5 = net.one97.paytm.wallet.R.id.edit_message_input_layout     // Catch:{ Exception -> 0x00e5 }
            android.view.View r5 = r4.findViewById(r5)     // Catch:{ Exception -> 0x00e5 }
            com.google.android.material.textfield.TextInputLayout r5 = (com.google.android.material.textfield.TextInputLayout) r5     // Catch:{ Exception -> 0x00e5 }
            r3.f70983i = r5     // Catch:{ Exception -> 0x00e5 }
            int r5 = net.one97.paytm.wallet.R.id.edit_amount     // Catch:{ Exception -> 0x00e5 }
            android.view.View r5 = r4.findViewById(r5)     // Catch:{ Exception -> 0x00e5 }
            android.widget.EditText r5 = (android.widget.EditText) r5     // Catch:{ Exception -> 0x00e5 }
            r3.f70978d = r5     // Catch:{ Exception -> 0x00e5 }
            android.widget.EditText r5 = r3.f70978d     // Catch:{ Exception -> 0x00e5 }
            android.text.TextWatcher r6 = r3.k     // Catch:{ Exception -> 0x00e5 }
            r5.addTextChangedListener(r6)     // Catch:{ Exception -> 0x00e5 }
            net.one97.paytm.wallet.communicator.c r5 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x00e5 }
            androidx.fragment.app.FragmentActivity r6 = r3.getActivity()     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r1 = "max_digit_paytmcash"
            java.lang.String r5 = r5.getStringFromGTM(r6, r1)     // Catch:{ Exception -> 0x00e5 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00e5 }
            if (r6 != 0) goto L_0x00b6
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x00e5 }
            goto L_0x00b7
        L_0x00b6:
            r5 = 0
        L_0x00b7:
            if (r5 > 0) goto L_0x00ba
            r5 = 5
        L_0x00ba:
            r6 = 1
            android.text.InputFilter[] r6 = new android.text.InputFilter[r6]     // Catch:{ Exception -> 0x00e5 }
            net.one97.paytm.common.widgets.f r1 = new net.one97.paytm.common.widgets.f     // Catch:{ Exception -> 0x00e5 }
            r2 = 2
            r1.<init>(r5, r2)     // Catch:{ Exception -> 0x00e5 }
            r6[r0] = r1     // Catch:{ Exception -> 0x00e5 }
            android.widget.EditText r5 = r3.f70978d     // Catch:{ Exception -> 0x00e5 }
            r5.setFilters(r6)     // Catch:{ Exception -> 0x00e5 }
            android.widget.EditText r5 = r3.f70978d     // Catch:{ Exception -> 0x00e5 }
            r6 = 6
            r5.setImeOptions(r6)     // Catch:{ Exception -> 0x00e5 }
            android.widget.ImageView r5 = r3.f70975a     // Catch:{ Exception -> 0x00e5 }
            r5.setOnClickListener(r3)     // Catch:{ Exception -> 0x00e5 }
            android.widget.ImageView r5 = r3.f70976b     // Catch:{ Exception -> 0x00e5 }
            r5.setOnClickListener(r3)     // Catch:{ Exception -> 0x00e5 }
            android.widget.EditText r5 = r3.f70978d     // Catch:{ Exception -> 0x00e5 }
            net.one97.paytm.wallet.newdesign.independencedaypostcard.c$1 r6 = new net.one97.paytm.wallet.newdesign.independencedaypostcard.c$1     // Catch:{ Exception -> 0x00e5 }
            r6.<init>()     // Catch:{ Exception -> 0x00e5 }
            r5.addTextChangedListener(r6)     // Catch:{ Exception -> 0x00e5 }
            goto L_0x00ed
        L_0x00e5:
            r5 = move-exception
            java.lang.String r5 = java.lang.String.valueOf(r5)
            com.paytm.utility.q.d(r5)
        L_0x00ed:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.independencedaypostcard.c.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void onResume() {
        super.onResume();
        this.f70978d.setText("");
    }

    private void a(String str) {
        try {
            w.a().a(str).a((af) new af() {
                public final void onPrepareLoad(Drawable drawable) {
                }

                public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
                    if (c.this.getActivity() != null) {
                        c.this.f70979e.setBackground(new BitmapDrawable(bitmap));
                    }
                }

                public final void onBitmapFailed(Exception exc, Drawable drawable) {
                    if (c.this.getActivity() != null) {
                        c.this.f70979e.setBackground(new ColorDrawable(c.this.getActivity().getResources().getColor(R.color.white)));
                    }
                }
            });
        } catch (Exception unused) {
            if (getActivity() != null) {
                this.f70979e.setBackground(new ColorDrawable(getActivity().getResources().getColor(R.color.white)));
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        try {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f70978d.getWindowToken(), 0);
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:73|74|75|76|84) */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r13 = new java.util.HashMap();
        r13.put("wallet_error_type", "send_postcard_error");
        r13.put("wallet_error_text", getString(net.one97.paytm.wallet.R.string.wallet_amount_error));
        net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(getActivity().getApplicationContext(), "wallet_error_displayed", r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r12.f70982h.setErrorEnabled(true);
        r12.f70982h.setError(getString(net.one97.paytm.wallet.R.string.wallet_amount_error));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x01b8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x01d8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r13) {
        /*
            r12 = this;
            android.widget.ImageView r0 = r12.f70975a     // Catch:{ Exception -> 0x01e9 }
            if (r13 != r0) goto L_0x000c
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()     // Catch:{ Exception -> 0x01e9 }
            r13.onBackPressed()     // Catch:{ Exception -> 0x01e9 }
            return
        L_0x000c:
            android.widget.ImageView r0 = r12.f70976b     // Catch:{ Exception -> 0x01e9 }
            if (r13 != r0) goto L_0x01e8
            java.lang.String r13 = ""
            android.widget.EditText r0 = r12.f70978d     // Catch:{ Exception -> 0x01e9 }
            android.text.Editable r0 = r0.getText()     // Catch:{ Exception -> 0x01e9 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01e9 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01e9 }
            r2 = 0
            r3 = 1
            java.lang.String r4 = "wallet_error_displayed"
            java.lang.String r5 = "wallet_error_text"
            java.lang.String r6 = "send_postcard_error"
            java.lang.String r7 = "wallet_error_type"
            if (r1 == 0) goto L_0x00c2
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x004d }
            r13.<init>()     // Catch:{ Exception -> 0x004d }
            r13.put(r7, r6)     // Catch:{ Exception -> 0x004d }
            int r0 = net.one97.paytm.wallet.R.string.wallet_amount_error     // Catch:{ Exception -> 0x004d }
            java.lang.String r0 = r12.getString(r0)     // Catch:{ Exception -> 0x004d }
            r13.put(r5, r0)     // Catch:{ Exception -> 0x004d }
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x004d }
            androidx.fragment.app.FragmentActivity r1 = r12.getActivity()     // Catch:{ Exception -> 0x004d }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ Exception -> 0x004d }
            r0.sendCustomGTMEvent(r1, r4, r13)     // Catch:{ Exception -> 0x004d }
            goto L_0x0059
        L_0x004d:
            r13 = move-exception
            boolean r0 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x01e9 }
            if (r0 == 0) goto L_0x0059
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x01e9 }
            com.paytm.utility.q.d(r13)     // Catch:{ Exception -> 0x01e9 }
        L_0x0059:
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()     // Catch:{ Exception -> 0x01e9 }
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x01e9 }
            boolean r13 = r0.isFromAppEvoke(r13)     // Catch:{ Exception -> 0x01e9 }
            if (r13 == 0) goto L_0x00b1
            int r13 = net.one97.paytm.wallet.R.string.trans_status     // Catch:{ Exception -> 0x01e9 }
            java.lang.String r13 = r12.getString(r13)     // Catch:{ Exception -> 0x01e9 }
            int r0 = net.one97.paytm.wallet.R.string.msg_invalid_value     // Catch:{ Exception -> 0x01e9 }
            java.lang.String r0 = r12.getString(r0)     // Catch:{ Exception -> 0x01e9 }
            int r1 = net.one97.paytm.wallet.R.string.ok     // Catch:{ Exception -> 0x01e9 }
            java.lang.String r1 = r12.getString(r1)     // Catch:{ Exception -> 0x01e9 }
            net.one97.paytm.wallet.newdesign.independencedaypostcard.c$3 r3 = new net.one97.paytm.wallet.newdesign.independencedaypostcard.c$3     // Catch:{ Exception -> 0x01e9 }
            r3.<init>()     // Catch:{ Exception -> 0x01e9 }
            com.paytm.utility.h r4 = new com.paytm.utility.h     // Catch:{ Exception -> 0x00a4 }
            androidx.fragment.app.FragmentActivity r5 = r12.getActivity()     // Catch:{ Exception -> 0x00a4 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00a4 }
            r12.f70980f = r4     // Catch:{ Exception -> 0x00a4 }
            com.paytm.utility.h r4 = r12.f70980f     // Catch:{ Exception -> 0x00a4 }
            r4.setTitle(r13)     // Catch:{ Exception -> 0x00a4 }
            com.paytm.utility.h r13 = r12.f70980f     // Catch:{ Exception -> 0x00a4 }
            r13.a(r0)     // Catch:{ Exception -> 0x00a4 }
            com.paytm.utility.h r13 = r12.f70980f     // Catch:{ Exception -> 0x00a4 }
            r13.setCancelable(r2)     // Catch:{ Exception -> 0x00a4 }
            com.paytm.utility.h r13 = r12.f70980f     // Catch:{ Exception -> 0x00a4 }
            r0 = -3
            r13.a(r0, r1, r3)     // Catch:{ Exception -> 0x00a4 }
            com.paytm.utility.h r13 = r12.f70980f     // Catch:{ Exception -> 0x00a4 }
            r13.show()     // Catch:{ Exception -> 0x00a4 }
            return
        L_0x00a4:
            r13 = move-exception
            boolean r0 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x01e9 }
            if (r0 == 0) goto L_0x00b0
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x01e9 }
            com.paytm.utility.q.d(r13)     // Catch:{ Exception -> 0x01e9 }
        L_0x00b0:
            return
        L_0x00b1:
            com.google.android.material.textfield.TextInputLayout r13 = r12.f70982h     // Catch:{ Exception -> 0x01e9 }
            r13.setErrorEnabled(r3)     // Catch:{ Exception -> 0x01e9 }
            com.google.android.material.textfield.TextInputLayout r13 = r12.f70982h     // Catch:{ Exception -> 0x01e9 }
            int r0 = net.one97.paytm.wallet.R.string.wallet_amount_error     // Catch:{ Exception -> 0x01e9 }
            java.lang.String r0 = r12.getString(r0)     // Catch:{ Exception -> 0x01e9 }
            r13.setError(r0)     // Catch:{ Exception -> 0x01e9 }
            return
        L_0x00c2:
            double r8 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x01b8 }
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x0109
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x00ed }
            r13.<init>()     // Catch:{ Exception -> 0x00ed }
            r13.put(r7, r6)     // Catch:{ Exception -> 0x00ed }
            int r0 = net.one97.paytm.wallet.R.string.transaction_limit_message_min     // Catch:{ Exception -> 0x00ed }
            java.lang.String r0 = r12.getString(r0)     // Catch:{ Exception -> 0x00ed }
            r13.put(r5, r0)     // Catch:{ Exception -> 0x00ed }
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x00ed }
            androidx.fragment.app.FragmentActivity r1 = r12.getActivity()     // Catch:{ Exception -> 0x00ed }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ Exception -> 0x00ed }
            r0.sendCustomGTMEvent(r1, r4, r13)     // Catch:{ Exception -> 0x00ed }
            goto L_0x00f9
        L_0x00ed:
            r13 = move-exception
            boolean r0 = com.paytm.utility.b.v     // Catch:{ NumberFormatException -> 0x01b8 }
            if (r0 == 0) goto L_0x00f9
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ NumberFormatException -> 0x01b8 }
            com.paytm.utility.q.d(r13)     // Catch:{ NumberFormatException -> 0x01b8 }
        L_0x00f9:
            int r13 = net.one97.paytm.wallet.R.string.transaction_limit_header     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.String r13 = r12.getString(r13)     // Catch:{ NumberFormatException -> 0x01b8 }
            int r0 = net.one97.paytm.wallet.R.string.transaction_limit_message_min     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.String r0 = r12.getString(r0)     // Catch:{ NumberFormatException -> 0x01b8 }
            r12.a(r13, r0)     // Catch:{ NumberFormatException -> 0x01b8 }
            return
        L_0x0109:
            double r8 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x01e9 }
            java.lang.Double r1 = net.one97.paytm.utils.n.j     // Catch:{ Exception -> 0x01e9 }
            double r10 = r1.doubleValue()     // Catch:{ Exception -> 0x01e9 }
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 <= 0) goto L_0x0154
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x0138 }
            r13.<init>()     // Catch:{ Exception -> 0x0138 }
            r13.put(r7, r6)     // Catch:{ Exception -> 0x0138 }
            int r0 = net.one97.paytm.wallet.R.string.transaction_limit_message     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = r12.getString(r0)     // Catch:{ Exception -> 0x0138 }
            r13.put(r5, r0)     // Catch:{ Exception -> 0x0138 }
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x0138 }
            androidx.fragment.app.FragmentActivity r1 = r12.getActivity()     // Catch:{ Exception -> 0x0138 }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ Exception -> 0x0138 }
            r0.sendCustomGTMEvent(r1, r4, r13)     // Catch:{ Exception -> 0x0138 }
            goto L_0x0144
        L_0x0138:
            r13 = move-exception
            boolean r0 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x01e9 }
            if (r0 == 0) goto L_0x0144
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x01e9 }
            com.paytm.utility.q.d(r13)     // Catch:{ Exception -> 0x01e9 }
        L_0x0144:
            int r13 = net.one97.paytm.wallet.R.string.transaction_limit_header     // Catch:{ Exception -> 0x01e9 }
            java.lang.String r13 = r12.getString(r13)     // Catch:{ Exception -> 0x01e9 }
            int r0 = net.one97.paytm.wallet.R.string.transaction_limit_message     // Catch:{ Exception -> 0x01e9 }
            java.lang.String r0 = r12.getString(r0)     // Catch:{ Exception -> 0x01e9 }
            r12.a(r13, r0)     // Catch:{ Exception -> 0x01e9 }
            return
        L_0x0154:
            androidx.fragment.app.FragmentActivity r1 = r12.getActivity()     // Catch:{ Exception -> 0x01e9 }
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r1)     // Catch:{ Exception -> 0x01e9 }
            if (r1 == 0) goto L_0x0198
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0186 }
            r1.<init>()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r2 = "wallet_send_money_method_name"
            java.lang.String r3 = "mobile"
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0186 }
            java.lang.String r2 = "wallet_send_money_amount"
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0186 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0186 }
            java.lang.String r2 = "wallet_send_money_comment"
            r1.put(r2, r13)     // Catch:{ Exception -> 0x0186 }
            net.one97.paytm.wallet.communicator.c r13 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x0186 }
            androidx.fragment.app.FragmentActivity r2 = r12.getActivity()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r3 = "wallet_send_money_clicked"
            r13.sendCustomGTMEvent(r2, r3, r1)     // Catch:{ Exception -> 0x0186 }
            goto L_0x0192
        L_0x0186:
            r13 = move-exception
            boolean r1 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x01e9 }
            if (r1 == 0) goto L_0x0192
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x01e9 }
            com.paytm.utility.q.d(r13)     // Catch:{ Exception -> 0x01e9 }
        L_0x0192:
            net.one97.paytm.wallet.newdesign.independencedaypostcard.c$a r13 = r12.f70977c     // Catch:{ Exception -> 0x01e9 }
            r13.a(r0)     // Catch:{ Exception -> 0x01e9 }
            return
        L_0x0198:
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()     // Catch:{ Exception -> 0x01e9 }
            if (r13 == 0) goto L_0x01b7
            boolean r13 = r12.isDetached()     // Catch:{ Exception -> 0x01e9 }
            if (r13 == 0) goto L_0x01a5
            goto L_0x01b7
        L_0x01a5:
            net.one97.paytm.wallet.newdesign.utils.NoInternetAlertDialogFragment r13 = net.one97.paytm.wallet.newdesign.utils.NoInternetAlertDialogFragment.newInstance(r2)     // Catch:{ Exception -> 0x01e9 }
            androidx.fragment.app.j r0 = r12.getFragmentManager()     // Catch:{ Exception -> 0x01e9 }
            androidx.fragment.app.q r0 = r0.a()     // Catch:{ Exception -> 0x01e9 }
            java.lang.String r1 = "dialog"
            r13.show((androidx.fragment.app.q) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x01e9 }
            goto L_0x01e8
        L_0x01b7:
            return
        L_0x01b8:
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x01d8 }
            r13.<init>()     // Catch:{ Exception -> 0x01d8 }
            r13.put(r7, r6)     // Catch:{ Exception -> 0x01d8 }
            int r0 = net.one97.paytm.wallet.R.string.wallet_amount_error     // Catch:{ Exception -> 0x01d8 }
            java.lang.String r0 = r12.getString(r0)     // Catch:{ Exception -> 0x01d8 }
            r13.put(r5, r0)     // Catch:{ Exception -> 0x01d8 }
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x01d8 }
            androidx.fragment.app.FragmentActivity r1 = r12.getActivity()     // Catch:{ Exception -> 0x01d8 }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ Exception -> 0x01d8 }
            r0.sendCustomGTMEvent(r1, r4, r13)     // Catch:{ Exception -> 0x01d8 }
        L_0x01d8:
            com.google.android.material.textfield.TextInputLayout r13 = r12.f70982h     // Catch:{ Exception -> 0x01e9 }
            r13.setErrorEnabled(r3)     // Catch:{ Exception -> 0x01e9 }
            com.google.android.material.textfield.TextInputLayout r13 = r12.f70982h     // Catch:{ Exception -> 0x01e9 }
            int r0 = net.one97.paytm.wallet.R.string.wallet_amount_error     // Catch:{ Exception -> 0x01e9 }
            java.lang.String r0 = r12.getString(r0)     // Catch:{ Exception -> 0x01e9 }
            r13.setError(r0)     // Catch:{ Exception -> 0x01e9 }
        L_0x01e8:
            return
        L_0x01e9:
            r13 = move-exception
            java.lang.String r13 = java.lang.String.valueOf(r13)
            com.paytm.utility.q.d(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.independencedaypostcard.c.onClick(android.view.View):void");
    }

    private void a(String str, String str2) {
        this.f70980f = new com.paytm.utility.h(getActivity());
        this.f70980f.setTitle(str);
        this.f70980f.a(str2);
        this.f70980f.setCancelable(true);
        this.f70980f.a(-3, getString(R.string.ok), new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.f70980f.dismiss();
                c.this.f70978d.setText("");
            }
        });
        this.f70980f.show();
    }

    static /* synthetic */ void a(c cVar) {
        try {
            if (cVar.f70978d.getText().toString().trim().length() > 0) {
                cVar.f70976b.setImageDrawable(cVar.getResources().getDrawable(R.drawable.post_now_postcard));
            } else {
                cVar.f70976b.setImageDrawable(cVar.getResources().getDrawable(R.drawable.post_now));
            }
        } catch (Resources.NotFoundException e2) {
            q.d(String.valueOf(e2));
        }
    }
}

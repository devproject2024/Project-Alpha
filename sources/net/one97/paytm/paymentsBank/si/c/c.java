package net.one97.paytm.paymentsBank.si.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.w;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.si.c.a;

public final class c extends a {
    public static final a t = new a((byte) 0);
    private HashMap u;

    public final void h() {
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        h();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.si_fragment_add_benif, viewGroup, false);
        k.a((Object) inflate, "view");
        a(inflate);
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f18875a;

        b(c cVar) {
            this.f18875a = cVar;
        }

        public final void onClick(View view) {
            c.a(this.f18875a);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(View view) {
        k.c(view, "view");
        super.a(view);
        View findViewById = view.findViewById(R.id.proceedbutton);
        if (findViewById != null) {
            ((TextView) findViewById).setOnClickListener(new b(this));
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public static final /* synthetic */ void a(c cVar) {
        if (cVar.g()) {
            View inflate = cVar.getLayoutInflater().inflate(R.layout.pb_layout_money_transfer_v2_new_account, (ViewGroup) null);
            FragmentActivity activity = cVar.getActivity();
            if (activity == null) {
                k.a();
            }
            com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(activity);
            aVar.setContentView(inflate);
            k.a((Object) inflate, "bottomSheetView");
            ViewParent parent = inflate.getParent();
            if (parent != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from((View) parent);
                k.a((Object) from, "BottomSheetBehavior.from…SheetView.parent as View)");
                aVar.setOnDismissListener(new a.h(cVar, from));
                from.setBottomSheetCallback(new a.i(cVar, aVar));
                from.setState(2);
                from.setPeekHeight(com.paytm.utility.b.b((Activity) cVar.getActivity()) - net.one97.paytm.bankCommon.mapping.a.a(150.0f, (Context) cVar.getActivity()));
                Window window = aVar.getWindow();
                if (window == null) {
                    k.a();
                }
                window.setSoftInputMode(16);
                aVar.show();
                aVar.setOnKeyListener(new a.j(cVar, aVar));
                EditText editText = (EditText) inflate.findViewById(R.id.edit_p2b_account_number);
                String str = cVar.p;
                if (str == null) {
                    k.a();
                }
                CharSequence charSequence = str;
                int length = charSequence.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length) {
                    boolean z2 = charSequence.charAt(!z ? i2 : length) <= ' ';
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (!z2) {
                        z = true;
                    } else {
                        i2++;
                    }
                }
                if (new l("[0123456789]").replace((CharSequence) charSequence.subSequence(i2, length + 1).toString(), "").length() == 0) {
                    k.a((Object) editText, "accountNumberET");
                    editText.setInputType(2);
                } else {
                    k.a((Object) editText, "accountNumberET");
                    editText.setInputType(129);
                }
                inflate.findViewById(R.id.cross_iv).setOnClickListener(new a.k(cVar, editText, aVar));
                TextView textView = (TextView) inflate.findViewById(R.id.name_tv);
                if (!TextUtils.isEmpty(cVar.o)) {
                    k.a((Object) textView, "mNameTv");
                    textView.setText(cVar.o);
                } else {
                    k.a((Object) textView, "mNameTv");
                    textView.setVisibility(8);
                }
                TextView textView2 = (TextView) inflate.findViewById(R.id.bank_name_tv);
                TextView textView3 = (TextView) inflate.findViewById(R.id.bankLogoName);
                TextView textView4 = (TextView) inflate.findViewById(R.id.bank_ifsc_tv);
                k.a((Object) textView2, "mBankNameTv");
                textView2.setVisibility(0);
                k.a((Object) textView4, "mIfscTv");
                textView4.setText(cVar.getString(R.string.ifsc_code) + " " + cVar.m);
                if (!TextUtils.isEmpty(cVar.n)) {
                    textView2.setText(cVar.n);
                } else {
                    textView2.setVisibility(8);
                }
                if (!TextUtils.isEmpty(cVar.n)) {
                    k.a((Object) textView3, "mBankLogoName");
                    textView3.setText(cVar.n);
                } else {
                    k.a((Object) textView3, "mBankLogoName");
                    textView3.setVisibility(8);
                }
                ImageView imageView = (ImageView) inflate.findViewById(R.id.receiver_bank_iv);
                if (!TextUtils.isEmpty(cVar.m)) {
                    k.a((Object) imageView, "mReceiverBankIv");
                    imageView.setVisibility(0);
                    String str2 = cVar.m;
                    k.c(imageView, "imageView");
                    CharSequence charSequence2 = str2;
                    if (!TextUtils.isEmpty(charSequence2) && p.a(str2, "UPI", true)) {
                        FragmentActivity activity2 = cVar.getActivity();
                        if (activity2 == null) {
                            k.a();
                        }
                        imageView.setImageDrawable(androidx.core.content.b.a((Context) activity2, R.drawable.pb_ic_bhim));
                    } else if (!TextUtils.isEmpty(charSequence2)) {
                        w a2 = w.a();
                        FragmentActivity activity3 = cVar.getActivity();
                        if (activity3 != null) {
                            activity3.getApplicationContext();
                        }
                        a2.a(net.one97.paytm.paymentsBank.si.g.a.a(str2)).a(R.drawable.pb_bank_ic_default_bank).b(R.drawable.pb_bank_ic_default_bank).a(imageView);
                    }
                } else {
                    k.a((Object) imageView, "mReceiverBankIv");
                    imageView.setVisibility(8);
                }
                TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.float_p2b_account_number);
                editText.postDelayed(new a.e(cVar, editText), 100);
                k.a((Object) textInputLayout, "accountNumberTIL");
                textInputLayout.setVisibility(0);
                textInputLayout.setHint(cVar.getString(R.string.re_entr_acc_no));
                editText.setOnEditorActionListener(new a.l(cVar, editText, textInputLayout, aVar));
                editText.addTextChangedListener(new a.m(textInputLayout));
                inflate.findViewById(R.id.w_custom_dialog_btn_positive).setOnClickListener(new a.n(cVar, editText, textInputLayout, aVar));
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.View");
        }
    }
}

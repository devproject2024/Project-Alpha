package net.one97.paytm.impsRefund.view;

import android.app.Activity;
import android.app.Dialog;
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
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.impsdatamodel.CJRAddRefundAmount;
import net.one97.paytm.impsRefund.a.a;
import net.one97.paytm.impsRefund.a.b;
import net.one97.paytm.impsRefund.b.b;
import net.one97.paytm.impsRefund.view.a;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class b extends a implements a.b {
    public static final a s = new a((byte) 0);
    private a.C0915a t;
    private Dialog u;
    private String v;
    private HashMap w;

    public final void j() {
        HashMap hashMap = this.w;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        j();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.v = arguments != null ? arguments.getString("bank_assetId") : null;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_refund_add_bank, viewGroup, false);
        a.b bVar = this;
        b.a aVar = net.one97.paytm.impsRefund.b.b.f50588a;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        this.t = new net.one97.paytm.impsRefund.c.a(bVar, b.a.a(activity));
        k.a((Object) inflate, "view");
        a(inflate);
        return inflate;
    }

    /* renamed from: net.one97.paytm.impsRefund.view.b$b  reason: collision with other inner class name */
    static final class C0920b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f50649a;

        C0920b(b bVar) {
            this.f50649a = bVar;
        }

        public final void onClick(View view) {
            b.a(this.f50649a);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(View view) {
        k.c(view, "view");
        super.a(view);
        View findViewById = view.findViewById(R.id.proceedbutton);
        if (findViewById != null) {
            ((TextView) findViewById).setOnClickListener(new C0920b(this));
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    /* access modifiers changed from: protected */
    public final void i() {
        if (!TextUtils.isEmpty(this.v)) {
            a.C0915a aVar = this.t;
            if (aVar == null) {
                k.a("mPresenter");
            }
            String str = this.v;
            if (str == null) {
                k.a();
            }
            aVar.a(str);
            return;
        }
        a.C0915a aVar2 = this.t;
        if (aVar2 == null) {
            k.a("mPresenter");
        }
        aVar2.a(this.o, this.p, this.m, this.n);
    }

    public final void a() {
        a.C0915a aVar = this.t;
        if (aVar == null) {
            k.a("mPresenter");
        }
        aVar.a(this.o, this.p, this.m, this.n);
    }

    private static Dialog a(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.lyt_progress_bar);
            Window window = dialog.getWindow();
            if (window == null) {
                k.a();
            }
            window.setBackgroundDrawableResource(17170445);
            return dialog;
        } catch (Exception e2) {
            if (!com.paytm.utility.b.v) {
                return null;
            }
            q.b(e2.getMessage());
            return null;
        }
    }

    public final void a(boolean z) {
        Dialog dialog;
        Dialog dialog2;
        if (z) {
            try {
                if (this.u == null) {
                    this.u = a((Activity) getActivity());
                }
                if (this.u != null) {
                    Dialog dialog3 = this.u;
                    if (dialog3 == null) {
                        k.a();
                    }
                    if (!dialog3.isShowing() && (dialog2 = this.u) != null) {
                        dialog2.show();
                    }
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        } else if (this.u != null) {
            Dialog dialog4 = this.u;
            if (dialog4 == null) {
                k.a();
            }
            if (dialog4.isShowing() && (dialog = this.u) != null) {
                dialog.dismiss();
            }
        }
    }

    public final void a(String str) {
        k.c(str, "msg");
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.something_wrong_try_again);
            k.a((Object) str, "getString(R.string.something_wrong_try_again)");
        }
        com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), str);
    }

    public final void a(CJRAddRefundAmount cJRAddRefundAmount) {
        k.c(cJRAddRefundAmount, "dataModel");
        if (getActivity() instanceof RefundHomePageActivity) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((RefundHomePageActivity) activity).a();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    b.a aVar = ((RefundHomePageActivity) activity2).f50604a;
                    if (aVar == null) {
                        k.a("mPresenter");
                    }
                    aVar.c();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.impsRefund.view.RefundHomePageActivity");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.impsRefund.view.RefundHomePageActivity");
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
        b(networkCustomError);
    }

    public final void onDestroy() {
        super.onDestroy();
        a.C0915a aVar = this.t;
        if (aVar == null) {
            k.a("mPresenter");
        }
        aVar.a();
    }

    public static final /* synthetic */ void a(b bVar) {
        FragmentActivity activity;
        if (bVar.h()) {
            View inflate = bVar.getLayoutInflater().inflate(R.layout.refund_new_account_bottomsheet, (ViewGroup) null);
            FragmentActivity activity2 = bVar.getActivity();
            if (activity2 == null) {
                k.a();
            }
            com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(activity2);
            aVar.setContentView(inflate);
            k.a((Object) inflate, "bottomSheetView");
            ViewParent parent = inflate.getParent();
            if (parent != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from((View) parent);
                k.a((Object) from, "BottomSheetBehavior.from…SheetView.parent as View)");
                aVar.setOnDismissListener(new a.g(bVar, from));
                from.setBottomSheetCallback(new a.h(bVar, aVar));
                from.setState(2);
                from.setPeekHeight(com.paytm.utility.b.b((Activity) bVar.getActivity()) - com.paytm.utility.b.a(150.0f, (Context) bVar.getActivity()));
                Window window = aVar.getWindow();
                if (window == null) {
                    k.a();
                }
                window.setSoftInputMode(16);
                aVar.show();
                aVar.setOnKeyListener(new a.i(bVar, aVar));
                EditText editText = (EditText) inflate.findViewById(R.id.edit_p2b_account_number);
                String str = bVar.p;
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
                inflate.findViewById(R.id.cross_iv).setOnClickListener(new a.j(bVar, editText, aVar));
                TextView textView = (TextView) inflate.findViewById(R.id.name_tv);
                if (!TextUtils.isEmpty(bVar.o)) {
                    k.a((Object) textView, "mNameTv");
                    textView.setText(bVar.o);
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
                textView4.setText(bVar.getString(R.string.ifsc_code) + " " + bVar.m);
                if (!TextUtils.isEmpty(bVar.n)) {
                    textView2.setText(bVar.n);
                } else {
                    textView2.setVisibility(8);
                }
                if (!TextUtils.isEmpty(bVar.n)) {
                    k.a((Object) textView3, "mBankLogoName");
                    textView3.setText(bVar.n);
                } else {
                    k.a((Object) textView3, "mBankLogoName");
                    textView3.setVisibility(8);
                }
                ImageView imageView = (ImageView) inflate.findViewById(R.id.receiver_bank_iv);
                if (!TextUtils.isEmpty(bVar.m)) {
                    k.a((Object) imageView, "mReceiverBankIv");
                    imageView.setVisibility(0);
                    String str2 = bVar.m;
                    k.c(imageView, "imageView");
                    CharSequence charSequence2 = str2;
                    if (!TextUtils.isEmpty(charSequence2) && p.a(str2, "UPI", true)) {
                        FragmentActivity activity3 = bVar.getActivity();
                        if (activity3 == null) {
                            k.a();
                        }
                        imageView.setImageDrawable(androidx.core.content.b.a((Context) activity3, (int) R.drawable.ic_bhim));
                    } else if (!TextUtils.isEmpty(charSequence2) && (activity = bVar.getActivity()) != null) {
                        b.a aVar2 = com.paytm.utility.b.b.f43744a;
                        k.a((Object) activity, "it");
                        b.a.C0750a a2 = b.a.a(activity);
                        FragmentActivity activity4 = bVar.getActivity();
                        a2.f43753a = UpiRequestBuilder.getBankIconUrl(activity4 != null ? activity4.getApplicationContext() : null, str2);
                        b.a.C0750a.a(a2.a((Object) Integer.valueOf(R.drawable.ic_default_bank)).b(Integer.valueOf(R.drawable.ic_default_bank)), imageView, (com.paytm.utility.b.b.b) null, 2);
                    }
                } else {
                    k.a((Object) imageView, "mReceiverBankIv");
                    imageView.setVisibility(8);
                }
                TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.float_p2b_account_number);
                editText.postDelayed(new a.e(bVar, editText), 100);
                k.a((Object) textInputLayout, "accountNumberTIL");
                textInputLayout.setVisibility(0);
                textInputLayout.setHint(bVar.getString(R.string.refund_re_entr_acc_no));
                editText.setOnEditorActionListener(new a.k(bVar, editText, textInputLayout, aVar));
                editText.addTextChangedListener(new a.l(textInputLayout));
                inflate.findViewById(R.id.w_custom_dialog_btn_positive).setOnClickListener(new a.m(bVar, editText, textInputLayout, aVar));
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.View");
        }
    }
}

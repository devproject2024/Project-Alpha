package net.one97.paytm.moneytransfer.view.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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
import com.paytm.utility.h;
import com.squareup.picasso.w;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.a.b;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.moneytransfer.view.fragments.a;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class b extends a implements b.a {
    public static final a u = new a((byte) 0);
    private net.one97.paytm.moneytransfer.presenter.a v;
    private Dialog w;
    private HashMap x;

    public final void j() {
        HashMap hashMap = this.x;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        j();
    }

    public static final /* synthetic */ net.one97.paytm.moneytransfer.presenter.a b(b bVar) {
        net.one97.paytm.moneytransfer.presenter.a aVar = bVar.v;
        if (aVar == null) {
            k.a("mPresenter");
        }
        return aVar;
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
        View inflate = layoutInflater.inflate(R.layout.fragment_add_beneficiary, viewGroup, false);
        b.a aVar = this;
        if (getActivity() == null) {
            k.a();
        }
        net.one97.paytm.upi.requestmoney.b.a.b c2 = g.c();
        k.a((Object) c2, "net.one97.paytm.upi.Inje…neyRepository(activity!!)");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        net.one97.paytm.moneytransfer.b.a.b a2 = net.one97.paytm.moneytransfer.b.a(activity);
        k.a((Object) a2, "Injection.provideMoneyTr…ferRepository(activity!!)");
        this.v = new net.one97.paytm.moneytransfer.presenter.a(aVar, c2, a2);
        k.a((Object) inflate, "view");
        a(inflate);
        return inflate;
    }

    /* renamed from: net.one97.paytm.moneytransfer.view.fragments.b$b  reason: collision with other inner class name */
    static final class C0976b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54432a;

        C0976b(b bVar) {
            this.f54432a = bVar;
        }

        public final void onClick(View view) {
            b.a(this.f54432a);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(View view) {
        k.c(view, "view");
        super.a(view);
        View findViewById = view.findViewById(R.id.btn_proceed);
        if (findViewById != null) {
            ((TextView) findViewById).setOnClickListener(new C0976b(this));
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public final void b(String str) {
        k.c(str, "mPayerName");
        d(str);
    }

    public final void a(boolean z, String str) {
        k.c(str, "message");
        b(z, str);
        if (z) {
            i();
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        b(upiCustomVolleyError);
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54433a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f54434b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f54435c;

        c(b bVar, h hVar, String str) {
            this.f54433a = bVar;
            this.f54434b = hVar;
            this.f54435c = str;
        }

        public final void onClick(View view) {
            this.f54434b.dismiss();
            this.f54433a.a().setText(this.f54435c);
            net.one97.paytm.moneytransfer.presenter.a b2 = b.b(this.f54433a);
            String str = this.f54435c;
            k.a((Object) str, "filterVpa");
            b2.a(str, "xyz");
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54436a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f54437b;

        d(b bVar, h hVar) {
            this.f54436a = bVar;
            this.f54437b = hVar;
        }

        public final void onClick(View view) {
            this.f54437b.dismiss();
            b.b(this.f54436a).a(String.valueOf(this.f54436a.a().getText()), "xyz");
        }
    }

    public final void a(boolean z) {
        Dialog dialog;
        Dialog dialog2;
        if (z) {
            try {
                if (this.w == null) {
                    this.w = UpiAppUtils.getWalletStyleProgressDialog(getActivity());
                }
                if (this.w != null) {
                    Dialog dialog3 = this.w;
                    if (dialog3 == null) {
                        k.a();
                    }
                    if (!dialog3.isShowing() && (dialog2 = this.w) != null) {
                        dialog2.show();
                    }
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        } else if (this.w != null) {
            Dialog dialog4 = this.w;
            if (dialog4 == null) {
                k.a();
            }
            if (dialog4.isShowing() && (dialog = this.w) != null) {
                dialog.dismiss();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void i() {
        if (this.t == a.C0975a.ACCOUNT_NUMBER) {
            net.one97.paytm.moneytransfer.presenter.a aVar = this.v;
            if (aVar == null) {
                k.a("mPresenter");
            }
            aVar.a(this.q, this.p, this.n, this.o);
        } else if (this.t == a.C0975a.VPA) {
            net.one97.paytm.moneytransfer.presenter.a aVar2 = this.v;
            if (aVar2 == null) {
                k.a("mPresenter");
            }
            aVar2.a(this.q, this.p, (String) null, (String) null);
        }
    }

    public final void c(String str) {
        if (this.t == a.C0975a.ACCOUNT_NUMBER) {
            f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "proceed_button_icon_clicked", CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "bank_account", "");
        } else if (this.t == a.C0975a.VPA) {
            f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "proceed_button_icon_clicked", CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "upi_id", "");
        }
        Intent intent = new Intent();
        intent.putExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER, this.q);
        intent.putExtra(UpiConstants.EXTRA_ACCOUNT_NAME, this.p);
        intent.putExtra(UpiConstants.EXTRA_BANK_NAME, this.o);
        intent.putExtra(UpiConstants.EXTRA_IFSC, this.n);
        intent.putExtra(UpiConstants.EXTRA_BENEFICIARY_ID, str);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public final void a(String str) {
        k.c(str, "msg");
        if (getActivity() != null && isAdded() && isResumed()) {
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.mt_something_wrong_try_again);
                k.a((Object) str, "getString(R.string.mt_something_wrong_try_again)");
            }
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), str);
        }
    }

    public static final /* synthetic */ void a(b bVar) {
        if (bVar.h()) {
            Context context = null;
            if (bVar.t != a.C0975a.VPA) {
                View inflate = bVar.getLayoutInflater().inflate(R.layout.layout_money_transfer_v2_new_account, (ViewGroup) null);
                FragmentActivity activity = bVar.getActivity();
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
                    aVar.setOnDismissListener(new a.g(bVar, from));
                    from.setBottomSheetCallback(new a.h(bVar, aVar));
                    from.setState(2);
                    from.setPeekHeight(com.paytm.utility.a.b((Activity) bVar.getActivity()) - UpiAppUtils.convertDpToPixel(150.0f, bVar.getActivity()));
                    Window window = aVar.getWindow();
                    if (window == null) {
                        k.a();
                    }
                    window.setSoftInputMode(16);
                    aVar.show();
                    aVar.setOnKeyListener(new a.i(bVar, aVar));
                    EditText editText = (EditText) inflate.findViewById(R.id.edit_p2b_account_number);
                    String str = bVar.q;
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
                    if (!TextUtils.isEmpty(bVar.p)) {
                        k.a((Object) textView, "mNameTv");
                        textView.setText(bVar.p);
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
                    textView4.setText(bVar.getString(R.string.money_transfer_find_ifsc) + " : " + bVar.n);
                    if (!TextUtils.isEmpty(bVar.o)) {
                        textView2.setText(bVar.o);
                    } else {
                        textView2.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(bVar.o)) {
                        k.a((Object) textView3, "mBankLogoName");
                        textView3.setText(bVar.o);
                    } else {
                        k.a((Object) textView3, "mBankLogoName");
                        textView3.setVisibility(8);
                    }
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.receiver_bank_iv);
                    if (!TextUtils.isEmpty(bVar.n)) {
                        k.a((Object) imageView, "mReceiverBankIv");
                        imageView.setVisibility(0);
                        String str2 = bVar.n;
                        k.c(imageView, "imageView");
                        CharSequence charSequence2 = str2;
                        if (!TextUtils.isEmpty(charSequence2) && p.a(str2, "UPI", true)) {
                            FragmentActivity activity2 = bVar.getActivity();
                            if (activity2 == null) {
                                k.a();
                            }
                            imageView.setImageDrawable(androidx.core.content.b.a((Context) activity2, R.drawable.ic_bhim));
                        } else if (!TextUtils.isEmpty(charSequence2)) {
                            w a2 = w.a();
                            FragmentActivity activity3 = bVar.getActivity();
                            if (activity3 != null) {
                                context = activity3.getApplicationContext();
                            }
                            a2.a(UpiRequestBuilder.getBankIconUrl(context, str2)).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView);
                        }
                    } else {
                        k.a((Object) imageView, "mReceiverBankIv");
                        imageView.setVisibility(8);
                    }
                    TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.float_p2b_account_number);
                    editText.postDelayed(new a.e(bVar, editText), 100);
                    k.a((Object) textInputLayout, "accountNumberTIL");
                    textInputLayout.setVisibility(0);
                    textInputLayout.setHint(bVar.getString(R.string.money_transfer_re_entr_acc_no));
                    editText.setOnEditorActionListener(new a.k(bVar, editText, textInputLayout, aVar));
                    editText.addTextChangedListener(new a.l(textInputLayout));
                    inflate.findViewById(R.id.w_custom_dialog_btn_positive).setOnClickListener(new a.m(bVar, editText, textInputLayout, aVar));
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.View");
            } else if (bVar.s) {
                bVar.i();
            } else if (com.paytm.utility.a.m(bVar.getActivity())) {
                bVar.c().setError((CharSequence) null);
                com.paytm.utility.b.c((Activity) bVar.getActivity());
                String valueOf = String.valueOf(bVar.a().getText());
                if (valueOf != null) {
                    String lowerCase = valueOf.toLowerCase();
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (p.a((CharSequence) lowerCase, (CharSequence) ".com", false)) {
                        String clearExtension = UpiAppUtils.clearExtension(String.valueOf(bVar.a().getText()));
                        h hVar = new h(bVar.getActivity());
                        aa aaVar = aa.f47921a;
                        String string = bVar.getString(R.string.money_transfer_did_you_mean_to_enter);
                        k.a((Object) string, "getString(R.string.money…er_did_you_mean_to_enter)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{clearExtension}, 1));
                        k.a((Object) format, "java.lang.String.format(format, *args)");
                        hVar.a(format);
                        hVar.a(-1, CommonPayParams.Builder.YES, new c(bVar, hVar, clearExtension));
                        hVar.a(-2, CommonPayParams.Builder.NO, new d(bVar, hVar));
                        hVar.show();
                        return;
                    }
                    net.one97.paytm.moneytransfer.presenter.a aVar2 = bVar.v;
                    if (aVar2 == null) {
                        k.a("mPresenter");
                    }
                    aVar2.a(String.valueOf(bVar.a().getText()), "xyz");
                    return;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            } else {
                com.paytm.utility.b.b((Context) bVar.getActivity(), bVar.getResources().getString(R.string.no_connection), bVar.getResources().getString(R.string.no_internet));
            }
        }
    }
}

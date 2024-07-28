package net.one97.paytm.moneytransfer.view.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.contactsSdk.database.ContactColumn;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.contacts.b.a;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.viewmodel.d;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.UpiAppUtils;

public final class f extends Fragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.moneytransfer.d.b f54466a;

    /* renamed from: b  reason: collision with root package name */
    private EditText f54467b;

    /* renamed from: c  reason: collision with root package name */
    private View f54468c;

    /* renamed from: d  reason: collision with root package name */
    private LottieAnimationView f54469d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f54470e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f54471f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.moneytransfer.viewmodel.d f54472g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f54473h = "";
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f54474i = "";
    private HashMap j;

    static final class a<T> implements z<net.one97.paytm.moneytransfer.model.c<d.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f54475a;

        a(f fVar) {
            this.f54475a = fVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = g.f54480a[dVar.ordinal()];
                if (i2 == 1) {
                    f.b(this.f54475a);
                } else if (i2 == 2) {
                    f.c(this.f54475a);
                    f.a(this.f54475a, cVar);
                } else if (i2 == 3) {
                    f.c(this.f54475a);
                    UpiCustomVolleyError upiCustomVolleyError = cVar.f54034c;
                    if (upiCustomVolleyError != null) {
                        f.a(this.f54475a, upiCustomVolleyError);
                    }
                }
            }
        }
    }

    static final class b<T> implements z<net.one97.paytm.moneytransfer.model.c<a.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f54476a;

        b(f fVar) {
            this.f54476a = fVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            String str2;
            a.d dVar;
            a.d dVar2;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            f fVar = this.f54476a;
            if (cVar == null || (dVar2 = (a.d) cVar.f54033b) == null) {
                str = null;
            } else {
                str = dVar2.f53982a;
            }
            String f2 = m.f(str);
            k.a((Object) f2, "MoneyTransferUtils.toCam…Details?.data?.payeeName)");
            fVar.f54473h = f2;
            f fVar2 = this.f54476a;
            if (cVar == null || (dVar = (a.d) cVar.f54033b) == null || (str2 = dVar.f53983b) == null) {
                str2 = "";
            }
            fVar2.f54474i = str2;
        }
    }

    public final void onCreate(Bundle bundle) {
        y<net.one97.paytm.moneytransfer.model.c<a.d>> yVar;
        y<net.one97.paytm.moneytransfer.model.c<d.a>> yVar2;
        super.onCreate(bundle);
        this.f54472g = (net.one97.paytm.moneytransfer.viewmodel.d) am.a((Fragment) this).a(net.one97.paytm.moneytransfer.viewmodel.d.class);
        net.one97.paytm.moneytransfer.viewmodel.d dVar = this.f54472g;
        if (!(dVar == null || (yVar2 = dVar.f54722a) == null)) {
            yVar2.observe(this, new a(this));
        }
        net.one97.paytm.moneytransfer.viewmodel.d dVar2 = this.f54472g;
        if (dVar2 != null && (yVar = dVar2.f54724c) != null) {
            yVar.observe(this, new b(this));
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.money_transfer_enter_no_sheet, viewGroup, false);
        k.a((Object) inflate, "view");
        this.f54467b = (EditText) inflate.findViewById(R.id.so_cp_contact_et);
        this.f54469d = (LottieAnimationView) inflate.findViewById(R.id.money_transfer_loader);
        this.f54470e = (TextView) inflate.findViewById(R.id.w_custom_dialog_btn_positive);
        this.f54468c = inflate.findViewById(R.id.money_transfer_loader_container);
        TextView textView = this.f54470e;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        inflate.findViewById(R.id.iv_back_button).setOnClickListener(this);
        this.f54471f = (TextView) inflate.findViewById(R.id.so_enter_number_tv);
        EditText editText = this.f54467b;
        if (editText != null) {
            editText.requestFocus();
        }
        EditText editText2 = this.f54467b;
        if (editText2 == null) {
            k.a();
        }
        editText2.postDelayed(new d(this, editText2), 100);
        EditText editText3 = this.f54467b;
        if (editText3 != null) {
            editText3.addTextChangedListener(new c(this));
        }
        return inflate;
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f54477a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        c(f fVar) {
            this.f54477a = fVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            TextView a2;
            if (f.b(String.valueOf(charSequence)) && (a2 = this.f54477a.f54471f) != null) {
                a2.setVisibility(8);
            }
        }
    }

    public final void onClick(View view) {
        j supportFragmentManager;
        if (view != null && view.getId() == R.id.w_custom_dialog_btn_positive) {
            EditText editText = this.f54467b;
            String valueOf = String.valueOf(editText != null ? editText.getText() : null);
            if (!b(valueOf)) {
                TextView textView = this.f54471f;
                if (textView != null) {
                    textView.setText(getString(R.string.err_valid_phone));
                }
                TextView textView2 = this.f54471f;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
            } else if (com.paytm.utility.a.m(getContext())) {
                TextView textView3 = this.f54471f;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                net.one97.paytm.moneytransfer.viewmodel.d dVar = this.f54472g;
                if (dVar != null) {
                    k.c(valueOf, "phoneNumber");
                    y<net.one97.paytm.moneytransfer.model.c<d.a>> yVar = dVar.f54722a;
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    yVar.setValue(c.a.a());
                    net.one97.paytm.moneytransfer.b.a.b bVar = dVar.f54723b;
                    if (bVar != null) {
                        bVar.a((a.C0960a) new d.b(dVar), valueOf);
                    }
                }
            } else {
                m.d((Activity) getActivity());
            }
        } else if (view != null && view.getId() == R.id.iv_back_button && getActivity() != null) {
            UpiAppUtils.hideKeyboard(getActivity());
            FragmentActivity activity = getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                supportFragmentManager.d();
            }
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f54478a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f54479b;

        d(f fVar, EditText editText) {
            this.f54478a = fVar;
            this.f54479b = editText;
        }

        public final void run() {
            Window window;
            try {
                Context context = this.f54478a.getContext();
                InputMethodManager inputMethodManager = (InputMethodManager) (context != null ? context.getSystemService("input_method") : null);
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f54479b, 1);
                    FragmentActivity activity = this.f54478a.getActivity();
                    if (activity != null && (window = activity.getWindow()) != null) {
                        window.setSoftInputMode(20);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(String str) {
        if (!TextUtils.isEmpty(str) && Character.isDigit(str.charAt(0))) {
            try {
                if (Integer.parseInt(String.valueOf(str.charAt(0))) <= 4 || str == null || str.length() != 10) {
                    return false;
                }
                return true;
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    private final void a() {
        String str;
        j supportFragmentManager;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            Editable editable = null;
            Boolean valueOf = activity != null ? Boolean.valueOf(activity.isFinishing()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (!valueOf.booleanValue()) {
                UpiAppUtils.hideKeyboard(getActivity());
                FragmentActivity activity2 = getActivity();
                q a2 = (activity2 == null || (supportFragmentManager = activity2.getSupportFragmentManager()) == null) ? null : supportFragmentManager.a();
                i iVar = new i();
                Bundle bundle = new Bundle();
                if (p.a(this.f54473h)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getString(R.string.mt_india_code_space));
                    EditText editText = this.f54467b;
                    if (editText != null) {
                        editable = editText.getText();
                    }
                    sb.append(String.valueOf(editable));
                    str = sb.toString();
                } else {
                    str = this.f54473h;
                }
                bundle.putString(ContactColumn.PHONE_NUMBER, str);
                iVar.setArguments(bundle);
                net.one97.paytm.moneytransfer.d.b bVar = this.f54466a;
                if (bVar != null) {
                    iVar.a(bVar);
                }
                if (a2 != null) {
                    a2.a(R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out, R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out);
                }
                if (a2 != null) {
                    a2.a(R.id.fragmentContainer, iVar, "MoneyTransferNoUPIUserFragment").a("MoneyTransferNoUPIUserFragment");
                }
                if (a2 != null) {
                    a2.c();
                }
            }
        }
    }

    public static final /* synthetic */ void b(f fVar) {
        AnimationFactory.startWalletLoader(fVar.f54469d);
        TextView textView = fVar.f54470e;
        if (textView != null) {
            textView.setEnabled(false);
        }
        TextView textView2 = fVar.f54470e;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        View view = fVar.f54468c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public static final /* synthetic */ void c(f fVar) {
        AnimationFactory.stopWalletLoader(fVar.f54469d);
        TextView textView = fVar.f54470e;
        if (textView != null) {
            textView.setEnabled(true);
        }
        TextView textView2 = fVar.f54470e;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        View view = fVar.f54468c;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX WARNING: type inference failed for: r2v12, types: [android.text.Editable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.moneytransfer.view.fragments.f r17, net.one97.paytm.moneytransfer.model.c r18) {
        /*
            r0 = r17
            r1 = r18
            ResultType r1 = r1.f54033b
            net.one97.paytm.moneytransfer.viewmodel.d$a r1 = (net.one97.paytm.moneytransfer.viewmodel.d.a) r1
            r2 = 0
            if (r1 == 0) goto L_0x0012
            boolean r3 = r1.f54725a
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x0013
        L_0x0012:
            r3 = r2
        L_0x0013:
            if (r3 != 0) goto L_0x0018
            kotlin.g.b.k.a()
        L_0x0018:
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x01a9
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$PaymentOptionList r1 = r1.f54726b
            if (r1 != 0) goto L_0x0025
            kotlin.g.b.k.a()
        L_0x0025:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r3 = r1.getSourcePayment()
            java.lang.String r4 = "paymentOptionListItem.sourcePayment"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r3 = r3.getPaymentType()
            net.one97.paytm.upi.common.PaymentInstrumentationType r4 = net.one97.paytm.upi.common.PaymentInstrumentationType.UPI_LEAD
            java.lang.String r4 = r4.name()
            r5 = 1
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r4, (boolean) r5)
            if (r3 == 0) goto L_0x006f
            android.content.Context r1 = r17.getContext()
            if (r1 == 0) goto L_0x006e
            androidx.fragment.app.FragmentActivity r1 = r17.getActivity()
            r3 = r1
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r4 = "wallet_money_transfer"
            java.lang.String r5 = "phonebook_list_clicked"
            java.lang.String r6 = "/money-transfer"
            java.lang.String r7 = "user_not_on_UPI_Bank_Account"
            java.lang.String r8 = ""
            net.one97.paytm.moneytransfer.utils.f.a(r3, r4, r5, r6, r7, r8)
            android.widget.EditText r1 = r0.f54467b
            if (r1 == 0) goto L_0x0063
            android.text.Editable r2 = r1.getText()
        L_0x0063:
            java.lang.String r1 = java.lang.String.valueOf(r2)
            net.one97.paytm.moneytransfer.d.b r0 = r0.f54466a
            if (r0 == 0) goto L_0x006e
            r0.e(r1)
        L_0x006e:
            return
        L_0x006f:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r3 = r1.getDestinationPayment()
            java.lang.String r4 = "paymentOptionListItem.destinationPayment"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r3 = r3.getPaymentType()
            net.one97.paytm.upi.common.PaymentInstrumentationType r6 = net.one97.paytm.upi.common.PaymentInstrumentationType.UPI
            java.lang.String r6 = r6.name()
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r6, (boolean) r5)
            java.lang.String r6 = "source_of_initiation"
            java.lang.String r7 = "picture"
            java.lang.String r8 = "username"
            java.lang.String r9 = "vpa"
            java.lang.String r10 = "isVPA"
            if (r3 == 0) goto L_0x00f5
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r3 = r1.getDestinationPayment()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r3 = r3.getVpaId()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r1 = r1.getDestinationPayment()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r1 = r1.getDisplayName()
            java.lang.String r4 = "vpaId"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r4 = "name"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            android.content.Context r11 = r17.getContext()
            java.lang.String r12 = "wallet_money_transfer"
            java.lang.String r13 = "proceed_clicked"
            java.lang.String r14 = "/money-transfer"
            java.lang.String r15 = "upi"
            java.lang.String r16 = "new_phone_number_entered"
            net.one97.paytm.moneytransfer.utils.f.a(r11, r12, r13, r14, r15, r16)
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            r4.putBoolean(r10, r5)
            r4.putString(r9, r3)
            r4.putString(r8, r1)
            java.lang.String r1 = r0.f54474i
            r4.putString(r7, r1)
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$c r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.c.PHONEBOOK
            int r1 = r1.ordinal()
            r4.putInt(r6, r1)
            androidx.fragment.app.FragmentActivity r0 = r17.getActivity()
            if (r0 == 0) goto L_0x00ef
            androidx.fragment.app.j r2 = r0.getSupportFragmentManager()
        L_0x00ef:
            int r0 = net.one97.paytm.moneytransfer.R.id.fragmentContainer
            net.one97.paytm.moneytransfer.utils.m.a((android.os.Bundle) r4, (androidx.fragment.app.j) r2, (int) r0)
            return
        L_0x00f5:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r2 = r1.getDestinationPayment()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.String r2 = r2.getPaymentType()
            net.one97.paytm.upi.common.PaymentInstrumentationType r3 = net.one97.paytm.upi.common.PaymentInstrumentationType.BANK
            java.lang.String r3 = r3.name()
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r5)
            if (r2 == 0) goto L_0x01a8
            androidx.fragment.app.FragmentActivity r2 = r17.getActivity()
            r11 = r2
            android.content.Context r11 = (android.content.Context) r11
            java.lang.String r12 = "wallet_money_transfer"
            java.lang.String r13 = "selected_contact_link_status"
            java.lang.String r14 = "/money-transfer"
            java.lang.String r15 = "linked_bank"
            java.lang.String r16 = ""
            net.one97.paytm.moneytransfer.utils.f.a(r11, r12, r13, r14, r15, r16)
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r2 = r1.getDestinationPayment()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.String r2 = r2.getBankAccountNumber()
            java.lang.String r3 = "paymentOptionListItem.de…Payment.bankAccountNumber"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r3 = r0.f54473h
            if (r3 != 0) goto L_0x0138
            kotlin.g.b.k.a()
        L_0x0138:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r5 = r1.getDestinationPayment()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            java.lang.String r5 = r5.getIfscCode()
            java.lang.String r11 = "paymentOptionListItem.destinationPayment.ifscCode"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r11)
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r1 = r1.getDestinationPayment()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r1 = r1.getBankName()
            java.lang.String r4 = "paymentOptionListItem.destinationPayment.bankName"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            android.content.Context r11 = r17.getContext()
            java.lang.String r12 = "wallet_money_transfer"
            java.lang.String r13 = "proceed_clicked"
            java.lang.String r14 = "/money-transfer"
            java.lang.String r15 = "bank_account"
            java.lang.String r16 = "new_phone_number_entered"
            net.one97.paytm.moneytransfer.utils.f.a(r11, r12, r13, r14, r15, r16)
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            r11 = 0
            r4.putBoolean(r10, r11)
            r4.putString(r9, r2)
            r4.putString(r8, r3)
            java.lang.String r2 = "ifsc"
            r4.putString(r2, r5)
            java.lang.String r2 = "bankname"
            r4.putString(r2, r1)
            java.lang.String r1 = r0.f54474i
            r4.putString(r7, r1)
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$c r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.c.PHONEBOOK
            int r1 = r1.ordinal()
            r4.putInt(r6, r1)
            androidx.fragment.app.FragmentActivity r0 = r17.getActivity()
            if (r0 != 0) goto L_0x019a
            kotlin.g.b.k.a()
        L_0x019a:
            java.lang.String r1 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
            int r1 = net.one97.paytm.moneytransfer.R.id.fragmentContainer
            net.one97.paytm.moneytransfer.utils.m.a((android.os.Bundle) r4, (androidx.fragment.app.j) r0, (int) r1)
        L_0x01a8:
            return
        L_0x01a9:
            r17.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.f.a(net.one97.paytm.moneytransfer.view.fragments.f, net.one97.paytm.moneytransfer.model.c):void");
    }

    public static final /* synthetic */ void a(f fVar, UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            return;
        }
        if ("BT_INV_435".equals(upiCustomVolleyError.getmErrorCode())) {
            fVar.a();
        } else if ("BT_ISE_436".equals(upiCustomVolleyError.getmErrorCode())) {
            m.b((Activity) fVar.getActivity());
        } else {
            if (upiCustomVolleyError.getAlertMessage() == null) {
                upiCustomVolleyError.setAlertMessage(fVar.getString(R.string.mt_something_wrong_try_again));
            }
            com.paytm.utility.b.b(fVar.getActivity(), upiCustomVolleyError.getAlertTitle() == null ? "Error" : upiCustomVolleyError.getAlertTitle(), upiCustomVolleyError.getAlertMessage());
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

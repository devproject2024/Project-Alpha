package net.one97.paytm.upi.registration.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseDialogFragment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.registration.view.p;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class q extends net.one97.paytm.i.f implements p.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f69021a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f69022b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public b f69023c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f69024d;

    /* renamed from: e  reason: collision with root package name */
    private CheckBox f69025e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f69026f = UpiConstants.ARG_BANK_LIST;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f69027g = BaseDialogFragment.IS_CANCELABLE;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<BankAccountDetails.BankAccount> f69028h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private HashMap f69029i;

    public interface b {
        void a();

        void a(BankAccountDetails.BankAccount bankAccount);
    }

    public static final /* synthetic */ RecyclerView b(q qVar) {
        RecyclerView recyclerView = qVar.f69022b;
        if (recyclerView == null) {
            k.a("bankListRecyclerView");
        }
        return recyclerView;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static q a(ArrayList<BankAccountDetails.BankAccount> arrayList, b bVar) {
            k.c(arrayList, "bankList");
            k.c(bVar, "listener");
            q qVar = new q();
            Bundle bundle = new Bundle();
            bundle.putSerializable(qVar.f69026f, arrayList);
            qVar.f69023c = bVar;
            qVar.setArguments(bundle);
            return qVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(this.f69026f) : null;
        if (serializable != null) {
            this.f69028h = (ArrayList) serializable;
            setStyle(0, R.style.BottomSheetDialogStyle);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount> /* = java.util.ArrayList<net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount> */");
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Context applicationContext;
        k.c(dialogInterface, "dialog");
        Bundle arguments = getArguments();
        if (arguments != null ? arguments.getBoolean(this.f69027g, false) : false) {
            CheckBox checkBox = this.f69025e;
            if (checkBox == null) {
                k.a("checkBox");
            }
            if (checkBox.isChecked()) {
                Context context = getContext();
                com.paytm.b.a.a pref = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : PaytmUpiPrefUtil.Companion.getPref(applicationContext);
                if (pref != null) {
                    pref.a(UpiConstants.PREF_KEY_SETMPIN_VISIBLE_FLAG, false, false);
                }
            }
        }
        super.onDismiss(dialogInterface);
        b bVar = this.f69023c;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_sign_up_set_mpin_sheet, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.checkbox);
        k.a((Object) findViewById, "view.findViewById<CheckBox>(R.id.checkbox)");
        this.f69025e = (CheckBox) findViewById;
        Bundle arguments = getArguments();
        if (arguments != null ? arguments.getBoolean(this.f69027g, false) : false) {
            View findViewById2 = inflate.findViewById(R.id.iv_close);
            k.a((Object) findViewById2, "view.findViewById<ImageView>(R.id.iv_close)");
            ((ImageView) findViewById2).setVisibility(0);
            CheckBox checkBox = this.f69025e;
            if (checkBox == null) {
                k.a("checkBox");
            }
            checkBox.setVisibility(0);
        } else {
            View findViewById3 = inflate.findViewById(R.id.iv_close);
            k.a((Object) findViewById3, "view.findViewById<ImageView>(R.id.iv_close)");
            ((ImageView) findViewById3).setVisibility(8);
            CheckBox checkBox2 = this.f69025e;
            if (checkBox2 == null) {
                k.a("checkBox");
            }
            checkBox2.setVisibility(8);
        }
        View findViewById4 = inflate.findViewById(R.id.rv_bank_account_list);
        k.a((Object) findViewById4, "view.findViewById(R.id.rv_bank_account_list)");
        this.f69022b = (RecyclerView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.tv_imp_note);
        k.a((Object) findViewById5, "view.findViewById(R.id.tv_imp_note)");
        this.f69024d = (TextView) findViewById5;
        RecyclerView recyclerView = this.f69022b;
        if (recyclerView == null) {
            k.a("bankListRecyclerView");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView2 = this.f69022b;
        if (recyclerView2 == null) {
            k.a("bankListRecyclerView");
        }
        recyclerView2.setAdapter(new p(this.f69028h, getActivity(), this));
        ((ImageView) inflate.findViewById(R.id.iv_close)).setOnClickListener(new d(this));
        ((TextView) inflate.findViewById(R.id.tv_do_later)).setOnClickListener(new e(this));
        ((TextView) inflate.findViewById(R.id.tv_set_pin)).setOnClickListener(new f(this));
        if (this.f69028h.size() == 1) {
            View findViewById6 = inflate.findViewById(R.id.tv_title);
            k.a((Object) findViewById6, "view.findViewById<TextView>(R.id.tv_title)");
            ((TextView) findViewById6).setText(getString(R.string.upi_select_bank_for_pin_single_bank));
        }
        Context context = getContext();
        ArrayList<BankAccountDetails.BankAccount> arrayList = this.f69028h;
        CJRSendGTMTag.sendNewCustomGTMEvents(context, GAConstants.CATEGORY.UPI_ONB_V1, "screen_open", String.valueOf((arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue()), "", "", GAConstants.SCREEN_NAME.UPI_ONB_SET_PRIMARY_ACCOUNT, "wallet");
        return inflate;
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f69031a;

        d(q qVar) {
            this.f69031a = qVar;
        }

        public final void onClick(View view) {
            this.f69031a.dismissAllowingStateLoss();
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f69032a;

        e(q qVar) {
            this.f69032a = qVar;
        }

        public final void onClick(View view) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f69032a.getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "set_pin_sheet_do_it_later", "", "", "", "/bhim-upi/signup/setmpin", "wallet");
            this.f69032a.dismissAllowingStateLoss();
            b a2 = this.f69032a.f69023c;
            if (a2 != null) {
                a2.a();
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f69033a;

        f(q qVar) {
            this.f69033a = qVar;
        }

        public final void onClick(View view) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f69033a.getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "set_pin_sheet_proceed", "", "", "", "/bhim-upi/signup/setmpin", "wallet");
            this.f69033a.dismissAllowingStateLoss();
            RecyclerView.a adapter = q.b(this.f69033a).getAdapter();
            if (adapter != null) {
                p pVar = (p) adapter;
                b a2 = this.f69033a.f69023c;
                if (a2 != null) {
                    Object obj = this.f69033a.f69028h.get(pVar.a());
                    k.a(obj, "profileBankList.get(addB…ter.selectedBankPosition)");
                    a2.a((BankAccountDetails.BankAccount) obj);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upi.registration.view.SignUpSetMpinBankAdapter");
        }
    }

    public final void a(int i2) {
        int i3 = R.string.upi_keep_card_handy;
        BankAccountDetails.BankAccount bankAccount = this.f69028h.get(i2);
        k.a((Object) bankAccount, "profileBankList.get(position)");
        String string = getString(i3, bankAccount.getBankName());
        k.a((Object) string, "getString(R.string.upi_k…t.get(position).bankName)");
        CharSequence charSequence = string;
        int a2 = !TextUtils.isEmpty(charSequence) ? kotlin.m.p.a(charSequence, " ", 0, false, 6) : 0;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        int c2 = androidx.core.content.b.c(activity, R.color.color_506d85);
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(c2), 0, a2, 33);
        Spannable spannable = spannableString;
        TextView textView = this.f69024d;
        if (textView == null) {
            k.a("tvImpNote");
        }
        textView.setText(spannable);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(c.f69030a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f69030a = new c();

        c() {
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

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        if (!jVar.h() && !jVar.i()) {
            super.show(jVar, str);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f69029i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

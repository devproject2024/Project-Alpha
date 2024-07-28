package net.one97.paytm.moneytransfer.view.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.IJRPaytmDataModel;
import io.reactivex.rxjava3.d.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.a.d;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferUserHistoryActivity;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransfer.viewmodel.g;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class s extends net.one97.paytm.i.h implements View.OnClickListener, d.b {

    /* renamed from: a  reason: collision with root package name */
    Dialog f54630a;

    /* renamed from: b  reason: collision with root package name */
    private TextWatcher f54631b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.moneytransfer.view.a.d f54632c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.moneytransfer.viewmodel.g f54633d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<BeneficiaryEntity> f54634e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private EditText f54635f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f54636g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f54637h;

    /* renamed from: i  reason: collision with root package name */
    private Integer f54638i = 0;
    private ImageView j;
    /* access modifiers changed from: private */
    public final io.reactivex.rxjava3.j.b<String> k;
    private final long l;
    /* access modifiers changed from: private */
    public ImageView m;
    /* access modifiers changed from: private */
    public BeneficiaryEntity n;
    private io.reactivex.rxjava3.b.c o;
    private HashMap p;

    static final class d<T> implements q<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f54642a = new d();

        d() {
        }

        public final /* bridge */ /* synthetic */ boolean test(Object obj) {
            return true;
        }
    }

    public static final /* synthetic */ void a() {
    }

    static final class a<T> implements z<net.one97.paytm.moneytransfer.model.c<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f54639a;

        a(s sVar) {
            this.f54639a = sVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            UpiCustomVolleyError upiCustomVolleyError = null;
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = t.f54649a[dVar.ordinal()];
                if (i2 == 1) {
                    s sVar = this.f54639a;
                    if (sVar.f54630a == null) {
                        sVar.f54630a = UpiAppUtils.getWalletStyleProgressDialog(sVar.getActivity());
                    }
                    Dialog dialog = sVar.f54630a;
                    if (dialog != null && !dialog.isShowing()) {
                        dialog.show();
                    }
                } else if (i2 == 2) {
                    s.d(this.f54639a);
                } else if (i2 == 3) {
                    s sVar2 = this.f54639a;
                    if (cVar != null) {
                        upiCustomVolleyError = cVar.f54034c;
                    }
                    s.a(sVar2, upiCustomVolleyError);
                }
            }
        }
    }

    static final class b<T> implements z<net.one97.paytm.moneytransfer.model.c<ArrayList<BeneficiaryEntity>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f54640a;

        b(s sVar) {
            this.f54640a = sVar;
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
                int i2 = t.f54650b[dVar.ordinal()];
                if (i2 == 1) {
                    s.a();
                } else if (i2 == 2) {
                    s sVar = this.f54640a;
                    ResultType resulttype = cVar.f54033b;
                    if (resulttype == null) {
                        k.a();
                    }
                    s.a(sVar, (ArrayList) resulttype);
                } else if (i2 == 3) {
                    s.b(this.f54640a, cVar.f54034c);
                }
            }
        }
    }

    static final class e<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f54643a = new e();

        e() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str = (String) obj;
            k.a((Object) str, "it");
            if (str != null) {
                String lowerCase = str.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                if (lowerCase != null) {
                    return p.b(lowerCase).toString();
                }
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
    }

    static final class f<T> implements io.reactivex.rxjava3.d.g<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f54644a;

        f(s sVar) {
            this.f54644a = sVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            Filter filter;
            CharSequence charSequence = (String) obj;
            if (!TextUtils.isEmpty(charSequence)) {
                net.one97.paytm.moneytransfer.view.a.d f2 = this.f54644a.f54632c;
                if (f2 != null && (filter = f2.getFilter()) != null) {
                    filter.filter(charSequence);
                    return;
                }
                return;
            }
            this.f54644a.c();
        }
    }

    public s() {
        io.reactivex.rxjava3.j.b<String> a2 = io.reactivex.rxjava3.j.b.a();
        k.a((Object) a2, "PublishSubject.create()");
        this.k = a2;
        this.l = 100;
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.iv_back) {
            b();
        }
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.iv_back;
        if (valueOf != null && valueOf.intValue() == i2) {
            b();
            return;
        }
        int i3 = R.id.iv_cross_search;
        if (valueOf != null && valueOf.intValue() == i3) {
            c();
        }
    }

    public final void onCreate(Bundle bundle) {
        int i2;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f54638i = Integer.valueOf(arguments.getInt("beneficiary_offset"));
            i2 = arguments.getInt("beneficiary_total_count");
            Serializable serializable = arguments.getSerializable("beneficiary_list_page_1");
            if (serializable != null) {
                this.f54634e = (ArrayList) serializable;
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity> /* = java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity> */");
            }
        } else {
            i2 = -1;
        }
        this.f54633d = (net.one97.paytm.moneytransfer.viewmodel.g) am.a((Fragment) this).a(net.one97.paytm.moneytransfer.viewmodel.g.class);
        net.one97.paytm.moneytransfer.viewmodel.g gVar = this.f54633d;
        if (gVar != null) {
            gVar.f54758c = i2;
            gVar.a((List<? extends BeneficiaryEntity>) this.f54634e);
            if (i2 > 25) {
                gVar.a(25);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.mt_viewall_beneficiary_fragmenet, viewGroup, false);
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f54641a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        c(s sVar) {
            this.f54641a = sVar;
        }

        public final void afterTextChanged(Editable editable) {
            this.f54641a.k.onNext(String.valueOf(editable));
            String valueOf = String.valueOf(editable);
            if (valueOf == null) {
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            } else if (!TextUtils.isEmpty(p.b(valueOf).toString())) {
                ImageView b2 = this.f54641a.m;
                if (b2 != null) {
                    b2.setVisibility(0);
                }
            } else {
                this.f54641a.c();
            }
        }
    }

    public final void a(BeneficiaryEntity beneficiaryEntity) {
        k.c(beneficiaryEntity, "entity");
        this.n = beneficiaryEntity;
        if (this.n != null) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.confirm_delete_bottom_sheet, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.recent_delete_btn);
            TextView textView2 = (TextView) inflate.findViewById(R.id.recent_cancel_btn);
            inflate.findViewById(R.id.delete_message);
            x.e eVar = new x.e();
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            eVar.element = new com.google.android.material.bottomsheet.a(activity);
            ((com.google.android.material.bottomsheet.a) eVar.element).setContentView(inflate);
            ((com.google.android.material.bottomsheet.a) eVar.element).setCancelable(false);
            ((com.google.android.material.bottomsheet.a) eVar.element).setCanceledOnTouchOutside(false);
            k.a((Object) inflate, "bottomSheetView");
            ViewParent parent = inflate.getParent();
            if (parent != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from((View) parent);
                k.a((Object) from, "BottomSheetBehavior.from…SheetView.parent as View)");
                from.setState(3);
                ((com.google.android.material.bottomsheet.a) eVar.element).show();
                ((com.google.android.material.bottomsheet.a) eVar.element).setOnDismissListener(new g(from));
                textView.setOnClickListener(new h(this, eVar));
                textView2.setOnClickListener(new i(eVar));
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.View");
        }
    }

    public final void b(BeneficiaryEntity beneficiaryEntity) {
        String str;
        String str2;
        String str3;
        k.c(beneficiaryEntity, "entity");
        if (com.paytm.utility.a.m(getContext())) {
            String str4 = "";
            if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
                str4 = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountHolderName;
                str3 = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.bankName;
                String str5 = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber;
                str2 = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.ifscCode;
                str = str5;
            } else if (beneficiaryEntity.instrumentPreferences.upi != null) {
                String str6 = beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail.accountHolderName;
                str = beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail.vpa;
                str2 = str4;
                str4 = str6;
                str3 = str2;
            } else {
                str = str4;
                str3 = str;
                str2 = str3;
            }
            Intent intent = new Intent(getActivity(), MoneyTransferUserHistoryActivity.class);
            intent.putExtra("account_holder_name", str4);
            intent.putExtra(PayUtility.BANK_NAME, str3);
            intent.putExtra(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, str);
            intent.putExtra("ifsc_code", str2);
            startActivity(intent);
            return;
        }
        m.d((Activity) getActivity());
    }

    static final class g implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f54645a;

        g(BottomSheetBehavior bottomSheetBehavior) {
            this.f54645a = bottomSheetBehavior;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f54645a.setState(4);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f54646a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f54647b;

        h(s sVar, x.e eVar) {
            this.f54646a = sVar;
            this.f54647b = eVar;
        }

        public final void onClick(View view) {
            if (com.paytm.utility.a.m(this.f54646a.getContext())) {
                ((com.google.android.material.bottomsheet.a) this.f54647b.element).dismiss();
                s sVar = this.f54646a;
                s.a(sVar, sVar.n);
                return;
            }
            com.paytm.utility.b.b((Context) this.f54646a.getActivity(), this.f54646a.getString(R.string.no_connection), this.f54646a.getString(R.string.no_internet));
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f54648a;

        i(x.e eVar) {
            this.f54648a = eVar;
        }

        public final void onClick(View view) {
            ((com.google.android.material.bottomsheet.a) this.f54648a.element).dismiss();
        }
    }

    private final void b() {
        j supportFragmentManager;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            Boolean valueOf = activity != null ? Boolean.valueOf(activity.isFinishing()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (!valueOf.booleanValue()) {
                UpiAppUtils.hideKeyboard(getActivity());
                FragmentActivity activity2 = getActivity();
                if (activity2 != null && (supportFragmentManager = activity2.getSupportFragmentManager()) != null) {
                    supportFragmentManager.d();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        EditText editText = this.f54635f;
        if (editText != null) {
            editText.removeTextChangedListener(this.f54631b);
        }
        EditText editText2 = this.f54635f;
        if (editText2 != null) {
            editText2.setText("");
        }
        EditText editText3 = this.f54635f;
        if (editText3 != null) {
            editText3.addTextChangedListener(this.f54631b);
        }
        net.one97.paytm.moneytransfer.view.a.d dVar = this.f54632c;
        if (dVar != null) {
            dVar.a("");
        }
        net.one97.paytm.moneytransfer.view.a.d dVar2 = this.f54632c;
        if (dVar2 != null) {
            dVar2.a(this.f54634e);
        }
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        a(false);
    }

    public final void a(boolean z) {
        if (z) {
            TextView textView = this.f54636g;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.f54636g;
            if (textView2 != null) {
                int i2 = R.string.mt_no_beneficiary_searched;
                Object[] objArr = new Object[1];
                EditText editText = this.f54635f;
                objArr[0] = editText != null ? editText.getText() : null;
                textView2.setText(getString(i2, objArr));
                return;
            }
            return;
        }
        TextView textView3 = this.f54636g;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    private void d() {
        Dialog dialog = this.f54630a;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public final void a(UpiDBTransactionModel upiDBTransactionModel) {
        String str;
        k.c(upiDBTransactionModel, "upiDBTransactionModel");
        Bundle bundle = new Bundle();
        if (com.paytm.utility.b.X(upiDBTransactionModel.getTxn_mode())) {
            bundle.putBoolean("isVPA", true);
            bundle.putString("vpa", upiDBTransactionModel.getTxn_mode());
            bundle.putString("username", upiDBTransactionModel.getBeneficiary_name());
            str = "upi";
        } else {
            bundle.putBoolean("isVPA", false);
            bundle.putString("vpa", upiDBTransactionModel.getTxn_mode());
            bundle.putString("username", upiDBTransactionModel.getBeneficiary_name());
            bundle.putString("ifsc", upiDBTransactionModel.getIfsc());
            bundle.putString("bankname", upiDBTransactionModel.getBank_name());
            str = "bank_account";
        }
        String str2 = str;
        bundle.putInt("source_of_initiation", MoneyTransferV3Activity.c.BENEFICIARY_LIST.ordinal());
        FragmentActivity activity = getActivity();
        m.a(bundle, activity != null ? activity.getSupportFragmentManager() : null, R.id.fragmentContainer);
        net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, Events.Action.PROCEED_CLICKED, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, str2, "saved_account");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        LiveData liveData;
        LiveData liveData2;
        k.c(view, "view");
        this.f54635f = (EditText) view.findViewById(R.id.et_search);
        this.f54636g = (TextView) view.findViewById(R.id.tv_error);
        this.f54637h = (RecyclerView) view.findViewById(R.id.rv_beneficiaryList);
        this.f54632c = new net.one97.paytm.moneytransfer.view.a.d(this.f54634e);
        net.one97.paytm.moneytransfer.view.a.d dVar = this.f54632c;
        if (dVar != null) {
            d.b bVar = this;
            k.c(bVar, "listener");
            dVar.f54240b = bVar;
        }
        net.one97.paytm.moneytransfer.view.a.d dVar2 = this.f54632c;
        if (dVar2 != null) {
            ArrayList<BeneficiaryEntity> arrayList = this.f54634e;
            k.c(arrayList, "originalList");
            dVar2.f54239a = arrayList;
        }
        RecyclerView recyclerView = this.f54637h;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        RecyclerView recyclerView2 = this.f54637h;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f54632c);
        }
        this.j = (ImageView) view.findViewById(R.id.iv_back);
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.m = (ImageView) view.findViewById(R.id.iv_cross_search);
        ImageView imageView2 = this.m;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        io.reactivex.rxjava3.b.c subscribe = this.k.debounce(this.l, TimeUnit.MILLISECONDS).distinctUntilChanged().observeOn(io.reactivex.rxjava3.android.b.a.a()).filter(d.f54642a).subscribeOn(io.reactivex.rxjava3.i.a.b()).map(e.f54643a).subscribe(new f(this));
        k.a((Object) subscribe, "subject.debounce(QUERY_T…hBox();\n                }");
        this.o = subscribe;
        this.f54631b = new c(this);
        EditText editText = this.f54635f;
        if (editText != null) {
            editText.addTextChangedListener(this.f54631b);
        }
        m.a(this.f54635f, (Activity) getActivity());
        net.one97.paytm.moneytransfer.viewmodel.g gVar = this.f54633d;
        if (!(gVar == null || (liveData2 = gVar.f54756a) == null)) {
            liveData2.observe(this, new a(this));
        }
        net.one97.paytm.moneytransfer.viewmodel.g gVar2 = this.f54633d;
        if (gVar2 != null && (liveData = gVar2.f54759d) != null) {
            liveData.observe(this, new b(this));
        }
    }

    public static final /* synthetic */ void d(s sVar) {
        Filter filter;
        sVar.d();
        BeneficiaryEntity beneficiaryEntity = sVar.n;
        if (beneficiaryEntity != null) {
            net.one97.paytm.moneytransfer.utils.f.a(sVar.getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_DELETE_SAVED_BANK, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "", "");
            if (beneficiaryEntity != null) {
                try {
                    String str = beneficiaryEntity.beneficiaryId;
                    Intent intent = new Intent("action_delete_beneficiary");
                    intent.putExtra("beneficiary_identifier", str);
                    FragmentActivity activity = sVar.getActivity();
                    if (activity != null) {
                        k.a((Object) activity, "it");
                        androidx.localbroadcastmanager.a.a.a(activity.getApplicationContext()).a(intent);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                int indexOf = sVar.f54634e.indexOf(beneficiaryEntity);
                sVar.f54634e.remove(indexOf);
                EditText editText = sVar.f54635f;
                if (!TextUtils.isEmpty(String.valueOf(editText != null ? editText.getText() : null))) {
                    net.one97.paytm.moneytransfer.view.a.d dVar = sVar.f54632c;
                    if (!(dVar == null || (filter = dVar.getFilter()) == null)) {
                        EditText editText2 = sVar.f54635f;
                        filter.filter(String.valueOf(editText2 != null ? editText2.getText() : null));
                    }
                } else {
                    net.one97.paytm.moneytransfer.view.a.d dVar2 = sVar.f54632c;
                    if (dVar2 != null) {
                        dVar2.notifyItemRemoved(indexOf);
                    }
                }
                sVar.n = null;
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity");
        }
    }

    public static final /* synthetic */ void a(s sVar, UpiCustomVolleyError upiCustomVolleyError) {
        sVar.d();
        if (upiCustomVolleyError == null) {
            com.paytm.utility.b.a((Context) sVar.getActivity(), sVar.getResources().getString(R.string.error), sVar.getResources().getString(R.string.some_went_wrong));
        } else if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getMessage(), true) || p.a("410", upiCustomVolleyError.getMessage(), true)) {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            FragmentActivity activity = sVar.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            b2.a((Activity) activity, MoneyTransferV3Activity.class.getSimpleName());
        } else {
            com.paytm.utility.b.b((Context) sVar.getActivity(), sVar.getString(R.string.error), upiCustomVolleyError.getAlertMessage());
        }
    }

    public static final /* synthetic */ void a(s sVar, ArrayList arrayList) {
        net.one97.paytm.moneytransfer.view.a.d dVar = sVar.f54632c;
        if (dVar == null) {
            k.a();
        }
        k.c(arrayList, "data");
        ArrayList<BeneficiaryEntity> arrayList2 = dVar.f54241c;
        if (arrayList2 == null) {
            k.a();
        }
        int size = arrayList2.size();
        ArrayList<BeneficiaryEntity> arrayList3 = dVar.f54241c;
        if (arrayList3 == null) {
            k.a();
        }
        arrayList3.addAll(arrayList);
        ArrayList<BeneficiaryEntity> arrayList4 = dVar.f54241c;
        if (arrayList4 == null) {
            k.a();
        }
        dVar.notifyItemRangeChanged(size, arrayList4.size());
    }

    public static final /* synthetic */ void b(s sVar, UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            return;
        }
        if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getMessage(), true) || p.a("410", upiCustomVolleyError.getMessage(), true)) {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            FragmentActivity activity = sVar.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            b2.a((Activity) activity, MoneyTransferV3Activity.class.getSimpleName());
        }
    }

    public static final /* synthetic */ void a(s sVar, BeneficiaryEntity beneficiaryEntity) {
        String str;
        net.one97.paytm.moneytransfer.viewmodel.g gVar;
        if (beneficiaryEntity != null) {
            String str2 = beneficiaryEntity.beneficiaryId;
            k.a((Object) str2, "(entity as BeneficiaryEntity).beneficiaryId");
            boolean z = false;
            if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
                str = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).uuid;
                k.a((Object) str, "entity.instrumentPrefere…therBank.accounts[0].uuid");
            } else if (beneficiaryEntity.instrumentPreferences.upi != null) {
                str = beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).uuid;
                k.a((Object) str, "entity.instrumentPreferences.upi.accounts[0].uuid");
                z = true;
            } else {
                str = "";
            }
            if (com.paytm.utility.a.m(sVar.getActivity()) && (gVar = sVar.f54633d) != null) {
                k.c(str, "uuid");
                k.c(str2, "beneficiaryId");
                y<net.one97.paytm.moneytransfer.model.c<IJRPaytmDataModel>> yVar = gVar.f54756a;
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                yVar.setValue(c.a.a());
                gVar.f54757b.a((a.C0960a) new g.a(gVar, str, str2), str, str2, z);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.p;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

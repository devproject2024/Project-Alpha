package net.one97.paytm.upi.registration.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.google.android.material.appbar.AppBarLayout;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.d.q;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.awareness.view.AwarenessSelectBankActivity;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.registration.a.a;
import net.one97.paytm.upi.registration.view.a;
import net.one97.paytm.upi.registration.view.c;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class b extends h implements View.OnClickListener, a.b, a.c, c.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f68799a = true;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a.C1387a f68800b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressBar f68801c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f68802d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f68803e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f68804f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f68805g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f68806h;

    /* renamed from: i  reason: collision with root package name */
    private ConstraintLayout f68807i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private EditText n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    /* access modifiers changed from: private */
    public ImageView r;
    /* access modifiers changed from: private */
    public io.reactivex.rxjava3.j.b<String> s = io.reactivex.rxjava3.j.b.a();
    private long t = 100;
    private io.reactivex.rxjava3.b.c u;
    private TextWatcher v;
    private boolean w;
    /* access modifiers changed from: private */
    public AppBarLayout x;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.f68800b = (a.C1387a) obj;
    }

    public static b d() {
        return new b();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_acc_provider, viewGroup, false);
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "screen_open", "", "", "", GAConstants.SCREEN_NAME.BANK_LIST_SCREEN, "wallet");
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, "screen_open", "", "", "", GAConstants.SCREEN_NAME.UPI_ADD_NEW_BANK, "");
        getActivity().getWindow().setSoftInputMode(2);
        this.f68801c = (ProgressBar) inflate.findViewById(R.id.pb_progress);
        this.f68802d = (RecyclerView) inflate.findViewById(R.id.rv_bank_list);
        this.f68803e = (RecyclerView) inflate.findViewById(R.id.gridRecycler);
        this.f68804f = (LinearLayout) inflate.findViewById(R.id.ll_error_container);
        this.f68805g = (LinearLayout) inflate.findViewById(R.id.ll_empty_container_upi);
        this.j = (TextView) this.f68804f.findViewById(R.id.tv_error_msg);
        this.k = (TextView) this.f68804f.findViewById(R.id.tv_retry);
        this.l = (TextView) inflate.findViewById(R.id.tv_skip);
        this.n = (EditText) inflate.findViewById(R.id.et_search);
        this.o = (ImageView) inflate.findViewById(R.id.iv_cross_search);
        this.p = (ImageView) inflate.findViewById(R.id.iv_back);
        this.q = (ImageView) inflate.findViewById(R.id.iv_search_back);
        this.r = (ImageView) inflate.findViewById(R.id.iv_search);
        this.m = (TextView) inflate.findViewById(R.id.tv_title);
        this.x = (AppBarLayout) inflate.findViewById(R.id.appBar);
        this.f68806h = (RelativeLayout) inflate.findViewById(R.id.rl_search_box);
        this.f68807i = (ConstraintLayout) inflate.findViewById(R.id.cl_banks_layout);
        this.m.setText(getString(R.string.upi_select_bank_linked_to, UpiAppUtils.getMobile(getActivity())));
        this.f68804f.setVisibility(8);
        if (getArguments() != null) {
            this.w = getArguments().getBoolean(UpiConstants.EXTRA_UPI_SHOW_DO_IT_LATER, false);
        }
        if (this.w) {
            this.l.setVisibility(0);
            this.l.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (b.this.isAdded()) {
                        b.this.getActivity().setResult(0);
                        b.this.getActivity().finish();
                    }
                }
            });
        }
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.f68800b.a();
            }
        });
        this.o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, "");
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CJRSendGTMTag.sendNewCustomGTMEvents(b.this.getContext(), GAConstants.CATEGORY.UPI_ONB_V1, Events.Action.BACK_ARROW_CLICKED, "", "", "", GAConstants.SCREEN_NAME.BANK_LIST_SCREEN, "wallet");
                b.this.getActivity().finish();
            }
        });
        this.q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.x.setExpanded(true, true);
                b.a(b.this, "");
            }
        });
        this.r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CJRSendGTMTag.sendNewCustomGTMEvents(b.this.getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "search_icon_clicked", "", "", "", GAConstants.SCREEN_NAME.BANK_LIST_SCREEN, "wallet");
                b.this.x.setExpanded(false);
            }
        });
        this.x.a((AppBarLayout.b) new AppBarLayout.b() {
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                if (Math.abs(i2) - appBarLayout.getTotalScrollRange() != 0) {
                    b.this.f68806h.setVisibility(8);
                    if (b.this.f68802d.getVisibility() == 0) {
                        b.this.r.setVisibility(0);
                    }
                    UpiAppUtils.hideKeyboard(b.this.getActivity());
                } else if (b.this.f68806h.getVisibility() != 0) {
                    b.this.f68806h.setVisibility(0);
                    b.d(b.this);
                }
            }
        });
        this.u = this.s.debounce(this.t, TimeUnit.MILLISECONDS).distinctUntilChanged().observeOn(io.reactivex.rxjava3.android.b.a.a()).filter(new q<String>() {
            public final /* bridge */ /* synthetic */ boolean test(Object obj) throws Throwable {
                return true;
            }
        }).subscribeOn(io.reactivex.rxjava3.i.a.b()).map(new io.reactivex.rxjava3.d.h<String, Object>() {
            public final /* synthetic */ Object apply(Object obj) throws Throwable {
                return ((String) obj).toLowerCase().trim();
            }
        }).subscribe(new g<Object>() {
            public final void accept(Object obj) throws Exception {
                if (obj instanceof String) {
                    b.a(b.this, (String) obj);
                }
            }
        });
        this.v = new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                b.this.s.onNext(charSequence.toString());
            }
        };
        this.n.addTextChangedListener(this.v);
        this.f68802d.setHasFixedSize(true);
        this.f68802d.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f68802d.setAdapter(new a(getActivity(), this));
        if (!this.f68799a) {
            this.f68801c.setVisibility(8);
        }
        if (UpiUtils.isPaytmFirstApp()) {
            inflate.findViewById(R.id.motif_iv).setVisibility(8);
        }
        return inflate;
    }

    public void onClick(View view) {
        view.getId();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.n, 1);
                getActivity().getWindow().setSoftInputMode(20);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f68800b.e();
    }

    public final boolean c() {
        return isAdded();
    }

    public final void a() {
        if (this.f68799a) {
            this.f68801c.setVisibility(0);
        } else {
            this.f68801c.setVisibility(8);
        }
        this.f68804f.setVisibility(8);
        this.f68802d.setVisibility(8);
        this.f68805g.setVisibility(8);
        this.r.setVisibility(8);
        this.f68807i.setVisibility(8);
    }

    public final void a(List<UpiBaseDataModel> list) {
        this.f68802d.setVisibility(0);
        this.f68804f.setVisibility(8);
        this.f68801c.setVisibility(8);
        this.f68805g.setVisibility(8);
        this.r.setVisibility(0);
        a aVar = (a) this.f68802d.getAdapter();
        aVar.f68787a = list;
        aVar.notifyDataSetChanged();
    }

    public final void b(List<AccountProviderBody.AccountProvider> list) {
        this.f68804f.setVisibility(8);
        this.f68801c.setVisibility(8);
        this.f68805g.setVisibility(8);
        this.f68807i.setVisibility(0);
        if (list != null) {
            this.f68803e.setAdapter(new c(list, this));
            this.f68803e.setLayoutManager(new GridLayoutManager(getContext(), 4));
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        this.f68804f.setVisibility(0);
        this.f68801c.setVisibility(8);
        this.f68802d.setVisibility(8);
        this.f68805g.setVisibility(8);
        this.r.setVisibility(8);
        this.f68807i.setVisibility(8);
        if (upiCustomVolleyError != null) {
            String str = upiCustomVolleyError.getmErrorCode();
            if (TextUtils.isEmpty(str) || !UpiConstants.NETWORK_ERROR_CODE.equals(str)) {
                this.j.setText(R.string.upi_some_went_wrong);
            } else {
                this.j.setText(R.string.check_your_network);
            }
        } else {
            this.j.setText(R.string.upi_some_went_wrong);
        }
    }

    public final void b() {
        this.f68805g.setVisibility(0);
        this.f68804f.setVisibility(8);
        this.f68801c.setVisibility(8);
        this.f68802d.setVisibility(8);
    }

    public final void b(AccountProviderBody.AccountProvider accountProvider) {
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "bank_icon_clicked", accountProvider.getAccountProvider(), "", "", GAConstants.SCREEN_NAME.BANK_LIST_SCREEN, "wallet");
        if (getActivity() != null && (getActivity() instanceof AccountProviderActivity)) {
            UpiAppUtils.hideKeyboard(getActivity());
            Intent intent = new Intent();
            intent.putExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER, accountProvider);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
        if (getActivity() != null && (getActivity() instanceof AwarenessSelectBankActivity)) {
            ((AwarenessSelectBankActivity) getActivity()).a(accountProvider);
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        b(accountProvider);
    }

    public void onDetach() {
        super.onDetach();
        io.reactivex.rxjava3.b.c cVar = this.u;
        if (cVar != null) {
            cVar.dispose();
        }
        this.f68800b.f();
    }

    public final void c(List<UpiBaseDataModel> list) {
        a aVar = (a) this.f68802d.getAdapter();
        if (aVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f68787a);
            arrayList.addAll(0, list);
            h.b a2 = androidx.recyclerview.widget.h.a(new a.C1395a(aVar.f68787a, arrayList));
            aVar.f68787a = arrayList;
            a2.a((RecyclerView.a) aVar);
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                b.this.f68802d.smoothScrollToPosition(0);
            }
        }, 200);
    }

    public final void a(int i2, AccountProviderBody.AccountProvider accountProvider) {
        if (isAdded() && getActivity() != null) {
            this.f68800b.a(i2);
            CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, GAConstants.ACTION.TOP_BANK_SELECTED, accountProvider.getAccountProvider(), "", "", GAConstants.SCREEN_NAME.UPI_ADD_NEW_BANK, "");
        }
    }

    static /* synthetic */ void a(b bVar, String str) {
        if (!TextUtils.isEmpty(str.trim())) {
            bVar.o.setVisibility(0);
        } else {
            bVar.n.removeTextChangedListener(bVar.v);
            bVar.n.setText("");
            bVar.n.addTextChangedListener(bVar.v);
            bVar.o.setVisibility(8);
            bVar.f68804f.setVisibility(8);
            bVar.f68801c.setVisibility(8);
            bVar.f68805g.setVisibility(8);
        }
        bVar.f68800b.a(str.trim());
    }

    static /* synthetic */ void d(b bVar) {
        bVar.n.requestFocus();
        bVar.n.postDelayed(new Runnable() {
            public final void run() {
                b.this.e();
            }
        }, 100);
    }
}

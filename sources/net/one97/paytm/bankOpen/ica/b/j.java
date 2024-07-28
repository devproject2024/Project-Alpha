package net.one97.paytm.bankOpen.ica.b;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.google.android.material.textfield.TextInputEditText;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.ica.view.stepview.BankStepsView;
import net.one97.paytm.common.entity.CJRAadharPanDocList;
import net.one97.paytm.common.entity.CJRAadharPanGet;

public final class j extends e {

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.bankOpen.ica.d.c f16552b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.bankCommon.f.d f16553c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f16554d;

    public final View a(int i2) {
        if (this.f16554d == null) {
            this.f16554d = new HashMap();
        }
        View view = (View) this.f16554d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f16554d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void f() {
        HashMap hashMap = this.f16554d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        f();
    }

    static final class a<T> implements z<net.one97.paytm.bankCommon.b.c<? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f16555a;

        a(j jVar) {
            this.f16555a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List<CJRAadharPanDocList> documents;
            net.one97.paytm.bankCommon.b.c cVar = (net.one97.paytm.bankCommon.b.c) obj;
            if (cVar == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.api.Resource<kotlin.Any>");
            } else if (cVar == null) {
            } else {
                if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS) {
                    T t = cVar.f16217b;
                    if (t != null) {
                        CJRAadharPanGet cJRAadharPanGet = (CJRAadharPanGet) t;
                        if (cJRAadharPanGet.getDocuments() != null && (documents = cJRAadharPanGet.getDocuments()) != null) {
                            for (int i2 = 0; i2 < documents.size(); i2++) {
                                CJRAadharPanDocList cJRAadharPanDocList = documents.get(i2);
                                k.a((Object) cJRAadharPanDocList, "doclist[i]");
                                if (cJRAadharPanDocList.getDocCode() != null) {
                                    CJRAadharPanDocList cJRAadharPanDocList2 = documents.get(i2);
                                    k.a((Object) cJRAadharPanDocList2, "doclist[i]");
                                    if (p.a(cJRAadharPanDocList2.getDocCode(), "pan", true)) {
                                        CJRAadharPanDocList cJRAadharPanDocList3 = documents.get(i2);
                                        k.a((Object) cJRAadharPanDocList3, "doclist.get(i)");
                                        if (!TextUtils.isEmpty(cJRAadharPanDocList3.getDocValue())) {
                                            CJRAadharPanDocList cJRAadharPanDocList4 = documents.get(i2);
                                            k.a((Object) cJRAadharPanDocList4, "doclist.get(i)");
                                            ((TextInputEditText) this.f16555a.a(R.id.pan_et)).setText(cJRAadharPanDocList4.getDocValue());
                                            TextInputEditText textInputEditText = (TextInputEditText) this.f16555a.a(R.id.pan_et);
                                            k.a((Object) textInputEditText, "pan_et");
                                            textInputEditText.setEnabled(false);
                                        }
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRAadharPanGet");
                } else if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.ERROR) {
                    Throwable th = cVar.f16218c;
                    if (th != null) {
                        NetworkCustomError networkCustomError = (NetworkCustomError) th;
                        f.a(this.f16555a.getContext(), networkCustomError, networkCustomError.getStatusCode());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.bankOpen.ica.d.c b(j jVar) {
        net.one97.paytm.bankOpen.ica.d.c cVar = jVar.f16552b;
        if (cVar == null) {
            k.a("viewModel");
        }
        return cVar;
    }

    public static final /* synthetic */ net.one97.paytm.bankCommon.f.d c(j jVar) {
        net.one97.paytm.bankCommon.f.d dVar = jVar.f16553c;
        if (dVar == null) {
            k.a("fragmentActionListener");
        }
        return dVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pb_ca_acc_pan_fragment, viewGroup, false);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof net.one97.paytm.bankCommon.f.d) {
            this.f16553c = (net.one97.paytm.bankCommon.f.d) context;
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.iv_back_arrow);
        if (findViewById != null) {
            if (findViewById != null) {
                findViewById.setOnClickListener(new b(this));
            }
            ((BankStepsView) a(R.id.stepsViewBank)).a(R.color.gray, R.color.dark_blue, R.color.paytm_primary_color, R.color.gray);
            ((BankStepsView) a(R.id.stepsViewBank)).setSteps(4, 1);
            ((Button) a(R.id.proced_button)).setOnClickListener(new c(this));
            ((ImageView) a(R.id.iv_back_arrow)).setOnClickListener(new d(this));
            ai a2 = am.a((Fragment) this).a(net.one97.paytm.bankOpen.ica.d.c.class);
            k.a((Object) a2, "ViewModelProviders.of(th…PanViewModel::class.java)");
            this.f16552b = (net.one97.paytm.bankOpen.ica.d.c) a2;
            g();
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f16556a;

        b(j jVar) {
            this.f16556a = jVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f16556a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f16557a;

        c(j jVar) {
            this.f16557a = jVar;
        }

        public final void onClick(View view) {
            if (j.a(this.f16557a)) {
                com.paytm.utility.b.k(this.f16557a.getContext(), this.f16557a.getString(R.string.please_wait));
                j.b(this.f16557a);
                TextInputEditText textInputEditText = (TextInputEditText) this.f16557a.a(R.id.pan_et);
                k.a((Object) textInputEditText, "pan_et");
                net.one97.paytm.bankOpen.ica.d.c.a(String.valueOf(textInputEditText.getText())).observe(this.f16557a, new z<net.one97.paytm.bankCommon.b.c<? extends Object>>(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ c f16558a;

                    {
                        this.f16558a = r1;
                    }

                    public final /* synthetic */ void onChanged(Object obj) {
                        net.one97.paytm.bankCommon.b.c cVar = (net.one97.paytm.bankCommon.b.c) obj;
                        com.paytm.utility.b.Z(this.f16558a.f16557a.getContext());
                        if (cVar == null) {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.api.Resource<kotlin.Any>");
                        } else if (cVar == null) {
                        } else {
                            if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS) {
                                net.one97.paytm.bankCommon.f.d c2 = j.c(this.f16558a.f16557a);
                                TextInputEditText textInputEditText = (TextInputEditText) this.f16558a.f16557a.a(R.id.pan_et);
                                k.a((Object) textInputEditText, "pan_et");
                                c2.onFragmentAction(100, String.valueOf(textInputEditText.getText()));
                            } else if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.ERROR) {
                                Throwable th = cVar.f16218c;
                                if (th != null) {
                                    NetworkCustomError networkCustomError = (NetworkCustomError) th;
                                    f.a(this.f16558a.f16557a.getContext(), networkCustomError, networkCustomError.getStatusCode());
                                    return;
                                }
                                throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                            }
                        }
                    }
                });
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f16559a;

        d(j jVar) {
            this.f16559a = jVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f16559a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    private final void g() {
        if (this.f16552b == null) {
            k.a("viewModel");
        }
        net.one97.paytm.bankOpen.ica.d.c.a().observe(this, new a(this));
    }

    public static final /* synthetic */ boolean a(j jVar) {
        TextInputEditText textInputEditText = (TextInputEditText) jVar.a(R.id.pan_et);
        k.a((Object) textInputEditText, "pan_et");
        if (textInputEditText.isEnabled()) {
            TextInputEditText textInputEditText2 = (TextInputEditText) jVar.a(R.id.pan_et);
            k.a((Object) textInputEditText2, "pan_et");
            Editable text = textInputEditText2.getText();
            if (text == null) {
                k.a();
            }
            if (text.length() != 10) {
                return false;
            }
        }
        TextInputEditText textInputEditText3 = (TextInputEditText) jVar.a(R.id.pan_et);
        k.a((Object) textInputEditText3, "pan_et");
        if (!textInputEditText3.isEnabled()) {
            TextInputEditText textInputEditText4 = (TextInputEditText) jVar.a(R.id.pan_et);
            k.a((Object) textInputEditText4, "pan_et");
            Editable text2 = textInputEditText4.getText();
            if (text2 == null) {
                k.a();
            }
            k.a((Object) text2, "pan_et.text!!");
            if (text2.length() == 0) {
                jVar.g();
                return false;
            }
        }
        return true;
    }
}

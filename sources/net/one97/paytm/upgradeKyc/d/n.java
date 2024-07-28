package net.one97.paytm.upgradeKyc.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.aa;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRAadharPanSave;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.upgradeKyc.DocData;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.d.m;
import net.one97.paytm.upgradeKyc.helper.e;

public final class n extends net.one97.paytm.i.f implements View.OnClickListener, net.one97.paytm.common.widgets.a.d {

    /* renamed from: d  reason: collision with root package name */
    public static final a f65716d = new a((byte) 0);
    /* access modifiers changed from: private */
    public static String o = "MinKYCBottomSheetTag";

    /* renamed from: a  reason: collision with root package name */
    public b f65717a;

    /* renamed from: b  reason: collision with root package name */
    public String f65718b;

    /* renamed from: c  reason: collision with root package name */
    public String f65719c;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.kycV3.c.l f65720e;

    /* renamed from: f  reason: collision with root package name */
    private BottomSheetBehavior<?> f65721f;

    /* renamed from: g  reason: collision with root package name */
    private final TextWatcher f65722g = new d(this);

    /* renamed from: h  reason: collision with root package name */
    private final TextWatcher f65723h = new e(this);

    /* renamed from: i  reason: collision with root package name */
    private final TextWatcher f65724i = new k(this);
    private c j = new c(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCTncAccept>> k = new l(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> l = new i(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> m = new m(this);
    private net.one97.paytm.upgradeKyc.minkycotp.d n = new h(this);
    private HashMap p;

    public interface b {
        void d();

        void e();

        void f();
    }

    public final View a(int i2) {
        if (this.p == null) {
            this.p = new HashMap();
        }
        View view = (View) this.p.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.p.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class i<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f65731a;

        i(n nVar) {
            this.f65731a = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65731a.a(R.id.wallet_loader));
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = o.f65737b[dVar.ordinal()];
                if (i2 == 1) {
                    n.a(this.f65731a, (CJRAadharPanSave) bVar.f66169b);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65731a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    Context context = this.f65731a.getContext();
                    if (context == null) {
                        kotlin.g.b.k.a();
                    }
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65731a.a(R.id.wallet_loader));
                        n nVar = this.f65731a;
                        String string = nVar.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
                        Snackbar.a((View) (NestedScrollView) nVar.a(R.id.sv), (CharSequence) string, -1).c();
                    }
                }
            }
        }
    }

    static final class l<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCTncAccept>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f65734a;

        l(n nVar) {
            this.f65734a = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            String str = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = o.f65736a[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65734a.a(R.id.wallet_loader));
                    KYCTncAccept kYCTncAccept = (KYCTncAccept) bVar.f66169b;
                    if ((kYCTncAccept != null ? kYCTncAccept.getStatus() : null) == null || !p.a(kYCTncAccept.getStatus(), "error", true)) {
                        if (kYCTncAccept != null) {
                            str = kYCTncAccept.getStatus();
                        }
                        if (str != null && p.a(kYCTncAccept.getStatus(), "success", true) && kotlin.g.b.k.a((Object) kYCTncAccept.getResponseCode(), (Object) "2004")) {
                            n.b(this.f65734a);
                        }
                    } else if (!TextUtils.isEmpty(kYCTncAccept.getMessage())) {
                        n nVar = this.f65734a;
                        String message = kYCTncAccept.getMessage();
                        kotlin.g.b.k.a((Object) message, "kycTncAccept.message");
                        nVar.c(message);
                    }
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65734a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    Context context = this.f65734a.getContext();
                    if (context == null) {
                        kotlin.g.b.k.a();
                    }
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65734a.a(R.id.wallet_loader));
                        n nVar2 = this.f65734a;
                        String string = nVar2.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
                        Snackbar.a((View) (NestedScrollView) nVar2.a(R.id.sv), (CharSequence) string, -1).c();
                    }
                }
            }
        }
    }

    static final class m<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f65735a;

        m(n nVar) {
            this.f65735a = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            String str = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = o.f65738c[dVar.ordinal()];
                boolean z = true;
                if (i2 == 1) {
                    if (n.c(this.f65735a).f66262a) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65735a.a(R.id.wallet_loader));
                    }
                    KYCFetchTnc kYCFetchTnc = (KYCFetchTnc) bVar.f66169b;
                    if ((kYCFetchTnc != null ? kYCFetchTnc.getStatus() : null) == null || !p.a(kYCFetchTnc.getStatus(), "error", true)) {
                        if (kYCFetchTnc != null) {
                            str = kYCFetchTnc.getStatus();
                        }
                        if (str != null && p.a(kYCFetchTnc.getStatus(), "success", true)) {
                            Collection tncDataList = kYCFetchTnc.getTncDataList();
                            if (tncDataList != null && !tncDataList.isEmpty()) {
                                z = false;
                            }
                            if (!z) {
                                n.c(this.f65735a).f66264c = kYCFetchTnc.getTncDataList();
                                if (n.c(this.f65735a).f66262a) {
                                    n nVar = this.f65735a;
                                    ArrayList<TncData> arrayList = n.c(nVar).f66264c;
                                    if (arrayList == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    nVar.a(arrayList);
                                }
                                if (n.c(this.f65735a).f66263b) {
                                    n.c(this.f65735a).b();
                                }
                            }
                        }
                    } else if (!TextUtils.isEmpty(kYCFetchTnc.getMessage())) {
                        n nVar2 = this.f65735a;
                        String message = kYCFetchTnc.getMessage();
                        kotlin.g.b.k.a((Object) message, "kycFetchTnc.message");
                        nVar2.c(message);
                    }
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65735a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    Context context = this.f65735a.getContext();
                    if (context == null) {
                        kotlin.g.b.k.a();
                    }
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65735a.a(R.id.wallet_loader));
                        n nVar3 = this.f65735a;
                        String string = nVar3.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
                        Snackbar.a((View) (NestedScrollView) nVar3.a(R.id.sv), (CharSequence) string, -1).c();
                    }
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.kycV3.c.l c(n nVar) {
        net.one97.paytm.upgradeKyc.kycV3.c.l lVar = nVar.f65720e;
        if (lVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return lVar;
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "<set-?>");
        this.f65718b = str;
    }

    public final void b(String str) {
        kotlin.g.b.k.c(str, "<set-?>");
        this.f65719c = str;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        if (context instanceof b) {
            this.f65717a = (b) context;
            return;
        }
        throw new IllegalStateException(context + " must implement MinKYCBottomSheet.InteractionListener");
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f65726a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        d(n nVar) {
            this.f65726a = nVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            char charAt;
            kotlin.g.b.k.c(charSequence, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65726a.a(R.id.lyt_number);
            kotlin.g.b.k.a((Object) textInputLayout, "lyt_number");
            textInputLayout.setError("");
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f65726a.a(R.id.lyt_name);
            kotlin.g.b.k.a((Object) textInputLayout2, "lyt_name");
            textInputLayout2.setError("");
            TextInputLayout textInputLayout3 = (TextInputLayout) this.f65726a.a(R.id.lyt_expiry_date);
            kotlin.g.b.k.a((Object) textInputLayout3, "lyt_expiry_date");
            textInputLayout3.setError("");
            TextInputEditText textInputEditText = (TextInputEditText) this.f65726a.a(R.id.et_name);
            kotlin.g.b.k.a((Object) textInputEditText, "et_name");
            String valueOf = String.valueOf(textInputEditText.getText());
            if ((valueOf.length() > 0) && '0' <= (charAt = valueOf.charAt(valueOf.length() - 1)) && '9' >= charAt) {
                TextInputEditText textInputEditText2 = (TextInputEditText) this.f65726a.a(R.id.et_name);
                int length = valueOf.length() - 1;
                if (valueOf != null) {
                    String substring = valueOf.substring(0, length);
                    kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    textInputEditText2.setText(substring);
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            TextInputEditText textInputEditText3 = (TextInputEditText) this.f65726a.a(R.id.et_name);
            TextInputEditText textInputEditText4 = (TextInputEditText) this.f65726a.a(R.id.et_name);
            kotlin.g.b.k.a((Object) textInputEditText4, "et_name");
            Editable text = textInputEditText4.getText();
            if (text == null) {
                kotlin.g.b.k.a();
            }
            textInputEditText3.setSelection(text.length());
        }
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f65727a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        e(n nVar) {
            this.f65727a = nVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65727a.a(R.id.lyt_number);
            if (textInputLayout == null) {
                kotlin.g.b.k.a();
            }
            textInputLayout.setError("");
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f65727a.a(R.id.lyt_name);
            if (textInputLayout2 == null) {
                kotlin.g.b.k.a();
            }
            textInputLayout2.setError("");
            TextInputLayout textInputLayout3 = (TextInputLayout) this.f65727a.a(R.id.lyt_expiry_date);
            if (textInputLayout3 == null) {
                kotlin.g.b.k.a();
            }
            textInputLayout3.setError("");
        }
    }

    public static final class k implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f65733a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        k(n nVar) {
            this.f65733a = nVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65733a.a(R.id.lyt_number);
            kotlin.g.b.k.a((Object) textInputLayout, "lyt_number");
            textInputLayout.setError("");
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f65733a.a(R.id.lyt_name);
            kotlin.g.b.k.a((Object) textInputLayout2, "lyt_name");
            textInputLayout2.setError("");
            TextInputLayout textInputLayout3 = (TextInputLayout) this.f65733a.a(R.id.lyt_expiry_date);
            kotlin.g.b.k.a((Object) textInputLayout3, "lyt_expiry_date");
            textInputLayout3.setError("");
        }
    }

    public static final class c extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f65725a;

        public final void onSlide(View view, float f2) {
            kotlin.g.b.k.c(view, "bottomSheet");
        }

        c(n nVar) {
            this.f65725a = nVar;
        }

        public final void onStateChanged(View view, int i2) {
            kotlin.g.b.k.c(view, "bottomSheet");
            if (i2 == 5) {
                b bVar = this.f65725a.f65717a;
                if (bVar == null) {
                    kotlin.g.b.k.a("mHost");
                }
                bVar.d();
            }
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(context, getTheme());
        aVar.setOnShowListener(new f(this));
        Window window = aVar.getWindow();
        if (window == null) {
            kotlin.g.b.k.a();
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    static final class f implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f65728a;

        f(n nVar) {
            this.f65728a = nVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            n.a(this.f65728a, dialogInterface);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.activity_verify_doc, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((NestedScrollView) a(R.id.sv)).setBackgroundResource(R.drawable.kyc_bottomsheet_bg);
        NestedScrollView nestedScrollView = (NestedScrollView) a(R.id.sv);
        kotlin.g.b.k.a((Object) nestedScrollView, "sv");
        ViewGroup.LayoutParams layoutParams = nestedScrollView.getLayoutParams();
        layoutParams.height = (int) a(0.9d);
        NestedScrollView nestedScrollView2 = (NestedScrollView) a(R.id.sv);
        kotlin.g.b.k.a((Object) nestedScrollView2, "sv");
        nestedScrollView2.setLayoutParams(layoutParams);
        TextInputEditText textInputEditText = (TextInputEditText) a(R.id.et_name);
        kotlin.g.b.k.a((Object) textInputEditText, "et_name");
        textInputEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(60), new InputFilter.AllCaps()});
        View.OnClickListener onClickListener = this;
        ((ImageView) a(R.id.iv_close)).setOnClickListener(onClickListener);
        ((Button) a(R.id.btn_close)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.tv_complete_full_kyc)).setOnClickListener(onClickListener);
        ((Button) a(R.id.button_proceed)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.terms_text)).setOnClickListener(onClickListener);
        ((TextInputEditText) a(R.id.et_expiry_date)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.kyc_again_doubt_tv)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.kyc_again_know_more_tv)).setOnClickListener(onClickListener);
        ((RadioGroup) a(R.id.rg_docs)).setOnCheckedChangeListener(new j(this));
        ((TextInputEditText) a(R.id.et_expiry_date)).addTextChangedListener(this.f65724i);
        ((TextInputEditText) a(R.id.et_name)).addTextChangedListener(this.f65722g);
        ((TextInputEditText) a(R.id.et_number)).addTextChangedListener(this.f65723h);
        aa aaVar = aa.f47921a;
        String string = getString(R.string.kyc_i_agree_to_the);
        kotlin.g.b.k.a((Object) string, "getString(R.string.kyc_i_agree_to_the)");
        String format = String.format(string, Arrays.copyOf(new Object[]{" <a style=\"text-decoration:none\" href=https://www.google.com\">" + getString(R.string.kyc_terms_and_conditions) + "</a> "}, 1));
        kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
        Spanned fromHtml = Html.fromHtml(format);
        kotlin.g.b.k.a((Object) fromHtml, "Html.fromHtml(html)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
        TextView textView = (TextView) a(R.id.terms_text);
        kotlin.g.b.k.a((Object) textView, "terms_text");
        textView.setVisibility(0);
        TextView textView2 = (TextView) a(R.id.terms_text);
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        textView2.setLinkTextColor(androidx.core.content.b.c(context, R.color.paytm_blue));
        TextView textView3 = (TextView) a(R.id.terms_text);
        kotlin.g.b.k.a((Object) textView3, "terms_text");
        textView3.setText(spannableStringBuilder);
        ImageView imageView = (ImageView) a(R.id.iv_close);
        kotlin.g.b.k.a((Object) imageView, "iv_close");
        imageView.setVisibility(0);
        TextView textView4 = (TextView) a(R.id.kyc_again_doubt_tv);
        kotlin.g.b.k.a((Object) textView4, "kyc_again_doubt_tv");
        textView4.setText(getString(R.string.why_kyc));
        ((RadioGroup) a(R.id.rg_docs)).check(R.id.rb_passport);
        this.f65718b = "passport";
        this.f65719c = "passport";
        this.f65720e = (net.one97.paytm.upgradeKyc.kycV3.c.l) net.one97.paytm.upgradeKyc.kycV3.b.a((Fragment) this, net.one97.paytm.upgradeKyc.kycV3.c.l.class);
        net.one97.paytm.upgradeKyc.kycV3.c.l lVar = this.f65720e;
        if (lVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        lVar.a();
        net.one97.paytm.upgradeKyc.kycV3.c.l lVar2 = this.f65720e;
        if (lVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        lVar2.f66266e.observe(getViewLifecycleOwner(), this.l);
        net.one97.paytm.upgradeKyc.kycV3.c.l lVar3 = this.f65720e;
        if (lVar3 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        lVar3.f66265d.observe(getViewLifecycleOwner(), this.m);
        net.one97.paytm.upgradeKyc.kycV3.c.l lVar4 = this.f65720e;
        if (lVar4 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        lVar4.f66267f.observe(getViewLifecycleOwner(), this.k);
    }

    /* access modifiers changed from: private */
    public final void c(String str) {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            if (!activity.isFinishing()) {
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity2, "activity!!");
                if (!activity2.isDestroyed()) {
                    com.paytm.utility.g.b(getContext(), getString(R.string.error), str);
                }
            }
        }
    }

    static final class j implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f65732a;

        j(n nVar) {
            this.f65732a = nVar;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            n.a(this.f65732a);
            if (i2 == R.id.rb_voter_id) {
                TextInputLayout textInputLayout = (TextInputLayout) this.f65732a.a(R.id.lyt_expiry_date);
                kotlin.g.b.k.a((Object) textInputLayout, "lyt_expiry_date");
                textInputLayout.setVisibility(8);
                TextInputLayout textInputLayout2 = (TextInputLayout) this.f65732a.a(R.id.lyt_number);
                kotlin.g.b.k.a((Object) textInputLayout2, "lyt_number");
                textInputLayout2.setHint(this.f65732a.getString(R.string.voter_id_number));
                TextInputLayout textInputLayout3 = (TextInputLayout) this.f65732a.a(R.id.lyt_name);
                kotlin.g.b.k.a((Object) textInputLayout3, "lyt_name");
                textInputLayout3.setHint(this.f65732a.getString(R.string.voter_id_name));
                n.a(this.f65732a, 30);
                this.f65732a.a("voter id");
                this.f65732a.b("voter");
            } else if (i2 == R.id.rb_job_card) {
                TextInputLayout textInputLayout4 = (TextInputLayout) this.f65732a.a(R.id.lyt_expiry_date);
                kotlin.g.b.k.a((Object) textInputLayout4, "lyt_expiry_date");
                textInputLayout4.setVisibility(8);
                TextInputLayout textInputLayout5 = (TextInputLayout) this.f65732a.a(R.id.lyt_number);
                kotlin.g.b.k.a((Object) textInputLayout5, "lyt_number");
                textInputLayout5.setHint(this.f65732a.getString(R.string.nrega_number));
                TextInputLayout textInputLayout6 = (TextInputLayout) this.f65732a.a(R.id.lyt_name);
                kotlin.g.b.k.a((Object) textInputLayout6, "lyt_name");
                textInputLayout6.setHint(this.f65732a.getString(R.string.nrega_name));
                n.a(this.f65732a, 30);
                this.f65732a.a("nrega job card");
                this.f65732a.b("nrega_job");
            } else if (i2 == R.id.rb_driving_license) {
                TextInputLayout textInputLayout7 = (TextInputLayout) this.f65732a.a(R.id.lyt_expiry_date);
                kotlin.g.b.k.a((Object) textInputLayout7, "lyt_expiry_date");
                textInputLayout7.setVisibility(0);
                TextInputLayout textInputLayout8 = (TextInputLayout) this.f65732a.a(R.id.lyt_number);
                kotlin.g.b.k.a((Object) textInputLayout8, "lyt_number");
                textInputLayout8.setHint(this.f65732a.getString(R.string.driving_license_number));
                TextInputLayout textInputLayout9 = (TextInputLayout) this.f65732a.a(R.id.lyt_name);
                kotlin.g.b.k.a((Object) textInputLayout9, "lyt_name");
                textInputLayout9.setHint(this.f65732a.getString(R.string.driving_license_name));
                TextInputLayout textInputLayout10 = (TextInputLayout) this.f65732a.a(R.id.lyt_expiry_date);
                kotlin.g.b.k.a((Object) textInputLayout10, "lyt_expiry_date");
                textInputLayout10.setHint(this.f65732a.getString(R.string.driving_license_expiry));
                n.a(this.f65732a, 30);
                this.f65732a.a("driving license");
                this.f65732a.b("dl");
            } else if (i2 == R.id.rb_passport) {
                TextInputLayout textInputLayout11 = (TextInputLayout) this.f65732a.a(R.id.lyt_expiry_date);
                kotlin.g.b.k.a((Object) textInputLayout11, "lyt_expiry_date");
                textInputLayout11.setVisibility(0);
                TextInputLayout textInputLayout12 = (TextInputLayout) this.f65732a.a(R.id.lyt_number);
                kotlin.g.b.k.a((Object) textInputLayout12, "lyt_number");
                textInputLayout12.setHint(this.f65732a.getString(R.string.kyc_passport_number));
                TextInputLayout textInputLayout13 = (TextInputLayout) this.f65732a.a(R.id.lyt_name);
                kotlin.g.b.k.a((Object) textInputLayout13, "lyt_name");
                textInputLayout13.setHint(this.f65732a.getString(R.string.passport_name));
                TextInputLayout textInputLayout14 = (TextInputLayout) this.f65732a.a(R.id.lyt_expiry_date);
                kotlin.g.b.k.a((Object) textInputLayout14, "lyt_expiry_date");
                textInputLayout14.setHint(this.f65732a.getString(R.string.passport_expiry));
                n.a(this.f65732a, 8);
                this.f65732a.a("passport");
                this.f65732a.b("passport");
            }
            TextView textView = (TextView) this.f65732a.a(R.id.terms_text_complete);
            kotlin.g.b.k.a((Object) textView, "terms_text_complete");
            n nVar = this.f65732a;
            int i3 = R.string.aadhaar_tnc_complete;
            Object[] objArr = new Object[1];
            String str = this.f65732a.f65718b;
            if (str == null) {
                kotlin.g.b.k.a("docName");
            }
            objArr[0] = str;
            textView.setText(nVar.getString(i3, objArr));
        }
    }

    private final double a(double d2) {
        FragmentActivity activity = getActivity();
        WindowManager windowManager = activity != null ? activity.getWindowManager() : null;
        if (windowManager == null) {
            kotlin.g.b.k.a();
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        kotlin.g.b.k.a((Object) defaultDisplay, "activity?.windowManager!!.defaultDisplay");
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i2 = point.x;
        return ((double) point.y) * d2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v12, types: [android.content.Context] */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0248, code lost:
        if (r12.getCheckedRadioButtonId() == net.one97.paytm.upgradeKyc.R.id.rb_driving_license) goto L_0x024a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r12) {
        /*
            r11 = this;
            java.lang.String r0 = "v"
            kotlin.g.b.k.c(r12, r0)
            int r12 = r12.getId()
            int r0 = net.one97.paytm.upgradeKyc.R.id.btn_close
            java.lang.String r1 = "mHost"
            if (r12 != r0) goto L_0x001a
            net.one97.paytm.upgradeKyc.d.n$b r12 = r11.f65717a
            if (r12 != 0) goto L_0x0016
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0016:
            r12.d()
            return
        L_0x001a:
            int r0 = net.one97.paytm.upgradeKyc.R.id.tv_complete_full_kyc
            if (r12 != r0) goto L_0x0029
            net.one97.paytm.upgradeKyc.d.n$b r12 = r11.f65717a
            if (r12 != 0) goto L_0x0025
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0025:
            r12.e()
            return
        L_0x0029:
            int r0 = net.one97.paytm.upgradeKyc.R.id.iv_close
            if (r12 != r0) goto L_0x0038
            net.one97.paytm.upgradeKyc.d.n$b r12 = r11.f65717a
            if (r12 != 0) goto L_0x0034
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0034:
            r12.d()
            return
        L_0x0038:
            int r0 = net.one97.paytm.upgradeKyc.R.id.kyc_again_know_more_tv
            r1 = 0
            if (r12 == r0) goto L_0x045c
            int r0 = net.one97.paytm.upgradeKyc.R.id.kyc_again_doubt_tv
            if (r12 != r0) goto L_0x0043
            goto L_0x045c
        L_0x0043:
            int r0 = net.one97.paytm.upgradeKyc.R.id.button_proceed
            java.lang.String r2 = "et_expiry_date"
            r3 = 1
            r4 = 0
            java.lang.String r5 = "context!!"
            if (r12 != r0) goto L_0x0349
            int r12 = net.one97.paytm.upgradeKyc.R.id.et_number
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            if (r12 != 0) goto L_0x005a
            kotlin.g.b.k.a()
        L_0x005a:
            android.text.Editable r12 = r12.getText()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            java.lang.String r0 = "lyt_number"
            java.lang.String r6 = "et_number"
            java.lang.String r7 = " "
            java.lang.String r8 = "sv"
            if (r12 == 0) goto L_0x00f2
            net.one97.paytm.upgradeKyc.utils.i$a r12 = net.one97.paytm.upgradeKyc.utils.i.f66336a
            android.content.Context r12 = r11.getContext()
            if (r12 != 0) goto L_0x0079
            kotlin.g.b.k.a()
        L_0x0079:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            int r2 = net.one97.paytm.upgradeKyc.R.id.et_number
            android.view.View r2 = r11.a((int) r2)
            com.google.android.material.textfield.TextInputEditText r2 = (com.google.android.material.textfield.TextInputEditText) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            android.widget.EditText r2 = (android.widget.EditText) r2
            net.one97.paytm.upgradeKyc.utils.i.a.a(r12, r2)
            net.one97.paytm.upgradeKyc.utils.k$a r12 = net.one97.paytm.upgradeKyc.utils.k.f66337a
            android.content.Context r12 = r11.getContext()
            if (r12 != 0) goto L_0x0097
            kotlin.g.b.k.a()
        L_0x0097:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            int r2 = net.one97.paytm.upgradeKyc.R.id.sv
            android.view.View r2 = r11.a((int) r2)
            androidx.core.widget.NestedScrollView r2 = (androidx.core.widget.NestedScrollView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            int r5 = net.one97.paytm.upgradeKyc.R.id.lyt_number
            android.view.View r5 = r11.a((int) r5)
            com.google.android.material.textfield.TextInputLayout r5 = (com.google.android.material.textfield.TextInputLayout) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            android.view.View r5 = (android.view.View) r5
            net.one97.paytm.upgradeKyc.utils.k.a.a(r12, r2, r5)
            int r12 = net.one97.paytm.upgradeKyc.R.id.lyt_number
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputLayout r12 = (com.google.android.material.textfield.TextInputLayout) r12
            if (r12 != 0) goto L_0x00c2
            kotlin.g.b.k.a()
        L_0x00c2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = net.one97.paytm.upgradeKyc.R.string.please_enter
            java.lang.String r2 = r11.getString(r2)
            r0.append(r2)
            r0.append(r7)
            int r2 = net.one97.paytm.upgradeKyc.R.id.lyt_number
            android.view.View r2 = r11.a((int) r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            if (r2 != 0) goto L_0x00e0
            kotlin.g.b.k.a()
        L_0x00e0:
            java.lang.CharSequence r2 = r2.getHint()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setError(r0)
            goto L_0x0310
        L_0x00f2:
            int r12 = net.one97.paytm.upgradeKyc.R.id.rg_docs
            android.view.View r12 = r11.a((int) r12)
            android.widget.RadioGroup r12 = (android.widget.RadioGroup) r12
            java.lang.String r9 = "rg_docs"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r9)
            int r12 = r12.getCheckedRadioButtonId()
            int r10 = net.one97.paytm.upgradeKyc.R.id.rb_passport
            if (r12 != r10) goto L_0x0183
            int r12 = net.one97.paytm.upgradeKyc.R.id.et_number
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            if (r12 != 0) goto L_0x0114
            kotlin.g.b.k.a()
        L_0x0114:
            android.text.Editable r12 = r12.getText()
            java.lang.String r12 = java.lang.String.valueOf(r12)
            boolean r12 = com.paytm.utility.b.U((java.lang.String) r12)
            if (r12 != 0) goto L_0x0183
            net.one97.paytm.upgradeKyc.utils.i$a r12 = net.one97.paytm.upgradeKyc.utils.i.f66336a
            android.content.Context r12 = r11.getContext()
            if (r12 != 0) goto L_0x012d
            kotlin.g.b.k.a()
        L_0x012d:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            int r2 = net.one97.paytm.upgradeKyc.R.id.et_number
            android.view.View r2 = r11.a((int) r2)
            com.google.android.material.textfield.TextInputEditText r2 = (com.google.android.material.textfield.TextInputEditText) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            android.widget.EditText r2 = (android.widget.EditText) r2
            net.one97.paytm.upgradeKyc.utils.i.a.a(r12, r2)
            net.one97.paytm.upgradeKyc.utils.k$a r12 = net.one97.paytm.upgradeKyc.utils.k.f66337a
            android.content.Context r12 = r11.getContext()
            if (r12 != 0) goto L_0x014b
            kotlin.g.b.k.a()
        L_0x014b:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            int r2 = net.one97.paytm.upgradeKyc.R.id.sv
            android.view.View r2 = r11.a((int) r2)
            androidx.core.widget.NestedScrollView r2 = (androidx.core.widget.NestedScrollView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            int r5 = net.one97.paytm.upgradeKyc.R.id.lyt_number
            android.view.View r5 = r11.a((int) r5)
            com.google.android.material.textfield.TextInputLayout r5 = (com.google.android.material.textfield.TextInputLayout) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            android.view.View r5 = (android.view.View) r5
            net.one97.paytm.upgradeKyc.utils.k.a.a(r12, r2, r5)
            int r12 = net.one97.paytm.upgradeKyc.R.id.lyt_number
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputLayout r12 = (com.google.android.material.textfield.TextInputLayout) r12
            if (r12 != 0) goto L_0x0176
            kotlin.g.b.k.a()
        L_0x0176:
            int r0 = net.one97.paytm.upgradeKyc.R.string.error_passport_number
            java.lang.String r0 = r11.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setError(r0)
            goto L_0x0310
        L_0x0183:
            int r12 = net.one97.paytm.upgradeKyc.R.id.et_name
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            if (r12 != 0) goto L_0x0190
            kotlin.g.b.k.a()
        L_0x0190:
            android.text.Editable r12 = r12.getText()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x0224
            net.one97.paytm.upgradeKyc.utils.i$a r12 = net.one97.paytm.upgradeKyc.utils.i.f66336a
            android.content.Context r12 = r11.getContext()
            if (r12 != 0) goto L_0x01a7
            kotlin.g.b.k.a()
        L_0x01a7:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            int r0 = net.one97.paytm.upgradeKyc.R.id.et_name
            android.view.View r0 = r11.a((int) r0)
            com.google.android.material.textfield.TextInputEditText r0 = (com.google.android.material.textfield.TextInputEditText) r0
            java.lang.String r2 = "et_name"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.widget.EditText r0 = (android.widget.EditText) r0
            net.one97.paytm.upgradeKyc.utils.i.a.a(r12, r0)
            net.one97.paytm.upgradeKyc.utils.k$a r12 = net.one97.paytm.upgradeKyc.utils.k.f66337a
            android.content.Context r12 = r11.getContext()
            if (r12 != 0) goto L_0x01c7
            kotlin.g.b.k.a()
        L_0x01c7:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            int r0 = net.one97.paytm.upgradeKyc.R.id.sv
            android.view.View r0 = r11.a((int) r0)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            int r2 = net.one97.paytm.upgradeKyc.R.id.lyt_name
            android.view.View r2 = r11.a((int) r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            java.lang.String r5 = "lyt_name"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upgradeKyc.utils.k.a.a(r12, r0, r2)
            int r12 = net.one97.paytm.upgradeKyc.R.id.lyt_name
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputLayout r12 = (com.google.android.material.textfield.TextInputLayout) r12
            if (r12 != 0) goto L_0x01f4
            kotlin.g.b.k.a()
        L_0x01f4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = net.one97.paytm.upgradeKyc.R.string.please_enter
            java.lang.String r2 = r11.getString(r2)
            r0.append(r2)
            r0.append(r7)
            int r2 = net.one97.paytm.upgradeKyc.R.id.lyt_name
            android.view.View r2 = r11.a((int) r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            if (r2 != 0) goto L_0x0212
            kotlin.g.b.k.a()
        L_0x0212:
            java.lang.CharSequence r2 = r2.getHint()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setError(r0)
            goto L_0x0310
        L_0x0224:
            int r12 = net.one97.paytm.upgradeKyc.R.id.rg_docs
            android.view.View r12 = r11.a((int) r12)
            android.widget.RadioGroup r12 = (android.widget.RadioGroup) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r9)
            int r12 = r12.getCheckedRadioButtonId()
            int r0 = net.one97.paytm.upgradeKyc.R.id.rb_passport
            if (r12 == r0) goto L_0x024a
            int r12 = net.one97.paytm.upgradeKyc.R.id.rg_docs
            android.view.View r12 = r11.a((int) r12)
            android.widget.RadioGroup r12 = (android.widget.RadioGroup) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r9)
            int r12 = r12.getCheckedRadioButtonId()
            int r0 = net.one97.paytm.upgradeKyc.R.id.rb_driving_license
            if (r12 != r0) goto L_0x02e8
        L_0x024a:
            int r12 = net.one97.paytm.upgradeKyc.R.id.et_expiry_date
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            if (r12 != 0) goto L_0x0257
            kotlin.g.b.k.a()
        L_0x0257:
            android.text.Editable r12 = r12.getText()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x02e8
            net.one97.paytm.upgradeKyc.utils.i$a r12 = net.one97.paytm.upgradeKyc.utils.i.f66336a
            android.content.Context r12 = r11.getContext()
            if (r12 != 0) goto L_0x026e
            kotlin.g.b.k.a()
        L_0x026e:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            int r0 = net.one97.paytm.upgradeKyc.R.id.et_expiry_date
            android.view.View r0 = r11.a((int) r0)
            com.google.android.material.textfield.TextInputEditText r0 = (com.google.android.material.textfield.TextInputEditText) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.widget.EditText r0 = (android.widget.EditText) r0
            net.one97.paytm.upgradeKyc.utils.i.a.a(r12, r0)
            net.one97.paytm.upgradeKyc.utils.k$a r12 = net.one97.paytm.upgradeKyc.utils.k.f66337a
            android.content.Context r12 = r11.getContext()
            if (r12 != 0) goto L_0x028c
            kotlin.g.b.k.a()
        L_0x028c:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            int r0 = net.one97.paytm.upgradeKyc.R.id.sv
            android.view.View r0 = r11.a((int) r0)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            int r2 = net.one97.paytm.upgradeKyc.R.id.lyt_expiry_date
            android.view.View r2 = r11.a((int) r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            java.lang.String r5 = "lyt_expiry_date"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upgradeKyc.utils.k.a.a(r12, r0, r2)
            int r12 = net.one97.paytm.upgradeKyc.R.id.lyt_expiry_date
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputLayout r12 = (com.google.android.material.textfield.TextInputLayout) r12
            if (r12 != 0) goto L_0x02b9
            kotlin.g.b.k.a()
        L_0x02b9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = net.one97.paytm.upgradeKyc.R.string.please_enter
            java.lang.String r2 = r11.getString(r2)
            r0.append(r2)
            r0.append(r7)
            int r2 = net.one97.paytm.upgradeKyc.R.id.lyt_expiry_date
            android.view.View r2 = r11.a((int) r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            if (r2 != 0) goto L_0x02d7
            kotlin.g.b.k.a()
        L_0x02d7:
            java.lang.CharSequence r2 = r2.getHint()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setError(r0)
            goto L_0x0310
        L_0x02e8:
            int r12 = net.one97.paytm.upgradeKyc.R.id.terms_checkbox
            android.view.View r12 = r11.a((int) r12)
            android.widget.CheckBox r12 = (android.widget.CheckBox) r12
            java.lang.String r0 = "terms_checkbox"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            boolean r12 = r12.isChecked()
            if (r12 != 0) goto L_0x030f
            android.content.Context r12 = r11.getContext()
            int r0 = net.one97.paytm.upgradeKyc.R.string.alert
            java.lang.String r0 = r11.getString(r0)
            int r2 = net.one97.paytm.upgradeKyc.R.string.tnc_accept
            java.lang.String r2 = r11.getString(r2)
            com.paytm.utility.b.b((android.content.Context) r12, (java.lang.String) r0, (java.lang.String) r2)
            goto L_0x0310
        L_0x030f:
            r4 = 1
        L_0x0310:
            if (r4 == 0) goto L_0x0348
            net.one97.paytm.upgradeKyc.utils.m$a r12 = net.one97.paytm.upgradeKyc.utils.m.f66342a
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()
            if (r12 == 0) goto L_0x031e
            android.content.Context r1 = r12.getApplicationContext()
        L_0x031e:
            boolean r12 = net.one97.paytm.upgradeKyc.utils.m.a.a(r1)
            if (r12 == 0) goto L_0x0345
            net.one97.paytm.upgradeKyc.minkycotp.b r12 = new net.one97.paytm.upgradeKyc.minkycotp.b
            r12.<init>()
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "isBottomSheetView"
            r0.putBoolean(r1, r3)
            r12.setArguments(r0)
            net.one97.paytm.upgradeKyc.minkycotp.d r0 = r11.n
            r12.a((net.one97.paytm.upgradeKyc.minkycotp.d) r0)
            androidx.fragment.app.j r0 = r11.getChildFragmentManager()
            java.lang.String r1 = "OTPFragment"
            r12.show((androidx.fragment.app.j) r0, (java.lang.String) r1)
            return
        L_0x0345:
            r11.b()
        L_0x0348:
            return
        L_0x0349:
            int r0 = net.one97.paytm.upgradeKyc.R.id.terms_text
            if (r12 != r0) goto L_0x039f
            net.one97.paytm.upgradeKyc.kycV3.c.l r12 = r11.f65720e
            java.lang.String r0 = "viewModel"
            if (r12 != 0) goto L_0x0356
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0356:
            r12.f66263b = r4
            net.one97.paytm.upgradeKyc.kycV3.c.l r12 = r11.f65720e
            if (r12 != 0) goto L_0x035f
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x035f:
            java.util.ArrayList<net.one97.paytm.common.entity.auth.TncData> r12 = r12.f66264c
            java.util.Collection r12 = (java.util.Collection) r12
            if (r12 == 0) goto L_0x036b
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x036c
        L_0x036b:
            r4 = 1
        L_0x036c:
            if (r4 != 0) goto L_0x0380
            net.one97.paytm.upgradeKyc.kycV3.c.l r12 = r11.f65720e
            if (r12 != 0) goto L_0x0375
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0375:
            java.util.ArrayList<net.one97.paytm.common.entity.auth.TncData> r12 = r12.f66264c
            if (r12 != 0) goto L_0x037c
            kotlin.g.b.k.a()
        L_0x037c:
            r11.a((java.util.ArrayList<net.one97.paytm.common.entity.auth.TncData>) r12)
            return
        L_0x0380:
            net.one97.paytm.upgradeKyc.kycV3.c.l r12 = r11.f65720e
            if (r12 != 0) goto L_0x0387
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0387:
            r12.f66262a = r3
            int r12 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
            android.view.View r12 = r11.a((int) r12)
            com.airbnb.lottie.LottieAnimationView r12 = (com.airbnb.lottie.LottieAnimationView) r12
            net.one97.paytm.common.widgets.a.a(r12)
            net.one97.paytm.upgradeKyc.kycV3.c.l r12 = r11.f65720e
            if (r12 != 0) goto L_0x039b
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x039b:
            r12.a()
            return
        L_0x039f:
            int r0 = net.one97.paytm.upgradeKyc.R.id.et_expiry_date
            if (r12 != r0) goto L_0x045b
            net.one97.paytm.upgradeKyc.utils.i$a r12 = net.one97.paytm.upgradeKyc.utils.i.f66336a
            android.content.Context r12 = r11.getContext()
            if (r12 != 0) goto L_0x03ae
            kotlin.g.b.k.a()
        L_0x03ae:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            int r0 = net.one97.paytm.upgradeKyc.R.id.et_expiry_date
            android.view.View r0 = r11.a((int) r0)
            com.google.android.material.textfield.TextInputEditText r0 = (com.google.android.material.textfield.TextInputEditText) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.widget.EditText r0 = (android.widget.EditText) r0
            net.one97.paytm.upgradeKyc.utils.i.a.a(r12, r0)
            int r12 = net.one97.paytm.upgradeKyc.R.id.et_expiry_date
            android.view.View r12 = r11.a((int) r12)
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            if (r12 != 0) goto L_0x03ce
            kotlin.g.b.k.a()
        L_0x03ce:
            android.text.Editable r12 = r12.getText()
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "dd-MM-yyyy"
            r0.<init>(r1)
            r2 = r12
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x03f7
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.Long r12 = java.lang.Long.valueOf(r4)
            java.lang.String r12 = r0.format(r12)
            java.lang.String r2 = "simpleDateFormat.format(…stem.currentTimeMillis())"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
        L_0x03f7:
            net.one97.paytm.common.widgets.e r2 = new net.one97.paytm.common.widgets.e
            r2.<init>()
            r4 = r11
            net.one97.paytm.common.widgets.a.d r4 = (net.one97.paytm.common.widgets.a.d) r4
            r2.a(r4)
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r5 = "date_format"
            r4.putString(r5, r1)
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            java.lang.String r5 = "Calendar.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r6 = 5
            r7 = 4
            r1.add(r6, r7)
            java.util.Date r1 = r1.getTime()
            java.lang.String r1 = r0.format(r1)
            java.lang.String r6 = "simpleDateFormat.format(minCalendar.time)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            java.lang.String r6 = "min_date"
            r4.putString(r6, r1)
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r5 = 50
            r1.add(r3, r5)
            java.util.Date r1 = r1.getTime()
            java.lang.String r0 = r0.format(r1)
            java.lang.String r1 = "simpleDateFormat.format(calendarUpper.time)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = "max_date"
            r4.putString(r1, r0)
            java.lang.String r0 = "default_dob"
            r4.putString(r0, r12)
            r2.setArguments(r4)
            androidx.fragment.app.j r12 = r11.getChildFragmentManager()
            java.lang.String r0 = "DatePickerFragment"
            r2.show((androidx.fragment.app.j) r12, (java.lang.String) r0)
        L_0x045b:
            return
        L_0x045c:
            net.one97.paytm.upgradeKyc.helper.d$a r12 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r12 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r12 == 0) goto L_0x0498
            net.one97.paytm.upgradeKyc.helper.d$a r12 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r12 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r12 == 0) goto L_0x0472
            java.lang.String r12 = "kycAgainLearnMoreUrl"
            java.lang.String r1 = net.one97.paytm.upgradeKyc.helper.d.a((java.lang.String) r12)
        L_0x0472:
            android.content.Intent r12 = new android.content.Intent     // Catch:{ ClassNotFoundException -> 0x0494 }
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()     // Catch:{ ClassNotFoundException -> 0x0494 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ ClassNotFoundException -> 0x0494 }
            net.one97.paytm.upgradeKyc.helper.e$a r2 = net.one97.paytm.upgradeKyc.helper.e.f66028b     // Catch:{ ClassNotFoundException -> 0x0494 }
            net.one97.paytm.upgradeKyc.helper.f r2 = net.one97.paytm.upgradeKyc.helper.e.a.b()     // Catch:{ ClassNotFoundException -> 0x0494 }
            java.lang.String r2 = r2.d()     // Catch:{ ClassNotFoundException -> 0x0494 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0494 }
            r12.<init>(r0, r2)     // Catch:{ ClassNotFoundException -> 0x0494 }
            java.lang.String r0 = "url"
            r12.putExtra(r0, r1)     // Catch:{ ClassNotFoundException -> 0x0494 }
            r11.startActivity(r12)     // Catch:{ ClassNotFoundException -> 0x0494 }
            return
        L_0x0494:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0498:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.d.n.onClick(android.view.View):void");
    }

    /* access modifiers changed from: private */
    public final void b() {
        c();
        net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.wallet_loader));
        net.one97.paytm.upgradeKyc.kycV3.c.l lVar = this.f65720e;
        if (lVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        lVar.a(d());
    }

    private final void c() {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
        String n2 = com.paytm.utility.b.n(e.a.b().a());
        kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getU….getApplicationContext())");
        map.put("kyc_user_id", n2);
        String str = this.f65718b;
        if (str == null) {
            kotlin.g.b.k.a("docName");
        }
        map.put("kyc_document_type", str);
        e.a aVar2 = net.one97.paytm.upgradeKyc.helper.e.f66028b;
        net.one97.paytm.upgradeKyc.helper.f b2 = e.a.b();
        e.a aVar3 = net.one97.paytm.upgradeKyc.helper.e.f66028b;
        b2.a("kyc_verify_document_proceed_clicked", (HashMap<String, Object>) hashMap, e.a.b().a());
    }

    private final DocData d() {
        String str = this.f65719c;
        if (str == null) {
            kotlin.g.b.k.a("docCode");
        }
        TextInputEditText textInputEditText = (TextInputEditText) a(R.id.et_number);
        kotlin.g.b.k.a((Object) textInputEditText, "et_number");
        String valueOf = String.valueOf(textInputEditText.getText());
        TextInputEditText textInputEditText2 = (TextInputEditText) a(R.id.et_name);
        kotlin.g.b.k.a((Object) textInputEditText2, "et_name");
        return new DocData(str, valueOf, String.valueOf(textInputEditText2.getText()));
    }

    public static final class h implements net.one97.paytm.upgradeKyc.minkycotp.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f65730a;

        h(n nVar) {
            this.f65730a = nVar;
        }

        public final void a() {
            this.f65730a.b();
        }
    }

    public final void setSelectedDate(String str) {
        ((TextInputEditText) a(R.id.et_expiry_date)).setText(str);
    }

    static final class g implements m.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f65729a;

        g(n nVar) {
            this.f65729a = nVar;
        }

        public final void onTncAccepted() {
            CheckBox checkBox = (CheckBox) this.f65729a.a(R.id.terms_checkbox);
            kotlin.g.b.k.a((Object) checkBox, "terms_checkbox");
            checkBox.setChecked(true);
        }
    }

    /* access modifiers changed from: private */
    public final void a(ArrayList<TncData> arrayList) {
        try {
            m a2 = m.a(arrayList);
            a2.a((m.a) new g(this));
            a2.show(getChildFragmentManager(), "KycTNCFragment");
        } catch (Exception unused) {
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        kotlin.g.b.k.c(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        b bVar = this.f65717a;
        if (bVar == null) {
            kotlin.g.b.k.a("mHost");
        }
        bVar.d();
    }

    public static final /* synthetic */ void a(n nVar, DialogInterface dialogInterface) {
        if (dialogInterface != null) {
            FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if (frameLayout != null) {
                frameLayout.setBackground(new ColorDrawable(0));
            }
            nVar.f65721f = frameLayout != null ? BottomSheetBehavior.from(frameLayout) : null;
            BottomSheetBehavior<?> bottomSheetBehavior = nVar.f65721f;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setPeekHeight((int) nVar.a(0.9d));
            }
            BottomSheetBehavior<?> bottomSheetBehavior2 = nVar.f65721f;
            if (bottomSheetBehavior2 != null) {
                bottomSheetBehavior2.setBottomSheetCallback(nVar.j);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    public static final /* synthetic */ void a(n nVar) {
        TextInputLayout textInputLayout = (TextInputLayout) nVar.a(R.id.lyt_number);
        kotlin.g.b.k.a((Object) textInputLayout, "lyt_number");
        textInputLayout.setError("");
        TextInputLayout textInputLayout2 = (TextInputLayout) nVar.a(R.id.lyt_name);
        kotlin.g.b.k.a((Object) textInputLayout2, "lyt_name");
        textInputLayout2.setError("");
        TextInputLayout textInputLayout3 = (TextInputLayout) nVar.a(R.id.lyt_expiry_date);
        kotlin.g.b.k.a((Object) textInputLayout3, "lyt_expiry_date");
        textInputLayout3.setError("");
        ((TextInputEditText) nVar.a(R.id.et_number)).setText("");
        ((TextInputEditText) nVar.a(R.id.et_name)).setText("");
        ((TextInputEditText) nVar.a(R.id.et_expiry_date)).setText("");
        TextInputLayout textInputLayout4 = (TextInputLayout) nVar.a(R.id.lyt_number);
        kotlin.g.b.k.a((Object) textInputLayout4, "lyt_number");
        textInputLayout4.setVisibility(0);
        TextInputLayout textInputLayout5 = (TextInputLayout) nVar.a(R.id.lyt_name);
        kotlin.g.b.k.a((Object) textInputLayout5, "lyt_name");
        textInputLayout5.setVisibility(0);
    }

    public static final /* synthetic */ void a(n nVar, int i2) {
        TextInputEditText textInputEditText = (TextInputEditText) nVar.a(R.id.et_number);
        kotlin.g.b.k.a((Object) textInputEditText, "et_number");
        textInputEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2), new InputFilter.AllCaps()});
    }

    public static final /* synthetic */ void b(n nVar) {
        BottomSheetBehavior<?> bottomSheetBehavior = nVar.f65721f;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setPeekHeight((int) nVar.a(0.6d));
        }
        NestedScrollView nestedScrollView = (NestedScrollView) nVar.a(R.id.sv);
        kotlin.g.b.k.a((Object) nestedScrollView, "sv");
        ViewGroup.LayoutParams layoutParams = nestedScrollView.getLayoutParams();
        layoutParams.height = (int) nVar.a(0.6d);
        NestedScrollView nestedScrollView2 = (NestedScrollView) nVar.a(R.id.sv);
        kotlin.g.b.k.a((Object) nestedScrollView2, "sv");
        nestedScrollView2.setLayoutParams(layoutParams);
        b bVar = nVar.f65717a;
        if (bVar == null) {
            kotlin.g.b.k.a("mHost");
        }
        bVar.f();
        LinearLayout linearLayout = (LinearLayout) nVar.a(R.id.ll_success);
        kotlin.g.b.k.a((Object) linearLayout, "ll_success");
        linearLayout.setVisibility(0);
        View a2 = nVar.a(R.id.kyc_again_footer);
        kotlin.g.b.k.a((Object) a2, "kyc_again_footer");
        a2.setVisibility(8);
        LinearLayout linearLayout2 = (LinearLayout) nVar.a(R.id.main_lyt);
        kotlin.g.b.k.a((Object) linearLayout2, "main_lyt");
        linearLayout2.setVisibility(8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r0.equals("9561") != false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        r7 = r6.getString(net.one97.paytm.upgradeKyc.R.string.kyc_dedup_dialog_error);
        kotlin.g.b.k.a((java.lang.Object) r7, "getString(R.string.kyc_dedup_dialog_error)");
        r6.c(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r0.equals("9562") != false) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.upgradeKyc.d.n r6, net.one97.paytm.common.entity.CJRAadharPanSave r7) {
        /*
            if (r7 == 0) goto L_0x0007
            java.lang.String r0 = r7.getErrorErrorMessage()
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            if (r0 == 0) goto L_0x005d
            java.lang.String r0 = r7.getErrorErrorCode()
            if (r0 != 0) goto L_0x0011
            goto L_0x004e
        L_0x0011:
            int r1 = r0.hashCode()
            switch(r1) {
                case 1596805: goto L_0x0039;
                case 1750743: goto L_0x0022;
                case 1750744: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x004e
        L_0x0019:
            java.lang.String r7 = "9562"
            boolean r7 = r0.equals(r7)
            if (r7 == 0) goto L_0x004e
            goto L_0x002a
        L_0x0022:
            java.lang.String r7 = "9561"
            boolean r7 = r0.equals(r7)
            if (r7 == 0) goto L_0x004e
        L_0x002a:
            int r7 = net.one97.paytm.upgradeKyc.R.string.kyc_dedup_dialog_error
            java.lang.String r7 = r6.getString(r7)
            java.lang.String r0 = "getString(R.string.kyc_dedup_dialog_error)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            r6.c((java.lang.String) r7)
            return
        L_0x0039:
            java.lang.String r1 = "4009"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004e
            java.lang.String r7 = r7.getErrorErrorMessage()
            java.lang.String r0 = "response.errorErrorMessage"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            r6.c((java.lang.String) r7)
            return
        L_0x004e:
            int r7 = net.one97.paytm.upgradeKyc.R.string.some_went_wrong
            java.lang.String r7 = r6.getString(r7)
            java.lang.String r0 = "getString(R.string.some_went_wrong)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            r6.c((java.lang.String) r7)
            return
        L_0x005d:
            if (r7 == 0) goto L_0x00c8
            java.util.List r0 = r7.getDocuments()
            if (r0 == 0) goto L_0x00c8
            java.util.List r0 = r7.getDocuments()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00c8
            r0 = 0
            java.util.List r7 = r7.getDocuments()
            java.util.Iterator r7 = r7.iterator()
        L_0x0078:
            boolean r1 = r7.hasNext()
            r2 = 1
            if (r1 == 0) goto L_0x00b3
            java.lang.Object r1 = r7.next()
            net.one97.paytm.common.entity.CJRAadharPanDocList r1 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r1
            if (r1 == 0) goto L_0x0078
            java.lang.String r3 = r1.getDocCode()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0078
            java.lang.String r3 = r1.getDocCode()
            java.lang.String r4 = r6.f65719c
            if (r4 != 0) goto L_0x00a0
            java.lang.String r5 = "docCode"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00a0:
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r4, (boolean) r2)
            if (r3 == 0) goto L_0x0078
            java.lang.String r1 = r1.getDocValue()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0078
            r0 = 1
        L_0x00b3:
            android.content.Context r7 = r6.getContext()
            net.one97.paytm.upgradeKyc.utils.j.a((android.content.Context) r7, (boolean) r2)
            if (r0 == 0) goto L_0x00c8
            net.one97.paytm.upgradeKyc.kycV3.c.l r6 = r6.f65720e
            if (r6 != 0) goto L_0x00c5
            java.lang.String r7 = "viewModel"
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x00c5:
            r6.b()
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.d.n.a(net.one97.paytm.upgradeKyc.d.n, net.one97.paytm.common.entity.CJRAadharPanSave):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.p;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

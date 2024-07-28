package net.one97.paytm.upgradeKyc.videokyc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRAadharPanDocList;
import net.one97.paytm.common.entity.CJRAadharPanSave;
import net.one97.paytm.common.entity.upgradeKyc.DocData;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.InPersonVerification;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upgradeKyc.utils.l;
import net.one97.paytm.upgradeKyc.videokyc.a.e;

public final class AddPanVideoKycActivity extends UpgradeKycBaseActivity implements e.b {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.videokyc.b.b f66413a;

    /* renamed from: b  reason: collision with root package name */
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> f66414b = new e(this);

    /* renamed from: d  reason: collision with root package name */
    private HashMap f66415d;

    public final View a(int i2) {
        if (this.f66415d == null) {
            this.f66415d = new HashMap();
        }
        View view = (View) this.f66415d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f66415d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return -1;
    }

    static final class e<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddPanVideoKycActivity f66420a;

        e(AddPanVideoKycActivity addPanVideoKycActivity) {
            this.f66420a = addPanVideoKycActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            String statusMessage;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            String str = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = a.f66451a[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66420a.a(R.id.wallet_loader));
                    CJRAadharPanSave cJRAadharPanSave = (CJRAadharPanSave) bVar.f66169b;
                    if (cJRAadharPanSave == null || (statusMessage = cJRAadharPanSave.getStatusMessage()) == null || !p.a(statusMessage, "success", true)) {
                        CJRAadharPanSave cJRAadharPanSave2 = (CJRAadharPanSave) bVar.f66169b;
                        if (!TextUtils.isEmpty(cJRAadharPanSave2 != null ? cJRAadharPanSave2.getErrorErrorMessage() : null)) {
                            AddPanVideoKycActivity addPanVideoKycActivity = this.f66420a;
                            CJRAadharPanSave cJRAadharPanSave3 = (CJRAadharPanSave) bVar.f66169b;
                            if (cJRAadharPanSave3 != null) {
                                str = cJRAadharPanSave3.getErrorErrorMessage();
                            }
                            if (str == null) {
                                k.a();
                            }
                            Snackbar.a((View) (RelativeLayout) addPanVideoKycActivity.a(R.id.parent_layout), (CharSequence) str, -1).c();
                            return;
                        }
                        CJRAadharPanSave cJRAadharPanSave4 = (CJRAadharPanSave) bVar.f66169b;
                        if (!TextUtils.isEmpty(cJRAadharPanSave4 != null ? cJRAadharPanSave4.getErrorMessage() : null)) {
                            AddPanVideoKycActivity addPanVideoKycActivity2 = this.f66420a;
                            CJRAadharPanSave cJRAadharPanSave5 = (CJRAadharPanSave) bVar.f66169b;
                            if (cJRAadharPanSave5 != null) {
                                str = cJRAadharPanSave5.getErrorMessage();
                            }
                            if (str == null) {
                                k.a();
                            }
                            Snackbar.a((View) (RelativeLayout) addPanVideoKycActivity2.a(R.id.parent_layout), (CharSequence) str, -1).c();
                            return;
                        }
                        AddPanVideoKycActivity addPanVideoKycActivity3 = this.f66420a;
                        String string = addPanVideoKycActivity3.getString(R.string.some_went_wrong);
                        k.a((Object) string, "getString(R.string.some_went_wrong)");
                        Snackbar.a((View) (RelativeLayout) addPanVideoKycActivity3.a(R.id.parent_layout), (CharSequence) string, -1).c();
                        return;
                    }
                    if (bVar.f66169b != null) {
                        ResultType resulttype = bVar.f66169b;
                        if (resulttype == null) {
                            k.a();
                        }
                        if (((CJRAadharPanSave) resulttype).getDocuments() != null) {
                            ResultType resulttype2 = bVar.f66169b;
                            if (resulttype2 == null) {
                                k.a();
                            }
                            if (((CJRAadharPanSave) resulttype2).getDocuments().size() > 0) {
                                ResultType resulttype3 = bVar.f66169b;
                                if (resulttype3 == null) {
                                    k.a();
                                }
                                for (CJRAadharPanDocList next : ((CJRAadharPanSave) resulttype3).getDocuments()) {
                                    if (next != null && next.getDocCode() != null && p.a(next.getDocCode(), "pan", true)) {
                                        String editableAction = next.getEditableAction();
                                        if (editableAction != null) {
                                            int hashCode = editableAction.hashCode();
                                            if (hashCode != -10211755) {
                                                if (hashCode == 23774884 ? editableAction.equals("NON_EDITABLE_WAITING") : !(hashCode != 1584648101 || !editableAction.equals("NON_EDITABLE_TICKED"))) {
                                                    j.a("AdditionalDoc");
                                                    AddPanVideoKycActivity.c(this.f66420a);
                                                    return;
                                                }
                                            } else if (editableAction.equals("EDITABLE_EXCLAMATED")) {
                                                AddPanVideoKycActivity addPanVideoKycActivity4 = this.f66420a;
                                                g.b(addPanVideoKycActivity4, addPanVideoKycActivity4.getString(R.string.error), next.getEditableActionMsg());
                                                return;
                                            }
                                        }
                                        AddPanVideoKycActivity addPanVideoKycActivity5 = this.f66420a;
                                        String string2 = addPanVideoKycActivity5.getString(R.string.some_went_wrong);
                                        k.a((Object) string2, "getString(R.string.some_went_wrong)");
                                        Snackbar.a((View) (RelativeLayout) addPanVideoKycActivity5.a(R.id.parent_layout), (CharSequence) string2, -1).c();
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                    }
                    AddPanVideoKycActivity addPanVideoKycActivity6 = this.f66420a;
                    String string3 = addPanVideoKycActivity6.getString(R.string.some_went_wrong);
                    k.a((Object) string3, "getString(R.string.some_went_wrong)");
                    Snackbar.a((View) (RelativeLayout) addPanVideoKycActivity6.a(R.id.parent_layout), (CharSequence) string3, -1).c();
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66420a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context = this.f66420a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        k.a();
                    }
                    if (!l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66420a.a(R.id.wallet_loader));
                        AddPanVideoKycActivity addPanVideoKycActivity7 = this.f66420a;
                        String string4 = addPanVideoKycActivity7.getString(R.string.some_went_wrong);
                        k.a((Object) string4, "getString(R.string.some_went_wrong)");
                        Snackbar.a((View) (RelativeLayout) addPanVideoKycActivity7.a(R.id.parent_layout), (CharSequence) string4, -1).c();
                    }
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.videokyc.b.b b(AddPanVideoKycActivity addPanVideoKycActivity) {
        net.one97.paytm.upgradeKyc.videokyc.b.b bVar = addPanVideoKycActivity.f66413a;
        if (bVar == null) {
            k.a("viewModel");
        }
        return bVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f66413a = (net.one97.paytm.upgradeKyc.videokyc.b.b) net.one97.paytm.upgradeKyc.kycV3.b.a((AppCompatActivity) this, net.one97.paytm.upgradeKyc.videokyc.b.b.class);
        net.one97.paytm.upgradeKyc.videokyc.b.b bVar = this.f66413a;
        if (bVar == null) {
            k.a("viewModel");
        }
        bVar.f66462b.observe(this, this.f66414b);
        TextInputEditText textInputEditText = (TextInputEditText) a(R.id.etpan);
        k.a((Object) textInputEditText, "etpan");
        textInputEditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        ((TextInputEditText) a(R.id.etpan)).addTextChangedListener(new a(this));
        ((Button) a(R.id.activity_verify_doc_button_proceed)).setOnClickListener(new b(this));
        ((TextView) a(R.id.tv_dont_have_pan)).setOnClickListener(new c(this));
        ((ImageView) a(R.id.iv_back_btn)).setOnClickListener(new d(this));
    }

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddPanVideoKycActivity f66416a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        a(AddPanVideoKycActivity addPanVideoKycActivity) {
            this.f66416a = addPanVideoKycActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f66416a.a(R.id.til_enter_pan);
            k.a((Object) textInputLayout, "til_enter_pan");
            textInputLayout.setErrorEnabled(false);
            this.f66416a.b("pan_entered", "/kyc/video_kyc/pan_verify");
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddPanVideoKycActivity f66417a;

        b(AddPanVideoKycActivity addPanVideoKycActivity) {
            this.f66417a = addPanVideoKycActivity;
        }

        public final void onClick(View view) {
            this.f66417a.b("proceed_button_clicked", "/kyc/video_kyc/pan_verify");
            if (this.f66417a.f()) {
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66417a.a(R.id.wallet_loader));
                net.one97.paytm.upgradeKyc.videokyc.b.b b2 = AddPanVideoKycActivity.b(this.f66417a);
                TextInputEditText textInputEditText = (TextInputEditText) this.f66417a.a(R.id.etpan);
                k.a((Object) textInputEditText, "etpan");
                String valueOf = String.valueOf(textInputEditText.getText());
                k.c(valueOf, "panNo");
                b2.f66461a.setValue(new DocData("pan", valueOf, (String) null, 4, (kotlin.g.b.g) null));
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddPanVideoKycActivity f66418a;

        c(AddPanVideoKycActivity addPanVideoKycActivity) {
            this.f66418a = addPanVideoKycActivity;
        }

        public final void onClick(View view) {
            this.f66418a.b("form60_request", "/kyc/video_kyc/pan_verify");
            e.a aVar = net.one97.paytm.upgradeKyc.videokyc.a.e.f66377a;
            new net.one97.paytm.upgradeKyc.videokyc.a.e().show(this.f66418a.getSupportFragmentManager(), net.one97.paytm.upgradeKyc.videokyc.a.e.class.getName());
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddPanVideoKycActivity f66419a;

        d(AddPanVideoKycActivity addPanVideoKycActivity) {
            this.f66419a = addPanVideoKycActivity;
        }

        public final void onClick(View view) {
            this.f66419a.b("go_back_clicked", "/kyc/video_kyc/pan_verify");
            e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            e.a.b().a((Activity) this.f66419a);
        }
    }

    public final int a() {
        return R.layout.activity_add_pan_video_kyc;
    }

    /* access modifiers changed from: private */
    public final boolean f() {
        TextInputEditText textInputEditText = (TextInputEditText) a(R.id.etpan);
        k.a((Object) textInputEditText, "etpan");
        if (TextUtils.isEmpty(textInputEditText.getText())) {
            TextInputEditText textInputEditText2 = (TextInputEditText) a(R.id.etpan);
            k.a((Object) textInputEditText2, "etpan");
            a((EditText) textInputEditText2);
            TextInputLayout textInputLayout = (TextInputLayout) a(R.id.til_enter_pan);
            k.a((Object) textInputLayout, "til_enter_pan");
            textInputLayout.setErrorEnabled(true);
            TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.til_enter_pan);
            k.a((Object) textInputLayout2, "til_enter_pan");
            textInputLayout2.setError(getString(R.string.empty_pan_error));
            return false;
        }
        TextInputEditText textInputEditText3 = (TextInputEditText) a(R.id.etpan);
        k.a((Object) textInputEditText3, "etpan");
        if (String.valueOf(textInputEditText3.getText()).length() >= 10) {
            TextInputEditText textInputEditText4 = (TextInputEditText) a(R.id.etpan);
            k.a((Object) textInputEditText4, "etpan");
            if (com.paytm.utility.b.W(String.valueOf(textInputEditText4.getText()))) {
                return true;
            }
        }
        TextInputLayout textInputLayout3 = (TextInputLayout) a(R.id.til_enter_pan);
        k.a((Object) textInputLayout3, "til_enter_pan");
        textInputLayout3.setError(getString(R.string.invalid_pan_error));
        TextInputEditText textInputEditText5 = (TextInputEditText) a(R.id.etpan);
        k.a((Object) textInputEditText5, "etpan");
        a((EditText) textInputEditText5);
        return false;
    }

    private final void a(EditText editText) {
        try {
            Object systemService = getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d() {
        startActivity(new Intent(this, InPersonVerification.class));
        finish();
    }

    public final void e() {
        e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
        if (!j.f(e.a.b().a())) {
            startActivity(new Intent(this, Form60VideoKycActivity.class));
        } else {
            startActivity(new Intent(this, InPersonVerification.class));
        }
        finish();
    }

    public static final /* synthetic */ void c(AddPanVideoKycActivity addPanVideoKycActivity) {
        addPanVideoKycActivity.startActivity(new Intent(addPanVideoKycActivity, VideoKycActivity.class));
        addPanVideoKycActivity.finish();
    }
}

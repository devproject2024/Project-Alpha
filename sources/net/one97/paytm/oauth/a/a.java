package net.one97.paytm.oauth.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.b;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.a.b;
import net.one97.paytm.oauth.e;
import net.one97.paytm.oauth.e.h;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.upi.util.Events;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f52465b = (!a.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    public h f52466a;

    /* renamed from: c  reason: collision with root package name */
    private b f52467c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public BottomSheetBehavior f52468d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Button f52469e;

    /* renamed from: f  reason: collision with root package name */
    private View f52470f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextInputLayout f52471g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public AppCompatEditText f52472h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f52473i;
    /* access modifiers changed from: private */
    public TextView j;
    /* access modifiers changed from: private */
    public View k;
    /* access modifiers changed from: private */
    public String l;
    private LottieAnimationView m;
    /* access modifiers changed from: private */
    public TextWatcher n = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            if (!editable.toString().startsWith("+91 ")) {
                a.this.f52472h.setText("+91 ");
                Selection.setSelection(a.this.f52472h.getText(), a.this.f52472h.getText().length());
            }
            a.this.f52471g.setError((CharSequence) null);
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BottomSheetDialogStyle);
        this.f52467c = (b) am.a((Fragment) this).a(b.class);
        setCancelable(false);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior unused = a.this.f52468d = BottomSheetBehavior.from(frameLayout);
                }
                a.this.f52468d.setState(3);
                a.this.f52468d.setPeekHeight(500);
            }
        });
        return aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.bottomsheet_add_mobile, viewGroup, false);
        this.m = (LottieAnimationView) inflate.findViewById(R.id.lottie_loader);
        this.f52469e = (Button) inflate.findViewById(R.id.btnProceed);
        this.f52470f = inflate.findViewById(R.id.progressView);
        this.f52471g = (TextInputLayout) inflate.findViewById(R.id.til_mobile);
        this.f52472h = (AppCompatEditText) inflate.findViewById(R.id.et_mobile);
        this.f52472h.setText("+91 ");
        AppCompatEditText appCompatEditText = this.f52472h;
        appCompatEditText.setSelection(appCompatEditText.getText().length());
        this.f52472h.addTextChangedListener(this.n);
        this.f52473i = (TextView) inflate.findViewById(R.id.message);
        this.j = (TextView) inflate.findViewById(R.id.msg_benefit);
        this.k = inflate.findViewById(R.id.resend_otp);
        this.k.setOnClickListener(this);
        this.f52469e.setOnClickListener(this);
        inflate.findViewById(R.id.login_with_account).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("mobile_number");
                a.this.a("login_to_a_diff_account", (ArrayList<String>) arrayList);
                a.this.dismissAllowingStateLoss();
                if (a.this.f52466a != null) {
                    a.this.f52466a.a();
                }
            }
        });
        getDialog().setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior from = BottomSheetBehavior.from(((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet));
                from.setState(3);
                from.setHideable(false);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public void a(final String str) {
        a();
        b bVar = this.f52467c;
        Context context = getContext();
        y yVar = new y();
        b.AnonymousClass1 r3 = new com.paytm.network.listener.b(yVar) {

            /* renamed from: a */
            final /* synthetic */ y f52484a;

            public final void onApiSuccess(
/*
Method generation error in method: net.one97.paytm.oauth.a.b.1.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes4.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.oauth.a.b.1.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/

            public final void handleErrorCode(
/*
Method generation error in method: net.one97.paytm.oauth.a.b.1.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes4.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.oauth.a.b.1.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        };
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("updatePhoneV2");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(context, a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Authorization", OauthModule.a().f52576c);
            hashMap.put("session_token", OauthModule.b().getSSOToken());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ContactColumn.PHONE_NUMBER, str);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            com.paytm.network.b a3 = net.one97.paytm.oauth.b.b.a(a.class.getName());
            a3.n = a.b.SILENT;
            a3.f42879c = a.C0715a.PUT;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = jSONObject.toString();
            a3.j = r3;
            a3.f42885i = new SimplifiedLoginInit();
            com.paytm.network.a l2 = a3.l();
            l2.f42860d = true;
            if (!com.paytm.network.b.b.a(context)) {
                r3.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l2.a();
            }
        }
        yVar.observe(this, new z<e<IJRPaytmDataModel>>() {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f52478a = (!a.class.desiredAssertionStatus());

            public final /* synthetic */ void onChanged(Object obj) {
                e eVar = (e) obj;
                if (f52478a || eVar != null) {
                    a.this.b();
                    if (eVar.f52602a == 101) {
                        SimplifiedLoginInit simplifiedLoginInit = (SimplifiedLoginInit) eVar.f52603b;
                        if ("SUCCESS".equals(simplifiedLoginInit.getStatus())) {
                            a.this.f52472h.removeTextChangedListener(a.this.n);
                            String unused = a.this.l = simplifiedLoginInit.getStateToken();
                            a.this.f52473i.setText(a.this.getString(R.string.txt_verify_number, str));
                            a.this.j.setText(R.string.msg_otp_sent);
                            a.this.f52472h.setText("");
                            a.this.f52471g.setHint(a.this.getString(R.string.hint_enter_otp));
                            a.this.f52469e.setText(R.string.btn_verify);
                            a.this.f52472h.setInputType(524290);
                            if (Build.VERSION.SDK_INT >= 26) {
                                a.this.f52472h.setImportantForAutofill(0);
                            }
                            a.this.k.setVisibility(0);
                        } else if (!TextUtils.isEmpty(simplifiedLoginInit.getMessage())) {
                            a.this.f52471g.setError(simplifiedLoginInit.getMessage());
                        } else {
                            com.paytm.utility.b.b((Context) a.this.getActivity(), (String) null, a.this.getString(R.string.some_went_wrong));
                        }
                    } else if (eVar.f52602a == 102) {
                        a.this.a((ErrorModel) eVar.f52603b, eVar.f52604c);
                    }
                } else {
                    throw new AssertionError();
                }
            }
        });
    }

    public final void a(ErrorModel errorModel, Throwable th) {
        String str;
        if (!OAuthUtils.a((Activity) getActivity(), (Fragment) this, (NetworkCustomError) th)) {
            String str2 = null;
            if (!(th instanceof NetworkCustomError) || errorModel.getStatus() != -1) {
                str = getString(R.string.some_went_wrong);
            } else {
                str2 = getString(R.string.no_connection);
                str = getString(R.string.no_internet);
            }
            OAuthUtils.a(getActivity(), str2, str, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    a aVar = a.this;
                    aVar.a(aVar.f52472h.getText().toString());
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(e eVar) {
        if (f52465b || eVar != null) {
            b();
            if (eVar.f52602a == 102) {
                a((ErrorModel) eVar.f52603b, eVar.f52604c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnProceed) {
            if (this.l == null) {
                String str = "";
                if (!TextUtils.isEmpty(this.f52472h.getText().toString())) {
                    str = this.f52472h.getText().toString().replace("+91 ", str).trim();
                }
                if (TextUtils.isEmpty(str)) {
                    this.f52471g.setError(getString(R.string.mobile_empty_msg));
                    String string = getString(R.string.mobile_empty_msg);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("mobile_number");
                    arrayList.add(string);
                    a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) arrayList);
                } else if (!OAuthUtils.a(str)) {
                    this.f52471g.setError(getString(R.string.msg_invalid_mobile));
                    String string2 = getString(R.string.msg_invalid_mobile);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add("mobile_number");
                    arrayList2.add(string2);
                    a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) arrayList2);
                } else {
                    OAuthUtils.a((Activity) getActivity());
                    a(this.f52472h.getText().toString());
                }
            } else {
                String obj = this.f52472h.getText().toString();
                if (!OAuthUtils.d(obj)) {
                    this.f52471g.setError(getString(R.string.invalid_otp));
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add("otp");
                    arrayList3.add(getString(R.string.invalid_otp));
                    a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) arrayList3);
                    return;
                }
                a();
                this.f52467c.a(getContext(), obj, this.l).observe(this, new z<e<IJRPaytmDataModel>>() {

                    /* renamed from: a  reason: collision with root package name */
                    static final /* synthetic */ boolean f52482a = (!a.class.desiredAssertionStatus());

                    public final /* synthetic */ void onChanged(Object obj) {
                        e eVar = (e) obj;
                        if (f52482a || eVar != null) {
                            a.this.b();
                            if (eVar.f52602a == 101) {
                                SimplifiedLoginInit simplifiedLoginInit = (SimplifiedLoginInit) eVar.f52603b;
                                if (simplifiedLoginInit.getResponseCode().equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                                    a.this.dismiss();
                                } else if (simplifiedLoginInit.getResponseCode().equals("407") || simplifiedLoginInit.getResponseCode().equals("762") || simplifiedLoginInit.getResponseCode().equals("708") || simplifiedLoginInit.getResponseCode().equals("3007") || simplifiedLoginInit.getResponseCode().equals("3005")) {
                                    com.paytm.utility.b.b((Context) a.this.getActivity(), (String) null, simplifiedLoginInit.getMessage());
                                } else {
                                    com.paytm.utility.b.b((Context) a.this.getActivity(), (String) null, a.this.getString(R.string.some_went_wrong));
                                }
                            } else if (eVar.f52602a == 102) {
                                a.this.a((ErrorModel) eVar.f52603b, eVar.f52604c);
                            }
                        } else {
                            throw new AssertionError();
                        }
                    }
                });
            }
        } else if (view.getId() == R.id.resend_otp) {
            String str2 = this.l;
            a();
            this.f52467c.a(getContext(), str2, false).observe(this, new z() {
                public final void onChanged(Object obj) {
                    a.this.a((e) obj);
                }
            });
        }
    }

    private void a() {
        this.f52470f.setVisibility(0);
        OAuthUtils.a(this.m);
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f52470f.setVisibility(8);
        OAuthUtils.b(this.m);
    }

    /* access modifiers changed from: private */
    public void a(String str, ArrayList<String> arrayList) {
        OauthModule.b().sendGAMultipleLabelEvent(getContext(), "add_number_email_only", str, arrayList, (String) null, "/add_number_email_only", p.f56796a);
    }
}

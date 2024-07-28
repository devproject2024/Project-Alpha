package com.travel.bus.busticket.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.R;
import com.travel.bus.busticket.a.z;
import com.travel.bus.busticket.activity.AJRBusBusinessUser;
import com.travel.bus.busticket.activity.AJRBusSearchSRPActivity;
import com.travel.bus.busticket.activity.AJRBusSelectSeatsActivity;
import com.travel.bus.busticket.activity.AJRBusSelectSeatsOnBlockActivity;
import com.travel.bus.busticket.activity.AJRBusTravellerDetailsActivity;
import com.travel.bus.busticket.activity.AJRBusWebViewActivity;
import com.travel.bus.busticket.b.e;
import com.travel.bus.busticket.b.f;
import com.travel.bus.busticket.g.j;
import com.travel.bus.busticket.i.o;
import com.travel.bus.busticket.i.s;
import com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRBusTravellerExtraDetailsFieldModel;
import com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDropdownOptionsModel;
import com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDynamicFormFieldRootModel;
import com.travel.bus.pojo.busticket.CJRBusInsuranceItem;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;
import com.travel.bus.pojo.busticket.CJRBusUserDeleteProfile;
import com.travel.bus.pojo.busticket.CJRBusUserProfile;
import com.travel.bus.pojo.busticket.CJRLocation;
import com.travel.bus.pojo.busticket.CJRNewErrorFormat;
import com.travel.bus.pojo.busticket.CJRPassengerDetails;
import com.travel.bus.pojo.busticket.TripBusDetail;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import com.travel.bus.pojo.common.entity.travel.CJRBusTpUserProfileContact;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONObject;

public class m extends h implements CompoundButton.OnCheckedChangeListener, Response.ErrorListener, Response.Listener<IJRDataModel>, b, e, f {
    private HashMap<String, CJRBusSearchOperatorTagInfo> A = null;
    private String B;
    private double C;
    /* access modifiers changed from: private */
    public int D;
    /* access modifiers changed from: private */
    public HashMap<Integer, CJRBusTpUserProfileContact> E = new HashMap<>();
    private ArrayList<CJRBusTpUserProfileContact> F = new ArrayList<>();
    private ArrayList<CJRBusTpUserProfileContact> G;
    private ArrayList<CJRBusTpUserProfileContact> H;
    private RelativeLayout I;
    private LinearLayout J;
    /* access modifiers changed from: private */
    public String K;
    /* access modifiers changed from: private */
    public String L;
    private CJRDynamicFormFieldRootModel M;
    private ArrayList<String> N;
    /* access modifiers changed from: private */
    public String O;
    /* access modifiers changed from: private */
    public String P;
    /* access modifiers changed from: private */
    public String Q;
    private boolean R;
    /* access modifiers changed from: private */
    public HashMap<String, String> S;
    private com.travel.bus.busticket.f.h T;
    private CJRBusUserProfile U;
    private CheckBox V;
    private ImageButton W;
    private ConstraintLayout X;
    /* access modifiers changed from: private */
    public String Y = "";
    /* access modifiers changed from: private */
    public String Z = "";

    /* renamed from: a  reason: collision with root package name */
    String f22299a = "";
    /* access modifiers changed from: private */
    public String aa = "";
    /* access modifiers changed from: private */
    public String ab = "";
    /* access modifiers changed from: private */
    public String ac = "";
    /* access modifiers changed from: private */
    public String ad = "";
    /* access modifiers changed from: private */
    public String ae = "";
    /* access modifiers changed from: private */
    public String af = "";
    /* access modifiers changed from: private */
    public Dialog ag = null;
    /* access modifiers changed from: private */
    public boolean ah = false;

    /* renamed from: b  reason: collision with root package name */
    private View f22300b;

    /* renamed from: c  reason: collision with root package name */
    private j f22301c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f22302d;

    /* renamed from: e  reason: collision with root package name */
    private EditText f22303e;

    /* renamed from: f  reason: collision with root package name */
    private EditText f22304f;

    /* renamed from: g  reason: collision with root package name */
    private View f22305g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CheckBox f22306h;

    /* renamed from: i  reason: collision with root package name */
    private RoboTextView f22307i;
    private RoboTextView j;
    /* access modifiers changed from: private */
    public AlertDialog k;
    private CheckBox l;
    private RoboTextView m;
    private Button n;
    private ScrollView o;
    private ArrayList<TripBusDetailsItem> p;
    private TripBusDetail q;
    /* access modifiers changed from: private */
    public CJRBusSearchInput r;
    /* access modifiers changed from: private */
    public CJRBusSearchItem s;
    private CJRLocation t;
    private CJRLocation u;
    /* access modifiers changed from: private */
    public ArrayList<CJRPassengerDetails> v;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    /* access modifiers changed from: private */
    public CJRBusInsuranceItem z;

    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
    }

    public /* bridge */ /* synthetic */ void onResponse(Object obj) {
    }

    public static m b(Bundle bundle) {
        m mVar = new m();
        mVar.setArguments(bundle);
        return mVar;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        a.b(context);
        if (context instanceof AJRBusTravellerDetailsActivity) {
            this.T = (com.travel.bus.busticket.f.h) context;
        }
    }

    public void onResume() {
        super.onResume();
        a.b((Context) getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        this.f22300b = layoutInflater.inflate(R.layout.pre_b_bus_new_passenger_view, (ViewGroup) null);
        ResourceUtils.loadBusImagesFromCDN((ImageView) this.f22300b.findViewById(R.id.passenger_id_card), "travellers_id_ic.png", false, false, n.a.V1);
        this.f22301c = new j(this);
        this.J = (LinearLayout) this.f22300b.findViewById(R.id.msgLyt);
        this.I = (RelativeLayout) this.f22300b.findViewById(R.id.lyt_progress_bar);
        if (com.paytm.utility.b.r(getContext())) {
            new Handler().post(new Runnable() {
                public final void run() {
                    m.this.i();
                }
            });
        }
        this.f22302d = (LinearLayout) this.f22300b.findViewById(R.id.passenger_details_view);
        TextView textView = (TextView) this.f22300b.findViewById(R.id.termscondition_text);
        SpannableString spannableString = new SpannableString("By clicking on proceed you are agreeing to all Terms and Conditions");
        AnonymousClass8 r0 = new ClickableSpan() {
            public final void onClick(View view) {
                m.i(m.this);
            }

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(androidx.core.content.b.c(m.this.getActivity(), R.color.bus_color_00b8f8));
                textPaint.setUnderlineText(false);
            }
        };
        spannableString.setSpan(r0, 47, 67, 0);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        if (textView.getLineCount() > 1) {
            SpannableString spannableString2 = new SpannableString(Resources.getSystem().getString(R.string.terms_and_condtions_travellers_page_for_small_screen));
            spannableString2.setSpan(r0, 47, 50, 0);
            textView.setText(spannableString2);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (!this.q.getMeta().isExtraPaxDetailsRequired()) {
            d();
        }
        this.f22303e = (EditText) this.f22300b.findViewById(R.id.traveller_mobile_edittext);
        this.f22304f = (EditText) this.f22300b.findViewById(R.id.traveller_email_edittext);
        if (com.paytm.utility.b.m((Context) getActivity()) != null) {
            this.f22304f.setText(com.paytm.utility.b.m((Context) getActivity()));
        } else {
            FragmentActivity activity = getActivity();
            com.travel.bus.a.a();
            String[] split = com.travel.bus.b.a.a(com.travel.bus.a.b().D()).b("email_bus", "", false).split(AppConstants.COLON);
            if (split == null || split.length <= 1) {
                str = "";
                str2 = str;
            } else {
                str2 = split[0];
                str = split[1];
            }
            if (!str2.equalsIgnoreCase(com.paytm.utility.b.n((Context) activity))) {
                str = "";
            }
            if (!str.isEmpty()) {
                this.f22304f.setText(str);
            }
        }
        if (com.paytm.utility.b.l((Context) getActivity()) != null) {
            this.f22303e.setText(com.paytm.utility.b.l((Context) getActivity()));
        }
        this.f22303e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                m.this.d(view);
            }
        });
        this.f22304f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                m.this.c(view);
            }
        });
        this.f22303e.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                m.this.b(view, z);
            }
        });
        this.f22304f.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                m.this.a(view, z);
            }
        });
        this.f22305g = this.f22300b.findViewById(R.id.insurance_option_view);
        this.f22305g.setVisibility(8);
        this.f22306h = (CheckBox) this.f22300b.findViewById(R.id.insurance_option);
        this.f22306h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                m.this.a(compoundButton, z);
            }
        });
        this.f22307i = (RoboTextView) this.f22300b.findViewById(R.id.insurance_text_view);
        this.j = (RoboTextView) this.f22300b.findViewById(R.id.insurance_text_view_title);
        this.l = (CheckBox) this.f22300b.findViewById(R.id.terms_conditions_option);
        this.l.setOnCheckedChangeListener(this);
        this.m = (RoboTextView) this.f22300b.findViewById(R.id.busbook_terms_conditions_edittext);
        this.m.setVisibility(8);
        this.n = (Button) this.f22300b.findViewById(R.id.proceed_btn);
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                m.this.f(view);
            }
        });
        this.o = (ScrollView) this.f22300b.findViewById(R.id.traveller_container_scroll);
        this.V = (CheckBox) this.f22300b.findViewById(R.id.cbBusinessUser);
        this.W = (ImageButton) this.f22300b.findViewById(R.id.ibArrowBusinessUser);
        this.W.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(m.this.getActivity(), AJRBusBusinessUser.class);
                intent.putExtra("BUSINESS_GST", m.this.Y);
                intent.putExtra("BUSINESS_COMPANY", m.this.Z);
                intent.putExtra("BUSINESS_FLAT", m.this.aa);
                intent.putExtra("BUSINESS_STREET", m.this.ab);
                intent.putExtra("BUSINESS_EMAIL", m.this.af);
                intent.putExtra("BUSINESS_PIN", m.this.ac);
                intent.putExtra("BUSINESS_STATE", m.this.ad);
                intent.putExtra("BUSINESS_CITY", m.this.ae);
                m.this.startActivityForResult(intent, 101);
            }
        });
        this.X = (ConstraintLayout) this.f22300b.findViewById(R.id.clBusinessUser);
        this.X.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                m.this.e(view);
            }
        });
        com.travel.bus.a.a();
        if (com.travel.bus.a.b().q() && this.q.getMeta().isExtraPaxDetailsRequired()) {
            getActivity();
            e();
            String a2 = j.a(this.r, this.s, this.B);
            j jVar = this.f22301c;
            com.travel.bus.a.a();
            String w2 = com.travel.bus.a.b().w();
            HashMap hashMap = new HashMap();
            hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(jVar.f22395b));
            hashMap.put("Content-Type", "application/json");
            j.a(jVar.f22395b, w2, hashMap, a2, a.C0715a.POST, new CJRDynamicFormFieldRootModel(), new b() {
                public final void onApiSuccess(
/*
Method generation error in method: com.travel.bus.busticket.g.j.2.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes12.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.travel.bus.busticket.g.j.2.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
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
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
Method generation error in method: com.travel.bus.busticket.g.j.2.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes12.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.travel.bus.busticket.g.j.2.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
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
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
            });
        }
        if (this.q.getMeta() == null || !this.q.getMeta().getIsBusinessUser()) {
            this.y = false;
            this.X.setVisibility(8);
        } else {
            this.y = true;
            this.X.setVisibility(0);
        }
        return this.f22300b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        Intent intent = new Intent(getActivity(), AJRBusBusinessUser.class);
        intent.putExtra("BUSINESS_GST", this.Y);
        intent.putExtra("BUSINESS_COMPANY", this.Z);
        intent.putExtra("BUSINESS_FLAT", this.aa);
        intent.putExtra("BUSINESS_STREET", this.ab);
        intent.putExtra("BUSINESS_EMAIL", this.af);
        intent.putExtra("BUSINESS_PIN", this.ac);
        intent.putExtra("BUSINESS_STATE", this.ad);
        intent.putExtra("BUSINESS_CITY", this.ae);
        startActivityForResult(intent, 101);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        Class<m> cls = m.class;
        if (getActivity() != null && isAdded() && isVisible()) {
            CJRBusUserProfile cJRBusUserProfile = this.U;
            if (cJRBusUserProfile == null) {
                com.travel.bus.busticket.i.n.a();
                com.travel.bus.busticket.i.n.a(getContext(), com.travel.bus.pojo.common.entity.travel.a.buses, this);
                cls.getSimpleName();
                return;
            }
            a(cJRBusUserProfile);
            cls.getSimpleName();
        }
    }

    private boolean a(CJRPassengerDetails cJRPassengerDetails) {
        String str;
        String str2;
        String str3;
        boolean z2;
        String idCardValue = cJRPassengerDetails.getIdCardValue();
        CJRBusTravellerExtraDetailsFieldModel travellerExtraDetailsFieldModel = cJRPassengerDetails.getTravellerExtraDetailsFieldModel();
        if (travellerExtraDetailsFieldModel != null) {
            z2 = travellerExtraDetailsFieldModel.isRequired();
            str3 = travellerExtraDetailsFieldModel.getLabel();
            str2 = travellerExtraDetailsFieldModel.getError_text();
            str = travellerExtraDetailsFieldModel.getRegex();
        } else {
            str = null;
            str3 = null;
            str2 = null;
            z2 = false;
        }
        if (!z2 || !TextUtils.isEmpty(idCardValue)) {
            StringBuilder sb = new StringBuilder("Default regex for  in validation ");
            sb.append(this.P);
            sb.append("   >>>>> ");
            sb.append(this.O);
            if (!z2 || TextUtils.isEmpty(str) || Pattern.compile(str).matcher(idCardValue).matches()) {
                return false;
            }
            com.paytm.utility.b.b((Context) getActivity(), str3 + " is incorrect", str2);
            return true;
        }
        com.paytm.utility.b.b((Context) getActivity(), str3 + " is missing", "Please enter ".concat(String.valueOf(str3)));
        return true;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_passenger");
        hashMap.put("event_action", "error_popup");
        hashMap.put("event_label", str);
        hashMap.put("event_label2", " ");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-traveller");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
    }

    private boolean a(String str, boolean z2) {
        if (z2) {
            if (Pattern.compile(com.business.merchant_payments.common.utility.AppConstants.EMAIL_REG_EX).matcher(str).matches()) {
                return false;
            }
            com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.bus_incorrect_email_id_title), getResources().getString(R.string.msg_invalid_passenger_email_id));
            c(getResources().getString(R.string.bus_incorrect_email_id_title));
            a(getResources().getString(R.string.bus_incorrect_email_id_title));
            return true;
        } else if (Pattern.compile("^([1-9]{1}+[0-9]{9})$").matcher(str).matches()) {
            return false;
        } else {
            com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.special_characters_title), getResources().getString(R.string.msg_invalid_passenger_mobile_number));
            c(getResources().getString(R.string.msg_invalid_passenger_mobile_number));
            a(getResources().getString(R.string.msg_invalid_passenger_mobile_number));
            return true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        e("contact");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        e(com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        this.w = z2;
    }

    private void b() {
        ArrayList<TripBusDetailsItem> arrayList = this.p;
        if (arrayList != null && arrayList.size() > 0) {
            this.C = 0.0d;
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                TripBusDetailsItem tripBusDetailsItem = this.p.get(i2);
                if (tripBusDetailsItem != null) {
                    this.C += Double.parseDouble(tripBusDetailsItem.getFare());
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f9, code lost:
        if ((r2 > ((double) com.travel.bus.a.b().j())) != false) goto L_0x00fd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r7, com.paytm.network.model.IJRPaytmDataModel r8) {
        /*
            r6 = this;
            r0 = 1
            if (r7 == 0) goto L_0x00b9
            if (r7 == r0) goto L_0x00b8
            r0 = 2
            if (r7 == r0) goto L_0x00b5
            r1 = 3
            if (r7 == r1) goto L_0x0020
            r0 = 5
            if (r7 == r0) goto L_0x0010
            goto L_0x00b4
        L_0x0010:
            r6.f()
            boolean r7 = r8 instanceof com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDynamicFormFieldRootModel
            if (r7 == 0) goto L_0x00b4
            com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDynamicFormFieldRootModel r8 = (com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDynamicFormFieldRootModel) r8
            r6.M = r8
            r6.d()
            goto L_0x00b4
        L_0x0020:
            boolean r7 = r8 instanceof com.travel.bus.pojo.busticket.CJRBlockOneResponse
            if (r7 == 0) goto L_0x00b4
            com.travel.bus.pojo.busticket.CJRBlockOneResponse r8 = (com.travel.bus.pojo.busticket.CJRBlockOneResponse) r8
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r7 = r6.v
            androidx.fragment.app.FragmentActivity r1 = r6.getActivity()
            if (r1 == 0) goto L_0x00b4
            android.content.Intent r1 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r2 = r6.getActivity()
            java.lang.Class<com.travel.bus.busticket.activity.AJRConfirmBookingActivity> r3 = com.travel.bus.busticket.activity.AJRConfirmBookingActivity.class
            r1.<init>(r2, r3)
            com.travel.bus.pojo.busticket.CJRBusSearchInput r2 = r6.r
            java.lang.String r3 = "intent_extra_bus_search_input"
            r1.putExtra(r3, r2)
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r2 = r6.p
            java.lang.String r3 = "intent_extra_selected_seats"
            r1.putExtra(r3, r2)
            java.lang.String r2 = "intent_extra_passenger_details"
            r1.putExtra(r2, r7)
            java.lang.String r7 = "intent_block_ticket_response_data"
            r1.putExtra(r7, r8)
            java.lang.String r7 = r6.B
            java.lang.String r8 = "requestid"
            r1.putExtra(r8, r7)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r7 = r6.s
            java.lang.String r8 = "intent_extra_bus_search_result_item"
            r1.putExtra(r8, r7)
            com.travel.bus.pojo.busticket.CJRLocation r7 = r6.t
            java.lang.String r8 = "intent_extra_selected_boarding_point"
            r1.putExtra(r8, r7)
            com.travel.bus.pojo.busticket.CJRLocation r7 = r6.u
            java.lang.String r8 = "intent_extra_selected_dropping_point"
            r1.putExtra(r8, r7)
            com.travel.bus.pojo.busticket.TripBusDetail r7 = r6.q
            java.lang.String r8 = "intent_extra_bus_trip_detail"
            r1.putExtra(r8, r7)
            java.util.HashMap<java.lang.String, com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo> r7 = r6.A
            java.lang.String r8 = "intent_extra_bus_search_load_data"
            r1.putExtra(r8, r7)
            android.widget.EditText r7 = r6.f22304f
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "EMAIL"
            r1.putExtra(r8, r7)
            android.widget.EditText r7 = r6.f22303e
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "MOBILE_NO"
            r1.putExtra(r8, r7)
            boolean r7 = r6.w
            if (r7 == 0) goto L_0x00ad
            com.travel.bus.pojo.busticket.CJRBusInsuranceItem r8 = r6.z
            if (r8 == 0) goto L_0x00ad
            java.lang.String r8 = "intent_extra_bus_insurance_enabled"
            r1.putExtra(r8, r7)
            com.travel.bus.pojo.busticket.CJRBusInsuranceItem r7 = r6.z
            java.lang.String r8 = "intent_extra_bus_insurance_plan"
            r1.putExtra(r8, r7)
        L_0x00ad:
            androidx.fragment.app.FragmentActivity r7 = r6.getActivity()
            r7.startActivityForResult(r1, r0)
        L_0x00b4:
            return
        L_0x00b5:
            r6.f()
        L_0x00b8:
            return
        L_0x00b9:
            com.travel.bus.pojo.busticket.CJRBusInsurancePlans r8 = (com.travel.bus.pojo.busticket.CJRBusInsurancePlans) r8
            if (r8 == 0) goto L_0x00c2
            int r7 = r8.getCode()
            goto L_0x00c3
        L_0x00c2:
            r7 = -1
        L_0x00c3:
            r1 = 0
            if (r8 == 0) goto L_0x00cb
            int r2 = r8.getPlansCount()
            goto L_0x00cc
        L_0x00cb:
            r2 = 0
        L_0x00cc:
            r3 = 200(0xc8, float:2.8E-43)
            if (r7 != r3) goto L_0x0105
            if (r8 == 0) goto L_0x0105
            if (r2 <= 0) goto L_0x0105
            boolean r7 = r6.g()
            if (r7 == 0) goto L_0x00fc
            com.travel.bus.pojo.busticket.CJRBusSearchItem r7 = r6.s
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r7 = r7.getFare()
            double[] r7 = r7.getPrices()
            r2 = r7[r1]
            com.travel.bus.a.a()
            com.travel.g.a r7 = com.travel.bus.a.b()
            int r7 = r7.j()
            double r4 = (double) r7
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x00f8
            r7 = 1
            goto L_0x00f9
        L_0x00f8:
            r7 = 0
        L_0x00f9:
            if (r7 == 0) goto L_0x00fc
            goto L_0x00fd
        L_0x00fc:
            r0 = 0
        L_0x00fd:
            com.travel.bus.pojo.busticket.CJRBusInsuranceItem r7 = r8.getInsuranceAtIndex(r1)
            r6.a((boolean) r0, (com.travel.bus.pojo.busticket.CJRBusInsuranceItem) r7)
            return
        L_0x0105:
            r7 = 0
            r6.a((boolean) r1, (com.travel.bus.pojo.busticket.CJRBusInsuranceItem) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.fragment.m.a(int, com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public final void a(int i2, NetworkCustomError networkCustomError) {
        CJRNewErrorFormat cJRNewErrorFormat = new CJRNewErrorFormat();
        if (networkCustomError.networkResponse != null) {
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if (networkResponse.data != null) {
                try {
                    cJRNewErrorFormat = (CJRNewErrorFormat) new com.google.gsonhtcfix.f().a(new String(networkResponse.data), cJRNewErrorFormat.getClass());
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        }
        if (!(networkCustomError == null || networkCustomError.getAlertMessage() == null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "bus_passenger");
            hashMap.put("event_action", "error_popup");
            hashMap.put("event_label", networkCustomError.getAlertMessage());
            hashMap.put("event_label2", Integer.valueOf(networkCustomError.getStatusCode()));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-traveller");
            hashMap.put("vertical_name", "bus");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
        }
        Intent intent = null;
        if (i2 == 0) {
            a(false, (CJRBusInsuranceItem) null);
        } else if (i2 != 1) {
            if (i2 != 3) {
                if (i2 != 5) {
                    f();
                    String valueOf = String.valueOf(cJRNewErrorFormat.getCode());
                    if (networkCustomError != null) {
                        if (networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403) {
                            com.travel.bus.a.a();
                            com.travel.bus.a.b().a((Activity) getActivity());
                            return;
                        } else if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                            com.paytm.utility.b.d((Context) getActivity(), networkCustomError.getUrl(), valueOf);
                            return;
                        } else if (networkCustomError.getStatusCode() == 503) {
                            if (getActivity() != null && !getActivity().isFinishing()) {
                                String string = getResources().getString(R.string.bus_maintenance_error_title);
                                String string2 = getResources().getString(R.string.bus_maintenance_error_description);
                                a(string2);
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                builder.setTitle(string).setMessage(string2).setCancelable(false);
                                builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        m.this.a(dialogInterface, i2);
                                    }
                                });
                                builder.show();
                                return;
                            }
                            return;
                        } else if (networkCustomError.getStatusCode() == 480) {
                            a(true, "no_actions");
                            return;
                        } else {
                            return;
                        }
                    } else if (cJRNewErrorFormat == null || cJRNewErrorFormat.getStatus() == null || cJRNewErrorFormat.getStatus().getMessage() == null) {
                        com.travel.bus.a.a();
                        com.travel.bus.a.b().a((Activity) getActivity(), networkCustomError);
                        return;
                    } else {
                        com.paytm.utility.b.b((Context) getActivity(), cJRNewErrorFormat.getStatus().getMessage().f22819b, cJRNewErrorFormat.getStatus().getMessage().f22820c);
                        return;
                    }
                } else if (cJRNewErrorFormat == null || cJRNewErrorFormat.getStatus() == null || cJRNewErrorFormat.getStatus().getMessage() == null || cJRNewErrorFormat.getStatus().getMessage().f22819b == null || cJRNewErrorFormat.getStatus().getMessage().f22820c == null || cJRNewErrorFormat.getStatus().getMessage().a() == null) {
                    a("", "", "");
                } else {
                    a(cJRNewErrorFormat.getStatus().getMessage().f22819b, cJRNewErrorFormat.getStatus().getMessage().f22820c, cJRNewErrorFormat.getStatus().getMessage().a());
                }
            }
            f();
            if (networkCustomError != null && (networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403)) {
                com.travel.bus.a.a();
                com.travel.bus.a.b().a((Activity) getActivity());
            } else if (cJRNewErrorFormat != null && cJRNewErrorFormat.getStatus() != null && cJRNewErrorFormat.getStatus().getMessage() != null) {
                if (cJRNewErrorFormat.getStatus().getMessage().f22818a == null || !cJRNewErrorFormat.getStatus().getMessage().f22818a.equalsIgnoreCase("redirect_SRP")) {
                    if (cJRNewErrorFormat.getStatus().getMessage().f22818a == null || !cJRNewErrorFormat.getStatus().getMessage().f22818a.equalsIgnoreCase("Close")) {
                        if (cJRNewErrorFormat.getStatus().getMessage().f22818a.equalsIgnoreCase("open_seat_layout") || cJRNewErrorFormat.getStatus().getMessage().f22818a.equalsIgnoreCase("open_seat_layout_single_female") || cJRNewErrorFormat.getStatus().getMessage().f22818a.equalsIgnoreCase("open_seat_layout_single_pax") || cJRNewErrorFormat.getStatus().getMessage().f22818a.equalsIgnoreCase("open_seat_layout_female_reserved") || cJRNewErrorFormat.getStatus().getMessage().f22818a.equalsIgnoreCase("open_seat_layout_opp_gender")) {
                            intent = a(false, cJRNewErrorFormat.getStatus().getMessage().f22818a);
                        } else if (getActivity() != null && cJRNewErrorFormat.getStatus().getMessage().f22819b != null && cJRNewErrorFormat.getStatus().getMessage().f22820c != null && cJRNewErrorFormat.getStatus().getMessage().a() != null) {
                            this.T.a(cJRNewErrorFormat.getStatus().getMessage().f22819b, cJRNewErrorFormat.getStatus().getMessage().f22820c, cJRNewErrorFormat.getStatus().getMessage().a());
                            return;
                        } else {
                            return;
                        }
                    }
                    s.a(getActivity(), cJRNewErrorFormat.getStatus().getMessage().f22819b, cJRNewErrorFormat.getStatus().getMessage().f22820c, cJRNewErrorFormat.getStatus().getMessage().a(), intent);
                } else if (getActivity() != null && cJRNewErrorFormat.getStatus().getMessage().f22819b != null && cJRNewErrorFormat.getStatus().getMessage().f22820c != null && cJRNewErrorFormat.getStatus().getMessage().a() != null) {
                    this.T.a(cJRNewErrorFormat.getStatus().getMessage().f22819b, cJRNewErrorFormat.getStatus().getMessage().f22820c, cJRNewErrorFormat.getStatus().getMessage().a());
                }
            }
        }
    }

    private void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "Some thing went wrong, Please try again later";
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = getResources().getString(R.string.ok);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(str).setMessage(str2).setCancelable(false);
        builder.setPositiveButton(str3, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                m.this.b(dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (getActivity() != null) {
            getActivity().finish();
            c();
        }
    }

    private void c() {
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), AJRBusSearchSRPActivity.class);
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            startActivity(intent);
        }
    }

    private Intent a(boolean z2, String str) {
        new AJRBusSelectSeatsOnBlockActivity();
        AJRBusSelectSeatsOnBlockActivity.a((e) this);
        if (getActivity() == null || this.s == null) {
            return null;
        }
        Intent intent = new Intent(getActivity(), AJRBusSelectSeatsOnBlockActivity.class);
        intent.putExtra("intent_extra_bus_search_result_item", this.s);
        String str2 = this.B;
        if (str2 != null) {
            intent.putExtra("intent_extra_bus_search", str2);
        }
        CJRBusSearchInput cJRBusSearchInput = this.r;
        if (cJRBusSearchInput != null) {
            intent.putExtra("intent_extra_bus_search_input", cJRBusSearchInput);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            intent.putExtra("bus_intent_block_action_error", str);
            intent.putExtra("intent_extra_selected_seats", arguments.getSerializable("intent_extra_selected_seats"));
            intent.putExtra("intent_extra_passenger_details", this.v);
            intent.putExtra("intent_extra_bus_trip_detail", arguments.getSerializable("intent_extra_bus_trip_detail"));
            intent.putExtra("intent_extra_selected_boarding_point", arguments.getSerializable("intent_extra_selected_boarding_point"));
            intent.putExtra("intent_extra_selected_dropping_point", arguments.getSerializable("intent_extra_selected_dropping_point"));
        }
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        if (!z2) {
            return intent;
        }
        startActivityForResult(intent, 2);
        getActivity().setResult(9);
        return intent;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (getContext() != null) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(getContext(), intent);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: int[]} */
    /* JADX WARNING: type inference failed for: r1v9, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: type inference failed for: r1v34 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r57 = this;
            r11 = r57
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r11.p
            if (r0 == 0) goto L_0x0639
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0639
            com.travel.bus.busticket.g.j r0 = r11.f22301c
            if (r0 == 0) goto L_0x0021
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r11.v = r0
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r0 = r11.v
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r1 = r11.p
            java.util.ArrayList r0 = com.travel.bus.busticket.g.j.a(r0, r1)
            r11.v = r0
        L_0x0021:
            androidx.fragment.app.FragmentActivity r0 = r57.getActivity()
            android.view.LayoutInflater r12 = android.view.LayoutInflater.from(r0)
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r0 = r11.v
            if (r0 == 0) goto L_0x003b
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x003b
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r0 = r11.v
            int r0 = r0.size()
            r14 = r0
            goto L_0x003c
        L_0x003b:
            r14 = 0
        L_0x003c:
            com.paytm.utility.RoboTextView[] r15 = new com.paytm.utility.RoboTextView[r14]
            android.widget.ImageView[] r10 = new android.widget.ImageView[r14]
            android.widget.LinearLayout[] r9 = new android.widget.LinearLayout[r14]
            android.widget.AutoCompleteTextView[] r8 = new android.widget.AutoCompleteTextView[r14]
            android.widget.EditText[] r7 = new android.widget.EditText[r14]
            android.widget.RadioGroup[] r6 = new android.widget.RadioGroup[r14]
            android.widget.RadioButton[] r5 = new android.widget.RadioButton[r14]
            android.widget.RadioButton[] r4 = new android.widget.RadioButton[r14]
            com.paytm.utility.RoboTextView[] r3 = new com.paytm.utility.RoboTextView[r14]
            android.widget.ImageView[] r2 = new android.widget.ImageView[r14]
            android.widget.ImageView[] r1 = new android.widget.ImageView[r14]
            android.widget.Spinner[] r0 = new android.widget.Spinner[r14]
            java.lang.String[] r13 = new java.lang.String[r14]
            r16 = r13
            android.widget.EditText[] r13 = new android.widget.EditText[r14]
            r17 = r7
            com.google.android.material.textfield.TextInputLayout[] r7 = new com.google.android.material.textfield.TextInputLayout[r14]
            r18 = r6
            com.paytm.utility.RoboTextView[] r6 = new com.paytm.utility.RoboTextView[r14]
            r19 = r7
            android.widget.LinearLayout[] r7 = new android.widget.LinearLayout[r14]
            r20 = r7
            android.view.View[] r7 = new android.view.View[r14]
            r21 = r7
            android.view.View[] r7 = new android.view.View[r14]
            r22 = r7
            android.widget.ImageView[] r7 = new android.widget.ImageView[r14]
            r23 = r7
            android.widget.RelativeLayout[] r7 = new android.widget.RelativeLayout[r14]
            r24 = r7
            android.widget.LinearLayout[] r7 = new android.widget.LinearLayout[r14]
            r25 = r7
            android.widget.LinearLayout[] r7 = new android.widget.LinearLayout[r14]
            r26 = r7
            com.paytm.utility.RoboTextView[] r7 = new com.paytm.utility.RoboTextView[r14]
            r27 = r7
            android.widget.EditText[] r7 = new android.widget.EditText[r14]
            r28 = r7
            android.widget.RelativeLayout[] r7 = new android.widget.RelativeLayout[r14]
            r29 = r7
            android.widget.Spinner[] r7 = new android.widget.Spinner[r14]
            r30 = r7
            android.view.View[] r7 = new android.view.View[r14]
            r31 = r7
            android.view.View[] r7 = new android.view.View[r14]
            r32 = r7
            com.google.android.material.textfield.TextInputLayout[] r7 = new com.google.android.material.textfield.TextInputLayout[r14]
            r33 = r7
            android.widget.TextView[] r7 = new android.widget.TextView[r14]
            r34 = r6
            android.widget.TextView[] r6 = new android.widget.TextView[r14]
            r35 = r5
            android.widget.TextView[] r5 = new android.widget.TextView[r14]
            r36 = r4
            android.widget.ImageView[] r4 = new android.widget.ImageView[r14]
            r37 = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r38 = r1
            com.travel.bus.pojo.busticket.CJRBusSearchItem r1 = r11.s
            if (r1 == 0) goto L_0x00f0
            com.travel.bus.pojo.busticket.CJRConcessionObj r1 = r1.getConcessionString()
            if (r1 == 0) goto L_0x00f0
            com.travel.bus.pojo.busticket.CJRBusSearchItem r1 = r11.s
            com.travel.bus.pojo.busticket.CJRConcessionObj r1 = r1.getConcessionString()
            com.travel.bus.pojo.busticket.k r1 = r1.getGeneralPublic()
            if (r1 == 0) goto L_0x00ce
            java.lang.String r1 = "General Public"
            r0.add(r1)
        L_0x00ce:
            com.travel.bus.pojo.busticket.CJRBusSearchItem r1 = r11.s
            com.travel.bus.pojo.busticket.CJRConcessionObj r1 = r1.getConcessionString()
            com.travel.bus.pojo.busticket.CJRSeniorCitizen r1 = r1.getSeniorCitizen()
            if (r1 == 0) goto L_0x00df
            java.lang.String r1 = "Senior Citizen"
            r0.add(r1)
        L_0x00df:
            com.travel.bus.pojo.busticket.CJRBusSearchItem r1 = r11.s
            com.travel.bus.pojo.busticket.CJRConcessionObj r1 = r1.getConcessionString()
            com.travel.bus.pojo.busticket.CJRCatCard r1 = r1.getCatCard()
            if (r1 == 0) goto L_0x00f0
            java.lang.String r1 = "Cat Card"
            r0.add(r1)
        L_0x00f0:
            int r1 = r0.size()
            java.lang.String[] r1 = new java.lang.String[r1]
            r40 = r8
            r39 = r13
            r13 = 0
        L_0x00fb:
            int r8 = r0.size()
            if (r13 >= r8) goto L_0x010c
            java.lang.Object r8 = r0.get(r13)
            java.lang.String r8 = (java.lang.String) r8
            r1[r13] = r8
            int r13 = r13 + 1
            goto L_0x00fb
        L_0x010c:
            if (r14 <= 0) goto L_0x0639
            r13 = 0
        L_0x010f:
            if (r13 >= r14) goto L_0x0639
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r0 = r11.v
            java.lang.Object r0 = r0.get(r13)
            r8 = r0
            com.travel.bus.pojo.busticket.CJRPassengerDetails r8 = (com.travel.bus.pojo.busticket.CJRPassengerDetails) r8
            int r0 = com.travel.bus.R.layout.pre_b_bus_passenger_item_view
            r41 = r1
            r1 = 0
            android.view.View r1 = r12.inflate(r0, r1)
            int r0 = com.travel.bus.R.id.passenger_label_view
            android.view.View r0 = r1.findViewById(r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r15[r13] = r0
            int r0 = com.travel.bus.R.id.ladiesReservedText
            android.view.View r0 = r1.findViewById(r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r3[r13] = r0
            boolean r0 = r8.isLadiesSeat()
            if (r0 == 0) goto L_0x0146
            r0 = r3[r13]
            r42 = r3
            r3 = 0
            r0.setVisibility(r3)
            goto L_0x0148
        L_0x0146:
            r42 = r3
        L_0x0148:
            int r0 = com.travel.bus.R.id.bus_icon_onward
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r2[r13] = r0
            int r0 = com.travel.bus.R.id.bus_icon_onward_text
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r5[r13] = r0
            r0 = r5[r13]
            java.lang.String r3 = r8.getSeatNumber()
            r0.setText(r3)
            int r0 = com.travel.bus.R.id.bus_icon_onward
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r4[r13] = r0
            boolean r0 = r8.isLadiesSeat()
            r43 = 1
            if (r0 == 0) goto L_0x01bc
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r11.p
            java.lang.Object r0 = r0.get(r13)
            com.travel.bus.pojo.busticket.TripBusDetailsItem r0 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r0
            long r45 = r0.getLength()
            int r0 = (r45 > r43 ? 1 : (r45 == r43 ? 0 : -1))
            if (r0 > 0) goto L_0x01aa
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r11.p
            java.lang.Object r0 = r0.get(r13)
            com.travel.bus.pojo.busticket.TripBusDetailsItem r0 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r0
            long r45 = r0.getWidth()
            int r0 = (r45 > r43 ? 1 : (r45 == r43 ? 0 : -1))
            if (r0 <= 0) goto L_0x0198
            goto L_0x01aa
        L_0x0198:
            r0 = r4[r13]
            android.content.Context r3 = r57.getContext()
            r45 = r2
            int r2 = com.travel.bus.R.drawable.bus_passenger_seat_ladies
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r3, (int) r2)
            r0.setImageDrawable(r2)
            goto L_0x01fe
        L_0x01aa:
            r45 = r2
            r0 = r4[r13]
            android.content.Context r2 = r57.getContext()
            int r3 = com.travel.bus.R.drawable.bus_sleeper_booked_ladies
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r3)
            r0.setImageDrawable(r2)
            goto L_0x01fe
        L_0x01bc:
            r45 = r2
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r11.p
            java.lang.Object r0 = r0.get(r13)
            com.travel.bus.pojo.busticket.TripBusDetailsItem r0 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r0
            long r2 = r0.getLength()
            int r0 = (r2 > r43 ? 1 : (r2 == r43 ? 0 : -1))
            if (r0 > 0) goto L_0x01ef
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r11.p
            java.lang.Object r0 = r0.get(r13)
            com.travel.bus.pojo.busticket.TripBusDetailsItem r0 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r0
            long r2 = r0.getWidth()
            int r0 = (r2 > r43 ? 1 : (r2 == r43 ? 0 : -1))
            if (r0 <= 0) goto L_0x01df
            goto L_0x01ef
        L_0x01df:
            r0 = r4[r13]
            android.content.Context r2 = r57.getContext()
            int r3 = com.travel.bus.R.drawable.bus_passenger_seat_green
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r3)
            r0.setImageDrawable(r2)
            goto L_0x01fe
        L_0x01ef:
            r0 = r4[r13]
            android.content.Context r2 = r57.getContext()
            int r3 = com.travel.bus.R.drawable.bus_sleeper_selected
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r3)
            r0.setImageDrawable(r2)
        L_0x01fe:
            boolean r0 = r11.x
            if (r0 == 0) goto L_0x0242
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r11.p
            java.lang.Object r0 = r0.get(r13)
            com.travel.bus.pojo.busticket.TripBusDetailsItem r0 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r0
            long r2 = r0.getLength()
            int r0 = (r2 > r43 ? 1 : (r2 == r43 ? 0 : -1))
            if (r0 > 0) goto L_0x0233
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r11.p
            java.lang.Object r0 = r0.get(r13)
            com.travel.bus.pojo.busticket.TripBusDetailsItem r0 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r0
            long r2 = r0.getWidth()
            int r0 = (r2 > r43 ? 1 : (r2 == r43 ? 0 : -1))
            if (r0 <= 0) goto L_0x0223
            goto L_0x0233
        L_0x0223:
            r0 = r4[r13]
            android.content.Context r2 = r57.getContext()
            int r3 = com.travel.bus.R.drawable.bus_ladies_available_port
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r3)
            r0.setImageDrawable(r2)
            goto L_0x0242
        L_0x0233:
            r0 = r4[r13]
            android.content.Context r2 = r57.getContext()
            int r3 = com.travel.bus.R.drawable.bus_sleeper_seat_for_ladies
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r3)
            r0.setImageDrawable(r2)
        L_0x0242:
            int r0 = com.travel.bus.R.id.onwardTitle
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r7[r13] = r0
            int r0 = com.travel.bus.R.id.returnTitle
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r6[r13] = r0
            r0 = r6[r13]
            r3 = 8
            r0.setVisibility(r3)
            int r0 = com.travel.bus.R.id.close_button
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r10[r13] = r0
            int r0 = com.travel.bus.R.id.lyt_passenger_input_container
            android.view.View r0 = r1.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r9[r13] = r0
            int r0 = com.travel.bus.R.id.passenger_name_input
            android.view.View r0 = r1.findViewById(r0)
            android.widget.AutoCompleteTextView r0 = (android.widget.AutoCompleteTextView) r0
            r40[r13] = r0
            int r0 = com.travel.bus.R.id.passenger_concession_card_number
            android.view.View r0 = r1.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r39[r13] = r0
            r0 = r40[r13]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r0.setTag(r2)
            r0 = r40[r13]
            androidx.fragment.app.FragmentActivity r2 = r57.getActivity()
            int r2 = com.paytm.utility.b.a((android.app.Activity) r2)
            r0.setDropDownWidth(r2)
            r2 = r40[r13]
            com.travel.bus.busticket.a.z r0 = new com.travel.bus.busticket.a.z
            android.content.Context r46 = r57.getContext()
            java.util.ArrayList r47 = new java.util.ArrayList
            r47.<init>()
            r48 = r40[r13]
            r49 = r0
            r50 = r15
            r15 = r1
            r56 = r41
            r41 = r12
            r12 = r56
            r1 = r46
            r46 = r6
            r6 = r2
            r2 = r47
            r3 = r57
            r47 = r4
            r4 = r48
            r48 = r5
            r5 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            r6.setAdapter(r0)
            r0 = r40[r13]
            com.travel.bus.busticket.fragment.-$$Lambda$m$BU4ZaRoWzAtMWN1f1YFn4NiIkg4 r1 = new com.travel.bus.busticket.fragment.-$$Lambda$m$BU4ZaRoWzAtMWN1f1YFn4NiIkg4
            r1.<init>()
            r0.setOnDismissListener(r1)
            int r0 = com.travel.bus.R.id.concessionText
            android.view.View r0 = r15.findViewById(r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r34[r13] = r0
            int r0 = com.travel.bus.R.id.concession_categoty
            android.view.View r0 = r15.findViewById(r0)
            android.widget.Spinner r0 = (android.widget.Spinner) r0
            r37[r13] = r0
            int r0 = com.travel.bus.R.id.view_line_conncession
            android.view.View r0 = r15.findViewById(r0)
            r21[r13] = r0
            int r0 = com.travel.bus.R.id.view_line_end
            android.view.View r0 = r15.findViewById(r0)
            r22[r13] = r0
            int r0 = com.travel.bus.R.id.spinner_dropdown
            android.view.View r0 = r15.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r23[r13] = r0
            int r0 = com.travel.bus.R.id.concession_layout
            android.view.View r0 = r15.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r20[r13] = r0
            int r0 = com.travel.bus.R.id.concessionlayout
            android.view.View r0 = r15.findViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r24[r13] = r0
            int r0 = com.travel.bus.R.id.text_input_layout_concession
            android.view.View r0 = r15.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            r19[r13] = r0
            int r0 = com.travel.bus.R.id.lyt_extra_traveller_details
            android.view.View r0 = r15.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r25[r13] = r0
            int r0 = com.travel.bus.R.id.lbl_id_type
            android.view.View r0 = r15.findViewById(r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r27[r13] = r0
            int r0 = com.travel.bus.R.id.lyt_id_card_spinner
            android.view.View r0 = r15.findViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r29[r13] = r0
            int r0 = com.travel.bus.R.id.id_card_spinner
            android.view.View r0 = r15.findViewById(r0)
            android.widget.Spinner r0 = (android.widget.Spinner) r0
            r30[r13] = r0
            int r0 = com.travel.bus.R.id.id_card_layout
            android.view.View r0 = r15.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r26[r13] = r0
            int r0 = com.travel.bus.R.id.text_input_layout_id_card
            android.view.View r0 = r15.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            r33[r13] = r0
            int r0 = com.travel.bus.R.id.id_card_value
            android.view.View r0 = r15.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r28[r13] = r0
            int r0 = com.travel.bus.R.id.view_line_end_1
            android.view.View r0 = r15.findViewById(r0)
            r31[r13] = r0
            int r0 = com.travel.bus.R.id.view_line_end_2
            android.view.View r0 = r15.findViewById(r0)
            r32[r13] = r0
            com.travel.bus.pojo.busticket.TripBusDetail r0 = r11.q
            com.travel.bus.pojo.busticket.TripDetailsMeta r0 = r0.getMeta()
            boolean r0 = r0.isExtraPaxDetailsRequired()
            if (r0 == 0) goto L_0x03e8
            com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDynamicFormFieldRootModel r0 = r11.M
            if (r0 == 0) goto L_0x03e8
            com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDynamicFormFieldModel r0 = r0.getbody()
            java.util.ArrayList r49 = r0.getFields()
            if (r49 == 0) goto L_0x03e8
            int r0 = r49.size()
            if (r0 <= 0) goto L_0x03e8
            java.util.Iterator r51 = r49.iterator()
        L_0x039b:
            boolean r0 = r51.hasNext()
            if (r0 == 0) goto L_0x03e8
            java.lang.Object r0 = r51.next()
            r52 = r0
            com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRBusTravellerExtraDetailsFieldModel r52 = (com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRBusTravellerExtraDetailsFieldModel) r52
            boolean r0 = r52.isVisibile()
            boolean r1 = r52.isPrimaryPax()
            r11.R = r1
            boolean r1 = r11.R
            if (r1 == 0) goto L_0x03c3
            if (r0 == 0) goto L_0x03bc
            if (r13 != 0) goto L_0x03bc
            goto L_0x03c3
        L_0x03bc:
            r53 = r7
            r54 = r40
            r40 = r8
            goto L_0x03e1
        L_0x03c3:
            r0 = r25[r13]
            r1 = 0
            r0.setVisibility(r1)
            r0 = r57
            r1 = r30
            r2 = r33
            r3 = r28
            r4 = r32
            r5 = r13
            r6 = r49
            r53 = r7
            r7 = r52
            r54 = r40
            r40 = r8
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x03e1:
            r8 = r40
            r7 = r53
            r40 = r54
            goto L_0x039b
        L_0x03e8:
            r53 = r7
            r54 = r40
            r40 = r8
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = r11.s
            boolean r0 = r0.isConcessionEnabled()
            if (r0 == 0) goto L_0x040c
            r0 = r37[r13]
            r1 = 0
            r0.setVisibility(r1)
            r0 = r23[r13]
            r0.setVisibility(r1)
            r0 = r21[r13]
            r0.setVisibility(r1)
            r0 = r34[r13]
            r0.setVisibility(r1)
            goto L_0x040d
        L_0x040c:
            r1 = 0
        L_0x040d:
            com.travel.bus.busticket.a.j r0 = new com.travel.bus.busticket.a.j
            android.content.Context r2 = r57.getContext()
            r0.<init>(r2, r12, r1)
            r2 = r37[r13]
            r2.setAdapter(r0)
            r8 = 1
            int[] r2 = new int[r8]
            r2[r1] = r1
            r7 = r37[r13]
            com.travel.bus.busticket.fragment.m$12 r6 = new com.travel.bus.busticket.fragment.m$12
            r0 = r6
            r1 = r57
            r3 = r16
            r4 = r13
            r5 = r12
            r49 = r12
            r12 = r6
            r6 = r14
            r51 = r14
            r14 = r7
            r7 = r37
            r8 = r20
            r52 = r9
            r9 = r22
            r55 = r10
            r10 = r40
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r14.setOnItemSelectedListener(r12)
            int r0 = com.travel.bus.R.id.info_icon
            android.view.View r0 = r15.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r38[r13] = r0
            r0 = r38[r13]
            com.travel.bus.busticket.fragment.-$$Lambda$m$6rPcBQgu9tU65VI6OOWw-mqsSaU r1 = new com.travel.bus.busticket.fragment.-$$Lambda$m$6rPcBQgu9tU65VI6OOWw-mqsSaU
            r1.<init>()
            r0.setOnClickListener(r1)
            r0 = r39[r13]
            com.travel.bus.busticket.fragment.m$13 r1 = new com.travel.bus.busticket.fragment.m$13
            r6 = r40
            r1.<init>(r6)
            r0.addTextChangedListener(r1)
            r7 = r54
            r0 = r7[r13]
            com.travel.bus.busticket.fragment.m$14 r1 = new com.travel.bus.busticket.fragment.m$14
            r1.<init>(r7, r13)
            r0.addTextChangedListener(r1)
            int r0 = com.travel.bus.R.id.passenger_age_input
            android.view.View r0 = r15.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r17[r13] = r0
            r0 = r17[r13]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r0.setTag(r1)
            r0 = r17[r13]
            com.travel.bus.busticket.fragment.m$15 r1 = new com.travel.bus.busticket.fragment.m$15
            r1.<init>()
            r0.setOnClickListener(r1)
            r0 = r17[r13]
            com.travel.bus.busticket.fragment.m$2 r1 = new com.travel.bus.busticket.fragment.m$2
            r1.<init>(r13)
            r0.addTextChangedListener(r1)
            int r0 = com.travel.bus.R.id.title_radio_group
            android.view.View r0 = r15.findViewById(r0)
            android.widget.RadioGroup r0 = (android.widget.RadioGroup) r0
            r18[r13] = r0
            r0 = r18[r13]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r0.setTag(r1)
            int r0 = com.travel.bus.R.id.title_mr
            android.view.View r0 = r15.findViewById(r0)
            android.widget.RadioButton r0 = (android.widget.RadioButton) r0
            r35[r13] = r0
            r8 = 3
            java.lang.String[] r0 = new java.lang.String[r8]
            java.lang.String r9 = " "
            r1 = 0
            r0[r1] = r9
            r10 = 1
            r0[r10] = r9
            androidx.fragment.app.FragmentActivity r1 = r57.getActivity()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = com.travel.bus.R.string.male
            java.lang.String r1 = r1.getString(r2)
            r12 = 2
            r0[r12] = r1
            java.lang.String r0 = com.paytm.utility.v.a((java.lang.String[]) r0)
            boolean r1 = r11.x
            if (r1 == 0) goto L_0x04df
            r1 = r35[r13]
            r2 = 8
            r1.setVisibility(r2)
        L_0x04df:
            r1 = r35[r13]
            r1.setText(r0)
            int r0 = com.travel.bus.R.id.title_mrs
            android.view.View r0 = r15.findViewById(r0)
            android.widget.RadioButton r0 = (android.widget.RadioButton) r0
            r36[r13] = r0
            java.lang.String[] r0 = new java.lang.String[r8]
            r1 = 0
            r0[r1] = r9
            r0[r10] = r9
            androidx.fragment.app.FragmentActivity r1 = r57.getActivity()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = com.travel.bus.R.string.female
            java.lang.String r1 = r1.getString(r2)
            r0[r12] = r1
            java.lang.String r0 = com.paytm.utility.v.a((java.lang.String[]) r0)
            r1 = r36[r13]
            r1.setText(r0)
            r14 = r18[r13]
            com.travel.bus.busticket.fragment.-$$Lambda$m$t7PltYOOL9SANlYeiCjKD6cGeDU r5 = new com.travel.bus.busticket.fragment.-$$Lambda$m$t7PltYOOL9SANlYeiCjKD6cGeDU
            r0 = r5
            r1 = r57
            r2 = r42
            r3 = r45
            r4 = r35
            r12 = r5
            r5 = r36
            r0.<init>(r2, r3, r4, r5)
            r14.setOnCheckedChangeListener(r12)
            java.lang.String r0 = "Passenger"
            r1 = r51
            if (r1 != r10) goto L_0x052b
            goto L_0x053f
        L_0x052b:
            java.lang.String[] r2 = new java.lang.String[r8]
            r3 = 0
            r2[r3] = r0
            r2[r10] = r9
            int r0 = r13 + 1
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r3 = 2
            r2[r3] = r0
            java.lang.String r0 = com.paytm.utility.v.a((java.lang.String[]) r2)
        L_0x053f:
            r2 = r50[r13]
            r2.setText(r0)
            java.lang.String r0 = "Mr"
            if (r6 == 0) goto L_0x0553
            java.lang.String r2 = r6.getmTitle()
            if (r2 == 0) goto L_0x0553
            java.lang.String r2 = r6.getmTitle()
            goto L_0x0554
        L_0x0553:
            r2 = r0
        L_0x0554:
            boolean r3 = r6.isLadiesSeat()
            if (r3 == 0) goto L_0x05cc
            r3 = r47[r13]
            r4 = r35[r13]
            r5 = r36[r13]
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r8 = r11.p     // Catch:{ Exception -> 0x05cb }
            java.lang.Object r8 = r8.get(r13)     // Catch:{ Exception -> 0x05cb }
            com.travel.bus.pojo.busticket.TripBusDetailsItem r8 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r8     // Catch:{ Exception -> 0x05cb }
            long r8 = r8.getLength()     // Catch:{ Exception -> 0x05cb }
            int r12 = (r8 > r43 ? 1 : (r8 == r43 ? 0 : -1))
            if (r12 > 0) goto L_0x058f
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r8 = r11.p     // Catch:{ Exception -> 0x05cb }
            java.lang.Object r8 = r8.get(r13)     // Catch:{ Exception -> 0x05cb }
            com.travel.bus.pojo.busticket.TripBusDetailsItem r8 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r8     // Catch:{ Exception -> 0x05cb }
            long r8 = r8.getWidth()     // Catch:{ Exception -> 0x05cb }
            int r12 = (r8 > r43 ? 1 : (r8 == r43 ? 0 : -1))
            if (r12 <= 0) goto L_0x0581
            goto L_0x058f
        L_0x0581:
            android.content.Context r8 = r57.getContext()     // Catch:{ Exception -> 0x05cb }
            int r9 = com.travel.bus.R.drawable.bus_passenger_seat_ladies     // Catch:{ Exception -> 0x05cb }
            android.graphics.drawable.Drawable r8 = androidx.core.content.b.a((android.content.Context) r8, (int) r9)     // Catch:{ Exception -> 0x05cb }
            r3.setImageDrawable(r8)     // Catch:{ Exception -> 0x05cb }
            goto L_0x059c
        L_0x058f:
            android.content.Context r8 = r57.getContext()     // Catch:{ Exception -> 0x05cb }
            int r9 = com.travel.bus.R.drawable.bus_sleeper_booked_ladies     // Catch:{ Exception -> 0x05cb }
            android.graphics.drawable.Drawable r8 = androidx.core.content.b.a((android.content.Context) r8, (int) r9)     // Catch:{ Exception -> 0x05cb }
            r3.setImageDrawable(r8)     // Catch:{ Exception -> 0x05cb }
        L_0x059c:
            r3 = 0
            r4.setChecked(r3)     // Catch:{ Exception -> 0x05cb }
            r5.setChecked(r10)     // Catch:{ Exception -> 0x05cb }
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r3 = r11.v     // Catch:{ Exception -> 0x05cb }
            java.lang.Object r3 = r3.get(r13)     // Catch:{ Exception -> 0x05cb }
            com.travel.bus.pojo.busticket.CJRPassengerDetails r3 = (com.travel.bus.pojo.busticket.CJRPassengerDetails) r3     // Catch:{ Exception -> 0x05cb }
            java.lang.String r4 = "Ms"
            r3.setTitle(r4)     // Catch:{ Exception -> 0x05cb }
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r3 = r11.v     // Catch:{ Exception -> 0x05cb }
            java.lang.Object r3 = r3.get(r13)     // Catch:{ Exception -> 0x05cb }
            com.travel.bus.pojo.busticket.CJRPassengerDetails r3 = (com.travel.bus.pojo.busticket.CJRPassengerDetails) r3     // Catch:{ Exception -> 0x05cb }
            java.lang.String r4 = "female"
            r3.setGender(r4)     // Catch:{ Exception -> 0x05cb }
            androidx.fragment.app.FragmentActivity r3 = r57.getActivity()     // Catch:{ Exception -> 0x05cb }
            int r4 = com.travel.bus.R.color.color_323232     // Catch:{ Exception -> 0x05cb }
            int r3 = androidx.core.content.b.c(r3, r4)     // Catch:{ Exception -> 0x05cb }
            r5.setTextColor(r3)     // Catch:{ Exception -> 0x05cb }
            goto L_0x05cc
        L_0x05cb:
        L_0x05cc:
            java.lang.String r3 = r6.getPassengerName()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x05db
            r4 = r7[r13]
            r4.setText(r3)
        L_0x05db:
            r3 = r52[r13]
            r4 = 0
            r3.setVisibility(r4)
            if (r6 == 0) goto L_0x05f6
            int r3 = r6.getPassengerage()
            if (r3 <= 0) goto L_0x05f6
            r3 = r17[r13]
            int r5 = r6.getPassengerage()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r3.setText(r5)
        L_0x05f6:
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0601
            java.lang.String r0 = "Mrs"
            r2.equalsIgnoreCase(r0)
        L_0x0601:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            r15.setTag(r0)
            r0 = r7[r13]
            r2 = r7[r13]
            android.text.Editable r2 = r2.getText()
            int r2 = r2.length()
            r0.setSelection(r2)
            android.widget.LinearLayout r0 = r11.f22302d
            r0.addView(r15)
            int r13 = r13 + 1
            r14 = r1
            r40 = r7
            r12 = r41
            r3 = r42
            r2 = r45
            r6 = r46
            r4 = r47
            r5 = r48
            r1 = r49
            r15 = r50
            r9 = r52
            r7 = r53
            r10 = r55
            goto L_0x010f
        L_0x0639:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.fragment.m.d():void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h() {
        if (!this.ah) {
            f("close_saved_traveller_list");
        } else {
            this.ah = false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(RoboTextView[] roboTextViewArr, ImageView[] imageViewArr, RadioButton[] radioButtonArr, RadioButton[] radioButtonArr2, RadioGroup radioGroup, int i2) {
        e("gender");
        int intValue = ((Integer) radioGroup.getTag()).intValue();
        int i3 = R.color.color_9b9b9b;
        int i4 = R.color.color_9b9b9b;
        if (i2 == R.id.title_mr) {
            roboTextViewArr[intValue].setVisibility(8);
            if (this.p.get(intValue).getLength() > 1 || this.p.get(intValue).getWidth() > 1) {
                imageViewArr[intValue].setImageDrawable(androidx.core.content.b.a(getContext(), R.drawable.bus_sleeper_selected));
            } else {
                imageViewArr[intValue].setImageDrawable(androidx.core.content.b.a(getContext(), R.drawable.bus_passenger_seat_green));
            }
            if (!this.v.get(intValue).isLadiesSeat()) {
                this.v.get(intValue).setTitle("Mr");
                this.v.get(intValue).setGender("male");
                i3 = R.color.color_323232;
            } else {
                radioButtonArr[intValue].setChecked(false);
                radioButtonArr2[intValue].setChecked(true);
                this.v.get(intValue).setTitle("Ms");
                this.v.get(intValue).setGender("female");
                i4 = R.color.color_323232;
            }
        } else if (i2 == R.id.title_mrs) {
            this.v.get(intValue).setTitle("Mrs");
            this.v.get(intValue).setGender("female");
            i4 = R.color.color_323232;
            roboTextViewArr[intValue].setVisibility(0);
            if (this.p.get(intValue).getLength() > 1 || this.p.get(intValue).getWidth() > 1) {
                imageViewArr[intValue].setImageDrawable(androidx.core.content.b.a(getContext(), R.drawable.bus_sleeper_booked_ladies));
            } else {
                imageViewArr[intValue].setImageDrawable(androidx.core.content.b.a(getContext(), R.drawable.bus_passenger_seat_ladies));
            }
        }
        radioButtonArr[intValue].setTextColor(androidx.core.content.b.c(getActivity(), i3));
        radioButtonArr2[intValue].setTextColor(androidx.core.content.b.c(getActivity(), i4));
    }

    private void a(Spinner[] spinnerArr, TextInputLayout[] textInputLayoutArr, EditText[] editTextArr, View[] viewArr, int i2, ArrayList<CJRBusTravellerExtraDetailsFieldModel> arrayList, CJRBusTravellerExtraDetailsFieldModel cJRBusTravellerExtraDetailsFieldModel, CJRPassengerDetails cJRPassengerDetails) {
        final int i3 = i2;
        ArrayList<CJRBusTravellerExtraDetailsFieldModel> arrayList2 = arrayList;
        String lowerCase = cJRBusTravellerExtraDetailsFieldModel.getType().trim().toLowerCase();
        String format = String.format("Please select %s", new Object[]{(arrayList2 == null || arrayList.size() <= 0 || arrayList2.get(0) == null) ? AppManagerUtil.EXTEND_TYPE : arrayList2.get(0).getLabel()});
        if (lowerCase.equalsIgnoreCase("dropdown")) {
            ArrayList<CJRDropdownOptionsModel> options = cJRBusTravellerExtraDetailsFieldModel.getOptions();
            this.N = new ArrayList<>();
            this.S = new HashMap<>();
            Iterator<CJRDropdownOptionsModel> it2 = options.iterator();
            while (it2.hasNext()) {
                CJRDropdownOptionsModel next = it2.next();
                if (!TextUtils.isEmpty(next.getDisplay())) {
                    if (this.N.size() == 0) {
                        this.N.add(format);
                        this.S.put(format, format);
                    }
                    this.N.add(next.getDisplay());
                    this.S.put(next.getDisplay(), next.getValue());
                }
            }
            String defaultSelected = cJRBusTravellerExtraDetailsFieldModel.getDefaultSelected();
            if (TextUtils.isEmpty(defaultSelected) || !this.N.contains(defaultSelected)) {
                defaultSelected = this.N.get(0);
            } else {
                this.N.remove(defaultSelected);
                this.N.add(0, defaultSelected);
            }
            this.v.get(i3).setIdCardType(this.S.get(defaultSelected));
            Context context = getContext();
            ArrayList<String> arrayList3 = this.N;
            spinnerArr[i3].setAdapter(new com.travel.bus.busticket.a.j(context, (String[]) arrayList3.toArray(new String[arrayList3.size()]), true));
            spinnerArr[i3].setSelection(0);
            Iterator<CJRDropdownOptionsModel> it3 = options.iterator();
            String str = "";
            while (it3.hasNext()) {
                CJRDropdownOptionsModel next2 = it3.next();
                if (defaultSelected.trim().equalsIgnoreCase(next2.getDisplay())) {
                    str = next2.getShow().get(0);
                }
            }
            Iterator<CJRBusTravellerExtraDetailsFieldModel> it4 = arrayList.iterator();
            while (it4.hasNext()) {
                CJRBusTravellerExtraDetailsFieldModel next3 = it4.next();
                if (next3.getName().trim().equalsIgnoreCase(str)) {
                    String label = next3.getLabel();
                    textInputLayoutArr[i3].setHint(label);
                    this.O = next3.getRegex();
                    this.P = label;
                    this.Q = next3.getError_text();
                    StringBuilder sb = new StringBuilder("Default regex for ");
                    sb.append(this.P);
                    sb.append("   >>>>> ");
                    sb.append(this.O);
                }
            }
            final ArrayList<CJRDropdownOptionsModel> arrayList4 = options;
            final int i4 = i2;
            final TextInputLayout[] textInputLayoutArr2 = textInputLayoutArr;
            final EditText[] editTextArr2 = editTextArr;
            final View[] viewArr2 = viewArr;
            final ArrayList<CJRBusTravellerExtraDetailsFieldModel> arrayList5 = arrayList;
            final CJRPassengerDetails cJRPassengerDetails2 = cJRPassengerDetails;
            spinnerArr[i3].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public final void onNothingSelected(AdapterView<?> adapterView) {
                }

                /* JADX WARNING: Removed duplicated region for block: B:10:0x006a  */
                /* JADX WARNING: Removed duplicated region for block: B:18:0x00d2  */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x00f9  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onItemSelected(android.widget.AdapterView<?> r3, android.view.View r4, int r5, long r6) {
                    /*
                        r2 = this;
                        java.lang.String r3 = ""
                        r4 = 0
                        if (r5 <= 0) goto L_0x003a
                        int r5 = r5 + -1
                        java.util.ArrayList r6 = r2
                        java.lang.Object r6 = r6.get(r5)
                        com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDropdownOptionsModel r6 = (com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDropdownOptionsModel) r6
                        java.util.ArrayList r6 = r6.getShow()
                        if (r6 == 0) goto L_0x003a
                        java.util.ArrayList r6 = r2
                        java.lang.Object r6 = r6.get(r5)
                        com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDropdownOptionsModel r6 = (com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDropdownOptionsModel) r6
                        java.util.ArrayList r6 = r6.getShow()
                        int r6 = r6.size()
                        if (r6 <= 0) goto L_0x003a
                        java.util.ArrayList r6 = r2
                        java.lang.Object r6 = r6.get(r5)
                        com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDropdownOptionsModel r6 = (com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDropdownOptionsModel) r6
                        java.util.ArrayList r6 = r6.getShow()
                        java.lang.Object r6 = r6.get(r4)
                        java.lang.String r6 = (java.lang.String) r6
                        goto L_0x003b
                    L_0x003a:
                        r6 = r3
                    L_0x003b:
                        com.travel.bus.busticket.fragment.m r7 = com.travel.bus.busticket.fragment.m.this
                        java.util.HashMap r7 = r7.S
                        java.util.ArrayList r0 = r2
                        java.lang.Object r5 = r0.get(r5)
                        com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDropdownOptionsModel r5 = (com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRDropdownOptionsModel) r5
                        java.lang.String r5 = r5.getDisplay()
                        java.lang.Object r5 = r7.get(r5)
                        java.lang.String r5 = (java.lang.String) r5
                        com.travel.bus.busticket.fragment.m r7 = com.travel.bus.busticket.fragment.m.this
                        java.util.ArrayList r7 = r7.v
                        int r0 = r3
                        java.lang.Object r7 = r7.get(r0)
                        com.travel.bus.pojo.busticket.CJRPassengerDetails r7 = (com.travel.bus.pojo.busticket.CJRPassengerDetails) r7
                        r7.setIdCardType(r5)
                        boolean r5 = android.text.TextUtils.isEmpty(r6)
                        if (r5 == 0) goto L_0x00d2
                        com.google.android.material.textfield.TextInputLayout[] r5 = r4
                        int r7 = r3
                        r5 = r5[r7]
                        r7 = 8
                        r5.setVisibility(r7)
                        android.widget.EditText[] r5 = r5
                        int r0 = r3
                        r5 = r5[r0]
                        r5.setVisibility(r7)
                        android.view.View[] r5 = r6
                        int r0 = r3
                        r5 = r5[r0]
                        r5.setVisibility(r7)
                        com.travel.bus.busticket.fragment.m r5 = com.travel.bus.busticket.fragment.m.this
                        r7 = 0
                        java.lang.String unused = r5.O = r7
                        com.travel.bus.busticket.fragment.m r5 = com.travel.bus.busticket.fragment.m.this
                        java.lang.String unused = r5.P = r7
                        com.travel.bus.busticket.fragment.m r5 = com.travel.bus.busticket.fragment.m.this
                        java.lang.String unused = r5.Q = r7
                        java.util.ArrayList r5 = r7
                        if (r5 == 0) goto L_0x00ba
                        int r5 = r5.size()
                        if (r5 <= 0) goto L_0x00ba
                        java.util.ArrayList r5 = r7
                        java.lang.Object r5 = r5.get(r4)
                        if (r5 == 0) goto L_0x00ba
                        com.travel.bus.busticket.fragment.m r5 = com.travel.bus.busticket.fragment.m.this
                        java.util.ArrayList r7 = r7
                        java.lang.Object r4 = r7.get(r4)
                        com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRBusTravellerExtraDetailsFieldModel r4 = (com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRBusTravellerExtraDetailsFieldModel) r4
                        java.lang.String r4 = r4.getLabel()
                        java.lang.String unused = r5.P = r4
                    L_0x00ba:
                        com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRBusTravellerExtraDetailsFieldModel r4 = new com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRBusTravellerExtraDetailsFieldModel
                        r4.<init>()
                        r5 = 1
                        r4.setRequired(r5)
                        com.travel.bus.busticket.fragment.m r5 = com.travel.bus.busticket.fragment.m.this
                        java.lang.String r5 = r5.P
                        r4.setLabel(r5)
                        com.travel.bus.pojo.busticket.CJRPassengerDetails r5 = r8
                        r5.setTravellerExtraDetailsFieldModel(r4)
                        goto L_0x00ed
                    L_0x00d2:
                        com.google.android.material.textfield.TextInputLayout[] r5 = r4
                        int r7 = r3
                        r5 = r5[r7]
                        r5.setVisibility(r4)
                        android.widget.EditText[] r5 = r5
                        int r7 = r3
                        r5 = r5[r7]
                        r5.setVisibility(r4)
                        android.view.View[] r5 = r6
                        int r7 = r3
                        r5 = r5[r7]
                        r5.setVisibility(r4)
                    L_0x00ed:
                        java.util.ArrayList r4 = r7
                        java.util.Iterator r4 = r4.iterator()
                    L_0x00f3:
                        boolean r5 = r4.hasNext()
                        if (r5 == 0) goto L_0x015e
                        java.lang.Object r5 = r4.next()
                        com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRBusTravellerExtraDetailsFieldModel r5 = (com.travel.bus.pojo.busticket.BusTravellerExtraDetails.CJRBusTravellerExtraDetailsFieldModel) r5
                        java.lang.String r7 = r5.getName()
                        java.lang.String r7 = r7.trim()
                        boolean r7 = r7.equalsIgnoreCase(r6)
                        if (r7 == 0) goto L_0x00f3
                        java.lang.String r7 = r5.getLabel()
                        com.google.android.material.textfield.TextInputLayout[] r0 = r4
                        int r1 = r3
                        r0 = r0[r1]
                        r0.setHint(r7)
                        android.widget.EditText[] r0 = r5
                        int r1 = r3
                        r0 = r0[r1]
                        r0.setText(r3)
                        com.travel.bus.busticket.fragment.m r0 = com.travel.bus.busticket.fragment.m.this
                        java.lang.String r1 = r5.getRegex()
                        java.lang.String unused = r0.O = r1
                        com.travel.bus.busticket.fragment.m r0 = com.travel.bus.busticket.fragment.m.this
                        java.lang.String unused = r0.P = r7
                        com.travel.bus.busticket.fragment.m r7 = com.travel.bus.busticket.fragment.m.this
                        java.lang.String r0 = r5.getError_text()
                        java.lang.String unused = r7.Q = r0
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder
                        java.lang.String r0 = "Default regex for "
                        r7.<init>(r0)
                        com.travel.bus.busticket.fragment.m r0 = com.travel.bus.busticket.fragment.m.this
                        java.lang.String r0 = r0.P
                        r7.append(r0)
                        java.lang.String r0 = "   >>>>> "
                        r7.append(r0)
                        com.travel.bus.busticket.fragment.m r0 = com.travel.bus.busticket.fragment.m.this
                        java.lang.String r0 = r0.O
                        r7.append(r0)
                        com.travel.bus.pojo.busticket.CJRPassengerDetails r7 = r8
                        r7.setTravellerExtraDetailsFieldModel(r5)
                        goto L_0x00f3
                    L_0x015e:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.fragment.m.AnonymousClass3.onItemSelected(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
            editTextArr[i3].addTextChangedListener(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    String obj = (editable == null || editable.length() <= 0) ? "" : editable.toString();
                    if (obj != null) {
                        ((CJRPassengerDetails) m.this.v.get(i3)).setIdCardValue(obj);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(AlertDialog alertDialog, View view) {
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), AJRBusSelectSeatsActivity.class);
            intent.putExtra("intent_extra_bus_search_result_item", this.s);
            intent.putExtra("intent_extra_bus_search", this.B);
            intent.putExtra("intent_extra_bus_search_input", this.r);
            getActivity().startActivity(intent);
            alertDialog.dismiss();
        }
    }

    private void b(String str) {
        View inflate = getLayoutInflater().inflate(R.layout.pre_b_alert_on_info_on_concession, (ViewGroup) null);
        ((RoboTextView) inflate.findViewById(R.id.disp_title)).setText(getString(R.string.concession_card));
        ((RoboTextView) inflate.findViewById(R.id.disp_message)).setText(str);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(inflate);
        AlertDialog create = builder.create();
        create.show();
        ((RoboTextView) inflate.findViewById(R.id.ok_msg)).setOnClickListener(new View.OnClickListener(create) {
            private final /* synthetic */ AlertDialog f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(View view) {
                this.f$0.dismiss();
            }
        });
        ((ImageView) inflate.findViewById(R.id.close_icon)).setOnClickListener(new View.OnClickListener(create) {
            private final /* synthetic */ AlertDialog f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(View view) {
                this.f$0.dismiss();
            }
        });
    }

    private void a(boolean z2, CJRBusInsuranceItem cJRBusInsuranceItem) {
        if (cJRBusInsuranceItem != null) {
            this.f22305g.setVisibility(8);
            this.w = z2;
            this.f22306h.setChecked(cJRBusInsuranceItem.isSelected());
            this.z = cJRBusInsuranceItem;
            if (!TextUtils.isEmpty(cJRBusInsuranceItem.getTitle())) {
                this.j.setText(cJRBusInsuranceItem.getTitle());
                this.j.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        m.this.a(view);
                    }
                });
            }
            if (!TextUtils.isEmpty(cJRBusInsuranceItem.getDescription())) {
                this.f22307i.setText(cJRBusInsuranceItem.getDescription());
                AnonymousClass5 r6 = new ClickableSpan() {
                    public final void onClick(View view) {
                        if (m.this.f22306h != null) {
                            m.this.f22306h.setChecked(!m.this.f22306h.isChecked());
                        }
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                        textPaint.setColor(Color.parseColor("#ff666666"));
                    }
                };
                AnonymousClass6 r0 = new ClickableSpan() {
                    public final void onClick(View view) {
                        if (m.this.z != null && m.this.z.getTc() != null && !"".equalsIgnoreCase(m.this.z.getTc().trim())) {
                            m mVar = m.this;
                            m.j(mVar, mVar.z.getTc());
                            HashMap hashMap = new HashMap();
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Passenger Details Screen");
                            com.travel.bus.a.a();
                            com.travel.bus.a.b().a("bus_passenger_premium_tnc_checked", (Map<String, Object>) hashMap, (Context) m.this.getActivity());
                        }
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                        textPaint.setColor(Color.parseColor("#ff33b5e5"));
                    }
                };
                if (!TextUtils.isEmpty(cJRBusInsuranceItem.getTc())) {
                    String str = "\t" + getString(R.string.view_terms_and_condtions_str);
                    String str2 = cJRBusInsuranceItem.getDescription() + str;
                    int indexOf = str2.indexOf(str);
                    if (indexOf != -1) {
                        SpannableString spannableString = new SpannableString(str2);
                        spannableString.setSpan(r6, 0, cJRBusInsuranceItem.getDescription().length(), 0);
                        spannableString.setSpan(r0, indexOf + 1, indexOf + str.length(), 0);
                        this.f22307i.setText(spannableString);
                        this.f22307i.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        CheckBox checkBox = this.f22306h;
        if (checkBox != null) {
            checkBox.setChecked(!checkBox.isChecked());
        }
    }

    private void e() {
        if (getActivity() != null || getActivity().isFinishing()) {
            this.I.setBackgroundColor(getResources().getColor(R.color.white));
            this.I.setVisibility(0);
        }
    }

    private void f() {
        RelativeLayout relativeLayout;
        if (getActivity() != null && (relativeLayout = this.I) != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private void c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                com.travel.bus.a.a();
                com.travel.bus.a.b().a("passenger_validation_error", "/bus-tickets/passenger-details", "ERROR_MESSAGE", str, (Context) getActivity());
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("intent_extra_selected_seats", this.p);
        bundle.putSerializable("intent_extra_bus_search_input", this.r);
        bundle.putSerializable("intent_extra_bus_search_result_item", this.s);
        bundle.putSerializable("intent_extra_passenger_details", this.v);
        bundle.putSerializable("requestid", this.B);
        bundle.putSerializable("intent_extra_bus_trip_detail", this.q);
        bundle.putSerializable("intent_extra_selected_boarding_point", this.t);
        bundle.putSerializable("intent_extra_selected_dropping_point", this.u);
        bundle.putSerializable("intent_extra_bus_search_load_data", this.A);
        bundle.putString("EMAIL", this.f22304f.getText().toString());
        bundle.putString(CJRQRScanResultModel.KEY_MOBILE_NO, this.f22303e.getText().toString());
        return bundle;
    }

    public void onErrorResponse(VolleyError volleyError) {
        f();
    }

    private void d(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(str, (Map<String, Object>) hashMap, (Context) getActivity());
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Confirm Booking page - passenger contentDetails section");
        hashMap.put("bus_user_id", com.paytm.utility.b.n((Context) getActivity()));
        hashMap.put("bus_origin", this.s.getSource().toString());
        hashMap.put("bus_destination", this.s.getDestination().toString());
        if (str.equalsIgnoreCase("gender")) {
            str2 = "bus_passenger_gender_clicked";
        } else if (str.equalsIgnoreCase("name")) {
            str2 = "bus_passenger_name_clicked";
        } else if (str.equalsIgnoreCase("age")) {
            str2 = "bus_passenger_age_clicked";
        } else if (str.equalsIgnoreCase("contact")) {
            str2 = "bus_passenger_contact_clicked";
        } else {
            str2 = str.equalsIgnoreCase(com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL) ? "bus_passenger_email_clicked" : "";
        }
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(str2, (Map<String, Object>) hashMap, (Context) getActivity());
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(str2, (Map<String, Object>) hashMap, (Context) getActivity());
    }

    private boolean g() {
        getContext();
        String d2 = com.paytm.utility.b.d(this.s.getDepartureDatetime(), "yyyy-MM-dd HH:mm:ss", "HHmm");
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        String str = d2 + " " + (d2.subSequence(0, 2) + AppConstants.COLON + d2.subSequence(2, 4));
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            long time = (simpleDateFormat.parse(str).getTime() - simpleDateFormat.parse(format).getTime()) / 3600000;
            com.travel.bus.a.a();
            if (time < ((long) com.travel.bus.a.b().i())) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void a(CJRBusTpUserProfileContact cJRBusTpUserProfileContact, View view) {
        if (cJRBusTpUserProfileContact != null) {
            f("deletion_saved_traveller_list");
            d(d.cI);
            com.travel.bus.busticket.i.n a2 = com.travel.bus.busticket.i.n.a();
            Context context = getContext();
            if (a2.f22465a != null && a2.f22465a.size() > 0) {
                a2.f22465a.remove(cJRBusTpUserProfileContact);
            }
            com.travel.bus.a.a();
            String s2 = com.paytm.utility.b.s(context, com.travel.bus.a.b().A());
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            JSONObject a3 = com.travel.bus.busticket.i.q.a(context, cJRBusTpUserProfileContact);
            if (URLUtil.isValidUrl(s2)) {
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = context;
                bVar.f42878b = a.c.BUS;
                bVar.f42879c = a.C0715a.POST;
                bVar.f42880d = s2;
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = null;
                bVar.f42884h = a3.toString();
                bVar.f42885i = new CJRBusUserDeleteProfile();
                bVar.j = this;
                bVar.t = com.travel.bus.busticket.i.n.b();
                bVar.n = a.b.SILENT;
                bVar.o = "bus-traveller-page";
                bVar.l().a();
            }
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
            z zVar = (z) autoCompleteTextView.getAdapter();
            ArrayList<CJRBusTpUserProfileContact> arrayList = zVar.f21809b;
            arrayList.remove(cJRBusTpUserProfileContact);
            zVar.a(arrayList, autoCompleteTextView.getText());
            this.F.remove(cJRBusTpUserProfileContact);
            if (this.G.contains(cJRBusTpUserProfileContact)) {
                this.G.remove(cJRBusTpUserProfileContact);
            }
            if (this.H.contains(cJRBusTpUserProfileContact)) {
                this.H.remove(cJRBusTpUserProfileContact);
            }
            new Handler().post(new Runnable(autoCompleteTextView) {
                private final /* synthetic */ AutoCompleteTextView f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    m.this.c(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(AutoCompleteTextView autoCompleteTextView) {
        if (getActivity() != null && isAdded() && isVisible() && autoCompleteTextView != null) {
            autoCompleteTextView.showDropDown();
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        a(2, iJRPaytmDataModel);
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (getActivity() != null && !getActivity().isFinishing() && !isDetached() && (iJRPaytmDataModel instanceof CJRBusUserProfile)) {
            a((CJRBusUserProfile) iJRPaytmDataModel);
        }
    }

    private void a(CJRBusUserProfile cJRBusUserProfile) {
        ArrayList arrayList;
        f();
        ArrayList<CJRBusTpUserProfileContact> contacts = cJRBusUserProfile.getBody().getContacts();
        new ArrayList(contacts);
        com.travel.bus.busticket.i.n.a().a(contacts);
        this.D = contacts.size();
        if (this.D > 0) {
            this.F.clear();
            for (int i2 = 0; i2 < contacts.size(); i2++) {
                CJRBusTpUserProfileContact cJRBusTpUserProfileContact = contacts.get(i2);
                if (cJRBusTpUserProfileContact != null && !TextUtils.isEmpty(cJRBusTpUserProfileContact.getGender()) && cJRBusTpUserProfileContact.getAge() != null && Integer.parseInt(cJRBusTpUserProfileContact.getAge()) > 0) {
                    this.F.add(cJRBusTpUserProfileContact);
                }
            }
            this.G = new ArrayList<>();
            this.H = new ArrayList<>();
            for (int i3 = 0; i3 < this.F.size(); i3++) {
                if (!(this.F.get(i3) == null || this.F.get(i3).getGender() == null)) {
                    if (this.F.get(i3).getGender().equalsIgnoreCase("female") || this.F.get(i3).getGender().equalsIgnoreCase(AppConstants.FEED_SUB_TYPE)) {
                        this.G.add(this.F.get(i3));
                    } else {
                        this.H.add(this.F.get(i3));
                    }
                }
            }
            this.J.setVisibility(0);
            ArrayList<CJRPassengerDetails> arrayList2 = this.v;
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (int i4 = 0; i4 < this.v.size(); i4++) {
                    View childAt = this.f22302d.getChildAt(i4);
                    if (childAt != null) {
                        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) childAt.findViewById(R.id.passenger_name_input);
                        Map<String, Integer> a2 = o.a(getContext());
                        if (!a2.isEmpty()) {
                            Integer num = a2.get("Height");
                            if (num != null) {
                                m.class.getSimpleName();
                                String.valueOf(num);
                                autoCompleteTextView.setDropDownHeight(num.intValue() / 5);
                            } else {
                                autoCompleteTextView.setDropDownHeight(400);
                            }
                        }
                        EditText editText = (EditText) childAt.findViewById(R.id.passenger_age_input);
                        RadioGroup radioGroup = (RadioGroup) childAt.findViewById(R.id.title_radio_group);
                        RadioButton radioButton = (RadioButton) childAt.findViewById(R.id.title_mrs);
                        RadioButton radioButton2 = (RadioButton) childAt.findViewById(R.id.title_mr);
                        autoCompleteTextView.setTag(R.string.ladies_only, Boolean.valueOf(this.v.get(i4).isLadiesSeat()));
                        if (this.v.get(i4).isLadiesSeat() || radioButton.isChecked()) {
                            arrayList = new ArrayList(this.G);
                            radioButton.setChecked(true);
                        } else if (radioButton2.isChecked()) {
                            arrayList = new ArrayList(this.H);
                        } else {
                            arrayList = new ArrayList(this.F);
                        }
                        ((z) autoCompleteTextView.getAdapter()).a((ArrayList<CJRBusTpUserProfileContact>) arrayList);
                        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(editText, autoCompleteTextView, radioGroup) {
                            private final /* synthetic */ EditText f$1;
                            private final /* synthetic */ AutoCompleteTextView f$2;
                            private final /* synthetic */ RadioGroup f$3;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                                this.f$3 = r4;
                            }

                            public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
                                m.this.a(this.f$1, this.f$2, this.f$3, adapterView, view, i2, j);
                            }
                        });
                        AutoCompleteTextView autoCompleteTextView2 = autoCompleteTextView;
                        ArrayList<CJRBusTpUserProfileContact> arrayList3 = contacts;
                        RadioButton radioButton3 = radioButton;
                        RadioButton radioButton4 = radioButton2;
                        autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener(autoCompleteTextView2, arrayList3, radioButton3, radioButton4) {
                            private final /* synthetic */ AutoCompleteTextView f$1;
                            private final /* synthetic */ ArrayList f$2;
                            private final /* synthetic */ RadioButton f$3;
                            private final /* synthetic */ RadioButton f$4;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                                this.f$3 = r4;
                                this.f$4 = r5;
                            }

                            public final void onFocusChange(View view, boolean z) {
                                m.this.a(this.f$1, this.f$2, this.f$3, this.f$4, view, z);
                            }
                        });
                        autoCompleteTextView.setOnClickListener(new View.OnClickListener(autoCompleteTextView2, arrayList3, radioButton3, radioButton4) {
                            private final /* synthetic */ AutoCompleteTextView f$1;
                            private final /* synthetic */ ArrayList f$2;
                            private final /* synthetic */ RadioButton f$3;
                            private final /* synthetic */ RadioButton f$4;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                                this.f$3 = r4;
                                this.f$4 = r5;
                            }

                            public final void onClick(View view) {
                                m.this.a(this.f$1, this.f$2, this.f$3, this.f$4, view);
                            }
                        });
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(EditText editText, AutoCompleteTextView autoCompleteTextView, RadioGroup radioGroup, AdapterView adapterView, View view, int i2, long j2) {
        LinearLayout linearLayout;
        RadioButton radioButton;
        z zVar = (z) adapterView.getAdapter();
        CJRBusTpUserProfileContact a2 = zVar.getItem(i2);
        int i3 = zVar.f21810c;
        d(d.cG);
        if (a2 != null) {
            String age = a2.getAge();
            String fullname = a2.getFullname();
            String gender = a2.getGender();
            editText.setText(age);
            autoCompleteTextView.setText(fullname);
            f("selection_saved_traveller_list");
            int i4 = 0;
            while (true) {
                if (i4 >= radioGroup.getChildCount()) {
                    break;
                }
                radioButton = (RadioButton) radioGroup.getChildAt(i4);
                String str = radioButton.getText().toString().trim().equalsIgnoreCase(getString(R.string.male)) ? "Male" : "Female";
                if (str.equalsIgnoreCase(gender) || ((str.equalsIgnoreCase("Male") && gender.equalsIgnoreCase("M")) || (str.equalsIgnoreCase("Female") && gender.equalsIgnoreCase(AppConstants.FEED_SUB_TYPE)))) {
                    radioButton.setChecked(true);
                } else {
                    i4++;
                }
            }
            radioButton.setChecked(true);
        }
        this.E.put(Integer.valueOf(i3), a2);
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(autoCompleteTextView.getWindowToken(), 0);
        ScrollView scrollView = this.o;
        if (scrollView != null && (linearLayout = this.J) != null) {
            scrollView.smoothScrollTo(0, linearLayout.getBottom() * (i3 + 1) * 4);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AutoCompleteTextView autoCompleteTextView, ArrayList arrayList, RadioButton radioButton, RadioButton radioButton2, View view, boolean z2) {
        ArrayList arrayList2;
        if (z2) {
            int intValue = ((Integer) autoCompleteTextView.getTag()).intValue();
            if (intValue == 0) {
                this.o.scrollTo(0, this.J.getBottom());
            } else {
                this.o.scrollTo(0, this.J.getBottom() * intValue * 4);
            }
            arrayList.clear();
            if (autoCompleteTextView.getTag(R.string.ladies_only).equals(Boolean.TRUE) || radioButton.isChecked()) {
                arrayList2 = new ArrayList(this.G);
            } else if (radioButton2.isChecked()) {
                arrayList2 = new ArrayList(this.H);
            } else {
                arrayList2 = new ArrayList(this.F);
            }
            arrayList.addAll(arrayList2);
            for (CJRBusTpUserProfileContact remove : this.E.values()) {
                arrayList.remove(remove);
            }
            ((z) autoCompleteTextView.getAdapter()).a((ArrayList<CJRBusTpUserProfileContact>) arrayList, autoCompleteTextView.getText());
            new Handler().post(new Runnable(autoCompleteTextView) {
                private final /* synthetic */ AutoCompleteTextView f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    m.this.b(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(AutoCompleteTextView autoCompleteTextView) {
        if (getActivity() != null && autoCompleteTextView != null && isAdded() && isVisible()) {
            autoCompleteTextView.showDropDown();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AutoCompleteTextView autoCompleteTextView, ArrayList arrayList, RadioButton radioButton, RadioButton radioButton2, View view) {
        ArrayList arrayList2;
        if (((Integer) autoCompleteTextView.getTag()).intValue() == 0) {
            this.o.scrollTo(0, this.J.getBottom());
        }
        e("name");
        arrayList.clear();
        if (autoCompleteTextView.getTag(R.string.ladies_only).equals(Boolean.TRUE) || radioButton.isChecked()) {
            arrayList2 = new ArrayList(this.G);
        } else if (radioButton2.isChecked()) {
            arrayList2 = new ArrayList(this.H);
        } else {
            arrayList2 = new ArrayList(this.F);
        }
        arrayList.addAll(arrayList2);
        for (CJRBusTpUserProfileContact remove : this.E.values()) {
            arrayList.remove(remove);
        }
        ((z) autoCompleteTextView.getAdapter()).a((ArrayList<CJRBusTpUserProfileContact>) arrayList, autoCompleteTextView.getText());
        new Handler().post(new Runnable(autoCompleteTextView) {
            private final /* synthetic */ AutoCompleteTextView f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                m.this.a(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AutoCompleteTextView autoCompleteTextView) {
        if (getActivity() != null && autoCompleteTextView != null && isAdded() && isVisible()) {
            autoCompleteTextView.showDropDown();
        }
    }

    private void f(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_label2", this.r.getSource().getDisplayCityName() + "/" + this.r.getDestination().getDisplayCityName());
        try {
            hashMap.put("event_label3", this.q.getMeta().getProvider().getName());
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        hashMap.put("userid", com.paytm.utility.b.n((Context) getActivity()));
        com.travel.bus.a.a();
        com.travel.bus.a.a("customEvent", "/bus-tickets-traveller", "bus_passenger", str, hashMap);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2 && i3 == 11) {
            if (intent == null || !intent.hasExtra("bus_confirmation_intent")) {
                c();
            } else {
                startActivity(a(false, intent.getStringExtra("bus_confirmation_intent")));
            }
        } else if (i2 == 101) {
            if (i3 == -1) {
                this.V.setChecked(true);
            }
            if (intent != null) {
                this.Y = intent.getStringExtra("BUSINESS_GST");
                this.Z = intent.getStringExtra("BUSINESS_COMPANY");
                this.af = intent.getStringExtra("BUSINESS_EMAIL");
                this.aa = intent.getStringExtra("BUSINESS_FLAT");
                this.ab = intent.getStringExtra("BUSINESS_STREET");
                this.ac = intent.getStringExtra("BUSINESS_PIN");
                this.ad = intent.getStringExtra("BUSINESS_STATE");
                this.ae = intent.getStringExtra("BUSINESS_CITY");
            }
        }
    }

    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.p = (ArrayList) arguments.getSerializable("intent_extra_selected_seats");
            this.r = (CJRBusSearchInput) arguments.getSerializable("intent_extra_bus_search_input");
            this.s = (CJRBusSearchItem) arguments.getSerializable("intent_extra_bus_search_result_item");
            this.v = (ArrayList) arguments.getSerializable("intent_extra_passenger_details");
            this.B = arguments.getString("requestid", (String) null);
            this.q = (TripBusDetail) arguments.getSerializable("intent_extra_bus_trip_detail");
            this.t = (CJRLocation) arguments.getSerializable("intent_extra_selected_boarding_point");
            this.u = (CJRLocation) arguments.getSerializable("intent_extra_selected_dropping_point");
            this.x = arguments.getBoolean("isSingleLady", false);
            this.U = (CJRBusUserProfile) arguments.getSerializable("traveller_details_key");
            this.A = (HashMap) arguments.getSerializable("intent_extra_bus_search_load_data");
        }
        super.onCreate(bundle);
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            this.p = (ArrayList) bundle.getSerializable("intent_extra_selected_seats");
            this.r = (CJRBusSearchInput) bundle.getSerializable("intent_extra_bus_search_input");
            this.s = (CJRBusSearchItem) bundle.getSerializable("intent_extra_bus_search_result_item");
            this.v = (ArrayList) bundle.getSerializable("intent_extra_passenger_details");
            this.B = bundle.getString("requestid", (String) null);
            this.q = (TripBusDetail) bundle.getSerializable("intent_extra_bus_trip_detail");
            this.t = (CJRLocation) bundle.getSerializable("intent_extra_selected_boarding_point");
            this.u = (CJRLocation) bundle.getSerializable("intent_extra_selected_dropping_point");
        }
        if (!com.paytm.utility.b.c((Context) getActivity())) {
            String string = getResources().getString(R.string.no_connection);
            String string2 = getResources().getString(R.string.no_internet);
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setmAlertTitle(string);
            networkCustomError.setAlertMessage(string2);
            a(2, networkCustomError);
            return;
        }
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(a.c.BUS, (Activity) getActivity(), (b) new b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                m.this.a(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                m.this.a(2, networkCustomError);
            }
        });
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!(networkCustomError == null || networkCustomError.getAlertMessage() == null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "bus_passenger");
            hashMap.put("event_action", "error_popup");
            hashMap.put("event_label", networkCustomError.getAlertMessage());
            hashMap.put("event_label2", Integer.valueOf(networkCustomError.getStatusCode()));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-traveller");
            hashMap.put("vertical_name", "bus");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
        }
        f();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_passenger");
        hashMap.put("event_action", "card_icon_clicked");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Passenger Details Screen");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
        if (this.L.equals("Senior Citizen")) {
            b(getResources().getString(R.string.a_deduction_of_25_will_be_available_for_senior_citizen_holders));
        }
        if (this.L.equals("Cat Card")) {
            b(getResources().getString(R.string.a_deduction_of_10_will_be_available_for_cat_card_holders));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, boolean z2) {
        if (!z2) {
            try {
                String obj = this.f22304f.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    com.travel.bus.a.a();
                    com.travel.bus.a.b().a("passenger_email_changed", "/bus-tickets/passenger-details", "EMAIL", obj, (Context) getActivity());
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view, boolean z2) {
        if (!z2) {
            try {
                String obj = this.f22303e.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    com.travel.bus.a.a();
                    com.travel.bus.a.b().a("passenger_mobile_changed", "/bus-tickets/passenger-details", "MOBILE", obj, (Context) getActivity());
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01c6, code lost:
        if (android.text.TextUtils.isEmpty(r13) == false) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01c8, code lost:
        com.paytm.utility.b.b((android.content.Context) getActivity(), r0.getString(com.travel.bus.R.string.special_characters_title), r0.getString(com.travel.bus.R.string.select_gender_text) + " " + r0.getString(com.travel.bus.R.string.passenger_small_text));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01f4, code lost:
        com.paytm.utility.b.b((android.content.Context) getActivity(), r0.getString(com.travel.bus.R.string.special_characters_title), r0.getString(com.travel.bus.R.string.select_gender_text) + " '" + r13 + "'");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x021e, code lost:
        c(r0.getString(com.travel.bus.R.string.select_gender_text) + " '" + r13);
        a(r0.getString(com.travel.bus.R.string.select_gender_text) + " '" + r13);
     */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x056f  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0582  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0601  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void f(android.view.View r37) {
        /*
            r36 = this;
            r1 = r36
            androidx.fragment.app.FragmentActivity r0 = r36.getActivity()
            android.content.res.Resources r0 = r0.getResources()
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r2 = r1.v
            r3 = 3
            java.lang.String r4 = "event_label2"
            java.lang.String r5 = ""
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0280
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0280
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r2 = r1.v
            java.util.Iterator r2 = r2.iterator()
            r11 = r5
            r9 = 0
            r10 = 0
        L_0x0024:
            boolean r12 = r2.hasNext()
            if (r12 == 0) goto L_0x0256
            java.lang.Object r12 = r2.next()
            com.travel.bus.pojo.busticket.CJRPassengerDetails r12 = (com.travel.bus.pojo.busticket.CJRPassengerDetails) r12
            int r10 = r10 + r7
            if (r12 == 0) goto L_0x003e
            java.lang.String r13 = r12.getPassengerName()
            if (r13 == 0) goto L_0x003e
            java.lang.String r13 = r12.getPassengerName()
            goto L_0x003f
        L_0x003e:
            r13 = r5
        L_0x003f:
            if (r12 == 0) goto L_0x004c
            java.lang.String r14 = r12.getmTitle()
            if (r14 == 0) goto L_0x004c
            java.lang.String r14 = r12.getmTitle()
            goto L_0x004d
        L_0x004c:
            r14 = 0
        L_0x004d:
            java.lang.String r15 = " "
            if (r14 == 0) goto L_0x0093
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r1.f22299a
            r6.append(r7)
            r6.append(r14)
            r6.append(r15)
            java.lang.String r6 = r6.toString()
            r1.f22299a = r6
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r6 = r1.v
            int r6 = r6.size()
            if (r10 != r6) goto L_0x007f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r11)
            r6.append(r14)
            java.lang.String r11 = r6.toString()
            goto L_0x0093
        L_0x007f:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r11)
            r6.append(r14)
            java.lang.String r7 = ","
            r6.append(r7)
            java.lang.String r11 = r6.toString()
        L_0x0093:
            if (r14 == 0) goto L_0x01c0
            if (r14 == 0) goto L_0x00a3
            java.lang.String r6 = r14.trim()
            int r6 = r6.length()
            if (r6 > 0) goto L_0x00a3
            goto L_0x01c0
        L_0x00a3:
            if (r13 == 0) goto L_0x00c2
            java.lang.String r6 = "[a-zA-z\\s]*"
            boolean r6 = r13.matches(r6)
            if (r6 != 0) goto L_0x00c2
            androidx.fragment.app.FragmentActivity r2 = r36.getActivity()
            int r3 = com.travel.bus.R.string.special_characters_title
            java.lang.String r3 = r0.getString(r3)
            int r5 = com.travel.bus.R.string.name_can_have_only_letters_and_spaces
            java.lang.String r0 = r0.getString(r5)
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r0)
            goto L_0x06ba
        L_0x00c2:
            if (r13 == 0) goto L_0x0107
            java.lang.String r6 = r13.trim()
            int r6 = r6.length()
            if (r6 < r3) goto L_0x00e0
            java.lang.String r6 = r13.trim()
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x00e0
            java.lang.String r6 = "[a-zA-Z ]+"
            boolean r6 = r13.matches(r6)
            if (r6 != 0) goto L_0x0107
        L_0x00e0:
            androidx.fragment.app.FragmentActivity r2 = r36.getActivity()
            int r3 = com.travel.bus.R.string.bus_invalid_passenger_name_title
            java.lang.String r3 = r0.getString(r3)
            int r5 = com.travel.bus.R.string.bus_invalid_passenger_name_message
            java.lang.String r5 = r0.getString(r5)
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r5)
            int r2 = com.travel.bus.R.string.bus_invalid_passenger_name_message
            java.lang.String r2 = r0.getString(r2)
            r1.c((java.lang.String) r2)
            int r2 = com.travel.bus.R.string.bus_invalid_passenger_name_message
            java.lang.String r0 = r0.getString(r2)
            r1.a((java.lang.String) r0)
            goto L_0x06ba
        L_0x0107:
            if (r12 == 0) goto L_0x010e
            int r6 = r12.getPassengerage()
            goto L_0x010f
        L_0x010e:
            r6 = 0
        L_0x010f:
            if (r6 > 0) goto L_0x0171
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r13)
            android.content.res.Resources r2 = r36.getResources()
            int r3 = com.travel.bus.R.string.bus_age_alert_msg
            java.lang.String r2 = r2.getString(r3)
            r0.append(r2)
            r0.append(r15)
            android.content.res.Resources r2 = r36.getResources()
            int r3 = com.travel.bus.R.string.bus_age_missing
            java.lang.String r2 = r2.getString(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            int r2 = com.travel.bus.R.string.bus_age_zero_error_message
            java.lang.String r2 = r1.getString(r2)
            androidx.fragment.app.FragmentActivity r3 = r36.getActivity()
            com.paytm.utility.b.b((android.content.Context) r3, (java.lang.String) r0, (java.lang.String) r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Please Enter "
            r0.<init>(r2)
            r0.append(r13)
            java.lang.String r3 = "'s age"
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r1.c((java.lang.String) r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            r0.append(r13)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r1.a((java.lang.String) r0)
            goto L_0x06ba
        L_0x0171:
            r7 = 12
            if (r6 < r7) goto L_0x0176
            r9 = 1
        L_0x0176:
            java.lang.String r6 = r1.L
            java.lang.String r7 = "Senior Citizen"
            if (r6 == r7) goto L_0x0180
            java.lang.String r7 = "Cat Card"
            if (r6 != r7) goto L_0x018b
        L_0x0180:
            java.lang.String r6 = r1.K
            if (r6 == 0) goto L_0x01af
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x018b
            goto L_0x01af
        L_0x018b:
            com.travel.bus.pojo.busticket.TripBusDetail r6 = r1.q
            com.travel.bus.pojo.busticket.TripDetailsMeta r6 = r6.getMeta()
            boolean r6 = r6.isExtraPaxDetailsRequired()
            if (r6 == 0) goto L_0x01ac
            boolean r6 = r1.R
            if (r6 == 0) goto L_0x01a6
            r6 = 2
            if (r10 >= r6) goto L_0x01ac
            boolean r6 = r1.a((com.travel.bus.pojo.busticket.CJRPassengerDetails) r12)
            if (r6 == 0) goto L_0x01ac
            goto L_0x06ba
        L_0x01a6:
            boolean r6 = r1.a((com.travel.bus.pojo.busticket.CJRPassengerDetails) r12)
            if (r6 != 0) goto L_0x06ba
        L_0x01ac:
            r7 = 1
            goto L_0x0024
        L_0x01af:
            androidx.fragment.app.FragmentActivity r2 = r36.getActivity()
            int r3 = com.travel.bus.R.string.special_characters_title
            java.lang.String r0 = r0.getString(r3)
            java.lang.String r3 = "Please enter the Concession Card Number"
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r0, (java.lang.String) r3)
            goto L_0x06ba
        L_0x01c0:
            boolean r2 = android.text.TextUtils.isEmpty(r13)
            java.lang.String r3 = " '"
            if (r2 == 0) goto L_0x01f4
            androidx.fragment.app.FragmentActivity r2 = r36.getActivity()
            int r5 = com.travel.bus.R.string.special_characters_title
            java.lang.String r5 = r0.getString(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r7 = com.travel.bus.R.string.select_gender_text
            java.lang.String r7 = r0.getString(r7)
            r6.append(r7)
            r6.append(r15)
            int r7 = com.travel.bus.R.string.passenger_small_text
            java.lang.String r7 = r0.getString(r7)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r5, (java.lang.String) r6)
            goto L_0x021e
        L_0x01f4:
            androidx.fragment.app.FragmentActivity r2 = r36.getActivity()
            int r5 = com.travel.bus.R.string.special_characters_title
            java.lang.String r5 = r0.getString(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r7 = com.travel.bus.R.string.select_gender_text
            java.lang.String r7 = r0.getString(r7)
            r6.append(r7)
            r6.append(r3)
            r6.append(r13)
            java.lang.String r7 = "'"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r5, (java.lang.String) r6)
        L_0x021e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r5 = com.travel.bus.R.string.select_gender_text
            java.lang.String r5 = r0.getString(r5)
            r2.append(r5)
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r1.c((java.lang.String) r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r5 = com.travel.bus.R.string.select_gender_text
            java.lang.String r0 = r0.getString(r5)
            r2.append(r0)
            r2.append(r3)
            r2.append(r13)
            java.lang.String r0 = r2.toString()
            r1.a((java.lang.String) r0)
            goto L_0x06ba
        L_0x0256:
            if (r9 != 0) goto L_0x027f
            androidx.fragment.app.FragmentActivity r2 = r36.getActivity()
            int r3 = com.travel.bus.R.string.special_characters_title
            java.lang.String r3 = r0.getString(r3)
            int r5 = com.travel.bus.R.string.bus_pax_less_than_12_years
            java.lang.String r5 = r0.getString(r5)
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r5)
            int r2 = com.travel.bus.R.string.bus_pax_less_than_12_years
            java.lang.String r2 = r0.getString(r2)
            r1.c((java.lang.String) r2)
            int r2 = com.travel.bus.R.string.bus_pax_less_than_12_years
            java.lang.String r0 = r0.getString(r2)
            r1.a((java.lang.String) r0)
            goto L_0x06ba
        L_0x027f:
            r5 = r11
        L_0x0280:
            android.widget.EditText r2 = r1.f22303e
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            android.widget.EditText r6 = r1.f22304f
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            int r7 = r2.length()
            if (r7 > 0) goto L_0x02c9
            androidx.fragment.app.FragmentActivity r2 = r36.getActivity()
            int r3 = com.travel.bus.R.string.bus_mobile_number_error_title
            java.lang.String r3 = r0.getString(r3)
            int r5 = com.travel.bus.R.string.bus_mobile_number_error_message
            java.lang.String r0 = r0.getString(r5)
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r0)
            android.content.res.Resources r0 = r36.getResources()
            int r2 = com.travel.bus.R.string.bus_mobile_number_error_message
            java.lang.String r0 = r0.getString(r2)
            r1.c((java.lang.String) r0)
            android.content.res.Resources r0 = r36.getResources()
            int r2 = com.travel.bus.R.string.bus_mobile_number_error_message
            java.lang.String r0 = r0.getString(r2)
            r1.a((java.lang.String) r0)
            goto L_0x06ba
        L_0x02c9:
            int r7 = r2.length()
            r9 = 10
            if (r7 == r9) goto L_0x0300
            androidx.fragment.app.FragmentActivity r2 = r36.getActivity()
            int r3 = com.travel.bus.R.string.bus_mobile_number_error_not_valid_title
            java.lang.String r3 = r0.getString(r3)
            int r5 = com.travel.bus.R.string.bus_mobile_number_error_not_valid_message
            java.lang.String r0 = r0.getString(r5)
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r0)
            android.content.res.Resources r0 = r36.getResources()
            int r2 = com.travel.bus.R.string.msg_invalid_passenger_mobile_number
            java.lang.String r0 = r0.getString(r2)
            r1.c((java.lang.String) r0)
            android.content.res.Resources r0 = r36.getResources()
            int r2 = com.travel.bus.R.string.msg_invalid_passenger_mobile_number
            java.lang.String r0 = r0.getString(r2)
            r1.a((java.lang.String) r0)
            goto L_0x06ba
        L_0x0300:
            boolean r2 = r1.a((java.lang.String) r2, (boolean) r8)
            if (r2 != 0) goto L_0x06ba
            int r2 = r6.length()
            if (r2 > 0) goto L_0x033b
            androidx.fragment.app.FragmentActivity r2 = r36.getActivity()
            int r3 = com.travel.bus.R.string.bus_email_missing_title
            java.lang.String r3 = r0.getString(r3)
            int r5 = com.travel.bus.R.string.bus_email_missing_message
            java.lang.String r0 = r0.getString(r5)
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r0)
            android.content.res.Resources r0 = r36.getResources()
            int r2 = com.travel.bus.R.string.bus_email_missing_message
            java.lang.String r0 = r0.getString(r2)
            r1.c((java.lang.String) r0)
            android.content.res.Resources r0 = r36.getResources()
            int r2 = com.travel.bus.R.string.bus_email_missing_message
            java.lang.String r0 = r0.getString(r2)
            r1.a((java.lang.String) r0)
            goto L_0x06ba
        L_0x033b:
            r0 = 1
            boolean r2 = r1.a((java.lang.String) r6, (boolean) r0)
            if (r2 != 0) goto L_0x06ba
            boolean r0 = r1.y
            if (r0 == 0) goto L_0x0404
            android.widget.CheckBox r0 = r1.V
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L_0x0404
            java.lang.String r0 = r1.Y
            java.lang.String r0 = r0.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03ae
            java.lang.String r0 = r1.Z
            java.lang.String r0 = r0.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03ae
            java.lang.String r0 = r1.af
            java.lang.String r0 = r0.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03ae
            java.lang.String r0 = r1.aa
            java.lang.String r0 = r0.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03ae
            java.lang.String r0 = r1.ab
            java.lang.String r0 = r0.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03ae
            java.lang.String r0 = r1.ac
            java.lang.String r0 = r0.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03ae
            java.lang.String r0 = r1.ad
            java.lang.String r0 = r0.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03ae
            java.lang.String r0 = r1.ae
            java.lang.String r0 = r0.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0404
        L_0x03ae:
            android.app.Dialog r0 = r1.ag
            if (r0 == 0) goto L_0x03bd
            boolean r0 = r0.isShowing()
            if (r0 == 0) goto L_0x03bd
            android.app.Dialog r0 = r1.ag
            r0.dismiss()
        L_0x03bd:
            android.app.Dialog r0 = new android.app.Dialog
            androidx.fragment.app.FragmentActivity r2 = r36.getActivity()
            r0.<init>(r2)
            r1.ag = r0
            android.app.Dialog r0 = r1.ag
            android.view.Window r0 = r0.getWindow()
            int r2 = com.travel.bus.R.layout.traveller_business_ok_dialog
            r0.setContentView(r2)
            android.app.Dialog r0 = r1.ag
            android.view.Window r0 = r0.getWindow()
            android.graphics.drawable.ColorDrawable r2 = new android.graphics.drawable.ColorDrawable
            r2.<init>(r8)
            r0.setBackgroundDrawable(r2)
            android.app.Dialog r0 = r1.ag
            int r2 = com.travel.bus.R.id.tvOKBusinessUserDialog
            android.view.View r0 = r0.findViewById(r2)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            com.travel.bus.busticket.fragment.m$9 r2 = new com.travel.bus.busticket.fragment.m$9
            r2.<init>()
            r0.setOnClickListener(r2)
            android.app.Dialog r0 = r1.ag
            r0.setCancelable(r8)
            android.app.Dialog r0 = r1.ag
            r0.setCanceledOnTouchOutside(r8)
            android.app.Dialog r0 = r1.ag
            r0.show()
            goto L_0x06ba
        L_0x0404:
            androidx.fragment.app.FragmentActivity r0 = r36.getActivity()
            java.lang.String r0 = com.travel.bus.busticket.i.p.a((android.content.Context) r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x06b3
            r36.getActivity()
            androidx.fragment.app.FragmentActivity r0 = r36.getActivity()
            android.content.res.Resources r0 = r0.getResources()
            int r2 = com.travel.bus.R.string.please_wait_progress_msg
            r0.getString(r2)
            r36.e()
            r36.b()
            android.widget.EditText r0 = r1.f22304f
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            android.widget.EditText r2 = r1.f22303e
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r7 = r1.v
            if (r7 == 0) goto L_0x044a
            int r7 = r7.size()
            r9 = 1
            if (r7 <= r9) goto L_0x044a
            int r7 = com.travel.bus.R.string.block_seats
            goto L_0x044c
        L_0x044a:
            int r7 = com.travel.bus.R.string.block_seat
        L_0x044c:
            r36.getActivity()
            androidx.fragment.app.FragmentActivity r9 = r36.getActivity()
            android.content.res.Resources r9 = r9.getResources()
            r9.getString(r7)
            r36.e()
            androidx.fragment.app.FragmentActivity r16 = r36.getActivity()
            com.travel.bus.pojo.busticket.CJRBusSearchInput r7 = r1.r
            r17 = r7
            com.travel.bus.pojo.busticket.CJRBusSearchItem r7 = r1.s
            r18 = r7
            java.lang.String r7 = r1.B
            r19 = r7
            com.travel.bus.pojo.busticket.CJRLocation r7 = r1.t
            r20 = r7
            com.travel.bus.pojo.busticket.CJRLocation r7 = r1.u
            r21 = r7
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r7 = r1.v
            r22 = r7
            double r9 = r1.C
            java.lang.String r23 = java.lang.String.valueOf(r9)
            boolean r7 = r1.w
            r24 = r7
            com.travel.bus.pojo.busticket.CJRBusInsuranceItem r7 = r1.z
            r25 = r7
            boolean r7 = r1.x
            r28 = r7
            boolean r7 = r1.y
            r29 = r7
            java.lang.String r7 = r1.Y
            r30 = r7
            java.lang.String r7 = r1.ad
            r31 = r7
            java.lang.String r7 = r1.Z
            r32 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = r1.aa
            r7.append(r9)
            java.lang.String r9 = ", "
            r7.append(r9)
            java.lang.String r10 = r1.ab
            r7.append(r10)
            r7.append(r9)
            java.lang.String r10 = r1.ae
            r7.append(r10)
            r7.append(r9)
            java.lang.String r9 = r1.ad
            r7.append(r9)
            java.lang.String r33 = r7.toString()
            java.lang.String r7 = r1.af
            r34 = r7
            android.widget.CheckBox r7 = r1.V
            r35 = r7
            r26 = r0
            r27 = r2
            java.lang.String r12 = com.travel.bus.busticket.g.j.a(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            androidx.fragment.app.FragmentActivity r7 = r36.getActivity()
            boolean r7 = com.travel.bus.busticket.i.o.b((android.content.Context) r7)
            java.lang.String r9 = "sso_token"
            java.lang.String r10 = "Content-Type"
            if (r7 != 0) goto L_0x055b
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r7 = r1.v
            java.lang.String r0 = com.travel.bus.busticket.g.j.a((java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails>) r7, (java.lang.String) r0, (java.lang.String) r2)
            com.travel.bus.busticket.g.j r2 = r1.f22301c
            androidx.fragment.app.FragmentActivity r7 = r36.getActivity()
            com.travel.bus.a.a()
            com.travel.g.a r11 = com.travel.bus.a.b()
            java.lang.String r13 = "tpInsertTravelers"
            java.lang.String r11 = r11.f(r13)
            boolean r13 = android.text.TextUtils.isEmpty(r11)
            if (r13 != 0) goto L_0x055b
            boolean r13 = android.webkit.URLUtil.isValidUrl(r11)
            if (r13 == 0) goto L_0x055b
            java.util.HashMap r13 = new java.util.HashMap
            r13.<init>()
            java.lang.String r14 = "application/x-www-form-urlencoded"
            r13.put(r10, r14)
            java.lang.String r14 = com.travel.bus.busticket.i.p.a((android.content.Context) r7)
            r13.put(r9, r14)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r14 = "data="
            java.lang.String r0 = r14.concat(r0)
            com.paytm.network.b r14 = new com.paytm.network.b
            r14.<init>()
            r14.f42877a = r7
            com.paytm.network.a$c r7 = com.paytm.network.a.c.BUS
            r14.f42878b = r7
            com.paytm.network.a$a r7 = com.paytm.network.a.C0715a.POST
            r14.f42879c = r7
            r14.f42880d = r11
            r7 = 0
            r14.f42881e = r7
            r14.f42882f = r13
            r14.f42883g = r7
            r14.f42884h = r0
            com.travel.bus.pojo.busticket.CJRBusUserData r0 = new com.travel.bus.pojo.busticket.CJRBusUserData
            r0.<init>()
            r14.f42885i = r0
            com.travel.bus.busticket.g.j$3 r0 = new com.travel.bus.busticket.g.j$3
            r0.<init>()
            r14.j = r0
            com.paytm.network.a$b r0 = com.paytm.network.a.b.SILENT
            r14.n = r0
            java.lang.String r0 = "bus-traveller-page"
            r14.o = r0
            com.paytm.network.a r0 = r14.l()
            r0.a()
            goto L_0x055c
        L_0x055b:
            r7 = 0
        L_0x055c:
            com.travel.bus.busticket.g.j r0 = r1.f22301c
            androidx.fragment.app.FragmentActivity r2 = r36.getActivity()
            com.travel.bus.a.a()
            com.travel.g.a r11 = com.travel.bus.a.b()
            java.lang.String r11 = r11.v()
            if (r11 == 0) goto L_0x057a
            com.travel.bus.a.a()
            com.travel.g.a r7 = com.travel.bus.a.b()
            java.lang.String r7 = r7.v()
        L_0x057a:
            if (r7 == 0) goto L_0x0601
            boolean r11 = android.text.TextUtils.isEmpty(r7)
            if (r11 != 0) goto L_0x0601
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.lang.String r3 = "application/json"
            r11.put(r10, r3)
            java.lang.String r3 = com.paytm.utility.a.q(r2)
            r11.put(r9, r3)
            java.lang.String r3 = com.paytm.utility.b.k()
            android.net.Uri r9 = android.net.Uri.parse(r7)
            java.lang.String r9 = r9.getQuery()
            java.lang.String r10 = "?client_id="
            if (r9 == 0) goto L_0x05b6
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            r9.append(r10)
            r9.append(r3)
            java.lang.String r3 = r9.toString()
            goto L_0x05c8
        L_0x05b6:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            r9.append(r10)
            r9.append(r3)
            java.lang.String r3 = r9.toString()
        L_0x05c8:
            android.content.Context r7 = r0.f22395b
            boolean r7 = com.travel.bus.busticket.i.o.b((android.content.Context) r7)
            if (r7 == 0) goto L_0x05e8
            android.net.Uri r3 = android.net.Uri.parse(r3)
            android.net.Uri$Builder r3 = r3.buildUpon()
            java.lang.String r7 = "is_reseller"
            java.lang.String r9 = "1"
            android.net.Uri$Builder r3 = r3.appendQueryParameter(r7, r9)
            android.net.Uri r3 = r3.build()
            java.lang.String r3 = r3.toString()
        L_0x05e8:
            r10 = r3
            boolean r2 = com.paytm.utility.b.c((android.content.Context) r2)
            if (r2 == 0) goto L_0x0615
            android.content.Context r9 = r0.f22395b
            com.paytm.network.a$a r13 = com.paytm.network.a.C0715a.POST
            com.travel.bus.pojo.busticket.CJRBlockOneResponse r14 = new com.travel.bus.pojo.busticket.CJRBlockOneResponse
            r14.<init>()
            com.travel.bus.busticket.g.j$1 r15 = new com.travel.bus.busticket.g.j$1
            r15.<init>()
            com.travel.bus.busticket.g.j.a(r9, r10, r11, r12, r13, r14, r15)
            goto L_0x0615
        L_0x0601:
            com.travel.bus.busticket.fragment.m r0 = r0.f22394a
            com.paytm.network.model.NetworkCustomError r2 = new com.paytm.network.model.NetworkCustomError
            r2.<init>()
            java.lang.String r7 = "Unable to proceed"
            r2.setmAlertTitle(r7)
            java.lang.String r7 = "Please try again later."
            r2.setAlertMessage(r7)
            r0.a((int) r3, (com.paytm.network.model.NetworkCustomError) r2)
        L_0x0615:
            androidx.fragment.app.FragmentActivity r0 = r36.getActivity()
            java.lang.String r0 = com.paytm.utility.b.n((android.content.Context) r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = ":"
            r2.append(r0)
            r2.append(r6)
            java.lang.String r0 = r2.toString()
            com.travel.bus.a.a()
            com.travel.g.a r2 = com.travel.bus.a.b()
            android.content.Context r2 = r2.D()
            com.paytm.b.a.a r2 = com.travel.bus.b.a.a(r2)
            java.lang.String r3 = "email_bus"
            r2.a((java.lang.String) r3, (java.lang.String) r0, (boolean) r8)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r0 = "event_label"
            r2.put(r0, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.travel.bus.pojo.busticket.CJRBusSearchInput r3 = r1.r
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r3 = r3.getSource()
            java.lang.String r3 = r3.getDisplayCityName()
            r0.append(r3)
            java.lang.String r3 = "/"
            r0.append(r3)
            com.travel.bus.pojo.busticket.CJRBusSearchInput r3 = r1.r
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r3 = r3.getDestination()
            java.lang.String r3 = r3.getDisplayCityName()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.put(r4, r0)
            java.lang.String r0 = "event_label3"
            com.travel.bus.pojo.busticket.TripBusDetail r3 = r1.q     // Catch:{ Exception -> 0x068e }
            com.travel.bus.pojo.busticket.TripDetailsMeta r3 = r3.getMeta()     // Catch:{ Exception -> 0x068e }
            com.travel.bus.pojo.busticket.TripDetailProvider r3 = r3.getProvider()     // Catch:{ Exception -> 0x068e }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x068e }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x068e }
            goto L_0x0696
        L_0x068e:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x0696:
            androidx.fragment.app.FragmentActivity r0 = r36.getActivity()
            java.lang.String r0 = com.paytm.utility.b.n((android.content.Context) r0)
            java.lang.String r3 = "userid"
            r2.put(r3, r0)
            com.travel.bus.a.a()
            java.lang.String r0 = "customEvent"
            java.lang.String r3 = "/bus-tickets-traveller"
            java.lang.String r5 = "bus_passenger"
            java.lang.String r6 = "proceed_clicked"
            com.travel.bus.a.a(r0, r3, r5, r6, r2)
            goto L_0x06ba
        L_0x06b3:
            androidx.fragment.app.FragmentActivity r0 = r36.getActivity()
            com.travel.bus.busticket.i.c.a(r0)
        L_0x06ba:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x06e8 }
            r0.<init>()     // Catch:{ Exception -> 0x06e8 }
            java.lang.String r2 = "bus_passenger_genders"
            java.lang.String r3 = r1.f22299a     // Catch:{ Exception -> 0x06e8 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x06e8 }
            com.travel.bus.pojo.busticket.TripBusDetail r2 = r1.q     // Catch:{ Exception -> 0x06e8 }
            com.travel.bus.pojo.busticket.TripDetailsMeta r2 = r2.getMeta()     // Catch:{ Exception -> 0x06e8 }
            com.travel.bus.pojo.busticket.TripDetailProvider r2 = r2.getProvider()     // Catch:{ Exception -> 0x06e8 }
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x06e8 }
            r0.put(r4, r2)     // Catch:{ Exception -> 0x06e8 }
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x06e8 }
            com.travel.g.a r2 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x06e8 }
            java.lang.String r3 = "bus_passenger_proceed_clicked"
            androidx.fragment.app.FragmentActivity r4 = r36.getActivity()     // Catch:{ Exception -> 0x06e8 }
            r2.a((java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.Object>) r0, (android.content.Context) r4)     // Catch:{ Exception -> 0x06e8 }
            return
        L_0x06e8:
            r0 = move-exception
            boolean r2 = com.paytm.utility.b.v
            if (r2 == 0) goto L_0x06f4
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x06f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.fragment.m.f(android.view.View):void");
    }

    static /* synthetic */ void i(m mVar) {
        if (mVar.getActivity() != null) {
            mVar.f("premium_tnc_checked");
            com.travel.bus.a.a();
            String r2 = com.travel.bus.a.b().r();
            Intent intent = new Intent(mVar.getActivity(), AJRBusWebViewActivity.class);
            intent.putExtra("url", r2);
            intent.putExtra("title", mVar.getString(R.string.f21494paytm));
            mVar.startActivity(intent);
        }
    }

    static /* synthetic */ void b(m mVar, String str) {
        View inflate = mVar.getLayoutInflater().inflate(R.layout.pre_b_concession_alert_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(mVar.getContext());
        builder.setView(inflate);
        ((RoboTextView) inflate.findViewById(R.id.disp_title)).setText(R.string.cant_apply_concession);
        ((RoboTextView) inflate.findViewById(R.id.disp_message)).setText(str);
        mVar.a(str);
        AlertDialog create = builder.create();
        create.show();
        ((RoboTextView) inflate.findViewById(R.id.change_seats)).setOnClickListener(new View.OnClickListener(create) {
            private final /* synthetic */ AlertDialog f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                m.this.e(this.f$1, view);
            }
        });
        ((RoboTextView) inflate.findViewById(R.id.ok_got_it)).setOnClickListener(new View.OnClickListener(create) {
            private final /* synthetic */ AlertDialog f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(View view) {
                this.f$0.dismiss();
            }
        });
        ((ImageView) inflate.findViewById(R.id.close_icon)).setOnClickListener(new View.OnClickListener(create) {
            private final /* synthetic */ AlertDialog f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(View view) {
                this.f$0.dismiss();
            }
        });
    }

    static /* synthetic */ void d(m mVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_passeenger");
        hashMap.put("event_action", "quota_changed");
        hashMap.put("event_label", str);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-traveller");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", com.paytm.utility.b.n((Context) mVar.getActivity()));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) mVar.getActivity());
    }

    static /* synthetic */ void j(m mVar, String str) {
        AlertDialog alertDialog = mVar.k;
        if (alertDialog != null && alertDialog.isShowing()) {
            mVar.k.dismiss();
        }
        if (!TextUtils.isEmpty(str)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mVar.getActivity());
            WebView webView = new WebView(mVar.getActivity());
            webView.setLayoutParams(new LinearLayout.LayoutParams(-21, 300));
            webView.setVerticalScrollBarEnabled(true);
            webView.loadUrl(str);
            webView.setWebViewClient(new WebViewClient() {
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    webView.loadUrl(str);
                    return true;
                }
            });
            builder.setView(webView);
            mVar.k = builder.create();
            RelativeLayout relativeLayout = (RelativeLayout) mVar.getActivity().getLayoutInflater().inflate(R.layout.bus_paytm_terms_condition_tc, (ViewGroup) null);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.tnc_title);
            textView.setBackgroundColor(androidx.core.content.b.c(mVar.getActivity(), 17170445));
            textView.setTextColor(-16777216);
            textView.setTextSize(17.0f);
            textView.setGravity(17);
            mVar.getActivity();
            com.paytm.utility.b.d(textView);
            textView.setText(mVar.getResources().getString(R.string.view_terms_and_condtions_str));
            relativeLayout.findViewById(R.id.tnc_close).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    m.this.k.dismiss();
                }
            });
            mVar.k.setCustomTitle(relativeLayout);
            mVar.k.show();
        }
    }
}

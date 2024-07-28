package net.one97.paytm.fastag.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.io.File;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;
import net.one97.paytm.fastag.BaseActivity;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.a.a;
import net.one97.paytm.fastag.b.c;
import net.one97.paytm.fastag.dependencies.h;
import net.one97.paytm.fastag.f.d;
import net.one97.paytm.fastag.f.e;
import net.one97.paytm.fastag.f.i;
import net.one97.paytm.fastag.f.j;
import net.one97.paytm.fastag.model.CJRAadharPanSave;
import net.one97.paytm.fastag.model.CJRAddress;
import net.one97.paytm.fastag.model.CJRAddresses;
import net.one97.paytm.fastag.model.CJRBulletPoints;
import net.one97.paytm.fastag.model.CJRCart;
import net.one97.paytm.fastag.model.CJRCartProduct;
import net.one97.paytm.fastag.model.CJRDetailProduct;
import net.one97.paytm.fastag.model.CJRLongRichDesc;
import net.one97.paytm.fastag.model.CJRRechargeCart;
import net.one97.paytm.fastag.ui.activity.FasTagKYCActivity;
import net.one97.paytm.fastag.ui.activity.a;
import net.one97.paytm.fastag.ui.b.b;
import net.one97.paytm.fastag.widget.ImageUploader;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class FasTagKYCActivity extends BaseActivity implements View.OnClickListener, a.b, a.C0189a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.fastag.e.a f13804a;

    /* renamed from: b  reason: collision with root package name */
    private c f13805b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f13806c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<CJRAddress> f13807d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private TextView f13808e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f13809f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13810g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ImageUploader f13811h;

    /* renamed from: i  reason: collision with root package name */
    private ImageUploader f13812i;
    private AlertDialog j;
    private a k;
    /* access modifiers changed from: private */
    public String l;
    private LottieAnimationView m;
    private LottieAnimationView n;
    private LinearLayout o;
    private LinearLayout p;
    /* access modifiers changed from: private */
    public EditText q;
    private d r;
    private String s;
    private String t;
    private TextView u;
    private TextView v;
    private TextView w;
    private CJRDetailProduct x;
    private CJRRechargeCart y;
    private ImageUploader.a z = new ImageUploader.a() {
        public final void a(ImageUploader imageUploader) {
            b bVar = new b();
            bVar.f13846b = FasTagKYCActivity.this.getString(R.string.upload_photos_of_rc);
            bVar.f13847c = FasTagKYCActivity.this.getString(R.string.msg_to_avoid_rejection);
            bVar.show(FasTagKYCActivity.this.getSupportFragmentManager(), b.class.getName());
            bVar.f13845a = new h(imageUploader) {
                private final /* synthetic */ ImageUploader f$1;

                {
                    this.f$1 = r2;
                }

                public final void onFragmentAction(int i2, Object obj) {
                    FasTagKYCActivity.AnonymousClass1.this.a(this.f$1, i2, obj);
                }
            };
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(ImageUploader imageUploader, int i2, Object obj) {
            if (i2 != 101) {
                return;
            }
            if ("action-camera".equals(obj)) {
                int i3 = imageUploader == FasTagKYCActivity.this.f13811h ? 0 : 2;
                if (s.a((Activity) FasTagKYCActivity.this)) {
                    FasTagKYCActivity.this.a("take_photo_clicked", "");
                    FasTagKYCActivity fasTagKYCActivity = FasTagKYCActivity.this;
                    String unused = fasTagKYCActivity.l = ImageUploader.a(fasTagKYCActivity, i3, imageUploader == fasTagKYCActivity.f13811h ? "rc_front_pic.jpg" : "rc_back_pic.jpg");
                    return;
                }
                androidx.core.app.a.a(FasTagKYCActivity.this, new String[]{"android.permission.CAMERA"}, i3);
            } else if ("action-gallery".equals(obj)) {
                int i4 = imageUploader == FasTagKYCActivity.this.f13811h ? 1 : 3;
                if (androidx.core.app.a.a((Context) FasTagKYCActivity.this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
                    ImageUploader.a(FasTagKYCActivity.this, i4);
                    FasTagKYCActivity.this.a("choose_from_gallery_selected", "");
                    return;
                }
                androidx.core.app.a.a(FasTagKYCActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, i4);
            }
        }

        public final void a(Uri uri) {
            Intent intent = new Intent(FasTagKYCActivity.this, ImageViewerActivity.class);
            intent.putExtra("pic_uri_path", uri.toString());
            FasTagKYCActivity.this.startActivity(intent);
        }

        public final void b(ImageUploader imageUploader) {
            imageUploader.setState(ImageUploader.b.IMAGE_SELECTED_AND_UPLOADING);
            FasTagKYCActivity.this.f13804a.a(imageUploader, imageUploader.getImageURI());
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fastag_kyc);
        this.r = new d(this);
        this.r.setCancelable(false);
        this.r.setCanceledOnTouchOutside(false);
        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FasTagKYCActivity.this.a(view);
            }
        });
        this.q = (EditText) findViewById(R.id.vehicle_registration_number_et);
        this.o = (LinearLayout) findViewById(R.id.loader_ll);
        this.m = (LottieAnimationView) findViewById(R.id.address_loader);
        this.p = (LinearLayout) findViewById(R.id.catalog_loader_ll);
        this.n = (LottieAnimationView) findViewById(R.id.catalog_loader);
        this.f13809f = (TextView) findViewById(R.id.tv_add_new);
        this.f13808e = (TextView) findViewById(R.id.view_price_breakup_tv);
        this.f13810g = (TextView) findViewById(R.id.tv_preceed_to_pay);
        this.f13810g.setOnClickListener(this);
        this.f13811h = (ImageUploader) findViewById(R.id.rc_pic_front);
        this.f13812i = (ImageUploader) findViewById(R.id.rc_pic_back);
        this.u = (TextView) findViewById(R.id.amount_tv);
        this.v = (TextView) findViewById(R.id.discounted_amount_tv);
        TextView textView = this.u;
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        this.w = (TextView) findViewById(R.id.tvFastagName);
        this.f13811h.setText(R.string.front_photo_of_rc, R.string.upload);
        this.f13812i.setText(R.string.back_photo_of_rc, R.string.upload);
        this.f13806c = (ViewPager) findViewById(R.id.address_view_pager);
        this.f13808e.setOnClickListener(this);
        this.f13809f.setOnClickListener(this);
        this.f13811h.setListener(this.z);
        this.f13812i.setListener(this.z);
        this.q.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        this.q.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                FasTagKYCActivity.this.a("registration_number_field_clicked", "");
                String replaceAll = editable.toString().replaceAll(" ", "");
                if (!editable.toString().equals(replaceAll)) {
                    FasTagKYCActivity.this.q.setText(replaceAll.toUpperCase());
                    FasTagKYCActivity.this.q.setSelection(replaceAll.length());
                }
            }
        });
        this.f13805b = new c(this);
        this.f13804a = new net.one97.paytm.fastag.e.a(this, this.f13805b);
        this.s = net.one97.paytm.fastag.c.a.a().f13559b.getStringFromGTM("fastagProductId");
        j();
        if (!com.paytm.utility.b.r((Context) this)) {
            startActivityForResult(new Intent(this, net.one97.paytm.fastag.c.a.a().f13559b.getAuthActivityClass()), 2987);
        }
        a("homepage_loaded", "");
    }

    private void f() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception unused) {
        }
    }

    private void h() {
        new net.one97.paytm.fastag.ui.b.a().show(getSupportFragmentManager(), net.one97.paytm.fastag.ui.b.a.class.getName());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void onResume() {
        super.onResume();
        f();
        if (com.paytm.utility.b.r((Context) this)) {
            i();
        }
    }

    private void i() {
        if (g()) {
            h();
            return;
        }
        this.f13804a.a(this.s);
        ArrayList<CJRAddress> arrayList = this.f13807d;
        if (arrayList == null || arrayList.size() <= 0) {
            this.f13804a.a();
        }
    }

    public void onPause() {
        super.onPause();
        f();
    }

    public void onStop() {
        super.onStop();
    }

    private void j() {
        ArrayList<CJRAddress> arrayList = this.f13807d;
        if (arrayList != null && arrayList.size() > 0) {
            this.k = new a(this, this.f13807d, this);
            this.f13806c.setAdapter(this.k);
        }
    }

    public final void a(CJRAddress cJRAddress) {
        a("edit_address_clicked", "");
        Intent intent = new Intent(this, FasTagEditAddressActivity.class);
        intent.putExtra("address to update", cJRAddress);
        intent.putExtra("address list to update", this.f13807d);
        intent.putExtra("edit address", true);
        intent.putExtra("no address", false);
        startActivityForResult(intent, 4);
    }

    public final void a(int i2) {
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(i2);
        }
        a("delivery_address_selected", "");
    }

    public void onClick(View view) {
        CJRAddress l2;
        if (view == this.f13808e) {
            a("view_price_breakup_clicked", "");
            CJRDetailProduct cJRDetailProduct = this.x;
            if (cJRDetailProduct != null && !TextUtils.isEmpty(cJRDetailProduct.getmDiscountedPrice())) {
                this.t = this.x.getmDiscountedPrice();
            }
            net.one97.paytm.fastag.ui.b.c cVar = new net.one97.paytm.fastag.ui.b.c(this.x.getmActualPrice(), this.x.getmDiscountedPrice());
            CJRDetailProduct cJRDetailProduct2 = this.x;
            if (!(cJRDetailProduct2 == null || cJRDetailProduct2.getAttributes() == null)) {
                cVar.f13848a = this.x.getAttributes();
            }
            cVar.show(getSupportFragmentManager(), net.one97.paytm.fastag.ui.b.c.class.getName());
            return;
        }
        boolean z2 = false;
        if (view == this.f13809f) {
            a("add_new_delivery_address_clicked", "");
            Intent intent = new Intent(this, FasTagEditAddressActivity.class);
            intent.putExtra("address list to update", this.f13807d);
            intent.putExtra("edit address", false);
            intent.putExtra("no address", false);
            startActivityForResult(intent, 4);
        } else if (view == this.f13810g) {
            a("proceed_to_pay_clicked", "");
            if (TextUtils.isEmpty(this.q.getText())) {
                net.one97.paytm.fastag.f.h.a((Context) this, getResources().getString(R.string.vihicle_number_missing), getResources().getString(R.string.vihicle_number));
            } else {
                if (!Pattern.compile("^([A-Za-z]{2}[0-9A-Za-z]{1,4}[0-9]{1,4})$").matcher(this.q.getText().toString()).matches()) {
                    net.one97.paytm.fastag.f.h.a((Context) this, getResources().getString(R.string.vihicle_number_missing), getResources().getString(R.string.vihicle_number_valid));
                } else if (this.f13811h.f13954a != ImageUploader.b.IMAGE_UPLOADED) {
                    net.one97.paytm.fastag.f.h.a((Context) this, getResources().getString(R.string.upload_photos_of_rc), getResources().getString(R.string.upload_front_photo_of_rc));
                } else if (this.f13812i.f13954a != ImageUploader.b.IMAGE_UPLOADED) {
                    net.one97.paytm.fastag.f.h.a((Context) this, getResources().getString(R.string.upload_photos_of_rc), getResources().getString(R.string.upload_back_photo_of_rc));
                } else {
                    ArrayList<CJRAddress> arrayList = this.f13807d;
                    if (arrayList == null || arrayList.size() <= 0 || !k()) {
                        net.one97.paytm.fastag.f.h.a((Context) this, getResources().getString(R.string.address_error), getResources().getString(R.string.address_select));
                    } else {
                        z2 = true;
                    }
                }
            }
            if (z2 && (l2 = l()) != null) {
                d dVar = this.r;
                if (dVar != null && !dVar.isShowing()) {
                    this.r.show();
                }
                String obj = this.q.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    a("vehicle_registration_number_entered", "");
                }
                String imageUploadedKey = this.f13811h.getImageUploadedKey();
                if (!TextUtils.isEmpty(imageUploadedKey)) {
                    a("front_photo_of_RC_uploaded", "");
                }
                String imageUploadedKey2 = this.f13812i.getImageUploadedKey();
                if (!TextUtils.isEmpty(imageUploadedKey2)) {
                    a("back_photo_of_RC_uploaded", "");
                }
                net.one97.paytm.fastag.e.a aVar = this.f13804a;
                String str = this.t;
                aVar.f13758b.a(new net.one97.paytm.fastag.b.b() {
                    public final void a(
/*
Method generation error in method: net.one97.paytm.fastag.e.a.4.a(java.lang.Throwable):void, dex: classes10.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.fastag.e.a.4.a(java.lang.Throwable):void, class status: UNLOADED
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
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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

                    public final void a(
/*
Method generation error in method: net.one97.paytm.fastag.e.a.4.a(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes10.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.fastag.e.a.4.a(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
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
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                }, this.s, obj, imageUploadedKey, imageUploadedKey2, l2, str);
            }
        }
    }

    public final void a(CJRRechargeCart cJRRechargeCart) {
        if (cJRRechargeCart != null) {
            this.y = cJRRechargeCart;
            String obj = this.q.getText().toString();
            String imageUploadedKey = this.f13811h.getImageUploadedKey();
            String imageUploadedKey2 = this.f13812i.getImageUploadedKey();
            net.one97.paytm.fastag.e.a aVar = this.f13804a;
            aVar.f13758b.a(new net.one97.paytm.fastag.b.b() {
                public final void a(
/*
Method generation error in method: net.one97.paytm.fastag.e.a.5.a(java.lang.Throwable):void, dex: classes10.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.fastag.e.a.5.a(java.lang.Throwable):void, class status: UNLOADED
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

                public final void a(
/*
Method generation error in method: net.one97.paytm.fastag.e.a.5.a(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes10.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.fastag.e.a.5.a(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
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
            }, obj, imageUploadedKey, imageUploadedKey2, "");
        }
    }

    public final void e() {
        d dVar = this.r;
        if (dVar != null && dVar.isShowing()) {
            this.r.dismiss();
        }
    }

    public final void a(CJRAadharPanSave cJRAadharPanSave) {
        if (cJRAadharPanSave != null) {
            e();
            Intent intent = new Intent(this, net.one97.paytm.fastag.c.a.a().f13559b.getAJRCoupons());
            try {
                CJRCartProduct cJRCartProduct = this.y.getCart().getCartItems().get(0);
                String valueOf = String.valueOf(cJRCartProduct.getProductId());
                String stringFromGTM = net.one97.paytm.fastag.c.a.a().f13559b.getStringFromGTM("fastagProductId");
                if (!TextUtils.isEmpty(stringFromGTM) && !TextUtils.isEmpty(valueOf)) {
                    stringFromGTM.equalsIgnoreCase(valueOf);
                }
                intent.putExtra("vertical_id", String.valueOf(cJRCartProduct.getVerticalId()));
                cJRCartProduct.setBrand("");
                CJRCart cart = this.y.getCart();
                ArrayList<CJRCartProduct> cartItems = this.y.getCart().getCartItems();
                cartItems.add(0, cJRCartProduct);
                cart.setCartItems(cartItems);
                this.y.setmCart(cart);
                intent.putExtra("recharge cart", net.one97.paytm.fastag.c.a.a().f13559b.getCartResponse(this.y));
                intent.putExtra("gtm_category", this.y.getCart().getCartItems().get(0).getCategoryPathForGTM());
            } catch (NullPointerException e2) {
                e();
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
            startActivity(intent);
        }
    }

    private boolean k() {
        ArrayList<CJRAddress> arrayList = this.f13807d;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.f13807d.size(); i2++) {
            if (this.f13807d.get(i2).isChecked()) {
                return true;
            }
        }
        return false;
    }

    private CJRAddress l() {
        ArrayList<CJRAddress> arrayList = this.f13807d;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < this.f13807d.size(); i2++) {
                if (this.f13807d.get(i2).isChecked()) {
                    return this.f13807d.get(i2);
                }
            }
        }
        return null;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (strArr.length <= 0 || !"android.permission.CAMERA".equalsIgnoreCase(strArr[0])) {
            if (strArr.length > 0 && "android.permission.READ_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[0])) {
                if (androidx.core.app.a.a((Context) this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
                    ImageUploader.a(this, i2);
                    a("choose_from_gallery_selected", "");
                } else if (androidx.core.app.a.a((Activity) this, "android.permission.READ_EXTERNAL_STORAGE")) {
                    net.one97.paytm.fastag.f.h.a((Context) this, getString(R.string.error), getString(R.string.error_storage_permission_denied));
                } else {
                    net.one97.paytm.fastag.f.h.a((Context) this, getString(R.string.storage_permission_title), getString(R.string.write_to_sdcard_permission_alert_msg));
                }
            }
        } else if (s.a((Activity) this)) {
            this.l = ImageUploader.a(this, i2, i2 == 0 ? "rc_front_pic.jpg" : "rc_back_pic.jpg");
            a("take_photo_clicked", "");
        } else if (androidx.core.app.a.a((Activity) this, "android.permission.CAMERA")) {
            net.one97.paytm.fastag.f.h.a((Context) this, getString(R.string.error), getString(R.string.error_camera_permission_denied));
        } else {
            net.one97.paytm.fastag.f.h.a((Context) this, getString(R.string.camera_permission_title), getString(R.string.enable_camera_permission_alert_msg));
        }
    }

    public final void a(CJRAddresses cJRAddresses) {
        if (cJRAddresses != null) {
            this.f13807d = cJRAddresses.getAddressess();
            ArrayList<CJRAddress> arrayList = this.f13807d;
            if (arrayList == null || arrayList.size() <= 0) {
                this.f13806c.setVisibility(8);
                return;
            }
            if (this.f13807d.size() == 1) {
                this.f13807d.get(0).setPriority(1);
            }
            this.f13806c.setVisibility(0);
            j();
        }
    }

    public final void a(Throwable th) {
        String str;
        String str2;
        if (TextUtils.isEmpty(th.getMessage())) {
            return;
        }
        if (th.getMessage().equalsIgnoreCase("404") || th.getMessage().equalsIgnoreCase("400") || th.getMessage().equalsIgnoreCase("503")) {
            String message = th.getMessage();
            if (message.equalsIgnoreCase("404")) {
                str = getString(R.string.not_available);
                str2 = getString(R.string.come_back_in_a_while);
            } else if (message.equalsIgnoreCase("400")) {
                str2 = getResources().getString(R.string.message_400);
                str = getResources().getString(R.string.title_400);
            } else {
                str = getString(R.string.we_are_fixing_something);
                str2 = getString(R.string.be_right_back);
            }
            net.one97.paytm.fastag.f.h.a((Context) this, str, str2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        this.f13804a.a();
    }

    public final void a(net.one97.paytm.fastag.c cVar) {
        if (cVar != null) {
            $$Lambda$FasTagKYCActivity$d8Q2Ns5BSk18jU1g28hMufLNts r4 = new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    FasTagKYCActivity.this.a(dialogInterface, i2);
                }
            };
            AlertDialog alertDialog = this.j;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.j.dismiss();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.no_connection));
            builder.setMessage(getResources().getString(R.string.no_internet));
            builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), r4);
            this.j = builder.create();
            this.j.show();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Uri uri;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2987) {
            if (com.paytm.utility.b.r((Context) this)) {
                i();
            } else {
                finish();
            }
        } else if (i3 == -1) {
            ImageUploader imageUploader = null;
            if (i2 == 1 || i2 == 3) {
                imageUploader = i2 == 1 ? this.f13811h : this.f13812i;
                uri = intent.getData();
                if (!a(uri)) {
                    net.one97.paytm.fastag.f.h.a((Context) this, getString(R.string.error), getString(R.string.max_file_size_limit_reached));
                    return;
                }
                imageUploader.a(uri);
            } else if (i2 != 0 && i2 != 2) {
                if (i2 == 4) {
                    this.f13807d = (ArrayList) getIntent().getSerializableExtra("address list to update");
                    ArrayList<CJRAddress> arrayList = this.f13807d;
                    if (arrayList != null && arrayList.size() > 0) {
                        this.f13806c.setVisibility(0);
                        j();
                    }
                } else if (i2 == 5 && i3 == -1) {
                    String stringExtra = intent.getStringExtra("KEY_ORDER_ID_TO_TRACK");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        Intent intent2 = new Intent(this, FasTagPostPaymentActivity.class);
                        intent2.putExtra("KEY_ORDER_ID_TO_TRACK", stringExtra);
                        intent2.putExtra("order_from_fastag", true);
                        startActivity(intent2);
                        finish();
                    }
                }
                uri = null;
            } else if (this.l != null) {
                imageUploader = i2 == 0 ? this.f13811h : this.f13812i;
                net.one97.paytm.fastag.f.b.a(this.l);
                uri = Uri.fromFile(new File(this.l));
                imageUploader.a(uri);
            } else {
                return;
            }
            if (uri != null) {
                imageUploader.setState(ImageUploader.b.IMAGE_SELECTED_AND_UPLOADING);
                this.f13804a.a(imageUploader, uri);
            }
        }
    }

    private boolean a(Uri uri) {
        if (uri == null) {
            return true;
        }
        try {
            String a2 = i.a(this, uri);
            if (a2 != null) {
                File file = new File(a2);
                if (!file.exists() || file.length() <= 2097152) {
                    return true;
                }
                return false;
            }
        } catch (URISyntaxException unused) {
        }
        return true;
    }

    public final void b(Throwable th) {
        if (th.getMessage() != null) {
            a("error_captured", th.getMessage());
        }
        net.one97.paytm.fastag.f.h.a((Context) this, getString(R.string.network_error_heading), getString(R.string.network_error_message));
    }

    public final void c(Throwable th) {
        if (!isFinishing()) {
            e.a(this, th, FasTagKYCActivity.class.getSimpleName());
        }
    }

    public void onDestroy() {
        f();
        super.onDestroy();
    }

    public final void a(CJRDetailProduct cJRDetailProduct) {
        ArrayList<String> arrayList;
        String format = new DecimalFormat("##,##,##,##,##,##,##0.00", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(cJRDetailProduct.getmActualPrice()));
        String format2 = new DecimalFormat("##,##,##,##,##,##,##0.00", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(cJRDetailProduct.getmDiscountedPrice()));
        net.one97.paytm.fastag.f.h.b(String.format(getString(R.string.rs_str), new Object[]{format}), this.u);
        net.one97.paytm.fastag.f.h.b(String.format(getString(R.string.rs_str), new Object[]{format2}), this.v);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.fastag_layout);
        new LinearLayout.LayoutParams(-1, -2);
        linearLayout.removeAllViews();
        if (cJRDetailProduct != null) {
            findViewById(R.id.amount_ll).setVisibility(0);
            this.f13808e.setVisibility(0);
            this.x = cJRDetailProduct;
            if (!TextUtils.isEmpty(this.x.getmDiscountedPrice())) {
                this.f13810g.setText(getString(R.string.proceed_to_pay_fastag, new Object[]{this.x.getmDiscountedPrice()}));
            }
            if (!TextUtils.isEmpty(this.x.getBargainName())) {
                this.w.setText(this.x.getBargainName());
            }
            CJRBulletPoints cJRBulletPoints = cJRDetailProduct.getmBulletPoints();
            if (!(cJRBulletPoints == null || (arrayList = cJRBulletPoints.getmSalientFeatures()) == null || arrayList.size() <= 0)) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    View inflate = getLayoutInflater().inflate(R.layout.ft_detail_bullet_layout, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.tv_fasttag_detail);
                    textView.setText(Html.fromHtml(arrayList.get(i2)));
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    linearLayout.addView(inflate);
                }
            }
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.fastag_description_layout);
            linearLayout2.removeAllViews();
            ArrayList<CJRLongRichDesc> arrayList2 = cJRDetailProduct.getmLongRichDesc();
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    View inflate2 = getLayoutInflater().inflate(R.layout.ft_detail_desc_layout, (ViewGroup) null);
                    LinearLayout linearLayout3 = (LinearLayout) inflate2.findViewById(R.id.product_code_layout);
                    TextView textView2 = (TextView) inflate2.findViewById(R.id.tv_product_code);
                    TextView textView3 = (TextView) inflate2.findViewById(R.id.tv_product_type);
                    LinearLayout linearLayout4 = (LinearLayout) inflate2.findViewById(R.id.product_policy_layout);
                    TextView textView4 = (TextView) inflate2.findViewById(R.id.tv_product_policy);
                    ((TextView) inflate2.findViewById(R.id.tv_detail_title)).setText(arrayList2.get(i3).getmTitle());
                    TextView textView5 = (TextView) inflate2.findViewById(R.id.tv_fasttag_detail);
                    if (!TextUtils.isEmpty(arrayList2.get(i3).getmDescription())) {
                        textView5.setVisibility(0);
                        textView5.setText(Html.fromHtml(arrayList2.get(i3).getmDescription()));
                    } else {
                        textView5.setVisibility(8);
                    }
                    if (arrayList2.get(i3).getmAttributes() == null || TextUtils.isEmpty(arrayList2.get(i3).getmAttributes().get("Product Code"))) {
                        linearLayout3.setVisibility(8);
                    } else {
                        linearLayout3.setVisibility(0);
                        textView2.setText(arrayList2.get(i3).getmAttributes().get("Product Code"));
                        textView3.setText(arrayList2.get(i3).getmAttributes().get(AppManagerUtil.EXTEND_TYPE));
                    }
                    if (arrayList2.get(i3).getmAttributes() == null || TextUtils.isEmpty(arrayList2.get(i3).getmAttributes().get("Return Policy"))) {
                        linearLayout4.setVisibility(8);
                    } else {
                        linearLayout4.setVisibility(0);
                        textView4.setText(arrayList2.get(i3).getmAttributes().get("Return Policy"));
                    }
                    linearLayout2.addView(inflate2);
                }
            }
        }
    }

    public final void a() {
        this.o.setVisibility(8);
        net.one97.paytm.fastag.f.a.a(this.m);
    }

    public final void b() {
        this.o.setVisibility(0);
        LottieAnimationView lottieAnimationView = this.m;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
    }

    public final void c() {
        this.p.setVisibility(8);
        net.one97.paytm.fastag.f.a.a(this.n);
    }

    public final void d() {
        this.p.setVisibility(8);
        net.one97.paytm.fastag.f.a.a(this.n);
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "fastag");
            hashMap.put("event_action", str);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/buy-fastag");
            hashMap.put("VERTICAL_NAME".toLowerCase(), "recharges_utilities");
            if (TextUtils.isEmpty(str2)) {
                hashMap.put("event_label", str2);
            }
            hashMap.put("VERTICAL_NAME".toLowerCase(), "fastag");
            net.one97.paytm.fastag.c.a.a().f13559b.sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, this);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    public void attachBaseContext(Context context) {
        if (net.one97.paytm.fastag.c.a.a() == null) {
            new j();
            Class[] clsArr = new Class[0];
            try {
                Class<?> cls = Class.forName("net.one97.paytm.dynamic.module.fastag.FastagInitActivity");
                cls.getDeclaredMethod("reInitialized", clsArr).invoke(cls.newInstance(), (Object[]) null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(context);
        }
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    private boolean g() {
        return !net.one97.paytm.fastag.c.a.a().f13559b.isMinKycDone(this);
    }
}

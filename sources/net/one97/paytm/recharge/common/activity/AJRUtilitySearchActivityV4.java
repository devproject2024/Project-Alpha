package net.one97.paytm.recharge.common.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.m;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.f;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import java.util.List;
import net.one97.paytm.common.entity.recharge.v2.CJRUtilityLocationModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.y;
import net.one97.paytm.recharge.common.e.k;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.l;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class AJRUtilitySearchActivityV4 extends CJRRechargeToolbarActivity implements View.OnClickListener, e.b, e.c, m<LocationSettingsResult>, k, l.b {

    /* renamed from: a  reason: collision with root package name */
    y f60823a;

    /* renamed from: b  reason: collision with root package name */
    ExpandableListView f60824b;

    /* renamed from: c  reason: collision with root package name */
    AutoCompleteTextView f60825c;

    /* renamed from: d  reason: collision with root package name */
    String f60826d;

    /* renamed from: e  reason: collision with root package name */
    private View f60827e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f60828f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f60829g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ImageView f60830h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f60831i;
    private LinearLayout j;
    private e k;
    private String l;
    private String m;
    private String n = "AJRUtilitySearchList";
    /* access modifiers changed from: private */
    public List<CJRAggsItem> o;
    private String v = "";

    public final void a() {
    }

    public final void c(int i2) {
    }

    public final void d() {
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public /* synthetic */ void onResult(com.google.android.gms.common.api.l lVar) {
        Status status = ((LocationSettingsResult) lVar).f11359a;
        int i2 = status.f8360g;
        if (i2 == 0) {
            v();
        } else if (i2 == 6) {
            try {
                status.a(this, 111);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.f60826d = getIntent().getExtras().getString("list_type");
            this.l = getIntent().getStringExtra("location_title");
            this.m = getIntent().getStringExtra("location_search_hint");
            net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
            this.o = net.one97.paytm.recharge.common.utils.y.c();
            if (getIntent().getExtras().containsKey("categories")) {
                this.v = getIntent().getStringExtra("categories");
            }
        }
        setContentView(R.layout.activity_search_list);
        this.f60825c = (AutoCompleteTextView) findViewById(R.id.search_operator);
        this.f60824b = (ExpandableListView) findViewById(R.id.expandable_search_list);
        this.f60830h = (ImageView) findViewById(R.id.img_search);
        this.f60831i = (TextView) findViewById(R.id.search_hint);
        this.f60827e = findViewById(R.id.content_header_no_apartment);
        this.f60829g = (RelativeLayout) findViewById(R.id.rl_search_list);
        this.f60828f = (TextView) findViewById(R.id.tv_refer_apartment);
        final int i2 = 0;
        this.f60824b.addHeaderView((ViewGroup) getLayoutInflater().inflate(R.layout.location_selection_header, this.f60824b, false), (Object) null, false);
        int g2 = b.g((Context) this);
        this.j = (LinearLayout) findViewById(R.id.current_location_lyt);
        this.j.setVisibility(0);
        int i3 = g2 + (g2 / 2);
        this.j.setPadding(0, i3, 0, i3);
        this.j.setOnClickListener(this);
        if (x()) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.content_view_refer_apartment, (ViewGroup) null);
            inflate.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRUtilitySearchActivityV4.this.w();
                }
            });
            StringBuilder sb = new StringBuilder(getResources().getString(R.string.city_not_listed));
            int length = sb.length();
            sb.append(" " + getResources().getString(R.string.refer_apartment));
            SpannableString spannableString = new SpannableString(sb);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_00b9f5)), length, sb.length(), 0);
            ((TextView) inflate.findViewById(R.id.tv_refer_apartment)).setText(spannableString);
            this.f60824b.addFooterView(inflate);
        }
        this.f60828f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRUtilitySearchActivityV4.this.a(view);
            }
        });
        al_();
        String str = this.l;
        if (str != null) {
            setTitle(str);
        }
        String str2 = this.m;
        if (str2 != null) {
            this.f60831i.setText(str2);
        }
        if (b.O((Context) this) && b.P((Context) this)) {
            try {
                this.k = new e.a(this).a((e.b) this).a((e.c) this).a((a<? extends a.d.C0127d>) f.f11372a).a();
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
        this.f60823a = new y(this, this.o, this.f60824b, this.f60826d, this);
        this.f60824b.setAdapter(this.f60823a);
        final List<CJRAggsItem> list = this.o;
        if (list != null) {
            i2 = list.size();
        }
        this.f60824b.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public final boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j) {
                CJRAggsItem cJRAggsItem = (CJRAggsItem) expandableListView.getExpandableListAdapter().getGroup(i2);
                CJRAggsItem cJRAggsItem2 = (CJRAggsItem) expandableListView.getExpandableListAdapter().getChild(i2, i3);
                for (int i4 = 0; i4 < i2; i4++) {
                    if (cJRAggsItem.equals(list.get(i4))) {
                        int size = ((CJRAggsItem) list.get(i4)).getAggs().size();
                        for (int i5 = 0; i5 < size; i5++) {
                            if (cJRAggsItem2.equals(((CJRAggsItem) list.get(i4)).getAggs().get(i5))) {
                                AJRUtilitySearchActivityV4.this.a(i4, i5);
                            }
                        }
                    }
                }
                return true;
            }
        });
        this.f60824b.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i2, long j) {
                CJRAggsItem cJRAggsItem = (CJRAggsItem) expandableListView.getExpandableListAdapter().getGroup(i2);
                int i3 = 0;
                while (i3 < i2) {
                    if (!cJRAggsItem.equals(list.get(i3))) {
                        i3++;
                    } else if (((CJRAggsItem) list.get(i3)).getAggs() == null || ((((CJRAggsItem) list.get(i3)).getAggs() != null && ((CJRAggsItem) list.get(i3)).getAggs().size() == 0) || !"accordion".equalsIgnoreCase(AJRUtilitySearchActivityV4.this.f60826d))) {
                        AJRUtilitySearchActivityV4.this.a(i3, -1);
                        return true;
                    } else if (expandableListView.isGroupExpanded(i2)) {
                        expandableListView.collapseGroup(i2);
                        return true;
                    } else {
                        expandableListView.expandGroup(i2);
                        return true;
                    }
                }
                return true;
            }
        });
        this.f60825c.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                new Filter() {
                    public final void publishResults(
/*
Method generation error in method: net.one97.paytm.recharge.common.a.y.1.publishResults(java.lang.CharSequence, android.widget.Filter$FilterResults):void, dex: classes6.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.recharge.common.a.y.1.publishResults(java.lang.CharSequence, android.widget.Filter$FilterResults):void, class status: UNLOADED
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
                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
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

                    public final android.widget.Filter.FilterResults performFiltering(
/*
Method generation error in method: net.one97.paytm.recharge.common.a.y.1.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults, dex: classes6.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.recharge.common.a.y.1.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults, class status: UNLOADED
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
                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
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
                }.filter(editable.toString());
                if (editable.toString().trim().length() > 0) {
                    AJRUtilitySearchActivityV4.this.f60830h.setVisibility(8);
                    AJRUtilitySearchActivityV4.this.f60831i.setVisibility(8);
                    return;
                }
                AJRUtilitySearchActivityV4.this.f60830h.setVisibility(0);
                AJRUtilitySearchActivityV4.this.f60831i.setVisibility(0);
                if (AJRUtilitySearchActivityV4.this.o != null && !AJRUtilitySearchActivityV4.this.o.isEmpty()) {
                    for (int i2 = 0; i2 < AJRUtilitySearchActivityV4.this.o.size(); i2++) {
                        AJRUtilitySearchActivityV4.this.f60824b.collapseGroup(i2);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        w();
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: private */
    public void l() {
        a((Context) this, getString(R.string.please_wait_progress_msg_re));
        new l(this, this, this.k, this).b();
    }

    public void onConnectionSuspended(int i2) {
        try {
            if (this.k != null) {
                this.k.d();
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    public void onClick(View view) {
        if (view.getId() != R.id.current_location_lyt) {
            return;
        }
        if (b.c((Context) this)) {
            l();
        } else {
            u();
        }
    }

    public final void am_() {
        o();
    }

    public final void a(CJRUtilityLocationModel cJRUtilityLocationModel) {
        int i2;
        o();
        if (cJRUtilityLocationModel != null) {
            int a2 = a(new CJRAggsItem.Builder().setValue(cJRUtilityLocationModel.getState()).build());
            if (a2 == -1) {
                a2 = a(new CJRAggsItem.Builder().setValue(cJRUtilityLocationModel.getCity()).build());
            }
            if (a2 < 0) {
                return;
            }
            if ((this.o.get(a2).getAggs() == null || this.o.get(a2).getAggs().size() != 0) && this.o.get(a2).getAggs() != null) {
                CJRAggsItem build = new CJRAggsItem.Builder().setValue(cJRUtilityLocationModel.getCity()).build();
                if (this.o == null) {
                    net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
                    this.o = net.one97.paytm.recharge.common.utils.y.c();
                }
                List<CJRAggsItem> list = this.o;
                if (list != null) {
                    CJRAggsItem cJRAggsItem = list.get(a2);
                    int size = cJRAggsItem.getAggs().size();
                    i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (build.equals(cJRAggsItem.getAggs().get(i2))) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                i2 = -1;
                if (i2 == -1) {
                    a(-1, -1);
                } else {
                    a(a2, i2);
                }
            } else {
                a(a2, -1);
            }
        } else {
            az azVar = az.f61525a;
            az.a(this, ERROR_TYPE.UNDEFINED, ACTION_TYPE.LOCATION_NOT_FOUND, getResources().getString(R.string.error), getResources().getString(R.string.no_gps));
        }
    }

    public void onStart() {
        super.onStart();
        try {
            if (this.k != null && !this.k.f()) {
                this.k.d();
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (b.c((Context) AJRUtilitySearchActivityV4.this)) {
                    AJRUtilitySearchActivityV4.this.l();
                } else {
                    AJRUtilitySearchActivityV4.this.u();
                }
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3) {
        Intent intent = new Intent();
        intent.putExtra("intent_extra_item_index", i2);
        intent.putExtra("intent_extra_child_index", i3);
        if (i2 >= 0 && this.o.size() > i2) {
            intent.putExtra("operator_variant", this.o.get(i2));
        }
        setResult(1, intent);
        q();
        finish();
    }

    public void onStop() {
        super.onStop();
        o();
        try {
            if (this.k != null && this.k.f()) {
                this.k.e();
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 115) {
            if (i3 == -1) {
                a((Context) this, getString(R.string.please_wait_progress_msg_re));
                v();
            } else if (i3 == 0) {
                o();
            }
        }
    }

    private void v() {
        new l(this, this, this.k, this).a();
    }

    private int a(CJRAggsItem cJRAggsItem) {
        if (this.o == null) {
            net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
            this.o = net.one97.paytm.recharge.common.utils.y.c();
        }
        List<CJRAggsItem> list = this.o;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (cJRAggsItem.getValue().equals(list.get(i2).getValue())) {
                return i2;
            }
        }
        return -1;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 57) {
            if (s.a(iArr)) {
                a((Context) this, getString(R.string.please_wait_progress_msg_re));
                new l(this, this, this.k, this).b();
            } else {
                o();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: private */
    public void w() {
        startActivity(new Intent(this, AJRReferApartmentActivity.class));
    }

    private boolean x() {
        return "apartments".equalsIgnoreCase(this.v);
    }

    public final void a(boolean z) {
        if (!x()) {
            return;
        }
        if (z) {
            this.f60829g.setVisibility(8);
            this.f60827e.setVisibility(0);
            ((TextView) findViewById(R.id.tv_no_result_found)).setText(getResources().getString(R.string.city_not_listed));
            q();
            return;
        }
        this.f60829g.setVisibility(0);
        this.f60827e.setVisibility(8);
    }
}

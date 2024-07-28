package net.one97.paytm.o2o.movies.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public String f75258a;

    /* renamed from: b  reason: collision with root package name */
    public String f75259b = "";

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRCinemas> f75260c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<CJRMovieHomeListItem> f75261d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f75262e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f75263f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f75264g;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fjr_cinema_search, viewGroup, false);
        this.f75264g = (RelativeLayout) inflate.findViewById(R.id.no_cinemas_err_lyt);
        this.f75263f = (ProgressBar) inflate.findViewById(R.id.cinemas_progress);
        this.f75262e = (RecyclerView) inflate.findViewById(R.id.cinema_recycler_view);
        this.f75262e.setLayoutManager(new LinearLayoutManager(getActivity()));
        try {
            if (Build.VERSION.SDK_INT < 21 && getActivity() != null) {
                getActivity().getWindow().setSoftInputMode(32);
            }
        } catch (Exception unused) {
        }
        this.f75262e.addOnScrollListener(new RecyclerView.l() {
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
            }

            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                if (c.this.getActivity() != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) c.this.getActivity().getSystemService("input_method");
                    if (i3 > 0) {
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(c.this.f75262e.getWindowToken(), 0);
                        }
                    } else if (i3 < 0 && inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(c.this.f75262e.getWindowToken(), 0);
                    }
                }
            }
        });
        ArrayList<CJRCinemas> arrayList = this.f75260c;
        if (arrayList == null || arrayList.size() <= 0) {
            this.f75263f.setVisibility(8);
            this.f75264g.setVisibility(0);
        } else {
            a aVar = new a(getActivity(), this.f75260c);
            this.f75263f.setVisibility(8);
            this.f75264g.setVisibility(8);
            this.f75262e.setAdapter(aVar);
        }
        return inflate;
    }

    public class a extends RecyclerView.a<C1487a> {

        /* renamed from: a  reason: collision with root package name */
        Context f75266a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<CJRCinemas> f75267b;

        /* renamed from: d  reason: collision with root package name */
        private LayoutInflater f75269d = ((LayoutInflater) this.f75266a.getSystemService("layout_inflater"));

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            C1487a aVar = (C1487a) vVar;
            ArrayList<CJRCinemas> arrayList = this.f75267b;
            if (arrayList != null && arrayList.get(i2) != null && !TextUtils.isEmpty(this.f75267b.get(i2).getName())) {
                aVar.f75270a.setVisibility(8);
                aVar.f75271b.setText(this.f75267b.get(i2).getName());
            }
        }

        a(Context context, ArrayList<CJRCinemas> arrayList) {
            this.f75266a = context;
            this.f75267b = arrayList;
        }

        public final int getItemCount() {
            return this.f75267b.size();
        }

        /* renamed from: net.one97.paytm.o2o.movies.fragment.c$a$a  reason: collision with other inner class name */
        class C1487a extends RecyclerView.v {

            /* renamed from: a  reason: collision with root package name */
            final RoboTextView f75270a;

            /* renamed from: b  reason: collision with root package name */
            RoboTextView f75271b;

            /* renamed from: d  reason: collision with root package name */
            private final View f75273d;

            C1487a(View view) {
                super(view);
                this.f75271b = (RoboTextView) view.findViewById(R.id.cinema_name);
                this.f75270a = (RoboTextView) view.findViewById(R.id.heading);
                this.f75273d = view.findViewById(R.id.bottom_border);
                this.f75271b.setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0028: INVOKE  
                      (wrap: com.paytm.utility.RoboTextView : 0x0021: IGET  (r1v9 com.paytm.utility.RoboTextView) = 
                      (r0v0 'this' net.one97.paytm.o2o.movies.fragment.c$a$a A[THIS])
                     net.one97.paytm.o2o.movies.fragment.c.a.a.b com.paytm.utility.RoboTextView)
                      (wrap: net.one97.paytm.o2o.movies.fragment.-$$Lambda$c$a$a$yt8FB-iFd8SfEFT3wambSNdQs7c : 0x0025: CONSTRUCTOR  (r2v1 net.one97.paytm.o2o.movies.fragment.-$$Lambda$c$a$a$yt8FB-iFd8SfEFT3wambSNdQs7c) = 
                      (r0v0 'this' net.one97.paytm.o2o.movies.fragment.c$a$a A[THIS])
                     call: net.one97.paytm.o2o.movies.fragment.-$$Lambda$c$a$a$yt8FB-iFd8SfEFT3wambSNdQs7c.<init>(net.one97.paytm.o2o.movies.fragment.c$a$a):void type: CONSTRUCTOR)
                     com.paytm.utility.RoboTextView.setOnClickListener(android.view.View$OnClickListener):void type: VIRTUAL in method: net.one97.paytm.o2o.movies.fragment.c.a.a.<init>(net.one97.paytm.o2o.movies.fragment.c$a, android.view.View):void, dex: classes9.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
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
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0025: CONSTRUCTOR  (r2v1 net.one97.paytm.o2o.movies.fragment.-$$Lambda$c$a$a$yt8FB-iFd8SfEFT3wambSNdQs7c) = 
                      (r0v0 'this' net.one97.paytm.o2o.movies.fragment.c$a$a A[THIS])
                     call: net.one97.paytm.o2o.movies.fragment.-$$Lambda$c$a$a$yt8FB-iFd8SfEFT3wambSNdQs7c.<init>(net.one97.paytm.o2o.movies.fragment.c$a$a):void type: CONSTRUCTOR in method: net.one97.paytm.o2o.movies.fragment.c.a.a.<init>(net.one97.paytm.o2o.movies.fragment.c$a, android.view.View):void, dex: classes9.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 59 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: net.one97.paytm.o2o.movies.fragment.-$$Lambda$c$a$a$yt8FB-iFd8SfEFT3wambSNdQs7c, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	... 65 more
                    */
                /*
                    this = this;
                    net.one97.paytm.o2o.movies.fragment.c.a.this = r1
                    r0.<init>(r2)
                    int r1 = net.one97.paytm.o2o.movies.R.id.cinema_name
                    android.view.View r1 = r2.findViewById(r1)
                    com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
                    r0.f75271b = r1
                    int r1 = net.one97.paytm.o2o.movies.R.id.heading
                    android.view.View r1 = r2.findViewById(r1)
                    com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
                    r0.f75270a = r1
                    int r1 = net.one97.paytm.o2o.movies.R.id.bottom_border
                    android.view.View r1 = r2.findViewById(r1)
                    r0.f75273d = r1
                    com.paytm.utility.RoboTextView r1 = r0.f75271b
                    net.one97.paytm.o2o.movies.fragment.-$$Lambda$c$a$a$yt8FB-iFd8SfEFT3wambSNdQs7c r2 = new net.one97.paytm.o2o.movies.fragment.-$$Lambda$c$a$a$yt8FB-iFd8SfEFT3wambSNdQs7c
                    r2.<init>(r0)
                    r1.setOnClickListener(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.fragment.c.a.C1487a.<init>(net.one97.paytm.o2o.movies.fragment.c$a, android.view.View):void");
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0125 */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0136 A[Catch:{ Exception -> 0x0151 }] */
            /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ void a(android.view.View r7) {
                /*
                    r6 = this;
                    net.one97.paytm.o2o.movies.fragment.c$a r0 = net.one97.paytm.o2o.movies.fragment.c.a.this     // Catch:{ Exception -> 0x0151 }
                    java.util.ArrayList<net.one97.paytm.o2o.movies.entity.CJRCinemas> r0 = r0.f75267b     // Catch:{ Exception -> 0x0151 }
                    int r1 = r6.getAdapterPosition()     // Catch:{ Exception -> 0x0151 }
                    java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.entity.CJRCinemas r0 = (net.one97.paytm.o2o.movies.entity.CJRCinemas) r0     // Catch:{ Exception -> 0x0151 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r2 = "--------CINEMA  NAME---------"
                    r1.<init>(r2)     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r2 = r0.getName()     // Catch:{ Exception -> 0x0151 }
                    r1.append(r2)     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r2 = "--------------CINEMA ID-----------"
                    r1.append(r2)     // Catch:{ Exception -> 0x0151 }
                    java.lang.Integer r2 = r0.getPaytmCinemaId()     // Catch:{ Exception -> 0x0151 }
                    r1.append(r2)     // Catch:{ Exception -> 0x0151 }
                    com.paytm.utility.b.j()     // Catch:{ Exception -> 0x0151 }
                    android.content.Intent r1 = new android.content.Intent     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c$a r2 = net.one97.paytm.o2o.movies.fragment.c.a.this     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c r2 = net.one97.paytm.o2o.movies.fragment.c.this     // Catch:{ Exception -> 0x0151 }
                    androidx.fragment.app.FragmentActivity r2 = r2.getActivity()     // Catch:{ Exception -> 0x0151 }
                    java.lang.Class<net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity> r3 = net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity.class
                    r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r2 = "movie_ticket_city_selected"
                    net.one97.paytm.o2o.movies.fragment.c$a r3 = net.one97.paytm.o2o.movies.fragment.c.a.this     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c r3 = net.one97.paytm.o2o.movies.fragment.c.this     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r3 = r3.f75258a     // Catch:{ Exception -> 0x0151 }
                    r1.putExtra(r2, r3)     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r2 = "movie_ticket_selected_item_type"
                    java.lang.String r3 = "cinema"
                    r1.putExtra(r2, r3)     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r2 = "movie_ticket_selected_item_value"
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0151 }
                    r3.<init>()     // Catch:{ Exception -> 0x0151 }
                    java.lang.Integer r4 = r0.getPaytmCinemaId()     // Catch:{ Exception -> 0x0151 }
                    r3.append(r4)     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0151 }
                    r1.putExtra(r2, r3)     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.utils.i r2 = net.one97.paytm.o2o.movies.utils.i.a()     // Catch:{ Exception -> 0x0151 }
                    r2.f75936f = r0     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c$a r2 = net.one97.paytm.o2o.movies.fragment.c.a.this     // Catch:{ Exception -> 0x0151 }
                    android.content.Context r2 = r2.f75266a     // Catch:{ Exception -> 0x0151 }
                    if (r2 == 0) goto L_0x0085
                    net.one97.paytm.o2o.movies.fragment.c$a r2 = net.one97.paytm.o2o.movies.fragment.c.a.this     // Catch:{ Exception -> 0x0151 }
                    android.content.Context r2 = r2.f75266a     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r3 = "input_method"
                    java.lang.Object r2 = r2.getSystemService(r3)     // Catch:{ Exception -> 0x0151 }
                    android.view.inputmethod.InputMethodManager r2 = (android.view.inputmethod.InputMethodManager) r2     // Catch:{ Exception -> 0x0151 }
                    if (r2 == 0) goto L_0x0085
                    android.os.IBinder r7 = r7.getWindowToken()     // Catch:{ Exception -> 0x0151 }
                    r3 = 0
                    r2.hideSoftInputFromWindow(r7, r3)     // Catch:{ Exception -> 0x0151 }
                L_0x0085:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r2 = "----Cinema Frag--------CINEMA NAME-----"
                    r7.<init>(r2)     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r2 = r0.getName()     // Catch:{ Exception -> 0x0151 }
                    r7.append(r2)     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r2 = "------Listing Type ------Cinema"
                    r7.append(r2)     // Catch:{ Exception -> 0x0151 }
                    com.paytm.utility.b.j()     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c$a r7 = net.one97.paytm.o2o.movies.fragment.c.a.this     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c$a r2 = net.one97.paytm.o2o.movies.fragment.c.a.this     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c r2 = net.one97.paytm.o2o.movies.fragment.c.this     // Catch:{ Exception -> 0x0151 }
                    java.lang.String r2 = r2.f75258a     // Catch:{ Exception -> 0x0151 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r4 = "-------------Cinemas Frag----- searchCategory---Cinema Hall------cinemaName-----"
                    r3.<init>(r4)     // Catch:{ Exception -> 0x0125 }
                    r3.append(r0)     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r4 = "----cityName----"
                    r3.append(r4)     // Catch:{ Exception -> 0x0125 }
                    r3.append(r2)     // Catch:{ Exception -> 0x0125 }
                    com.paytm.utility.b.j()     // Catch:{ Exception -> 0x0125 }
                    java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0125 }
                    r2.<init>()     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r3 = "screenName"
                    java.lang.String r4 = "/movies"
                    r2.put(r3, r4)     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.x     // Catch:{ Exception -> 0x0125 }
                    r2.put(r3, r4)     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r3 = "movie_search_category"
                    net.one97.paytm.o2o.movies.fragment.c r4 = net.one97.paytm.o2o.movies.fragment.c.this     // Catch:{ Exception -> 0x0125 }
                    int r5 = net.one97.paytm.o2o.movies.R.string.cinemas_search_tab     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x0125 }
                    r2.put(r3, r4)     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r3 = ""
                    if (r0 == 0) goto L_0x00fb
                    java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r4 = "Homescreen-"
                    java.lang.String r5 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r4 = r4.concat(r5)     // Catch:{ Exception -> 0x0125 }
                    r2.put(r3, r4)     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r3 = "NA|"
                    java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r3 = r3.concat(r0)     // Catch:{ Exception -> 0x0125 }
                L_0x00fb:
                    java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x0125 }
                    r2.put(r0, r3)     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x0125 }
                    r2.put(r0, r3)     // Catch:{ Exception -> 0x0125 }
                    android.content.Context r0 = r7.f75266a     // Catch:{ Exception -> 0x0125 }
                    boolean r0 = com.paytm.utility.b.r((android.content.Context) r0)     // Catch:{ Exception -> 0x0125 }
                    if (r0 == 0) goto L_0x011a
                    java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x0125 }
                    android.content.Context r3 = r7.f75266a     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r3 = com.paytm.utility.b.n((android.content.Context) r3)     // Catch:{ Exception -> 0x0125 }
                    r2.put(r0, r3)     // Catch:{ Exception -> 0x0125 }
                L_0x011a:
                    net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x0125 }
                    net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x0125 }
                    android.content.Context r7 = r7.f75266a     // Catch:{ Exception -> 0x0125 }
                    r0.sendCustomEventWithMap(r3, r2, r7)     // Catch:{ Exception -> 0x0125 }
                L_0x0125:
                    net.one97.paytm.o2o.movies.fragment.c$a r7 = net.one97.paytm.o2o.movies.fragment.c.a.this     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c r7 = net.one97.paytm.o2o.movies.fragment.c.this     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c.c(r7)     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c$a r7 = net.one97.paytm.o2o.movies.fragment.c.a.this     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c r7 = net.one97.paytm.o2o.movies.fragment.c.this     // Catch:{ Exception -> 0x0151 }
                    androidx.fragment.app.FragmentActivity r7 = r7.getActivity()     // Catch:{ Exception -> 0x0151 }
                    if (r7 == 0) goto L_0x0151
                    net.one97.paytm.o2o.movies.fragment.c$a r7 = net.one97.paytm.o2o.movies.fragment.c.a.this     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c r7 = net.one97.paytm.o2o.movies.fragment.c.this     // Catch:{ Exception -> 0x0151 }
                    androidx.fragment.app.FragmentActivity r7 = r7.getActivity()     // Catch:{ Exception -> 0x0151 }
                    r7.startActivity(r1)     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c$a r7 = net.one97.paytm.o2o.movies.fragment.c.a.this     // Catch:{ Exception -> 0x0151 }
                    net.one97.paytm.o2o.movies.fragment.c r7 = net.one97.paytm.o2o.movies.fragment.c.this     // Catch:{ Exception -> 0x0151 }
                    androidx.fragment.app.FragmentActivity r7 = r7.getActivity()     // Catch:{ Exception -> 0x0151 }
                    int r0 = net.one97.paytm.common.assets.R.anim.slide_in_right     // Catch:{ Exception -> 0x0151 }
                    r1 = 17432577(0x10a0001, float:2.53466E-38)
                    r7.overridePendingTransition(r0, r1)     // Catch:{ Exception -> 0x0151 }
                L_0x0151:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.fragment.c.a.C1487a.a(android.view.View):void");
            }
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C1487a(this.f75269d.inflate(R.layout.movies_search_landing_cinemas, viewGroup, false));
        }
    }

    static /* synthetic */ void c(c cVar) {
        try {
            b.f75032a.f75033b.sendCustomEvents("mov_search_performed", cVar.getActivity());
        } catch (Exception unused) {
        }
    }
}

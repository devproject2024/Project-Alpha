package com.travel.train.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.model.searchResult.CJRSearchByTrainNumberModel;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;

public abstract class o extends RecyclerView.a<a> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    int f26497a = -1;

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f26498b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26499c = true;

    /* renamed from: d  reason: collision with root package name */
    private Context f26500d;

    /* renamed from: e  reason: collision with root package name */
    private CJRSearchByTrainNumberModel f26501e;

    /* renamed from: f  reason: collision with root package name */
    private String f26502f;

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        r1 = (r1 = r1.getBody()).getSearchedDateClasses();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r7, int r8) {
        /*
            r6 = this;
            com.travel.train.b.o$a r7 = (com.travel.train.b.o.a) r7
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r7, r0)
            kotlin.g.b.x$e r0 = new kotlin.g.b.x$e
            r0.<init>()
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r6.f26501e
            r2 = 0
            if (r1 == 0) goto L_0x0024
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x0024
            java.util.List r1 = r1.getSearchedDateClasses()
            if (r1 == 0) goto L_0x0024
            java.lang.Object r1 = r1.get(r8)
            com.travel.train.model.searchResult.SearchedDateClass r1 = (com.travel.train.model.searchResult.SearchedDateClass) r1
            goto L_0x0025
        L_0x0024:
            r1 = r2
        L_0x0025:
            r0.element = r1
            android.widget.TextView r1 = r7.f26503a
            T r3 = r0.element
            com.travel.train.model.searchResult.SearchedDateClass r3 = (com.travel.train.model.searchResult.SearchedDateClass) r3
            if (r3 == 0) goto L_0x0034
            java.lang.String r3 = r3.getClassName()
            goto L_0x0035
        L_0x0034:
            r3 = r2
        L_0x0035:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            android.widget.Button r1 = r7.f26507e
            android.content.Context r3 = r6.f26500d
            android.content.res.Resources r3 = r3.getResources()
            int r4 = com.travel.train.R.string.train_book
            java.lang.String r3 = r3.getString(r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            T r1 = r0.element
            com.travel.train.model.searchResult.SearchedDateClass r1 = (com.travel.train.model.searchResult.SearchedDateClass) r1
            if (r1 == 0) goto L_0x0058
            java.lang.String r1 = r1.getFare()
            goto L_0x0059
        L_0x0058:
            r1 = r2
        L_0x0059:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r3 = 0
            if (r1 != 0) goto L_0x00e8
            android.widget.TextView r1 = r7.f26504b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = " ₹"
            r4.<init>(r5)
            T r5 = r0.element
            com.travel.train.model.searchResult.SearchedDateClass r5 = (com.travel.train.model.searchResult.SearchedDateClass) r5
            if (r5 == 0) goto L_0x0076
            java.lang.String r5 = r5.getFare()
            goto L_0x0077
        L_0x0076:
            r5 = r2
        L_0x0077:
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            android.widget.TextView r1 = r7.f26505c
            T r4 = r0.element
            com.travel.train.model.searchResult.SearchedDateClass r4 = (com.travel.train.model.searchResult.SearchedDateClass) r4
            if (r4 == 0) goto L_0x0090
            java.lang.String r4 = r4.getStatus()
            goto L_0x0091
        L_0x0090:
            r4 = r2
        L_0x0091:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            android.widget.TextView r1 = r7.f26505c
            T r4 = r0.element
            com.travel.train.model.searchResult.SearchedDateClass r4 = (com.travel.train.model.searchResult.SearchedDateClass) r4
            if (r4 == 0) goto L_0x00a3
            java.lang.String r4 = r4.getText_colour()
            goto L_0x00a4
        L_0x00a3:
            r4 = r2
        L_0x00a4:
            int r4 = android.graphics.Color.parseColor(r4)
            r1.setTextColor(r4)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r7.f26506d
            com.travel.train.b.o$b r4 = new com.travel.train.b.o$b
            r4.<init>(r6, r0, r8, r7)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r1.setOnClickListener(r4)
            boolean r1 = r6.f26499c
            if (r1 == 0) goto L_0x00c9
            java.lang.String r1 = r6.f26502f
            if (r1 != 0) goto L_0x00c9
            if (r8 != 0) goto L_0x00c9
            r6.f26499c = r3
            r6.f26497a = r8
            a(r7)
            goto L_0x0127
        L_0x00c9:
            T r1 = r0.element
            com.travel.train.model.searchResult.SearchedDateClass r1 = (com.travel.train.model.searchResult.SearchedDateClass) r1
            if (r1 == 0) goto L_0x00d3
            java.lang.String r2 = r1.getClassType()
        L_0x00d3:
            if (r2 != 0) goto L_0x00d8
            kotlin.g.b.k.a()
        L_0x00d8:
            java.lang.String r1 = r6.f26502f
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0127
            r6.f26499c = r3
            r6.f26497a = r8
            a(r7)
            goto L_0x0127
        L_0x00e8:
            android.widget.TextView r8 = r7.f26504b
            java.lang.String r1 = ""
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r8.setText(r2)
            android.widget.TextView r8 = r7.f26504b
            android.content.Context r2 = r6.f26500d
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.travel.train.R.drawable.pre_t_train_grey_fill
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r4)
            r8.setBackground(r2)
            android.widget.TextView r8 = r7.f26505c
            android.content.Context r2 = r6.f26500d
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.travel.train.R.drawable.pre_t_train_grey_fill
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r4)
            r8.setBackground(r2)
            android.widget.Button r8 = r7.f26507e
            r8.setVisibility(r3)
            android.widget.Button r8 = r7.f26507e
            int r2 = com.travel.train.R.drawable.blue_border_with_refresh
            r8.setBackgroundResource(r2)
            android.widget.Button r8 = r7.f26507e
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x0127:
            android.widget.Button r8 = r7.f26507e
            T r0 = r0.element
            com.travel.train.model.searchResult.SearchedDateClass r0 = (com.travel.train.model.searchResult.SearchedDateClass) r0
            r8.setTag(r0)
            android.widget.Button r7 = r7.f26507e
            r8 = r6
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r7.setOnClickListener(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.b.o.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f26500d).inflate(R.layout.pre_t_trai_availability_class_list_layout, viewGroup, false);
        if (inflate == null) {
            k.a();
        }
        return new a(inflate);
    }

    public o(RecyclerView recyclerView, Context context, CJRSearchByTrainNumberModel cJRSearchByTrainNumberModel, String str) {
        k.c(recyclerView, "classList");
        k.c(context, "mContext");
        this.f26498b = recyclerView;
        this.f26500d = context;
        this.f26501e = cJRSearchByTrainNumberModel;
        this.f26502f = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r0.getBody()).getSearchedDateClasses();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getItemCount() {
        /*
            r1 = this;
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r0 = r1.f26501e
            if (r0 == 0) goto L_0x0019
            com.travel.train.model.searchResult.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x0019
            java.util.List r0 = r0.getSearchedDateClasses()
            if (r0 == 0) goto L_0x0019
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            if (r0 != 0) goto L_0x001f
            kotlin.g.b.k.a()
        L_0x001f:
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.b.o.getItemCount():int");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f26511a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f26512b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f26513c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f26514d;

        b(o oVar, x.e eVar, int i2, a aVar) {
            this.f26511a = oVar;
            this.f26512b = eVar;
            this.f26513c = i2;
            this.f26514d = aVar;
        }

        public final void onClick(View view) {
            if (!(this.f26511a.f26497a == -1 || this.f26511a.f26498b.findViewHolderForAdapterPosition(this.f26511a.f26497a) == null)) {
                RecyclerView.v findViewHolderForAdapterPosition = this.f26511a.f26498b.findViewHolderForAdapterPosition(this.f26511a.f26497a);
                if (findViewHolderForAdapterPosition != null) {
                    a aVar = (a) findViewHolderForAdapterPosition;
                    aVar.f26506d.setBackground((Drawable) null);
                    aVar.f26507e.setVisibility(8);
                } else {
                    throw new u("null cannot be cast to non-null type com.travel.train.adapter.CJRSearchByTrainBSClassListAdapter.ClassViewHolder");
                }
            }
            this.f26511a.f26497a = this.f26513c;
            o.a(this.f26514d);
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f26503a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f26504b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f26505c;

        /* renamed from: d  reason: collision with root package name */
        final ConstraintLayout f26506d;

        /* renamed from: e  reason: collision with root package name */
        final Button f26507e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f26508f;

        /* renamed from: g  reason: collision with root package name */
        private final ProgressBar f26509g;

        /* renamed from: h  reason: collision with root package name */
        private final TextView f26510h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.txt_train_class_type);
            if (findViewById != null) {
                this.f26503a = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.txt_train_price);
                if (findViewById2 != null) {
                    this.f26504b = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.txt_train_status);
                    if (findViewById3 != null) {
                        this.f26505c = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.txt_train_pred);
                        if (findViewById4 != null) {
                            this.f26508f = (TextView) findViewById4;
                            View findViewById5 = view.findViewById(R.id.prediction_progressBar);
                            if (findViewById5 != null) {
                                this.f26509g = (ProgressBar) findViewById5;
                                View findViewById6 = view.findViewById(R.id.prediction_progressBar_txt);
                                if (findViewById6 != null) {
                                    this.f26510h = (TextView) findViewById6;
                                    View findViewById7 = view.findViewById(R.id.item_container);
                                    if (findViewById7 != null) {
                                        this.f26506d = (ConstraintLayout) findViewById7;
                                        View findViewById8 = view.findViewById(R.id.book_button);
                                        if (findViewById8 != null) {
                                            this.f26507e = (Button) findViewById8;
                                            return;
                                        }
                                        throw new u("null cannot be cast to non-null type android.widget.Button");
                                    }
                                    throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                                }
                                throw new u("null cannot be cast to non-null type android.widget.TextView");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.ProgressBar");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    static void a(a aVar) {
        aVar.f26506d.setBackgroundResource(R.drawable.blue_border);
        aVar.f26507e.setVisibility(0);
    }
}

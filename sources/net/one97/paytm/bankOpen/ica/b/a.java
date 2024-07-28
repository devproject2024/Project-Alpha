package net.one97.paytm.bankOpen.ica.b;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.ica.model.Option;
import net.one97.paytm.i.f;

public final class a extends f {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.bankCommon.f.d f16457a;

    /* renamed from: b  reason: collision with root package name */
    public String f16458b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Option> f16459c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f16460d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f16461e;

    private View a(int i2) {
        if (this.f16461e == null) {
            this.f16461e = new HashMap();
        }
        View view = (View) this.f16461e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f16461e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pb_ca_answer_bsdf, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f16460d = (ImageView) view.findViewById(R.id.full_kyc_cross_iv);
        TextView textView = (TextView) a(R.id.dialog_title);
        k.a((Object) textView, "dialog_title");
        String str = this.f16458b;
        if (str == null) {
            k.a("questionText");
        }
        textView.setText(str);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        RecyclerView recyclerView = (RecyclerView) a(R.id.optionRv);
        k.a((Object) recyclerView, "optionRv");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        C0234a aVar = new C0234a(context, new d(this));
        ArrayList<Option> arrayList = this.f16459c;
        if (arrayList == null) {
            k.a("answerList");
        }
        k.c(arrayList, "<set-?>");
        aVar.f16463b = arrayList;
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.optionRv);
        k.a((Object) recyclerView2, "optionRv");
        recyclerView2.setAdapter(aVar);
        ImageView imageView = this.f16460d;
        if (imageView == null) {
            k.a();
        }
        imageView.setOnClickListener(new c(this));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f16468a;

        c(a aVar) {
            this.f16468a = aVar;
        }

        public final void onClick(View view) {
            this.f16468a.dismissAllowingStateLoss();
        }
    }

    public static final class d implements net.one97.paytm.bankCommon.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f16469a;

        d(a aVar) {
            this.f16469a = aVar;
        }

        public final void onFragmentAction(int i2, Object obj) {
            if (obj != null) {
                net.one97.paytm.bankCommon.f.d a2 = this.f16469a.f16457a;
                if (a2 != null) {
                    String str = this.f16469a.f16458b;
                    if (str == null) {
                        k.a("questionText");
                    }
                    a2.onFragmentAction(i2, new o(str, obj));
                    this.f16469a.dismissAllowingStateLoss();
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.bankOpen.ica.model.Option");
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public TextView f16467a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.title);
            k.a((Object) findViewById, "itemView.findViewById(R.id.title)");
            this.f16467a = (TextView) findViewById;
        }
    }

    /* renamed from: net.one97.paytm.bankOpen.ica.b.a$a  reason: collision with other inner class name */
    public static final class C0234a extends RecyclerView.a<b> {

        /* renamed from: a  reason: collision with root package name */
        public Context f16462a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<Option> f16463b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public net.one97.paytm.bankCommon.f.d f16464c;

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            b bVar = (b) vVar;
            k.c(bVar, "holder");
            TextView textView = bVar.f16467a;
            if (textView == null) {
                k.a("title");
            }
            ArrayList<Option> arrayList = this.f16463b;
            if (arrayList == null) {
                k.a("optionList");
            }
            textView.setText(arrayList.get(i2).getText());
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            Context context = this.f16462a;
            if (context == null) {
                k.a("context");
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.pb_ca_answer_rv_item, (ViewGroup) null);
            x.e eVar = new x.e();
            k.a((Object) inflate, "view");
            eVar.element = new b(inflate);
            ((b) eVar.element).itemView.setOnClickListener(new C0235a(this, eVar));
            return (b) eVar.element;
        }

        public C0234a(Context context, net.one97.paytm.bankCommon.f.d dVar) {
            k.c(context, "context");
            k.c(dVar, "fa");
            this.f16462a = context;
            this.f16464c = dVar;
        }

        /* renamed from: net.one97.paytm.bankOpen.ica.b.a$a$a  reason: collision with other inner class name */
        static final class C0235a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0234a f16465a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ x.e f16466b;

            C0235a(C0234a aVar, x.e eVar) {
                this.f16465a = aVar;
                this.f16466b = eVar;
            }

            public final void onClick(View view) {
                net.one97.paytm.bankCommon.f.d dVar = this.f16465a.f16464c;
                if (dVar == null) {
                    k.a("fragmentActionListener");
                }
                int adapterPosition = ((b) this.f16466b.element).getAdapterPosition();
                ArrayList<Option> arrayList = this.f16465a.f16463b;
                if (arrayList == null) {
                    k.a("optionList");
                }
                dVar.onFragmentAction(adapterPosition, arrayList.get(((b) this.f16466b.element).getAdapterPosition()));
            }
        }

        public final int getItemCount() {
            ArrayList<Option> arrayList = this.f16463b;
            if (arrayList == null) {
                k.a("optionList");
            }
            return arrayList.size();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f16461e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

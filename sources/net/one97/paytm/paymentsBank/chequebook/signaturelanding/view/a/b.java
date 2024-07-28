package net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.a;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookNames;

public final class b extends f implements a.C0287a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f17828f = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public f f17829a;

    /* renamed from: b  reason: collision with root package name */
    public ChequeBookNames f17830b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f17831c = "Proceed";

    /* renamed from: d  reason: collision with root package name */
    Integer f17832d = -1;

    /* renamed from: e  reason: collision with root package name */
    String f17833e;

    /* renamed from: g  reason: collision with root package name */
    private a f17834g;

    /* renamed from: h  reason: collision with root package name */
    private String f17835h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f17836i;

    private View a(int i2) {
        if (this.f17836i == null) {
            this.f17836i = new HashMap();
        }
        View view = (View) this.f17836i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f17836i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = getLayoutInflater().inflate(R.layout.fragment_item_selection, viewGroup, false);
        if (inflate == null) {
            k.a();
        }
        Button button = (Button) inflate.findViewById(R.id.btn_proceed_to_pay);
        k.a((Object) button, "view!!.btn_proceed_to_pay");
        button.setText(this.f17831c);
        ((Button) inflate.findViewById(R.id.btn_proceed_to_pay)).setOnClickListener(new c(this));
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("title");
            RoboTextView roboTextView = (RoboTextView) inflate.findViewById(R.id.headingText);
            k.a((Object) roboTextView, "view!!.headingText");
            roboTextView.setText(string);
        }
        return inflate;
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f17839a;

        c(b bVar) {
            this.f17839a = bVar;
        }

        public final void onClick(View view) {
            Integer num = this.f17839a.f17832d;
            if ((num != null && num.intValue() == -1) || this.f17839a.f17833e == null) {
                com.paytm.utility.b.b(this.f17839a.getContext(), "Error", "Please select at least one suggested name");
                return;
            }
            f a2 = this.f17839a.f17829a;
            if (a2 != null) {
                Integer num2 = this.f17839a.f17832d;
                if (num2 == null) {
                    k.a();
                }
                num2.intValue();
                a2.d(this.f17839a.f17833e);
            }
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.errorView);
        k.a((Object) linearLayout, "view!!.errorView");
        linearLayout.setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.contentView);
        k.a((Object) relativeLayout, "view!!.contentView");
        relativeLayout.setVisibility(0);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        Context applicationContext = activity.getApplicationContext();
        k.a((Object) applicationContext, "activity!!.applicationContext");
        g gVar = g.f17850a;
        ChequeBookNames chequeBookNames = this.f17830b;
        if (chequeBookNames == null) {
            k.a();
        }
        this.f17834g = new a(applicationContext, g.a(chequeBookNames), this);
        RecyclerView recyclerView = (RecyclerView) a(R.id.namesRecyclerView);
        k.a((Object) recyclerView, "namesRecyclerView");
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            k.a();
        }
        k.a((Object) activity2, "activity!!");
        recyclerView.setLayoutManager(new LinearLayoutManager(activity2.getApplicationContext()));
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.namesRecyclerView);
        k.a((Object) recyclerView2, "namesRecyclerView");
        a aVar = this.f17834g;
        if (aVar == null) {
            k.a("itemSelectionAdapter");
        }
        recyclerView2.setAdapter(aVar);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_cross_view);
        if (imageView != null) {
            imageView.setOnClickListener(new d(this));
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f17840a;

        d(b bVar) {
            this.f17840a = bVar;
        }

        public final void onClick(View view) {
            this.f17840a.dismiss();
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        x.e eVar = new x.e();
        T onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        eVar.element = onCreateDialog;
        ((Dialog) eVar.element).setOnShowListener(new C0288b(this, eVar));
        return (Dialog) eVar.element;
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.b$b  reason: collision with other inner class name */
    public static final class C0288b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f17837a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f17838b;

        C0288b(b bVar, x.e eVar) {
            this.f17837a = bVar;
            this.f17838b = eVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            FrameLayout frameLayout = (FrameLayout) ((Dialog) this.f17838b.element).findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if (frameLayout == null) {
                k.a();
            }
            BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
            k.a((Object) from, "BottomSheetBehavior.from(bottomSheet!!)");
            if (from != null) {
                Context context = this.f17837a.getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                k.c(context, "context");
                Resources resources = context.getResources();
                k.a((Object) resources, "context.resources");
                from.setPeekHeight((int) TypedValue.applyDimension(1, 700.0f, resources.getDisplayMetrics()));
            }
        }
    }

    public final void a(int i2, String str, String str2) {
        k.c(str, "type");
        k.c(str2, "name");
        this.f17832d = Integer.valueOf(i2);
        this.f17835h = str;
        this.f17833e = str2;
    }

    public final int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f17836i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

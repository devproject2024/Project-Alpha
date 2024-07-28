package com.paytm.paymentsettings.paytmassist.view.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.paymentsettings.R;
import com.paytm.paymentsettings.common.widget.CircularImageView;
import com.paytm.paymentsettings.paytmassist.model.BankUserName;
import com.paytm.paymentsettings.paytmassist.view.ui.a;
import com.squareup.picasso.aa;
import com.squareup.picasso.w;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class a extends RecyclerView.a<C0742a> {

    /* renamed from: a  reason: collision with root package name */
    com.paytm.paymentsettings.paytmassist.view.ui.a f43526a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<BankUserName> f43527b;

    /* renamed from: c  reason: collision with root package name */
    final com.paytm.paymentsettings.paytmassist.model.b f43528c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f43529d;

    /* renamed from: e  reason: collision with root package name */
    private final j f43530e;

    public a(Context context, ArrayList<BankUserName> arrayList, j jVar, com.paytm.paymentsettings.paytmassist.model.b bVar) {
        k.c(context, "context");
        k.c(arrayList, "list");
        k.c(jVar, "fragmentManager");
        k.c(bVar, "adapterListener");
        this.f43529d = context;
        this.f43527b = arrayList;
        this.f43530e = jVar;
        this.f43528c = bVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ArrayList<String> mUserNameList;
        C0742a aVar = (C0742a) vVar;
        k.c(aVar, "holder");
        BankUserName bankUserName = this.f43527b.get(i2);
        TextView textView = aVar.f43532b;
        String str = null;
        if (textView != null) {
            Context context = this.f43529d;
            int i3 = R.string.bank_name_text;
            Object[] objArr = new Object[2];
            objArr[0] = bankUserName != null ? bankUserName.getMBankName() : null;
            objArr[1] = (bankUserName == null || (mUserNameList = bankUserName.getMUserNameList()) == null) ? null : Integer.valueOf(mUserNameList.size());
            textView.setText(context.getString(i3, objArr));
        }
        aa a2 = w.a().a(bankUserName != null ? bankUserName.getMBankLogoUrl() : null);
        Drawable a3 = androidx.core.content.b.a(this.f43529d, R.drawable.img_no_active_subscriptions);
        if (a3 == null) {
            k.a();
        }
        a2.b(a3).a((ImageView) aVar.f43531a);
        if (bankUserName == null || !bankUserName.isSelected()) {
            ImageView imageView = aVar.f43533c;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.ic_arrow_down_24px);
            }
        } else {
            ImageView imageView2 = aVar.f43533c;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.ic_arrow_up_24px);
            }
        }
        ImageView imageView3 = aVar.f43533c;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new b(bankUserName, aVar));
        }
        Boolean valueOf = bankUserName != null ? Boolean.valueOf(bankUserName.isSelected()) : null;
        if (valueOf == null) {
            k.a();
        }
        int i4 = valueOf.booleanValue() ? 0 : 8;
        ArrayList<String> mUserNameList2 = bankUserName.getMUserNameList();
        Integer valueOf2 = mUserNameList2 != null ? Integer.valueOf(mUserNameList2.size()) : null;
        if (valueOf2 != null && valueOf2.intValue() == 0) {
            LinearLayout linearLayout = aVar.f43534d;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else if (valueOf2 != null && valueOf2.intValue() == 1) {
            LinearLayout linearLayout2 = aVar.f43534d;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(i4);
            }
            LinearLayout linearLayout3 = aVar.f43535e;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            TextView textView2 = aVar.j;
            if (textView2 != null) {
                ArrayList<String> mUserNameList3 = bankUserName.getMUserNameList();
                if (mUserNameList3 != null) {
                    str = mUserNameList3.get(0);
                }
                textView2.setText(str);
            }
            ImageView imageView4 = aVar.m;
            if (imageView4 != null) {
                imageView4.setOnClickListener(new c(this, bankUserName, i2, aVar));
            }
            View view = aVar.f43538h;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = aVar.f43539i;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            LinearLayout linearLayout4 = aVar.f43536f;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
            LinearLayout linearLayout5 = aVar.f43537g;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
        } else if (valueOf2 != null && valueOf2.intValue() == 2) {
            LinearLayout linearLayout6 = aVar.f43534d;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(i4);
            }
            LinearLayout linearLayout7 = aVar.f43535e;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(0);
            }
            TextView textView3 = aVar.j;
            if (textView3 != null) {
                ArrayList<String> mUserNameList4 = bankUserName.getMUserNameList();
                textView3.setText(mUserNameList4 != null ? mUserNameList4.get(0) : null);
            }
            ImageView imageView5 = aVar.m;
            if (imageView5 != null) {
                imageView5.setOnClickListener(new d(this, bankUserName, i2, aVar));
            }
            View view3 = aVar.f43538h;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            LinearLayout linearLayout8 = aVar.f43536f;
            if (linearLayout8 != null) {
                linearLayout8.setVisibility(0);
            }
            TextView textView4 = aVar.k;
            if (textView4 != null) {
                ArrayList<String> mUserNameList5 = bankUserName.getMUserNameList();
                if (mUserNameList5 != null) {
                    str = mUserNameList5.get(1);
                }
                textView4.setText(str);
            }
            ImageView imageView6 = aVar.n;
            if (imageView6 != null) {
                imageView6.setOnClickListener(new e(this, bankUserName, i2, aVar));
            }
            View view4 = aVar.f43539i;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            LinearLayout linearLayout9 = aVar.f43537g;
            if (linearLayout9 != null) {
                linearLayout9.setVisibility(8);
            }
        } else if (valueOf2 != null && valueOf2.intValue() == 3) {
            LinearLayout linearLayout10 = aVar.f43534d;
            if (linearLayout10 != null) {
                linearLayout10.setVisibility(i4);
            }
            LinearLayout linearLayout11 = aVar.f43535e;
            if (linearLayout11 != null) {
                linearLayout11.setVisibility(0);
            }
            TextView textView5 = aVar.j;
            if (textView5 != null) {
                ArrayList<String> mUserNameList6 = bankUserName.getMUserNameList();
                textView5.setText(mUserNameList6 != null ? mUserNameList6.get(0) : null);
            }
            ImageView imageView7 = aVar.m;
            if (imageView7 != null) {
                imageView7.setOnClickListener(new f(this, bankUserName, i2, aVar));
            }
            View view5 = aVar.f43538h;
            if (view5 != null) {
                view5.setVisibility(0);
            }
            LinearLayout linearLayout12 = aVar.f43536f;
            if (linearLayout12 != null) {
                linearLayout12.setVisibility(0);
            }
            TextView textView6 = aVar.k;
            if (textView6 != null) {
                ArrayList<String> mUserNameList7 = bankUserName.getMUserNameList();
                textView6.setText(mUserNameList7 != null ? mUserNameList7.get(1) : null);
            }
            ImageView imageView8 = aVar.n;
            if (imageView8 != null) {
                imageView8.setOnClickListener(new g(this, bankUserName, i2, aVar));
            }
            View view6 = aVar.f43539i;
            if (view6 != null) {
                view6.setVisibility(0);
            }
            LinearLayout linearLayout13 = aVar.f43537g;
            if (linearLayout13 != null) {
                linearLayout13.setVisibility(0);
            }
            TextView textView7 = aVar.l;
            if (textView7 != null) {
                ArrayList<String> mUserNameList8 = bankUserName.getMUserNameList();
                if (mUserNameList8 != null) {
                    str = mUserNameList8.get(2);
                }
                textView7.setText(str);
            }
            ImageView imageView9 = aVar.o;
            if (imageView9 != null) {
                imageView9.setOnClickListener(new h(this, bankUserName, i2, aVar));
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_bank_parent_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new C0742a(this, inflate);
    }

    public final int getItemCount() {
        if (this.f43527b.size() == 0) {
            this.f43528c.a(true);
        } else {
            this.f43528c.a(false);
        }
        return this.f43527b.size();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankUserName f43540a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C0742a f43541b;

        b(BankUserName bankUserName, C0742a aVar) {
            this.f43540a = bankUserName;
            this.f43541b = aVar;
        }

        public final void onClick(View view) {
            BankUserName bankUserName = this.f43540a;
            if (bankUserName != null) {
                Boolean valueOf = bankUserName != null ? Boolean.valueOf(bankUserName.isSelected()) : null;
                if (valueOf == null) {
                    k.a();
                }
                bankUserName.setSelected(!valueOf.booleanValue());
            }
            if (this.f43540a.isSelected()) {
                LinearLayout linearLayout = this.f43541b.f43534d;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                this.f43541b.f43533c.setImageResource(R.drawable.ic_arrow_up_24px);
                return;
            }
            LinearLayout linearLayout2 = this.f43541b.f43534d;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            this.f43541b.f43533c.setImageResource(R.drawable.ic_arrow_down_24px);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43542a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BankUserName f43543b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43544c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C0742a f43545d;

        c(a aVar, BankUserName bankUserName, int i2, C0742a aVar2) {
            this.f43542a = aVar;
            this.f43543b = bankUserName;
            this.f43544c = i2;
            this.f43545d = aVar2;
        }

        public final void onClick(View view) {
            a.a(this.f43542a, this.f43543b, 1, this.f43544c, this.f43545d);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43546a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BankUserName f43547b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43548c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C0742a f43549d;

        d(a aVar, BankUserName bankUserName, int i2, C0742a aVar2) {
            this.f43546a = aVar;
            this.f43547b = bankUserName;
            this.f43548c = i2;
            this.f43549d = aVar2;
        }

        public final void onClick(View view) {
            a.a(this.f43546a, this.f43547b, 1, this.f43548c, this.f43549d);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43550a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BankUserName f43551b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43552c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C0742a f43553d;

        e(a aVar, BankUserName bankUserName, int i2, C0742a aVar2) {
            this.f43550a = aVar;
            this.f43551b = bankUserName;
            this.f43552c = i2;
            this.f43553d = aVar2;
        }

        public final void onClick(View view) {
            a.a(this.f43550a, this.f43551b, 2, this.f43552c, this.f43553d);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43554a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BankUserName f43555b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43556c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C0742a f43557d;

        f(a aVar, BankUserName bankUserName, int i2, C0742a aVar2) {
            this.f43554a = aVar;
            this.f43555b = bankUserName;
            this.f43556c = i2;
            this.f43557d = aVar2;
        }

        public final void onClick(View view) {
            a.a(this.f43554a, this.f43555b, 1, this.f43556c, this.f43557d);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43558a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BankUserName f43559b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43560c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C0742a f43561d;

        g(a aVar, BankUserName bankUserName, int i2, C0742a aVar2) {
            this.f43558a = aVar;
            this.f43559b = bankUserName;
            this.f43560c = i2;
            this.f43561d = aVar2;
        }

        public final void onClick(View view) {
            a.a(this.f43558a, this.f43559b, 2, this.f43560c, this.f43561d);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43562a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BankUserName f43563b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43564c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C0742a f43565d;

        h(a aVar, BankUserName bankUserName, int i2, C0742a aVar2) {
            this.f43562a = aVar;
            this.f43563b = bankUserName;
            this.f43564c = i2;
            this.f43565d = aVar2;
        }

        public final void onClick(View view) {
            a.a(this.f43562a, this.f43563b, 3, this.f43564c, this.f43565d);
        }
    }

    /* renamed from: com.paytm.paymentsettings.paytmassist.view.a.a$a  reason: collision with other inner class name */
    public final class C0742a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final CircularImageView f43531a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f43532b;

        /* renamed from: c  reason: collision with root package name */
        final ImageView f43533c;

        /* renamed from: d  reason: collision with root package name */
        final LinearLayout f43534d;

        /* renamed from: e  reason: collision with root package name */
        final LinearLayout f43535e;

        /* renamed from: f  reason: collision with root package name */
        final LinearLayout f43536f;

        /* renamed from: g  reason: collision with root package name */
        final LinearLayout f43537g;

        /* renamed from: h  reason: collision with root package name */
        final View f43538h;

        /* renamed from: i  reason: collision with root package name */
        final View f43539i;
        final TextView j;
        final TextView k;
        final TextView l;
        final ImageView m;
        final ImageView n;
        final ImageView o;
        final /* synthetic */ a p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0742a(a aVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.p = aVar;
            this.f43531a = (CircularImageView) view.findViewById(R.id.civ_bank_logo_parent_pas);
            this.f43532b = (TextView) view.findViewById(R.id.tv_bank_name_parent_pas);
            this.f43533c = (ImageView) view.findViewById(R.id.iv_show_hide_list_parent_pas);
            this.f43534d = (LinearLayout) view.findViewById(R.id.ll_child_item);
            this.f43535e = (LinearLayout) view.findViewById(R.id.ll_userId_group_1);
            this.f43536f = (LinearLayout) view.findViewById(R.id.ll_userId_group_2);
            this.f43537g = (LinearLayout) view.findViewById(R.id.ll_userId_group_3);
            this.f43538h = view.findViewById(R.id.v_seperator_1_parent_item);
            this.f43539i = view.findViewById(R.id.v_seperator_2_parent_item);
            this.j = (TextView) view.findViewById(R.id.tv_user_name_1_pas);
            this.k = (TextView) view.findViewById(R.id.tv_user_name_2_pas);
            this.l = (TextView) view.findViewById(R.id.tv_user_name_3_pas);
            this.m = (ImageView) view.findViewById(R.id.iv_delete_user_name_1_pas);
            this.n = (ImageView) view.findViewById(R.id.iv_delete_user_name_2_pas);
            this.o = (ImageView) view.findViewById(R.id.iv_delete_user_name_3_pas);
        }
    }

    public static final class i implements com.paytm.paymentsettings.paytmassist.model.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43566a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f43567b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43568c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BankUserName f43569d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C0742a f43570e;

        public final void onDismiss() {
        }

        i(a aVar, int i2, int i3, BankUserName bankUserName, C0742a aVar2) {
            this.f43566a = aVar;
            this.f43567b = i2;
            this.f43568c = i3;
            this.f43569d = bankUserName;
            this.f43570e = aVar2;
        }

        public final void onNegative() {
            com.paytm.paymentsettings.paytmassist.view.ui.a aVar = this.f43566a.f43526a;
            if (aVar != null) {
                aVar.dismiss();
            }
        }

        public final void onPositive() {
            ArrayList<String> mUserNameList;
            com.paytm.paymentsettings.paytmassist.model.b bVar = this.f43566a.f43528c;
            ArrayList<String> mUserNameList2 = this.f43566a.f43527b.get(this.f43567b).getMUserNameList();
            bVar.a(mUserNameList2 != null ? mUserNameList2.get(this.f43568c - 1) : null, this.f43566a.f43527b.get(this.f43567b).getMBankChannelCode());
            ArrayList<String> mUserNameList3 = this.f43566a.f43527b.get(this.f43567b).getMUserNameList();
            if (mUserNameList3 != null) {
                mUserNameList3.remove(this.f43568c - 1);
            }
            a aVar = this.f43566a;
            BankUserName bankUserName = this.f43569d;
            int i2 = this.f43567b;
            k.c(this.f43570e, "holder");
            if (!(bankUserName == null || (mUserNameList = bankUserName.getMUserNameList()) == null || mUserNameList.size() != 0)) {
                aVar.f43527b.remove(i2);
                aVar.notifyDataSetChanged();
            }
            if (aVar.f43527b.size() == 0) {
                aVar.f43528c.a(true);
            } else {
                aVar.f43528c.a(false);
            }
            this.f43566a.notifyItemChanged(this.f43567b);
            com.paytm.paymentsettings.paytmassist.view.ui.a aVar2 = this.f43566a.f43526a;
            if (aVar2 != null) {
                aVar2.dismiss();
            }
        }
    }

    public static final /* synthetic */ void a(a aVar, BankUserName bankUserName, int i2, int i3, C0742a aVar2) {
        a.C0743a aVar3 = com.paytm.paymentsettings.paytmassist.view.ui.a.f43581a;
        aVar.f43526a = a.C0743a.a("delete_nb_username", new i(aVar, i3, i2, bankUserName, aVar2));
        com.paytm.paymentsettings.paytmassist.view.ui.a aVar4 = aVar.f43526a;
        if (aVar4 != null) {
            aVar4.show(aVar.f43530e, "delete_nb_username");
        }
    }
}

package net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<d> f17822a;

    /* renamed from: b  reason: collision with root package name */
    final C0287a f17823b;

    /* renamed from: c  reason: collision with root package name */
    int f17824c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f17825d;

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.a$a  reason: collision with other inner class name */
    public interface C0287a {
        void a(int i2, String str, String str2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        Context context = this.f17825d;
        d dVar = this.f17822a.get(i2);
        k.a((Object) dVar, "dataList[position]");
        d dVar2 = dVar;
        k.c(context, "context");
        k.c(dVar2, "itemSelectionModel");
        View view = bVar.itemView;
        k.a((Object) view, "itemView");
        RoboTextView roboTextView = (RoboTextView) view.findViewById(R.id.nameToBePrintText);
        k.a((Object) roboTextView, "itemView.nameToBePrintText");
        roboTextView.setText(dVar2.f17848c);
        if (dVar2.f17849d) {
            View view2 = bVar.itemView;
            k.a((Object) view2, "itemView");
            RadioButton radioButton = (RadioButton) view2.findViewById(R.id.selectedRadioButton);
            k.a((Object) radioButton, "itemView.selectedRadioButton");
            radioButton.setChecked(true);
            View view3 = bVar.itemView;
            k.a((Object) view3, "itemView");
            ((RoboTextView) view3.findViewById(R.id.nameToBePrintText)).setFontType(3);
        } else {
            View view4 = bVar.itemView;
            k.a((Object) view4, "itemView");
            RadioButton radioButton2 = (RadioButton) view4.findViewById(R.id.selectedRadioButton);
            k.a((Object) radioButton2, "itemView.selectedRadioButton");
            radioButton2.setChecked(false);
            View view5 = bVar.itemView;
            k.a((Object) view5, "itemView");
            ((RoboTextView) view5.findViewById(R.id.nameToBePrintText)).setFontType(2);
        }
        bVar.itemView.setOnClickListener(new c(this, i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "p0");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_sheet_item_selection_item_view, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(p0.c…      false\n            )");
        return new b(inflate);
    }

    public a(Context context, ArrayList<d> arrayList, C0287a aVar) {
        k.c(context, "context");
        k.c(arrayList, "dataList");
        k.c(aVar, "itemClickListener");
        this.f17825d = context;
        this.f17822a = arrayList;
        this.f17823b = aVar;
    }

    public final int getItemCount() {
        return this.f17822a.size();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f17826a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f17827b;

        c(a aVar, int i2) {
            this.f17826a = aVar;
            this.f17827b = i2;
        }

        public final void onClick(View view) {
            C0287a aVar = this.f17826a.f17823b;
            Integer num = this.f17826a.f17822a.get(this.f17827b).f17846a;
            if (num == null) {
                k.a();
            }
            int intValue = num.intValue();
            String str = this.f17826a.f17822a.get(this.f17827b).f17847b;
            if (str == null) {
                k.a();
            }
            String str2 = this.f17826a.f17822a.get(this.f17827b).f17848c;
            if (str2 == null) {
                k.a();
            }
            aVar.a(intValue, str, str2);
            this.f17826a.f17822a.get(this.f17827b).f17849d = true;
            this.f17826a.notifyItemChanged(this.f17827b);
            if (this.f17826a.f17824c != this.f17827b) {
                this.f17826a.f17822a.get(this.f17826a.f17824c).f17849d = false;
                a aVar2 = this.f17826a;
                aVar2.notifyItemChanged(aVar2.f17824c);
                this.f17826a.f17824c = this.f17827b;
            }
        }
    }

    public static final class b extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }
}

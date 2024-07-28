package net.one97.paytm.paymentsBank.slfd.tds.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;

public class c extends f {

    /* renamed from: a  reason: collision with root package name */
    public d f19372a;

    /* renamed from: b  reason: collision with root package name */
    private int f19373b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f19374c = 2;

    public final void a(d dVar) {
        this.f19372a = dVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_tds_fin_year_bsdf, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.fl_financial_year_cont);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_close);
        String string = getArguments().getString("title");
        if (!TextUtils.isEmpty(string)) {
            ((TextView) inflate.findViewById(R.id.tv_title)).setText(string);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.a(view);
            }
        });
        String string2 = getArguments().getString("selectedYear");
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), getArguments().getInt("columnCount")));
        b bVar = new b(getActivity(), (ArrayList) getArguments().getSerializable("year_list"), new d() {
            public final void onFragmentAction(int i2, Object obj) {
                c.this.a(i2, obj);
            }
        }, string2);
        if (getArguments().containsKey("shape")) {
            bVar.f19366d = getArguments().getInt("shape");
        }
        recyclerView.setAdapter(bVar);
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (getDialog() != null) {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, Object obj) {
        d dVar = this.f19372a;
        if (dVar != null) {
            dVar.onFragmentAction(i2, obj);
        }
        dismiss();
    }

    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }
}

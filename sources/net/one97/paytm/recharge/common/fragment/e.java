package net.one97.paytm.recharge.common.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.squareup.picasso.w;
import net.one97.paytm.common.widgets.l;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.b.c;
import net.one97.paytm.recharge.b.k;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2;

public class e extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61160a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public String f61161b;

    /* renamed from: c  reason: collision with root package name */
    public k f61162c;

    /* renamed from: d  reason: collision with root package name */
    public a f61163d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public CJRUtilityAlertV2 f61164e;

    public interface a {
        void b(boolean z);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.f61163d = (a) context;
        } else if (getParentFragment() instanceof a) {
            this.f61163d = (a) getParentFragment();
        }
    }

    public static e a(boolean z, CJRUtilityAlertV2 cJRUtilityAlertV2, String str) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("recharge_item", cJRUtilityAlertV2);
        bundle.putString(CLPConstants.PRODUCT_ID, str);
        bundle.putBoolean("Verify", z);
        e eVar = new e();
        eVar.setArguments(bundle);
        return eVar;
    }

    public void show(j jVar, String str) {
        if (jVar != null) {
            try {
                q a2 = jVar.a();
                a2.a((Fragment) this, str);
                a2.c();
            } catch (Exception e2) {
                com.paytm.utility.q.d(e2.getMessage());
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f61164e = (CJRUtilityAlertV2) getArguments().getSerializable("recharge_item");
        this.f61161b = getArguments().getString(CLPConstants.PRODUCT_ID);
        this.f61162c = (k) androidx.databinding.f.a(layoutInflater, R.layout.fragment_alert_bottom_sheet, viewGroup, false);
        this.f61162c.a(this.f61164e);
        this.f61162c.a(this);
        this.f61162c.f60353g.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f61162c.f60353g.addItemDecoration(new l(getContext()));
        this.f61162c.f60353g.setAdapter(new RecyclerView.a<net.one97.paytm.recharge.automatic.a.a>() {
            public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
                net.one97.paytm.recharge.automatic.a.a aVar = (net.one97.paytm.recharge.automatic.a.a) vVar;
                ((c) aVar.f60227a).a(e.this.f61164e.getRich_message().get(i2));
                w.a().a(e.this.f61164e.getRich_message().get(i2).getImage()).a(((c) aVar.f60227a).f60316b, (com.squareup.picasso.e) null);
            }

            public final int getItemCount() {
                return e.this.f61164e.getRich_message().size();
            }

            public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
                return new net.one97.paytm.recharge.automatic.a.a(androidx.databinding.f.a(e.this.getLayoutInflater(), R.layout.alert_item, viewGroup, false));
            }
        });
        String message = this.f61164e.getMessage();
        if (!TextUtils.isEmpty(message) && message.contains("\\n")) {
            for (String text : message.replace("\\n", "line_break").split("line_break")) {
                View inflate = getLayoutInflater().inflate(R.layout.alert_dialog_bullet, this.f61162c.f60349c, false);
                ((TextView) inflate.findViewById(R.id.bullet_text)).setText(text);
                this.f61162c.f60349c.addView(inflate);
            }
        }
        return this.f61162c.getRoot();
    }

    public static boolean a(CJRUtilityAlertV2 cJRUtilityAlertV2) {
        String message = cJRUtilityAlertV2.getMessage();
        return !TextUtils.isEmpty(message) && message.contains("\\n");
    }

    public void onDetach() {
        super.onDetach();
        this.f61163d = null;
    }
}

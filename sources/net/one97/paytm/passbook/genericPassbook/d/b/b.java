package net.one97.paytm.passbook.genericPassbook.d.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.f;
import net.one97.paytm.passbook.statementDownload.StatementDownloadActivity;
import net.one97.paytm.passbook.utility.n;

public final class b extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private int f57469a;

    /* renamed from: b  reason: collision with root package name */
    private View.OnClickListener f57470b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f57471c;

    public final View a(int i2) {
        if (this.f57471c == null) {
            this.f57471c = new HashMap();
        }
        View view = (View) this.f57471c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f57471c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public b() {
        super(R.layout.fragment_subwallet_cta);
        this.f57469a = -1;
        this.f57470b = new a(this);
    }

    public b(int i2) {
        this();
        this.f57469a = i2;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (this.f57469a == n.TOLL.getValue()) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.tollCTALayout);
            k.a((Object) linearLayout, "tollCTALayout");
            linearLayout.setVisibility(0);
        }
        ((RelativeLayout) a(R.id.rl_manage_toll_tags)).setOnClickListener(this.f57470b);
        ((RelativeLayout) a(R.id.rl_download_statement_toll_tags)).setOnClickListener(this.f57470b);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f57472a;

        a(b bVar) {
            this.f57472a = bVar;
        }

        public final void onClick(View view) {
            if (k.a((Object) view, (Object) (RelativeLayout) this.f57472a.a(R.id.rl_manage_toll_tags))) {
                b.a(this.f57472a);
                b.b(this.f57472a);
            } else if (k.a((Object) view, (Object) (RelativeLayout) this.f57472a.a(R.id.rl_download_statement_toll_tags))) {
                k.a((Object) view, "it");
                Intent intent = new Intent(view.getContext(), StatementDownloadActivity.class);
                intent.putExtra("header_title", this.f57472a.getString(R.string.fastag_download_statement));
                intent.putExtra("CallingFragment", "TransactionTollPassageHistoryFragment");
                this.f57472a.startActivityForResult(intent, 131);
            }
        }
    }

    public static final /* synthetic */ void a(b bVar) {
        Map hashMap = new HashMap();
        hashMap.put("event_category", "wallet_passbook_toll");
        hashMap.put("event_action", "manage_toll_tags_clicked");
        hashMap.put("user_id", Boolean.valueOf(new ArrayList().add(com.paytm.utility.b.n(bVar.getContext()))));
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "passbook screen");
        hashMap.put("vertical_name", "fastag");
        f b2 = d.b();
        bVar.getContext();
        b2.a((Map<String, Object>) hashMap);
    }

    public static final /* synthetic */ void b(b bVar) {
        String a2 = d.b().a("passManageFastagDeeplink");
        if (!TextUtils.isEmpty(a2)) {
            f b2 = d.b();
            Context context = bVar.getContext();
            if (context != null) {
                b2.a(a2, (Activity) context);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f57471c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

package net.one97.paytm.moneytransfer.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.one97.paytm.i.h;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.upi.util.CJRGTMConstants;

public class m extends h {

    /* renamed from: a  reason: collision with root package name */
    private String f54543a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f54544b = "";

    /* renamed from: c  reason: collision with root package name */
    private TextView f54545c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f54546d;

    public static m a(String str) {
        m mVar = new m();
        Bundle bundle = new Bundle();
        bundle.putString("offer_text", str);
        mVar.setArguments(bundle);
        return mVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.offer_title_fragment, viewGroup, false);
        this.f54545c = (TextView) inflate.findViewById(R.id.offerTv);
        this.f54546d = (ImageView) inflate.findViewById(R.id.offer_iv);
        ((RelativeLayout) inflate.findViewById(R.id.parent_layout)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                m.this.a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (!TextUtils.isEmpty(this.f54543a)) {
            Intent intent = null;
            try {
                intent = new Intent(getActivity(), Class.forName(d.c().f()));
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
            intent.putExtra("url", this.f54543a);
            startActivity(intent);
            f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "offer_strip_clicked", CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "", "");
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getArguments() != null) {
            String string = getArguments().getString("offer_text");
            if (!TextUtils.isEmpty(string)) {
                ArrayList arrayList = new ArrayList(Arrays.asList(string.split("\\$")));
                if (!TextUtils.isEmpty((CharSequence) arrayList.get(0))) {
                    this.f54545c.setText((CharSequence) arrayList.get(0));
                }
                if (a(arrayList, 1) && !TextUtils.isEmpty((CharSequence) arrayList.get(1))) {
                    this.f54543a = (String) arrayList.get(1);
                }
                if (!a(arrayList, 2) || TextUtils.isEmpty((CharSequence) arrayList.get(2))) {
                    this.f54546d.setImageResource(R.drawable.announcement);
                    return;
                }
                this.f54544b = (String) arrayList.get(2);
                w.a().a(this.f54544b).a(getActivity().getResources().getDrawable(R.drawable.announcement)).b(R.drawable.announcement).a(this.f54546d, (e) null);
            }
        }
    }

    private static boolean a(List list, int i2) {
        return i2 >= 0 && i2 < list.size();
    }
}

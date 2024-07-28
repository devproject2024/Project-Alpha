package net.one97.paytm.p2mNewDesign.PaymentOptions.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;
import net.one97.paytm.p2mNewDesign.a.e;
import net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2;
import net.one97.paytm.wallet.R;

public final class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.p2mNewDesign.PaymentOptions.b.a f13079a;

    /* renamed from: b  reason: collision with root package name */
    private Context f13080b;

    /* renamed from: c  reason: collision with root package name */
    private List<PayChannelOptionsV2> f13081c;

    /* renamed from: d  reason: collision with root package name */
    private int f13082d;

    public a(Context context, List<PayChannelOptionsV2> list, int i2, net.one97.paytm.p2mNewDesign.PaymentOptions.b.a aVar) {
        super(context);
        this.f13080b = context;
        this.f13081c = list;
        this.f13079a = aVar;
        this.f13082d = i2;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.selectbank_dialog_layout);
        ListView listView = (ListView) findViewById(R.id.selectbank_dialog_lv);
        final e eVar = new e(this.f13081c, this.f13080b, this.f13079a, this.f13082d);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                e eVar = eVar;
                eVar.f13173a.a(eVar.getItem(i2), i2);
            }
        });
        listView.setAdapter(eVar);
    }
}

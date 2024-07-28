package net.one97.paytm.wallet.newdesign.independencedaypostcard;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRPostcardCreateEvent;
import net.one97.paytm.common.entity.wallet.CJRPostcardSentData;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.f.i;
import net.one97.paytm.wallet.f.j;
import net.one97.paytm.wallet.newdesign.utils.IndependentImageDownloadManager;
import org.json.JSONObject;

public class b extends h implements View.OnClickListener, j {

    /* renamed from: a  reason: collision with root package name */
    ImageView f70963a;

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.wallet.d.h f70964b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f70965c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f70966d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f70967e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f70968f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f70969g;

    /* renamed from: h  reason: collision with root package name */
    private String f70970h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f70971i;
    private TextView j;
    private TranslateAnimation k;
    private CJRQRScanResultModel l;
    private Context m;

    public interface a {
        void a(CJRPostcardSentData cJRPostcardSentData);
    }

    public static b a(String str, String str2) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("amount", str);
        bundle.putString("key_scan_result", str2);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getArguments() != null) {
                this.f70969g = getArguments().getString("amount");
                this.f70970h = getArguments().getString("key_scan_result");
                JSONObject jSONObject = new JSONObject(this.f70970h);
                this.l = new CJRQRScanResultModel();
                this.l.parseData(jSONObject, (Context) getActivity());
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_postcard_sending_independence, viewGroup, false);
        try {
            this.f70966d = (ImageView) inflate.findViewById(R.id.iv_envelope);
            this.j = (TextView) inflate.findViewById(R.id.tv_transaction_status);
            this.f70967e = (ImageView) inflate.findViewById(R.id.iv_transaction_status);
            this.f70963a = (ImageView) inflate.findViewById(R.id.iv_back_button);
            this.f70971i = (RelativeLayout) inflate.findViewById(R.id.rl_go_back);
            this.f70968f = (ImageView) inflate.findViewById(R.id.iv_transaction_fail);
            try {
                getActivity().getWindowManager().getDefaultDisplay().getWidth();
                this.k = new TranslateAnimation(0.0f, 0.0f, -10.0f, 10.0f);
                this.k.setDuration(500);
                this.k.setRepeatCount(-1);
                this.k.setRepeatMode(2);
                this.f70966d.startAnimation(this.k);
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
            this.f70963a.setOnClickListener(this);
            this.f70971i.setOnClickListener(this);
        } catch (Exception e3) {
            q.d(String.valueOf(e3));
        }
        try {
            new IndependentImageDownloadManager(getActivity()).download(net.one97.paytm.wallet.utility.a.c((Context) getActivity()), new IndependentImageDownloadManager.ImageDownloadListener() {
                public final void onDownloadFinished() {
                    b.c(b.this);
                }
            });
        } catch (Exception e4) {
            q.d(String.valueOf(e4));
        }
        return inflate;
    }

    private void a() {
        try {
            if (this.k != null) {
                this.k.cancel();
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.m = context;
        try {
            if (context instanceof a) {
                this.f70965c = (a) context;
            }
            if (this.f70964b == null) {
                this.f70964b = new net.one97.paytm.wallet.d.h();
            }
            this.f70964b.a((Activity) context, (i) new i() {
                public final void a() {
                }

                public final void b() {
                }

                public final void a(IJRDataModel iJRDataModel) {
                    net.one97.paytm.f.b.a().c();
                    b.this.a((IJRDataModel) null);
                }

                public final void a(String str) {
                    CJRPostcardCreateEvent cJRPostcardCreateEvent = new CJRPostcardCreateEvent();
                    cJRPostcardCreateEvent.setmStatusMessage(str);
                    b.this.b((IJRDataModel) cJRPostcardCreateEvent);
                }
            });
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f70965c = null;
    }

    public void onClick(View view) {
        try {
            if (view.getId() == R.id.iv_back_button) {
                getActivity().onBackPressed();
            } else if (view.getId() == R.id.rl_go_back) {
                getActivity().onBackPressed();
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public final void a(IJRDataModel iJRDataModel) {
        a();
        this.f70967e.setImageDrawable(getResources().getDrawable(R.drawable.success_postcard));
        this.j.setText(String.format(getString(R.string.postcard_successfully_sent), new Object[0]));
        this.f70967e.setVisibility(0);
        this.f70968f.setVisibility(4);
        b();
    }

    private void b() {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                if (b.this.getActivity() != null && !b.this.getActivity().isFinishing()) {
                    CJRPostcardSentData cJRPostcardSentData = new CJRPostcardSentData();
                    cJRPostcardSentData.setAmount(b.this.f70969g);
                    cJRPostcardSentData.setName(com.paytm.utility.b.h((Context) b.this.getActivity()));
                    b.this.f70965c.a(cJRPostcardSentData);
                }
            }
        }, 1000);
    }

    public final void b(IJRDataModel iJRDataModel) {
        a();
        this.f70963a.setVisibility(0);
        this.f70971i.setVisibility(0);
        this.f70967e.setVisibility(4);
        this.f70968f.setVisibility(0);
        this.f70968f.setImageDrawable(getResources().getDrawable(R.drawable.fail_postcard));
        if (iJRDataModel != null) {
            this.j.setText(((CJRPostcardCreateEvent) iJRDataModel).getStatusMessage());
        } else {
            this.j.setText(getString(R.string.title_400));
        }
        b();
    }

    public void onResume() {
        super.onResume();
    }

    static /* synthetic */ void c(b bVar) {
        if (bVar.f70964b != null) {
            CJRQRScanResultModel cJRQRScanResultModel = bVar.l;
            if (cJRQRScanResultModel != null && !TextUtils.isEmpty(cJRQRScanResultModel.getMobileNo())) {
                net.one97.paytm.wallet.utility.a.e(bVar.m, bVar.l.getMobileNo());
            }
            net.one97.paytm.f.b.a().a(bVar.m, bVar.l.getMerchantName(), bVar.l.getMobileNo(), false, net.one97.paytm.wallet.utility.h.P2M.getValue(), com.paytm.utility.b.s((Context) bVar.getActivity()), com.paytm.utility.b.t((Context) bVar.getActivity()));
            bVar.f70964b.a(bVar.l, String.valueOf(bVar.f70969g), "");
        }
    }
}

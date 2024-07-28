package com.travel.train.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.train.R;
import com.travel.train.b.w;
import com.travel.train.j.g;
import com.travel.train.j.n;
import com.travel.train.model.trainticket.CJRPNRMessage;
import com.travel.train.model.trainticket.CJRPNRStatus;
import com.travel.train.model.trainticket.CJRTrainCancellationResponse;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class r extends am implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f27136a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public w f27137b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CJRTrainCancellationResponse f27138c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27139d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f27140e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f27141f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f27142g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f27143h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f27144i;
    private Button j;
    private String k = null;
    private TextView l;

    public static r a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("intent_extra_page_title", str);
        bundle.putSerializable("url", str2);
        r rVar = new r();
        rVar.setArguments(bundle);
        return rVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f27136a = (String) getArguments().getSerializable("intent_extra_page_title");
            this.k = (String) getArguments().getSerializable("url");
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.f27139d = z;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pre_t_fragment_train_cancel_policy, viewGroup, false);
        this.l = (TextView) inflate.findViewById(R.id.train_toolbar_title);
        this.l.setText(getActivity().getResources().getString(R.string.cancellation_policy));
        this.f27141f = (ImageView) inflate.findViewById(R.id.train_toolbar_back_arrow);
        this.f27140e = (RecyclerView) inflate.findViewById(R.id.dummyfrag_scrollableview);
        this.f27142g = (RelativeLayout) inflate.findViewById(R.id.rl_progress_error_layout);
        this.f27143h = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        this.f27144i = (LinearLayout) inflate.findViewById(R.id.rv_error_layout);
        this.j = (Button) this.f27144i.findViewById(R.id.network_retry_btn);
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                r.this.a();
            }
        });
        this.f27141f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                r.this.a(view);
            }
        });
        a();
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        getActivity().onBackPressed();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        a(true);
        if (com.paytm.utility.b.c((Context) getActivity())) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getActivity().getApplicationContext();
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.m;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = this.k;
            bVar.f42882f = n.b(getContext());
            bVar.f42885i = new CJRTrainCancellationResponse();
            bVar.j = this;
            a l2 = bVar.l();
            l2.f42859c = false;
            l2.a();
            return;
        }
        NetworkCustomError networkCustomError = new NetworkCustomError();
        networkCustomError.setmAlertTitle(getResources().getString(R.string.title_connection_problem));
        networkCustomError.setAlertMessage(getResources().getString(R.string.msg_connection_problem));
        a(networkCustomError);
    }

    public final void a(final boolean z) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                public final void run() {
                    if (z) {
                        r.this.f27140e.setVisibility(8);
                        r.this.f27142g.setVisibility(0);
                        r.this.f27143h.setVisibility(0);
                        r.this.f27144i.setVisibility(8);
                        return;
                    }
                    r.this.f27140e.setVisibility(0);
                    r.this.f27142g.setVisibility(8);
                    r.this.f27143h.setVisibility(8);
                    r.this.f27144i.setVisibility(8);
                }
            });
        }
    }

    private void a(final NetworkCustomError networkCustomError) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                public final void run() {
                    r.this.f27140e.setVisibility(8);
                    r.this.f27142g.setVisibility(0);
                    r.this.f27143h.setVisibility(8);
                    r.this.f27144i.setVisibility(0);
                    if (!TextUtils.isEmpty(networkCustomError.getAlertTitle())) {
                        ((TextView) r.this.f27144i.findViewById(R.id.no_network_title)).setText(networkCustomError.getAlertTitle());
                    }
                    if (!TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                        ((TextView) r.this.f27144i.findViewById(R.id.no_network_message)).setText(networkCustomError.getAlertMessage());
                    }
                }
            });
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if ((getActivity() == null || !getActivity().isFinishing()) && (iJRPaytmDataModel instanceof CJRTrainCancellationResponse)) {
            this.f27138c = (CJRTrainCancellationResponse) iJRPaytmDataModel;
            if (this.f27138c.getStatus() != null) {
                CJRPNRStatus status = this.f27138c.getStatus();
                if (TextUtils.isEmpty(status.getmResult())) {
                    return;
                }
                if (status.getmResult().equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE)) {
                    CJRPNRMessage cJRPNRMessage = status.getmMessagePNR();
                    if (cJRPNRMessage != null) {
                        NetworkCustomError networkCustomError = new NetworkCustomError();
                        networkCustomError.setAlertMessage(cJRPNRMessage.getmMessage());
                        networkCustomError.setmAlertTitle(cJRPNRMessage.getmTitle());
                        a(networkCustomError);
                        return;
                    }
                    NetworkCustomError networkCustomError2 = new NetworkCustomError();
                    networkCustomError2.setmAlertTitle(getResources().getString(R.string.title_connection_problem));
                    networkCustomError2.setAlertMessage(getResources().getString(R.string.msg_connection_problem));
                    a(networkCustomError2);
                } else if (this.f27138c.getBody() == null || this.f27138c.getBody().getTemplates() == null || this.f27138c.getBody().getTemplates().size() <= 0) {
                    NetworkCustomError networkCustomError3 = new NetworkCustomError();
                    networkCustomError3.setmAlertTitle("Cancellation policies");
                    networkCustomError3.setAlertMessage("Not able to find any policies. Please retry again.");
                    a(networkCustomError3);
                } else if (getActivity() != null && !getActivity().isFinishing()) {
                    getActivity().runOnUiThread(new Runnable() {
                        public final void run() {
                            r.this.a(false);
                            r.this.f27140e.setLayoutManager(new LinearLayoutManager(r.this.getActivity().getBaseContext()));
                            r rVar = r.this;
                            w unused = rVar.f27137b = new w(rVar.getActivity(), r.this.f27138c.getBody().getTemplates());
                            r.this.f27140e.setAdapter(r.this.f27137b);
                        }
                    });
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (getActivity() == null || !getActivity().isFinishing()) {
            a(networkCustomError);
        }
    }
}

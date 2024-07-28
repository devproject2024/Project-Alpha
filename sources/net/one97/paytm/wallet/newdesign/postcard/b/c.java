package net.one97.paytm.wallet.newdesign.postcard.b;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.lifafa.ReceivedLifafaDetailsResponse;
import net.one97.paytm.i.h;
import net.one97.paytm.network.f;
import net.one97.paytm.wallet.R;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends h {

    /* renamed from: a  reason: collision with root package name */
    boolean f71263a;

    /* renamed from: b  reason: collision with root package name */
    String f71264b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public LottieAnimationView f71265c;

    /* renamed from: d  reason: collision with root package name */
    private b f71266d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public IJRDataModel f71267e;

    /* renamed from: f  reason: collision with root package name */
    private LottieAnimationView f71268f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f71269g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f71270h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f71271i;
    private TextView j;
    /* access modifiers changed from: private */
    public ImageView k;

    public interface a {
        void a(ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse);
    }

    public interface b {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getArguments() != null) {
                this.f71267e = (IJRDataModel) getArguments().getSerializable("data");
                this.f71263a = getArguments().getBoolean("from_deep_link", false);
                this.f71264b = getArguments().getString("lifafa_key", "");
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_post_card_animation_view, viewGroup, false);
        inflate.findViewById(R.id.iv_back_button).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.getActivity().onBackPressed();
            }
        });
        this.f71269g = (LinearLayout) inflate.findViewById(R.id.animation_ll);
        this.f71270h = (LinearLayout) inflate.findViewById(R.id.error_ll);
        this.f71270h.setVisibility(8);
        this.f71271i = (TextView) inflate.findViewById(R.id.error_tv);
        this.j = (TextView) inflate.findViewById(R.id.go_back_tv);
        this.k = (ImageView) inflate.findViewById(R.id.error_icon_iv);
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.getActivity().onBackPressed();
            }
        });
        this.f71265c = (LottieAnimationView) inflate.findViewById(R.id.loading_lifafa_lav);
        this.f71265c.setAnimation("lifafa_loading.json");
        this.f71265c.loop(true);
        this.f71268f = (LottieAnimationView) inflate.findViewById(R.id.open_lifafa_lav);
        this.f71268f.setVisibility(8);
        if (this.f71263a) {
            if (getActivity() != null && !getActivity().isFinishing()) {
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    String q = com.paytm.utility.a.q(getActivity());
                    if (!TextUtils.isEmpty(q)) {
                        net.one97.paytm.wallet.communicator.b.a().getWalletToken(q, getActivity(), new com.paytm.network.listener.b() {
                            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                c cVar = c.this;
                                if (cVar.getActivity() != null && !cVar.getActivity().isFinishing() && (iJRPaytmDataModel instanceof CJRPGTokenList)) {
                                    CJRPGTokenList cJRPGTokenList = (CJRPGTokenList) iJRPaytmDataModel;
                                    if (cVar.getActivity() != null && !cVar.getActivity().isFinishing()) {
                                        String pgToken = net.one97.paytm.wallet.communicator.b.a().getPgToken(cJRPGTokenList);
                                        if (TextUtils.isEmpty(pgToken)) {
                                            net.one97.paytm.wallet.communicator.b.a().showSessionTimeoutAlert(cVar.getActivity());
                                        } else if (cVar.f71263a) {
                                            cVar.f71265c.playAnimation();
                                            cVar.a(cVar.f71264b, pgToken);
                                        }
                                    }
                                }
                            }

                            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                c.this.a(networkCustomError);
                            }
                        });
                    } else {
                        net.one97.paytm.wallet.communicator.b.a().showSessionTimeoutAlert(getActivity());
                    }
                } else if (getActivity() != null && !getActivity().isFinishing()) {
                    net.one97.paytm.wallet.utility.a.a((Activity) getActivity());
                }
            }
        } else if (this.f71267e != null) {
            this.f71268f.setVisibility(0);
            this.f71265c.setVisibility(8);
            this.f71268f.setAnimation("lifafa_open.json");
            this.f71268f.addAnimatorListener(new Animator.AnimatorListener() {
                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            if (c.this.getActivity() != null && (c.this.getActivity() instanceof a)) {
                                ((a) c.this.getActivity()).a((ReceivedLifafaDetailsResponse) c.this.f71267e);
                            } else if (c.this.getActivity() != null && c.this.isResumed()) {
                                c.this.f71265c.setVisibility(8);
                                c.this.f71269g.setVisibility(8);
                                c.this.f71270h.setVisibility(0);
                                c.this.k.setImageResource(R.drawable.lifafa_fail_icon);
                                c.this.f71271i.setText(c.this.getString(R.string.some_went_wrong));
                            }
                        }
                    }, 500);
                }
            });
            this.f71268f.playAnimation();
        } else {
            this.f71265c.setVisibility(8);
            this.f71269g.setVisibility(8);
            this.f71270h.setVisibility(0);
            this.k.setImageResource(R.drawable.lifafa_fail_icon);
            this.f71271i.setText(getString(R.string.some_went_wrong));
        }
        return inflate;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if (context instanceof b) {
                this.f71266d = (b) context;
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f71266d = null;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2) {
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "lifafaEventProcessURL");
        String stringFromGTM2 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "lifafaEventDetailURL");
        if (URLUtil.isValidUrl(stringFromGTM) && URLUtil.isValidUrl(stringFromGTM2)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("lifafaKey", str);
                jSONObject.put("startOffset", "0");
                jSONObject.put("limit", "100");
                jSONObject2.put("lifafaKey", str);
            } catch (JSONException e2) {
                q.d(String.valueOf(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("ssotoken", str2);
            hashMap.put("Content-Type", "application/json");
            net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(stringFromGTM, new ReceivedLifafaDetailsResponse(), (Map<String, String>) null, hashMap, jSONObject.toString());
            if (com.paytm.utility.b.c((Context) getActivity())) {
                bVar.c().observeForever(new z(stringFromGTM2, hashMap, jSONObject) {
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ Map f$2;
                    private final /* synthetic */ JSONObject f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void onChanged(Object obj) {
                        c.this.a(this.f$1, this.f$2, this.f$3, (f) obj);
                    }
                });
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (networkCustomError != null && getActivity() != null) {
            if ((!TextUtils.isEmpty(networkCustomError.getMessage()) && networkCustomError.getStatusCode() == 410) || networkCustomError.getStatusCode() == 401) {
                net.one97.paytm.wallet.communicator.b.a().handleError(getActivity(), networkCustomError, (String) null, (Bundle) null, false);
            } else if (networkCustomError.getMessage() != null && !net.one97.paytm.wallet.communicator.b.a().checkErrorCode(getActivity(), networkCustomError)) {
                StringBuilder sb = new StringBuilder();
                sb.append(getResources().getString(R.string.network_error_message));
                sb.append(" ");
                sb.append(networkCustomError.getUrl());
                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                    com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                    return;
                }
                FragmentActivity activity = getActivity();
                String url = networkCustomError.getUrl();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(networkCustomError.getStatusCode());
                com.paytm.utility.b.d((Context) activity, url, sb2.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, Map map, JSONObject jSONObject, f fVar) {
        if (fVar.f55796a != net.one97.paytm.network.h.SUCCESS) {
            net.one97.paytm.network.h hVar = net.one97.paytm.network.h.ERROR;
        } else if (fVar.f55797b != null && (fVar.f55797b instanceof ReceivedLifafaDetailsResponse)) {
            ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse = (ReceivedLifafaDetailsResponse) fVar.f55797b;
            if (receivedLifafaDetailsResponse == null) {
                this.f71269g.setVisibility(8);
                this.f71270h.setVisibility(0);
                this.k.setImageResource(R.drawable.lifafa_fail_icon);
                this.f71271i.setText(getString(R.string.some_went_wrong));
            } else if (receivedLifafaDetailsResponse.getStatusCode() != null && (receivedLifafaDetailsResponse.getStatusCode().equals("FE_0000") || receivedLifafaDetailsResponse.getStatusCode().equals("CM_0000"))) {
                net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(str, new ReceivedLifafaDetailsResponse(), (Map<String, String>) null, map, jSONObject.toString());
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    bVar.c().observeForever(new z(receivedLifafaDetailsResponse) {
                        private final /* synthetic */ ReceivedLifafaDetailsResponse f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onChanged(Object obj) {
                            c.this.a(this.f$1, (f) obj);
                        }
                    });
                }
            } else if ((receivedLifafaDetailsResponse.getStatusCode() != null && receivedLifafaDetailsResponse.getStatusCode().equals("PE_0005")) || (receivedLifafaDetailsResponse.getStatusCode() != null && receivedLifafaDetailsResponse.getStatusCode().equals("EV_0014"))) {
                this.f71269g.setVisibility(8);
                this.f71270h.setVisibility(0);
                this.k.setImageResource(R.drawable.lifafa_expire_icon);
                this.f71271i.setText(receivedLifafaDetailsResponse.getStatusMessage());
            } else if (receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("EV_0041")) {
                this.f71269g.setVisibility(8);
                this.f71270h.setVisibility(0);
                this.k.setImageResource(R.drawable.lifafa_fail_icon);
                this.f71271i.setText(receivedLifafaDetailsResponse.getStatusMessage());
            } else {
                this.f71269g.setVisibility(8);
                this.f71270h.setVisibility(0);
                this.k.setImageResource(R.drawable.lifafaf_late_icon);
                this.f71271i.setText(receivedLifafaDetailsResponse.getStatusMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse, f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            if (fVar.f55797b != null && (fVar.f55797b instanceof ReceivedLifafaDetailsResponse)) {
                ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse2 = (ReceivedLifafaDetailsResponse) fVar.f55797b;
                this.f71267e = receivedLifafaDetailsResponse2;
                this.f71265c.cancelAnimation();
                this.f71265c.setVisibility(8);
                if (receivedLifafaDetailsResponse2 == null) {
                    this.f71269g.setVisibility(8);
                    this.f71270h.setVisibility(0);
                    this.k.setImageResource(R.drawable.lifafa_fail_icon);
                    this.f71271i.setText(getString(R.string.some_went_wrong));
                } else if (receivedLifafaDetailsResponse2.getStatusCode() != null && receivedLifafaDetailsResponse2.getStatusCode().equals("FE_0000")) {
                    this.f71268f.setVisibility(0);
                    this.f71268f.setAnimation("lifafa_open.json");
                    this.f71268f.addAnimatorListener(new Animator.AnimatorListener() {
                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }

                        public final void onAnimationStart(Animator animator) {
                        }

                        public final void onAnimationEnd(Animator animator) {
                            new Handler().postDelayed(new Runnable() {
                                public final void run() {
                                    if (c.this.getActivity() == null || !(c.this.getActivity() instanceof a)) {
                                        c.this.f71269g.setVisibility(8);
                                        c.this.f71270h.setVisibility(0);
                                        c.this.k.setImageResource(R.drawable.lifafa_fail_icon);
                                        c.this.f71271i.setText(c.this.getString(R.string.some_went_wrong));
                                        return;
                                    }
                                    ((a) c.this.getActivity()).a((ReceivedLifafaDetailsResponse) c.this.f71267e);
                                }
                            }, 500);
                        }
                    });
                    this.f71268f.playAnimation();
                } else if ((receivedLifafaDetailsResponse.getStatusCode() != null && receivedLifafaDetailsResponse.getStatusCode().equals("PE_0005")) || (receivedLifafaDetailsResponse.getStatusCode() != null && receivedLifafaDetailsResponse.getStatusCode().equals("EV_0014"))) {
                    this.f71269g.setVisibility(8);
                    this.f71270h.setVisibility(0);
                    this.k.setImageResource(R.drawable.lifafa_expire_icon);
                    this.f71271i.setText(receivedLifafaDetailsResponse.getStatusMessage());
                } else if (receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("EV_0041")) {
                    this.f71269g.setVisibility(8);
                    this.f71270h.setVisibility(0);
                    this.k.setImageResource(R.drawable.lifafa_fail_icon);
                    this.f71271i.setText(getString(R.string.some_went_wrong));
                } else {
                    this.f71269g.setVisibility(8);
                    this.f71270h.setVisibility(0);
                    this.k.setImageResource(R.drawable.lifafaf_late_icon);
                    this.f71271i.setText(receivedLifafaDetailsResponse.getStatusMessage());
                }
            }
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }
}

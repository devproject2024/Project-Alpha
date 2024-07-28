package net.one97.paytm.wallet.newdesign.postcard.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPostcardFetchInitiatorList;
import net.one97.paytm.common.entity.CJRPostcardFetchRecipientList;
import net.one97.paytm.common.entity.lifafa.ReceivedLifafaResponse;
import net.one97.paytm.common.entity.lifafa.SentLifafaResponse;
import net.one97.paytm.common.entity.wallet.postcard.data.PostcardThemesResponseDataModel;
import net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.postcard.PostCardMainActivity;
import net.one97.paytm.wallet.newdesign.postcard.d;
import net.one97.paytm.wallet.newdesign.utils.NoInternetAlertDialogFragment;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends net.one97.paytm.base.b implements View.OnClickListener, d.C1447d {

    /* renamed from: a  reason: collision with root package name */
    public TextView f71279a;

    /* renamed from: b  reason: collision with root package name */
    public b f71280b;

    /* renamed from: c  reason: collision with root package name */
    public PostcardThemesResponseDataModel f71281c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71282e = false;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f71283f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f71284g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f71285h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f71286i;
    private RelativeLayout j;
    private ViewPager k;
    private TabLayout l;
    private RelativeLayout m;
    private TextView n;
    private ArrayList<CJRPostcardFetchInitiatorList> o = new ArrayList<>();
    private ArrayList<CJRPostcardFetchRecipientList> p = new ArrayList<>();
    private net.one97.paytm.wallet.newdesign.postcard.a q;
    private boolean r = false;
    private boolean s = false;
    /* access modifiers changed from: private */
    public b t;
    /* access modifiers changed from: private */
    public a u;

    public interface a {
        void a(Fragment fragment);
    }

    public interface b {
        void a();

        void a(PostcardThemesResponseDataModel postcardThemesResponseDataModel);

        void a(PostcardThemesResponseDataModel postcardThemesResponseDataModel, boolean z, Intent intent);

        void a(PostcardThemesResponseDataModel postcardThemesResponseDataModel, boolean z, boolean z2);

        void b();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|7|8|9) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.paytm.network.model.NetworkCustomError r9) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x00e4
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            if (r0 == 0) goto L_0x001b
            boolean r0 = r8.isDetached()
            if (r0 != 0) goto L_0x001b
            r0 = 0
            net.one97.paytm.wallet.newdesign.postcard.b.a r1 = r8.u     // Catch:{ Exception -> 0x0014 }
            r1.b((boolean) r0)     // Catch:{ Exception -> 0x0014 }
        L_0x0014:
            net.one97.paytm.wallet.newdesign.postcard.b.b r1 = r8.t     // Catch:{ Exception -> 0x001a }
            r1.a((boolean) r0)     // Catch:{ Exception -> 0x001a }
            goto L_0x001b
        L_0x001a:
        L_0x001b:
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            if (r0 == 0) goto L_0x00e4
            if (r9 == 0) goto L_0x00e4
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            if (r0 == 0) goto L_0x00e4
            java.lang.String r0 = r9.getMessage()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x003b
            int r0 = r9.getStatusCode()
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L_0x0043
        L_0x003b:
            int r0 = r9.getStatusCode()
            r1 = 401(0x191, float:5.62E-43)
            if (r0 != r1) goto L_0x0053
        L_0x0043:
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            androidx.fragment.app.FragmentActivity r3 = r8.getActivity()
            r5 = 0
            r6 = 0
            r7 = 0
            r4 = r9
            r2.handleError(r3, r4, r5, r6, r7)
            return
        L_0x0053:
            java.lang.String r0 = r9.getMessage()
            if (r0 == 0) goto L_0x00e4
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            androidx.fragment.app.FragmentActivity r1 = r8.getActivity()
            boolean r0 = r0.checkErrorCode(r1, r9)
            if (r0 != 0) goto L_0x00e4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.res.Resources r1 = r8.getResources()
            int r2 = net.one97.paytm.wallet.R.string.network_error_message
            java.lang.String r1 = r1.getString(r2)
            r0.append(r1)
            java.lang.String r1 = " "
            r0.append(r1)
            java.lang.String r2 = r9.getUrl()
            r0.append(r2)
            java.lang.String r0 = r9.getMessage()
            if (r0 == 0) goto L_0x00b3
            java.lang.String r0 = r9.getMessage()
            java.lang.String r2 = "parsing_error"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x00b3
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            java.lang.String r1 = r9.getUrl()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r9 = r9.getStatusCode()
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            com.paytm.utility.b.d((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r9)
            return
        L_0x00b3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.res.Resources r2 = r8.getResources()
            int r3 = net.one97.paytm.wallet.R.string.network_error_message
            java.lang.String r2 = r2.getString(r3)
            r0.append(r2)
            r0.append(r1)
            java.lang.String r9 = r9.getUrl()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            android.content.res.Resources r1 = r8.getResources()
            int r2 = net.one97.paytm.wallet.R.string.network_error_heading
            java.lang.String r1 = r1.getString(r2)
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r9)
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.postcard.b.d.b(com.paytm.network.model.NetworkCustomError):void");
    }

    public final void a(PostcardThemesResponseDataModel postcardThemesResponseDataModel) {
        if (getActivity() != null) {
            this.f71282e = true;
            b bVar = this.f71280b;
            if (bVar != null) {
                bVar.a(postcardThemesResponseDataModel);
            }
            net.one97.paytm.wallet.newdesign.postcard.d.a((Context) getActivity()).a();
        }
    }

    public final void a() {
        net.one97.paytm.wallet.newdesign.postcard.d.a((Context) getActivity()).b();
    }

    public final void a(NetworkCustomError networkCustomError) {
        b(networkCustomError);
    }

    public final void a(String str, String str2) {
        com.paytm.utility.b.b((Context) getActivity(), str, str2);
    }

    private void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof ReceivedLifafaResponse) {
            ReceivedLifafaResponse receivedLifafaResponse = (ReceivedLifafaResponse) iJRPaytmDataModel;
            b bVar = this.t;
            if (!(receivedLifafaResponse.getStatusCode() == null || !receivedLifafaResponse.getStatusCode().equals("FE_0000") || receivedLifafaResponse.getRecievedLifafaDetails() == null)) {
                ArrayList<CJRPostcardFetchRecipientList> arrayList = new ArrayList<>();
                for (ReceivedLifafaResponse.RecievedLifafaDetails recievedLifafaDetails : receivedLifafaResponse.getRecievedLifafaDetails()) {
                    CJRPostcardFetchRecipientList cJRPostcardFetchRecipientList = new CJRPostcardFetchRecipientList();
                    cJRPostcardFetchRecipientList.setRecievedLifafaDetails(recievedLifafaDetails);
                    arrayList.add(cJRPostcardFetchRecipientList);
                }
                PostcardThemesResponseDataModel postcardThemesResponseDataModel = this.f71281c;
                if (!(postcardThemesResponseDataModel == null || postcardThemesResponseDataModel.getResponse() == null)) {
                    Iterator<CJRPostcardFetchRecipientList> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        CJRPostcardFetchRecipientList next = it2.next();
                        for (ThemesMetaDataModel next2 : this.f71281c.getResponse()) {
                            if (next.getRecievedLifafaDetails().getLifafaDetail().getThemeGuid().equals(next2.getId())) {
                                next.setThemesMetaDataModel(next2);
                            }
                        }
                    }
                }
                this.p = arrayList;
            }
            net.one97.paytm.wallet.newdesign.postcard.a aVar = this.q;
            if (aVar != null && aVar.getItem(0) != null) {
                bVar.e();
                bVar.a(false);
                bVar.a(this.p);
                ArrayList<CJRPostcardFetchRecipientList> arrayList2 = this.p;
                if (arrayList2 == null || arrayList2.size() == 0) {
                    bVar.b(true);
                } else {
                    bVar.b(false);
                }
            }
        } else if (iJRPaytmDataModel instanceof SentLifafaResponse) {
            SentLifafaResponse sentLifafaResponse = (SentLifafaResponse) iJRPaytmDataModel;
            a aVar2 = this.u;
            if (!(sentLifafaResponse == null || sentLifafaResponse.getStatusCode() == null || !sentLifafaResponse.getStatusCode().equals("FE_0000") || sentLifafaResponse.getSentLifafaList() == null)) {
                this.o = a(sentLifafaResponse);
            }
            net.one97.paytm.wallet.newdesign.postcard.a aVar3 = this.q;
            if (aVar3 != null && aVar3.getItem(1) != null) {
                aVar2.e();
                aVar2.b(false);
                aVar2.a(this.o);
                ArrayList<CJRPostcardFetchInitiatorList> arrayList3 = this.o;
                if (arrayList3 == null || arrayList3.size() == 0) {
                    aVar2.a(true);
                } else {
                    aVar2.a(false);
                }
            }
        }
    }

    private ArrayList<CJRPostcardFetchInitiatorList> a(SentLifafaResponse sentLifafaResponse) {
        ArrayList<CJRPostcardFetchInitiatorList> arrayList = new ArrayList<>();
        for (SentLifafaResponse.SentLifafaList sentLifafaList : sentLifafaResponse.getSentLifafaList()) {
            CJRPostcardFetchInitiatorList cJRPostcardFetchInitiatorList = new CJRPostcardFetchInitiatorList();
            cJRPostcardFetchInitiatorList.setSentLifafaList(sentLifafaList);
            arrayList.add(cJRPostcardFetchInitiatorList);
        }
        PostcardThemesResponseDataModel postcardThemesResponseDataModel = this.f71281c;
        if (!(postcardThemesResponseDataModel == null || postcardThemesResponseDataModel.getResponse() == null)) {
            Iterator<CJRPostcardFetchInitiatorList> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRPostcardFetchInitiatorList next = it2.next();
                for (ThemesMetaDataModel next2 : this.f71281c.getResponse()) {
                    if (next.getSentLifafaList().getThemeGuid().equals(next2.getId())) {
                        next.setThemesMetaDataModel(next2);
                    }
                }
            }
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.paytm.utility.b.c((Context) getActivity())) {
            net.one97.paytm.wallet.newdesign.postcard.d a2 = net.one97.paytm.wallet.newdesign.postcard.d.a((Context) getActivity());
            this.f71281c = a2.a((d.C1447d) this);
            if (this.f71281c != null) {
                a2.b();
                return;
            }
            return;
        }
        d();
    }

    public final void d() {
        if (getActivity() != null && !isDetached()) {
            NoInternetAlertDialogFragment.newInstance(false).show(getFragmentManager().a(), "dialog");
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.f71280b = (b) context;
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f71280b = null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_post_card_landing, viewGroup, false);
        try {
            this.f71285h = (ImageView) inflate.findViewById(R.id.iv_back_button);
            this.f71285h.setOnClickListener(this);
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/wallet/lifafa");
        net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(getActivity(), "open_screen_event", hashMap);
        return inflate;
    }

    public final void a(boolean z) {
        net.one97.paytm.network.b bVar;
        y<f> yVar;
        try {
            String str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "lifafaEventFetchURL") + "/recieved";
            String str2 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "lifafaEventFetchURL") + "/sent";
            if (!URLUtil.isValidUrl(str)) {
                return;
            }
            if (URLUtil.isValidUrl(str2)) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put("limit", 20);
                jSONObject.put("startOffset", 0);
                jSONObject2.put("limit", 20);
                jSONObject2.put("startOffset", 0);
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(getActivity()));
                hashMap.put("Content-Type", "application/json");
                if (z) {
                    bVar = new net.one97.paytm.network.b(str, new ReceivedLifafaResponse(), (Map<String, String>) null, hashMap, jSONObject.toString());
                } else {
                    bVar = new net.one97.paytm.network.b(str2, new SentLifafaResponse(), (Map<String, String>) null, hashMap, jSONObject2.toString());
                }
                if (com.paytm.utility.b.c(getContext())) {
                    yVar = bVar.c();
                } else {
                    yVar = net.one97.paytm.base.d.f49504d.a(getContext(), bVar);
                }
                if (yVar != null) {
                    yVar.observeForever(new z(z) {
                        private final /* synthetic */ boolean f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onChanged(Object obj) {
                            d.this.a(this.f$1, (f) obj);
                        }
                    });
                }
            }
        } catch (JSONException unused) {
        }
    }

    public void onClick(View view) {
        try {
            if (view == this.f71283f) {
                if (!com.paytm.utility.b.c((Context) getActivity())) {
                    d();
                } else {
                    this.f71280b.a();
                }
            } else if (view == this.f71284g) {
                b(false);
            } else if (view == this.n) {
                b(false);
                ((PostCardMainActivity) getActivity()).a("send_lucky_lifafa_clicked");
            } else if (view == this.m) {
                b(true);
                ((PostCardMainActivity) getActivity()).a("send_lifafa_to_a_friend_clicked");
            } else if (view == this.f71285h) {
                getActivity().onBackPressed();
            } else if (view == this.f71286i) {
                e();
            } else if (view == this.j) {
                e();
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    private void e() {
        if (!com.paytm.utility.b.c((Context) getActivity())) {
            d();
        } else {
            this.f71280b.b();
        }
    }

    public final void b(boolean z) {
        if (!com.paytm.utility.b.c((Context) getActivity())) {
            d();
        } else {
            this.f71280b.a(this.f71281c, this.f71282e, z);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View view = getView();
        this.m = (RelativeLayout) view.findViewById(R.id.rl_send_lucky_lifafa_btn);
        this.m.setOnClickListener(this);
        this.n = (TextView) view.findViewById(R.id.tvSendLifafa);
        this.n.setOnClickListener(this);
        this.l = (TabLayout) view.findViewById(R.id.tabs);
        TabLayout tabLayout = this.l;
        tabLayout.a(tabLayout.a().a((CharSequence) "Received"));
        TabLayout tabLayout2 = this.l;
        tabLayout2.a(tabLayout2.a().a((CharSequence) "Sent"));
        this.k = (ViewPager) view.findViewById(R.id.mypostcards_pager);
        this.q = new net.one97.paytm.wallet.newdesign.postcard.a(getChildFragmentManager(), getActivity(), this.o, this.p, new a() {
            public final void a(Fragment fragment) {
                if (fragment instanceof b) {
                    b unused = d.this.t = (b) fragment;
                    d.this.a(true);
                } else if (fragment instanceof a) {
                    a unused2 = d.this.u = (a) fragment;
                    d.this.a(false);
                }
            }
        });
        this.k.setAdapter(this.q);
        this.l.setupWithViewPager(this.k);
    }

    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, f fVar) {
        if (z) {
            if (fVar.f55796a == h.SUCCESS) {
                a(fVar.f55797b);
            } else if (fVar.f55796a == h.ERROR) {
                b(fVar.f55798c.f55801c);
            }
            this.t.a(true);
            return;
        }
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            b(fVar.f55798c.f55801c);
        }
        this.u.b(true);
    }
}

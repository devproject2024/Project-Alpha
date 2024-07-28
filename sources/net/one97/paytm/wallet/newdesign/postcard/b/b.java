package net.one97.paytm.wallet.newdesign.postcard.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRPostcardFetchRecipientList;
import net.one97.paytm.common.entity.lifafa.ReceivedLifafaDetailsResponse;
import net.one97.paytm.common.entity.lifafa.ReceivedLifafaResponse;
import net.one97.paytm.common.entity.lifafa.enums.LifafaStatus;
import net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel;
import net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.d.l;
import net.one97.paytm.wallet.newdesign.postcard.MyPostcardAnimationActivity;
import net.one97.paytm.wallet.newdesign.postcard.ViewPostcardActivity;
import net.one97.paytm.wallet.newdesign.postcard.b.d;
import net.one97.paytm.wallet.newdesign.postcard.c;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends net.one97.paytm.base.b implements View.OnClickListener {
    private static d.a o;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f71250a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.wallet.newdesign.postcard.a.d f71251b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CJRPostcardFetchRecipientList f71252c;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<CJRPostcardFetchRecipientList> f71253e;

    /* renamed from: f  reason: collision with root package name */
    private Dialog f71254f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f71255g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f71256h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f71257i;
    private ImageView j;
    private int k;
    private LottieAnimationView l;
    private View m;
    private boolean n = false;
    /* access modifiers changed from: private */
    public int p = -1;
    private String q;
    /* access modifiers changed from: private */
    public int r;
    /* access modifiers changed from: private */
    public int s;
    /* access modifiers changed from: private */
    public int t;
    /* access modifiers changed from: private */
    public int u;
    /* access modifiers changed from: private */
    public boolean v;

    /* renamed from: net.one97.paytm.wallet.newdesign.postcard.b.b$b  reason: collision with other inner class name */
    public interface C1446b {
        void a(int i2);
    }

    public static b a(ArrayList<CJRPostcardFetchRecipientList> arrayList, d.a aVar) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("recipientlist", arrayList);
        bVar.setArguments(bundle);
        o = aVar;
        return bVar;
    }

    public final void a(NetworkCustomError networkCustomError) {
        d();
        this.v = false;
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

    public void onResume() {
        super.onResume();
        e();
        o.a(this);
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse;
        d();
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRPGTokenList)) {
                CJRPGTokenList cJRPGTokenList = (CJRPGTokenList) iJRPaytmDataModel;
                if (getActivity() != null && !getActivity().isFinishing()) {
                    this.q = net.one97.paytm.wallet.communicator.b.a().getPgToken(cJRPGTokenList);
                    if (!TextUtils.isEmpty(this.q)) {
                        int i2 = this.p;
                        this.f71252c = this.f71253e.get(i2);
                        String recipientStatus = this.f71253e.get(i2).getRecievedLifafaDetails().getRecipientDetail().getRecipientStatus();
                        if (recipientStatus == null) {
                            return;
                        }
                        if (recipientStatus.equalsIgnoreCase(LifafaStatus.PENDING.name()) || recipientStatus.equalsIgnoreCase(LifafaStatus.ACTIVATED.name())) {
                            a(true, this.f71253e.get(i2).getRecievedLifafaDetails().getLifafaDetail().getLifafaKey());
                        } else if (recipientStatus.equalsIgnoreCase(LifafaStatus.SUCCESS.name()) && !this.f71252c.getRecievedLifafaDetails().getLifafaDetail().getLifafaStatus().equalsIgnoreCase(LifafaStatus.EXPIRED.name()) && !this.f71252c.getRecievedLifafaDetails().getLifafaDetail().getLifafaStatus().equalsIgnoreCase(LifafaStatus.CANCELLED.name())) {
                            this.k = i2;
                            a(false, this.f71253e.get(i2).getRecievedLifafaDetails().getLifafaDetail().getLifafaKey());
                        } else if (this.f71253e.get(i2).getRecievedLifafaDetails().getLifafaDetail().getLifafaStatus().equalsIgnoreCase(LifafaStatus.EXPIRED.name()) || this.f71253e.get(i2).getRecievedLifafaDetails().getLifafaDetail().getLifafaStatus().equalsIgnoreCase(LifafaStatus.CANCELLED.name()) || this.f71253e.get(i2).getRecievedLifafaDetails().getLifafaDetail().getLifafaStatus().equalsIgnoreCase(LifafaStatus.DECLINED.name()) || this.f71253e.get(i2).getRecievedLifafaDetails().getLifafaDetail().getLifafaStatus().equalsIgnoreCase(LifafaStatus.CLOSED.name())) {
                            a(getString(R.string.error), getString(R.string.expired_postcard_mesg));
                        }
                    } else {
                        net.one97.paytm.wallet.communicator.b.a().showSessionTimeoutAlert(getActivity());
                    }
                }
            } else if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof ReceivedLifafaDetailsResponse) && (receivedLifafaDetailsResponse = (ReceivedLifafaDetailsResponse) iJRPaytmDataModel) != null) {
                if (receivedLifafaDetailsResponse.getStatusCode() != null && receivedLifafaDetailsResponse.getStatusCode().equals("FE_0000")) {
                    onDestroyView();
                    getChildFragmentManager().d();
                    boolean z = this.n;
                    if (!z) {
                        Intent intent = new Intent(getActivity(), ViewPostcardActivity.class);
                        intent.putExtra("data", receivedLifafaDetailsResponse);
                        startActivity(intent);
                    } else if (z) {
                        Intent intent2 = new Intent(getActivity(), MyPostcardAnimationActivity.class);
                        intent2.putExtra("data", receivedLifafaDetailsResponse);
                        intent2.putExtra("claim_from_deep_link", false);
                        getActivity().startActivityForResult(intent2, 1007);
                    }
                } else if ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("EV_0014")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_0001")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_0002")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_0003")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_0004")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_1000")) && (receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_1001")))))))) {
                    a(getString(R.string.error), getString(R.string.some_went_wrong));
                } else {
                    a(getString(R.string.error), receivedLifafaDetailsResponse.getStatusMessage());
                }
            }
        }
    }

    private void a(boolean z, String str) {
        a aVar = new a(this, (byte) 0);
        c cVar = new c();
        cVar.f71339b = str;
        cVar.f71338a = z;
        if (Build.VERSION.SDK_INT >= 11) {
            aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new c[]{cVar});
            return;
        }
        aVar.execute(new c[]{cVar});
    }

    class a extends AsyncTask<c, Void, c> {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            c cVar = (c) obj;
            if (b.this.getActivity() != null) {
                super.onPostExecute(cVar);
                b.this.d();
                if (cVar != null) {
                    b.a(b.this, cVar.f71338a, cVar.f71339b);
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            super.onPreExecute();
            b.this.a();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public c doInBackground(c... cVarArr) {
            String str;
            Process.setThreadPriority(9);
            Process.setThreadPriority(0);
            if (b.this.getActivity() == null) {
                return null;
            }
            if (b.this.f71252c.getThemesMetaDataModel() == null || b.this.f71252c.getThemesMetaDataModel().getThemes() == null) {
                return cVarArr[0];
            }
            IconMetaDataModel a2 = b.a((ArrayList) b.this.f71252c.getThemesMetaDataModel().getThemes().getPassbookView(), l.a((Context) b.this.getActivity()));
            String url1 = a2 != null ? a2.getUrl1() : null;
            try {
                str = url1.substring(url1.lastIndexOf("/"));
            } catch (Exception unused) {
                str = url1;
            }
            try {
                if (b.this.getActivity() == null) {
                    return null;
                }
                File file = new File(b.this.getActivity().getExternalCacheDir().toString(), str);
                if (!file.exists()) {
                    file.createNewFile();
                    HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(url1).openConnection()));
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    InputStream inputStream = httpURLConnection.getInputStream();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    net.one97.paytm.wallet.newdesign.postcard.b.a(inputStream, fileOutputStream);
                    fileOutputStream.close();
                    fileOutputStream.flush();
                }
                return cVarArr[0];
            } catch (IOException e2) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public final void a(ArrayList<CJRPostcardFetchRecipientList> arrayList) {
        this.f71253e = arrayList;
        f();
    }

    public void onStart() {
        super.onStart();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        f();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onDetach() {
        super.onDetach();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_post_cards_list, viewGroup, false);
        this.m = inflate.findViewById(R.id.list_container);
        this.f71250a = (RecyclerView) inflate.findViewById(R.id.mypostcards_recycler_view);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.f71250a.setLayoutManager(linearLayoutManager);
        this.f71255g = (LinearLayout) inflate.findViewById(R.id.id_noPostCardLayout);
        this.j = (ImageView) inflate.findViewById(R.id.no_postcard_img);
        this.f71256h = (TextView) inflate.findViewById(R.id.no_postcard_text);
        this.f71257i = (TextView) inflate.findViewById(R.id.send_postcard_button);
        this.j.setImageResource(R.drawable.empty_letterbox);
        inflate.findViewById(R.id.empty_outbox_lyt_outer).setVisibility(8);
        this.f71256h.setText(R.string.no_received_postcard);
        this.f71257i.setOnClickListener(this);
        this.l = (LottieAnimationView) inflate.findViewById(R.id.wallet_loader);
        e();
        this.f71250a.addOnScrollListener(new RecyclerView.l() {
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                if (b.a(b.this.f71250a) && i3 > 0) {
                    int unused = b.this.r = linearLayoutManager.getItemCount();
                    int unused2 = b.this.s = linearLayoutManager.findLastVisibleItemPosition();
                    if (!b.this.v && b.this.r <= b.this.s + b.this.u) {
                        b bVar = b.this;
                        int unused3 = bVar.t = bVar.t + b.this.u;
                        boolean unused4 = b.this.v = true;
                        b bVar2 = b.this;
                        bVar2.a(bVar2.t, b.this.u);
                    }
                }
            }
        });
        return inflate;
    }

    public final void a(boolean z) {
        try {
            if (this.l != null) {
                net.one97.paytm.common.widgets.a.b(this.l);
                if (z) {
                    net.one97.paytm.common.widgets.a.a(this.l);
                } else {
                    net.one97.paytm.common.widgets.a.b(this.l);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.m.setVisibility(8);
            this.f71255g.setVisibility(0);
            return;
        }
        this.m.setVisibility(0);
        this.f71255g.setVisibility(8);
    }

    private void f() {
        this.f71251b = new net.one97.paytm.wallet.newdesign.postcard.a.d(this.f71253e, new C1446b() {
            public final void a(int i2) {
                int unused = b.this.p = i2;
                b bVar = b.this;
                if (bVar.getActivity() != null && !bVar.getActivity().isFinishing()) {
                    bVar.a();
                    if (com.paytm.utility.b.c((Context) bVar.getActivity())) {
                        String q = com.paytm.utility.a.q(bVar.getActivity());
                        if (!TextUtils.isEmpty(q)) {
                            net.one97.paytm.wallet.communicator.b.a().getWalletToken(q, bVar.getActivity(), new com.paytm.network.listener.b() {
                                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                    b.this.a(iJRPaytmDataModel);
                                }

                                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                    b.this.a(networkCustomError);
                                }
                            });
                        } else {
                            net.one97.paytm.wallet.communicator.b.a().showSessionTimeoutAlert(bVar.getActivity());
                        }
                    } else if (bVar.getActivity() != null && !bVar.getActivity().isFinishing()) {
                        bVar.d();
                        net.one97.paytm.wallet.utility.a.a((Activity) bVar.getActivity());
                    }
                }
            }
        }, getContext());
        this.f71250a.getLayoutManager().onRestoreInstanceState(this.f71250a.getLayoutManager().onSaveInstanceState());
        this.f71250a.setAdapter(this.f71251b);
    }

    private void a(String str, String str2) {
        com.paytm.utility.b.b((Context) getActivity(), str, str2);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.send_postcard_button) {
            getActivity().setResult(-1);
            getActivity().finish();
        } else if (view.getId() == R.id.iv_back_button) {
            getActivity().onBackPressed();
        }
    }

    private void a(String str, boolean z) {
        String str2 = str;
        Class<b> cls = b.class;
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "lifafaEventProcessURL");
        String stringFromGTM2 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "lifafaEventDetailURL");
        if (URLUtil.isValidUrl(stringFromGTM) && URLUtil.isValidUrl(stringFromGTM2)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("lifafaKey", str2);
                jSONObject.put("startOffset", "0");
                jSONObject.put("limit", "100");
                jSONObject2.put("lifafaKey", str2);
            } catch (JSONException e2) {
                q.d(String.valueOf(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("ssotoken", this.q);
            hashMap.put("Content-Type", "application/json");
            if (z) {
                net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(stringFromGTM, new ReceivedLifafaDetailsResponse(), (Map<String, String>) null, hashMap, jSONObject.toString(), a.b.SILENT, cls.getSimpleName());
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    a();
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
                            b.this.a(this.f$1, this.f$2, this.f$3, (f) obj);
                        }
                    });
                    return;
                }
                return;
            }
            net.one97.paytm.network.b bVar2 = new net.one97.paytm.network.b(stringFromGTM2, new ReceivedLifafaDetailsResponse(), (Map<String, String>) null, hashMap, jSONObject.toString(), a.b.SILENT, cls.getSimpleName());
            if (com.paytm.utility.b.c((Context) getActivity())) {
                a();
                bVar2.c().observeForever(new z() {
                    public final void onChanged(Object obj) {
                        b.this.b((f) obj);
                    }
                });
            }
        }
    }

    public final void a() {
        if (getActivity() != null) {
            try {
                if (this.f71254f == null) {
                    this.f71254f = net.one97.paytm.wallet.utility.a.b((Activity) getActivity());
                }
                if (this.f71254f != null && !this.f71254f.isShowing()) {
                    this.f71254f.show();
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e2));
                }
            }
        }
    }

    public final void d() {
        if (getActivity() != null) {
            try {
                if (this.f71254f != null && this.f71254f.isShowing()) {
                    this.f71254f.dismiss();
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e2));
                }
            }
        }
    }

    public final void a(int i2, int i3) {
        y<f> yVar;
        try {
            String str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "lifafaEventFetchURL") + "/recieved";
            if (URLUtil.isValidUrl(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("limit", i3);
                jSONObject.put("startOffset", i2);
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(getActivity()));
                hashMap.put("Content-Type", "application/json");
                net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(str, new ReceivedLifafaResponse(), (Map<String, String>) null, hashMap, jSONObject.toString());
                if (com.paytm.utility.b.c(getContext())) {
                    yVar = bVar.c();
                } else {
                    yVar = net.one97.paytm.base.d.f49504d.a(getContext(), bVar);
                }
                if (yVar != null) {
                    yVar.observeForever(new z() {
                        public final void onChanged(Object obj) {
                            b.this.a((f) obj);
                        }
                    });
                }
            }
        } catch (JSONException unused) {
        }
    }

    public final void e() {
        this.v = false;
        this.t = 20;
        this.u = 20;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        ReceivedLifafaResponse receivedLifafaResponse;
        if (fVar.f55796a == h.SUCCESS) {
            d();
            this.v = false;
            if (fVar.f55797b != null && (fVar.f55797b instanceof ReceivedLifafaResponse) && (receivedLifafaResponse = (ReceivedLifafaResponse) fVar.f55797b) != null) {
                if (receivedLifafaResponse.getRecievedLifafaDetails() == null || receivedLifafaResponse.getRecievedLifafaDetails().size() == 0) {
                    this.v = true;
                }
                if (receivedLifafaResponse.getStatusCode() != null && receivedLifafaResponse.getStatusCode().equals("FE_0000") && receivedLifafaResponse.getRecievedLifafaDetails() != null) {
                    ArrayList arrayList = new ArrayList();
                    for (ReceivedLifafaResponse.RecievedLifafaDetails recievedLifafaDetails : receivedLifafaResponse.getRecievedLifafaDetails()) {
                        CJRPostcardFetchRecipientList cJRPostcardFetchRecipientList = new CJRPostcardFetchRecipientList();
                        cJRPostcardFetchRecipientList.setRecievedLifafaDetails(recievedLifafaDetails);
                        arrayList.add(cJRPostcardFetchRecipientList);
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        CJRPostcardFetchRecipientList cJRPostcardFetchRecipientList2 = (CJRPostcardFetchRecipientList) it2.next();
                        List<ThemesMetaDataModel> c2 = net.one97.paytm.wallet.newdesign.postcard.d.a((Context) getActivity()).c();
                        if (c2 != null && c2.size() > 0) {
                            for (ThemesMetaDataModel next : c2) {
                                if (cJRPostcardFetchRecipientList2.getRecievedLifafaDetails().getLifafaDetail().getThemeGuid().equals(next.getId())) {
                                    cJRPostcardFetchRecipientList2.setThemesMetaDataModel(next);
                                }
                            }
                        }
                    }
                    Parcelable onSaveInstanceState = this.f71250a.getLayoutManager().onSaveInstanceState();
                    net.one97.paytm.wallet.newdesign.postcard.a.d dVar = this.f71251b;
                    dVar.f71210a.addAll(arrayList);
                    dVar.notifyDataSetChanged();
                    this.f71250a.getLayoutManager().onRestoreInstanceState(onSaveInstanceState);
                } else if ((receivedLifafaResponse.getStatusCode() != null && receivedLifafaResponse.getStatusCode().equals("EV_0014")) || ((receivedLifafaResponse.getStatusCode() != null && receivedLifafaResponse.getStatusCode().equals("RWL_0001")) || ((receivedLifafaResponse.getStatusCode() != null && receivedLifafaResponse.getStatusCode().equals("RWL_0002")) || ((receivedLifafaResponse.getStatusCode() != null && receivedLifafaResponse.getStatusCode().equals("RWL_0003")) || ((receivedLifafaResponse.getStatusCode() != null && receivedLifafaResponse.getStatusCode().equals("RWL_0004")) || ((receivedLifafaResponse.getStatusCode() != null && receivedLifafaResponse.getStatusCode().equals("RWL_1000")) || (receivedLifafaResponse.getStatusCode() != null && receivedLifafaResponse.getStatusCode().equals("RWL_1001")))))))) {
                    a(getString(R.string.error), receivedLifafaResponse.getStatusMessage());
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, Map map, JSONObject jSONObject, f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse = (ReceivedLifafaDetailsResponse) fVar.f55797b;
            if (receivedLifafaDetailsResponse.getStatusCode() == null || (!receivedLifafaDetailsResponse.getStatusCode().equals("FE_0000") && !receivedLifafaDetailsResponse.getStatusCode().equals("CM_0000"))) {
                d();
                a("Error", receivedLifafaDetailsResponse.getStatusMessage());
                return;
            }
            net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(str, new ReceivedLifafaDetailsResponse(), (Map<String, String>) null, map, jSONObject.toString());
            if (com.paytm.utility.b.c((Context) getActivity())) {
                bVar.c().observeForever(new z() {
                    public final void onChanged(Object obj) {
                        b.this.c((f) obj);
                    }
                });
            }
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    static /* synthetic */ IconMetaDataModel a(ArrayList arrayList, String str) {
        if (arrayList == null) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((IconMetaDataModel) arrayList.get(i2)).getResolution().equalsIgnoreCase(str)) {
                return (IconMetaDataModel) arrayList.get(i2);
            }
        }
        return (IconMetaDataModel) arrayList.get(0);
    }

    static /* synthetic */ void a(b bVar, boolean z, String str) {
        if (z) {
            bVar.n = true;
            bVar.a(str, true);
            return;
        }
        bVar.n = false;
        bVar.a(str, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = ((androidx.recyclerview.widget.LinearLayoutManager) r2.getLayoutManager()).findLastCompletelyVisibleItemPosition();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean a(androidx.recyclerview.widget.RecyclerView r2) {
        /*
            androidx.recyclerview.widget.RecyclerView$a r0 = r2.getAdapter()
            int r0 = r0.getItemCount()
            if (r0 == 0) goto L_0x0024
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r2.getLayoutManager()
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            int r0 = r0.findLastCompletelyVisibleItemPosition()
            r1 = -1
            if (r0 == r1) goto L_0x0024
            androidx.recyclerview.widget.RecyclerView$a r2 = r2.getAdapter()
            int r2 = r2.getItemCount()
            r1 = 1
            int r2 = r2 - r1
            if (r0 != r2) goto L_0x0024
            return r1
        L_0x0024:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.postcard.b.b.a(androidx.recyclerview.widget.RecyclerView):boolean");
    }
}

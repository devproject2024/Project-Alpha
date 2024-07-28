package net.one97.paytm.wallet.newdesign.postcard.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
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
import net.one97.paytm.common.entity.CJRPostcardFetchInitiatorList;
import net.one97.paytm.common.entity.lifafa.SentLifafaDetailsResponse;
import net.one97.paytm.common.entity.lifafa.SentLifafaResponse;
import net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel;
import net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel;
import net.one97.paytm.network.f;
import net.one97.paytm.network.g;
import net.one97.paytm.network.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.d.l;
import net.one97.paytm.wallet.newdesign.postcard.ViewPostcardActivity;
import net.one97.paytm.wallet.newdesign.postcard.a.c;
import net.one97.paytm.wallet.newdesign.postcard.b.d;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends net.one97.paytm.base.b implements View.OnClickListener {
    private static d.a l;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f71238a;

    /* renamed from: b  reason: collision with root package name */
    private c f71239b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRPostcardFetchInitiatorList> f71240c = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private Dialog f71241e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f71242f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f71243g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f71244h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f71245i;
    private LottieAnimationView j;
    private View k;
    /* access modifiers changed from: private */
    public int m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public int p;
    /* access modifiers changed from: private */
    public boolean q;

    public interface b {
        void a(int i2);
    }

    public static a a(ArrayList<CJRPostcardFetchInitiatorList> arrayList, d.a aVar) {
        a aVar2 = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("initiatorList", arrayList);
        aVar2.setArguments(bundle);
        l = aVar;
        return aVar2;
    }

    public void onResume() {
        super.onResume();
        e();
        l.a(this);
    }

    public final void a(ArrayList<CJRPostcardFetchInitiatorList> arrayList) {
        this.f71240c = arrayList;
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
        if (getArguments() != null && getArguments().containsKey("initiatorList")) {
            this.f71240c = (ArrayList) getArguments().getSerializable("initiatorList");
        }
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
        this.k = inflate.findViewById(R.id.list_container);
        this.f71238a = (RecyclerView) inflate.findViewById(R.id.mypostcards_recycler_view);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.f71238a.setLayoutManager(linearLayoutManager);
        this.f71242f = (LinearLayout) inflate.findViewById(R.id.id_noPostCardLayout);
        this.f71245i = (ImageView) inflate.findViewById(R.id.no_postcard_img);
        this.f71245i.setVisibility(8);
        this.f71243g = (TextView) inflate.findViewById(R.id.no_postcard_text);
        this.f71244h = (TextView) inflate.findViewById(R.id.send_postcard_button);
        this.j = (LottieAnimationView) inflate.findViewById(R.id.wallet_loader);
        inflate.findViewById(R.id.empty_outbox_lyt_outer).setVisibility(0);
        this.f71243g.setText(R.string.no_sent_postcard);
        this.f71244h.setOnClickListener(this);
        e();
        this.f71238a.addOnScrollListener(new RecyclerView.l() {
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                if (a.a(a.this.f71238a) && i3 > 0) {
                    int unused = a.this.m = linearLayoutManager.getItemCount();
                    int unused2 = a.this.n = linearLayoutManager.findLastVisibleItemPosition();
                    if (!a.this.q && a.this.m <= a.this.n + a.this.p) {
                        a aVar = a.this;
                        int unused3 = aVar.o = aVar.o + a.this.p;
                        boolean unused4 = a.this.q = true;
                        a aVar2 = a.this;
                        aVar2.a(aVar2.o, a.this.p);
                    }
                }
            }
        });
        return inflate;
    }

    public final void a(boolean z) {
        if (z) {
            this.k.setVisibility(8);
            this.f71242f.setVisibility(0);
            return;
        }
        this.k.setVisibility(0);
        this.f71242f.setVisibility(8);
    }

    public final void b(boolean z) {
        try {
            if (this.j != null) {
                net.one97.paytm.common.widgets.a.b(this.j);
                if (z) {
                    net.one97.paytm.common.widgets.a.a(this.j);
                } else {
                    net.one97.paytm.common.widgets.a.b(this.j);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void f() {
        this.f71239b = new c(this.f71240c, new b() {
            public final void a(int i2) {
                a aVar = a.this;
                a.a(aVar, (CJRPostcardFetchInitiatorList) aVar.f71240c.get(i2));
            }
        }, getContext());
        this.f71238a.getLayoutManager().onRestoreInstanceState(this.f71238a.getLayoutManager().onSaveInstanceState());
        this.f71238a.setAdapter(this.f71239b);
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.postcard.b.a$a  reason: collision with other inner class name */
    class C1445a extends AsyncTask<CJRPostcardFetchInitiatorList, Void, CJRPostcardFetchInitiatorList> {
        private C1445a() {
        }

        /* synthetic */ C1445a(a aVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            CJRPostcardFetchInitiatorList cJRPostcardFetchInitiatorList = (CJRPostcardFetchInitiatorList) obj;
            if (a.this.getActivity() != null) {
                super.onPostExecute(cJRPostcardFetchInitiatorList);
                a.this.d();
                if (cJRPostcardFetchInitiatorList != null) {
                    a.a(a.this, cJRPostcardFetchInitiatorList.getSentLifafaList().getLifafaKey());
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            super.onPreExecute();
            a.this.a();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public CJRPostcardFetchInitiatorList doInBackground(CJRPostcardFetchInitiatorList... cJRPostcardFetchInitiatorListArr) {
            String str;
            Process.setThreadPriority(0);
            if (a.this.getActivity() == null) {
                return null;
            }
            CJRPostcardFetchInitiatorList cJRPostcardFetchInitiatorList = cJRPostcardFetchInitiatorListArr[0];
            if (cJRPostcardFetchInitiatorList.getThemesMetaDataModel() == null || cJRPostcardFetchInitiatorList.getThemesMetaDataModel().getThemes() == null) {
                return cJRPostcardFetchInitiatorListArr[0];
            }
            IconMetaDataModel a2 = a.a((ArrayList) cJRPostcardFetchInitiatorList.getThemesMetaDataModel().getThemes().getPassbookView(), l.a((Context) a.this.getActivity()));
            String url1 = a2 != null ? a2.getUrl1() : "";
            try {
                str = url1.substring(url1.lastIndexOf("/"));
            } catch (Exception unused) {
                str = url1;
            }
            try {
                if (a.this.getActivity() == null) {
                    return null;
                }
                File file = new File(a.this.getActivity().getExternalCacheDir().toString(), str);
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
                return cJRPostcardFetchInitiatorListArr[0];
            } catch (IOException e2) {
                q.d(String.valueOf(e2));
            }
        }
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

    public final void a() {
        try {
            if (this.f71241e == null) {
                this.f71241e = net.one97.paytm.wallet.utility.a.b((Activity) getActivity());
            }
            if (this.f71241e != null && !this.f71241e.isShowing()) {
                this.f71241e.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public final void d() {
        try {
            if (this.f71241e != null && this.f71241e.isShowing()) {
                this.f71241e.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public final void a(int i2, int i3) {
        y<f> yVar;
        try {
            String str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "lifafaEventFetchURL") + "/sent";
            if (URLUtil.isValidUrl(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("limit", i3);
                jSONObject.put("startOffset", i2);
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(getActivity()));
                hashMap.put("Content-Type", "application/json");
                a();
                net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(str, new SentLifafaResponse(), (Map<String, String>) null, hashMap, jSONObject.toString());
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    yVar = bVar.c();
                } else {
                    yVar = net.one97.paytm.base.d.f49504d.a(getActivity(), bVar);
                }
                if (yVar != null) {
                    yVar.observeForever(new z() {
                        public final void onChanged(Object obj) {
                            a.this.a((f) obj);
                        }
                    });
                }
            }
        } catch (JSONException unused) {
        }
    }

    public final void e() {
        this.q = false;
        this.o = 20;
        this.p = 20;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        g gVar;
        SentLifafaResponse sentLifafaResponse;
        if (fVar.f55796a == h.SUCCESS) {
            d();
            this.q = false;
            if (fVar.f55797b != null && (fVar.f55797b instanceof SentLifafaResponse) && (sentLifafaResponse = (SentLifafaResponse) fVar.f55797b) != null) {
                if (sentLifafaResponse.getSentLifafaList() == null || sentLifafaResponse.getSentLifafaList().size() == 0) {
                    this.q = true;
                }
                if (sentLifafaResponse.getStatusCode() != null && sentLifafaResponse.getStatusCode().equals("FE_0000") && sentLifafaResponse.getSentLifafaList() != null) {
                    ArrayList arrayList = new ArrayList();
                    for (SentLifafaResponse.SentLifafaList sentLifafaList : sentLifafaResponse.getSentLifafaList()) {
                        CJRPostcardFetchInitiatorList cJRPostcardFetchInitiatorList = new CJRPostcardFetchInitiatorList();
                        cJRPostcardFetchInitiatorList.setSentLifafaList(sentLifafaList);
                        arrayList.add(cJRPostcardFetchInitiatorList);
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        CJRPostcardFetchInitiatorList cJRPostcardFetchInitiatorList2 = (CJRPostcardFetchInitiatorList) it2.next();
                        List<ThemesMetaDataModel> c2 = net.one97.paytm.wallet.newdesign.postcard.d.a((Context) getActivity()).c();
                        if (c2 != null && c2.size() > 0) {
                            for (ThemesMetaDataModel next : c2) {
                                if (cJRPostcardFetchInitiatorList2.getSentLifafaList().getThemeGuid().equals(next.getId())) {
                                    cJRPostcardFetchInitiatorList2.setThemesMetaDataModel(next);
                                }
                            }
                        }
                    }
                    c cVar = this.f71239b;
                    cVar.f71193a.addAll(arrayList);
                    cVar.notifyDataSetChanged();
                } else if ((sentLifafaResponse.getStatusCode() != null && sentLifafaResponse.getStatusCode().equals("EV_0014")) || ((sentLifafaResponse.getStatusCode() != null && sentLifafaResponse.getStatusCode().equals("RWL_0001")) || ((sentLifafaResponse.getStatusCode() != null && sentLifafaResponse.getStatusCode().equals("RWL_0002")) || ((sentLifafaResponse.getStatusCode() != null && sentLifafaResponse.getStatusCode().equals("RWL_0003")) || ((sentLifafaResponse.getStatusCode() != null && sentLifafaResponse.getStatusCode().equals("RWL_0004")) || ((sentLifafaResponse.getStatusCode() != null && sentLifafaResponse.getStatusCode().equals("RWL_1000")) || (sentLifafaResponse.getStatusCode() != null && sentLifafaResponse.getStatusCode().equals("RWL_1001")))))))) {
                    a(getString(R.string.error), sentLifafaResponse.getStatusMessage());
                }
            }
        } else if (fVar.f55796a == h.ERROR && (gVar = fVar.f55798c) != null && getActivity() != null) {
            if ((!TextUtils.isEmpty(gVar.f55801c.getMessage()) && gVar.f55799a == 410) || gVar.f55799a == 401) {
                net.one97.paytm.wallet.communicator.b.a().handleError(getActivity(), gVar.f55801c, (String) null, (Bundle) null, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(f fVar) {
        SentLifafaDetailsResponse sentLifafaDetailsResponse;
        if (fVar.f55796a == h.SUCCESS) {
            d();
            if (fVar.f55797b != null && (fVar.f55797b instanceof SentLifafaDetailsResponse) && (sentLifafaDetailsResponse = (SentLifafaDetailsResponse) fVar.f55797b) != null) {
                if (sentLifafaDetailsResponse.getStatusCode() != null && sentLifafaDetailsResponse.getStatusCode().equals("FE_0000")) {
                    Intent intent = new Intent(getActivity(), ViewPostcardActivity.class);
                    intent.putExtra("data", sentLifafaDetailsResponse);
                    startActivity(intent);
                } else if ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("EV_0014")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_0001")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_0002")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_0003")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_0004")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_1000")) && (sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_1001")))))))) {
                    a(getString(R.string.error), getString(R.string.some_went_wrong));
                } else {
                    a(getString(R.string.error), sentLifafaDetailsResponse.getStatusMessage());
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            d();
            this.q = false;
            g gVar = fVar.f55798c;
            if (gVar != null && getActivity() != null) {
                if (gVar.f55799a == 410 || gVar.f55799a == 401) {
                    net.one97.paytm.wallet.communicator.b.a().handleError(getActivity(), gVar.f55801c, (String) null, (Bundle) null, false);
                } else if (gVar.f55801c.getMessage() != null && !net.one97.paytm.wallet.communicator.b.a().checkErrorCode(getActivity(), gVar.f55801c)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getResources().getString(R.string.network_error_message));
                    sb.append(" ");
                    sb.append(gVar.f55801c.getUrl());
                    if (gVar.f55801c.getMessage() == null || !gVar.f55801c.getMessage().equalsIgnoreCase("parsing_error")) {
                        com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + gVar.f55801c.getUrl());
                        return;
                    }
                    FragmentActivity activity = getActivity();
                    String url = gVar.f55801c.getUrl();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(gVar.f55799a);
                    com.paytm.utility.b.d((Context) activity, url, sb2.toString());
                }
            }
        }
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.postcard.b.a.a(androidx.recyclerview.widget.RecyclerView):boolean");
    }

    static /* synthetic */ void a(a aVar, CJRPostcardFetchInitiatorList cJRPostcardFetchInitiatorList) {
        C1445a aVar2 = new C1445a(aVar, (byte) 0);
        if (Build.VERSION.SDK_INT >= 11) {
            aVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new CJRPostcardFetchInitiatorList[]{cJRPostcardFetchInitiatorList});
            return;
        }
        aVar2.execute(new CJRPostcardFetchInitiatorList[]{cJRPostcardFetchInitiatorList});
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

    static /* synthetic */ void a(a aVar, String str) {
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(aVar.getActivity(), "lifafaEventDetailURL");
        if (URLUtil.isValidUrl(stringFromGTM)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lifafaKey", str);
                jSONObject.put("startOffset", "0");
                jSONObject.put("limit", "100");
            } catch (JSONException e2) {
                q.d(String.valueOf(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("ssotoken", com.paytm.utility.a.q(aVar.getActivity()));
            hashMap.put("Content-Type", "application/json");
            net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(stringFromGTM, new SentLifafaDetailsResponse(), (Map<String, String>) null, hashMap, jSONObject.toString(), a.b.SILENT, a.class.getSimpleName());
            if (com.paytm.utility.b.c((Context) aVar.getActivity())) {
                aVar.a();
                bVar.c().observeForever(new z() {
                    public final void onChanged(Object obj) {
                        a.this.b((f) obj);
                    }
                });
            }
        }
    }
}

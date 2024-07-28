package net.one97.paytm.wallet.newdesign.postcard.b;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.paytm.utility.q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRPostcardCreateEvent;
import net.one97.paytm.common.entity.wallet.CJRPostcardSentData;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.d.i;
import net.one97.paytm.wallet.f.j;
import net.one97.paytm.wallet.newdesign.postcard.ViewPostcardActivity;

public class f extends h implements View.OnClickListener, j {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f71305a;

    /* renamed from: b  reason: collision with root package name */
    public i f71306b;

    /* renamed from: c  reason: collision with root package name */
    Context f71307c;

    /* renamed from: d  reason: collision with root package name */
    private b f71308d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f71309e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f71310f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f71311g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f71312h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f71313i;
    /* access modifiers changed from: private */
    public String j;
    /* access modifiers changed from: private */
    public String k;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public IconMetaDataModel n;
    private RelativeLayout o;
    private TextView p;
    private TranslateAnimation q;

    public interface b {
    }

    public static f a(String str, String str2, String str3, String str4, String str5, IconMetaDataModel iconMetaDataModel, boolean z) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putString("account", str2);
        bundle.putString("amount", str3);
        bundle.putString(CJRQRScanResultModel.KEY_COMMENT_SMALL, str4);
        bundle.putString("name", str);
        bundle.putString("themeID", str5);
        bundle.putBoolean("lucky_lifafa", z);
        bundle.putSerializable("key_summary_view", iconMetaDataModel);
        fVar.setArguments(bundle);
        return fVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getArguments() != null) {
                this.f71312h = getArguments().getString("account");
                this.f71313i = getArguments().getString("amount");
                this.j = getArguments().getString(CJRQRScanResultModel.KEY_COMMENT_SMALL);
                this.k = getArguments().getString("name");
                this.l = getArguments().getString("themeID");
                this.n = (IconMetaDataModel) getArguments().getSerializable("key_summary_view");
                this.m = getArguments().getBoolean("lucky_lifafa");
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_postcard_sending, viewGroup, false);
        try {
            this.f71309e = (ImageView) inflate.findViewById(R.id.iv_envelope);
            this.p = (TextView) inflate.findViewById(R.id.tv_transaction_status);
            this.f71310f = (ImageView) inflate.findViewById(R.id.iv_transaction_status);
            this.f71305a = (ImageView) inflate.findViewById(R.id.iv_back_button);
            this.o = (RelativeLayout) inflate.findViewById(R.id.rl_go_back);
            this.f71311g = (ImageView) inflate.findViewById(R.id.iv_transaction_fail);
            try {
                this.q = new TranslateAnimation(0.0f, 0.0f, -10.0f, 10.0f);
                this.q.setDuration(500);
                this.q.setRepeatCount(-1);
                this.q.setRepeatMode(2);
                this.f71309e.startAnimation(this.q);
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
            this.f71305a.setOnClickListener(this);
            this.o.setOnClickListener(this);
        } catch (Exception e3) {
            q.d(String.valueOf(e3));
        }
        try {
            a aVar = new a(this, (byte) 0);
            if (Build.VERSION.SDK_INT >= 11) {
                aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new IconMetaDataModel[]{this.n});
            } else {
                aVar.execute(new IconMetaDataModel[]{this.n});
            }
        } catch (Exception e4) {
            q.d(String.valueOf(e4));
        }
        return inflate;
    }

    private void a() {
        try {
            if (this.q != null) {
                this.q.cancel();
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f71307c = context;
        try {
            if (context instanceof b) {
                this.f71308d = (b) context;
            }
            if (this.f71306b == null) {
                this.f71306b = new i();
            }
            this.f71306b.a(getActivity(), this);
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f71308d = null;
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

    public final void a(final IJRDataModel iJRDataModel) {
        a();
        this.f71310f.setImageDrawable(this.f71307c.getResources().getDrawable(R.drawable.success_postcard));
        if (this.m) {
            this.p.setText(this.f71307c.getString(R.string.lifafa_success_message));
        } else {
            TextView textView = this.p;
            String string = this.f71307c.getString(R.string.postcard_success_message);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(this.k) ? this.f71312h : this.k;
            textView.setText(String.format(string, objArr));
        }
        this.f71310f.setVisibility(0);
        this.f71311g.setVisibility(4);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                if (f.this.getActivity() != null && !f.this.getActivity().isFinishing()) {
                    CJRPostcardSentData cJRPostcardSentData = new CJRPostcardSentData();
                    cJRPostcardSentData.setAmount(f.this.f71313i);
                    cJRPostcardSentData.setDesciptionMessage(f.this.j);
                    cJRPostcardSentData.setRecepientName(TextUtils.isEmpty(f.this.k) ? f.this.f71312h : f.this.k);
                    cJRPostcardSentData.setName(com.paytm.utility.b.h((Context) f.this.getActivity()));
                    cJRPostcardSentData.setmSummaryView(f.this.n);
                    cJRPostcardSentData.setmThemeId(f.this.l);
                    cJRPostcardSentData.setmLifafaCount(f.this.f71312h);
                    IJRDataModel iJRDataModel = iJRDataModel;
                    if (iJRDataModel instanceof CJRPostcardCreateEvent) {
                        cJRPostcardSentData.setmLifafaKey(((CJRPostcardCreateEvent) iJRDataModel).getLifafaKey());
                    }
                    cJRPostcardSentData.setLuckyLifafa(f.this.m);
                    Intent intent = new Intent(f.this.getActivity(), ViewPostcardActivity.class);
                    intent.putExtra("data", cJRPostcardSentData);
                    f.this.startActivity(intent);
                    f.this.getActivity().finish();
                }
            }
        }, 1000);
    }

    public final void b(IJRDataModel iJRDataModel) {
        if (!isDetached()) {
            a();
            this.f71305a.setVisibility(0);
            this.o.setVisibility(0);
            this.f71310f.setVisibility(4);
            this.f71311g.setVisibility(0);
            this.f71311g.setImageDrawable(this.f71307c.getResources().getDrawable(R.drawable.fail_postcard));
            if (iJRDataModel != null) {
                this.p.setText(((CJRPostcardCreateEvent) iJRDataModel).getStatusMessage());
            } else {
                this.p.setText(this.f71307c.getString(R.string.title_400));
            }
        }
    }

    public void onResume() {
        super.onResume();
    }

    class a extends AsyncTask<IconMetaDataModel, Void, IconMetaDataModel> {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            IconMetaDataModel iconMetaDataModel = (IconMetaDataModel) obj;
            if (f.this.getActivity() != null) {
                super.onPostExecute(iconMetaDataModel);
                try {
                    f.this.f71306b.a(f.this.k, f.this.f71312h, f.this.f71313i, f.this.j, f.this.l, f.this.m);
                } catch (Exception e2) {
                    q.d(String.valueOf(e2));
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public IconMetaDataModel doInBackground(IconMetaDataModel... iconMetaDataModelArr) {
            String str;
            Process.setThreadPriority(0);
            if (f.this.getActivity() == null) {
                return null;
            }
            String url1 = iconMetaDataModelArr[0].getUrl1();
            try {
                str = url1.substring(url1.lastIndexOf("/"));
            } catch (Exception unused) {
                str = url1;
            }
            if (!(f.this.getActivity() == null || f.this.getActivity().getExternalCacheDir() == null)) {
                File file = new File(f.this.getActivity().getExternalCacheDir().toString(), str);
                try {
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
                } catch (IOException e2) {
                    q.d(String.valueOf(e2));
                }
            }
            return iconMetaDataModelArr[0];
        }
    }
}

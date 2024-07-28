package net.one97.paytm.wallet.newdesign.postcard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.lifecycle.z;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel;
import net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataSuperModel;
import net.one97.paytm.common.entity.wallet.postcard.data.PostcardThemesResponseDataModel;
import net.one97.paytm.common.entity.wallet.postcard.data.ThemesIconsDataModel;
import net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.p2p.theme.e;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.d.l;
import net.one97.paytm.wallet.newdesign.utils.DelegateUtil;
import org.json.JSONObject;

public final class d implements com.paytm.network.listener.b {

    /* renamed from: g  reason: collision with root package name */
    private static d f71340g;

    /* renamed from: a  reason: collision with root package name */
    final Context f71341a;

    /* renamed from: b  reason: collision with root package name */
    PostcardThemesResponseDataModel f71342b;

    /* renamed from: c  reason: collision with root package name */
    C1447d f71343c;

    /* renamed from: d  reason: collision with root package name */
    boolean f71344d;

    /* renamed from: e  reason: collision with root package name */
    boolean f71345e;

    /* renamed from: f  reason: collision with root package name */
    int f71346f = 0;

    public interface b {
        void a(Bitmap bitmap);
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.postcard.d$d  reason: collision with other inner class name */
    public interface C1447d {
        void a();

        void a(NetworkCustomError networkCustomError);

        void a(String str, String str2);

        void a(PostcardThemesResponseDataModel postcardThemesResponseDataModel);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    private void a(NetworkCustomError networkCustomError) {
        this.f71343c.a(networkCustomError);
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a(networkCustomError);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f71340g == null) {
                f71340g = new d(context);
            }
            dVar = f71340g;
        }
        return dVar;
    }

    private d(Context context) {
        this.f71341a = context;
    }

    public final PostcardThemesResponseDataModel a(C1447d dVar) {
        this.f71343c = dVar;
        d();
        this.f71342b = f();
        return this.f71342b;
    }

    private void d() {
        if (!this.f71344d) {
            this.f71344d = true;
            e();
        }
    }

    private void e() {
        try {
            String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f71341a, "postCardThemeFetchURL");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("startLimit", "0");
            jSONObject2.put("pageSize", "10");
            jSONObject2.put("filters", new JSONObject().put("themesRequesterType", 1));
            jSONObject.put("request", jSONObject2);
            HashMap hashMap = new HashMap();
            hashMap.put("ssotoken", com.paytm.utility.a.q(this.f71341a));
            hashMap.put("Content-Type", "application/json");
            new net.one97.paytm.network.b(stringFromGTM, new PostcardThemesResponseDataModel(), (Map<String, String>) null, hashMap, jSONObject.toString()).c().observeForever(new z() {
                public final void onChanged(Object obj) {
                    d.this.a((f) obj);
                }
            });
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    private PostcardThemesResponseDataModel f() {
        Object a2 = e.a(this.f71341a, "themes_data");
        if (a2 instanceof PostcardThemesResponseDataModel) {
            return (PostcardThemesResponseDataModel) a2;
        }
        return null;
    }

    private int g() {
        PostcardThemesResponseDataModel postcardThemesResponseDataModel = this.f71342b;
        if (postcardThemesResponseDataModel == null) {
            return 0;
        }
        int size = postcardThemesResponseDataModel.getResponse().size();
        return (size + size) * 4;
    }

    public final void a() {
        String a2 = l.a(this.f71341a);
        int i2 = 0;
        while (i2 < this.f71342b.getResponse().size()) {
            try {
                ThemesIconsDataModel themes = this.f71342b.getResponse().get(i2).getThemes();
                ArrayList<IconMetaDataModel> summaryView = themes.getSummaryView();
                ArrayList<IconMetaDataModel> passbookView = themes.getPassbookView();
                a(summaryView, a2);
                a(passbookView, a2);
                i2++;
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
                return;
            }
        }
    }

    private void a(ArrayList<IconMetaDataModel> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (str.equalsIgnoreCase(arrayList.get(i2).getResolution())) {
                a(arrayList.get(i2));
            }
        }
    }

    private void a(IconMetaDataModel iconMetaDataModel) {
        int i2 = 1;
        while (i2 < 5) {
            String url1 = i2 == 1 ? iconMetaDataModel.getUrl1() : "";
            if (i2 == 2) {
                url1 = iconMetaDataModel.getUrl2();
            }
            if (i2 == 3) {
                url1 = iconMetaDataModel.getUrl3();
            }
            if (i2 == 4) {
                url1 = iconMetaDataModel.getUrl4();
            }
            if (!TextUtils.isEmpty(url1)) {
                new c(this, (byte) 0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new IconMetaDataSuperModel[]{new IconMetaDataSuperModel(iconMetaDataModel, i2, url1)});
            }
            i2++;
        }
    }

    class c extends AsyncTask<IconMetaDataSuperModel, Void, Void> {
        private c() {
        }

        /* synthetic */ c(d dVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void doInBackground(IconMetaDataSuperModel... iconMetaDataSuperModelArr) {
            String str;
            try {
                if (d.this.f71341a == null) {
                    return null;
                }
                IconMetaDataSuperModel iconMetaDataSuperModel = iconMetaDataSuperModelArr[0];
                IconMetaDataModel iconMetaDataModel = iconMetaDataSuperModel.getIconMetaDataModel();
                int itemNumber = iconMetaDataSuperModel.getItemNumber();
                File externalCacheDir = d.this.f71341a.getExternalCacheDir();
                String imageUrl = iconMetaDataSuperModel.getImageUrl();
                if (TextUtils.isEmpty(imageUrl)) {
                    return null;
                }
                try {
                    str = imageUrl.substring(imageUrl.lastIndexOf("/"));
                } catch (Exception unused) {
                    str = imageUrl;
                }
                File file = new File(externalCacheDir.toString(), str);
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(imageUrl).openConnection()));
                        httpURLConnection.setConnectTimeout(30000);
                        httpURLConnection.setReadTimeout(30000);
                        httpURLConnection.setInstanceFollowRedirects(true);
                        InputStream inputStream = httpURLConnection.getInputStream();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        d.a(inputStream, (OutputStream) fileOutputStream);
                        fileOutputStream.close();
                        fileOutputStream.flush();
                    }
                } catch (IOException e2) {
                    q.d(String.valueOf(e2));
                }
                if (itemNumber == 1) {
                    iconMetaDataModel.setCacheURL1(file.getAbsolutePath());
                }
                if (itemNumber == 2) {
                    iconMetaDataModel.setCacheURL2(file.getAbsolutePath());
                }
                if (itemNumber == 3) {
                    iconMetaDataModel.setCacheURL3(file.getAbsolutePath());
                }
                if (itemNumber == 4) {
                    iconMetaDataModel.setCacheURL4(file.getAbsolutePath());
                }
                return null;
            } catch (Exception e3) {
                q.d(String.valueOf(e3));
            }
        }
    }

    public final void b() {
        if (!this.f71345e) {
            this.f71345e = true;
            this.f71346f = g();
            if (this.f71346f > 0) {
                String a2 = l.a(this.f71341a);
                int i2 = 0;
                while (i2 < this.f71342b.getResponse().size()) {
                    try {
                        ThemesIconsDataModel themes = this.f71342b.getResponse().get(i2).getThemes();
                        if (themes != null) {
                            b(themes.getThumbnailView(), a2);
                            b(themes.getApplicationView(), a2);
                        }
                        i2++;
                    } catch (Exception e2) {
                        q.d(String.valueOf(e2));
                        return;
                    }
                }
            }
        }
    }

    private void b(ArrayList<IconMetaDataModel> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (str.equalsIgnoreCase(arrayList.get(i2).getResolution())) {
                b(arrayList.get(i2));
            }
        }
    }

    private void b(IconMetaDataModel iconMetaDataModel) {
        for (int i2 = 1; i2 < 5; i2++) {
            String str = null;
            if (i2 == 1) {
                str = iconMetaDataModel.getUrl1();
            }
            if (i2 == 2) {
                str = iconMetaDataModel.getUrl2();
            }
            if (i2 == 3) {
                str = iconMetaDataModel.getUrl3();
            }
            if (i2 == 4) {
                str = iconMetaDataModel.getUrl4();
            }
            IconMetaDataSuperModel iconMetaDataSuperModel = new IconMetaDataSuperModel(iconMetaDataModel, i2, str);
            new a(this, (byte) 0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new IconMetaDataSuperModel[]{iconMetaDataSuperModel});
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[TarConstants.EOF_BLOCK];
            while (true) {
                int read = inputStream.read(bArr, 0, TarConstants.EOF_BLOCK);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    class a extends AsyncTask<IconMetaDataSuperModel, Void, Void> {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            d dVar = d.this;
            dVar.f71346f--;
            if (d.this.f71346f == 0) {
                d dVar2 = d.this;
                dVar2.f71345e = false;
                if (dVar2.f71343c != null) {
                    d.this.f71343c.a(d.this.f71342b);
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void doInBackground(IconMetaDataSuperModel... iconMetaDataSuperModelArr) {
            String str;
            try {
                if (d.this.f71341a == null) {
                    return null;
                }
                IconMetaDataSuperModel iconMetaDataSuperModel = iconMetaDataSuperModelArr[0];
                IconMetaDataModel iconMetaDataModel = iconMetaDataSuperModel.getIconMetaDataModel();
                int itemNumber = iconMetaDataSuperModel.getItemNumber();
                File externalCacheDir = d.this.f71341a.getExternalCacheDir();
                String imageUrl = iconMetaDataSuperModel.getImageUrl();
                if (TextUtils.isEmpty(imageUrl)) {
                    return null;
                }
                try {
                    str = imageUrl.substring(imageUrl.lastIndexOf("/"));
                } catch (Exception unused) {
                    str = imageUrl;
                }
                File file = new File(externalCacheDir.toString(), str);
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(imageUrl).openConnection()));
                        httpURLConnection.setConnectTimeout(30000);
                        httpURLConnection.setReadTimeout(30000);
                        httpURLConnection.setInstanceFollowRedirects(true);
                        InputStream inputStream = httpURLConnection.getInputStream();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        d.a(inputStream, (OutputStream) fileOutputStream);
                        fileOutputStream.close();
                        fileOutputStream.flush();
                    }
                } catch (IOException e2) {
                    q.d(String.valueOf(e2));
                }
                if (itemNumber == 1) {
                    iconMetaDataModel.setCacheURL1(file.getAbsolutePath());
                }
                if (itemNumber == 2) {
                    iconMetaDataModel.setCacheURL2(file.getAbsolutePath());
                }
                if (itemNumber == 3) {
                    iconMetaDataModel.setCacheURL3(file.getAbsolutePath());
                }
                if (itemNumber == 4) {
                    iconMetaDataModel.setCacheURL4(file.getAbsolutePath());
                }
                return null;
            } catch (Exception e3) {
                q.d(String.valueOf(e3));
            }
        }
    }

    public final String a(String str, Context context) {
        PostcardThemesResponseDataModel postcardThemesResponseDataModel = this.f71342b;
        if (postcardThemesResponseDataModel != null) {
            Iterator<ThemesMetaDataModel> it2 = postcardThemesResponseDataModel.getResponse().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ThemesMetaDataModel next = it2.next();
                if (next.getId().equalsIgnoreCase(str)) {
                    if (next.getThemes().getThumbnailView() != null && next.getThemes().getThumbnailView().size() > 0) {
                        ArrayList<IconMetaDataModel> thumbnailView = next.getThemes().getThumbnailView();
                        String a2 = l.a(context);
                        IconMetaDataModel iconMetaDataModel = thumbnailView.get(0);
                        for (int i2 = 0; i2 < thumbnailView.size(); i2++) {
                            if (thumbnailView.get(i2).getResolution().equalsIgnoreCase(a2)) {
                                iconMetaDataModel = thumbnailView.get(i2);
                            }
                        }
                        return iconMetaDataModel.getCacheURL1();
                    }
                }
            }
        }
        return null;
    }

    public final Bitmap a(String str, b bVar) {
        IconMetaDataModel iconMetaDataModel;
        PostcardThemesResponseDataModel postcardThemesResponseDataModel = this.f71342b;
        if (postcardThemesResponseDataModel != null) {
            Iterator<ThemesMetaDataModel> it2 = postcardThemesResponseDataModel.getResponse().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ThemesMetaDataModel next = it2.next();
                if (next.getId().equalsIgnoreCase(str)) {
                    iconMetaDataModel = next.getThemes().getPassbookView().get(0);
                    break;
                }
            }
        }
        iconMetaDataModel = null;
        try {
            if (iconMetaDataModel.getCacheURL1().length() != 0 || iconMetaDataModel.getUrl1() == null) {
                Bitmap decodeFile = BitmapFactory.decodeFile(iconMetaDataModel.getCacheURL1());
                if (decodeFile != null) {
                    return decodeFile;
                }
                a(iconMetaDataModel, bVar);
                return null;
            }
            b(iconMetaDataModel.getUrl1(), bVar);
            return null;
        } catch (Exception unused) {
            a(iconMetaDataModel, bVar);
        }
    }

    private Bitmap b(String str, b bVar) {
        try {
            File file = new File(this.f71341a.getExternalCacheDir().toString(), str.substring(str.lastIndexOf("/")));
            if (file.exists()) {
                Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (decodeFile != null) {
                    return decodeFile;
                }
                c(str, bVar);
                return null;
            }
            c(str, bVar);
            return null;
        } catch (Exception unused) {
            c(str, bVar);
            return null;
        }
    }

    private void a(IconMetaDataModel iconMetaDataModel, b bVar) {
        if (iconMetaDataModel != null && iconMetaDataModel.getUrl1() != null) {
            c(iconMetaDataModel.getUrl1(), bVar);
        }
    }

    private void c(String str, final b bVar) {
        try {
            w.a().a(str).a((af) new af() {
                public final void onPrepareLoad(Drawable drawable) {
                }

                public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
                    if (d.this.f71341a != null) {
                        bVar.a(bitmap);
                    }
                }

                public final void onBitmapFailed(Exception exc, Drawable drawable) {
                    if (d.this.f71341a != null) {
                        bVar.a((Bitmap) null);
                    }
                }
            });
        } catch (Exception unused) {
            if (this.f71341a == null) {
                bVar.a((Bitmap) null);
            }
        }
    }

    public final List<ThemesMetaDataModel> c() {
        PostcardThemesResponseDataModel postcardThemesResponseDataModel = this.f71342b;
        if (postcardThemesResponseDataModel != null) {
            return postcardThemesResponseDataModel.getResponse();
        }
        return null;
    }

    public final boolean a(String str) {
        PostcardThemesResponseDataModel postcardThemesResponseDataModel = this.f71342b;
        if (postcardThemesResponseDataModel == null) {
            return false;
        }
        for (ThemesMetaDataModel id : postcardThemesResponseDataModel.getResponse()) {
            if (id.getId().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
            try {
                if (iJRPaytmDataModel instanceof PostcardThemesResponseDataModel) {
                    this.f71344d = false;
                    PostcardThemesResponseDataModel postcardThemesResponseDataModel = (PostcardThemesResponseDataModel) iJRPaytmDataModel;
                    if (this.f71342b == null) {
                        this.f71342b = postcardThemesResponseDataModel;
                    }
                    if (postcardThemesResponseDataModel.getStatusCode().equalsIgnoreCase("SS_0001")) {
                        DelegateUtil.INSTANCE.writeObjectToFile(this.f71341a, postcardThemesResponseDataModel, "themes_data");
                        if (this.f71343c != null) {
                            this.f71343c.a();
                        }
                    } else if ((postcardThemesResponseDataModel.getStatusCode() == null || !postcardThemesResponseDataModel.getStatusCode().equals("SH_0001")) && ((postcardThemesResponseDataModel.getStatusCode() == null || !postcardThemesResponseDataModel.getStatusCode().equals("SH_0002")) && ((postcardThemesResponseDataModel.getStatusCode() == null || !postcardThemesResponseDataModel.getStatusCode().equals("TH_0000")) && ((postcardThemesResponseDataModel.getStatusCode() == null || !postcardThemesResponseDataModel.getStatusCode().equals("TH_0001")) && ((postcardThemesResponseDataModel.getStatusCode() == null || !postcardThemesResponseDataModel.getStatusCode().equals("GE_1027")) && ((postcardThemesResponseDataModel.getStatusCode() == null || !postcardThemesResponseDataModel.getStatusCode().equals("GE_0003")) && (postcardThemesResponseDataModel.getStatusCode() == null || !postcardThemesResponseDataModel.getStatusCode().equals("TH_1000")))))))) {
                        if (this.f71343c != null) {
                            this.f71343c.a(this.f71341a.getString(R.string.error), this.f71341a.getString(R.string.some_went_wrong));
                        }
                    } else if (this.f71343c != null) {
                        this.f71343c.a(this.f71341a.getString(R.string.error), postcardThemesResponseDataModel.getStatusMessage());
                    }
                }
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }
}

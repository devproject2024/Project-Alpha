package a.a.a.a.a.h.a;

import android.os.AsyncTask;
import org.json.JSONObject;

public abstract class b extends AsyncTask<Object, Void, String> {

    /* renamed from: d  reason: collision with root package name */
    a f765d;

    /* renamed from: e  reason: collision with root package name */
    protected final C0004b f766e;

    public interface a {
        void a();
    }

    /* renamed from: a.a.a.a.a.h.a.b$b  reason: collision with other inner class name */
    public interface C0004b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(C0004b bVar) {
        this.f766e = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        a aVar = this.f765d;
        if (aVar != null) {
            aVar.a();
        }
    }
}

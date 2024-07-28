package com.google.zxing.client.android.book;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.zxing.client.android.R;
import com.google.zxing.client.android.j;
import com.google.zxing.client.android.m;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class SearchBookContentsActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f40142b = SearchBookContentsActivity.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f40143c = Pattern.compile("\\<.*?\\>");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f40144d = Pattern.compile("&lt;");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f40145e = Pattern.compile("&gt;");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f40146f = Pattern.compile("&#39;");
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f40147g = Pattern.compile("&quot;");

    /* renamed from: a  reason: collision with root package name */
    String f40148a;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public EditText f40149h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public View f40150i;
    /* access modifiers changed from: private */
    public ListView j;
    /* access modifiers changed from: private */
    public TextView k;
    private AsyncTask<String, ?, ?> l;
    private final View.OnClickListener m = new View.OnClickListener() {
        public final void onClick(View view) {
            SearchBookContentsActivity.a(SearchBookContentsActivity.this);
        }
    };
    private final View.OnKeyListener n = new View.OnKeyListener() {
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 != 66 || keyEvent.getAction() != 0) {
                return false;
            }
            SearchBookContentsActivity.a(SearchBookContentsActivity.this);
            return true;
        }
    };

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CookieSyncManager.createInstance(this);
        CookieManager.getInstance().removeExpiredCookie();
        Intent intent = getIntent();
        if (intent == null || !intent.getAction().equals("com.google.zxing.client.android.SEARCH_BOOK_CONTENTS")) {
            finish();
            return;
        }
        this.f40148a = intent.getStringExtra("ISBN");
        if (m.a(this.f40148a)) {
            setTitle(getString(R.string.sbc_name));
        } else {
            setTitle(getString(R.string.sbc_name) + ": ISBN " + this.f40148a);
        }
        setContentView(R.layout.search_book_contents);
        this.f40149h = (EditText) findViewById(R.id.query_text_view);
        String stringExtra = intent.getStringExtra("QUERY");
        if (stringExtra != null && !stringExtra.isEmpty()) {
            this.f40149h.setText(stringExtra);
        }
        this.f40149h.setOnKeyListener(this.n);
        this.f40150i = findViewById(R.id.query_button);
        this.f40150i.setOnClickListener(this.m);
        this.j = (ListView) findViewById(R.id.result_list_view);
        this.k = (TextView) LayoutInflater.from(this).inflate(R.layout.search_book_contents_header, this.j, false);
        this.j.addHeaderView(this.k);
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        this.f40149h.selectAll();
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        AsyncTask<String, ?, ?> asyncTask = this.l;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.l = null;
        }
        super.onPause();
    }

    final class a extends AsyncTask<String, Object, JSONObject> {
        private a() {
        }

        /* synthetic */ a(SearchBookContentsActivity searchBookContentsActivity, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((String[]) objArr);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null) {
                SearchBookContentsActivity.this.k.setText(R.string.msg_sbc_failed);
            } else {
                try {
                    int i2 = jSONObject.getInt("number_of_results");
                    TextView b2 = SearchBookContentsActivity.this.k;
                    b2.setText(SearchBookContentsActivity.this.getString(R.string.msg_sbc_results) + " : " + i2);
                    if (i2 > 0) {
                        JSONArray jSONArray = jSONObject.getJSONArray("search_results");
                        c.a(SearchBookContentsActivity.this.f40149h.getText().toString());
                        ArrayList arrayList = new ArrayList(i2);
                        for (int i3 = 0; i3 < i2; i3++) {
                            arrayList.add(a(jSONArray.getJSONObject(i3)));
                        }
                        SearchBookContentsActivity.this.j.setOnItemClickListener(new a(SearchBookContentsActivity.this, arrayList));
                        SearchBookContentsActivity.this.j.setAdapter(new b(SearchBookContentsActivity.this, arrayList));
                    } else {
                        if ("false".equals(jSONObject.optString("searchable"))) {
                            SearchBookContentsActivity.this.k.setText(R.string.msg_sbc_book_not_searchable);
                        }
                        SearchBookContentsActivity.this.j.setAdapter((ListAdapter) null);
                    }
                } catch (JSONException unused) {
                    String unused2 = SearchBookContentsActivity.f40142b;
                    SearchBookContentsActivity.this.j.setAdapter((ListAdapter) null);
                    SearchBookContentsActivity.this.k.setText(R.string.msg_sbc_failed);
                }
            }
            SearchBookContentsActivity.this.f40149h.setEnabled(true);
            SearchBookContentsActivity.this.f40149h.selectAll();
            SearchBookContentsActivity.this.f40150i.setEnabled(true);
        }

        private static JSONObject a(String... strArr) {
            String str;
            try {
                String str2 = strArr[0];
                String str3 = strArr[1];
                if (m.a(str3)) {
                    str = "http://www.google.com/books?id=" + str3.substring(str3.indexOf(61) + 1) + "&jscmd=SearchWithinVolume2&q=" + str2;
                } else {
                    str = "http://www.google.com/books?vid=isbn" + str3 + "&jscmd=SearchWithinVolume2&q=" + str2;
                }
                return new JSONObject(j.a(str, j.a.JSON).toString());
            } catch (IOException unused) {
                String unused2 = SearchBookContentsActivity.f40142b;
                return null;
            } catch (JSONException unused3) {
                String unused4 = SearchBookContentsActivity.f40142b;
                return null;
            }
        }

        private c a(JSONObject jSONObject) {
            String str;
            String str2;
            boolean z = false;
            try {
                String string = jSONObject.getString("page_id");
                String optString = jSONObject.optString("page_number");
                String optString2 = jSONObject.optString("snippet_text");
                if (optString == null || optString.isEmpty()) {
                    str = "";
                } else {
                    str = SearchBookContentsActivity.this.getString(R.string.msg_sbc_page) + ' ' + optString;
                }
                if (optString2 != null && !optString2.isEmpty()) {
                    z = true;
                }
                if (z) {
                    str2 = SearchBookContentsActivity.f40147g.matcher(SearchBookContentsActivity.f40146f.matcher(SearchBookContentsActivity.f40145e.matcher(SearchBookContentsActivity.f40144d.matcher(SearchBookContentsActivity.f40143c.matcher(optString2).replaceAll("")).replaceAll(SimpleComparison.LESS_THAN_OPERATION)).replaceAll(SimpleComparison.GREATER_THAN_OPERATION)).replaceAll("'")).replaceAll("\"");
                } else {
                    str2 = "(" + SearchBookContentsActivity.this.getString(R.string.msg_sbc_snippet_unavailable) + ')';
                }
                return new c(string, str, str2, z);
            } catch (JSONException unused) {
                String unused2 = SearchBookContentsActivity.f40142b;
                return new c(SearchBookContentsActivity.this.getString(R.string.msg_sbc_no_page_returned), "", "", false);
            }
        }
    }

    static /* synthetic */ void a(SearchBookContentsActivity searchBookContentsActivity) {
        String obj = searchBookContentsActivity.f40149h.getText().toString();
        if (obj != null && !obj.isEmpty()) {
            AsyncTask<String, ?, ?> asyncTask = searchBookContentsActivity.l;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            searchBookContentsActivity.l = new a(searchBookContentsActivity, (byte) 0);
            searchBookContentsActivity.l.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{obj, searchBookContentsActivity.f40148a});
            searchBookContentsActivity.k.setText(R.string.msg_sbc_searching_book);
            searchBookContentsActivity.j.setAdapter((ListAdapter) null);
            searchBookContentsActivity.f40149h.setEnabled(false);
            searchBookContentsActivity.f40150i.setEnabled(false);
        }
    }
}

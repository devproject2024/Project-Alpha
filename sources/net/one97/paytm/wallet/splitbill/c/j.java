package net.one97.paytm.wallet.splitbill.c;

import android.app.Activity;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.a.a;
import androidx.loader.b.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.TreeMap;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.b;
import net.one97.paytm.wallet.splitbill.activity.SBNewBillActivity;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;

public class j extends h implements a.C0056a<Cursor>, net.one97.paytm.wallet.splitbill.b.a {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<SBContactDetail> f72201a = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f72202b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ProgressBar f72203c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f72204d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ImageView f72205e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public EditText f72206f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f72207g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public b f72208h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Activity f72209i;
    private FragmentActivity j;
    private FrameLayout k;

    public final void a(c<Cursor> cVar) {
    }

    public final void a(SBContactDetail sBContactDetail, int i2) {
    }

    public final void c() {
    }

    public final void d() {
    }

    public final /* synthetic */ void a(c cVar, Object obj) {
        Cursor cursor = (Cursor) obj;
        if (cursor != null && this.f72202b == null) {
            this.f72202b = new a((SBNewBillActivity) this.f72209i);
            this.f72202b.execute(new Cursor[]{cursor});
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f72209i = activity;
        this.j = (FragmentActivity) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sb_new_bill_fragment, viewGroup, false);
        this.f72203c = (ProgressBar) inflate.findViewById(R.id.pb_progress);
        this.f72204d = (ImageView) inflate.findViewById(R.id.split_back_button);
        this.f72205e = (ImageView) inflate.findViewById(R.id.search_cross_button);
        this.f72207g = (RecyclerView) inflate.findViewById(R.id.vertical_recycleview);
        getActivity().getSupportLoaderManager().a(100, (Bundle) null, this);
        this.f72206f = (EditText) inflate.findViewById(R.id.search_text);
        this.k = (FrameLayout) inflate.findViewById(R.id.Groupdetail);
        this.f72204d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                j.this.f72209i.finish();
            }
        });
        this.f72205e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                j.this.f72206f.setText("");
            }
        });
        return inflate;
    }

    public final c<Cursor> a(Bundle bundle) {
        return new androidx.loader.b.b(this.f72209i, ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"display_name", "data1", "photo_uri"}, (String) null, (String[]) null, "display_name");
    }

    class a extends AsyncTask<Cursor, Void, Void> {

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<SBNewBillActivity> f72213b;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            j.this.f72203c.setVisibility(8);
            if (j.this.f72201a != null && j.this.f72201a.size() > 0) {
                j.d(j.this);
            }
            j.this.f72206f.addTextChangedListener(new TextWatcher() {
                public final void afterTextChanged(Editable editable) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    if (i4 > 0) {
                        j.this.f72205e.setVisibility(0);
                    } else {
                        j.this.f72205e.setVisibility(8);
                    }
                    if (j.this.f72208h != null) {
                        j.this.f72208h.getFilter().filter(charSequence);
                    }
                }
            });
        }

        public a(SBNewBillActivity sBNewBillActivity) {
            this.f72213b = new WeakReference<>(sBNewBillActivity);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void doInBackground(Cursor... cursorArr) {
            try {
                j.a(j.this, cursorArr[0]);
                return null;
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public final void onCancelled() {
            super.onCancelled();
            if (this.f72213b.get() != null) {
                a unused = j.this.f72202b = null;
            }
        }
    }

    private static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && Character.isDigit(str.charAt(0))) {
            try {
                if (Integer.parseInt(String.valueOf(str.charAt(0))) <= 4 || str.length() != 10) {
                    return false;
                }
                return true;
            } catch (NumberFormatException e2) {
                q.d(String.valueOf(e2));
            }
        }
        return false;
    }

    static /* synthetic */ void a(j jVar, Cursor cursor) {
        try {
            ArrayList arrayList = new ArrayList();
            cursor.moveToFirst();
            while (!cursor.isAfterLast() && (jVar.f72202b == null || !jVar.f72202b.isCancelled())) {
                String string = cursor.getString(cursor.getColumnIndex("display_name"));
                String string2 = cursor.getString(cursor.getColumnIndex("data1"));
                String string3 = cursor.getString(cursor.getColumnIndex("photo_uri"));
                String a2 = net.one97.paytm.wallet.utility.a.a(string2);
                if (a2.length() > 10) {
                    a2 = net.one97.paytm.wallet.utility.a.a(jVar.f72209i, a2);
                }
                if (a(a2)) {
                    if ((!TextUtils.isEmpty(string) && Character.isLetter(string.charAt(0))) && !arrayList.contains(a2)) {
                        arrayList.add(a2);
                        jVar.f72201a.add(new SBContactDetail(string, a2, string3, false));
                        net.one97.paytm.wallet.utility.a.d(string);
                    }
                }
                cursor.moveToNext();
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    static /* synthetic */ void d(j jVar) {
        new TreeMap();
        if (jVar.f72201a != null) {
            jVar.f72207g.setLayoutManager(new LinearLayoutManager(jVar.f72209i));
            jVar.f72208h = new b(jVar.f72209i, jVar.f72201a, jVar);
            jVar.f72207g.setAdapter(jVar.f72208h);
        }
    }
}

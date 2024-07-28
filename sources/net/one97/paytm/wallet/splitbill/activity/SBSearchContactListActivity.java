package net.one97.paytm.wallet.splitbill.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.fragment.app.q;
import androidx.loader.a.a;
import androidx.loader.b.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.AppCompatLockActivity;
import net.one97.paytm.common.widgets.IndexFastScrollRecyclerView;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.i;
import net.one97.paytm.wallet.splitbill.b.d;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;

public class SBSearchContactListActivity extends AppCompatLockActivity implements a.C0056a<Cursor>, net.one97.paytm.wallet.splitbill.b.a, d {
    /* access modifiers changed from: private */
    public boolean A = true;
    /* access modifiers changed from: private */
    public String B;
    /* access modifiers changed from: private */
    public String C;
    /* access modifiers changed from: private */
    public String D;
    /* access modifiers changed from: private */
    public ArrayList<SBContactDetail> E;
    /* access modifiers changed from: private */
    public ArrayList<SBContactDetail> F;
    /* access modifiers changed from: private */
    public String G;
    /* access modifiers changed from: private */
    public String H;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f72041e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f72042f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f72043g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<SBContactDetail> f72044h = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f72045i;
    private IndexFastScrollRecyclerView j;
    private RecyclerView k;
    /* access modifiers changed from: private */
    public net.one97.paytm.wallet.splitbill.a.a l;
    private i m;
    /* access modifiers changed from: private */
    public EditText n;
    private List<net.one97.paytm.wallet.splitbill.model.a> o = new ArrayList();
    private LinearLayout p;
    private LinearLayout q;
    /* access modifiers changed from: private */
    public ArrayList<SBContactDetail> r = new ArrayList<>();
    private boolean s = false;
    /* access modifiers changed from: private */
    public boolean t = false;
    /* access modifiers changed from: private */
    public boolean u = false;
    private ArrayList<SBContactDetail> v = new ArrayList<>();
    private RoboTextView w;
    private FrameLayout x;
    private int y = 0;
    /* access modifiers changed from: private */
    public boolean z = false;

    public final void a() {
    }

    public final void a(c<Cursor> cVar) {
    }

    public final void a(ArrayList<SBContactDetail> arrayList) {
    }

    public final void b(ArrayList<SBContactDetail> arrayList) {
    }

    public final /* synthetic */ void a(c cVar, Object obj) {
        Cursor cursor = (Cursor) obj;
        if (cursor != null && this.f72045i == null) {
            this.f72045i = new a(this);
            this.f72045i.execute(new Cursor[]{cursor});
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sb_search_contact_list_activity);
        if (getIntent() != null) {
            this.u = getIntent().getBooleanExtra("edit_bill", false);
            this.r = (ArrayList) getIntent().getSerializableExtra("list");
            ArrayList<SBContactDetail> arrayList = this.r;
            if (arrayList != null) {
                this.y = arrayList.size() - 1;
                Iterator<SBContactDetail> it2 = this.r.iterator();
                while (it2.hasNext()) {
                    SBContactDetail next = it2.next();
                    next.setSelected(true);
                    next.setPosition(-1);
                    if ("You".equalsIgnoreCase(next.getmName())) {
                        this.z = next.getmIsSelectedForPay();
                        it2.remove();
                    }
                }
            } else {
                this.r = new ArrayList<>();
            }
            this.E = (ArrayList) getIntent().getSerializableExtra("paid_contact_list");
            this.F = (ArrayList) getIntent().getSerializableExtra("split_contact_list");
            this.A = getIntent().getBooleanExtra("is_equal", true);
            this.C = getIntent().getStringExtra("bill_name");
            this.B = getIntent().getStringExtra("bill_amount");
            this.D = getIntent().getStringExtra("bill_id");
            this.s = getIntent().getBooleanExtra("show_group_widget", false);
            this.t = getIntent().getBooleanExtra("non_group_bill", false);
            this.G = getIntent().getStringExtra("amount");
            this.H = getIntent().getStringExtra("your_id");
        }
        getSupportLoaderManager().a(100, (Bundle) null, this);
        this.n = (EditText) findViewById(R.id.search_text);
        this.f72041e = (ImageView) findViewById(R.id.split_back_button);
        this.f72042f = (ImageView) findViewById(R.id.search_cross_button);
        this.f72043g = (ProgressBar) findViewById(R.id.pb_progress);
        this.q = (LinearLayout) findViewById(R.id.ll_proceed);
        this.k = (RecyclerView) findViewById(R.id.horizontal_recycleview);
        this.k.setLayoutManager(new LinearLayoutManager(this, 0, true));
        this.m = new i(this, this, true);
        this.k.setAdapter(this.m);
        this.j = (IndexFastScrollRecyclerView) findViewById(R.id.rv_contact_list);
        this.p = (LinearLayout) findViewById(R.id.list_empty_layout_container);
        this.x = (FrameLayout) findViewById(R.id.frame_container);
        this.w = (RoboTextView) findViewById(R.id.tv_toolbar_title);
        if (this.G != null) {
            this.w.setText("Select Contacts to Split Bill");
        } else {
            this.w.setText("Select Contacts");
        }
        this.f72041e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBSearchContactListActivity.this.finish();
            }
        });
        this.f72042f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBSearchContactListActivity.this.n.setText("");
            }
        });
        this.q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (SBSearchContactListActivity.this.u) {
                    if (!SBSearchContactListActivity.this.r.isEmpty()) {
                        Intent intent = new Intent(SBSearchContactListActivity.this, SBEnterBillActivity.class);
                        ArrayList arrayList = new ArrayList();
                        SBContactDetail sBContactDetail = new SBContactDetail();
                        sBContactDetail.setmName("You");
                        sBContactDetail.setAdmin(true);
                        sBContactDetail.setmIsSelectedForPay(SBSearchContactListActivity.this.z);
                        sBContactDetail.setMobile(b.l((Context) SBSearchContactListActivity.this));
                        sBContactDetail.setUserId(SBSearchContactListActivity.this.H);
                        arrayList.add(sBContactDetail);
                        arrayList.addAll(SBSearchContactListActivity.this.r);
                        intent.putExtra("list", arrayList);
                        intent.putExtra("paid_contact_list", SBSearchContactListActivity.this.E);
                        intent.putExtra("split_contact_list", SBSearchContactListActivity.this.F);
                        intent.putExtra("equally_switch", SBSearchContactListActivity.this.A);
                        intent.putExtra("bill_name", SBSearchContactListActivity.this.C);
                        intent.putExtra("bill_amount", SBSearchContactListActivity.this.B);
                        intent.putExtra("edit_bill", true);
                        intent.putExtra("bill_id", SBSearchContactListActivity.this.D);
                        intent.putExtra("is_from_contact_selection", true);
                        intent.putExtra("your_id", SBSearchContactListActivity.this.H);
                        intent.setFlags(67108864);
                        SBSearchContactListActivity.this.startActivity(intent);
                        SBSearchContactListActivity.this.finish();
                    }
                } else if (SBSearchContactListActivity.this.r.isEmpty()) {
                } else {
                    if (SBSearchContactListActivity.this.t) {
                        Intent intent2 = new Intent(SBSearchContactListActivity.this, SBEnterBillActivity.class);
                        ArrayList arrayList2 = new ArrayList();
                        SBContactDetail sBContactDetail2 = new SBContactDetail();
                        sBContactDetail2.setmName("You");
                        sBContactDetail2.setAdmin(true);
                        sBContactDetail2.setmIsSelectedForPay(SBSearchContactListActivity.this.z);
                        sBContactDetail2.setMobile(b.l((Context) SBSearchContactListActivity.this));
                        sBContactDetail2.setUserId(SBSearchContactListActivity.this.H);
                        arrayList2.add(sBContactDetail2);
                        arrayList2.addAll(SBSearchContactListActivity.this.r);
                        intent2.putExtra("list", arrayList2);
                        intent2.putExtra("amount_from_deeplink", SBSearchContactListActivity.this.G);
                        intent2.putExtra("your_id", SBSearchContactListActivity.this.H);
                        SBSearchContactListActivity.this.startActivity(intent2);
                        return;
                    }
                    Intent intent3 = new Intent(SBSearchContactListActivity.this, SBCreateGroupActivity.class);
                    intent3.putExtra("list", SBSearchContactListActivity.this.r);
                    SBSearchContactListActivity.this.startActivity(intent3);
                }
            }
        });
        if (this.s) {
            net.one97.paytm.wallet.splitbill.c.i iVar = new net.one97.paytm.wallet.splitbill.c.i();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("non_group_bill", this.t);
            iVar.setArguments(bundle2);
            q a2 = getSupportFragmentManager().a();
            a2.b(R.id.frame_container, iVar, "GROUPTAG");
            a2.b();
            return;
        }
        this.x.setVisibility(8);
    }

    public final void a(SBContactDetail sBContactDetail, int i2) {
        this.n.setText("");
        if (sBContactDetail.getmIsSelectedForPay()) {
            Toast.makeText(this, "Cannot remove the one who has paid the bill", 0).show();
        } else if (b.ab(this).equalsIgnoreCase(sBContactDetail.getMobile())) {
            Toast.makeText(this, "You will be automatically added to this bill.", 0).show();
        } else {
            if (!this.r.isEmpty()) {
                if (b(this.r, sBContactDetail)) {
                    a(this.r, sBContactDetail);
                    this.y--;
                    a(this.y);
                }
                this.q.setVisibility(0);
                if (sBContactDetail.isSelected()) {
                    sBContactDetail.setPosition(i2);
                    this.y++;
                    this.r.add(sBContactDetail);
                    if (!(this.E == null || this.F == null)) {
                        sBContactDetail.setAmount("0");
                        this.E.add(sBContactDetail);
                        this.F.add(sBContactDetail);
                    }
                }
            } else if (sBContactDetail.isSelected()) {
                sBContactDetail.setPosition(i2);
                this.r.add(sBContactDetail);
                this.y++;
                if (!(this.E == null || this.F == null)) {
                    sBContactDetail.setAmount("0");
                    this.E.add(sBContactDetail);
                    this.F.add(sBContactDetail);
                }
            }
            if (this.r.isEmpty()) {
                this.q.setVisibility(8);
                this.k.setVisibility(8);
            } else {
                this.q.setVisibility(0);
                this.k.setVisibility(0);
            }
            if (this.r != null) {
                this.k.setVisibility(0);
                i iVar = this.m;
                iVar.f71830b = this.r;
                iVar.notifyDataSetChanged();
                this.l.notifyItemChanged(i2);
                a(this.y);
            }
            if (this.r.isEmpty()) {
                this.k.setVisibility(8);
            }
        }
    }

    private static void a(ArrayList<SBContactDetail> arrayList, SBContactDetail sBContactDetail) {
        Iterator<SBContactDetail> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (it2.next().getMobile().equalsIgnoreCase(sBContactDetail.getMobile())) {
                it2.remove();
            }
        }
    }

    private static boolean b(ArrayList<SBContactDetail> arrayList, SBContactDetail sBContactDetail) {
        Iterator<SBContactDetail> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (it2.next().getMobile().equalsIgnoreCase(sBContactDetail.getMobile())) {
                return true;
            }
        }
        return false;
    }

    public final void a(SBContactDetail sBContactDetail) {
        if (!sBContactDetail.getmIsSelectedForPay()) {
            ArrayList<SBContactDetail> arrayList = this.r;
            if (arrayList != null) {
                if (b(arrayList, sBContactDetail)) {
                    this.r.remove(sBContactDetail);
                    this.y--;
                    ArrayList<SBContactDetail> arrayList2 = this.E;
                    if (!(arrayList2 == null || this.F == null)) {
                        a(arrayList2, sBContactDetail);
                        a(this.F, sBContactDetail);
                    }
                }
                a(this.y);
                this.m.notifyDataSetChanged();
                if (this.r.isEmpty()) {
                    this.k.setVisibility(8);
                    this.q.setVisibility(8);
                }
                Iterator<SBContactDetail> it2 = this.f72044h.iterator();
                while (it2.hasNext()) {
                    SBContactDetail next = it2.next();
                    if (next.getMobile().equalsIgnoreCase(sBContactDetail.getMobile())) {
                        next.setSelected(false);
                        if (sBContactDetail.getPosition() != -1) {
                            this.l.notifyItemChanged(sBContactDetail.getPosition());
                        } else {
                            this.l.notifyDataSetChanged();
                        }
                    }
                }
                return;
            }
            return;
        }
        Toast.makeText(this, "Cannot remove the one who has paid the bill", 0).show();
    }

    private static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && Character.isDigit(str.charAt(0))) {
            try {
                if (Integer.parseInt(String.valueOf(str.charAt(0))) <= 4 || str.length() != 10) {
                    return false;
                }
                return true;
            } catch (NumberFormatException e2) {
                com.paytm.utility.q.d(String.valueOf(e2));
            }
        }
        return false;
    }

    private int b(SBContactDetail sBContactDetail) {
        if (this.o == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            if (!this.o.get(i2).f72242a && this.o.get(i2).f72243b.getMobile().equalsIgnoreCase(sBContactDetail.getMobile())) {
                return i2;
            }
        }
        return -1;
    }

    public final c<Cursor> a(Bundle bundle) {
        return new androidx.loader.b.b(this, ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"display_name", "data1", "photo_uri"}, (String) null, (String[]) null, "display_name");
    }

    public final void c() {
        this.p.setVisibility(0);
    }

    public final void d() {
        this.p.setVisibility(8);
    }

    class a extends AsyncTask<Cursor, Void, Void> {

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<SBSearchContactListActivity> f72050b;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            SBSearchContactListActivity.this.f72043g.setVisibility(8);
            if (SBSearchContactListActivity.this.f72044h != null && SBSearchContactListActivity.this.f72044h.size() > 0) {
                SBSearchContactListActivity.p(SBSearchContactListActivity.this);
                SBSearchContactListActivity.q(SBSearchContactListActivity.this);
            }
            SBSearchContactListActivity.this.n.addTextChangedListener(new TextWatcher() {
                public final void afterTextChanged(Editable editable) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    if (i4 > 0) {
                        SBSearchContactListActivity.this.f72042f.setVisibility(0);
                    } else {
                        SBSearchContactListActivity.this.f72042f.setVisibility(8);
                    }
                    if (SBSearchContactListActivity.this.l != null) {
                        SBSearchContactListActivity.this.l.getFilter().filter(charSequence.toString().toLowerCase());
                    }
                }
            });
        }

        public a(SBSearchContactListActivity sBSearchContactListActivity) {
            this.f72050b = new WeakReference<>(sBSearchContactListActivity);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void doInBackground(Cursor... cursorArr) {
            try {
                SBSearchContactListActivity.a(SBSearchContactListActivity.this, cursorArr[0]);
                return null;
            } catch (Exception e2) {
                com.paytm.utility.q.d(String.valueOf(e2));
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public final void onCancelled() {
            super.onCancelled();
            if (this.f72050b.get() != null) {
                a unused = SBSearchContactListActivity.this.f72045i = null;
            }
        }
    }

    private void a(int i2) {
        if (i2 != 0) {
            RoboTextView roboTextView = this.w;
            roboTextView.setText(i2 + " Contacts Selected");
        } else if (this.G != null) {
            this.w.setText("Select Contacts to Split Bill");
        } else {
            this.w.setText("Select Contacts");
        }
    }

    static /* synthetic */ void a(SBSearchContactListActivity sBSearchContactListActivity, Cursor cursor) {
        try {
            ArrayList arrayList = new ArrayList();
            cursor.moveToFirst();
            while (!cursor.isAfterLast() && (sBSearchContactListActivity.f72045i == null || !sBSearchContactListActivity.f72045i.isCancelled())) {
                String string = cursor.getString(cursor.getColumnIndex("display_name"));
                String string2 = cursor.getString(cursor.getColumnIndex("data1"));
                String string3 = cursor.getString(cursor.getColumnIndex("photo_uri"));
                String a2 = net.one97.paytm.wallet.utility.a.a(string2);
                if (a2.length() > 10) {
                    a2 = net.one97.paytm.wallet.utility.a.a((Activity) sBSearchContactListActivity, a2);
                }
                if (a(a2)) {
                    if ((!TextUtils.isEmpty(string) && Character.isLetter(string.charAt(0))) && !arrayList.contains(a2)) {
                        arrayList.add(a2);
                        sBSearchContactListActivity.f72044h.add(new SBContactDetail(string, a2, string3, false));
                        net.one97.paytm.wallet.utility.a.d(string);
                    }
                }
                cursor.moveToNext();
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e2) {
            com.paytm.utility.q.d(String.valueOf(e2));
        }
    }

    static /* synthetic */ void p(SBSearchContactListActivity sBSearchContactListActivity) {
        TreeMap treeMap = new TreeMap();
        ArrayList<SBContactDetail> arrayList = sBSearchContactListActivity.f72044h;
        if (arrayList != null) {
            Iterator<SBContactDetail> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                SBContactDetail next = it2.next();
                StringBuilder sb = new StringBuilder();
                sb.append(next.getmName().charAt(0));
                if (treeMap.containsKey(sb.toString())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(next.getmName().charAt(0));
                    ((List) treeMap.get(sb2.toString())).add(next);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(next);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(next.getmName().charAt(0));
                    treeMap.put(sb3.toString(), arrayList2);
                }
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            sBSearchContactListActivity.o.add(new net.one97.paytm.wallet.splitbill.model.a(true, (SBContactDetail) null, (String) entry.getKey()));
            for (SBContactDetail aVar : (List) entry.getValue()) {
                sBSearchContactListActivity.o.add(new net.one97.paytm.wallet.splitbill.model.a(false, aVar, ""));
            }
        }
        sBSearchContactListActivity.j.setLayoutManager(new LinearLayoutManager(sBSearchContactListActivity));
        List<net.one97.paytm.wallet.splitbill.model.a> list = sBSearchContactListActivity.o;
        if (list != null) {
            sBSearchContactListActivity.l = new net.one97.paytm.wallet.splitbill.a.a(sBSearchContactListActivity, list, sBSearchContactListActivity, sBSearchContactListActivity.r, sBSearchContactListActivity.u);
        }
        sBSearchContactListActivity.j.setAdapter(sBSearchContactListActivity.l);
        if (sBSearchContactListActivity.u && sBSearchContactListActivity.r.size() > 0) {
            i iVar = sBSearchContactListActivity.m;
            iVar.f71830b = sBSearchContactListActivity.r;
            iVar.notifyDataSetChanged();
            ArrayList<SBContactDetail> arrayList3 = sBSearchContactListActivity.f72044h;
            if (!(arrayList3 == null || arrayList3.size() <= 0 || sBSearchContactListActivity.l == null)) {
                Iterator<SBContactDetail> it3 = sBSearchContactListActivity.r.iterator();
                while (it3.hasNext()) {
                    SBContactDetail next2 = it3.next();
                    Iterator<SBContactDetail> it4 = sBSearchContactListActivity.f72044h.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            break;
                        }
                        SBContactDetail next3 = it4.next();
                        if (next3.getMobile().equalsIgnoreCase(next2.getMobile())) {
                            next3.setSelected(true);
                            next2.setPosition(sBSearchContactListActivity.b(next3));
                            break;
                        }
                    }
                }
                sBSearchContactListActivity.l.notifyDataSetChanged();
                sBSearchContactListActivity.a(sBSearchContactListActivity.y);
            }
            if (sBSearchContactListActivity.y > 0) {
                sBSearchContactListActivity.q.setVisibility(0);
            }
        }
    }

    static /* synthetic */ void q(SBSearchContactListActivity sBSearchContactListActivity) {
        sBSearchContactListActivity.j.setIndexTextSize(10);
        sBSearchContactListActivity.j.setIndexBarColor("#FFFFFF");
        sBSearchContactListActivity.j.setIndexBarCornerRadius(0);
        sBSearchContactListActivity.j.setTypeface(Typeface.SANS_SERIF);
        sBSearchContactListActivity.j.setIndexbarMargin(0.0f);
        sBSearchContactListActivity.j.setIndexbarWidth(40.0f);
        sBSearchContactListActivity.j.setPreviewPadding(0);
        sBSearchContactListActivity.j.setIndexBarTextColor("#999999");
        sBSearchContactListActivity.j.setIndexBarVisibility(true);
        sBSearchContactListActivity.j.setIndexBarHighLateTextVisibility(true);
    }
}

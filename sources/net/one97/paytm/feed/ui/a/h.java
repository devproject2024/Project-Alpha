package net.one97.paytm.feed.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.language.FeedLanguageData;
import net.one97.paytm.feed.utility.j;
import org.json.JSONArray;

public final class h extends i implements c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f34855a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<FeedLanguageData> f34856b;

    /* renamed from: d  reason: collision with root package name */
    private a f34857d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f34858e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f34859f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f34860g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f34861h;

    public final void b() {
        HashMap hashMap = this.f34861h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    static final class c extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(h hVar) {
            super(1);
            this.this$0 = hVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            ArrayList b2 = this.this$0.f34855a;
            if (b2 != null) {
                net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
                String arrayList = b2.toString();
                k.a((Object) arrayList, "language.toString()");
                net.one97.paytm.feed.repository.b.a(arrayList);
            }
            net.one97.paytm.feed.repository.b bVar2 = net.one97.paytm.feed.repository.b.f34608a;
            net.one97.paytm.feed.repository.b.l();
            this.this$0.dismiss();
        }
    }

    public final int a() {
        return R.layout.feed_oneoff_language;
    }

    public final void a(View view) {
        a aVar;
        k.c(view, "view");
        View findViewById = view.findViewById(R.id.feed_language_recyclerview);
        k.a((Object) findViewById, "view.findViewById(R.id.feed_language_recyclerview)");
        this.f34858e = (RecyclerView) findViewById;
        RecyclerView recyclerView = this.f34858e;
        if (recyclerView == null) {
            k.a("recyclerview");
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator((RecyclerView.f) null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f34865c, 1, false));
        this.f34857d = new a(this);
        recyclerView.setAdapter(this.f34857d);
        View findViewById2 = view.findViewById(R.id.feed_language_continue);
        k.a((Object) findViewById2, "view.findViewById(R.id.feed_language_continue)");
        this.f34859f = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.close);
        k.a((Object) findViewById3, "view.findViewById(R.id.close)");
        this.f34860g = (ImageView) findViewById3;
        TextView textView = this.f34859f;
        if (textView == null) {
            k.a("proceed");
        }
        textView.setOnClickListener(new a(this));
        ImageView imageView = this.f34860g;
        if (imageView == null) {
            k.a("close");
        }
        imageView.setOnClickListener(new b(this));
        ArrayList<FeedLanguageData> arrayList = this.f34856b;
        if (arrayList != null && (aVar = this.f34857d) != null) {
            aVar.a(arrayList);
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f34862a;

        a(h hVar) {
            this.f34862a = hVar;
        }

        public final void onClick(View view) {
            Context context = this.f34862a.f34865c;
            if (context != null) {
                j jVar = j.f35397a;
                if (j.e(context)) {
                    h.a(this.f34862a);
                } else {
                    Toast.makeText(this.f34862a.f34865c, R.string.language_no_internet, 0).show();
                }
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f34863a;

        b(h hVar) {
            this.f34863a = hVar;
        }

        public final void onClick(View view) {
            this.f34863a.dismiss();
            net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
            net.one97.paytm.feed.repository.b.l();
        }
    }

    public final void a(FeedLanguageData feedLanguageData, CheckBox checkBox) {
        k.c(feedLanguageData, "feedLanguageData");
        k.c(checkBox, "checkBox");
        ArrayList<String> arrayList = this.f34855a;
        Integer num = null;
        Boolean valueOf = arrayList != null ? Boolean.valueOf(arrayList.contains(feedLanguageData.getLanguageCode())) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue()) {
            ArrayList<String> arrayList2 = this.f34855a;
            if (arrayList2 == null) {
                k.a();
            }
            arrayList2.remove(feedLanguageData.getLanguageCode());
            checkBox.setChecked(false);
            feedLanguageData.setSelected(false);
        } else {
            ArrayList<String> arrayList3 = this.f34855a;
            if (arrayList3 != null) {
                arrayList3.add(feedLanguageData.getLanguageCode());
            }
            checkBox.setChecked(true);
            feedLanguageData.setSelected(true);
        }
        ArrayList<String> arrayList4 = this.f34855a;
        if (arrayList4 != null) {
            num = Integer.valueOf(arrayList4.size());
        }
        if (num == null) {
            k.a();
        }
        if (num.intValue() > 0) {
            TextView textView = this.f34859f;
            if (textView == null) {
                k.a("proceed");
            }
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = this.f34859f;
        if (textView2 == null) {
            k.a("proceed");
        }
        textView2.setVisibility(8);
    }

    public final void onCancel(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
        net.one97.paytm.feed.repository.b.l();
    }

    public static final /* synthetic */ void a(h hVar) {
        JSONArray jSONArray = new JSONArray(hVar.f34855a);
        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
        net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
        Context context = hVar.f34865c;
        if (context == null) {
            k.a();
        }
        String jSONArray2 = jSONArray.toString();
        k.a((Object) jSONArray2, "jsArray.toString()");
        a2.a(context, jSONArray2, (kotlin.g.a.b<? super String, x>) new c(hVar));
    }
}

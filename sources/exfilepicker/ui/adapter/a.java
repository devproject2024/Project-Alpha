package exfilepicker.ui.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import exfilepicker.a;
import exfilepicker.a.a.b;
import exfilepicker.a.b;
import exfilepicker.ui.adapter.a.c;
import exfilepicker.ui.adapter.a.d;
import exfilepicker.ui.adapter.a.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a extends RecyclerView.a<exfilepicker.ui.adapter.a.a> {

    /* renamed from: a  reason: collision with root package name */
    public List<File> f46201a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f46202b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public exfilepicker.ui.a.a f46203c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46204d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46205e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46206f;

    /* renamed from: g  reason: collision with root package name */
    public exfilepicker.ui.a.a f46207g;

    /* renamed from: h  reason: collision with root package name */
    public List<File> f46208h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<File> f46209i = new ArrayList<>();
    private boolean j;
    private View k;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        exfilepicker.ui.adapter.a.a aVar = (exfilepicker.ui.adapter.a.a) vVar;
        if (getItemViewType(i2) == 10) {
            ((d) aVar).f46212a = this.f46207g;
        } else if (getItemViewType(i2) == 5 || getItemViewType(i2) == 4) {
            e eVar = (e) aVar;
            eVar.f46212a = this.f46203c;
            eVar.f46220b.setText("..");
            eVar.f46221c.setVisibility(8);
            if (eVar.f46222d != null) {
                eVar.f46222d.setVisibility(8);
            }
            eVar.f46223e.setImageResource(R.drawable.chat_efp__ic_up);
        } else {
            aVar.a(a(i2), this.j, b(i2), this.f46203c);
        }
    }

    public final int getItemViewType(int i2) {
        if (this.k == null || i2 != 0) {
            return (!this.f46206f || i2 != 0) ? this.f46204d ? a(i2).isDirectory() ? 3 : 1 : a(i2).isDirectory() ? 2 : 0 : this.f46204d ? 4 : 5;
        }
        return 10;
    }

    public final int getItemCount() {
        if (this.f46206f) {
            return this.f46201a.size() + 1;
        }
        return this.f46201a.size();
    }

    public final void a(List<File> list, a.b bVar) {
        this.f46202b.clear();
        this.f46201a.clear();
        this.f46201a.addAll(list);
        a(bVar);
    }

    public final File a(int i2) {
        if (this.f46206f) {
            return this.f46201a.get(i2 - 1);
        }
        return this.f46201a.get(i2);
    }

    public final void a() {
        this.j = false;
        if (!this.j) {
            this.f46202b.clear();
        }
        if (this.f46205e) {
            this.f46201a = new ArrayList(this.f46209i);
        }
        notifyDataSetChanged();
    }

    public final boolean b(int i2) {
        return this.f46202b.contains(a(i2).getName());
    }

    public final void a(a.b bVar) {
        Collections.sort(this.f46201a, b.a(bVar));
        notifyDataSetChanged();
    }

    public final void b() {
        this.f46202b.clear();
        notifyDataSetChanged();
    }

    public final void a(boolean z) {
        this.f46204d = z;
        notifyDataSetChanged();
    }

    private static View a(ViewGroup viewGroup, int i2) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
    }

    public final void a(final String str) {
        this.f46201a.clear();
        exfilepicker.a.b.a(this.f46208h, this.f46201a, (b.a) null);
        if (!TextUtils.isEmpty(str)) {
            exfilepicker.a.b.a(this.f46201a, new b.a<File>() {
                public final /* synthetic */ boolean a(Object obj) {
                    return ((File) obj).getName().toUpperCase().indexOf(str.toUpperCase()) == -1;
                }
            });
        }
        a(a.b.NAME_ASC);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new c(a(viewGroup, R.layout.chat_layout_files_list_item));
        }
        if (i2 == 1) {
            return new c(a(viewGroup, R.layout.chat_layout_files_grid_item));
        }
        if (i2 == 2) {
            return new exfilepicker.ui.adapter.a.b(a(viewGroup, R.layout.chat_layout_files_list_item));
        }
        if (i2 == 4) {
            return new e(a(viewGroup, R.layout.chat_layout_files_list_item));
        }
        if (i2 == 5) {
            return new e(a(viewGroup, R.layout.chat_layout_files_list_item));
        }
        if (i2 != 10) {
            return new exfilepicker.ui.adapter.a.b(a(viewGroup, R.layout.chat_layout_files_grid_item));
        }
        return new d(this.k);
    }
}

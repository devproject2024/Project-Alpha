package g.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import g.a.a.a;
import g.a.a.c;
import g.a.a.d;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public abstract class b<T extends d<V, U>, V extends c, U extends a> extends h implements View.OnClickListener, c {

    /* renamed from: a  reason: collision with root package name */
    protected T f13526a;

    /* renamed from: b  reason: collision with root package name */
    protected View f13527b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f13528c;

    /* renamed from: d  reason: collision with root package name */
    private Context f13529d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f13530e;

    public abstract int a();

    public abstract T b();

    public abstract U c();

    public void onAttach(Context context) {
        k.c(context, "context");
        this.f13528c = (Activity) context;
        this.f13529d = context;
        super.onAttach(context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13526a = b();
        T t = this.f13526a;
        if (t == null) {
            k.a("mPresenter");
        }
        t.f13532b = c();
        if (bundle == null) {
            getArguments();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(a(), viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(getLayoutId(), container, false)");
        this.f13527b = inflate;
        T t = this.f13526a;
        if (t == null) {
            k.a("mPresenter");
        }
        T t2 = this;
        k.c(t2, "view");
        t.f13531a = t2;
        View view = this.f13527b;
        if (view == null) {
            k.a("mView");
        }
        return view;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
        T t = this.f13526a;
        if (t == null) {
            k.a("mPresenter");
        }
        t.f13531a = null;
        HashMap hashMap = this.f13530e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        T t = this.f13526a;
        if (t == null) {
            k.a("mPresenter");
        }
        t.f13532b = null;
    }
}

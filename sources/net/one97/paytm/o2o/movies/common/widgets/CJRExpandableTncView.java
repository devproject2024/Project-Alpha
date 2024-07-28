package net.one97.paytm.o2o.movies.common.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b.f;
import com.paytm.utility.RoboTextView;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.d;

public class CJRExpandableTncView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private RoboTextView f75216a;

    /* renamed from: b  reason: collision with root package name */
    private RoboTextView f75217b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f75218c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f75219d;

    /* renamed from: e  reason: collision with root package name */
    private RoboTextView f75220e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f75221f;

    /* renamed from: g  reason: collision with root package name */
    private ViewGroup f75222g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f75223h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f75224i;
    private String j;
    private String k;
    private String l;
    /* access modifiers changed from: private */
    public a m;
    private Drawable n;
    private Drawable o;
    private int p;
    private List<String> q;
    private LayoutInflater r;

    public interface a {
    }

    public CJRExpandableTncView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CJRExpandableTncView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CJRExpandableTncView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f75224i = false;
        this.p = 3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CJRExpandableTncView);
        this.p = obtainStyledAttributes.getInt(R.styleable.CJRExpandableTncView_minVisibleLines, 3);
        obtainStyledAttributes.recycle();
        setOrientation(1);
        this.r = LayoutInflater.from(context);
        this.r.inflate(R.layout.expandable_tnc_view, this);
        this.f75216a = (RoboTextView) findViewById(R.id.title);
        this.f75217b = (RoboTextView) findViewById(R.id.title_grey);
        this.f75218c = (LinearLayout) findViewById(R.id.description_lin_lay);
        this.f75219d = (LinearLayout) findViewById(R.id.description_lin_lay2);
        this.f75220e = (RoboTextView) findViewById(R.id.view_more);
        this.f75221f = (ViewGroup) findViewById(R.id.container);
        this.f75222g = (ViewGroup) findViewById(R.id.view_more_parent);
        this.f75223h = (ImageView) findViewById(R.id.indicator);
        this.n = f.a(getResources(), net.one97.paytm.common.assets.R.drawable.ic_expand, getContext().getTheme());
        this.o = f.a(getResources(), net.one97.paytm.common.assets.R.drawable.ic_collapse, getContext().getTheme());
        this.j = getContext().getString(R.string.view_more);
        this.k = getContext().getString(R.string.view_less);
        this.f75220e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CJRExpandableTncView cJRExpandableTncView = CJRExpandableTncView.this;
                boolean unused = cJRExpandableTncView.f75224i = !cJRExpandableTncView.f75224i;
                if (CJRExpandableTncView.this.f75224i) {
                    CJRExpandableTncView.this.a();
                } else {
                    CJRExpandableTncView.this.b();
                }
                if (CJRExpandableTncView.this.m != null) {
                    a unused2 = CJRExpandableTncView.this.m;
                    boolean unused3 = CJRExpandableTncView.this.f75224i;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f75220e.setText(this.k);
        this.f75223h.setImageDrawable(this.o);
        a(true);
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f75220e.setText(this.j);
        this.f75223h.setImageDrawable(this.n);
        a(false);
    }

    private void a(boolean z) {
        this.f75218c.setVisibility(0);
        if (!d.a((List) this.q)) {
            if (this.f75218c.getChildCount() < 2) {
                for (int i2 = 0; i2 < this.p; i2++) {
                    View inflate = this.r.inflate(R.layout.tnc_view_row, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.tnc_view_row_text);
                    if (this.q.size() > i2) {
                        textView.setText(this.q.get(i2));
                        this.f75218c.addView(inflate);
                    }
                }
            }
            if (this.q.size() <= this.p) {
                this.f75222g.setVisibility(8);
            }
            if (z) {
                if (this.f75219d.getChildCount() == 0) {
                    for (int i3 = 3; i3 < this.q.size(); i3++) {
                        View inflate2 = this.r.inflate(R.layout.tnc_view_row, (ViewGroup) null);
                        ((TextView) inflate2.findViewById(R.id.tnc_view_row_text)).setText(this.q.get(i3));
                        this.f75219d.addView(inflate2);
                    }
                }
                this.f75219d.setVisibility(0);
                return;
            }
            this.f75219d.setVisibility(8);
        }
    }

    public void setMinimumVisibleLine(int i2) {
        if (i2 > 0) {
            this.p = i2;
        } else {
            this.p = 3;
        }
        if (this.f75224i) {
            a();
        } else {
            b();
        }
    }

    public void setTitle(String str, int i2) {
        this.l = str;
        if (i2 == 5) {
            this.f75217b.setText(str);
            this.f75217b.setVisibility(0);
            this.f75216a.setVisibility(8);
            return;
        }
        this.f75216a.setText(str);
        this.f75217b.setVisibility(8);
        this.f75216a.setVisibility(0);
    }

    public String getTitle() {
        return this.l;
    }

    public void setDescription(List<String> list) {
        this.q = list;
        if (this.f75224i) {
            a();
        } else {
            b();
        }
    }

    public List<String> getDescriptionList() {
        return this.q;
    }

    public void setAnchorText(String str, String str2) {
        this.j = str;
        this.k = str2;
        this.f75220e.setText(this.f75224i ? this.k : this.j);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.f75221f.setPadding(i2, i3, i4, i5);
    }

    public LinearLayout getDescriptionLinLay1() {
        return this.f75218c;
    }

    public LinearLayout getDescriptionLinLay2() {
        return this.f75219d;
    }

    public TextView getTitleView() {
        return this.f75216a;
    }

    public void setOnExpandStateChangeListener(a aVar) {
        this.m = aVar;
    }

    public a getOnInfoViewStateChangeListener() {
        return this.m;
    }
}

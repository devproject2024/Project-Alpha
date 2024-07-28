package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

public final class AlertController {
    NestedScrollView A;
    int B = 0;
    Drawable C;
    ImageView D;
    TextView E;
    TextView F;
    View G;
    ListAdapter H;
    int I = -1;
    int J;
    int K;
    int L;
    int M;
    int N;
    int O;
    boolean P;
    int Q = 0;
    Handler R;
    final View.OnClickListener S = new View.OnClickListener() {
        public final void onClick(View view) {
            Message message;
            if (view == AlertController.this.o && AlertController.this.q != null) {
                message = Message.obtain(AlertController.this.q);
            } else if (view != AlertController.this.s || AlertController.this.u == null) {
                message = (view != AlertController.this.w || AlertController.this.y == null) ? null : Message.obtain(AlertController.this.y);
            } else {
                message = Message.obtain(AlertController.this.u);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController.this.R.obtainMessage(1, AlertController.this.f993b).sendToTarget();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final Context f992a;

    /* renamed from: b  reason: collision with root package name */
    final f f993b;

    /* renamed from: c  reason: collision with root package name */
    final Window f994c;

    /* renamed from: d  reason: collision with root package name */
    final int f995d;

    /* renamed from: e  reason: collision with root package name */
    CharSequence f996e;

    /* renamed from: f  reason: collision with root package name */
    CharSequence f997f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f998g;

    /* renamed from: h  reason: collision with root package name */
    View f999h;

    /* renamed from: i  reason: collision with root package name */
    int f1000i;
    int j;
    int k;
    int l;
    int m;
    boolean n = false;
    Button o;
    CharSequence p;
    Message q;
    Drawable r;
    Button s;
    CharSequence t;
    Message u;
    Drawable v;
    Button w;
    CharSequence x;
    Message y;
    Drawable z;

    static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f1037a;

        public b(DialogInterface dialogInterface) {
            this.f1037a = new WeakReference<>(dialogInterface);
        }

        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f1037a.get(), message.what);
            } else if (i2 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public AlertController(Context context, f fVar, Window window) {
        this.f992a = context;
        this.f993b = fVar;
        this.f994c = window;
        this.R = new b(fVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.f995d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        fVar.supportRequestWindowFeature(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void a(CharSequence charSequence) {
        this.f996e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void a(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (onClickListener != null) {
            message = this.R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i2 == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else if (i2 == -1) {
            this.p = charSequence;
            this.q = message;
            this.r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void a(int i2) {
        this.C = null;
        this.B = i2;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (i2 != 0) {
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
            return;
        }
        imageView.setVisibility(8);
    }

    static ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    static void a(View view, View view2, View view3) {
        int i2 = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i2 = 4;
            }
            view3.setVisibility(i2);
        }
    }

    static void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static class RecycleListView extends ListView {

        /* renamed from: a  reason: collision with root package name */
        private final int f1014a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1015b;

        public RecycleListView(Context context) {
            this(context, (AttributeSet) null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.f1015b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f1014a = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f1014a, getPaddingRight(), z2 ? getPaddingBottom() : this.f1015b);
            }
        }
    }

    public static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public boolean O = true;

        /* renamed from: a  reason: collision with root package name */
        public final Context f1016a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f1017b;

        /* renamed from: c  reason: collision with root package name */
        public int f1018c = 0;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f1019d;

        /* renamed from: e  reason: collision with root package name */
        public int f1020e = 0;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f1021f;

        /* renamed from: g  reason: collision with root package name */
        public View f1022g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f1023h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f1024i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public boolean r;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        public a(Context context) {
            this.f1016a = context;
            this.r = true;
            this.f1017b = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    static class c extends ArrayAdapter<CharSequence> {
        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final boolean hasStableIds() {
            return true;
        }

        public c(Context context, int i2, CharSequence[] charSequenceArr) {
            super(context, i2, 16908308, charSequenceArr);
        }
    }
}

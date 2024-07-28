package net.one97.paytm.hotel4.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.paytm.utility.b.b.d;
import com.paytm.utility.b.b.e;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.travel.customViews.c;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotel4.service.model.ordersummary.MetaData;
import net.one97.paytm.hotel4.view.a.i;
import net.one97.paytm.hotel4.view.a.y;
import net.one97.paytm.hotels2.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0498a f28631a = new C0498a((byte) 0);

    public static final void a(TextView textView, double d2) {
        C0498a.a(textView, d2);
    }

    /* renamed from: net.one97.paytm.hotel4.utils.a$a  reason: collision with other inner class name */
    public static final class C0498a {
        private C0498a() {
        }

        public /* synthetic */ C0498a(byte b2) {
            this();
        }

        public static void a(ImageView imageView, String str, Integer num) {
            if (num != null) {
                int intValue = num.intValue();
                if (intValue != 0) {
                    str = str + "?imwidth=" + num;
                } else if (intValue == 0) {
                    str = str + "?imwidth=" + c.a(c.a());
                }
            }
            a(imageView, str, e.NORMAL);
        }

        public static void b(ImageView imageView, String str, Integer num) {
            if (num != null) {
                int intValue = num.intValue();
                if (intValue != 0) {
                    str = str + "?imwidth=" + num;
                } else if (intValue == 0) {
                    str = str + "?imwidth=" + c.a(c.a());
                }
            }
            a(imageView, str, e.HIGH);
        }

        public static void a(ImageView imageView, String str) {
            a(imageView, str, e.NORMAL);
        }

        public static void a(ImageView imageView, String str, e eVar) {
            String str2;
            String str3 = null;
            if (str != null) {
                str2 = new l(" ").replace((CharSequence) str, "%20");
            } else {
                str2 = null;
            }
            if (imageView != null) {
                if (str2 != null && str2.length() > 0) {
                    if (str2 == null) {
                        k.a();
                    }
                    if (p.a((CharSequence) str2, (CharSequence) f.a(), false)) {
                        str3 = String.valueOf(System.currentTimeMillis() / 300000);
                    }
                }
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                b.a aVar = com.paytm.utility.b.b.f43744a;
                Context context = imageView.getContext();
                k.a((Object) context, "it.context");
                b.a.C0750a a2 = b.a.a(context);
                a2.f43753a = str2;
                Drawable a3 = androidx.core.content.b.a(imageView.getContext(), R.drawable.h4_ic_noimg_icon);
                if (a3 == null) {
                    k.a();
                }
                k.a((Object) a3, "ContextCompat.getDrawabl…wable.h4_ic_noimg_icon)!!");
                b.a.C0750a a4 = a2.a((Object) a3).a(d.PREFER_RGB_565);
                if (eVar == null) {
                    eVar = e.NORMAL;
                }
                b.a.C0750a a5 = a4.a(eVar).a(com.paytm.utility.b.b.a.RESOURCE_DISK_CACHE);
                a5.u = str3;
                a5.p = true;
                a5.o = true;
                a5.a(imageView, (com.paytm.utility.b.b.b<?>) new b(imageView));
            }
        }

        /* renamed from: net.one97.paytm.hotel4.utils.a$a$b */
        public static final class b implements com.paytm.utility.b.b.b<Drawable> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ImageView f28633a;

            public final void onError(Exception exc) {
            }

            b(ImageView imageView) {
                this.f28633a = imageView;
            }

            public final /* synthetic */ void onSuccess(Object obj, com.paytm.utility.b.b.c cVar) {
                this.f28633a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }

        public static void a(TextView textView, double d2) {
            if (textView == null) {
                k.a();
            }
            textView.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + com.paytm.utility.b.a(d2));
            if (d2 == 0.0d) {
                textView.setVisibility(4);
            } else {
                textView.setVisibility(0);
            }
        }

        /* renamed from: net.one97.paytm.hotel4.utils.a$a$a  reason: collision with other inner class name */
        static final class C0499a implements View.OnTouchListener {

            /* renamed from: a  reason: collision with root package name */
            public static final C0499a f28632a = new C0499a();

            C0499a() {
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (view != null) {
                    C0498a aVar = a.f28631a;
                    k.c(view, "v");
                    Object systemService = view.getContext().getSystemService("input_method");
                    if (systemService != null) {
                        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    } else {
                        throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                    }
                }
                return false;
            }
        }
    }

    public static final void a(TextView textView) {
        if (textView == null) {
            k.a();
        }
        textView.setPaintFlags(textView.getPaintFlags() | 16);
    }

    public static final void a(ImageView imageView, String str, e eVar, Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            if (intValue != 0) {
                str = str + "?imwidth=" + num;
            } else if (intValue == 0) {
                str = str + "?imwidth=" + c.a(c.a());
            }
        }
        C0498a.a(imageView, str, eVar);
    }

    public static final void b(TextView textView, double d2) {
        if (textView == null) {
            k.a();
        }
        textView.setText("Proceed to Pay  ₹" + com.paytm.utility.b.a(d2));
        if (d2 == 0.0d) {
            textView.setVisibility(4);
        } else {
            textView.setVisibility(0);
        }
    }

    public static final void c(TextView textView, double d2) {
        String str = FilterPriceSliderFragment.RUPEE_SYMBOL + com.paytm.utility.b.a(d2);
        if (textView == null) {
            k.a();
        }
        if (k.a((Object) str, (Object) textView.getText())) {
            textView.setVisibility(4);
        } else {
            textView.setVisibility(0);
        }
    }

    public static final void a(TextView textView, List<String> list) {
        if (list == null || list.size() <= 0) {
            if (textView == null) {
                k.a();
            }
            textView.setVisibility(4);
            return;
        }
        if (textView == null) {
            k.a();
        }
        textView.setText(list.get(0));
        textView.setVisibility(0);
    }

    public static final void a(TextView textView, String str) {
        if (str == null) {
            k.a();
        }
        CharSequence charSequence = str;
        if (p.a(charSequence, (CharSequence) "+", false)) {
            if (textView == null) {
                k.a();
            }
            textView.setText(charSequence);
            textView.setVisibility(0);
            return;
        }
        if (textView == null) {
            k.a();
        }
        textView.setVisibility(8);
    }

    public static final void a(ImageView imageView, String str) {
        if (str == null) {
            return;
        }
        if (p.a((CharSequence) str, (CharSequence) "+", false)) {
            if (imageView == null) {
                k.a();
            }
            imageView.setVisibility(8);
            return;
        }
        C0498a.a(imageView, str);
        if (imageView == null) {
            k.a();
        }
        imageView.setVisibility(0);
    }

    public static final void a(RecyclerView recyclerView, MetaData metaData) {
        if (recyclerView != null && metaData != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            List<CJRRoom> list = metaData.roomsDetails;
            k.a((Object) list, "meta.roomsDetails");
            Context context = recyclerView.getContext();
            k.a((Object) context, "it.context");
            recyclerView.setAdapter(new i(list, metaData, context));
        }
    }

    public static final void b(RecyclerView recyclerView, MetaData metaData) {
        if (recyclerView != null && metaData != null && metaData.getTaxes().size() > 0) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            List<androidx.core.g.d<String, String>> taxes = metaData.getTaxes();
            k.a((Object) taxes, "meta.taxes");
            recyclerView.setAdapter(new y(taxes));
        }
    }

    public static final void b(TextView textView, String str) {
        if (str != null) {
            if (textView != null) {
                if (Integer.parseInt(str) > 3) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                textView.setText(str + textView.getContext().getString(R.string.h4_star_hotel));
            }
        } else if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public static final void a(View view) {
        if (view != null) {
            view.setOnTouchListener(C0498a.C0499a.f28632a);
        }
    }
}

package com.paytmmall.artifact.search.a;

import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.search.a.c;
import com.paytmmall.artifact.search.entity.CJRSearchCuration;
import com.paytmmall.artifact.search.entity.CJRSearchLayout;
import com.paytmmall.artifact.search.entity.CJRSearchPage;
import com.paytmmall.artifact.search.entity.CJRSearchPageItem;
import com.paytmmall.artifact.search.entity.CJRSearchPopularProduct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRSearchLayout> f15927a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRSearchLayout> f15928b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRSearchPopularProduct> f15929c;

    /* renamed from: d  reason: collision with root package name */
    private String f15930d = "CJRSearchAdapter";

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f15931e;

    /* renamed from: f  reason: collision with root package name */
    private Context f15932f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<a> f15933g;

    /* renamed from: h  reason: collision with root package name */
    private d f15934h;

    /* renamed from: i  reason: collision with root package name */
    private final int f15935i = 0;
    private final int j = 1;
    private final int k = 2;
    private final int l = 4;
    private int m;
    private b n;

    public interface b {
        void a(String str, String str2, String str3, String str4, HashMap<String, String> hashMap, CJRSearchCuration cJRSearchCuration);

        void a(String str, String str2, HashMap<String, String> hashMap, CJRSearchCuration cJRSearchCuration);

        void b();

        void b(String str);
    }

    public c(Context context, CJRSearchPage cJRSearchPage, b bVar) {
        this.f15931e = LayoutInflater.from(context);
        this.f15932f = context;
        this.n = bVar;
        this.f15927a = cJRSearchPage.getKeyWordsLayoutList();
        this.f15928b = cJRSearchPage.getProductsLayoutList();
        this.f15929c = cJRSearchPage.getmSearchPopularProductsList();
        this.f15933g = new ArrayList<>();
        this.m = d.b(this.f15932f);
    }

    public final int getCount() {
        return this.f15929c == null ? this.f15933g.size() : this.f15933g.size() + 1;
    }

    public final Object getItem(int i2) {
        return this.f15933g.get(i2);
    }

    public final long getItemId(int i2) {
        ArrayList<a> arrayList = this.f15933g;
        if (arrayList == null || i2 >= arrayList.size()) {
            return 0;
        }
        return (long) this.f15933g.get(i2).hashCode();
    }

    public final int getItemViewType(int i2) {
        return i2 == this.f15933g.size() ? 3 : 4;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        ViewGroup viewGroup2 = viewGroup;
        if (this.f15933g != null) {
            if (getItemViewType(i2) == 4) {
                a aVar = this.f15933g.get(i2);
                CJRSearchCuration searchCuration = aVar.f15936a.getSearchCuration();
                String str = null;
                if (aVar != null) {
                    int i3 = aVar.f15937b;
                    String str2 = "";
                    if (i3 == 0) {
                        View inflate = this.f15931e.inflate(R.layout.mall_lyt_search_item, viewGroup2, false);
                        TextView textView = (TextView) inflate.findViewById(R.id.search_item_text);
                        TextView textView2 = (TextView) inflate.findViewById(R.id.search_item_count);
                        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.search_item_view);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.keyword_image);
                        ((RelativeLayout) inflate.findViewById(R.id.single_keyword_container)).setVisibility(0);
                        d.c(textView);
                        String text = aVar.f15936a.getText();
                        if (aVar.f15936a != null) {
                            str = aVar.f15936a.getmTextHtml();
                        }
                        String count = aVar.f15936a.getCount();
                        if (aVar.f15936a.getmAutoSearchMetaData() != null && aVar.f15936a.getmAutoSearchMetaData().size() > 0) {
                            for (Map.Entry next : aVar.f15936a.getmAutoSearchMetaData().entrySet()) {
                                str2 = str2 + ((String) next.getKey()) + "=" + ((String) next.getValue()) + ";";
                                inflate = inflate;
                            }
                        }
                        view = inflate;
                        HashMap<String, String> hashMap = aVar.f15936a.getmFilterAttributes();
                        if (count != null && count.trim().length() > 0) {
                            try {
                                if (Integer.parseInt(count) > 0) {
                                    textView2.setText(String.format(" (%s)", new Object[]{d.c(count)}));
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (str != null) {
                            textView.setText(Html.fromHtml(str));
                        } else if (aVar.f15939d != null) {
                            textView.setText(aVar.f15939d);
                        } else {
                            textView.setText(text);
                        }
                        imageView.setOnClickListener(new View.OnClickListener(text, searchCuration) {
                            private final /* synthetic */ String f$1;
                            private final /* synthetic */ CJRSearchCuration f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void onClick(View view) {
                                c.this.a(this.f$1, this.f$2, view);
                            }
                        });
                        relativeLayout.setOnClickListener(new View.OnClickListener(text, str2, hashMap, searchCuration) {
                            private final /* synthetic */ String f$1;
                            private final /* synthetic */ String f$2;
                            private final /* synthetic */ HashMap f$3;
                            private final /* synthetic */ CJRSearchCuration f$4;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                                this.f$3 = r4;
                                this.f$4 = r5;
                            }

                            public final void onClick(View view) {
                                c.this.a(this.f$1, this.f$2, this.f$3, this.f$4, view);
                            }
                        });
                    } else if (i3 == 1) {
                        View inflate2 = this.f15931e.inflate(R.layout.mall_lyt_search_item, viewGroup2, false);
                        TextView textView3 = (TextView) inflate2.findViewById(R.id.search_item_main_text);
                        TextView textView4 = (TextView) inflate2.findViewById(R.id.search_item_cat_count);
                        TextView textView5 = (TextView) inflate2.findViewById(R.id.search_item_cat_text);
                        RelativeLayout relativeLayout2 = (RelativeLayout) inflate2.findViewById(R.id.keyword_cat_container);
                        relativeLayout2.setVisibility(0);
                        d.c(textView3);
                        d.c(textView5);
                        String text2 = aVar.f15936a.getText();
                        String count2 = aVar.f15936a.getCount();
                        if (aVar.f15936a.getmAutoSearchMetaData() != null && aVar.f15936a.getmAutoSearchMetaData().size() > 0) {
                            for (Map.Entry next2 : aVar.f15936a.getmAutoSearchMetaData().entrySet()) {
                                str2 = str2 + ((String) next2.getKey()) + "=" + ((String) next2.getValue()) + ";";
                            }
                        }
                        HashMap<String, String> hashMap2 = aVar.f15936a.getmFilterAttributes();
                        if (count2 != null && count2.trim().length() > 0) {
                            try {
                                if (Integer.parseInt(count2) > 0) {
                                    textView4.setText(String.format(" (%s)", new Object[]{d.c(count2)}));
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        CJRSearchPageItem cJRSearchPageItem = aVar.f15936a.getSearchPageItemList().get(aVar.f15938c);
                        if (aVar.f15939d != null) {
                            textView3.setText(aVar.f15939d);
                        } else {
                            textView3.setText(text2);
                        }
                        if (cJRSearchPageItem != null && !TextUtils.isEmpty(cJRSearchPageItem.getText())) {
                            textView5.setText(Html.fromHtml(this.f15932f.getResources().getString(R.string.search_in, new Object[]{cJRSearchPageItem.getText()})));
                        }
                        relativeLayout2.setOnClickListener(new View.OnClickListener(cJRSearchPageItem, text2, str2, hashMap2, searchCuration) {
                            private final /* synthetic */ CJRSearchPageItem f$1;
                            private final /* synthetic */ String f$2;
                            private final /* synthetic */ String f$3;
                            private final /* synthetic */ HashMap f$4;
                            private final /* synthetic */ CJRSearchCuration f$5;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                                this.f$3 = r4;
                                this.f$4 = r5;
                                this.f$5 = r6;
                            }

                            public final void onClick(View view) {
                                c.this.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, view);
                            }
                        });
                        return inflate2;
                    } else if (i3 == 2) {
                        View inflate3 = this.f15931e.inflate(R.layout.mall_lyt_search_item, viewGroup2, false);
                        RelativeLayout relativeLayout3 = (RelativeLayout) inflate3.findViewById(R.id.product_container);
                        relativeLayout3.setVisibility(0);
                        TextView textView6 = (TextView) inflate3.findViewById(R.id.search_item_product_text);
                        TextView textView7 = (TextView) inflate3.findViewById(R.id.txt_price_product);
                        ImageView imageView2 = (ImageView) inflate3.findViewById(R.id.imgview);
                        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
                        int i4 = this.m;
                        layoutParams.width = (int) (((float) i4) * 1.5f);
                        layoutParams.height = (int) (((float) i4) * 1.5f);
                        d.c(textView6);
                        d.c(textView7);
                        String text3 = aVar.f15936a.getText();
                        String price = aVar.f15936a.getPrice();
                        textView6.setText(text3);
                        textView7.setText(price);
                        relativeLayout3.setOnClickListener(new View.OnClickListener(aVar, searchCuration) {
                            private final /* synthetic */ c.a f$1;
                            private final /* synthetic */ CJRSearchCuration f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void onClick(View view) {
                                c.this.a(this.f$1, this.f$2, view);
                            }
                        });
                        com.paytmmall.artifact.d.a.c.a(aVar.f15936a.getImageUrl(), imageView2);
                        return inflate3;
                    }
                }
            } else {
                View inflate4 = this.f15931e.inflate(R.layout.mall_lyt_container_popular_search, viewGroup2, false);
                RecyclerView recyclerView = (RecyclerView) inflate4.findViewById(R.id.lyt_popular_products);
                LinearLayout linearLayout = (LinearLayout) inflate4.findViewById(R.id.products_container);
                ArrayList<CJRSearchPopularProduct> arrayList = this.f15929c;
                if (arrayList == null || arrayList.size() <= 0) {
                    linearLayout.setVisibility(8);
                } else {
                    linearLayout.setVisibility(0);
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(this.f15932f, 0, false));
                d dVar = this.f15934h;
                if (dVar != null) {
                    recyclerView.setAdapter(dVar);
                    d dVar2 = this.f15934h;
                    dVar2.f15942b = this.f15929c;
                    dVar2.notifyDataSetChanged();
                    this.f15934h.notifyDataSetChanged();
                    return inflate4;
                }
                this.f15934h = new d(this.f15932f, this.f15929c);
                recyclerView.setAdapter(this.f15934h);
                return inflate4;
            }
        }
        return view;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, CJRSearchCuration cJRSearchCuration, View view) {
        this.n.b(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, HashMap hashMap, CJRSearchCuration cJRSearchCuration, View view) {
        this.n.a(str, str2, hashMap, cJRSearchCuration);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRSearchPageItem cJRSearchPageItem, String str, String str2, HashMap hashMap, CJRSearchCuration cJRSearchCuration, View view) {
        if (cJRSearchPageItem == null) {
            return;
        }
        if (!TextUtils.isEmpty(cJRSearchPageItem.getSearchUrl())) {
            this.n.a(cJRSearchPageItem.getSearchUrl(), cJRSearchPageItem.getText(), str, str2, hashMap, cJRSearchCuration);
        } else if (!TextUtils.isEmpty(cJRSearchPageItem.getUrl())) {
            this.n.a(cJRSearchPageItem.getUrl(), cJRSearchPageItem.getText(), str, str2, hashMap, cJRSearchCuration);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, CJRSearchCuration cJRSearchCuration, View view) {
        b bVar = this.n;
        aVar.f15936a.getSeourl();
        bVar.b();
    }

    public final void a(CharSequence charSequence) {
        if (charSequence != null) {
            try {
                if (charSequence.length() > 2) {
                    ArrayList<a> arrayList = new ArrayList<>();
                    for (int i2 = 0; i2 < this.f15927a.size(); i2++) {
                        if (this.f15927a.get(i2).getSearchPageItemList().size() > 0) {
                            for (int i3 = 0; i3 < this.f15927a.get(i2).getSearchPageItemList().size(); i3++) {
                                arrayList.add(new a(this, this.f15927a.get(i2), 1, i3, a(this.f15927a.get(i2).getText(), charSequence.toString()), (byte) 0));
                            }
                        } else {
                            arrayList.add(new a(this, this.f15927a.get(i2), 0, -1, a(this.f15927a.get(i2).getText(), charSequence.toString()), (byte) 0));
                        }
                    }
                    for (int i4 = 0; i4 < this.f15928b.size(); i4++) {
                        arrayList.add(new a(this, this.f15928b.get(i4), 2, -1, a(this.f15927a.get(i4).getText(), charSequence.toString()), (byte) 0));
                    }
                    this.f15933g = arrayList;
                    notifyDataSetChanged();
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        this.f15933g = new ArrayList<>();
        notifyDataSetChanged();
    }

    private static SpannableStringBuilder a(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2.length() <= 0 || str2.trim().equals("")) {
            return spannableStringBuilder.append(str);
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        String lowerCase2 = str2.toLowerCase(Locale.getDefault());
        int indexOf = lowerCase.indexOf(lowerCase2);
        int length = lowerCase2.length() + indexOf;
        if (indexOf < 0 || length < 0) {
            return spannableStringBuilder.append(str);
        }
        spannableStringBuilder.append(str);
        spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, length, 0);
        return spannableStringBuilder;
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        CJRSearchLayout f15936a;

        /* renamed from: b  reason: collision with root package name */
        int f15937b;

        /* renamed from: c  reason: collision with root package name */
        int f15938c;

        /* renamed from: d  reason: collision with root package name */
        SpannableStringBuilder f15939d;

        /* synthetic */ a(c cVar, CJRSearchLayout cJRSearchLayout, int i2, int i3, SpannableStringBuilder spannableStringBuilder, byte b2) {
            this(cJRSearchLayout, i2, i3, spannableStringBuilder);
        }

        private a(CJRSearchLayout cJRSearchLayout, int i2, int i3, SpannableStringBuilder spannableStringBuilder) {
            this.f15936a = cJRSearchLayout;
            this.f15937b = i2;
            this.f15938c = i3;
            this.f15939d = spannableStringBuilder;
        }
    }
}

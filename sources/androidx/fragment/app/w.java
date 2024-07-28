package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class w extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    ListAdapter f3546a;

    /* renamed from: b  reason: collision with root package name */
    ListView f3547b;

    /* renamed from: c  reason: collision with root package name */
    View f3548c;

    /* renamed from: d  reason: collision with root package name */
    TextView f3549d;

    /* renamed from: e  reason: collision with root package name */
    View f3550e;

    /* renamed from: f  reason: collision with root package name */
    View f3551f;

    /* renamed from: g  reason: collision with root package name */
    CharSequence f3552g;

    /* renamed from: h  reason: collision with root package name */
    boolean f3553h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f3554i = new Handler();
    private final Runnable j = new Runnable() {
        public final void run() {
            w.this.f3547b.focusableViewAvailable(w.this.f3547b);
        }
    };
    private final AdapterView.OnItemClickListener k = new AdapterView.OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        }
    };

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, (AttributeSet) null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(requireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a();
    }

    public void onDestroyView() {
        this.f3554i.removeCallbacks(this.j);
        this.f3547b = null;
        this.f3553h = false;
        this.f3551f = null;
        this.f3550e = null;
        this.f3548c = null;
        this.f3549d = null;
        super.onDestroyView();
    }

    private void a(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.f3546a != null;
        this.f3546a = listAdapter;
        ListView listView = this.f3547b;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (!this.f3553h && !z2) {
                if (requireView().getWindowToken() != null) {
                    z = true;
                }
                a(true, z);
            }
        }
    }

    private void a(boolean z, boolean z2) {
        a();
        View view = this.f3550e;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.f3553h != z) {
            this.f3553h = z;
            if (z) {
                if (z2) {
                    view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                    this.f3551f.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                } else {
                    view.clearAnimation();
                    this.f3551f.clearAnimation();
                }
                this.f3550e.setVisibility(8);
                this.f3551f.setVisibility(0);
                return;
            }
            if (z2) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                this.f3551f.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
            } else {
                view.clearAnimation();
                this.f3551f.clearAnimation();
            }
            this.f3550e.setVisibility(0);
            this.f3551f.setVisibility(8);
        }
    }

    private void a() {
        if (this.f3547b == null) {
            View view = getView();
            if (view != null) {
                if (view instanceof ListView) {
                    this.f3547b = (ListView) view;
                } else {
                    this.f3549d = (TextView) view.findViewById(16711681);
                    TextView textView = this.f3549d;
                    if (textView == null) {
                        this.f3548c = view.findViewById(16908292);
                    } else {
                        textView.setVisibility(8);
                    }
                    this.f3550e = view.findViewById(16711682);
                    this.f3551f = view.findViewById(16711683);
                    View findViewById = view.findViewById(16908298);
                    if (findViewById instanceof ListView) {
                        this.f3547b = (ListView) findViewById;
                        View view2 = this.f3548c;
                        if (view2 != null) {
                            this.f3547b.setEmptyView(view2);
                        } else {
                            CharSequence charSequence = this.f3552g;
                            if (charSequence != null) {
                                this.f3549d.setText(charSequence);
                                this.f3547b.setEmptyView(this.f3549d);
                            }
                        }
                    } else if (findViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    } else {
                        throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                    }
                }
                this.f3553h = true;
                this.f3547b.setOnItemClickListener(this.k);
                ListAdapter listAdapter = this.f3546a;
                if (listAdapter != null) {
                    this.f3546a = null;
                    a(listAdapter);
                } else if (this.f3550e != null) {
                    a(false, false);
                }
                this.f3554i.post(this.j);
                return;
            }
            throw new IllegalStateException("Content view not yet created");
        }
    }
}

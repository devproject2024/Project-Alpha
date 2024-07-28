package net.one97.paytm.dynamicModule;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.a.a.i;
import java.util.ArrayList;
import net.one97.paytm.g.e;
import net.one97.paytm.g.g;
import net.one97.paytm.paytm_finance.R;

public class DynamicModuleLoaderAdapter extends RecyclerView.a<RecyclerView.v> {
    private int VIEW_TYPE_MULTIPLE = 1;
    private int VIEW_TYPE_SINGLE = 0;
    private Activity activity;
    private long lastClickTime = 0;
    private ArrayList<DynamicModuleLoaderItem> mArrayList;
    private Context mContext;
    private String source;

    public DynamicModuleLoaderAdapter(Context context, Activity activity2, String str) {
        this.mContext = context;
        this.mArrayList = new ArrayList<>();
        this.activity = activity2;
        this.source = str;
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == this.VIEW_TYPE_MULTIPLE) {
            return new MultipleModuleViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.multiple_item_dynamic_module_loader, viewGroup, false));
        }
        if (this.source.equalsIgnoreCase(DynamicModuleHelper.downloadSourceBottomSheet)) {
            return new SingleModuleViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.single_item_dynamic_module_loader, viewGroup, false));
        }
        return new SingleModuleFullViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.single_item_fullscreen_dynamic_module_loader, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        DynamicModuleLoaderItem dynamicModuleLoaderItem = this.mArrayList.get(i2);
        if (vVar instanceof SingleModuleViewHolder) {
            SingleModuleViewHolder singleModuleViewHolder = (SingleModuleViewHolder) vVar;
            singleModuleViewHolder.binding.j.setText(dynamicModuleLoaderItem.getTitle());
            setIcon(singleModuleViewHolder.binding.f50501a, dynamicModuleLoaderItem.getIconUrl());
            if (dynamicModuleLoaderItem.isFailed()) {
                singleModuleViewHolder.binding.f50502b.setVisibility(0);
                singleModuleViewHolder.binding.f50504d.setVisibility(4);
                singleModuleViewHolder.binding.f50507g.setText(dynamicModuleLoaderItem.getStatusText());
                singleModuleViewHolder.binding.f50508h.setOnClickListener(new View.OnClickListener(dynamicModuleLoaderItem) {
                    private final /* synthetic */ DynamicModuleLoaderItem f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        DynamicModuleLoaderAdapter.this.lambda$onBindViewHolder$0$DynamicModuleLoaderAdapter(this.f$1, view);
                    }
                });
                return;
            }
            singleModuleViewHolder.binding.f50502b.setVisibility(4);
            singleModuleViewHolder.binding.f50504d.setVisibility(0);
            if (dynamicModuleLoaderItem.isRequestInitiatedButNotDownload()) {
                singleModuleViewHolder.binding.f50503c.setIndeterminate(true);
                singleModuleViewHolder.binding.f50506f.setText("");
                return;
            }
            singleModuleViewHolder.binding.f50503c.setIndeterminate(false);
            singleModuleViewHolder.binding.f50503c.setProgress(dynamicModuleLoaderItem.getDownloadPercent());
            TextView textView = singleModuleViewHolder.binding.f50506f;
            textView.setText(dynamicModuleLoaderItem.getDownloadPercent() + "%");
        } else if (vVar instanceof SingleModuleFullViewHolder) {
            SingleModuleFullViewHolder singleModuleFullViewHolder = (SingleModuleFullViewHolder) vVar;
            if (this.source.equalsIgnoreCase(DynamicModuleHelper.downloadSourceActivity)) {
                singleModuleFullViewHolder.binding.f50511b.setVisibility(0);
                singleModuleFullViewHolder.binding.f50511b.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        DynamicModuleLoaderAdapter.this.lambda$onBindViewHolder$1$DynamicModuleLoaderAdapter(view);
                    }
                });
            } else {
                singleModuleFullViewHolder.binding.f50511b.setVisibility(8);
            }
            singleModuleFullViewHolder.binding.l.setText(dynamicModuleLoaderItem.getTitle());
            setIcon(singleModuleFullViewHolder.binding.f50510a, dynamicModuleLoaderItem.getIconUrl());
            if (dynamicModuleLoaderItem.isFailed()) {
                singleModuleFullViewHolder.binding.f50512c.setVisibility(0);
                singleModuleFullViewHolder.binding.f50514e.setVisibility(4);
                singleModuleFullViewHolder.binding.f50518i.setText(dynamicModuleLoaderItem.getStatusText());
                singleModuleFullViewHolder.binding.j.setOnClickListener(new View.OnClickListener(dynamicModuleLoaderItem) {
                    private final /* synthetic */ DynamicModuleLoaderItem f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        DynamicModuleLoaderAdapter.this.lambda$onBindViewHolder$2$DynamicModuleLoaderAdapter(this.f$1, view);
                    }
                });
                return;
            }
            singleModuleFullViewHolder.binding.f50512c.setVisibility(4);
            singleModuleFullViewHolder.binding.f50514e.setVisibility(0);
            if (dynamicModuleLoaderItem.isRequestInitiatedButNotDownload()) {
                singleModuleFullViewHolder.binding.f50513d.setIndeterminate(true);
                singleModuleFullViewHolder.binding.f50517h.setText("");
                return;
            }
            singleModuleFullViewHolder.binding.f50513d.setIndeterminate(false);
            singleModuleFullViewHolder.binding.f50513d.setProgress(dynamicModuleLoaderItem.getDownloadPercent());
            TextView textView2 = singleModuleFullViewHolder.binding.f50517h;
            textView2.setText(dynamicModuleLoaderItem.getDownloadPercent() + "%");
        } else {
            MultipleModuleViewHolder multipleModuleViewHolder = (MultipleModuleViewHolder) vVar;
            multipleModuleViewHolder.binding.f50497f.setText(dynamicModuleLoaderItem.getTitle());
            setIcon(multipleModuleViewHolder.binding.f50492a, dynamicModuleLoaderItem.getIconUrl());
            if (dynamicModuleLoaderItem.isFailed()) {
                multipleModuleViewHolder.binding.f50495d.setVisibility(0);
                multipleModuleViewHolder.binding.f50496e.setVisibility(0);
                multipleModuleViewHolder.binding.f50493b.setVisibility(8);
                multipleModuleViewHolder.binding.f50494c.setVisibility(8);
                multipleModuleViewHolder.binding.f50495d.setText(dynamicModuleLoaderItem.getStatusText());
                multipleModuleViewHolder.binding.f50496e.setOnClickListener(new View.OnClickListener(dynamicModuleLoaderItem) {
                    private final /* synthetic */ DynamicModuleLoaderItem f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        DynamicModuleLoaderAdapter.this.lambda$onBindViewHolder$3$DynamicModuleLoaderAdapter(this.f$1, view);
                    }
                });
                return;
            }
            multipleModuleViewHolder.binding.f50495d.setVisibility(8);
            multipleModuleViewHolder.binding.f50496e.setVisibility(8);
            multipleModuleViewHolder.binding.f50493b.setVisibility(0);
            multipleModuleViewHolder.binding.f50494c.setVisibility(0);
            if (dynamicModuleLoaderItem.isRequestInitiatedButNotDownload()) {
                multipleModuleViewHolder.binding.f50493b.setIndeterminate(true);
                multipleModuleViewHolder.binding.f50494c.setText("");
                return;
            }
            multipleModuleViewHolder.binding.f50493b.setIndeterminate(false);
            multipleModuleViewHolder.binding.f50493b.setProgress(dynamicModuleLoaderItem.getDownloadPercent());
            TextView textView3 = multipleModuleViewHolder.binding.f50494c;
            textView3.setText(dynamicModuleLoaderItem.getDownloadPercent() + "%");
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$DynamicModuleLoaderAdapter(DynamicModuleLoaderItem dynamicModuleLoaderItem, View view) {
        if (!checkContinousClick().booleanValue()) {
            DynamicModuleManager.getInstance().startInstall(dynamicModuleLoaderItem.getName(), this.activity);
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$DynamicModuleLoaderAdapter(View view) {
        this.activity.finish();
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$DynamicModuleLoaderAdapter(DynamicModuleLoaderItem dynamicModuleLoaderItem, View view) {
        if (!checkContinousClick().booleanValue()) {
            DynamicModuleManager.getInstance().startInstall(dynamicModuleLoaderItem.getName(), this.activity);
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$3$DynamicModuleLoaderAdapter(DynamicModuleLoaderItem dynamicModuleLoaderItem, View view) {
        if (!checkContinousClick().booleanValue()) {
            DynamicModuleManager.getInstance().startInstall(dynamicModuleLoaderItem.getName(), this.activity);
        }
    }

    private void setIcon(ImageView imageView, int i2) {
        try {
            imageView.setImageDrawable(i.a(imageView.getContext().getResources(), i2, (Resources.Theme) null));
        } catch (Resources.NotFoundException unused) {
            imageView.setImageDrawable(imageView.getContext().getDrawable(i2));
        }
    }

    public void updateItemData(String str, boolean z, String str2, int i2) {
        int activeModulePosition = getActiveModulePosition(str);
        if (activeModulePosition != -1) {
            this.mArrayList.get(activeModulePosition).setRequestInitiatedButNotDownload(i2 == 0 && !z);
            this.mArrayList.get(activeModulePosition).setFailed(z);
            this.mArrayList.get(activeModulePosition).setStatusText(str2);
            this.mArrayList.get(activeModulePosition).setDownloadPercent(i2);
            notifyItemChanged(activeModulePosition);
        }
    }

    public void refreshCurrentQueue() {
        this.mArrayList = DynamicModuleManager.getInstance().getCurrentQueue();
        notifyDataSetChanged();
    }

    private int getActiveModulePosition(String str) {
        for (int i2 = 0; i2 < this.mArrayList.size(); i2++) {
            if (this.mArrayList.get(i2).getName().equalsIgnoreCase(str)) {
                return i2;
            }
        }
        return -1;
    }

    public int getItemCount() {
        ArrayList<DynamicModuleLoaderItem> arrayList = this.mArrayList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public int getItemViewType(int i2) {
        if (i2 != 0) {
            return this.VIEW_TYPE_MULTIPLE;
        }
        if (getItemCount() > 1) {
            return this.VIEW_TYPE_MULTIPLE;
        }
        return this.VIEW_TYPE_SINGLE;
    }

    public class MultipleModuleViewHolder extends RecyclerView.v {
        e binding;

        MultipleModuleViewHolder(View view) {
            super(view);
            this.binding = (e) f.a(view);
        }
    }

    public class SingleModuleViewHolder extends RecyclerView.v {
        g binding;

        SingleModuleViewHolder(View view) {
            super(view);
            this.binding = (g) f.a(view);
        }
    }

    public class SingleModuleFullViewHolder extends RecyclerView.v {
        net.one97.paytm.g.i binding;

        SingleModuleFullViewHolder(View view) {
            super(view);
            this.binding = (net.one97.paytm.g.i) f.a(view);
        }
    }

    private Boolean checkContinousClick() {
        if (SystemClock.elapsedRealtime() - this.lastClickTime < 1000) {
            return Boolean.TRUE;
        }
        this.lastClickTime = SystemClock.elapsedRealtime();
        return Boolean.FALSE;
    }
}

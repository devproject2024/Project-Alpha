package net.one97.paytm.dynamicModule.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.dynamicModule.test.DynamicModuleAdapter;
import net.one97.paytm.paytm_finance.R;

public class DynamicModuleAdapter extends RecyclerView.a<RecyclerView.v> {
    private ArrayList<DynamicModuleItem> mArrayList;
    private Context mContext;
    private ItemClickListener mItemClickListener;

    public interface ItemClickListener {
        void onCheckedChangeListener(boolean z, String str);
    }

    public DynamicModuleAdapter(Context context, ArrayList<DynamicModuleItem> arrayList, ItemClickListener itemClickListener) {
        this.mContext = context;
        this.mArrayList = arrayList;
        this.mItemClickListener = itemClickListener;
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ModuleViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.item_module, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ModuleViewHolder moduleViewHolder = (ModuleViewHolder) vVar;
        moduleViewHolder.tvModuleName.setText(this.mArrayList.get(i2).getName());
        moduleViewHolder.swToggleInstall.setChecked(this.mArrayList.get(i2).isInstalled());
        moduleViewHolder.swToggleInstall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(moduleViewHolder) {
            private final /* synthetic */ DynamicModuleAdapter.ModuleViewHolder f$1;

            {
                this.f$1 = r2;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DynamicModuleAdapter.this.lambda$onBindViewHolder$0$DynamicModuleAdapter(this.f$1, compoundButton, z);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$DynamicModuleAdapter(ModuleViewHolder moduleViewHolder, CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.mItemClickListener.onCheckedChangeListener(z, moduleViewHolder.tvModuleName.getText().toString());
        }
    }

    public void setNewData(ArrayList<DynamicModuleItem> arrayList) {
        this.mArrayList = arrayList;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        ArrayList<DynamicModuleItem> arrayList = this.mArrayList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class ModuleViewHolder extends RecyclerView.v {
        Switch swToggleInstall;
        TextView tvModuleName;

        ModuleViewHolder(View view) {
            super(view);
            this.tvModuleName = (TextView) view.findViewById(R.id.tv_module_name);
            this.swToggleInstall = (Switch) view.findViewById(R.id.sw_toggle_install);
        }
    }
}

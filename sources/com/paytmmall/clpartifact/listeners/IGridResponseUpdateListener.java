package com.paytmmall.clpartifact.listeners;

import com.paytmmall.clpartifact.modal.grid.CJRGrid;
import com.paytmmall.clpartifact.modal.grid.CJRSortingKeys;

public interface IGridResponseUpdateListener {
    void onGridUpdate(String str, CJRGrid cJRGrid);

    void onSortingSelected(CJRSortingKeys cJRSortingKeys);
}

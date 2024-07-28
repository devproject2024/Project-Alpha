package com.travel.flight.flightSRPV2.viewModel.factory;

import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel;
import com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel;
import com.travel.flight.flightSRPV2.viewModel.IRTViewModel;
import com.travel.flight.flightSRPV2.viewModel.NoFlightsFoundViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPModifyViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import java.lang.reflect.Constructor;
import java.util.NoSuchElementException;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SRPViewModelFactory implements al.b {
    private final FlightFilterHomeViewModel filterHomeViewModel;
    private final boolean isOnward;
    private final SRPSharedViewModel parentViewModel;

    public SRPViewModelFactory(SRPSharedViewModel sRPSharedViewModel, boolean z, FlightFilterHomeViewModel flightFilterHomeViewModel) {
        k.c(sRPSharedViewModel, "parentViewModel");
        this.parentViewModel = sRPSharedViewModel;
        this.isOnward = z;
        this.filterHomeViewModel = flightFilterHomeViewModel;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SRPViewModelFactory(SRPSharedViewModel sRPSharedViewModel, boolean z, FlightFilterHomeViewModel flightFilterHomeViewModel, int i2, g gVar) {
        this(sRPSharedViewModel, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? null : flightFilterHomeViewModel);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SRPViewModelFactory(SRPSharedViewModel sRPSharedViewModel, boolean z) {
        this(sRPSharedViewModel, z, (FlightFilterHomeViewModel) null);
        k.c(sRPSharedViewModel, "parentViewModel");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SRPViewModelFactory(SRPSharedViewModel sRPSharedViewModel, boolean z, int i2, g gVar) {
        this(sRPSharedViewModel, (i2 & 2) != 0 ? true : z);
    }

    public final <T extends ai> T create(Class<T> cls) {
        T t;
        k.c(cls, "modelClass");
        if (k.a((Object) cls, (Object) SRPOneWayViewModel.class) || k.a((Object) cls, (Object) IRTViewModel.class) || k.a((Object) cls, (Object) IRTSplitViewModel.class) || k.a((Object) cls, (Object) DRTListViewModel.class) || k.a((Object) cls, (Object) SRPModifyViewModel.class) || k.a((Object) cls, (Object) NoFlightsFoundViewModel.class) || k.a((Object) cls, (Object) FlightFilterHomeViewModel.class)) {
            Constructor[] declaredConstructors = cls.getDeclaredConstructors();
            k.a((Object) declaredConstructors, "modelClass.declaredConstructors");
            k.d(declaredConstructors, "$this$first");
            if (!(declaredConstructors.length == 0)) {
                t = declaredConstructors[0].newInstance(new Object[]{this.parentViewModel});
            } else {
                throw new NoSuchElementException("Array is empty.");
            }
        } else if (k.a((Object) cls, (Object) FlightFilterViewModel.class)) {
            SRPSharedViewModel sRPSharedViewModel = this.parentViewModel;
            FlightFilterHomeViewModel flightFilterHomeViewModel = this.filterHomeViewModel;
            if (flightFilterHomeViewModel == null) {
                k.a();
            }
            t = new FlightFilterViewModel(sRPSharedViewModel, flightFilterHomeViewModel, this.isOnward);
        } else {
            throw new Exception("Unknown type for this factory");
        }
        return (ai) t;
    }
}

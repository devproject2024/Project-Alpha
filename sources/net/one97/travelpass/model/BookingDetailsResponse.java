package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class BookingDetailsResponse extends IJRPaytmDataModel {
    @b(a = "body")
    private final BookingDetails body;
    @b(a = "code")
    private final int code;
    @b(a = "message")
    private final String message;

    public final String getMessage() {
        return this.message;
    }

    public final int getCode() {
        return this.code;
    }

    public final BookingDetails getBody() {
        return this.body;
    }

    public static final class BookingDetails extends IJRPaytmDataModel {
        @b(a = "bookingDetails")
        private final List<BookingItems> bookingItems;
        @b(a = "error")
        private final String error;
        @b(a = "message")
        private final String message;
        @b(a = "status")
        private final String status;
        @b(a = "title")
        private final String title;
        @b(a = "vertical")
        private final String vertical;
        @b(a = "verticalId")
        private final Integer verticalId;

        public final String getStatus() {
            return this.status;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getError() {
            return this.error;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getVertical() {
            return this.vertical;
        }

        public final Integer getVerticalId() {
            return this.verticalId;
        }

        public final List<BookingItems> getBookingItems() {
            return this.bookingItems;
        }
    }

    public static final class BookingItems extends IJRPaytmDataModel {
        @b(a = "journeyDetails")
        private final String journeyDetails;
        @b(a = "journeyStatus")
        private final String journeyStatus;
        @b(a = "journeyStatusColor")
        private final String journeyStatusColor;
        @b(a = "orderId")
        private final String orderId;

        public final String getJourneyDetails() {
            return this.journeyDetails;
        }

        public final String getOrderId() {
            return this.orderId;
        }

        public final String getJourneyStatus() {
            return this.journeyStatus;
        }

        public final String getJourneyStatusColor() {
            return this.journeyStatusColor;
        }
    }
}

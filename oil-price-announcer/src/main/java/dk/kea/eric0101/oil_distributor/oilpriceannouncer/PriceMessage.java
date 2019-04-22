package dk.kea.eric0101.oil_distributor.oilpriceannouncer;

import java.io.Serializable;
import java.util.Date;

public class PriceMessage implements Serializable {
    Double newPrice;
    Date createdAt;

    public Double getMessageContent() {
        return newPrice;
    }

    public void setMessageContent(Double messageContent) {
        this.newPrice = messageContent;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public PriceMessage(Double newPrice, Date createdAt) {
        this.newPrice = newPrice;
        this.createdAt = createdAt;
    }


}

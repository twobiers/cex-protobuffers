package de.thkoeln.cexprotobuf.server.messages.json;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.DEDUCTION)
@JsonSubTypes({
    @JsonSubTypes.Type(value = CashPaymentDto.class),
    @JsonSubTypes.Type(value = CreditCardPaymentDto.class),
})
public interface Payment {

}

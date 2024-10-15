package com.nathanrhoden.paytrace.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String message;
    private Long sendingBankId;
    private Long receivingBankId;
    private String uniqueTransferReference;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "transfer_message_id")
    private TransferMessage transferMessage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(getUuid(), ticket.getUuid()) && Objects.equals(getMessage(), ticket.getMessage()) && Objects.equals(getSendingBankId(), ticket.getSendingBankId()) && Objects.equals(getReceivingBankId(), ticket.getReceivingBankId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getMessage(), getSendingBankId(), getReceivingBankId());
    }
}

package com.nathanrhoden.paytrace.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "TRANSFER_MESSAGE")
public class TransferMessage {

    private String headerBlock;
    private String applicationHeader;
    private String userBlockHeader;
    private String uniqueTransactionRef;
    private String operationCode ;
    private Date valueDate;
    private String currency;
    private String ordBIC;
    private String beneBIC;
    private String beneficiaryCustomerAccountNumber;
    private Long interbankSettledAmount;
    private Long instructedAmount;
    private String orderingCustomerName;
    private String orderingCustomerAccountNumber;
    private String orderingCustomerAddress;
    private String remittanceInformation;

    private Long beneBank;
    private Long ordBank;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch =FetchType.LAZY , mappedBy = "transferMessage", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Ticket> ticketList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferMessage that = (TransferMessage) o;
        return Objects.equals(getHeaderBlock(), that.getHeaderBlock()) && Objects.equals(getApplicationHeader(), that.getApplicationHeader()) && Objects.equals(getUserBlockHeader(), that.getUserBlockHeader()) && Objects.equals(getUniqueTransactionRef(), that.getUniqueTransactionRef()) && Objects.equals(getOperationCode(), that.getOperationCode()) && Objects.equals(getValueDate(), that.getValueDate()) && Objects.equals(getCurrency(), that.getCurrency()) && Objects.equals(getOrdBIC(), that.getOrdBIC()) && Objects.equals(getBeneBIC(), that.getBeneBIC()) && Objects.equals(getBeneficiaryCustomerAccountNumber(), that.getBeneficiaryCustomerAccountNumber()) && Objects.equals(getInterbankSettledAmount(), that.getInterbankSettledAmount()) && Objects.equals(getInstructedAmount(), that.getInstructedAmount()) && Objects.equals(getOrderingCustomerName(), that.getOrderingCustomerName()) && Objects.equals(getOrderingCustomerAccountNumber(), that.getOrderingCustomerAccountNumber()) && Objects.equals(getOrderingCustomerAddress(), that.getOrderingCustomerAddress()) && Objects.equals(getRemittanceInformation(), that.getRemittanceInformation()) && Objects.equals(getBeneBank(), that.getBeneBank()) && Objects.equals(getOrdBank(), that.getOrdBank()) && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeaderBlock(), getApplicationHeader(), getUserBlockHeader(), getUniqueTransactionRef(), getOperationCode(), getValueDate(), getCurrency(), getOrdBIC(), getBeneBIC(), getBeneficiaryCustomerAccountNumber(), getInterbankSettledAmount(), getInstructedAmount(), getOrderingCustomerName(), getOrderingCustomerAccountNumber(), getOrderingCustomerAddress(), getRemittanceInformation(), getBeneBank(), getOrdBank(), getId());
    }
}

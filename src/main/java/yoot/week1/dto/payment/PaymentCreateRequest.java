package yoot.week1.dto.payment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import yoot.week1.domain.enums.PaymentMethod;

import java.time.LocalDateTime;

@Data
public class PaymentCreateRequest {
    @NotNull
    private Long invoiceId;
    @NotBlank
    private String paymentCode;
    @NotNull
    private Float paidAmount;
    @NotNull
    private PaymentMethod paymentMethod;
    @NotNull
    private LocalDateTime paidAt;
    @Size(max = 255)
    String note;
}

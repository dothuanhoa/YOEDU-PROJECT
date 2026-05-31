package yoot.week1.service;

import yoot.week1.common.exception.BadRequestException;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.dto.billing.InvoiceCreateRequest;
import yoot.week1.dto.billing.InvoiceResponse;
import yoot.week1.dto.payment.PaymentCreateRequest;
import yoot.week1.dto.payment.PaymentResponse;

import java.util.List;

public interface BillingService {
    InvoiceResponse createInvoice(InvoiceCreateRequest request) throws NotFoundException;
    List<InvoiceResponse> findInvoicesByStudent(Long studentId, String username) throws BadRequestException, NotFoundException;
    PaymentResponse createPayment(PaymentCreateRequest request, String username) throws NotFoundException, BadRequestException;
}

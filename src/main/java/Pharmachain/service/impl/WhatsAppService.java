package Pharmachain.service.impl;

public interface WhatsAppService {

    void sendInvoicePdf(String mobileNumber, byte[] pdfBytes);
}
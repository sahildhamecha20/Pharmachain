package Pharmachain.service.impl;


import org.springframework.stereotype.Service;

@Service
public class WhatsAppServiceImpl implements WhatsAppService {

    @Override
    public void sendInvoicePdf(String mobileNumber, byte[] pdfBytes) {

        System.out.println("WhatsApp PDF sent to: " + mobileNumber);
    }
}
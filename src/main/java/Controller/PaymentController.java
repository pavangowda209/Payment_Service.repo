package Controller;


import Dtos.RequestDto;
import Service.IPaymentInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    // creating objects of interface
    private IPaymentInterface stripeService;
    private IPaymentInterface razorPayService;
    public PaymentController(@Qualifier("stripeService") IPaymentInterface stripeService,
                             @Qualifier("razorPayService") IPaymentInterface razorPayService) {
        this.stripeService = stripeService;
        this.razorPayService = razorPayService;
    }

    @PostMapping("/payments")
    public String intiatepayments(@RequestBody RequestDto dto) {
        String response;
        int paymentgateway = getpaymentgateway();
        switch (paymentgateway) {
            case 1:
                response = razorPayService.dopayments(dto.getEmail(), dto.getAmount(), dto.getPhoneno(), dto.getOrderId());
            case 2:
                response = stripeService.dopayments(dto.getEmail(), dto.getAmount(), dto.getPhoneno(), dto.getOrderId());
        }
        return null;
    }

    private int getpaymentgateway() {
        return 1;
    }
}

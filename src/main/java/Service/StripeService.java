package Service;


import org.springframework.stereotype.Service;

@Service("stripeService")
public class StripeService implements IPaymentInterface{
    @Override
    public String dopayments(String email, Integer amount, String phoneno, String orderId) {
        return "";
    }
}

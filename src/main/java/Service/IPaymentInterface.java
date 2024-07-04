package Service;

import com.razorpay.RazorpayException;

public interface IPaymentInterface {
    String dopayments(String email,Integer amount,String phoneno, String orderId) throws RazorpayException;
}

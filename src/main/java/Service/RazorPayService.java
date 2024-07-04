package Service;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorPayService")
public class RazorPayService implements IPaymentInterface{

    private RazorpayClient razorpayClient;
    public RazorPayService(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String dopayments(String email, Integer amount, String phoneno, String orderId) throws RazorpayException {
        //s1.constructing the data
        JSONObject response = getanswerforRazorpay(amount,orderId);
        //s2.call the razorpay
        PaymentLink razorpaypaymentLink =razorpayClient.paymentLink.create(response);

        return razorpaypaymentLink.toString();
    }

    private JSONObject getanswerforRazorpay(Integer amount, String orderId) {
        JSONObject OrderRequest = new JSONObject();
        /**
         * {
         * "amount" :
         * "currency"
         * "receipt"
         * "customer" :{ "phone" :"",
         *               "email : "",
         *             },
         * "notify" : { "sms" : true,
         *              "email" : true,
         *            }
         * }
         */
        OrderRequest.put("amount",amount);
        OrderRequest.put("Currency","INR");
        OrderRequest.put("receipt",orderId);

        JSONObject CustomerInfo = new JSONObject();
        CustomerInfo.put("phoneno","9573080527");
        CustomerInfo.put("email","pavankumarrajama@gmail.com");
        OrderRequest.put("customerinfo",CustomerInfo);

        JSONObject Notify = new JSONObject();
        Notify.put("SMS","true");
        Notify.put("email","true");
        OrderRequest.put("notify",Notify);

        // putting call back url
        OrderRequest.put("callback_url","https://x.razorpay.com/welcome/razorpay/webhook");

        return CustomerInfo;
    }
}

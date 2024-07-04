package Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class RazorpayWebhook {

    @GetMapping("/razorpay/webhook")
    public String razorpaycallback(){
        return "Redirecting customer...";
    }
}

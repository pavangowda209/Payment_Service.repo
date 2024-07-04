package Configuration;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfiguration {

    @Value("${razorpay.key.id}")
    String razorpayId;

    @Value("${razor.pay.secret}")
    String razorpaySecret;

    @Bean
   public RazorpayClient createRazorpayClient() throws RazorpayException {
       return new RazorpayClient(razorpayId,razorpaySecret);
   }
}

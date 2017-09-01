import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.paypal.api.payments.Payment;
import com.paypal.api.payments.servlet.PaymentWithCreditCardServlet;
import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;
import com.paypal.svcs.services.AdaptivePaymentsService;
import com.paypal.svcs.types.ap.PayRequest;
import com.paypal.svcs.types.ap.PayResponse;
import com.paypal.svcs.types.ap.Receiver;
import com.paypal.svcs.types.ap.ReceiverList;
import com.paypal.svcs.types.common.RequestEnvelope;




/**
 * Servlet implementation class DoTransaction
 */
@WebServlet("/DoTransaction")
public class DoTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger
			.getLogger(PaymentWithCreditCardServlet.class);


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	// ##Create
	// Sample showing to create a Payment using
	// CreditCard as a FundingInstrument
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			createPayment(req, resp);
		//req.getRequestDispatcher("response.jsp").forward(req, resp);
		return;
	}

	public Payment createPayment(HttpServletRequest req,
			HttpServletResponse resp)  {
		/*Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");

		APIContext apiContext = new APIContext("Bearer A015FlneCn5Whz7.WErTUXGqWSLqZvlHpzW2.k1EXROvLNw");
		apiContext.setConfigurationMap(sdkConfig);

		CreditCard creditCard = new CreditCard();
		creditCard.setType("visa");
		creditCard.setNumber("4032036960224911");
		creditCard.setExpireMonth(2);
		creditCard.setExpireYear(2020);
		creditCard.setFirstName("Abhishek");
		creditCard.setLastName("Sharma");

		FundingInstrument fundingInstrument = new FundingInstrument();
		fundingInstrument.setCreditCard(creditCard);

		List<FundingInstrument> fundingInstrumentList = new ArrayList<FundingInstrument>();
		fundingInstrumentList.add(fundingInstrument);

		Payer payer = new Payer();
		payer.setFundingInstruments(fundingInstrumentList);
		payer.setPaymentMethod("credit_card");

		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal("12");

		Transaction transaction = new Transaction();
		transaction.setDescription("creating a direct payment with credit card");
		transaction.setAmount(amount);

		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);

		Payment createdPayment = null;
		try {
			createdPayment = payment.create(apiContext);
		} catch (PayPalRESTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(createdPayment.toJSON());
		return createdPayment;
		*/
		
		
		PayRequest payRequest = new PayRequest();
		  
		List<Receiver> receivers = new ArrayList<Receiver>();
		Receiver receiver = new Receiver();
		receiver.setAmount(1.00);
		receiver.setEmail("abhishekshm007-buyer@gmail.com");
		receivers.add(receiver);
		ReceiverList receiverList = new ReceiverList(receivers);

		payRequest.setReceiverList(receiverList);

		RequestEnvelope requestEnvelope = new RequestEnvelope();
		payRequest.setRequestEnvelope(requestEnvelope); 
		payRequest.setActionType("PAY");
		payRequest.setCancelUrl("https://devtools-paypal.com/guide/ap_simple_payment?cancel=true");
		payRequest.setReturnUrl("https://devtools-paypal.com/guide/ap_simple_payment?success=true");
		payRequest.setCurrencyCode("USD");
		payRequest.setIpnNotificationUrl("o9pathshala.com");

		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");
		sdkConfig.put("acct1.UserName", "abhishekshm007-facilitator_api1.gmail.com");
		sdkConfig.put("acct1.Password", "2CCVBARJQZ88WCH9");
		sdkConfig.put("acct1.Signature","AOGDbj57h.k6CO0zuCVLcttcst9pAYQLJW.UUesY-qwHvbtWR1RqOt6U");
		sdkConfig.put("acct1.AppId","APP-80W284485P519543T");

		AdaptivePaymentsService adaptivePaymentsService = new AdaptivePaymentsService(sdkConfig);
		try {
			PayResponse payResponse = adaptivePaymentsService.pay(payRequest);
			System.out.println(payResponse.toString());
		} catch (SSLConfigurationException | InvalidCredentialException
				| HttpErrorException | InvalidResponseDataException
				| ClientActionRequiredException | MissingCredentialException
				| OAuthException | IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

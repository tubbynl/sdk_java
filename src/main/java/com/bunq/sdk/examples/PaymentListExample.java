package com.bunq.sdk.examples;

import com.bunq.sdk.context.ApiContext;
import com.bunq.sdk.context.BunqContext;
import com.bunq.sdk.http.BunqResponse;
import com.bunq.sdk.http.Pagination;
import com.bunq.sdk.model.generated.endpoint.Payment;

import java.util.List;

/**
 * Restore previously saved API context from a file and use it for Payment listing call.
 */
public class PaymentListExample {

  /**
   * Path to the API Context file.
   */
  private static final String API_CONTEXT_FILE_PATH = "bunq.conf";

  /**
   * Message constants.
   */
  private static final String MESSAGE_LATEST_PAGE_IDS = "Latest page IDs: ";
  private static final String MESSAGE_SECOND_LATEST_PAGE_IDS = "Second latest page IDs: ";
  private static final String MESSAGE_NO_PRIOR_PAYMENTS_FOUND = "No prior payments found!";

  /**
   * Size of each page of payments listing.
   */
  private static final int PAGE_SIZE = 3;

  /**
   * Constants to be changed to run the example.
   */
  private static final int MONETARY_ACCOUNT_ITEM_ID = 0; // Put your monetary account ID here

  /**
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    BunqContext.loadApiContext(ApiContext.restore(API_CONTEXT_FILE_PATH));
    Pagination paginationCountOnly = new Pagination();
    paginationCountOnly.setCount(PAGE_SIZE);
    BunqResponse<List<Payment>> paymentListResponse = Payment.list(
        MONETARY_ACCOUNT_ITEM_ID,
        paginationCountOnly.getUrlParamsCountOnly()
    );
    List<Payment> payments = paymentListResponse.getValue();

    System.out.println(MESSAGE_LATEST_PAGE_IDS);
    printPayments(payments);

    Pagination pagination = paymentListResponse.getPagination();

    if (pagination.hasPreviousPage()) {
      System.out.println(MESSAGE_SECOND_LATEST_PAGE_IDS);
      List<Payment> previousPayments = Payment.list(
          MONETARY_ACCOUNT_ITEM_ID,
          pagination.getUrlParamsPreviousPage()
      ).getValue();
      printPayments(previousPayments);
    } else {
      System.out.println(MESSAGE_NO_PRIOR_PAYMENTS_FOUND);
    }
  }

  private static void printPayments(List<Payment> payments) {
    for (Payment payment : payments) {
      System.out.println(payment.getId());
    }
  }

}

package com.bunq.sdk.model.generated.endpoint;

import com.bunq.sdk.http.ApiClient;
import com.bunq.sdk.http.BunqResponse;
import com.bunq.sdk.http.BunqResponseRaw;
import com.bunq.sdk.model.core.BunqModel;
import com.google.gson.stream.JsonReader;

import java.util.HashMap;
import java.util.Map;

/**
 * Using this call you can create a SOFORT Request assigned to your User by providing the Token
 * of the request.
 */
public class TokenQrRequestSofort extends BunqModel {

  /**
   * Endpoint constants.
   */
  protected static final String ENDPOINT_URL_CREATE = "user/%s/token-qr-request-sofort";

  /**
   * Field constants.
   */
  public static final String FIELD_TOKEN = "token";

  /**
   * Object type.
   */
  protected static final String OBJECT_TYPE_POST = "RequestResponse";

  /**
   * Create a request from an SOFORT transaction.
   * @param token The token passed from a site or read from a QR code.
   */
  public static BunqResponse<TokenQrRequestSofort> create(String token, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(getApiContext());

    if (customHeaders == null) {
      customHeaders = new HashMap<>();
    }

  HashMap<String, Object> requestMap = new HashMap<>();
requestMap.put(FIELD_TOKEN, token);

    byte[] requestBytes = gson.toJson(requestMap).getBytes();
    BunqResponseRaw responseRaw = apiClient.post(String.format(ENDPOINT_URL_CREATE, determineUserId()), requestBytes, customHeaders);

    return fromJson(TokenQrRequestSofort.class, responseRaw, OBJECT_TYPE_POST);
  }

  public static BunqResponse<TokenQrRequestSofort> create() {
    return create(null, null);
  }

  public static BunqResponse<TokenQrRequestSofort> create(String token) {
    return create(token, null);
  }

  /**
   */
  public boolean isAllFieldNull() {
    return true;
  }

  /**
   */
  public static TokenQrRequestSofort fromJsonReader(JsonReader reader) {
    return fromJsonReader(TokenQrRequestSofort.class, reader);
  }

}

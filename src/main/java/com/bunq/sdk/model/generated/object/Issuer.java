package com.bunq.sdk.model.generated.object;

import com.bunq.sdk.model.core.BunqModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;

/**
 */
public class Issuer extends BunqModel {

  /**
   * The BIC code.
   */
  @Expose
  @SerializedName("bic")
  private String bic;

  /**
   * The name of the bank.
   */
  @Expose
  @SerializedName("name")
  private String name;

  public Issuer(String bic) {
    this.bic = bic;
    this.name = name;
  }

  /**
   * The BIC code.
   */
  public String getBic() {
    return this.bic;
  }

  public void setBic(String bic) {
    this.bic = bic;
  }

  /**
   * The name of the bank.
   */
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   */
  public boolean isAllFieldNull() {
    if (this.bic != null) {
      return false;
    }

    if (this.name != null) {
      return false;
    }

    return true;
  }

  /**
   */
  public static Issuer fromJsonReader(JsonReader reader) {
    return fromJsonReader(Issuer.class, reader);
  }

}

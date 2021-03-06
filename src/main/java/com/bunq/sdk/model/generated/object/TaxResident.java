package com.bunq.sdk.model.generated.object;

import com.bunq.sdk.model.core.BunqModel;
import com.bunq.sdk.model.core.MonetaryAccountReference;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public class TaxResident extends BunqModel {

  /**
   * The country of the tax number.
   */
  @Expose
  @SerializedName("country")
  private String country;

  /**
   * The tax number.
   */
  @Expose
  @SerializedName("tax_number")
  private String taxNumber;

  public TaxResident(String country, String taxNumber) {
    this.country = country;
    this.taxNumber = taxNumber;
  }

  /**
   * The country of the tax number.
   */
  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * The tax number.
   */
  public String getTaxNumber() {
    return this.taxNumber;
  }

  public void setTaxNumber(String taxNumber) {
    this.taxNumber = taxNumber;
  }

  /**
   */
  public boolean isAllFieldNull() {
    if (this.country != null) {
      return false;
    }

    if (this.taxNumber != null) {
      return false;
    }

    return true;
  }

  /**
   */
  public static TaxResident fromJsonReader(JsonReader reader) {
    return fromJsonReader(TaxResident.class, reader);
  }

}

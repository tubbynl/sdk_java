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
public class ChatMessageContentText extends BunqModel {

  /**
   * The text of the message.
   */
  @Expose
  @SerializedName("text")
  private String text;

  /**
   * The text of the message.
   */
  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }

  /**
   */
  public boolean isAllFieldNull() {
    if (this.text != null) {
      return false;
    }

    return true;
  }

  /**
   */
  public static ChatMessageContentText fromJsonReader(JsonReader reader) {
    return fromJsonReader(ChatMessageContentText.class, reader);
  }

}

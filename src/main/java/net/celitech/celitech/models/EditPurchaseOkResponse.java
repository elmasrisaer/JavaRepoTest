package net.celitech.celitech.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class EditPurchaseOkResponse {

  /**
   * ID of the purchase
   */
  private String purchaseId;

  /**
   * Start date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  private String newStartDate;

  /**
   * End date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  private String newEndDate;

  /**
   * Epoch value representing the new start time of the package's validity
   */
  private Double newStartTime;

  /**
   * Epoch value representing the new end time of the package's validity
   */
  private Double newEndTime;
}

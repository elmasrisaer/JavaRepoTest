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
public class History {

  /**
   * The status of the eSIM at a given time, possible values are 'RELEASED', 'DOWNLOADED', 'INSTALLED', 'ENABLED', 'DELETED', or 'ERROR'
   */
  private String status;

  /**
   * The date when the eSIM status changed in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  private String statusDate;

  /**
   * Epoch value representing the date when the eSIM status changed
   */
  private Double date;
}

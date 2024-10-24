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
public class GetEsimOkResponseEsim {

  /**
   * ID of the eSIM
   */
  private String iccid;

  /**
   * SM-DP+ Address
   */
  private String smdpAddress;

  /**
   * The manual activation code
   */
  private String manualActivationCode;

  /**
   * Status of the eSIM, possible values are 'RELEASED', 'DOWNLOADED', 'INSTALLED', 'ENABLED', 'DELETED', or 'ERROR'
   */
  private String status;
}

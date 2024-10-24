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
public class Device {

  /**
   * Name of the OEM
   */
  private String oem;

  /**
   * Name of the Device
   */
  private String hardwareName;

  /**
   * Model of the Device
   */
  private String hardwareModel;

  /**
   * Serial Number of the eSIM
   */
  private String eid;
}

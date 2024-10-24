package net.celitech.celitech.models;

import java.util.List;
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
public class Destinations {

  /**
   * Name of the destination
   */
  private String name;

  /**
   * ISO representation of the destination
   */
  private String destination;

  /**
   * This array indicates the geographical area covered by a specific destination. If the destination represents a single country, the array will include that country. However, if the destination represents a broader regional scope, the array will be populated with the names of the countries belonging to that region.
   */
  private List<String> supportedCountries;
}

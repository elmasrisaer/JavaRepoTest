package net.celitech.celitech.config;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import net.celitech.celitech.http.Environment;

@Builder
@Data
public class CelitechConfig {

  @NonNull
  @Builder.Default
  private String userAgent = "celitech/1.0.0";

  @NonNull
  @Builder.Default
  private Environment environment = Environment.DEFAULT;

  @NonNull
  @Builder.Default
  private RetryConfig retryConfig = RetryConfig.builder().build();

  /** Timeout in milliseconds */
  @Builder.Default
  private long timeout = 10_000;

  private String clientId;
  private String clientSecret;
}

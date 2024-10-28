package net.celitech.celitech;

import java.util.concurrent.TimeUnit;
import net.celitech.celitech.config.CelitechConfig;
import net.celitech.celitech.hook.CustomHook;
import net.celitech.celitech.http.Environment;
import net.celitech.celitech.http.interceptors.DefaultHeadersInterceptor;
import net.celitech.celitech.http.interceptors.HookInterceptor;
import net.celitech.celitech.http.interceptors.RetryInterceptor;
import net.celitech.celitech.services.DestinationsService;
import net.celitech.celitech.services.ESimService;
import net.celitech.celitech.services.PackagesService;
import net.celitech.celitech.services.PurchasesService;
import okhttp3.OkHttpClient;

/** Welcome to the CELITECH API documentation!  Useful links: [Homepage](https://www.celitech.com) | [Support email](mailto:support@celitech.com) | [Blog](https://www.celitech.com/blog/)  */
public class Celitech {

  public final DestinationsService destinationsService;
  public final PackagesService packagesService;
  public final PurchasesService purchasesService;
  public final ESimService eSimService;

  private final HookInterceptor hookInterceptor;

  public Celitech() {
    // Default configs
    this(CelitechConfig.builder().build());
  }

  public Celitech(CelitechConfig config) {
    final String serverUrl = config.getEnvironment().getUrl();

    this.hookInterceptor = new HookInterceptor(new CustomHook(), config);

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(hookInterceptor)
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.destinationsService = new DestinationsService(httpClient, serverUrl);
    this.packagesService = new PackagesService(httpClient, serverUrl);
    this.purchasesService = new PurchasesService(httpClient, serverUrl);
    this.eSimService = new ESimService(httpClient, serverUrl);
  }

  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  public void setBaseUrl(String baseUrl) {
    this.destinationsService.setBaseUrl(baseUrl);
    this.packagesService.setBaseUrl(baseUrl);
    this.purchasesService.setBaseUrl(baseUrl);
    this.eSimService.setBaseUrl(baseUrl);
  }

  public void setClientId(String clientId) {
    this.hookInterceptor.setClientId(clientId);
  }

  public void setClientSecret(String clientSecret) {
    this.hookInterceptor.setClientSecret(clientSecret);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c

```java
import net.celitech.celitech.Celitech;
import net.celitech.celitech.config.CelitechConfig;
import net.celitech.celitech.models.ListPurchasesOkResponse;
import net.celitech.celitech.models.ListPurchasesParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("client-id").clientSecret("client-secret").build();

    Celitech celitech = new Celitech(config);

    ListPurchasesOkResponse response = celitech.purchasesService.listPurchases();

    System.out.println(response);
  }
}

```
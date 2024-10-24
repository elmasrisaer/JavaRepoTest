# Celitech Java SDK 1.1.88

Welcome to the Celitech SDK documentation. This guide will help you get started with integrating and using the Celitech SDK in your project.

## Versions

- API version: `1.1.0`
- SDK version: `1.1.88`

## About the API

Welcome to the CELITECH API documentation! Useful links: [Homepage](https://www.celitech.com) | [Support email](mailto:support@celitech.com) | [Blog](https://www.celitech.com/blog/)

## Table of Contents

- [Setup & Configuration](#setup--configuration)
  - [Supported Language Versions](#supported-language-versions)
  - [Installation](#installation)
  - [Environment Variables](#environment-variables)
- [Setting a Custom Timeout](#setting-a-custom-timeout)
- [Sample Usage](#sample-usage)
- [Services](#services)
- [Models](#models)
- [License](#license)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `Java >= 1.8`

## Installation

If you use Maven, place the following within the _dependency_ tag in your `pom.xml` file:

```XML
<dependency>
    <groupId>net.celitech</groupId>
    <artifactId>celitech</artifactId>
    <version>1.1.88</version>
</dependency>
```

If you use Gradle, paste the next line inside the _dependencies_ block of your `build.gradle` file:

```Gradle
implementation group: net.celitech, name: celitech, version: 1.1.88
```

If you use JAR files, package the SDK by running the following command:

```shell
mvn compile assembly:single
```

Then, add the JAR file to your project's classpath.

## Environment Variables

These are the environment variables for the SDK:

| Name          | Description             |
| :------------ | :---------------------- |
| CLIENT_ID     | Client ID parameter     |
| CLIENT_SECRET | Client Secret parameter |

Environment variables are a way to configure your application outside the code. You can set these environment variables on the command line or use your project's existing tooling for managing environment variables.

If you are using a `.env` file, a template with the variable names is provided in the `.env.example` file located in the same directory as this README.

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```java
import net.celitech.celitech.Celitech;
import net.celitech.celitech.config.CelitechConfig;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().timeout(10000).build();
    Celitech celitech = new Celitech(config);
  }
}

```

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```java
import net.celitech.celitech.Celitech;
import net.celitech.celitech.config.CelitechConfig;
import net.celitech.celitech.models.ListDestinationsOkResponse;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("client-id").clientSecret("client-secret").build();

    Celitech celitech = new Celitech(config);

    ListDestinationsOkResponse response = celitech.destinationsService.listDestinations();

    System.out.println(response);
  }
}

```

## Services

The SDK provides various services to interact with the API.

<details> 
<summary>Below is a list of all available services with links to their detailed documentation:</summary>

| Name                                                                 |
| :------------------------------------------------------------------- |
| [DestinationsService](documentation/services/DestinationsService.md) |
| [PackagesService](documentation/services/PackagesService.md)         |
| [PurchasesService](documentation/services/PurchasesService.md)       |
| [ESimService](documentation/services/ESimService.md)                 |

</details>

## Models

The SDK includes several models that represent the data structures used in API requests and responses. These models help in organizing and managing the data efficiently.

<details> 
<summary>Below is a list of all available models with links to their detailed documentation:</summary>

| Name                                                                                         | Description |
| :------------------------------------------------------------------------------------------- | :---------- |
| [ListDestinationsOkResponse](documentation/models/ListDestinationsOkResponse.md)             |             |
| [ListPackagesOkResponse](documentation/models/ListPackagesOkResponse.md)                     |             |
| [ListPurchasesOkResponse](documentation/models/ListPurchasesOkResponse.md)                   |             |
| [CreatePurchaseRequest](documentation/models/CreatePurchaseRequest.md)                       |             |
| [CreatePurchaseOkResponse](documentation/models/CreatePurchaseOkResponse.md)                 |             |
| [TopUpEsimRequest](documentation/models/TopUpEsimRequest.md)                                 |             |
| [TopUpEsimOkResponse](documentation/models/TopUpEsimOkResponse.md)                           |             |
| [EditPurchaseRequest](documentation/models/EditPurchaseRequest.md)                           |             |
| [EditPurchaseOkResponse](documentation/models/EditPurchaseOkResponse.md)                     |             |
| [GetPurchaseConsumptionOkResponse](documentation/models/GetPurchaseConsumptionOkResponse.md) |             |
| [GetEsimOkResponse](documentation/models/GetEsimOkResponse.md)                               |             |
| [GetEsimDeviceOkResponse](documentation/models/GetEsimDeviceOkResponse.md)                   |             |
| [GetEsimHistoryOkResponse](documentation/models/GetEsimHistoryOkResponse.md)                 |             |
| [GetEsimMacOkResponse](documentation/models/GetEsimMacOkResponse.md)                         |             |
| [ListPackagesParameters](documentation/models/ListPackagesParameters.md)                     |             |
| [ListPurchasesParameters](documentation/models/ListPurchasesParameters.md)                   |             |
| [GetEsimParameters](documentation/models/GetEsimParameters.md)                               |             |

</details>

## License

This SDK is licensed under the MIT License.

See the [LICENSE](LICENSE) file for more details.

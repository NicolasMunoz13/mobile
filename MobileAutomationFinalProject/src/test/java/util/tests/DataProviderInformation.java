package util.tests;

import org.testng.annotations.DataProvider;

public class DataProviderInformation {

    @DataProvider(name = "data-providerCountry")
    public Object[][] dataProviderInjection(){
        return new Object[][]{
                {
                    "Colombia"
                }
        };
    }

    @DataProvider(name = "data-providerCity")
    public Object[][] dataProviderInjectionCity(){
        return new Object[][]{
                {
                        "Colombia",
                        "Cartagena"
                }
        };
    }
}

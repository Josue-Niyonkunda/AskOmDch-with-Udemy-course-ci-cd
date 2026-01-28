package samePackage.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import samePackage.pages.BillingDetailsPage;

import java.util.List;
import java.util.Map;

public class BillingDetailsSteps {

    private final BillingDetailsPage billingDetailsPage;

    // PicoContainer injects WebDriver via page constructor
    public BillingDetailsSteps(BillingDetailsPage billingDetailsPage) {
        this.billingDetailsPage = billingDetailsPage;
    }

    @And("my billing details are")
    public void myBillingDetailsAre(DataTable table) {

        Map<String, String> data =
                table.asMaps(String.class, String.class).get(0);

        billingDetailsPage.fillBillingDetails(
                data.get("firstname"),
                data.get("lastname"),
                data.get("country"),
                data.get("StreetAddress"),
                data.get("city"),
                data.get("state"),
                data.get("zip"),
                data.get("email")
        );
    }

}

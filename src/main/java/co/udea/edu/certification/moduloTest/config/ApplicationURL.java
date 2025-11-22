package co.udea.edu.certification.moduloTest.config;

public enum ApplicationURL {

    // E-commerce
    SAUCE_DEMO("https://www.saucedemo.com/", "Sauce Demo"),
    PARA_BANK("https://parabank.parasoft.com/", "Para Bank"),
    ADVANTAGE_ONLINE("https://advantageonlineshopping.com/", "Advantage Online"),
    BLAZE_DEMO("https://blazedemo.com/", "Blaze Demo"),
    AUTOMATION_EXERCISE("https://automationexercise.com/", "Automation Exercise"),
    DEMO_OPENCART("https://demo.opencart.com/", "Demo OpenCart"),
    BUGGY_RATING("https://buggy.justtestit.org/", "Buggy Rating"),
    NOP_COMMERCE("https://demo.nopcommerce.com/", "Nop Commerce"),


    // Search Engines
    GOOGLE("https://www.google.com/", "Google"),
    BING("https://www.bing.com/", "Bing"),

    // Test Applications
    DEMO_QA("https://demoqa.com/", "Demo QA"),
    THE_INTERNET("https://the-internet.herokuapp.com/", "The Internet");

    private final String url;
    private final String name;

    ApplicationURL(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + url + ")";
    }
}

package br.com.tas.tracker.console.enums;

public enum ResourceBundles {

    HIBERNATE_CONSOLE("hibernate-console.properties"),
    MENU_CONSOLE("tracker-console.properties"),
    MESSAGES("messages.properties");

    private String desc;

    private ResourceBundles(String desc) {
        this.desc = desc;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

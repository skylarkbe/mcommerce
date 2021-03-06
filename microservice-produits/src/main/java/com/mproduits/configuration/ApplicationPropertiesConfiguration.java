package com.mproduits.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mycommerce")
@RefreshScope
public class ApplicationPropertiesConfiguration {

    private int searchMaxResults ;

    public int getSearchMaxResults() {
        return searchMaxResults;
    }

    public void setSearchMaxResults(int searchMaxResults) {
        this.searchMaxResults = searchMaxResults;
    }
}

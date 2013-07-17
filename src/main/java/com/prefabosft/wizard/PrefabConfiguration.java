package com.prefabosft.wizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * BSD licensed copyright (C) 2013 by jochen @ 7/17/13 3:33 PM.
 * .___   ___   ____  ____   __    ___   __   ___   ____ _____
 * | |_) | |_) | |_  | |_   / /\  | |_) ( (` / / \ | |_   | |
 * |_|   |_| \ |_|__ |_|   /_/--\ |_|_) _)_) \_\_/ |_|    |_|
 */
public class PrefabConfiguration extends Configuration{
    
    @NotEmpty
    @JsonProperty
    private String template;

    @NotEmpty
    @JsonProperty
    private String defaultId = "Stranger";

    public String getTemplate() {
        return template;
    }

    public String getDefaultId() {
        return defaultId;
    }

}

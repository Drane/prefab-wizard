package com.prefabsoft.wizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prefabsoft.wizard.resource.ServerInfoConfig;
import com.yammer.dropwizard.config.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * BSD licensed copyright (C) 2013 by jochen @ 7/17/13 3:33 PM.
 * .___   ___   ____  ____   __    ___   __   ___   ____ _____
 * | |_) | |_) | |_  | |_   / /\  | |_) ( (` / / \ | |_   | |
 * |_|   |_| \ |_|__ |_|   /_/--\ |_|_) _)_) \_\_/ |_|    |_|
 */
public class PrefabConfiguration extends Configuration{

    @Valid
    @NotNull
    @JsonProperty
    private ServerInfoConfig serverInfo;

//    public PrefabConfiguration() {http://stackoverflow.com/questions/13259672/dropwizard-setting-servlet-context-parameters
//        this.http = new HttpConfiguration(){
//            @Override
//            public ImmutableMap<String, String> getContextParameters(){
//                return ImmutableMap.<String, String>builder()
//                        .put("module", MainModule.class.getName()).build();
//            }
//        };
//    }

    public ServerInfoConfig getServerInfoConfig() {
        return serverInfo;
    }

}

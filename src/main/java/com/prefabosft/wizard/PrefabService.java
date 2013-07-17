package com.prefabosft.wizard;

import com.prefabosft.wizard.health.TemplateHealthCheck;
import com.prefabosft.wizard.resource.PrefabResource;
import com.prefabosft.wizard.util.PrefabWizardUtil;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * BSD licensed copyright (C) 2013 by jochen @ 7/17/13 3:33 PM.
 * .___   ___   ____  ____   __    ___   __   ___   ____ _____
 * | |_) | |_) | |_  | |_   / /\  | |_) ( (` / / \ | |_   | |
 * |_|   |_| \ |_|__ |_|   /_/--\ |_|_) _)_) \_\_/ |_|    |_|
 */
public class PrefabService  extends Service<PrefabConfiguration>{

    public static void main(String[] args) throws Exception {
        new PrefabService().run(PrefabWizardUtil.addDefaultArgs(args));
    }

    public void initialize(Bootstrap<PrefabConfiguration> prefabConfigurationBootstrap) {
        prefabConfigurationBootstrap.setName("prefabConfigurationBootstrap is my name");
        System.out.println("initialize->prefabConfigurationBootstrap :"+prefabConfigurationBootstrap);
    }

    public void run(PrefabConfiguration prefabConfiguration, Environment environment) throws Exception {
        System.out.println("run->prefabConfiguration :"+prefabConfiguration);

        final String template = prefabConfiguration.getTemplate();
        final String getDefaultId = prefabConfiguration.getDefaultId();
        environment.addResource(new PrefabResource(template, getDefaultId));
        environment.addHealthCheck(new TemplateHealthCheck(template));
    }
}

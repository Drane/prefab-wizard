package com.prefabosft.wizard;

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
        System.out.println("initialize->prefabConfigurationBootstrap :"+prefabConfigurationBootstrap);
    }

    public void run(PrefabConfiguration prefabConfiguration, Environment environment) throws Exception {
        environment.addResource(new PrefabResource());
        System.out.println("run->prefabConfiguration :"+prefabConfiguration);
    }
}

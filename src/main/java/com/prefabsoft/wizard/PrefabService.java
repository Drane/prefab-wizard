package com.prefabsoft.wizard;

import com.federecio.dropwizard.swagger.SwaggerBundle;
import com.prefabsoft.wizard.health.TemplateHealthCheck;
import com.prefabsoft.wizard.resource.PrefabResource;
import com.prefabsoft.wizard.resource.ServerInfoConfig;
import com.prefabsoft.wizard.util.PrefabWizardUtil;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BSD licensed copyright (C) 2013 by jochen @ 7/17/13 3:33 PM.
 * .___   ___   ____  ____   __    ___   __   ___   ____ _____
 * | |_) | |_) | |_  | |_   / /\  | |_) ( (` / / \ | |_   | |
 * |_|   |_| \ |_|__ |_|   /_/--\ |_|_) _)_) \_\_/ |_|    |_|
 */
public class PrefabService  extends Service<PrefabConfiguration>{

    private static final Logger log = LoggerFactory.getLogger(PrefabService.class);

    public static void main(String[] args) throws Exception {
        new PrefabService().run(PrefabWizardUtil.handleDefaultArgs(args));
    }

    public void initialize(Bootstrap<PrefabConfiguration> bootstrap) {
        log.debug("initialize->bootstrap :"+bootstrap);
        bootstrap.setName("prefab-service");
        bootstrap.addBundle(new SwaggerBundle());
    }

    public void run(PrefabConfiguration configuration, Environment environment) throws Exception {
        final String apiVersion = configuration.getHttpConfiguration().getContextParameters().get("api.version");
        log.debug("run-> API Version:" + apiVersion);
        final ServerInfoConfig serverInfoConfig = configuration.getServerInfoConfig();

        environment.addResource(new PrefabResource(serverInfoConfig));
        environment.addHealthCheck(new TemplateHealthCheck(serverInfoConfig.getDescriptionTemplate()));
    }
}

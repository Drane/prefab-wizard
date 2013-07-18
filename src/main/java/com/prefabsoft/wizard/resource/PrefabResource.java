package com.prefabsoft.wizard.resource;

import com.prefabsoft.wizard.model.ServerInfo;
import com.wordnik.swagger.annotations.*;
import com.yammer.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * BSD licensed copyright (C) 2013 by jochen @ 7/17/13 3:33 PM.
 * .___   ___   ____  ____   __    ___   __   ___   ____ _____
 * | |_) | |_) | |_  | |_   / /\  | |_) ( (` / / \ | |_   | |
 * |_|   |_| \ |_|__ |_|   /_/--\ |_|_) _)_) \_\_/ |_|    |_|
 */

@Api(value = "/info", description = "Prefab server info API.")
@Path(value = "/info")
@Produces(MediaType.APPLICATION_JSON)
public class PrefabResource {

    private static final Logger log = LoggerFactory.getLogger(PrefabResource.class);

    private final AtomicLong counter;
    private final ServerInfoConfig serverInfoConfig;

    public PrefabResource(ServerInfoConfig serverInfoConfig) {
        this.counter = new AtomicLong();
        this.serverInfoConfig = serverInfoConfig;
    }

    private ServerInfo getServerInfo(ServerInfoConfig serverInfoConfig){
        return new ServerInfo(serverInfoConfig.getName(), serverInfoConfig.getVersion(), String.format(serverInfoConfig.getDescriptionTemplate(), serverInfoConfig.getName()));
    }

    private ServerInfo getServerInfo(String version){
        //TODO: Fetch from DB
        return new ServerInfo(serverInfoConfig.getName(), version, String.format(serverInfoConfig.getDescriptionTemplate(), serverInfoConfig.getName()));
    }

    @ApiOperation(value = "Get ServerInfo", notes = "Get additional server info", responseClass = "com.prefabsoft.wizard.model.ServerInfo")
    @ApiErrors(value = {
            @ApiError(code = 400, reason = "Invalid version supplied"),
            @ApiError(code = 404, reason = "ServerInfo not found")
    })
    @GET
    @Timed
    public ServerInfo get(){
        log.info("/info hitcount: {}",counter.incrementAndGet());
        return getServerInfo(serverInfoConfig);
    }


    @ApiOperation(value = "Get ServerInfo", notes = "Get additional server info", responseClass = "com.prefabsoft.wizard.model.ServerInfo")
    @ApiErrors(value = {
            @ApiError(code = 400, reason = "Invalid version supplied"),
            @ApiError(code = 404, reason = "ServerInfo not found")
    })
    @GET
    @Path("/{version}")
    @Timed
    public ServerInfo getByVersion(
            @ApiParam(value = "Version of ServerInfo that needs to be fetched", allowableValues = "range[1,5]", required = true)
            @PathParam("version") String version){

        log.info("/info hitcount: {} version PathParam: {}",counter.incrementAndGet(),version);

        return getServerInfo(version);
    }

}/*


@Api(value = "/info", description = "Prefab server info API.")
@Path(value = "/info")
@Produces(MediaType.APPLICATION_JSON)
public class PrefabResource {

    private final String defaultId;
    private final String description;
    private final String template;
    private final AtomicLong counter;

    public PrefabResource(String defaultId, String description, String template) {
        this.counter = new AtomicLong();
        this.description = description;
        this.defaultId = defaultId;
        this.template = template;
    }

    @ApiOperation(value = "Get ServerInfo", notes = "Get additional server info", responseClass = "com.prefabsoft.wizard.model.ServerInfo")
    @ApiErrors(value = {
            @ApiError(code = 400, reason = "Invalid version supplied"),
            @ApiError(code = 404, reason = "ServerInfo not found")
    })
    @GET
    @Path("/{id}")
    @Timed
    public String get(
            @ApiParam(value = "ID of pet that needs to be fetched", allowableValues = "range[1,5]", required = true)
            @PathParam("id") String id){

        System.out.println("id :"+id);

        return counter.incrementAndGet() + " " +
                String.format(template, id*/
/*.or(defaultId)*//*
);
    }

}
*/

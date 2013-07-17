package com.prefabosft.wizard.resource;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * BSD licensed copyright (C) 2013 by jochen @ 7/17/13 3:33 PM.
 * .___   ___   ____  ____   __    ___   __   ___   ____ _____
 * | |_) | |_) | |_  | |_   / /\  | |_) ( (` / / \ | |_   | |
 * |_|   |_| \ |_|__ |_|   /_/--\ |_|_) _)_) \_\_/ |_|    |_|
 */
@Path(value = "/")
@Produces(MediaType.APPLICATION_JSON)
public class PrefabResource {
    private final String template;
    private final String defaultId;
    private final AtomicLong counter;

    public PrefabResource(String template, String defaultId) {
        this.template = template;
        this.defaultId = defaultId;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public String get(@QueryParam("id") Optional<String> id){
        System.out.println("id :"+id);
        return counter.incrementAndGet() + " " +
            String.format(template, id.or(defaultId));
    }

}

package com.prefabosft.wizard.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * BSD licensed copyright (C) 2013 by jochen @ 7/17/13 3:33 PM.
 * .___   ___   ____  ____   __    ___   __   ___   ____ _____
 * | |_) | |_) | |_  | |_   / /\  | |_) ( (` / / \ | |_   | |
 * |_|   |_| \ |_|__ |_|   /_/--\ |_|_) _)_) \_\_/ |_|    |_|
 */
@Path(value = "/{id}")
public class PrefabResource {

    @GET
    public String get(@PathParam("id") String id){
        System.out.println("id :"+id);
        return "Hello, " + id;
    }

}

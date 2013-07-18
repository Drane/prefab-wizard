package com.prefabsoft.wizard.util;

import com.google.common.collect.ImmutableSet;

/**
 * BSD licensed copyright (C) 2013 by jochen @ 7/17/13 3:33 PM.
 * .___   ___   ____  ____   __    ___   __   ___   ____ _____
 * | |_) | |_) | |_  | |_   / /\  | |_) ( (` / / \ | |_   | |
 * |_|   |_| \ |_|__ |_|   /_/--\ |_|_) _)_) \_\_/ |_|    |_|
 */
public class PrefabWizardUtil {

    private static final ImmutableSet<String> EXT_ARRAY = ImmutableSet.of("yml","yaml");
    private static final String CONFIG_URI_STRING = "cfg/prefabCONFIG.yml";
    private static final String BASE_PARAM = "server";

    public static String[] handleDefaultArgs(String[] args) {
        if(args.length==0) args = new String[]{BASE_PARAM, CONFIG_URI_STRING};
        else if(args.length==1) args = new String[]{CONFIG_URI_STRING};

        String ext = args[args.length-1].substring(args[args.length-1].lastIndexOf('.')+1);

        if(!EXT_ARRAY.contains(ext)){
            args[args.length] = CONFIG_URI_STRING;
        }
        return args;
    }
}

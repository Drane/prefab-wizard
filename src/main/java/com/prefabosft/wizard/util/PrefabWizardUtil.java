package com.prefabosft.wizard.util;

import com.google.common.collect.ImmutableSet;

/**
 * BSD licensed copyright (C) 2013 by jochen @ 7/17/13 3:33 PM.
 * .___   ___   ____  ____   __    ___   __   ___   ____ _____
 * | |_) | |_) | |_  | |_   / /\  | |_) ( (` / / \ | |_   | |
 * |_|   |_| \ |_|__ |_|   /_/--\ |_|_) _)_) \_\_/ |_|    |_|
 */
public class PrefabWizardUtil {

    public static final ImmutableSet<String> extArray = ImmutableSet.of(".yml","yaml");
    public static final String configNameString = "prefabCONFIG.yml";

    public static String[] addDefaultArgs(String[] args) {
        if(args.length==0) args = new String[]{"server", configNameString};
        else if(args.length==1) args = new String[]{configNameString};

        if(!extArray.contains(args[args.length-1].substring(args[args.length-1].length()-4))){
            args[args.length] = configNameString;
        }
        return args;
    }
}

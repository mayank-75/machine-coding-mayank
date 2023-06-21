package org.example;

import java.util.Arrays;

public class Main {

    private static final KVService kvService = new KVService() ;

    public static void main(String[] args) {
        kvService.put("sde_bootcamp", Arrays.asList(new Object[]{"title","SDE-Bootcamp"}, new Object[]{"price", 30000.00},
        new Object[]{"enrolled",false}, new Object[]{"estimated_time", 30}));
        System.out.println(kvService.get("sde_bootcamp"));
        System.out.println(kvService.keys());
        kvService.put("sde_kickstart", Arrays.asList(new Object[]{"title", "SDE-Kickstart"}, new Object[]{"price", 4000},
                new Object[]{"enrolled", true}, new Object[]{"estimated_time", 8}));
        System.out.println(kvService.get("sde_kickstart"));
        System.out.println(kvService.keys());
        kvService.put("sde_kickstart", Arrays.asList(new Object[]{"title", "SDE-Kickstart"}, new Object[]{"price", 4000.00}, new Object[]{"enrolled", true},
                new Object[]{"estimated_time", 8}));
        System.out.println(kvService.get("sde_kickstart"));
        System.out.println(kvService.keys());
        kvService.delete("sde_bootcamp");
        System.out.println(kvService.get("sde_bootcamp"));
        System.out.println(kvService.keys());
        kvService.put("sde_bootcamp", Arrays.asList(new Object[]{"title", "SDE-Bootcamp"}, new Object[]{"price", 30000.00},
                new Object[]{"enrolled", true}, new Object[]{"estimated_time", 30}));
        System.out.println(kvService.search("price", 30000.00));
        System.out.println(kvService.search("enrolled", true));

    }
}
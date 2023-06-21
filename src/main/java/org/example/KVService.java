package org.example;

import java.util.*;

public class KVService {
    private final Map<String, Value> kvStore;

    private final Map<String, Class<?>> attributesDataTypeMap;

    public KVService() {
        kvStore = new HashMap<>();
        attributesDataTypeMap = new HashMap<>();
    }

    public String get(String key) {
       if(!kvStore.containsKey(key)) {
           return null;
       }
       return kvStore.get(key).toString();
    }

    public List<String> search(String attributeKey, Object attributeValue) {
        List<String> res = new ArrayList<>();
        kvStore.forEach((k, v) -> v.getVal().forEach((attrKey, attrVal) -> {
            if(attributeKey.equals(attrKey) && attributeValue.equals(attrVal)) {
                res.add(k);
            }
        }));
        return res;
    }

    public void put(String key, List<Object[]> listOfAttributePairs) {
        for (Object[] attributePairs : listOfAttributePairs) {
            String attributeKey = (String) attributePairs[0];
            Object attributeValue = attributePairs[1];
            if (attributesDataTypeMap.containsKey(attributeKey) && !attributeValue.getClass().equals(attributesDataTypeMap.get(attributeKey))) {
                System.out.println("Data type error");
                return;
            }
        }

        for (Object[] attributePairs : listOfAttributePairs) {
            String attributeKey = (String) attributePairs[0];
            Object attributeValue = attributePairs[1];
            kvStore.computeIfAbsent(key, k -> new Value()).getVal().put(attributeKey, attributeValue);
            attributesDataTypeMap.put(attributeKey, attributeValue.getClass());
        }
    }

    public void delete(String key) {
        kvStore.remove(key);
    }

    public Set<String> keys() {
        return kvStore.keySet();
    }
}

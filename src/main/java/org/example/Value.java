package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Value {

    public Map<String, Object> getVal() {
        return val;
    }

    private Map<String, Object> val;

    public Value() {
        val = new HashMap<>();
    }

    @Override
    public String toString() {
       List<String> res = new ArrayList<>();
       val.forEach((k, v) -> res.add(k + ": " + v));
       return String.join(", ", res);
    }
}

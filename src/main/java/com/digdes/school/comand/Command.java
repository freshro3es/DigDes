package com.digdes.school.comand;

import java.util.List;
import java.util.Map;

public interface Command {
    List<Map<String, Object>> evaluate(List<Map<String, Object>> table) throws Exception;
}

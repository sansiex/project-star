package com.star.people.mapper;

import java.util.List;
import java.util.Map;

public interface sqlMapper {
    List<Map> selectBySql(String sql);

}
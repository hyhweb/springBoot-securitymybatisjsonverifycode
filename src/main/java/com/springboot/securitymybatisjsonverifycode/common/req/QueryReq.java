package com.springboot.securitymybatisjsonverifycode.common.req;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

public class QueryReq {
private Integer page;
private Integer pageSize;
private Integer starRow;
private Map parameter = new HashMap();

public Integer getPage() {
return page != null ? page : 1;
}

public void setPage(Integer page) {
this.page = page;
}

public Integer getPageSize() {
return pageSize != null ? pageSize : 10;
}

public void setPageSize(Integer pageSize) {
this.pageSize = pageSize;
}

public Map getParameter() {
return parameter;
}

public void setParameter(Map parameter) {
this.parameter = parameter;
}

public static QueryReq initParameter(Map parameter) {
QueryReq queryReq = new QueryReq();
queryReq.setParameter(parameter);
return queryReq;
}

public Integer getStarRow() {
return starRow;
}

public void setStarRow(Integer starRow) {
this.starRow = starRow;
}

@JsonIgnore
public Integer getStartRow() {return (getPage() - 1) * getPageSize();}
@Override
public String toString() {
return JSON.toJSONString(this);
}
}

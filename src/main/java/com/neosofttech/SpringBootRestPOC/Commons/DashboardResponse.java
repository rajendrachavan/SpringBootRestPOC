package com.neosofttech.SpringBootRestPOC.Commons;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DashboardResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    @JsonProperty("status_code")
    private String statusCode;

    @Setter
    @Getter
    @JsonProperty("error_code")
    private String errorCode;

    @Setter
    @Getter
    @JsonProperty("error_msg")
    private String errorMsg;

    @JsonProperty("response_data")
    private ResponseData responseData;

    public void setResponseData(String name, Object value) {
        if(responseData == null)
            responseData = new ResponseData();
        this.responseData.setValue(name, value);
    }

    public Map<String, Object> getResponseData(String name) {
        return this.responseData.getValue();
    }

    class ResponseData {

        @JsonIgnore
        private Map<String, Object> value = new LinkedHashMap<>();

        @JsonAnyGetter
        public Map<String, Object> getValue() {
            return this.value;
        }

        @JsonAnyGetter
        public void setValue(String name, Object value) {
            this.value.put(name, value);
        }
    }
}

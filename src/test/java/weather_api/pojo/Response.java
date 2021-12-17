
package weather_api.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request",
    "location",
    "current"
})

public class Response {

    @JsonProperty("request")
    private RespRequest respRequest;
    @JsonProperty("location")
    private RespLocation respLocation;
    @JsonProperty("current")
    private RespCurrent respCurrent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("request")
    public RespRequest getRequest() {
        return respRequest;
    }

    @JsonProperty("request")
    public void setRequest(RespRequest respRequest) {
        this.respRequest = respRequest;
    }

    @JsonProperty("location")
    public RespLocation getLocation() {
        return respLocation;
    }

    @JsonProperty("location")
    public void setLocation(RespLocation respLocation) {
        this.respLocation = respLocation;
    }

    @JsonProperty("current")
    public RespCurrent getCurrent() {
        return respCurrent;
    }

    @JsonProperty("current")
    public void setCurrent(RespCurrent respCurrent) {
        this.respCurrent = respCurrent;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

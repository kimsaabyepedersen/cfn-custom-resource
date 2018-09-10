package org.saabye_pedersen.cfn;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class CfnRequest {

    @JsonProperty("ServiceToken")
    private String serviceToken;

    @JsonProperty("RequestType")
    private RequestType requestType;

    @JsonProperty("ResponseURL")
    private String responseURL;

    @JsonProperty("StackId")
    private String stackId;

    @JsonProperty("RequestId")
    private String requestId;

    @JsonProperty("ResourceType")
    private String resourceType;

    @JsonProperty("LogicalResourceId")
    private String logicalResourceId;

    @JsonProperty("PhysicalResourceId")
    private String physicalResourceId;

    @JsonProperty("ResourceProperties")
    private JsonNode resourceProperties;

    @JsonProperty("OldResourceProperties")
    private JsonNode oldResourceProperties;

}

package org.saabye_pedersen.cfn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class CfnResponse {

    @JsonProperty("Status")
    private Status status;

    @JsonProperty("Reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String reason;

    @JsonProperty("StackId")
    private String stackId;

    @JsonProperty("RequestId")
    private String requestId;

    @JsonProperty("LogicalResourceId")
    private String logicalResourceId;

    @JsonProperty("PhysicalResourceId")
    private String physicalResourceId;

    static CfnResponse fromCfnRequest(CfnRequest cfnRequest, String arnOfResource) {
        CfnResponse cfnResponse = new CfnResponse();
        cfnResponse.setLogicalResourceId(cfnRequest.getLogicalResourceId());
        cfnResponse.setStackId(cfnRequest.getStackId());
        cfnResponse.setRequestId(cfnRequest.getRequestId());

        if (arnOfResource != null) {
            cfnResponse.setStatus(Status.SUCCESS);
            cfnResponse.setPhysicalResourceId(arnOfResource);
        } else {
            cfnResponse.setStatus(Status.FAILED);
            cfnResponse.setReason("Some Reason");
        }

        return cfnResponse;
    }

}

package org.saabye_pedersen.cfn;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import java.io.InputStream;
import java.io.OutputStream;


/**
 * Handler for requests to Lambda function.
 */
public class CustomResourceFunctionHandler implements RequestStreamHandler {

    @Override
    public void handleRequest(final InputStream inputStream, final OutputStream outputStream, final Context context) {
        CfnRequest cfnRequest = JacksonHelper.getInputFromStream(inputStream);

        System.out.println(JacksonHelper.mapToString(cfnRequest));

        switch (cfnRequest.getRequestType()) {
            case Create:
                break;
            case Delete:
                break;
            case Update:
                break;
        }

        String output = JacksonHelper.mapToString(CfnResponse.fromCfnRequest(cfnRequest, "Demo ARN"));

        System.out.println("Writing to bucket:" + cfnRequest.getResponseURL());
        System.out.println(output);

        new HttpClient().put(output, cfnRequest.getResponseURL());
    }

}

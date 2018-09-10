# AWS CloudFormation 
Demo of CloudFormation [Custom Resources](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-custom-resources.html).

The code does not create an actual resource, but it responds to CloudFormation as though it had.

It logs a lot to CloudWatch so you can see the payloads from CloudFormation and what is sent to the S3 bucket (as a reply to CloudFormation).

## Prerequisites
* [SAM CLI](https://github.com/awslabs/serverless-application-model) installed.
* Java 8 or higher.
* A recent Maven version.

## How to run
First create an S3 bucket with some name. Then edit `package-and-deploy.sh.tmp` and replace <BUCKET_NAME> with that name.
Then rename  `package-and-deploy.sh.tmp` to `package-and-deploy.sh` and run `sh package-and-deploy.sh`


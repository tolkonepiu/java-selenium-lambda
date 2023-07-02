# java-selenium-lambda

This is minimum demo of headless chrome, java and selenium on container image on AWS Lambda

## Running the demo

```bash
$ npm install -g serverless # skip this line if you have already installed Serverless Framework
$ export AWS_REGION=ap-northeast-1 # You can specify region or skip this line. us-east-1 will be used by default.
$ sls create --template-url "https://github.com/tolkonepiu/java-selenium-lambda/tree/main" --path java-selenium-lambda && cd $_
$ sls deploy
$ sls invoke --function demo # Yay! You will get texts of example.com
```

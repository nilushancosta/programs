import ballerina/http;
import ballerina/log;

service /srvc on new http:Listener(8080) {
    resource function get success() returns string|error {
        log:printInfo("Request received at /success endpoint");
        return "Successful";
    }

    resource function get failure() returns error? {
        log:printInfo("Request received at /failure endpoint");
        return error("Error");
    }

    resource function get divide() returns int {
        return 5/0;
    }

    resource function get context() returns string|error {
        log:printInfo("info log", id = 845315, name = "foo", successful = true);
        return "Successful";
    }
}


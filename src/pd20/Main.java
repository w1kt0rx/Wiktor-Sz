package pd20;

import pd20.dto.UserReport;
import pd20.service.ApiGateway;
import pd20.util.JsonFileWriter;

public class Main {

    public static void main(String[] args) {

        ApiGateway apiGateway = new ApiGateway();

        UserReport report = apiGateway.getUserReport(1L);

        JsonFileWriter.save(report, "user-report.json");

        System.out.println("Raport zapisany.");
    }
}
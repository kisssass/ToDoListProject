package ru.kissass.ToDoListProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kissass.ToDoListProject.service.ReportServiceImpl;

@SpringBootTest
public class ReportServiceTest
{
    private final ReportServiceImpl reportService;

    @Autowired
    public ReportServiceTest(ReportServiceImpl reportService) {
        this.reportService = reportService;
    }

    @Test
    void testCreateReport()
    {
        Long id = reportService.createReport();
    }

    @Test
    void testGenerateReport()
    {
        reportService.generateReport(1052L);

    }
}
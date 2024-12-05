package ru.kissass.ToDoListProject.service;

/*@Service
public class ReportServiceImpl
{
    private final ReportRepository reportRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public ReportServiceImpl(ReportRepository reportRepository, TaskRepository taskRepository, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public ReportEntity getReport(Long id)
    {
        return reportRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Report not found, id =" + id)) ;
    }

    public Long createReport()
    {
        ReportEntity report = new ReportEntity();
        report.setStatus(ReportStatus.CREATED);
        reportRepository.save(report);
        return report.getId();
    }

    public CompletableFuture<ReportEntity> generateReport(Long id) {
        CompletableFuture<ReportEntity> future = CompletableFuture.supplyAsync(() -> {
            long timeGenerateStart = System.currentTimeMillis();
            ReportEntity report = getReport(id);
            List<TodoItem> tasks = (List<TodoItem>) taskRepository.findAll();


            Thread t1 = new Thread(() -> {
                long timeStart = System.currentTimeMillis();
                String content = tasks.stream().map(TodoItem::getName).
                        collect(Collectors.joining("\n"));
                report.setContent(content);
                report.setTimeToCountTask(System.currentTimeMillis() - timeStart);
            });


            Thread t2 = new Thread(() -> {
                long timeStart = System.currentTimeMillis();
                Long countUser = userRepository.count();
                report.setCountUsers(countUser);
                report.setTimeToCountUser(System.currentTimeMillis() - timeStart);

            });

            t2.start();
            t1.start();

            try {
                t1.join();
                t2.join();
                report.setTimeToCreatedReport(System.currentTimeMillis() - timeGenerateStart);
                report.setStatus(ReportStatus.COMPLETED);
            } catch (InterruptedException e) {
                report.setStatus(ReportStatus.ERROR);
                throw new RuntimeException(e);
            } finally {
                //upReport(report);
                reportRepository.save(report);
            }
            return report;
        });
        return future;
    }

}*/
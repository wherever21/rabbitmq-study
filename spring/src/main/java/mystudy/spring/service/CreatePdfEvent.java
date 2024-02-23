package mystudy.spring.service;

public class CreatePdfEvent {
    private final String fileName;
    private final long fileSize;

    private final String fileUrl;

    public CreatePdfEvent(String fileName, long fileSize, String fileUrl) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getFileUrl() {
        return fileUrl;
    }
}

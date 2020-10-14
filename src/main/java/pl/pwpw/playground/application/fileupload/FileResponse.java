package pl.pwpw.playground.application.fileupload;

public class FileResponse {
    private String type;
    private String uri;
    private String uploadDate;
    private long size;

    public FileResponse(String type, String uri, String uploadDate, long size) {
        this.type = type;
        this.uri = uri;
        this.uploadDate = uploadDate;
        this.size = size;
    }
}

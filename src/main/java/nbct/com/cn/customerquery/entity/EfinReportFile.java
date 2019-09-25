package nbct.com.cn.customerquery.entity;

public class EfinReportFile {
  private String fileName;

  private byte[] fileData;

  public byte[] getFileData() {
    return fileData;
  }

  public void setFileData(byte[] fileData) {
    this.fileData = fileData;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

}
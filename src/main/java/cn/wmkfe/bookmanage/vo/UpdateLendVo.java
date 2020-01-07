package cn.wmkfe.bookmanage.vo;

public class UpdateLendVo {
    private Integer bookId;
    private String readerId;
    private Boolean whetherLend;
    private String borrowId;
    private Integer lendNumber;

    @Override
    public String toString() {
        return "UpdateLendVo{" +
                "bookId=" + bookId +
                ", readerId='" + readerId + '\'' +
                ", whetherLend=" + whetherLend +
                ", borrowId='" + borrowId + '\'' +
                ", lendNumber=" + lendNumber +
                '}';
    }

    public Integer getLendNumber() {
        return lendNumber;
    }

    public void setLendNumber(Integer lendNumber) {
        this.lendNumber = lendNumber;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public Boolean getWhetherLend() {
        return whetherLend;
    }

    public void setWhetherLend(Boolean whetherLend) {
        this.whetherLend = whetherLend;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}

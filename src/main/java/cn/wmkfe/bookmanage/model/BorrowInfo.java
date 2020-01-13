package cn.wmkfe.bookmanage.model;

import java.math.BigDecimal;
import java.util.Date;

public class BorrowInfo {
    private String borrowId;

    private Date lendTime;

    private Date giveBackTime;

    private String readerId;

    private Integer bookId;

    private Boolean beOverdue;

    private BigDecimal fine;

    private String beOverdueDay;

    private Boolean whetherLend;

    private Book book;

    private Reader reader;

    @Override
    public String toString() {
        return "BorrowInfo{" +
                "borrowId='" + borrowId + '\'' +
                ", lendTime=" + lendTime +
                ", giveBackTime=" + giveBackTime +
                ", readerId='" + readerId + '\'' +
                ", bookId=" + bookId +
                ", beOverdue=" + beOverdue +
                ", fine=" + fine +
                ", beOverdueDay='" + beOverdueDay + '\'' +
                ", whetherLend=" + whetherLend +
                ", book=" + book +
                ", reader=" + reader +
                '}';
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public Date getLendTime() {
        return lendTime;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    public Date getGiveBackTime() {
        return giveBackTime;
    }

    public void setGiveBackTime(Date giveBackTime) {
        this.giveBackTime = giveBackTime;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Boolean getBeOverdue() {
        return beOverdue;
    }

    public void setBeOverdue(Boolean beOverdue) {
        this.beOverdue = beOverdue;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    public String getBeOverdueDay() {
        return beOverdueDay;
    }

    public void setBeOverdueDay(String beOverdueDay) {
        this.beOverdueDay = beOverdueDay;
    }

    public Boolean getWhetherLend() {
        return whetherLend;
    }

    public void setWhetherLend(Boolean whetherLend) {
        this.whetherLend = whetherLend;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
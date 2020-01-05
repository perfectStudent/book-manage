package cn.wmkfe.bookmanage.model;

import java.math.BigDecimal;

public class Book {
    private Integer bookId;

    private String bookName;

    private String author;

    private Integer type;

    private BigDecimal price;

    private String press;

    private Integer number;

    private String isbn;

    private String cover;

    private String describe;

    private Integer lendNumber;

    public Integer getLendNumber() {
        return lendNumber;
    }

    public void setLendNumber(Integer lendNumber) {
        this.lendNumber = lendNumber;
    }

    private Type typeModel;


    public Type getTypeModel() {
        return typeModel;
    }

    public void setTypeModel(Type typeModel) {
        this.typeModel = typeModel;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }
}
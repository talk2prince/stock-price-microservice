package com.techwithprince.stock.dbservices.model;

import javax.persistence.*;

@Entity
@Table(name = "quotes",catalog = "test")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "quote")
    private String quote;

    public Quote() {

    }
    public Quote(String userName, String quote) {
        this.username = userName;
        this.quote = quote;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}

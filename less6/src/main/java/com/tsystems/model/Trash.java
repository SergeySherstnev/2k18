package com.tsystems.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name="trash")
public class Trash {
    @Column(name="userid")
    //@ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="userid")
    private long id;

    @Id
    @Column(name="count")
    private int count;

    @Column(name="date")
    private Date date;

    @Column(name="price")
    private int price;

    public Trash(Long id, int count, Date date, int price) {
        this.id = id;
        this.count = count;
        this.date = date;
        this.price = price;
    }

}

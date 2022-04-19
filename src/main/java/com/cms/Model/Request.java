package com.cms.Model;


import jakarta.persistence.*;
import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer requestId;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Employee.class)
    @JoinColumn(name = "id")
    private Employee emp;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = BookingDetails.class)
    @JoinColumn(name = "bookingId")
    private BookingDetails bookingId;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = BookingStatus.class)
    @JoinColumn(name = "bId")
    private BookingStatus bId;

    /**
     * @param emp
     * @param bId
     */
    public Request (Employee emp, BookingStatus bId) {
        this.emp = emp;
        this.bId = bId;
        this.bookingId = null;
    }

    /**
     * @param emp
     * @param bookingId
     * @param bId
     */
    public Request (Employee emp, BookingDetails bookingId, BookingStatus bId) {
        this.emp = emp;
        this.bookingId = bookingId;
        this.bId = bId;
    }

    public Request () {
    }

    public Integer getRequestId () {
        return requestId;
    }

    public Employee getEmp () {
        return emp;
    }

    public BookingDetails getBookingId () {
        return bookingId;
    }

    public BookingStatus getbId () {
        return bId;
    }

    public void setRequestId (Integer requestId) {
        this.requestId = requestId;
    }

    public void setEmp (Employee emp) {
        this.emp = emp;
    }

    public void setBookingId (BookingDetails bookingId) {
        this.bookingId = bookingId;
    }

    public void setbId (BookingStatus bId) {
        this.bId = bId;
    }


}

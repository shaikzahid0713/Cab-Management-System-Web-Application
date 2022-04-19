package com.cms.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.Table;

import java.util.Objects;


@Entity
@Table(name = "bDetails")
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer bookingId;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Cab.class)
    @JoinColumn(name = "cabNo")
    private Cab cabNo;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Employee.class)
    @JoinColumn(name = "id")
    private Employee emp;



    public BookingDetails (Cab cabNo, Employee emp) {
        this.cabNo = cabNo;
        this.emp = emp;
    }

    public BookingDetails () {
    }

    @Override
    public int hashCode () {
        return Objects.hash(bookingId);
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BookingDetails other = (BookingDetails) obj;
        return Objects.equals(bookingId, other.bookingId);
    }

    public Integer getBookingId () {
        return bookingId;
    }

    public Cab getCabNo () {
        return cabNo;
    }

    public Employee getEmplpoyeeId () {
        return emp;
    }

    public void setBookingId (Integer bookingId) {
        this.bookingId = bookingId;
    }

    public void setCabNo (Cab cabNo) {
        this.cabNo = cabNo;
    }

    public void setEmplpoyeeId (Employee emp) {
        this.emp = emp;
    }


}
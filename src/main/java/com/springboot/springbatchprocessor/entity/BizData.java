package com.springboot.springbatchprocessor.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class BizData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 1400)
    private String companyName;
    @Column(length = 700)
    private String website;
    @Column(length = 700)
    private String technologyType;
    @Column(length = 700)
    private String technologyUsed;
    @Column(length = 700)
    private String bookingEngine;
    @Column(length = 700)
    private String industry;
    @Column(length = 700)
    private String businessSolution;
    @Column(length = 700)
    private String employeeSize;
    @Column(length = 700)
    private String employeeRange;
    @Column(length = 700)
    private String address_1;
    @Column(length = 700)
    private String address_2;
    @Column(length = 700)
    private String country;
    @Column(length = 700)
    private String state;
    @Column(length = 700)
    private String city;
    @Column(length = 700)
    private String subscription;
    @Column(length = 700)
    private String firstName;
    @Column(length = 700)
    private String lastName;
    @Column(length = 700)
    private String linkedIn_URL;
    @Column(length = 700)
    private String email_Id;
    @Column(length = 700)
    private String jobTitle;
    @Column(length = 700)
    private String contact_Number;
    @Column(length = 700)
    private String direct_Number;
    @Column(length = 700)
    private String personCountry;
    @Column(length = 700)
    private String personState;
    @Column(length = 700)
    private String personCity;
    @Column(length = 700)
    private String revenue;
    @Column(length = 700)
    private String jobURL;
    @Column(length = 700)
    private String jobOpening;
    @Column(length = 700)
    private String numberOfRooms;
    @Column(length = 700)
    private String starRatings;
    @Column(length = 700)
    private String reviewRatings;
    @Column(length = 700)
    private String pMS;
    @Column(length = 700)
    private String hotelName;
    @Column(length = 700)
    private String hotelType;
    @Column(length = 700)
    private String pOW;
    @Column(length = 700)
    private String assesmentTool;
    @Column(length = 700)
    private String foundedYear;
    @Column(length = 700)
    private String comment;
    @Column(length = 700)
    private String modifiedOn;
    @Column(length = 700)
    private String technology;
    @Column(length = 700)
    private String zipCode;
    @Column(length = 700)
    private String gender;
    @Column(length = 700)
    private String actual_Revenue;
    @Column(length = 700)
    private String revenue_Range;
    @Column(length = 700)
    private String public_Profile;
    @Column(length = 700)
    private String countryCode;
    @Column(length = 700)
    private String updateLocationStatus;
}

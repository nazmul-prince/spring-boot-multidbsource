package com.db.multiplesources.db2source.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "banks", schema = "public")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BanksEntity {
    @Id
    @SequenceGenerator(name="banks_id_seq_gen",sequenceName="banks_id_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="banks_id_seq_gen")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "bank_code")
    private String bankCode;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "website")
    private String website;
    
//    @Column(name = "transaction_status")
//    private Boolean transactionStatus;
//
//    @Column(name = "is_active")
//    private Boolean isActive;
//
//    @Column(name = "is_archieved")
//    private Boolean isArchived;
    
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;
    
    @Column(name = "deleted_at")
    private Date deletedAt;
    
}

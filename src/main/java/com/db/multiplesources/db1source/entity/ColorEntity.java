package com.db.multiplesources.db1source.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "colors", schema = "beza_service")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ColorEntity {
    @Id
    @SequenceGenerator(name = "colors_id_seq_gen", sequenceName = "colors_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "colors_id_seq_gen")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}

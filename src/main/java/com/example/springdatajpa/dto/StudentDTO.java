package com.example.springdatajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "studentDTO")
@Data
public class StudentDTO {


    private Integer studentId;

    private String name;
    private String surname;

}

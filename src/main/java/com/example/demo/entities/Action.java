package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@DynamicUpdate
@Table(schema = "fip", name = "action")
@Getter
@Setter
@ToString
public class Action {

    @Id
    @Column(name = "id")
    private Integer idAction;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Column(name = "date")
    private LocalDateTime dateCreation;
    @Column(name = "label")
    private String labelAction;
    @Type(type = "json")
    @Column(name = "uploads", columnDefinition = "json"/*, updatable = false*/)
    private List<Upload> uploads;

}

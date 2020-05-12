package com.example.demo.entities;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.MappedSuperclass;

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class)
})
@MappedSuperclass
@Getter
@Setter
@ToString
public class Upload {

    private String fileName;
    private String fileType;
    private Long fileSize;

}

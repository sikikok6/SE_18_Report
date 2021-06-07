package com.example.demo.Dao;
import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@EqualsAndHashCode
public class ApplyID implements Serializable {
    private String Openid;
    private int Seq;
}

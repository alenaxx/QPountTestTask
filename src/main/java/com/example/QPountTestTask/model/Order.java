package com.example.QPountTestTask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    @NotBlank
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private Long userId;
    private String serviceName;
    private String targetUrl;
    private float price;

   @ManyToOne
   @JoinColumn(name = "userId", nullable = false)
   @OnDelete(action = OnDeleteAction.CASCADE)
   @JsonIgnore
    private User user;

}

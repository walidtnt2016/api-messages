package com.walid.messages.apimessages.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class DossierClient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String nomClient ;
    @Column
    private LocalDateTime dateOuverture;

    @Column
    private String reference ;
    @Column
    @OneToMany
    private List<Message> messages;


}

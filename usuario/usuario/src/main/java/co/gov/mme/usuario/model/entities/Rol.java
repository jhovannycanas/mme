package co.gov.mme.usuario.model.entities;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_rol", schema = "usuario")
public class Rol extends AbstractEntity{

    @Column(name = "nombre")
    private String nombre;
}

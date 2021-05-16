package co.gov.mme.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_emprendimiento", schema = "emprendimiento")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Builder
public class Emprendimiento extends AbstractEntity {

    @Column(name = "id_cliente")
    private Integer usuario;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "fechacreacion")
    private Date fechaCreacion;

    @Column(name = "usuariocreacion")
    private String usuarioCreacion;
}

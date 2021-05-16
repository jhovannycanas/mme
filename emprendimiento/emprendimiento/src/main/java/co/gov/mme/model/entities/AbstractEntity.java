package co.gov.mme.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@Access(AccessType.FIELD)
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fechamodificacion")
    private Date fechaModificacion;

    @Column(name = "usuariomodificacion")
    private String usuarioModificacion;
}

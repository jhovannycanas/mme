package co.gov.mme.usuario.model.entities;


import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "tbl_usuario_rol", schema = "usuario")
public class UsuarioRol extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    private Rol rol;

    @Column(name = "estado")
    private Boolean estado;
}

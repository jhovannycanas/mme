package co.gov.mme.usuario.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "tbl_usuario", schema = "usuario")
public class Usuario extends AbstractEntity {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "documento")
    private String documento;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "fechacreacion")
    private Date fechaCreacion;

    @Column(name = "usuariocreacion")
    private String usuarioCreacion;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
    // private Set<UsuarioRol> usuarioRols = new HashSet<>();
    private Set<UsuarioRol> usuarioRols;

    public void addRol(UsuarioRol usuarioRol) {
        if (this.usuarioRols == null ) {
            this.usuarioRols = new HashSet<>();
        }
        this.usuarioRols.add(usuarioRol);
        usuarioRol.setUsuario(this);
    }
}

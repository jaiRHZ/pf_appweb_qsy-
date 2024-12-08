package dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import web.blogdominio.domain.Usuario;

@lombok.Data
@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class UsuarioDto implements Serializable {

    private Long id;
    private String nombreCompleto;
    private String correo;
    private String telefono;
    private String ciudad;
    private String fechaNacimiento;
    private String genero;

    public static UsuarioDto createUsuarioDto(Usuario usuario) {
        return new UsuarioDto().builder().ciudad(usuario.getCiudad()).
                correo(usuario.getCorreo()).
                fechaNacimiento(usuario.getFechaNacimiento().toString())
                .nombreCompleto(usuario.getNombreCompleto()).
                genero(usuario.getGenero().toString()).
                telefono(usuario.getTelefono()).
                id(usuario.getId()).
                build();
    }

}

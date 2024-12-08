package dto;

import java.io.Serializable;
import java.util.ArrayList;
import web.blogdominio.domain.Comentario;
import java.util.List;

@lombok.Data
@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class ComentarioDto implements Serializable{

    private Long id;
    private String nombreUsuario;
    private String publicacionComun;
    private String contenido;
    private String fechaHora;

    public static ComentarioDto createComentarioDto(Comentario comentario) {
       
        return new ComentarioDto().builder().nombreUsuario(comentario.getUsuarioNormal().getNombreCompleto())
                .publicacionComun(comentario.getPublicacionComun().getTitulo())
                .contenido(comentario.getContenido())
                .fechaHora(comentario.getFechaHora().toString())
                .id(comentario.getId())
                .build();
    }

    // No mover
    public static List<ComentarioDto> createComentarioDto(List<Comentario> comentarios) {
        List<ComentarioDto> comentarioDtos = new ArrayList<>();
        for (Comentario comentario : comentarios) {
            comentarioDtos.add(createComentarioDto(comentario));
        }

        return comentarioDtos;
    }

}
